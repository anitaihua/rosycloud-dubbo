package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.enums.IdType;
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
public class Forums extends Model<Forums> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "forum_id", type = IdType.AUTO)
    private Long forumId;
    private String forumName;
    private String forumDescription;
    private String forumLogo;
    private Long forumPostCount;
    private Long parentForumId;


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

    public String getForumDescription() {
        return forumDescription;
    }

    public void setForumDescription(String forumDescription) {
        this.forumDescription = forumDescription;
    }

    public String getForumLogo() {
        return forumLogo;
    }

    public void setForumLogo(String forumLogo) {
        this.forumLogo = forumLogo;
    }

    public Long getForumPostCount() {
        return forumPostCount;
    }

    public void setForumPostCount(Long forumPostCount) {
        this.forumPostCount = forumPostCount;
    }

    public Long getParentForumId() {
        return parentForumId;
    }

    public void setParentForumId(Long parentForumId) {
        this.parentForumId = parentForumId;
    }

    @Override
    protected Serializable pkVal() {
        return this.forumId;
    }

    @Override
    public String toString() {
        return "Forums{" +
        ", forumId=" + forumId +
        ", forumName=" + forumName +
        ", forumDescription=" + forumDescription +
        ", forumLogo=" + forumLogo +
        ", forumPostCount=" + forumPostCount +
        ", parentForumId=" + parentForumId +
        "}";
    }
}
