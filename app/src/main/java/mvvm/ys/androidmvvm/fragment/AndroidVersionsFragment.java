package mvvm.ys.androidmvvm.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.adapter.AndroidVersionsAdapter;
import mvvm.ys.androidmvvm.model.AndroidVersion;

public class AndroidVersionsFragment extends Fragment {

    private static final String EXTRA_VERSIONS = "versions";

    private AndroidVersionsAdapter adapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_android_version, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        adapter = new AndroidVersionsAdapter();

        if(savedInstanceState != null) {
            ArrayList<AndroidVersion> versions =
                    savedInstanceState.getParcelableArrayList(EXTRA_VERSIONS);

            adapter.setItems(versions);
        } else {
            adapter.setItems(getVersions());
        }

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelableArrayList(EXTRA_VERSIONS, adapter.getItems());
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
}
