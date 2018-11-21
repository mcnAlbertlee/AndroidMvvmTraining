package mvvm.ys.mvvmapp.inject;

import android.app.Activity;

import java.net.URISyntaxException;

public interface AttachedActivity {
    void startActivity(Class<? extends Activity> activityClass);
    void openUrl(String url) throws URISyntaxException;
}
