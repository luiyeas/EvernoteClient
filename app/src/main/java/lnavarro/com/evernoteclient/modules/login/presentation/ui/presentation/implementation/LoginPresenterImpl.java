package lnavarro.com.evernoteclient.modules.login.presentation.ui.presentation.implementation;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.evernote.client.android.EvernoteSession;

import lnavarro.com.evernoteclient.R;
import lnavarro.com.evernoteclient.common.navigator.EvernoteNavigator;
import lnavarro.com.evernoteclient.common.presenter.AbstractPresenter;
import lnavarro.com.evernoteclient.modules.evernotewrapper.domain.repository.EvernoteRepository;
import lnavarro.com.evernoteclient.modules.login.domain.interactors.implementation.LoginInteractorImpl;
import lnavarro.com.evernoteclient.modules.login.presentation.ui.activity.LoginActivity;
import lnavarro.com.evernoteclient.modules.login.presentation.ui.presentation.LoginPresenter;

/**
 * Created by luis on 29/10/17.
 */

public class LoginPresenterImpl extends AbstractPresenter implements LoginPresenter {

    private Context mContext;
    private LoginInteractorImpl mInteractor;

    public LoginPresenterImpl(Context context) {
        super(context);
        mContext = context;
        this.mInteractor = new LoginInteractorImpl(context);
    }

    public void init() {
        if (mInteractor.isLoggedIn()) {
            onLoginSuccess();
        } else {
            mInteractor.run();
        }
    }

    public void destroy() {
        mInteractor.destroy();
    }


    @Override
    public void onLoginSuccess() {
        EvernoteNavigator.navigateToNotesListActivity((LoginActivity) mContext);
    }

    @Override
    public void onLoginError() {
        Toast.makeText(mContext, mContext.getString(R.string.error_text), Toast.LENGTH_SHORT).show();
    }
}
