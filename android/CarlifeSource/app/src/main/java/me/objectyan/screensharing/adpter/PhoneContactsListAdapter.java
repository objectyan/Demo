package com.baidu.carlife.adpter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.model.C1936n;
import com.baidu.carlife.util.C2188r;
import java.util.List;

/* compiled from: PhoneContactsListAdapter */
/* renamed from: com.baidu.carlife.adpter.m */
public class PhoneContactsListAdapter extends BaseAdapter {
    /* renamed from: a */
    private String f2545a;
    /* renamed from: b */
    private LayoutInflater f2546b;
    /* renamed from: c */
    private List<C1936n> f2547c;

    /* compiled from: PhoneContactsListAdapter */
    /* renamed from: com.baidu.carlife.adpter.m$a */
    private class C0998a {
        /* renamed from: a */
        TextView f2540a;
        /* renamed from: b */
        TextView f2541b;
        /* renamed from: c */
        TextView f2542c;
        /* renamed from: d */
        View f2543d;
        /* renamed from: e */
        final /* synthetic */ PhoneContactsListAdapter f2544e;

        private C0998a(PhoneContactsListAdapter phoneContactsListAdapter) {
            this.f2544e = phoneContactsListAdapter;
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m3215a(i);
    }

    public PhoneContactsListAdapter(Context context) {
        this.f2546b = LayoutInflater.from(context);
        this.f2545a = context.getString(R.string.phone_name_unknown);
    }

    /* renamed from: a */
    public void m3216a(List<C1936n> contactsList) {
        this.f2547c = contactsList;
    }

    public int getCount() {
        if (this.f2547c == null) {
            return 0;
        }
        return this.f2547c.size();
    }

    /* renamed from: a */
    public C1936n m3215a(int position) {
        if (this.f2547c == null) {
            return null;
        }
        return (C1936n) this.f2547c.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0998a viewCache;
        if (convertView == null) {
            convertView = this.f2546b.inflate(R.layout.phone_book_list_item, parent, false);
            viewCache = new C0998a();
            viewCache.f2540a = (TextView) convertView.findViewById(R.id.tv_phonebook_name);
            viewCache.f2541b = (TextView) convertView.findViewById(R.id.tv_phonebook_num);
            viewCache.f2542c = (TextView) convertView.findViewById(R.id.tv_phonebook_type);
            viewCache.f2543d = convertView.findViewById(R.id.cl_line);
            convertView.setTag(viewCache);
        }
        viewCache = (C0998a) convertView.getTag();
        C1936n contact = m3215a(position);
        if (contact != null) {
            if (position == getCount() - 1) {
                viewCache.f2543d.setVisibility(8);
            } else {
                viewCache.f2543d.setVisibility(0);
            }
            if (TextUtils.isEmpty(contact.f6104a)) {
                viewCache.f2540a.setText(this.f2545a);
            } else {
                viewCache.f2540a.setText(contact.f6104a);
            }
            viewCache.f2541b.setText(contact.f6105b);
            viewCache.f2542c.setText(contact.f6108e);
            if (!contact.f6109f && !contact.f6110g) {
                viewCache.f2540a.setVisibility(0);
                viewCache.f2541b.setVisibility(8);
            } else if (contact.f6109f || !contact.f6110g) {
                viewCache.f2540a.setVisibility(4);
                viewCache.f2541b.setVisibility(0);
            } else {
                viewCache.f2540a.setVisibility(0);
                viewCache.f2541b.setVisibility(0);
            }
            viewCache.f2540a.setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_content));
            viewCache.f2541b.setTextColor(C2188r.m8328a((int) R.color.cl_text_a2_content));
            viewCache.f2542c.setTextColor(C2188r.m8328a((int) R.color.cl_text_a2_content));
        }
        return convertView;
    }
}
