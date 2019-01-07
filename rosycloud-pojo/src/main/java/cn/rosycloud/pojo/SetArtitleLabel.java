package cn.rosycloud.pojo;

import java.io.Serializable;

public class SetArtitleLabel implements Serializable {
    private Long articleId;

    private Long labelId;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toString() {
        return "SetArtitleLabel{" +
                "articleId=" + articleId +
                ", labelId=" + labelId +
                '}';
    }
}