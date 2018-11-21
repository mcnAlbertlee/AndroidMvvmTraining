package mvvm.ys.mvvmapp.inject;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Context appContext;

    public AppModule(Application application) {
        appContext = application;
    }

    @Provides
    @Singleton
    @AppContext
    Context provideAppContext() {
        return appContext;
    }
}
