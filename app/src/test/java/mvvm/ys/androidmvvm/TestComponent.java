package mvvm.ys.androidmvvm;

import javax.inject.Singleton;

import dagger.Component;
import mvvm.ys.mvvmapp.inject.ActivityComponent;

@Singleton
@Component(modules = {TestModule.class})
public interface TestComponent extends ActivityComponent {
    void inject(BaseTest baseTest);
}
