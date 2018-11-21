package mvvm.ys.androidmvvm.viewmodel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SampleAppModule {

    @Provides
    @Singleton
    ViewModelFactory provideViewModelFactory(AppViewModelFactory appViewModelFactory) {
        return appViewModelFactory;
    }
}
