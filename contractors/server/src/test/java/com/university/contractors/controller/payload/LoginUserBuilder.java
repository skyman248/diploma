package com.university.contractors.controller.payload;

import com.university.contractors.controller.dto.LoginUser;

public final class LoginUserBuilder {
    private LoginUser loginUser;

    private LoginUserBuilder() {
        loginUser = new LoginUser();
    }

    public static LoginUserBuilder aLoginUser() {
        return new LoginUserBuilder();
    }

    public LoginUserBuilder username(String username) {
        loginUser.setUsername(username);
        return this;
    }

    public LoginUserBuilder password(String password) {
        loginUser.setPassword(password);
        return this;
    }

    public LoginUser build() {
        return loginUser;
    }
}
