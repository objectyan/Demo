package com.baidu.platform.comjni.util;

import com.baidu.platform.comjni.C2912a;

@Deprecated
public class JNIMD5 extends C2912a {
    public static native String EncodeUrlParamsValue(String str);

    public static native String GetSignMD5String(String str);

    public static native String GetWebSignMD5String(String str);

    public static native String SignOpra(String str);
}
