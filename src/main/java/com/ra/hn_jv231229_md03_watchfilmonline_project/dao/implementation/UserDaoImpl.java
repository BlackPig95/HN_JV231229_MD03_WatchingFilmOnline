package com.ra.hn_jv231229_md03_watchfilmonline_project.dao.implementation;

import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.IUserDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.constant.UserRole;
<<<<<<< HEAD
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.UserDTO;
=======
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.UserDTO;
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.mapper.UserMapper;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserFilterRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserUpdateRoleRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserUpdateStatusRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.util.Page;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
import org.springframework.transaction.annotation.Transactional;
=======

import org.springframework.transaction.annotation.Transactional;

>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDaoImpl implements IUserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public User authenticate(String username, String password)
    {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("from User where username = :username and password = :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.uniqueResult();
<<<<<<< HEAD
    }

    @Override
    @Transactional
    public List<User> getAll() {
        Session session = this.sessionFactory.openSession();
        CriteriaQuery<User> cq = session.getCriteriaBuilder().createQuery(User.class);
        cq.select(cq.from(User.class));
        return session.createQuery(cq).getResultList();
=======
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
    }

    @Override
    @Transactional
    public List<User> getAll()
    {
        Session session = this.sessionFactory.openSession();
        CriteriaQuery<User> cq = session.getCriteriaBuilder().createQuery(User.class);
        cq.select(cq.from(User.class));
        return session.createQuery(cq).getResultList();
    }

    @Override
    @Transactional
    public void register(User user)
    {
        Session session = this.sessionFactory.openSession();
        session.save(user);
    }

    @Override
<<<<<<< HEAD
    @Transactional
    public Page<UserDTO> getAllByFilter(UserFilterRequest filterRequest, int page, int size) {
        try (Session session = sessionFactory.openSession()) {
=======

    @Transactional
    public Page<UserDTO> getAllByFilter(UserFilterRequest filterRequest, int page, int size)
    {
        try (Session session = sessionFactory.openSession())
        {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);

            List<Predicate> predicates = new ArrayList<>();

<<<<<<< HEAD
            if (filterRequest.getUsername() != null && !filterRequest.getUsername().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("username"), "%" + filterRequest.getUsername() + "%"));
            }
            if (filterRequest.getStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), filterRequest.getStatus()));
            }
            if (filterRequest.getEmail() != null && !filterRequest.getEmail().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("email"), "%" + filterRequest.getEmail() + "%"));
            }
            if (filterRequest.getPhone() != null && !filterRequest.getPhone().isEmpty()) {
=======
            if (filterRequest.getUsername() != null && !filterRequest.getUsername().isEmpty())
            {
                predicates.add(criteriaBuilder.like(root.get("username"), "%" + filterRequest.getUsername() + "%"));
            }
            if (filterRequest.getStatus() != null)
            {
                predicates.add(criteriaBuilder.equal(root.get("status"), filterRequest.getStatus()));
            }
            if (filterRequest.getEmail() != null && !filterRequest.getEmail().isEmpty())
            {
                predicates.add(criteriaBuilder.like(root.get("email"), "%" + filterRequest.getEmail() + "%"));
            }
            if (filterRequest.getPhone() != null && !filterRequest.getPhone().isEmpty())
            {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
                predicates.add(criteriaBuilder.like(root.get("phone"), "%" + filterRequest.getPhone() + "%"));
            }

            criteriaQuery.where(predicates.toArray(new Predicate[0]));

            Query<User> query = session.createQuery(criteriaQuery);
            query.setFirstResult(page * size);
            query.setMaxResults(size);

            List<User> users = query.getResultList();
            List<UserDTO> userDTOs = users.stream()
                    .map(UserMapper::toUserDTO)
                    .collect(Collectors.toList());
            System.out.println(userDTOs);
            long totalCount = getTotalCount(session, criteriaQuery);
            return new Page<>(userDTOs, page, size, totalCount);
<<<<<<< HEAD
        } catch (Exception e) {
=======
        } catch (Exception e)
        {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
<<<<<<< HEAD
    public void updateStatus(UserUpdateStatusRequest request) {
        String hql = "UPDATE User u SET u.status = :newStatus WHERE u.id = :userId";
        Session session = this.sessionFactory.openSession();
        try {
=======
    public void updateStatus(UserUpdateStatusRequest request)
    {
        String hql = "UPDATE User u SET u.status = :newStatus WHERE u.id = :userId";
        Session session = this.sessionFactory.openSession();
        try
        {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
            session.beginTransaction();
            int updatedEntities = session.createQuery(hql)
                    .setParameter("newStatus", request.getNewStatus())
                    .setParameter("userId", request.getUserId())
                    .executeUpdate();
<<<<<<< HEAD
            if (updatedEntities == 0) {
=======
            if (updatedEntities == 0)
            {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
                System.out.println(("ERROR"));
            }
            session.getTransaction().commit();

<<<<<<< HEAD
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
             session.close();
=======
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        } finally
        {
            session.close();
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
        }
    }

    @Override
    @Transactional
<<<<<<< HEAD
    public void updateRole(UserUpdateRoleRequest request) {
        String hql = "UPDATE User u SET u.userRole = :newRole WHERE u.id = :userId";
        Session session = this.sessionFactory.openSession();
        try {
=======
    public void updateRole(UserUpdateRoleRequest request)
    {
        String hql = "UPDATE User u SET u.userRole = :newRole WHERE u.id = :userId";
        Session session = this.sessionFactory.openSession();
        try
        {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
            session.beginTransaction();
            int updatedEntities = session.createQuery(hql)
                    .setParameter("newRole", UserRole.valueOf(request.getNewRole()))
                    .setParameter("userId", request.getUserId())
                    .executeUpdate();
<<<<<<< HEAD
            if (updatedEntities == 0) {
                System.out.println(("ERROR"));
            }
            session.getTransaction().commit();
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
=======
            if (updatedEntities == 0)
            {
                System.out.println(("ERROR"));
            }
            session.getTransaction().commit();
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public User findById(Long id)
    {
        Session session = sessionFactory.openSession();
        try
        {
            return session.find(User.class, id);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        } finally
        {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
            session.close();
        }
    }

<<<<<<< HEAD
    private long getTotalCount(Session session, CriteriaQuery<User> criteriaQuery) {
=======
    private long getTotalCount(Session session, CriteriaQuery<User> criteriaQuery)
    {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.select(criteriaBuilder.count(countQuery.from(User.class)));
        countQuery.where(criteriaQuery.getRestriction());
        return session.createQuery(countQuery).getSingleResult();
    }
<<<<<<< HEAD
=======

    @Override
    public List<User> getAllUsers()
    {
        Session session = sessionFactory.openSession();
        try
        {
            List list = session.createQuery("from  User ").list();
            return list;
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            session.close();
        }
        return null;
    }

    @Override
    public void update(User user)
    {
        Session session = this.sessionFactory.openSession();
        try
        {
            session.getTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally
        {
            session.close();
        }

    }

>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
}

