package com.university.contractors.controller.payload;

import com.university.contractors.controller.dto.SignInUserDto;

public final class LoginUserBuilder {
    private SignInUserDto loginUser;

    private LoginUserBuilder() {
        loginUser = new SignInUserDto();
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

    public SignInUserDto build() {
        return loginUser;
    }
}
