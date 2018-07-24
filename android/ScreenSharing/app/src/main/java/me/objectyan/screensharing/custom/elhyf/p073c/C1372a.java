package com.baidu.carlife.custom.elhyf.p073c;

import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType;
import java.io.File;

/* compiled from: ReceiveData */
/* renamed from: com.baidu.carlife.custom.elhyf.c.a */
public class C1372a {
    /* renamed from: a */
    private int f4005a;
    /* renamed from: b */
    private DataType f4006b;
    /* renamed from: c */
    private String f4007c;
    /* renamed from: d */
    private int f4008d;
    /* renamed from: e */
    private File f4009e;

    public C1372a(int id, DataType type, String fileName, int totalSize, File file) {
        this.f4005a = id;
        this.f4006b = type;
        this.f4007c = fileName;
        this.f4008d = totalSize;
        this.f4009e = file;
    }

    /* renamed from: a */
    public int m5019a() {
        return this.f4005a;
    }

    /* renamed from: b */
    public DataType m5024b() {
        return this.f4006b;
    }

    /* renamed from: c */
    public String m5026c() {
        return this.f4007c;
    }

    /* renamed from: d */
    public int m5027d() {
        return this.f4008d;
    }

    /* renamed from: e */
    public File m5028e() {
        return this.f4009e;
    }

    /* renamed from: a */
    public void m5020a(int id) {
        this.f4005a = id;
    }

    /* renamed from: a */
    public void m5021a(DataType type) {
        this.f4006b = type;
    }

    /* renamed from: a */
    public void m5023a(String fileName) {
        this.f4007c = fileName;
    }

    /* renamed from: b */
    public void m5025b(int totalSize) {
        this.f4008d = totalSize;
    }

    /* renamed from: a */
    public void m5022a(File file) {
        this.f4009e = file;
    }
}
