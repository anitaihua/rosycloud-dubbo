package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.enums.IdType;
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
public class FriendLinks extends Model<FriendLinks> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "friend_link_id", type = IdType.AUTO)
    private Long friendLinkId;
    private String friendLinks;
    private String friendLinkName;
    private String friendLinkDescription;
    private String friendLinkLogo;


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
        this.friendLinks = friendLinks;
    }

    public String getFriendLinkName() {
        return friendLinkName;
    }

    public void setFriendLinkName(String friendLinkName) {
        this.friendLinkName = friendLinkName;
    }

    public String getFriendLinkDescription() {
        return friendLinkDescription;
    }

    public void setFriendLinkDescription(String friendLinkDescription) {
        this.friendLinkDescription = friendLinkDescription;
    }

    public String getFriendLinkLogo() {
        return friendLinkLogo;
    }

    public void setFriendLinkLogo(String friendLinkLogo) {
        this.friendLinkLogo = friendLinkLogo;
    }

    @Override
    protected Serializable pkVal() {
        return this.friendLinkId;
    }

    @Override
    public String toString() {
        return "FriendLinks{" +
        ", friendLinkId=" + friendLinkId +
        ", friendLinks=" + friendLinks +
        ", friendLinkName=" + friendLinkName +
        ", friendLinkDescription=" + friendLinkDescription +
        ", friendLinkLogo=" + friendLinkLogo +
        "}";
    }
}
