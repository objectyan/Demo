package com.baidu.platform.comapi.util;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* compiled from: OSCheck */
/* renamed from: com.baidu.platform.comapi.util.i */
public class C4826i {
    /* renamed from: a */
    public static String f19972a = C4826i.class.getSimpleName();
    /* renamed from: b */
    public static final String f19973b = "";
    /* renamed from: c */
    private static final String f19974c = "ro.build.version.emui";

    /* compiled from: OSCheck */
    /* renamed from: com.baidu.platform.comapi.util.i$a */
    private static class C4825a {
        /* renamed from: a */
        private static final C4826i f19971a = new C4826i();

        private C4825a() {
        }
    }

    /* renamed from: a */
    public static C4826i m16007a() {
        return C4825a.f19971a;
    }

    /* renamed from: b */
    public boolean m16011b() {
        String os = "";
        try {
            os = Build.MANUFACTURER;
        } catch (Exception e) {
            C2911f.d(f19972a, e.getMessage());
        }
        return "xiaomi".equalsIgnoreCase(os);
    }

    /* renamed from: c */
    public boolean m16012c() {
        String os = "";
        try {
            os = C4826i.m16010d();
        } catch (Exception e) {
            C2911f.d(f19972a, e.getMessage());
        }
        return !TextUtils.isEmpty(os);
    }

    /* renamed from: d */
    public static String m16010d() {
        String emuiVersion = "";
        try {
            Object obj = C4826i.m16009a("android.os.SystemProperties", "get", new Class[]{String.class, String.class}, new Object[]{f19974c, ""});
            if (obj != null) {
                return (String) obj;
            }
            return emuiVersion;
        } catch (Exception e) {
            C2911f.d(f19972a, e.getMessage());
            return emuiVersion;
        }
    }

    /* renamed from: a */
    public static Object m16009a(String className, String funName, Class[] paramsType, Object[] params) {
        try {
            return C4826i.m16008a(Class.forName(className), funName, paramsType, params);
        } catch (ClassNotFoundException e) {
            C2911f.d(f19972a, e.getMessage());
            return null;
        } catch (Exception e2) {
            C2911f.d(f19972a, e2.getMessage());
            return null;
        } catch (Throwable e3) {
            C2911f.d(f19972a, e3.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m16008a(Class cls, String funName, Class[] paramsType, Object[] params) throws Exception {
        Object obj = null;
        if (cls == null) {
            throw new Exception("class is null in staticFun");
        }
        if (paramsType == null) {
            if (params != null) {
                throw new Exception("paramsType is null, but params is not null");
            }
        } else if (params == null) {
            throw new Exception("paramsType or params should be same");
        } else if (paramsType.length != params.length) {
            throw new Exception("paramsType len:" + paramsType.length + " should equal params.len:" + params.length);
        }
        try {
            try {
                obj = cls.getMethod(funName, paramsType).invoke(null, params);
            } catch (IllegalAccessException e) {
                C2911f.d(f19972a, e.getMessage());
            } catch (IllegalArgumentException e2) {
                C2911f.d(f19972a, e2.getMessage());
            } catch (InvocationTargetException e3) {
                C2911f.d(f19972a, e3.getMessage());
            }
        } catch (NoSuchMethodException e4) {
            C2911f.d(f19972a, e4.getMessage());
        } catch (Exception e5) {
            C2911f.d(f19972a, e5.getMessage());
        }
        return obj;
    }
}
