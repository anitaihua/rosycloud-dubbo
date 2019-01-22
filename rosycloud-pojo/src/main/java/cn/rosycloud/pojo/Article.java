package cn.rosycloud.pojo;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 博文表
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@TableName("t_article")
public class Article extends Model<Article> {

    private static final long serialVersionUID = 1L;

    /**
     * 博文ID
     */
    @TableId(value = "article_id", type = IdType.AUTO)
    private Long articleId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 博文标题
     */
    private String articleTitle;
    /**
     * 博文封面
     */
    private String articleCover;
    /**
     * 博文浏览数
     */
    private Long articleViews;
    /**
     * 发表日期
     */
    private Date articleDate;
    /**
     * 喜欢数
     */
    private Long articleLikeCount;
    /**
     * 评论总数
     */
    private Long articleCommentCount;
    /**
     * 是否公开（0:公开,1:私密）
     */
    private Integer open;
    /**
     * 删除标识（0:未删除,1:已删除）
     */
    private Integer df;


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

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleCover() {
        return articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    public Long getArticleViews() {
        return articleViews;
    }

    public void setArticleViews(Long articleViews) {
        this.articleViews = articleViews;
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

    public Long getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Long articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public Integer getDf() {
        return df;
    }

    public void setDf(Integer df) {
        this.df = df;
    }

    @Override
    protected Serializable pkVal() {
        return this.articleId;
    }

    @Override
    public String toString() {
        return "Article{" +
        ", articleId=" + articleId +
        ", userId=" + userId +
        ", articleTitle=" + articleTitle +
        ", articleCover=" + articleCover +
        ", articleViews=" + articleViews +
        ", articleDate=" + articleDate +
        ", articleLikeCount=" + articleLikeCount +
        ", articleCommentCount=" + articleCommentCount +
        ", open=" + open +
        ", df=" + df +
        "}";
    }
}
