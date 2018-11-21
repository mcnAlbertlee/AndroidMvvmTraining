package mvvm.ys.androidmvvm.viewmodel;

import android.content.Context;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.adapter.AndroidVersionsAdapter;
import mvvm.ys.androidmvvm.model.AndroidVersion;
import mvvm.ys.mvvmapp.adapter.RecyclerViewAdapter;
import mvvm.ys.mvvmapp.inject.ActivityComponent;
import mvvm.ys.mvvmapp.viewmodel.RecyclerViewViewModel;

public class AndroidVersionsViewModel extends RecyclerViewViewModel {

    private final Context appContext;
    AndroidVersionsAdapter adapter;

    public AndroidVersionsViewModel(Context context, @NonNull ActivityComponent activityComponent,
                                    @Nullable State savedInstanceState) {
        super(activityComponent, savedInstanceState);

        appContext = context.getApplicationContext();
        ArrayList<AndroidVersion> versions;

        if (savedInstanceState instanceof AndroidVersionsState) {
            versions = ((AndroidVersionsState) savedInstanceState).versions;
        } else {
            versions = getVersions();
        }

        adapter = new AndroidVersionsAdapter(activityComponent);
        adapter.setItems(versions);
    }

    @Override
    protected RecyclerViewAdapter getAdapter() {
        return adapter;
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager() {
        return new LinearLayoutManager(appContext);
    }

    @Override
    public RecyclerViewViewModelState getInstanceState() {
        return new AndroidVersionsState(this);
    }

    public void onClickHiBrianLee() {
        try {
            attachedActivity.openUrl(appContext.getString(R.string.twitter_url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArrayList<AndroidVersion> getVersions() {
        ArrayList<AndroidVersion> versions = new ArrayList<>();
        versions.add(new AndroidVersion("Cupcake", "Android 1.5"));
        versions.add(new AndroidVersion("Donut", "Android 1.6"));
        versions.add(new AndroidVersion("Eclair", "Android 2.0-2.1"));
        versions.add(new AndroidVersion("Froyo", "Android 2.2"));
        versions.add(new AndroidVersion("Gingerbread", "Android 2.3"));
        versions.add(new AndroidVersion("Honeycomb", "Android 3.0-3.2"));
        versions.add(new AndroidVersion("Ice Cream Sandwich", "Android 4.0"));
        versions.add(new AndroidVersion("Jelly Bean", "Android 4.1-4.3"));
        versions.add(new AndroidVersion("KitKat", "Android 4.4"));
        versions.add(new AndroidVersion("Lollipop", "Android 5.0-5.1"));
        versions.add(new AndroidVersion("Marshmallow", "Android 6.0"));
        return versions;
    }

    private static class AndroidVersionsState extends RecyclerViewViewModelState {
        private final ArrayList<AndroidVersion> versions;

        public AndroidVersionsState(AndroidVersionsViewModel viewModel) {
            super(viewModel);
            versions = viewModel.adapter.getItems();
        }

        public AndroidVersionsState(Parcel in) {
            super(in);
            versions = in.createTypedArrayList(AndroidVersion.CREATOR);
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeTypedList(versions);
        }

        public static Creator<AndroidVersionsState> CREATOR = new Creator<AndroidVersionsState>() {
            @Override
            public AndroidVersionsState createFromParcel(Parcel source) {
                return new AndroidVersionsState(source);
            }

            @Override
            public AndroidVersionsState[] newArray(int size) {
                return new AndroidVersionsState[size];
            }
        };
    }

}
