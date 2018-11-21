package mvvm.ys.mvvmapp.adapter;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import mvvm.ys.mvvmapp.inject.ActivityComponent;
import mvvm.ys.mvvmapp.viewmodel.ItemViewModel;

public abstract class RecyclerViewAdapter<ITEM_T, VIEW_MODEL_T extends ItemViewModel<ITEM_T>>
        extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder<ITEM_T, VIEW_MODEL_T>> {

    protected final ArrayList<ITEM_T> items;

    private final ActivityComponent activityComponent;

    public RecyclerViewAdapter(@NonNull ActivityComponent activityComponent) {
        this.activityComponent = activityComponent;
        items = new ArrayList<>();
    }

    @Override
    public final void onBindViewHolder(ItemViewHolder<ITEM_T, VIEW_MODEL_T> holder, int position) {
        holder.setItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected final ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    public static class ItemViewHolder<T, VT extends ItemViewModel<T>> extends RecyclerView.ViewHolder {
        protected final VT viewModel;
        private final ViewDataBinding binding;

        public ItemViewHolder(View itemView, ViewDataBinding binding, VT viewModel) {
            super(itemView);
            this.binding = binding;
            this.viewModel = viewModel;
        }

        void setItem(T item) {
            viewModel.setItem(item);
            binding.executePendingBindings();
        }
    }
}
