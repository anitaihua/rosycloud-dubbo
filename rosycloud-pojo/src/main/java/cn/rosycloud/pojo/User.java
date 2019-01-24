package cn.rosycloud.pojo;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    /**
     * 用户IP
     */
    private String ip;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户头像
     */
    private String profilePhoto;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 背景图
     */
    private String backgroundPhoto;
    /**
     * 用户等级
     */
    private String level;
    /**
     * 用户权限
     */
    private String rights;
    /**
     * 注册时间
     */
    private Date registrationTime;
    /**
     * 用户生日
     */
    private Date birthday;
    /**
     * 用户年龄
     */
    private Integer age;
    /**
     * 用户手机号
     */
    private Long telephoneNumber;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户真实姓名
     */
    private String realName;
    /**
     * 用户状态（0:正常,1:禁用）
     */
    private Integer status;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBackgroundPhoto() {
        return backgroundPhoto;
    }

    public void setBackgroundPhoto(String backgroundPhoto) {
        this.backgroundPhoto = backgroundPhoto;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "User{" +
        ", userId=" + userId +
        ", ip=" + ip +
        ", userName=" + userName +
        ", password=" + password +
        ", email=" + email +
        ", profilePhoto=" + profilePhoto +
        ", introduction=" + introduction +
        ", backgroundPhoto=" + backgroundPhoto +
        ", level=" + level +
        ", rights=" + rights +
        ", registrationTime=" + registrationTime +
        ", birthday=" + birthday +
        ", age=" + age +
        ", telephoneNumber=" + telephoneNumber +
        ", nickName=" + nickName +
        ", realName=" + realName +
        ", status=" + status +
        "}";
    }
}
