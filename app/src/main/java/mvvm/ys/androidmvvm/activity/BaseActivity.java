package mvvm.ys.androidmvvm.activity;

import javax.inject.Inject;

import mvvm.ys.androidmvvm.SampleAppComponent;
import mvvm.ys.androidmvvm.viewmodel.ViewModelFactory;
import mvvm.ys.mvvmapp.activity.ViewModelActivity;
import mvvm.ys.mvvmapp.inject.AppComponent;

public class BaseActivity extends ViewModelActivity {
    @Inject
    protected ViewModelFactory viewModelFactory;

    @Override
    protected void inject(AppComponent appComponent) {
        ((SampleAppComponent) appComponent).inject(this);
    }
}
