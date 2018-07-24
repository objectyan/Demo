package com.baidu.carlife.fragment;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2170a;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.utils.StringUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.commontool.BNAutoDayNightHelper;
import com.baidu.navisdk.comapi.commontool.BNDayNightChangedObserver;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSortModel;
import java.util.ArrayList;
import java.util.List;

public class SettingNaviFragment extends ContentFragment implements OnClickListener {
    /* renamed from: a */
    private ViewGroup f4793a;
    /* renamed from: b */
    private TextView f4794b;
    /* renamed from: c */
    private TextView f4795c;
    /* renamed from: d */
    private TextView f4796d;
    /* renamed from: e */
    private TextView f4797e;
    /* renamed from: f */
    private TextView f4798f;
    /* renamed from: g */
    private TextView f4799g;
    /* renamed from: h */
    private SwitchButton f4800h;
    /* renamed from: i */
    private TextView f4801i;
    /* renamed from: j */
    private View f4802j;
    /* renamed from: k */
    private List<TextView> f4803k;
    /* renamed from: l */
    private ArrayList<RGRouteSortModel> f4804l;
    /* renamed from: m */
    private SwitchButton f4805m;
    /* renamed from: n */
    private View f4806n;
    /* renamed from: o */
    private int f4807o;
    /* renamed from: p */
    private int f4808p = 5;
    /* renamed from: q */
    private int f4809q = 1;
    /* renamed from: r */
    private int f4810r = 0;
    /* renamed from: s */
    private BNDayNightChangedObserver f4811s = new C15794(this);
    /* renamed from: t */
    private C1443g f4812t;

    /* renamed from: com.baidu.carlife.fragment.SettingNaviFragment$1 */
    class C15761 implements OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ SettingNaviFragment f4789a;

        C15761(SettingNaviFragment this$0) {
            this.f4789a = this$0;
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            this.f4789a.m5798a(isChecked);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.SettingNaviFragment$2 */
    class C15772 implements OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ SettingNaviFragment f4790a;

        C15772(SettingNaviFragment this$0) {
            this.f4790a = this$0;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            this.f4790a.m5802b(isChecked);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.SettingNaviFragment$3 */
    class C15783 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ SettingNaviFragment f4791a;

        C15783(SettingNaviFragment this$0) {
            this.f4791a = this$0;
        }

        public void onClick(View v) {
            this.f4791a.f4805m.toggle();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.SettingNaviFragment$4 */
    class C15794 implements BNDayNightChangedObserver {
        /* renamed from: a */
        final /* synthetic */ SettingNaviFragment f4792a;

        C15794(SettingNaviFragment this$0) {
            this.f4792a = this$0;
        }

        public void update(BNSubject o, int type, int event, Object arg) {
            this.f4792a.m5803c();
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.f4793a = (ViewGroup) inflater.inflate(R.layout.frag_navi_setting, null);
        setCommonTitleBar(this.f4793a, getString(R.string.navi_setting));
        this.f4807o = CarlifeScreenUtil.m4331a().m4351h() / (CarlifeScreenUtil.m4331a().m4350g() / 160);
        m5799b();
        m5807g();
        BNAutoDayNightHelper.getInstance().addObserver(this.f4811s);
        return this.f4793a;
    }

    public void onResume() {
        super.onResume();
        m5796a();
        m5805e();
        m5803c();
        m5804d();
        m5806f();
        this.f4805m.setOnCheckedChangeListener(new C15761(this));
        this.f4800h.setOnCheckedChangeListener(new C15772(this));
    }

    /* renamed from: a */
    private void m5796a() {
        if (RGCarPreferSettingController.getInstance().isCarLimitOpen()) {
            String carPlate = BNSettingManager.getPlateFromLocal(getNaviActivity());
            if (StringUtils.isCarPlate(carPlate)) {
                this.f4801i.setText(carPlate);
                this.f4802j.setVisibility(0);
                this.f4800h.setChecked(true);
                RGCarPreferSettingController.getInstance().setCarLimitOpen(true);
                return;
            }
            RGCarPreferSettingController.getInstance().setCarLimitOpen(false);
            this.f4800h.setChecked(false);
            this.f4802j.setVisibility(8);
            return;
        }
        RGCarPreferSettingController.getInstance().setCarLimitOpen(false);
        this.f4800h.setChecked(false);
        this.f4802j.setVisibility(8);
    }

    /* renamed from: b */
    private void m5799b() {
        this.f4794b = (TextView) this.f4793a.findViewById(R.id.tv_daystyle_day);
        this.f4795c = (TextView) this.f4793a.findViewById(R.id.tv_daystyle_night);
        this.f4796d = (TextView) this.f4793a.findViewById(R.id.tv_daystyle_auto);
        this.f4797e = (TextView) this.f4793a.findViewById(R.id.tv_speck_novice);
        this.f4798f = (TextView) this.f4793a.findViewById(R.id.tv_speck_veteran);
        this.f4799g = (TextView) this.f4793a.findViewById(R.id.tv_speck_quite);
        this.f4805m = (SwitchButton) this.f4793a.findViewById(R.id.swbtn_calcroute_pre);
        this.f4806n = this.f4793a.findViewById(R.id.rl_calc_route);
        this.f4800h = (SwitchButton) this.f4793a.findViewById(R.id.switch_plate_control);
        this.f4801i = (TextView) this.f4793a.findViewById(R.id.tv_plate_number);
        this.f4802j = this.f4793a.findViewById(R.id.rl_plate_number);
        this.f4803k = new ArrayList();
        this.f4803k.add((TextView) this.f4793a.findViewById(R.id.tv_preference_01));
        this.f4803k.add((TextView) this.f4793a.findViewById(R.id.tv_preference_02));
        this.f4803k.add((TextView) this.f4793a.findViewById(R.id.tv_preference_03));
        this.f4803k.add((TextView) this.f4793a.findViewById(R.id.tv_preference_04));
        this.f4803k.add((TextView) this.f4793a.findViewById(R.id.tv_preference_05));
        this.f4803k.add((TextView) this.f4793a.findViewById(R.id.tv_preference_06));
        this.f4803k.add((TextView) this.f4793a.findViewById(R.id.tv_preference_07));
        this.f4803k.add((TextView) this.f4793a.findViewById(R.id.tv_preference_08));
    }

    /* renamed from: c */
    private void m5803c() {
        if (BNSettingManager.getNaviDayAndNightMode() == 2) {
            this.f4794b.setSelected(true);
            this.f4795c.setSelected(false);
            this.f4796d.setSelected(false);
        } else if (BNSettingManager.getNaviDayAndNightMode() == 3) {
            this.f4794b.setSelected(false);
            this.f4795c.setSelected(true);
            this.f4796d.setSelected(false);
        } else if (BNSettingManager.getNaviDayAndNightMode() == 1) {
            this.f4794b.setSelected(false);
            this.f4795c.setSelected(false);
            this.f4796d.setSelected(true);
        }
    }

    /* renamed from: d */
    private void m5804d() {
        int voiceMode = BNSettingManager.getVoiceMode();
        if (voiceMode == 0) {
            this.f4797e.setSelected(true);
            this.f4798f.setSelected(false);
            this.f4799g.setSelected(false);
        } else if (voiceMode == 1) {
            this.f4797e.setSelected(false);
            this.f4798f.setSelected(true);
            this.f4799g.setSelected(false);
        } else if (voiceMode == 2) {
            this.f4797e.setSelected(false);
            this.f4798f.setSelected(false);
            this.f4799g.setSelected(true);
        }
    }

    /* renamed from: e */
    private void m5805e() {
        int i;
        RGRouteSortModel model;
        this.f4804l = RGRouteSortController.getInstance().getRouteSortList();
        if (!C2170a.m8217a()) {
            Resources resources = AppContext.m3876a().getResources();
            for (i = 0; i < this.f4804l.size(); i++) {
                model = (RGRouteSortModel) this.f4804l.get(i);
                if ("智能推荐".equals(model.mItemName)) {
                    model.mItemName = resources.getString(R.string.route_smart);
                } else if ("时间优先".equals(model.mItemName)) {
                    model.mItemName = resources.getString(R.string.route_time);
                }
                if ("距离优先".equals(model.mItemName)) {
                    model.mItemName = resources.getString(R.string.route_dis);
                }
                if ("躲避拥堵".equals(model.mItemName)) {
                    model.mItemName = resources.getString(R.string.route_d);
                }
                if ("不走高速".equals(model.mItemName)) {
                    model.mItemName = resources.getString(R.string.route_dg);
                }
                if ("高速优先".equals(model.mItemName)) {
                    model.mItemName = resources.getString(R.string.route_g);
                }
                ((RGRouteSortModel) this.f4804l.get(i)).mItemName = model.mItemName;
            }
        }
        int pre = BNRoutePlaner.getInstance().getCalcPreference();
        if (this.f4807o < 540) {
            if (this.f4804l.size() >= 3) {
                this.f4808p = 3;
                this.f4809q = this.f4804l.size() - 3;
                this.f4810r = 2;
            } else {
                this.f4808p = this.f4804l.size();
                this.f4809q = 0;
                this.f4810r = 0;
            }
        } else if (this.f4807o < 640) {
            if (this.f4804l.size() >= 4) {
                this.f4808p = 4;
                this.f4809q = this.f4804l.size() - 4;
                this.f4810r = 1;
            } else {
                this.f4808p = this.f4804l.size();
                this.f4809q = 0;
                this.f4810r = 0;
            }
        } else if (this.f4804l.size() >= 5) {
            this.f4808p = 5;
            this.f4809q = this.f4804l.size() - 5;
            this.f4810r = 0;
        } else {
            this.f4808p = this.f4804l.size();
            this.f4809q = 0;
            this.f4810r = 0;
        }
        if (!C2170a.m8217a()) {
            if (this.f4804l.size() > 3) {
                this.f4808p = 3;
                this.f4809q = this.f4804l.size() - 3;
            } else {
                this.f4808p = this.f4804l.size();
                this.f4809q = 0;
            }
            this.f4810r = 2;
        }
        i = 0;
        while (i < this.f4804l.size() && i < this.f4808p && i < this.f4803k.size()) {
            model = (RGRouteSortModel) this.f4804l.get(i);
            TextView textView = (TextView) this.f4803k.get(i);
            textView.setText(model.mItemName);
            textView.setTag(Integer.valueOf(i));
            textView.setVisibility(0);
            if ((model.mPreferValue & pre) != 0) {
                textView.setSelected(true);
            } else {
                textView.setSelected(false);
            }
            textView.setOnClickListener(this);
            if (!C2170a.m8217a()) {
                textView.setTextSize(12.0f);
                textView.getLayoutParams().width = AppContext.m3876a().getResources().getDimensionPixelSize(R.dimen.en_route_width);
            }
            i++;
        }
        while (i < this.f4804l.size() && this.f4804l.size() - i <= this.f4809q && this.f4810r + i < this.f4803k.size()) {
            model = (RGRouteSortModel) this.f4804l.get(i);
            textView = (TextView) this.f4803k.get(this.f4810r + i);
            textView.setText(model.mItemName);
            textView.setTag(Integer.valueOf(i));
            textView.setVisibility(0);
            if ((model.mPreferValue & pre) != 0) {
                textView.setSelected(true);
            } else {
                textView.setSelected(false);
            }
            textView.setOnClickListener(this);
            if (!C2170a.m8217a()) {
                textView.setTextSize(12.0f);
                textView.getLayoutParams().width = AppContext.m3876a().getResources().getDimensionPixelSize(R.dimen.en_route_width);
            }
            i++;
        }
    }

    /* renamed from: f */
    private void m5806f() {
        this.f4805m.setChecked(BNSettingManager.getPrefRoutPlanMode() != 2);
    }

    /* renamed from: a */
    private void m5798a(boolean isChecked) {
        if (isChecked) {
            BNSettingManager.setPrefRoutePlanMode(3);
            StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, StatisticConstants.HOME_MY_SETTING_STATUS_ROUTE_ONLINE);
            return;
        }
        BNSettingManager.setPrefRoutePlanMode(2);
        StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, StatisticConstants.HOME_MY_SETTING_STATUS_ROUTE_OFFLINE);
    }

    /* renamed from: g */
    private void m5807g() {
        this.f4794b.setOnClickListener(this);
        this.f4795c.setOnClickListener(this);
        this.f4796d.setOnClickListener(this);
        this.f4797e.setOnClickListener(this);
        this.f4798f.setOnClickListener(this);
        this.f4799g.setOnClickListener(this);
        this.f4806n.setOnClickListener(new C15783(this));
        this.f4802j.setOnClickListener(this);
    }

    /* renamed from: b */
    private void m5802b(boolean isChecked) {
        if (isChecked) {
            String carPlate = BNSettingManager.getPlateFromLocal(getNaviActivity());
            if (StringUtils.isCarPlate(carPlate)) {
                this.f4801i.setText(carPlate);
                this.f4802j.setVisibility(0);
                RGCarPreferSettingController.getInstance().setCarLimitOpen(true);
                StatisticManager.onEvent(StatisticConstants.NAVI_0034, StatisticConstants.NAVI_0034);
                return;
            }
            RGCarPreferSettingController.getInstance().setCarLimitOpen(false);
            m5808h();
            return;
        }
        RGCarPreferSettingController.getInstance().setCarLimitOpen(false);
        this.f4802j.setVisibility(8);
    }

    /* renamed from: h */
    private void m5808h() {
        showFragment(NaviFragmentManager.TYPE_SETTING_CAR_PLATE, null);
    }

    public void onDestroyView() {
        BNAutoDayNightHelper.getInstance().deleteObserver(this.f4811s);
        super.onDestroyView();
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected void onInitView() {
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        m5805e();
        m5804d();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_plate_number:
                m5808h();
                break;
            case R.id.tv_daystyle_day:
                this.f4794b.setSelected(true);
                this.f4795c.setSelected(false);
                this.f4796d.setSelected(false);
                BNSettingManager.setNaviDayAndNightMode(2);
                return;
            case R.id.tv_daystyle_night:
                this.f4794b.setSelected(false);
                this.f4795c.setSelected(true);
                this.f4796d.setSelected(false);
                BNSettingManager.setNaviDayAndNightMode(3);
                return;
            case R.id.tv_daystyle_auto:
                this.f4794b.setSelected(false);
                this.f4795c.setSelected(false);
                this.f4796d.setSelected(true);
                BNSettingManager.setNaviDayAndNightMode(1);
                return;
            case R.id.tv_speck_novice:
                this.f4797e.setSelected(true);
                this.f4798f.setSelected(false);
                this.f4799g.setSelected(false);
                BNSettingManager.setVoiceMode(0);
                BNSettingManager.resetVoiceModeParams(0);
                BaiduNaviSDKManager.getInstance().updateRGEngineSpeekStatus();
                StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, StatisticConstants.HOME_MY_SETTING_STATUS_TTS_NEW);
                return;
            case R.id.tv_speck_veteran:
                this.f4797e.setSelected(false);
                this.f4798f.setSelected(true);
                this.f4799g.setSelected(false);
                BNSettingManager.setVoiceMode(1);
                BNSettingManager.resetVoiceModeParams(1);
                BaiduNaviSDKManager.getInstance().updateRGEngineSpeekStatus();
                StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, StatisticConstants.HOME_MY_SETTING_STATUS_TTS_EXPERT);
                return;
            case R.id.tv_speck_quite:
                this.f4797e.setSelected(false);
                this.f4798f.setSelected(false);
                this.f4799g.setSelected(true);
                BNSettingManager.setVoiceMode(2);
                BaiduNaviSDKManager.getInstance().updateRGEngineSpeekStatus();
                StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, StatisticConstants.HOME_MY_SETTING_STATUS_TTS_MUTE);
                return;
        }
        for (int i = 0; i < this.f4803k.size(); i++) {
            if (v != this.f4803k.get(i) || ((Integer) v.getTag()).intValue() >= this.f4804l.size()) {
                ((TextView) this.f4803k.get(i)).setSelected(false);
            } else {
                int preferValue;
                ((TextView) this.f4803k.get(i)).setSelected(true);
                RGRouteSortModel model = (RGRouteSortModel) this.f4804l.get(((Integer) v.getTag()).intValue());
                if ((RGRouteSortController.getInstance().getPreferValue() & 32) != 0) {
                    preferValue = model.mPreferValue | 32;
                } else {
                    preferValue = model.mPreferValue;
                }
                BNaviModuleManager.setLastPreferValue(preferValue);
                BNSettingManager.setDefaultRouteSort(preferValue);
                RGRouteSortController.getInstance().setPreferValue(preferValue);
                BNRoutePlaner.getInstance().setCalcPrference(preferValue);
            }
        }
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType() && this.f4793a != null) {
            if (this.f4812t == null) {
                this.f4812t = new C1443g(this.f4793a.findViewById(R.id.common_top_title), 2);
                this.f4812t.m5300d(this.f4793a.findViewById(R.id.ib_left));
            }
            C1440d.m5251a().m5256b(this.f4812t);
            C1440d.m5251a().m5268h(this.f4812t);
        }
    }

    public void driving() {
        LogUtil.d("yftech", "NaviSettingFragment driving");
        getNaviFragmentManager().back();
        getNaviFragmentManager().back();
        C1342a.m4926a().m4931d();
    }

    public void stopDriving() {
    }

    public void onStop() {
        super.onStop();
        this.f4805m.setOnCheckedChangeListener(null);
        this.f4800h.setOnCheckedChangeListener(null);
    }
}
