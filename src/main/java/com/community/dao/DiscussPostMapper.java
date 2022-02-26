package com.community.dao;

import com.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(@Param("userId")int userId,
                                         @Param("offset")int offset,
                                         @Param("limit")int limit);

    // @Param 用于给参数起别名
    int selectDiscussPostRows(@Param("userId") int userId);
}
