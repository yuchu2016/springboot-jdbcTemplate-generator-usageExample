package com.octopus.crudjdbc.dao;
import com.octopus.crudjdbc.common.Pagination;
import com.octopus.crudjdbc.common.PageRequest;
import com.octopus.crudjdbc.entity.Test1;
import java.util.List;
/**
 * 
 * 
 * @author yuchu
 * @email 
 * @date 2018-04-27 10:53:13
 */

public interface Test1Dao{

    Test1 findOne(Integer id);

    List<Test1> findAll();

    Pagination<Test1> getPage(PageRequest pageRequest);

    Test1 create(Test1 test1);

    void update(Test1 test1);

    boolean delete(Integer id);
}
