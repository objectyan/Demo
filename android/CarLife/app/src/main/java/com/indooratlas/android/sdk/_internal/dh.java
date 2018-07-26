package com.indooratlas.android.sdk._internal;

import android.os.ParcelUuid;
import android.util.SparseArray;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class dh {
    /* renamed from: a */
    public String f23394a;
    /* renamed from: b */
    public String f23395b;
    /* renamed from: c */
    public int f23396c;
    /* renamed from: d */
    public List<ParcelUuid> f23397d;
    /* renamed from: e */
    public SparseArray<byte[]> f23398e;
    /* renamed from: f */
    public Map<ParcelUuid, byte[]> f23399f;
    /* renamed from: g */
    public int f23400g;
    /* renamed from: h */
    public int f23401h;
    /* renamed from: i */
    public String f23402i;
    /* renamed from: j */
    public long f23403j;
    /* renamed from: k */
    public di f23404k;

    public dh(String str, String str2, long j, int i, List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i2, int i3, String str3) {
        this.f23394a = str;
        this.f23395b = str2;
        this.f23403j = j;
        this.f23396c = i;
        this.f23397d = list;
        this.f23398e = sparseArray;
        this.f23399f = map;
        this.f23400g = i2;
        this.f23401h = i3;
        this.f23402i = str3;
    }

    public final String toString() {
        return "IABleEvent [device address=" + this.f23394a + ", device name=" + this.f23395b + ", rssi=" + this.f23396c + ", timestamp=" + this.f23403j + ", txPowerLevel=" + this.f23401h + ", advertiseFlags=" + this.f23400g + ", serviceUuids=" + this.f23397d + ", manufacturerSpecificData=" + m20321a(this.f23398e) + ", serviceData=" + m20322a(this.f23399f) + ", localName=" + this.f23402i + ", iBeaconData=" + this.f23404k + "]";
    }

    /* renamed from: a */
    private static String m20321a(SparseArray<byte[]> sparseArray) {
        if (sparseArray == null) {
            return "null";
        }
        if (sparseArray.size() == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        for (int i = 0; i < sparseArray.size(); i++) {
            stringBuilder.append(sparseArray.keyAt(i)).append('=').append(Arrays.toString((byte[]) sparseArray.valueAt(i)));
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static <T> String m20322a(Map<T, byte[]> map) {
        if (map == null) {
            return "null";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object key = ((Entry) it.next()).getKey();
            stringBuilder.append(key).append('=').append(Arrays.toString((byte[]) map.get(key)));
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
