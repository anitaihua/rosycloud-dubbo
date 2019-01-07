package cn.rosycloud.pojo;

import java.io.Serializable;

public class Labels implements Serializable {
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
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public String getLabelAlias() {
        return labelAlias;
    }

    public void setLabelAlias(String labelAlias) {
        this.labelAlias = labelAlias == null ? null : labelAlias.trim();
    }

    public String getLabelDescription() {
        return labelDescription;
    }

    public void setLabelDescription(String labelDescription) {
        this.labelDescription = labelDescription == null ? null : labelDescription.trim();
    }

    @Override
    public String toString() {
        return "Labels{" +
                "labelId=" + labelId +
                ", labelName='" + labelName + '\'' +
                ", labelAlias='" + labelAlias + '\'' +
                ", labelDescription='" + labelDescription + '\'' +
                '}';
    }
}