package mvvm.ys.androidmvvm;

import javax.inject.Singleton;

import dagger.Component;
import mvvm.ys.androidmvvm.activity.BaseActivity;
import mvvm.ys.androidmvvm.fragment.BaseFragment;
import mvvm.ys.androidmvvm.viewmodel.SampleAppModule;
import mvvm.ys.mvvmapp.inject.AppComponent;
import mvvm.ys.mvvmapp.inject.AppContextModule;

@Singleton
@Component(modules = {
        AppContextModule.class,
        SampleAppModule.class
})
public interface SampleAppComponent extends AppComponent {
    void inject(BaseActivity baseActivity);
    void inject(BaseFragment baseFragment);
}
