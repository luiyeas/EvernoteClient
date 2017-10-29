package lnavarro.com.evernoteclient.common.navigator;

import android.app.Activity;
import android.content.Intent;

import lnavarro.com.evernoteclient.modules.login.presentation.ui.activity.LoginActivity;
import lnavarro.com.evernoteclient.modules.notes.presentation.ui.activity.NoteListActivity;

/**
 * Created by luis on 29/10/17.
 */

public class EvernoteNavigator {

    public static void navigateToLoginActivity(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent(activity, LoginActivity.class);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    public static void navigateToNotesListActivity(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent(activity, NoteListActivity.class);
            activity.startActivity(intent);
            activity.finish();
        }
    }
}
