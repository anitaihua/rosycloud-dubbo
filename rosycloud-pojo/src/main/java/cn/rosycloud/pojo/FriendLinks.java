package cn.rosycloud.pojo;

import java.io.Serializable;

public class FriendLinks implements Serializable {
    private Long friendLinkId;

    private String friendLinks;

    private String friendLinkName;

    private String friendLinkLogo;

    private String friendLinkDescription;

    public Long getFriendLinkId() {
        return friendLinkId;
    }

    public void setFriendLinkId(Long friendLinkId) {
        this.friendLinkId = friendLinkId;
    }

    public String getFriendLinks() {
        return friendLinks;
    }

    public void setFriendLinks(String friendLinks) {
        this.friendLinks = friendLinks == null ? null : friendLinks.trim();
    }

    public String getFriendLinkName() {
        return friendLinkName;
    }

    public void setFriendLinkName(String friendLinkName) {
        this.friendLinkName = friendLinkName == null ? null : friendLinkName.trim();
    }

    public String getFriendLinkLogo() {
        return friendLinkLogo;
    }

    public void setFriendLinkLogo(String friendLinkLogo) {
        this.friendLinkLogo = friendLinkLogo == null ? null : friendLinkLogo.trim();
    }

    public String getFriendLinkDescription() {
        return friendLinkDescription;
    }

    public void setFriendLinkDescription(String friendLinkDescription) {
        this.friendLinkDescription = friendLinkDescription == null ? null : friendLinkDescription.trim();
    }

    @Override
    public String toString() {
        return "FriendLinks{" +
                "friendLinkId=" + friendLinkId +
                ", friendLinks='" + friendLinks + '\'' +
                ", friendLinkName='" + friendLinkName + '\'' +
                ", friendLinkLogo='" + friendLinkLogo + '\'' +
                ", friendLinkDescription='" + friendLinkDescription + '\'' +
                '}';
    }
}