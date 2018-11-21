package mvvm.ys.androidmvvm.activity;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import mvvm.ys.androidmvvm.BaseTest;
import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.model.AndroidVersion;
import mvvm.ys.androidmvvm.viewmodel.AndroidVersionItemViewModel;
import mvvm.ys.androidmvvm.viewmodel.AndroidVersionsViewModel;
import mvvm.ys.androidmvvm.viewmodel.MockViewModelFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;

public class AndroidVersionsActivityTest extends BaseTest {
    @Rule
    public ActivityTestRule<AndroidVersionsActivity> activityTestRule = new ActivityTestRule<>(
            AndroidVersionsActivity.class, true, false);

    @Override
    public void setUp() throws Exception {
        super.setUp();
        AndroidVersionItemInitializer initializer = new AndroidVersionItemInitializer();
        initializer.version = "version";
        initializer.codeName = "codeName";
        initializer.selected = true;
        viewModelFactory.registerSpyInitializer(AndroidVersionItemViewModel.class, initializer);
        viewModelFactory.registerSpyInitializer(AndroidVersionsViewModel.class,
                new AndroidVersionsInitializer());
    }

    @Test
    public void testInitialScreen() {
        activityTestRule.launchActivity(null);
        AndroidVersionItemViewModel viewModel = viewModelFactory.getAndroidVersionItemViewModel();
        verify(viewModel, atLeastOnce()).setItem(any(AndroidVersion.class));
        onView(withRecyclerViewPosition(0))
                .check(matches(allOf(
                        hasDescendant(withText("version")),
                        hasDescendant(withText("codeName")),
                        isSelected()
                )));
    }

    @Test
    public void testItemClick() {
        activityTestRule.launchActivity(null);
        AndroidVersionItemViewModel viewModel = viewModelFactory.getAndroidVersionItemViewModel();
        onView(withRecyclerViewPosition(0)).perform(click());
        verify(viewModel).onClick();
    }

    @Test
    public void testClickHiBrianLee() {
        activityTestRule.launchActivity(null);
        AndroidVersionsViewModel viewModel = viewModelFactory.getAndroidVersionsViewModel();
        onView(withId(R.id.hiBrianLee)).perform(click());
        verify(viewModel).onClickHiBrianLee();
    }

    private static class AndroidVersionItemInitializer
            implements MockViewModelFactory.SpyInitializer<AndroidVersionItemViewModel> {
        private String version;
        private String codeName;
        private boolean selected;
        @Override
        public void setupSpy(AndroidVersionItemViewModel viewModel) {
            doReturn(version).when(viewModel).getVersion();
            doReturn(codeName).when(viewModel).getCodeName();
            doReturn(selected).when(viewModel).getSelected();
            doNothing().when(viewModel).onClick();
            doNothing().when(viewModel).setItem(any(AndroidVersion.class));
        }
    }

    private static class AndroidVersionsInitializer
            implements MockViewModelFactory.SpyInitializer<AndroidVersionsViewModel> {
        @Override
        public void setupSpy(AndroidVersionsViewModel viewModel) {
            doNothing().when(viewModel).onClickHiBrianLee();
        }
    }
}
