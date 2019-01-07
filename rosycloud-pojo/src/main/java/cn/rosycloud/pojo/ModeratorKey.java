package cn.rosycloud.pojo;

import java.io.Serializable;

public class ModeratorKey implements Serializable {
    private Long moderatorId;

    private Long forumId;

    public Long getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(Long moderatorId) {
        this.moderatorId = moderatorId;
    }

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    @Override
    public String toString() {
        return "ModeratorKey{" +
                "moderatorId=" + moderatorId +
                ", forumId=" + forumId +
                '}';
    }
}