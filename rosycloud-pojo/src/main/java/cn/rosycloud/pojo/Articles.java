package cn.rosycloud.pojo;

import java.io.Serializable;

import java.util.Date;

public class Articles implements Serializable{
    private Long articleId;

    private Long userId;

    private Long articleViews;

    private Long articleCommentCount;

    private Date articleDate;

    private Long articleLikeCount;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleViews() {
        return articleViews;
    }

    public void setArticleViews(Long articleViews) {
        this.articleViews = articleViews;
    }

    public Long getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Long articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public Long getArticleLikeCount() {
        return articleLikeCount;
    }

    public void setArticleLikeCount(Long articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "articleId=" + articleId +
                ", userId=" + userId +
                ", articleViews=" + articleViews +
                ", articleCommentCount=" + articleCommentCount +
                ", articleDate=" + articleDate +
                ", articleLikeCount=" + articleLikeCount +
                '}';
    }
}