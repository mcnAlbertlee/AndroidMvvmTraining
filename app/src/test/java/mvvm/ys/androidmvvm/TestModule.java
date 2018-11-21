package mvvm.ys.androidmvvm;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mvvm.ys.mvvmapp.inject.AppContext;
import mvvm.ys.mvvmapp.inject.AttachedActivity;

import static org.mockito.Mockito.mock;

@Module
public final class TestModule {
    @Provides
    @Singleton
    @AppContext
    Context provideAppContext() {
        return mock(Context.class);
    }

    @Provides
    @Singleton
    AttachedActivity provideAttachedActivity() {
        return mock(AttachedActivity.class);
    }
}
