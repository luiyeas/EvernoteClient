package lnavarro.com.evernoteclient.modules.notes.domain.interactors.implementation;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.evernote.client.android.asyncclient.EvernoteCallback;
import com.evernote.edam.notestore.NoteList;
import com.evernote.edam.type.Note;
import com.evernote.edam.type.Notebook;

import java.util.ArrayList;
import java.util.List;

import lnavarro.com.evernoteclient.common.interactors.AbstractInteractor;
import lnavarro.com.evernoteclient.modules.evernotewrapper.domain.repository.EvernoteRepository;
import lnavarro.com.evernoteclient.modules.notes.domain.interactors.NoteListInteractor;
import lnavarro.com.evernoteclient.modules.notes.domain.model.FilterBy;

/**
 * Created by luis on 29/10/17.
 */

public class NoteListInteractorImpl extends AbstractInteractor implements NoteListInteractor {

    private FilterBy mFilterBy;
    private NoteListInteractor.Callback mCallback;

    public NoteListInteractorImpl(Context context, NoteListInteractor.Callback callback) {
        super(context);
        this.mCallback = callback;
        mFilterBy = new FilterBy();
    }

    @Override
    public void run() {
        getNotes();
    }

    @Override
    public void removeCallbacks() {
        mCallback = null;
    }

    @Override
    public void destroy() {
        removeCallbacks();
    }

    public void updateFilter(FilterBy.Filter filter) {
        if (!mFilterBy.equals(filter)) {
            mFilterBy.setFilter(filter);
            getNotes();
        }
    }

    private void getNotes() {
        EvernoteRepository.getInstance(mContext).getNotes(new EvernoteCallback<NoteList>() {
            @Override
            public void onSuccess(NoteList result) {
                if (result != null && result.getNotes() != null) {
                    if (mCallback != null) {
                        mCallback.onNotesReceived(result.getNotes());
                    } else {
                        mCallback.onNotesError();
                    }
                }
            }

            @Override
            public void onException(Exception exception) {
                if (mCallback != null) {
                    mCallback.onNotesError();
                }
            }
        }, mFilterBy);
    }
}
