package cn.fyypumpkin.service;

import cn.fyypumpkin.bean.message;
import cn.fyypumpkin.dao.MessageDao;

import java.util.List;

/**
 *
 * Created by fyy on 4/9/17.
 */
public class MessageService {

    public List<message> query(String command, String description){
        MessageDao messageDao = new MessageDao();
        return messageDao.query(command,description);
    }


}
