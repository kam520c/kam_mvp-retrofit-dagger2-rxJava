package com.kammvp.injection;

import android.content.Context;
import android.support.annotation.NonNull;

import com.kammvp.BaseApplication;

import dagger.Module;
import dagger.Provides;

@Module
public final class AppModule {
    @NonNull
    private final BaseApplication mApp;

    public AppModule(@NonNull BaseApplication app) {
        mApp = app;
    }

    @Provides
    public Context provideAppContext() {
        return mApp;
    }

    @Provides
    public BaseApplication provideApp() {
        return mApp;
    }

}
