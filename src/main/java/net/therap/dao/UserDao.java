package net.therap.dao;

import net.therap.domain.User;

/**
 * @author Mushfekur Rahman
 */

public interface UserDao {
    User getUser(String name, String password);
}
