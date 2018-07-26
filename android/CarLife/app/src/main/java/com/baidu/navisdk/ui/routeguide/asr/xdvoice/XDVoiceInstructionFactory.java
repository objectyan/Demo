package com.baidu.navisdk.ui.routeguide.asr.xdvoice;

import com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor.InstructionExecutor;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor.XDNavOperationInstruction;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor.XDQueryInstruction;

public class XDVoiceInstructionFactory {
    public static InstructionExecutor createInstructExecutor(int topType) {
        InstructionExecutor instructionExecutor;
        switch (topType) {
            case 4:
                instructionExecutor = new XDQueryInstruction();
                break;
            case 6:
                instructionExecutor = new XDNavOperationInstruction();
                break;
            default:
                return null;
        }
        return instructionExecutor;
    }
}
