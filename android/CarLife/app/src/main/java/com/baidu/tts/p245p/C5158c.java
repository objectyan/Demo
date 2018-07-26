package com.baidu.tts.p245p;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.loopj.RequestHandle;
import com.baidu.tts.loopj.SyncHttpClient;
import com.baidu.tts.p233f.C5098o;
import com.baidu.tts.p241l.C5120a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UploadStatistics */
/* renamed from: com.baidu.tts.p.c */
public class C5158c {
    /* renamed from: a */
    ExecutorService f21292a = Executors.newSingleThreadExecutor();
    /* renamed from: b */
    private Context f21293b;
    /* renamed from: c */
    private C5120a f21294c;
    /* renamed from: d */
    private FutureTask<Integer> f21295d;
    /* renamed from: e */
    private int f21296e = 0;
    /* renamed from: f */
    private int f21297f = 0;

    /* compiled from: UploadStatistics */
    /* renamed from: com.baidu.tts.p.c$a */
    public class C5157a implements Callable<Integer> {
        /* renamed from: a */
        final /* synthetic */ C5158c f21290a;
        /* renamed from: b */
        private RequestHandle f21291b;

        public C5157a(C5158c c5158c) {
            this.f21290a = c5158c;
        }

        public /* synthetic */ Object call() throws Exception {
            return m17503a();
        }

        /* renamed from: a */
        public Integer m17503a() throws Exception {
            SyncHttpClient syncHttpClient = new SyncHttpClient(true, 80, 443);
            String a = C5098o.STATISTICS_SERVER.m17287a();
            HttpEntity b = m17502b();
            Object c5159d = new C5159d();
            this.f21291b = syncHttpClient.post(null, a, b, null, c5159d);
            final int a2 = c5159d.m17512a();
            this.f21290a.f21292a.submit(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C5157a f21289b;

                public void run() {
                    if (a2 == 0) {
                        LoggerProxy.m17001d("UploadStatistics", "delete database code==" + this.f21289b.f21290a.f21294c.m17357a(this.f21289b.f21290a.f21296e, this.f21289b.f21290a.f21297f));
                    }
                }
            });
            return Integer.valueOf(a2);
        }

        /* renamed from: b */
        private UrlEncodedFormEntity m17502b() {
            List arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList2 = (ArrayList) this.f21290a.f21294c.m17373f().get("listId");
            if (arrayList2.size() != 0) {
                this.f21290a.f21296e = ((Integer) arrayList2.get(0)).intValue();
                this.f21290a.f21297f = ((Integer) arrayList2.get(arrayList2.size() - 1)).intValue();
            }
            JSONArray jSONArray = new JSONArray((ArrayList) this.f21290a.f21294c.m17373f().get("list"));
            try {
                jSONObject.put("deviceInfo", C5154a.m17498a(this.f21290a.f21293b));
                jSONObject.put("appinfo", C5154a.m17499b(this.f21290a.f21293b));
                jSONObject.put("methodinfo", jSONArray);
                LoggerProxy.m17001d("UploadStatistics", "StatisticsData= " + jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            arrayList.add(new BasicNameValuePair("d", jSONObject.toString()));
            try {
                return new UrlEncodedFormEntity(arrayList, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public C5158c(Context context) {
        this.f21293b = context;
        this.f21294c = new C5120a(context);
    }

    /* renamed from: a */
    public FutureTask<Integer> m17510a() {
        this.f21295d = new FutureTask(new C5157a(this));
        this.f21292a.submit(this.f21295d);
        return this.f21295d;
    }

    /* renamed from: b */
    public void m17511b() {
        this.f21295d.cancel(true);
    }
}
