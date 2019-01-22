package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 博文用户喜欢表
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@TableName("t_article_user_like")
public class ArticleUserLike extends Model<ArticleUserLike> {

    private static final long serialVersionUID = 1L;

    /**
     * 博文用户喜欢ID
     */
    @TableId(value = "like_id", type = IdType.AUTO)
    private Long likeId;
    /**
     * 博文ID
     */
    private Long articleId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 状态（0:正常,1:禁用）
     */
    private Integer status;


    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.likeId;
    }

    @Override
    public String toString() {
        return "ArticleUserLike{" +
        ", likeId=" + likeId +
        ", articleId=" + articleId +
        ", userId=" + userId +
        ", status=" + status +
        "}";
    }
}
