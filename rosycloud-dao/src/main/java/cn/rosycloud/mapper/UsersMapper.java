package cn.rosycloud.mapper;

import cn.rosycloud.pojo.Users;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(Users user);

    int updateByPrimaryKey(Users record);

    List<Users> getUsers();

    Users findUserByUnameAndPasswd(Users user);
}