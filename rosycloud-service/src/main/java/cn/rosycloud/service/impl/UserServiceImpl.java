package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.User;
import cn.rosycloud.mapper.UserMapper;
import cn.rosycloud.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Long login(String username, String password) {
        return null;
    }
}
