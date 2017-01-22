package in.ceeq.dbx.core.types;

import android.os.Parcel;
import android.os.Parcelable;

public class BindableInteger extends BindableField<Integer> {

    public static final Parcelable.Creator<BindableInteger> CREATOR = new Parcelable.Creator<BindableInteger>() {
        @Override
        public BindableInteger createFromParcel(Parcel source) {
            return new BindableInteger(source);
        }

        @Override
        public BindableInteger[] newArray(int size) {
            return new BindableInteger[size];
        }
    };

    public BindableInteger() {
        super();
    }

    public BindableInteger(int value) {
        super(value);
    }

    protected BindableInteger(Parcel in) {
        this.mValue = in.readInt();
    }

    @Override
    public Integer get() {
        Integer value = super.get();
        return (value != null) ? value : 0;
    }

    @Override
    public void set(final Integer value) {
        super.set(value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mValue);
    }
}
