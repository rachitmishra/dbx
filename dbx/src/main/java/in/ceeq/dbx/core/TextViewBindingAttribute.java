package in.ceeq.dbx.core;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import in.ceeq.dbx.core.types.BindableInteger;
import in.ceeq.dbx.core.types.BindableString;
import in.ceeq.dbx.helpers.BindingAttributeClass;

@BindingAttributeClass
public class TextViewBindingAttribute {

    @BindingAdapter("text")
    public static void bindText(final TextView view, final BindableString bindableString) {
        if (null != bindableString) {
            String newValue = bindableString.get();
            view.setText(newValue);
        }
    }

    @BindingAdapter("textColor")
    public static void bindTextColor(final TextView view, final BindableInteger bindableColorId) {
        if (null != bindableColorId) {
            int colorId = bindableColorId.get();
            if (0 < colorId) {
                view.setTextColor(ContextCompat.getColor(view.getContext(), colorId));
            }
        }
    }
}
