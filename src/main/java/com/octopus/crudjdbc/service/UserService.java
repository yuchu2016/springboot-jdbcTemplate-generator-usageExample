package com.octopus.crudjdbc.service;

import com.octopus.crudjdbc.entity.User;
import com.octopus.crudjdbc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 
 *
 * @author yuchu
 * @email 
 * @date 2018-04-26 14:50:22
 */
@Service
public class UserService{
    @Autowired
    private UserDao userDao;

    public void addUser(User user){
        userDao.create(user);
    }

    public void updateUser(User user){
            userDao.update(user);
    }

    public void deleteUser(String id){
        userDao.delete(id);
    }

    public User getById( String id){
       return userDao.findOne(id);
    }

    public List<User> getAll(){
       return userDao.findAll();
    }

}

