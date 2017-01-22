package in.ceeq.dbx.core.types;

import android.databinding.BaseObservable;
import android.os.Parcelable;

public abstract class BindableField<T> extends BaseObservable implements Parcelable {

    protected T mValue;

    public BindableField() {
    }

    public BindableField(T defaultValue) {
        mValue = defaultValue;
    }

    public T get() {
        return mValue;
    }

    public void set(T value) {
        mValue = value;
        notifyChange();
    }
}
