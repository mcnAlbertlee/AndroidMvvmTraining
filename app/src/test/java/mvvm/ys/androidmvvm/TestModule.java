package mvvm.ys.androidmvvm;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mvvm.ys.mvvmapp.inject.AttachedActivity;

import static org.mockito.Mockito.mock;

@Module
public final class TestModule {
    @Provides
    @Singleton
    AttachedActivity provideAttachedActivity() {
        return mock(AttachedActivity.class);
    }
}
