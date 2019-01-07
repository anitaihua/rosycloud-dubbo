package cn.rosycloud.pojo;

import java.io.Serializable;

public class Sorts implements Serializable {
    private Long sortId;

    private String sortName;

    private String sortAlias;

    private Long parentSortId;

    private String sortDescription;

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
        this.sortName = sortName == null ? null : sortName.trim();
    }

    public String getSortAlias() {
        return sortAlias;
    }

    public void setSortAlias(String sortAlias) {
        this.sortAlias = sortAlias == null ? null : sortAlias.trim();
    }

    public Long getParentSortId() {
        return parentSortId;
    }

    public void setParentSortId(Long parentSortId) {
        this.parentSortId = parentSortId;
    }

    public String getSortDescription() {
        return sortDescription;
    }

    public void setSortDescription(String sortDescription) {
        this.sortDescription = sortDescription == null ? null : sortDescription.trim();
    }

    @Override
    public String toString() {
        return "Sorts{" +
                "sortId=" + sortId +
                ", sortName='" + sortName + '\'' +
                ", sortAlias='" + sortAlias + '\'' +
                ", parentSortId=" + parentSortId +
                ", sortDescription='" + sortDescription + '\'' +
                '}';
    }
}