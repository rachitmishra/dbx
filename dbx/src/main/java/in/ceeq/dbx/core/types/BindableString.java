package in.ceeq.dbx.core.types;

import android.os.Parcel;

public class BindableString extends BindableField<String> {

    public static final Creator<BindableString> CREATOR = new Creator<BindableString>() {
        public BindableString createFromParcel(Parcel source) {
            return new BindableString(source);
        }

        public BindableString[] newArray(int size) {
            return new BindableString[size];
        }
    };

    public BindableString() {
        super("");
    }

    protected BindableString(Parcel in) {
        mValue = in.readString();
    }

    @Override
    public String get() {
        String value = super.get();
        return (value != null) ? value : "";
    }

    @Override
    public void set(final String value) {
        super.set((value != null) ? value : "");
    }

    public boolean equals(final BindableString value) {
        return !value.isEmpty() && !mValue.isEmpty() && get().equals(value.get());
    }

    public boolean isEmpty() {
        return (null == mValue) || mValue.trim().isEmpty();
    }

    public int length() {
        return (mValue == null) ? 0 : mValue.length();
    }

    public int length(boolean countSpaces) {
        return (mValue == null) ? 0 : countSpaces ? mValue.length() : mValue.trim().length();
    }

    public boolean contains(String s) {
        return (mValue == null) ? false : mValue.contains(s);
    }

    public void clear() {
        set("");
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mValue);
    }

    public void toTitleCase() {
        if (!mValue.isEmpty()) {
            char c = mValue.charAt(0);
            String s = "" + c;
            String f = s.toUpperCase();
            set(f + mValue.substring(1));
        }
    }
}
