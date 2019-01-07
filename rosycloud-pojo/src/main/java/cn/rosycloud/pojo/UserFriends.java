package cn.rosycloud.pojo;

import java.io.Serializable;

public class UserFriends implements Serializable {
    private Long id;

    private Long userId;

    private Long userFriendsId;

    private String userNote;

    private String userStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        this.userNote = userNote == null ? null : userNote.trim();
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    @Override
    public String toString() {
        return "UserFriends{" +
                "id=" + id +
                ", userId=" + userId +
                ", userFriendsId=" + userFriendsId +
                ", userNote='" + userNote + '\'' +
                ", userStatus='" + userStatus + '\'' +
                '}';
    }
}