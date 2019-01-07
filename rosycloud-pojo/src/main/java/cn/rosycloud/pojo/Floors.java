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
public class Floors extends Model<Floors> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "floor_id", type = IdType.AUTO)
    private Long floorId;
    private Long userId;
    private Long postId;
    private String floorContent;
    private Date floorDate;
    private Long parentFloorId;


    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getFloorContent() {
        return floorContent;
    }

    public void setFloorContent(String floorContent) {
        this.floorContent = floorContent;
    }

    public Date getFloorDate() {
        return floorDate;
    }

    public void setFloorDate(Date floorDate) {
        this.floorDate = floorDate;
    }

    public Long getParentFloorId() {
        return parentFloorId;
    }

    public void setParentFloorId(Long parentFloorId) {
        this.parentFloorId = parentFloorId;
    }

    @Override
    protected Serializable pkVal() {
        return this.floorId;
    }

    @Override
    public String toString() {
        return "Floors{" +
        ", floorId=" + floorId +
        ", userId=" + userId +
        ", postId=" + postId +
        ", floorContent=" + floorContent +
        ", floorDate=" + floorDate +
        ", parentFloorId=" + parentFloorId +
        "}";
    }
}
