package mvvm.ys.mvvmapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import mvvm.ys.mvvmapp.MvvmApplication;
import mvvm.ys.mvvmapp.inject.ActivityComponent;
import mvvm.ys.mvvmapp.inject.ActivityModule;
import mvvm.ys.mvvmapp.inject.AppComponent;
import mvvm.ys.mvvmapp.inject.DaggerActivityComponent;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

public abstract class ViewModelActivity extends AppCompatActivity {

    private static final String EXTRA_VIEW_MODEL_STATE = "viewModelState";

    private ActivityComponent activityComponent;
    private ViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppComponent appComponent = ((MvvmApplication) getApplication()).getAppComponent();
        appComponent.inject(this);

        activityComponent = DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(this))
                .build();


        ViewModel.State savedViewModelState = null;
        if(savedInstanceState != null) {
            savedViewModelState = savedInstanceState.getParcelable(EXTRA_VIEW_MODEL_STATE);
        }

        viewModel = createViewModel(savedViewModelState);
    }

    @Nullable
    protected ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState) {
        return null;
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(viewModel != null) {
            viewModel.onStart();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if(viewModel != null) {
            outState.putParcelable(EXTRA_VIEW_MODEL_STATE, viewModel.getInstanceState());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(viewModel != null) {
            viewModel.onStop();
        }
    }

    public final ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
