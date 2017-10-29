package lnavarro.com.evernoteclient.modules.notes.presentation.presenter.implementation;

import android.content.Context;

import com.evernote.edam.type.Note;

import java.util.List;

import lnavarro.com.evernoteclient.common.presenter.AbstractPresenter;
import lnavarro.com.evernoteclient.modules.notes.domain.interactors.NoteListInteractor;
import lnavarro.com.evernoteclient.modules.notes.domain.interactors.implementation.NoteListInteractorImpl;
import lnavarro.com.evernoteclient.modules.notes.domain.model.FilterBy;
import lnavarro.com.evernoteclient.modules.notes.presentation.presenter.NoteListPresenter;

/**
 * Created by luis on 29/10/17.
 */

public class NoteListPresenterImpl extends AbstractPresenter implements NoteListPresenter, NoteListInteractor.Callback {

    private Context mContext;
    private NoteListPresenter.View mView;
    private NoteListInteractorImpl mInteractor;

    public NoteListPresenterImpl(Context context, NoteListPresenter.View view) {
        super(context);
        mContext = context;
        mView = view;
        mInteractor = new NoteListInteractorImpl(context, this);
    }

    public void init() {
        mInteractor.run();
    }

    public void destroy() {
        mInteractor.destroy();
    }

    @Override
    public void onNotesReceived(List<Note> notes) {
        mView.drawNotes(notes);
        mView.hideLoadingView();
    }

    @Override
    public void onNotesError() {

    }

    public void onFilterSelected(int position) {
        mInteractor.updateFilter(position == 0 ? FilterBy.Filter.TITLE : FilterBy.Filter.DATE);
    }
}
