package in.ceeq.dbx.core;

import android.databinding.BindingAdapter;
import android.text.InputType;
import android.widget.EditText;

import in.ceeq.dbx.core.types.BindableBoolean;
import in.ceeq.dbx.core.types.BindableString;
import in.ceeq.dbx.helpers.BindingAttributeClass;


@BindingAttributeClass
public class EditTextBindingAttribute {

    @BindingAdapter("text")
    public static void bindText(final EditText view, final BindableString bindableString) {
        if (null != bindableString) {
            String newValue = bindableString.get();
            if (!view.getText().toString().equals(newValue)) {
                view.setText(newValue);
                view.setSelection(view.getText().length());
            }
        }
    }

    @BindingAdapter("hint")
    public static void bindHint(final EditText view, final BindableString bindableString) {
        if (null != bindableString) {
            String newValue = bindableString.get();
            view.setHint(newValue);
        }
    }

    @BindingAdapter("mask")
    public static void bindMask(final EditText view, BindableBoolean bindableBoolean) {
        if (null != bindableBoolean) {
            view.setInputType(bindableBoolean.get() ?
                    InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD :
                    InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            view.setSelection(view.getText().length());
        }
    }
}
