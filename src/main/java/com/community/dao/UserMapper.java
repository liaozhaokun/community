package com.community.dao;

import com.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    List<User> selectAll();

    User selectById(int id);

    User selectByName(String username);

    int insertUser(User user);

    int updatePassword(User user);
}
