package com.baidu.carlife.util;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.logic.C1872t;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;

/* compiled from: SkinUtil */
/* renamed from: com.baidu.carlife.util.r */
public class C2188r {
    /* renamed from: a */
    private static final int f6995a = -1;
    /* renamed from: b */
    private static final int f6996b = 0;
    /* renamed from: c */
    private static SparseIntArray f6997c = new SparseIntArray();
    /* renamed from: d */
    private static Resources f6998d = BaiduNaviApplication.getInstance().getResources();
    /* renamed from: e */
    private static Resources f6999e;

    /* renamed from: a */
    public static void m8330a(Resources skinResources) {
        f6999e = skinResources;
    }

    /* renamed from: a */
    public static SparseIntArray m8329a() {
        return f6997c;
    }

    /* renamed from: b */
    public static void m8332b() {
        f6997c.clear();
        f6999e = null;
    }

    /* renamed from: a */
    public static int m8328a(int rid) {
        if (f6999e != null) {
            try {
                int temp = f6997c.get(rid, -1);
                if (temp == -1) {
                    temp = f6999e.getIdentifier(C2188r.m8333c(rid), OVERLAY_KEY.SGEO_LEVEL_COLOR_LINE, C1872t.f5807d);
                    f6997c.put(rid, temp);
                }
                if (temp != 0) {
                    return f6999e.getColor(temp);
                }
            } catch (Exception e) {
            }
        }
        return f6998d.getColor(rid);
    }

    /* renamed from: b */
    public static Drawable m8331b(int rid) {
        if (f6999e != null) {
            try {
                int temp = f6997c.get(rid, -1);
                if (temp == -1) {
                    temp = f6999e.getIdentifier(C2188r.m8333c(rid), C2188r.m8334d(rid), C1872t.f5807d);
                    f6997c.put(rid, temp);
                }
                if (temp != 0) {
                    return f6999e.getDrawable(temp);
                }
            } catch (NotFoundException e) {
            }
        }
        return f6998d.getDrawable(rid);
    }

    /* renamed from: c */
    private static String m8333c(int rid) {
        String name = "";
        if (f6998d != null) {
            try {
                name = f6998d.getResourceEntryName(rid);
            } catch (NotFoundException e) {
            }
        }
        return name;
    }

    /* renamed from: d */
    private static String m8334d(int rid) {
        String type = "";
        if (f6998d != null) {
            try {
                type = f6998d.getResourceTypeName(rid);
            } catch (NotFoundException e) {
            }
        }
        return type;
    }
}
