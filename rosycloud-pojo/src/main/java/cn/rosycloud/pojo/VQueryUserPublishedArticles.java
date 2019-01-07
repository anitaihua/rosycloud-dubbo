package cn.rosycloud.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-07
 */
public class VQueryUserPublishedArticles extends Model<VQueryUserPublishedArticles> {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String userName;
    private Long articleId;
    private String articleTitle;
    private String articleContent;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "VQueryUserPublishedArticles{" +
        ", userId=" + userId +
        ", userName=" + userName +
        ", articleId=" + articleId +
        ", articleTitle=" + articleTitle +
        ", articleContent=" + articleContent +
        "}";
    }
}
