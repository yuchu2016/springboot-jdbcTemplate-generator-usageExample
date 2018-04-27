package com.octopus.crudjdbc.dao;
import com.octopus.crudjdbc.common.Pagination;
import com.octopus.crudjdbc.common.PageRequest;
import com.octopus.crudjdbc.entity.User;
import java.util.List;
/**
 * 
 * 
 * @author yuchu
 * @email 
 * @date 2018-04-27 10:53:13
 */

public interface UserDao{

    User findOne(String id);

    List<User> findAll();

    Pagination<User> getPage(PageRequest pageRequest);

    User create(User user);

    void update(User user);

    boolean delete(String id);
}
