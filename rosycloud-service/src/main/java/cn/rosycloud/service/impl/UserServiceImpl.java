package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.User;
import cn.rosycloud.mapper.UserMapper;
import cn.rosycloud.service.UserService;
import cn.rosycloud.utils.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private UserMapper userMapper;

    @Override
    public Long login(String username, String password) {

        if(StringUtil.isEmpty(username)) return null;
        if(StringUtil.isEmpty(password)) return null;

        User u = new User();
        u.setUserName(username);
        u.setPassword(password);
        User user = userMapper.findByUserNameAndPassword(u);

        return user == null ? (long)-1 : user.getUserId();
    }
}
