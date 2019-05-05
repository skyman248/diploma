package com.university.contractors.controller.payload;

import com.university.contractors.controller.dto.SignUpUserDto;

public final class SignUpUserBuilder {
    private SignUpUserDto signUpUser;

    private SignUpUserBuilder() {
        signUpUser = new SignUpUserDto();
    }

    public static SignUpUserBuilder aSignUpUser() {
        return new SignUpUserBuilder();
    }

    public SignUpUserBuilder username(String username) {
        signUpUser.setUsername(username);
        return this;
    }

    public SignUpUserBuilder password(String password) {
        signUpUser.setPassword(password);
        return this;
    }

    public SignUpUserBuilder confirmationPassword(String confirmationPassword) {
        signUpUser.setConfirmationPassword(confirmationPassword);
        return this;
    }

    public SignUpUserDto build() {
        return signUpUser;
    }
}
