package net.therap.controller;

import net.therap.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Mushfekur Rahman
 * @since 10/02/2013
 */

@Controller
@RequestMapping("api")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("user/{name}")
    @ResponseBody
    public String getCurrentMailFromUrl(@PathVariable String name) {
        return userDao.getUser(name).getCurrentMail();
    }

    /**
     * works same as the above method but is mapped to
     * /api/user?name= rather than /api/user/{name}
     */
    @RequestMapping(value = "user", params = "name")
    @ResponseBody
    public String getCurrentMailFromParam(@RequestParam("name") String name) {
        return userDao.getUser(name).getCurrentMail();
    }
}
