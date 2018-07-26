package com.baidu.speech.audio;

import android.media.AudioRecord;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.navisdk.hudsdk.BNRemoteConstants;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.speech.utils.LogUtil;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MicrophoneServer implements Runnable {
    public static String SOCKET_ADDRESS = "com.baidu.speech";
    public static final int S_DATA_LENGTH = 1920000;
    public static final int S_LENGTH = 640;
    public static final String TAG = MicrophoneServer.class.getSimpleName();
    private static HashMap<String, MicrophoneServer> sPorts = new HashMap();
    private static Random sRandom = new Random();
    private boolean firstStart = true;
    private int mAudioSource;
    private DataInputStream mIn = null;
    private String mInfile;
    private ArrayList<SocketWrap> mRemoteOutputStreams = new ArrayList();
    private final int mServerPort;
    private LocalServerSocket mServerSocket;
    private final byte[] sData = new byte[S_DATA_LENGTH];
    private final int sLen = 640;
    private long sLimit = 0;

    public static class MicInputStream extends InputStream {
        private static final int DEFAULT_BUFFER_SIZE = 160000;
        private String TAG = MicInputStream.class.getSimpleName();
        private AudioRecord mAudioRecord;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public MicInputStream(int r10, int r11) {
            /*
            r9 = this;
            r8 = 3;
            r7 = 1;
            r6 = 0;
            r9.<init>();
            r0 = com.baidu.speech.audio.MicrophoneServer.MicInputStream.class;
            r0 = r0.getSimpleName();
            r9.TAG = r0;
            r0 = new android.media.AudioRecord;	 Catch:{ Exception -> 0x00d2 }
            r3 = 16;
            r4 = 2;
            r5 = 160000; // 0x27100 float:2.24208E-40 double:7.90505E-319;
            r1 = r10;
            r2 = r11;
            r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x00d2 }
            r9.mAudioRecord = r0;	 Catch:{ Exception -> 0x00d2 }
            r0 = "audioSource : ";
            r1 = 1;
            r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x00d2 }
            r2 = 0;
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d2 }
            r3.<init>();	 Catch:{ Exception -> 0x00d2 }
            r3 = r3.append(r10);	 Catch:{ Exception -> 0x00d2 }
            r4 = "";
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x00d2 }
            r3 = r3.toString();	 Catch:{ Exception -> 0x00d2 }
            r1[r2] = r3;	 Catch:{ Exception -> 0x00d2 }
            com.baidu.speech.utils.LogUtil.m16433w(r0, r1);	 Catch:{ Exception -> 0x00d2 }
            r0 = r9.TAG;	 Catch:{ Exception -> 0x00d2 }
            r1 = 1;
            r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x00d2 }
            r2 = 0;
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d2 }
            r3.<init>();	 Catch:{ Exception -> 0x00d2 }
            r4 = "startRecordingAndCheckStatus recorder status is ";
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x00d2 }
            r4 = r9.mAudioRecord;	 Catch:{ Exception -> 0x00d2 }
            r4 = r4.getState();	 Catch:{ Exception -> 0x00d2 }
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x00d2 }
            r3 = r3.toString();	 Catch:{ Exception -> 0x00d2 }
            r1[r2] = r3;	 Catch:{ Exception -> 0x00d2 }
            com.baidu.speech.utils.LogUtil.m16420d(r0, r1);	 Catch:{ Exception -> 0x00d2 }
            r0 = r9.mAudioRecord;	 Catch:{ Exception -> 0x00d2 }
            r0.startRecording();	 Catch:{ Exception -> 0x00d2 }
            r0 = 32;
            r1 = new byte[r0];	 Catch:{ Exception -> 0x00d2 }
            r0 = r6;
        L_0x006c:
            r2 = 10;
            if (r0 >= r2) goto L_0x015f;
        L_0x0070:
            r2 = r9.mAudioRecord;	 Catch:{ Exception -> 0x00d2 }
            r3 = 0;
            r4 = r1.length;	 Catch:{ Exception -> 0x00d2 }
            r2 = r2.read(r1, r3, r4);	 Catch:{ Exception -> 0x00d2 }
            if (r2 <= 0) goto L_0x00ca;
        L_0x007a:
            r0 = r6 + r2;
        L_0x007c:
            if (r0 > 0) goto L_0x008b;
        L_0x007e:
            r0 = r9.mAudioRecord;	 Catch:{ Exception -> 0x00d2 }
            r0.release();	 Catch:{ Exception -> 0x00d2 }
            r0 = new java.lang.Exception;	 Catch:{ Exception -> 0x00d2 }
            r1 = "bad recorder, read(byte[])";
            r0.<init>(r1);	 Catch:{ Exception -> 0x00d2 }
        L_0x008b:
            r0 = r9.mAudioRecord;
            if (r0 == 0) goto L_0x0097;
        L_0x008f:
            r0 = r9.mAudioRecord;
            r0 = r0.getRecordingState();
            if (r0 != r8) goto L_0x00a1;
        L_0x0097:
            r0 = r9.mAudioRecord;
            r0 = r0.getState();
            r1 = r9.mAudioRecord;
            if (r0 != 0) goto L_0x00c9;
        L_0x00a1:
            r0 = r9.mAudioRecord;	 Catch:{ Exception -> 0x00cd }
            r0.release();	 Catch:{ Exception -> 0x00cd }
        L_0x00a6:
            r0 = r9.TAG;
            r1 = new java.lang.String[r7];
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "recorder start failed, RecordingState=";
            r2 = r2.append(r3);
            r3 = r9.mAudioRecord;
            r3 = r3.getRecordingState();
            r2 = r2.append(r3);
            r2 = r2.toString();
            r1[r6] = r2;
            com.baidu.speech.utils.LogUtil.m16420d(r0, r1);
        L_0x00c9:
            return;
        L_0x00ca:
            r0 = r0 + 1;
            goto L_0x006c;
        L_0x00cd:
            r0 = move-exception;
            r0.printStackTrace();
            goto L_0x00a6;
        L_0x00d2:
            r0 = move-exception;
            r0.printStackTrace();	 Catch:{ all -> 0x011a }
            r0 = r9.mAudioRecord;
            if (r0 == 0) goto L_0x00e2;
        L_0x00da:
            r0 = r9.mAudioRecord;
            r0 = r0.getRecordingState();
            if (r0 != r8) goto L_0x00ec;
        L_0x00e2:
            r0 = r9.mAudioRecord;
            r0 = r0.getState();
            r1 = r9.mAudioRecord;
            if (r0 != 0) goto L_0x00c9;
        L_0x00ec:
            r0 = r9.mAudioRecord;	 Catch:{ Exception -> 0x0115 }
            r0.release();	 Catch:{ Exception -> 0x0115 }
        L_0x00f1:
            r0 = r9.TAG;
            r1 = new java.lang.String[r7];
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "recorder start failed, RecordingState=";
            r2 = r2.append(r3);
            r3 = r9.mAudioRecord;
            r3 = r3.getRecordingState();
            r2 = r2.append(r3);
            r2 = r2.toString();
            r1[r6] = r2;
            com.baidu.speech.utils.LogUtil.m16420d(r0, r1);
            goto L_0x00c9;
        L_0x0115:
            r0 = move-exception;
            r0.printStackTrace();
            goto L_0x00f1;
        L_0x011a:
            r0 = move-exception;
            r1 = r9.mAudioRecord;
            if (r1 == 0) goto L_0x0127;
        L_0x011f:
            r1 = r9.mAudioRecord;
            r1 = r1.getRecordingState();
            if (r1 != r8) goto L_0x0131;
        L_0x0127:
            r1 = r9.mAudioRecord;
            r1 = r1.getState();
            r2 = r9.mAudioRecord;
            if (r1 != 0) goto L_0x0159;
        L_0x0131:
            r1 = r9.mAudioRecord;	 Catch:{ Exception -> 0x015a }
            r1.release();	 Catch:{ Exception -> 0x015a }
        L_0x0136:
            r1 = r9.TAG;
            r2 = new java.lang.String[r7];
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r4 = "recorder start failed, RecordingState=";
            r3 = r3.append(r4);
            r4 = r9.mAudioRecord;
            r4 = r4.getRecordingState();
            r3 = r3.append(r4);
            r3 = r3.toString();
            r2[r6] = r3;
            com.baidu.speech.utils.LogUtil.m16420d(r1, r2);
        L_0x0159:
            throw r0;
        L_0x015a:
            r1 = move-exception;
            r1.printStackTrace();
            goto L_0x0136;
        L_0x015f:
            r0 = r6;
            goto L_0x007c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.speech.audio.MicrophoneServer.MicInputStream.<init>(int, int):void");
        }

        public void close() throws IOException {
            if (this.mAudioRecord != null) {
                this.mAudioRecord.release();
            }
        }

        public int read() throws IOException {
            throw new IOException("read not support");
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.mAudioRecord == null) {
                throw new IOException("audio recorder is null");
            }
            int read = this.mAudioRecord.read(bArr, i, i2);
            LogUtil.m16427i(this.TAG, " AudioRecord read: len:" + read + " byteOffset:" + i + " byteCount:" + i2);
            if (read >= 0 && read <= i2) {
                return read;
            }
            throw new IOException("audio recdoder read error, len = " + read);
        }
    }

    private static class SocketWrap extends LocalSocket {
        byte[] data = new byte[8];
        private long mPosition = -1;
        private final LocalSocket mSocket;

        public SocketWrap(LocalSocket localSocket) {
            this.mSocket = localSocket;
            try {
                this.mSocket.setSoTimeout(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private long byteArrayToInt(byte[] bArr) {
            byte[] bArr2 = new byte[8];
            int length = bArr2.length - 1;
            int i = 0;
            while (length >= 0) {
                if (i < bArr.length) {
                    bArr2[length] = bArr[i];
                } else {
                    bArr2[length] = (byte) 0;
                }
                length--;
                i++;
            }
            long j = ((long) (bArr2[2] & 255)) << 40;
            long j2 = ((long) (bArr2[3] & 255)) << 32;
            long j3 = ((long) (bArr2[4] & 255)) << 24;
            long j4 = ((long) (bArr2[5] & 255)) << 16;
            long j5 = ((long) (bArr2[6] & 255)) << 8;
            return (((((((((long) (bArr2[0] & 255)) << 56) + (((long) (bArr2[1] & 255)) << 48)) + j) + j2) + j3) + j4) + j5) + ((long) (bArr2[7] & 255));
        }

        public synchronized void close() throws IOException {
            this.mSocket.close();
        }

        public OutputStream getOutputStream() throws IOException {
            return this.mSocket.getOutputStream();
        }

        public long getPosition(long j) {
            if (this.mPosition >= 0) {
                return this.mPosition;
            }
            try {
                this.mSocket.getInputStream().read(this.data, 0, this.data.length);
                long byteArrayToInt = byteArrayToInt(this.data);
                Log.i(MicrophoneServer.TAG, "audio mills is " + byteArrayToInt);
                if (byteArrayToInt > 0) {
                    this.mPosition = ((Math.min(Math.max(0, System.currentTimeMillis() - byteArrayToInt), j / 32) / 20) * 20) * 32;
                } else {
                    this.mPosition = 640;
                }
                this.mPosition = ((j - this.mPosition) + 1920000) % 1920000;
            } catch (Exception e) {
                this.mPosition = ((j - 640) + 1920000) % 1920000;
                e.printStackTrace();
            }
            return this.mPosition;
        }

        public void setPosition(long j) {
            this.mPosition = j;
        }

        public void shutdownOutput() throws IOException {
            this.mSocket.shutdownOutput();
        }
    }

    private MicrophoneServer(String str, int i) throws IOException {
        this.mInfile = str;
        this.mAudioSource = i;
        LogUtil.m16427i(TAG, " infile:" + str + "  audioSource:" + i);
        if (TextUtils.isEmpty(str)) {
            this.mServerSocket = new LocalServerSocket(SOCKET_ADDRESS);
            this.mServerPort = 0;
        } else {
            int nextInt = sRandom.nextInt(1000) + 1;
            LogUtil.m16427i(TAG, "address=" + nextInt);
            this.mServerSocket = new LocalServerSocket(SOCKET_ADDRESS + JNISearchConst.LAYER_ID_DIVIDER + nextInt);
            this.mServerPort = nextInt;
        }
        new Thread("MicrophoneServer") {
            public void run() {
                LocalSocket accept;
                while (true) {
                    try {
                        accept = MicrophoneServer.this.mServerSocket.accept();
                        LogUtil.m16427i(MicrophoneServer.TAG, "server accept socket");
                        synchronized (MicrophoneServer.this.mRemoteOutputStreams) {
                            MicrophoneServer.this.mRemoteOutputStreams.add(new SocketWrap(accept));
                            LogUtil.m16427i(MicrophoneServer.TAG, "add wrap socket, mRemoteOutputStreams size = " + MicrophoneServer.this.mRemoteOutputStreams.size() + " firstStart = " + MicrophoneServer.this.firstStart);
                            if (MicrophoneServer.this.mRemoteOutputStreams.size() == 1 && MicrophoneServer.this.firstStart) {
                                MicrophoneServer.this.firstStart = false;
                                if (MicrophoneServer.this.mIn != null) {
                                    try {
                                        MicrophoneServer.this.mIn.close();
                                        MicrophoneServer.this.mIn = null;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                MicrophoneServer.this.mIn = new DataInputStream(MicrophoneServer.this.createInputStream(MicrophoneServer.this.mInfile, MicrophoneServer.this.mAudioSource));
                                new Thread(MicrophoneServer.this).start();
                            }
                        }
                    } catch (Exception e2) {
                        Exception exception = e2;
                        LogUtil.m16427i(MicrophoneServer.TAG, " ports:" + MicrophoneServer.this.mServerPort + " mRemoteOutputStreams.size：" + MicrophoneServer.this.mRemoteOutputStreams.size());
                        MicrophoneServer.this.firstStart = true;
                        synchronized (MicrophoneServer.this.mRemoteOutputStreams) {
                            Iterator it = MicrophoneServer.this.mRemoteOutputStreams.iterator();
                            while (it.hasNext()) {
                                accept = (LocalSocket) it.next();
                                try {
                                    accept.getOutputStream().close();
                                    accept.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            MicrophoneServer.this.mRemoteOutputStreams.clear();
                            if (MicrophoneServer.this.mIn != null) {
                                try {
                                    MicrophoneServer.this.mIn.close();
                                    MicrophoneServer.this.mIn = null;
                                } catch (Exception e22) {
                                    e22.printStackTrace();
                                }
                            }
                            try {
                                MicrophoneServer.this.mServerSocket.close();
                            } catch (Exception e222) {
                                e222.printStackTrace();
                            }
                            synchronized (MicrophoneServer.sPorts) {
                                MicrophoneServer.sPorts.remove(MicrophoneServer.this.mInfile);
                                exception.printStackTrace();
                                return;
                            }
                        }
                    }
                }
            }
        }.start();
    }

    public static int create(String str, int i) throws IOException {
        int i2;
        LogUtil.m16427i(TAG, "[create] infile:" + str + "  audioSource:" + i);
        synchronized (sPorts) {
            if (((MicrophoneServer) sPorts.get(str)) == null) {
                try {
                    sPorts.put(str, new MicrophoneServer(str, i));
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
            }
            i2 = ((MicrophoneServer) sPorts.get(str)).mServerPort;
        }
        return i2;
    }

    private InputStream createInputStream(String str, int i) throws Exception {
        if (str == null || str.equals("")) {
            return new MicInputStream(i, 16000);
        }
        if (str.startsWith("#")) {
            Matcher matcher = Pattern.compile("^#(.*)[#.](.*?)\\(").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                return (InputStream) Class.forName(group).getMethod(matcher.group(2), new Class[0]).invoke(null, new Object[0]);
            }
            throw new IOException("can not create inputStream");
        } else if (str.startsWith("res://")) {
            return getClass().getResourceAsStream("/" + str.replaceFirst("res://", "").replaceFirst("/", ""));
        } else if (str.startsWith("asset://") || str.startsWith("assets://")) {
            String replaceFirst = str.replaceFirst("assets://", "").replaceFirst("/", "");
            if (str.startsWith("asset://")) {
                replaceFirst = str.replaceFirst("asset://", "").replaceFirst("/", "");
            }
            return getClass().getResourceAsStream("/assets/" + replaceFirst);
        } else if (!str.startsWith("tcp://")) {
            return new FileInputStream(str);
        } else {
            return new Socket(BNRemoteConstants.IPADDR, Integer.parseInt(str.replaceFirst("tcp://", "").replaceFirst("/", ""))).getInputStream();
        }
    }

    public void run() {
        Iterator it;
        LocalSocket localSocket;
        int i = 0;
        while (true) {
            try {
                int length = (int) (this.sLimit % ((long) this.sData.length));
                try {
                    this.mIn.readFully(this.sData, length, 640);
                    this.sLimit += 640;
                    int i2 = length + 640;
                    synchronized (this.mRemoteOutputStreams) {
                        for (int i3 = 0; i3 < this.mRemoteOutputStreams.size(); i3++) {
                            SocketWrap socketWrap = (SocketWrap) this.mRemoteOutputStreams.get(i3);
                            try {
                                int position = (int) (socketWrap.getPosition(this.sLimit) % ((long) this.sData.length));
                                OutputStream outputStream = socketWrap.getOutputStream();
                                int i4 = i2 - position;
                                if (i4 >= 0) {
                                    outputStream.write(this.sData, position, i4);
                                } else {
                                    outputStream.write(this.sData, position, this.sData.length - position);
                                    outputStream.write(this.sData, 0, i2);
                                }
                                socketWrap.setPosition(this.sLimit);
                            } catch (Exception e) {
                                socketWrap.getOutputStream().close();
                                socketWrap.close();
                                this.mRemoteOutputStreams.remove(socketWrap);
                            }
                        }
                        if (this.mRemoteOutputStreams.size() <= 0) {
                            break;
                        }
                    }
                } catch (EOFException e2) {
                    e2.printStackTrace();
                    this.firstStart = true;
                }
            } catch (Exception e3) {
                try {
                    this.firstStart = true;
                    synchronized (this.mRemoteOutputStreams) {
                        while (i < this.mRemoteOutputStreams.size()) {
                            try {
                                byte[] bArr;
                                OutputStream outputStream2 = ((LocalSocket) this.mRemoteOutputStreams.get(i)).getOutputStream();
                                if (TextUtils.isEmpty(this.mInfile)) {
                                    bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
                                } else {
                                    bArr = new byte[6];
                                    bArr = new byte[]{(byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
                                }
                                outputStream2.write(bArr, 0, bArr.length);
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            i++;
                        }
                        synchronized (this.mRemoteOutputStreams) {
                            LogUtil.m16427i(TAG, "finally, mRemoteOutputStreams size = " + this.mRemoteOutputStreams.size() + " firstStart = " + this.firstStart);
                            if (this.firstStart) {
                                it = this.mRemoteOutputStreams.iterator();
                                while (it.hasNext()) {
                                    localSocket = (LocalSocket) it.next();
                                    try {
                                        localSocket.getOutputStream().close();
                                        localSocket.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                this.mRemoteOutputStreams.clear();
                                try {
                                    if (this.mIn != null) {
                                        this.mIn.close();
                                        this.mIn = null;
                                    }
                                } catch (Exception e42) {
                                    e42.printStackTrace();
                                }
                            }
                            return;
                        }
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    synchronized (this.mRemoteOutputStreams) {
                        LogUtil.m16427i(TAG, "finally, mRemoteOutputStreams size = " + this.mRemoteOutputStreams.size() + " firstStart = " + this.firstStart);
                        if (this.firstStart) {
                            Iterator it2 = this.mRemoteOutputStreams.iterator();
                            while (it2.hasNext()) {
                                localSocket = (LocalSocket) it2.next();
                                try {
                                    localSocket.getOutputStream().close();
                                    localSocket.close();
                                } catch (IOException e52) {
                                    e52.printStackTrace();
                                }
                            }
                            this.mRemoteOutputStreams.clear();
                            try {
                                if (this.mIn != null) {
                                    this.mIn.close();
                                    this.mIn = null;
                                }
                            } catch (Exception e422) {
                                e422.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        this.firstStart = true;
        synchronized (this.mRemoteOutputStreams) {
            LogUtil.m16427i(TAG, "finally, mRemoteOutputStreams size = " + this.mRemoteOutputStreams.size() + " firstStart = " + this.firstStart);
            if (this.firstStart) {
                it = this.mRemoteOutputStreams.iterator();
                while (it.hasNext()) {
                    localSocket = (LocalSocket) it.next();
                    try {
                        localSocket.getOutputStream().close();
                        localSocket.close();
                    } catch (IOException e522) {
                        e522.printStackTrace();
                    }
                }
                this.mRemoteOutputStreams.clear();
                try {
                    if (this.mIn != null) {
                        this.mIn.close();
                        this.mIn = null;
                    }
                } catch (Exception e4222) {
                    e4222.printStackTrace();
                }
            }
        }
    }
}
