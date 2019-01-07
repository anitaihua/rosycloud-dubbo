package cn.rosycloud.mapper;

import cn.rosycloud.pojo.Menus;

public interface MenusMapper {
    int deleteByPrimaryKey(Long menuId);

    int insert(Menus record);

    int insertSelective(Menus record);

    Menus selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(Menus record);

    int updateByPrimaryKey(Menus record);
}