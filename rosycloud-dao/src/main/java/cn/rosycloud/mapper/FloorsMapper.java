package cn.rosycloud.mapper;

import cn.rosycloud.pojo.Floors;

public interface FloorsMapper {
    int deleteByPrimaryKey(Long floorId);

    int insert(Floors record);

    int insertSelective(Floors record);

    Floors selectByPrimaryKey(Long floorId);

    int updateByPrimaryKeySelective(Floors record);

    int updateByPrimaryKeyWithBLOBs(Floors record);

    int updateByPrimaryKey(Floors record);
}