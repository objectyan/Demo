package com.baidu.carlife.core.audio;

import android.media.MediaCodec.CryptoException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: M3u8Decoder */
/* renamed from: com.baidu.carlife.core.audio.j */
class M3u8Decoder extends MediaCodecDecoder {
    /* renamed from: a */
    private static final String f3107a = "audioM3U8decoder";
    /* renamed from: e */
    private static final int f3108e = 7;
    /* renamed from: b */
    private byte[] f3109b = new byte[8192];
    /* renamed from: c */
    private FileInputStream f3110c = null;
    /* renamed from: d */
    private List<String> f3111d = new ArrayList();

    M3u8Decoder() {
    }

    /* renamed from: a */
    public int mo1445a(String url, ArrayList aacFilePaths) {
        this.f3111d = aacFilePaths;
        m4019n();
        return super.mo1444a(url);
    }

    /* renamed from: a */
    public synchronized int mo1443a(Pair p, int offset) {
        return m4029b(p, offset);
    }

    /* renamed from: n */
    private void m4019n() {
        if (this.f3110c != null) {
            try {
                this.f3110c.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                this.f3110c = null;
            }
        }
    }

    /* renamed from: a */
    private int m4017a(byte[] aacDataBuf, int count) throws IOException {
        int totalByteRead = 0;
        while (totalByteRead < count) {
            int byteReadThisTime = this.f3110c.read(aacDataBuf, 0, count);
            if (byteReadThisTime > 0) {
                totalByteRead += byteReadThisTime;
            } else {
                LogUtil.m4445e(f3107a, "read data from aac stream fail");
                return -1;
            }
        }
        return totalByteRead;
    }

    /* renamed from: b */
    public synchronized int m4029b(Pair p, int pos) {
        int i;
        if (m4008e() == null) {
            LogUtil.m4445e(f3107a, "codec is null");
            i = -1;
        } else if (m4026u()) {
            LogUtil.m4445e(f3107a, "aac file not enough");
            i = -1;
        } else {
            int pcmFrameSize = m4020o();
            if (pcmFrameSize < 0) {
                LogUtil.m4445e(f3107a, "pcm frame parse fail");
                i = -1;
            } else {
                i = 0;
                p.m4056a(m4016m());
                p.m4055a(0);
                try {
                    int inputBufIndex = m4008e().dequeueInputBuffer((long) MediaCodecDecoder.m3991d());
                    if (inputBufIndex >= 0 && !m4012i()) {
                        ByteBuffer dstBuf;
                        if (VERSION.SDK_INT >= 21) {
                            dstBuf = m4008e().getInputBuffer(inputBufIndex);
                        } else {
                            dstBuf = m4013j()[inputBufIndex];
                        }
                        dstBuf.put(this.f3109b, 0, pcmFrameSize);
                        m4008e().queueInputBuffer(inputBufIndex, 0, pcmFrameSize, 0, m4012i() ? 4 : 0);
                        dstBuf.clear();
                    }
                    int res = m4008e().dequeueOutputBuffer(m4010g(), (long) MediaCodecDecoder.m3991d());
                    if (res >= 0) {
                        ByteBuffer buf;
                        int outputBufIndex = res;
                        if (VERSION.SDK_INT >= 21) {
                            buf = m4008e().getOutputBuffer(outputBufIndex);
                        } else {
                            buf = m4014k()[outputBufIndex];
                        }
                        int chunkLen = m4010g().size;
                        if (m4016m().length < chunkLen + pos) {
                            m4000a(new byte[(chunkLen + pos)]);
                            p.m4056a(m4016m());
                        }
                        buf.get(m4016m(), pos, chunkLen);
                        buf.clear();
                        if (chunkLen > 0) {
                            p.m4055a(chunkLen);
                            i = chunkLen;
                        }
                        m4008e().releaseOutputBuffer(outputBufIndex, false);
                        if ((m4010g().flags & 4) != 0) {
                            m3999a(true);
                        } else {
                            m3999a(false);
                        }
                    } else if (VERSION.SDK_INT < 21) {
                        if (res == -3) {
                            m4005b(m4008e().getOutputBuffers());
                        }
                    } else if (res == -2) {
                        MediaFormat oformat = m4008e().getOutputFormat();
                        m4003b(oformat.getInteger("sample-rate"));
                        m4007c(oformat.getInteger("channel-count"));
                        LogUtil.m4445e(f3107a, "output format changed new sample rate is " + mo1442a() + " and new new channel count is " + mo1446b());
                        MsgHandlerCenter.m4461b((int) CommonParams.ev);
                    }
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                    LogUtil.m4445e(f3107a, "IllegalStateException");
                    m3995a(404);
                    i = -1;
                } catch (IllegalArgumentException e4) {
                    LogUtil.m4445e(f3107a, "IllegalArgumentException");
                    e4.printStackTrace();
                    m3995a(404);
                    i = -1;
                } catch (CryptoException e6) {
                    LogUtil.m4445e(f3107a, "MediaCodec.CryptoException");
                    e6.printStackTrace();
                    m3995a(404);
                    i = -1;
                }
            }
        }
        return i;
    }

    /* renamed from: o */
    private int m4020o() {
        try {
            return m4021p();
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.m4445e(f3107a, "read pcm io exception");
            return -1;
        }
    }

    /* renamed from: p */
    private int m4021p() throws IOException {
        int count = 0;
        while (m4018d(count)) {
            if (m4025t()) {
                count = m4022q();
            }
        }
        if (count < 0) {
            LogUtil.m4445e(f3107a, "parse until pcm frame read fail");
        }
        return count;
    }

    /* renamed from: q */
    private int m4022q() throws IOException {
        int pcmFrameSize = m4017a(this.f3109b, 7);
        if (pcmFrameSize < 0) {
            LogUtil.d(f3107a, "read header fail");
            m4024s();
            return pcmFrameSize;
        } else if (m4023r() < 7) {
            LogUtil.m4445e(f3107a, "frame is too short");
            m4024s();
            return -1;
        } else {
            pcmFrameSize = m4017a(this.f3109b, m4023r() - 7);
            if (pcmFrameSize < 0) {
                LogUtil.m4445e(f3107a, "read frame data fail");
                m4024s();
            }
            return pcmFrameSize;
        }
    }

    /* renamed from: r */
    private int m4023r() {
        return (((this.f3109b[3] & 3) << 11) + ((this.f3109b[4] & 255) << 3)) + ((this.f3109b[5] & CommonParams.dE) >> 5);
    }

    /* renamed from: s */
    private void m4024s() throws IOException {
        this.f3110c.close();
        this.f3110c = null;
        File file = new File((String) this.f3111d.get(0));
        this.f3111d.remove(0);
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: t */
    private boolean m4025t() {
        if (this.f3110c == null) {
            try {
                File file = new File((String) this.f3111d.get(0));
                if (file.exists()) {
                    this.f3110c = new FileInputStream(file);
                } else {
                    LogUtil.m4445e(f3107a, "aac file not exist");
                    this.f3111d.remove(0);
                    return false;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                LogUtil.m4445e(f3107a, "aac file not found");
                this.f3110c = null;
                this.f3111d.remove(0);
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private boolean m4018d(int fisReadBytes) {
        return fisReadBytes <= 0 && this.f3111d.size() > 0;
    }

    /* renamed from: u */
    private boolean m4026u() {
        return this.f3111d.size() < 2;
    }
}
