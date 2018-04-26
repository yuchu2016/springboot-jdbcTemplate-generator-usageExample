package com.octopus.crudjdbc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.octopus.crudjdbc.entity.Test1;
import com.octopus.crudjdbc.service.Test1Service;


/**
 * 
 *
 * @author yuchu
 * @email 
 * @date 2018-04-26 14:59:07
 */
@RestController
@RequestMapping("test1")
@Api("test1")
public class Test1Controller {
    @Autowired
    private Test1Service test1Service;

    @ApiOperation(value = "获取所有test1")
    @GetMapping
    public List<Test1> getAll(){
        return test1Service.getAll();
    }

    @ApiOperation(value = "更新test1")
    @PutMapping
    public void updateTest1(@RequestBody Test1 test1){
        test1Service.updateTest1(test1);
    }

    @ApiOperation(value = "添加test1")
    @PostMapping
    public void addTest1(@RequestBody Test1 test1){
        test1Service.addTest1(test1);
    }
    @ApiOperation(value = "根据id获取test1")
    @GetMapping("/{id}")
    public Test1 getTest1(@PathVariable Integer id){
        return test1Service.getById(id);
    }
    @ApiOperation(value = "根据id删除}test1")
    @DeleteMapping
    public void deleteTest1(@RequestParam(name = "id") Integer id){
        test1Service.deleteTest1(id);
    }

}
