package com.baidu.tts.tools;

import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SqlTool {
    public static String sqlDropTable(String tableName) {
        return "drop table if exists " + tableName;
    }

    public static String sqlCreateTable(String tableName, Object[] fields) {
        String str = null;
        if (!(tableName == null || fields == null)) {
            Object obj = fields[0];
            Class cls = obj.getClass();
            try {
                Method supportedMethod = ReflectTool.getSupportedMethod(cls, "getColumnName", null);
                Method supportedMethod2 = ReflectTool.getSupportedMethod(cls, "getDataType", null);
                StringBuilder stringBuilder = new StringBuilder("create Table " + tableName);
                String a = m17548a(supportedMethod, supportedMethod2, obj);
                if (a != null) {
                    stringBuilder.append(" (" + a);
                    int length = fields.length;
                    for (int i = 1; i < length; i++) {
                        stringBuilder.append(",");
                        stringBuilder.append(m17548a(supportedMethod, supportedMethod2, fields[i]));
                    }
                    stringBuilder.append(")");
                    str = stringBuilder.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    /* renamed from: a */
    private static String m17548a(Method method, Method method2, Object obj) {
        String a = m17547a(method, obj);
        if (a != null) {
            String a2 = m17547a(method2, obj);
            if (a2 != null) {
                return a + " " + a2;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m17547a(Method method, Object obj) {
        try {
            return (String) method.invoke(obj, (Object[]) null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String buildConditions(String connector, String... conditions) {
        if (TextUtils.isEmpty(connector) || conditions == null || conditions.length == 0) {
            return null;
        }
        List arrayList = new ArrayList();
        for (String str : conditions) {
            if (!StringTool.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            stringBuilder.append((String) it.next());
        }
        while (it.hasNext()) {
            String str2 = (String) it.next();
            stringBuilder.append(" " + connector + " ");
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }

    public static String buildInCondition(String field, String[] data) {
        if (data == null || data.length == 0 || TextUtils.isEmpty(field)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(field);
        stringBuilder.append(" in (");
        stringBuilder.append(addPlaceholders(data.length));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String addPlaceholders(int length) {
        int i = 1;
        if (length < 1) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("?");
        while (i < length) {
            stringBuilder.append(",?");
            i++;
        }
        return stringBuilder.toString();
    }

    public static String[] getSQLformat(String version, String[] domains, String[] languages, String[] qualities) {
        Object obj = new String[(((domains.length + 1) + languages.length) + qualities.length)];
        obj[0] = version;
        System.arraycopy(domains, 0, obj, 1, domains.length);
        System.arraycopy(languages, 0, obj, domains.length + 1, languages.length);
        System.arraycopy(qualities, 0, obj, (domains.length + 1) + languages.length, qualities.length);
        return obj;
    }
}
