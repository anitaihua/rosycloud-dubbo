package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-07
 */
public class VQueryAllUsersFriends extends Model<VQueryAllUsersFriends> {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String userName;
    private Long userFriendsId;
    private String userNote;


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

    public Long getUserFriendsId() {
        return userFriendsId;
    }

    public void setUserFriendsId(Long userFriendsId) {
        this.userFriendsId = userFriendsId;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "VQueryAllUsersFriends{" +
        ", userId=" + userId +
        ", userName=" + userName +
        ", userFriendsId=" + userFriendsId +
        ", userNote=" + userNote +
        "}";
    }
}
