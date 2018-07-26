package com.baidu.carlife.fragment;

import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.adpter.C0984g;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1253f.C1252a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.connect.C1212c;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.logic.C1856o;
import com.baidu.carlife.logic.C1868q;
import com.baidu.carlife.logic.codriver.adapter.C1754b;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.music.C1834p;
import com.baidu.carlife.logic.p082b.C1502b;
import com.baidu.carlife.logic.p082b.C1715a;
import com.baidu.carlife.logic.voice.C1903m;
import com.baidu.carlife.model.C1937p;
import com.baidu.carlife.model.C1942q;
import com.baidu.carlife.model.C1943r;
import com.baidu.carlife.p054k.C1660s;
import com.baidu.carlife.p054k.C1662u;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.carlife.p054k.p055a.C1635h;
import com.baidu.carlife.p054k.p055a.C1635h.C1489c;
import com.baidu.carlife.p054k.p055a.C1635h.C1633a;
import com.baidu.carlife.p054k.p055a.C1635h.C1634b;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p083g.C1605a;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.p100n.C1977e;
import com.baidu.carlife.radio.p079c.C2139a;
import com.baidu.carlife.radio.p079c.C2139a.C1491a;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.carlife.radio.p080b.aa;
import com.baidu.carlife.radio.p080b.aa.C1496a;
import com.baidu.carlife.radio.p102a.C2105a;
import com.baidu.carlife.util.C2170a;
import com.baidu.carlife.util.C2177h;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.util.C2191s;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.C2342g;
import com.baidu.carlife.view.HomeCardView;
import com.baidu.carlife.view.MainTopBarView;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.dialog.C2276d;
import com.baidu.che.codriver.protocol.C2566d.C2565a;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData.Result;
import com.baidu.che.codriver.protocol.data.nlp.RestrictionData;
import com.baidu.che.codriver.sdk.p081a.C2593g.C1499a;
import com.baidu.che.codriver.ui.p124d.C2704g;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2736p;
import com.baidu.che.codriver.vr.C2673m.C2837c;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.controller.AccountController;
import com.baidu.navi.controller.AccountController.IAccountListener;
import com.baidu.navi.controller.UserCenterController;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Random;

public class HomeFragment extends ContentFragment implements OnClickListener, OnItemClickListener {
    /* renamed from: a */
    public static String f4452a = HomeFragment.class.getSimpleName();
    /* renamed from: b */
    private static final int f4453b = 99;
    /* renamed from: c */
    private static final int f4454c = 101;
    /* renamed from: A */
    private boolean f4455A = false;
    /* renamed from: B */
    private C2276d f4456B;
    /* renamed from: C */
    private C0984g f4457C;
    /* renamed from: d */
    private HomeCardView f4458d;
    /* renamed from: e */
    private HomeCardView f4459e;
    /* renamed from: f */
    private HomeCardView f4460f;
    /* renamed from: g */
    private HomeCardView f4461g;
    /* renamed from: h */
    private HomeCardView f4462h;
    /* renamed from: i */
    private C0936j f4463i;
    /* renamed from: j */
    private C1443g f4464j;
    /* renamed from: k */
    private C1443g f4465k;
    /* renamed from: l */
    private C1443g f4466l;
    /* renamed from: m */
    private SimpleDraweeView f4467m;
    /* renamed from: n */
    private View f4468n;
    /* renamed from: o */
    private View f4469o;
    /* renamed from: p */
    private View f4470p;
    /* renamed from: q */
    private C1953c f4471q;
    /* renamed from: r */
    private boolean f4472r = false;
    /* renamed from: s */
    private C1662u f4473s;
    /* renamed from: t */
    private C1660s f4474t;
    /* renamed from: u */
    private Drawable f4475u;
    /* renamed from: v */
    private String f4476v;
    /* renamed from: w */
    private String f4477w;
    /* renamed from: x */
    private C0924a f4478x = new C14941(this);
    /* renamed from: y */
    private C0924a f4479y = new C0924a(this) {
        /* renamed from: a */
        final /* synthetic */ HomeFragment f4431a;

        {
            this.f4431a = this$0;
        }

        public void onNetWorkResponse(int responseCode) {
            C1937p vehicleLogoModel = this.f4431a.f4474t.m5974b();
            final String channel = this.f4431a.f4474t.m5972a();
            String fileName = channel + "_1.png";
            String filePath = BaseFragment.mActivity.getFilesDir().getAbsolutePath() + File.separator + fileName;
            this.f4431a.f4476v = null;
            this.f4431a.f4475u = null;
            if (vehicleLogoModel == null) {
                if (C1253f.jx.m4403a().equals(channel)) {
                    this.f4431a.f4476v = C2186p.m8304a().m8309a(channel + "VehicleName", null);
                    this.f4431a.f4475u = Drawable.createFromPath(new File(filePath).getAbsolutePath());
                    this.f4431a.m5458a(this.f4431a.f4475u, this.f4431a.f4476v);
                }
            } else if (C1253f.jx.m4403a().equals(channel)) {
                final String timeStamp = vehicleLogoModel.f6113c;
                this.f4431a.f4476v = vehicleLogoModel.f6112b;
                C2186p.m8304a().m8319b(channel + "VehicleName", this.f4431a.f4476v);
                File logoFile = new File(filePath);
                if (C2186p.m8304a().m8309a(channel + "TimeStamp", "").equals(timeStamp) && logoFile.exists()) {
                    this.f4431a.f4475u = Drawable.createFromPath(logoFile.getAbsolutePath());
                    this.f4431a.m5458a(this.f4431a.f4475u, this.f4431a.f4476v);
                    return;
                }
                this.f4431a.m5458a(null, this.f4431a.f4476v);
                final C1635h vehicleLogoDownload = new C1635h(this.f4431a.getContext(), vehicleLogoModel.f6111a, fileName, BaseFragment.mActivity.getFilesDir().getAbsolutePath(), null, true, 0);
                vehicleLogoDownload.m5921a(new C1489c(this) {
                    /* renamed from: d */
                    final /* synthetic */ AnonymousClass12 f4430d;

                    /* renamed from: a */
                    public void mo1561a(C1634b state, C1633a errorCode) {
                        if (C1634b.SUCESS == state) {
                            C2186p.m8304a().m8319b(channel + "TimeStamp", timeStamp);
                            if (vehicleLogoDownload.m5922b() != null && C1663a.m5979a().m5993N()) {
                                this.f4430d.f4431a.f4475u = Drawable.createFromPath(vehicleLogoDownload.m5922b().getAbsolutePath());
                                this.f4430d.f4431a.m5458a(this.f4430d.f4431a.f4475u, this.f4430d.f4431a.f4476v);
                            }
                        }
                    }

                    /* renamed from: a */
                    public void mo1560a(long total, int progress) {
                    }
                });
                vehicleLogoDownload.m5924e();
            }
        }
    };
    /* renamed from: z */
    private Random f4480z = new Random();

    /* renamed from: com.baidu.carlife.fragment.HomeFragment$1 */
    class C14941 implements C0924a {
        /* renamed from: a */
        final /* synthetic */ HomeFragment f4441a;

        C14941(HomeFragment this$0) {
            this.f4441a = this$0;
        }

        public void onNetWorkResponse(int responseCode) {
            if (responseCode == 0 && this.f4441a.isAdded()) {
                if (this.f4441a.f4473s == null) {
                    this.f4441a.m5480h();
                }
                C1943r weatherModel = this.f4441a.f4473s.m5978a();
                this.f4441a.m5464a(weatherModel.f6171f, weatherModel.f6166a, weatherModel.f6172g);
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeFragment$2 */
    class C14952 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ HomeFragment f4442a;

        C14952(HomeFragment this$0) {
            this.f4442a = this$0;
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == 0) {
                this.f4442a.f4467m.setAlpha(0.4f);
            } else if (event.getAction() == 1) {
                this.f4442a.f4467m.setAlpha(1.0f);
            }
            return false;
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeFragment$3 */
    class C14973 implements C1496a {
        /* renamed from: a */
        final /* synthetic */ HomeFragment f4443a;

        C14973(HomeFragment this$0) {
            this.f4443a = this$0;
        }

        /* renamed from: a */
        public void mo1563a(int count) {
            this.f4443a.m5466b(count);
        }

        /* renamed from: a */
        public void mo1564a(String error) {
            C1260i.m4435b(HomeFragment.f4452a, "UserOnlineNumberRequest error " + error);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeFragment$4 */
    class C15004 implements C1499a {
        /* renamed from: a */
        final /* synthetic */ HomeFragment f4445a;

        /* renamed from: com.baidu.carlife.fragment.HomeFragment$4$1 */
        class C14981 extends TypeToken<RestrictionData> {
            /* renamed from: a */
            final /* synthetic */ C15004 f4444a;

            C14981(C15004 this$1) {
                this.f4444a = this$1;
            }
        }

        C15004(HomeFragment this$0) {
            this.f4445a = this$0;
        }

        /* renamed from: a */
        public void mo1565a(C2565a error) {
            C2716c.m10156d("");
            if (this.f4445a.f4458d != null) {
                this.f4445a.f4458d.m8429b("");
            }
        }

        /* renamed from: a */
        public void mo1566a(NLPResponseData response) {
            C2716c.m10156d("");
            if (this.f4445a.f4458d != null) {
                if (response == null || response.resultList == null || response.resultList.size() <= 0 || !C2704g.f8845d.equals(((Result) response.resultList.get(0)).cardType) || !"universal_search".equals(((Result) response.resultList.get(0)).intent) || ((Result) response.resultList.get(0)).ttsStatus == null || ((Result) response.resultList.get(0)).data == null) {
                    this.f4445a.f4458d.m8429b("");
                    return;
                }
                RestrictionData restrictionData = (RestrictionData) new Gson().fromJson(((Result) response.resultList.get(0)).data, new C14981(this).getType());
                if (restrictionData != null) {
                    this.f4445a.f4458d.m8429b(restrictionData.getTodayRestriction());
                }
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeFragment$5 */
    class C15015 implements SapiCallBack<GetPortraitResponse> {
        /* renamed from: a */
        final /* synthetic */ HomeFragment f4446a;

        C15015(HomeFragment this$0) {
            this.f4446a = this$0;
        }

        public /* synthetic */ void onSuccess(SapiResponse sapiResponse) {
            m5449a((GetPortraitResponse) sapiResponse);
        }

        /* renamed from: a */
        public void m5449a(GetPortraitResponse getPortraitResponse) {
            this.f4446a.f4467m.setController(C1605a.m5867a(this.f4446a.f4467m, getPortraitResponse.portrait, 52, 52));
            C2186p.m8304a().m8319b("account_portrait_url", getPortraitResponse.portrait);
        }

        public void onNetworkFailed() {
            String portrait = C2186p.m8304a().m8309a("account_portrait_url", "");
            if (!TextUtils.isEmpty(portrait)) {
                this.f4446a.f4467m.setController(C1605a.m5867a(this.f4446a.f4467m, portrait, 52, 52));
            }
        }

        public void onSystemError(int i) {
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeFragment$6 */
    class C15036 extends C1502b {
        /* renamed from: a */
        final /* synthetic */ HomeFragment f4447a;

        C15036(HomeFragment this$0) {
            this.f4447a = this$0;
        }

        /* renamed from: a */
        public boolean mo1567a(int position) {
            switch (position) {
                case 2:
                    return C1715a.m6265a();
                default:
                    return false;
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeFragment$7 */
    class C15047 implements IAccountListener {
        /* renamed from: a */
        final /* synthetic */ HomeFragment f4448a;

        C15047(HomeFragment this$0) {
            this.f4448a = this$0;
        }

        public void onLogResult(boolean success) {
            if (success) {
                StatisticManager.onEvent(StatisticConstants.HOME_MINE_0007);
                UserCenterController.getInstance().startUpdateUserInfo(1, null);
                this.f4448a.m5497p();
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeFragment$8 */
    class C15058 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ HomeFragment f4449a;

        C15058(HomeFragment this$0) {
            this.f4449a = this$0;
        }

        public void onClick() {
            this.f4449a.m5499q();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeFragment$9 */
    class C15069 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ HomeFragment f4450a;

        C15069(HomeFragment this$0) {
            this.f4450a = this$0;
        }

        public void run() {
            if (!TextUtils.isEmpty(SysOSAPIv2.getInstance().getSdcardPath())) {
                String naviCacheDir = SysOSAPIv2.getInstance().getSdcardPath() + File.separator + C1253f.hM + File.separator + "tmp";
                if (!TextUtils.isEmpty(naviCacheDir)) {
                    File file = new File(naviCacheDir);
                    if (file.exists()) {
                        C2177h.m8270a(file);
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeFragment$a */
    private class C1507a extends C0936j {
        /* renamed from: a */
        final /* synthetic */ HomeFragment f4451a;

        private C1507a(HomeFragment homeFragment) {
            this.f4451a = homeFragment;
        }

        public void careAbout() {
            addMsg(3007);
            addMsg(3008);
            addMsg(C1253f.gi);
            addMsg(225);
            addMsg(1002);
            addMsg(C1253f.fm);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 99:
                    this.f4451a.m5473d();
                    return;
                case 101:
                    this.f4451a.dismissDialog(this.f4451a.f4456B);
                    return;
                case 225:
                    this.f4451a.m5456a(msg.arg1);
                    return;
                case 1002:
                case 3007:
                    if (C1663a.m5979a().m5993N()) {
                        this.f4451a.m5488l();
                    } else {
                        this.f4451a.m5458a(null, null);
                    }
                    this.f4451a.m5478g();
                    if (msg.what == 1002) {
                        C1260i.m4435b(HomeFragment.f4452a, "####### MSG_CONNECT_STATUS_DISCONNECTED : " + this.f4451a.f4470p);
                        if (this.f4451a.f4470p != null) {
                            this.f4451a.f4470p.setVisibility(8);
                            View bank1 = this.f4451a.mContentView.findViewById(C0965R.id.card_bank_1);
                            if (bank1 != null) {
                                bank1.setVisibility(8);
                            }
                            View bank2 = this.f4451a.mContentView.findViewById(C0965R.id.card_bank_2);
                            if (bank2 != null) {
                                bank2.setVisibility(8);
                            }
                            View bank3 = this.f4451a.mContentView.findViewById(C0965R.id.card_bank_3);
                            if (bank3 != null) {
                                bank3.setVisibility(8);
                            }
                            View bank4 = this.f4451a.mContentView.findViewById(C0965R.id.card_bank_4);
                            if (bank4 != null) {
                                bank4.setVisibility(8);
                            }
                            this.f4451a.mContentView.requestLayout();
                            return;
                        }
                        return;
                    }
                    return;
                case C1253f.fm /*1040*/:
                    this.f4451a.m5513a();
                    return;
                case 3008:
                    this.f4451a.m5490m();
                    return;
                case C1253f.gi /*3012*/:
                    if (this.f4451a.getCurrentFragmentType() == this.f4451a.fragmentType) {
                        this.f4451a.m5478g();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private void m5458a(Drawable drawable, String name) {
        if (isAdded() && this.f4461g != null) {
            if (drawable == null) {
                this.f4461g.m8438e((int) C0965R.drawable.home_ic_carlife_card);
            } else {
                this.f4461g.m8432c(drawable);
            }
            if (!TextUtils.isEmpty(name)) {
                this.f4461g.m8434c(name);
            } else if (C2170a.m8217a()) {
                this.f4461g.m8439f((int) C0965R.drawable.home_ic_carlife_name);
            } else {
                this.f4461g.m8434c("Baidu CarLife");
            }
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(C0965R.layout.frag_home_big_screen, null);
        this.f4463i = new C1507a();
        C1261k.m4460a(this.f4463i);
        setBottomBarStatus(true);
        m5465b();
        m5471c();
        m5480h();
        C1261k.m4461b(3007);
        try {
            NaviAccountUtils.getInstance().initAccount(BaiduNaviApplication.getInstance());
            NaviAccountUtils.getInstance().asyncGetUserInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        C2191s.m8343a(false, true, false, true);
        C2342g.m8864e().m8892b();
        C1868q.m7089f().m7123i();
        if (BNLocationManagerProxy.getInstance().isLocationValid()) {
            m5476f();
            m5475e();
        } else {
            this.f4463i.postDelayed(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ HomeFragment f4432a;

                {
                    this.f4432a = this$0;
                }

                public void run() {
                    if (BNLocationManagerProxy.getInstance().isLocationValid()) {
                        this.f4432a.m5476f();
                    }
                    this.f4432a.m5475e();
                }
            }, 2000);
        }
        return this.mContentView;
    }

    /* renamed from: b */
    private void m5465b() {
        this.f4458d = (HomeCardView) this.mContentView.findViewById(C0965R.id.home_card_navi);
        this.f4459e = (HomeCardView) this.mContentView.findViewById(C0965R.id.home_card_music);
        this.f4460f = (HomeCardView) this.mContentView.findViewById(C0965R.id.home_card_discover);
        this.f4461g = (HomeCardView) this.mContentView.findViewById(C0965R.id.home_card_carlife);
        this.f4462h = (HomeCardView) this.mContentView.findViewById(C0965R.id.home_card_exit);
        this.f4467m = (SimpleDraweeView) this.mContentView.findViewById(C0965R.id.btn_person);
        this.f4468n = this.mContentView.findViewById(C0965R.id.rl_person);
        this.f4469o = this.mContentView.findViewById(C0965R.id.red_point);
        this.f4470p = this.mContentView.findViewById(C0965R.id.viewadapt);
        m5513a();
    }

    /* renamed from: c */
    private void m5471c() {
        this.f4468n.setOnClickListener(this);
        this.f4458d.setOnClickListener(this);
        this.f4459e.setOnClickListener(this);
        this.f4460f.setOnClickListener(this);
        this.f4461g.setOnClickListener(this);
        if (this.f4462h != null) {
            this.f4462h.setOnClickListener(this);
        }
        this.f4458d.m8420a(new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ HomeFragment f4434a;

            {
                this.f4434a = this$0;
            }

            public void onClick(View v) {
                StatisticManager.onEvent(StatisticConstants.HOME_ICON_0006);
                this.f4434a.m5505t();
            }
        }).m8428b(new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ HomeFragment f4433a;

            {
                this.f4433a = this$0;
            }

            public void onClick(View v) {
                StatisticManager.onEvent(StatisticConstants.HOME_ICON_0007);
                this.f4433a.m5503s();
            }
        });
        this.f4460f.m8420a(new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ HomeFragment f4435a;

            {
                this.f4435a = this$0;
            }

            public void onClick(View v) {
                StatisticManager.onEvent(StatisticConstants.HOME_ICON_0001);
                C1856o.m7042a().m7046c();
                this.f4435a.showFragment(NaviFragmentManager.TYPE_HOME_DISCOVER, null);
            }
        });
        this.f4461g.m8433c(new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ HomeFragment f4436a;

            {
                this.f4436a = this$0;
            }

            public void onClick(View v) {
                StatisticManager.onEvent(StatisticConstants.HOME_ICON_0004);
                this.f4436a.showFragment(NaviFragmentManager.TYPE_HOME_MORE, null);
            }
        });
        this.f4459e.m8420a(new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ HomeFragment f4440a;

            /* renamed from: com.baidu.carlife.fragment.HomeFragment$19$1 */
            class C14931 implements C1491a {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass19 f4439a;

                C14931(AnonymousClass19 this$1) {
                    this.f4439a = this$1;
                }

                /* renamed from: a */
                public void mo1562a() {
                    if (C1818h.m6730b().m6829q()) {
                        C1834p.m6925a().m6928d();
                    }
                    C1818h.m6730b().m6836x();
                }
            }

            {
                this.f4440a = this$0;
            }

            public void onClick(View v) {
                C1903m.m7252a().m7255b();
                StatisticManager.onEvent(StatisticConstants.HOME_ICON_0009);
                if (C1818h.m6730b().m6834v()) {
                    C1834p.m6925a().m6927c();
                    C1818h.m6730b().m6811f(true);
                } else if (C1251e.m4358a().m4401r()) {
                    new C2139a(this.f4440a.getContext()).m8066a(this.f4440a, new C14931(this));
                } else {
                    C2201w.m8370a((int) C0965R.string.network_unconnected);
                }
            }
        }).m8428b(new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ HomeFragment f4438a;

            /* renamed from: com.baidu.carlife.fragment.HomeFragment$18$1 */
            class C14921 implements C1491a {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass18 f4437a;

                C14921(AnonymousClass18 this$1) {
                    this.f4437a = this$1;
                }

                /* renamed from: a */
                public void mo1562a() {
                    C1818h.m6730b().m6813g(true);
                    C1818h.m6730b().m6789a(true);
                }
            }

            {
                this.f4438a = this$0;
            }

            public void onClick(View v) {
                C1903m.m7252a().m7255b();
                StatisticManager.onEvent(StatisticConstants.HOME_ICON_0010);
                if (C1251e.m4358a().m4401r()) {
                    new C2139a(this.f4438a.getContext()).m8066a(this.f4438a, new C14921(this));
                } else {
                    C2201w.m8370a((int) C0965R.string.network_unconnected);
                }
            }
        });
        this.f4468n.setOnTouchListener(new C14952(this));
    }

    /* renamed from: d */
    private void m5473d() {
        if (!this.f4455A && getCurrentFragment() == this && C1818h.m6730b().m6834v()) {
            this.f4459e.m8440g(0);
            this.f4459e.getMusicMelody().setStartIndex(this.f4480z.nextInt(40));
            this.f4459e.getMusicMelody().invalidate();
            this.f4463i.sendEmptyMessageDelayed(99, 200);
            return;
        }
        this.f4463i.removeMsg(99);
        this.f4459e.m8440g(8);
    }

    /* renamed from: a */
    private void m5456a(int dataType) {
        if (C1818h.m6730b().m6834v() && dataType == 101) {
            this.f4455A = false;
            m5473d();
            C2105a channelModel = C2142b.m8067a().m8077c(C1818h.m6730b().m6831s().m6644n());
            if (channelModel != null) {
                this.f4472r = true;
                String channelName = channelModel.m7895b();
                if (!C2170a.m8217a()) {
                    if ("每日随心".equals(channelName)) {
                        channelName = "Daily Audio";
                    } else if (C1942q.f6153u.equals(channelName)) {
                        channelName = "Music";
                    } else if ("儿童".equals(channelName)) {
                        channelName = "Children";
                    } else if ("听书".equals(channelName)) {
                        channelName = "Audio Book";
                    } else if ("电台".equals(channelName)) {
                        channelName = "Radio";
                    } else if ("语音点播".equals(channelName)) {
                        channelName = "VOD";
                    } else if ("情感".equals(channelName)) {
                        channelName = "Emotion";
                    } else if ("学习".equals(channelName)) {
                        channelName = "Study";
                    } else if ("新闻".equals(channelName)) {
                        channelName = "News";
                    } else if ("娱乐".equals(channelName)) {
                        channelName = "Recreation";
                    }
                }
                this.f4459e.m8429b(channelName);
            }
            this.f4459e.m8426b((int) C0965R.drawable.com_home_ic_music_pause_selector);
            this.f4459e.m8431c((int) C0965R.drawable.com_home_ic_music_next_selector);
            this.f4459e.m8425b();
            return;
        }
        this.f4455A = true;
        m5473d();
        this.f4459e.m8426b((int) C0965R.drawable.com_home_ic_music_play_selector01);
    }

    /* renamed from: e */
    private void m5475e() {
        if (C1251e.m4358a().m4401r()) {
            new aa().m7944a(new C14973(this));
        }
    }

    /* renamed from: b */
    private void m5466b(int count) {
        if (this.f4459e != null && !this.f4472r) {
            if (count <= 0) {
                this.f4459e.m8429b("");
            } else if (count < 10000) {
                this.f4459e.m8429b(String.valueOf(count) + getResources().getString(C0965R.string.listen_user));
            } else if (count < C1253f.iE) {
                int tmp = count / 1000;
                if (tmp % 10 == 0) {
                    this.f4459e.m8429b(String.valueOf(m5512a((double) ((tmp / 10) * 10000))) + getResources().getString(C0965R.string.listen_user));
                } else {
                    this.f4459e.m8429b(String.valueOf(m5512a((((double) tmp) / 10.0d) * 10000.0d)) + getResources().getString(C0965R.string.listen_user));
                }
            } else {
                this.f4459e.m8429b(getResources().getString(C0965R.string.listen_user_ten_m));
            }
        }
    }

    /* renamed from: a */
    public String m5512a(double num) {
        return new DecimalFormat("#,##0").format(num);
    }

    /* renamed from: f */
    private void m5476f() {
        C2716c.m10156d("cltcwidg");
        C1754b.m6365a().m6380a(GeoLocateModel.getInstance().getCurrentDistrict().mName + "限行信息", new C15004(this));
    }

    /* renamed from: g */
    private void m5478g() {
        if (this.f4461g != null) {
            if (C1977e.m7498a().m7557b()) {
                this.f4461g.m8436d(0);
            } else if (C1663a.m5979a().m5993N() || !C1856o.m7042a().m7045b()) {
                this.f4461g.m8436d(8);
            } else {
                this.f4461g.m8436d(0);
            }
        }
    }

    /* renamed from: h */
    private void m5480h() {
        this.f4473s = new C1662u();
        this.f4473s.registerResponseListener(this.f4478x);
    }

    protected void onInitView() {
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0965R.id.home_card_navi:
                C2342g.m8864e().m8895f();
                StatisticManager.onEvent(StatisticConstants.HOME_ICON_0005);
                m5507u();
                return;
            case C0965R.id.home_card_music:
                C1903m.m7252a().m7255b();
                StatisticManager.onEvent(StatisticConstants.HOME_ICON_0008);
                showFragment(NaviFragmentManager.TYPE_RADIO_CHANNEL, null);
                return;
            case C0965R.id.rl_person:
                C2342g.m8864e().m8895f();
                m5492n();
                return;
            case C0965R.id.home_card_discover:
                C2342g.m8864e().m8895f();
                StatisticManager.onEvent(StatisticConstants.HOME_ICON_0001);
                C1856o.m7042a().m7046c();
                showFragment(NaviFragmentManager.TYPE_HOME_DISCOVER, null);
                return;
            case C0965R.id.home_card_carlife:
                C2342g.m8864e().m8895f();
                StatisticManager.onEvent(StatisticConstants.HOME_ICON_0004);
                showFragment(NaviFragmentManager.TYPE_HOME_MORE, null);
                return;
            case C0965R.id.home_card_exit:
                m5501r();
                return;
            default:
                return;
        }
    }

    public void onPause() {
        super.onPause();
        this.f4455A = true;
    }

    public void onResume() {
        super.onResume();
        C1261k.m4461b(3007);
        m5478g();
        m5482i();
        m5490m();
        m5487k();
        C1260i.m4434b(f4452a);
        this.f4455A = false;
        this.f4463i.removeMsg(99);
        if (C1818h.m6730b().m6834v()) {
            m5473d();
        }
        m5485j();
    }

    /* renamed from: i */
    private void m5482i() {
        if (this.f4469o != null) {
            if (C1715a.m6265a()) {
                this.f4469o.setVisibility(0);
            } else {
                this.f4469o.setVisibility(8);
            }
        }
    }

    /* renamed from: j */
    private void m5485j() {
        if (NaviAccountUtils.getInstance().isLogin()) {
            if (NaviAccountUtils.getInstance().getPortraitUrl() != null) {
                this.f4467m.setController(C1605a.m5867a(this.f4467m, NaviAccountUtils.getInstance().getPortraitUrl(), 52, 52));
                return;
            }
            NaviAccountUtils.getInstance().asyncGetProtraitUrl(new C15015(this));
        } else if (this.f4467m != null) {
            this.f4467m.setImageURI("");
        }
    }

    /* renamed from: k */
    private void m5487k() {
        if (this.f4473s == null) {
            m5480h();
        }
        if (this.f4473s.m5978a() == null) {
            this.f4473s.toPostRequest();
        }
    }

    public boolean onBackPressed() {
        if (mActivity != null) {
            mActivity.m3108d();
        }
        return true;
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        C1260i.m4434b(f4452a);
        m5487k();
        m5478g();
        m5482i();
        if (hidden) {
            this.f4455A = true;
            C2342g.m8864e().m8895f();
            return;
        }
        this.f4455A = false;
        m5473d();
    }

    public boolean onVoiceCommand(String strCommand, String strIntent) {
        C1260i.m4435b(f4452a, "HomeFragment VOICE Command: " + strCommand + " # " + strIntent);
        if (strIntent.equals("发现")) {
            onClick(this.f4460f);
            return true;
        } else if (this.f4456B != null && this.f4456B.isShown()) {
            return this.f4456B.m8612a(strCommand, strIntent);
        } else {
            if (!strIntent.equals(C2736p.f8994x)) {
                return false;
            }
            onClick(this.f4468n);
            return true;
        }
    }

    /* renamed from: a */
    private void m5457a(int drawableId, int stringId) {
        this.f4475u = getResources().getDrawable(drawableId);
        this.f4476v = getString(stringId);
        m5458a(this.f4475u, this.f4476v);
        this.f4477w = C1253f.jx.m4403a();
    }

    /* renamed from: l */
    private void m5488l() {
        C1252a v = C1253f.jx;
        switch (v) {
            case VEHICLE_CHANNEL_NORMAL:
                this.f4475u = null;
                this.f4476v = null;
                m5458a(this.f4475u, this.f4476v);
                this.f4477w = v.m4403a();
                return;
            default:
                if (!v.m4403a().equals(this.f4477w) || this.f4475u == null) {
                    this.f4477w = v.m4403a();
                    this.f4474t = new C1660s();
                    this.f4474t.registerResponseListener(this.f4479y);
                    this.f4474t.m5973a(this.f4477w);
                    this.f4474t.toGetRequest();
                    return;
                }
                m5458a(this.f4475u, this.f4476v);
                return;
        }
    }

    /* renamed from: m */
    private void m5490m() {
        MainTopBarView topbarview = (MainTopBarView) this.mContentView.findViewById(C0965R.id.main_comm_top_bar);
        if (C1663a.m5979a().m5993N()) {
            topbarview.m8463b(true);
            return;
        }
        topbarview.m8463b(false);
        m5458a(null, null);
    }

    public void onDestroyView() {
        this.f4471q = null;
        super.onDestroyView();
    }

    public void onDetach() {
        C1261k.m4464b(this.f4463i);
        super.onDetach();
    }

    protected void onUpdateSkin() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    /* renamed from: a */
    private void m5464a(String temperature, String state, int pm25) {
        C1260i.m4435b(f4452a, "temperature = " + temperature + ", state = " + state);
        if (this.mContentView != null && !TextUtils.isEmpty(temperature) && !TextUtils.isEmpty(state) && temperature.length() > 1) {
            TextView leftTV = (TextView) this.mContentView.findViewById(C0965R.id.tv_left_bar);
            leftTV.setCompoundDrawablesWithIntrinsicBounds(m5453a(state), null, null, null);
            temperature = temperature.trim();
            if (!C1251e.m4370e(temperature)) {
                leftTV.setText(temperature);
            }
        }
    }

    /* renamed from: a */
    private Drawable m5453a(String state) {
        if (TextUtils.isEmpty(state)) {
            return null;
        }
        if (state.contains(C1253f.gA)) {
            return getResources().getDrawable(C0965R.drawable.statusbaric_ic_weather_cloudy);
        }
        if (state.contains(C1253f.gB)) {
            return getResources().getDrawable(C0965R.drawable.statusbaric_ic_weather_fine);
        }
        if (state.contains(C1253f.gz)) {
            return getResources().getDrawable(C0965R.drawable.statusbaric_ic_weather_rain);
        }
        if (state.contains(C1253f.gC)) {
            return getResources().getDrawable(C0965R.drawable.statusbaric_ic_weather_snow);
        }
        if (state.contains(C1253f.gD)) {
            return getResources().getDrawable(C0965R.drawable.statusbaric_ic_weather_shade);
        }
        return null;
    }

    public void onInitFocusAreas() {
        if (this.mContentView != null && this.f4458d != null && this.f4459e != null && this.f4460f != null && this.f4461g != null && this.f4468n != null) {
            C1440d focusManager = C1440d.m5251a();
            if (this.f4465k == null) {
                this.f4465k = new C1443g(this.mContentView, 2);
                this.f4465k.m5300d(this.f4468n);
            }
            if (this.f4464j == null) {
                this.f4464j = new C1443g(this.mContentView.findViewById(C0965R.id.layout_icons), 4);
                this.f4464j.m5300d(this.f4458d).m5300d(this.f4459e).m5300d(this.f4460f).m5300d(this.f4461g);
                if (this.f4462h != null && this.f4462h.isShown()) {
                    this.f4464j.m5300d(this.f4462h);
                }
            }
            View rootView = mActivity.m3125u().m4695g();
            if (this.f4466l == null) {
                this.f4466l = new C1443g(rootView, 6);
                this.f4466l.m5300d(rootView.findViewById(C0965R.id.iv_home)).m5300d(rootView.findViewById(C0965R.id.iv_phone_book)).m5300d(rootView.findViewById(C0965R.id.iv_voice_focus_bg)).m5300d(rootView.findViewById(C0965R.id.iv_navi)).m5300d(rootView.findViewById(C0965R.id.iv_music));
            }
            this.f4466l.m5298b(true);
            this.f4466l.m5297b(rootView.findViewById(C0965R.id.iv_voice_focus_bg));
            focusManager.m5256b(this.f4465k, this.f4464j, this.f4466l);
            focusManager.m5268h(this.f4466l);
        }
    }

    /* renamed from: n */
    private void m5492n() {
        if (this.f4457C == null) {
            this.f4457C = new C0984g(getActivity());
            this.f4457C.m3191a(new C15036(this));
        }
        if (this.f4456B == null) {
            this.f4456B = new C2276d(getActivity(), this.f4457C, this);
            this.f4456B.m8618j();
            this.f4456B.setSelected(0);
        } else {
            this.f4456B.mo1630i();
        }
        m5497p();
        showDialog(this.f4456B, C1265a.left);
    }

    /* renamed from: o */
    private void m5495o() {
        AccountController.getInstance().loginIn(new C15047(this));
    }

    /* renamed from: p */
    private void m5497p() {
        if (this.f4457C != null) {
            boolean isLogin;
            String userName = getContext().getString(C0965R.string.user_not_login);
            try {
                isLogin = NaviAccountUtils.getInstance().isLogin();
            } catch (Exception e) {
                isLogin = false;
            }
            if (isLogin) {
                userName = NaviAccountUtils.getInstance().getUserName();
            }
            this.f4457C.m3192a(userName);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        this.f4463i.removeMsg(101);
        int nDelayHideDlg = 0;
        switch (position) {
            case 0:
                if (NaviAccountUtils.getInstance().isLogin()) {
                    showFragment(NaviFragmentManager.TYPE_HOME_MY_DETAIL, null);
                } else if (this.f4457C.m3193a()) {
                    StatisticManager.onEvent(StatisticConstants.HOME_MINE_0001, StatisticConstants.HOME_ACCOUNT_LOGIN_001);
                    m5495o();
                } else {
                    return;
                }
                nDelayHideDlg = 200;
                break;
            case 1:
                showFragment(NaviFragmentManager.TYPE_ROUTE_RECORD, null);
                nDelayHideDlg = 200;
                break;
            case 2:
                showFragment(NaviFragmentManager.TYPE_MAP_SETTING, null);
                nDelayHideDlg = 200;
                break;
            case 3:
                showFragment(NaviFragmentManager.TYPE_VOICE_SETTING, null);
                nDelayHideDlg = 200;
                break;
            case 4:
                showFragment(NaviFragmentManager.TYPE_HOME_HELP_PANEL, null);
                nDelayHideDlg = 100;
                break;
            case 5:
                if (this.f4471q == null) {
                    this.f4471q = new C1953c(mActivity).m7442b((int) C0965R.string.alert_delete_navi_cache).m7435a((int) C0965R.string.alert_delete_navi_cache_content).m7457g(17).m7447c((int) C0965R.string.alert_confirm).m7458q().m7450d((int) C0965R.string.alert_cancel);
                    this.f4471q.m7438a(new C15058(this));
                }
                showDialog(this.f4471q);
                StatisticManager.onEvent(StatisticConstants.SETTINGS_CLEAN_BUFFER, StatisticConstants.SETTINGS_CLEAN_BUFFER);
                break;
            case 6:
                showFragment(539, null);
                StatisticManager.onEvent(StatisticConstants.SETTINGS_ABOUT, StatisticConstants.SETTINGS_ABOUT);
                nDelayHideDlg = 100;
                break;
        }
        this.f4463i.sendEmptyMessageDelayed(101, (long) nDelayHideDlg);
    }

    /* renamed from: q */
    private void m5499q() {
        new Thread(new C15069(this)).start();
    }

    /* renamed from: r */
    private void m5501r() {
        C1212c command = new C1212c(true);
        command.m4201c(C1253f.au);
        C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
    }

    /* renamed from: s */
    private void m5503s() {
        if (AddressSettingModel.hasSetCompAddr(C1157a.m3876a())) {
            m5463a(AddressSettingModel.getCompAddrNode(C1157a.m3876a()));
        } else {
            C1754b.m6365a().m6378a(C2837c.STATE_SET_COMPANY);
        }
    }

    /* renamed from: t */
    private void m5505t() {
        if (AddressSettingModel.hasSetHomeAddr(C1157a.m3876a())) {
            m5463a(AddressSettingModel.getHomeAddrNode(C1157a.m3876a()));
        } else {
            C1754b.m6365a().m6378a(C2837c.STATE_SET_HOME);
        }
    }

    /* renamed from: u */
    private void m5507u() {
        C1260i.m4435b(f4452a, "goVoiceNavi" + C2837c.STATE_WHERE_GOING);
        C1754b.m6365a().m6378a(C2837c.STATE_WHERE_GOING);
    }

    /* renamed from: a */
    private void m5463a(final RoutePlanNode node) {
        if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
            showDialog(new C1953c(mActivity).m7435a((int) C0965R.string.dialog_quit_naviing_to_navi).m7447c((int) C0965R.string.alert_confirm).m7450d((int) C0965R.string.alert_cancel).m7438a(new C0672b(this) {
                /* renamed from: b */
                final /* synthetic */ HomeFragment f4425b;

                public void onClick() {
                    this.f4425b.m5469b(node);
                }
            }), C1265a.Center);
        } else {
            m5469b(node);
        }
    }

    /* renamed from: b */
    private void m5469b(RoutePlanNode node) {
        openNavi();
        if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
            BaiduNaviSDKManager.getInstance().quitNavi();
        }
        if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
            BaiduNaviSDKManager.getInstance().quitCruise();
        }
        C1328h.m4757a().backTo(17, null);
        NavPoiController.getInstance().startCalcRoute(node);
    }

    /* renamed from: a */
    public void m5513a() {
        if (this.f4470p != null && C1249d.m4334m()) {
            this.f4470p.setVisibility(0);
            View bank1 = this.mContentView.findViewById(C0965R.id.card_bank_1);
            if (bank1 != null) {
                bank1.setVisibility(0);
            }
            View bank2 = this.mContentView.findViewById(C0965R.id.card_bank_2);
            if (bank2 != null) {
                bank2.setVisibility(0);
            }
            View bank3 = this.mContentView.findViewById(C0965R.id.card_bank_3);
            if (bank3 != null) {
                bank3.setVisibility(0);
            }
            View bank4 = this.mContentView.findViewById(C0965R.id.card_bank_4);
            if (bank4 != null) {
                bank4.setVisibility(0);
            }
            this.mContentView.requestLayout();
        }
    }
}
