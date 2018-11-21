package mvvm.ys.androidmvvm;

import android.app.Instrumentation;
import android.support.annotation.CallSuper;
import android.support.test.InstrumentationRegistry;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;

import javax.inject.Inject;

import mvvm.ys.androidmvvm.viewmodel.MockViewModelFactory;
import mvvm.ys.mvvmapp.adapter.RecyclerViewAdapter;
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

    public static Matcher<View> withRecyclerViewPosition(final int position) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("with RecyclerView position: " + position);
            }
            @Override
            protected boolean matchesSafely(View view) {
                if (!(view.getParent() instanceof RecyclerView)) {
                    return false;
                }
                RecyclerView recyclerView = (RecyclerView) view.getParent();
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (!(adapter instanceof RecyclerViewAdapter)) {
                    return false;
                }
                return position == recyclerView.getChildAdapterPosition(view);
            }
        };
    }
}
