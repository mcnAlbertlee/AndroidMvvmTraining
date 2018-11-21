package mvvm.ys.androidmvvm;

import android.app.Instrumentation;
import android.support.annotation.CallSuper;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;

import javax.inject.Inject;

import mvvm.ys.androidmvvm.viewmodel.MockViewModelFactory;
import mvvm.ys.mvvmapp.inject.AppContextModule;

public class BaseTest {
    @Inject
    protected MockViewModelFactory viewModelFactory;

    @CallSuper
    @Before
    public void setUp() throws Exception {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();

        AndroidMvvmApplication application = (AndroidMvvmApplication) instrumentation
                .getTargetContext().getApplicationContext();

        TestComponent testComponent = DaggerTestComponent.builder()
                .appContextModule(new AppContextModule(application))
                .build();

        application.setAppComponent(testComponent);
        testComponent.inject(this);
        viewModelFactory.clear();
    }
}
