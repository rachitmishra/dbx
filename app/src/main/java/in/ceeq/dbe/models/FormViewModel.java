package in.ceeq.dbe.models;

import android.content.Context;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import in.ceeq.dbe.FormActivity;
import in.ceeq.dbx.core.BaseViewModel;
import in.ceeq.dbx.core.types.BindableString;


public class FormViewModel extends BaseViewModel {

    public BindableString name = new BindableString();
    public BindableString dateOfBirth = new BindableString();
    public BindableString gender = new BindableString();
    public BindableString action = new BindableString();
    private FormActivity mFormActivity;

    public FormViewModel(Context context) {
        mFormActivity = (FormActivity) context;
    }

    @SuppressWarnings("unused, databinding")
    public void onSubmitButtonClick(View view) {
        mFormActivity.handleSubmitClick();
    }

    @SuppressWarnings("unused, databinding")
    public void onDateOfBirthClick(View view) {
        mFormActivity.handleDateOfBirthClick(dateOfBirth.get());
    }

    @SuppressWarnings("unused, databinding")
    public void onGenderClick(View view) {
        mFormActivity.handleGenderClick();
    }

    @SuppressWarnings("unused, databinding")
    public boolean onSubmitImeAction(TextView textView, int actionId, KeyEvent event) {
        if (EditorInfo.IME_ACTION_GO == actionId) {
            mFormActivity.handleSubmitClick();
            return true;
        }

        return false;
    }

    @SuppressWarnings("unused, databinding")
    public void afterDateOfBirthTextChanged(Editable editable) {
        if (editable != null) {
            if (!dateOfBirth.isEmpty()) {
                dateOfBirth.set("");
            }
            dateOfBirth.set(editable.toString());
        }
    }


    @SuppressWarnings("unused, databinding")
    public void afterGenderTextChanged(Editable editable) {
        if (editable != null) {
            if (!gender.isEmpty()) {
                gender.set("");
            }
            gender.set(editable.toString());
            gender.toTitleCase();
        }
    }

    @SuppressWarnings("unused, databinding")
    public void afterNameTextChanged(Editable editable) {
        if (editable != null) {
            if (!name.isEmpty()) {
                name.set("");
            }
            name.set(editable.toString());
            name.toTitleCase();
        }
    }
}
