package in.ceeq.dbx.core;

import android.databinding.BindingAdapter;
import android.view.View;

import in.ceeq.dbx.core.types.BindableBoolean;
import in.ceeq.dbx.core.types.BindableInteger;
import in.ceeq.dbx.core.types.BindableString;
import in.ceeq.dbx.helpers.BindingAttributeClass;

@BindingAttributeClass
public class ViewBindingAttribute {

    @BindingAdapter("visible")
    public static void bindVisible(final View view, final boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("visible")
    public static void bindVisible(final View view, final BindableBoolean visible) {
        if (null != visible) {
            view.setVisibility(visible.get() ? View.VISIBLE : View.GONE);
        }
    }

    @BindingAdapter("visible")
    public static void bindVisible(final View view, final BindableString bindableString) {
        if (null != bindableString) {
            view.setVisibility(!(bindableString.isEmpty()) ? View.VISIBLE : View.GONE);
        }
    }

    @BindingAdapter("enable")
    public static void bindEnable(final View view, final BindableString bindableString) {
        if (null != bindableString) {
            view.setEnabled(bindableString.isEmpty());
        }
    }

    @BindingAdapter("enable")
    public static void bindEnable(final View view, final BindableBoolean bindableBoolean) {
        if (null != bindableBoolean) {
            view.setEnabled(bindableBoolean.get());
        }
    }

    @BindingAdapter("gone")
    public static void bindGone(final View view, final BindableBoolean observableBoolean) {
        if (null != observableBoolean) {
            view.setVisibility(!(observableBoolean.get()) ? View.VISIBLE : View.GONE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    @BindingAdapter("gone")
    public static void bindGone(final View view, final BindableString bindableString) {
        if (null != bindableString) {
            view.setVisibility(!(bindableString.isEmpty()) ? View.GONE : View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    @BindingAdapter("backgroundSrc")
    public static void bindSrc(final View view, final BindableInteger bindableSrcId) {
        if (bindableSrcId != null) {
            int srcId = bindableSrcId.get();
            if (0 < srcId) {
                view.setBackgroundResource(srcId);
            }
        }
    }
}
