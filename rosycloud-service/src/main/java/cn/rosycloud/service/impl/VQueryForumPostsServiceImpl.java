package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.VQueryForumPosts;
import cn.rosycloud.mapper.VQueryForumPostsMapper;
import cn.rosycloud.service.VQueryForumPostsService;
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
public class VQueryForumPostsServiceImpl extends ServiceImpl<VQueryForumPostsMapper, VQueryForumPosts> implements VQueryForumPostsService {

}