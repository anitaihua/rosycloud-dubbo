package cn.rosycloud.pojo;

import java.io.Serializable;
import java.util.Date;

public class Comments implements Serializable {
    private Long commentId;

    private Long userId;

    private Long articleId;

    private Long commentLikeCount;

    private Date commentDate;

    private Long parentCommentId;

    private String commentContent;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getCommentLikeCount() {
        return commentLikeCount;
    }

    public void setCommentLikeCount(Long commentLikeCount) {
        this.commentLikeCount = commentLikeCount;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", articleId=" + articleId +
                ", commentLikeCount=" + commentLikeCount +
                ", commentDate=" + commentDate +
                ", parentCommentId=" + parentCommentId +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}