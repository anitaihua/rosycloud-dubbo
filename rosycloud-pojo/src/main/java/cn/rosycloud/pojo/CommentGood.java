package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 评论点赞表
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@TableName("t_comment_good")
public class CommentGood extends Model<CommentGood> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论点赞ID
     */
    @TableId(value = "good_id", type = IdType.AUTO)
    private Long goodId;
    /**
     * 评论ID
     */
    private Long commentId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 点赞状态（0:未点赞,1:已点赞）
     */
    private Integer status;


    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.goodId;
    }

    @Override
    public String toString() {
        return "CommentGood{" +
        ", goodId=" + goodId +
        ", commentId=" + commentId +
        ", userId=" + userId +
        ", status=" + status +
        "}";
    }
}
