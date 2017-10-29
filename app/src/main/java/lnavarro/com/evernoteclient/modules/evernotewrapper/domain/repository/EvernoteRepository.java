package lnavarro.com.evernoteclient.modules.evernotewrapper.domain.repository;

import android.app.Activity;
import android.content.Context;

import com.evernote.client.android.EvernoteSession;
import com.evernote.client.android.asyncclient.EvernoteCallback;
import com.evernote.client.android.asyncclient.EvernoteNoteStoreClient;
import com.evernote.edam.notestore.NoteFilter;
import com.evernote.edam.notestore.NoteList;
import com.evernote.edam.type.NoteSortOrder;

import lnavarro.com.evernoteclient.modules.notes.domain.model.FilterBy;

/**
 * Created by luis on 29/10/17.
 */

public class EvernoteRepository {

    private static final String EVERNOTE_CONSUMER_KEY = "luiyeas-3285";
    private static final String EVERNOTE_CONSUMER_SECRET = "9e02374fa4779a29";
    private static final EvernoteSession.EvernoteService EVERNOTE_SERVICE = EvernoteSession.EvernoteService.SANDBOX;
    private int MAX = 50;


    private static EvernoteRepository sInstance;
    private Context mContext;
    private EvernoteSession mEvernoteSession;

    public static EvernoteRepository getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new EvernoteRepository();
            sInstance.mContext = context;
            sInstance.init();
        }
        return sInstance;
    }

    public boolean isLoggedIn() {
        return mEvernoteSession.isLoggedIn();
    }

    private void init() {
        mEvernoteSession = new EvernoteSession.Builder(mContext)
                .setEvernoteService(EVERNOTE_SERVICE)
                .setSupportAppLinkedNotebooks(true)
                .build(EVERNOTE_CONSUMER_KEY, EVERNOTE_CONSUMER_SECRET)
                .asSingleton();
    }

    public void login(Activity activity) {
        mEvernoteSession.authenticate(activity);
    }

    public void getNotes(EvernoteCallback<NoteList> callback, FilterBy filter) {
        if (mEvernoteSession.isLoggedIn()) {
            // Cast filter
            EvernoteNoteStoreClient noteStoreClient = EvernoteSession.getInstance().getEvernoteClientFactory().getNoteStoreClient();
            noteStoreClient.findNotesAsync(convertFilter(filter), 0, MAX, callback);
        }
    }

    private NoteFilter convertFilter(FilterBy filter) {
        NoteFilter noteFilter = new NoteFilter();
        if (filter.getFilter() == FilterBy.Filter.TITLE) {
            noteFilter.setOrder(NoteSortOrder.TITLE.getValue());
        } else {
            noteFilter.setOrder(NoteSortOrder.CREATED.getValue());
        }

        noteFilter.setAscending(true);

        return noteFilter;
    }
}
