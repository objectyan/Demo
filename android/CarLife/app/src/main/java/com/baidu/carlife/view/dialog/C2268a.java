package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.adpter.C0986h;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;

/* compiled from: BtnListViewRightListDialog */
/* renamed from: com.baidu.carlife.view.dialog.a */
public class C2268a extends BaseDialog implements OnClickListener, OnTouchListener, OnScrollListener {
    /* renamed from: e */
    private View f7414e;
    /* renamed from: f */
    private ImageButton f7415f;
    /* renamed from: g */
    private ImageButton f7416g;
    /* renamed from: h */
    private ViewGroup f7417h;
    /* renamed from: i */
    private View f7418i;
    /* renamed from: j */
    private int f7419j;
    /* renamed from: k */
    private int f7420k;
    /* renamed from: l */
    private int f7421l;
    /* renamed from: m */
    private int f7422m;
    /* renamed from: n */
    private int f7423n;
    /* renamed from: o */
    private int f7424o;
    /* renamed from: p */
    private int f7425p;
    /* renamed from: q */
    private boolean f7426q;
    /* renamed from: r */
    private boolean f7427r;
    /* renamed from: s */
    private TextView f7428s;
    /* renamed from: t */
    private ListView f7429t;
    /* renamed from: u */
    private String f7430u;
    /* renamed from: v */
    private BaseAdapter f7431v;
    /* renamed from: w */
    private boolean f7432w;
    /* renamed from: x */
    private boolean f7433x;
    /* renamed from: y */
    private C1438c f7434y;

    /* compiled from: BtnListViewRightListDialog */
    /* renamed from: com.baidu.carlife.view.dialog.a$1 */
    class C22651 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2268a f7410a;

        C22651(C2268a this$0) {
            this.f7410a = this$0;
        }

        public void onClick(View view) {
        }
    }

    /* compiled from: BtnListViewRightListDialog */
    /* renamed from: com.baidu.carlife.view.dialog.a$3 */
    class C22673 implements OnKeyListener {
        /* renamed from: a */
        final /* synthetic */ C2268a f7413a;

        C22673(C2268a this$0) {
            this.f7413a = this$0;
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event == null || event.getAction() != 0 || keyCode != 21) {
                return false;
            }
            this.f7413a.mo1526d();
            return true;
        }
    }

    public void onClick(View v) {
        if (this.f7423n != 0) {
            int offsetCount = this.f7421l / this.f7423n;
            switch (v.getId()) {
                case C0965R.id.btnlistview_btn_prev:
                    this.f7429t.smoothScrollToPositionFromTop(this.f7425p - offsetCount, (-this.f7429t.getDividerHeight()) - 1);
                    return;
                case C0965R.id.btnlistview_btn_next:
                    this.f7429t.smoothScrollToPositionFromTop(this.f7425p + offsetCount, (-this.f7429t.getDividerHeight()) - 1);
                    return;
                default:
                    return;
            }
        }
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (this.f7429t.getChildAt(0) != null) {
            if (this.f7419j == 0 || this.f7421l == 0 || this.f7424o != totalItemCount) {
                this.f7424o = totalItemCount;
                if (this.f7431v != null && (this.f7431v instanceof C0986h)) {
                    C0986h loadMoreBaseAdapter = this.f7431v;
                    if (Boolean.valueOf(loadMoreBaseAdapter.m3201b()).booleanValue() && loadMoreBaseAdapter.m3196a() == 0) {
                        this.f7424o = totalItemCount - 1;
                    }
                }
                this.f7421l = this.f7429t.getHeight();
                this.f7423n = this.f7429t.getChildAt(0).getHeight() + this.f7429t.getDividerHeight();
                this.f7422m = (this.f7423n * this.f7424o) - 10;
                this.f7419j = this.f7417h.getHeight();
                if (this.f7419j != 0) {
                    LayoutParams lp = this.f7418i.getLayoutParams();
                    this.f7420k = ((this.f7421l * this.f7419j) / this.f7424o) / this.f7423n;
                    int minScrollBarHeight = C1249d.m4331a().m4343c(12);
                    if (this.f7420k < minScrollBarHeight) {
                        this.f7419j -= minScrollBarHeight - this.f7420k;
                        this.f7420k = minScrollBarHeight;
                    }
                    lp.height = this.f7420k;
                    this.f7418i.setLayoutParams(lp);
                } else {
                    return;
                }
            }
            int scrollY = ((-((this.f7423n * firstVisibleItem) - this.f7429t.getChildAt(0).getTop())) * this.f7419j) / this.f7422m;
            if (scrollY == 0) {
                if (this.f7426q) {
                    this.f7426q = false;
                    this.f7415f.setImageResource(C0965R.drawable.com_ic_prev_disable);
                    this.f7415f.setEnabled(false);
                }
                if (this.f7427r) {
                    if ((-((this.f7419j - this.f7420k) - 2)) >= 0) {
                        this.f7427r = false;
                        this.f7416g.setImageResource(C0965R.drawable.com_ic_next_disable);
                        this.f7416g.setEnabled(false);
                    }
                } else if ((-((this.f7419j - this.f7420k) - 2)) < 0) {
                    this.f7427r = true;
                    this.f7416g.setImageResource(C0965R.drawable.com_ic_next);
                    this.f7416g.setEnabled(true);
                }
            } else if (scrollY <= (-((this.f7419j - this.f7420k) - 2))) {
                if (this.f7427r) {
                    this.f7427r = false;
                    this.f7416g.setImageResource(C0965R.drawable.com_ic_next_disable);
                    this.f7416g.setEnabled(false);
                }
                if (!(scrollY == 0 || this.f7426q)) {
                    this.f7426q = true;
                    this.f7415f.setImageResource(C0965R.drawable.com_ic_prev);
                    this.f7415f.setEnabled(true);
                }
            } else {
                if (!this.f7426q) {
                    this.f7426q = true;
                    this.f7415f.setImageResource(C0965R.drawable.com_ic_prev);
                    this.f7415f.setEnabled(true);
                }
                if (!this.f7427r) {
                    this.f7427r = true;
                    this.f7416g.setImageResource(C0965R.drawable.com_ic_next);
                    this.f7416g.setEnabled(true);
                }
            }
            this.f7425p = firstVisibleItem;
            this.f7417h.scrollTo(0, scrollY);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public C2268a(Context activity, BaseAdapter menuAdapter, OnItemClickListener onItemClickListener) {
        super(activity);
        this.f7419j = 0;
        this.f7420k = 0;
        this.f7421l = 0;
        this.f7422m = 0;
        this.f7423n = 0;
        this.f7424o = 0;
        this.f7425p = 0;
        this.f7426q = true;
        this.f7427r = true;
        this.f7432w = false;
        this.f7433x = true;
        this.f7433x = false;
        m8598k();
        this.f7431v = menuAdapter;
        this.f7429t.setOnItemClickListener(onItemClickListener);
        this.f7429t.setAdapter(this.f7431v);
        setCanceledOnTouchOutside(true);
    }

    public C2268a(Context activity, int titleStringId, BaseAdapter menuAdapter, OnItemClickListener onItemClickListener) {
        super(activity);
        this.f7419j = 0;
        this.f7420k = 0;
        this.f7421l = 0;
        this.f7422m = 0;
        this.f7423n = 0;
        this.f7424o = 0;
        this.f7425p = 0;
        this.f7426q = true;
        this.f7427r = true;
        this.f7432w = false;
        this.f7433x = true;
        this.f7433x = true;
        this.f7431v = menuAdapter;
        this.f7430u = activity.getString(titleStringId);
        setTitle(this.f7430u);
        this.f7429t.setOnItemClickListener(onItemClickListener);
        this.f7429t.setAdapter(this.f7431v);
        setCanceledOnTouchOutside(true);
    }

    /* renamed from: a */
    protected View mo1528a() {
        View contentView = LayoutInflater.from(this.c).inflate(C0965R.layout.btnlistview_dialog_right_list, null);
        contentView.setOnClickListener(new C22651(this));
        return contentView;
    }

    protected int getCustomWidth() {
        return this.c.getResources().getDimensionPixelSize(C0965R.dimen.btnlistview_menu_right_width);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7428s = (TextView) findViewById(C0965R.id.tv_title);
        this.f7428s.setText(this.f7430u);
        this.f7429t = (ListView) findViewById(C0965R.id.lv_menu);
        this.f7429t.setOverScrollMode(2);
        this.f7414e = findViewById(C0965R.id.btnlistview_left);
        if (C1342a.m4926a().m4929b() || C1343b.m4932a().m4935b()) {
            this.f7414e.setVisibility(0);
        }
        this.f7417h = (ViewGroup) findViewById(C0965R.id.btnlistview_scroller);
        this.f7418i = findViewById(C0965R.id.btnlistview_scroll_bar);
        this.f7415f = (ImageButton) findViewById(C0965R.id.btnlistview_btn_prev);
        this.f7416g = (ImageButton) findViewById(C0965R.id.btnlistview_btn_next);
        this.f7415f.setOnClickListener(this);
        this.f7416g.setOnClickListener(this);
        this.f7429t.setOnScrollListener(this);
        this.f7429t.setOnTouchListener(this);
        if (this.f7432w) {
            this.f7429t.setDivider(null);
        }
    }

    /* renamed from: i */
    public void mo1630i() {
        if (this.f7431v != null) {
            this.f7431v.notifyDataSetChanged();
        }
    }

    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            this.f7430u = title;
            if (this.f7428s != null) {
                this.f7428s.setText(this.f7430u);
            }
        }
    }

    /* renamed from: k */
    private void m8598k() {
        if (!this.f7433x) {
            this.f7428s.setVisibility(8);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        if (this.f7429t != null) {
            this.f7429t.setOnItemClickListener(onItemClickListener);
        }
    }

    /* renamed from: a */
    public void m8600a(final int selectedPos) {
        if (this.f7429t != null) {
            this.f7429t.post(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C2268a f7412b;

                public void run() {
                    this.f7412b.f7429t.setSelection(selectedPos > 0 ? selectedPos - 1 : selectedPos);
                }
            });
        }
    }

    /* renamed from: j */
    public void m8605j() {
        this.f7432w = true;
    }

    /* renamed from: f */
    public void mo1530f() {
        if (this.f7434y == null) {
            this.f7434y = new C1438c(this.f7429t, 9);
            this.f7434y.m5249a(new C22673(this));
            this.f7434y.m5244a(true);
        }
        C1440d.m5251a().m5253a(this.f7434y);
    }

    /* renamed from: g */
    public void mo1527g() {
        C1440d.m5251a().m5263e();
    }

    public void setBtnVisibility(int visibility) {
        if ((visibility == 0 || visibility == 8) && this.f7414e != null) {
            this.f7414e.setVisibility(visibility);
            ((View) this.f7414e.getParent()).invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((C1342a.m4926a().m4929b() || C1343b.m4932a().m4935b()) && motionEvent.getAction() == 2 && C1328h.m4757a().getNaviFragmentManager().isDriving()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
