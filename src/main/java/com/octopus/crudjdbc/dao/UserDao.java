package com.octopus.crudjdbc.dao;

import com.octopus.crudjdbc.entity.User;
import java.util.List;
/**
 * 
 * 
 * @author yuchu
 * @email 
 * @date 2018-04-26 14:50:22
 */

public interface UserDao{

    User findOne(String id);

    List<User> findAll();

    User create(User user);

    void update(User user);

    boolean delete(String id);
}
