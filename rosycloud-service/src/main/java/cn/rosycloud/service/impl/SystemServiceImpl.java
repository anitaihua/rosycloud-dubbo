package cn.rosycloud.service.impl;

import cn.rosycloud.mapper.LogMapper;
import cn.rosycloud.pojo.Log;
import cn.rosycloud.pojo.Users;
import cn.rosycloud.service.SystemService;
import cn.rosycloud.service.UsersService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private LogMapper logMapper;
    @Autowired
    private UsersService usersService;

    @Override
    public void addLog(Log log) {

        if(log!=null&&log.getUserId()!=null){
            Users u = usersService.selectById(log.getUserId());
            if(u!=null){
                log.setUserName(u.getUserName());
                log.setRealName(u.getUserNickname());
                logMapper.insert(log);
            }
        }
    }
}
