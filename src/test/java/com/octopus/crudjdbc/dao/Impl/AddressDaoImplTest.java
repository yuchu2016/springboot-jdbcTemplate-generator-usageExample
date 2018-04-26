//package com.octopus.crudjdbc.dao.Impl;
//
//import com.octopus.crudjdbc.CrudJdbcApplication;
//import com.octopus.crudjdbc.entity.Address;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = CrudJdbcApplication.class)
//public class AddressDaoImplTest {
//
//    @Autowired
//    private AddressDao addressDao;
//    @Test
//    public void findOne() {
//        Integer id = 1;
//        Address address = addressDao.findOne(id);
//        Assert.assertNotNull(address);
//    }
//
//    @Test
//    public void findAll() {
//        List<Address> addressList = addressDao.findAll();
//        Assert.assertNotEquals(0,addressList.size());
//    }
//
//    @Test
//    public void create() {
//        Address address = new Address();
//        address.setUserid(1);
//        address.setAddress("address1");
//        addressDao.create(address);
//    }
//
//    @Test
//    public void update() {
//        Address address = new Address();
//        address.setUserid(2);
//        address.setAddress("Address2345");
//        address.setId(3);
//        addressDao.update(address);
//    }
//
//    @Test
//    public void delete() {
//        Boolean result = addressDao.delete(3);
//        Assert.assertTrue(result);
//    }
//}