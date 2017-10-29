package lnavarro.com.evernoteclient.modules.notes.presentation.presenter;

import com.evernote.edam.type.Note;

import java.util.List;

/**
 * Created by luis on 29/10/17.
 */

public interface NoteListPresenter {

    public interface View {
        void drawNotes(List<Note> notes);
        void showLoadingView();
        void hideLoadingView();
        void showErrorView();
    }
}
