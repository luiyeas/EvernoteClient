package lnavarro.com.evernoteclient.modules.splash.domain.interactors.implementation;

import android.content.Context;
import android.os.Handler;

import lnavarro.com.evernoteclient.common.interactors.AbstractInteractor;
import lnavarro.com.evernoteclient.modules.splash.domain.interactors.SplashInteractor;

/**
 * Created by luis on 29/10/17.
 */

public class SplashInteractorImpl extends AbstractInteractor {

    private Handler mHandler;
    private SplashInteractor.Callback mCallback;

    public SplashInteractorImpl(Context context, SplashInteractor.Callback callback) {
        super(context);
        mCallback = callback;
        mHandler = new Handler();
    }

    @Override
    public void run() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mCallback != null){
                    mCallback.onFinishCountFakeCountDown();
                }
            }
        }, 2 * 1000);
    }

    @Override
    public void removeCallbacks() {
        mCallback = null;
    }

    @Override
    public void destroy() {
        removeCallbacks();
        mHandler = null;
    }
}
