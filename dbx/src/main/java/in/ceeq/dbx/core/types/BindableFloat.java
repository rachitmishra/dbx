package in.ceeq.dbx.core.types;

import android.os.Parcel;

public class BindableFloat extends BindableField<Float> {

    public static final Creator<BindableFloat> CREATOR = new Creator<BindableFloat>() {
        @Override
        public BindableFloat createFromParcel(Parcel source) {
            return new BindableFloat(source);
        }

        @Override
        public BindableFloat[] newArray(int size) {
            return new BindableFloat[size];
        }
    };

    public BindableFloat() {
        super();
    }

    public BindableFloat(float value) {
        super(value);
    }

    protected BindableFloat(Parcel in) {
        this.mValue = in.readFloat();
    }

    @Override
    public Float get() {
        Float value = super.get();
        return (value != null) ? value : 0;
    }

    @Override
    public void set(final Float value) {
        super.set(value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(this.mValue);
    }
}
