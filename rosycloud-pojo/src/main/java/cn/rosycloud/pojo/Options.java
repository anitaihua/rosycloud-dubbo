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
public class Options extends Model<Options> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "option_id", type = IdType.AUTO)
    private Integer optionId;
    private String optionName;
    private String optionValues;


    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionValues() {
        return optionValues;
    }

    public void setOptionValues(String optionValues) {
        this.optionValues = optionValues;
    }

    @Override
    protected Serializable pkVal() {
        return this.optionId;
    }

    @Override
    public String toString() {
        return "Options{" +
        ", optionId=" + optionId +
        ", optionName=" + optionName +
        ", optionValues=" + optionValues +
        "}";
    }
}
