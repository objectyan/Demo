package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.map.provider.ProviderUtils;

public class RtPopupOverlayItem {
    public int bgresid = NaviFragmentManager.TYPE_CAR_DRV_LIST;
    public String id;
    public Drawable imgdata;
    public int imgindex;
    public int showLevelMax = 100;
    public int showLevelMin = 0;
    /* renamed from: x */
    public int f19854x;
    /* renamed from: y */
    public int f19855y;

    public int getResId() {
        if (this.imgdata == null) {
            return -1;
        }
        return this.imgdata.hashCode();
    }

    public static RtPopupOverlayItem getPoiDetailRtBusTipOverlayItem(double x, double y, String tip, int color, int bgresid, int showLevel) {
        Context context = C2907c.f();
        RtPopupOverlayItem item = new RtPopupOverlayItem();
        item.bgresid = bgresid;
        item.f19854x = (int) x;
        item.f19855y = (int) y;
        item.showLevelMin = showLevel;
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(1);
        TextView tvTip = new TextView(context);
        tvTip.setMaxWidth(ProviderUtils.dip2px(CommonHandlerThread.MSG_START_RECORD_TRAJECTORY));
        tvTip.setSingleLine(true);
        tvTip.setTextColor(color);
        tvTip.setText(tip);
        layout.addView(tvTip);
        layout.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        layout.layout(0, 0, layout.getMeasuredWidth(), layout.getMeasuredHeight());
        layout.buildDrawingCache();
        Bitmap bitmap = layout.getDrawingCache();
        if (bitmap == null) {
            return null;
        }
        Drawable drawable = new BitmapDrawable(bitmap);
        layout.setDrawingCacheEnabled(false);
        item.imgdata = drawable;
        return item;
    }
}
