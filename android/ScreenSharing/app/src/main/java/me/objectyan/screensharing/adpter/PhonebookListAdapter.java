package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.model.C1936n;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.pinnedheaderlistview.C1006b;
import com.baidu.carlife.view.pinnedheaderlistview.C2352a;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: PhonebookListAdapter */
/* renamed from: com.baidu.carlife.adpter.o */
public class PhonebookListAdapter extends C1006b {
    /* renamed from: a */
    private LayoutInflater f2566a;
    /* renamed from: b */
    private Map<String, List<C1936n>> f2567b = null;
    /* renamed from: c */
    private String[] f2568c = null;
    /* renamed from: d */
    private C2352a f2569d = null;
    /* renamed from: e */
    private int[] f2570e = null;
    /* renamed from: f */
    private String[] f2571f = null;

    /* compiled from: PhonebookListAdapter */
    /* renamed from: com.baidu.carlife.adpter.o$a */
    private class C1004a {
        /* renamed from: a */
        TextView f2556a;
        /* renamed from: b */
        TextView f2557b;
        /* renamed from: c */
        final /* synthetic */ PhonebookListAdapter f2558c;

        private C1004a(PhonebookListAdapter phonebookListAdapter) {
            this.f2558c = phonebookListAdapter;
        }
    }

    /* renamed from: c */
    public /* synthetic */ Object mo1376c(int i, int i2) {
        return m3248a(i, i2);
    }

    public PhonebookListAdapter(Context context) {
        this.f2566a = LayoutInflater.from(context);
    }

    /* renamed from: a */
    public void m3249a(Map<String, List<C1936n>> list) {
        if (list != null && list.size() >= 1) {
            this.f2567b = list;
            this.f2568c = new String[this.f2567b.size()];
            this.f2567b.keySet().toArray(this.f2568c);
            m3240d();
            m3241e();
            this.f2570e = new int[this.f2567b.size()];
            for (int i = 0; i < this.f2568c.length; i++) {
                this.f2570e[i] = mo1374b(i);
            }
            this.f2569d = new C2352a(this.f2568c, this.f2570e);
        }
    }

    /* renamed from: d */
    private void m3240d() {
        int j;
        String[] tmp = new String[this.f2567b.size()];
        int j2 = 0;
        int k = 0;
        int i = 0;
        while (i < this.f2568c.length) {
            if (this.f2568c[i].compareTo("A") < 0 || this.f2568c[i].compareTo("Z") > 0) {
                int k2 = k + 1;
                tmp[k] = this.f2568c[i];
                k = k2;
            } else {
                j = j2 + 1;
                this.f2568c[j2] = this.f2568c[i];
                j2 = j;
            }
            i++;
        }
        Arrays.sort(this.f2568c, 0, this.f2568c.length - k);
        if (tmp != null && k > 0) {
            Arrays.sort(tmp, 0, k);
        }
        i = 0;
        j = j2;
        while (i < k) {
            j2 = j + 1;
            this.f2568c[j] = tmp[i];
            i++;
            j = j2;
        }
    }

    /* renamed from: a */
    public int mo1372a(int section) {
        if (this.f2569d != null) {
            return this.f2569d.getPositionForSection(section);
        }
        return -1;
    }

    /* renamed from: a */
    public int m3245a(String key) {
        int section;
        if ("#".equalsIgnoreCase(key)) {
            section = this.f2571f.length;
        } else if (this.f2571f == null || this.f2571f.length <= 0) {
            try {
                section = Arrays.binarySearch(this.f2568c, key);
            } catch (NullPointerException e) {
                return -2;
            }
        } else {
            section = Arrays.binarySearch(this.f2571f, key);
        }
        if (section >= 0) {
            return section;
        }
        return (-section) - 1;
    }

    /* renamed from: e */
    private void m3241e() {
        int k = 0;
        int i = 0;
        while (i < this.f2568c.length) {
            if (this.f2568c[i].compareTo("A") >= 0 && this.f2568c[i].compareTo("Z") <= 0) {
                k++;
            }
            i++;
        }
        if (k != 0) {
            this.f2571f = new String[k];
            int j = 0;
            i = 0;
            while (j < k && i < this.f2568c.length) {
                if (this.f2568c[i].compareTo("A") >= 0 && this.f2568c[i].compareTo("Z") <= 0) {
                    this.f2571f[j] = this.f2568c[i];
                    j++;
                }
                i++;
            }
        }
    }

    /* renamed from: g */
    private List<C1936n> m3242g(int section) {
        if (this.f2567b == null || this.f2567b.size() < 1) {
            return null;
        }
        return (List) this.f2567b.get(this.f2568c[section]);
    }

    /* renamed from: a */
    public C1936n m3248a(int section, int position) {
        List<C1936n> temp = m3242g(section);
        if (temp == null || temp.size() < 1) {
            return null;
        }
        return (C1936n) temp.get(position);
    }

    /* renamed from: b */
    public long mo1375b(int section, int position) {
        return 0;
    }

    /* renamed from: a */
    public int mo1371a() {
        if (this.f2567b == null) {
            return 0;
        }
        return this.f2567b.size();
    }

    /* renamed from: b */
    public int mo1374b(int section) {
        List<C1936n> list = m3242g(section);
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: a */
    public View mo1373a(int section, int position, View convertView, ViewGroup parent) {
        C1004a viewCache;
        if (convertView == null) {
            convertView = this.f2566a.inflate(R.layout.phone_book_list_item, parent, false);
            viewCache = new C1004a();
            viewCache.f2556a = (TextView) convertView.findViewById(R.id.tv_phonebook_name);
            viewCache.f2557b = (TextView) convertView.findViewById(R.id.tv_phonebook_num);
            convertView.setTag(viewCache);
        }
        viewCache = (C1004a) convertView.getTag();
        C1936n contact = m3248a(section, position);
        if (contact == null) {
            return null;
        }
        viewCache.f2556a.setText(contact.f6104a);
        viewCache.f2557b.setText(contact.f6105b);
        viewCache.f2556a.setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_content));
        viewCache.f2557b.setTextColor(C2188r.m8328a((int) R.color.cl_text_a2_content));
        return convertView;
    }

    /* renamed from: a */
    public View mo1366a(int section, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.f2566a.inflate(R.layout.contact_header_item, parent, false);
        }
        convertView.setBackground(C2188r.m8331b(R.color.cl_bg_a_input));
        ((TextView) convertView.findViewById(R.id.section_tv)).setText(String.valueOf(this.f2568c[section]));
        return convertView;
    }
}
