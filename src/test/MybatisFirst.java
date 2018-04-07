package test;

import domain.User;

import domain.UserCustom;
import domain.UserQueryVo;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisFirst {

    private SqlSessionFactory sqlSessionFactory;

    //创建工厂
    @Before
    public void init() throws IOException {
        //配置文件
        String resource = "SqlMapConfig.xml";

        //加载配置文件到输入流中
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    //根据id查询用户信息
    @Test
    public void testFindUserById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);
        sqlSession.close();
        System.out.println(user);
    }

    //根据用户名模糊查询用户信息
    @Test
    public void testFindUserByName() throws Exception {
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //通过sqlSession操作数据库
        List<User> users = userMapper.findUserByName("xxw");

        sqlSession.close();

        System.out.println(users);
    }

    //添加用户
    @Test
    public void testInsertUser() throws Exception {
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("CitrusMaxima");
        user.setAddress("大连");
        user.setBirthday(new Date());
        user.setSex("1");

        userMapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    //删除用户
    @Test
    public void testDeleteUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.deleteUser(7);
        sqlSession.commit();
        sqlSession.close();

    }

    //更新用户信息
    @Test
    public void testUpdateUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(2);
        user.setUsername("CitrusMaxima");
        user.setAddress("辽宁");
        user.setBirthday(new Date());
        user.setSex("1");

        userMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void findUserByList() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();

        userCustom.setUsername("CitrusMaxima");
        userQueryVo.setUserCustom(userCustom);
        List<User> users = userMapper.findUserList(userQueryVo);

        sqlSession.close();
        System.out.println(users);
    }

    @Test
    public void findUserCount() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();

        userCustom.setUsername("CitrusMaxima");
        userQueryVo.setUserCustom(userCustom);
        int count = userMapper.findUserCount(userQueryVo);

        sqlSession.close();

        System.out.println(count);
    }
}
