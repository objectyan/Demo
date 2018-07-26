package com.baidu.tts.aop.ttslistener;

import com.baidu.tts.aop.AInterceptorHandler;

public class TtsListenerInterceptorHandler extends AInterceptorHandler {
    public void registerMethods() {
        registerMethod("onSynthesizeDataArrived");
        registerMethod("onPlayProgressUpdate");
    }
}
