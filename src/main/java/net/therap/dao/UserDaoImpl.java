package net.therap.dao;

import net.therap.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author Mushfekur Rahman
 */

public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User getUser(String name, String password) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.name = :name " +
                "AND u.password = :password", User.class)
                .setParameter("name", name)
                .setParameter("password", password);

        return query.getResultList().get(0);
    }
}
