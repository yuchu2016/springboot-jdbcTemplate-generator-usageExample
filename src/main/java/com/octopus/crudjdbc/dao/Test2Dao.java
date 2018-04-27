package com.octopus.crudjdbc.dao;
import com.octopus.crudjdbc.common.Pagination;
import com.octopus.crudjdbc.common.PageRequest;
import com.octopus.crudjdbc.entity.Test2;
import java.util.List;
/**
 * 
 * 
 * @author yuchu
 * @email 
 * @date 2018-04-27 10:53:13
 */

public interface Test2Dao{

    Test2 findOne(Integer id);

    List<Test2> findAll();

    Pagination<Test2> getPage(PageRequest pageRequest);

    Test2 create(Test2 test2);

    void update(Test2 test2);

    boolean delete(Integer id);
}
