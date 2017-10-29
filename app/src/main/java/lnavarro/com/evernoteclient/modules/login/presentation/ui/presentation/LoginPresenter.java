package lnavarro.com.evernoteclient.modules.login.presentation.ui.presentation;

import android.app.Activity;

import lnavarro.com.evernoteclient.common.presenter.AbstractPresenter;

/**
 * Created by luis on 29/10/17.
 */

public interface LoginPresenter {
    public void onLoginSuccess();

    public void onLoginError();
}
