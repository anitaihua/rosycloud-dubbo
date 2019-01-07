package cn.rosycloud.config;

/**
 * 常量
 */
public class Constants {

    /**
     * 存储当前登录用户id的字段名
     */
    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";

    /**
     * token有效期（小时）
     */
    public static final int TOKEN_EXPIRES_HOUR = 72;

    /**  存放Token的header字段  (@author yangdaihua) */

    public static final String DEFAULT_TOKEN_NAME = "X-Token";


    /**
     * 人员类型
     */
    public static final Short User_Normal=1;//正常
    public static final Short User_Forbidden=0;//禁用
    public static final Short User_ADMIN=-1;//超级管理员

    /**
     * 用户类型：1、系统类型用户
     */
    public static final String USER_TYPE_SYSTEM = "1";
    /**
     * 用户类型：2、接口类型用户
     *
     */
    public static final String USER_TYPE_INTERFACE = "2";


    /**
     * 逻辑删除标记
     */
    /**
     * 删除
     */
    public static final Short Delete_Forbidden=1;
    /**
     * 正常
     */
    public static final Short Delete_Normal=0;

    /**
     *日志级别定义
     */
    public static final Short Log_Leavel_INFO=1;
    public static final Short Log_Leavel_WARRING=2;
    public static final Short Log_Leavel_ERROR=3;
    /**
     * 日志类型
     */
    public static final Short Log_Type_LOGIN=1; //登陆
    public static final Short Log_Type_EXIT=2;  //退出
    public static final Short Log_Type_INSERT=3; //插入
    public static final Short Log_Type_DEL=4; //删除
    public static final Short Log_Type_UPDATE=5; //更新
    public static final Short Log_Type_UPLOAD=6; //上传
    public static final Short Log_Type_OTHER=7; //其他


}
