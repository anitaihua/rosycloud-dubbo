package cn.rosycloud.mapper;

import cn.rosycloud.pojo.Log;
import cn.rosycloud.pojo.LogWithBLOBs;

public interface LogMapper {
    int deleteByPrimaryKey(Long logId);

    int insert(LogWithBLOBs record);

    int insertSelective(LogWithBLOBs record);

    LogWithBLOBs selectByPrimaryKey(Long logId);

    int updateByPrimaryKeySelective(LogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LogWithBLOBs record);

    int updateByPrimaryKey(Log record);
}