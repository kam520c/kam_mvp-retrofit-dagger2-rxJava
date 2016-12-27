package com.kammvp.view.impl;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.EditText;
import android.widget.Toast;

import com.kammvp.R;
import com.kammvp.databinding.ActivityLoginBinding;
import com.kammvp.injection.AppComponent;
import com.kammvp.injection.DaggerLoginViewComponent;
import com.kammvp.injection.LoginViewModule;
import com.kammvp.model.User;
import com.kammvp.presenter.BasePresenter;
import com.kammvp.presenter.impl.LoginPresenterImpl;
import com.kammvp.view.LoginView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public final class LoginActivity extends BaseActivity implements LoginView {
    @Inject
    LoginPresenterImpl mPresenter;

    @InjectView(R.id.ed_login_name)
    EditText edLoginName;
//    @InjectView(R.id.ed_login_password)
//    EditText edLoginPassword;
//    @InjectView(R.id.btn_login_login)
//    Button btnLoginLogin;
//    @InjectView(R.id.btn_login_sendCode)
//    Button btnLoginSendCode;

    ActivityLoginBinding mLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginBinding= DataBindingUtil.setContentView(this,R.layout.activity_login);
        mLoginBinding.setPresenter(mPresenter);
        User user=new User();
        user.setUserName("kam");
        mLoginBinding.setUserModel(user);
        ButterKnife.inject(this);
//        btnLoginLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mPresenter.loginUser(edLoginName.getText().toString(), edLoginPassword.getText().toString());
//            }
//        });
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerLoginViewComponent.builder()
                .appComponent(parentComponent)
                .loginViewModule(new LoginViewModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected BasePresenter getBasePresenter() {
        return mPresenter;
    }

    @Override
    public void showErrorMsg() {
        Toast.makeText(this, R.string.login_password_worng, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this, R.string.login_success, Toast.LENGTH_LONG).show();
    }

}
