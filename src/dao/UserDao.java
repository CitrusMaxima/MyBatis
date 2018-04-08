package dao;

import po.User;

import java.util.List;

/**
 * Created by 26637_000 on 2018/4/8.
 */
public interface UserDao {

    public User findUserById(int id) throws Exception;

    //public List<User> findUserById(String username) throws Exception;
}
