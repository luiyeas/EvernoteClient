package lnavarro.com.evernoteclient.modules.splash.presentation.presenter.implementation;

import android.app.Activity;
import android.content.Context;

import lnavarro.com.evernoteclient.common.navigator.EvernoteNavigator;
import lnavarro.com.evernoteclient.common.presenter.AbstractPresenter;
import lnavarro.com.evernoteclient.modules.splash.domain.interactors.SplashInteractor;
import lnavarro.com.evernoteclient.modules.splash.domain.interactors.implementation.SplashInteractorImpl;
import lnavarro.com.evernoteclient.modules.splash.presentation.presenter.SplashPresenter;

/**
 * Created by luis on 29/10/17.
 */

public class SplashPresenterImpl extends AbstractPresenter implements SplashInteractor.Callback {

    private Context mContext;
    private SplashInteractorImpl mInteractor;
    private SplashPresenter.View mView;

    public SplashPresenterImpl(Context context, SplashPresenter.View view) {
        super(context);
        this.mContext = context;
        this.mView = view;
        this.mInteractor = new SplashInteractorImpl(context, this);
    }

    @Override
    public void init() {
        super.init();
        mInteractor.run();
    }

    public void destroy() {
        mInteractor.destroy();
        mView = null;
    }

    @Override
    public void onFinishCountFakeCountDown() {
        mView.jumoToLoginActivity();
    }

    public void navigateToLoginActivity(Activity activity) {
        EvernoteNavigator.navigateToLoginActivity(activity);
    }
}
