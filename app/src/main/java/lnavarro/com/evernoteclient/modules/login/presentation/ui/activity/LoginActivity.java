package lnavarro.com.evernoteclient.modules.login.presentation.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.evernote.client.android.EvernoteSession;

import lnavarro.com.evernoteclient.modules.login.presentation.ui.presentation.implementation.LoginPresenterImpl;

/**
 * Created by luis on 29/10/17.
 */

public class LoginActivity extends Activity {

    private LoginPresenterImpl mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new LoginPresenterImpl(this);
        mPresenter.init();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case EvernoteSession.REQUEST_CODE_LOGIN:
                if (resultCode == Activity.RESULT_OK) {
                    // handle success
                    mPresenter.onLoginSuccess();
                } else {
                    // handle failure
                    mPresenter.onLoginError();
                }
                break;

            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }
}
