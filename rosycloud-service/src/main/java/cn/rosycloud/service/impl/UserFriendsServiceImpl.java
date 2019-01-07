package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.UserFriends;
import cn.rosycloud.mapper.UserFriendsMapper;
import cn.rosycloud.service.UserFriendsService;
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
public class UserFriendsServiceImpl extends ServiceImpl<UserFriendsMapper, UserFriends> implements UserFriendsService {

}
