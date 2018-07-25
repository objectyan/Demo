package com.baidu.carlife.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.baidu.carlife.R;
import com.baidu.carlife.adpter.SettingListAdapter;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.CommonParams.EnumVehicleChannel;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.screen.OnBtnClickListener;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.elhyf.C1371b;
import com.baidu.carlife.logic.C1765g;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.util.C2177h;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.track.common.TrackConfigUtil;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.File;

public class SettingFragment extends ContentFragment implements OnItemClickListener {
    /* renamed from: a */
    public static String f4782a = SettingFragment.class.getSimpleName();
    /* renamed from: b */
    protected SettingListAdapter f4783b;
    /* renamed from: c */
    private ListView f4784c;
    /* renamed from: d */
    private C1575a f4785d;
    /* renamed from: e */
    private C1953c f4786e;
    /* renamed from: f */
    private C1443g f4787f;
    /* renamed from: g */
    private C1438c f4788g;

    /* renamed from: com.baidu.carlife.fragment.SettingFragment$1 */
    class C15711 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ SettingFragment f4777a;

        C15711(SettingFragment this$0) {
            this.f4777a = this$0;
        }

        public void onClick() {
            this.f4777a.m5792d();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.SettingFragment$2 */
    class C15722 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ SettingFragment f4778a;

        C15722(SettingFragment this$0) {
            this.f4778a = this$0;
        }

        public void onClick() {
            this.f4778a.m5792d();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.SettingFragment$3 */
    class C15733 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ SettingFragment f4779a;

        C15733(SettingFragment this$0) {
            this.f4779a = this$0;
        }

        public void onClick() {
            this.f4779a.m5792d();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.SettingFragment$4 */
    class C15744 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ SettingFragment f4780a;

        C15744(SettingFragment this$0) {
            this.f4780a = this$0;
        }

        public void run() {
            if (!TextUtils.isEmpty(SysOSAPIv2.getInstance().getSdcardPath())) {
                String naviCacheDir = SysOSAPIv2.getInstance().getSdcardPath() + File.separator + CommonParams.hM + File.separator + "tmp";
                if (!TextUtils.isEmpty(naviCacheDir)) {
                    File file = new File(naviCacheDir);
                    if (file.exists()) {
                        C2177h.m8270a(file);
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.SettingFragment$a */
    private class C1575a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ SettingFragment f4781a;

        public C1575a(SettingFragment settingFragment, Looper looper) {
            this.f4781a = settingFragment;
            super(looper);
        }

        public void careAbout() {
            addMsg(CommonParams.bU);
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case CommonParams.bU /*16875523*/:
                    int listId;
                    if (msg.obj == null) {
                        listId = R.array.carlife_setting_name;
                    } else if (this.f4781a.m5794a()) {
                        listId = R.array.carlife_setting_name_elh;
                    } else {
                        listId = R.array.carlife_setting_name_usb;
                    }
                    if (this.f4781a.f4783b != null) {
                        this.f4781a.f4783b.m3260a(listId);
                        this.f4781a.f4783b.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        int arrayId;
        this.mContentView = inflater.inflate(R.layout.frag_setting, null);
        setCommonTitleBar(this.mContentView, getString(R.string.module_setting));
        if (CommonParams.jv) {
            arrayId = R.array.carlife_setting_name;
        } else if (m5794a()) {
            arrayId = R.array.carlife_setting_name_elh;
        } else {
            arrayId = R.array.carlife_setting_name_usb;
        }
        this.f4783b = new SettingListAdapter(getContext(), arrayId);
        this.f4784c = (ListView) this.mContentView.findViewById(R.id.setting_list);
        this.f4784c.setOverScrollMode(2);
        this.f4784c.setAdapter(this.f4783b);
        this.f4784c.setOnItemClickListener(this);
        this.f4785d = new C1575a(this, Looper.getMainLooper());
        MsgHandlerCenter.m4460a(this.f4785d);
        return this.mContentView;
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
        this.f4784c.setSelector(C2188r.m8331b(R.drawable.com_bg_item_selector));
        this.f4784c.setDivider(C2188r.m8331b(R.color.cl_line_a1_item));
        this.f4784c.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.common_item_line));
        this.f4783b.notifyDataSetChanged();
    }

    public void onResume() {
        super.onResume();
        LogUtil.m4434b(f4782a);
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {
        int itemId = (int) adapter.getItemIdAtPosition(pos);
        LogUtil.d(f4782a, "onItemClick:itemId = " + itemId);
        SwitchButton switchVoice;
        SwitchButton switchColorMode;
        if (CommonParams.jv) {
            switch (itemId) {
                case 0:
                    if (m5790b()) {
                        switchVoice = (SwitchButton) view.findViewById(R.id.sw_voice_wakeup);
                        switchVoice.setVisibility(0);
                        switchVoice.setChecked(!CarlifeUtil.m4358a().m4398o());
                        return;
                    }
                    return;
                case 1:
                    switchColorMode = (SwitchButton) view.findViewById(R.id.sw_voice_wakeup);
                    switchColorMode.setVisibility(0);
                    switchColorMode.setChecked(!CarlifeCoreSDK.m5979a().m6043j());
                    return;
                case 2:
                    if (!C1765g.m6424a().m6442c()) {
                        showFragment(NaviFragmentManager.TYPE_SETTING_NAVI, null);
                        return;
                    } else if (!showConnectForbidDialog()) {
                        showFragment(NaviFragmentManager.TYPE_SETTING_NAVI, null);
                        return;
                    } else {
                        return;
                    }
                case 3:
                    if (!C1765g.m6424a().m6442c()) {
                        showFragment(NaviFragmentManager.TYPE_SETTING_TTS, null);
                        return;
                    } else if (!showConnectForbidDialog()) {
                        showFragment(NaviFragmentManager.TYPE_SETTING_TTS, null);
                        return;
                    } else {
                        return;
                    }
                case 4:
                    ((SwitchButton) view.findViewById(R.id.sw_voice_wakeup)).setChecked(!TrackConfigUtil.getInstance().getRouteRecordFlag());
                    return;
                case 5:
                    try {
                        mActivity.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                case 6:
                    if (this.f4786e == null) {
                        this.f4786e = new C1953c(mActivity).m7442b((int) R.string.alert_delete_navi_cache).m7435a((int) R.string.alert_delete_navi_cache_content).m7457g(17).m7447c((int) R.string.alert_confirm).m7458q().m7450d((int) R.string.alert_cancel);
                        this.f4786e.m7438a(new C15711(this));
                    }
                    showDialog(this.f4786e);
                    StatisticManager.onEvent(StatisticConstants.SETTINGS_CLEAN_BUFFER, StatisticConstants.SETTINGS_CLEAN_BUFFER);
                    return;
                case 7:
                    showFragment(539, null);
                    StatisticManager.onEvent(StatisticConstants.SETTINGS_ABOUT, StatisticConstants.SETTINGS_ABOUT);
                    return;
                default:
                    return;
            }
        } else if (m5794a()) {
            switch (itemId) {
                case 0:
                    switchVoice = (SwitchButton) view.findViewById(R.id.sw_voice_wakeup);
                    if (m5790b()) {
                        switchVoice.setVisibility(0);
                        switchVoice.setChecked(!CarlifeUtil.m4358a().m4398o());
                        return;
                    }
                    switchVoice.setChecked(false);
                    return;
                case 1:
                    switchColorMode = (SwitchButton) view.findViewById(R.id.sw_voice_wakeup);
                    switchColorMode.setVisibility(0);
                    switchColorMode.setChecked(!CarlifeCoreSDK.m5979a().m6043j());
                    return;
                case 2:
                    if (!C1765g.m6424a().m6442c()) {
                        showFragment(NaviFragmentManager.TYPE_SETTING_NAVI, null);
                        return;
                    } else if (!showConnectForbidDialog()) {
                        showFragment(NaviFragmentManager.TYPE_SETTING_NAVI, null);
                        return;
                    } else {
                        return;
                    }
                case 3:
                    if (!C1765g.m6424a().m6442c()) {
                        showFragment(NaviFragmentManager.TYPE_SETTING_TTS, null);
                        return;
                    } else if (!showConnectForbidDialog()) {
                        showFragment(NaviFragmentManager.TYPE_SETTING_TTS, null);
                        return;
                    } else {
                        return;
                    }
                case 4:
                    ((SwitchButton) view.findViewById(R.id.sw_voice_wakeup)).setChecked(!TrackConfigUtil.getInstance().getRouteRecordFlag());
                    return;
                case 5:
                    C1371b.m4996a().m5014d();
                    return;
                case 6:
                    if (this.f4786e == null) {
                        this.f4786e = new C1953c(mActivity).m7442b((int) R.string.alert_delete_navi_cache).m7435a((int) R.string.alert_delete_navi_cache_content).m7457g(17).m7447c((int) R.string.alert_confirm).m7458q().m7450d((int) R.string.alert_cancel);
                        this.f4786e.m7438a(new C15722(this));
                    }
                    showDialog(this.f4786e);
                    StatisticManager.onEvent(StatisticConstants.SETTINGS_CLEAN_BUFFER, StatisticConstants.SETTINGS_CLEAN_BUFFER);
                    return;
                case 7:
                    showFragment(539, null);
                    StatisticManager.onEvent(StatisticConstants.SETTINGS_ABOUT, StatisticConstants.SETTINGS_ABOUT);
                    return;
                default:
                    return;
            }
        } else {
            switch (itemId) {
                case 0:
                    switchVoice = (SwitchButton) view.findViewById(R.id.sw_voice_wakeup);
                    if (m5790b()) {
                        switchVoice.setVisibility(0);
                        switchVoice.setChecked(!CarlifeUtil.m4358a().m4398o());
                        return;
                    }
                    switchVoice.setChecked(false);
                    return;
                case 1:
                    switchColorMode = (SwitchButton) view.findViewById(R.id.sw_voice_wakeup);
                    switchColorMode.setVisibility(0);
                    switchColorMode.setChecked(!CarlifeCoreSDK.m5979a().m6043j());
                    return;
                case 2:
                    if (!C1765g.m6424a().m6442c()) {
                        showFragment(NaviFragmentManager.TYPE_SETTING_NAVI, null);
                        return;
                    } else if (!showConnectForbidDialog()) {
                        showFragment(NaviFragmentManager.TYPE_SETTING_NAVI, null);
                        return;
                    } else {
                        return;
                    }
                case 3:
                    if (!C1765g.m6424a().m6442c()) {
                        showFragment(NaviFragmentManager.TYPE_SETTING_TTS, null);
                        return;
                    } else if (!showConnectForbidDialog()) {
                        showFragment(NaviFragmentManager.TYPE_SETTING_TTS, null);
                        return;
                    } else {
                        return;
                    }
                case 4:
                    ((SwitchButton) view.findViewById(R.id.sw_voice_wakeup)).setChecked(!TrackConfigUtil.getInstance().getRouteRecordFlag());
                    return;
                case 5:
                    if (this.f4786e == null) {
                        this.f4786e = new C1953c(mActivity).m7442b((int) R.string.alert_delete_navi_cache).m7435a((int) R.string.alert_delete_navi_cache_content).m7457g(17).m7447c((int) R.string.alert_confirm).m7458q().m7450d((int) R.string.alert_cancel);
                        this.f4786e.m7438a(new C15733(this));
                    }
                    showDialog(this.f4786e);
                    StatisticManager.onEvent(StatisticConstants.SETTINGS_CLEAN_BUFFER, StatisticConstants.SETTINGS_CLEAN_BUFFER);
                    return;
                case 6:
                    showFragment(539, null);
                    StatisticManager.onEvent(StatisticConstants.SETTINGS_ABOUT, StatisticConstants.SETTINGS_ABOUT);
                    return;
                default:
                    return;
            }
        }
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType()) {
            if (this.f4787f == null) {
                this.f4787f = new C1443g(this.mContentView.findViewById(R.id.title_bar), 2);
                this.f4787f.m5300d(this.mContentView.findViewById(R.id.ib_left));
            }
            if (this.f4788g == null) {
                this.f4788g = new C1438c(this.f4784c, 6);
            }
            C1440d.m5251a().m5256b(this.f4787f, this.f4788g);
            C1440d.m5251a().m5268h(this.f4788g);
            this.f4788g.m5250e();
        }
    }

    /* renamed from: b */
    private boolean m5790b() {
        if (m5791c() || !C1912n.m7270a().m7315n()) {
            return true;
        }
        C2201w.m8371a((int) R.string.voice_feature_no_wakeup, 0);
        return false;
    }

    /* renamed from: c */
    private boolean m5791c() {
        return CarlifeUtil.m4358a().m4398o();
    }

    /* renamed from: d */
    private void m5792d() {
        new Thread(new C15744(this)).start();
    }

    public void driving() {
        LogUtil.d("yftech", "SettingFragment driving");
        m5793e();
        back();
        C1342a.m4926a().m4931d();
    }

    public void onDestroy() {
        this.f4785d.removeCallbacksAndMessages(null);
        MsgHandlerCenter.m4464b(this.f4785d);
        this.f4783b = null;
        this.f4786e = null;
        this.f4784c = null;
        super.onDestroy();
    }

    public void stopDriving() {
        LogUtil.d("yftech", "SettingFragment stopDriving");
    }

    /* renamed from: e */
    private void m5793e() {
        if (this.f4786e != null) {
            this.f4786e.mo1526d();
        }
    }

    /* renamed from: a */
    public boolean m5794a() {
        if (CommonParams.sVehicleChannel == EnumVehicleChannel.VEHICLE_CHANNEL_YUANFENG_ELH_ONLINE || CommonParams.sVehicleChannel == EnumVehicleChannel.VEHICLE_CHANNEL_YUANFENG_ELH_PCBA) {
            return true;
        }
        return false;
    }
}
