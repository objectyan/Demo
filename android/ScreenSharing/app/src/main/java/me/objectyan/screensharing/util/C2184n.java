package com.baidu.carlife.util;

import android.content.Context;
import android.media.AudioTrack;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import java.io.InputStream;

/* compiled from: PCMFilePlayUtil */
/* renamed from: com.baidu.carlife.util.n */
public class C2184n {
    /* renamed from: d */
    private static C2184n f6978d = null;
    /* renamed from: e */
    private static final int f6979e = 16000;
    /* renamed from: f */
    private static final int f6980f = 1;
    /* renamed from: g */
    private static final int f6981g = 16;
    /* renamed from: a */
    private Context f6982a;
    /* renamed from: b */
    private byte[] f6983b;
    /* renamed from: c */
    private InputStream f6984c;

    private C2184n() {
        this.f6982a = null;
        this.f6983b = new byte[10240];
        this.f6984c = null;
        this.f6982a = BaiduNaviApplication.getInstance().getApplicationContext();
    }

    /* renamed from: a */
    public static C2184n m8295a() {
        if (f6978d == null) {
            f6978d = new C2184n();
        }
        return f6978d;
    }

    /* renamed from: a */
    public void m8296a(int resId) {
        try {
            this.f6984c = this.f6982a.getResources().openRawResource(resId);
            int byteRead;
            if (!CarlifeCoreSDK.m5979a().m5993N() || CarlifeCoreSDK.m5979a().m5989J()) {
                AudioTrack pcmPlayer = new AudioTrack(3, 16000, 4, 2, AudioTrack.getMinBufferSize(16000, 4, 2), 1);
                while (true) {
                    byteRead = this.f6984c.read(this.f6983b);
                    if (byteRead == -1) {
                        break;
                    }
                    if (pcmPlayer.getPlayState() != 3) {
                        pcmPlayer.play();
                    }
                    pcmPlayer.write(this.f6983b, 0, byteRead);
                    pcmPlayer.flush();
                }
                pcmPlayer.release();
            } else {
                if (CarlifeCoreSDK.m5979a().m5982C()) {
                    CarlifeCoreSDK.m5979a().m5981B();
                }
                CarlifeCoreSDK.m5979a().m6027c(16000, 1, 16);
                while (true) {
                    byteRead = this.f6984c.read(this.f6983b);
                    if (byteRead == -1) {
                        break;
                    }
                    CarlifeCoreSDK.m5979a().m6029c(this.f6983b, byteRead);
                }
                CarlifeCoreSDK.m5979a().m5984E();
            }
            this.f6984c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
