package com.baidu.che.codriver.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.ui.p127a.C2651h;
import com.baidu.che.codriver.util.C2725h;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SwitchPageLayout extends RelativeLayout implements OnClickListener, C2880e {
    /* renamed from: a */
    public static final String f9492a = "SwitchPageLayout";
    /* renamed from: b */
    public static final int f9493b = 500;
    /* renamed from: c */
    private C2651h f9494c;
    /* renamed from: d */
    private int f9495d;
    /* renamed from: e */
    private int f9496e;
    /* renamed from: f */
    private TextView f9497f;
    /* renamed from: g */
    private TextView f9498g;
    /* renamed from: h */
    private CompoundImageView f9499h;
    /* renamed from: i */
    private CompoundImageView f9500i;
    /* renamed from: j */
    private View f9501j;
    /* renamed from: k */
    private SparseArray<View> f9502k;
    /* renamed from: l */
    private LinearLayout f9503l;

    public SwitchPageLayout(Context context) {
        this(context, null);
    }

    public SwitchPageLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwitchPageLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f9502k = new SparseArray();
    }

    /* renamed from: a */
    private void m10911a() {
        this.f9503l = (LinearLayout) findViewById(C0965R.id.container);
        this.f9497f = (TextView) findViewById(C0965R.id.title);
        this.f9501j = findViewById(C0965R.id.control_bar);
        this.f9498g = (TextView) findViewById(C0965R.id.page_index);
        this.f9499h = (CompoundImageView) findViewById(C0965R.id.page_prev);
        this.f9500i = (CompoundImageView) findViewById(C0965R.id.page_next);
        this.f9499h.setOnClickListener(this);
        this.f9500i.setOnClickListener(this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        m10911a();
    }

    public void setAdapter(C2651h adapter) {
        this.f9494c = adapter;
        this.f9496e = this.f9494c.mo1919a();
        this.f9495d = this.f9494c.mo1921b();
        this.f9502k.clear();
        m10917d();
    }

    public void setTitle(String title) {
        if (TextUtils.isEmpty(title)) {
            this.f9497f.setVisibility(8);
        } else {
            this.f9497f.setText(title);
        }
    }

    public void setPageIndex(int current, int max) {
        this.f9498g.setText(current + "/" + max);
    }

    public LinkedHashMap<View, ArrayList<String>> getKeywords() {
        ViewGroup currentContent = (ViewGroup) m10910a(this.f9495d);
        LinkedHashMap<View, ArrayList<String>> resultMap = new LinkedHashMap();
        int childCount = currentContent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ArrayList resultList = new ArrayList();
            View childView = currentContent.getChildAt(i);
            if (childView instanceof ViewGroup) {
                m10912a((ViewGroup) childView, resultList);
            }
            resultMap.put(childView, resultList);
        }
        return resultMap;
    }

    /* renamed from: a */
    private void m10912a(ViewGroup rootView, ArrayList<String> resultList) {
        int childCount = rootView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = rootView.getChildAt(i);
            if (childView instanceof TextView) {
                if (childView.getVisibility() == 0) {
                    resultList.add(((TextView) childView).getText().toString());
                }
            } else if (childView instanceof ViewGroup) {
                m10912a((ViewGroup) childView, (ArrayList) resultList);
            }
        }
    }

    /* renamed from: b */
    public boolean mo1983b() {
        C2725h.m10207b(f9492a, "switchToPrevPage() mCurrentPage=" + this.f9495d + " mMaxPage=" + this.f9496e);
        return m10914a(true, false);
    }

    /* renamed from: c */
    public boolean mo1984c() {
        C2725h.m10207b(f9492a, "switchToNextPage() mCurrentPage=" + this.f9495d + " mMaxPage=" + this.f9496e);
        return m10914a(true, true);
    }

    /* renamed from: a */
    private boolean m10914a(boolean needDelay, final boolean isNext) {
        if (isNext) {
            if (this.f9495d == this.f9496e - 1) {
                return false;
            }
            this.f9495d++;
        } else if (this.f9495d == 0) {
            return false;
        } else {
            this.f9495d--;
        }
        if (needDelay) {
            if (isNext) {
                this.f9500i.setChecked(true);
            } else {
                this.f9499h.setChecked(true);
            }
            postDelayed(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ SwitchPageLayout f9491b;

                public void run() {
                    this.f9491b.m10917d();
                    if (isNext) {
                        this.f9491b.f9500i.setChecked(false);
                    } else {
                        this.f9491b.f9499h.setChecked(false);
                    }
                }
            }, 500);
        } else {
            m10917d();
        }
        return true;
    }

    /* renamed from: d */
    private void m10917d() {
        this.f9494c.mo1922b(this.f9495d);
        this.f9503l.removeAllViewsInLayout();
        setPageIndex(this.f9495d + 1, this.f9496e);
        this.f9503l.addView(m10910a(this.f9495d));
        if (this.f9496e <= 1) {
            this.f9501j.setVisibility(8);
        } else if (this.f9495d == 0) {
            this.f9501j.setVisibility(0);
            this.f9499h.setEnabled(false);
            this.f9499h.setAlpha(0.4f);
            this.f9500i.setEnabled(true);
            this.f9500i.setAlpha(1.0f);
        } else if (this.f9495d == this.f9496e - 1) {
            this.f9501j.setVisibility(0);
            this.f9499h.setEnabled(true);
            this.f9499h.setAlpha(1.0f);
            this.f9500i.setEnabled(false);
            this.f9500i.setAlpha(0.4f);
        } else {
            this.f9501j.setVisibility(0);
            this.f9499h.setEnabled(true);
            this.f9499h.setAlpha(1.0f);
            this.f9500i.setEnabled(true);
            this.f9500i.setAlpha(1.0f);
        }
    }

    /* renamed from: a */
    private View m10910a(int position) {
        if (this.f9502k.get(position) != null) {
            return (View) this.f9502k.get(position);
        }
        View view = this.f9494c.mo1920a(this.f9495d);
        this.f9502k.put(position, view);
        return view;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0965R.id.page_prev:
                m10914a(false, false);
                return;
            case C0965R.id.page_next:
                m10914a(false, true);
                return;
            default:
                return;
        }
    }
}
