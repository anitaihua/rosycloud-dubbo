package cn.rosycloud.pojo;

import java.io.Serializable;

public class Options implements Serializable {
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
        this.optionName = optionName == null ? null : optionName.trim();
    }

    public String getOptionValues() {
        return optionValues;
    }

    public void setOptionValues(String optionValues) {
        this.optionValues = optionValues == null ? null : optionValues.trim();
    }

    @Override
    public String toString() {
        return "Options{" +
                "optionId=" + optionId +
                ", optionName='" + optionName + '\'' +
                ", optionValues='" + optionValues + '\'' +
                '}';
    }
}