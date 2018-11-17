package mvvm.ys.androidmvvm.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.Bindable;
import android.os.Parcel;
import android.support.annotation.Nullable;

import mvvm.ys.androidmvvm.R;
import mvvm.ys.androidmvvm.BR;
import mvvm.ys.mvvmapp.viewmodel.ViewModel;

public class ClickCountViewModel extends ViewModel {
    private final Context appContext;
    int clicks;

    public ClickCountViewModel(Context context, @Nullable State savedInstanceState) {
        super(savedInstanceState);
        appContext = context.getApplicationContext();
        if (savedInstanceState instanceof ClickCountState) {
            clicks = ((ClickCountState) savedInstanceState).clicks;
        }
    }

    @Override
    public State getInstanceState() {
        return new ClickCountState(this);
    }

    @Bindable
    public String getClickCountText() {
        return String.format(appContext.getString(R.string.click_count), clicks);
    }

    public void onClickButton() {
        clicks ++;
        notifyPropertyChanged(BR.clickCountText);
    }

    public void onClickHiBrianLee(Activity activity) {
        try {
            Intent intent = Intent.parseUri(activity.getString(R.string.twitter_url), 0);
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ClickCountState extends State {

        private final int clicks;

        protected ClickCountState(ClickCountViewModel viewModel) {
            super(viewModel);
            clicks = viewModel.clicks;
        }

        public ClickCountState(Parcel in) {
            super(in);
            clicks = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(clicks);
        }

        public static Creator<ClickCountState> CREATOR = new Creator<ClickCountState>() {
            @Override
            public ClickCountState createFromParcel(Parcel source) {
                return new ClickCountState(source);
            }

            @Override
            public ClickCountState[] newArray(int size) {
                return new ClickCountState[size];
            }
        };
    }
}
