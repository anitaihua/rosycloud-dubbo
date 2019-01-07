package cn.rosycloud.pojo;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    private Long logId;

    private String broswer;

    private Short logLevel;

    private Date operateTime;

    private Short operateType;

    private Long userId;

    private String userName;

    private String realName;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getBroswer() {
        return broswer;
    }

    public void setBroswer(String broswer) {
        this.broswer = broswer == null ? null : broswer.trim();
    }

    public Short getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(Short logLevel) {
        this.logLevel = logLevel;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Short getOperateType() {
        return operateType;
    }

    public void setOperateType(Short operateType) {
        this.operateType = operateType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", broswer='" + broswer + '\'' +
                ", logLevel=" + logLevel +
                ", operateTime=" + operateTime +
                ", operateType=" + operateType +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}