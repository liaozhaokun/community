package com.community;


import com.community.dao.DiscussPostMapper;
import com.community.dao.UserMapper;
import com.community.entity.DiscussPost;
import com.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectAll(){
        List<User> users = userMapper.selectAll();
        for(User user : users) System.out.println(user);
    }
    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(3);
        System.out.println(user);
    }
    @Test
    public void testSelectByName(){
        User user = userMapper.selectByName("lzk");
        System.out.println(user);
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("bibi");
        user.setPassword("999666");
        userMapper.insertUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setPassword("888888");
        user.setId(3);
        userMapper.updatePassword(user);
    }

    @Test
    public void testSelectDiscussPost(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 15);
        for(DiscussPost discussPost : list) System.out.println(discussPost);
    }

    @Test
    public void testSelectCountById(){
        int count = discussPostMapper.selectDiscussPostRows(101);
        System.out.println(count);
    }
}
