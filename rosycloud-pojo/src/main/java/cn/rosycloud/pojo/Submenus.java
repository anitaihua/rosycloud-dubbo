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
public class Submenus extends Model<Submenus> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "link_id", type = IdType.AUTO)
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
        this.linkName = linkName;
    }

    public String getLinkTarget() {
        return linkTarget;
    }

    public void setLinkTarget(String linkTarget) {
        this.linkTarget = linkTarget;
    }

    public String getLinkOpenWay() {
        return linkOpenWay;
    }

    public void setLinkOpenWay(String linkOpenWay) {
        this.linkOpenWay = linkOpenWay;
    }

    public Long getParentLinkId() {
        return parentLinkId;
    }

    public void setParentLinkId(Long parentLinkId) {
        this.parentLinkId = parentLinkId;
    }

    @Override
    protected Serializable pkVal() {
        return this.linkId;
    }

    @Override
    public String toString() {
        return "Submenus{" +
        ", linkId=" + linkId +
        ", menuId=" + menuId +
        ", linkName=" + linkName +
        ", linkTarget=" + linkTarget +
        ", linkOpenWay=" + linkOpenWay +
        ", parentLinkId=" + parentLinkId +
        "}";
    }
}
