package com.baidu.carlife.view.p104a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.util.C2188r;

/* compiled from: StateDrawableUtil */
/* renamed from: com.baidu.carlife.view.a.b */
public class C2251b {
    /* renamed from: a */
    public static StateListDrawable m8527a(Context context) {
        Drawable recCirclePressStateDrawable = new C2250a(context.getResources().getDimension(R.dimen.common_item_width), context.getResources().getDimension(R.dimen.common_item_height_64), C2188r.m8328a((int) R.color.cl_press_g));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, recCirclePressStateDrawable);
        stateListDrawable.addState(new int[]{16842913}, recCirclePressStateDrawable);
        stateListDrawable.addState(new int[]{16842908}, ContextCompat.getDrawable(context, R.drawable.com_bg_foucs));
        stateListDrawable.addState(new int[]{16843161}, new ColorDrawable(0));
        return stateListDrawable;
    }

    /* renamed from: b */
    public static StateListDrawable m8528b(Context context) {
        Drawable recCirclePressStateDrawable = new C2250a(context.getResources().getDimension(R.dimen.common_item_width), context.getResources().getDimension(R.dimen.common_item_height_64), C2188r.m8328a((int) R.color.cl_press_g));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, recCirclePressStateDrawable);
        stateListDrawable.addState(new int[]{16842913}, recCirclePressStateDrawable);
        stateListDrawable.addState(new int[]{16842908}, ContextCompat.getDrawable(context, R.drawable.com_bg_foucs));
        stateListDrawable.addState(new int[]{16843161}, new ColorDrawable(0));
        return stateListDrawable;
    }

    /* renamed from: c */
    public static StateListDrawable m8529c(Context context) {
        Drawable recCirclePressStateDrawable = new C2250a((context.getResources().getDimension(R.dimen.phone_soft_input_dial_plate_width) - (context.getResources().getDimension(R.dimen.phone_soft_input_dial_plate_hori_margin) * 2.0f)) / 3.0f, (((float) CarlifeScreenUtil.m4331a().m4352i()) - (context.getResources().getDimension(R.dimen.phone_soft_input_dial_plate_vert_margin) * 2.0f)) / 4.0f, C2188r.m8328a((int) R.color.cl_press_g), 1);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, recCirclePressStateDrawable);
        stateListDrawable.addState(new int[]{16842913}, recCirclePressStateDrawable);
        stateListDrawable.addState(new int[]{16842908}, ContextCompat.getDrawable(context, R.drawable.com_bg_foucs));
        stateListDrawable.addState(new int[]{16843161}, new ColorDrawable(0));
        return stateListDrawable;
    }

    /* renamed from: d */
    public static StateListDrawable m8530d(Context context) {
        Drawable recCirclePressStateDrawable = new C2250a(context.getResources().getDimension(R.dimen.common_two_tap_width), context.getResources().getDimension(R.dimen.common_item_height_64), C2188r.m8328a((int) R.color.cl_press_g));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, recCirclePressStateDrawable);
        stateListDrawable.addState(new int[]{16842913}, recCirclePressStateDrawable);
        stateListDrawable.addState(new int[]{16842908}, ContextCompat.getDrawable(context, R.drawable.com_bg_foucs));
        stateListDrawable.addState(new int[]{16843161}, new ColorDrawable(0));
        return stateListDrawable;
    }
}
