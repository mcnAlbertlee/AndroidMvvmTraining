package mvvm.ys.mvvmapp;

import android.app.Application;

import mvvm.ys.mvvmapp.inject.AppComponent;
import mvvm.ys.mvvmapp.inject.AppModule;
import mvvm.ys.mvvmapp.inject.DaggerAppComponent;

public class MvvmApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();

        }
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
