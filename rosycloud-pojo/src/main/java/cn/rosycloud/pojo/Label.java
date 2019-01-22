package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 标签表
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@TableName("t_label")
public class Label extends Model<Label> {

    private static final long serialVersionUID = 1L;

    /**
     * 标签ID
     */
    @TableId(value = "label_id", type = IdType.AUTO)
    private Long labelId;
    /**
     * 标签名称
     */
    private String labelName;
    /**
     * 标签别名
     */
    private String labelAlias;
    /**
     * 标签描述
     */
    private String labelDescription;


    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelAlias() {
        return labelAlias;
    }

    public void setLabelAlias(String labelAlias) {
        this.labelAlias = labelAlias;
    }

    public String getLabelDescription() {
        return labelDescription;
    }

    public void setLabelDescription(String labelDescription) {
        this.labelDescription = labelDescription;
    }

    @Override
    protected Serializable pkVal() {
        return this.labelId;
    }

    @Override
    public String toString() {
        return "Label{" +
        ", labelId=" + labelId +
        ", labelName=" + labelName +
        ", labelAlias=" + labelAlias +
        ", labelDescription=" + labelDescription +
        "}";
    }
}
