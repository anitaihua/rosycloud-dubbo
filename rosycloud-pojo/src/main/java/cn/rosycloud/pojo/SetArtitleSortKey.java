package cn.rosycloud.pojo;

import java.io.Serializable;

public class SetArtitleSortKey implements Serializable {
    private Long articleId;

    private Long sortId;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getSortId() {
        return sortId;
    }

    public void setSortId(Long sortId) {
        this.sortId = sortId;
    }

    @Override
    public String toString() {
        return "SetArtitleSortKey{" +
                "articleId=" + articleId +
                ", sortId=" + sortId +
                '}';
    }
}