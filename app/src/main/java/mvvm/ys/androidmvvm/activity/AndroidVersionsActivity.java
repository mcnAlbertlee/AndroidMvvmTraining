package mvvm.ys.androidmvvm.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.fragment.AndroidVersionsFragment;

public class AndroidVersionsActivity extends AppCompatActivity {
    private static final String TAG_VERSION_FRAGMENT = "versionFragment";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_versions);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(TAG_VERSION_FRAGMENT);
        if(fragment == null) {
            fragment = new AndroidVersionsFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment, TAG_VERSION_FRAGMENT)
                    .commit();
        }
    }
}
