package com.octopus.crudjdbc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.octopus.crudjdbc.entity.Test2;
import com.octopus.crudjdbc.service.Test2Service;


/**
 * 
 *
 * @author yuchu
 * @email 
 * @date 2018-04-26 14:59:07
 */
@RestController
@RequestMapping("test2")
@Api("test2")
public class Test2Controller {
    @Autowired
    private Test2Service test2Service;

    @ApiOperation(value = "获取所有test2")
    @GetMapping
    public List<Test2> getAll(){
        return test2Service.getAll();
    }

    @ApiOperation(value = "更新test2")
    @PutMapping
    public void updateTest2(@RequestBody Test2 test2){
        test2Service.updateTest2(test2);
    }

    @ApiOperation(value = "添加test2")
    @PostMapping
    public void addTest2(@RequestBody Test2 test2){
        test2Service.addTest2(test2);
    }
    @ApiOperation(value = "根据id获取test2")
    @GetMapping("/{id}")
    public Test2 getTest2(@PathVariable Integer id){
        return test2Service.getById(id);
    }
    @ApiOperation(value = "根据id删除}test2")
    @DeleteMapping
    public void deleteTest2(@RequestParam(name = "id") Integer id){
        test2Service.deleteTest2(id);
    }

}
