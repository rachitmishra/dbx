package in.ceeq.dbx.core;

import android.os.Parcel;
import android.os.Parcelable;

import in.ceeq.dbx.core.types.BindableBoolean;
import in.ceeq.dbx.core.types.BindableString;

public class BaseViewModel implements Parcelable {

    public BindableBoolean mProgressViewVisible = new BindableBoolean();
    public BindableBoolean mErrorViewVisible = new BindableBoolean();
    public BindableBoolean mEmptyViewVisible = new BindableBoolean();
    public BindableBoolean mToolbarVisible = new BindableBoolean(true);
    public BindableString mErrorMessage = new BindableString();
    public BindableString mToolbarTitle = new BindableString();
    public BindableString mProgressMessage = new BindableString();
    public BindableString mEmptyMessage = new BindableString();

    public BaseViewModel() {
    }

    public void setProgressMessage(String progressMessage) {
        mProgressMessage.set(progressMessage);
    }

    public void setEmptyMessage(String emptyMessage) {
        mEmptyMessage.set(emptyMessage);
    }

    public String getProgressMessage() {
        return mProgressMessage.get();
    }

    public String getEmptyMessage() {
        return mEmptyMessage.get();
    }

    public void setProgressViewVisible(final boolean progressViewVisible) {
        mProgressViewVisible.set(progressViewVisible);
        if (!progressViewVisible && !mProgressMessage.isEmpty()) {
            mProgressMessage.set("");
        }
    }

    public void setOnlyProgressViewVisible(final boolean progressViewVisible) {
        mProgressViewVisible.set(progressViewVisible);
    }

    public void setEmptyViewVisible(final boolean emptyViewVisible) {
        mEmptyViewVisible.set(emptyViewVisible);
    }

    public void setToolbarVisible(final boolean toolbarVisible) {
        mToolbarVisible.set(toolbarVisible);
    }

    public void setErrorMessage(String errorMessage) {
        mErrorMessage.set(errorMessage);
    }

    public void setErrorViewVisible(final boolean errorViewVisible) {
        mErrorViewVisible.set(errorViewVisible);
    }

    public void setToolbarTitle(final String toolbarTitle) {
        mToolbarTitle.set(toolbarTitle);
    }

    public String getToolbarTitle() {
        return mToolbarTitle.get();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mProgressViewVisible, flags);
        dest.writeParcelable(mErrorViewVisible, flags);
        dest.writeParcelable(mEmptyViewVisible, flags);
        dest.writeParcelable(mToolbarVisible, flags);
        dest.writeParcelable(mErrorMessage, flags);
        dest.writeParcelable(mToolbarTitle, flags);
        dest.writeParcelable(mProgressMessage, flags);
        dest.writeParcelable(mEmptyMessage, flags);
    }

    protected BaseViewModel(Parcel in) {
        mProgressViewVisible = in.readParcelable(BindableBoolean.class.getClassLoader());
        mErrorViewVisible = in.readParcelable(BindableBoolean.class.getClassLoader());
        mEmptyViewVisible = in.readParcelable(BindableBoolean.class.getClassLoader());
        mToolbarVisible = in.readParcelable(BindableBoolean.class.getClassLoader());
        mErrorMessage = in.readParcelable(BindableString.class.getClassLoader());
        mToolbarTitle = in.readParcelable(BindableString.class.getClassLoader());
        mProgressMessage = in.readParcelable(BindableString.class.getClassLoader());
        mEmptyMessage = in.readParcelable(BindableString.class.getClassLoader());
    }

    public static final Creator<BaseViewModel> CREATOR = new Creator<BaseViewModel>() {
        @Override
        public BaseViewModel createFromParcel(Parcel source) {
            return new BaseViewModel(source);
        }

        @Override
        public BaseViewModel[] newArray(int size) {
            return new BaseViewModel[size];
        }
    };
}
