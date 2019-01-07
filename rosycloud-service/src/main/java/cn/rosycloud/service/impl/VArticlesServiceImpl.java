package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.VArticles;
import cn.rosycloud.mapper.VArticlesMapper;
import cn.rosycloud.service.VArticlesService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-07
 */
@Service
public class VArticlesServiceImpl extends ServiceImpl<VArticlesMapper, VArticles> implements VArticlesService {

}
