package com.baidu.che.codriver.protocol;

/* compiled from: HttpListener */
/* renamed from: com.baidu.che.codriver.protocol.d */
public interface C2566d<T> {

    /* compiled from: HttpListener */
    /* renamed from: com.baidu.che.codriver.protocol.d$a */
    public enum C2565a {
        ERROR_REQUEST,
        ERROR_NETWORK,
        ERROR_SERVER,
        ERROR_DATA,
        EEROR_UNKNOWN
    }

    /* renamed from: a */
    void mo1971a(C2565a c2565a);

    /* renamed from: a */
    void mo1972a(T t);
}
