package mvvm.ys.androidmvvm.viewmodel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import mvvm.ys.androidmvvm.adapter.AndroidVersionsAdapter;
import mvvm.ys.mvvmapp.inject.ActivityComponent;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

public interface ViewModelFactory {

    @NonNull
    MainViewModel createMainViewModel(@NonNull ActivityComponent activityComponent,
                                      @Nullable ViewModel.State savedViewModelState);

    @NonNull
    ClickCountViewModel createClickCountViewModel(@NonNull ActivityComponent activityComponent,
                                      @Nullable ViewModel.State savedViewModelState);

    @NonNull
    AndroidVersionsViewModel createAndroidVersionsViewModel(@NonNull AndroidVersionsAdapter adapter,
                                                            @NonNull ActivityComponent activityComponent,
                                                            @Nullable ViewModel.State savedInstanceState);

    @NonNull
    AndroidVersionItemViewModel createAndroidVersionItemViewModel(@NonNull ActivityComponent activityComponent);
}
