package mvvm.ys.mvvmapp;

import android.app.Application;

import mvvm.ys.mvvmapp.inject.AppComponent;

public abstract class MvvmApplication extends Application {
    private AppComponent appComponent;

    protected abstract AppComponent createAppComponent();


    @Override
    public void onCreate() {
        super.onCreate();

        if (appComponent == null) {
            appComponent = createAppComponent();
        }
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
