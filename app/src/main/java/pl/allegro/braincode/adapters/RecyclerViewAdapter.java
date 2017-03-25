package pl.allegro.braincode.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.allegro.braincode.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private List<String> tasks;

    public RecyclerViewAdapter(List<String> tasks) {
        this.tasks = tasks;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.title.setText("lel");
        holder.taskId.setText("heh");
    }

    @Override
    public int getItemCount() {
        if (tasks == null) return 0;
        return tasks.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.todo_id)
        TextView taskId;
        @BindView(R.id.todo_title)
        TextView title;

        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        }
}
