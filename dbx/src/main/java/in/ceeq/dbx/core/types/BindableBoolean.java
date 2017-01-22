package in.ceeq.dbx.core.types;

import android.os.Parcel;
import android.os.Parcelable;

public class BindableBoolean extends BindableField<Boolean> {

    public static final Parcelable.Creator<BindableBoolean> CREATOR =
            new Parcelable.Creator<BindableBoolean>() {
                public BindableBoolean createFromParcel(Parcel source) {
                    return new BindableBoolean(source);
                }

                public BindableBoolean[] newArray(int size) {
                    return new BindableBoolean[size];
                }
            };

    public BindableBoolean() {
        super(false);
    }

    public BindableBoolean(boolean value) {
        super(value);
    }

    protected BindableBoolean(Parcel in) {
        mValue = in.readByte() != 0;
    }

    @Override
    public Boolean get() {
        Boolean value = super.get();
        return (value != null) ? value : false;
    }

    @Override
    public void set(final Boolean value) {
        super.set(value);
    }

    public void toggle() {
        set(!get());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(mValue ? (byte) 1 : (byte) 0);
    }

}
