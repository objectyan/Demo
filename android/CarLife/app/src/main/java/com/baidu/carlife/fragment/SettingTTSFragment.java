package com.baidu.carlife.fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.tts.BdTTSPlayer;
import com.baidu.baidunavis.tts.OnTTSVoiceDataSwitchListener;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2201w;
import com.baidu.navi.fragment.ContentFragment;

public class SettingTTSFragment extends ContentFragment implements OnClickListener {
    /* renamed from: a */
    private ViewGroup f4820a;
    /* renamed from: b */
    private TextView f4821b;
    /* renamed from: c */
    private TextView f4822c;
    /* renamed from: d */
    private OnTTSVoiceDataSwitchListener f4823d = new C15801(this);
    /* renamed from: e */
    private Handler f4824e = new C15812(this);
    /* renamed from: f */
    private C1443g f4825f;

    /* renamed from: com.baidu.carlife.fragment.SettingTTSFragment$1 */
    class C15801 implements OnTTSVoiceDataSwitchListener {
        /* renamed from: a */
        final /* synthetic */ SettingTTSFragment f4818a;

        C15801(SettingTTSFragment this$0) {
            this.f4818a = this$0;
        }

        public void onTTSVoiceDataSwitched(boolean switchSuccessed) {
            if (switchSuccessed) {
                this.f4818a.f4824e.sendEmptyMessage(110);
            } else {
                this.f4818a.f4824e.sendEmptyMessage(111);
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.SettingTTSFragment$2 */
    class C15812 extends Handler {
        /* renamed from: a */
        final /* synthetic */ SettingTTSFragment f4819a;

        C15812(SettingTTSFragment this$0) {
            this.f4819a = this$0;
        }

        public void handleMessage(Message msg) {
            if (msg.what == 110) {
                C1309g.m4699a().m4701b().mo1468c();
                C2201w.m8372a("切换成功");
                this.f4819a.m5810a();
            } else if (msg.what == 111) {
                C1309g.m4699a().m4701b().mo1468c();
                C2201w.m8372a("切换失败");
                this.f4819a.m5810a();
            }
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.f4820a = (ViewGroup) inflater.inflate(C0965R.layout.frag_tts_setting, null);
        setCommonTitleBar(this.f4820a, getString(C0965R.string.tts_setting));
        this.f4821b = (TextView) this.f4820a.findViewById(C0965R.id.tv_preference_01);
        this.f4822c = (TextView) this.f4820a.findViewById(C0965R.id.tv_preference_02);
        this.f4821b.setOnClickListener(this);
        this.f4822c.setOnClickListener(this);
        m5810a();
        return this.f4820a;
    }

    /* renamed from: a */
    private void m5810a() {
        if (BaseTTSPlayer.getInstance().getLastTTSVoiceDataPath().contains(BdTTSPlayer.K_TTS_DATA_TAIWAN_FILE)) {
            this.f4821b.setSelected(false);
            this.f4822c.setSelected(true);
            return;
        }
        this.f4822c.setSelected(false);
        this.f4821b.setSelected(true);
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected void onInitView() {
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        m5810a();
    }

    public void onClick(View v) {
        if (v.getId() == C0965R.id.tv_preference_01) {
            C1309g.m4699a().m4701b().mo1467b("切换中...");
            BaseTTSPlayer.getInstance().setCustomParams(false);
            BaseTTSPlayer.getInstance().loadCustomResource("");
            BaseTTSPlayer.getInstance().setCurrentSelectPath(BdTTSPlayer.K_TTS_DATA_FILE);
            BaseTTSPlayer.getInstance().switchTTSVoiceData(null, this.f4823d);
        } else if (v.getId() == C0965R.id.tv_preference_02) {
            C1309g.m4699a().m4701b().mo1467b("切换中...");
            BaseTTSPlayer.getInstance().setCustomParams(false);
            BaseTTSPlayer.getInstance().loadCustomResource("");
            BaseTTSPlayer.getInstance().setCurrentSelectPath(BdTTSPlayer.K_TTS_DATA_TAIWAN_FILE);
            BaseTTSPlayer.getInstance().switchTTSVoiceData(null, this.f4823d);
        }
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType() && this.f4820a != null) {
            if (this.f4825f == null) {
                this.f4825f = new C1443g(this.f4820a.findViewById(C0965R.id.common_top_title), 2);
                this.f4825f.m5300d(this.f4820a.findViewById(C0965R.id.ib_left));
            }
            C1440d.m5251a().m5256b(this.f4825f);
            C1440d.m5251a().m5268h(this.f4825f);
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
