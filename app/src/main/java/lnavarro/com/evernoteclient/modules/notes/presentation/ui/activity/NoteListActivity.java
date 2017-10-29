package lnavarro.com.evernoteclient.modules.notes.presentation.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.evernote.edam.type.Note;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import lnavarro.com.evernoteclient.R;
import lnavarro.com.evernoteclient.modules.notes.presentation.presenter.implementation.NoteListPresenterImpl;
import lnavarro.com.evernoteclient.modules.notes.presentation.ui.adapter.NoteAdapter;

/**
 * Created by luis on 29/10/17.
 */

public class NoteListActivity extends AppCompatActivity implements NoteListPresenterImpl.View {

    Unbinder mUnbinder;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.loading_view)
    View mLoadingView;


    private NoteListPresenterImpl mPresenter;
    private LinearLayoutManager mLlManager;
    private NoteAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        mUnbinder = ButterKnife.bind(this);

        initView();

        mPresenter = new NoteListPresenterImpl(this, this);
        mPresenter.init();
    }

    private void initView() {
        showLoadingView();
        mToolbar.setTitle(getString(R.string.notes_activity_title));
        setSupportActionBar(mToolbar);

        mLlManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mAdapter = new NoteAdapter();
        mRecyclerView.setLayoutManager(mLlManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
        mUnbinder.unbind();
    }

    @Override
    public void drawNotes(List<Note> notes) {
        mAdapter.updateData(new ArrayList<>(notes));
    }

    @Override
    public void showLoadingView() {
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingView() {
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public void showErrorView() {

    }
}
