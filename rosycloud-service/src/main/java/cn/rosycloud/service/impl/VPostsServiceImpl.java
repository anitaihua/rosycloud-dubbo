package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.VPosts;
import cn.rosycloud.mapper.VPostsMapper;
import cn.rosycloud.service.VPostsService;
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
public class VPostsServiceImpl extends ServiceImpl<VPostsMapper, VPosts> implements VPostsService {

}
