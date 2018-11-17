package mvvm.ys.androidmvvm.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.model.AndroidVersion;

public class AndroidVersionsAdapter extends RecyclerView.Adapter<AndroidVersionsAdapter.AndroidVersionViewHolder>
implements View.OnClickListener {

    private final ArrayList<AndroidVersion> items = new ArrayList<>();

    @NonNull
    @Override
    public AndroidVersionsAdapter.AndroidVersionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_android_version, parent, false);
        itemView.setOnClickListener(this);
        return new AndroidVersionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AndroidVersionsAdapter.AndroidVersionViewHolder holder, int position) {
        AndroidVersion item = items.get(position);
        holder.itemView.setTag(position);
        holder.itemView.setSelected(item.isSelected());
        holder.version.setText(item.getVersion());
        holder.codeName.setText(item.getCodeName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<AndroidVersion> newItems) {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    public ArrayList<AndroidVersion> getItems() {
        return items;
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();

        AndroidVersion item = items.get(position);
        item.toggleSelected();
        notifyItemChanged(position);
    }

    static class AndroidVersionViewHolder extends RecyclerView.ViewHolder {
        TextView version;
        TextView codeName;

        public AndroidVersionViewHolder(View itemView) {
            super(itemView);

            version = itemView.findViewById(R.id.version);
            codeName = itemView.findViewById(R.id.codeName);
        }
    }
}
