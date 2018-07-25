package com.baidu.carlife.core.audio;

import java.util.ArrayList;

/* compiled from: AudioDecoderInterface */
/* renamed from: com.baidu.carlife.core.audio.d */
public interface AudioDecoderInterface {
    /* renamed from: a */
    int getSampleRate();

    /* renamed from: a */
    int changeOutput(Pair pair, int i);

    /* renamed from: a */
    int decodeAudio(String str);

    /* renamed from: a */
    int initialization(String str, ArrayList arrayList);

    /* renamed from: b */
    int getChannelConfig();

    /* renamed from: c */
    int getReSampleRate();
}
