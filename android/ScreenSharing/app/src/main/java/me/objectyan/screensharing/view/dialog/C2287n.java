package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.view.dialog.C2286m.C2302a;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import java.util.ArrayList;

/* compiled from: NaviListDialog */
/* renamed from: com.baidu.carlife.view.dialog.n */
public class C2287n extends C2286m {
    /* renamed from: e */
    private ListView f7489e;

    /* compiled from: NaviListDialog */
    /* renamed from: com.baidu.carlife.view.dialog.n$a */
    public class C2303a extends BaseAdapter {
        /* renamed from: a */
        final /* synthetic */ C2287n f7556a;
        /* renamed from: b */
        private ArrayList<String> f7557b = new ArrayList();

        public C2303a(C2287n this$0, ArrayList<String> mDataList) {
            this.f7556a = this$0;
            for (int i = 0; i < mDataList.size(); i++) {
                this.f7557b.add(mDataList.get(i));
            }
        }

        public int getCount() {
            if (this.f7557b == null || this.f7557b.size() <= 0) {
                return 0;
            }
            return this.f7557b.size();
        }

        public Object getItem(int position) {
            if (this.f7557b == null || position < 0 || position >= this.f7557b.size()) {
                return null;
            }
            return this.f7557b.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if (convertView == null) {
                convertView = LayoutInflater.from(this.f7556a.getContext()).inflate(R.layout.tv_iv_list_item, null);
                textView = (TextView) convertView.findViewById(R.id.text_view);
                convertView.setTag(textView);
            } else {
                textView = (TextView) convertView.getTag();
            }
            if (this.f7557b != null && position >= 0 && position < this.f7557b.size()) {
                textView.setText((CharSequence) this.f7557b.get(position));
            }
            if (position == getCount() - 1) {
                textView.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_string_rg_comment_dialog_title));
                convertView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
            } else {
                textView.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_string_rg_comment_dialog_title));
                convertView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_middle));
            }
            return convertView;
        }
    }

    /* renamed from: a */
    public /* synthetic */ C2286m mo1803a(int i) {
        return m8695i(i);
    }

    /* renamed from: a */
    public /* synthetic */ C2286m mo1804a(View view) {
        return m8679c(view);
    }

    /* renamed from: a */
    public /* synthetic */ C2286m mo1805a(C2302a c2302a) {
        return m8680c(c2302a);
    }

    /* renamed from: a */
    public /* synthetic */ C2286m mo1806a(boolean z) {
        return m8681c(z);
    }

    /* renamed from: b */
    public /* synthetic */ C2286m mo1807b(int i) {
        return m8697j(i);
    }

    /* renamed from: b */
    public /* synthetic */ C2286m mo1808b(View view) {
        return m8684d(view);
    }

    /* renamed from: b */
    public /* synthetic */ C2286m mo1809b(C2302a c2302a) {
        return m8685d(c2302a);
    }

    /* renamed from: b */
    public /* synthetic */ C2286m mo1810b(String str) {
        return m8690f(str);
    }

    /* renamed from: b */
    public /* synthetic */ C2286m mo1811b(boolean z) {
        return m8686d(z);
    }

    /* renamed from: c */
    public /* synthetic */ C2286m mo1812c(int i) {
        return m8698k(i);
    }

    /* renamed from: c */
    public /* synthetic */ C2286m mo1813c(String str) {
        return m8692g(str);
    }

    /* renamed from: d */
    public /* synthetic */ C2286m mo1814d(int i) {
        return m8699l(i);
    }

    /* renamed from: d */
    public /* synthetic */ C2286m mo1815d(String str) {
        return m8694h(str);
    }

    /* renamed from: e */
    public /* synthetic */ C2286m mo1816e(int i) {
        return m8700m(i);
    }

    /* renamed from: e */
    public /* synthetic */ C2286m mo1817e(String str) {
        return m8696i(str);
    }

    public C2287n(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected View mo1528a() {
        return LayoutInflater.from(this.c).inflate(R.layout.navi_dialog_listview, null);
    }

    protected int getCustomWidth() {
        return this.c.getResources().getDimensionPixelSize(R.dimen.common_dialog_navi);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7489e = (ListView) findViewById(R.id.list_view);
    }

    /* renamed from: a */
    public C2287n m8670a(ListAdapter adapter) {
        this.f7489e.setAdapter(adapter);
        return this;
    }

    public ListView getListView() {
        return this.f7489e;
    }

    /* renamed from: a */
    public C2287n m8669a(OnItemClickListener listener) {
        this.f7489e.setOnItemClickListener(listener);
        return this;
    }

    /* renamed from: f */
    public C2287n m8689f(int width) {
        LayoutParams params = (LayoutParams) this.f7489e.getLayoutParams();
        params.width = width;
        this.f7489e.setLayoutParams(params);
        return this;
    }

    /* renamed from: g */
    public C2287n m8691g(int height) {
        LayoutParams params = (LayoutParams) this.f7489e.getLayoutParams();
        params.height = height;
        this.f7489e.setLayoutParams(params);
        return this;
    }

    /* renamed from: h */
    public C2287n m8693h(int position) {
        this.f7489e.setSelection(position);
        return this;
    }

    /* renamed from: f */
    public C2287n m8690f(String text) {
        super.mo1810b(text);
        return this;
    }

    /* renamed from: i */
    public C2287n m8695i(int resId) {
        super.mo1803a(resId);
        return this;
    }

    /* renamed from: g */
    public C2287n m8692g(String text) {
        super.mo1813c(text);
        return this;
    }

    /* renamed from: j */
    public C2287n m8697j(int resId) {
        super.mo1807b(resId);
        return this;
    }

    /* renamed from: h */
    public C2287n m8694h(String text) {
        super.mo1815d(text);
        return this;
    }

    /* renamed from: k */
    public C2287n m8698k(int resId) {
        super.mo1812c(resId);
        return this;
    }

    /* renamed from: c */
    public C2287n m8679c(View content) {
        super.mo1804a(content);
        return this;
    }

    /* renamed from: d */
    public C2287n m8684d(View content) {
        super.mo1808b(content);
        return this;
    }

    /* renamed from: c */
    public C2287n m8680c(C2302a listener) {
        super.mo1805a(listener);
        return this;
    }

    /* renamed from: d */
    public C2287n m8685d(C2302a listener) {
        super.mo1809b(listener);
        return this;
    }

    /* renamed from: l */
    public C2287n m8699l(int width) {
        super.mo1814d(width);
        return this;
    }

    /* renamed from: m */
    public C2287n m8700m(int height) {
        super.mo1816e(height);
        return this;
    }

    /* renamed from: c */
    public C2287n m8681c(boolean enabled) {
        super.mo1806a(enabled);
        return this;
    }

    /* renamed from: d */
    public C2287n m8686d(boolean enabled) {
        super.mo1811b(enabled);
        return this;
    }

    /* renamed from: i */
    public C2287n m8696i(String text) {
        super.mo1817e(text);
        return this;
    }

    public void setListAdapter(ArrayList<String> mDataList) {
        this.f7489e.setAdapter(new C2303a(this, mDataList));
    }
}
