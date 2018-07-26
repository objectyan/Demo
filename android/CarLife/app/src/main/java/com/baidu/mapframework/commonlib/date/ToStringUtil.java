package com.baidu.mapframework.commonlib.date;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import java.util.regex.Pattern;

final class ToStringUtil {
    /* renamed from: a */
    private static final String f19032a = "getClass";
    /* renamed from: b */
    private static final String f19033b = "clone";
    /* renamed from: c */
    private static final String f19034c = "hashCode";
    /* renamed from: d */
    private static final String f19035d = "toString";
    /* renamed from: e */
    private static final String f19036e = "get";
    /* renamed from: f */
    private static final Object[] f19037f = new Object[0];
    /* renamed from: g */
    private static final Class[] f19038g = new Class[0];
    /* renamed from: h */
    private static final String f19039h = "";
    /* renamed from: i */
    private static final String f19040i = "[circular reference]";
    /* renamed from: j */
    private static final Logger f19041j = Util.m15094a(ToStringUtil.class);
    /* renamed from: k */
    private static final String f19042k = System.getProperty("line.separator");
    /* renamed from: l */
    private static Pattern f19043l = Pattern.compile("password", 2);
    /* renamed from: m */
    private static String f19044m = "****";

    private static final class Ping {
        /* renamed from: a */
        private Pong f19030a;

        private Ping() {
        }

        public Pong getPong() {
            return this.f19030a;
        }

        public void setPong(Pong aPong) {
            this.f19030a = aPong;
        }

        public Integer getId() {
            return new Integer(123);
        }

        public String getUserPassword() {
            return "blah";
        }

        public String toString() {
            return ToStringUtil.m15082a((Object) this);
        }
    }

    private static final class Pong {
        /* renamed from: a */
        private Ping f19031a;

        private Pong() {
        }

        public Ping getPing() {
            return this.f19031a;
        }

        public void setPing(Ping aPing) {
            this.f19031a = aPing;
        }

        public String toString() {
            return ToStringUtil.m15083a(this, Ping.class, "getId");
        }
    }

    private ToStringUtil() {
    }

    /* renamed from: a */
    static String m15082a(Object aObject) {
        return m15083a(aObject, null, null);
    }

    /* renamed from: a */
    static String m15083a(Object aObject, Class aSpecialClass, String aMethodName) {
        StringBuilder result = new StringBuilder();
        m15086a(aObject, result);
        for (Method method : aObject.getClass().getDeclaredMethods()) {
            if (m15089a(method, aObject.getClass())) {
                m15087a(aObject, method, result, aSpecialClass, aMethodName);
            }
        }
        m15088a(result);
        return result.toString();
    }

    /* renamed from: a */
    private static void m15086a(Object aObject, StringBuilder aResult) {
        aResult.append(aObject.getClass().getName());
        aResult.append(" {");
        aResult.append(f19042k);
    }

    /* renamed from: a */
    private static void m15088a(StringBuilder aResult) {
        aResult.append("}");
        aResult.append(f19042k);
    }

    /* renamed from: a */
    private static boolean m15089a(Method aMethod, Class aNativeClass) {
        boolean isPublic = Modifier.isPublic(aMethod.getModifiers());
        boolean hasNoArguments;
        if (aMethod.getParameterTypes().length == 0) {
            hasNoArguments = true;
        } else {
            hasNoArguments = false;
        }
        boolean hasReturnValue;
        if (aMethod.getReturnType() != Void.TYPE) {
            hasReturnValue = true;
        } else {
            hasReturnValue = false;
        }
        boolean returnsNativeObject;
        if (aMethod.getReturnType() == aNativeClass) {
            returnsNativeObject = true;
        } else {
            returnsNativeObject = false;
        }
        boolean isMethodOfObjectClass;
        if (aMethod.getName().equals(f19033b) || aMethod.getName().equals(f19032a) || aMethod.getName().equals(f19034c) || aMethod.getName().equals(f19035d)) {
            isMethodOfObjectClass = true;
        } else {
            isMethodOfObjectClass = false;
        }
        if (isPublic && hasNoArguments && hasReturnValue && !isMethodOfObjectClass && !returnsNativeObject) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static void m15087a(Object aObject, Method aMethod, StringBuilder aResult, Class aCircularRefClass, String aCircularRefMethodName) {
        aResult.append("");
        aResult.append(m15084a(aMethod));
        aResult.append(": ");
        Object returnValue = m15081a(aObject, aMethod);
        if (returnValue != null && returnValue.getClass().isArray()) {
            aResult.append(Util.m15097b(returnValue));
        } else if (aCircularRefClass == null) {
            aResult.append(returnValue);
        } else if (aCircularRefClass == returnValue.getClass()) {
            Method method = m15085a(aCircularRefClass, aCircularRefMethodName);
            if (m15089a(method, aCircularRefClass)) {
                aResult.append(m15081a(returnValue, method));
            } else {
                aResult.append(f19040i);
            }
        }
        aResult.append(f19042k);
    }

    /* renamed from: a */
    private static String m15084a(Method aMethod) {
        String result = aMethod.getName();
        if (result.startsWith(f19036e)) {
            return result.substring(f19036e.length());
        }
        return result;
    }

    /* renamed from: a */
    private static Object m15081a(Object aObject, Method aMethod) {
        Object result = null;
        try {
            result = aMethod.invoke(aObject, f19037f);
        } catch (IllegalAccessException e) {
            m15091b(aObject, aMethod);
        } catch (InvocationTargetException e2) {
            m15091b(aObject, aMethod);
        }
        return m15092c(result, aMethod);
    }

    /* renamed from: a */
    private static Method m15085a(Class aSpecialClass, String aMethodName) {
        Method result = null;
        try {
            result = aSpecialClass.getMethod(aMethodName, f19038g);
        } catch (NoSuchMethodException e) {
            m15090b(aSpecialClass, aMethodName);
        }
        return result;
    }

    /* renamed from: b */
    private static void m15091b(Object aObject, Method aMethod) {
        f19041j.severe("Cannot get return value using reflection. Class: " + aObject.getClass().getName() + " Method: " + aMethod.getName());
    }

    /* renamed from: b */
    private static void m15090b(Class aSpecialClass, String aMethodName) {
        f19041j.severe("Reflection fails to get no-arg method named: " + Util.m15093a((Object) aMethodName) + " for class: " + aSpecialClass.getName());
    }

    /* renamed from: c */
    private static Object m15092c(Object aReturnValue, Method aMethod) {
        Object result = aReturnValue;
        if (f19043l.matcher(aMethod.getName()).find()) {
            return f19044m;
        }
        return result;
    }

    public static void main(String... args) {
        List<String> list = new ArrayList();
        list.add("blah");
        list.add("blah");
        list.add("blah");
        StringTokenizer parser = new StringTokenizer("This is the end.");
        Ping ping = new Ping();
        Pong pong = new Pong();
        ping.setPong(pong);
        pong.setPing(ping);
    }
}
