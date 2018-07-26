package com.tencent.mm.sdk.p287b;

import com.baidu.mobstat.Config;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;

/* renamed from: com.tencent.mm.sdk.b.f */
public final class C6100f {
    public final String toString() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length < 4) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 3;
        while (i < stackTrace.length) {
            if (stackTrace[i].getClassName().contains(WXApp.WXAPP_PACKAGE_NAME) && !stackTrace[i].getClassName().contains("sdk.platformtools.Log")) {
                stringBuilder.append("[");
                stringBuilder.append(stackTrace[i].getClassName().substring(15));
                stringBuilder.append(Config.TRACE_TODAY_VISIT_SPLIT);
                stringBuilder.append(stackTrace[i].getMethodName());
                stringBuilder.append("(" + stackTrace[i].getLineNumber() + ")]");
            }
            i++;
        }
        return stringBuilder.toString();
    }
}
