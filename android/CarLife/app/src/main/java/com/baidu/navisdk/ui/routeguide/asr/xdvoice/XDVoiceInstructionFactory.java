package com.baidu.navisdk.ui.routeguide.asr.xdvoice;

import com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor.InstructionExecutor;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor.XDNavOperationInstruction;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor.XDQueryInstruction;

public class XDVoiceInstructionFactory
{
  public static InstructionExecutor createInstructExecutor(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return null;
    }
    for (Object localObject = new XDQueryInstruction();; localObject = new XDNavOperationInstruction()) {
      return (InstructionExecutor)localObject;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/asr/xdvoice/XDVoiceInstructionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */