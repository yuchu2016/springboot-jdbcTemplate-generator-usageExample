package com.octopus.crudjdbc.dao;

import com.octopus.crudjdbc.entity.Test2;
import java.util.List;
/**
 * 
 * 
 * @author yuchu
 * @email 
 * @date 2018-04-26 14:50:22
 */

public interface Test2Dao{

    Test2 findOne(Integer id);

    List<Test2> findAll();

    Test2 create(Test2 test2);

    void update(Test2 test2);

    boolean delete(Integer id);
}
