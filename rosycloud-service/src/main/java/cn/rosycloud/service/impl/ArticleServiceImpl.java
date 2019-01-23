package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Article;
import cn.rosycloud.mapper.ArticleMapper;
import cn.rosycloud.service.ArticleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * <p>
 * 博文表 服务实现类
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
