package com.kammvp.injection;

import com.kammvp.model.User;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kam on 16/12/22.
 */
@Module
public class UserModule {
    @Provides
    public User provideUser(){
        User user = new User();
        user.setUserId("123");
        user.setUserName("kam");
        user.setPassword("123456");
        return user;
    }
}
