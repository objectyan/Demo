package com.baidu.carlife.custom.elhyf.p073c;

import com.baidu.carlife.custom.elhyf.p073c.C1381d.C1359a;
import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType;
import java.io.InputStream;

/* compiled from: TransferData */
/* renamed from: com.baidu.carlife.custom.elhyf.c.c */
public class C1377c {
    /* renamed from: a */
    private String f4027a;
    /* renamed from: b */
    private DataType f4028b;
    /* renamed from: c */
    private C1359a f4029c;
    /* renamed from: d */
    private InputStream f4030d;

    /* renamed from: a */
    public String m5060a() {
        return this.f4027a;
    }

    /* renamed from: b */
    public DataType m5065b() {
        return this.f4028b;
    }

    /* renamed from: c */
    public C1359a m5066c() {
        return this.f4029c;
    }

    /* renamed from: d */
    public InputStream m5067d() {
        return this.f4030d;
    }

    /* renamed from: a */
    public void m5064a(String fileName) {
        this.f4027a = fileName;
    }

    /* renamed from: a */
    public void m5062a(DataType type) {
        this.f4028b = type;
    }

    /* renamed from: a */
    public void m5061a(C1359a transferDataListener) {
        this.f4029c = transferDataListener;
    }

    /* renamed from: a */
    public void m5063a(InputStream inputStream) {
        this.f4030d = inputStream;
    }
}
