package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Articles;
import cn.rosycloud.mapper.ArticlesMapper;
import cn.rosycloud.service.ArticlesService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;

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

}
