package com.baidu.carlife.core.audio;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.platform.comapi.UIMsg.m_AppUI;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: MediaCodecDecoder */
/* renamed from: com.baidu.carlife.core.audio.l */
public class C1179l implements C1168d {
    /* renamed from: a */
    private static final String f3082a = (C1163a.f3010n + C1179l.class.getSimpleName());
    /* renamed from: b */
    private static final int f3083b = 1;
    /* renamed from: c */
    private static final int f3084c = 0;
    /* renamed from: d */
    private static final int f3085d = -1;
    /* renamed from: e */
    private static final int f3086e = -2;
    /* renamed from: f */
    private static final int f3087f = -3;
    /* renamed from: g */
    private static final int f3088g = -4;
    /* renamed from: h */
    private static final int f3089h = -10;
    /* renamed from: i */
    private static final int f3090i = -11;
    /* renamed from: j */
    private static final int f3091j = -12;
    /* renamed from: k */
    private static final int f3092k = 1000;
    /* renamed from: l */
    private static final int f3093l = 10;
    /* renamed from: m */
    private MediaCodec f3094m;
    /* renamed from: n */
    private MediaExtractor f3095n;
    /* renamed from: o */
    private MediaFormat f3096o;
    /* renamed from: p */
    private BufferInfo f3097p;
    /* renamed from: q */
    private boolean f3098q = false;
    /* renamed from: r */
    private boolean f3099r = false;
    /* renamed from: s */
    private ByteBuffer[] f3100s;
    /* renamed from: t */
    private ByteBuffer[] f3101t;
    /* renamed from: u */
    private int f3102u = -1;
    /* renamed from: v */
    private int f3103v = -1;
    /* renamed from: w */
    private int f3104w = -1;
    /* renamed from: x */
    private byte[] f3105x;
    /* renamed from: y */
    private String f3106y;

    C1179l() {
        m4000a(new byte[C1163a.f3005i]);
    }

    /* renamed from: d */
    public static int m3991d() {
        return 1000;
    }

    /* renamed from: a */
    public synchronized int mo1444a(String url) {
        int i = -1;
        synchronized (this) {
            try {
                if (this.f3095n != null) {
                    this.f3095n.release();
                }
                m3993o();
                this.f3095n = new MediaExtractor();
                C1260i.m4435b(f3082a, "the decode file path is " + url);
                this.f3095n.setDataSource(url);
                this.f3096o = this.f3095n.getTrackFormat(0);
                this.f3106y = m4009f().getString("mime");
                C1260i.m4435b(f3082a, "mMine= " + this.f3106y);
                if (m3990b(this.f3106y)) {
                    m4007c(m4009f().getInteger("channel-count"));
                    C1260i.m4435b(f3082a, "mChannelConfig= " + mo1446b());
                    if (Build.MODEL.equals("GT-N7100") && mo1446b() == 1) {
                        m4007c(2);
                    }
                    m4003b(m4009f().getInteger("sample-rate"));
                    C1260i.m4435b(f3082a, "samplerate = " + mo1442a());
                    if (mo1442a() < m_AppUI.MSG_APP_SAVESCREEN || mo1442a() > 48000) {
                        C1260i.m4435b(f3082a, "4000>sample rate || sample rate>48000: " + mo1442a());
                        m3995a(404);
                    } else {
                        this.f3104w = 16;
                        this.f3094m = MediaCodec.createDecoderByType(this.f3106y);
                        m3999a(false);
                        m4004b(false);
                        m4008e().configure(m4009f(), null, null, 0);
                        m4008e().start();
                        if (VERSION.SDK_INT < 21) {
                            m4001a(m4008e().getInputBuffers());
                            m4005b(m4008e().getOutputBuffers());
                        }
                        this.f3097p = new BufferInfo();
                        this.f3095n.selectTrack(0);
                        int retVal = m3992n();
                        if (retVal >= 0) {
                            C1260i.m4435b(f3082a, "Reconfigure sample rate in success,retVal = " + retVal);
                        } else {
                            C1260i.m4435b(f3082a, "Reconfigure sample rate in failure,retVal = " + retVal);
                        }
                        i = 0;
                    }
                } else {
                    m3995a(404);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
                C1260i.m4435b(f3082a, "IOException happen!-decoder");
                m3995a(404);
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                C1260i.m4435b(f3082a, "IllegalStateException happen!-decoder");
                m3995a(404);
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
                C1260i.m4435b(f3082a, "IllegalArgumentException happen!-decoder");
                m3995a(404);
            } catch (CryptoException e6) {
                e6.printStackTrace();
                C1260i.m4435b(f3082a, "MediaCodec.CryptoException happen!-decoder");
                m3995a(404);
            } catch (NullPointerException e7) {
                e7.printStackTrace();
                C1260i.m4435b(f3082a, "NullPointerException happen!-decoder");
                m3995a(404);
            }
        }
        return i;
    }

    /* renamed from: a */
    public int mo1445a(String url, ArrayList arrayList) {
        return 0;
    }

    /* renamed from: a */
    public int mo1442a() {
        return this.f3102u;
    }

    /* renamed from: b */
    public int mo1446b() {
        return this.f3103v;
    }

    /* renamed from: c */
    public int mo1447c() {
        return m4015l();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: n */
    private int m3992n() {
        /*
        r19 = this;
        r9 = 0;
        r14 = 0;
        r2 = r19.m4008e();
        if (r2 != 0) goto L_0x01ba;
    L_0x0008:
        r2 = -1;
    L_0x0009:
        return r2;
    L_0x000a:
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = 21;
        if (r2 >= r4) goto L_0x0022;
    L_0x0010:
        r2 = -3;
        r0 = r17;
        if (r0 != r2) goto L_0x0022;
    L_0x0015:
        r2 = r19.m4008e();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = r2.getOutputBuffers();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r0 = r19;
        r0.m4005b(r2);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
    L_0x0022:
        r10 = r9;
    L_0x0023:
        r9 = r10 + 1;
        r2 = 10;
        if (r10 >= r2) goto L_0x010e;
    L_0x0029:
        r2 = r19.m4008e();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = com.baidu.carlife.core.audio.C1179l.m3991d();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = (long) r4;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r3 = r2.dequeueInputBuffer(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = f3082a;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4.<init>();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "inputBuffIndex = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.append(r3);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.toString();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        com.baidu.carlife.core.C1260i.m4435b(r2, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        if (r3 < 0) goto L_0x0126;
    L_0x0051:
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = 21;
        if (r2 < r4) goto L_0x0115;
    L_0x0057:
        r2 = r19.m4008e();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r15 = r2.getInputBuffer(r3);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
    L_0x005f:
        r0 = r19;
        r2 = r0.f3095n;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = 0;
        r5 = r2.readSampleData(r15, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = f3082a;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4.<init>();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "inputBuffIndex = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.append(r3);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "sampleSize = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.append(r5);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.toString();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        com.baidu.carlife.core.C1260i.m4435b(r2, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r16 = 0;
        if (r5 >= 0) goto L_0x011d;
    L_0x0090:
        r16 = 1;
        r5 = 0;
    L_0x0093:
        r2 = r19.m4008e();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = 0;
        r6 = 0;
        if (r16 == 0) goto L_0x0121;
    L_0x009c:
        r8 = 4;
    L_0x009d:
        r2.queueInputBuffer(r3, r4, r5, r6, r8);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        if (r16 != 0) goto L_0x0124;
    L_0x00a2:
        r0 = r19;
        r2 = r0.f3095n;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2.advance();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
    L_0x00a9:
        r2 = r19.m4008e();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r19.m4010g();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = com.baidu.carlife.core.audio.C1179l.m3991d();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = (long) r6;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r17 = r2.dequeueOutputBuffer(r4, r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = f3082a;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4.<init>();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "outputBuffIndex = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r0 = r17;
        r4 = r4.append(r0);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.toString();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        com.baidu.carlife.core.C1260i.m4435b(r2, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        if (r17 < 0) goto L_0x012b;
    L_0x00d7:
        r2 = r19.m4008e();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r0 = r17;
        r18 = r2.getOutputFormat(r0);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = f3082a;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4.<init>();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "output format no change, sample rate = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "sample-rate";
        r0 = r18;
        r6 = r0.getInteger(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.toString();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        com.baidu.carlife.core.C1260i.m4435b(r2, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = r19.m4008e();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = 0;
        r0 = r17;
        r2.releaseOutputBuffer(r0, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r14 = 0;
    L_0x010e:
        r2 = 10;
        if (r9 < r2) goto L_0x01b7;
    L_0x0112:
        r2 = -4;
        goto L_0x0009;
    L_0x0115:
        r2 = r19.m4013j();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r15 = r2[r3];	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        goto L_0x005f;
    L_0x011d:
        r16 = 0;
        goto L_0x0093;
    L_0x0121:
        r8 = 0;
        goto L_0x009d;
    L_0x0124:
        r14 = -2;
        goto L_0x010e;
    L_0x0126:
        r2 = -1;
        if (r3 == r2) goto L_0x00a9;
    L_0x0129:
        r14 = -3;
        goto L_0x010e;
    L_0x012b:
        r2 = -2;
        r0 = r17;
        if (r0 != r2) goto L_0x000a;
    L_0x0130:
        r2 = r19.m4008e();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r18 = r2.getOutputFormat();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = "sample-rate";
        r0 = r18;
        r2 = r0.getInteger(r2);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r0 = r19;
        r0.m4003b(r2);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = "channel-count";
        r0 = r18;
        r2 = r0.getInteger(r2);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r0 = r19;
        r0.m4007c(r2);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = f3082a;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4.<init>();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "output format changed, sample rate = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = r19.mo1442a();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = ",channel count = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = r19.mo1446b();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.toString();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        com.baidu.carlife.core.C1260i.m4435b(r2, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = 425; // 0x1a9 float:5.96E-43 double:2.1E-321;
        com.baidu.carlife.core.C1261k.m4461b(r2);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r14 = 1;
        goto L_0x010e;
    L_0x0187:
        r11 = move-exception;
        r11.printStackTrace();
        r2 = f3082a;
        r4 = "IllegalStateException happen!-getDecodedAudioData";
        com.baidu.carlife.core.C1260i.m4435b(r2, r4);
        r14 = -10;
        goto L_0x010e;
    L_0x0197:
        r12 = move-exception;
        r12.printStackTrace();
        r2 = f3082a;
        r4 = "IllegalArgumentException happen!-getDecodedAudioData";
        com.baidu.carlife.core.C1260i.m4435b(r2, r4);
        r14 = -11;
        goto L_0x010e;
    L_0x01a7:
        r13 = move-exception;
        r13.printStackTrace();
        r2 = f3082a;
        r4 = "MediaCodec.CryptoException happen!-getDecodedAudioData";
        com.baidu.carlife.core.C1260i.m4435b(r2, r4);
        r14 = -12;
        goto L_0x010e;
    L_0x01b7:
        r2 = r14;
        goto L_0x0009;
    L_0x01ba:
        r10 = r9;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.core.audio.l.n():int");
    }

    /* renamed from: a */
    public synchronized int mo1443a(C1187p p, int pos) {
        int i;
        if (m4008e() == null || this.f3095n == null) {
            i = -1;
        } else {
            i = 0;
            p.m4056a(m4016m());
            p.m4055a(0);
            try {
                int inputBufIndex = m4008e().dequeueInputBuffer((long) C1179l.m3991d());
                if (inputBufIndex >= 0 && !m4012i()) {
                    ByteBuffer dstBuf;
                    if (VERSION.SDK_INT >= 21) {
                        dstBuf = m4008e().getInputBuffer(inputBufIndex);
                    } else {
                        dstBuf = m4013j()[inputBufIndex];
                    }
                    int sampleSize = this.f3095n.readSampleData(dstBuf, 0);
                    if (sampleSize < 0) {
                        m4004b(true);
                        sampleSize = 0;
                    } else {
                        long presentationTimeUs = this.f3095n.getSampleTime();
                        m4004b(false);
                    }
                    m4008e().queueInputBuffer(inputBufIndex, 0, sampleSize, 0, m4012i() ? 4 : 0);
                    if (m4012i()) {
                        m3995a(417);
                    } else {
                        this.f3095n.advance();
                    }
                }
                int res = m4008e().dequeueOutputBuffer(m4010g(), (long) C1179l.m3991d());
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
                        C1260i.m4435b(f3082a, "res = MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED");
                    }
                } else if (res == -2) {
                    int newSamplerate = m4008e().getOutputFormat().getInteger("sample-rate");
                    C1260i.m4435b(f3082a, "res = MediaCodec.INFO_OUTPUT_FORMAT_CHANGED");
                }
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                C1260i.m4435b(f3082a, "IllegalStateException happen!-getDecodedAudioData");
                m3995a(404);
                i = -1;
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
                C1260i.m4435b(f3082a, "IllegalArgumentException happen!-getDecodedAudioData");
                m3995a(404);
                i = -1;
            } catch (CryptoException e6) {
                e6.printStackTrace();
                C1260i.m4435b(f3082a, "MediaCodec.CryptoException happen!-getDecodedAudioData");
                m3995a(404);
                i = -1;
            }
        }
        return i;
    }

    /* renamed from: a */
    protected int m3995a(int type) {
        C1261k.m4461b(type);
        if (type == 404) {
            m3993o();
        }
        return -1;
    }

    /* renamed from: o */
    private void m3993o() {
        if (m4008e() != null) {
            try {
                m4008e().flush();
                m4008e().stop();
            } catch (IllegalStateException e1) {
                e1.printStackTrace();
            } finally {
                m4008e().release();
                this.f3094m = null;
            }
        }
    }

    /* renamed from: b */
    private boolean m3990b(String mimeType) {
        int numCodecs = MediaCodecList.getCodecCount();
        for (int i = 0; i < numCodecs; i++) {
            MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(i);
            C1260i.m4435b(f3082a, "codecInfo = " + codecInfo.getName());
            if (!codecInfo.isEncoder()) {
                String[] types = codecInfo.getSupportedTypes();
                for (int j = 0; j < types.length; j++) {
                    C1260i.m4435b(f3082a, "support type = " + types[j]);
                    if (types[j].equalsIgnoreCase(mimeType)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* renamed from: e */
    public MediaCodec m4008e() {
        return this.f3094m;
    }

    /* renamed from: f */
    public MediaFormat m4009f() {
        return this.f3096o;
    }

    /* renamed from: g */
    public BufferInfo m4010g() {
        return this.f3097p;
    }

    /* renamed from: h */
    public boolean m4011h() {
        return this.f3098q;
    }

    /* renamed from: i */
    public boolean m4012i() {
        return this.f3099r;
    }

    /* renamed from: j */
    public ByteBuffer[] m4013j() {
        return this.f3100s;
    }

    /* renamed from: k */
    public ByteBuffer[] m4014k() {
        return this.f3101t;
    }

    /* renamed from: l */
    public int m4015l() {
        return this.f3104w;
    }

    /* renamed from: m */
    public byte[] m4016m() {
        return this.f3105x;
    }

    /* renamed from: a */
    public void m3999a(boolean sawOutputEOS) {
        this.f3098q = sawOutputEOS;
    }

    /* renamed from: b */
    public void m4004b(boolean sawInputEOS) {
        this.f3099r = sawInputEOS;
    }

    /* renamed from: a */
    public void m4001a(ByteBuffer[] codecInputBuffers) {
        this.f3100s = codecInputBuffers;
    }

    /* renamed from: b */
    public void m4005b(ByteBuffer[] codecOutputBuffers) {
        this.f3101t = codecOutputBuffers;
    }

    /* renamed from: b */
    public void m4003b(int mSampleRate) {
        this.f3102u = mSampleRate;
    }

    /* renamed from: c */
    public void m4007c(int mChannelConfig) {
        this.f3103v = mChannelConfig;
    }

    /* renamed from: a */
    public void m4000a(byte[] mChunk) {
        this.f3105x = mChunk;
    }
}
