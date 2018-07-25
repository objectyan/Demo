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
    private static final String Tag = "audioM3U8decoder";
    /* renamed from: e */
    private static final int f3108e = 7;
    /* renamed from: b */
    private byte[] f3109b = new byte[8192];
    /* renamed from: c */
    private FileInputStream mFileInputStream = null;
    /* renamed from: d */
    private List<String> mAACPaths = new ArrayList();

    M3u8Decoder() {
    }

    /* renamed from: a */
    public int initialization(String url, ArrayList aacFilePaths) {
        this.mAACPaths = aacFilePaths;
        closeFileStream();
        return super.decodeAudio(url);
    }

    /* renamed from: a */
    public synchronized int changeOutput(Pair p, int offset) {
        return crypto(p, offset);
    }

    /* renamed from: n */
    private void closeFileStream() {
        if (this.mFileInputStream != null) {
            try {
                this.mFileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                this.mFileInputStream = null;
            }
        }
    }

    /* renamed from: a */
    private int readDataForStream(byte[] aacDataBuf, int count) throws IOException {
        int totalByteRead = 0;
        while (totalByteRead < count) {
            int byteReadThisTime = this.mFileInputStream.read(aacDataBuf, 0, count);
            if (byteReadThisTime > 0) {
                totalByteRead += byteReadThisTime;
            } else {
                LogUtil.e(Tag, "read data from aac stream fail");
                return -1;
            }
        }
        return totalByteRead;
    }

    /* renamed from: b */
    public synchronized int crypto(Pair p, int pos) {
        int i;
        if (getMediaCodec() == null) {
            LogUtil.e(Tag, "codec is null");
            i = -1;
        } else if (isAACEnough()) {
            LogUtil.e(Tag, "aac file not enough");
            i = -1;
        } else {
            int pcmFrameSize = readPCM();
            if (pcmFrameSize < 0) {
                LogUtil.e(Tag, "pcm frame parse fail");
                i = -1;
            } else {
                i = 0;
                p.setData(getChunk());
                p.setSize(0);
                try {
                    int inputBufIndex = getMediaCodec().dequeueInputBuffer((long) MediaCodecDecoder.m3991d());
                    if (inputBufIndex >= 0 && !getSawInputEOS()) {
                        ByteBuffer dstBuf;
                        if (VERSION.SDK_INT >= 21) {
                            dstBuf = getMediaCodec().getInputBuffer(inputBufIndex);
                        } else {
                            dstBuf = getCodecInputBuffers()[inputBufIndex];
                        }
                        dstBuf.put(this.f3109b, 0, pcmFrameSize);
                        getMediaCodec().queueInputBuffer(inputBufIndex, 0, pcmFrameSize, 0, getSawInputEOS() ? 4 : 0);
                        dstBuf.clear();
                    }
                    int res = getMediaCodec().dequeueOutputBuffer(getBufferInfo(), (long) MediaCodecDecoder.m3991d());
                    if (res >= 0) {
                        ByteBuffer buf;
                        int outputBufIndex = res;
                        if (VERSION.SDK_INT >= 21) {
                            buf = getMediaCodec().getOutputBuffer(outputBufIndex);
                        } else {
                            buf = getCodecOutputBuffers()[outputBufIndex];
                        }
                        int chunkLen = getBufferInfo().size;
                        if (getChunk().length < chunkLen + pos) {
                            setChunk(new byte[(chunkLen + pos)]);
                            p.setData(getChunk());
                        }
                        buf.get(getChunk(), pos, chunkLen);
                        buf.clear();
                        if (chunkLen > 0) {
                            p.setSize(chunkLen);
                            i = chunkLen;
                        }
                        getMediaCodec().releaseOutputBuffer(outputBufIndex, false);
                        if ((getBufferInfo().flags & 4) != 0) {
                            setSawOutputEOS(true);
                        } else {
                            setSawOutputEOS(false);
                        }
                    } else if (VERSION.SDK_INT < 21) {
                        if (res == -3) {
                            setCodecOutputBuffers(getMediaCodec().getOutputBuffers());
                        }
                    } else if (res == -2) {
                        MediaFormat oformat = getMediaCodec().getOutputFormat();
                        setSampleRate(oformat.getInteger("sample-rate"));
                        setChannelConfig(oformat.getInteger("channel-count"));
                        LogUtil.e(Tag, "output format changed new sample rate is " + getSampleRate() + " and new new channel count is " + getChannelConfig());
                        MsgHandlerCenter.dispatchMessage((int) CommonParams.ev);
                    }
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                    LogUtil.e(Tag, "IllegalStateException");
                    m3995a(404);
                    i = -1;
                } catch (IllegalArgumentException e4) {
                    LogUtil.e(Tag, "IllegalArgumentException");
                    e4.printStackTrace();
                    m3995a(404);
                    i = -1;
                } catch (CryptoException e6) {
                    LogUtil.e(Tag, "MediaCodec.CryptoException");
                    e6.printStackTrace();
                    m3995a(404);
                    i = -1;
                }
            }
        }
        return i;
    }

    /* renamed from: o */
    private int readPCM() {
        try {
            return parseUntilPCM();
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.e(Tag, "read pcm io exception");
            return -1;
        }
    }

    /* renamed from: p */
    private int parseUntilPCM() throws IOException {
        int count = 0;
        while (isFisReadBytes(count)) {
            if (readAACFile()) {
                count = readFrameData();
            }
        }
        if (count < 0) {
            LogUtil.e(Tag, "parse until pcm frame read fail");
        }
        return count;
    }

    /* renamed from: q */
    private int readFrameData() throws IOException {
        int pcmFrameSize = readDataForStream(this.f3109b, 7);
        if (pcmFrameSize < 0) {
            LogUtil.d(Tag, "read header fail");
            deleteACCFile();
            return pcmFrameSize;
        } else if (m4023r() < 7) {
            LogUtil.e(Tag, "frame is too short");
            deleteACCFile();
            return -1;
        } else {
            pcmFrameSize = readDataForStream(this.f3109b, m4023r() - 7);
            if (pcmFrameSize < 0) {
                LogUtil.e(Tag, "read frame data fail");
                deleteACCFile();
            }
            return pcmFrameSize;
        }
    }

    /* renamed from: r */
    private int m4023r() {
        return (((this.f3109b[3] & 3) << 11) +
                ((this.f3109b[4] & 255) << 3)) +
                ((this.f3109b[5] & CommonParams.dE) >> 5);
    }

    /* renamed from: s */
    private void deleteACCFile() throws IOException {
        this.mFileInputStream.close();
        this.mFileInputStream = null;
        File file = new File((String) this.mAACPaths.get(0));
        this.mAACPaths.remove(0);
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: t */
    private boolean readAACFile() {
        if (this.mFileInputStream == null) {
            try {
                File file = new File((String) this.mAACPaths.get(0));
                if (file.exists()) {
                    this.mFileInputStream = new FileInputStream(file);
                } else {
                    LogUtil.e(Tag, "aac file not exist");
                    this.mAACPaths.remove(0);
                    return false;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                LogUtil.e(Tag, "aac file not found");
                this.mFileInputStream = null;
                this.mAACPaths.remove(0);
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private boolean isFisReadBytes(int fisReadBytes) {
        return fisReadBytes <= 0 && this.mAACPaths.size() > 0;
    }

    /* renamed from: u */
    private boolean isAACEnough() {
        return this.mAACPaths.size() < 2;
    }
}
