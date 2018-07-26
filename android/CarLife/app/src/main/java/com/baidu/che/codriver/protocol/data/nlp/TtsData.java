package com.baidu.che.codriver.protocol.data.nlp;

import com.baidu.che.codriver.util.INoProguard;

public class TtsData implements INoProguard {
    public String tts;

    public String getTts() {
        return this.tts;
    }

    public void setTts(String tts) {
        this.tts = tts;
    }

    public String toString() {
        return this.tts;
    }
}
