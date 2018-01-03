package com.learn.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.learn.dto.User;
import com.learn.dto.UserQueryCondition;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

   /* @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> query(@RequestParam String username){

        System.out.println(username);
        List<User> userList = new ArrayList<User>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        return userList;
    }*/

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition,@PageableDefault(page = 2, size = 17, sort = "username, asc") Pageable pageable){
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());

        List<User> userList = new ArrayList<User>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        return userList;
    }

    @RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.GET)
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable("id") String id){
        User user = new User();
        user.setUsername("tom");
        return user;
    }

}
