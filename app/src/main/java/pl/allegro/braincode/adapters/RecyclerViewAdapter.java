package pl.allegro.braincode.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.allegro.braincode.R;
import pl.allegro.braincode.fragments.OnChooseListener;
import pl.allegro.braincode.messages.category.CategoryDto;

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
        String text = categories.get(position);
        CategoryDto categoryDto = CategoryDto.valueOf(text);

        holder.categoryName.setText(categoryDto.getName());

        StringBuilder builder = new StringBuilder();
        Iterator it = categoryDto.getProperties().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            builder.append(pair.getKey()).append(": ").append(pair.getValue()).append("\n");
            it.remove(); // avoids a ConcurrentModificationException
        }
        holder.categoryProps.setText(builder.toString());
    }

    @Override
    public int getItemCount() {
        if (categories == null) return 0;
        return categories.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.category_name)
        TextView categoryName;

        @BindView(R.id.category_props)
        TextView categoryProps;

        @BindView(R.id.item_frame)
        LinearLayout linearLayout;

        OnChooseListener list;

        public CustomViewHolder(View itemView, OnChooseListener listener) {
            super(itemView);
            this.list = listener;
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.item_frame)
        public void click() {
            list.choose(getAdapterPosition());
        }

    }
}
