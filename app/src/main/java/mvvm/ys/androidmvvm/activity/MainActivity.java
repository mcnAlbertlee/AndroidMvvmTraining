package mvvm.ys.androidmvvm.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.viewmodel.MainViewModel;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

public class MainActivity extends BaseActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Nullable
    @Override
    protected ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState) {
        mainViewModel = viewModelFactory.createMainViewModel(getActivityComponent(), savedViewModelState);
        return mainViewModel;
    }

    public void onClickButtonClicks(View view) {
        mainViewModel.onClickButtonClicks();
    }

    public void onClickButtonRecyclerView(View view) {
        mainViewModel.onClickButtonRecyclerView();
    }

    public void onClickAlbertLee(View view) {
        mainViewModel.onClickHiBrianLee();
    }
}
