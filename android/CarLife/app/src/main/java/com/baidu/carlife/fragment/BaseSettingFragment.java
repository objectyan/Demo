package com.baidu.carlife.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.p059c.C1102b;
import com.baidu.carlife.p059c.p061f.C1140b.C1134a;
import com.baidu.carlife.p059c.p062b.C1100a;
import com.baidu.carlife.p059c.p063c.C1103a;
import com.baidu.carlife.p059c.p066e.C1135b;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2188r;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;

public abstract class BaseSettingFragment<T extends C1103a> extends ContentFragment {
    /* renamed from: a */
    private C1443g f4234a;
    /* renamed from: b */
    private C1438c f4235b;
    /* renamed from: c */
    private ListView f4236c;
    /* renamed from: d */
    private C1102b f4237d;

    /* renamed from: com.baidu.carlife.fragment.BaseSettingFragment$1 */
    class C14461 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ BaseSettingFragment f4233a;

        C14461(BaseSettingFragment this$0) {
            this.f4233a = this$0;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            view.performClick();
        }
    }

    /* renamed from: a */
    protected abstract String mo1568a();

    /* renamed from: b */
    protected abstract C1100a<T> mo1569b();

    /* renamed from: c */
    protected abstract C1135b<T> mo1570c();

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType()) {
            if (this.f4234a == null) {
                this.f4234a = new C1443g(this.mContentView.findViewById(C0965R.id.title_bar), 2);
                this.f4234a.m5300d(this.mContentView.findViewById(C0965R.id.ib_left));
            }
            if (this.f4235b == null) {
                this.f4235b = new C1438c(this.f4236c, 4);
            }
            C1440d.m5251a().m5256b(this.f4234a, this.f4235b);
            C1440d.m5251a().m5268h(this.f4235b);
            this.f4235b.m5250e();
        }
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
        this.f4236c.setSelector(C2188r.m8331b(C0965R.drawable.com_bg_item_selector));
        this.f4236c.setDivider(C2188r.m8331b(C0965R.color.cl_line_a1_item));
        this.f4236c.setDividerHeight(getResources().getDimensionPixelSize(C0965R.dimen.common_item_line));
        this.f4237d.notifyDataSetChanged();
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onResume() {
        super.onResume();
    }

    protected void onInitView() {
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(C0965R.layout.frag_setting, null);
        setCommonTitleBar(this.mContentView, mo1568a());
        this.f4236c = (ListView) this.mContentView.findViewById(C0965R.id.setting_list);
        this.f4236c.setOnItemClickListener(new C14461(this));
        this.f4237d = new C1102b();
        C1134a presenter = mo1570c();
        presenter.m3829a(this.f4237d);
        presenter.m3828a(mo1569b());
        this.f4237d.m3724a(presenter);
        this.f4236c.setAdapter(this.f4237d);
        presenter.mo1424a();
        return this.mContentView;
    }

    public void driving() {
        C1260i.m4435b("yftech", "BaseSettingFragment driving");
        if (C1343b.m4932a().m4935b()) {
            backTo(NaviFragmentManager.TYPE_HOME, null);
        }
    }
}
