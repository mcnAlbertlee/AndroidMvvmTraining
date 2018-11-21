package mvvm.ys.androidmvvm;

import javax.inject.Singleton;

import dagger.Component;
import mvvm.ys.mvvmapp.inject.AppComponent;
import mvvm.ys.mvvmapp.inject.AppContextModule;

@Singleton
@Component(modules = {AppContextModule.class})
public interface SampleAppComponent extends AppComponent {
}
