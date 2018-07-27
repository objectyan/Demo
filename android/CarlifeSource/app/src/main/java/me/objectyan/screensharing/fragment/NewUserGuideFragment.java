package com.baidu.carlife.fragment;

import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CarLifeSettings;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.presentation.view.CarlifeViewContainer;
import com.baidu.carlife.logic.C1877u;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p078f.C1444h;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.view.UserGuideViewPager;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import java.util.ArrayList;
import java.util.List;

public class NewUserGuideFragment extends ContentFragment implements OnClickListener, OnTouchListener {
    /* renamed from: a */
    public static final String f4663a = "firstEnter";
    /* renamed from: b */
    public static final String f4664b = "index";
    /* renamed from: c */
    private boolean f4665c;
    /* renamed from: d */
    private int f4666d = 0;
    /* renamed from: e */
    private RelativeLayout f4667e;
    /* renamed from: f */
    private ImageView f4668f;
    /* renamed from: g */
    private ImageView f4669g;
    /* renamed from: h */
    private ImageView f4670h;
    /* renamed from: i */
    private RelativeLayout f4671i;
    /* renamed from: j */
    private RelativeLayout f4672j;
    /* renamed from: k */
    private UserGuideViewPager f4673k;
    /* renamed from: l */
    private List<View> f4674l;
    /* renamed from: m */
    private TextView f4675m;
    /* renamed from: n */
    private C1443g f4676n;
    /* renamed from: o */
    private C1444h f4677o;

    /* renamed from: com.baidu.carlife.fragment.NewUserGuideFragment$1 */
    class C15521 implements OnPageChangeListener {
        /* renamed from: a */
        final /* synthetic */ NewUserGuideFragment f4659a;

        C15521(NewUserGuideFragment this$0) {
            this.f4659a = this$0;
        }

        public void onPageScrolled(int i, float v, int i1) {
        }

        public void onPageSelected(int pos) {
            m5702a(pos);
        }

        /* renamed from: a */
        private void m5702a(int pos) {
            if (this.f4659a.f4665c) {
                if (pos == 0) {
                    this.f4659a.m5704a(8, 0, 8);
                    this.f4659a.f4675m.setVisibility(8);
                } else if (pos == this.f4659a.f4674l.size() - 1) {
                    this.f4659a.m5704a(0, 8, 0);
                    this.f4659a.f4675m.setVisibility(0);
                }
            } else if (pos == 0) {
                this.f4659a.f4668f.setVisibility(8);
            } else {
                this.f4659a.f4668f.setVisibility(0);
                this.f4659a.f4669g.setVisibility(0);
            }
        }

        public void onPageScrollStateChanged(int i) {
        }
    }

    /* renamed from: com.baidu.carlife.fragment.NewUserGuideFragment$2 */
    class C15532 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ NewUserGuideFragment f4660a;

        C15532(NewUserGuideFragment this$0) {
            this.f4660a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                this.f4660a.f4670h.setBackground(ContextCompat.getDrawable(BaseFragment.mActivity, R.drawable.guide_btn_start_hover));
            } else {
                this.f4660a.f4670h.setBackground(ContextCompat.getDrawable(BaseFragment.mActivity, R.drawable.guide_btn_start));
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.NewUserGuideFragment$3 */
    class C15543 implements OnKeyListener {
        /* renamed from: a */
        final /* synthetic */ NewUserGuideFragment f4661a;

        C15543(NewUserGuideFragment this$0) {
            this.f4661a = this$0;
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event.getAction() != 0 || keyCode != 23) {
                return false;
            }
            if ((CarlifeViewContainer.m4699a().isDialogShown() && !C1440d.m5251a().m5270i()) || !this.f4661a.m5717c()) {
                return true;
            }
            this.f4661a.m5719d();
            return true;
        }
    }

    /* renamed from: com.baidu.carlife.fragment.NewUserGuideFragment$a */
    private class C1555a extends PagerAdapter {
        /* renamed from: a */
        final /* synthetic */ NewUserGuideFragment f4662a;

        private C1555a(NewUserGuideFragment newUserGuideFragment) {
            this.f4662a = newUserGuideFragment;
        }

        public int getCount() {
            if (this.f4662a.f4665c) {
                return this.f4662a.f4674l.size();
            }
            return this.f4662a.f4674l.size() - 1;
        }

        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) this.f4662a.f4674l.get(arg1));
        }

        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView((View) this.f4662a.f4674l.get(arg1));
            return this.f4662a.f4674l.get(arg1);
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        setBottomBarStatus(false);
        if (this.mShowBundle != null) {
            this.f4665c = this.mShowBundle.getBoolean("firstEnter", false);
            this.f4666d = this.mShowBundle.getInt("index", 0);
        }
        View contentView = inflater.inflate(R.layout.frag_guid_new, null);
        m5707a(contentView);
        m5720d(contentView);
        m5705a(inflater);
        m5723e(contentView);
        m5714b(contentView);
        m5716c(contentView);
        this.f4673k.setCurrentItem(this.f4666d);
        return contentView;
    }

    public void onResume() {
        super.onResume();
        m5712b();
    }

    /* renamed from: a */
    private void m5707a(View contentView) {
        this.f4675m = (TextView) contentView.findViewById(R.id.tv_legacy);
        this.f4675m.setText(C1877u.m7165a(getStringUtil(R.string.legacy_content)));
        this.f4675m.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* renamed from: b */
    private void m5714b(View contentView) {
        this.f4671i = (RelativeLayout) contentView.findViewById(R.id.rl_left_touch);
        this.f4671i.setOnTouchListener(this);
        this.f4672j = (RelativeLayout) contentView.findViewById(R.id.rl_right_touch);
        this.f4672j.setOnTouchListener(this);
    }

    /* renamed from: c */
    private void m5716c(View contentView) {
        this.f4668f = (ImageView) contentView.findViewById(R.id.iv_left);
        this.f4668f.setOnClickListener(this);
        this.f4669g = (ImageView) contentView.findViewById(R.id.iv_right);
        this.f4669g.setOnClickListener(this);
        this.f4670h = (ImageView) contentView.findViewById(R.id.iv_enter);
        this.f4670h.setOnClickListener(this);
    }

    /* renamed from: d */
    private void m5720d(View contentView) {
        this.f4667e = (RelativeLayout) contentView.findViewById(R.id.rl_left_back_btn);
        if (this.f4665c) {
            this.f4667e.setVisibility(8);
            return;
        }
        this.f4667e.setVisibility(0);
        this.f4667e.setOnClickListener(this);
    }

    /* renamed from: e */
    private void m5723e(View contentView) {
        this.f4673k = (UserGuideViewPager) contentView.findViewById(R.id.viewpager);
        this.f4673k.setScrollOperationFlag(false);
        this.f4673k.setOnPageChangeListener(new C15521(this));
        this.f4673k.setAdapter(new C1555a());
        this.f4673k.setOnFocusChangeListener(new C15532(this));
    }

    /* renamed from: a */
    private void m5705a(LayoutInflater inflater) {
        View view1 = inflater.inflate(R.layout.user_guide1, null);
        View view3 = inflater.inflate(R.layout.user_guide3, null);
        this.f4674l = new ArrayList();
        this.f4674l.add(view1);
        this.f4674l.add(view3);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (VERSION.SDK_INT <= 16) {
            removeAllFragmentByType(516);
        } else if (mActivity != null && !mActivity.isDestroyed()) {
            removeAllFragmentByType(516);
        }
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        this.f4667e.setBackground(C2251b.m8527a(mActivity));
    }

    public boolean onBackPressed() {
        if (this.f4665c) {
            mActivity.m3108d();
            return true;
        }
        setBottomBarStatus(true);
        return false;
    }

    protected void onInitView() {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onInitFocusAreas() {
        if (this.mContentView != null) {
            if (this.f4676n == null) {
                this.f4676n = new C1443g(this.mContentView.findViewById(R.id.frag_guid_new), 2);
                this.f4676n.m5300d(this.mContentView.findViewById(R.id.rl_left_back_btn));
            }
            m5703a();
            m5712b();
        }
    }

    /* renamed from: a */
    private void m5704a(int leftBtnVisibility, int rightBtnVisibility, int enterBtnVisibility) {
        this.f4668f.setVisibility(leftBtnVisibility);
        this.f4670h.setVisibility(enterBtnVisibility);
        this.f4669g.setVisibility(rightBtnVisibility);
    }

    /* renamed from: a */
    private void m5703a() {
        if (this.f4677o == null) {
            this.f4677o = new C1444h((ViewPager) this.mContentView.findViewById(R.id.viewpager), 4);
            this.f4677o.m5307a(new C15543(this));
        }
    }

    /* renamed from: b */
    private void m5712b() {
        if (this.f4665c) {
            C1440d.m5251a().m5256b(this.f4677o);
            C1440d.m5251a().m5268h(this.f4677o);
            return;
        }
        C1440d.m5251a().m5256b(this.f4676n, this.f4677o);
        C1440d.m5251a().m5268h(this.f4676n);
    }

    public boolean onTouch(View v, MotionEvent event) {
        return m5709a(v, event);
    }

    /* renamed from: a */
    private boolean m5709a(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.rl_left_touch:
                m5713b(event);
                return true;
            case R.id.rl_right_touch:
                m5706a(event);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    private void m5706a(MotionEvent event) {
        if (event.getAction() == 0) {
            if (m5717c()) {
                this.f4670h.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.guide_btn_start_press));
            } else {
                this.f4669g.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.guide_btn_next_press));
            }
        } else if (event.getAction() == 1) {
            if (!m5717c()) {
                this.f4669g.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.user_guide_right_btn_selector));
            } else if (this.f4665c) {
                m5719d();
            }
            m5725f();
        }
    }

    /* renamed from: c */
    private boolean m5717c() {
        return this.f4673k.getCurrentItem() == this.f4674l.size() + -1;
    }

    /* renamed from: b */
    private void m5713b(MotionEvent event) {
        if (event.getAction() == 0) {
            this.f4668f.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.guide_btn_prev_prss));
        } else if (event.getAction() == 1) {
            this.f4668f.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.user_guide_left_btn_selector));
            m5722e();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_left_back_btn:
                back();
                setBottomBarStatus(true);
                return;
            case R.id.iv_left:
                m5722e();
                return;
            case R.id.iv_right:
                m5725f();
                return;
            case R.id.iv_enter:
                m5719d();
                return;
            default:
                return;
        }
    }

    /* renamed from: d */
    private void m5719d() {
        LogUtil.d("Framework", "onEnterCarlife");
        CarLifeSettings.m4069a().m4074a(false);
        if (CarlifeUtil.m4358a().m4402x() || CarlifeCoreSDK.m5979a().m5993N()) {
            showFragment(515, null);
        } else {
            showFragment(513, null);
        }
    }

    /* renamed from: e */
    private void m5722e() {
        if (this.f4666d > 0) {
            this.f4666d--;
            this.f4673k.setCurrentItem(this.f4666d);
        }
    }

    /* renamed from: f */
    private void m5725f() {
        if (this.f4666d < this.f4674l.size() - 1) {
            this.f4666d++;
            this.f4673k.setCurrentItem(this.f4666d);
        }
    }
}
