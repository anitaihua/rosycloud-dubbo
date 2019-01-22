package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 文章设置分类表
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@TableName("t_set_artitle_sort")
public class SetArtitleSort extends Model<SetArtitleSort> {

    private static final long serialVersionUID = 1L;

    /**
     * 文章设置分类ID
     */
    @TableId(value = "set_artitle_sort_id", type = IdType.AUTO)
    private Long setArtitleSortId;
    /**
     * 博文ID
     */
    private Long articleId;
    /**
     * 分类ID
     */
    private Long sortId;


    public Long getSetArtitleSortId() {
        return setArtitleSortId;
    }

    public void setSetArtitleSortId(Long setArtitleSortId) {
        this.setArtitleSortId = setArtitleSortId;
    }

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
        return this.setArtitleSortId;
    }

    @Override
    public String toString() {
        return "SetArtitleSort{" +
        ", setArtitleSortId=" + setArtitleSortId +
        ", articleId=" + articleId +
        ", sortId=" + sortId +
        "}";
    }
}
