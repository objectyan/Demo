package com.baidu.mapframework.nirvana.assets;

import android.content.Context;
import com.baidu.mapframework.nirvana.C3480g;
import java.io.InputStream;

public class AssetsTask extends C3480g {
    /* renamed from: a */
    private final String f19113a;
    /* renamed from: b */
    private final Context f19114b;
    /* renamed from: c */
    private int f19115c = 2;
    /* renamed from: d */
    private InputStream f19116d;

    public AssetsTask(Context context, String fileName) {
        this.f19114b = context;
        this.f19113a = fileName;
    }

    public InputStream getInputStream() {
        return this.f19116d;
    }

    /* renamed from: a */
    protected void m15131a(InputStream inputStream) {
        this.f19116d = inputStream;
    }

    /* renamed from: a */
    String m15130a() {
        return this.f19113a;
    }

    /* renamed from: b */
    int m15132b() {
        return this.f19115c;
    }

    public void setAccessMode(int accessMode) {
        this.f19115c = accessMode;
    }

    /* renamed from: c */
    Context m15133c() {
        return this.f19114b;
    }
}
