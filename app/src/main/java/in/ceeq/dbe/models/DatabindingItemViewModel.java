package in.ceeq.dbe.models;

import android.content.Context;
import android.view.View;

import in.ceeq.dbe.HomeActivity;
import in.ceeq.dbx.core.BaseViewModel;
import in.ceeq.dbx.core.types.BindableInteger;
import in.ceeq.dbx.core.types.BindableString;

public class DatabindingItemViewModel extends BaseViewModel {

    public BindableString title = new BindableString();
    public BindableString value = new BindableString();
    public BindableString rating = new BindableString();
    public BindableString suggestion = new BindableString();
    public BindableInteger trend = new BindableInteger();
    public BindableString button = new BindableString();
    public BindableInteger color = new BindableInteger();

    private HomeActivity mHomActivity;

    public DatabindingItemViewModel(Context context) {
        mHomActivity = (HomeActivity) context;
    }

    @SuppressWarnings("unused, databinding")
    public void onButtonClick(View view) {
        mHomActivity.handleButtonClick();
    }


    public void setFromItem(DatabindingItem databindingItem) {
        title.set(databindingItem.title);
        value.set(databindingItem.value);
        rating.set(databindingItem.rating);
        suggestion.set(databindingItem.suggestion);
        button.set(databindingItem.button);
        color.set(databindingItem.color);
    }
}
