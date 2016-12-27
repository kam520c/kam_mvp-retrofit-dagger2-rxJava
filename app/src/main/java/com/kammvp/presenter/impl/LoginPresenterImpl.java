package com.kammvp.presenter.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.kammvp.interactor.LoginInteractor;
import com.kammvp.model.User;
import com.kammvp.presenter.LoginPresenter;
import com.kammvp.view.LoginView;

import javax.inject.Inject;

public final class LoginPresenterImpl extends LoginPresenter {
    /**
     * The view
     */
    @NonNull
    private final LoginView mView;
    /**
     * The interactor
     */
    @NonNull
    private final LoginInteractor mInteractor;

    @NonNull
    private User user;

    @Inject
    public LoginPresenterImpl(@NonNull LoginView view, @NonNull LoginInteractor interactor, @NonNull User user) {
        mView = view;
        mInteractor = interactor;
        this.user = user;
    }

    @Override
    public void onRestoreState(@NonNull Bundle savedInstanceState) {

    }

    @Override
    public void onStart(boolean firstStart) {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

    }

    @Override
    public void loginUser(String name, String psd) {
        Log.e("==name=", "click loginUser");
        if (mInteractor.verifyUserName(name) && mInteractor.verifyPassword(psd)) {
            mView.loginSuccess();
        } else {
            mView.showErrorMsg();
        }
    }
}