package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptorHandler;

public class TtsInterceptorHandler extends AInterceptorHandler {
    public void registerMethods() {
        registerMethod("speak");
        registerMethod("synthesize");
        registerMethod("setTtsListener");
    }
}
