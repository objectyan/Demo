package com.baidu.carlife.adpter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.R;
import com.baidu.carlife.model.C1935m;
import com.baidu.carlife.util.C2188r;
import java.util.List;

/* compiled from: CallLogListAdapter */
/* renamed from: com.baidu.carlife.adpter.a */
public class CallLogListAdapter extends BaseAdapter {
    /* renamed from: a */
    private LayoutInflater f2453a;
    /* renamed from: b */
    private List<C1935m> f2454b = null;
    /* renamed from: c */
    private String f2455c;

    /* compiled from: CallLogListAdapter */
    /* renamed from: com.baidu.carlife.adpter.a$a */
    private static class C0970a {
        /* renamed from: a */
        TextView f2448a;
        /* renamed from: b */
        TextView f2449b;
        /* renamed from: c */
        View f2450c;
        /* renamed from: d */
        TextView f2451d;
        /* renamed from: e */
        View f2452e;

        private C0970a() {
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m3173a(i);
    }

    public CallLogListAdapter(Context context) {
        this.f2453a = LayoutInflater.from(context);
        this.f2455c = BaiduNaviApplication.getInstance().getApplicationContext().getString(R.string.module_tele_unknow_name);
    }

    /* renamed from: a */
    public void m3174a(List<C1935m> list) {
        this.f2454b = list;
    }

    public int getCount() {
        if (this.f2454b == null) {
            return 0;
        }
        return this.f2454b.size();
    }

    /* renamed from: a */
    public C1935m m3173a(int position) {
        if (this.f2454b == null) {
            return null;
        }
        return (C1935m) this.f2454b.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0970a cache;
        if (convertView == null) {
            convertView = this.f2453a.inflate(R.layout.call_log_list_item, parent, false);
            cache = new C0970a();
            cache.f2448a = (TextView) convertView.findViewById(R.id.tv_calllog_name);
            cache.f2449b = (TextView) convertView.findViewById(R.id.tv_calllog_count);
            cache.f2450c = convertView.findViewById(R.id.iv_calllog_type);
            cache.f2451d = (TextView) convertView.findViewById(R.id.tv_calllog_time);
            cache.f2452e = convertView.findViewById(R.id.cl_line);
            convertView.setTag(cache);
        } else {
            cache = (C0970a) convertView.getTag();
        }
        C1935m callRecord = m3173a(position);
        if (callRecord == null) {
            return null;
        }
        if (position == getCount() - 1) {
            cache.f2452e.setVisibility(8);
        } else {
            cache.f2452e.setVisibility(0);
        }
        int calllogType = callRecord.f6101d;
        if (calllogType == 2) {
            cache.f2450c.setVisibility(0);
        } else {
            cache.f2450c.setVisibility(8);
        }
        if (calllogType == 3) {
            cache.f2448a.setTextColor(C2188r.m8328a((int) R.color.cl_other_a_highlight));
            cache.f2449b.setTextColor(C2188r.m8328a((int) R.color.cl_other_a_highlight));
        } else {
            cache.f2448a.setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_content));
            cache.f2449b.setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_content));
        }
        String calllogName = this.f2455c;
        if (!TextUtils.isEmpty(callRecord.f6098a)) {
            calllogName = callRecord.f6098a;
        } else if (!TextUtils.isEmpty(callRecord.f6099b)) {
            calllogName = callRecord.f6099b;
        }
        cache.f2448a.setText(calllogName);
        if (callRecord.f6100c > 1) {
            cache.f2449b.setText("(" + callRecord.f6100c + ")");
        } else {
            cache.f2449b.setText("");
        }
        if (TextUtils.isEmpty(callRecord.f6103f)) {
            cache.f2451d.setText("");
            return convertView;
        }
        cache.f2451d.setText(callRecord.f6103f);
        return convertView;
    }
}
