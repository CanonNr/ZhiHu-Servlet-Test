package cn.lksun.Dao;

import cn.lksun.Domain.User;

public interface UserDao {
    public void getUserByUsername(String username);

    public void createUser(User user);
}
