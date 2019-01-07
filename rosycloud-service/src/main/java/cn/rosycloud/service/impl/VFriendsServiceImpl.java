package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.VFriends;
import cn.rosycloud.mapper.VFriendsMapper;
import cn.rosycloud.service.VFriendsService;
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
public class VFriendsServiceImpl extends ServiceImpl<VFriendsMapper, VFriends> implements VFriendsService {

}
