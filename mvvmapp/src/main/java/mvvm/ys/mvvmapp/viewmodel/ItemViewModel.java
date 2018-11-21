package mvvm.ys.mvvmapp.viewmodel;

import android.support.annotation.NonNull;

import mvvm.ys.mvvmapp.inject.ActivityComponent;

public abstract class ItemViewModel<ITEM_T> extends ViewModel {

    public ItemViewModel(@NonNull ActivityComponent activityComponent) {
        super(activityComponent, null);
    }

    public abstract void setItem(ITEM_T item);
}
