package mapper;

import domain.User;
import domain.UserQueryVo;

import java.util.List;

public interface UserMapper {

    public User findUserById(int id) throws Exception;

    public List<User> findUserByName(String username) throws Exception;

    public void insertUser(User user) throws Exception;

    public void deleteUser(int id) throws Exception;

    public void updateUser(User user) throws Exception;

    public List<User> findUserList(UserQueryVo userQueryVo) throws Exception;

    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    //查询用户使用resultMap进行映射
    public List<User> findUserListResultMap(UserQueryVo userQueryVo) throws Exception;
}
