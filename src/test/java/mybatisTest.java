import bean.User;
import mapper.DepMapper;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import utils.MyBatisUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class mybatisTest {

    @Test
    public void myTest() throws IOException {
        SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactoryByXml();
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectTwoCondition(1,3);
        System.out.println(user);
    }

    @Test
    public void myTest1() throws IOException {
        SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactoryByXml();
        SqlSession sqlSession = factory.openSession();
        DepMapper mapper = sqlSession.getMapper(DepMapper.class);
        List<User> user = mapper.getDepAndUser(1);
        System.out.println(user);
    }

    @Test
    public void InsertTest() throws IOException {
        SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactoryByXml();
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(new User(11,"7",7,"7","7",null));
        sqlSession.commit();
    }

}

