package lnavarro.com.evernoteclient.modules.splash.presentation.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lnavarro.com.evernoteclient.R;
import lnavarro.com.evernoteclient.modules.splash.presentation.presenter.SplashPresenter;
import lnavarro.com.evernoteclient.modules.splash.presentation.presenter.implementation.SplashPresenterImpl;

public class SplashActivity extends AppCompatActivity implements SplashPresenter.View{

    private SplashPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPresenter = new SplashPresenterImpl(this, this);
        mPresenter.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

    @Override
    public void jumoToLoginActivity() {
        mPresenter.navigateToLoginActivity(this);
    }
}
