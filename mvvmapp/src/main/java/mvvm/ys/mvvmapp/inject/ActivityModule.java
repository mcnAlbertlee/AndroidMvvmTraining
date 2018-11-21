package mvvm.ys.mvvmapp.inject;

import dagger.Module;
import dagger.Provides;
import mvvm.ys.mvvmapp.activity.ViewModelActivity;

@Module
public class ActivityModule {
    private final ViewModelActivity activity;

    public ActivityModule(ViewModelActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    AttachedActivity provideAttachedActivity() {
        return new AttachedViewModelActivity(activity);
    }
}
