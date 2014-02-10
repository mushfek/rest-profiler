package net.therap.dao;

import net.therap.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Mushfekur Rahman
 * @since 09/02/2013
 */

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User getUser(String name) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE :name IN u.name", User.class)
                .setParameter("name", name);

        List<User> userList = query.getResultList();
        return userList.isEmpty()? null : userList.get(0);
    }
}
