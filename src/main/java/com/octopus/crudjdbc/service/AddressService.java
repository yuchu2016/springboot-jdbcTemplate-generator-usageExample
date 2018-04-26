package com.octopus.crudjdbc.service;

import com.octopus.crudjdbc.entity.Address;
import com.octopus.crudjdbc.dao.AddressDao;
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
public class AddressService{
    @Autowired
    private AddressDao addressDao;

    public void addAddress(Address address){
        addressDao.create(address);
    }

    public void updateAddress(Address address){
            addressDao.update(address);
    }

    public void deleteAddress(Integer id){
        addressDao.delete(id);
    }

    public Address getById( Integer id){
       return addressDao.findOne(id);
    }

    public List<Address> getAll(){
       return addressDao.findAll();
    }

}

