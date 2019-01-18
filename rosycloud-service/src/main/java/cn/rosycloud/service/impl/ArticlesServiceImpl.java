package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Articles;
import cn.rosycloud.mapper.ArticlesMapper;
import cn.rosycloud.pojo.PageResult;
import cn.rosycloud.service.ArticlesService;
import cn.rosycloud.utils.Query;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-07
 */
@Service
public class ArticlesServiceImpl extends ServiceImpl<ArticlesMapper, Articles> implements ArticlesService {

    @Override
    public PageResult list(Map<String, Object> params) {

        Page<Articles> page = this.selectPage(new Query<Articles>(params).getPage(),new EntityWrapper<Articles>());

        return new PageResult(page.getTotal(),page.getRecords());
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addArticle(Articles articles){
        articles.setArticleDate(new Date());
        this.insert(articles);

    }
}
