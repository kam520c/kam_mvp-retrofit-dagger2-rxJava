package com.kammvp.view;

import android.support.annotation.UiThread;

@UiThread
public interface LoginView {
    void showErrorMsg();
    void loginSuccess();
    void showText();
}