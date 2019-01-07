package cn.rosycloud.pojo;

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
public class Sorts extends Model<Sorts> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sort_id", type = IdType.AUTO)
    private Long sortId;
    private String sortName;
    private String sortAlias;
    private String sortDescription;
    private Long parentSortId;


    public Long getSortId() {
        return sortId;
    }

    public void setSortId(Long sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortAlias() {
        return sortAlias;
    }

    public void setSortAlias(String sortAlias) {
        this.sortAlias = sortAlias;
    }

    public String getSortDescription() {
        return sortDescription;
    }

    public void setSortDescription(String sortDescription) {
        this.sortDescription = sortDescription;
    }

    public Long getParentSortId() {
        return parentSortId;
    }

    public void setParentSortId(Long parentSortId) {
        this.parentSortId = parentSortId;
    }

    @Override
    protected Serializable pkVal() {
        return this.sortId;
    }

    @Override
    public String toString() {
        return "Sorts{" +
        ", sortId=" + sortId +
        ", sortName=" + sortName +
        ", sortAlias=" + sortAlias +
        ", sortDescription=" + sortDescription +
        ", parentSortId=" + parentSortId +
        "}";
    }
}
