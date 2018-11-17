package mvvm.ys.androidmvvm.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.databinding.ActivityClickCountBinding;
import mvvm.ys.androidmvvm.viewmodel.ClickCountViewModel;
import mvvm.ys.mvvmapp.activity.ViewModelActivity;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

public class ClickCountActivity extends ViewModelActivity {
    private ClickCountViewModel clickCountViewModel;

    @Nullable
    @Override
    protected ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState) {
        clickCountViewModel = new ClickCountViewModel(this, savedViewModelState);
        return clickCountViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityClickCountBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_click_count);
        binding.setViewModel(clickCountViewModel);
    }

    public void onClickButton(View view) {
        clickCountViewModel.onClickButton();
    }

    public void onClickHiBrianLee(View view) {
        clickCountViewModel.onClickHiBrianLee(this);
    }
}
