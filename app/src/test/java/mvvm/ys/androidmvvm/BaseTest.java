package mvvm.ys.androidmvvm;

import android.content.Context;
import android.support.annotation.CallSuper;

import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mockito;

import javax.inject.Inject;

import mvvm.ys.mvvmapp.inject.AppContext;
import mvvm.ys.mvvmapp.inject.AttachedActivity;

public class BaseTest extends Assert {
    protected final TestComponent testComponent;

    @Inject
    @AppContext
    protected Context appContext;

    @Inject
    protected AttachedActivity attachedActivity;

    public BaseTest() {
        testComponent = DaggerTestComponent.builder()
                .testModule(new TestModule())
                .build();
        testComponent.inject(this);
    }

    @CallSuper
    @Before
    public void setup() {
        Mockito.reset(appContext, attachedActivity);
    }
}
