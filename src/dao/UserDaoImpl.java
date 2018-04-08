package dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import po.User;

import java.util.List;

/**
 * Created by 26637_000 on 2018/4/8.
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    //private SqlSessionFactory sqlSessionFactory;

    /*public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }*/

    @Override
    public User findUserById(int id) throws Exception {

        SqlSession sqlSession = this.getSqlSession();

        User user = sqlSession.selectOne("mapper.UserMapper.findUserById", id);

        //sqlSession.close();

        return user;
    }

    /*@Override
    public List<User> findUserById(String username) throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> users = sqlSession.selectList("test.findUserById", username);

        return users;
    }*/
}
