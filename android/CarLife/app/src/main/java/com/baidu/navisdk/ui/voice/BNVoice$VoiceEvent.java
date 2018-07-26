package com.baidu.navisdk.ui.voice;

public class BNVoice$VoiceEvent {
    public static final int EVENT_RESTART_NEXT = 1;
    public static final int EVENT_RESTART_NOW = 0;
    public int arg1;
    public int arg2;
    public boolean bool;
    public int event_type;
    public Object obj1;
    public Object obj2;

    public BNVoice$VoiceEvent(int type) {
        this.event_type = type;
    }

    public BNVoice$VoiceEvent(int type, int arg1, Object obj1) {
        this.event_type = type;
        this.arg1 = arg1;
        this.obj1 = obj1;
    }

    public BNVoice$VoiceEvent(int type, int arg1, int arg2, Object obj1, Object obj2) {
        this.event_type = type;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
}
