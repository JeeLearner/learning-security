package com.learn.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.learn.validator.MyConstraint;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

public class User {

    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};

    @JsonView(UserSimpleView.class)
    @MyConstraint(message = "测试自定义注解")
    private String username;

    @JsonView(UserDetailView.class)
    @NotBlank
    private String password;

    private String id;
    @Past(message = "{message}")
    private Date birthday;

    /** getter/setter **/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
