package com.zwy.restful.controller;

import com.zwy.restful.bean.UserBean;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@RestController
public class UserController {
    private Map<Integer, UserBean> map = new HashMap<>();

    //增加一个用户
    @PostMapping("/users")
    public Map<Integer, UserBean> insert(UserBean user) {
        map.put(map.size() + 1, user);
        Set<Integer> keySet = map.keySet();
        keySet.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("key:" + integer + " " + user);
            }
        });
        return map;
    }

    //删除一个指定用户
    @DeleteMapping("/users/{id}")
    public Map<Integer, UserBean> delete(@PathVariable int id) {
        if (map.containsKey(id))
            map.remove(id);
        return map;
    }

    //修改一个指定用户
    @PutMapping("/users/{id}")
    public Map<Integer, UserBean> update(@PathVariable int id, UserBean user) {
        map.put(id, user);
        return map;
    }

    //查询所有用户
    @GetMapping("/users")
    public Map<Integer, UserBean> queryAll() {
        return map;
    }

    //查询指定用户
    @GetMapping("/users/{id}")
    public UserBean queryOne(@PathVariable int id) {
        return map.get(id);
    }
}
