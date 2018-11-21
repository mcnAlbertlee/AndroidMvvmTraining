package mvvm.ys.mvvmapp.inject;

import android.content.Context;

import mvvm.ys.mvvmapp.activity.ViewModelActivity;
import mvvm.ys.mvvmapp.fragment.ViewModelFragment;

public interface AppComponent {

    @AppContext
    Context appContext();

    void inject(ViewModelActivity viewModelActivity);
    void inject(ViewModelFragment viewModelFragment);
}
