package mvvm.ys.mvvmapp.inject;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import mvvm.ys.mvvmapp.activity.ViewModelActivity;
import mvvm.ys.mvvmapp.fragment.ViewModelFragment;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @AppContext
    Context appContext();

    void inject(ViewModelActivity viewModelActivity);
    void inject(ViewModelFragment viewModelFragment);
}
