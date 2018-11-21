package mvvm.ys.androidmvvm.fragment;

import javax.inject.Inject;

import mvvm.ys.androidmvvm.SampleAppComponent;
import mvvm.ys.androidmvvm.viewmodel.ViewModelFactory;
import mvvm.ys.mvvmapp.fragment.ViewModelFragment;
import mvvm.ys.mvvmapp.inject.AppComponent;

public abstract class BaseFragment extends ViewModelFragment {

    @Inject
    protected ViewModelFactory viewModelFactory;

    @Override
    protected void inject(AppComponent appComponent) {
        ((SampleAppComponent) appComponent).inject(this);
    }
}
