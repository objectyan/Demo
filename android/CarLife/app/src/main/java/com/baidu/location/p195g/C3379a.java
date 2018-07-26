package com.baidu.location.p195g;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.baidunavis.BaiduNaviParams.VoiceKey;
import com.baidu.location.C3377f;
import com.baidu.location.LLSInterface;
import com.baidu.location.indoor.C3439d;
import com.baidu.location.indoor.p196a.C3398a;
import com.baidu.location.p187a.C3181a;
import com.baidu.location.p187a.C3182b;
import com.baidu.location.p187a.C3192e;
import com.baidu.location.p187a.C3196g;
import com.baidu.location.p187a.C3200h;
import com.baidu.location.p187a.C3207j;
import com.baidu.location.p187a.C3209l;
import com.baidu.location.p187a.C3211m;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p189b.C3213a;
import com.baidu.location.p189b.C3216b;
import com.baidu.location.p189b.C3218c;
import com.baidu.location.p189b.C3220d;
import com.baidu.location.p189b.C3221e;
import com.baidu.location.p189b.C3225f;
import com.baidu.location.p189b.C3229g;
import com.baidu.location.p190c.C3232a;
import com.baidu.location.p190c.C3243b;
import com.baidu.location.p191d.C3286c;
import com.baidu.location.p191d.C3294d;
import com.baidu.location.p191d.C3299f;
import com.baidu.location.p191d.C3303h;
import com.baidu.location.p191d.C3314j;
import com.baidu.location.p191d.C3319l;
import com.baidu.location.p191d.C3330n;
import com.baidu.location.p191d.p192a.C3256a;
import com.baidu.location.p191d.p192a.C3268e;
import com.baidu.location.p191d.p192a.C3274f;
import com.baidu.location.p193e.C3335a;
import com.baidu.location.p193e.C3349d;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3371d;
import com.baidu.location.p194f.C3376f;
import com.baidu.location.wifihistory.SClient;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel;
import org.json.JSONObject;

/* renamed from: com.baidu.location.g.a */
public class C3379a extends Service implements LLSInterface {
    /* renamed from: a */
    static C3378a f18296a = null;
    /* renamed from: f */
    private static long f18297f = 0;
    /* renamed from: b */
    Messenger f18298b = null;
    /* renamed from: c */
    private Looper f18299c;
    /* renamed from: d */
    private HandlerThread f18300d;
    /* renamed from: e */
    private boolean f18301e = false;

    /* renamed from: com.baidu.location.g.a$a */
    public class C3378a extends Handler {
        /* renamed from: a */
        final /* synthetic */ C3379a f18295a;

        public C3378a(C3379a c3379a, Looper looper) {
            this.f18295a = c3379a;
            super(looper);
        }

        public void handleMessage(Message message) {
            boolean z = false;
            if (C3377f.isServing) {
                Bundle data;
                switch (message.what) {
                    case 11:
                        this.f18295a.m14387a(message);
                        break;
                    case 12:
                        this.f18295a.m14391b(message);
                        break;
                    case 15:
                        this.f18295a.m14395c(message);
                        break;
                    case 22:
                        C3200h.m13362c().m13381b(message);
                        break;
                    case 28:
                        C3200h.m13362c().m13380a(true, true);
                        break;
                    case 41:
                        C3200h.m13362c().m13391j();
                        break;
                    case 110:
                        C3439d.m14680a().m14741c();
                        break;
                    case 111:
                        C3439d.m14680a().m14742d();
                        break;
                    case 112:
                        C3439d.m14680a().m14740b();
                        break;
                    case 302:
                        C3439d.m14680a().m14743e();
                        break;
                    case 401:
                        try {
                            Bundle data2 = message.getData();
                            try {
                                JSONObject jSONObject = new JSONObject(data2.getString("ugcInfo", ""));
                                Message obtainMessage;
                                if (!jSONObject.has(VoiceKey.ACTION) || !jSONObject.has("status")) {
                                    z = true;
                                    if (z) {
                                        obtainMessage = C3294d.m13799a().m13835e().obtainMessage(2);
                                        obtainMessage.setData(data2);
                                        obtainMessage.sendToTarget();
                                        break;
                                    }
                                }
                                if (jSONObject.getInt("status") == 1) {
                                    C3286c.m13744a().m13794a(false);
                                } else if (jSONObject.getInt("status") == 0) {
                                    C3286c.m13744a().m13794a(true);
                                }
                                if (z) {
                                    obtainMessage = C3294d.m13799a().m13835e().obtainMessage(2);
                                    obtainMessage.setData(data2);
                                    obtainMessage.sendToTarget();
                                }
                            } catch (Exception e) {
                                z = true;
                            }
                        } catch (Exception e2) {
                            break;
                        }
                        break;
                    case 402:
                        try {
                            data = message.getData();
                            if (data != null) {
                                Message obtainMessage2 = C3294d.m13799a().m13835e().obtainMessage(3);
                                obtainMessage2.setData(data);
                                obtainMessage2.sendToTarget();
                                break;
                            }
                        } catch (Exception e3) {
                            break;
                        }
                        break;
                    case 403:
                        try {
                            data = message.getData();
                            int i = data.getInt("status", 0);
                            int i2 = data.getInt("source", 0);
                            if (i != 1) {
                                if (i == 2) {
                                    C3303h.m13894a().m13903c();
                                    break;
                                }
                            }
                            C3303h.m13894a().m13901a(i2);
                            break;
                        } catch (Exception e4) {
                            break;
                        }
                        break;
                    case 405:
                        byte[] byteArray = message.getData().getByteArray("errorid");
                        String str = null;
                        if (byteArray != null && byteArray.length > 0) {
                            str = new String(byteArray);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            C3299f.m13848a().m13868a("receive errorreportid = " + str);
                            C3299f.m13848a().m13872c(str);
                            break;
                        }
                        break;
                    case 406:
                        C3192e.m13329a().m13342e();
                        break;
                    case 407:
                        try {
                            C3192e.m13329a().m13338a(message.getData().getBoolean(BNRCEventDetailsModel.BN_RC_KEY_USER));
                            break;
                        } catch (Exception e5) {
                            break;
                        }
                }
            }
            if (message.what == 1) {
                this.f18295a.m14397d();
            }
            if (message.what == 0) {
                this.f18295a.m14394c();
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: a */
    public static Handler m14386a() {
        return f18296a;
    }

    /* renamed from: a */
    private void m14387a(Message message) {
        Log.d("baidu_location_service", "baidu location service register ...");
        C3299f.m13848a().m13868a("service register!");
        C3181a.m13265a().m13271a(message);
        C3349d.m14171a();
        C3220d.m13499a().m13517d();
        C3207j.m13417b().mo2499c();
    }

    /* renamed from: b */
    public static long m14390b() {
        return f18297f;
    }

    /* renamed from: b */
    private void m14391b(Message message) {
        C3181a.m13265a().m13275b(message);
    }

    /* renamed from: c */
    private void m14394c() {
        C3196g.m13350a().m13351a(C3377f.getServiceContext());
        C3319l.m13952a().m13957a(this.f18299c);
        SClient.getInstance().start();
        C3274f.m13695a();
        C3256a.m13618a().m13635b();
        C3268e.m13681a();
        C3314j.m13917b().m13940e();
        C3330n.m14008a().m14033b();
        C3398a.m14465b().m14478e();
        C3243b.m13581a().m13590a(604800);
        C3232a.m13554b();
        C3192e.m13329a().m13339b();
        C3371d.m14289a().m14314b();
        C3364b.m14262a().m14276b();
        C3381b.m14398a();
        C3200h.m13362c().m13384d();
        C3335a.m14038a().m14058b();
        C3218c.m13487a().m13491b();
        C3220d.m13499a().m13515b();
        C3221e.m13518a().m13522b();
        C3213a.m13466a().m13472b();
        C3225f.m13526a().m13533b();
        C3376f.m14355a().m14368c();
    }

    /* renamed from: c */
    private void m14395c(Message message) {
        C3181a.m13265a().m13279c(message);
    }

    /* renamed from: d */
    private void m14397d() {
        C3376f.m14355a().m14370e();
        C3349d.m14171a().m14197o();
        C3371d.m14289a().m14318f();
        C3229g.m13535a().m13544c();
        C3220d.m13499a().m13516c();
        C3218c.m13487a().m13492c();
        C3216b.m13475a().m13483c();
        C3213a.m13466a().m13473c();
        C3182b.m13285a().m13287b();
        C3364b.m14262a().m14277c();
        C3200h.m13362c().m13386e();
        C3439d.m14680a().m14742d();
        C3314j.m13917b().m13941f();
        C3330n.m14008a().m14034c();
        C3192e.m13329a().m13340c();
        C3211m.m13457g();
        C3181a.m13265a().m13274b();
        C3299f.m13848a().m13871c();
        Log.d("baidu_location_service", "baidu location service has stoped ...");
        Process.killProcess(Process.myPid());
    }

    public double getVersion() {
        return 7.320000171661377d;
    }

    public IBinder onBind(Intent intent) {
        Bundle extras = intent.getExtras();
        boolean z = false;
        if (extras != null) {
            C3381b.f18314g = extras.getString("key");
            C3381b.f18313f = extras.getString("sign");
            this.f18301e = extras.getBoolean("kill_process");
            z = extras.getBoolean("cache_exception");
        }
        if (z) {
        }
        return this.f18298b.getBinder();
    }

    public void onCreate(Context context) {
        f18297f = System.currentTimeMillis();
        this.f18300d = C3209l.m13436a();
        this.f18299c = this.f18300d.getLooper();
        if (this.f18299c == null) {
            f18296a = new C3378a(this, Looper.getMainLooper());
        } else {
            f18296a = new C3378a(this, this.f18299c);
        }
        this.f18298b = new Messenger(f18296a);
        f18296a.sendEmptyMessage(0);
        C3299f.m13848a().m13869b();
        C3299f.m13848a().m13868a("service creat!");
        Log.d("baidu_location_service", "baidu location service start1 ..." + Process.myPid());
    }

    public void onDestroy() {
        C3181a.m13265a().m13270a(new Bundle(), 502);
        C3299f.m13848a().m13868a("service destroy!");
        C3299f.m13848a().m13873d();
        try {
            f18296a.sendEmptyMessage(1);
        } catch (Exception e) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            m14397d();
            Process.killProcess(Process.myPid());
        }
        Log.d("baidu_location_service", "baidu location service stop ...");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public void onTaskRemoved(Intent intent) {
        Log.d("baidu_location_service", "baidu location service remove task...");
    }

    public boolean onUnBind(Intent intent) {
        return false;
    }
}
