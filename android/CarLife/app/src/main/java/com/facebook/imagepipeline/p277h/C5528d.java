package com.facebook.imagepipeline.p277h;

import com.facebook.common.internal.C5342c;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.C5354o;
import com.facebook.common.p141m.C5370e;
import com.facebook.imagepipeline.memory.C5630f;
import com.facebook.imagepipeline.memory.C5654x;
import com.facebook.imagepipeline.p152i.C2952d;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProgressiveJpegParser */
/* renamed from: com.facebook.imagepipeline.h.d */
public class C5528d {
    /* renamed from: a */
    private static final int f22436a = 0;
    /* renamed from: b */
    private static final int f22437b = 1;
    /* renamed from: c */
    private static final int f22438c = 2;
    /* renamed from: d */
    private static final int f22439d = 3;
    /* renamed from: e */
    private static final int f22440e = 4;
    /* renamed from: f */
    private static final int f22441f = 5;
    /* renamed from: g */
    private static final int f22442g = 6;
    /* renamed from: h */
    private static final int f22443h = 16384;
    /* renamed from: i */
    private int f22444i = 0;
    /* renamed from: j */
    private int f22445j = 0;
    /* renamed from: k */
    private int f22446k = 0;
    /* renamed from: l */
    private int f22447l = 0;
    /* renamed from: m */
    private int f22448m = 0;
    /* renamed from: n */
    private int f22449n = 0;
    /* renamed from: o */
    private final C5630f f22450o;

    public C5528d(C5630f byteArrayPool) {
        this.f22450o = (C5630f) C5350k.m18310a((Object) byteArrayPool);
    }

    /* renamed from: a */
    public boolean m19035a(C2952d encodedImage) {
        if (this.f22444i == 6) {
            return false;
        }
        if (encodedImage.j() <= this.f22446k) {
            return false;
        }
        boolean z = (byte[]) this.f22450o.mo4144a(16384);
        InputStream bufferedDataStream = new C5654x(encodedImage.d(), z, this.f22450o);
        try {
            C5370e.m18386a(bufferedDataStream, (long) this.f22446k);
            z = m19032a(bufferedDataStream);
            return z;
        } catch (IOException ioe) {
            C5354o.m18340b(ioe);
            return false;
        } finally {
            C5342c.m18274a(bufferedDataStream);
        }
    }

    /* renamed from: a */
    private boolean m19032a(InputStream inputStream) {
        int oldBestScanNumber = this.f22448m;
        while (this.f22444i != 6) {
            int nextByte = inputStream.read();
            if (nextByte != -1) {
                this.f22446k++;
                switch (this.f22444i) {
                    case 0:
                        if (nextByte != 255) {
                            this.f22444i = 6;
                            break;
                        }
                        try {
                            this.f22444i = 1;
                            break;
                        } catch (IOException ioe) {
                            C5354o.m18340b(ioe);
                            break;
                        }
                    case 1:
                        if (nextByte != 216) {
                            this.f22444i = 6;
                            break;
                        }
                        this.f22444i = 2;
                        break;
                    case 2:
                        if (nextByte == 255) {
                            this.f22444i = 3;
                            break;
                        }
                        break;
                    case 3:
                        if (nextByte != 255) {
                            if (nextByte != 0) {
                                if (nextByte == 218 || nextByte == 217) {
                                    m19033b(this.f22446k - 2);
                                }
                                if (!C5528d.m19031a(nextByte)) {
                                    this.f22444i = 2;
                                    break;
                                }
                                this.f22444i = 4;
                                break;
                            }
                            this.f22444i = 2;
                            break;
                        }
                        this.f22444i = 3;
                        break;
                    case 4:
                        this.f22444i = 5;
                        break;
                    case 5:
                        int bytesToSkip = ((this.f22445j << 8) + nextByte) - 2;
                        C5370e.m18386a(inputStream, (long) bytesToSkip);
                        this.f22446k += bytesToSkip;
                        this.f22444i = 2;
                        break;
                    default:
                        C5350k.m18321b(false);
                        break;
                }
                this.f22445j = nextByte;
            } else if (this.f22444i != 6 || this.f22448m == oldBestScanNumber) {
                return false;
            } else {
                return true;
            }
        }
        if (this.f22444i != 6) {
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m19031a(int markerSecondByte) {
        boolean z = true;
        if (markerSecondByte == 1) {
            return false;
        }
        if (markerSecondByte >= 208 && markerSecondByte <= 215) {
            return false;
        }
        if (markerSecondByte == 217 || markerSecondByte == 216) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private void m19033b(int offset) {
        if (this.f22447l > 0) {
            this.f22449n = offset;
        }
        int i = this.f22447l;
        this.f22447l = i + 1;
        this.f22448m = i;
    }

    /* renamed from: a */
    public boolean m19034a() {
        return this.f22446k > 1 && this.f22444i != 6;
    }

    /* renamed from: b */
    public int m19036b() {
        return this.f22449n;
    }

    /* renamed from: c */
    public int m19037c() {
        return this.f22448m;
    }
}
