package com.p015a.p016a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.lang.model.element.Modifier;

/* compiled from: Util */
/* renamed from: com.a.a.o */
final class C0386o {
    /* renamed from: a */
    static final Modifier f1261a;

    private C0386o() {
    }

    static {
        Modifier def = null;
        try {
            def = Modifier.valueOf("DEFAULT");
        } catch (IllegalArgumentException e) {
        }
        f1261a = def;
    }

    /* renamed from: a */
    static <K, V> Map<K, List<V>> m1666a(Map<K, List<V>> multimap) {
        LinkedHashMap<K, List<V>> result = new LinkedHashMap();
        for (Entry<K, List<V>> entry : multimap.entrySet()) {
            if (!((List) entry.getValue()).isEmpty()) {
                result.put(entry.getKey(), C0386o.m1665a((Collection) entry.getValue()));
            }
        }
        return Collections.unmodifiableMap(result);
    }

    /* renamed from: b */
    static <K, V> Map<K, V> m1670b(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    /* renamed from: a */
    static void m1669a(boolean condition, String format, Object... args) {
        if (!condition) {
            throw new IllegalArgumentException(String.format(format, args));
        }
    }

    /* renamed from: a */
    static <T> T m1661a(T reference, String format, Object... args) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.format(format, args));
    }

    /* renamed from: b */
    static void m1672b(boolean condition, String format, Object... args) {
        if (!condition) {
            throw new IllegalStateException(String.format(format, args));
        }
    }

    /* renamed from: a */
    static <T> List<T> m1665a(Collection<T> collection) {
        return Collections.unmodifiableList(new ArrayList(collection));
    }

    /* renamed from: b */
    static <T> Set<T> m1671b(Collection<T> set) {
        return Collections.unmodifiableSet(new LinkedHashSet(set));
    }

    /* renamed from: a */
    static String m1664a(String separator, List<String> parts) {
        if (parts.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        result.append((String) parts.get(0));
        for (int i = 1; i < parts.size(); i++) {
            result.append(separator).append((String) parts.get(i));
        }
        return result.toString();
    }

    /* renamed from: a */
    static <T> Set<T> m1667a(Set<T> a, Set<T> b) {
        Set<T> result = new LinkedHashSet();
        result.addAll(a);
        result.addAll(b);
        return result;
    }

    /* renamed from: a */
    static void m1668a(Set<Modifier> modifiers, Modifier... mutuallyExclusive) {
        boolean z;
        int count = 0;
        for (Modifier modifier : mutuallyExclusive) {
            if (!(modifier == null && f1261a == null) && modifiers.contains(modifier)) {
                count++;
            }
        }
        if (count == 1) {
            z = true;
        } else {
            z = false;
        }
        C0386o.m1669a(z, "modifiers %s must contain one of %s", modifiers, Arrays.toString(mutuallyExclusive));
    }

    /* renamed from: c */
    static boolean m1673c(Collection<Modifier> modifiers) {
        return f1261a != null && modifiers.contains(f1261a);
    }

    /* renamed from: a */
    static String m1662a(char c) {
        switch (c) {
            case '\b':
                return "\\b";
            case '\t':
                return "\\t";
            case '\n':
                return "\\n";
            case '\f':
                return "\\f";
            case '\r':
                return "\\r";
            case '\"':
                return "\"";
            case '\'':
                return "\\'";
            case '\\':
                return "\\\\";
            default:
                if (!Character.isISOControl(c)) {
                    return Character.toString(c);
                }
                return String.format("\\u%04x", new Object[]{Integer.valueOf(c)});
        }
    }

    /* renamed from: a */
    static String m1663a(String value, String indent) {
        StringBuilder result = new StringBuilder(value.length() + 2);
        result.append('\"');
        int i = 0;
        while (i < value.length()) {
            char c = value.charAt(i);
            if (c == '\'') {
                result.append("'");
            } else if (c == '\"') {
                result.append("\\\"");
            } else {
                result.append(C0386o.m1662a(c));
                if (c == '\n' && i + 1 < value.length()) {
                    result.append("\"\n").append(indent).append(indent).append("+ \"");
                }
            }
            i++;
        }
        result.append('\"');
        return result.toString();
    }
}
