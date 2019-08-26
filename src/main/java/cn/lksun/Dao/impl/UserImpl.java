package cn.lksun.Dao.impl;

import cn.lksun.Dao.UserDao;
import cn.lksun.Domain.User;
import cn.lksun.Util.JdbcUtil;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public int createUser(User user) {

        String sql = "INSERT into users(username,email,password, create_time) VALUE (?,?,?,?)";
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        long time = new Date().getTime();
        int i = template.update(sql, user.getUsername(), user.getEmail(), password, time);
        return i;
    }

    @Override
    public int count(String username) {
        String sql = "SELECT count(*) as count FROM users WHERE username= ?";
        Map<String, Object> count = template.queryForMap(sql,username);
        return Integer.parseInt(count.get("count").toString());
    }

}
