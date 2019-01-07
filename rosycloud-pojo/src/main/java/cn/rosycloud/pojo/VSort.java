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
public class VSort extends Model<VSort> {

    private static final long serialVersionUID = 1L;

    private Long sortId;
    private String sortName;
    private Long articleId;
    private String articleTitle;


    public Long getSortId() {
        return sortId;
    }

    public void setSortId(Long sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "VSort{" +
        ", sortId=" + sortId +
        ", sortName=" + sortName +
        ", articleId=" + articleId +
        ", articleTitle=" + articleTitle +
        "}";
    }
}
