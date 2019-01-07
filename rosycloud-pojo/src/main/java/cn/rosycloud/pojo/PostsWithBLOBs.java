package cn.rosycloud.pojo;

import java.io.Serializable;

public class PostsWithBLOBs extends Posts implements Serializable {
    private String postTitle;

    private String postContent;

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle == null ? null : postTitle.trim();
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent == null ? null : postContent.trim();
    }

    @Override
    public String toString() {
        return "PostsWithBLOBs{" +
                "postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                '}';
    }
}