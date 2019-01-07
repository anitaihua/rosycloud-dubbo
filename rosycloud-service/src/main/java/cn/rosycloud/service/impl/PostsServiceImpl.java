package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Posts;
import cn.rosycloud.mapper.PostsMapper;
import cn.rosycloud.service.PostsService;
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
public class PostsServiceImpl extends ServiceImpl<PostsMapper, Posts> implements PostsService {

}
