package com.octopus.crudjdbc.service;
import com.octopus.crudjdbc.common.Pagination;
import com.octopus.crudjdbc.common.PageRequest;
import com.octopus.crudjdbc.entity.Test1;
import com.octopus.crudjdbc.dao.Test1Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 
 *
 * @author yuchu
 * @email 
 * @date 2018-04-27 10:53:13
 */
@Service
public class Test1Service{
    @Autowired
    private Test1Dao test1Dao;

    public void addTest1(Test1 test1){
        test1Dao.create(test1);
    }

    public void updateTest1(Test1 test1){
            test1Dao.update(test1);
    }

    public void deleteTest1(Integer id){
        test1Dao.delete(id);
    }

    public Test1 getById( Integer id){
       return test1Dao.findOne(id);
    }

    public List<Test1> getAll(){
       return test1Dao.findAll();
    }

    public Pagination<Test1> getPage(Integer pageNum,Integer pageSize){
        PageRequest pageRequest = new PageRequest(pageNum,pageSize);
        return test1Dao.getPage(pageRequest);
    }
}

