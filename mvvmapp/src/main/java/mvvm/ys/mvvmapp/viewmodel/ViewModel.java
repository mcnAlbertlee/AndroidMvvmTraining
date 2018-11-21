package mvvm.ys.mvvmapp.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import mvvm.ys.mvvmapp.inject.ActivityComponent;
import mvvm.ys.mvvmapp.inject.AppContext;
import mvvm.ys.mvvmapp.inject.AttachedActivity;

public abstract class ViewModel extends BaseObservable {
    protected ViewModel(@NonNull ActivityComponent activityComponent,
                        @Nullable State savedInstanceState) {
        activityComponent.inject(this);
    }

    @CallSuper
    public void onStart() {

    }

    public State getInstanceState() {
        return new State(this);
    }

    @CallSuper
    public void onStop() {
    }

    @Inject
    @AppContext
    protected Context appContext;

    @Inject
    protected AttachedActivity attachedActivity;

    public static class State implements Parcelable {
        protected State(ViewModel viewModel) {

        }

        public State(Parcel in) {

        }

        @Override
        public int describeContents() {
            return 0;
        }

        @CallSuper
        @Override
        public void writeToParcel(Parcel parcel, int i) {

        }

        public static Creator<State> CREATOR = new Creator<State>() {
            @Override
            public State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            @Override
            public State[] newArray(int size) {
                return new State[size];
            }
        };
    }

}
