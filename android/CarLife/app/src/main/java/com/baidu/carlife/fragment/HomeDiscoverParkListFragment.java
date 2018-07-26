package com.baidu.carlife.fragment;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.adpter.C0981e;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.C1269a;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.logic.C1765g;
import com.baidu.carlife.p054k.C1650k;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.carlife.p077e.C1435a;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;

public class HomeDiscoverParkListFragment extends ContentFragment implements C0924a {
    /* renamed from: a */
    private TextView f4415a;
    /* renamed from: b */
    private TextView f4416b;
    /* renamed from: c */
    private ListView f4417c;
    /* renamed from: d */
    private C1650k f4418d;
    /* renamed from: e */
    private CommonTipView f4419e;
    /* renamed from: f */
    private C0981e f4420f;
    /* renamed from: g */
    private C1443g f4421g;
    /* renamed from: h */
    private C1438c f4422h;
    /* renamed from: i */
    private C1488a f4423i;

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverParkListFragment$1 */
    class C14851 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverParkListFragment f4411a;

        C14851(HomeDiscoverParkListFragment this$0) {
            this.f4411a = this$0;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if (this.f4411a.f4420f != null) {
                StatisticManager.onEvent(StatisticConstants.DISCOVER_ZCW_0002, StatisticConstants.DISCOVER_ZCW_0002);
                C1269a searchPoi = this.f4411a.f4420f.m3184a(position);
                if (searchPoi != null) {
                    this.f4411a.startCalcRoute(searchPoi);
                }
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverParkListFragment$2 */
    class C14862 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverParkListFragment f4412a;

        C14862(HomeDiscoverParkListFragment this$0) {
            this.f4412a = this$0;
        }

        public void onClick(View v) {
            if (this.f4412a.m5430c()) {
                this.f4412a.openWebView(4, NaviFragmentManager.TYPE_HOME_DISCOVER_CWYD, this.f4412a.getStringUtil(C0965R.string.home_discovery_cwyd), WebViewFragment.f4872l);
            } else {
                C2201w.m8373a("当前城市，暂不支持该服务", 0);
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverParkListFragment$3 */
    class C14873 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverParkListFragment f4413a;

        C14873(HomeDiscoverParkListFragment this$0) {
            this.f4413a = this$0;
        }

        public void onClick(View v) {
            if (this.f4413a.m5428b()) {
                StatisticManager.onEvent(StatisticConstants.DISCOVER_ETCP_0001);
                this.f4413a.openWebView(1, NaviFragmentManager.TYPE_HOME_DISCOVER_ETCP, this.f4413a.getStringUtil(C0965R.string.home_discovery_etcp_title), WebViewFragment.f4870j);
                return;
            }
            C2201w.m8373a("当前城市，暂不支持该服务", 0);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverParkListFragment$a */
    private class C1488a extends C0936j {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverParkListFragment f4414a;

        private C1488a(HomeDiscoverParkListFragment homeDiscoverParkListFragment) {
            this.f4414a = homeDiscoverParkListFragment;
        }

        public void careAbout() {
            addMsg(1002);
            addMsg(1004);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    this.f4414a.m5432d();
                    return;
                case 1004:
                    this.f4414a.m5432d();
                    return;
                default:
                    return;
            }
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        setBottomBarStatus(false);
        ViewGroup contentView = (ViewGroup) inflater.inflate(C0965R.layout.frag_home_discover_parklist, null);
        setCommonTitleBar(contentView, getResources().getStringArray(C0965R.array.home_discovery)[0]);
        ((TextView) contentView.findViewById(C0965R.id.tv_title_desc)).setText("");
        this.f4417c = (ListView) contentView.findViewById(C0965R.id.listview);
        this.f4417c.setOverScrollMode(2);
        this.f4417c.setHeaderDividersEnabled(false);
        this.f4419e = (CommonTipView) contentView.findViewById(C0965R.id.common_tip_view);
        this.f4419e.m8398a((int) C0965R.string.error_nopark, (int) C0965R.drawable.com_ic_parking_empty);
        if (BNLocationManagerProxy.getInstance().getCurLocation() != null) {
            C1307e.m4686a().mo1467b(getString(C0965R.string.progress_loading));
            this.f4418d = new C1650k();
            this.f4418d.registerResponseListener(this);
            this.f4418d.toPostRequest();
        } else {
            this.f4419e.m8397a(2);
            this.f4417c.setEmptyView(this.f4419e);
        }
        this.f4417c.setOnItemClickListener(new C14851(this));
        this.f4415a = (TextView) contentView.findViewById(C0965R.id.home_parking_book);
        this.f4415a.setBackground(C2251b.m8527a(getActivity()));
        this.f4415a.setOnClickListener(new C14862(this));
        this.f4416b = (TextView) contentView.findViewById(C0965R.id.home_parking_etcp);
        this.f4416b.setBackground(C2251b.m8527a(getActivity()));
        this.f4416b.setOnClickListener(new C14873(this));
        m5432d();
        this.f4423i = new C1488a();
        C1261k.m4460a(this.f4423i);
        return contentView;
    }

    public void onResume() {
        super.onResume();
        if (this.mBackBundle != null && this.mBackBundle.getInt(WebViewFragment.f4863c, 0) == 1) {
            if (BNLocationManagerProxy.getInstance().getCurLocation() != null) {
                C1307e.m4686a().mo1467b(getString(C0965R.string.progress_loading));
                this.f4418d = new C1650k();
                this.f4418d.registerResponseListener(this);
                this.f4418d.toPostRequest();
            } else {
                this.f4419e.m8397a(2);
                this.f4417c.setEmptyView(this.f4419e);
            }
            this.mBackBundle = null;
        }
    }

    public void onHiddenChanged(boolean hidden) {
        if (!hidden) {
            setBottomBarStatus(false);
        }
        super.onHiddenChanged(hidden);
    }

    protected void onInitView() {
    }

    protected void onUpdateSkin() {
        updateCommonSkin();
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onNetWorkResponse(int responseCode) {
        if (isAdded()) {
            C1307e.m4686a().mo1468c();
            switch (responseCode) {
                case -3:
                case -1:
                    this.f4419e.m8397a(0);
                    this.f4417c.setEmptyView(this.f4419e);
                    onInitFocusAreas();
                    return;
                case -2:
                    this.f4419e.m8397a(1);
                    this.f4417c.setEmptyView(this.f4419e);
                    onInitFocusAreas();
                    return;
                case 0:
                    this.f4420f = new C0981e(getContext());
                    this.f4420f.m3186a(this.f4418d.m5961a());
                    this.f4417c.setAdapter(this.f4420f);
                    onInitFocusAreas();
                    return;
                default:
                    return;
            }
        }
    }

    public void driving() {
        C1260i.m4435b("yftech", "HomeDiscoverFragment driving");
        m5427a();
        back();
        C1342a.m4926a().m4931d();
    }

    public void stopDriving() {
    }

    public void onDestroy() {
        C1261k.m4464b(this.f4423i);
        setBottomBarStatus(true);
        super.onDestroy();
    }

    /* renamed from: a */
    private void m5427a() {
        if (C1343b.m4932a().m4935b() && C1307e.m4686a().mo1469d()) {
            C1307e.m4686a().mo1468c();
        }
    }

    public void onInitFocusAreas() {
        if (getCurrentFragmentType() == NaviFragmentManager.TYPE_HOME_DISCOVER_PARK) {
            if (this.f4421g == null) {
                this.f4421g = new C1443g(this.mContentView.findViewById(C0965R.id.temp), 2);
                this.f4421g.m5300d(this.mContentView.findViewById(C0965R.id.ib_left));
            }
            if (this.f4422h == null) {
                this.f4422h = new C1438c(this.f4417c, 6);
            }
            if (this.f4420f == null || this.f4420f.isEmpty()) {
                C1440d.m5251a().m5256b(this.f4421g);
                C1440d.m5251a().m5268h(this.f4421g);
                return;
            }
            C1440d.m5251a().m5256b(this.f4421g, this.f4422h);
            C1440d.m5251a().m5268h(this.f4422h);
        }
    }

    /* renamed from: b */
    private boolean m5428b() {
        if (C1435a.m5226a().m5234f()) {
            String cities = C1435a.m5226a().m5232d();
            C1260i.m4440c("Framework", "cities=" + cities + ", focusUI=" + C1765g.m6424a().m6442c());
            DistrictInfo mDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
            C1260i.m4440c("Framework", "DistrictInfo=" + mDistrictInfo);
            if (!C1765g.m6424a().m6442c() && cities.contains(String.valueOf(mDistrictInfo.mId))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m5430c() {
        if (!C1663a.m5979a().m5993N() && C1435a.m5226a().m5235g()) {
            String cities = C1435a.m5226a().m5233e();
            C1260i.m4440c("Framework", "cities=" + cities + ", focusUI=" + C1765g.m6424a().m6442c());
            DistrictInfo mDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
            C1260i.m4440c("Framework", "DistrictInfo=" + mDistrictInfo);
            if (!C1765g.m6424a().m6442c() && cities.contains(String.valueOf(mDistrictInfo.mId))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    private void m5432d() {
        if (this.f4416b != null && this.f4415a != null) {
            if (m5430c()) {
                this.f4415a.setVisibility(0);
            } else {
                this.f4415a.setVisibility(8);
            }
            if (C1663a.m5979a().m5993N()) {
                this.f4416b.setVisibility(8);
            } else if (m5428b()) {
                this.f4416b.setVisibility(0);
            } else {
                this.f4416b.setVisibility(8);
            }
        }
    }

    public boolean onVoiceCommand(int selectIndex) {
        if (this.f4420f != null) {
            C1269a searchPoi = this.f4420f.m3184a(selectIndex);
            if (searchPoi != null) {
                startCalcRoute(searchPoi);
                return true;
            }
        }
        return false;
    }
}
