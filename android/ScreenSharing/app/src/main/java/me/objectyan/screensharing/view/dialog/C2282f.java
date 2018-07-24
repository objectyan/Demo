package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.adpter.SimpleRightDialogAdapter;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;

/* compiled from: CommonRightListDialog */
/* renamed from: com.baidu.carlife.view.dialog.f */
public class C2282f extends BaseDialog {
    /* renamed from: e */
    private TextView f7464e;
    /* renamed from: f */
    private ListView f7465f;
    /* renamed from: g */
    private String f7466g;
    /* renamed from: h */
    private BaseAdapter f7467h;
    /* renamed from: i */
    private View f7468i;
    /* renamed from: j */
    private boolean f7469j;
    /* renamed from: k */
    private boolean f7470k;
    /* renamed from: l */
    private C1438c f7471l;

    /* compiled from: CommonRightListDialog */
    /* renamed from: com.baidu.carlife.view.dialog.f$1 */
    class C22791 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2282f f7460a;

        C22791(C2282f this$0) {
            this.f7460a = this$0;
        }

        public void onClick(View view) {
        }
    }

    /* compiled from: CommonRightListDialog */
    /* renamed from: com.baidu.carlife.view.dialog.f$3 */
    class C22813 implements OnKeyListener {
        /* renamed from: a */
        final /* synthetic */ C2282f f7463a;

        C22813(C2282f this$0) {
            this.f7463a = this$0;
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event == null || event.getAction() != 0 || keyCode != 21) {
                return false;
            }
            this.f7463a.mo1526d();
            return true;
        }
    }

    public C2282f(Context activity, BaseAdapter menuAdapter, OnItemClickListener onItemClickListener) {
        super(activity);
        this.f7469j = false;
        this.f7470k = true;
        this.f7470k = false;
        m8628k();
        this.f7467h = menuAdapter;
        this.f7465f.setOnItemClickListener(onItemClickListener);
        this.f7465f.setAdapter(this.f7467h);
        setCanceledOnTouchOutside(true);
    }

    public C2282f(Context activity, int titleStringId, BaseAdapter menuAdapter, OnItemClickListener onItemClickListener) {
        super(activity);
        this.f7469j = false;
        this.f7470k = true;
        this.f7470k = true;
        this.f7467h = menuAdapter;
        this.f7466g = activity.getString(titleStringId);
        setTitle(this.f7466g);
        this.f7465f.setOnItemClickListener(onItemClickListener);
        this.f7465f.setAdapter(this.f7467h);
        setCanceledOnTouchOutside(true);
    }

    /* renamed from: a */
    protected View mo1528a() {
        View contentView = LayoutInflater.from(this.c).inflate(R.layout.common_dialog_right_list, null);
        contentView.setOnClickListener(new C22791(this));
        return contentView;
    }

    protected int getCustomWidth() {
        if (CarlifeScreenUtil.m4334m()) {
            return this.c.getResources().getDimensionPixelSize(R.dimen.common_menu_right_big_screen_width);
        }
        return this.c.getResources().getDimensionPixelSize(R.dimen.common_menu_right_width);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7464e = (TextView) findViewById(R.id.tv_title);
        this.f7464e.setText(this.f7466g);
        this.f7465f = (ListView) findViewById(R.id.lv_menu);
        this.f7465f.setOverScrollMode(2);
        if (this.f7468i != null) {
            this.f7465f.addFooterView(this.f7468i, null, false);
        }
        if (this.f7469j) {
            this.f7465f.setDivider(null);
        }
    }

    public void setSelected(int selectedPos) {
        if (this.f7467h instanceof SimpleRightDialogAdapter) {
            ((SimpleRightDialogAdapter) this.f7467h).m3261a(selectedPos);
            this.f7467h.notifyDataSetChanged();
        }
    }

    /* renamed from: i */
    public void mo1630i() {
        if (this.f7467h != null) {
            this.f7467h.notifyDataSetChanged();
        }
    }

    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            this.f7466g = title;
            if (this.f7464e != null) {
                this.f7464e.setText(this.f7466g);
            }
        }
    }

    /* renamed from: k */
    private void m8628k() {
        if (!this.f7470k) {
            this.f7464e.setVisibility(8);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        if (this.f7465f != null) {
            this.f7465f.setOnItemClickListener(onItemClickListener);
        }
    }

    /* renamed from: a */
    public void m8630a(final int selectedPos) {
        if (this.f7465f != null) {
            this.f7465f.post(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C2282f f7462b;

                public void run() {
                    this.f7462b.f7465f.setSelection(selectedPos > 0 ? selectedPos - 1 : selectedPos);
                }
            });
        }
    }

    /* renamed from: a */
    public void m8631a(View view) {
        this.f7468i = view;
    }

    /* renamed from: j */
    public void m8636j() {
        this.f7469j = true;
    }

    /* renamed from: f */
    public void mo1530f() {
        if (this.f7471l == null) {
            this.f7471l = new C1438c(this.f7465f, 9);
            this.f7471l.m5249a(new C22813(this));
            this.f7471l.m5244a(true);
        }
        C1440d.m5251a().m5253a(this.f7471l);
    }

    /* renamed from: g */
    public void mo1527g() {
        C1440d.m5251a().m5263e();
    }
}
