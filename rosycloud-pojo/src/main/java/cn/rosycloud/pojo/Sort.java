package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@TableName("t_sort")
public class Sort extends Model<Sort> {

    private static final long serialVersionUID = 1L;

    /**
     * 分类ID
     */
    @TableId(value = "sort_id", type = IdType.AUTO)
    private Long sortId;
    /**
     * 分类名称
     */
    private String sortName;
    /**
     * 分类别名
     */
    private String sortAlias;
    /**
     * 分类描述
     */
    private String sortDescription;
    /**
     * 父分类ID
     */
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
        return "Sort{" +
        ", sortId=" + sortId +
        ", sortName=" + sortName +
        ", sortAlias=" + sortAlias +
        ", sortDescription=" + sortDescription +
        ", parentSortId=" + parentSortId +
        "}";
    }
}
