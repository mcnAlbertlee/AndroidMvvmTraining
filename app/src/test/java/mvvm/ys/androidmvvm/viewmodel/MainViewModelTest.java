package mvvm.ys.androidmvvm.viewmodel;


import android.app.Activity;

import org.junit.Test;

import mvvm.ys.androidmvvm.BaseTest;
import mvvm.ys.androidmvvm.activity.AndroidVersionsActivity;
import mvvm.ys.androidmvvm.activity.ClickCountActivity;

import static org.mockito.Mockito.verify;

public class MainViewModelTest extends BaseTest {

    private MainViewModel viewModel;
    private Activity activity;

    @Override
    public void setup() {
        super.setup();
        viewModel = new MainViewModel(testComponent, null);
    }


    @Test
    public void testOnClickButtonClicks() {
        viewModel.onClickButtonClicks();
        verify(attachedActivity).startActivity(ClickCountActivity.class);


//        viewModel.onClickButtonClicks(activity);
////        verify(activity).startActivity(new Intent(activity, AndroidVersionsActivity.class));
//        verify(activity).startActivity(any());
    }

    @Test
    public void testOnClickButtonRecyclerView() {
        viewModel.onClickButtonRecyclerView();
        verify(attachedActivity).startActivity(AndroidVersionsActivity.class);

//        viewModel.onClickButtonRecyclerView(activity);
////        verify(activity).startActivity(new Intent(activity, AndroidVersionsActivity.class));
//        verify(activity).startActivity(any());
    }
    @Test
    public void testOnClickHiBrianLee() throws Exception {
//        viewModel.onClickHiBrianLee(activity);
//        // parseUri를 변경해도 성공함..
//        verify(activity).startActivity(Intent.parseUri("https://www.twitter.com/hiBrianLee", 0));
    }
}