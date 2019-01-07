package cn.rosycloud.mapper;

import cn.rosycloud.pojo.Labels;

public interface LabelsMapper {
    int deleteByPrimaryKey(Long labelId);

    int insert(Labels record);

    int insertSelective(Labels record);

    Labels selectByPrimaryKey(Long labelId);

    int updateByPrimaryKeySelective(Labels record);

    int updateByPrimaryKeyWithBLOBs(Labels record);

    int updateByPrimaryKey(Labels record);
}