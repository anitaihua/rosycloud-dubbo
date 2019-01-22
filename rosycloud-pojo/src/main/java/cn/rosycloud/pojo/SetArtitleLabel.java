package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 文章设置标签表
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@TableName("t_set_artitle_label")
public class SetArtitleLabel extends Model<SetArtitleLabel> {

    private static final long serialVersionUID = 1L;

    /**
     * 文章设置标签ID
     */
    @TableId(value = "set_artitle_label_id", type = IdType.AUTO)
    private Long setArtitleLabelId;
    /**
     * 博文ID
     */
    private Long articleId;
    /**
     * 标签ID
     */
    private Long labelId;


    public Long getSetArtitleLabelId() {
        return setArtitleLabelId;
    }

    public void setSetArtitleLabelId(Long setArtitleLabelId) {
        this.setArtitleLabelId = setArtitleLabelId;
    }

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
    protected Serializable pkVal() {
        return this.setArtitleLabelId;
    }

    @Override
    public String toString() {
        return "SetArtitleLabel{" +
        ", setArtitleLabelId=" + setArtitleLabelId +
        ", articleId=" + articleId +
        ", labelId=" + labelId +
        "}";
    }
}
