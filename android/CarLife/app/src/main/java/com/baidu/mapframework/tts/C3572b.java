package com.baidu.mapframework.tts;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Build.VERSION;

/* compiled from: SoundUtils */
/* renamed from: com.baidu.mapframework.tts.b */
public class C3572b {
    /* renamed from: a */
    public static final int f19277a = 3;
    /* renamed from: b */
    public static final int f19278b = 8;
    /* renamed from: c */
    private Context f19279c;
    /* renamed from: d */
    private SoundPool f19280d;
    /* renamed from: e */
    private int f19281e;
    /* renamed from: f */
    private boolean f19282f;

    /* compiled from: SoundUtils */
    /* renamed from: com.baidu.mapframework.tts.b$1 */
    class C35711 implements OnLoadCompleteListener {
        /* renamed from: a */
        final /* synthetic */ C3572b f19276a;

        C35711(C3572b this$0) {
            this.f19276a = this$0;
        }

        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
            this.f19276a.f19282f = status == 0;
        }
    }

    public C3572b(Context context, int soundRawResId) {
        this.f19279c = null;
        this.f19280d = null;
        this.f19281e = -1;
        this.f19282f = false;
        this.f19282f = false;
        this.f19279c = context;
        m15230a(context, soundRawResId);
    }

    /* renamed from: a */
    private void m15230a(Context context, int soundRawResId) {
        if (context == null || soundRawResId <= 0) {
            this.f19282f = false;
            return;
        }
        this.f19280d = new SoundPool(3, 4, 0);
        if (VERSION.SDK_INT >= 8) {
            this.f19280d.setOnLoadCompleteListener(new C35711(this));
        } else {
            this.f19282f = true;
        }
        this.f19281e = this.f19280d.load(context, soundRawResId, 1);
    }

    /* renamed from: a */
    public boolean m15232a() {
        if (this.f19279c == null || !this.f19282f || this.f19280d == null) {
            return false;
        }
        AudioManager am = (AudioManager) this.f19279c.getSystemService("audio");
        float volumeRatio = ((float) am.getStreamVolume(3)) / ((float) am.getStreamMaxVolume(3));
        this.f19280d.play(this.f19281e, volumeRatio, volumeRatio, 1, 0, 1.0f);
        return true;
    }

    /* renamed from: b */
    public void m15233b() {
        if (this.f19280d != null) {
            if (this.f19282f) {
                this.f19280d.unload(this.f19281e);
            }
            this.f19280d.release();
            this.f19280d = null;
        }
    }
}
