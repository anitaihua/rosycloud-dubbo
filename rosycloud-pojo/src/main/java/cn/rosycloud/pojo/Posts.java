package cn.rosycloud.pojo;

import java.io.Serializable;
import java.util.Date;

public class Posts implements Serializable {
    private Long postId;

    private Long forumId;

    private Long userId;

    private Long postViews;

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

    public Long getPostViews() {
        return postViews;
    }

    public void setPostViews(Long postViews) {
        this.postViews = postViews;
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
        this.postStatus = postStatus == null ? null : postStatus.trim();
    }

    public Long getPostCommentCount() {
        return postCommentCount;
    }

    public void setPostCommentCount(Long postCommentCount) {
        this.postCommentCount = postCommentCount;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "postId=" + postId +
                ", forumId=" + forumId +
                ", userId=" + userId +
                ", postViews=" + postViews +
                ", postDate=" + postDate +
                ", postStatus='" + postStatus + '\'' +
                ", postCommentCount=" + postCommentCount +
                '}';
    }
}