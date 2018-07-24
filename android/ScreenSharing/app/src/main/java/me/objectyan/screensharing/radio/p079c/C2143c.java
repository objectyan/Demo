package com.baidu.carlife.radio.p079c;

import android.content.res.Resources;
import com.baidu.carlife.R;
import com.baidu.carlife.core.AppContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* compiled from: RadioNewGuideHintUtil */
/* renamed from: com.baidu.carlife.radio.c.c */
public class C2143c {
    /* renamed from: a */
    private static Map<String, String[]> f6825a = new HashMap();
    /* renamed from: b */
    private static Random f6826b = new Random();

    static {
        C2143c.m8084a();
    }

    /* renamed from: a */
    public static void m8084a() {
        Resources resources = AppContext.m3876a().getResources();
        f6825a.put("电台", resources.getStringArray(R.array.guide_for_channel_fm));
        f6825a.put("儿童", resources.getStringArray(R.array.guide_for_channel_ertong));
        f6825a.put("情感", resources.getStringArray(R.array.guide_for_channel_qinggan));
        f6825a.put("听书", resources.getStringArray(R.array.guide_for_channel_tingshu));
        f6825a.put("学习", resources.getStringArray(R.array.guide_for_channel_xuexi));
        f6825a.put("娱乐", resources.getStringArray(R.array.guide_for_channel_yule));
        f6825a.put("新闻", resources.getStringArray(R.array.guide_for_channel_news));
        f6825a.put("每日随心", null);
    }

    /* renamed from: a */
    public static String m8082a(String channel) {
        if (!f6825a.containsKey(channel)) {
            return null;
        }
        if ("每日随心".equals(channel)) {
            f6825a.remove(channel);
            return AppContext.m3876a().getString(R.string.guide_for_channel_suixinting);
        }
        String hint = C2143c.m8083a((String[]) f6825a.get(channel));
        f6825a.remove(channel);
        if (hint.equals("")) {
            return null;
        }
        return "您可以这样说，" + hint;
    }

    /* renamed from: a */
    public static String m8083a(String[] list) {
        if (list == null || list.length <= 0) {
            return "";
        }
        int index = f6826b.nextInt(list.length);
        if (index < list.length) {
            return list[index];
        }
        return "";
    }
}
