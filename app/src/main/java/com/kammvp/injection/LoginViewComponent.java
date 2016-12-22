package com.kammvp.injection;

import com.kammvp.view.impl.LoginActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {LoginViewModule.class})
public interface LoginViewComponent {
    void inject(LoginActivity activity);
}