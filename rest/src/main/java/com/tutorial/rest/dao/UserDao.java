package com.tutorial.rest.dao;

import com.tutorial.rest.domain.User;

import java.util.List;

public interface UserDao {
    List<User> search();
}
