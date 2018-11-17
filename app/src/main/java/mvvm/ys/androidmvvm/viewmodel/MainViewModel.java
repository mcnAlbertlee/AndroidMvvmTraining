package mvvm.ys.androidmvvm.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.activity.AndroidVersionsActivity;
import mvvm.ys.androidmvvm.activity.ClickCountActivity;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

public class MainViewModel extends ViewModel {
    public MainViewModel(@Nullable State savedInstanceState) {
        super(savedInstanceState);
    }

    public void onClickButtonClicks(Activity activity) {
        activity.startActivity(new Intent(activity, ClickCountActivity.class));
    }
    public void onClickButtonRecyclerView(Activity activity) {
        activity.startActivity(new Intent(activity, AndroidVersionsActivity.class));
    }
    public void onClickHiBrianLee(Activity activity) {
        try {
            Intent intent = Intent.parseUri(activity.getString(R.string.twitter_url), 0);
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
