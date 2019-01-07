package cn.rosycloud.pojo;

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
public class SetArtitleSort extends Model<SetArtitleSort> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "article_id", type = IdType.AUTO)
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
    protected Serializable pkVal() {
        return this.articleId;
    }

    @Override
    public String toString() {
        return "SetArtitleSort{" +
        ", articleId=" + articleId +
        ", sortId=" + sortId +
        "}";
    }
}
