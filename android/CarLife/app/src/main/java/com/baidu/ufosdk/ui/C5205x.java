package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.util.C5216i;
import com.baidu.ufosdk.util.C5223p;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.x */
public final class C5205x extends BaseAdapter {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21682a;
    /* renamed from: b */
    private Context f21683b;

    public C5205x(FeedbackFacePageActivity feedbackFacePageActivity, Context context) {
        this.f21682a = feedbackFacePageActivity;
        this.f21683b = context;
    }

    public final int getCount() {
        return this.f21682a.f21434y.size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C5206y c5206y;
        if (view == null) {
            C5206y c5206y2 = new C5206y(this);
            view = new RelativeLayout(this.f21683b);
            view.setBackgroundColor(-723724);
            view.setLayoutParams(new LayoutParams(-1, C5216i.m17757a(this.f21682a.getApplicationContext(), 40.0f)));
            View textView = new TextView(this.f21683b);
            textView.setId(C0965R.string.alert_gps_not_open_and_set);
            textView.setEllipsize(TruncateAt.END);
            textView.setSingleLine(true);
            textView.setTextColor(C5167a.f21338J);
            textView.setTextSize(C5167a.ad);
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(16);
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(C5216i.m17757a(this.f21682a.getApplicationContext(), 7.0f), C5216i.m17757a(this.f21682a.getApplicationContext(), 5.0f), C5216i.m17757a(this.f21682a.getApplicationContext(), 7.0f), C5216i.m17757a(this.f21682a.getApplicationContext(), 5.0f));
            layoutParams.addRule(13);
            layoutParams.addRule(9);
            view.addView(textView, layoutParams);
            view.setBackgroundDrawable(C5223p.m17780a(this.f21682a.getApplicationContext(), C5167a.f21380z, "ufo_list_press.png"));
            c5206y2.f21684a = textView;
            view.setTag(c5206y2);
            c5206y = c5206y2;
        } else {
            c5206y = (C5206y) view.getTag();
        }
        c5206y.f21684a.setText(((dc) this.f21682a.f21434y.get(i)).f21661b);
        Drawable bitmapDrawable = new BitmapDrawable(C5223p.m17779a(this.f21682a.getApplicationContext(), "ufo_search_icon.png"));
        bitmapDrawable.setBounds(0, 0, C5216i.m17757a(this.f21682a.getApplicationContext(), 12.0f), C5216i.m17757a(this.f21682a.getApplicationContext(), 12.0f));
        c5206y.f21684a.setCompoundDrawables(bitmapDrawable, null, null, null);
        c5206y.f21684a.setCompoundDrawablePadding(5);
        return view;
    }
}
