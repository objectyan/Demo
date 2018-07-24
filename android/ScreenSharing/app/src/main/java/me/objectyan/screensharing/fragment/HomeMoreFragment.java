package com.baidu.carlife.fragment;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.R;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.CommonParams.EnumVehicleChannel;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.core.config.CarlifeConfig;
import com.baidu.carlife.custom.elhyf.C1371b;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.p100n.C1977e;
import com.baidu.carlife.view.DiscoverCardView;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;

@SuppressLint({"ValidFragment"})
public class HomeMoreFragment extends ContentFragment implements OnClickListener {
    /* renamed from: a */
    private static final String f4483a = "HomeMoreFragment";
    /* renamed from: b */
    private static final int f4484b = 1;
    /* renamed from: c */
    private static final int f4485c = 2;
    /* renamed from: d */
    private static final int f4486d = 3;
    /* renamed from: e */
    private static final int f4487e = 4;
    /* renamed from: f */
    private static final int f4488f = 5;
    /* renamed from: g */
    private DiscoverCardView f4489g;
    /* renamed from: h */
    private DiscoverCardView f4490h;
    /* renamed from: i */
    private DiscoverCardView f4491i;
    /* renamed from: j */
    private DiscoverCardView f4492j;
    /* renamed from: k */
    private C1510a f4493k;
    /* renamed from: l */
    private C1443g f4494l;
    /* renamed from: m */
    private C1443g f4495m;
    /* renamed from: n */
    private C1508b f4496n;
    /* renamed from: o */
    private boolean f4497o = false;

    /* renamed from: com.baidu.carlife.fragment.HomeMoreFragment$b */
    public interface C1508b {
        /* renamed from: a */
        void mo1573a();
    }

    /* renamed from: com.baidu.carlife.fragment.HomeMoreFragment$1 */
    class C15091 implements C1508b {
        /* renamed from: a */
        final /* synthetic */ HomeMoreFragment f4481a;

        C15091(HomeMoreFragment this$0) {
            this.f4481a = this$0;
        }

        /* renamed from: a */
        public void mo1573a() {
            this.f4481a.m5522b();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeMoreFragment$a */
    private class C1510a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ HomeMoreFragment f4482a;

        public C1510a(HomeMoreFragment homeMoreFragment, Looper looper) {
            this.f4482a = homeMoreFragment;
            super(looper);
        }

        public void careAbout() {
            addMsg(3008);
            addMsg(CommonParams.bU);
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 3008:
                    if (this.f4482a.isAdded()) {
                        this.f4482a.m5519a();
                        return;
                    }
                    return;
                case CommonParams.bU /*16875523*/:
                    String channel = msg.obj;
                    if (channel == null) {
                        this.f4482a.f4497o = false;
                    } else if (this.f4482a.m5525a(channel)) {
                        LogUtil.d(HomeMoreFragment.f4483a, "is yuanfeng ELH");
                        this.f4482a.f4497o = true;
                    }
                    if (this.f4482a.isAdded()) {
                        this.f4482a.m5519a();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View contentView = inflater.inflate(R.layout.frag_home_more, null);
        setCommonTitleBar(contentView, "CarLife");
        this.f4489g = (DiscoverCardView) contentView.findViewById(R.id.card_1);
        this.f4490h = (DiscoverCardView) contentView.findViewById(R.id.card_2);
        this.f4491i = (DiscoverCardView) contentView.findViewById(R.id.card_3);
        this.f4492j = (DiscoverCardView) contentView.findViewById(R.id.card_4);
        this.f4489g.setBackgroundResource(R.color.discover_card_background);
        this.f4490h.setBackgroundResource(R.color.discover_card_background);
        this.f4491i.setBackgroundResource(R.color.discover_card_background);
        this.f4492j.setBackgroundResource(R.color.discover_card_background);
        this.f4489g.setOnClickListener(this);
        this.f4490h.setOnClickListener(this);
        this.f4491i.setOnClickListener(this);
        this.f4492j.setOnClickListener(this);
        if (CommonParams.sVehicleChannel == EnumVehicleChannel.VEHICLE_CHANNEL_YUANFENG_ELH_ONLINE || CommonParams.sVehicleChannel == EnumVehicleChannel.VEHICLE_CHANNEL_YUANFENG_ELH_PCBA) {
            this.f4497o = true;
        }
        this.f4493k = new C1510a(this, Looper.getMainLooper());
        MsgHandlerCenter.m4460a(this.f4493k);
        return contentView;
    }

    /* renamed from: a */
    private void m5519a() {
        int count;
        LogUtil.d(f4483a, "setupView");
        if (C1663a.m5979a().m5993N()) {
            if (this.f4497o) {
                if (CarlifeConfig.m4067c()) {
                    this.f4489g.m8406a((int) R.drawable.home_ic_quit);
                    this.f4490h.m8406a((int) R.drawable.home_ic_recorder);
                    this.f4491i.m8406a((int) R.drawable.home_ic_wx);
                    this.f4492j.m8406a((int) R.drawable.home_ic_upgrade);
                    this.f4489g.m8407a(getStringUtil(R.string.home_more_quit));
                    this.f4490h.m8407a(getStringUtil(R.string.home_more_recorder));
                    this.f4491i.m8407a(getStringUtil(R.string.home_more_wx));
                    this.f4492j.m8407a(getStringUtil(R.string.home_more_component_update));
                    this.f4489g.m8408b(getStringUtil(R.string.home_more_quit_description));
                    this.f4490h.m8408b(getStringUtil(R.string.home_more_recorder_description));
                    this.f4491i.m8408b(getStringUtil(R.string.home_more_wx_description));
                    this.f4492j.m8408b(getStringUtil(R.string.home_more_elh_update_description));
                    this.f4489g.setTagInt(3);
                    this.f4490h.setTagInt(4);
                    this.f4491i.setTagInt(1);
                    this.f4492j.setTagInt(5);
                    this.f4496n = new C15091(this);
                    C1977e.m7498a().m7553a(this.f4496n);
                    m5522b();
                    count = 4;
                } else {
                    this.f4489g.m8406a((int) R.drawable.home_ic_quit);
                    this.f4490h.m8406a((int) R.drawable.home_ic_recorder);
                    this.f4489g.m8407a(getStringUtil(R.string.home_more_quit));
                    this.f4490h.m8407a(getStringUtil(R.string.home_more_recorder));
                    this.f4489g.m8408b(getStringUtil(R.string.home_more_quit_description));
                    this.f4490h.m8408b(getStringUtil(R.string.home_more_recorder_description));
                    this.f4489g.setTagInt(3);
                    this.f4490h.setTagInt(4);
                    count = 2;
                }
            } else if (CarlifeConfig.m4067c()) {
                this.f4489g.m8406a((int) R.drawable.home_ic_quit);
                this.f4490h.m8406a((int) R.drawable.home_ic_wx);
                this.f4489g.m8407a(getStringUtil(R.string.home_more_quit));
                this.f4490h.m8407a(getStringUtil(R.string.home_more_wx));
                this.f4489g.m8408b(getStringUtil(R.string.home_more_quit_description));
                this.f4490h.m8408b(getStringUtil(R.string.home_more_wx_description));
                this.f4489g.setTagInt(3);
                this.f4490h.setTagInt(1);
                count = 2;
            } else {
                this.f4489g.m8406a((int) R.drawable.home_ic_quit);
                this.f4489g.m8407a(getStringUtil(R.string.home_more_quit));
                this.f4489g.m8408b(getStringUtil(R.string.home_more_quit_description));
                this.f4489g.setTagInt(3);
                count = 1;
            }
            if (CommonParams.sVehicleChannel == EnumVehicleChannel.VEHICLE_CHANNEL_AUDI || CommonParams.sVehicleChannel == EnumVehicleChannel.VEHICLE_CHANNEL_AUDI_DUAL_AUDIO) {
                this.f4489g.m8407a(getStringUtil(R.string.home_more_quit_audi));
            } else if (CommonParams.sVehicleChannel == EnumVehicleChannel.VEHICLE_CHANNEL_DAIMLER) {
                this.f4489g.m8407a(getStringUtil(R.string.home_more_quit_benz));
            }
            if (CarlifeScreenUtil.m4334m()) {
                this.f4489g.m8406a((int) R.drawable.home_ic_activity);
                this.f4489g.m8407a(getStringUtil(R.string.home_more_activity));
                this.f4489g.m8408b(getStringUtil(R.string.home_more_activity_description));
                this.f4489g.setTagInt(2);
                this.f4489g.setEnabled(false);
            }
        } else {
            this.f4489g.m8406a((int) R.drawable.home_ic_activity);
            this.f4489g.m8407a(getStringUtil(R.string.home_more_activity));
            this.f4489g.m8408b(getStringUtil(R.string.home_more_activity_description));
            this.f4489g.setTagInt(2);
            count = 1;
        }
        if (count == 4) {
            this.f4489g.setVisibility(0);
            this.f4490h.setVisibility(0);
            this.f4491i.setVisibility(0);
            this.f4492j.setVisibility(0);
        } else if (count == 3) {
            this.f4489g.setVisibility(0);
            this.f4490h.setVisibility(0);
            this.f4491i.setVisibility(0);
            this.f4492j.setVisibility(4);
        } else if (count == 2) {
            this.f4489g.setVisibility(0);
            this.f4490h.setVisibility(0);
            this.f4491i.setVisibility(4);
            this.f4492j.setVisibility(4);
        } else if (count == 1) {
            this.f4489g.setVisibility(0);
            this.f4490h.setVisibility(4);
            this.f4491i.setVisibility(4);
            this.f4492j.setVisibility(4);
        }
    }

    /* renamed from: b */
    private void m5522b() {
        if (C1977e.m7498a().m7557b()) {
            this.f4492j.setRedPointVisibility(0);
        } else {
            this.f4492j.setRedPointVisibility(8);
        }
    }

    /* renamed from: c */
    private void m5524c() {
        CarlifeCmdMessage command = new CarlifeCmdMessage(true);
        command.m4201c(CommonParams.au);
        C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
    }

    public void onResume() {
        super.onResume();
        setBottomBarStatus(true);
        m5519a();
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onClick(View v) {
        int tag = -1;
        if (v != null && (v instanceof DiscoverCardView)) {
            tag = ((DiscoverCardView) v).getTagInt();
        }
        switch (tag) {
            case 1:
                StatisticManager.onEvent(StatisticConstants.HOME_WECHAT_001);
                showFragment(NaviFragmentManager.TYPE_WECHAT_MAIN, null);
                return;
            case 2:
                StatisticManager.onEvent(StatisticConstants.HOME_CARLIFE_001);
                openWebView(3, NaviFragmentManager.TYPE_HOME_MORE_ACTS, "活动专区", WebViewFragment.f4871k);
                return;
            case 3:
                m5524c();
                return;
            case 4:
                showFragment(NaviFragmentManager.TYPE_MY_CAR_RECORD, null);
                return;
            case 5:
                if (CarlifeConfig.m4067c()) {
                    C1371b.m4996a().m5014d();
                    return;
                } else {
                    C1977e.m7498a().m7558c();
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: a */
    public boolean m5525a(String cha) {
        if (cha.equals(EnumVehicleChannel.VEHICLE_CHANNEL_YUANFENG_ELH_ONLINE.getChannel()) || cha.equals(EnumVehicleChannel.VEHICLE_CHANNEL_YUANFENG_ELH_PCBA.getChannel())) {
            return true;
        }
        return false;
    }

    public void onInitFocusAreas() {
        if (getCurrentFragmentType() == NaviFragmentManager.TYPE_HOME_MORE) {
            if (this.f4494l == null) {
                this.f4494l = new C1443g(this.mContentView.findViewById(R.id.ll_title), 2);
                this.f4494l.m5300d(this.mContentView.findViewById(R.id.ib_left));
            }
            if (this.f4495m == null) {
                this.f4495m = new C1443g(this.mContentView.findViewById(R.id.discover_ll), 4);
                this.f4495m.m5300d(this.f4489g).m5300d(this.f4490h).m5300d(this.f4491i).m5300d(this.f4492j);
            }
            C1440d.m5251a().m5256b(this.f4494l, this.f4495m);
            C1440d.m5251a().m5268h(this.f4495m);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        C1977e.m7498a().m7553a(null);
    }
}
