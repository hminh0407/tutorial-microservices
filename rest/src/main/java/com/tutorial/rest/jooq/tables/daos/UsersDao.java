/*
 * This file is generated by jOOQ.
*/
package com.tutorial.rest.jooq.tables.daos;


import com.tutorial.rest.jooq.tables.Users;
import com.tutorial.rest.jooq.tables.records.UsersRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersDao extends DAOImpl<UsersRecord, com.tutorial.rest.jooq.tables.pojos.Users, Long> {

    /**
     * Create a new UsersDao without any configuration
     */
    public UsersDao() {
        super(Users.USERS, com.tutorial.rest.jooq.tables.pojos.Users.class);
    }

    /**
     * Create a new UsersDao with an attached configuration
     */
    public UsersDao(Configuration configuration) {
        super(Users.USERS, com.tutorial.rest.jooq.tables.pojos.Users.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(com.tutorial.rest.jooq.tables.pojos.Users object) {
        return object.getUserId();
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<com.tutorial.rest.jooq.tables.pojos.Users> fetchByUserId(Long... values) {
        return fetch(Users.USERS.USER_ID, values);
    }

    /**
     * Fetch a unique record that has <code>user_id = value</code>
     */
    public com.tutorial.rest.jooq.tables.pojos.Users fetchOneByUserId(Long value) {
        return fetchOne(Users.USERS.USER_ID, value);
    }

    /**
     * Fetch records that have <code>user_name IN (values)</code>
     */
    public List<com.tutorial.rest.jooq.tables.pojos.Users> fetchByUserName(String... values) {
        return fetch(Users.USERS.USER_NAME, values);
    }

    /**
     * Fetch records that have <code>pass IN (values)</code>
     */
    public List<com.tutorial.rest.jooq.tables.pojos.Users> fetchByPass(String... values) {
        return fetch(Users.USERS.PASS, values);
    }

    /**
     * Fetch records that have <code>email IN (values)</code>
     */
    public List<com.tutorial.rest.jooq.tables.pojos.Users> fetchByEmail(String... values) {
        return fetch(Users.USERS.EMAIL, values);
    }

    /**
     * Fetch records that have <code>enabled IN (values)</code>
     */
    public List<com.tutorial.rest.jooq.tables.pojos.Users> fetchByEnabled(Short... values) {
        return fetch(Users.USERS.ENABLED, values);
    }
}
