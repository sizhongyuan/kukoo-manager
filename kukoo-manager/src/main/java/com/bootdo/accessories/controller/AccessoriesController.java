package com.bootdo.accessories.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.accessories.domain.AccessoriesDO;
import com.bootdo.accessories.service.AccessoriesService;
import com.bootdo.common.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 文件管理模块
 *
 * @author szy
 * @date 2018-05-13 21:08:35
 */
@Controller
@RequestMapping("/accessories")
public class AccessoriesController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AccessoriesController.class);
    @Value("${files.path}")
    private String filePath;

    @Autowired
    private AccessoriesService accessoriesService;

    //多文件上传
    @RequestMapping(value = { "uploadFilesMethod" }, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadFilesMethod(HttpServletRequest request) throws Exception {
        JSONObject object = new JSONObject();
        Map<String,MultipartFile> filesMap =((MultipartHttpServletRequest) request).getFileMap();
        //获取模块需要保存的文件夹名，为空则存在根路径下
        String appCode = request.getParameter("appCode");
        logger.info("上传的文件路径：" + filePath+appCode);
        if( filesMap != null && filesMap.size() > 0 ){
            JSONArray array = new JSONArray();
            for(Map.Entry<String,MultipartFile> entry : filesMap.entrySet() ){

                //key 为input[type="file"] 的name值
                String key = entry.getKey();
                MultipartFile file = entry.getValue();
                // 获取文件名
                String fileName = file.getOriginalFilename();
                logger.info("上传的文件名为：" + fileName);
                // 获取文件的后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                logger.info("上传的后缀名为：" + suffixName);
                //保存文件
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                String dateStr = format.format(date);
                File dest = new File(filePath+appCode+"/"+dateStr+suffixName);
                // 检测是否存在目录
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    //保存文件对象到服务器
                    file.transferTo(dest);
                    //保存文件对象到数据库

                    AccessoriesDO accessoriesDO = new AccessoriesDO();
                    accessoriesDO.setCreateTime(date);
                    accessoriesDO.setDeleted("0");
                    accessoriesDO.setFileCnName(fileName);
                    accessoriesDO.setFileName(dateStr+suffixName);//时间戳加后缀名
                    accessoriesDO.setFileRelPath(appCode);
                    accessoriesDO.setFileUserId(this.getUserId().toString());//好不爽啊这么写
                    accessoriesService.save(accessoriesDO);
                    JSONObject accJson = new JSONObject();
                    accJson.put("inputName",key);//input[type="file"] 的name值
                    accJson.put("fileName",fileName);//文件名
                    accJson.put("saveName",dateStr+suffixName);//时间戳名，用于关联保存
                    array.add(accJson);
                }catch (Exception e) {
                    object.put("status","400");
                    object.put("error","附件上传失败");
                    e.printStackTrace();
                }
            }
            object.put("status","201");
            object.put("data",array);
        }else{
            logger.info("没有获取到上传文件");
            object.put("status","400");
            object.put("error","没有获取到上传文件");
        }
        return object;
    }


    //文件下载
    @RequestMapping(value = { "downLoadFilesMethod" }, method = RequestMethod.GET)
    @ResponseBody
    public void downLoadFilesMethod(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //文件时间戳名字
        String fileName = request.getParameter("fileName");

        AccessoriesDO accessoriesDO = accessoriesService.getByFileName(fileName);
        if(accessoriesDO != null){
            String path = filePath+accessoriesDO.getFileRelPath();
            File file = new File(path, fileName);
            if(file.exists()){

                response.setContentType("application/force-download");// 设置强制下载不打开
                boolean isMSIE = this.isMSBrowser(request);
                String fileCnName =accessoriesDO.getFileCnName();
                if (isMSIE) {
                    //IE浏览器的乱码问题解决
                    fileCnName = URLEncoder.encode(fileCnName, "UTF-8");
                } else {
                    //万能乱码问题解决
                    fileCnName = new String(fileCnName.getBytes("UTF-8"), "ISO-8859-1");
                }
                response.addHeader("Content-Disposition",
                        "attachment;fileName=\"" +  fileCnName+"\"");// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    logger.info("文件"+fileName+"下载成功");
                } catch (Exception e) {
                    logger.info("文件"+fileName+"下载失败");
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }else{
            logger.info("文件"+fileName+"不存在,请检查");
        }
    }

    //判断是不是ie浏览器
    public boolean isMSBrowser(HttpServletRequest request) {
        String[] IEBrowserSignals = {"MSIE", "Trident", "Edge"};
        String userAgent = request.getHeader("User-Agent");
        for (String signal : IEBrowserSignals) {
            if (userAgent.contains(signal))
                return true;
        }
        return false;
    }
}
