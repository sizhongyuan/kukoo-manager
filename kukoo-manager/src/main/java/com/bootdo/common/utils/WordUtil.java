package com.bootdo.common.utils;

import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class WordUtil {

    private static final Logger logger = LoggerFactory.getLogger(WordUtil.class);
    //附件文件保存路径
    @Value("${files.path}")
    private String filePath;

    //word2007转html
    public void word2007ToHtml() throws Exception {
        String filepath = "/Users/sizhongyuan/Downloads/";
        String sourceFileName =filepath+"4G无线综合网管四期需求分析说明书-现场巡检数据更新审批流程与OMC账号集约管控流程_20180723.docx";
        String targetFileName = filepath+"123456.html";
        String imagePathStr = filepath+"/image/";
        OutputStreamWriter outputStreamWriter = null;
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(sourceFileName));
            XHTMLOptions options = XHTMLOptions.create();
            // 存放图片的文件夹
            options.setExtractor(new FileImageExtractor(new File(imagePathStr)));
            // html中图片的路径
            options.URIResolver(new BasicURIResolver("image"));
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetFileName), "utf-8");
            XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
            xhtmlConverter.convert(document, outputStreamWriter, options);
        } finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        }
    }

    public static void main(String[] args){
        WordUtil aa = new WordUtil();
        try {
            aa.word2007ToHtml();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
