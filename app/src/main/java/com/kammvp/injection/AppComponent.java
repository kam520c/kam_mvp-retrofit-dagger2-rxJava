package com.kammvp.injection;

import android.content.Context;

import com.kammvp.BaseApplication;
import com.kammvp.model.User;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class,UserModule.class})
public interface AppComponent {
    Context getAppContext();

    BaseApplication getApp();

    User getUser();
}