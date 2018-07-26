package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.baidunavis.BaiduNaviParams;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.util.C5216i;
import com.baidu.ufosdk.util.C5223p;
import java.util.Map;

/* compiled from: FeedbackListActivity */
public final class cw extends BaseAdapter {
    /* renamed from: a */
    final /* synthetic */ FeedbackListActivity f21640a;
    /* renamed from: b */
    private Context f21641b;

    public cw(FeedbackListActivity feedbackListActivity, Context context) {
        this.f21640a = feedbackListActivity;
        this.f21641b = context;
    }

    public final int getCount() {
        return this.f21640a.f21515e.size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        cv cvVar;
        if (view == null) {
            cv cvVar2 = new cv(this.f21640a);
            view = new LinearLayout(this.f21641b);
            view.setBackgroundColor(-1184275);
            view.setOrientation(1);
            view.setLayoutParams(new LayoutParams(-1, -2));
            View relativeLayout = new RelativeLayout(this.f21641b);
            relativeLayout.setBackgroundColor(-1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            View textView = new TextView(this.f21641b);
            textView.setId(2132344840);
            ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(C5216i.m17757a(this.f21640a.getApplicationContext(), 6.0f), C5216i.m17757a(this.f21640a.getApplicationContext(), 6.0f));
            layoutParams2.setMargins(C5216i.m17757a(this.f21640a.getApplicationContext(), 8.0f), C5216i.m17757a(this.f21640a.getApplicationContext(), 17.0f), 0, 0);
            layoutParams2.addRule(10);
            layoutParams2.addRule(9);
            relativeLayout.addView(textView, layoutParams2);
            View textView2 = new TextView(this.f21641b);
            textView2.setId(2132344842);
            textView2.setTextColor(C5167a.f21330B);
            textView2.setTextSize(15.0f);
            textView2.setGravity(17);
            textView2.setPadding(0, 0, 0, 0);
            ViewGroup.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(C5216i.m17757a(this.f21640a.getApplicationContext(), 40.0f), -1);
            layoutParams3.addRule(1, textView.getId());
            layoutParams3.addRule(13);
            layoutParams3.setMargins(0, 0, C5216i.m17757a(this.f21640a.getApplicationContext(), 10.0f), 0);
            relativeLayout.addView(textView2, layoutParams3);
            View view2 = new View(this.f21641b);
            view2.setBackgroundColor(-1184275);
            view2.setId(2132344844);
            ViewGroup.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(C5216i.m17757a(this.f21640a.getApplicationContext(), 0.8f), -1);
            layoutParams4.setMargins(0, C5216i.m17757a(this.f21640a.getApplicationContext(), 5.0f), C5216i.m17757a(this.f21640a.getApplicationContext(), 15.0f), C5216i.m17757a(this.f21640a.getApplicationContext(), 5.0f));
            layoutParams4.addRule(1, textView2.getId());
            relativeLayout.addView(view2, layoutParams4);
            View imageView = new ImageView(this.f21641b);
            imageView.setId(2132344846);
            imageView.setBackgroundDrawable(new BitmapDrawable(C5223p.m17779a(this.f21640a.getApplicationContext(), "ufo_next_icon.png")));
            ViewGroup.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(C5216i.m17757a(this.f21640a.getApplicationContext(), 9.0f), C5216i.m17757a(this.f21640a.getApplicationContext(), 17.0f));
            layoutParams5.addRule(11);
            layoutParams5.addRule(13);
            relativeLayout.addView(imageView, layoutParams5);
            View textView3 = new TextView(this.f21641b);
            textView3.setTextSize(C5167a.aa);
            textView3.setEllipsize(TruncateAt.END);
            textView3.setSingleLine(true);
            textView3.setTextColor(C5167a.f21329A);
            textView3.setId(2132344845);
            textView3.setGravity(16);
            ViewGroup.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams6.addRule(1, view2.getId());
            layoutParams6.addRule(0, imageView.getId());
            relativeLayout.addView(textView3, layoutParams6);
            relativeLayout.setBackgroundDrawable(C5223p.m17780a(this.f21640a.getApplicationContext(), C5167a.f21380z, "ufo_list_press.png"));
            view2 = new TextView(this.f21641b);
            view2.setTextColor(C5167a.f21330B);
            view2.setBackgroundColor(-1184275);
            view2.setTextSize(C5167a.f21353Y);
            view2.setGravity(17);
            view2.setPadding(0, C5216i.m17757a(this.f21640a.getApplicationContext(), 10.0f), 0, C5216i.m17757a(this.f21640a.getApplicationContext(), 5.0f));
            view.addView(view2, new LinearLayout.LayoutParams(-1, -2));
            view.addView(relativeLayout, new LinearLayout.LayoutParams(-1, C5216i.m17757a(this.f21640a.getApplicationContext(), 50.0f)));
            relativeLayout.setPadding(0, 0, C5216i.m17757a(this.f21640a.getApplicationContext(), 15.0f), 0);
            cvVar2.f21634a = view2;
            cvVar2.f21635b = textView;
            cvVar2.f21636c = textView2;
            cvVar2.f21637d = textView3;
            cvVar2.f21638e = imageView;
            view.setTag(cvVar2);
            cvVar = cvVar2;
        } else {
            cvVar = (cv) view.getTag();
        }
        cvVar.f21637d.setText((String) ((Map) this.f21640a.f21515e.get(i)).get("content"));
        if (i == 0 || !FeedbackListActivity.m17690a((String) ((Map) this.f21640a.f21515e.get(i)).get(BaiduNaviParams.KEY_TIME), (String) ((Map) this.f21640a.f21515e.get(i - 1)).get(BaiduNaviParams.KEY_TIME))) {
            cvVar.f21634a.setVisibility(0);
            cvVar.f21634a.setText(FeedbackListActivity.m17691b((String) ((Map) this.f21640a.f21515e.get(i)).get(BaiduNaviParams.KEY_TIME)));
        } else {
            cvVar.f21634a.setVisibility(8);
        }
        cvVar.f21636c.setText(FeedbackListActivity.m17686a((String) ((Map) this.f21640a.f21515e.get(i)).get(BaiduNaviParams.KEY_TIME)));
        if (((String) ((Map) this.f21640a.f21515e.get(i)).get("newmsg")).equals("0")) {
            cvVar.f21635b.setBackgroundDrawable(null);
        } else {
            cvVar.f21635b.setBackgroundDrawable(new BitmapDrawable(FeedbackListActivity.m17703m(this.f21640a)));
        }
        return view;
    }
}
