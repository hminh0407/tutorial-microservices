package com.tutorial.rest.dao;

import com.tutorial.rest.domain.User;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.tutorial.rest.jooq.tables.Roles.ROLES;
import static com.tutorial.rest.jooq.tables.Users.USERS;

@Repository
public class UserDaoJooqImpl implements UserDao {

    private DSLContext dsl;

    @Autowired
    public UserDaoJooqImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<User> search() {
        return dsl.select(USERS.USER_NAME, USERS.EMAIL, ROLES.ROLE_NAME)
                .from(USERS
                        .join(ROLES).on(USERS.USER_ID.eq(ROLES.USER_ID)))
                .fetch()
                .into(User.class);
    }

}
