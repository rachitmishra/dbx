package in.ceeq.dbx.core;

import android.databinding.BindingAdapter;
import android.widget.Button;

import in.ceeq.dbx.core.types.BindableString;
import in.ceeq.dbx.helpers.BindingAttributeClass;

@BindingAttributeClass
public class ButtonBindingAttribute {

    @BindingAdapter("text")
    public static void bindText(final Button view, final BindableString bindableString) {
        if (null != bindableString) {
            String newValue = bindableString.get();
            view.setText(newValue);
        }
    }
}
