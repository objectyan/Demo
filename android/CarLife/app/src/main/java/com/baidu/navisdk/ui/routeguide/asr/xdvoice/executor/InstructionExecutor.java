package com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor;

import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceTTSListener;

public abstract interface InstructionExecutor
{
  public abstract void execute(String paramString, XDVoiceTTSListener paramXDVoiceTTSListener);
  
  public abstract void onRelease();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/asr/xdvoice/executor/InstructionExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */