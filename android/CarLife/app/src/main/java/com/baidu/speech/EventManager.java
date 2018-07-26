package com.baidu.speech;

public interface EventManager {
    void registerListener(EventListener eventListener);

    void send(String str, String str2, byte[] bArr, int i, int i2);

    void unregisterListener(EventListener eventListener);
}
