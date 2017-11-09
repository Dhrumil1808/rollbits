package com.sjsu.rollbits.dao.interfaces.service;

import java.util.List;

import com.sjsu.rollbits.dao.interfaces.MessageDao;
import com.sjsu.rollbits.dao.interfaces.model.Message;
public class MessageService {

    private static MessageDao messageDao;
    public MessageService() {
        messageDao = new MessageDao();
    }
    public static void persist(Message entity) {
        messageDao.openCurrentSessionwithTransaction();
        messageDao.persist(entity);
        messageDao.closeCurrentSessionwithTransaction();
    }
    public static void update(Message entity) {
        messageDao.openCurrentSessionwithTransaction();
        messageDao.update(entity);
        messageDao.closeCurrentSessionwithTransaction();
    }

    public static Message findById(int id) {
        messageDao.openCurrentSession();
        Message message = messageDao.findById(id);
        messageDao.closeCurrentSession();
        return message;
    }
    public static void delete(int id) {
        messageDao.openCurrentSessionwithTransaction();
        Message message = messageDao.findById(id);
        messageDao.delete(message);
        messageDao.closeCurrentSessionwithTransaction();
    }

    public static List<Message> findAll() {
        messageDao.openCurrentSession();
        List<Message> messages = messageDao.findAll();
        messageDao.closeCurrentSession();
        return messages;
    }
    public static void deleteAll() {
        messageDao.openCurrentSessionwithTransaction();
        messageDao.deleteAll();
        messageDao.closeCurrentSessionwithTransaction();
    }
    public MessageDao MessageDao() {
        return messageDao;

    }

}