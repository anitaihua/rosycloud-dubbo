package cn.rosycloud.pojo;

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
public class Users extends Model<Users> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    private String userIp;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userProfilePhoto;
    private String userLevel;
    private String userRights;
    private Date userRegistrationTime;
    private Date userBirthday;
    private Integer userAge;
    private Integer userTelephoneNumber;
    private String userNickname;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserProfilePhoto() {
        return userProfilePhoto;
    }

    public void setUserProfilePhoto(String userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserRights() {
        return userRights;
    }

    public void setUserRights(String userRights) {
        this.userRights = userRights;
    }

    public Date getUserRegistrationTime() {
        return userRegistrationTime;
    }

    public void setUserRegistrationTime(Date userRegistrationTime) {
        this.userRegistrationTime = userRegistrationTime;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserTelephoneNumber() {
        return userTelephoneNumber;
    }

    public void setUserTelephoneNumber(Integer userTelephoneNumber) {
        this.userTelephoneNumber = userTelephoneNumber;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "Users{" +
        ", userId=" + userId +
        ", userIp=" + userIp +
        ", userName=" + userName +
        ", userPassword=" + userPassword +
        ", userEmail=" + userEmail +
        ", userProfilePhoto=" + userProfilePhoto +
        ", userLevel=" + userLevel +
        ", userRights=" + userRights +
        ", userRegistrationTime=" + userRegistrationTime +
        ", userBirthday=" + userBirthday +
        ", userAge=" + userAge +
        ", userTelephoneNumber=" + userTelephoneNumber +
        ", userNickname=" + userNickname +
        "}";
    }
}
