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
public class Posts extends Model<Posts> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "post_id", type = IdType.AUTO)
    private Long postId;
    private Long forumId;
    private Long userId;
    private String postTitle;
    private Long postViews;
    private String postContent;
    private Date postDate;
    private String postStatus;
    private Long postCommentCount;


    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Long getPostViews() {
        return postViews;
    }

    public void setPostViews(Long postViews) {
        this.postViews = postViews;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public Long getPostCommentCount() {
        return postCommentCount;
    }

    public void setPostCommentCount(Long postCommentCount) {
        this.postCommentCount = postCommentCount;
    }

    @Override
    protected Serializable pkVal() {
        return this.postId;
    }

    @Override
    public String toString() {
        return "Posts{" +
        ", postId=" + postId +
        ", forumId=" + forumId +
        ", userId=" + userId +
        ", postTitle=" + postTitle +
        ", postViews=" + postViews +
        ", postContent=" + postContent +
        ", postDate=" + postDate +
        ", postStatus=" + postStatus +
        ", postCommentCount=" + postCommentCount +
        "}";
    }
}
