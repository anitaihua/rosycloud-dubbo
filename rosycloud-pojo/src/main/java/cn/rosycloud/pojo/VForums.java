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
public class VForums extends Model<VForums> {

    private static final long serialVersionUID = 1L;

    private Long forumId;
    private String forumName;
    private Long postId;
    private String postTitle;


    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "VForums{" +
        ", forumId=" + forumId +
        ", forumName=" + forumName +
        ", postId=" + postId +
        ", postTitle=" + postTitle +
        "}";
    }
}
