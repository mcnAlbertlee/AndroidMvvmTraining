package mvvm.ys.androidmvvm.viewmodel;

import android.databinding.Observable;

import org.mockito.verification.VerificationMode;

import mvvm.ys.androidmvvm.BaseTest;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public abstract class ViewModelTest<ViewModelT extends ViewModel> extends BaseTest {
    protected ViewModelT viewModel;
    protected Observable.OnPropertyChangedCallback onPropertyChangedCallback;

    private ViewModel.State savedInstanceState;

    protected abstract ViewModelT createViewModel(ViewModel.State savedInstanceState);

    @Override
    public void setup() {
        super.setup();

        savedInstanceState = null;
        onPropertyChangedCallback = mock(Observable.OnPropertyChangedCallback.class);
        viewModel = createViewModel(null);
        viewModel.addOnPropertyChangedCallback(onPropertyChangedCallback);
    }

    protected final void verifyChanged() {
        verify(onPropertyChangedCallback)
                .onPropertyChanged(any(Observable.class), eq(0));
    }

    protected final void verifyPropertyChanged(int propertyId) {
        verify(onPropertyChangedCallback)
                .onPropertyChanged(any(Observable.class), eq(propertyId));
    }

    protected final void verifyPropertyChanged(int propertyId, VerificationMode verificationMode) {
        verify(onPropertyChangedCallback, verificationMode)
                .onPropertyChanged(any(Observable.class), eq(propertyId));
    }

    protected final void rotateDestroy() {
        savedInstanceState = viewModel.getInstanceState();
        viewModel.removeOnPropertyChangedCallback(onPropertyChangedCallback);
        viewModel.onStop();
    }

    protected final void rotateCreate() {
        onPropertyChangedCallback = mock(Observable.OnPropertyChangedCallback.class);
        viewModel = createViewModel(savedInstanceState);
        viewModel.addOnPropertyChangedCallback(onPropertyChangedCallback);
        viewModel.onStart();
        savedInstanceState = null;
    }
}
