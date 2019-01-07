package cn.rosycloud.pojo;

import java.io.Serializable;
import java.util.Date;

public class Floors implements Serializable {
    private Long floorId;

    private Long userId;

    private Long postId;

    private Date floorDate;

    private Long parentFloorId;

    private String floorContent;

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

    public String getFloorContent() {
        return floorContent;
    }

    public void setFloorContent(String floorContent) {
        this.floorContent = floorContent == null ? null : floorContent.trim();
    }

    @Override
    public String toString() {
        return "Floors{" +
                "floorId=" + floorId +
                ", userId=" + userId +
                ", postId=" + postId +
                ", floorDate=" + floorDate +
                ", parentFloorId=" + parentFloorId +
                ", floorContent='" + floorContent + '\'' +
                '}';
    }
}