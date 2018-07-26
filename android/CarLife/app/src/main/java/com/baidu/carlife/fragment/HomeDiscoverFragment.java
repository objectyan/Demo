package com.baidu.carlife.fragment;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.logic.C1765g;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.view.DiscoverCardView;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;

public class HomeDiscoverFragment extends ContentFragment implements OnClickListener {
    /* renamed from: a */
    private static final int f4398a = 1;
    /* renamed from: b */
    private static final int f4399b = 2;
    /* renamed from: c */
    private static final int f4400c = 3;
    /* renamed from: d */
    private static final int f4401d = 4;
    /* renamed from: e */
    private static final int f4402e = 5;
    /* renamed from: f */
    private boolean f4403f = false;
    /* renamed from: g */
    private DiscoverCardView f4404g;
    /* renamed from: h */
    private DiscoverCardView f4405h;
    /* renamed from: i */
    private DiscoverCardView f4406i;
    /* renamed from: j */
    private DiscoverCardView f4407j;
    /* renamed from: k */
    private C1443g f4408k;
    /* renamed from: l */
    private C1443g f4409l;
    /* renamed from: m */
    private C0936j f4410m = new C14841(this);

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFragment$1 */
    class C14841 extends C0936j {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFragment f4397a;

        C14841(HomeDiscoverFragment this$0) {
            this.f4397a = this$0;
        }

        public void careAbout() {
            addMsg(1007);
            addMsg(1002);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    C1260i.m4435b("Framework", "handleMessage=MSG_CONNECT_STATUS_DISCONNECTED   HomeDiscoverFragment.");
                    this.f4397a.m5421a();
                    return;
                case 1007:
                    C1260i.m4435b("Framework", "handleMessage=MSG_CONNECT_STATUS_FEATURE_CONFIG_SUCCESS   HomeDiscoverFragment.");
                    this.f4397a.m5421a();
                    return;
                default:
                    return;
            }
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View contentView = inflater.inflate(C0965R.layout.frag_home_discover, null);
        setCommonTitleBar(contentView, getStringUtil(C0965R.string.home_car_service));
        this.f4404g = (DiscoverCardView) contentView.findViewById(C0965R.id.card_1);
        this.f4405h = (DiscoverCardView) contentView.findViewById(C0965R.id.card_2);
        this.f4406i = (DiscoverCardView) contentView.findViewById(C0965R.id.card_3);
        this.f4407j = (DiscoverCardView) contentView.findViewById(C0965R.id.card_4);
        this.f4404g.setOnClickListener(this);
        this.f4405h.setOnClickListener(this);
        this.f4406i.setOnClickListener(this);
        this.f4407j.setOnClickListener(this);
        m5421a();
        return contentView;
    }

    public void onResume() {
        super.onResume();
        C1260i.m4435b("Framework", "HomeDiscoverFragment --onResume ");
        setBottomBarStatus(true);
        m5421a();
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        C1260i.m4435b("Framework", "--onHiddenChanged- hidden=" + hidden);
        m5421a();
    }

    protected void onUpdateSkin() {
        updateCommonSkin();
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onInitFocusAreas() {
        if (this.f4408k == null) {
            this.f4408k = new C1443g(this.mContentView.findViewById(C0965R.id.ll_title), 2);
            this.f4408k.m5300d(this.mContentView.findViewById(C0965R.id.ib_left));
        }
        if (this.f4409l == null) {
            this.f4409l = new C1443g(this.mContentView.findViewById(C0965R.id.discover_ll), 4);
            this.f4409l.m5300d(this.f4404g).m5300d(this.f4405h).m5300d(this.f4406i).m5300d(this.f4407j);
        }
        C1440d.m5251a().m5256b(this.f4408k, this.f4409l);
        C1440d.m5251a().m5268h(this.f4409l);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C1261k.m4460a(this.f4410m);
    }

    public void onDestroy() {
        super.onDestroy();
        C1261k.m4464b(this.f4410m);
    }

    /* renamed from: a */
    private void m5421a() {
        if (this.f4404g == null || this.f4405h == null || this.f4406i == null || this.f4407j == null) {
            C1260i.m4435b("yftech", "HomeDiscoverFragment --updateAdapter Card is null");
            return;
        }
        this.f4403f = m5423b();
        if (this.f4403f) {
            this.f4404g.m8406a((int) C0965R.drawable.home_ic_parking);
            this.f4406i.m8406a((int) C0965R.drawable.home_ic_fuel);
            this.f4405h.m8406a((int) C0965R.drawable.home_ic_food);
            this.f4407j.m8406a((int) C0965R.drawable.home_ic_rescue);
            this.f4404g.m8407a(getStringUtil(C0965R.string.home_discovery_zcw));
            this.f4406i.m8407a(getStringUtil(C0965R.string.home_discovery_qcd));
            this.f4405h.m8407a(getStringUtil(C0965R.string.home_discovery_zms));
            this.f4407j.m8407a(getStringUtil(C0965R.string.home_discovery_hjy));
            this.f4404g.m8408b(getStringUtil(C0965R.string.home_discovery_parking_description));
            this.f4406i.m8408b(getStringUtil(C0965R.string.home_discovery_charge_description));
            this.f4405h.m8408b(getStringUtil(C0965R.string.home_discovery_food_description));
            this.f4407j.m8408b(getStringUtil(C0965R.string.home_discovery_rescue_description));
            this.f4404g.setTagInt(1);
            this.f4406i.setTagInt(5);
            this.f4405h.setTagInt(4);
            this.f4407j.setTagInt(3);
        } else {
            this.f4404g.m8406a((int) C0965R.drawable.home_ic_parking);
            this.f4406i.m8406a((int) C0965R.drawable.home_ic_fuel);
            this.f4405h.m8406a((int) C0965R.drawable.home_ic_food);
            this.f4407j.m8406a((int) C0965R.drawable.home_ic_rescue);
            this.f4404g.m8407a(getStringUtil(C0965R.string.home_discovery_zcw));
            this.f4406i.m8407a(getStringUtil(C0965R.string.home_discovery_qjy));
            this.f4405h.m8407a(getStringUtil(C0965R.string.home_discovery_zms));
            this.f4407j.m8407a(getStringUtil(C0965R.string.home_discovery_hjy));
            this.f4404g.m8408b(getStringUtil(C0965R.string.home_discovery_parking_description));
            this.f4406i.m8408b(getStringUtil(C0965R.string.home_discovery_fuel_description));
            this.f4405h.m8408b(getStringUtil(C0965R.string.home_discovery_food_description));
            this.f4407j.m8408b(getStringUtil(C0965R.string.home_discovery_rescue_description));
            this.f4404g.setTagInt(1);
            this.f4406i.setTagInt(2);
            this.f4405h.setTagInt(4);
            this.f4407j.setTagInt(3);
        }
        this.f4404g.setBackgroundResource(C0965R.color.discover_card_background);
        this.f4405h.setBackgroundResource(C0965R.color.discover_card_background);
        this.f4406i.setBackgroundResource(C0965R.color.discover_card_background);
        this.f4407j.setBackgroundResource(C0965R.color.discover_card_background);
        this.f4404g.setVisibility(0);
        this.f4405h.setVisibility(0);
        this.f4406i.setVisibility(0);
        this.f4407j.setVisibility(0);
        if (C1328h.m4757a().getNaviFragmentManager().isDriving()) {
            this.f4404g.setEnabled(false);
            this.f4405h.setEnabled(false);
            this.f4406i.setEnabled(false);
            this.f4407j.setEnabled(false);
        } else {
            this.f4404g.setEnabled(true);
            this.f4405h.setEnabled(true);
            this.f4406i.setEnabled(true);
            this.f4407j.setEnabled(true);
        }
        C1260i.m4435b("yftech", "HomeDiscoverFragment --updateAdapter ");
    }

    public void onClick(View v) {
        int tag = -1;
        if (v != null && (v instanceof DiscoverCardView)) {
            tag = ((DiscoverCardView) v).getTagInt();
        }
        m5425a(tag);
    }

    /* renamed from: a */
    public void m5425a(int tag) {
        switch (tag) {
            case 1:
                StatisticManager.onEvent(StatisticConstants.DISCOVER_ZCW_0001, StatisticConstants.DISCOVER_ZCW_0001);
                showFragment(NaviFragmentManager.TYPE_HOME_DISCOVER_PARK, null);
                return;
            case 2:
                StatisticManager.onEvent(StatisticConstants.DISCOVER_QJY_0001, StatisticConstants.DISCOVER_QJY_0001);
                innerNameSearch(getStringUtil(C0965R.string.home_discovery_qjy_title));
                return;
            case 3:
                StatisticManager.onEvent(StatisticConstants.DISCOVER_HJY_0001);
                showFragment(NaviFragmentManager.TYPE_HOME_DISCOVER_RESCUE, null);
                return;
            case 4:
                StatisticManager.onEvent(StatisticConstants.DISCOVER_ZMS_0001, StatisticConstants.DISCOVER_ZMS_0001);
                showFragment(NaviFragmentManager.TYPE_HOME_DISCOVER_FOOD, null);
                return;
            case 5:
                if (this.f4403f) {
                    innerNameSearch(getStringUtil(C0965R.string.home_discovery_qcd_title));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void driving() {
        C1260i.m4435b("yftech", "HomeDiscoverFragment driving");
        m5421a();
        dismissDialog();
    }

    public void stopDriving() {
        C1260i.m4435b("yftech", "HomeDiscoverFragment stopDriving");
        m5421a();
    }

    public boolean onVoiceCommand(String strCommand, String strIntent) {
        C1260i.m4435b("Framework", "HomeDiscoverFragment VOICE Command: [" + strCommand + "] [" + strIntent + "]");
        if (this.f4404g != null && this.f4404g.getCardName().contains(strIntent)) {
            onClick(this.f4404g);
            return true;
        } else if (this.f4405h != null && this.f4405h.getCardName().contains(strIntent)) {
            onClick(this.f4405h);
            return true;
        } else if (this.f4406i != null && this.f4406i.getCardName().contains(strIntent)) {
            onClick(this.f4406i);
            return true;
        } else if (this.f4407j == null || !this.f4407j.getCardName().contains(strIntent)) {
            return false;
        } else {
            onClick(this.f4407j);
            return true;
        }
    }

    /* renamed from: b */
    private boolean m5423b() {
        if (C1765g.m6424a().m6436a(C1765g.f5344i) == C1765g.f5356u || m5424c()) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private boolean m5424c() {
        return "20272111".equals(C2186p.m8304a().m8309a(C1253f.jA, ""));
    }
}
