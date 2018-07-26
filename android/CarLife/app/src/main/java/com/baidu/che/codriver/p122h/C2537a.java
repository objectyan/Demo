package com.baidu.che.codriver.p122h;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import com.baidu.che.codriver.sdk.p081a.C2602k;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.che.codriver.util.C2725h;

/* compiled from: AudioFocusManager */
/* renamed from: com.baidu.che.codriver.h.a */
public class C2537a implements OnAudioFocusChangeListener {
    /* renamed from: a */
    public static final String f8326a = "AudioFocusManager";
    /* renamed from: b */
    private static final Object f8327b = new Object();
    /* renamed from: c */
    private static C2537a f8328c;
    /* renamed from: d */
    private AudioManager f8329d;
    /* renamed from: e */
    private boolean f8330e = false;
    /* renamed from: f */
    private Handler f8331f;

    private C2537a() {
    }

    /* renamed from: a */
    public static C2537a m9625a() {
        if (f8328c == null) {
            synchronized (f8327b) {
                if (f8328c == null) {
                    f8328c = new C2537a();
                }
            }
        }
        return f8328c;
    }

    /* renamed from: a */
    public void m9626a(Context context) {
        if (this.f8329d == null) {
            this.f8329d = (AudioManager) context.getSystemService("audio");
        }
        if (this.f8331f == null) {
            this.f8331f = new Handler();
        }
    }

    /* renamed from: b */
    public int m9627b() {
        C2725h.m10207b(f8326a, "AudioFocusManager.requestVrAudioFocus() mHasFocus=" + this.f8330e);
        if (1 != this.f8329d.requestAudioFocus(this, 3, 2)) {
            return 0;
        }
        C2725h.m10207b(f8326a, "requestVrAudioFocus succeed!");
        return 1;
    }

    /* renamed from: c */
    public int m9628c() {
        C2725h.m10207b(f8326a, "AudioFocusManager.abandonVrAudioFocus() mHasFocus=" + this.f8330e);
        if (1 != this.f8329d.abandonAudioFocus(this)) {
            return 0;
        }
        C2725h.m10207b(f8326a, "abandonVrAudioFocus succeed!");
        return 1;
    }

    public void onAudioFocusChange(int focusChange) {
        C2725h.m10207b(f8326a, "onAudioFocusChange focusChange=" + focusChange);
        C1981b systemTool = C2602k.m9819a().m9822b();
        switch (focusChange) {
        }
    }
}
