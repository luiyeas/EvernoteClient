package lnavarro.com.evernoteclient.modules.splash.domain.interactors;

import lnavarro.com.evernoteclient.common.interactors.Interactor;

/**
 * Created by luis on 29/10/17.
 */

public interface SplashInteractor extends Interactor {
    interface Callback {
        void onFinishCountFakeCountDown();
    }
}
