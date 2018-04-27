//package com.octopus.crudjdbc.dao.Impl;
//
//import com.octopus.crudjdbc.CrudJdbcApplication;
//import com.octopus.crudjdbc.common.PageRequest;
//import com.octopus.crudjdbc.dao.UserDao;
//import com.octopus.crudjdbc.entity.User;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = CrudJdbcApplication.class)
//public class UserDaoImplTest {
//
//    @Autowired
//    private UserDao userDao;
//    @Test
//    public void findOne() {
//        String id = "4028969b62fbb2660162fbb31d8c0000";
//        User user = userDao.findOne(id);
//        Assert.assertNotNull(user);
//    }
//    @Test
//    public void findAll(){
//        List<User> userList = userDao.findAll();
//        Assert.assertNotNull(userList.size());
//    }
//    @Test
//    public void getPage(){
//        Pagination<User> pageResult = userDao.getPage(new PageRequest(1,10));
//        Assert.assertNotNull(pageResult.getResultList());
//    }
//    @Test
//    public void create(){
//        User user = new User();
//        user.setUsername("李四");
//        user.setPassword("1234");
//        User result = userDao.create(user);
//        Assert.assertNotNull(result);
//    }
//    @Test
//    public void update(){
//        User user = userDao.findOne("4823da77fb734ba28233c572fa112553");
//        user.setPassword("12341");
//        user.setUsername("李四1");
//        userDao.update(user);
//    }
//
//    @Test
//    public void delete(){
//        String id = "4823da77fb734ba28233c572fa112553";
//        Boolean result = userDao.delete(id);
//        Assert.assertTrue(result);
//    }
//}