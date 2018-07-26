package com.baidu.che.codriver.p123i;

import android.text.TextUtils;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.sdk.p081a.C2578b;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;

/* compiled from: RawTextUtils */
/* renamed from: com.baidu.che.codriver.i.b */
public class C2545b {
    /* renamed from: a */
    private static final String f8404a = "RawTextUtils";

    /* renamed from: a */
    public static String m9647a(String params, String rawText) {
        String replaceText = C2545b.m9646a(rawText);
        if (replaceText == null) {
            return params;
        }
        params = params.replaceAll(rawText, replaceText);
        C2725h.m10207b(f8404a, "replaceJson params = " + params + ";replaceText = " + replaceText);
        return params;
    }

    /* renamed from: a */
    public static String m9646a(String rawText) {
        if (rawText.length() == 1) {
            return C2545b.m9648b(rawText);
        }
        return null;
    }

    /* renamed from: b */
    public static String m9648b(String text) {
        String pinyinText = C2716c.m10160f(text);
        C2725h.m10207b(f8404a, "rawText = " + text + ";pinyinText = " + pinyinText);
        if (C2545b.m9649b(pinyinText, "YI")) {
            return "1";
        }
        if (C2545b.m9649b(pinyinText, "ER|E")) {
            return "2";
        }
        if (C2545b.m9649b(pinyinText, "SAN|SHAN|SANG|SHANG|ZHANG|ZANG|ZHAN")) {
            return "3";
        }
        if (C2545b.m9649b(pinyinText, "SI")) {
            return "4";
        }
        if (C2545b.m9649b(pinyinText, "WU|WO")) {
            return "5";
        }
        if (C2545b.m9649b(pinyinText, "LIU|LU")) {
            return C2578b.f8568g;
        }
        if (C2545b.m9649b(pinyinText, "QI|QU")) {
            return "7";
        }
        if (C2545b.m9649b(pinyinText, "BA")) {
            return NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL;
        }
        if (C2545b.m9649b(pinyinText, "JIU")) {
            return "9";
        }
        if (C2545b.m9649b(pinyinText, "SHI")) {
            return C2142b.f6818b;
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m9649b(String src, String regex) {
        if (TextUtils.isEmpty(regex) || TextUtils.isEmpty(src)) {
            return false;
        }
        return src.matches(regex);
    }
}
