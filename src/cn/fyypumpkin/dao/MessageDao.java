package cn.fyypumpkin.dao;

import cn.fyypumpkin.DB.DBAcess;
import cn.fyypumpkin.bean.message;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * message表对应的DAO层
 * Created by fyy on 4/9/17.
 */
public class MessageDao {

//    public List<message> query(String command, String description) {
//
//        StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,content from micro_message where 1 = 1");
//        List<String> paraList = new ArrayList<>();
//        List<message> messageList = new ArrayList<>();
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FirstWeb", "root", "123456");
//            if (command != null && !"".equals(command.trim())) {
//                sql.append(" and COMMAND =?");
//                paraList.add(command);
//            }
//            if (description != null && !"".equals(description.trim())) {
//                sql.append(" and DESCRIPTION like '%' ? '%'");
//                paraList.add(description);
//            }
//            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
//            for (int i = 0; i < paraList.size(); i++) {
//                preparedStatement.setString(i + 1, paraList.get(i));
//
//            }
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//
//                message message = new message();
//                messageList.add(message);
//                message.setId(resultSet.getInt("ID"));
//                message.setCommand(resultSet.getString("COMMAND"));
//                message.setContent(resultSet.getString("content"));
//                message.setDescription(resultSet.getString("DESCRIPTION"));
//
//
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return messageList;
//    }

    /**
     * 查询
     * @param command
     * @param description
     * @return
     */
    public List<message> query(String command, String description){
        DBAcess dbAcess = new DBAcess();
        SqlSession sqlSession = null;
        message message = new message();
        message.setCommand(command);
        message.setDescription(description);
        List<message> messageList = new ArrayList<>();
        try {
            sqlSession = dbAcess.getsqlSession();
            messageList = sqlSession.selectList("Message.query",message);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null)
            sqlSession.close();
        }

        return messageList;

    }


    /**
     * 单条删除记录
     */

    public void  deleteOne(int id){
        DBAcess dbAcess = new DBAcess();
        SqlSession sqlSession = null;

        try {
            sqlSession = dbAcess.getsqlSession();
            sqlSession.delete("Message.deleteOne",id);
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null)
                sqlSession.close();
        }

    }

    public void  deleteBatch(List ids){
        DBAcess dbAcess = new DBAcess();
        SqlSession sqlSession = null;

        try {
            sqlSession = dbAcess.getsqlSession();
            sqlSession.delete("Message.deleteBatch",ids);
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null)
                sqlSession.close();
        }

    }


}
