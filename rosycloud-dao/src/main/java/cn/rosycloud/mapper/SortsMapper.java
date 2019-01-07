package cn.rosycloud.mapper;

import cn.rosycloud.pojo.Sorts;

public interface SortsMapper {
    int deleteByPrimaryKey(Long sortId);

    int insert(Sorts record);

    int insertSelective(Sorts record);

    Sorts selectByPrimaryKey(Long sortId);

    int updateByPrimaryKeySelective(Sorts record);

    int updateByPrimaryKeyWithBLOBs(Sorts record);

    int updateByPrimaryKey(Sorts record);
}