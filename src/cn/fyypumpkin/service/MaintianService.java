package cn.fyypumpkin.service;

import cn.fyypumpkin.dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * 维护业务的功能
 * Created by fyy on 4/9/17.
 */
public class MaintianService {

    public void deleteOne(String id) {
        if (id != null && !"".equals(id)) {
            MessageDao messageDao = new MessageDao();
            messageDao.deleteOne(Integer.valueOf(id));
        }
    }

    public void deleteBatch(String[] ids){
        MessageDao messageDao = new MessageDao();
        List list = new ArrayList();
        for(String id : ids){
            list.add(id);
        }
        messageDao.deleteBatch(list);
    }
}
