package com.kammvp.injection;

import android.support.annotation.NonNull;

import com.kammvp.interactor.MainInteractor;
import com.kammvp.interactor.impl.MainInteractorImpl;
import com.kammvp.model.User;
import com.kammvp.presenter.MainPresenter;
import com.kammvp.view.MainView;

import dagger.Module;
import dagger.Provides;

@Module
public final class MainViewModule {
    /**
     * Stored view
     */
    private final MainView mView;

    public MainViewModule(@NonNull MainView view) {
        mView = view;
    }

    @Provides
    public MainView provideView() {
        return mView;
    }

    @Provides
    public MainInteractor provideInteractor() {
        return new MainInteractorImpl();
    }

    @Provides
    public MainPresenter providePresenter(@NonNull MainView view, @NonNull MainInteractor interactor, User user) {
        return new MainPresenter(view, interactor, user);
    }


}
