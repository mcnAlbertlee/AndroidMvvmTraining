package mvvm.ys.mvvmapp.inject;

import dagger.Component;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

@PerActivity
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(ViewModel viewModel);
}
