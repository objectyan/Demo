package com.baidu.navisdk.ui.routeguide.asr.xdvoice;

public class XDVoiceInstructionResponse {
    private boolean bPreempt = true;
    private String errorContent;
    private Object extra;
    private boolean hasRound2;
    private RetState retState;
    private String roundValue;
    private String voiceContent;

    public enum RetState {
        SUCCESS,
        INVALID
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public XDVoiceInstructionResponse(RetState mRetState, String mVoiceContent) {
        this.voiceContent = mVoiceContent;
        this.retState = mRetState;
    }

    public String getVoiceContent() {
        return this.voiceContent;
    }

    public void setVoiceContent(String mVoiceContent) {
        this.voiceContent = mVoiceContent;
    }

    public RetState getResponseState() {
        return this.retState;
    }

    public void setResponseState(RetState mRetState) {
        this.retState = mRetState;
    }

    public RetState getRetState() {
        return this.retState;
    }

    public void setRetState(RetState retState) {
        this.retState = retState;
    }

    public boolean isbPreempt() {
        return this.bPreempt;
    }

    public void setbPreempt(boolean bPreempt) {
        this.bPreempt = bPreempt;
    }

    public boolean isHasRound2() {
        return this.hasRound2;
    }

    public void setHasRound2(boolean hasRound2) {
        this.hasRound2 = hasRound2;
    }

    public String getRoundValue() {
        return this.roundValue;
    }

    public void setRoundValue(String roundValue) {
        this.roundValue = roundValue;
    }

    public String getErrorContent() {
        return this.errorContent;
    }

    public void setErrorContent(String errorContent) {
        this.errorContent = errorContent;
    }
}
