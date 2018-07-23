package com.bootdo.accessories.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件管理模块对象
 *
 * @author szy
 * @date 2018-05-09 20:26:14
 */
public class AccessoriesDO implements Serializable {
    /**
     * 文件id,唯一标识
     * */
    private String id;
    /**
     * 文件编号,时间戳
     * */
    private String fileName;
    /**
     * 文件真实名称
     * */
    private String fileCnName;
    /**
     * 文件相对路径
     * */
    private String fileRelPath;
    /**
     * 文件上传人
     * */
    private String fileUserId;
    /**
     * 文件上传时间
     * */
    private Date createTime;
    /**
     * 删除标识，默认为0，删除为1
     * 目前觉得没用
     * */
    private String deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileCnName() {
        return fileCnName;
    }

    public void setFileCnName(String fileCnName) {
        this.fileCnName = fileCnName;
    }

    public String getFileRelPath() {
        return fileRelPath;
    }

    public void setFileRelPath(String fileRelPath) {
        this.fileRelPath = fileRelPath;
    }

    public String getFileUserId() {
        return fileUserId;
    }

    public void setFileUserId(String fileUserId) {
        this.fileUserId = fileUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
