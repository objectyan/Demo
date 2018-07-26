package com.baidu.carlife.logic.voice;

import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.screen.presentation.C1328h;
import java.util.Random;

/* compiled from: GuideContentStrategy */
/* renamed from: com.baidu.carlife.logic.voice.b */
public class C1888b {
    /* renamed from: a */
    public static String m7226a() {
        return C1888b.m7227a(C1888b.m7228b());
    }

    /* renamed from: b */
    private static int m7228b() {
        int type = C1328h.m4757a().getCurrentFragmentType();
        if (C1328h.m4757a().m4763a(type)) {
            return C0965R.array.tts_record_radio_hint_array;
        }
        if (C1328h.m4757a().m4769d(type)) {
            return C0965R.array.tts_record_home_hint_array;
        }
        if (C1328h.m4757a().m4765b(type)) {
            return C0965R.array.tts_record_music_hint_array;
        }
        if (C1328h.m4757a().m4771e(type)) {
            return C0965R.array.tts_record_phone_hint_array;
        }
        return C0965R.array.tts_record_navi_hint_array;
    }

    /* renamed from: a */
    private static String m7227a(int resId) {
        String[] hintArray = C1157a.m3876a().getResources().getStringArray(resId);
        return hintArray[new Random().nextInt(hintArray.length)];
    }
}
