package lnavarro.com.evernoteclient.common.interactors;


/**
 * This is the main interface of an interactor. Each interactor serves a specific use case.
 */
public interface Interactor {

    /**
     * This is the main method that starts an interactor. It will make sure that the interactor operation is done on a
     * background thread using RxJava.
     */
    void run();

    void removeCallbacks();

    void destroy();


}
