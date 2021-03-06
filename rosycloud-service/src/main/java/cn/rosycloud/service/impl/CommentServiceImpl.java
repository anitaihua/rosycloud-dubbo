package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Comment;
import cn.rosycloud.mapper.CommentMapper;
import cn.rosycloud.service.CommentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
