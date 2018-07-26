package com.baidu.baidumaps.p037b;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapframework.common.mapview.MapInfoProvider;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.basestruct.Point;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EntryUtils */
/* renamed from: com.baidu.baidumaps.b.a */
public class C0665a {
    /* renamed from: a */
    public static final String f2120a = "baidu_lauch";
    /* renamed from: b */
    public static final String f2121b = "launch_mode";
    /* renamed from: c */
    public static final String f2122c = "(\\?|&+)(.+?)=([^&]*)";
    /* renamed from: d */
    private static final String f2123d = "com.baidu.baidumaps.action.ENTRY";

    /* compiled from: EntryUtils */
    /* renamed from: com.baidu.baidumaps.b.a$a */
    public enum C0664a {
        MAP_MODE("MAP_MODE"),
        CLEAN_MODE("CLEAN_MODE"),
        NORMAL_MODE("NORMAL_MODE"),
        NORMAL_MAP_MODE("NORMAL_MAP_MODE"),
        BAIDU_MODE("BAIDU_MODE");
        
        /* renamed from: f */
        private final String f2119f;

        private C0664a(String strValue) {
            this.f2119f = strValue;
        }

        public String toString() {
            return this.f2119f;
        }
    }

    /* renamed from: a */
    public static Intent m2834a(Class aClass, C0664a mode, Bundle bundle) {
        Uri uri = Uri.parse("baidu_lauch://" + aClass.getName() + "?" + "launch_mode" + "=" + mode.toString());
        Intent intent = new Intent();
        intent.setData(uri);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    /* renamed from: a */
    public static Intent m2833a() {
        Intent intent = new Intent();
        intent.setAction(f2123d);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(67108864);
        return intent;
    }

    /* renamed from: a */
    public static Map<String, String> m2836a(String url) {
        return C0665a.m2837a(url, false);
    }

    /* renamed from: a */
    public static Map<String, String> m2837a(String url, boolean decode) {
        Matcher m = Pattern.compile(f2122c).matcher(url);
        Map<String, String> map = new HashMap();
        while (m.find()) {
            if (decode) {
                map.put(m.group(2), C0665a.m2847e(m.group(3)));
            } else {
                map.put(m.group(2), m.group(3));
            }
        }
        return map;
    }

    /* renamed from: b */
    public static Bundle m2842b(String url) {
        Matcher m = Pattern.compile(f2122c).matcher(url);
        Bundle bundle = new Bundle();
        while (m.find()) {
            bundle.putString(m.group(2), m.group(3));
        }
        return bundle;
    }

    /* renamed from: c */
    public static String m2843c(String url) {
        JSONObject jSONObject;
        try {
            Matcher m = Pattern.compile(f2122c).matcher(url);
            JSONObject obj = new JSONObject();
            while (m.find()) {
                try {
                    obj.put(m.group(2), m.group(3));
                } catch (JSONException e) {
                    jSONObject = obj;
                }
            }
            if (obj != null) {
                jSONObject = obj;
                return obj.toString();
            }
            jSONObject = obj;
            return "";
        } catch (JSONException e2) {
            return "";
        }
    }

    /* renamed from: a */
    public static boolean m2839a(Uri uri) {
        return (uri == null || !uri.isAbsolute() || !uri.isHierarchical() || uri.getHost() == null || uri.getPath() == null) ? false : true;
    }

    /* renamed from: d */
    public static String m2846d(String str) {
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        return str;
    }

    /* renamed from: e */
    public static String m2847e(String url) {
        while (url.contains("%")) {
            url = Uri.decode(url);
        }
        return url;
    }

    /* renamed from: a */
    public static void m2838a(Bundle bundle, String key, String value) {
        if (bundle != null && !TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
            bundle.putString(key, value);
        }
    }

    /* renamed from: b */
    public static int m2841b() {
        return (int) MapInfoProvider.getMapInfo().getMapLevel();
    }

    /* renamed from: a */
    public static MapBound m2835a(Point point, int region) {
        MapBound mapBound = new MapBound();
        Point lb = new Point();
        Point rt = new Point();
        lb.setIntX(point.getIntX() - region);
        lb.setIntY(point.getIntY() - region);
        rt.setIntX(point.getIntX() + region);
        rt.setIntY(point.getIntY() + region);
        mapBound.setLeftBottomPt(lb);
        mapBound.setRightTopPt(rt);
        return mapBound;
    }

    /* renamed from: a */
    private static boolean m2840a(Point lb, Point rt) {
        return lb.getIntX() > rt.getIntX() || lb.getIntY() > rt.getIntY() || lb.getIntX() < 0 || lb.getIntY() < 0 || rt.getIntX() < 0 || rt.getIntY() < 0;
    }

    /* renamed from: c */
    public static boolean m2844c() {
        return LocationManager.getInstance().isLocationValid();
    }

    /* renamed from: d */
    public static Point m2845d() {
        Point loc = new Point(0.0d, 0.0d);
        if (LocationManager.getInstance().isLocationValid()) {
            loc.setIntX((int) LocationManager.getInstance().getCurLocation(CoordType.CoordType_BD09).longitude);
            loc.setIntY((int) LocationManager.getInstance().getCurLocation(CoordType.CoordType_BD09).latitude);
        }
        return loc;
    }

    /* renamed from: f */
    public static C0664a m2848f(String mode) {
        if (TextUtils.isEmpty(mode)) {
            return C0664a.MAP_MODE;
        }
        if (mode.equals(C0664a.CLEAN_MODE.toString())) {
            return C0664a.CLEAN_MODE;
        }
        if (mode.equals(C0664a.NORMAL_MAP_MODE.toString())) {
            return C0664a.NORMAL_MAP_MODE;
        }
        if (mode.equals(C0664a.MAP_MODE.toString())) {
            return C0664a.MAP_MODE;
        }
        if (mode.equals(C0664a.NORMAL_MODE.toString())) {
            return C0664a.NORMAL_MODE;
        }
        return C0664a.MAP_MODE;
    }
}
