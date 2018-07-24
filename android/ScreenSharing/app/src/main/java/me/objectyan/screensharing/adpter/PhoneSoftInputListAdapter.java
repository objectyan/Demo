package com.baidu.carlife.adpter;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.model.C1936n;
import java.util.List;

/* compiled from: PhoneSoftInputListAdapter */
/* renamed from: com.baidu.carlife.adpter.n */
public class PhoneSoftInputListAdapter extends BaseAdapter {
    /* renamed from: a */
    private String f2551a;
    /* renamed from: b */
    private LayoutInflater f2552b;
    /* renamed from: c */
    private List<C1936n> f2553c;
    /* renamed from: d */
    private String f2554d;
    /* renamed from: e */
    private int f2555e;

    /* compiled from: PhoneSoftInputListAdapter */
    /* renamed from: com.baidu.carlife.adpter.n$a */
    private class C1001a {
        /* renamed from: a */
        TextView f2548a;
        /* renamed from: b */
        TextView f2549b;
        /* renamed from: c */
        final /* synthetic */ PhoneSoftInputListAdapter f2550c;

        private C1001a(PhoneSoftInputListAdapter phoneSoftInputListAdapter) {
            this.f2550c = phoneSoftInputListAdapter;
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m3218a(i);
    }

    public PhoneSoftInputListAdapter(Context context) {
        this.f2552b = LayoutInflater.from(context);
        this.f2551a = context.getString(R.string.phone_name_unknown);
        this.f2555e = context.getResources().getColor(R.color.cl_other_c_highlight);
    }

    /* renamed from: a */
    public void m3220a(List<C1936n> contactsList) {
        this.f2553c = contactsList;
    }

    /* renamed from: a */
    public void m3219a(String input) {
        this.f2554d = input;
    }

    public int getCount() {
        if (this.f2553c == null) {
            return 0;
        }
        return this.f2553c.size();
    }

    /* renamed from: a */
    public C1936n m3218a(int position) {
        if (this.f2553c == null) {
            return null;
        }
        return (C1936n) this.f2553c.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C1001a viewCache;
        if (convertView == null) {
            convertView = this.f2552b.inflate(R.layout.phone_softinput_list_item, parent, false);
            viewCache = new C1001a();
            viewCache.f2548a = (TextView) convertView.findViewById(R.id.tv_phonebook_name);
            viewCache.f2549b = (TextView) convertView.findViewById(R.id.tv_phonebook_num);
            convertView.setTag(viewCache);
        }
        viewCache = (C1001a) convertView.getTag();
        C1936n contact = m3218a(position);
        if (contact != null) {
            if (TextUtils.isEmpty(contact.f6104a)) {
                viewCache.f2548a.setText(this.f2551a);
            } else {
                viewCache.f2548a.setText(contact.f6104a);
            }
            viewCache.f2549b.setText(m3217a(contact.f6105b, this.f2554d));
        }
        return convertView;
    }

    /* renamed from: a */
    private SpannableString m3217a(String num, String input) {
        SpannableString span = new SpannableString(num);
        int index = 0;
        if (!TextUtils.isEmpty(this.f2554d)) {
            index = num.indexOf(this.f2554d);
        }
        if (index == -1) {
            index = 0;
        }
        span.setSpan(new ForegroundColorSpan(this.f2555e), index, input.length() + index, 33);
        return span;
    }
}
