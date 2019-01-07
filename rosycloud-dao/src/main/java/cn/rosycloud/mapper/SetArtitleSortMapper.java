package cn.rosycloud.mapper;

import cn.rosycloud.pojo.SetArtitleSortKey;

public interface SetArtitleSortMapper {
    int deleteByPrimaryKey(SetArtitleSortKey key);

    int insert(SetArtitleSortKey record);

    int insertSelective(SetArtitleSortKey record);
}