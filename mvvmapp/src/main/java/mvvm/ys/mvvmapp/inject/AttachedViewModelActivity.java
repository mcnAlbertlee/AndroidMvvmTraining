package mvvm.ys.mvvmapp.inject;

import android.app.Activity;
import android.content.Intent;

import java.lang.ref.WeakReference;
import java.net.URISyntaxException;

import mvvm.ys.mvvmapp.activity.ViewModelActivity;

public final class AttachedViewModelActivity implements AttachedActivity {
    private final WeakReference<ViewModelActivity> weakActivity;

    AttachedViewModelActivity(ViewModelActivity activity) {
        weakActivity = new WeakReference<>(activity);
    }

    @Override
    public void startActivity(Class<? extends Activity> activityClass) {
        ViewModelActivity activity = weakActivity.get();
        if (activity != null && !activity.isFinishing()) {
            activity.startActivity(new Intent(activity, activityClass));
        }
    }
    @Override
    public void openUrl(String url) throws URISyntaxException {
        ViewModelActivity activity = weakActivity.get();
        if (activity != null && !activity.isFinishing()) {
            activity.startActivity(Intent.parseUri(url, 0));
        }
    }

}
