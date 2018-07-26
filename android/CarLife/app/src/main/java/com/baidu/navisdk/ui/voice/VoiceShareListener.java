package com.baidu.navisdk.ui.voice;

import com.baidu.navisdk.ui.voice.model.VoiceShareData;
import java.util.List;

public interface VoiceShareListener {
    void share(List<VoiceShareData> list);
}
