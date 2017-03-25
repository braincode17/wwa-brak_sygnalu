package pl.allegro.braincode.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.allegro.braincode.R;
import pl.allegro.braincode.fragments.OnChooseListener;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private List<String> categories;
    private OnChooseListener listener;

    public RecyclerViewAdapter(List<String> categories, OnChooseListener listener) {
        this.categories = categories;
        this.listener = listener;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new CustomViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.title.setText(categories.get(position));
    }

    @Override
    public int getItemCount() {
        if (categories == null) return 0;
        return categories.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.category_name)
        TextView title;

        OnChooseListener list;

        public CustomViewHolder(View itemView, OnChooseListener listener) {
            super(itemView);
            this.list = listener;
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.category_name)
        public void click(){
            list.choose(getAdapterPosition());
        }

    }
}
