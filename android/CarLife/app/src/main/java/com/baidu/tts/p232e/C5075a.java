package com.baidu.tts.p232e;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.speech.asr.SpeechConstant;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.loopj.AsyncHttpResponseHandler;
import com.baidu.tts.loopj.SyncHttpClient;
import com.baidu.tts.p236h.p238b.C5107b;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StatHelper */
/* renamed from: com.baidu.tts.e.a */
public class C5075a {
    /* renamed from: a */
    public static synchronized void m17228a(Context context, String str) {
        synchronized (C5075a.class) {
            if (C5079d.m17254h(context)) {
                long a = C5079d.m17239a(context);
                long currentTimeMillis = System.currentTimeMillis();
                Date date = new Date(a);
                Date date2 = new Date(currentTimeMillis);
                if (currentTimeMillis - a >= 86400000 || currentTimeMillis - a <= 0) {
                    LoggerProxy.m17001d("StatHelper", "updated " + C5075a.m17230b(context, str));
                } else {
                    LoggerProxy.m17001d("StatHelper", "lastTime " + a + ", curTime " + System.currentTimeMillis());
                    LoggerProxy.m17001d("StatHelper", "lastDate " + date + "\ncurDate " + date2);
                }
            }
        }
    }

    /* renamed from: b */
    private static boolean m17230b(Context context, String str) {
        boolean z = false;
        try {
            C5078c a = C5078c.m17232a(context);
            int a2 = a.m17235a();
            if (a2 >= 1) {
                int i;
                LoggerProxy.m17001d("StatHelper", "cursor.getCount: " + a2);
                if (a2 % 500 == 0) {
                    i = a2 / 500;
                } else {
                    i = (a2 / 500) + 1;
                }
                int i2 = 0;
                while (i2 < i) {
                    boolean z2;
                    JSONObject jSONObject = new JSONObject();
                    Map b = a.m17238b();
                    List list = (ArrayList) b.get("listId");
                    jSONObject.put("recog_results", new JSONArray((ArrayList) b.get("list")));
                    LoggerProxy.m17001d("StatHelper", "jsonObj all: " + jSONObject.toString());
                    byte[] a3 = C5079d.m17243a(jSONObject.toString());
                    if (a3.length >= 2) {
                        a3[0] = (byte) 117;
                        a3[1] = (byte) 123;
                    }
                    String a4 = C5079d.m17241a(a3);
                    LoggerProxy.m17001d("StatHelper", " postContent:" + a4);
                    boolean a5 = C5075a.m17229a(context, str, a4);
                    C5079d.m17242a(context, System.currentTimeMillis());
                    if (a5) {
                        a.m17237a(list);
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    i2++;
                    z = z2;
                }
            }
        } catch (SQLiteException e) {
            LoggerProxy.m17001d("StatHelper", "exception:" + e.toString());
        } catch (IllegalStateException e2) {
            LoggerProxy.m17001d("StatHelper", "exception:" + e2.toString());
        } catch (Exception e3) {
            LoggerProxy.m17001d("StatHelper", "exception:" + e3.toString());
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m17229a(Context context, String str, String str2) {
        final boolean[] zArr = new boolean[]{false};
        String c = C5075a.m17231c(context, str);
        LoggerProxy.m17001d("StatHelper", "statHelper url:" + c);
        new SyncHttpClient(true, 80, 443).post(null, c, C5075a.m17227a(str2), null, new AsyncHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Object str = new String(responseBody);
                LoggerProxy.m17001d("StatHelper", "response=" + new String(responseBody));
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if ("0".equals(new JSONObject(str).optString(C2125n.f6745M))) {
                            zArr[0] = true;
                            LoggerProxy.m17001d("StatHelper", "ret=" + zArr[0]);
                        }
                    } catch (JSONException e) {
                        LoggerProxy.m17001d("StatHelper", "parse:" + e.toString());
                    } catch (Exception e2) {
                        LoggerProxy.m17001d("StatHelper", "parse:" + e2.toString());
                    }
                }
            }

            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                LoggerProxy.m17001d("StatHelper", "statusCode: " + statusCode + "responseBody: " + responseBody);
            }
        });
        return zArr[0];
    }

    /* renamed from: c */
    private static String m17231c(Context context, String str) {
        List linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("wise_cuid", C5107b.m17306a().m17317i()));
        linkedList.add(new BasicNameValuePair("sdk_version", C5079d.m17240a()));
        linkedList.add(new BasicNameValuePair("app_name", C5079d.m17245b(context)));
        linkedList.add(new BasicNameValuePair("platform", C5079d.m17248c(context)));
        linkedList.add(new BasicNameValuePair("os", C5079d.m17244b()));
        linkedList.add(new BasicNameValuePair("net_type", C5079d.m17250d(context) + ""));
        linkedList.add(new BasicNameValuePair(SpeechConstant.APP_ID, str));
        linkedList.add(new BasicNameValuePair("screen", C5079d.m17251e(context)));
        linkedList.add(new BasicNameValuePair("sdk_name", C5079d.m17247c()));
        linkedList.add(new BasicNameValuePair("app_signature", C5079d.m17252f(context)));
        return "https://upl.baidu.com/voice?osname=voiceopen&action=usereventflow&" + URLEncodedUtils.format(linkedList, "utf-8");
    }

    /* renamed from: a */
    private static UrlEncodedFormEntity m17227a(String str) {
        UrlEncodedFormEntity urlEncodedFormEntity;
        UnsupportedEncodingException e;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("records", str));
        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, "utf-8");
            try {
                urlEncodedFormEntity.setContentType("application/x-www-form-urlencoded");
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                e.printStackTrace();
                return urlEncodedFormEntity;
            }
        } catch (UnsupportedEncodingException e3) {
            UnsupportedEncodingException unsupportedEncodingException = e3;
            urlEncodedFormEntity = null;
            e = unsupportedEncodingException;
            e.printStackTrace();
            return urlEncodedFormEntity;
        }
        return urlEncodedFormEntity;
    }
}
