package com.baidu.tts.p233f;

import java.net.InetAddress;

/* compiled from: UrlEnum */
/* renamed from: com.baidu.tts.f.o */
public enum C5098o {
    TTS_SERVER("https://tts.baidu.com/text2audio") {
        /* renamed from: b */
        public String mo3881b() {
            String a = C5098o.m17286a("tts.baidu.com");
            if (a != null) {
                return "https://" + a + "/text2audio";
            }
            return null;
        }
    },
    MODEL_SERVER("https://tts.baidu.com/bos/story.php?") {
        /* renamed from: b */
        public String mo3881b() {
            return null;
        }
    },
    STATISTICS_SERVER("https://upl.baidu.com/ttsdlstats.php") {
        /* renamed from: b */
        public String mo3881b() {
            return null;
        }
    };
    
    /* renamed from: d */
    private final String f21201d;

    /* renamed from: b */
    public abstract String mo3881b();

    private C5098o(String str) {
        this.f21201d = str;
    }

    /* renamed from: a */
    public String m17287a() {
        return this.f21201d;
    }

    /* renamed from: a */
    public static String m17286a(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
