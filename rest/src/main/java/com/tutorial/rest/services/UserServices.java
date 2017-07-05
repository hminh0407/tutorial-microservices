package com.tutorial.rest.services;

import com.tutorial.rest.dao.UserDao;
import com.tutorial.rest.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    private UserDao userDao;

    @Autowired
    public UserServices(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> search() {
        return userDao.search();
    }
}
