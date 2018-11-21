package mvvm.ys.androidmvvm.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.adapter.AndroidVersionsAdapter;
import mvvm.ys.androidmvvm.databinding.FragmentAndroidVersionBinding;
import mvvm.ys.androidmvvm.viewmodel.AndroidVersionsViewModel;
import mvvm.ys.mvvmapp.fragment.ViewModelFragment;
import mvvm.ys.mvvmapp.inject.ActivityComponent;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

public class AndroidVersionsFragment extends ViewModelFragment {

    private AndroidVersionsViewModel androidVersionsViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_android_version, container, false);

        return root;
    }

    protected ViewModel createAndBindViewModel(View root,
                                               @NonNull ActivityComponent activityComponent,
                                               @Nullable ViewModel.State savedViewModelState) {

        androidVersionsViewModel = new AndroidVersionsViewModel(
                new AndroidVersionsAdapter(activityComponent), activityComponent, savedViewModelState);

        FragmentAndroidVersionBinding binding = DataBindingUtil.bind(root);
        binding.setViewModel(androidVersionsViewModel);

        return androidVersionsViewModel;
    }
}
