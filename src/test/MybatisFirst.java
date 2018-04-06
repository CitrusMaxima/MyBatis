package test;

import domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * Created by 26637_000 on 2018/4/6.
 */
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

    //根据id查找用户
    @Test
    public void testFinUserById() {
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = null;

        //通过sqlSession操作数据库
        try {
            user = sqlSession.selectOne("test.findUserById", 1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        System.out.println(user);
    }

    @Test
    public void testFindUserByName() {
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过sqlSession操作数据库
        List<User> userList = null;
        try {
            userList = sqlSession.selectList("test.findUserByName", "w");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }

        System.out.println(userList.get(0).getUsername());
    }
}
