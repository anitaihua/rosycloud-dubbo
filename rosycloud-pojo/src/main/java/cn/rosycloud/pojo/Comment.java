package cn.rosycloud.pojo;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@TableName("t_comment")
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论ID
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 博文ID
     */
    private Long articleId;
    /**
     * 点赞数
     */
    private Long commentLikeCount;
    /**
     * 评论日期
     */
    private Date commentDate;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 父评论ID
     */
    private Long parentCommentId;
    /**
     * 评论状态（0:正常,1:禁用）
     */
    private Integer commontStatus;
    /**
     * 删除标识（0:未删除,1:已删除）
     */
    private Integer df;


    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getCommentLikeCount() {
        return commentLikeCount;
    }

    public void setCommentLikeCount(Long commentLikeCount) {
        this.commentLikeCount = commentLikeCount;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public Integer getCommontStatus() {
        return commontStatus;
    }

    public void setCommontStatus(Integer commontStatus) {
        this.commontStatus = commontStatus;
    }

    public Integer getDf() {
        return df;
    }

    public void setDf(Integer df) {
        this.df = df;
    }

    @Override
    protected Serializable pkVal() {
        return this.commentId;
    }

    @Override
    public String toString() {
        return "Comment{" +
        ", commentId=" + commentId +
        ", userId=" + userId +
        ", articleId=" + articleId +
        ", commentLikeCount=" + commentLikeCount +
        ", commentDate=" + commentDate +
        ", commentContent=" + commentContent +
        ", parentCommentId=" + parentCommentId +
        ", commontStatus=" + commontStatus +
        ", df=" + df +
        "}";
    }
}
