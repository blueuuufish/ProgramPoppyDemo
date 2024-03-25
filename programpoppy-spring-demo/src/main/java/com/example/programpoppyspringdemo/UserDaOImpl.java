package com.example.programpoppyspringdemo;

public class UserDaOImpl implements UserDao {
    private UserDao userDao;

    public void saveUser(User user) {
        System.out.println("添加用户成功");
    }

    public void deleteUser(User user) {
        System.out.println("删除用户成功");
    }
}
