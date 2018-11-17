package mvvm.ys.androidmvvm.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.databinding.ActivityClickCountBinding;

public class ClickCountActivity extends AppCompatActivity {
    private static final String EXTRA_CLICKS = "clicks";

    ActivityClickCountBinding clickCountBinding;

    private int clicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clickCountBinding = DataBindingUtil.setContentView(this, R.layout.activity_click_count);

        if(savedInstanceState != null) {
            clicks = savedInstanceState.getInt(EXTRA_CLICKS);
        }

        updateClicks();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_CLICKS, clicks);
    }

    public void onClickButton(View view) {
        clicks ++;
        updateClicks();
    }

    public void onClickHiBrianLee(View view) {
        try {
            Intent intent = Intent.parseUri(getString(R.string.twitter_url), 0);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateClicks() {
        clickCountBinding.setCountText(String.format(getString(R.string.click_count), clicks));
    }
}
