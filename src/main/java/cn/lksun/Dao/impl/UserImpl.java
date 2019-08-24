package cn.lksun.Dao.impl;

import cn.lksun.Dao.UserDao;
import cn.lksun.Domain.User;
import cn.lksun.Util.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Date;
import java.util.List;

public class UserImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());

    @Override
    public void getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username= ?";
        RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);
        List<User> persons = template.query(sql, mapper,username);
        System.out.println(persons.get(0).getUsername());

    }

    @Override
    public void createUser(User user) {

        String sql = "INSERT into users(username,email,password, create_time) VALUE (?,?,?,?)";
        long time = new Date().getTime();
        template.update(sql,user.getUsername(),user.getEmail(),user.getPassword(),time);

    }

}
