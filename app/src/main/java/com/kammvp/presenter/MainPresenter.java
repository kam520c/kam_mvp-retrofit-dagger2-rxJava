package com.kammvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.kammvp.interactor.MainInteractor;
import com.kammvp.model.User;
import com.kammvp.view.MainView;

import javax.inject.Inject;

public final class MainPresenter implements BasePresenter {
    /**
     * The view
     */
    @NonNull
    private final MainView mView;
    /**
     * The interactor
     */
    @NonNull
    private final MainInteractor mInteractor;

    @NonNull
    private final User user;

    @Inject
    public MainPresenter(@NonNull MainView view, @NonNull MainInteractor interactor, @NonNull User user) {
        mView = view;
        mInteractor = interactor;
        this.user = user;
    }

    @Override
    public void onRestoreState(@NonNull Bundle savedInstanceState) {

    }

    @Override
    public void onStart(boolean firstStart) {
        showUserName();
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

    }

    public void showUserName(){
        mView.setTextView(user.getUserName());
    }
}