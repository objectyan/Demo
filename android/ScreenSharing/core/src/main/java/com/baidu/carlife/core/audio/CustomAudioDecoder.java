package com.baidu.carlife.core.audio;

import android.media.AudioTrack;
import android.util.Log;

import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;

/* compiled from: CustomAudioDecoder */
/* renamed from: com.baidu.carlife.core.audio.g */
public class CustomAudioDecoder {
    /* renamed from: a */
    private static final String Tag = (AudioUtil.AUDIO + CustomAudioDecoder.class.getSimpleName());
    /* renamed from: b */
    private int mSampleRate;
    /* renamed from: c */
    private int mChannelConfig;
    /* renamed from: d */
    private int mReSampleRate;
    /* renamed from: e */
    private AudioTrack mAudioTrack;
    /* renamed from: f */
    private int mWeiChatVol = 0;
    /* renamed from: g */
    private AudioDecoderInterface mMediaCodecDecoder = new MediaCodecDecoder();
    /* renamed from: h */
    private Pair mPairOne = new Pair();
    /* renamed from: i */
    private Pair mPairTwo = new Pair();
    /* renamed from: j */
    private byte[] decoderOut = null;
    /* renamed from: k */
    private Object mObject = new Object();

    /* renamed from: a */
    public boolean init(String filePath) {
        synchronized (this.mObject) {
            LogUtil.d(Tag, "init() is called");
            if (this.mMediaCodecDecoder.initialization(filePath, null) == -1) {
                Log.i(Tag, "MediaCodec initialization is failed!");
            } else {
                Log.i(Tag, "wechat initialization is successed!");
            }
        }
        if (8000 != this.mMediaCodecDecoder.getSampleRate()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public byte[] getDecoderOut() {
        int nCount = 0;
        this.decoderOut = null;
        while (nCount < 5) {
            this.mWeiChatVol = this.mMediaCodecDecoder.changeOutput(this.mPairOne, 0);
            LogUtil.d(Tag, "Get WeChat Vol:" + this.mWeiChatVol);
            if (this.mWeiChatVol > 0) {
                break;
            } else if (-1 == this.mWeiChatVol) {
                try {
                    synchronized (this.mObject) {
                        this.mObject.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                nCount++;
                LogUtil.d(Tag, "MediaCodec Error happen!");
            } else if (this.mWeiChatVol == 0) {
                nCount++;
            }
        }
        if (this.mPairOne.getSize() != this.mWeiChatVol) {
            LogUtil.e(Tag, "Get Audio size Error =" + this.mPairOne.getSize() + "  Return=" + this.mWeiChatVol);
        }
        if (this.mWeiChatVol <= 0) {
            return null;
        }
        this.decoderOut = new byte[(this.mPairOne.getSize() * 2)];
        byte[] dataIn = this.mPairOne.getData();
        LogUtil.d(Tag, "decoder out :" + this.mWeiChatVol);
        for (int i = 0; i < this.mWeiChatVol; i += 2) {
            this.decoderOut[i * 2] = dataIn[i];
            this.decoderOut[(i * 2) + 1] = dataIn[i + 1];
            this.decoderOut[(i * 2) + 2] = dataIn[i];
            this.decoderOut[(i * 2) + 3] = dataIn[i + 1];
        }
        return this.decoderOut;
    }

    /* renamed from: b */
    public void initAudioTrack() {
        if (createAudioTrack()) {
            ArbitrationModule.newInstance().musicAudioFocus();
            playAudioTrack();
            return;
        }
        LogUtil.d(Tag, "audio Track Init Error!!!");
    }

    /* renamed from: c */
    public void m3941c() {
        int nCount = 0;
        while (nCount < 8) {
            long lstarttime = System.currentTimeMillis();
            this.mWeiChatVol = this.mMediaCodecDecoder.changeOutput(this.mPairOne, 0);
            LogUtil.d(Tag, "Get WeChat Vol:" + this.mWeiChatVol);
            if (-1 == this.mWeiChatVol) {
                try {
                    synchronized (this.mObject) {
                        this.mObject.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                nCount++;
                LogUtil.d(Tag, "MediaCodec Error happen!");
            } else if (this.mWeiChatVol == 0) {
                nCount++;
            } else {
                if (this.mPairOne.getSize() != this.mWeiChatVol) {
                    LogUtil.e(Tag, "Get Audio size Error =" + this.mPairOne.getSize() + "  Return=" + this.mWeiChatVol);
                }
                nCount = 0;
                this.decoderOut = new byte[(this.mPairOne.getSize() * 2)];
                this.mPairTwo.setSize(this.mPairOne.getSize() * 2);
                this.mPairTwo.setData(this.decoderOut);
                byte[] dataIn = this.mPairOne.getData();
                for (int i = 0; i < this.mWeiChatVol; i += 2) {
                    this.decoderOut[i * 2] = dataIn[i];
                    this.decoderOut[(i * 2) + 1] = dataIn[i + 1];
                    this.decoderOut[(i * 2) + 2] = dataIn[i];
                    this.decoderOut[(i * 2) + 3] = dataIn[i + 1];
                }
                LogUtil.d(Tag, "Use Time :" + (System.currentTimeMillis() - lstarttime));
                writeAudioData();
            }
        }
    }

    /* renamed from: d */
    public void stop() {
        synchronized (this.mObject) {
            LogUtil.d(Tag, "stop() is called");
            if (this.mAudioTrack == null) {
                return;
            }
            try {
                this.mAudioTrack.stop();
            } catch (IllegalStateException e) {
                MsgHandlerCenter.dispatchMessage(415);
                e.printStackTrace();
            }
            this.mAudioTrack.release();
            this.mAudioTrack = null;
        }
    }

    /* renamed from: e */
    public void play() {
        synchronized (this.mObject) {
            ArbitrationModule.newInstance().musicAudioFocus();
            LogUtil.d(Tag, "play() is called");
            if (this.mAudioTrack == null || this.mAudioTrack.getPlayState() == 3) {
                LogUtil.d(Tag, "play music has been triggered");
            } else {
                playAudioTrack();
            }
        }
    }

    /* renamed from: g */
    private boolean createAudioTrack() {
        int channelConfig;
        this.mSampleRate = this.mMediaCodecDecoder.getSampleRate();
        if (this.mSampleRate == 8000) {
            this.mSampleRate *= 2;
        }
        this.mChannelConfig = this.mMediaCodecDecoder.getChannelConfig();
        this.mReSampleRate = this.mMediaCodecDecoder.getReSampleRate();
        if (this.mAudioTrack != null) {
            this.mAudioTrack.flush();
        }
        if (this.mChannelConfig == 1) {
            channelConfig = 4;
        } else {
            channelConfig = 12;
        }
        LogUtil.d(Tag, "samplerate = " + this.mSampleRate);
        if (this.mSampleRate < 4000 || this.mSampleRate > 48000) {
            this.mAudioTrack = null;
            LogUtil.d(Tag, "4000>sample rate || sample rate>48000: " + this.mSampleRate);
            return false;
        }
        int audioMinBufSizeLocal = AudioTrack.getMinBufferSize(this.mSampleRate, channelConfig, 2);
        LogUtil.d(Tag, "audioMinBufSizeLocal= " + audioMinBufSizeLocal);
        try {
            this.mAudioTrack = new AudioTrack(3, this.mSampleRate, channelConfig, 2, audioMinBufSizeLocal * 2, 1);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            this.mAudioTrack = null;
            LogUtil.d(Tag, "IllegalArgumentException: mAudioTrack =new AudioTrack");
            return false;
        }
    }

    /* renamed from: h */
    private void playAudioTrack() {
        if (this.mAudioTrack != null) {
            if (this.mAudioTrack.getPlayState() != 3) {
                try {
                    LogUtil.d(Tag, "Play WeChat voice!");
                    this.mAudioTrack.play();
                } catch (IllegalStateException e) {
                    MsgHandlerCenter.dispatchMessage(415);
                    e.printStackTrace();
                }
                synchronized (this.mObject) {
                    this.mObject.notify();
                }
                return;
            }
            LogUtil.d(Tag, "play music has been triggered");
        }
    }

    /* renamed from: a */
    public void writeAudioData(byte[] pData) {
        int size = pData.length;
        if (size <= 0) {
            LogUtil.e(Tag, "Data size 0!!!");
            return;
        }
        synchronized (this.mObject) {
            if (this.mAudioTrack != null && this.mAudioTrack.getPlayState() == 3) {
                LogUtil.e(Tag, "Trace size:  " + size);
                this.mAudioTrack.write(pData, 0, size);
            }
        }
    }

    /* renamed from: f */
    public void writeAudioData() {
        int size = this.mPairTwo.getSize();
        if (size <= 0) {
            LogUtil.e(Tag, "Out size 0!!!");
            return;
        }
        synchronized (this.mObject) {
            if (this.mAudioTrack != null && this.mAudioTrack.getPlayState() == 3) {
                LogUtil.e(Tag, "size  " + size);
                this.mAudioTrack.write(this.mPairTwo.getData(), 0, size);
            }
        }
    }

    /* renamed from: i */
    private void audioWait() {
        synchronized (this.mObject) {
            if (this.mAudioTrack == null || this.mAudioTrack.getPlayState() != 3) {
                try {
                    this.mObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
