package lnavarro.com.evernoteclient.modules.notes.domain.interactors;

import com.evernote.edam.type.Note;

import java.util.List;

import lnavarro.com.evernoteclient.common.interactors.Interactor;

/**
 * Created by luis on 29/10/17.
 */

public interface NoteListInteractor extends Interactor {
    public interface Callback{
        void onNotesReceived(List<com.evernote.edam.type.Note> notes);
        void onNotesError();
    }
}
