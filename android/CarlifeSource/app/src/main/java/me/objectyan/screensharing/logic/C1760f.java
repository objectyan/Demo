package com.baidu.carlife.logic;

import java.io.IOException;
import java.net.HttpURLConnection;

/* compiled from: DownLoader */
/* renamed from: com.baidu.carlife.logic.f */
public abstract class C1760f {
    /* renamed from: a */
    private C1758w f5329a;

    public C1760f(C1758w urlFetcher) {
        this.f5329a = urlFetcher;
    }

    /* renamed from: a */
    public void m6423a(String url, String fileName) throws IOException {
        String diskFilePath = this.f5329a.mo1638a(url, fileName);
        HttpURLConnection conn = this.f5329a.mo1639a(url);
        if (this.f5329a.mo1640b(conn)) {
            mo1643a();
        } else if (this.f5329a.mo1637a(diskFilePath, conn) > 0) {
            mo1642a(diskFilePath);
        }
    }

    /* renamed from: a */
    void mo1642a(String diskFilePath) throws IOException {
    }

    /* renamed from: a */
    void mo1643a() {
    }
}
