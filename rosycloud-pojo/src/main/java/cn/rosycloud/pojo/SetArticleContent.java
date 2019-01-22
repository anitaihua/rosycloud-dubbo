package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 博文设置正文表
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@TableName("t_set_article_content")
public class SetArticleContent extends Model<SetArticleContent> {

    private static final long serialVersionUID = 1L;

    /**
     * 正文ID
     */
    @TableId(value = "content_id", type = IdType.AUTO)
    private Long contentId;
    /**
     * 博文ID
     */
    private Long articleId;
    /**
     * 正文类型
     */
    private Long typeId;
    /**
     * 正文图片路径
     */
    private String contentUrl;
    /**
     * 正文内容
     */
    private String contentText;


    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    @Override
    protected Serializable pkVal() {
        return this.contentId;
    }

    @Override
    public String toString() {
        return "SetArticleContent{" +
        ", contentId=" + contentId +
        ", articleId=" + articleId +
        ", typeId=" + typeId +
        ", contentUrl=" + contentUrl +
        ", contentText=" + contentText +
        "}";
    }
}
