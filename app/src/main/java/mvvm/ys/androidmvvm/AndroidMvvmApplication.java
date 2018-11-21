package mvvm.ys.androidmvvm;

import mvvm.ys.mvvmapp.MvvmApplication;
import mvvm.ys.mvvmapp.inject.AppComponent;
import mvvm.ys.mvvmapp.inject.AppContextModule;

public class AndroidMvvmApplication extends MvvmApplication {
    @Override
    protected AppComponent createAppComponent() {
        return DaggerSampleAppComponent.builder()
                .appContextModule(new AppContextModule(this))
                .build();
    }
}
