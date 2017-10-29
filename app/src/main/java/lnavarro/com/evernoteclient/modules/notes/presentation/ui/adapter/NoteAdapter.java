package lnavarro.com.evernoteclient.modules.notes.presentation.ui.adapter;

import android.support.annotation.BinderThread;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.evernote.edam.type.Note;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lnavarro.com.evernoteclient.R;
import lnavarro.com.evernoteclient.utils.Utils;

/**
 * Created by luis on 29/10/17.
 */

public class NoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Note> mData;

    public NoteAdapter() {
        mData = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_note, parent, false);
        viewHolder = new NoteAdapter.NoteViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Note note = mData.get(position);
        ((NoteViewHolder) holder).noteTitleTextView.setText(note.getTitle());
        ((NoteViewHolder) holder).noteSubtitleTextView.setText(Utils.formatDate(note.getCreated()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateData(ArrayList<Note> notes) {
        mData = notes;
        notifyDataSetChanged();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.note_title)
        TextView noteTitleTextView;
        @BindView(R.id.note_subtitle)
        TextView noteSubtitleTextView;

        public NoteViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
