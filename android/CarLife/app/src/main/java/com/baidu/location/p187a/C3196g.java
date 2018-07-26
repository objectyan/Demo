package com.baidu.location.p187a;

import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.C3167g;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.location.p188h.C3380a;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.platform.comapi.UIMsg;
import org.json.JSONObject;

/* renamed from: com.baidu.location.a.g */
public class C3196g implements LBSAuthManagerListener {
    /* renamed from: a */
    private static Object f17368a = new Object();
    /* renamed from: b */
    private static C3196g f17369b = null;
    /* renamed from: c */
    private int f17370c = 0;
    /* renamed from: d */
    private Context f17371d = null;
    /* renamed from: e */
    private long f17372e = 0;
    /* renamed from: f */
    private String f17373f = null;

    /* renamed from: a */
    public static C3196g m13350a() {
        C3196g c3196g;
        synchronized (f17368a) {
            if (f17369b == null) {
                f17369b = new C3196g();
            }
            c3196g = f17369b;
        }
        return c3196g;
    }

    /* renamed from: a */
    public void m13351a(Context context) {
    }

    /* renamed from: b */
    public boolean m13352b() {
        boolean z = true;
        if (!(this.f17370c == 0 || this.f17370c == 602 || this.f17370c == UIMsg.MSG_MAP_PANO_ROUTE_DATA || this.f17370c == -10 || this.f17370c == -11)) {
            z = false;
        }
        if (this.f17371d != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f17372e;
            if (z) {
                if (currentTimeMillis > 86400000) {
                    C3167g.m13228a(this.f17371d).m13246a(false, "lbs_locsdk", null, (LBSAuthManagerListener) this);
                    this.f17372e = System.currentTimeMillis();
                }
            } else if (currentTimeMillis < 0 || currentTimeMillis > BNOffScreenParams.MIN_ENTER_INTERVAL) {
                C3167g.m13228a(this.f17371d).m13246a(false, "lbs_locsdk", null, (LBSAuthManagerListener) this);
                this.f17372e = System.currentTimeMillis();
            }
        }
        return z;
    }

    public void onAuthResult(int i, String str) {
        this.f17370c = i;
        Log.i(C3380a.f18302a, "LocationAuthManager Authentication Error errorcode = " + i + " , msg = " + str);
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && jSONObject.getString("token") != null) {
                    this.f17373f = jSONObject.getString("token");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
