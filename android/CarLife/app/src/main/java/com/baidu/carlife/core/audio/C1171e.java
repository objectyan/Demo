package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.C1260i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: AudioFilePipeLine */
/* renamed from: com.baidu.carlife.core.audio.e */
public class C1171e {
    /* renamed from: a */
    private static final String f3032a = "AudioFilePipeLine";
    /* renamed from: c */
    private static final int f3033c = 10;
    /* renamed from: b */
    private LinkedBlockingQueue<String> f3034b;

    /* compiled from: AudioFilePipeLine */
    /* renamed from: com.baidu.carlife.core.audio.e$a */
    private static class C1170a {
        /* renamed from: a */
        static final C1171e f3031a = new C1171e();

        private C1170a() {
        }
    }

    private C1171e() {
        this.f3034b = new LinkedBlockingQueue(10);
    }

    /* renamed from: a */
    public static C1171e m3916a() {
        return C1170a.f3031a;
    }

    /* renamed from: b */
    public void m3920b() {
        m3917e();
        this.f3034b.clear();
    }

    /* renamed from: e */
    private void m3917e() {
        List<String> paths = new ArrayList();
        this.f3034b.drainTo(paths);
        for (String path : paths) {
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /* renamed from: a */
    public void m3918a(String path) {
        try {
            this.f3034b.put(path);
        } catch (InterruptedException e) {
            e.printStackTrace();
            C1260i.m4445e(f3032a, "InterruptedException in put, message is " + e.getMessage());
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            C1260i.m4445e(f3032a, "NullPointerException in put, message is " + e2.getMessage());
        }
    }

    /* renamed from: c */
    public String m3921c() {
        try {
            return (String) this.f3034b.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            C1260i.m4445e(f3032a, "InterruptedException in take, message is " + e.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    public void m3919a(List<String> paths) {
        this.f3034b.drainTo(paths);
    }

    /* renamed from: d */
    public int m3922d() {
        return this.f3034b.size();
    }
}
