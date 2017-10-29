package lnavarro.com.evernoteclient.modules.login.domain.interactors.implementation;

import android.content.Context;

import lnavarro.com.evernoteclient.common.interactors.AbstractInteractor;
import lnavarro.com.evernoteclient.modules.evernotewrapper.domain.repository.EvernoteRepository;
import lnavarro.com.evernoteclient.modules.login.presentation.ui.activity.LoginActivity;

/**
 * Created by luis on 29/10/17.
 */

public class LoginInteractorImpl extends AbstractInteractor {

    private Context mContext;

    public LoginInteractorImpl(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public void run() {
        EvernoteRepository.getInstance(mContext).login((LoginActivity) mContext);
    }

    @Override
    public void removeCallbacks() {

    }

    @Override
    public void destroy() {

    }

    public boolean isLoggedIn() {
        return EvernoteRepository.getInstance(mContext).isLoggedIn();
    }
}
