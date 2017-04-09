package cn.fyypumpkin.DB;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


/**
 * 通过mybatis访问数据库
 * Created by fyy on 4/9/17.
 */
public class DBAcess {


    public SqlSession getsqlSession() throws IOException {

        //通过配置文件获取数据库连接信息
        Reader reader = Resources.getResourceAsReader("cn/fyypumpkin/config/Configuration.xml");
        //通过配置信息构建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //通过SqlSessionFactory打开一个数据库绘话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession;


    }


}
