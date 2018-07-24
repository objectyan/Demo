package com.baidu.carlife.logic.voice;

import com.baidu.carlife.R;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
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
        int type = FragmentManagerCallbackProxy.m4757a().getCurrentFragmentType();
        if (FragmentManagerCallbackProxy.m4757a().m4763a(type)) {
            return R.array.tts_record_radio_hint_array;
        }
        if (FragmentManagerCallbackProxy.m4757a().m4769d(type)) {
            return R.array.tts_record_home_hint_array;
        }
        if (FragmentManagerCallbackProxy.m4757a().m4765b(type)) {
            return R.array.tts_record_music_hint_array;
        }
        if (FragmentManagerCallbackProxy.m4757a().m4771e(type)) {
            return R.array.tts_record_phone_hint_array;
        }
        return R.array.tts_record_navi_hint_array;
    }

    /* renamed from: a */
    private static String m7227a(int resId) {
        String[] hintArray = AppContext.m3876a().getResources().getStringArray(resId);
        return hintArray[new Random().nextInt(hintArray.length)];
    }
}
