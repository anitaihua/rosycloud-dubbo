package cn.rosycloud.pojo;

import java.io.Serializable;

public class Moderator extends ModeratorKey implements Serializable {
    private String moderatorLevel;

    public String getModeratorLevel() {
        return moderatorLevel;
    }

    public void setModeratorLevel(String moderatorLevel) {
        this.moderatorLevel = moderatorLevel == null ? null : moderatorLevel.trim();
    }

    @Override
    public String toString() {
        return "Moderator{" +
                "moderatorLevel='" + moderatorLevel + '\'' +
                '}';
    }
}