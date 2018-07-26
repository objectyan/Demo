package com.baidu.carlife.p101o;

import android.content.Context;
import android.os.Message;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1253f.C1252a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.connect.C1212c;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.logic.codriver.adapter.C1754b;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.music.C1834p;
import com.baidu.carlife.model.C1942q;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.protobuf.CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest;
import com.baidu.carlife.protobuf.CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.Builder;
import com.baidu.che.codriver.sdk.p081a.C2575a.C1979b;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.C2736p;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.voice.MapVoiceCommandController;
import java.util.HashMap;
import java.util.Map;

/* compiled from: VoiceControlManager */
/* renamed from: com.baidu.carlife.o.b */
public class C1983b {
    /* renamed from: a */
    private static final String f6376a = C1983b.class.getSimpleName();
    /* renamed from: b */
    private static C1983b f6377b = null;
    /* renamed from: c */
    private static Context f6378c = null;
    /* renamed from: d */
    private Map<Integer, String> f6379d = new HashMap();
    /* renamed from: e */
    private C1979b f6380e = new C19801(this);
    /* renamed from: f */
    private C1981b f6381f = new C19822(this);

    /* compiled from: VoiceControlManager */
    /* renamed from: com.baidu.carlife.o.b$1 */
    class C19801 extends C1979b {
        /* renamed from: a */
        final /* synthetic */ C1983b f6361a;

        C19801(C1983b this$0) {
            this.f6361a = this$0;
        }

        public void onCommand(String type, String cmd) {
            C1260i.m4435b(C1983b.f6376a, "## mCommandListener onCommand():" + type + " # " + cmd);
            if (type.equals("open_home_page")) {
                this.f6361a.m7581b(4001);
            } else if (type.equals("open_phone_page")) {
                this.f6361a.m7581b(4002);
            } else if (type.equals("open_navi_page")) {
                this.f6361a.m7581b(4003);
            } else if (type.equals("open_music_page")) {
                this.f6361a.m7581b(4004);
            } else if (type.equals(C1981b.f6374n)) {
                C1983b.m7577a(17);
            } else if (type.equals("max_brightness")) {
                C1983b.m7577a(13);
            } else if (type.equals("min_brightness")) {
                C1983b.m7577a(14);
            } else if (type.equals("open_dvr")) {
                C1983b.m7577a(0);
            } else if (type.equals("open_camera")) {
                C1983b.m7577a(22);
            } else if (type.equals("scene_music")) {
                if ("播放音乐,播放歌曲,继续播放".contains(cmd)) {
                    if (C1818h.m6730b().m6829q()) {
                        C1834p.m6925a().m6928d();
                    }
                    C1818h.m6730b().m6778a(null, null);
                } else if ("暂停播放,停止播放".contains(cmd)) {
                    if (C1818h.m6730b().m6829q()) {
                        C1834p.m6925a().m6927c();
                    }
                    C1818h.m6730b().m6811f(true);
                } else if (cmd.contains("下一")) {
                    C1818h.m6730b().m6789a(true);
                } else if (cmd.contains("上一")) {
                    C1818h.m6730b().m6789a(false);
                }
            } else if (type.equals("select_index")) {
                C1260i.m4435b(C1983b.f6376a, "voice scene select: " + cmd);
            }
        }
    }

    /* compiled from: VoiceControlManager */
    /* renamed from: com.baidu.carlife.o.b$2 */
    class C19822 implements C1981b {
        /* renamed from: a */
        final /* synthetic */ C1983b f6375a;

        C19822(C1983b this$0) {
            this.f6375a = this$0;
        }

        /* renamed from: a */
        public void mo1727a(String feature) {
            C1260i.m4435b(C1983b.f6376a, "close feature = " + feature);
            if (C2736p.f8976f.equals(feature)) {
                MapVoiceCommandController.getInstance().openNavi();
                MapVoiceCommandController.getInstance().exitNavi();
                return;
            }
            C1915a.m7321a().m7322a(C1983b.f6378c.getString(C0965R.string.no_this_ability), 1);
        }

        /* renamed from: a */
        public void mo1728a(String feature, boolean isFromVrWakeUp) {
            C1260i.m4435b(C1983b.f6376a, "open feature = " + feature);
            if (feature.equals(C1981b.f6368h)) {
                C1983b.m7577a(2);
            } else if (feature.equals("图库")) {
                C1983b.m7577a(3);
            } else if (feature.equals("playback")) {
                C1983b.m7577a(4);
            } else if (feature.equals("后视")) {
                C1983b.m7577a(22);
            } else if (feature.equals("home")) {
                this.f6375a.m7581b(4001);
            } else if (feature.equals("music_player_bsg")) {
                this.f6375a.m7581b(4004);
            } else if (feature.equals(C2736p.f8976f) || feature.equals(C1942q.f6155w)) {
                this.f6375a.m7581b(4003);
            } else if (feature.equals("telephone")) {
                this.f6375a.m7581b(4002);
            } else if (feature.equals("回放")) {
                C1983b.m7577a(4);
            } else if (feature.equals("记录仪")) {
                C1983b.m7577a(0);
            } else if (feature.equals("随心听")) {
                if (!C1663a.m5979a().m5993N()) {
                    C1260i.m4435b("#######", "VoiceControlManager VOICE_PHONE_0004,VOICE_0006");
                    StatisticManager.onEvent(StatisticConstants.VOICE_PHONE_0004);
                    StatisticManager.onEvent(StatisticConstants.VOICE_0006);
                }
                C1818h.m6730b().m6831s().m6994a(null, null);
            } else {
                C1260i.m4435b(C1983b.f6376a, "------- Wake up CMD -------: " + isFromVrWakeUp);
                if (!isFromVrWakeUp) {
                    C1915a.m7321a().m7322a(C1983b.f6378c.getString(C0965R.string.no_this_ability), 1);
                } else if (!this.f6375a.m7588a(feature)) {
                    C1915a.m7321a().m7322a(C1983b.f6378c.getString(C0965R.string.voice_current_no_control), 1);
                }
            }
        }

        /* renamed from: b */
        public void mo1729b(String feature) {
            C1260i.m4435b(C1983b.f6376a, "increase feature = " + feature);
            if (feature.equals(C1981b.f6362b)) {
                C1983b.m7577a(7);
            } else if (feature.equals(C1981b.f6364d)) {
                C1983b.m7577a(11);
            } else {
                C1915a.m7321a().m7322a(C1983b.f6378c.getString(C0965R.string.no_this_ability), 1);
            }
        }

        /* renamed from: c */
        public void mo1730c(String feature) {
            C1260i.m4435b(C1983b.f6376a, "decrease feature = " + feature);
            if (feature.equals(C1981b.f6362b)) {
                C1983b.m7577a(8);
            } else if (feature.equals(C1981b.f6364d)) {
                C1983b.m7577a(12);
            } else {
                C1915a.m7321a().m7322a(C1983b.f6378c.getString(C0965R.string.no_this_ability), 1);
            }
        }

        /* renamed from: d */
        public void mo1731d(String feature) {
            C1260i.m4435b(C1983b.f6376a, "maxmize feature = " + feature);
            if (feature.equals(C1981b.f6362b)) {
                C1983b.m7577a(9);
            } else if (feature.equals(C1981b.f6364d)) {
                C1983b.m7577a(13);
            } else {
                C1915a.m7321a().m7322a(C1983b.f6378c.getString(C0965R.string.no_this_ability), 1);
            }
        }

        /* renamed from: e */
        public void mo1732e(String feature) {
            C1260i.m4435b(C1983b.f6376a, "minimize feature = " + feature);
            if (feature.equals(C1981b.f6364d)) {
                C1983b.m7577a(14);
            } else {
                C1915a.m7321a().m7322a(C1983b.f6378c.getString(C0965R.string.no_this_ability), 1);
            }
        }

        /* renamed from: f */
        public void mo1733f(String action) {
            C1260i.m4435b(C1983b.f6376a, "manipulate feature = " + action);
            if (action.equals(C1981b.f6374n)) {
                C1983b.m7577a(17);
            } else {
                C1915a.m7321a().m7322a(C1983b.f6378c.getString(C0965R.string.no_this_ability), 1);
            }
        }
    }

    /* renamed from: a */
    public static C1983b m7576a() {
        if (f6377b == null) {
            synchronized (C1983b.class) {
                if (f6377b == null) {
                    f6377b = new C1983b();
                }
            }
        }
        return f6377b;
    }

    /* renamed from: a */
    public void m7587a(Context cx) {
        C1260i.m4435b(f6376a, "VoiceControlManager Init");
        f6378c = cx;
        this.f6379d.put(Integer.valueOf(18), C1978a.f6329B);
        this.f6379d.put(Integer.valueOf(13), C1978a.f6359y);
        this.f6379d.put(Integer.valueOf(14), C1978a.f6360z);
        this.f6379d.put(Integer.valueOf(0), C1978a.f6358x);
        this.f6379d.put(Integer.valueOf(17), C1978a.f6328A);
        this.f6379d.put(Integer.valueOf(22), C1978a.f6333F);
        m7584d();
        m7585e();
        C1754b.m6365a().m6368a(this.f6380e);
        C1754b.m6365a().m6373a(this.f6381f);
    }

    /* renamed from: d */
    private void m7584d() {
        this.f6380e.addCommand("open_home_page", C1978a.f6329B);
        this.f6380e.addCommand("open_phone_page", C1978a.f6330C);
        this.f6380e.addCommand("open_navi_page", C1978a.f6332E);
        this.f6380e.addCommand("open_music_page", C1978a.f6331D);
        this.f6380e.addCommand(C1981b.f6374n, C1978a.f6328A);
        this.f6380e.addCommand("max_brightness", C1978a.f6359y);
        this.f6380e.addCommand("min_brightness", C1978a.f6360z);
        this.f6380e.addCommand("open_dvr", C1978a.f6358x);
        this.f6380e.addCommand("open_camera", C1978a.f6333F);
        this.f6380e.addCommand("select_index", C1978a.f6334G);
    }

    /* renamed from: e */
    private void m7585e() {
        this.f6380e.addCommand("scene_music", "播放音乐", "播放歌曲", "暂停播放", "停止播放", "继续播放", StatisticConstants.HOME_MUSIC_STATUS_CHANGE_NEXT, "下一曲", StatisticConstants.HOME_MUSIC_STATUS_CHANGE_PRE, "上一曲");
    }

    /* renamed from: b */
    private void m7581b(int type) {
        switch (type) {
            case 4001:
                C1983b.m7577a(18);
                C1261k.m4461b(type);
                return;
            case 4002:
                C1983b.m7577a(1);
                C1261k.m4461b(type);
                return;
            case 4003:
                C1983b.m7577a(1);
                C1261k.m4461b(type);
                return;
            case 4004:
                C1983b.m7577a(1);
                C1261k.m4461b(type);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public boolean m7588a(String feature) {
        ContentFragment contentFragment = C1328h.m4757a().getCurrentFragment();
        if (contentFragment != null) {
            return contentFragment.onVoiceCommand("", feature);
        }
        C2725h.m10207b(f6376a, "doGotoCommand: fragment Error");
        return false;
    }

    /* renamed from: a */
    public static void m7577a(int cmd) {
        if (!C1983b.m7586f()) {
            return;
        }
        if (C1663a.m5979a().m5993N()) {
            CarlifeVoiceControlRequest voiceRequest = C1983b.m7583c(cmd);
            if (voiceRequest != null) {
                C1983b.m7579a(voiceRequest);
                C1260i.m4435b(f6376a, "MD --- >HU: Voice Control Cmd, id =  " + cmd);
                return;
            }
            return;
        }
        C1260i.m4435b(f6376a, "CarLife not connected");
    }

    /* renamed from: c */
    private static CarlifeVoiceControlRequest m7583c(int cmdID) {
        Builder builder = CarlifeVoiceControlRequest.newBuilder();
        if (builder == null) {
            return null;
        }
        builder.setCommand(cmdID);
        return builder.build();
    }

    /* renamed from: a */
    public static void m7579a(CarlifeVoiceControlRequest voiceReq) {
        C1260i.m4435b(f6376a, "MD--->HU : send voice control cmd to HU");
        if (voiceReq != null && C1663a.m5979a().m5993N()) {
            C1212c btCommand = new C1212c(true);
            btCommand.m4201c(C1253f.bh);
            btCommand.m4199b(voiceReq.toByteArray());
            btCommand.m4203d(voiceReq.getSerializedSize());
            C1663a.m5979a().m6017a(Message.obtain(null, btCommand.m4202d(), 1001, 0, btCommand));
        }
    }

    /* renamed from: f */
    private static boolean m7586f() {
        if (C1253f.jx == C1252a.VEHICLE_CHANNEL_YUANFENG_ELH_ONLINE || C1253f.jx == C1252a.VEHICLE_CHANNEL_YUANFENG_ELH_PCBA) {
            return true;
        }
        return false;
    }
}
