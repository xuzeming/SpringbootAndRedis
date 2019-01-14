package com.zl.service.impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zl.pojo.Info;
import com.zl.pojo.User;
import com.zl.service.UserService;

import lombok.extern.slf4j.Slf4j;
 
/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/9/21.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
 
    private Map<Long, User> userMap = new HashMap<>();
    private Map<Long, Info> infoMap = new HashMap<>();
 
    public UserServiceImpl() {
    	User u1=new User();
    	u1.setId(1L);
    	u1.setName("1111");
    	u1.setPassword("11223434");
    	User u2=new User();
    	u2.setId(1L);
    	u2.setName("1111");
    	u2.setPassword("11223434");
    	User u3=new User();
    	u3.setId(1L);
    	u3.setName("1111");
    	u3.setPassword("11223434");
    	
        userMap.put(1L,u1);
        userMap.put(2L,u2);
        userMap.put(3L,u3);
        infoMap.put(1L, new Info("18559198715", "福州市"));
    }
 
    @Override
    public List list() {
        return Arrays.asList(userMap.values().toArray());
    }
 
    @Override
    @Cacheable(value = "user", key = "'user'.concat(#id.toString())")
    public User findUserById(Long id) {
        //log.info("findUserById query from db, id: {}", id);
    	System.out.println("findUserById query from db, id: {}======"+id);
        return userMap.get(id);
    }
 
    @Override
    @Cacheable(value = "info", key = "'info'.concat(#id.toString())")
    public User findInfoById(Long id) {
       // log.info("findInfoById query from db, id: {}", id);
    	System.out.println("findUserById query from db, id: {}======"+id);
        return userMap.get(id);
    }
 
    @Override
    @CachePut(value = "user", key = "'user'.concat(#user.id.toString())")
    public void update(User user) {
        //log.info("update db, user: {}", user.toString());
    	System.out.println("findUserById query from db, id: {}======");
        userMap.put(user.getId(), user);
    }
 
    @Override
    @CacheEvict(value = "user", key = "'user'.concat(#id.toString())")
    public void remove(Long id) {
        //log.info("remove from db, id: {}", id);
    	System.out.println("findUserById query from db, id: {}======");
        userMap.remove(id);
    }
 
	@Override
	@CacheEvict(value = "user", key = "'user'.concat(#id.toString())")
	public User upuser(Long id) {
		User d= userMap.get(id);
		d.setName("000000000000000000000000000000000000000000000000");
		return d;
	}
	
}
