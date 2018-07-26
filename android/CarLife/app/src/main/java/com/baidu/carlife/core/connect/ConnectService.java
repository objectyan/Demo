package com.baidu.carlife.core.connect;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.baidu.carlife.core.C1260i;
import java.util.LinkedList;
import java.util.List;

public class ConnectService extends Service {
    /* renamed from: a */
    public static final int f3180a = -1;
    /* renamed from: b */
    private static final String f3181b = "ConnectService";
    /* renamed from: c */
    private static final int f3182c = 100;
    /* renamed from: d */
    private HandlerThread f3183d = new HandlerThread("MsgHandlerThread");
    /* renamed from: e */
    private C1193a f3184e;
    /* renamed from: f */
    private Messenger f3185f;
    /* renamed from: g */
    private C1220f f3186g = null;
    /* renamed from: h */
    private Handler f3187h = null;
    /* renamed from: i */
    private List<Message> f3188i = new LinkedList();
    /* renamed from: j */
    private C1218e f3189j = null;

    /* renamed from: com.baidu.carlife.core.connect.ConnectService$a */
    private class C1193a extends Handler {
        /* renamed from: a */
        final /* synthetic */ ConnectService f3179a;

        public C1193a(ConnectService connectService, Looper looper) {
            this.f3179a = connectService;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (this.f3179a.f3187h != null) {
                this.f3179a.f3187h.handleMessage(msg);
                if (this.f3179a.f3188i.size() > 0) {
                    this.f3179a.f3184e.sendMessage((Message) this.f3179a.f3188i.remove(0));
                    return;
                }
                return;
            }
            if (this.f3179a.f3188i.size() >= 100) {
                Message oldMsg = (Message) this.f3179a.f3188i.remove(0);
                Message replayMsg = Message.obtain(null, -1, oldMsg);
                try {
                    C1260i.m4445e(ConnectService.f3181b, "Send MSG_SEND_DISCARD, oldMsg what = " + Integer.toString(oldMsg.what));
                    oldMsg.replyTo.send(replayMsg);
                } catch (Throwable t) {
                    C1260i.m4445e(ConnectService.f3181b, "Send MSG_SEND_DISCARD Error");
                    t.printStackTrace();
                }
            }
            this.f3179a.f3188i.add(Message.obtain(msg));
            this.f3179a.m4097a();
        }
    }

    /* renamed from: a */
    private void m4097a() {
        try {
            if (this.f3186g == null || this.f3187h == null) {
                this.f3186g = new C1220f(this);
                this.f3187h = this.f3186g.m4257a();
            }
            if (this.f3188i.size() > 0) {
                this.f3184e.sendMessage((Message) this.f3188i.remove(0));
            }
            this.f3189j = C1218e.m4228a();
            this.f3189j.m4244c();
            this.f3189j.m4254h();
        } catch (Throwable t) {
            this.f3186g = null;
            this.f3187h = null;
            t.printStackTrace();
        }
    }

    public IBinder onBind(Intent intent) {
        C1260i.m4435b(f3181b, "ConnectService onBind()");
        return this.f3185f.getBinder();
    }

    public boolean onUnbind(Intent intent) {
        C1260i.m4435b(f3181b, "ConnectService onUnbind()");
        return super.onUnbind(intent);
    }

    public void onRebind(Intent intent) {
        C1260i.m4435b(f3181b, "ConnectService onRebind()");
        super.onRebind(intent);
    }

    public void onCreate() {
        C1260i.m4435b(f3181b, "ConnectService onCreate()");
        super.onCreate();
        this.f3183d.start();
        this.f3184e = new C1193a(this, this.f3183d.getLooper());
        this.f3185f = new Messenger(this.f3184e);
        m4097a();
    }

    public void onStart(Intent intent, int startId) {
        C1260i.m4435b(f3181b, "ConnectService onStart(), startId = " + startId);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        C1260i.m4435b(f3181b, "ConnectService onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        C1260i.m4435b(f3181b, "ConnectService onDestroy()");
        if (this.f3189j != null) {
            this.f3189j.m4246d();
            this.f3189j = null;
        }
        super.onDestroy();
    }
}
