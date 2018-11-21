package mvvm.ys.androidmvvm.viewmodel;

import org.junit.Test;

import mvvm.ys.androidmvvm.model.AndroidVersion;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;
import mvvm.ys.androidmvvm.BR;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AndroidVersionItemViewModelTest extends ViewModelTest<AndroidVersionItemViewModel>{

    private AndroidVersion androidVersion;

    @Override
    protected AndroidVersionItemViewModel createViewModel(ViewModel.State savedInstanceState) {
        return new AndroidVersionItemViewModel(testComponent);
    }

    @Test
    public void testViewModel() {
        androidVersion = mock(AndroidVersion.class);
        when(androidVersion.getVersion()).thenReturn("Version");
        when(androidVersion.getCodeName()).thenReturn("Code Name");
        when(androidVersion.isSelected()).thenReturn(true);
        viewModel.setItem(androidVersion);

        verifyChanged();
        assertEquals("Version", viewModel.getVersion());
        assertEquals("Code Name", viewModel.getCodeName());
        assertTrue(viewModel.getSelected());
    }

    @Test
    public void testVersion() {
        androidVersion = mock(AndroidVersion.class);
        when(androidVersion.getVersion()).thenReturn("Version");
        viewModel.setItem(androidVersion);

        assertEquals("Version", viewModel.getVersion());

        when(androidVersion.getVersion()).thenReturn("New Version");
        assertEquals("New Version", viewModel.getVersion());
    }

    @Test
    public void testCodeName() {
        androidVersion = mock(AndroidVersion.class);
        when(androidVersion.getCodeName()).thenReturn("Code Name");
        viewModel.setItem(androidVersion);

        assertEquals("Code Name", viewModel.getCodeName());

        when(androidVersion.getCodeName()).thenReturn("New Code Name");
        assertEquals("New Code Name", viewModel.getCodeName());
    }

    @Test
    public void testSelected() {
        androidVersion = mock(AndroidVersion.class);
        when(androidVersion.isSelected()).thenReturn(false);

        assertFalse(androidVersion.isSelected());

        when(androidVersion.isSelected()).thenReturn(true);
        assertTrue(androidVersion.isSelected());
    }

    @Test
    public void testOnClick() {
        androidVersion = mock(AndroidVersion.class);
        viewModel.setItem(androidVersion);
        viewModel.onClick();

        verify(androidVersion).toggleSelected();
        verifyPropertyChanged(BR.selected);
    }
}