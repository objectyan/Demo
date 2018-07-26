package com.indooratlas.android.sdk._internal;

import android.os.ParcelUuid;
import android.os.SystemClock;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class dl {
    /* renamed from: a */
    private static final ParcelUuid f23413a = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    /* renamed from: b */
    private static final byte[] f23414b = new byte[]{(byte) 76, (byte) 0, (byte) 2, (byte) 21};

    /* renamed from: a */
    public static dh m20330a(String str, String str2, int i, byte[] bArr) {
        if (bArr == null || str2 == null) {
            return null;
        }
        dh dhVar;
        di a;
        int i2 = 0;
        int i3 = -1;
        List arrayList = new ArrayList();
        String str3 = null;
        int i4 = Integer.MIN_VALUE;
        SparseArray sparseArray = new SparseArray();
        Map hashMap = new HashMap();
        while (i2 < bArr.length) {
            int i5 = i2 + 1;
            i2 = bArr[i2] & 255;
            if (i2 != 0) {
                i2--;
                int i6 = i5 + 1;
                switch (bArr[i5] & 255) {
                    case 1:
                        i3 = bArr[i6] & 255;
                        break;
                    case 2:
                    case 3:
                        m20328a(bArr, i6, i2, 2, arrayList);
                        break;
                    case 4:
                    case 5:
                        try {
                            m20328a(bArr, i6, i2, 4, arrayList);
                            break;
                        } catch (Exception e) {
                            ee.m20409a(cz.f23362a, "unable to parse scan record: " + Arrays.toString(bArr), new Object[0]);
                            return null;
                        }
                    case 6:
                    case 7:
                        m20328a(bArr, i6, i2, 16, arrayList);
                        break;
                    case 8:
                    case 9:
                        str3 = new String(m20332a(bArr, i6, i2), "UTF-8");
                        break;
                    case 10:
                        i4 = bArr[i6];
                        break;
                    case 22:
                        hashMap.put(m20329a(m20332a(bArr, i6, 2)), m20332a(bArr, i6 + 2, i2 - 2));
                        break;
                    case 255:
                        sparseArray.put(((bArr[i6 + 1] & 255) << 8) + (bArr[i6] & 255), m20332a(bArr, i6 + 2, i2 - 2));
                        break;
                    default:
                        break;
                }
                i2 += i6;
            } else {
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                dhVar = new dh(str2, str, SystemClock.elapsedRealtime() * 1000, i, arrayList, sparseArray, hashMap, i3, i4, str3);
                a = m20331a(bArr, i);
                if (a != null) {
                    return dhVar;
                }
                dhVar.f23401h = a.f23409e;
                dhVar.f23404k = a;
                return dhVar;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        dhVar = new dh(str2, str, SystemClock.elapsedRealtime() * 1000, i, arrayList, sparseArray, hashMap, i3, i4, str3);
        a = m20331a(bArr, i);
        if (a != null) {
            return dhVar;
        }
        dhVar.f23401h = a.f23409e;
        dhVar.f23404k = a;
        return dhVar;
    }

    /* renamed from: a */
    private static int m20328a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(m20329a(m20332a(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    /* renamed from: a */
    private static byte[] m20332a(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return obj;
    }

    /* renamed from: a */
    private static ParcelUuid m20329a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException("uuidBytes length invalid - " + length);
        } else if (length == 16) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
        } else {
            long j;
            if (length == 2) {
                j = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
            } else {
                j = ((((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8))) + ((long) ((bArr[2] & 255) << 16))) + ((long) ((bArr[3] & 255) << 24));
            }
            return new ParcelUuid(new UUID(f23413a.getUuid().getMostSignificantBits() + (j << 32), f23413a.getUuid().getLeastSignificantBits()));
        }
    }

    /* renamed from: a */
    public static di m20331a(byte[] bArr, int i) {
        if (bArr == null) {
            return null;
        }
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = bArr[i2] & 255;
            i2++;
            if (i3 != 0) {
                int i4 = bArr[i2] & 255;
                int i5 = i2 + 1;
                if (i4 != 0) {
                    if (i4 == 255) {
                        di diVar;
                        byte[] copyOfRange = Arrays.copyOfRange(bArr, i5, (i5 + i3) - 1);
                        if (copyOfRange.length < 25) {
                            diVar = null;
                        } else {
                            Object obj;
                            byte[] bArr2 = f23414b;
                            if (copyOfRange.length < bArr2.length) {
                                obj = null;
                            } else {
                                i2 = 0;
                                while (i2 < bArr2.length) {
                                    if (copyOfRange[i2] != bArr2[i2]) {
                                        obj = null;
                                    } else {
                                        i2++;
                                    }
                                }
                                obj = 1;
                            }
                            if (obj != null) {
                                bArr2 = Arrays.copyOfRange(copyOfRange, 4, 20);
                                StringBuilder stringBuilder = new StringBuilder();
                                for (i2 = 0; i2 < bArr2.length; i2++) {
                                    switch (i2) {
                                        case 4:
                                        case 6:
                                        case 8:
                                        case 10:
                                            stringBuilder.append('-');
                                            break;
                                    }
                                    int i6 = bArr2[i2] & 255;
                                    if (i6 <= 15) {
                                        stringBuilder.append('0');
                                    }
                                    stringBuilder.append(Integer.toHexString(i6));
                                }
                                Object stringBuilder2 = stringBuilder.toString();
                                if (!ei.m20418a(stringBuilder2)) {
                                    int b = m20333b(Arrays.copyOfRange(copyOfRange, 20, 22));
                                    int b2 = m20333b(Arrays.copyOfRange(copyOfRange, 22, 24));
                                    byte b3 = copyOfRange[24];
                                    double d = (double) i;
                                    if (d == 0.0d) {
                                        d = -1.0d;
                                    } else {
                                        d = (d * 1.0d) / ((double) b3);
                                        if (d < 1.0d) {
                                            d = Math.pow(d, 10.0d);
                                        } else {
                                            d = (Math.pow(d, 7.7095d) * 0.89976d) + 0.111d;
                                        }
                                    }
                                    diVar = new di(stringBuilder2, b, b2, i, b3, d);
                                }
                            }
                            diVar = null;
                        }
                        if (diVar != null) {
                            return diVar;
                        }
                    }
                    i2 = (i3 - 1) + i5;
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: b */
    private static int m20333b(byte[] bArr) {
        return ByteBuffer.wrap(new byte[]{(byte) 0, (byte) 0, bArr[0], bArr[1]}).getInt();
    }
}
