package com.tutorial.rest.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    @NonNull
    private String userName;

    @NonNull
    private String email;

    @NonNull
    private String roleName;

}
