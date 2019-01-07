package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
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
public class Comments extends Model<Comments> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;
    private Long userId;
    private Long articleId;
    private Long commentLikeCount;
    private Date commentDate;
    private String commentContent;
    private Long parentCommentId;


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

    @Override
    protected Serializable pkVal() {
        return this.commentId;
    }

    @Override
    public String toString() {
        return "Comments{" +
        ", commentId=" + commentId +
        ", userId=" + userId +
        ", articleId=" + articleId +
        ", commentLikeCount=" + commentLikeCount +
        ", commentDate=" + commentDate +
        ", commentContent=" + commentContent +
        ", parentCommentId=" + parentCommentId +
        "}";
    }
}
