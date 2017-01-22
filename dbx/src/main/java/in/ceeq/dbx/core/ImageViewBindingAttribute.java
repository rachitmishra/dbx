package in.ceeq.dbx.core;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import in.ceeq.dbx.core.types.BindableInteger;
import in.ceeq.dbx.helpers.BindingAttributeClass;

@BindingAttributeClass
public class ImageViewBindingAttribute {

    @BindingAdapter("src")
    public static void bindSrc(final ImageView view, final BindableInteger bindableSrcId) {
        if (null != bindableSrcId) {
            int srcId = bindableSrcId.get();
            if (0 < srcId) {
                view.setImageResource(srcId);
            }
        }
    }

    @BindingAdapter("src")
    public static void bindSrc(final ImageView view, final int srcId) {
        if (0 < srcId) {
            view.setImageResource(srcId);
        }
    }
}
