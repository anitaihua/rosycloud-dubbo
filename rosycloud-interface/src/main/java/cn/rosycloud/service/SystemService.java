package cn.rosycloud.service;

import cn.rosycloud.pojo.Log;

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
}
