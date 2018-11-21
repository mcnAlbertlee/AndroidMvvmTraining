package mvvm.ys.androidmvvm.adapter;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.databinding.ItemAndroidVersionBinding;
import mvvm.ys.androidmvvm.model.AndroidVersion;
import mvvm.ys.androidmvvm.viewmodel.AndroidVersionItemViewModel;
import mvvm.ys.androidmvvm.viewmodel.ViewModelFactory;
import mvvm.ys.mvvmapp.adapter.RecyclerViewAdapter;
import mvvm.ys.mvvmapp.inject.ActivityComponent;

public class AndroidVersionsAdapter extends RecyclerViewAdapter<AndroidVersion, AndroidVersionItemViewModel> {

    private final ViewModelFactory viewModelFactory;

    public AndroidVersionsAdapter(ViewModelFactory viewModelFactory,
                                  @NonNull ActivityComponent activityComponent) {
        super(activityComponent);
        this.viewModelFactory = viewModelFactory;
    }

    private final ArrayList<AndroidVersion> items = new ArrayList<>();

    @NonNull
    @Override
    public ItemViewHolder<AndroidVersion, AndroidVersionItemViewModel> onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_android_version, parent, false);

        AndroidVersionItemViewModel viewModel =
                viewModelFactory.createAndroidVersionItemViewModel(getActivityComponent());

        ItemAndroidVersionBinding binding = ItemAndroidVersionBinding.bind(itemView);
        binding.setViewModel(viewModel);

        return new AndroidVersionViewHolder(itemView, binding, viewModel);
    }

    public void setItems(ArrayList<AndroidVersion> newItems) {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    public ArrayList<AndroidVersion> getItems() {
        return items;
    }

    static class AndroidVersionViewHolder extends ItemViewHolder<AndroidVersion, AndroidVersionItemViewModel> {
        TextView version;
        TextView codeName;

        public AndroidVersionViewHolder(View itemView, ViewDataBinding binding, AndroidVersionItemViewModel viewModel) {
            super(itemView, binding, viewModel);

            version = itemView.findViewById(R.id.version);
            codeName = itemView.findViewById(R.id.codeName);
        }

        void onClickVersionItem() {
            viewModel.onClick();
        }
    }
}
