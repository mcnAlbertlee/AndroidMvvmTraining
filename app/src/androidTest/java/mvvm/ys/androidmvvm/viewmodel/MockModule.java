package mvvm.ys.androidmvvm.viewmodel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MockModule {
    @Provides
    @Singleton
    ViewModelFactory provideViewModelFactory(MockViewModelFactory mockViewModelFactory) {
        return mockViewModelFactory;
    }
}
