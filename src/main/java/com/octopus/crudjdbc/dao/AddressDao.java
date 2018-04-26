package com.octopus.crudjdbc.dao;

import com.octopus.crudjdbc.entity.Address;
import java.util.List;
/**
 * 
 * 
 * @author yuchu
 * @email 
 * @date 2018-04-26 14:50:22
 */

public interface AddressDao{

    Address findOne(Integer id);

    List<Address> findAll();

    Address create(Address address);

    void update(Address address);

    boolean delete(Integer id);
}
