package com.octopus.crudjdbc.service;

import com.octopus.crudjdbc.entity.Test2;
import com.octopus.crudjdbc.dao.Test2Dao;
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
public class Test2Service{
    @Autowired
    private Test2Dao test2Dao;

    public void addTest2(Test2 test2){
        test2Dao.create(test2);
    }

    public void updateTest2(Test2 test2){
            test2Dao.update(test2);
    }

    public void deleteTest2(Integer id){
        test2Dao.delete(id);
    }

    public Test2 getById( Integer id){
       return test2Dao.findOne(id);
    }

    public List<Test2> getAll(){
       return test2Dao.findAll();
    }

}

