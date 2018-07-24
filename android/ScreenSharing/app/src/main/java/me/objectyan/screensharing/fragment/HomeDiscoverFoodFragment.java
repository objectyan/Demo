package com.baidu.carlife.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.adpter.FoodCafeListAdapter;
import com.baidu.carlife.adpter.SimpleRightDialogAdapter;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.presentation.view.CarlifeProgressDialogContainer;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.logic.C1766h;
import com.baidu.carlife.model.C1925e;
import com.baidu.carlife.model.C1926f;
import com.baidu.carlife.p054k.C1647h;
import com.baidu.carlife.p054k.C1649j;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.LoadMoreFooter;
import com.baidu.carlife.view.dialog.C2282f;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.NaviAccountUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeDiscoverFoodFragment extends ContentFragment {
    /* renamed from: a */
    public static final int f4373a = 0;
    /* renamed from: b */
    public static final int f4374b = 1;
    /* renamed from: c */
    public static final String f4375c = HomeDiscoverFoodFragment.class.getSimpleName();
    /* renamed from: d */
    private static final int f4376d = 0;
    /* renamed from: e */
    private static final int f4377e = 1;
    /* renamed from: f */
    private ListView f4378f;
    /* renamed from: g */
    private LoadMoreFooter f4379g;
    /* renamed from: h */
    private C2282f f4380h;
    /* renamed from: i */
    private CommonTipView f4381i;
    /* renamed from: j */
    private ImageButton f4382j;
    /* renamed from: k */
    private boolean f4383k;
    /* renamed from: l */
    private C1649j f4384l;
    /* renamed from: m */
    private C1647h f4385m;
    /* renamed from: n */
    private List<C1925e> f4386n;
    /* renamed from: o */
    private List<C1925e> f4387o;
    /* renamed from: p */
    private FoodCafeListAdapter f4388p;
    /* renamed from: q */
    private int f4389q = 0;
    /* renamed from: r */
    private C1443g f4390r;
    /* renamed from: s */
    private C1438c f4391s;
    /* renamed from: t */
    private int f4392t = 0;
    /* renamed from: u */
    private C0924a f4393u = new C14781(this);
    /* renamed from: v */
    private C0924a f4394v = new C14792(this);
    /* renamed from: w */
    private Comparator<C1925e> f4395w = new C14803(this);
    /* renamed from: x */
    private OnItemClickListener f4396x = new C14814(this);

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodFragment$1 */
    class C14781 implements C0924a {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFoodFragment f4367a;

        C14781(HomeDiscoverFoodFragment this$0) {
            this.f4367a = this$0;
        }

        public void onNetWorkResponse(int responseCode) {
            if (this.f4367a.isAdded()) {
                if (responseCode == 0) {
                    List<C1926f> temp = this.f4367a.f4384l.m5959a();
                    if (temp != null && temp.size() > 0) {
                        this.f4367a.f4388p.m3177a(this.f4367a.f4384l.m5959a());
                        this.f4367a.f4388p.notifyDataSetChanged();
                        this.f4367a.f4392t = 0;
                        this.f4367a.onInitFocusAreas();
                    }
                }
                if (this.f4367a.f4383k) {
                    this.f4367a.f4383k = false;
                    this.f4367a.f4385m.toPostRequest();
                }
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodFragment$2 */
    class C14792 implements C0924a {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFoodFragment f4368a;

        C14792(HomeDiscoverFoodFragment this$0) {
            this.f4368a = this$0;
        }

        public void onNetWorkResponse(int responseCode) {
            CarlifeProgressDialogContainer.m4686a().mo1468c();
            if (this.f4368a.f4385m.m5957b() == 0) {
                this.f4368a.f4378f.setFooterDividersEnabled(false);
                this.f4368a.f4379g.setStatus(0);
            } else {
                this.f4368a.f4378f.setFooterDividersEnabled(true);
                this.f4368a.f4379g.setStatus(1);
            }
            switch (responseCode) {
                case -3:
                case -1:
                    if (this.f4368a.f4388p.isEmpty()) {
                        this.f4368a.f4381i.m8397a(0);
                        this.f4368a.f4378f.setEmptyView(this.f4368a.f4381i);
                        this.f4368a.f4392t = 0;
                        this.f4368a.onInitFocusAreas();
                        return;
                    }
                    return;
                case -2:
                    if (this.f4368a.f4388p.isEmpty()) {
                        this.f4368a.f4381i.m8397a(1);
                        this.f4368a.f4378f.setEmptyView(this.f4368a.f4381i);
                        this.f4368a.f4392t = 0;
                        this.f4368a.onInitFocusAreas();
                        return;
                    }
                    C2201w.m8371a((int) R.string.common_error_nonetwork, 0);
                    return;
                case 0:
                    if (this.f4368a.f4386n == null) {
                        this.f4368a.f4386n = new ArrayList();
                    }
                    this.f4368a.f4382j.setVisibility(0);
                    this.f4368a.f4392t = this.f4368a.f4386n.size();
                    this.f4368a.f4386n.addAll(this.f4368a.f4385m.m5956a());
                    if (this.f4368a.f4389q == 0) {
                        this.f4368a.f4388p.m3178b(this.f4368a.f4386n);
                        this.f4368a.f4388p.notifyDataSetChanged();
                        this.f4368a.onInitFocusAreas();
                        return;
                    }
                    this.f4368a.m5406a();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodFragment$3 */
    class C14803 implements Comparator<C1925e> {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFoodFragment f4369a;

        C14803(HomeDiscoverFoodFragment this$0) {
            this.f4369a = this$0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5402a((C1925e) obj, (C1925e) obj2);
        }

        /* renamed from: a */
        public int m5402a(C1925e lhs, C1925e rhs) {
            if (rhs.f5969B.compareTo(lhs.f5969B) != 0) {
                return rhs.f5969B.compareTo(lhs.f5969B);
            }
            return lhs.f5980n.compareTo(rhs.f5980n);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodFragment$4 */
    class C14814 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFoodFragment f4370a;

        C14814(HomeDiscoverFoodFragment this$0) {
            this.f4370a = this$0;
        }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (id >= 0) {
                Object model = parent.getItemAtPosition((int) id);
                if (model != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("model", (Serializable) model);
                    this.f4370a.showFragment(NaviFragmentManager.TYPE_HOME_DISCOVER_FOOD_DETAIL, bundle);
                }
            } else if (this.f4370a.f4379g.m8458a() && this.f4370a.f4385m != null) {
                this.f4370a.f4385m.toPostRequest();
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodFragment$5 */
    class C14825 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFoodFragment f4371a;

        C14825(HomeDiscoverFoodFragment this$0) {
            this.f4371a = this$0;
        }

        public void onClick(View v) {
            this.f4371a.showDialog(this.f4371a.f4380h, C1265a.Right);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodFragment$a */
    private class C1483a implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFoodFragment f4372a;

        private C1483a(HomeDiscoverFoodFragment homeDiscoverFoodFragment) {
            this.f4372a = homeDiscoverFoodFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            this.f4372a.dismissDialog(this.f4372a.f4380h);
            this.f4372a.f4380h.setSelected(position);
            switch (position) {
                case 0:
                    if (this.f4372a.f4389q != 0) {
                        this.f4372a.f4388p.m3178b(this.f4372a.f4386n);
                        this.f4372a.f4388p.notifyDataSetChanged();
                        this.f4372a.f4392t = 0;
                        this.f4372a.onInitFocusAreas();
                    }
                    this.f4372a.f4389q = 0;
                    return;
                case 1:
                    if (this.f4372a.f4389q != 1) {
                        this.f4372a.m5406a();
                    }
                    this.f4372a.f4389q = 1;
                    return;
                default:
                    return;
            }
        }
    }

    public void onHiddenChanged(boolean hidden) {
        if (!hidden) {
            setBottomBarStatus(false);
        }
        super.onHiddenChanged(hidden);
        if (NaviAccountUtils.getInstance().isLogin() && !hidden) {
            LogUtil.d(f4375c, "onHiddenChanged NetWork UserQueueRequest");
            this.f4384l.toPostRequest();
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View contentView = inflater.inflate(R.layout.frag_home_discover_food, null);
        setCommonTitleBar(contentView, getResources().getStringArray(R.array.home_discovery)[2]);
        ((TextView) contentView.findViewById(R.id.tv_title_desc)).setText(R.string.home_food_nowait);
        this.f4380h = new C2282f(getContext(), R.string.carmode_order, new SimpleRightDialogAdapter(getContext(), getResources().getStringArray(R.array.home_food_menu)), new C1483a());
        this.f4380h.setSelected(0);
        this.f4382j = (ImageButton) contentView.findViewById(R.id.ib_right);
        this.f4382j.setVisibility(8);
        this.f4382j.setOnClickListener(new C14825(this));
        this.f4381i = (CommonTipView) contentView.findViewById(R.id.common_tip_view);
        this.f4381i.m8403b(R.string.error_nofood);
        this.f4378f = (ListView) contentView.findViewById(R.id.listview);
        this.f4378f.setOverScrollMode(2);
        this.f4378f.setFooterDividersEnabled(false);
        this.f4379g = new LoadMoreFooter(getContext());
        this.f4378f.addFooterView(this.f4379g);
        this.f4388p = new FoodCafeListAdapter(getContext(), this);
        this.f4378f.setAdapter(this.f4388p);
        this.f4378f.setOnItemClickListener(this.f4396x);
        CarlifeProgressDialogContainer.m4686a().mo1467b(getString(R.string.progress_loading));
        this.f4383k = true;
        this.f4384l = new C1649j();
        this.f4384l.registerResponseListener(this.f4393u);
        this.f4385m = new C1647h();
        this.f4385m.registerResponseListener(this.f4394v);
        return contentView;
    }

    public void onResume() {
        super.onResume();
        if (NaviAccountUtils.getInstance().isLogin()) {
            LogUtil.d(f4375c, "onResume NetWork UserQueueRequest");
            this.f4384l.toPostRequest();
        } else if (this.f4383k) {
            this.f4383k = false;
            this.f4385m.toPostRequest();
        }
        if (C1766h.f5369c) {
            this.f4378f.setSelection(0);
        }
        C1766h.f5369c = false;
    }

    public void onDestroy() {
        super.onDestroy();
        C1766h.f5368b = false;
    }

    /* renamed from: a */
    private void m5406a() {
        if (this.f4387o == null) {
            this.f4387o = new ArrayList();
        }
        if (this.f4386n != null) {
            this.f4387o.clear();
            this.f4387o.addAll(this.f4386n);
            Collections.sort(this.f4387o, this.f4395w);
            this.f4388p.m3178b(this.f4387o);
            this.f4388p.notifyDataSetChanged();
            this.f4392t = 0;
            onInitFocusAreas();
        }
    }

    protected void onUpdateSkin() {
        updateCommonSkin();
        this.f4382j.setBackground(C2251b.m8527a(mActivity));
        this.f4382j.setImageDrawable(C2188r.m8331b(R.drawable.com_ic_sequence));
    }

    public void onDetach() {
        super.onDetach();
        if (this.f4384l != null) {
            this.f4384l.cancel();
        }
        if (this.f4385m != null) {
            this.f4385m.cancel();
        }
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void driving() {
        LogUtil.d("yftech", "HomeDiscoverFoodFragment driving");
        CarlifeProgressDialogContainer.m4686a().mo1468c();
        m5410b();
        back();
        C1342a.m4926a().m4931d();
    }

    public void stopDriving() {
        LogUtil.d("yftech", "HomeDiscoverFoodFragment stopDriving");
    }

    /* renamed from: b */
    private void m5410b() {
        if (this.f4380h != null && this.f4380h.isShown()) {
            this.f4380h.mo1526d();
        }
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType()) {
            if (this.f4390r == null) {
                this.f4390r = new C1443g(this.mContentView.findViewById(R.id.temp), 2);
                this.f4390r.m5300d(this.mContentView.findViewById(R.id.ib_left)).m5300d(this.f4382j);
            }
            if (this.f4391s == null) {
                this.f4391s = new C1438c(this.f4378f, 6);
            }
            if (this.f4388p.isEmpty()) {
                C1440d.m5251a().m5256b(this.f4390r);
                C1440d.m5251a().m5268h(this.f4390r);
                return;
            }
            this.f4378f.setSelection(this.f4392t);
            C1440d.m5251a().m5256b(this.f4390r, this.f4391s);
            C1440d.m5251a().m5268h(this.f4391s);
        }
    }
}
