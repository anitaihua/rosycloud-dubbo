package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-07
 */
public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;
    /**
     * 浏览器
     */
    private String broswer;
    /**
     * 日志内容
     */
    private String logContent;
    /**
     * 日志级别
     */
    private Integer logLevel;
    /**
     * IP
     */
    private String note;
    /**
     * 操作时间
     */
    private Date operateTime;
    /**
     * 操作类型
     */
    private Integer operateType;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户账号
     */
    private String userName;
    /**
     * 真实名字
     */
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
        this.broswer = broswer;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public Integer getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(Integer logLevel) {
        this.logLevel = logLevel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
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
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    protected Serializable pkVal() {
        return this.logId;
    }

    @Override
    public String toString() {
        return "SysLog{" +
        ", logId=" + logId +
        ", broswer=" + broswer +
        ", logContent=" + logContent +
        ", logLevel=" + logLevel +
        ", note=" + note +
        ", operateTime=" + operateTime +
        ", operateType=" + operateType +
        ", userId=" + userId +
        ", userName=" + userName +
        ", realName=" + realName +
        "}";
    }
}
