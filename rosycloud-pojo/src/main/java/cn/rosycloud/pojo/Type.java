package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 类型表
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@TableName("t_type")
public class Type extends Model<Type> {

    private static final long serialVersionUID = 1L;

    /**
     * 类型ID
     */
    @TableId(value = "type_id", type = IdType.AUTO)
    private Long typeId;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 类型别名
     */
    private String typeAlias;
    /**
     * 类型描述
     */
    private String typeDescription;


    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeAlias() {
        return typeAlias;
    }

    public void setTypeAlias(String typeAlias) {
        this.typeAlias = typeAlias;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    @Override
    protected Serializable pkVal() {
        return this.typeId;
    }

    @Override
    public String toString() {
        return "Type{" +
        ", typeId=" + typeId +
        ", typeName=" + typeName +
        ", typeAlias=" + typeAlias +
        ", typeDescription=" + typeDescription +
        "}";
    }
}
