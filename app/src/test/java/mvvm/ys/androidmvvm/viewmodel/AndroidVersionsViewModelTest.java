package mvvm.ys.androidmvvm.viewmodel;

import android.support.v7.widget.RecyclerView;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.util.ArrayList;

import mvvm.ys.androidmvvm.adapter.AndroidVersionsAdapter;
import mvvm.ys.androidmvvm.model.AndroidVersion;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AndroidVersionsViewModelTest extends ViewModelTest<AndroidVersionsViewModel> {

    private static final String[] CODE_NAMES = {
            "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb",
            "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow"
    };

    private static final String[] VERSIONS = {
            "Android 1.5", "Android 1.6", "Android 2.0-2.1", "Android 2.2", "Android 2.3",
            "Android 3.0-3.2", "Android 4.0", "Android 4.1-4.3", "Android 4.4", "Android 5.0-5.1",
            "Android 6.0"
    };

    @Captor
    private ArgumentCaptor<ArrayList<AndroidVersion>> versionsCaptor;

    private AndroidVersionsAdapter adapter;

    @Override
    protected AndroidVersionsViewModel createViewModel(ViewModel.State savedInstanceState) {
        adapter = mock(AndroidVersionsAdapter.class);
        AndroidVersionsViewModel androidVersionsViewModel =
                new AndroidVersionsViewModel(adapter, testComponent, savedInstanceState);
        // required to initialize LayoutManager
        androidVersionsViewModel.setupRecyclerView(mock(RecyclerView.class));
        return androidVersionsViewModel;
    }

    @Test
    public void testViewModel() {
        verify(adapter).setItems(versionsCaptor.capture());

        ArrayList<AndroidVersion> versions = versionsCaptor.getValue();
        assertEquals(11, versions.size());

        for (int i = 0; i < 11; i++) {
            AndroidVersion androidVersion = versions.get(i);
            assertEquals(CODE_NAMES[i], androidVersion.getCodeName());
            assertEquals(VERSIONS[i], androidVersion.getVersion());
            assertFalse(androidVersion.isSelected());
        }
    }

    @Test
    public void testRotation() {
        ArrayList<AndroidVersion> versions = new ArrayList<>();

        AndroidVersion androidVersion = new AndroidVersion("Code Name", "Version");
        androidVersion.toggleSelected();
        versions.add(androidVersion);
        when(adapter.getItems()).thenReturn(versions);

        rotateDestroy();
        rotateCreate();

        verify(adapter).setItems(versionsCaptor.capture());
        ArrayList<AndroidVersion> restoredVersions = versionsCaptor.getValue();
        assertNotNull(restoredVersions);
        assertEquals(1, restoredVersions.size());
        AndroidVersion restoreVersion = restoredVersions.get(0);
        assertEquals("Code Name", restoreVersion.getCodeName());
        assertEquals("Version", restoreVersion.getVersion());
        assertTrue(restoreVersion.isSelected());
    }
}