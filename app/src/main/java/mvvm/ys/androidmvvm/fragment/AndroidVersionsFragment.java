package mvvm.ys.androidmvvm.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.databinding.FragmentAndroidVersionBinding;
import mvvm.ys.androidmvvm.viewmodel.AndroidVersionsViewModel;
import mvvm.ys.mvvmapp.fragment.ViewModelFragment;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

public class AndroidVersionsFragment extends ViewModelFragment {

    private AndroidVersionsViewModel androidVersionsViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentAndroidVersionBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_android_version, container,false);
        binding.setViewModel(androidVersionsViewModel);

        return binding.getRoot();
    }

    protected ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState) {
        androidVersionsViewModel = new AndroidVersionsViewModel(getContext(), savedViewModelState);
        return androidVersionsViewModel;
    }

    public void onClickHiBrianLee(View view) {
        androidVersionsViewModel.onClickHiBrianLee(getActivity());
    }
}
