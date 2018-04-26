//package com.octopus.crudjdbc.dao.Impl;
//
//import com.octopus.crudjdbc.dao.UserDaoBack;
//import com.octopus.crudjdbc.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementSetter;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.UUID;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: luqinglin
// * Date: 2018-04-26
// * Time: 9:31
// */
//@Repository
//public class UserDaoImplBack implements UserDaoBack {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    @Transactional(readOnly = true)
//    public User findOne(String id) {
//        return jdbcTemplate.queryForObject("select * from tb_user where id=?", new Object[]{id}, new UserRowMapper());
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<User> findAll() {
//        return jdbcTemplate.query("select * from tb_user ", new UserRowMapper());
//    }
//
//    @Override
//    public User create(User user) {
//        String id = UUID.randomUUID().toString().replaceAll("-", "");
//        user.setId(id);
//        final String sql = "insert into tb_user values(?,?,?)";
//        jdbcTemplate.update(sql, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps) throws SQLException {
//                ps.setString(1, id);
//                ps.setString(2, user.getUsername());
//                ps.setString(3, user.getPassword());
//            }
//        });
//        return user;
//    }
//
//    @Override
//    public void update(User user) {
//        final String sql = "update tb_user set username=?,password=? where id=?";
//        jdbcTemplate.update(sql, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps) throws SQLException {
//                ps.setString(1, user.getUsername());
//                ps.setString(2, user.getPassword());
//                ps.setString(3, user.getId());
//            }
//        });
//    }
//
//    @Override
//    public boolean delete(String id) {
//        String sql = "delete from tb_user  where id=?";
//        Object[] params = new Object[]{id};
//        int rowNum = jdbcTemplate.update(sql, params);
//        return rowNum > 0 ? true : false;
//    }
//}
//
//class UserRowMapper implements RowMapper<User> {
//
//    @Override
//    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//        User user = new User();
//        user.setId(rs.getString("id"));
//        user.setUsername(rs.getString("username"));
//        user.setPassword(rs.getString("password"));
//        return user;
//    }
//
//}
