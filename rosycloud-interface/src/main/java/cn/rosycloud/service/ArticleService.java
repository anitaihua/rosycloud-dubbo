package cn.rosycloud.service;

import cn.rosycloud.pojo.Article;
import cn.rosycloud.pojo.PageResult;
import cn.rosycloud.pojo.User;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 博文表 服务类
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
public interface ArticleService extends IService<Article> {

    PageResult list(Map<String, Object> params);

    PageResult selfArticles(Map<String, Object> params, User user);
}
