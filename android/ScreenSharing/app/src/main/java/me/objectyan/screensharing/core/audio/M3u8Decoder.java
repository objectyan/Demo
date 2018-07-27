package me.objectyan.screensharing.core.audio;

import android.media.MediaCodec.CryptoException;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;

import me.objectyan.screensharing.core.CommonParams;
import me.objectyan.screensharing.core.LogUtil;
import me.objectyan.screensharing.core.MsgHandlerCenter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* 3u8Decoder */
//
class M3u8Decoder extends MediaCodecDecoder {

    private static final String Tag = "audioM3U8decoder";

    private static final int f3108e = 7;

    private byte[] f3109b = new byte[8192];

    private FileInputStream mFileInputStream = null;

    private List<String> mAACPaths = new ArrayList();

    M3u8Decoder() {
    }


    public int initialization(String url, ArrayList aacFilePaths) {
        this.mAACPaths = aacFilePaths;
        closeFileStream();
        return super.decodeAudio(url);
    }


    public synchronized int changeOutput(Pair p, int offset) {
        return crypto(p, offset);
    }


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


    private int readDataForStream(byte[] aacDataBuf, int count) throws IOException {
        int totalByteRead = 0;
        while (totalByteRead < count) {
            int byteReadThisTime = this.mFileInputStream.read(aacDataBuf, 0, count);
            if (byteReadThisTime > 0) {
                totalByteRead += byteReadThisTime;
            } else {
                Log.e(Tag, "read data from aac stream fail");
                return -1;
            }
        }
        return totalByteRead;
    }


    public synchronized int crypto(Pair p, int pos) {
        int i;
        if (getMediaCodec() == null) {
            Log.e(Tag, "codec is null");
            i = -1;
        } else if (isAACEnough()) {
            Log.e(Tag, "aac file not enough");
            i = -1;
        } else {
            int pcmFrameSize = readPCM();
            if (pcmFrameSize < 0) {
                Log.e(Tag, "pcm frame parse fail");
                i = -1;
            } else {
                i = 0;
                p.setData(getChunk());
                p.setSize(0);
                try {
                    int inputBufIndex = getMediaCodec().dequeueInputBuffer((long) MediaCodecDecoder.m3991d());
                    if (inputBufIndex >= 0 && !getSawInputEOS()) {
                        ByteBuffer dstBuf;
                        if (VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
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
                        if (VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
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
                    } else if (VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        if (res == -3) {
                            setCodecOutputBuffers(getMediaCodec().getOutputBuffers());
                        }
                    } else if (res == -2) {
                        MediaFormat oformat = getMediaCodec().getOutputFormat();
                        setSampleRate(oformat.getInteger("sample-rate"));
                        setChannelConfig(oformat.getInteger("channel-count"));
                        Log.e(Tag, "output format changed new sample rate is " + getSampleRate() + " and new new channel count is " + getChannelConfig());
                        MsgHandlerCenter.dispatchMessage((int) CommonParams.ev);
                    }
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                    Log.e(Tag, "IllegalStateException");
                    m3995a(404);
                    i = -1;
                } catch (IllegalArgumentException e4) {
                    Log.e(Tag, "IllegalArgumentException");
                    e4.printStackTrace();
                    m3995a(404);
                    i = -1;
                } catch (CryptoException e6) {
                    Log.e(Tag, "MediaCodec.CryptoException");
                    e6.printStackTrace();
                    m3995a(404);
                    i = -1;
                }
            }
        }
        return i;
    }


    private int readPCM() {
        try {
            return parseUntilPCM();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(Tag, "read pcm io exception");
            return -1;
        }
    }


    private int parseUntilPCM() throws IOException {
        int count = 0;
        while (isFisReadBytes(count)) {
            if (readAACFile()) {
                count = readFrameData();
            }
        }
        if (count < 0) {
            Log.e(Tag, "parse until pcm frame read fail");
        }
        return count;
    }


    private int readFrameData() throws IOException {
        int pcmFrameSize = readDataForStream(this.f3109b, 7);
        if (pcmFrameSize < 0) {
            Log.d(Tag, "read header fail");
            deleteACCFile();
            return pcmFrameSize;
        } else if (m4023r() < 7) {
            Log.e(Tag, "frame is too short");
            deleteACCFile();
            return -1;
        } else {
            pcmFrameSize = readDataForStream(this.f3109b, m4023r() - 7);
            if (pcmFrameSize < 0) {
                Log.e(Tag, "read frame data fail");
                deleteACCFile();
            }
            return pcmFrameSize;
        }
    }


    private int m4023r() {
        return (((this.f3109b[3] & 3) << 11) +
                ((this.f3109b[4] & 255) << 3)) +
                ((this.f3109b[5] & CommonParams.dE) >> 5);
    }


    private void deleteACCFile() throws IOException {
        this.mFileInputStream.close();
        this.mFileInputStream = null;
        File file = new File((String) this.mAACPaths.get(0));
        this.mAACPaths.remove(0);
        if (file.exists()) {
            file.delete();
        }
    }


    private boolean readAACFile() {
        if (this.mFileInputStream == null) {
            try {
                File file = new File((String) this.mAACPaths.get(0));
                if (file.exists()) {
                    this.mFileInputStream = new FileInputStream(file);
                } else {
                    Log.e(Tag, "aac file not exist");
                    this.mAACPaths.remove(0);
                    return false;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Log.e(Tag, "aac file not found");
                this.mFileInputStream = null;
                this.mAACPaths.remove(0);
                return false;
            }
        }
        return true;
    }


    private boolean isFisReadBytes(int fisReadBytes) {
        return fisReadBytes <= 0 && this.mAACPaths.size() > 0;
    }


    private boolean isAACEnough() {
        return this.mAACPaths.size() < 2;
    }
}
