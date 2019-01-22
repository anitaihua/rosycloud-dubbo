package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 关注表
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@TableName("t_concern")
public class Concern extends Model<Concern> {

    private static final long serialVersionUID = 1L;

    /**
     * 关注ID
     */
    @TableId(value = "concern_id", type = IdType.AUTO)
    private Long concernId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 关注用户ID
     */
    private Long focusUser;
    /**
     * 状态（0:正常,1:禁用）
     */
    private Integer status;


    public Long getConcernId() {
        return concernId;
    }

    public void setConcernId(Long concernId) {
        this.concernId = concernId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFocusUser() {
        return focusUser;
    }

    public void setFocusUser(Long focusUser) {
        this.focusUser = focusUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.concernId;
    }

    @Override
    public String toString() {
        return "Concern{" +
        ", concernId=" + concernId +
        ", userId=" + userId +
        ", focusUser=" + focusUser +
        ", status=" + status +
        "}";
    }
}
