package mvvm.ys.androidmvvm.activity;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import mvvm.ys.androidmvvm.BaseTest;
import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.viewmodel.MainViewModel;
import mvvm.ys.androidmvvm.viewmodel.MockViewModelFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class MainActivityTest extends BaseTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(
            MainActivity.class, true, false);

    @Override
    public void setUp() throws Exception {
        super.setUp();
        viewModelFactory.registerSpyInitializer(MainViewModel.class, new MainSpyInitializer());
    }

    @Test
    public void testClickButtonClicks() {
        activityTestRule.launchActivity(null);
        MainViewModel mainViewModel = viewModelFactory.getMainViewModel();
        onView(withId(R.id.btClicks)).perform(click());

        verify(mainViewModel).onClickButtonClicks();
    }

    @Test
    public void testClickRecyclerView() {
        activityTestRule.launchActivity(null);
        MainViewModel mainViewModel = viewModelFactory.getMainViewModel();
        onView(withId(R.id.btRecyclerView)).perform(click());

        verify(mainViewModel).onClickButtonRecyclerView();
    }

    @Test
    public void testClickHiBrianLee() {
        activityTestRule.launchActivity(null);
        MainViewModel mainViewModel = viewModelFactory.getMainViewModel();
        onView(withId(R.id.albertLee)).perform(click());

        verify(mainViewModel).onClickHiBrianLee();
    }

    private static class MainSpyInitializer
            implements MockViewModelFactory.SpyInitializer<MainViewModel> {
        @Override
        public void setupSpy(MainViewModel viewModel) {
            doNothing().when(viewModel).onClickButtonClicks();
            doNothing().when(viewModel).onClickButtonRecyclerView();
            doNothing().when(viewModel).onClickHiBrianLee();
        }
    }
}