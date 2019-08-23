package cn.lksun.Dao.impl;

import cn.lksun.Dao.UserDao;
import cn.lksun.Domain.User;
import cn.lksun.Util.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Map;

public class UserImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());

    @Override
    public void getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username= ?";
//        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
////        System.out.println(user);
        RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);

        // 查询结果query(sql语句，Mapper对象); 会返回List集合

        List<User> persons = template.query(sql, mapper,username);
        System.out.println(persons.get(0).getUsername());

    }
}
