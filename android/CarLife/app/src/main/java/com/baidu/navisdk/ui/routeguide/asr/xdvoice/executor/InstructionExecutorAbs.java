package com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor;

import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceTTSListener;

public abstract class InstructionExecutorAbs implements InstructionExecutor {
    public abstract void execute(String str, XDVoiceTTSListener xDVoiceTTSListener);

    public void onRelease() {
    }
}
