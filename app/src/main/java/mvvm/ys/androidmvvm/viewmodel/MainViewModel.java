package mvvm.ys.androidmvvm.viewmodel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.net.URISyntaxException;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.activity.AndroidVersionsActivity;
import mvvm.ys.androidmvvm.activity.ClickCountActivity;
import mvvm.ys.mvvmapp.inject.ActivityComponent;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

public class MainViewModel extends ViewModel {
    MainViewModel(@NonNull ActivityComponent activityComponent,
                         @Nullable State savedInstanceState) {
        super(activityComponent, savedInstanceState);
    }

    public void onClickButtonClicks() {
        attachedActivity.startActivity(ClickCountActivity.class);
    }

    public void onClickButtonRecyclerView() {
        attachedActivity.startActivity(AndroidVersionsActivity.class);
    }

    public void onClickHiBrianLee() {
        try {
            attachedActivity.openUrl(appContext.getString(R.string.twitter_url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
