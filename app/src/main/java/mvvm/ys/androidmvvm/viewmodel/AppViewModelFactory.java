package mvvm.ys.androidmvvm.viewmodel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import mvvm.ys.androidmvvm.adapter.AndroidVersionsAdapter;
import mvvm.ys.mvvmapp.inject.ActivityComponent;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

public class AppViewModelFactory implements ViewModelFactory {
    @Inject
    AppViewModelFactory() {
    }

    @NonNull
    @Override
    public MainViewModel createMainViewModel(@NonNull ActivityComponent activityComponent, @Nullable ViewModel.State savedViewModelState) {
        return new MainViewModel(activityComponent, savedViewModelState);
    }

    @NonNull
    @Override
    public ClickCountViewModel createClickCountViewModel(@NonNull ActivityComponent activityComponent, @Nullable ViewModel.State savedViewModelState) {
        return new ClickCountViewModel(activityComponent, savedViewModelState);
    }

    @NonNull
    @Override
    public AndroidVersionsViewModel createAndroidVersionsViewModel(@NonNull AndroidVersionsAdapter adapter, @NonNull ActivityComponent activityComponent, @Nullable ViewModel.State savedInstanceState) {
        return new AndroidVersionsViewModel(adapter, activityComponent, savedInstanceState);
    }

    @NonNull
    @Override
    public AndroidVersionItemViewModel createAndroidVersionItemViewModel(@NonNull ActivityComponent activityComponent) {
        return new AndroidVersionItemViewModel(activityComponent);
    }
}
