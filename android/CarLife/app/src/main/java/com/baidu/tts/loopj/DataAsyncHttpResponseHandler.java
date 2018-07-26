package com.baidu.tts.loopj;

import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.util.ByteArrayBuffer;

public abstract class DataAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "DataAsyncHttpRH";
    protected static final int PROGRESS_DATA_MESSAGE = 7;

    public void onProgressData(byte[] responseBody) {
        AsyncHttpClient.log.mo3894d(LOG_TAG, "onProgressData(byte[]) was not overriden, but callback was received");
    }

    public final void sendProgressDataMessage(byte[] responseBytes) {
        sendMessage(obtainMessage(7, new Object[]{responseBytes}));
    }

    protected void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 7:
                Object[] objArr = (Object[]) message.obj;
                if (objArr == null || objArr.length < 1) {
                    AsyncHttpClient.log.mo3896e(LOG_TAG, "PROGRESS_DATA_MESSAGE didn't got enough params");
                    return;
                }
                try {
                    onProgressData((byte[]) objArr[0]);
                    return;
                } catch (Throwable th) {
                    AsyncHttpClient.log.mo3897e(LOG_TAG, "custom onProgressData contains an error", th);
                    return;
                }
            default:
                return;
        }
    }

    byte[] getResponseData(HttpEntity entity) throws IOException {
        byte[] bArr = null;
        if (entity != null) {
            InputStream content = entity.getContent();
            if (content != null) {
                long contentLength = entity.getContentLength();
                if (contentLength > 2147483647L) {
                    throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
                }
                if (contentLength < 0) {
                    contentLength = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                }
                try {
                    ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer((int) contentLength);
                    byte[] bArr2 = new byte[4096];
                    while (true) {
                        int read = content.read(bArr2);
                        if (read == -1 || Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        byteArrayBuffer.append(bArr2, 0, read);
                        sendProgressDataMessage(copyOfRange(bArr2, 0, read));
                        sendProgressMessage((long) 0, contentLength);
                    }
                    AsyncHttpClient.silentCloseInputStream(content);
                    bArr = byteArrayBuffer.toByteArray();
                } catch (OutOfMemoryError e) {
                    System.gc();
                    throw new IOException("File too large to fit into available memory");
                } catch (Throwable th) {
                    AsyncHttpClient.silentCloseInputStream(content);
                }
            }
        }
        return bArr;
    }

    public static byte[] copyOfRange(byte[] original, int start, int end) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NullPointerException {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int length = original.length;
        if (start < 0 || start > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = end - start;
        length = Math.min(i, length - start);
        Object obj = new byte[i];
        System.arraycopy(original, start, obj, 0, length);
        return obj;
    }
}
