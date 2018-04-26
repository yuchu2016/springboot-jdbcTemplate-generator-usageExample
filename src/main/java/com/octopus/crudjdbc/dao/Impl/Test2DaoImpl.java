package com.octopus.crudjdbc.dao.Impl;

import com.octopus.crudjdbc.entity.Test2;
import com.octopus.crudjdbc.dao.Test2Dao;
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
public class Test2DaoImpl implements Test2Dao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(readOnly = true)
    public Test2 findOne(Integer id) {
        return jdbcTemplate.queryForObject("select * from test2 where id=?", new Object[]{id}, new Test2RowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Test2> findAll() {
        return jdbcTemplate.query("select * from test2", new Test2RowMapper());
    }

    @Override
    public Test2 create(Test2 test2) {
        final String sql = "insert into test2( name  ,  pwd   ) values(   ?,  ?)";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, test2.getName());
                ps.setString(2, test2.getPwd());
                return ps;
            }
        }, holder);
        int newId = holder.getKey().intValue();
        test2.setId(newId);
        return test2;
    }

    @Override
    public void update(Test2 test2) {
        final String sql = "update test2 set  name=?,pwd=? where id=?";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(3, test2.getId());
                ps.setString(1, test2.getName());
                ps.setString(2, test2.getPwd());
            }
        });
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "delete from test2  where id=?";
        Object[] params = new Object[]{id};
        int rowNum = jdbcTemplate.update(sql, params);
        return rowNum > 0 ? true : false;
    }
}

class Test2RowMapper implements RowMapper<Test2> {

    @Override
    public Test2 mapRow(ResultSet rs, int rowNum) throws SQLException {
        Test2 test2 = new Test2();
        test2.setId(rs.getInt("id"));
        test2.setName(rs.getString("name"));
        test2.setPwd(rs.getString("pwd"));
        return test2;
    }

}