package com.kammvp.injection;

import android.support.annotation.NonNull;

import com.kammvp.interactor.LoginInteractor;
import com.kammvp.interactor.impl.LoginInteractorImpl;
import com.kammvp.model.User;
import com.kammvp.presenter.impl.LoginPresenterImpl;
import com.kammvp.view.LoginView;

import dagger.Module;
import dagger.Provides;

@Module
public final class LoginViewModule {
    /**
     * Stored view
     */
    private final LoginView mView;

    public LoginViewModule(@NonNull LoginView view) {
        mView = view;
    }

    @Provides
    public LoginView provideView() {
        return mView;
    }

    @Provides
    public LoginInteractor provideInteractor() {
        return new LoginInteractorImpl();
    }

    @Provides
    public LoginPresenterImpl providePresenter(@NonNull LoginView view, @NonNull LoginInteractor interactor,User user) {
        return new LoginPresenterImpl(view, interactor,user);
    }
}
