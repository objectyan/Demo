package com.indooratlas.android.sdk._internal;

import android.os.ParcelUuid;
import android.support.annotation.NonNull;
import com.indooratlas.android.sdk._internal.eu.C5872a;
import com.indooratlas.android.sdk._internal.eu.C5872a.C5871a;
import com.indooratlas.android.sdk._internal.ff.C5895a;
import com.indooratlas.android.sdk._internal.ff.C5896b;
import com.indooratlas.android.sdk._internal.ff.C5898d;
import com.indooratlas.android.sdk._internal.ff.C5899e;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class cl {
    /* renamed from: a */
    public HashMap<ParcelUuid, HashMap<Integer, C5896b>> f23319a;
    /* renamed from: b */
    public HashMap<String, HashMap<Integer, C5898d>> f23320b;
    /* renamed from: c */
    public C5872a f23321c;
    /* renamed from: d */
    public HashMap<ParcelUuid, C5871a> f23322d;
    /* renamed from: e */
    public cr f23323e;
    /* renamed from: f */
    public long f23324f;
    /* renamed from: g */
    public long f23325g;

    public cl(@NonNull cr crVar) {
        if (crVar == null) {
            throw new IllegalArgumentException("clock cannot be null");
        }
        this.f23323e = crVar;
        this.f23319a = new HashMap();
        this.f23320b = new HashMap();
    }

    /* renamed from: a */
    public final int m20225a() {
        int i = 0;
        for (HashMap size : this.f23319a.values()) {
            i = size.size() + i;
        }
        for (HashMap size2 : this.f23320b.values()) {
            i += size2.size();
        }
        return i;
    }

    /* renamed from: a */
    public final C5895a[] m20227a(@NonNull HashMap<ParcelUuid, HashMap<Integer, C5896b>> hashMap) {
        C5895a[] c5895aArr = new C5895a[hashMap.size()];
        int i = 0;
        for (Entry entry : hashMap.entrySet()) {
            byte[] array;
            c5895aArr[i] = new C5895a();
            C5895a c5895a = c5895aArr[i];
            ParcelUuid parcelUuid = (ParcelUuid) entry.getKey();
            if (this.f23322d == null || !this.f23322d.containsKey(parcelUuid)) {
                ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
                wrap.putLong(parcelUuid.getUuid().getMostSignificantBits());
                wrap.putLong(parcelUuid.getUuid().getLeastSignificantBits());
                array = wrap.array();
            } else {
                array = ((C5871a) this.f23322d.get(parcelUuid)).f23545b;
            }
            c5895a.f23637b = array;
            c5895a = c5895aArr[i];
            Map map = (Map) entry.getValue();
            C5896b[] c5896bArr = new C5896b[map.size()];
            int i2 = 0;
            for (C5896b c5896b : map.values()) {
                c5896bArr[i2] = c5896b;
                i2++;
            }
            c5895a.f23638d = c5896bArr;
            i++;
        }
        return c5895aArr;
    }

    /* renamed from: b */
    public static C5899e[] m20224b(@NonNull HashMap<String, HashMap<Integer, C5898d>> hashMap) {
        C5899e[] c5899eArr = new C5899e[hashMap.size()];
        int i = 0;
        for (Entry entry : hashMap.entrySet()) {
            c5899eArr[i] = new C5899e();
            c5899eArr[i].f23654b = (String) entry.getKey();
            C5899e c5899e = c5899eArr[i];
            HashMap hashMap2 = (HashMap) entry.getValue();
            C5898d[] c5898dArr = new C5898d[hashMap2.size()];
            int i2 = 0;
            for (C5898d c5898d : hashMap2.values()) {
                c5898dArr[i2] = c5898d;
                i2++;
            }
            c5899e.f23655d = c5898dArr;
            i++;
        }
        return c5899eArr;
    }

    /* renamed from: a */
    public final boolean m20226a(@NonNull dh dhVar) {
        long a = cv.m20272a(dhVar.f23394a);
        if (a == -1) {
            return false;
        }
        int abs = Math.abs(dhVar.f23396c);
        Object[] objArr = new Object[]{Long.valueOf(dhVar.f23403j), Long.valueOf(r8), Long.valueOf(dhVar.f23403j - (this.f23325g * 1000))};
        int i = (int) ((dhVar.f23403j - (this.f23325g * 1000)) / 1000);
        HashMap hashMap;
        Object obj;
        int i2;
        int i3;
        HashMap hashMap2;
        if (dhVar.f23404k != null) {
            int abs2 = Math.abs(dhVar.f23404k.f23409e);
            hashMap = this.f23320b;
            String str = dhVar.f23404k.f23405a;
            int i4 = dhVar.f23404k.f23407c;
            int i5 = dhVar.f23404k.f23406b;
            if (this.f23321c == null || this.f23321c.f23549e) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                i2 = 0;
            } else {
                HashMap hashMap3;
                i3 = ((((((int) ((a >>> 32) ^ a)) + 31) * 31) + i4) * 31) + i5;
                hashMap2 = (HashMap) hashMap.get(str);
                if (hashMap2 == null) {
                    hashMap3 = new HashMap(1);
                } else {
                    hashMap3 = hashMap2;
                }
                C5898d c5898d = (C5898d) hashMap3.get(Integer.valueOf(i3));
                if (c5898d == null) {
                    c5898d = new C5898d();
                }
                c5898d.f23652h = a;
                c5898d.f23647b = i4;
                c5898d.f23648d = i5;
                c5898d.f23649e = abs2;
                c5898d.f23651g = ec.m20398a(c5898d.f23651g, abs);
                c5898d.f23650f = ec.m20398a(c5898d.f23650f, i);
                hashMap3.put(Integer.valueOf(i3), c5898d);
                hashMap.put(str, hashMap3);
                i2 = 1;
            }
            return i2 | 0;
        } else if (dhVar.f23399f == null) {
            return false;
        } else {
            boolean z = false;
            for (Entry entry : dhVar.f23399f.entrySet()) {
                C5896b c5896b;
                HashMap hashMap4 = this.f23319a;
                ParcelUuid parcelUuid = (ParcelUuid) entry.getKey();
                byte[] bArr = (byte[]) entry.getValue();
                if (this.f23321c == null || this.f23321c.f23550f) {
                    if (bArr == null || bArr.length == 0) {
                        obj = null;
                        if (obj == null) {
                            i2 = 0;
                        } else {
                            i3 = ((((int) ((a >>> 32) ^ a)) + 31) * 31) + Arrays.hashCode(bArr);
                            hashMap2 = (HashMap) hashMap4.get(parcelUuid);
                            if (hashMap2 == null) {
                                hashMap = new HashMap(1);
                            } else {
                                hashMap = hashMap2;
                            }
                            c5896b = (C5896b) hashMap.get(Integer.valueOf(i3));
                            if (c5896b == null) {
                                c5896b = new C5896b();
                            }
                            c5896b.f23643f = a;
                            c5896b.f23640b = bArr;
                            c5896b.f23642e = ec.m20398a(c5896b.f23642e, abs);
                            c5896b.f23641d = ec.m20398a(c5896b.f23641d, i);
                            hashMap.put(Integer.valueOf(i3), c5896b);
                            hashMap4.put(parcelUuid, hashMap);
                            i2 = 1;
                        }
                        z = i2 | z;
                    } else {
                        if (this.f23322d != null) {
                            C5871a c5871a = (C5871a) this.f23322d.get(parcelUuid);
                            if (c5871a != null) {
                                switch (c5871a.f23546d) {
                                    case 0:
                                        obj = null;
                                        break;
                                    case 1:
                                        obj = 1;
                                        break;
                                    case 2:
                                        if ((bArr[0] & 255) != 0) {
                                            obj = null;
                                            break;
                                        }
                                        obj = 1;
                                        break;
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            i3 = ((((int) ((a >>> 32) ^ a)) + 31) * 31) + Arrays.hashCode(bArr);
                            hashMap2 = (HashMap) hashMap4.get(parcelUuid);
                            if (hashMap2 == null) {
                                hashMap = hashMap2;
                            } else {
                                hashMap = new HashMap(1);
                            }
                            c5896b = (C5896b) hashMap.get(Integer.valueOf(i3));
                            if (c5896b == null) {
                                c5896b = new C5896b();
                            }
                            c5896b.f23643f = a;
                            c5896b.f23640b = bArr;
                            c5896b.f23642e = ec.m20398a(c5896b.f23642e, abs);
                            c5896b.f23641d = ec.m20398a(c5896b.f23641d, i);
                            hashMap.put(Integer.valueOf(i3), c5896b);
                            hashMap4.put(parcelUuid, hashMap);
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        z = i2 | z;
                    }
                }
                obj = null;
                if (obj == null) {
                    i2 = 0;
                } else {
                    i3 = ((((int) ((a >>> 32) ^ a)) + 31) * 31) + Arrays.hashCode(bArr);
                    hashMap2 = (HashMap) hashMap4.get(parcelUuid);
                    if (hashMap2 == null) {
                        hashMap = new HashMap(1);
                    } else {
                        hashMap = hashMap2;
                    }
                    c5896b = (C5896b) hashMap.get(Integer.valueOf(i3));
                    if (c5896b == null) {
                        c5896b = new C5896b();
                    }
                    c5896b.f23643f = a;
                    c5896b.f23640b = bArr;
                    c5896b.f23642e = ec.m20398a(c5896b.f23642e, abs);
                    c5896b.f23641d = ec.m20398a(c5896b.f23641d, i);
                    hashMap.put(Integer.valueOf(i3), c5896b);
                    hashMap4.put(parcelUuid, hashMap);
                    i2 = 1;
                }
                z = i2 | z;
            }
            return z;
        }
    }
}
