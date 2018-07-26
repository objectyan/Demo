package com.baidu.carlife.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.view.StatusButton;
import com.baidu.carlife.view.StatusButton.C1550a;
import com.baidu.carlife.view.StatusButton.C2237b;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;

public class NaviSettingFragment extends ContentFragment {
    /* renamed from: a */
    private ViewGroup f4641a;
    /* renamed from: b */
    private StatusButton f4642b;
    /* renamed from: c */
    private StatusButton f4643c;
    /* renamed from: d */
    private StatusButton f4644d;
    /* renamed from: e */
    private StatusButton f4645e;
    /* renamed from: f */
    private CheckBox f4646f;
    /* renamed from: g */
    private CheckBox f4647g;
    /* renamed from: h */
    private CheckBox f4648h;
    /* renamed from: i */
    private CheckBox f4649i;
    /* renamed from: j */
    private CheckBox f4650j;
    /* renamed from: k */
    private TextView f4651k;
    /* renamed from: l */
    private ImageButton f4652l;
    /* renamed from: m */
    private TextView f4653m;
    /* renamed from: n */
    private Boolean f4654n = Boolean.valueOf(false);
    /* renamed from: o */
    private OnCheckedChangeListener f4655o = new C15491(this);
    /* renamed from: p */
    private C1550a f4656p = new C15512(this);
    /* renamed from: q */
    private C1443g f4657q;
    /* renamed from: r */
    private C1443g f4658r;

    /* renamed from: com.baidu.carlife.fragment.NaviSettingFragment$1 */
    class C15491 implements OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ NaviSettingFragment f4639a;

        C15491(NaviSettingFragment this$0) {
            this.f4639a = this$0;
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (BNSettingManager.getVoiceMode() != 2) {
                if (buttonView == this.f4639a.f4646f) {
                    BNSettingManager.setElecCameraSpeakEnable(isChecked);
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, "播报内容-电子眼_" + isChecked);
                } else if (buttonView == this.f4639a.f4647g) {
                    BNSettingManager.setSpeedCameraSpeakEnable(isChecked);
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, "播报内容-限速提醒_" + isChecked);
                } else if (buttonView == this.f4639a.f4648h) {
                    BNSettingManager.setSaftyDriveSpeakEnable(isChecked);
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, "播报内容-安全驾驶_" + isChecked);
                } else if (buttonView == this.f4639a.f4649i) {
                    BNSettingManager.setRoadConditionpeakEnable(isChecked);
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, "播报内容-前方路况_" + isChecked);
                } else if (buttonView == this.f4639a.f4650j) {
                    BNSettingManager.setStraightDirectSpeakEnable(isChecked);
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, "播报内容-直行顺行提醒_" + isChecked);
                }
                BaiduNaviSDKManager.getInstance().updateRGEngineSpeekStatus();
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.NaviSettingFragment$2 */
    class C15512 implements C1550a {
        /* renamed from: a */
        final /* synthetic */ NaviSettingFragment f4640a;

        C15512(NaviSettingFragment this$0) {
            this.f4640a = this$0;
        }

        /* renamed from: a */
        public void mo1592a(StatusButton sButton, C2237b child) {
            if (sButton == this.f4640a.f4645e) {
                if (child == C2237b.LEFT) {
                    BNSettingManager.setNaviDayAndNightMode(2);
                } else if (child == C2237b.MID) {
                    BNSettingManager.setNaviDayAndNightMode(3);
                } else {
                    BNSettingManager.setNaviDayAndNightMode(1);
                }
            } else if (sButton == this.f4640a.f4642b) {
                if (child == C2237b.LEFT) {
                    BNSettingManager.setVoiceMode(0);
                    BNSettingManager.resetVoiceModeParams(0);
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, StatisticConstants.HOME_MY_SETTING_STATUS_TTS_NEW);
                } else if (child == C2237b.MID) {
                    BNSettingManager.setVoiceMode(1);
                    BNSettingManager.resetVoiceModeParams(1);
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, StatisticConstants.HOME_MY_SETTING_STATUS_TTS_EXPERT);
                } else {
                    BNSettingManager.setVoiceMode(2);
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, StatisticConstants.HOME_MY_SETTING_STATUS_TTS_MUTE);
                }
                this.f4640a.m5690a(BNSettingManager.getVoiceMode());
            } else if (sButton == this.f4640a.f4643c) {
                if (child == C2237b.LEFT) {
                    BNSettingManager.setPrefRoutePlanMode(2);
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, StatisticConstants.HOME_MY_SETTING_STATUS_ROUTE_OFFLINE);
                } else if (child == C2237b.RIGHT) {
                    BNSettingManager.setPrefRoutePlanMode(3);
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, StatisticConstants.HOME_MY_SETTING_STATUS_ROUTE_ONLINE);
                }
            } else if (sButton == this.f4640a.f4644d) {
                if (child == C2237b.LEFT) {
                    BNSettingManager.setPrefSearchMode(2);
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, StatisticConstants.HOME_MY_SETTING_STATUS_SEARCH_OFFLINE);
                } else if (child == C2237b.RIGHT) {
                    BNSettingManager.setPrefSearchMode(3);
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_SETTING_STATUS, StatisticConstants.HOME_MY_SETTING_STATUS_SEARCH_ONLINE);
                }
            }
            BaiduNaviSDKManager.getInstance().updateRGEngineSpeekStatus();
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.f4641a = (ViewGroup) inflater.inflate(C0965R.layout.navi_setting, null);
        setCommonTitleBar(this.f4641a, getString(C0965R.string.navi_setting));
        m5689a();
        return this.f4641a;
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
    }

    /* renamed from: a */
    private void m5689a() {
        this.f4642b = (StatusButton) this.f4641a.findViewById(C0965R.id.bt_speak_mode);
        this.f4643c = (StatusButton) this.f4641a.findViewById(C0965R.id.bt_routplan_mode);
        this.f4651k = (TextView) this.f4641a.findViewById(C0965R.id.tv_search_mode);
        this.f4644d = (StatusButton) this.f4641a.findViewById(C0965R.id.bt_search_mode);
        this.f4645e = (StatusButton) this.f4641a.findViewById(C0965R.id.bt_day_night_mode);
        LinearLayout bobao = (LinearLayout) this.f4641a.findViewById(C0965R.id.ll_bobao_setting);
        this.f4647g = (CheckBox) bobao.findViewById(C0965R.id.cb_over_speed);
        this.f4650j = (CheckBox) bobao.findViewById(C0965R.id.cb_straight);
        LinearLayout condition = (LinearLayout) this.f4641a.findViewById(C0965R.id.ll_road_condition);
        this.f4649i = (CheckBox) condition.findViewById(C0965R.id.cb_road_condition);
        this.f4646f = (CheckBox) condition.findViewById(C0965R.id.cb_elec_eye);
        this.f4648h = (CheckBox) ((LinearLayout) this.f4641a.findViewById(C0965R.id.ll_safe_setting)).findViewById(C0965R.id.cb_safe_drive);
        this.f4646f.setId(2147483632);
        this.f4647g.setId(2147483633);
        this.f4648h.setId(2147483634);
        this.f4649i.setId(2147483635);
        this.f4650j.setId(2147483636);
    }

    /* renamed from: b */
    private void m5693b() {
        int dayNightMode = BNSettingManager.getNaviDayAndNightMode();
        if (dayNightMode == 2) {
            this.f4645e.m8489a();
        } else if (dayNightMode == 3) {
            this.f4645e.m8499b();
        } else if (dayNightMode == 1) {
            this.f4645e.m8503c();
        }
        int voiceMode = BNSettingManager.getVoiceMode();
        if (voiceMode == 0) {
            this.f4642b.m8489a();
        } else if (voiceMode == 1) {
            this.f4642b.m8499b();
        } else if (voiceMode == 2) {
            this.f4642b.m8503c();
        }
        m5690a(voiceMode);
        if (BNSettingManager.getPrefRoutPlanMode() == 2) {
            this.f4643c.m8489a();
        } else {
            this.f4643c.m8503c();
        }
        if (BNSettingManager.getPrefSearchMode() == 2) {
            this.f4644d.m8489a();
        } else {
            this.f4644d.m8503c();
        }
    }

    protected void onInitView() {
    }

    /* renamed from: c */
    private void m5695c() {
        this.f4645e.m8492a((int) C0965R.string.day_mode, (int) C0965R.string.nighg_mode, (int) C0965R.string.auto_mode);
        this.f4645e.m8494a(this.f4656p);
        this.f4642b.m8492a((int) C0965R.string.speak_fresher, (int) C0965R.string.speak_professor, (int) C0965R.string.speak_silent);
        this.f4642b.m8494a(this.f4656p);
        this.f4643c.m8491a((int) C0965R.string.pref_offline, (int) C0965R.string.pref_online);
        this.f4643c.m8494a(this.f4656p);
        this.f4644d.m8491a((int) C0965R.string.pref_offline, (int) C0965R.string.pref_online);
        this.f4644d.m8494a(this.f4656p);
        this.f4646f.setOnCheckedChangeListener(this.f4655o);
        this.f4649i.setOnCheckedChangeListener(this.f4655o);
        this.f4647g.setOnCheckedChangeListener(this.f4655o);
        this.f4650j.setOnCheckedChangeListener(this.f4655o);
        this.f4648h.setOnCheckedChangeListener(this.f4655o);
    }

    /* renamed from: a */
    private void m5690a(int voiceMode) {
        if (voiceMode == 0 || voiceMode == 1) {
            boolean otherCameraSpeak = BNSettingManager.isElecCameraSpeakEnable();
            this.f4646f.setEnabled(true);
            this.f4646f.setChecked(otherCameraSpeak);
            boolean overSpeedSpeak = BNSettingManager.isSpeedCameraSpeakEnable();
            this.f4647g.setEnabled(true);
            this.f4647g.setChecked(overSpeedSpeak);
            boolean safeDriveSpeak = BNSettingManager.isSaftyDriveSpeakEnable();
            this.f4648h.setEnabled(true);
            this.f4648h.setChecked(safeDriveSpeak);
            boolean roadCondSpeak = BNSettingManager.isRoadConditionSpeakEnable();
            this.f4649i.setEnabled(true);
            this.f4649i.setChecked(roadCondSpeak);
            boolean straightSpeak = BNSettingManager.isStraightDirectSpeakEnable();
            this.f4650j.setEnabled(true);
            this.f4650j.setChecked(straightSpeak);
        } else if (2 == voiceMode) {
            this.f4646f.setChecked(false);
            this.f4646f.setEnabled(false);
            this.f4647g.setChecked(false);
            this.f4647g.setEnabled(false);
            this.f4648h.setChecked(false);
            this.f4648h.setEnabled(false);
            this.f4649i.setChecked(false);
            this.f4649i.setEnabled(false);
            this.f4650j.setChecked(false);
            this.f4650j.setEnabled(false);
        }
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
        if (this.f4642b != null && this.f4645e != null && this.f4643c != null && this.f4644d != null) {
            this.f4642b.m8507d();
            this.f4645e.m8507d();
            this.f4644d.m8507d();
            this.f4643c.m8507d();
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        m5693b();
        m5695c();
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            int voiceMode = BNSettingManager.getVoiceMode();
            if (voiceMode == 0) {
                this.f4642b.m8489a();
            } else if (voiceMode == 1) {
                this.f4642b.m8499b();
            } else if (voiceMode == 2) {
                this.f4642b.m8503c();
            }
            m5690a(voiceMode);
        }
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType()) {
            if (this.f4657q == null) {
                this.f4657q = new C1443g(this.mContentView.findViewById(C0965R.id.common_top_title), 2);
                this.f4657q.m5300d(this.mContentView.findViewById(C0965R.id.ib_left));
            }
            C1440d.m5251a().m5256b(this.f4657q);
            C1440d.m5251a().m5268h(this.f4657q);
        }
    }

    public void driving() {
        C1260i.m4435b("yftech", "NaviSettingFragment driving");
        getNaviFragmentManager().back();
        getNaviFragmentManager().back();
        C1342a.m4926a().m4931d();
    }

    public void stopDriving() {
    }
}
