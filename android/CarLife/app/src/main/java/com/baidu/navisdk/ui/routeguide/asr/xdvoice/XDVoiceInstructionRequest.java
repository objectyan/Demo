package com.baidu.navisdk.ui.routeguide.asr.xdvoice;

import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionParams.VoiceInstructionType;

public class XDVoiceInstructionRequest {
    public String subAction;
    public int topType;

    public XDVoiceInstructionRequest(String instructionType) {
        paseInstruction(instructionType);
    }

    private void paseInstruction(String instructionType) {
        if (VoiceInstructionType.REMAINING_TIME.equals(instructionType)) {
            this.topType = 4;
        } else if (VoiceInstructionType.REMAINING_DISTANCE.equals(instructionType)) {
            this.topType = 4;
        } else if (VoiceInstructionType.REMAINING_DISTANCE_AND_TIME.equals(instructionType)) {
            this.topType = 4;
        } else if (VoiceInstructionType.TRAFFIC_INFO.equals(instructionType)) {
            this.topType = 4;
        } else if (VoiceInstructionType.EXIT_NAVIGATION.equals(instructionType)) {
            this.topType = 6;
        } else if (VoiceInstructionType.CHANGE_FASTER_ROUTE.equals(instructionType)) {
            this.topType = 6;
        } else if (VoiceInstructionType.AVOID_CONGESTION.equals(instructionType)) {
            this.topType = 6;
        } else {
            this.topType = 0;
        }
        this.subAction = instructionType;
    }
}
