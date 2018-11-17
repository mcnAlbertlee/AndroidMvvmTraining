package mvvm.ys.androidmvvm.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void onClickButtonClicks(View view) {
        startActivity(new Intent(this, ClickCountActivity.class));
    }

    public void onClickButtonRecyclerView(View view) {
        startActivity(new Intent(this, AndroidVersionsActivity.class));
    }

    public void onClickAlbertLee(View view) {
        try {
            Intent intent = Intent.parseUri(getString(R.string.twitter_url), 0);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
