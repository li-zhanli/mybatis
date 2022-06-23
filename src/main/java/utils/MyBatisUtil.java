package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyBatisUtil {

//    public SqlSession getSqlSession() throws IOException {
//        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        return factory.openSession();
//    }
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactoryByXml() {
        synchronized (MyBatisUtil.class) {
            if (sqlSessionFactory != null) {
                return sqlSessionFactory;
            }
            InputStream inputStream;
            InputStream is;
            try {
                // 加载数据库配置文件
                is = Resources.getResourceAsStream("database.properties");
                Properties properties = new Properties();
                properties.load(is);

//                // 获取加密信息
//                String username= properties.getProperty("database.username");
//                String password= properties.getProperty("database.password");

                // 解密用户名和密码，并重置属性
                properties.setProperty("database.username", "root");
                properties.setProperty("database.password", "123456");

                // 读取mybatis配置文件
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                // 通过SqlSessionFactoryBuilder类的builder方法进行构建，并使用程序传递的方式覆盖原有属性
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }
}
