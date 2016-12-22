package com.kammvp;

import android.app.Application;
import android.support.annotation.NonNull;

import com.kammvp.injection.AppComponent;
import com.kammvp.injection.AppModule;
import com.kammvp.injection.DaggerAppComponent;
import com.kammvp.injection.UserModule;

public final class BaseApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .userModule(new UserModule())
                .build();
    }

    @NonNull
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}