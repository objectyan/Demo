package com.baidu.mapframework.common.p202a;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: LogManager */
/* renamed from: com.baidu.mapframework.common.a.j */
public class C3475j {
    /* renamed from: a */
    static C3473h f18764a = null;
    /* renamed from: b */
    private static final String f18765b = "MAP_LOGGER";
    /* renamed from: c */
    private static final ConcurrentHashMap<String, C3466l> f18766c = new ConcurrentHashMap();

    /* renamed from: a */
    public static void m14918a(C3473h conf) {
        if (f18764a == null) {
            f18764a = conf;
        }
    }

    /* renamed from: a */
    public static synchronized C3466l m14916a(C3471f defaultLevel, String logTag) {
        C3466l logger;
        synchronized (C3475j.class) {
            C3471f level;
            if (defaultLevel == null) {
                level = C3471f.DEBUG;
            } else {
                level = defaultLevel;
            }
            String tag = f18765b;
            if (!(logTag == null || logTag.isEmpty())) {
                tag = logTag;
            }
            if (f18766c.get(tag + level) != null) {
                logger = (C3466l) f18766c.get(tag + level);
                logger.mo2525a();
            } else {
                logger = new C3467b(level, tag);
                f18766c.put(tag + level, logger);
                logger.mo2525a();
            }
        }
        return logger;
    }

    /* renamed from: a */
    public static synchronized void m14917a() {
        synchronized (C3475j.class) {
            for (Entry<String, C3466l> kv : f18766c.entrySet()) {
                if (kv.getValue() != null) {
                    ((C3466l) kv.getValue()).mo2529b();
                }
            }
        }
    }
}
