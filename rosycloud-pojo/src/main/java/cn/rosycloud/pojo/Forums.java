package cn.rosycloud.pojo;

import java.io.Serializable;

public class Forums implements Serializable {
    private Long forumId;

    private String forumName;

    private String forumLogo;

    private Long forumPostCount;

    private Long parentForumId;

    private String forumDescription;

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName == null ? null : forumName.trim();
    }

    public String getForumLogo() {
        return forumLogo;
    }

    public void setForumLogo(String forumLogo) {
        this.forumLogo = forumLogo == null ? null : forumLogo.trim();
    }

    public Long getForumPostCount() {
        return forumPostCount;
    }

    public void setForumPostCount(Long forumPostCount) {
        this.forumPostCount = forumPostCount;
    }

    public Long getParentForumId() {
        return parentForumId;
    }

    public void setParentForumId(Long parentForumId) {
        this.parentForumId = parentForumId;
    }

    public String getForumDescription() {
        return forumDescription;
    }

    public void setForumDescription(String forumDescription) {
        this.forumDescription = forumDescription == null ? null : forumDescription.trim();
    }

    @Override
    public String toString() {
        return "Forums{" +
                "forumId=" + forumId +
                ", forumName='" + forumName + '\'' +
                ", forumLogo='" + forumLogo + '\'' +
                ", forumPostCount=" + forumPostCount +
                ", parentForumId=" + parentForumId +
                ", forumDescription='" + forumDescription + '\'' +
                '}';
    }
}