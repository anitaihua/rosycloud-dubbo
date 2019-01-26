package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Article;
import cn.rosycloud.mapper.ArticleMapper;
import cn.rosycloud.pojo.PageResult;
import cn.rosycloud.pojo.User;
import cn.rosycloud.service.ArticleService;
import cn.rosycloud.utils.Query;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.Map;

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

    @Override
    public PageResult list(Map<String, Object> params) {

        Page<Article> page = this.selectPage(new Query<Article>(params).getPage(),new EntityWrapper<Article>().eq("df",0).eq("open",0).orderBy("article_date",false)) ;

        return new PageResult(page.getTotal(),page.getRecords());
    }


    @Override
    public PageResult selfArticles(Map<String, Object> params, User user) {
        Page<Article> page = new Page<>();

        if(params.get("open") != null){ //查看私密或者公开博文 0：公开 1：私有
            int open = Integer.parseInt(params.get("open")+"");
            page = this.selectPage(new Query<Article>(params).getPage(),new EntityWrapper<Article>().eq("user_id",user.getUserId()).eq("df",0).eq("open",open).orderBy("article_date",false)) ;
        } else { //查看所有自己的博文
            page = this.selectPage(new Query<Article>(params).getPage(),new EntityWrapper<Article>().eq("user_id",user.getUserId()).eq("df",0).orderBy("article_date",false)) ;

        }
        return new PageResult(page.getTotal(),page.getRecords());
    }
}
