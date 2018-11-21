package mvvm.ys.androidmvvm;

import javax.inject.Singleton;

import dagger.Component;
import mvvm.ys.androidmvvm.viewmodel.MockModule;
import mvvm.ys.mvvmapp.inject.AppContextModule;

@Singleton
@Component(modules = {
        AppContextModule.class,
        MockModule.class
})
public interface TestComponent extends SampleAppComponent {
    void inject(BaseTest baseTest);
}
