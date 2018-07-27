package com.baidu.carlife.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.tts.BdTTSPlayer;
import com.baidu.baidunavis.tts.OnTTSVoiceDataSwitchListener;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.presentation.view.CarlifeViewContainer;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.logic.p082b.p095e.C1745a;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.p059c.p064d.C1116d;
import com.baidu.carlife.p059c.p067g.C1148b;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.navi.fragment.ContentFragment;

public class VoiceSettingFragment extends ContentFragment {
    /* renamed from: a */
    private C1745a f4838a;
    /* renamed from: b */
    private SwitchButton f4839b;
    /* renamed from: c */
    private TextView f4840c;
    /* renamed from: d */
    private TextView f4841d;
    /* renamed from: e */
    private C1443g f4842e;
    /* renamed from: f */
    private C1443g f4843f;
    /* renamed from: g */
    private OnTTSVoiceDataSwitchListener f4844g = new C15841(this);

    /* renamed from: com.baidu.carlife.fragment.VoiceSettingFragment$1 */
    class C15841 implements OnTTSVoiceDataSwitchListener {
        /* renamed from: a */
        final /* synthetic */ VoiceSettingFragment f4832a;

        C15841(VoiceSettingFragment this$0) {
            this.f4832a = this$0;
        }

        public void onTTSVoiceDataSwitched(final boolean switchSuccessed) {
            C1148b.m3848a().m3849a(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C15841 f4831b;

                public void run() {
                    CarlifeViewContainer.m4699a().m4701b().mo1468c();
                    if (switchSuccessed) {
                        this.f4831b.f4832a.f4838a.m6330a().mo1419b(Boolean.valueOf(BaseTTSPlayer.getInstance().getLastTTSVoiceDataPath().contains(BdTTSPlayer.K_TTS_DATA_FILE)));
                    }
                }
            });
        }
    }

    /* renamed from: com.baidu.carlife.fragment.VoiceSettingFragment$2 */
    class C15852 implements OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ VoiceSettingFragment f4833a;

        C15852(VoiceSettingFragment this$0) {
            this.f4833a = this$0;
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            boolean z = false;
            if (C1912n.m7270a().m7315n()) {
                if (isChecked) {
                    this.f4833a.f4839b.setChecked(false);
                }
                C2201w.m8370a((int) R.string.voice_feature_no_wakeup);
                return;
            }
            boolean isWakeUpOpen = CarlifeUtil.m4358a().m4398o();
            VoiceSettingFragment voiceSettingFragment = this.f4833a;
            if (!isWakeUpOpen) {
                z = true;
            }
            voiceSettingFragment.m5824a(z);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.VoiceSettingFragment$3 */
    class C15863 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ VoiceSettingFragment f4834a;

        C15863(VoiceSettingFragment this$0) {
            this.f4834a = this$0;
        }

        public void onClick(View v) {
            this.f4834a.m5823a(BdTTSPlayer.K_TTS_DATA_FILE);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.VoiceSettingFragment$4 */
    class C15874 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ VoiceSettingFragment f4835a;

        C15874(VoiceSettingFragment this$0) {
            this.f4835a = this$0;
        }

        public void onClick(View v) {
            this.f4835a.m5823a(BdTTSPlayer.K_TTS_DATA_TAIWAN_FILE);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.VoiceSettingFragment$5 */
    class C15885 implements C1116d<Boolean> {
        /* renamed from: a */
        final /* synthetic */ VoiceSettingFragment f4836a;

        C15885(VoiceSettingFragment this$0) {
            this.f4836a = this$0;
        }

        /* renamed from: a */
        public void m5813a(@Nullable Boolean aBoolean) {
            this.f4836a.m5819a(this.f4836a.f4840c, aBoolean.booleanValue());
        }
    }

    /* renamed from: com.baidu.carlife.fragment.VoiceSettingFragment$6 */
    class C15896 implements C1116d<Boolean> {
        /* renamed from: a */
        final /* synthetic */ VoiceSettingFragment f4837a;

        C15896(VoiceSettingFragment this$0) {
            this.f4837a = this$0;
        }

        /* renamed from: a */
        public void m5815a(@Nullable Boolean aBoolean) {
            this.f4837a.m5819a(this.f4837a.f4841d, !aBoolean.booleanValue());
        }
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(R.layout.fragment_voice_setting, null);
        setCommonTitleBar(this.mContentView, getStringUtil(R.string.carlife_person_ctrl_voice_setting));
        this.f4839b = (SwitchButton) this.mContentView.findViewById(R.id.sw_voice_wakeup);
        this.f4840c = (TextView) this.mContentView.findViewById(R.id.btn_standard);
        this.f4841d = (TextView) this.mContentView.findViewById(R.id.btn_taiwan);
        return this.mContentView;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.f4838a = new C1745a();
        this.f4839b.setChecked(((Boolean) this.f4838a.m6332c().m3762b()).booleanValue());
        this.f4839b.setOnCheckedChangeListener(new C15852(this));
        this.f4840c.setOnClickListener(new C15863(this));
        this.f4841d.setOnClickListener(new C15874(this));
        m5819a(this.f4841d, !((Boolean) this.f4838a.m6330a().m3762b()).booleanValue());
        m5819a(this.f4840c, ((Boolean) this.f4838a.m6330a().m3762b()).booleanValue());
        this.f4838a.m6330a().m3760a(new C15885(this));
        this.f4838a.m6330a().m3760a(new C15896(this));
    }

    /* renamed from: a */
    private void m5823a(String ttsFilePath) {
        CarlifeViewContainer.m4699a().m4701b().mo1467b("切换中...");
        BaseTTSPlayer.getInstance().setCustomParams(false);
        BaseTTSPlayer.getInstance().loadCustomResource("");
        BaseTTSPlayer.getInstance().setCurrentSelectPath(ttsFilePath);
        BaseTTSPlayer.getInstance().switchTTSVoiceData(null, this.f4844g);
    }

    /* renamed from: a */
    private void m5819a(TextView button, boolean isSelected) {
        button.setSelected(isSelected);
        button.setTextColor(getResources().getColor(isSelected ? R.color.white : R.color.text_def_white_title));
    }

    /* renamed from: a */
    private void m5824a(boolean isWakeUp) {
        if (isWakeUp != CarlifeUtil.m4358a().m4398o()) {
            if (isWakeUp) {
                m5818a();
            } else {
                m5826b();
            }
        }
    }

    /* renamed from: a */
    private void m5818a() {
        if (C1912n.m7270a().m7315n()) {
            C2201w.m8370a((int) R.string.voice_feature_no_wakeup);
            return;
        }
        C1912n.m7270a().m7299a(true);
        CarlifeUtil.m4358a().m4390a(true);
        C2201w.m8370a((int) R.string.voice_open);
        C1912n.m7270a().m7308g();
    }

    /* renamed from: b */
    private void m5826b() {
        C1912n.m7270a().m7299a(false);
        CarlifeUtil.m4358a().m4390a(false);
        C2201w.m8371a((int) R.string.voice_close, 0);
        C1912n.m7270a().m7309h();
    }

    public void onDestroyView() {
        this.f4838a.mo1628b();
        super.onDestroyView();
    }

    public void onInitFocusAreas() {
        super.onInitFocusAreas();
        if (this.f4842e == null) {
            this.f4842e = new C1443g(this.mContentView.findViewById(R.id.common_top_title), 2);
            this.f4842e.m5300d(this.mContentView.findViewById(R.id.ib_left));
        }
        if (this.f4843f == null) {
            this.f4843f = new C1443g(this.mContentView, 4);
            this.f4843f.m5300d(this.f4839b).m5300d(this.f4840c).m5300d(this.f4841d);
        }
        C1440d.m5251a().m5256b(this.f4842e, this.f4843f);
        C1440d.m5251a().m5268h(this.f4842e);
    }

    protected void onInitView() {
    }

    public void driving() {
        LogUtil.d("yftech", "VoiceSettingFragment driving");
        if (C1343b.m4932a().m4935b()) {
            back();
        }
    }
}
