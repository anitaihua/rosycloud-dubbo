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
public class Labels extends Model<Labels> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "label_id", type = IdType.AUTO)
    private Long labelId;
    private String labelName;
    private String labelAlias;
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
        return "Labels{" +
        ", labelId=" + labelId +
        ", labelName=" + labelName +
        ", labelAlias=" + labelAlias +
        ", labelDescription=" + labelDescription +
        "}";
    }
}
