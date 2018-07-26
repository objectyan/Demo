package com.baidu.platform.comjni;

/* compiled from: NativeComponent */
/* renamed from: com.baidu.platform.comjni.c */
public abstract class C2913c extends C2912a {
    protected long mNativePointer;

    public abstract long create();

    public abstract int dispose();

    protected void finalize() throws Throwable {
        dispose();
        super.finalize();
    }
}
