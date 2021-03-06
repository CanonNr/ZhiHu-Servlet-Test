package cn.lksun.Dao;

import cn.lksun.Domain.User;

public interface UserDao {
    public void getUserByUsername(String username);

    public int createUser(User user);

    public int count(String username);

    public User getUserByUsernameAndPassword(User user);
}
