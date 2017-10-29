package lnavarro.com.evernoteclient.common.presenter;

import android.content.Context;


public abstract class AbstractPresenter {

    protected Context mContext;

    public AbstractPresenter(Context context) {
        mContext = context;
    }

    /**
     * All methods for init views
     */
    public void init() {

    }

    /**
     * Provide method for detroy views
     */
    public void destroy() {

    }



}
