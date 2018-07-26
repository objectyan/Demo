package com.p015a.p016a;

import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.lang.model.SourceVersion;

/* compiled from: NameAllocator */
/* renamed from: com.a.a.i */
public final class C0374i implements Cloneable {
    /* renamed from: a */
    private final Set<String> f1203a;
    /* renamed from: b */
    private final Map<Object, String> f1204b;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m1539a();
    }

    public C0374i() {
        this(new LinkedHashSet(), new LinkedHashMap());
    }

    private C0374i(LinkedHashSet<String> allocatedNames, LinkedHashMap<Object, String> tagToName) {
        this.f1203a = allocatedNames;
        this.f1204b = tagToName;
    }

    /* renamed from: a */
    public String m1541a(String suggestion) {
        return m1542a(suggestion, UUID.randomUUID().toString());
    }

    /* renamed from: a */
    public String m1542a(String suggestion, Object tag) {
        C0386o.m1661a((Object) suggestion, "suggestion", new Object[0]);
        C0386o.m1661a(tag, "tag", new Object[0]);
        suggestion = C0374i.m1538b(suggestion);
        while (true) {
            if (!SourceVersion.isKeyword(suggestion) && this.f1203a.add(suggestion)) {
                break;
            }
            suggestion = suggestion + JNISearchConst.LAYER_ID_DIVIDER;
        }
        String replaced = (String) this.f1204b.put(tag, suggestion);
        if (replaced == null) {
            return suggestion;
        }
        this.f1204b.put(tag, replaced);
        throw new IllegalArgumentException("tag " + tag + " cannot be used for both '" + replaced + "' and '" + suggestion + "'");
    }

    /* renamed from: b */
    public static String m1538b(String suggestion) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < suggestion.length()) {
            int codePoint = suggestion.codePointAt(i);
            if (i == 0 && !Character.isJavaIdentifierStart(codePoint) && Character.isJavaIdentifierPart(codePoint)) {
                result.append(JNISearchConst.LAYER_ID_DIVIDER);
            }
            result.appendCodePoint(Character.isJavaIdentifierPart(codePoint) ? codePoint : 95);
            i += Character.charCount(codePoint);
        }
        return result.toString();
    }

    /* renamed from: a */
    public String m1540a(Object tag) {
        String result = (String) this.f1204b.get(tag);
        if (result != null) {
            return result;
        }
        throw new IllegalArgumentException("unknown tag: " + tag);
    }

    /* renamed from: a */
    public C0374i m1539a() {
        return new C0374i(new LinkedHashSet(this.f1203a), new LinkedHashMap(this.f1204b));
    }
}
