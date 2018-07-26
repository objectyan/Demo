package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.hardware.Sensor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.navi.protocol.model.UpdateDeviceStatusDataStruct;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.indooratlas.android.sdk.BuildConfig;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocation.Builder;
import com.indooratlas.android.sdk._internal.ar.C5767b;
import com.indooratlas.android.sdk._internal.ar.C5768c;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ct {

    /* renamed from: com.indooratlas.android.sdk._internal.ct$1 */
    public static class C58441 extends AsyncTask {
        /* renamed from: a */
        final /* synthetic */ cj f23353a;
        /* renamed from: b */
        final /* synthetic */ int f23354b = 100;
        /* renamed from: c */
        final /* synthetic */ ac f23355c;
        /* renamed from: d */
        final /* synthetic */ String f23356d;

        public C58441(cj cjVar, ac acVar, String str) {
            this.f23353a = cjVar;
            this.f23355c = acVar;
            this.f23356d = str;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final java.lang.Object doInBackground(java.lang.Object[] r8) {
            /*
            r7 = this;
            r6 = 0;
            r2 = 1;
            r4 = 0;
            r1 = com.indooratlas.android.sdk._internal.ci.m20217a();
            r0 = r7.f23353a;
            com.indooratlas.android.sdk._internal.ci.C5836a.m20213a(r0, r1);
            r0 = r7.f23353a;
            r2 = new java.lang.String[r2];
            r3 = "data";
            r2[r4] = r3;
            r3 = r7.f23354b;
            r2 = com.indooratlas.android.sdk._internal.ci.C5836a.m20214a(r0, r1, r2, r3);
            if (r2 != 0) goto L_0x001e;
        L_0x001d:
            return r6;
        L_0x001e:
            r0 = new java.io.StringWriter;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r0.<init>();	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r3 = com.indooratlas.android.sdk._internal.ct.m20250a(r2, r0);	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            if (r3 <= 0) goto L_0x006f;
        L_0x0029:
            r0 = r0.toString();	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r4 = 0;
            r3[r4] = r0;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r3 = r7.f23355c;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r4 = r7.f23356d;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r5 = "UTF-8";
            r5 = java.nio.charset.Charset.forName(r5);	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r0 = r0.getBytes(r5);	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r0 = r3.mo4598a(r4, r0);	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r3 = r0.mo4595c();	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r0 = r3.f22927a;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            if (r0 == 0) goto L_0x0084;
        L_0x004e:
            r0 = r3.f22927a;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            if (r0 == 0) goto L_0x0073;
        L_0x0052:
            r0 = r3.f22929c;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r0 = r0.b();	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
        L_0x0058:
            r4 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
            if (r0 != r4) goto L_0x0084;
        L_0x005c:
            r0 = 1;
            r0 = new java.lang.Object[r0];	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r3 = 0;
            r4 = r2.getCount();	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r4 = java.lang.Integer.valueOf(r4);	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r0[r3] = r4;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r0 = r7.f23353a;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            com.indooratlas.android.sdk._internal.ci.C5836a.m20215b(r0, r1);	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
        L_0x006f:
            com.indooratlas.android.sdk._internal.ct.m20263a(r2);
            goto L_0x001d;
        L_0x0073:
            r0 = r3.f22930d;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r0 = r0.f22925b;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            if (r0 == 0) goto L_0x0082;
        L_0x0079:
            r0 = r3.f22930d;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r0 = r0.f22925b;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r0 = r0.b();	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            goto L_0x0058;
        L_0x0082:
            r0 = -1;
            goto L_0x0058;
        L_0x0084:
            r0 = 1;
            r0 = new java.lang.Object[r0];	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r4 = 0;
            r0[r4] = r3;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            r0 = r7.f23353a;	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            com.indooratlas.android.sdk._internal.ci.C5836a.m20216c(r0, r1);	 Catch:{ IOException -> 0x0090, Throwable -> 0x009a }
            goto L_0x006f;
        L_0x0090:
            r0 = move-exception;
            r0 = r7.f23353a;	 Catch:{ all -> 0x00ac }
            com.indooratlas.android.sdk._internal.ci.C5836a.m20216c(r0, r1);	 Catch:{ all -> 0x00ac }
            com.indooratlas.android.sdk._internal.ct.m20263a(r2);
            goto L_0x001d;
        L_0x009a:
            r0 = move-exception;
            r1 = "IACore";
            r3 = "unexpected error while uploading logs";
            r4 = 0;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00ac }
            com.indooratlas.android.sdk._internal.ee.m20410a(r1, r0, r3, r4);	 Catch:{ all -> 0x00ac }
            com.indooratlas.android.sdk._internal.ct.m20263a(r2);
            goto L_0x001d;
        L_0x00ac:
            r0 = move-exception;
            com.indooratlas.android.sdk._internal.ct.m20263a(r2);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.indooratlas.android.sdk._internal.ct.1.doInBackground(java.lang.Object[]):java.lang.Object");
        }
    }

    /* renamed from: a */
    public static ArrayList<String> m20260a(Context context, String... strArr) {
        ArrayList<String> arrayList = new ArrayList(0);
        PackageManager packageManager = context.getPackageManager();
        for (int i = 0; i <= 0; i++) {
            String str = strArr[0];
            if (!packageManager.hasSystemFeature(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m20253a() {
        return String.format(Locale.US, "%s; %s-%d; %s; Android %d", new Object[]{"indooratlas-android-sdk", BuildConfig.VERSION_NAME, Integer.valueOf(BuildConfig.VERSION_CODE), "release", Integer.valueOf(VERSION.SDK_INT)});
    }

    /* renamed from: a */
    public static JSONObject m20261a(Context context, String str, JSONObject jSONObject) {
        try {
            ck a = ck.m20223a(context);
            JSONObject put = new JSONObject().put("idauuid", str).put("bundle", new JSONObject().put("id", a.f23316a).put("version", a.f23317b));
            String str2 = "sdk";
            Object obj = TextUtils.isEmpty("") ? "release" : ",release";
            ar a2 = ar.m19847a();
            JSONObject put2 = put.put(str2, new JSONObject().put("id", "indooratlas-android-sdk").put("version", BuildConfig.VERSION_NAME).put("build", "743").put("variant", obj).put("apiLevel", 4)).put("platform", new JSONObject().put("os", C1253f.jb).put("osVersion", a2.m19849a(C5768c.VERSION_RELEASE)).put("manufacturer", a2.m19849a(C5768c.MANUFACTURER)).put(UpdateDeviceStatusDataStruct.KEY_DEVICE, a2.m19849a(C5768c.DEVICE)).put("product", a2.m19849a(C5768c.PRODUCT)).put("model", a2.m19849a(C5768c.MODEL)).put("board", a2.m19849a(C5768c.BOARD)).put("hardware", a2.m19849a(C5768c.HARDWARE)).put("apiLevel", String.valueOf(a2.m19848a(C5767b.f22973a))).put("sensors", m20271c(context)));
            if (jSONObject != null) {
                put2.put("androidNativeSensors", jSONObject);
            }
            return put2;
        } catch (Throwable e) {
            throw new IllegalStateException("failure creating init sdk json", e);
        }
    }

    /* renamed from: c */
    private static JSONArray m20271c(Context context) throws JSONException {
        cz a = cz.m20279a(context);
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(a.m20283a(1));
        arrayList.add(a.m20283a(4));
        arrayList.add(a.m20283a(16));
        arrayList.add(a.m20283a(2));
        arrayList.add(a.m20283a(14));
        arrayList.add(a.m20283a(6));
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            cw cwVar = (cw) it.next();
            if (cwVar != null) {
                jSONArray.put(m20254a(cwVar.mo4658a()));
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static JSONObject m20262a(List<cw> list) {
        if (list == null) {
            throw new IllegalArgumentException("sensor list cannot be null");
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (cw cwVar : list) {
                if (cwVar.mo4659b() != null) {
                    String a = m20254a(cwVar.mo4658a());
                    Sensor b = cwVar.mo4659b();
                    JSONObject jSONObject2 = new JSONObject();
                    if (VERSION.SDK_INT >= 19) {
                        jSONObject2.put("fifoMaxEventCount", b.getFifoMaxEventCount());
                        jSONObject2.put("fifoReservedEventCount", b.getFifoReservedEventCount());
                    }
                    if (VERSION.SDK_INT >= 21) {
                        jSONObject2.put("maxDelay", b.getMaxDelay());
                    }
                    m20264a(jSONObject2, "maximumRange", b.getMaximumRange());
                    jSONObject2.put("minDelay", b.getMinDelay());
                    jSONObject2.put("name", b.getName());
                    m20264a(jSONObject2, "power", b.getPower());
                    if (VERSION.SDK_INT >= 21) {
                        jSONObject2.put("reportingMode", b.getReportingMode());
                    }
                    m20264a(jSONObject2, "resolution", b.getResolution());
                    if (VERSION.SDK_INT >= 20) {
                        jSONObject2.put("stringType", b.getStringType());
                    }
                    jSONObject2.put("type", b.getType());
                    jSONObject2.put("vendor", b.getVendor());
                    jSONObject2.put("version", b.getVersion());
                    jSONObject.put(a, jSONObject2);
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            ee.m20409a("IACore", "Failed to create json array with all sensors", e);
            return null;
        }
    }

    /* renamed from: a */
    private static void m20264a(JSONObject jSONObject, String str, float f) throws JSONException {
        if (!Float.isNaN(f) && !Float.isInfinite(f)) {
            jSONObject.put(str, (double) f);
        }
    }

    /* renamed from: a */
    private static String m20254a(int i) {
        switch (i) {
            case -301:
                return "network_location";
            case -300:
                return "gps_location";
            case SapiErrorCode.NETWORK_FAILED /*-200*/:
                return "ble";
            case -101:
                return "wifi_passive";
            case -100:
                return C1981b.f6365e;
            case -1:
                return "all";
            case 0:
                return "unknown";
            case 1:
                return "acc";
            case 2:
                return "magn_calib";
            case 3:
                return "orientation";
            case 4:
                return "gyro_calib";
            case 5:
                return C1981b.f6364d;
            case 6:
                return "pressure";
            case 8:
                return "proximity";
            case 9:
                return "gravity";
            case 10:
                return "linear_acc";
            case 11:
                return "rot_vec";
            case 12:
                return "humidity";
            case 13:
                return "temp";
            case 14:
                return "magn_uncalib";
            case 15:
                return "game_rot_vec";
            case 16:
                return "gyro_uncalib";
            case 17:
                return "significant_motion";
            case 18:
                return "step_detector";
            case 19:
                return "step_counter";
            case 20:
                return "geomagn_rot_vec";
            case 21:
                return "hearth_rate";
            case 22:
                return "tilt_detector";
            case 23:
                return "wake_gesture";
            case 24:
                return "glance_gesture";
            case 25:
                return "pick_up_gesture";
            case 26:
                return "wrist_tilt_gesture";
            default:
                return "unknown";
        }
    }

    /* renamed from: a */
    public static String m20255a(String str, String str2) {
        try {
            return m20258a(m20267a(str + JNISearchConst.LAYER_ID_DIVIDER + str2));
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        } catch (Throwable e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* renamed from: a */
    public static String m20256a(String str, Object... objArr) {
        try {
            str = String.format(Locale.US, str, objArr);
        } catch (IllegalFormatException e) {
            ee.m20409a("IACore", "bad string format: " + str + ", args: " + Arrays.toString(objArr), new Object[0]);
        }
        return str;
    }

    /* renamed from: a */
    public static byte[] m20267a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.reset();
        instance.update(str.getBytes("UTF-8"));
        return instance.digest();
    }

    /* renamed from: a */
    public static String m20258a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static void m20263a(Cursor cursor) {
        try {
            cursor.close();
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public static int m20250a(Cursor cursor, Writer writer) throws IOException {
        int count = cursor.getCount();
        if (count > 0 && cursor.moveToFirst()) {
            writer.write(91);
            do {
                writer.write(cursor.getString(0));
                if (!cursor.isLast()) {
                    writer.write(",");
                }
            } while (cursor.moveToNext());
            writer.write(93);
        }
        return count;
    }

    /* renamed from: a */
    public static String m20257a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "null response";
        }
        if (jSONObject.length() == 0) {
            return "no keys in response";
        }
        if (TextUtils.isEmpty(jSONObject.optString("key"))) {
            return "missing mandatory key: 'key'";
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return "missing mandatory key: 'url'";
        }
        try {
            URI uri = new URI(optString);
            return null;
        } catch (URISyntaxException e) {
            return "malformed url: " + optString;
        }
    }

    /* renamed from: a */
    public static int m20251a(int[] iArr) {
        for (int i = 0; i < 4; i++) {
            int i2 = iArr[i];
            if (i2 != -1) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static boolean m20265a(Context context) {
        return m20266a(context, "android.permission.BLUETOOTH") && m20266a(context, "android.permission.BLUETOOTH_ADMIN") && m20266a(context, "android.permission.ACCESS_COARSE_LOCATION");
    }

    @TargetApi(18)
    /* renamed from: b */
    public static boolean m20269b(Context context) {
        if (VERSION.SDK_INT >= 18) {
            return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        return false;
    }

    /* renamed from: a */
    public static IALocation m20252a(cx cxVar) {
        if (cxVar == null || !cxVar.m20277b()) {
            return null;
        }
        String str;
        dq dqVar = (dq) cxVar.f23360c;
        if (dqVar.f23432a == -300) {
            str = "gps";
        } else if (dqVar.f23432a == -301) {
            str = C1981b.f6367g;
        } else {
            str = "passive";
        }
        return new Builder(str).withLatitude(dqVar.f23434c).withLongitude(dqVar.f23435d).withAccuracy(dqVar.f23436e).withAltitude(dqVar.f23437f).withBearing(dqVar.f23438g).withTime(dqVar.f23440i).build();
    }

    /* renamed from: a */
    public static boolean m20266a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    /* renamed from: b */
    public static String m20268b(String str) {
        String str2 = null;
        try {
            str2 = System.getProperty(str);
        } catch (Exception e) {
            ee.m20409a("IACore", "Unable to read property: %s", str);
        }
        return str2;
    }

    /* renamed from: c */
    public static int m20270c(String str) {
        int i = -1;
        String b = m20268b(str);
        if (b != null) {
            try {
                i = Integer.parseInt(b);
            } catch (NumberFormatException e) {
                ee.m20409a("IACore", "Unable to read property int: %s", str);
            }
        }
        return i;
    }

    /* renamed from: a */
    public static String m20259a(String... strArr) {
        for (String str : strArr) {
            if (!ei.m20418a(str)) {
                return str;
            }
        }
        return null;
    }
}
