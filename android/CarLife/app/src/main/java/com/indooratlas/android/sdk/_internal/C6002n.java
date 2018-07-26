package com.indooratlas.android.sdk._internal;

import android.support.v4.media.TransportMediator;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.indooratlas.android.sdk._internal.n */
public final class C6002n {
    /* renamed from: a */
    public static <T extends C6001m> String m21511a(T t) {
        if (t == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            C6002n.m21513a(null, t, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e) {
            return "Error printing proto: " + e.getMessage();
        } catch (InvocationTargetException e2) {
            return "Error printing proto: " + e2.getMessage();
        }
    }

    /* renamed from: a */
    private static void m21513a(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, InvocationTargetException {
        if (obj == null) {
            return;
        }
        int length;
        if (obj instanceof C6001m) {
            int modifiers;
            int length2 = stringBuffer.length();
            if (str != null) {
                stringBuffer2.append(stringBuffer).append(C6002n.m21512a(str)).append(" <\n");
                stringBuffer.append("  ");
            }
            Class cls = obj.getClass();
            for (Field field : cls.getFields()) {
                modifiers = field.getModifiers();
                String name = field.getName();
                if (!("cachedSize".equals(name) || (modifiers & 1) != 1 || (modifiers & 8) == 8 || name.startsWith(JNISearchConst.LAYER_ID_DIVIDER) || name.endsWith(JNISearchConst.LAYER_ID_DIVIDER))) {
                    Class type = field.getType();
                    Object obj2 = field.get(obj);
                    if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                        C6002n.m21513a(name, obj2, stringBuffer, stringBuffer2);
                    } else {
                        int length3 = obj2 == null ? 0 : Array.getLength(obj2);
                        for (modifiers = 0; modifiers < length3; modifiers++) {
                            C6002n.m21513a(name, Array.get(obj2, modifiers), stringBuffer, stringBuffer2);
                        }
                    }
                }
            }
            for (Method name2 : cls.getMethods()) {
                String name3 = name2.getName();
                if (name3.startsWith(C2848p.af)) {
                    String substring = name3.substring(3);
                    try {
                        if (((Boolean) cls.getMethod("has" + substring, new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                            try {
                                C6002n.m21513a(substring, cls.getMethod("get" + substring, new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                            } catch (NoSuchMethodException e) {
                            }
                        }
                    } catch (NoSuchMethodException e2) {
                    }
                }
            }
            if (str != null) {
                stringBuffer.setLength(length2);
                stringBuffer2.append(stringBuffer).append(">\n");
            }
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            String a = C6002n.m21512a(str);
            for (Entry entry : map.entrySet()) {
                stringBuffer2.append(stringBuffer).append(a).append(" <\n");
                length = stringBuffer.length();
                stringBuffer.append("  ");
                C6002n.m21513a("key", entry.getKey(), stringBuffer, stringBuffer2);
                C6002n.m21513a("value", entry.getValue(), stringBuffer, stringBuffer2);
                stringBuffer.setLength(length);
                stringBuffer2.append(stringBuffer).append(">\n");
            }
        } else {
            stringBuffer2.append(stringBuffer).append(C6002n.m21512a(str)).append(": ");
            if (obj instanceof String) {
                obj = (String) obj;
                if (!obj.startsWith("http") && obj.length() > 200) {
                    obj = obj.substring(0, 200) + "[...]";
                }
                stringBuffer2.append("\"").append(C6002n.m21515b(obj)).append("\"");
            } else if (obj instanceof byte[]) {
                C6002n.m21514a((byte[]) obj, stringBuffer2);
            } else {
                stringBuffer2.append(obj);
            }
            stringBuffer2.append("\n");
        }
    }

    /* renamed from: a */
    private static String m21512a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (i == 0) {
                stringBuffer.append(Character.toLowerCase(charAt));
            } else if (Character.isUpperCase(charAt)) {
                stringBuffer.append('_').append(Character.toLowerCase(charAt));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private static String m21515b(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                stringBuilder.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static void m21514a(byte[] bArr, StringBuffer stringBuffer) {
        if (bArr == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append('\"');
        for (byte b : bArr) {
            int i = b & 255;
            if (i == 92 || i == 34) {
                stringBuffer.append('\\').append((char) i);
            } else if (i < 32 || i >= TransportMediator.KEYCODE_MEDIA_PAUSE) {
                stringBuffer.append(String.format("\\%03o", new Object[]{Integer.valueOf(i)}));
            } else {
                stringBuffer.append((char) i);
            }
        }
        stringBuffer.append('\"');
    }
}
