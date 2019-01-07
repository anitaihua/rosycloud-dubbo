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
public class VQueryUserPostedPosts extends Model<VQueryUserPostedPosts> {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String userName;
    private Long postId;
    private String postTitle;
    private String postContent;
    private Long forumId;
    private String forumName;


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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "VQueryUserPostedPosts{" +
        ", userId=" + userId +
        ", userName=" + userName +
        ", postId=" + postId +
        ", postTitle=" + postTitle +
        ", postContent=" + postContent +
        ", forumId=" + forumId +
        ", forumName=" + forumName +
        "}";
    }
}
