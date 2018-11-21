package mvvm.ys.androidmvvm.viewmodel;

import org.junit.Test;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.BR;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClickCountViewModelTest extends ViewModelTest<ClickCountViewModel> {
    private static final String TWITTER_URL = "twitterUrl";

    @Override
    protected ClickCountViewModel createViewModel(ViewModel.State savedInstanceState) {
        return new ClickCountViewModel(testComponent, savedInstanceState);
    }

    @Override
    public void setup() {
        super.setup();
        when(appContext.getString(R.string.click_count)).thenReturn("%d");
        when(appContext.getString(R.string.twitter_url)).thenReturn(TWITTER_URL);
    }

    @Test
    public void testViewModel() {
        assertEquals("0", viewModel.getClickCountText());
    }

    @Test
    public void testClickButton() {
        viewModel.onClickButton();
        assertEquals("1", viewModel.getClickCountText());

        viewModel.onClickButton();
        assertEquals("2", viewModel.getClickCountText());

        viewModel.onClickButton();
        assertEquals("3", viewModel.getClickCountText());

        verifyPropertyChanged(BR.clickCountText, times(3));
    }

    @Test
    public void testOnClickHiBrianLee() throws Exception {
        viewModel.onClickHiBrianLee();
        verify(attachedActivity).openUrl(TWITTER_URL);
    }

    @Test
    public void testRotation() {
        viewModel.onClickButton();
        rotateDestroy();
        rotateCreate();
        assertEquals("1", viewModel.getClickCountText());

        viewModel.onClickButton();
        rotateDestroy();
        rotateCreate();
        assertEquals("2", viewModel.getClickCountText());
    }
}