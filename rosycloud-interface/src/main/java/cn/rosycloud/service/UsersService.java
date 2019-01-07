package cn.rosycloud.service;

import cn.rosycloud.pojo.Users;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface  UsersService extends IService<Users> {

    List<Users> getUsers();

    Long login(String username, String password);
}