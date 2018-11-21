package mvvm.ys.androidmvvm.viewmodel;

import org.junit.Test;

import mvvm.ys.androidmvvm.BaseTest;
import mvvm.ys.androidmvvm.R;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClickCountViewModelTest extends BaseTest {
    private static final String TWITTER_URL = "twitterUrl";
    private ClickCountViewModel viewModel;

    @Override
    public void setup() {
        super.setup();
        when(appContext.getString(R.string.click_count)).thenReturn("%d");
        when(appContext.getString(R.string.twitter_url)).thenReturn(TWITTER_URL);

        viewModel = new ClickCountViewModel(testComponent, null);
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
    }

    @Test
    public void testOnClickHiBrianLee() throws Exception {
        viewModel.onClickHiBrianLee();
        verify(attachedActivity).openUrl(TWITTER_URL);
    }
}