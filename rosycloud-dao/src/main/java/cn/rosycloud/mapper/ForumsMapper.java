package cn.rosycloud.mapper;

import cn.rosycloud.pojo.Forums;

public interface ForumsMapper {
    int deleteByPrimaryKey(Long forumId);

    int insert(Forums record);

    int insertSelective(Forums record);

    Forums selectByPrimaryKey(Long forumId);

    int updateByPrimaryKeySelective(Forums record);

    int updateByPrimaryKeyWithBLOBs(Forums record);

    int updateByPrimaryKey(Forums record);
}