package com.baidu.ufosdk.p251e;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navi.track.sync.SyncChannelConstant.Key;
import com.baidu.speech.asr.SpeechConstant;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p248b.C5171d;
import com.baidu.ufosdk.p249c.C5174a;
import com.baidu.ufosdk.util.C5210c;
import com.baidu.ufosdk.util.C5219l;
import com.baidu.ufosdk.util.C5220m;
import com.baidu.ufosdk.util.C5226s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: FeedbackMsgSender */
/* renamed from: com.baidu.ufosdk.e.a */
public final class C5180a {
    /* renamed from: a */
    public static boolean m17569a(Context context) {
        long blockCount;
        Object obj;
        String str = C5167a.at;
        C5210c.m17734b("postUrl is " + str);
        String uuid = UUID.randomUUID().toString();
        long currentTimeMillis = System.currentTimeMillis();
        Map hashMap = new HashMap();
        hashMap.put("os", "android");
        hashMap.put("clientid", UfoSDK.clientid);
        hashMap.put(SpeechConstant.APP_ID, UfoSDK.appid);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("pkgname", C5171d.m17558a());
        hashMap.put("cuid", uuid);
        hashMap.put("appname", C5171d.m17560b());
        hashMap.put("appvn", C5171d.m17561c());
        hashMap.put("brand", Build.MANUFACTURER);
        hashMap.put("model", Build.MODEL);
        hashMap.put("osvn", VERSION.RELEASE);
        hashMap.put("osvc", String.valueOf(C5219l.m17768a()));
        String str2 = "totalspace";
        if (C5226s.m17792a("android.permission.MOUNT_UNMOUNT_FILESYSTEMS")) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } else {
            blockCount = -1;
        }
        hashMap.put(str2, String.valueOf(blockCount));
        hashMap.put("phonetime", String.valueOf(currentTimeMillis));
        String str3 = "screensize";
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i == 0 && i2 == 0) {
            obj = null;
        } else {
            obj = String.valueOf(i) + "*" + String.valueOf(i2);
        }
        hashMap.put(str3, obj);
        hashMap.put("sdkvn", "1.7.13");
        uuid = C5220m.m17770a(C5174a.m17564a(hashMap));
        C5210c.m17734b("## encryptAES:\n" + uuid);
        str3 = "";
        try {
            uuid = "sdk_encrypt=" + URLEncoder.encode(uuid, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            uuid = str3;
        }
        try {
            obj = C5181b.m17578a(str, uuid);
            if (!TextUtils.isEmpty(obj)) {
                JSONObject jSONObject = new JSONObject(C5220m.m17773b(obj));
                C5210c.m17732a("getAPIKey response is " + jSONObject.toString());
                if (((Integer) jSONObject.get(C2125n.f6745M)).intValue() == 0) {
                    uuid = jSONObject.getString("clientid");
                    str = jSONObject.getString(SpeechConstant.APP_ID);
                    String string = jSONObject.getString("devid");
                    str3 = jSONObject.getString("product_line");
                    Editor edit = context.getSharedPreferences("UfoSharePreference", 0).edit();
                    UfoSDK.clientid = uuid;
                    UfoSDK.appid = str;
                    UfoSDK.devid = string;
                    UfoSDK.productid = str3;
                    edit.putString("UfoClientId", uuid);
                    edit.putString("UfoAppId", str);
                    edit.putString("UfoDevId", string);
                    edit.putString("UfoProductId", str3);
                    edit.commit();
                    context.sendBroadcast(new Intent("com.baidu.ufosdk.getappkeysuccess_getnewhistoryflag"));
                    if (UfoSDK.isUninstallFeedback && !UfoSDK.hasRegistered) {
                        UfoSDK.hasRegistered = UfoSDK.regUninstalledFeedback();
                    }
                    return true;
                }
            }
        } catch (Throwable e2) {
            C5210c.m17733a("sendRecord fail.", e2);
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public static boolean m17572b(android.content.Context r10) {
        /*
        r1 = 1;
        r2 = 0;
        r4 = com.baidu.ufosdk.C5167a.au;
        r0 = new java.lang.StringBuilder;
        r3 = "postUrl is ";
        r0.<init>(r3);
        r0 = r0.append(r4);
        r0 = r0.toString();
        com.baidu.ufosdk.util.C5210c.m17734b(r0);
        r0 = new java.util.HashMap;
        r0.<init>();
        r3 = "clientid";
        r5 = com.baidu.ufosdk.UfoSDK.clientid;
        r0.put(r3, r5);
        r3 = "appid";
        r5 = com.baidu.ufosdk.UfoSDK.appid;
        r0.put(r3, r5);
        r3 = "devid";
        r5 = com.baidu.ufosdk.UfoSDK.devid;
        r0.put(r3, r5);
        r3 = "uid";
        r5 = com.baidu.ufosdk.C5167a.f21356b;
        r0.put(r3, r5);
        r0 = com.baidu.ufosdk.p249c.C5174a.m17564a(r0);
        r0 = com.baidu.ufosdk.util.C5220m.m17770a(r0);
        r3 = "";
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x00ec }
        r6 = "sdk_encrypt=";
        r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x00ec }
        r6 = "UTF-8";
        r0 = java.net.URLEncoder.encode(r0, r6);	 Catch:{ UnsupportedEncodingException -> 0x00ec }
        r0 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x00ec }
        r0 = r0.toString();	 Catch:{ UnsupportedEncodingException -> 0x00ec }
    L_0x005e:
        r0 = com.baidu.ufosdk.p251e.C5181b.m17578a(r4, r0);	 Catch:{ Exception -> 0x01ab }
        r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x01ab }
        if (r3 != 0) goto L_0x01e4;
    L_0x0068:
        r0 = com.baidu.ufosdk.util.C5220m.m17773b(r0);	 Catch:{ Exception -> 0x01ab }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ab }
        r4 = "response is ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x01ab }
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x01ab }
        r3 = r3.toString();	 Catch:{ Exception -> 0x01ab }
        com.baidu.ufosdk.util.C5210c.m17732a(r3);	 Catch:{ Exception -> 0x01ab }
        r3 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01ab }
        r3.<init>(r0);	 Catch:{ Exception -> 0x01ab }
        r0 = "errno";
        r0 = r3.get(r0);	 Catch:{ Exception -> 0x01ab }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x01ab }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x01ab }
        if (r0 != 0) goto L_0x01d1;
    L_0x0093:
        r0 = "FeedbackMsgSender:getHistoryChat()  errNo == 0";
        com.baidu.ufosdk.util.C5210c.m17734b(r0);	 Catch:{ Exception -> 0x01ab }
        r4 = new android.content.Intent;	 Catch:{ Exception -> 0x01ab }
        r0 = "com.baidu.ufosdk.gethistorylist";
        r4.<init>(r0);	 Catch:{ Exception -> 0x01ab }
        r0 = "msgnum";
        r0 = r3.getInt(r0);	 Catch:{ Exception -> 0x01ab }
        if (r0 <= 0) goto L_0x017a;
    L_0x00aa:
        r0 = 0;
        com.baidu.ufosdk.UfoSDK.neverFeedback = r0;	 Catch:{ Exception -> 0x01ab }
        r0 = "UfoSharePreference";
        r5 = 0;
        r0 = r10.getSharedPreferences(r0, r5);	 Catch:{ Exception -> 0x01ab }
        r0 = r0.edit();	 Catch:{ Exception -> 0x01ab }
        r5 = "UfoNeverFeedback";
        r6 = 0;
        r0.putBoolean(r5, r6);	 Catch:{ Exception -> 0x01ab }
        r0.commit();	 Catch:{ Exception -> 0x01ab }
        r5 = new java.util.ArrayList;	 Catch:{ Exception -> 0x01ab }
        r5.<init>();	 Catch:{ Exception -> 0x01ab }
        r0 = "msg";
        r3 = r3.getJSONArray(r0);	 Catch:{ Exception -> 0x01ab }
        r0 = r2;
    L_0x00d0:
        r6 = r3.length();	 Catch:{ Exception -> 0x01ab }
        if (r0 < r6) goto L_0x00f3;
    L_0x00d6:
        r0 = "msgList";
        r4.putExtra(r0, r5);	 Catch:{ Exception -> 0x01ab }
        r10.sendBroadcast(r4);	 Catch:{ Exception -> 0x01ab }
    L_0x00df:
        r0 = new android.content.Intent;
        r2 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r0.<init>(r2);
        r10.sendBroadcast(r0);
        r0 = r1;
    L_0x00eb:
        return r0;
    L_0x00ec:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r3;
        goto L_0x005e;
    L_0x00f3:
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ab }
        r7 = "FeedbackMsgSender:getHistoryChat()  ";
        r6.<init>(r7);	 Catch:{ Exception -> 0x01ab }
        r6 = r6.append(r0);	 Catch:{ Exception -> 0x01ab }
        r7 = " msgArray.getJSONObject(i)--> ";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x01ab }
        r7 = r3.getJSONObject(r0);	 Catch:{ Exception -> 0x01ab }
        r7 = r7.toString();	 Catch:{ Exception -> 0x01ab }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x01ab }
        r6 = r6.toString();	 Catch:{ Exception -> 0x01ab }
        com.baidu.ufosdk.util.C5210c.m17732a(r6);	 Catch:{ Exception -> 0x01ab }
        r6 = new java.util.HashMap;	 Catch:{ Exception -> 0x01ab }
        r6.<init>();	 Catch:{ Exception -> 0x01ab }
        r7 = "id";
        r8 = r3.getJSONObject(r0);	 Catch:{ Exception -> 0x01ab }
        r9 = "id";
        r8 = r8.getString(r9);	 Catch:{ Exception -> 0x01ab }
        r6.put(r7, r8);	 Catch:{ Exception -> 0x01ab }
        r7 = "content";
        r8 = r3.getJSONObject(r0);	 Catch:{ Exception -> 0x01ab }
        r9 = "content";
        r8 = r8.getString(r9);	 Catch:{ Exception -> 0x01ab }
        r6.put(r7, r8);	 Catch:{ Exception -> 0x01ab }
        r7 = "time";
        r8 = r3.getJSONObject(r0);	 Catch:{ Exception -> 0x01ab }
        r9 = "time";
        r8 = r8.getString(r9);	 Catch:{ Exception -> 0x01ab }
        r6.put(r7, r8);	 Catch:{ Exception -> 0x01ab }
        r7 = "newmsg";
        r8 = r3.getJSONObject(r0);	 Catch:{ Exception -> 0x01ab }
        r9 = "newmsg";
        r8 = r8.getString(r9);	 Catch:{ Exception -> 0x01ab }
        r6.put(r7, r8);	 Catch:{ Exception -> 0x01ab }
        r7 = "replied";
        r8 = r3.getJSONObject(r0);	 Catch:{ Exception -> 0x01ab }
        r9 = "replied";
        r8 = r8.getString(r9);	 Catch:{ Exception -> 0x01ab }
        r6.put(r7, r8);	 Catch:{ Exception -> 0x01ab }
        r5.add(r6);	 Catch:{ Exception -> 0x01ab }
        r0 = r0 + 1;
        goto L_0x00d0;
    L_0x017a:
        r0 = 1;
        com.baidu.ufosdk.UfoSDK.neverFeedback = r0;	 Catch:{ Exception -> 0x01ab }
        r0 = "UfoSharePreference";
        r3 = 0;
        r0 = r10.getSharedPreferences(r0, r3);	 Catch:{ Exception -> 0x01ab }
        r0 = r0.edit();	 Catch:{ Exception -> 0x01ab }
        r3 = "UfoNeverFeedback";
        r5 = 1;
        r0.putBoolean(r3, r5);	 Catch:{ Exception -> 0x01ab }
        r0.commit();	 Catch:{ Exception -> 0x01ab }
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x01ab }
        r0.<init>();	 Catch:{ Exception -> 0x01ab }
        r3 = new android.os.Bundle;	 Catch:{ Exception -> 0x01ab }
        r3.<init>();	 Catch:{ Exception -> 0x01ab }
        r5 = "msgList";
        r3.putParcelableArrayList(r5, r0);	 Catch:{ Exception -> 0x01ab }
        r4.putExtras(r3);	 Catch:{ Exception -> 0x01ab }
        r10.sendBroadcast(r4);	 Catch:{ Exception -> 0x01ab }
        goto L_0x00df;
    L_0x01ab:
        r0 = move-exception;
        r1 = "sendRecord fail.";
        com.baidu.ufosdk.util.C5210c.m17733a(r1, r0);	 Catch:{ all -> 0x01f0 }
        android.os.Looper.prepare();	 Catch:{ all -> 0x01f0 }
        r0 = new android.content.Intent;	 Catch:{ all -> 0x01f0 }
        r1 = "com.baidu.ufosdk.reload";
        r0.<init>(r1);	 Catch:{ all -> 0x01f0 }
        r10.sendBroadcast(r0);	 Catch:{ all -> 0x01f0 }
        android.os.Looper.loop();	 Catch:{ all -> 0x01f0 }
        r0 = new android.content.Intent;
        r1 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r0.<init>(r1);
        r10.sendBroadcast(r0);
    L_0x01ce:
        r0 = r2;
        goto L_0x00eb;
    L_0x01d1:
        if (r0 == 0) goto L_0x01e4;
    L_0x01d3:
        r0 = "FeedbackMsgSender:getHistoryChat() errNo != 0";
        com.baidu.ufosdk.util.C5210c.m17734b(r0);	 Catch:{ Exception -> 0x01ab }
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x01ab }
        r1 = "com.baidu.ufosdk.reload";
        r0.<init>(r1);	 Catch:{ Exception -> 0x01ab }
        r10.sendBroadcast(r0);	 Catch:{ Exception -> 0x01ab }
    L_0x01e4:
        r0 = new android.content.Intent;
        r1 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r0.<init>(r1);
        r10.sendBroadcast(r0);
        goto L_0x01ce;
    L_0x01f0:
        r0 = move-exception;
        r1 = new android.content.Intent;
        r2 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r1.<init>(r2);
        r10.sendBroadcast(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ufosdk.e.a.b(android.content.Context):boolean");
    }

    /* renamed from: c */
    public static String m17574c(Context context) {
        String str;
        String str2 = C5167a.av;
        C5210c.m17734b("postUrl is " + str2);
        Map hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        hashMap.put(SpeechConstant.APP_ID, UfoSDK.appid);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("uid", C5167a.f21356b);
        hashMap.put(Key.INTERVAL, String.valueOf(C5167a.ao));
        String str3 = "";
        try {
            str = "sdk_encrypt=" + URLEncoder.encode(C5220m.m17770a(C5174a.m17564a(hashMap)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            str = str3;
        }
        try {
            Object a = C5181b.m17578a(str2, str);
            if (!TextUtils.isEmpty(a)) {
                str = C5220m.m17773b(a);
                C5210c.m17732a("response is " + str);
                JSONObject jSONObject = new JSONObject(str);
                C5210c.m17732a("response is " + jSONObject.toString());
                if (((Integer) jSONObject.get(C2125n.f6745M)).intValue() == 0) {
                    if (((Integer) jSONObject.get("newmsg")).intValue() > 0) {
                        context.sendBroadcast(new Intent("com.baidu.ufosdk.getnewhistoryflag"));
                    }
                    if (((Integer) jSONObject.get("update")).intValue() == 1) {
                        C5167a.ao = ((Integer) jSONObject.get(Key.INTERVAL)).intValue();
                    }
                    return String.valueOf(jSONObject.get("newmsg"));
                }
            }
        } catch (Throwable e2) {
            C5210c.m17733a("sendRecord fail.", e2);
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m17570a(Context context, String str) {
        String str2;
        CharSequence charSequence = "删除失败，请稍后重试。";
        String str3 = C5167a.ax;
        Map hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        hashMap.put(SpeechConstant.APP_ID, UfoSDK.appid);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("uid", C5167a.f21356b);
        hashMap.put("id", str);
        String str4 = "";
        try {
            str2 = "sdk_encrypt=" + URLEncoder.encode(C5220m.m17770a(C5174a.m17564a(hashMap)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            str2 = str4;
        }
        try {
            Object a = C5181b.m17578a(str3, str2);
            if (!TextUtils.isEmpty(a)) {
                if (((Integer) new JSONObject(C5220m.m17773b(a)).get(C2125n.f6745M)).intValue() == 0) {
                    context.sendBroadcast(new Intent("com.baidu.ufosdk.getappkeysuccess_getnewhistoryflag"));
                    return true;
                }
                context.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                Looper.prepare();
                Toast.makeText(context, charSequence, 1).show();
                Looper.loop();
            }
        } catch (Throwable e2) {
            C5210c.m17733a("sendRecord fail.", e2);
            context.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
            Looper.prepare();
            Toast.makeText(context, charSequence, 1).show();
            Looper.loop();
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public static boolean m17573b(android.content.Context r9, java.lang.String r10) {
        /*
        r1 = 0;
        r3 = com.baidu.ufosdk.C5167a.ap;
        r0 = new java.util.HashMap;
        r0.<init>();
        r2 = "appid";
        r4 = com.baidu.ufosdk.UfoSDK.appid;
        r0.put(r2, r4);
        r2 = "appvn";
        r4 = com.baidu.ufosdk.p248b.C5171d.m17561c();
        r0.put(r2, r4);
        r2 = "baiducuid";
        r4 = com.baidu.ufosdk.C5167a.f21357c;
        r0.put(r2, r4);
        r2 = "clientid";
        r4 = com.baidu.ufosdk.UfoSDK.clientid;
        r0.put(r2, r4);
        r2 = "devid";
        r4 = com.baidu.ufosdk.UfoSDK.devid;
        r0.put(r2, r4);
        r2 = "extra";
        r4 = com.baidu.ufosdk.C5167a.f21358d;
        r0.put(r2, r4);
        r2 = "id";
        r0.put(r2, r10);
        r2 = "interval";
        r4 = com.baidu.ufosdk.C5167a.an;
        r4 = java.lang.String.valueOf(r4);
        r0.put(r2, r4);
        r2 = "model";
        r4 = android.os.Build.MODEL;
        r0.put(r2, r4);
        r2 = "os";
        r4 = "android";
        r0.put(r2, r4);
        r2 = "sdkvn";
        r4 = com.baidu.ufosdk.p248b.C5171d.m17561c();
        r0.put(r2, r4);
        r2 = "uid";
        r4 = com.baidu.ufosdk.C5167a.f21356b;
        r0.put(r2, r4);
        r0 = com.baidu.ufosdk.p249c.C5174a.m17564a(r0);
        r0 = com.baidu.ufosdk.util.C5220m.m17770a(r0);
        r2 = "";
        r4 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0108 }
        r5 = "sdk_encrypt=";
        r4.<init>(r5);	 Catch:{ UnsupportedEncodingException -> 0x0108 }
        r5 = "UTF-8";
        r0 = java.net.URLEncoder.encode(r0, r5);	 Catch:{ UnsupportedEncodingException -> 0x0108 }
        r0 = r4.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0108 }
        r0 = r0.toString();	 Catch:{ UnsupportedEncodingException -> 0x0108 }
    L_0x0091:
        r0 = com.baidu.ufosdk.p251e.C5181b.m17578a(r3, r0);	 Catch:{ Exception -> 0x0191 }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0191 }
        if (r2 != 0) goto L_0x01c4;
    L_0x009b:
        r0 = com.baidu.ufosdk.util.C5220m.m17773b(r0);	 Catch:{ Exception -> 0x0191 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0191 }
        r3 = "response is ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0191 }
        r2 = r2.append(r0);	 Catch:{ Exception -> 0x0191 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0191 }
        com.baidu.ufosdk.util.C5210c.m17732a(r2);	 Catch:{ Exception -> 0x0191 }
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0191 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0191 }
        r0 = "errno";
        r0 = r2.get(r0);	 Catch:{ Exception -> 0x0191 }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x0191 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0191 }
        if (r0 != 0) goto L_0x01b7;
    L_0x00c6:
        r3 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0191 }
        r3.<init>();	 Catch:{ Exception -> 0x0191 }
        r4 = new android.content.Intent;	 Catch:{ Exception -> 0x0191 }
        r0 = "com.baidu.ufosdk.getchat";
        r4.<init>(r0);	 Catch:{ Exception -> 0x0191 }
        r0 = "msgnum";
        r0 = r2.getInt(r0);	 Catch:{ Exception -> 0x0191 }
        if (r0 <= 0) goto L_0x00fb;
    L_0x00dc:
        r0 = "msg";
        r5 = r2.getJSONArray(r0);	 Catch:{ Exception -> 0x0191 }
        r2 = r1;
    L_0x00e4:
        r0 = r5.length();	 Catch:{ Exception -> 0x0191 }
        if (r2 < r0) goto L_0x010e;
    L_0x00ea:
        r0 = new android.os.Bundle;	 Catch:{ Exception -> 0x0191 }
        r0.<init>();	 Catch:{ Exception -> 0x0191 }
        r2 = "msgList";
        r0.putParcelableArrayList(r2, r3);	 Catch:{ Exception -> 0x0191 }
        r4.putExtras(r0);	 Catch:{ Exception -> 0x0191 }
        r9.sendBroadcast(r4);	 Catch:{ Exception -> 0x0191 }
    L_0x00fb:
        r0 = new android.content.Intent;
        r1 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r0.<init>(r1);
        r9.sendBroadcast(r0);
        r0 = 1;
    L_0x0107:
        return r0;
    L_0x0108:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r2;
        goto L_0x0091;
    L_0x010e:
        r6 = new java.util.HashMap;	 Catch:{ Exception -> 0x0191 }
        r6.<init>();	 Catch:{ Exception -> 0x0191 }
        r0 = "id";
        r6.put(r0, r10);	 Catch:{ Exception -> 0x0191 }
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0191 }
        r7 = r5.getJSONObject(r2);	 Catch:{ Exception -> 0x0191 }
        r8 = "extra";
        r7 = r7.getString(r8);	 Catch:{ Exception -> 0x0191 }
        r0.<init>(r7);	 Catch:{ Exception -> 0x0191 }
        r7 = "answer";
        r7 = r0.has(r7);	 Catch:{ Exception -> 0x0191 }
        if (r7 == 0) goto L_0x0186;
    L_0x0132:
        r7 = "answer";
        r0 = r0.getString(r7);	 Catch:{ Exception -> 0x0191 }
    L_0x0139:
        r7 = r0.length();	 Catch:{ Exception -> 0x0191 }
        if (r7 == 0) goto L_0x0153;
    L_0x013f:
        r7 = "";
        r7 = r0.equals(r7);	 Catch:{ Exception -> 0x0191 }
        if (r7 != 0) goto L_0x0153;
    L_0x0148:
        r7 = "null";
        r7 = r0.equals(r7);	 Catch:{ Exception -> 0x0191 }
        if (r7 != 0) goto L_0x0153;
    L_0x0151:
        if (r0 != 0) goto L_0x018a;
    L_0x0153:
        r0 = "content";
        r7 = r5.getJSONObject(r2);	 Catch:{ Exception -> 0x0191 }
        r8 = "content";
        r7 = r7.getString(r8);	 Catch:{ Exception -> 0x0191 }
        r6.put(r0, r7);	 Catch:{ Exception -> 0x0191 }
    L_0x0164:
        r0 = "toggle";
        r7 = "yes";
        r6.put(r0, r7);	 Catch:{ Exception -> 0x0191 }
        r0 = "time";
        r7 = r5.getJSONObject(r2);	 Catch:{ Exception -> 0x0191 }
        r8 = "time";
        r7 = r7.getString(r8);	 Catch:{ Exception -> 0x0191 }
        r6.put(r0, r7);	 Catch:{ Exception -> 0x0191 }
        r3.add(r6);	 Catch:{ Exception -> 0x0191 }
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x00e4;
    L_0x0186:
        r0 = "";
        goto L_0x0139;
    L_0x018a:
        r7 = "content";
        r6.put(r7, r0);	 Catch:{ Exception -> 0x0191 }
        goto L_0x0164;
    L_0x0191:
        r0 = move-exception;
        r2 = "sendRecord fail.";
        com.baidu.ufosdk.util.C5210c.m17733a(r2, r0);	 Catch:{ all -> 0x01d0 }
        android.os.Looper.prepare();	 Catch:{ all -> 0x01d0 }
        r0 = new android.content.Intent;	 Catch:{ all -> 0x01d0 }
        r2 = "com.baidu.ufosdk.reload";
        r0.<init>(r2);	 Catch:{ all -> 0x01d0 }
        r9.sendBroadcast(r0);	 Catch:{ all -> 0x01d0 }
        android.os.Looper.loop();	 Catch:{ all -> 0x01d0 }
        r0 = new android.content.Intent;
        r2 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r0.<init>(r2);
        r9.sendBroadcast(r0);
    L_0x01b4:
        r0 = r1;
        goto L_0x0107;
    L_0x01b7:
        if (r0 == 0) goto L_0x01c4;
    L_0x01b9:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x0191 }
        r2 = "com.baidu.ufosdk.reload";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0191 }
        r9.sendBroadcast(r0);	 Catch:{ Exception -> 0x0191 }
    L_0x01c4:
        r0 = new android.content.Intent;
        r2 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r0.<init>(r2);
        r9.sendBroadcast(r0);
        goto L_0x01b4;
    L_0x01d0:
        r0 = move-exception;
        r1 = new android.content.Intent;
        r2 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r1.<init>(r2);
        r9.sendBroadcast(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ufosdk.e.a.b(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public static boolean m17575c(android.content.Context r12, java.lang.String r13) {
        /*
        r1 = 1;
        r2 = 0;
        r4 = com.baidu.ufosdk.C5167a.ap;
        r0 = new java.lang.StringBuilder;
        r3 = "postUrl is ";
        r0.<init>(r3);
        r0 = r0.append(r4);
        r0 = r0.toString();
        com.baidu.ufosdk.util.C5210c.m17734b(r0);
        r0 = new java.util.HashMap;
        r0.<init>();
        r3 = "clientid";
        r5 = com.baidu.ufosdk.UfoSDK.clientid;
        r0.put(r3, r5);
        r3 = "appid";
        r5 = com.baidu.ufosdk.UfoSDK.appid;
        r0.put(r3, r5);
        r3 = "devid";
        r5 = com.baidu.ufosdk.UfoSDK.devid;
        r0.put(r3, r5);
        r3 = "msgid";
        r0.put(r3, r13);
        r3 = "interval";
        r5 = com.baidu.ufosdk.C5167a.an;
        r5 = java.lang.String.valueOf(r5);
        r0.put(r3, r5);
        r0 = com.baidu.ufosdk.p249c.C5174a.m17564a(r0);
        r0 = com.baidu.ufosdk.util.C5220m.m17770a(r0);
        r3 = "";
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x00fd }
        r6 = "sdk_encrypt=";
        r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x00fd }
        r6 = "UTF-8";
        r0 = java.net.URLEncoder.encode(r0, r6);	 Catch:{ UnsupportedEncodingException -> 0x00fd }
        r0 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x00fd }
        r0 = r0.toString();	 Catch:{ UnsupportedEncodingException -> 0x00fd }
    L_0x0068:
        r0 = com.baidu.ufosdk.p251e.C5181b.m17578a(r4, r0);	 Catch:{ Exception -> 0x01d6 }
        r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x01d6 }
        if (r3 != 0) goto L_0x023a;
    L_0x0072:
        r0 = com.baidu.ufosdk.util.C5220m.m17773b(r0);	 Catch:{ Exception -> 0x01d6 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01d6 }
        r4 = "---getFeedbackChat---response is ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x01d6 }
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x01d6 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x01d6 }
        com.baidu.ufosdk.util.C5210c.m17732a(r3);	 Catch:{ Exception -> 0x01d6 }
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01d6 }
        r4.<init>(r0);	 Catch:{ Exception -> 0x01d6 }
        r0 = "errno";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x01d6 }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x01d6 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x01d6 }
        if (r0 != 0) goto L_0x022d;
    L_0x009d:
        r5 = new java.util.ArrayList;	 Catch:{ Exception -> 0x01d6 }
        r5.<init>();	 Catch:{ Exception -> 0x01d6 }
        r6 = new android.content.Intent;	 Catch:{ Exception -> 0x01d6 }
        r0 = "com.baidu.ufosdk.getchat";
        r6.<init>(r0);	 Catch:{ Exception -> 0x01d6 }
        r0 = "msgnum";
        r0 = r4.getInt(r0);	 Catch:{ Exception -> 0x01d6 }
        if (r0 <= 0) goto L_0x00d2;
    L_0x00b3:
        r0 = "msg";
        r7 = r4.getJSONArray(r0);	 Catch:{ Exception -> 0x01d6 }
        r3 = r2;
    L_0x00bb:
        r0 = r7.length();	 Catch:{ Exception -> 0x01d6 }
        if (r3 < r0) goto L_0x0104;
    L_0x00c1:
        r0 = new android.os.Bundle;	 Catch:{ Exception -> 0x01d6 }
        r0.<init>();	 Catch:{ Exception -> 0x01d6 }
        r3 = "msgList";
        r0.putParcelableArrayList(r3, r5);	 Catch:{ Exception -> 0x01d6 }
        r6.putExtras(r0);	 Catch:{ Exception -> 0x01d6 }
        r12.sendBroadcast(r6);	 Catch:{ Exception -> 0x01d6 }
    L_0x00d2:
        r0 = "update";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x01d6 }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x01d6 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x01d6 }
        if (r0 != r1) goto L_0x00f0;
    L_0x00e1:
        r0 = "interval";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x01d6 }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x01d6 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x01d6 }
        com.baidu.ufosdk.C5167a.an = r0;	 Catch:{ Exception -> 0x01d6 }
    L_0x00f0:
        r0 = new android.content.Intent;
        r2 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r0.<init>(r2);
        r12.sendBroadcast(r0);
        r0 = r1;
    L_0x00fc:
        return r0;
    L_0x00fd:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r3;
        goto L_0x0068;
    L_0x0104:
        r8 = new java.util.HashMap;	 Catch:{ Exception -> 0x01d6 }
        r8.<init>();	 Catch:{ Exception -> 0x01d6 }
        r0 = "id";
        r8.put(r0, r13);	 Catch:{ Exception -> 0x01d6 }
        r0 = r7.getJSONObject(r3);	 Catch:{ Exception -> 0x01d6 }
        r9 = "extra";
        r0 = r0.getString(r9);	 Catch:{ Exception -> 0x01d6 }
        r9 = r0.length();	 Catch:{ Exception -> 0x01d6 }
        if (r9 == 0) goto L_0x0122;
    L_0x0120:
        if (r0 != 0) goto L_0x0180;
    L_0x0122:
        r0 = "content";
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01d6 }
        r10 = r7.getJSONObject(r3);	 Catch:{ Exception -> 0x01d6 }
        r11 = "content";
        r10 = r10.getString(r11);	 Catch:{ Exception -> 0x01d6 }
        r10 = java.lang.String.valueOf(r10);	 Catch:{ Exception -> 0x01d6 }
        r9.<init>(r10);	 Catch:{ Exception -> 0x01d6 }
        r10 = "您可到我的反馈中查看。";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x01d6 }
        r9 = r9.toString();	 Catch:{ Exception -> 0x01d6 }
        r8.put(r0, r9);	 Catch:{ Exception -> 0x01d6 }
        r0 = "toggle";
        r9 = "no";
        r8.put(r0, r9);	 Catch:{ Exception -> 0x01d6 }
    L_0x0150:
        r0 = "time";
        r9 = r7.getJSONObject(r3);	 Catch:{ Exception -> 0x01d6 }
        r10 = "time";
        r9 = r9.getString(r10);	 Catch:{ Exception -> 0x01d6 }
        r8.put(r0, r9);	 Catch:{ Exception -> 0x01d6 }
        r5.add(r8);	 Catch:{ Exception -> 0x01d6 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01d6 }
        r8 = "^^^getFeedbackChat^^^";
        r0.<init>(r8);	 Catch:{ Exception -> 0x01d6 }
        r8 = r5.toString();	 Catch:{ Exception -> 0x01d6 }
        r0 = r0.append(r8);	 Catch:{ Exception -> 0x01d6 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x01d6 }
        com.baidu.ufosdk.util.C5210c.m17732a(r0);	 Catch:{ Exception -> 0x01d6 }
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x00bb;
    L_0x0180:
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01d6 }
        r9 = r7.getJSONObject(r3);	 Catch:{ Exception -> 0x01d6 }
        r10 = "extra";
        r9 = r9.getString(r10);	 Catch:{ Exception -> 0x01d6 }
        r0.<init>(r9);	 Catch:{ Exception -> 0x01d6 }
        r9 = "answer";
        r9 = r0.has(r9);	 Catch:{ Exception -> 0x01d6 }
        if (r9 == 0) goto L_0x01fc;
    L_0x0199:
        r9 = "answer";
        r0 = r0.getString(r9);	 Catch:{ Exception -> 0x01d6 }
    L_0x01a0:
        r9 = r0.length();	 Catch:{ Exception -> 0x01d6 }
        if (r9 == 0) goto L_0x01ba;
    L_0x01a6:
        r9 = "";
        r9 = r0.equals(r9);	 Catch:{ Exception -> 0x01d6 }
        if (r9 != 0) goto L_0x01ba;
    L_0x01af:
        r9 = "null";
        r9 = r0.equals(r9);	 Catch:{ Exception -> 0x01d6 }
        if (r9 != 0) goto L_0x01ba;
    L_0x01b8:
        if (r0 != 0) goto L_0x0200;
    L_0x01ba:
        r0 = "content";
        r9 = r7.getJSONObject(r3);	 Catch:{ Exception -> 0x01d6 }
        r10 = "content";
        r9 = r9.getString(r10);	 Catch:{ Exception -> 0x01d6 }
        r8.put(r0, r9);	 Catch:{ Exception -> 0x01d6 }
        r0 = "toggle";
        r9 = "no";
        r8.put(r0, r9);	 Catch:{ Exception -> 0x01d6 }
        goto L_0x0150;
    L_0x01d6:
        r0 = move-exception;
        r1 = "sendRecord fail.";
        com.baidu.ufosdk.util.C5210c.m17733a(r1, r0);	 Catch:{ all -> 0x0215 }
        android.os.Looper.prepare();	 Catch:{ all -> 0x0215 }
        r0 = new android.content.Intent;	 Catch:{ all -> 0x0215 }
        r1 = "com.baidu.ufosdk.reload";
        r0.<init>(r1);	 Catch:{ all -> 0x0215 }
        r12.sendBroadcast(r0);	 Catch:{ all -> 0x0215 }
        android.os.Looper.loop();	 Catch:{ all -> 0x0215 }
        r0 = new android.content.Intent;
        r1 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r0.<init>(r1);
        r12.sendBroadcast(r0);
    L_0x01f9:
        r0 = r2;
        goto L_0x00fc;
    L_0x01fc:
        r0 = "";
        goto L_0x01a0;
    L_0x0200:
        r9 = "content";
        r8.put(r9, r0);	 Catch:{ Exception -> 0x01d6 }
        r0 = com.baidu.ufosdk.UfoSDK.robotAnswer;	 Catch:{ Exception -> 0x01d6 }
        if (r0 == 0) goto L_0x0222;
    L_0x020a:
        r0 = "toggle";
        r9 = "yes";
        r8.put(r0, r9);	 Catch:{ Exception -> 0x01d6 }
        goto L_0x0150;
    L_0x0215:
        r0 = move-exception;
        r1 = new android.content.Intent;
        r2 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r1.<init>(r2);
        r12.sendBroadcast(r1);
        throw r0;
    L_0x0222:
        r0 = "toggle";
        r9 = "no";
        r8.put(r0, r9);	 Catch:{ Exception -> 0x01d6 }
        goto L_0x0150;
    L_0x022d:
        if (r0 == 0) goto L_0x023a;
    L_0x022f:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x01d6 }
        r1 = "com.baidu.ufosdk.reload";
        r0.<init>(r1);	 Catch:{ Exception -> 0x01d6 }
        r12.sendBroadcast(r0);	 Catch:{ Exception -> 0x01d6 }
    L_0x023a:
        r0 = new android.content.Intent;
        r1 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r0.<init>(r1);
        r12.sendBroadcast(r0);
        goto L_0x01f9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ufosdk.e.a.c(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static boolean m17571a(String str, String str2) {
        String str3;
        String str4 = null;
        String str5 = C5167a.aq;
        C5210c.m17734b("FeedbackChatSender --> sendSolvedResult:" + str2);
        Map hashMap = new HashMap();
        hashMap.put(SpeechConstant.APP_ID, UfoSDK.appid);
        hashMap.put("id", str);
        hashMap.put("robotReplyUseful", str2);
        String str6 = "";
        try {
            str3 = "sdk_encrypt=" + URLEncoder.encode(C5220m.m17770a(C5174a.m17564a(hashMap)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            str3 = str6;
        }
        try {
            Object a = C5181b.m17578a(str5, str3);
            if (TextUtils.isEmpty(a)) {
                C5210c.m17736d("finally");
                return str4;
            }
            str3 = C5220m.m17773b(a);
            C5210c.m17735c("^^ FeedbackMsgSender sendSolvedResult response is: \n" + str3);
            if (((Integer) new JSONObject(str3).get(C2125n.f6745M)).intValue() == 0) {
                return true;
            }
            C5210c.m17736d("finally");
            return false;
        } catch (Throwable e2) {
            C5210c.m17733a("sendRecord fail.", e2);
        } finally {
            str4 = "finally";
            C5210c.m17736d(str4);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public static boolean m17576d(android.content.Context r11, java.lang.String r12) {
        /*
        r1 = 1;
        r2 = 0;
        r4 = com.baidu.ufosdk.C5167a.ap;
        r0 = new java.lang.StringBuilder;
        r3 = "postUrl is ";
        r0.<init>(r3);
        r0 = r0.append(r4);
        r0 = r0.toString();
        com.baidu.ufosdk.util.C5210c.m17734b(r0);
        r0 = new java.util.HashMap;
        r0.<init>();
        r3 = "clientid";
        r5 = com.baidu.ufosdk.UfoSDK.clientid;
        r0.put(r3, r5);
        r3 = "appid";
        r5 = com.baidu.ufosdk.UfoSDK.appid;
        r0.put(r3, r5);
        r3 = "devid";
        r5 = com.baidu.ufosdk.UfoSDK.devid;
        r0.put(r3, r5);
        r3 = "msgid";
        r0.put(r3, r12);
        r3 = "interval";
        r5 = com.baidu.ufosdk.C5167a.an;
        r5 = java.lang.String.valueOf(r5);
        r0.put(r3, r5);
        r0 = com.baidu.ufosdk.p249c.C5174a.m17564a(r0);
        r0 = com.baidu.ufosdk.util.C5220m.m17770a(r0);
        r3 = "";
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x00fd }
        r6 = "sdk_encrypt=";
        r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x00fd }
        r6 = "UTF-8";
        r0 = java.net.URLEncoder.encode(r0, r6);	 Catch:{ UnsupportedEncodingException -> 0x00fd }
        r0 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x00fd }
        r0 = r0.toString();	 Catch:{ UnsupportedEncodingException -> 0x00fd }
    L_0x0068:
        r0 = com.baidu.ufosdk.p251e.C5181b.m17578a(r4, r0);	 Catch:{ Exception -> 0x017a }
        r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x017a }
        if (r3 != 0) goto L_0x021c;
    L_0x0072:
        r0 = com.baidu.ufosdk.util.C5220m.m17773b(r0);	 Catch:{ Exception -> 0x017a }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x017a }
        r4 = "response is ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x017a }
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x017a }
        r3 = r3.toString();	 Catch:{ Exception -> 0x017a }
        com.baidu.ufosdk.util.C5210c.m17732a(r3);	 Catch:{ Exception -> 0x017a }
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x017a }
        r4.<init>(r0);	 Catch:{ Exception -> 0x017a }
        r0 = "errno";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x017a }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x017a }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x017a }
        if (r0 != 0) goto L_0x020f;
    L_0x009d:
        r5 = new java.util.ArrayList;	 Catch:{ Exception -> 0x017a }
        r5.<init>();	 Catch:{ Exception -> 0x017a }
        r6 = new android.content.Intent;	 Catch:{ Exception -> 0x017a }
        r0 = "com.baidu.ufosdk.getchat";
        r6.<init>(r0);	 Catch:{ Exception -> 0x017a }
        r0 = "msgnum";
        r0 = r4.getInt(r0);	 Catch:{ Exception -> 0x017a }
        if (r0 <= 0) goto L_0x00d2;
    L_0x00b3:
        r0 = "msg";
        r7 = r4.getJSONArray(r0);	 Catch:{ Exception -> 0x017a }
        r3 = r2;
    L_0x00bb:
        r0 = r7.length();	 Catch:{ Exception -> 0x017a }
        if (r3 < r0) goto L_0x0104;
    L_0x00c1:
        r0 = new android.os.Bundle;	 Catch:{ Exception -> 0x017a }
        r0.<init>();	 Catch:{ Exception -> 0x017a }
        r3 = "msgList";
        r0.putParcelableArrayList(r3, r5);	 Catch:{ Exception -> 0x017a }
        r6.putExtras(r0);	 Catch:{ Exception -> 0x017a }
        r11.sendBroadcast(r6);	 Catch:{ Exception -> 0x017a }
    L_0x00d2:
        r0 = "update";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x017a }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x017a }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x017a }
        if (r0 != r1) goto L_0x00f0;
    L_0x00e1:
        r0 = "interval";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x017a }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x017a }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x017a }
        com.baidu.ufosdk.C5167a.an = r0;	 Catch:{ Exception -> 0x017a }
    L_0x00f0:
        r0 = new android.content.Intent;
        r2 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r0.<init>(r2);
        r11.sendBroadcast(r0);
        r0 = r1;
    L_0x00fc:
        return r0;
    L_0x00fd:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r3;
        goto L_0x0068;
    L_0x0104:
        r8 = new java.util.HashMap;	 Catch:{ Exception -> 0x017a }
        r8.<init>();	 Catch:{ Exception -> 0x017a }
        r0 = "id";
        r8.put(r0, r12);	 Catch:{ Exception -> 0x017a }
        r0 = r7.getJSONObject(r3);	 Catch:{ Exception -> 0x017a }
        r9 = "extra";
        r0 = r0.getString(r9);	 Catch:{ Exception -> 0x017a }
        r9 = r0.length();	 Catch:{ Exception -> 0x017a }
        if (r9 == 0) goto L_0x0122;
    L_0x0120:
        if (r0 != 0) goto L_0x01a0;
    L_0x0122:
        r0 = "content";
        r9 = r7.getJSONObject(r3);	 Catch:{ Exception -> 0x017a }
        r10 = "content";
        r9 = r9.getString(r10);	 Catch:{ Exception -> 0x017a }
        r8.put(r0, r9);	 Catch:{ Exception -> 0x017a }
        r0 = com.baidu.ufosdk.UfoSDK.robotAnswer;	 Catch:{ Exception -> 0x017a }
        if (r0 == 0) goto L_0x0170;
    L_0x0137:
        r0 = "toggle";
        r9 = "yes";
        r8.put(r0, r9);	 Catch:{ Exception -> 0x017a }
    L_0x0140:
        r0 = "time";
        r9 = r7.getJSONObject(r3);	 Catch:{ Exception -> 0x017a }
        r10 = "time";
        r9 = r9.getString(r10);	 Catch:{ Exception -> 0x017a }
        r8.put(r0, r9);	 Catch:{ Exception -> 0x017a }
        r5.add(r8);	 Catch:{ Exception -> 0x017a }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x017a }
        r8 = "^^^getFeedbackChatBack^^^";
        r0.<init>(r8);	 Catch:{ Exception -> 0x017a }
        r8 = r5.toString();	 Catch:{ Exception -> 0x017a }
        r0 = r0.append(r8);	 Catch:{ Exception -> 0x017a }
        r0 = r0.toString();	 Catch:{ Exception -> 0x017a }
        com.baidu.ufosdk.util.C5210c.m17732a(r0);	 Catch:{ Exception -> 0x017a }
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x00bb;
    L_0x0170:
        r0 = "toggle";
        r9 = "no";
        r8.put(r0, r9);	 Catch:{ Exception -> 0x017a }
        goto L_0x0140;
    L_0x017a:
        r0 = move-exception;
        r1 = "sendRecord fail.";
        com.baidu.ufosdk.util.C5210c.m17733a(r1, r0);	 Catch:{ all -> 0x01f6 }
        android.os.Looper.prepare();	 Catch:{ all -> 0x01f6 }
        r0 = new android.content.Intent;	 Catch:{ all -> 0x01f6 }
        r1 = "com.baidu.ufosdk.reload";
        r0.<init>(r1);	 Catch:{ all -> 0x01f6 }
        r11.sendBroadcast(r0);	 Catch:{ all -> 0x01f6 }
        android.os.Looper.loop();	 Catch:{ all -> 0x01f6 }
        r0 = new android.content.Intent;
        r1 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r0.<init>(r1);
        r11.sendBroadcast(r0);
    L_0x019d:
        r0 = r2;
        goto L_0x00fc;
    L_0x01a0:
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x017a }
        r9 = r7.getJSONObject(r3);	 Catch:{ Exception -> 0x017a }
        r10 = "extra";
        r9 = r9.getString(r10);	 Catch:{ Exception -> 0x017a }
        r0.<init>(r9);	 Catch:{ Exception -> 0x017a }
        r9 = "answer";
        r9 = r0.has(r9);	 Catch:{ Exception -> 0x017a }
        if (r9 == 0) goto L_0x0203;
    L_0x01b9:
        r9 = "answer";
        r0 = r0.getString(r9);	 Catch:{ Exception -> 0x017a }
    L_0x01c0:
        r9 = r0.length();	 Catch:{ Exception -> 0x017a }
        if (r9 == 0) goto L_0x01da;
    L_0x01c6:
        r9 = "";
        r9 = r0.equals(r9);	 Catch:{ Exception -> 0x017a }
        if (r9 != 0) goto L_0x01da;
    L_0x01cf:
        r9 = "null";
        r9 = r0.equals(r9);	 Catch:{ Exception -> 0x017a }
        if (r9 != 0) goto L_0x01da;
    L_0x01d8:
        if (r0 != 0) goto L_0x0207;
    L_0x01da:
        r0 = "content";
        r9 = r7.getJSONObject(r3);	 Catch:{ Exception -> 0x017a }
        r10 = "content";
        r9 = r9.getString(r10);	 Catch:{ Exception -> 0x017a }
        r8.put(r0, r9);	 Catch:{ Exception -> 0x017a }
        r0 = "toggle";
        r9 = "no";
        r8.put(r0, r9);	 Catch:{ Exception -> 0x017a }
        goto L_0x0140;
    L_0x01f6:
        r0 = move-exception;
        r1 = new android.content.Intent;
        r2 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r1.<init>(r2);
        r11.sendBroadcast(r1);
        throw r0;
    L_0x0203:
        r0 = "";
        goto L_0x01c0;
    L_0x0207:
        r9 = "content";
        r8.put(r9, r0);	 Catch:{ Exception -> 0x017a }
        goto L_0x0140;
    L_0x020f:
        if (r0 == 0) goto L_0x021c;
    L_0x0211:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x017a }
        r1 = "com.baidu.ufosdk.reload";
        r0.<init>(r1);	 Catch:{ Exception -> 0x017a }
        r11.sendBroadcast(r0);	 Catch:{ Exception -> 0x017a }
    L_0x021c:
        r0 = new android.content.Intent;
        r1 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        r0.<init>(r1);
        r11.sendBroadcast(r0);
        goto L_0x019d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ufosdk.e.a.d(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: e */
    public static String m17577e(Context context, String str) {
        String str2;
        String str3 = C5167a.ar;
        C5210c.m17734b("postUrl is " + str3);
        Map hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        hashMap.put(SpeechConstant.APP_ID, UfoSDK.appid);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("id", str);
        String str4 = "";
        try {
            str2 = "sdk_encrypt=" + URLEncoder.encode(C5220m.m17770a(C5174a.m17564a(hashMap)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            str2 = str4;
        }
        try {
            Object a = C5181b.m17578a(str3, str2);
            if (!TextUtils.isEmpty(a)) {
                str2 = C5220m.m17773b(a);
                C5210c.m17732a("response is " + str2);
                JSONObject jSONObject = new JSONObject(str2);
                int intValue = ((Integer) jSONObject.get(C2125n.f6745M)).intValue();
                if (intValue == 0 && jSONObject.getInt("msgnum") > 0) {
                    return jSONObject.getJSONArray("msg").toString();
                }
                if (intValue != 0) {
                    context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                }
            }
        } catch (Throwable e2) {
            C5210c.m17733a("sendRecord fail.", e2);
            Looper.prepare();
            context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
            Looper.loop();
        }
        return null;
    }
}
