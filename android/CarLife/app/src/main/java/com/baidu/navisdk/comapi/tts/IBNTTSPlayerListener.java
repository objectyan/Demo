package com.baidu.navisdk.comapi.tts;

public interface IBNTTSPlayerListener {
    public static final int PLAYER_STATE_ERROR = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_NOT_INIT = 0;
    public static final int PLAYER_STATE_PAUSE = 3;
    public static final int PLAYER_STATE_PLAYING = 2;

    public interface AudioPlayerListener {
        void playCompletion();
    }

    int cancelAudio();

    int getTTSState();

    void initTTSPlayer();

    boolean isNaviMuteState();

    void pauseTTS();

    void phoneCalling();

    void phoneHangUp();

    int playAudio(String str, AudioPlayerListener audioPlayerListener);

    int playTTSText(String str, String str2, int i);

    int playXDTTSText(String str, String str2, int i);

    void releaseTTSPlayer();

    void resumeTTS();

    void setNaviMuteState(boolean z);

    void stopTTS();
}
