package cn.rosycloud.service.impl;

import cn.rosycloud.mapper.UsersMapper;
import cn.rosycloud.pojo.Users;
import cn.rosycloud.service.UsersService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> getUsers() {

        return usersMapper.getUsers();
    }

    @Override
    @Transactional(readOnly = false)//必须设置为false,因为此处切入了日志的保存逻辑
    public Long login(String username, String password) {
        Users u = new Users();
        u.setUserName(username);
        u.setUserPassword(password);
        Users user = usersMapper.findUserByUnameAndPasswd(u);
        return user == null ? (long)-1 : user.getUserId();
    }
}
