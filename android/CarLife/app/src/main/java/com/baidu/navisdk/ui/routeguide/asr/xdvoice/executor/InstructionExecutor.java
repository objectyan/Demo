package com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor;

import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceTTSListener;

public interface InstructionExecutor {
    void execute(String str, XDVoiceTTSListener xDVoiceTTSListener);

    void onRelease();
}
