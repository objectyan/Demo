package com.facebook.common.p259i;

/* compiled from: SoLoaderShim */
/* renamed from: com.facebook.common.i.a */
public class C5335a {
    /* renamed from: a */
    private static volatile C5332b f21915a = new C5334a();

    /* compiled from: SoLoaderShim */
    /* renamed from: com.facebook.common.i.a$b */
    public interface C5332b {
        /* renamed from: a */
        void mo4018a(String str);
    }

    /* compiled from: SoLoaderShim */
    /* renamed from: com.facebook.common.i.a$1 */
    static class C53331 implements C5332b {
        C53331() {
        }

        /* renamed from: a */
        public void mo4018a(String libraryName) {
        }
    }

    /* compiled from: SoLoaderShim */
    /* renamed from: com.facebook.common.i.a$a */
    public static class C5334a implements C5332b {
        /* renamed from: a */
        public void mo4018a(String libraryName) {
            System.loadLibrary(libraryName);
        }
    }

    /* renamed from: a */
    public static void m18263a(C5332b handler) {
        if (handler == null) {
            throw new NullPointerException("Handler cannot be null");
        }
        f21915a = handler;
    }

    /* renamed from: a */
    public static void m18264a(String libraryName) {
        f21915a.mo4018a(libraryName);
    }

    /* renamed from: a */
    public static void m18262a() {
        C5335a.m18263a(new C53331());
    }
}
