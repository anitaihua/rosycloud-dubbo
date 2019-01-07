package cn.rosycloud.mapper;

import cn.rosycloud.pojo.Posts;
import cn.rosycloud.pojo.PostsWithBLOBs;

public interface PostsMapper {
    int deleteByPrimaryKey(Long postId);

    int insert(PostsWithBLOBs record);

    int insertSelective(PostsWithBLOBs record);

    PostsWithBLOBs selectByPrimaryKey(Long postId);

    int updateByPrimaryKeySelective(PostsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PostsWithBLOBs record);

    int updateByPrimaryKey(Posts record);
}