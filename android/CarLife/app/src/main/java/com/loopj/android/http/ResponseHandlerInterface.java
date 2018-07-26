package com.loopj.android.http;

import cz.msebera.android.httpclient.C6228x;
import cz.msebera.android.httpclient.C6327f;
import java.io.IOException;
import java.net.URI;

public interface ResponseHandlerInterface {
    C6327f[] getRequestHeaders();

    URI getRequestURI();

    Object getTag();

    boolean getUsePoolThread();

    boolean getUseSynchronousMode();

    void onPostProcessResponse(ResponseHandlerInterface responseHandlerInterface, C6228x c6228x);

    void onPreProcessResponse(ResponseHandlerInterface responseHandlerInterface, C6228x c6228x);

    void sendCancelMessage();

    void sendFailureMessage(int i, C6327f[] c6327fArr, byte[] bArr, Throwable th);

    void sendFinishMessage();

    void sendProgressMessage(long j, long j2);

    void sendResponseMessage(C6228x c6228x) throws IOException;

    void sendRetryMessage(int i);

    void sendStartMessage();

    void sendSuccessMessage(int i, C6327f[] c6327fArr, byte[] bArr);

    void setRequestHeaders(C6327f[] c6327fArr);

    void setRequestURI(URI uri);

    void setTag(Object obj);

    void setUsePoolThread(boolean z);

    void setUseSynchronousMode(boolean z);
}
