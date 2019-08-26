package cn.lksun.Service.impl;

import cn.lksun.Dao.impl.UserImpl;
import cn.lksun.Domain.User;
import cn.lksun.Service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User login(User user) {
        return new UserImpl().getUserByUsernameAndPassword(user);
    }
}