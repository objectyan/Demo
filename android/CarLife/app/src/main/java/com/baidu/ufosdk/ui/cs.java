package com.baidu.ufosdk.ui;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.PopupWindow;
import com.baidu.ufosdk.util.C5216i;
import com.baidu.ufosdk.util.C5228u;
import java.util.Map;

/* compiled from: FeedbackListActivity */
final class cs implements OnItemLongClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackListActivity f21631a;

    cs(FeedbackListActivity feedbackListActivity) {
        this.f21631a = feedbackListActivity;
    }

    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        View a = this.f21631a.m17683a(this.f21631a.getApplicationContext(), C5228u.m17794a("3"), (String) ((Map) this.f21631a.f21515e.get(i)).get("id"));
        this.f21631a.f21508A = new PopupWindow(a, C5216i.m17757a(this.f21631a.getApplicationContext(), 79.0f), C5216i.m17757a(this.f21631a.getApplicationContext(), 68.0f));
        this.f21631a.f21508A.setFocusable(false);
        this.f21631a.f21508A.setOutsideTouchable(true);
        this.f21631a.f21508A.setBackgroundDrawable(new BitmapDrawable());
        a.getLocationOnScreen(new int[2]);
        this.f21631a.f21508A.showAtLocation(this.f21631a.f21511a, 17, 0, 0);
        return true;
    }
}
