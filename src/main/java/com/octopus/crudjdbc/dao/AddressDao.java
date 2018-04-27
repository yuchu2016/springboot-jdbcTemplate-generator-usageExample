package com.octopus.crudjdbc.dao;
import com.octopus.crudjdbc.common.Pagination;
import com.octopus.crudjdbc.common.PageRequest;
import com.octopus.crudjdbc.entity.Address;
import java.util.List;
/**
 * 
 * 
 * @author yuchu
 * @email 
 * @date 2018-04-27 10:53:13
 */

public interface AddressDao{

    Address findOne(Integer id);

    List<Address> findAll();

    Pagination<Address> getPage(PageRequest pageRequest);

    Address create(Address address);

    void update(Address address);

    boolean delete(Integer id);
}
