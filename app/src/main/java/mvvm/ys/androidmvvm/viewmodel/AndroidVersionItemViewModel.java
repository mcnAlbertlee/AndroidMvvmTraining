package mvvm.ys.androidmvvm.viewmodel;

import android.databinding.Bindable;

import mvvm.ys.androidmvvm.BR;
import mvvm.ys.androidmvvm.model.AndroidVersion;
import mvvm.ys.mvvmapp.viewmodel.ItemViewModel;

public class AndroidVersionItemViewModel extends ItemViewModel<AndroidVersion> {

    private AndroidVersion androidVersion;

    @Override
    public void setItem(AndroidVersion item) {
        this.androidVersion = item;
        notifyChange();
    }

    public void onClick() {
        androidVersion.toggleSelected();
        notifyPropertyChanged(BR.selected);
    }

    @Bindable
    public String getVersion() {
        return androidVersion.getVersion();
    }

    @Bindable
    public String getCodeName() {
        return androidVersion.getCodeName();
    }

    @Bindable
    public boolean getSelected() {
        return androidVersion.isSelected();
    }


}
