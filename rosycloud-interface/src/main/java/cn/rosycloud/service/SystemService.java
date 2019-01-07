package cn.rosycloud.service;

public interface SystemService {

    /**
     * 日志添加
     * @param LogContent 内容
     * @param loglevel 级别
     * @param operatetype 类型
     */
     void addLog(String LogContent,Short operatetype, Short loglevel);
}
