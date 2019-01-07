package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.VQueryUserPostedPosts;
import cn.rosycloud.mapper.VQueryUserPostedPostsMapper;
import cn.rosycloud.service.VQueryUserPostedPostsService;
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
public class VQueryUserPostedPostsServiceImpl extends ServiceImpl<VQueryUserPostedPostsMapper, VQueryUserPostedPosts> implements VQueryUserPostedPostsService {

}
