package cn.rosycloud.mapper;

import cn.rosycloud.pojo.SetArtitleLabel;

public interface SetArtitleLabelMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(SetArtitleLabel record);

    int insertSelective(SetArtitleLabel record);

    SetArtitleLabel selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(SetArtitleLabel record);

    int updateByPrimaryKey(SetArtitleLabel record);
}