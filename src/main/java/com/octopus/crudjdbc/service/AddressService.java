package com.octopus.crudjdbc.service;
import com.octopus.crudjdbc.common.Pagination;
import com.octopus.crudjdbc.common.PageRequest;
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
 * @date 2018-04-27 10:53:13
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

    public Pagination<Address> getPage(Integer pageNum,Integer pageSize){
        PageRequest pageRequest = new PageRequest(pageNum,pageSize);
        return addressDao.getPage(pageRequest);
    }
}

