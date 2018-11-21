package mvvm.ys.mvvmapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import mvvm.ys.mvvmapp.MvvmApplication;
import mvvm.ys.mvvmapp.activity.ViewModelActivity;
import mvvm.ys.mvvmapp.inject.ActivityComponent;
import mvvm.ys.mvvmapp.inject.AppComponent;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

public abstract class ViewModelFragment extends Fragment {
    private static final String EXTRA_VIEW_MODEL_STATE = "viewModelState";

    private ViewModel viewModel;

    protected void inject(AppComponent appComponent) {
        appComponent.inject(this);
    }

    protected abstract ViewModel createAndBindViewModel(View root,
                                                        @NonNull ActivityComponent activityComponent,
                                                        @Nullable ViewModel.State savedViewModelState);
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent appComponent =
                ((MvvmApplication) getActivity().getApplication()).getAppComponent();
        inject(appComponent);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewModel.State savedViewModelState = null;
        if (savedInstanceState != null) {
            savedViewModelState = savedInstanceState.getParcelable(EXTRA_VIEW_MODEL_STATE);
        }

        ViewModelActivity activity = (ViewModelActivity) getActivity();
        viewModel = createAndBindViewModel(getView(), activity.getActivityComponent(),
                savedViewModelState);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (viewModel != null) {
            viewModel.onStart();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (viewModel != null) {
            outState.putParcelable(EXTRA_VIEW_MODEL_STATE, viewModel.getInstanceState());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (viewModel != null) {
            viewModel.onStop();
        }
    }
}
