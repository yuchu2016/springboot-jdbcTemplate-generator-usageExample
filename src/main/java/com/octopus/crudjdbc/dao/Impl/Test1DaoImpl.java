package com.octopus.crudjdbc.dao.Impl;

import com.octopus.crudjdbc.entity.Test1;
import com.octopus.crudjdbc.dao.Test1Dao;
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
public class Test1DaoImpl implements Test1Dao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(readOnly = true)
    public Test1 findOne(Integer id) {
        return jdbcTemplate.queryForObject("select * from test1 where id=?", new Object[]{id}, new Test1RowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Test1> findAll() {
        return jdbcTemplate.query("select * from test1", new Test1RowMapper());
    }

    @Override
    public Test1 create(Test1 test1) {
        final String sql = "insert into test1( name  ,  pwd   ) values(   ?,  ?)";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, test1.getName());
                ps.setString(2, test1.getPwd());
                return ps;
            }
        }, holder);
        int newId = holder.getKey().intValue();
        test1.setId(newId);
        return test1;
    }

    @Override
    public void update(Test1 test1) {
        final String sql = "update test1 set  name=?,pwd=? where id=?";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(3, test1.getId());
                ps.setString(1, test1.getName());
                ps.setString(2, test1.getPwd());
            }
        });
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "delete from test1  where id=?";
        Object[] params = new Object[]{id};
        int rowNum = jdbcTemplate.update(sql, params);
        return rowNum > 0 ? true : false;
    }
}

class Test1RowMapper implements RowMapper<Test1> {

    @Override
    public Test1 mapRow(ResultSet rs, int rowNum) throws SQLException {
        Test1 test1 = new Test1();
        test1.setId(rs.getInt("id"));
        test1.setName(rs.getString("name"));
        test1.setPwd(rs.getString("pwd"));
        return test1;
    }

}