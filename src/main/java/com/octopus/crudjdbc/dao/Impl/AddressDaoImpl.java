package com.octopus.crudjdbc.dao.Impl;

import com.octopus.crudjdbc.entity.Address;
import com.octopus.crudjdbc.dao.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;
import java.util.UUID;

/**
 * @author yuchu
 * @email
 * @date 2018-04-26 14:50:22
 */
@Repository
public class AddressDaoImpl implements AddressDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(readOnly = true)
    public Address findOne(Integer id) {
        return jdbcTemplate.queryForObject("select * from tb_address where id=?", new Object[]{id}, new AddressRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Address> findAll() {
        return jdbcTemplate.query("select * from tb_address", new AddressRowMapper());
    }

    @Override
    public Address create(Address address) {
        final String sql = "insert into tb_address( userId  ,  address   ) values(   ?,  ?)";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, address.getUserid());
                ps.setString(2, address.getAddress());
                return ps;
            }
        }, holder);
        int newId = holder.getKey().intValue();
        address.setId(newId);
        return address;
    }

    @Override
    public void update(Address address) {
        final String sql = "update tb_address set  userId=?,address=? where id=?";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(3, address.getId());
                ps.setInt(1, address.getUserid());
                ps.setString(2, address.getAddress());
            }
        });
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "delete from tb_address  where id=?";
        Object[] params = new Object[]{id};
        int rowNum = jdbcTemplate.update(sql, params);
        return rowNum > 0 ? true : false;
    }
}

class AddressRowMapper implements RowMapper<Address> {

    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        Address address = new Address();
        address.setId(rs.getInt("id"));
        address.setUserid(rs.getInt("userid"));
        address.setAddress(rs.getString("address"));
        return address;
    }

}