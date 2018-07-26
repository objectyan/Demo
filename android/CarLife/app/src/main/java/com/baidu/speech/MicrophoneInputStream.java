package com.baidu.speech;

import android.media.AudioRecord;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import com.baidu.speech.audio.MicrophoneServer;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public final class MicrophoneInputStream extends InputStream {
    private static final String TAG = "MicrophoneInputStream";
    private final LocalSocket socket;
    private final InputStream source;

    /* renamed from: com.baidu.speech.MicrophoneInputStream$1 */
    class C49301 implements Callable<LocalSocket> {
        C49301() {
        }

        public LocalSocket call() throws Exception {
            LocalSocket localSocket = new LocalSocket();
            localSocket.connect(new LocalSocketAddress(MicrophoneServer.SOCKET_ADDRESS));
            return localSocket;
        }
    }

    /* renamed from: com.baidu.speech.MicrophoneInputStream$2 */
    class C49312 extends Thread {
        C49312() {
        }

        public void run() {
            byte[] bArr = new byte[640];
            try {
                MicrophoneInputStream.this.socket.getOutputStream().write(0);
                while (true) {
                    MicrophoneInputStream.this.socket.getInputStream().read(bArr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public MicrophoneInputStream() throws IOException {
        this(1, 16000);
    }

    public MicrophoneInputStream(int i) throws IOException {
        this(1, i);
    }

    public MicrophoneInputStream(int i, int i2) throws IOException {
        this(i, i2, null);
    }

    public MicrophoneInputStream(int i, int i2, InputStream inputStream) throws IOException {
        this(i, i2, inputStream, null);
    }

    public MicrophoneInputStream(int i, int i2, InputStream inputStream, AudioRecord audioRecord) throws IOException {
        MicrophoneServer.create("", i);
        try {
            this.socket = (LocalSocket) Executors.newSingleThreadExecutor().submit(new C49301()).get();
            this.source = this.socket.getInputStream();
            new C49312().start();
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }

    public MicrophoneInputStream(int i, InputStream inputStream) throws IOException {
        this(1, i, inputStream);
    }

    public MicrophoneInputStream(AudioRecord audioRecord) throws IOException {
        this(1, 16000, null, audioRecord);
    }

    public void close() throws IOException {
        super.close();
        this.source.close();
        this.socket.close();
    }

    public long mills() {
        return 0;
    }

    public void mills(long j) {
    }

    public int read() throws IOException {
        return 0;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.source.read(bArr, i, i2);
    }
}
