package lnavarro.com.evernoteclient.common.interactors;


import android.content.Context;


public abstract class AbstractInteractor implements Interactor {

    protected Context mContext;

    public AbstractInteractor(Context context) {
        mContext = context;
    }


}
