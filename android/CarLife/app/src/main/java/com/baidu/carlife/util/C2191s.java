package com.baidu.carlife.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.p054k.C1654n;
import com.baidu.carlife.p054k.C1654n.C1653a;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.protobuf.CarlifeStatisticsInfoProto.CarlifeStatisticsInfo;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.track.database.DataBaseConstants;
import com.baidu.navisdk.model.GeoLocateModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StatisticMobileUtil */
/* renamed from: com.baidu.carlife.util.s */
public class C2191s {
    /* renamed from: a */
    public static final String f7007a = "StatisticMobileUtil";
    /* renamed from: b */
    public static String f7008b = null;
    /* renamed from: c */
    public static final String f7009c = "statistic.json";
    /* renamed from: d */
    public static final String f7010d = "StatisticErrorCode.txt";
    /* renamed from: e */
    public static final String f7011e = "10003";
    /* renamed from: f */
    public static final String f7012f = "10004";
    /* renamed from: g */
    public static final String f7013g = "10005";
    /* renamed from: h */
    public static String f7014h = "";
    /* renamed from: i */
    public static String f7015i = "";
    /* renamed from: j */
    public static String f7016j = "";
    /* renamed from: k */
    public static boolean f7017k = false;
    /* renamed from: l */
    public static long f7018l = 0;
    /* renamed from: m */
    public static long f7019m = 0;
    /* renamed from: n */
    public static boolean f7020n = false;
    /* renamed from: o */
    private static final int f7021o = 10;

    /* renamed from: a */
    public static C1653a m8335a() {
        int i;
        C1653a params = new C1653a();
        params.f5080a = TextUtils.isEmpty(f7014h) ? "unknow" : f7014h;
        params.f5081b = TextUtils.isEmpty(f7015i) ? "unknow" : f7015i;
        params.f5082c = TextUtils.isEmpty(f7016j) ? "unknow" : f7016j;
        params.f5083d = "android";
        params.f5086g = C1251e.m4373g();
        params.f5085f = C2172c.m8223b();
        params.f5084e = C1251e.m4378j();
        if (GeoLocateModel.getInstance().getCurrentDistrict() != null) {
            params.f5087h = GeoLocateModel.getInstance().getCurrentDistrict().mId;
        } else {
            params.f5087h = 0;
        }
        if (C1663a.m5979a().m5993N()) {
            i = 1;
        } else {
            i = 0;
        }
        params.f5088i = i;
        return params;
    }

    /* renamed from: a */
    public static void m8340a(CarlifeStatisticsInfo info) {
        f7008b = C1253f.jm + File.separator + "mobile/log/";
        if (info != null) {
            f7014h = info.getCuid();
            f7015i = info.getChannel();
            f7016j = info.getVersionName();
            f7017k = true;
        }
    }

    /* renamed from: a */
    public static synchronized void m8341a(final String errorCode, final boolean hasMaxNum) {
        synchronized (C2191s.class) {
            new Thread(new Runnable() {
                public void run() {
                    StringBuffer sb;
                    FileReader fr;
                    BufferedReader br;
                    FileReader fr2;
                    BufferedReader br2;
                    String tmpStr;
                    Throwable th;
                    String str;
                    Map<Long, Map<String, String>> paramsMap;
                    String[] temp;
                    Map<String, String> map;
                    Long time;
                    if (!TextUtils.isEmpty(errorCode)) {
                        if (C2191s.f7008b == null) {
                            C1260i.m4445e(C2191s.f7007a, "MOBILE_LOG_SDCARD_PATH is null ");
                            return;
                        }
                        C1654n request;
                        C1653a params;
                        File file = new File(C2191s.f7008b);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        file = new File(C2191s.f7008b + C2191s.f7010d);
                        if (!file.exists()) {
                            try {
                                file.createNewFile();
                            } catch (IOException e) {
                            }
                        }
                        FileWriter fw = null;
                        try {
                            FileWriter fw2 = new FileWriter(file, true);
                            try {
                                fw2.write("," + errorCode);
                                if (fw2 != null) {
                                    try {
                                        fw2.close();
                                    } catch (IOException e2) {
                                        fw = fw2;
                                    }
                                }
                                fw = fw2;
                            } catch (IOException e3) {
                                fw = fw2;
                                if (fw != null) {
                                    try {
                                        fw.close();
                                    } catch (IOException e4) {
                                    }
                                }
                                sb = new StringBuffer();
                                fr = null;
                                br = null;
                                fr2 = new FileReader(file);
                                try {
                                    br2 = new BufferedReader(fr2);
                                    while (true) {
                                        try {
                                            tmpStr = br2.readLine();
                                            if (tmpStr != null) {
                                                break;
                                            }
                                            sb.append(tmpStr);
                                        } catch (FileNotFoundException e5) {
                                            br = br2;
                                            fr = fr2;
                                        } catch (IOException e6) {
                                            br = br2;
                                            fr = fr2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            br = br2;
                                            fr = fr2;
                                        }
                                    }
                                    if (br2 != null) {
                                        try {
                                            br2.close();
                                        } catch (IOException e7) {
                                            br = br2;
                                            fr = fr2;
                                        }
                                    }
                                    if (fr2 != null) {
                                        fr2.close();
                                    }
                                    br = br2;
                                    fr = fr2;
                                } catch (FileNotFoundException e8) {
                                    fr = fr2;
                                    if (br != null) {
                                        try {
                                            br.close();
                                        } catch (IOException e9) {
                                        }
                                    }
                                    if (fr != null) {
                                        fr.close();
                                    }
                                    str = sb.toString();
                                    if (TextUtils.isEmpty(str)) {
                                        paramsMap = new HashMap();
                                        for (String split : str.split(",")) {
                                            temp = split.split("#");
                                            if (temp.length <= 1) {
                                                map = new HashMap();
                                                map.put("errcode", temp[0]);
                                                time = Long.valueOf(0);
                                                try {
                                                    time = Long.valueOf(Long.parseLong(temp[1]));
                                                } catch (Exception e10) {
                                                }
                                                paramsMap.put(time, map);
                                            }
                                        }
                                        if (paramsMap.size() < 10) {
                                        }
                                        request = new C1654n();
                                        request.m5966a(C2191s.f7010d);
                                        params = C2191s.m8335a();
                                        for (Entry<Long, Map<String, String>> entry : paramsMap.entrySet()) {
                                            params.m5964a("10005", (Map) entry.getValue(), ((Long) entry.getKey()).longValue());
                                        }
                                        request.m5965a(params);
                                        request.toPostRequest();
                                    }
                                } catch (IOException e11) {
                                    fr = fr2;
                                    if (br != null) {
                                        try {
                                            br.close();
                                        } catch (IOException e12) {
                                        }
                                    }
                                    if (fr != null) {
                                        fr.close();
                                    }
                                    str = sb.toString();
                                    if (TextUtils.isEmpty(str)) {
                                        paramsMap = new HashMap();
                                        while (i < size) {
                                            temp = split.split("#");
                                            if (temp.length <= 1) {
                                                map = new HashMap();
                                                map.put("errcode", temp[0]);
                                                time = Long.valueOf(0);
                                                time = Long.valueOf(Long.parseLong(temp[1]));
                                                paramsMap.put(time, map);
                                            }
                                        }
                                        if (paramsMap.size() < 10) {
                                        }
                                        request = new C1654n();
                                        request.m5966a(C2191s.f7010d);
                                        params = C2191s.m8335a();
                                        for (Entry<Long, Map<String, String>> entry2 : paramsMap.entrySet()) {
                                            params.m5964a("10005", (Map) entry2.getValue(), ((Long) entry2.getKey()).longValue());
                                        }
                                        request.m5965a(params);
                                        request.toPostRequest();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    fr = fr2;
                                    if (br != null) {
                                        try {
                                            br.close();
                                        } catch (IOException e13) {
                                            throw th;
                                        }
                                    }
                                    if (fr != null) {
                                        fr.close();
                                    }
                                    throw th;
                                }
                                str = sb.toString();
                                if (TextUtils.isEmpty(str)) {
                                    paramsMap = new HashMap();
                                    while (i < size) {
                                        temp = split.split("#");
                                        if (temp.length <= 1) {
                                            map = new HashMap();
                                            map.put("errcode", temp[0]);
                                            time = Long.valueOf(0);
                                            time = Long.valueOf(Long.parseLong(temp[1]));
                                            paramsMap.put(time, map);
                                        }
                                    }
                                    if (paramsMap.size() < 10) {
                                    }
                                    request = new C1654n();
                                    request.m5966a(C2191s.f7010d);
                                    params = C2191s.m8335a();
                                    for (Entry<Long, Map<String, String>> entry22 : paramsMap.entrySet()) {
                                        params.m5964a("10005", (Map) entry22.getValue(), ((Long) entry22.getKey()).longValue());
                                    }
                                    request.m5965a(params);
                                    request.toPostRequest();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fw = fw2;
                                if (fw != null) {
                                    try {
                                        fw.close();
                                    } catch (IOException e14) {
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e15) {
                            if (fw != null) {
                                fw.close();
                            }
                            sb = new StringBuffer();
                            fr = null;
                            br = null;
                            fr2 = new FileReader(file);
                            br2 = new BufferedReader(fr2);
                            while (true) {
                                tmpStr = br2.readLine();
                                if (tmpStr != null) {
                                    break;
                                }
                                sb.append(tmpStr);
                            }
                            if (br2 != null) {
                                br2.close();
                            }
                            if (fr2 != null) {
                                fr2.close();
                            }
                            br = br2;
                            fr = fr2;
                            str = sb.toString();
                            if (TextUtils.isEmpty(str)) {
                                paramsMap = new HashMap();
                                while (i < size) {
                                    temp = split.split("#");
                                    if (temp.length <= 1) {
                                        map = new HashMap();
                                        map.put("errcode", temp[0]);
                                        time = Long.valueOf(0);
                                        time = Long.valueOf(Long.parseLong(temp[1]));
                                        paramsMap.put(time, map);
                                    }
                                }
                                if (paramsMap.size() < 10) {
                                }
                                request = new C1654n();
                                request.m5966a(C2191s.f7010d);
                                params = C2191s.m8335a();
                                for (Entry<Long, Map<String, String>> entry222 : paramsMap.entrySet()) {
                                    params.m5964a("10005", (Map) entry222.getValue(), ((Long) entry222.getKey()).longValue());
                                }
                                request.m5965a(params);
                                request.toPostRequest();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            if (fw != null) {
                                fw.close();
                            }
                            throw th;
                        }
                        sb = new StringBuffer();
                        fr = null;
                        br = null;
                        try {
                            fr2 = new FileReader(file);
                            br2 = new BufferedReader(fr2);
                            while (true) {
                                tmpStr = br2.readLine();
                                if (tmpStr != null) {
                                    break;
                                }
                                sb.append(tmpStr);
                            }
                            if (br2 != null) {
                                br2.close();
                            }
                            if (fr2 != null) {
                                fr2.close();
                            }
                            br = br2;
                            fr = fr2;
                        } catch (FileNotFoundException e16) {
                            if (br != null) {
                                br.close();
                            }
                            if (fr != null) {
                                fr.close();
                            }
                            str = sb.toString();
                            if (TextUtils.isEmpty(str)) {
                                paramsMap = new HashMap();
                                while (i < size) {
                                    temp = split.split("#");
                                    if (temp.length <= 1) {
                                        map = new HashMap();
                                        map.put("errcode", temp[0]);
                                        time = Long.valueOf(0);
                                        time = Long.valueOf(Long.parseLong(temp[1]));
                                        paramsMap.put(time, map);
                                    }
                                }
                                if (paramsMap.size() < 10) {
                                }
                                request = new C1654n();
                                request.m5966a(C2191s.f7010d);
                                params = C2191s.m8335a();
                                for (Entry<Long, Map<String, String>> entry2222 : paramsMap.entrySet()) {
                                    params.m5964a("10005", (Map) entry2222.getValue(), ((Long) entry2222.getKey()).longValue());
                                }
                                request.m5965a(params);
                                request.toPostRequest();
                            }
                        } catch (IOException e17) {
                            if (br != null) {
                                br.close();
                            }
                            if (fr != null) {
                                fr.close();
                            }
                            str = sb.toString();
                            if (TextUtils.isEmpty(str)) {
                                paramsMap = new HashMap();
                                while (i < size) {
                                    temp = split.split("#");
                                    if (temp.length <= 1) {
                                        map = new HashMap();
                                        map.put("errcode", temp[0]);
                                        time = Long.valueOf(0);
                                        time = Long.valueOf(Long.parseLong(temp[1]));
                                        paramsMap.put(time, map);
                                    }
                                }
                                if (paramsMap.size() < 10) {
                                }
                                request = new C1654n();
                                request.m5966a(C2191s.f7010d);
                                params = C2191s.m8335a();
                                for (Entry<Long, Map<String, String>> entry22222 : paramsMap.entrySet()) {
                                    params.m5964a("10005", (Map) entry22222.getValue(), ((Long) entry22222.getKey()).longValue());
                                }
                                request.m5965a(params);
                                request.toPostRequest();
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            if (br != null) {
                                br.close();
                            }
                            if (fr != null) {
                                fr.close();
                            }
                            throw th;
                        }
                        str = sb.toString();
                        if (TextUtils.isEmpty(str)) {
                            paramsMap = new HashMap();
                            while (i < size) {
                                temp = split.split("#");
                                if (temp.length <= 1) {
                                    map = new HashMap();
                                    map.put("errcode", temp[0]);
                                    time = Long.valueOf(0);
                                    time = Long.valueOf(Long.parseLong(temp[1]));
                                    paramsMap.put(time, map);
                                }
                            }
                            if (paramsMap.size() < 10 || !hasMaxNum) {
                                request = new C1654n();
                                request.m5966a(C2191s.f7010d);
                                params = C2191s.m8335a();
                                for (Entry<Long, Map<String, String>> entry222222 : paramsMap.entrySet()) {
                                    params.m5964a("10005", (Map) entry222222.getValue(), ((Long) entry222222.getKey()).longValue());
                                }
                                request.m5965a(params);
                                request.toPostRequest();
                            }
                        }
                    }
                }
            }).start();
        }
    }

    /* renamed from: a */
    public static void m8343a(boolean isConn, boolean now, boolean save, boolean read) {
        f7008b = C1253f.jm + File.separator + "mobile/log/";
        final Context context = BaiduNaviApplication.getInstance();
        if (context == null) {
            return;
        }
        if (!isConn || f7017k) {
            final boolean z = isConn;
            final boolean z2 = now;
            final boolean z3 = save;
            final boolean z4 = read;
            new Thread(new Runnable() {
                public void run() {
                    C2191s.m8339a(context, z, C2191s.f7019m, C2191s.f7018l, z2, z3, z4);
                }
            }).start();
        }
    }

    /* renamed from: a */
    public static void m8339a(Context context, boolean isConn, long conStartTime, long appStartTime, boolean now, boolean save, boolean read) {
        if (!now || (now && C1251e.m4358a().m4401r())) {
            C1654n request = new C1654n();
            request.m5966a(f7009c);
            C1653a params = new C1653a();
            if (now && read) {
                params = C2191s.m8336a(request, C2191s.m8338a(f7009c));
                if (params != null) {
                    request.m5965a(params);
                    request.toPostRequest();
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (!isConn) {
                conStartTime = appStartTime;
            }
            long time = (currentTimeMillis - conStartTime) / 1000;
            Map<String, String> map = new HashMap();
            params.f5083d = "android";
            params.f5086g = C1251e.m4373g();
            params.f5085f = C2172c.m8223b();
            params.f5084e = C1251e.m4378j();
            if (GeoLocateModel.getInstance().getCurrentDistrict() != null) {
                params.f5087h = GeoLocateModel.getInstance().getCurrentDistrict().mId;
            } else {
                params.f5087h = NaviFragmentManager.TYPE_CAR_DRV_LIST;
            }
            if (isConn && f7017k) {
                params.f5080a = f7014h;
                params.f5081b = f7015i;
                params.f5082c = f7016j;
                params.f5088i = 1;
                map.put("connTime", "" + time);
            } else {
                params.f5080a = "";
                params.f5081b = "";
                params.f5082c = "";
                params.f5088i = 0;
                map.put("useTime", "" + time);
            }
            int netWorkType = C1251e.m4381s();
            if (netWorkType == 1) {
                map.put("net", "Mobile");
            } else if (netWorkType == 2) {
                map.put("net", "WIFI");
            } else {
                map.put("net", "invalid");
            }
            map.put("carr", C1251e.m4379k());
            map.put("dpi", C1251e.m4363c());
            JSONObject jsonObject = params.m5964a("10003", map, System.currentTimeMillis() / 1000);
            if (now) {
                request.m5965a(params);
                request.toPostRequest();
            } else if (save) {
                C2191s.m8342a(C2191s.m8337a(params, jsonObject), f7009c);
            }
        }
    }

    /* renamed from: a */
    public static JSONObject m8337a(C1653a params, JSONObject item) {
        JSONObject json = new JSONObject();
        try {
            json.put("os", params.f5083d);
            json.put("appVer", params.f5086g);
            json.put("mCuid", params.f5085f);
            json.put("mb", params.f5084e);
            json.put(DataBaseConstants.TYPE_LOC, params.f5087h);
            json.put("cuid", params.f5080a);
            json.put("channel", params.f5081b);
            json.put("version", params.f5082c);
            json.put("isConn", params.f5088i);
            json.put("item0", item);
            return json;
        } catch (JSONException e) {
            C1260i.m4445e(f7007a, e.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static void m8342a(JSONObject jsonObject, String fileName) {
        IOException e;
        Throwable th;
        if (jsonObject != null && !TextUtils.isEmpty(fileName) && !TextUtils.isEmpty(f7008b)) {
            String jsonStr = jsonObject.toString();
            if (!TextUtils.isEmpty(jsonStr)) {
                File dir = new File(f7008b);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File jsonFile = new File(f7008b + fileName);
                FileWriter fw = null;
                try {
                    jsonFile.createNewFile();
                    FileWriter fw2 = new FileWriter(jsonFile, false);
                    try {
                        fw2.write(jsonStr);
                        fw2.flush();
                        if (fw2 != null) {
                            try {
                                fw2.close();
                            } catch (IOException e2) {
                                C1260i.m4445e(f7007a, e2.toString());
                                fw = fw2;
                                return;
                            }
                        }
                        fw = fw2;
                    } catch (IOException e3) {
                        e2 = e3;
                        fw = fw2;
                        try {
                            C1260i.m4445e(f7007a, e2.toString());
                            if (fw != null) {
                                try {
                                    fw.close();
                                } catch (IOException e22) {
                                    C1260i.m4445e(f7007a, e22.toString());
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fw != null) {
                                try {
                                    fw.close();
                                } catch (IOException e222) {
                                    C1260i.m4445e(f7007a, e222.toString());
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fw = fw2;
                        if (fw != null) {
                            fw.close();
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e222 = e4;
                    C1260i.m4445e(f7007a, e222.toString());
                    if (fw != null) {
                        fw.close();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static JSONObject m8338a(String fileName) {
        FileNotFoundException e;
        IOException e2;
        JSONException e3;
        Throwable th;
        if (TextUtils.isEmpty(f7008b) || TextUtils.isEmpty(fileName)) {
            return null;
        }
        File jsonFile = new File(f7008b + fileName);
        if (!jsonFile.exists()) {
            return null;
        }
        String jsonStr = "";
        FileReader fr = null;
        BufferedReader br = null;
        try {
            FileReader fr2 = new FileReader(jsonFile);
            try {
                BufferedReader br2 = new BufferedReader(fr2);
                while (true) {
                    try {
                        String tmpStr = br2.readLine();
                        if (tmpStr == null) {
                            break;
                        }
                        jsonStr = jsonStr + tmpStr;
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        br = br2;
                        fr = fr2;
                    } catch (IOException e5) {
                        e2 = e5;
                        br = br2;
                        fr = fr2;
                    } catch (JSONException e6) {
                        e3 = e6;
                        br = br2;
                        fr = fr2;
                    } catch (Throwable th2) {
                        th = th2;
                        br = br2;
                        fr = fr2;
                    }
                }
                JSONObject resJson = new JSONObject(jsonStr);
                if (br2 != null) {
                    try {
                        br2.close();
                    } catch (IOException e22) {
                        C1260i.m4445e(f7007a, e22.toString());
                        br = br2;
                        fr = fr2;
                        return resJson;
                    }
                }
                if (fr2 != null) {
                    fr2.close();
                }
                br = br2;
                fr = fr2;
                return resJson;
            } catch (FileNotFoundException e7) {
                e = e7;
                fr = fr2;
                try {
                    C1260i.m4445e(f7007a, e.toString());
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e222) {
                            C1260i.m4445e(f7007a, e222.toString());
                            return null;
                        }
                    }
                    if (fr != null) {
                        return null;
                    }
                    fr.close();
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e2222) {
                            C1260i.m4445e(f7007a, e2222.toString());
                            throw th;
                        }
                    }
                    if (fr != null) {
                        fr.close();
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e2222 = e8;
                fr = fr2;
                C1260i.m4445e(f7007a, e2222.toString());
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e22222) {
                        C1260i.m4445e(f7007a, e22222.toString());
                        return null;
                    }
                }
                if (fr != null) {
                    return null;
                }
                fr.close();
                return null;
            } catch (JSONException e9) {
                e3 = e9;
                fr = fr2;
                C1260i.m4445e(f7007a, e3.toString());
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e222222) {
                        C1260i.m4445e(f7007a, e222222.toString());
                        return null;
                    }
                }
                if (fr != null) {
                    return null;
                }
                fr.close();
                return null;
            } catch (Throwable th4) {
                th = th4;
                fr = fr2;
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e10) {
            e = e10;
            C1260i.m4445e(f7007a, e.toString());
            if (br != null) {
                br.close();
            }
            if (fr != null) {
                return null;
            }
            fr.close();
            return null;
        } catch (IOException e11) {
            e222222 = e11;
            C1260i.m4445e(f7007a, e222222.toString());
            if (br != null) {
                br.close();
            }
            if (fr != null) {
                return null;
            }
            fr.close();
            return null;
        } catch (JSONException e12) {
            e3 = e12;
            C1260i.m4445e(f7007a, e3.toString());
            if (br != null) {
                br.close();
            }
            if (fr != null) {
                return null;
            }
            fr.close();
            return null;
        }
    }

    /* renamed from: a */
    public static C1653a m8336a(C1654n request, JSONObject sourceJson) {
        if (sourceJson == null || request == null) {
            return null;
        }
        C1260i.m4443d("resJson", sourceJson.toString());
        C1653a params = new C1653a();
        params.f5083d = sourceJson.optString("os");
        params.f5086g = sourceJson.optString("appVer");
        params.f5085f = sourceJson.optString("mCuid");
        params.f5087h = sourceJson.optInt(DataBaseConstants.TYPE_LOC);
        params.f5080a = sourceJson.optString("cuid");
        params.f5081b = sourceJson.optString("channel");
        params.f5082c = sourceJson.optString("version");
        params.f5088i = sourceJson.optInt("isConn");
        params.f5084e = sourceJson.optString("mb");
        if (sourceJson.optJSONObject("item0") == null) {
            return params;
        }
        params.m5963a(sourceJson.optJSONObject("item0").toString());
        return params;
    }
}
