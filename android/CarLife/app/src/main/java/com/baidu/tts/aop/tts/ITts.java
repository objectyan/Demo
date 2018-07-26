package com.baidu.tts.aop.tts;

import android.content.Context;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.p216j.C4958b;
import com.baidu.tts.p225m.C5142e;
import com.baidu.tts.p225m.C5143f;
import com.baidu.tts.p225m.C5144g;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p225m.C5148j;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p233f.C5095m;

public interface ITts extends C4958b {
    AuthInfo auth(C5095m c5095m);

    int freeCustomResource(C5142e c5142e);

    C5095m getMode();

    TtsListener getTtsListener();

    C5148j getTtsParams();

    int loadCustomResource(C5142e c5142e);

    int loadEnglishModel(C5143f c5143f);

    int loadModel(C5144g c5144g);

    int setAudioStreamType(int i);

    void setContext(Context context);

    void setMode(C5095m c5095m);

    int setParam(C5089g c5089g, String str);

    int setStereoVolume(float f, float f2);

    void setTtsListener(TtsListener ttsListener);

    void speak(C5146i c5146i);

    void synthesize(C5146i c5146i);
}
