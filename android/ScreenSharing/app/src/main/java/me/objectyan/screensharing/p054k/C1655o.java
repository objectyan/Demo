package com.baidu.carlife.p054k;

import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.util.C2195t;
import com.baidu.speech.asr.SpeechConstant;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StatisticVehicleCrashRequest */
/* renamed from: com.baidu.carlife.k.o */
public class C1655o extends C1626e {
    /* renamed from: a */
    private InputStream f5092a;
    /* renamed from: b */
    private String f5093b;
    /* renamed from: c */
    private String f5094c;

    public C1655o(String versionName, String gzfileName, InputStream in) {
        this.tag = C1655o.class.getSimpleName();
        this.f5093b = versionName;
        this.f5092a = in;
        this.f5094c = gzfileName;
    }

    protected String getUrl() {
        return C1631f.m5913a();
    }

    protected C1622d getPostRequestParams() {
        C1622d params = new C1622d();
        params.put("os", "0");
        params.put(SpeechConstant.APP_ID, "3");
        params.put("app_ver", this.f5093b);
        params.toSign("sign");
        params.put("datafile", this.f5092a, this.f5094c);
        return params;
    }

    protected int responseSuccessCallBack(String data) {
        FileOutputStream fout = null;
        FileOutputStream foutgz = null;
        try {
            fout = BaiduNaviApplication.getInstance().openFileOutput(C2195t.f7029c, 0);
            fout.write("".getBytes());
            foutgz = BaiduNaviApplication.getInstance().openFileOutput("CarlifeVechicleCrash.log.gz", 0);
            foutgz.write("".getBytes());
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    LogUtil.m4445e(this.tag, e.toString());
                }
            }
            if (foutgz != null) {
                foutgz.close();
            }
        } catch (Exception e2) {
            LogUtil.m4445e(this.tag, e2.toString());
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e3) {
                    LogUtil.m4445e(this.tag, e3.toString());
                }
            }
            if (foutgz != null) {
                foutgz.close();
            }
        } catch (Throwable th) {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e32) {
                    LogUtil.m4445e(this.tag, e32.toString());
                }
            }
            if (foutgz != null) {
                foutgz.close();
            }
        }
        return 0;
    }
}
