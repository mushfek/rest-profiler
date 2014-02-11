package net.therap.controller;

import net.therap.dao.UserDao;
import net.therap.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mushfekur Rahman
 * @since 10/02/2013
 */

@Controller
@RequestMapping("api")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello, take a little REST ;)");
        return "hello";
    }

    @ResponseBody
    @RequestMapping("{username}")
    public User getCurrentUser(@PathVariable String username) {
        return userDao.getUser(username);
    }

    @ResponseBody
    @RequestMapping("user/{name}")
    public String getCurrentMailFromUrl(@PathVariable String name) {
        return userDao.getUser(name).getCurrentMail();
    }

    /**
     * works same as the above method but is mapped to
     * /api/user?name= rather than /api/user/{name}
     */
    @ResponseBody
    @RequestMapping(value = "user", params = "name")
    public String getCurrentMailFromParam(@RequestParam("name") String name) {
        return userDao.getUser(name).getCurrentMail();
    }
}
