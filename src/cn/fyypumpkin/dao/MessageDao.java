package cn.fyypumpkin.dao;

import cn.fyypumpkin.bean.message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * message表对应的DAO层
 * Created by fyy on 4/9/17.
 */
public class MessageDao {

    public List<message> query(String command, String description) {

        StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,content from micro_message where 1 = 1");
        List<String> paraList = new ArrayList<>();
        List<message> messageList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FirstWeb", "root", "123456");
            if (command != null && !"".equals(command.trim())) {
                sql.append(" and COMMAND =?");
                paraList.add(command);
            }
            if (description != null && !"".equals(description.trim())) {
                sql.append(" and DESCRIPTION like '%' ? '%'");
                paraList.add(description);
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            for (int i = 0; i < paraList.size(); i++) {
                preparedStatement.setString(i + 1, paraList.get(i));

            }

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                message message = new message();
                messageList.add(message);
                message.setId(resultSet.getInt("ID"));
                message.setCommand(resultSet.getString("COMMAND"));
                message.setContent(resultSet.getString("content"));
                message.setDescription(resultSet.getString("DESCRIPTION"));


            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messageList;
    }


}
