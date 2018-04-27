package com.octopus.crudjdbc.dao.Impl;

import com.octopus.crudjdbc.entity.User;
import com.octopus.crudjdbc.dao.UserDao;
import com.octopus.crudjdbc.common.Pagination;
import com.octopus.crudjdbc.common.PageRequest;
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
 * 
 *
 * @author yuchu
 * @email 
 * @date 2018-04-27 10:53:13
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(readOnly = true)
    public User findOne(String id) {
        return jdbcTemplate.queryForObject("select * from tb_user where id=?", new Object[]{id}, new UserRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return jdbcTemplate.query("select * from tb_user", new UserRowMapper());
    }
    @Override
    @Transactional(readOnly = true)
    public Pagination getPage(PageRequest pageRequest) {
        return new Pagination("select * from tb_user",pageRequest,jdbcTemplate);
    }
    @Override
    public User create(User user) {
                    String id = UUID.randomUUID().toString().replaceAll("-", "");
            user.setId(id);
            final String sql = "insert into tb_user values( ?  ,  ?  ,  ?   )";
            jdbcTemplate.update(sql, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                                        ps.setString(1,user.getId());
                                        ps.setString(2,user.getUsername());
                                        ps.setString(3,user.getPassword());
                                    }
            });
            return user;
            }

    @Override
    public void update(User user){
        final String sql = "update tb_user set  username=?,password=? where id=?";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                                                            ps.setString(3,user.getId());
                                                                                ps.setString(1,user.getUsername());
                                                                                ps.setString(2,user.getPassword());
                                                }
        });
    }
    @Override
    public boolean delete(String id){
        String sql = "delete from tb_user  where id=?";
        Object[] params = new Object[]{id};
        int rowNum = jdbcTemplate.update(sql, params);
        return rowNum > 0 ? true : false;
    }
}

class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user =new User();
                        user.setId(rs.getString("id"));
                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                return user;
    }

}