package cn.rosycloud.pojo;

import java.io.Serializable;

public class Submenus implements Serializable {
    private Long linkId;

    private Long menuId;

    private String linkName;

    private String linkTarget;

    private String linkOpenWay;

    private Long parentLinkId;

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLinkTarget() {
        return linkTarget;
    }

    public void setLinkTarget(String linkTarget) {
        this.linkTarget = linkTarget == null ? null : linkTarget.trim();
    }

    public String getLinkOpenWay() {
        return linkOpenWay;
    }

    public void setLinkOpenWay(String linkOpenWay) {
        this.linkOpenWay = linkOpenWay == null ? null : linkOpenWay.trim();
    }

    public Long getParentLinkId() {
        return parentLinkId;
    }

    public void setParentLinkId(Long parentLinkId) {
        this.parentLinkId = parentLinkId;
    }

    @Override
    public String toString() {
        return "Submenus{" +
                "linkId=" + linkId +
                ", menuId=" + menuId +
                ", linkName='" + linkName + '\'' +
                ", linkTarget='" + linkTarget + '\'' +
                ", linkOpenWay='" + linkOpenWay + '\'' +
                ", parentLinkId=" + parentLinkId +
                '}';
    }
}