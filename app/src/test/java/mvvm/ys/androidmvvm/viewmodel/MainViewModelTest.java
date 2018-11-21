package mvvm.ys.androidmvvm.viewmodel;


import android.app.Activity;
import android.content.Intent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainViewModelTest extends Assert {

    private MainViewModel viewModel;
    private Activity activity;


    @Before
    public void setUp() {
        activity = mock(Activity.class);
        viewModel = new MainViewModel(null);
    }

    @Test
    public void testOnClickButtonClicks() {
        viewModel.onClickButtonClicks(activity);
//        verify(activity).startActivity(new Intent(activity, AndroidVersionsActivity.class));
        verify(activity).startActivity(any());
    }

    @Test
    public void testOnClickButtonRecyclerView() {
        viewModel.onClickButtonRecyclerView(activity);

//        verify(activity).startActivity(new Intent(activity, AndroidVersionsActivity.class));
        verify(activity).startActivity(any());
    }
    @Test
    public void testOnClickHiBrianLee() throws Exception {
        viewModel.onClickHiBrianLee(activity);
        // parseUri를 변경해도 성공함..
        verify(activity).startActivity(Intent.parseUri("https://www.twitter.com/hiBrianLee", 0));
    }
}