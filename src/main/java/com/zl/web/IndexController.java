package com.zl.web;
 
import java.util.List;

import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 

import com.google.common.collect.ImmutableMap;
import com.zl.pojo.User;
import com.zl.service.UserService;
 
/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/9/21.
 */
@RestController
public class IndexController {
 
    @Autowired
    private UserService userService;
 
    @GetMapping("/users")
    @ResponseBody
    public List<User> users() {
        return userService.list();
    }
 
    @GetMapping("/user/{id}")
    @ResponseBody
    public User findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }
    
    @GetMapping("/upuser/{id}")
    @ResponseBody
    public User upuser(@PathVariable("id") Long id) {
    	return userService.upuser(id);
    }
 
    @GetMapping("/info/{id}")
    @ResponseBody
    public User findInfoById(@PathVariable("id") Long id) {
        return userService.findInfoById(id);
    }
 
    @GetMapping("/user/{id}/{name}")
    @ResponseBody
    public Map update(@PathVariable("id") Long id, @PathVariable("name") String name) {
        User user = userService.findUserById(id);
        user.setName(name);
        userService.update(user);
        return ImmutableMap.of("ret", 0, "msg", "ok");
    }
 
 
}
