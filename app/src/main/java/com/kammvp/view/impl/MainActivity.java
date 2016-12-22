package com.kammvp.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kammvp.R;
import com.kammvp.injection.AppComponent;
import com.kammvp.injection.DaggerMainViewComponent;
import com.kammvp.injection.MainViewModule;
import com.kammvp.presenter.BasePresenter;
import com.kammvp.presenter.MainPresenter;
import com.kammvp.view.MainView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public final class MainActivity extends BaseActivity implements MainView, View.OnClickListener {
    @Inject
    MainPresenter mPresenter;

    @InjectView(R.id.btnSayHello)
    Button btnSayHello;

    @InjectView(R.id.tvHello)
    TextView tvHello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        btnSayHello.setOnClickListener(this);
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerMainViewComponent.builder()
                .appComponent(parentComponent)
                .mainViewModule(new MainViewModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected BasePresenter getBasePresenter() {
        return mPresenter;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSayHello:
                if (tvHello.getVisibility() == View.GONE) {
                    tvHello.setVisibility(View.VISIBLE);
                } else {
                    tvHello.setVisibility(View.GONE);
                }
                break;
        }
    }

    @Override
    public void setTextView(String userName) {
        tvHello.setText("hello " + userName);
        tvHello.setVisibility(View.VISIBLE);
    }
}
