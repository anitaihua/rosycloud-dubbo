package cn.rosycloud.service;

import cn.rosycloud.pojo.Log;

import java.io.File;

public interface SystemService {

    /**
     * 日志添加
     * @param log
     */
    void addLog(Log log);

    /**
     * 日志添加
     * @param log
     * @param userName 用户名
     */
    void addLog(Log log,String userName);

    /**
     *  上传文件
     * @param file
     * @param filename
     * @return fileId上传文件路径
     */
    String uploadFile(File file,String filename);

    /**
     *  上传文件
     * @param file
     * @return fileId上传文件路径
     */
    String uploadFile(File file);

    /**
     *  删除文件服务器文件
     * @param fileId 上传文件路径
     * @return
     */
    boolean deleteFile(String fileId);
}
