package cn.rosycloud.service;

import cn.rosycloud.pojo.Users;

import java.util.List;

public interface  UsersService {

    List<Users> getUsers();

    Long login(String username, String password);
}