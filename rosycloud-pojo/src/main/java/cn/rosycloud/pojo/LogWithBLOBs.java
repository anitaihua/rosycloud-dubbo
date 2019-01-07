package cn.rosycloud.pojo;

import java.io.Serializable;

public class LogWithBLOBs extends Log implements Serializable {
    private String logContent;

    private String note;

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    @Override
    public String toString() {
        return "LogWithBLOBs{" +
                "logContent='" + logContent + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}