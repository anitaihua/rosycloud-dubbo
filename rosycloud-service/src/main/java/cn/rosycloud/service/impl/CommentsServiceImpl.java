package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Comments;
import cn.rosycloud.mapper.CommentsMapper;
import cn.rosycloud.service.CommentsService;
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
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

}
