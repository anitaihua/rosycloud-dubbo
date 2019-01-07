package cn.rosycloud.mapper;

import cn.rosycloud.pojo.Moderator;
import cn.rosycloud.pojo.ModeratorKey;

public interface ModeratorMapper {
    int deleteByPrimaryKey(ModeratorKey key);

    int insert(Moderator record);

    int insertSelective(Moderator record);

    Moderator selectByPrimaryKey(ModeratorKey key);

    int updateByPrimaryKeySelective(Moderator record);

    int updateByPrimaryKey(Moderator record);
}