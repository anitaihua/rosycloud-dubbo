package cn.rosycloud.service;

import cn.rosycloud.pojo.Articles;
import cn.rosycloud.pojo.PageResult;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-07
 */
public interface ArticlesService extends IService<Articles> {

    PageResult list(Map<String, Object> params);

    void addArticle(Articles articles);
}
