package com.kammvp.interactor.impl;

import com.kammvp.interactor.LoginInteractor;
import com.kammvp.utils.InputUtils;

import javax.inject.Inject;

public final class LoginInteractorImpl implements LoginInteractor {
    @Inject
    public LoginInteractorImpl() {

    }

    @Override
    public boolean verifyUserName(String name) {
        return InputUtils.verifyUserName(name);
    }

    @Override
    public boolean verifyPassword(String password) {
        return InputUtils.verifyPassword(password);
    }
}