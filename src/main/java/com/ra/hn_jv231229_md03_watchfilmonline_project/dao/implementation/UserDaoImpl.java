package com.ra.hn_jv231229_md03_watchfilmonline_project.dao.implementation;

import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.IUserDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao
{
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public User authenticate(String username, String password) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from User where userName = :username and password = :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (User) query.uniqueResult();
    }

    @Override
    @Transactional
    public void register(User user) {
        Session session = this.sessionFactory.openSession();
        session.save(user);
    }

    @Override
    public User findById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.find(User.class,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        try {
            List list = session.createQuery("from  User ").list();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }


}
