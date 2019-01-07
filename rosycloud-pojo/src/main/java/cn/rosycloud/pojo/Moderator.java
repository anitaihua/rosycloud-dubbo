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
public class Moderator extends Model<Moderator> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "moderator_id", type = IdType.AUTO)
    private Long moderatorId;
    private Long forumId;
    private String moderatorLevel;


    public Long getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(Long moderatorId) {
        this.moderatorId = moderatorId;
    }

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    public String getModeratorLevel() {
        return moderatorLevel;
    }

    public void setModeratorLevel(String moderatorLevel) {
        this.moderatorLevel = moderatorLevel;
    }

    @Override
    protected Serializable pkVal() {
        return this.moderatorId;
    }

    @Override
    public String toString() {
        return "Moderator{" +
        ", moderatorId=" + moderatorId +
        ", forumId=" + forumId +
        ", moderatorLevel=" + moderatorLevel +
        "}";
    }
}
