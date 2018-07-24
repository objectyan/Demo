package com.baidu.carlife.core.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: ArbitrationModule */
/* renamed from: com.baidu.carlife.core.audio.b */
public class ArbitrationModule {
    /* renamed from: a */
    private static final String f3019a = (AudioUtil.f3010n + ArbitrationModule.class.getSimpleName());
    /* renamed from: b */
    private static ArbitrationModule f3020b;
    /* renamed from: c */
    private boolean f3021c = false;
    /* renamed from: d */
    private boolean f3022d = false;
    /* renamed from: e */
    private AudioManager f3023e;
    /* renamed from: f */
    private Timer f3024f;
    /* renamed from: g */
    private TimerTask f3025g;
    /* renamed from: h */
    private boolean f3026h = false;
    /* renamed from: i */
    private Context f3027i;
    /* renamed from: j */
    private OnAudioFocusChangeListener f3028j = new C11641(this);

    /* compiled from: ArbitrationModule */
    /* renamed from: com.baidu.carlife.core.audio.b$1 */
    class C11641 implements OnAudioFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ ArbitrationModule f3017a;

        C11641(ArbitrationModule this$0) {
            this.f3017a = this$0;
        }

        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case -3:
                    LogUtil.d(ArbitrationModule.f3019a, "music AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    MsgHandlerCenter.m4462b(270, -3);
                    return;
                case -2:
                    LogUtil.d(ArbitrationModule.f3019a, "music AUDIOFOCUS_LOSS_TRANSIENT");
                    MsgHandlerCenter.m4462b(270, -2);
                    return;
                case -1:
                    if (AudioUtil.m3883h()) {
                        LogUtil.d(ArbitrationModule.f3019a, "AUDIOFOCUS_LOSS is triggered");
                        this.f3017a.m3902e();
                        return;
                    }
                    LogUtil.d(ArbitrationModule.f3019a, "music AUDIOFOCUS_LOSS");
                    MsgHandlerCenter.m4462b(270, -1);
                    return;
                case 1:
                    LogUtil.d(ArbitrationModule.f3019a, "music AUDIOFOCUS_GAIN");
                    MsgHandlerCenter.m4462b(270, 1);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: ArbitrationModule */
    /* renamed from: com.baidu.carlife.core.audio.b$2 */
    class C11652 extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ ArbitrationModule f3018a;

        C11652(ArbitrationModule this$0) {
            this.f3018a = this$0;
        }

        public void run() {
            if (this.f3018a.f3024f != null) {
                if (this.f3018a.m3904g()) {
                    this.f3018a.m3907b();
                    this.f3018a.m3906a(false);
                } else {
                    LogUtil.d(ArbitrationModule.f3019a, "delay to send AUDIOFOCUS_LOSS");
                    MsgHandlerCenter.m4462b(270, -1);
                    this.f3018a.m3906a(false);
                }
                this.f3018a.m3903f();
            }
        }
    }

    private ArbitrationModule() {
    }

    /* renamed from: a */
    public static ArbitrationModule m3896a() {
        if (f3020b == null) {
            f3020b = new ArbitrationModule();
        }
        return f3020b;
    }

    /* renamed from: a */
    public void m3905a(Context context) {
        this.f3027i = context;
    }

    /* renamed from: b */
    public int m3907b() {
        LogUtil.d(f3019a, "music request Audio Focus");
        if (this.f3027i == null) {
            LogUtil.m4445e(f3019a, "mContext is not initialized!");
            return 1;
        }
        this.f3023e = (AudioManager) this.f3027i.getSystemService("audio");
        if (this.f3023e.requestAudioFocus(this.f3028j, 3, 1) == 1) {
            return 0;
        }
        return -1;
    }

    /* renamed from: c */
    public int m3908c() {
        return 0;
    }

    /* renamed from: e */
    private void m3902e() {
        try {
            LogUtil.m4445e(f3019a, "Timer Start");
            this.f3024f = new Timer();
            this.f3025g = new C11652(this);
            this.f3024f.schedule(this.f3025g, 100);
        } catch (Exception ex) {
            LogUtil.d(f3019a, "startTimer get exception");
            ex.printStackTrace();
        }
    }

    /* renamed from: f */
    private void m3903f() {
        LogUtil.m4445e(f3019a, "Timer Stop");
        if (this.f3024f != null) {
            this.f3024f.cancel();
            this.f3024f = null;
        }
    }

    /* renamed from: a */
    public void m3906a(boolean status) {
        this.f3026h = status;
    }

    /* renamed from: g */
    private boolean m3904g() {
        return this.f3026h;
    }
}
