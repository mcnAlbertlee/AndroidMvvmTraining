package mvvm.ys.androidmvvm.viewmodel;


import org.junit.Test;

import mvvm.ys.androidmvvm.BaseTest;
import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.activity.AndroidVersionsActivity;
import mvvm.ys.androidmvvm.activity.ClickCountActivity;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainViewModelTest extends BaseTest {

    private MainViewModel viewModel;

    @Override
    public void setup() {
        super.setup();
        viewModel = new MainViewModel(testComponent, null);
    }

    @Test
    public void testOnClickButtonClicks() {
        viewModel.onClickButtonClicks();
        verify(attachedActivity).startActivity(ClickCountActivity.class);
    }

    @Test
    public void testOnClickButtonRecyclerView() {
        viewModel.onClickButtonRecyclerView();
        verify(attachedActivity).startActivity(AndroidVersionsActivity.class);
    }

    @Test
    public void testOnClickHiBrianLee() throws Exception {
        when(appContext.getString(R.string.twitter_url)).thenReturn("https://test_url");
        viewModel.onClickHiBrianLee();
        verify(attachedActivity).openUrl("https://test_url");
    }
}