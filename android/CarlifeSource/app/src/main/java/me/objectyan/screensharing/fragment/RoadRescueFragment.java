package com.baidu.carlife.fragment;

import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.screen.OnBtnClickListener;
import com.baidu.carlife.logic.C1868q;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xmlpull.v1.XmlPullParser;

public class RoadRescueFragment extends ContentFragment implements OnClickListener {
    /* renamed from: a */
    public static final String f4748a = RoadRescueFragment.class.getSimpleName();
    /* renamed from: b */
    public static final String f4749b = "key_rescue_name";
    /* renamed from: c */
    public static final String f4750c = "key_rescue_phone";
    /* renamed from: d */
    public static final String f4751d = "key_rescue_car_num";
    /* renamed from: e */
    public static final String f4752e = "key_rescue_car_color";
    /* renamed from: f */
    public static final String f4753f = "key_rescue_contact_name";
    /* renamed from: g */
    public static final String f4754g = "key_rescue_contact_phone";
    /* renamed from: h */
    public static final String f4755h = "key_rescue_show_info";
    /* renamed from: i */
    private LinearLayout f4756i;
    /* renamed from: j */
    private LinearLayout f4757j;
    /* renamed from: k */
    private LinearLayout f4758k;
    /* renamed from: l */
    private TextView f4759l;
    /* renamed from: m */
    private ImageButton f4760m;
    /* renamed from: n */
    private MsgBaseHandler f4761n = new C1570a();
    /* renamed from: o */
    private View f4762o;
    /* renamed from: p */
    private View f4763p;
    /* renamed from: q */
    private TextView f4764q;
    /* renamed from: r */
    private TextView f4765r;
    /* renamed from: s */
    private TextView f4766s;
    /* renamed from: t */
    private TextView f4767t;
    /* renamed from: u */
    private TextView f4768u;
    /* renamed from: v */
    private TextView f4769v;
    /* renamed from: w */
    private C1443g f4770w;
    /* renamed from: x */
    private C1443g f4771x;

    /* renamed from: com.baidu.carlife.fragment.RoadRescueFragment$1 */
    class C15691 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ RoadRescueFragment f4746a;

        /* renamed from: com.baidu.carlife.fragment.RoadRescueFragment$1$1 */
        class C15681 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C15691 f4745a;

            C15681(C15691 this$1) {
                this.f4745a = this$1;
            }

            public void run() {
                this.f4745a.f4746a.m5782a(C2186p.m8304a().m8309a(RoadRescueFragment.f4749b, null), C2186p.m8304a().m8309a(RoadRescueFragment.f4750c, null), C2186p.m8304a().m8309a(RoadRescueFragment.f4753f, null), C2186p.m8304a().m8309a(RoadRescueFragment.f4754g, null), C2186p.m8304a().m8309a(RoadRescueFragment.f4751d, null), C2186p.m8304a().m8309a(RoadRescueFragment.f4752e, null));
            }
        }

        C15691(RoadRescueFragment this$0) {
            this.f4746a = this$0;
        }

        public void onClick() {
            StatisticManager.onEvent(StatisticConstants.DISCOVER_HJY_0003);
            if (CarlifeUtil.m4358a().m4401r()) {
                new Thread(new C15681(this)).start();
            }
            C1868q.m7089f().m7107a(this.f4746a.getContext(), "010-57390680");
            StatisticManager.onEvent(StatisticConstants.HOME_DISCOVERY_RESCUE_CALL, StatisticConstants.HOME_DISCOVERY_RESCUE_CALL);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.RoadRescueFragment$a */
    private class C1570a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ RoadRescueFragment f4747a;

        private C1570a(RoadRescueFragment roadRescueFragment) {
            this.f4747a = roadRescueFragment;
        }

        public void careAbout() {
            addMsg(3011);
        }

        public void handleMessage(Message msg) {
            LogUtil.m4440c(RoadRescueFragment.f4748a, "msg.what=" + msg.what);
            switch (msg.what) {
                case 3011:
                    try {
                        if (C2186p.m8304a().m8312a(RoadRescueFragment.f4755h, false)) {
                            this.f4747a.m5779a();
                            this.f4747a.f4763p.setVisibility(0);
                            this.f4747a.f4758k.setVisibility(8);
                            this.f4747a.f4760m.setAlpha(1.0f);
                            this.f4747a.f4760m.setEnabled(true);
                            return;
                        }
                        this.f4747a.f4763p.setVisibility(8);
                        this.f4747a.f4758k.setVisibility(0);
                        this.f4747a.f4760m.setAlpha(0.2f);
                        this.f4747a.f4760m.setEnabled(false);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public RoadRescueFragment() {
        MsgHandlerCenter.m4460a(this.f4761n);
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        LogUtil.m4440c(f4748a, "onCreateContentView");
        this.f4762o = inflater.inflate(R.layout.frag_road_rescue, null);
        setCommonTitleBar(this.f4762o, getString(R.string.rescue_service));
        this.f4760m = (ImageButton) this.f4762o.findViewById(R.id.ib_right);
        this.f4756i = (LinearLayout) this.f4762o.findViewById(R.id.linlayout_add_info);
        this.f4757j = (LinearLayout) this.f4762o.findViewById(R.id.linlayout_dialing);
        this.f4758k = (LinearLayout) this.f4762o.findViewById(R.id.linlayout_add_info_container);
        this.f4759l = (TextView) this.f4762o.findViewById(R.id.tv_rescue_provide);
        this.f4763p = this.f4762o.findViewById(R.id.stub_rescue_info);
        this.f4764q = (TextView) this.f4762o.findViewById(R.id.tv_rescue_name);
        this.f4765r = (TextView) this.f4762o.findViewById(R.id.tv_rescue_phone);
        this.f4766s = (TextView) this.f4762o.findViewById(R.id.tv_rescue_car_num);
        this.f4767t = (TextView) this.f4762o.findViewById(R.id.tv_rescue_car_color);
        this.f4768u = (TextView) this.f4762o.findViewById(R.id.tv_rescue_contact_name);
        this.f4769v = (TextView) this.f4762o.findViewById(R.id.tv_rescue_contact_phone);
        this.f4760m.setVisibility(0);
        this.f4760m.setImageResource(R.drawable.com_ic_edit);
        String rescueProvider = getResources().getString(R.string.rescue_provider);
        SpannableStringBuilder spBuilder = new SpannableStringBuilder(rescueProvider);
        spBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cl_other_c_highlight)), rescueProvider.length() - 4, rescueProvider.length(), 33);
        this.f4759l.setText(spBuilder);
        boolean showRescueInfo = C2186p.m8304a().m8312a(f4755h, false);
        this.f4756i.setOnClickListener(this);
        this.f4757j.setOnClickListener(this);
        this.f4759l.setOnClickListener(this);
        this.f4760m.setOnClickListener(this);
        if (showRescueInfo) {
            m5779a();
            this.f4763p.setVisibility(0);
            this.f4758k.setVisibility(8);
            this.f4760m.setAlpha(1.0f);
            this.f4760m.setEnabled(true);
        } else {
            this.f4760m.setAlpha(0.2f);
            this.f4760m.setEnabled(false);
        }
        return this.f4762o;
    }

    protected void onUpdateSkin() {
        updateCommonSkin();
        if (this.f4760m != null) {
            this.f4760m.setBackground(C2251b.m8527a(mActivity));
        }
    }

    public void onHiddenChanged(boolean hidden) {
        if (!hidden) {
            setBottomBarStatus(false);
        }
        super.onHiddenChanged(hidden);
    }

    public void onResume() {
        super.onResume();
        if (getNaviFragmentManager().isDriving()) {
            LogUtil.d("yftech", "RoadRescueFragment onResume driving");
            m5786c();
            return;
        }
        LogUtil.d("yftech", "RoadRescueFragment onResume stopDriving");
        m5784b();
    }

    /* renamed from: a */
    private void m5779a() {
        String rescueName = C2186p.m8304a().m8309a(f4749b, null);
        String rescuePhone = C2186p.m8304a().m8309a(f4750c, null);
        String rescueCarNum = C2186p.m8304a().m8309a(f4751d, null);
        String rescueCarColor = C2186p.m8304a().m8309a(f4752e, null);
        String rescueContactName = C2186p.m8304a().m8309a(f4753f, null);
        String rescueContactPhone = C2186p.m8304a().m8309a(f4754g, null);
        if (TextUtils.isEmpty(rescueName)) {
            this.f4764q.setText("");
        } else {
            this.f4764q.setText(rescueName);
        }
        if (TextUtils.isEmpty(rescuePhone)) {
            this.f4765r.setText("");
        } else {
            this.f4765r.setText(rescuePhone);
        }
        if (TextUtils.isEmpty(rescueCarNum)) {
            this.f4766s.setText("");
        } else {
            this.f4766s.setText(rescueCarNum);
        }
        if (TextUtils.isEmpty(rescueCarColor)) {
            this.f4767t.setText("");
        } else {
            this.f4767t.setText(rescueCarColor);
        }
        if (TextUtils.isEmpty(rescueContactName)) {
            this.f4768u.setText("");
        } else {
            this.f4768u.setText(rescueContactName);
        }
        if (TextUtils.isEmpty(rescueContactPhone)) {
            this.f4769v.setText("");
        } else {
            this.f4769v.setText(rescueContactPhone);
        }
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_right:
            case R.id.linlayout_add_info:
                if (!showConnectForbidDialog()) {
                    showFragment(551, null);
                    return;
                }
                return;
            case R.id.linlayout_dialing:
                StatisticManager.onEvent(StatisticConstants.DISCOVER_HJY_0002);
                C1953c commonDialog = new C1953c(getContext()).m7435a((int) R.string.rescue_call_yuanmeng).m7447c((int) R.string.alert_cancel).m7459r().m7450d((int) R.string.alert_confirm);
                commonDialog.m7443b(new C15691(this));
                showDialog(commonDialog);
                return;
            case R.id.tv_rescue_provide:
                showFragment(NaviFragmentManager.TYPE_MAP_YMSERVICEDETAIL, null);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m5782a(String name, String phone, String contactName, String contactPhone, String carNum, String carColor) {
        if (mActivity != null) {
            InputStream soapInStream = null;
            InputStream fsdInStream = null;
            try {
                soapInStream = mActivity.getAssets().open("carlife_soap.xml");
                String soap = m5788a(soapInStream);
                fsdInStream = mActivity.getAssets().open("carlife_fsd.xml");
                String fsdSoap = m5788a(fsdInStream);
                if (TextUtils.isEmpty(name)) {
                    name = "";
                }
                if (TextUtils.isEmpty(phone)) {
                    phone = "13800000000";
                }
                if (TextUtils.isEmpty(contactPhone)) {
                    contactPhone = "";
                }
                if (TextUtils.isEmpty(contactName)) {
                    contactName = "";
                }
                if (TextUtils.isEmpty(carNum)) {
                    carNum = "";
                }
                if (TextUtils.isEmpty(carColor)) {
                    carColor = "";
                }
                String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
                if (soap == null || fsdSoap == null) {
                    if (soapInStream != null) {
                        try {
                            soapInStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fsdInStream != null) {
                        try {
                            fsdInStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return;
                    }
                    return;
                }
                fsdSoap = fsdSoap.replaceAll("CARLIFE_RESCUE_TIME", time).replaceAll("CARLIFE_LINK_NAME", name).replaceAll("CARLIFE_LINK_PHONE", phone).replaceAll("CARLIFE_CONTACT_NAME", contactName).replaceAll("CARLIFE_CONTACT_PHONE", contactPhone).replaceAll("CARLIFE_RESCUE_CAR_NUMBER", carNum).replaceAll("CARLIFE_RESCUE_CAR_COLOR", carColor).replaceAll("CARLIFE_RESCUE_MESSAGE_ID", String.valueOf(System.currentTimeMillis()) + ((int) (((Math.random() * 9.0d) + 1.0d) * 10000.0d)));
                String latitude = "";
                String longitude = "";
                if (BNLocationManagerProxy.getInstance().isLocationValid()) {
                    LocData currentPoint = BNLocationManagerProxy.getInstance().getCurLocation();
                    if (currentPoint != null) {
                        latitude = String.valueOf(currentPoint.latitude);
                        longitude = String.valueOf(currentPoint.longitude);
                    }
                }
                String provinceName = GeoLocateModel.getInstance().getProvinceDistrict().mName;
                String cityName = GeoLocateModel.getInstance().getCurrentDistrict().mName;
                if (!TextUtils.isEmpty(provinceName)) {
                    fsdSoap = fsdSoap.replaceAll("CARLIFE_RESCUE_PROVINCE", provinceName);
                }
                if (!TextUtils.isEmpty(cityName)) {
                    fsdSoap = fsdSoap.replaceAll("CARLIFE_RESCUE_CITY", cityName);
                }
                fsdSoap = fsdSoap.replaceAll("CARLIFE_RESCUE_LATITUDE", latitude).replaceAll("CARLIFE_RESCUE_LONGITUDE", longitude);
                soap = soap.replaceAll("CARLIFE_USERNAME", "bdcarlife").replaceAll("CARLIFE_PASSWORD", "tsp123").replaceAll("CARLIFE_FSD", m5778a(fsdSoap));
                LogUtil.m4440c(f4748a, fsdSoap);
                LogUtil.m4440c(f4748a, soap);
                byte[] entity = soap.getBytes();
                HttpURLConnection conn = (HttpURLConnection) new URL(CommonParams.gE).openConnection();
                conn.setConnectTimeout(5000);
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "application/soap+xml;charset=UTF-8");
                conn.setRequestProperty("Content-Length", String.valueOf(entity.length));
                conn.getOutputStream().write(entity);
                LogUtil.m4440c(f4748a, conn.getResponseCode() + "");
                if (conn.getResponseCode() == 200) {
                    XmlPullParser parser = Xml.newPullParser();
                    parser.setInput(conn.getInputStream(), "UTF-8");
                    for (int event = parser.getEventType(); event != 1; event = parser.next()) {
                        switch (event) {
                            case 2:
                                LogUtil.m4440c(f4748a, parser.getName());
                                if (!"return".equals(parser.getName())) {
                                    break;
                                }
                                String returnValue = parser.nextText();
                                if (returnValue != null && returnValue.contains("接收信息成功")) {
                                    LogUtil.m4440c(f4748a, "上传成功啦");
                                    break;
                                }
                            default:
                                break;
                        }
                    }
                }
                if (soapInStream != null) {
                    try {
                        soapInStream.close();
                    } catch (IOException e22) {
                        e22.printStackTrace();
                    }
                }
                if (fsdInStream != null) {
                    try {
                        fsdInStream.close();
                    } catch (IOException e222) {
                        e222.printStackTrace();
                    }
                }
            } catch (IOException e2222) {
                e2222.printStackTrace();
                if (soapInStream != null) {
                    try {
                        soapInStream.close();
                    } catch (IOException e22222) {
                        e22222.printStackTrace();
                    }
                }
                if (fsdInStream != null) {
                    try {
                        fsdInStream.close();
                    } catch (IOException e222222) {
                        e222222.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                if (soapInStream != null) {
                    try {
                        soapInStream.close();
                    } catch (IOException e2222222) {
                        e2222222.printStackTrace();
                    }
                }
                if (fsdInStream != null) {
                    try {
                        fsdInStream.close();
                    } catch (IOException e22222222) {
                        e22222222.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (soapInStream != null) {
                    try {
                        soapInStream.close();
                    } catch (IOException e222222222) {
                        e222222222.printStackTrace();
                    }
                }
                if (fsdInStream != null) {
                    try {
                        fsdInStream.close();
                    } catch (IOException e2222222222) {
                        e2222222222.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public String m5788a(InputStream in) {
        try {
            StringBuffer out = new StringBuffer();
            byte[] b = new byte[2048];
            while (true) {
                int n = in.read(b);
                if (n == -1) {
                    return out.toString();
                }
                out.append(new String(b, 0, n));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m5778a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            byte[] encode = str.getBytes("UTF-8");
            return new String(Base64.encode(encode, 0, encode.length, 0), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void driving() {
        LogUtil.d("yftech", "RoadRescueFragment driving");
        m5786c();
    }

    public void stopDriving() {
        LogUtil.d("yftech", "RoadRescueFragment stopDriving");
        m5784b();
    }

    /* renamed from: b */
    private void m5784b() {
        this.f4756i.setAlpha(1.0f);
        this.f4756i.setEnabled(true);
        if (C2186p.m8304a().m8312a(f4755h, false)) {
            this.f4760m.setAlpha(1.0f);
            this.f4760m.setEnabled(true);
            return;
        }
        this.f4760m.setAlpha(0.2f);
        this.f4760m.setEnabled(false);
    }

    /* renamed from: c */
    private void m5786c() {
        this.f4756i.setAlpha(0.2f);
        this.f4756i.setEnabled(false);
        this.f4760m.setAlpha(0.2f);
        this.f4760m.setEnabled(false);
    }

    public void onInitFocusAreas() {
        if (this.f4770w == null) {
            this.f4770w = new C1443g(this.mContentView.findViewById(R.id.ll_title), 2);
            this.f4770w.m5300d(this.mContentView.findViewById(R.id.ib_left));
        }
        if (this.f4771x == null) {
            this.f4771x = new C1443g(this.f4762o, 4);
            this.f4771x.m5300d(this.f4757j);
        }
        C1440d.m5251a().m5256b(this.f4770w, this.f4771x);
        C1440d.m5251a().m5268h(this.f4771x);
    }
}
