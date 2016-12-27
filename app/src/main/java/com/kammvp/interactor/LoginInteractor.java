package com.kammvp.interactor;

public interface LoginInteractor extends BaseInteractor {
    boolean verifyUserName(String name);

    boolean verifyPassword(String password);
}