package com.baidu.location.wifihistory;

import android.net.wifi.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import java.util.LinkedList;
import java.util.List;

public class WifiHistory implements Parcelable {
    public static final Creator<WifiHistory> CREATOR = new C34621();
    List<String> historyWifi = new LinkedList();
    long lastTime = 0;
    List<ScanResult> lastWifi = null;
    boolean updateFlag = false;

    /* renamed from: com.baidu.location.wifihistory.WifiHistory$1 */
    static class C34621 implements Creator<WifiHistory> {
        C34621() {
        }

        /* renamed from: a */
        public WifiHistory m14854a(Parcel parcel) {
            return new WifiHistory(parcel);
        }

        /* renamed from: a */
        public WifiHistory[] m14855a(int i) {
            return new WifiHistory[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m14854a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m14855a(i);
        }
    }

    public WifiHistory(Parcel parcel) {
        try {
            parcel.readList(this.historyWifi, null);
            if (this.historyWifi == null) {
                this.historyWifi = new LinkedList();
            }
            parcel.readList(null, null);
            this.lastWifi = null;
            this.lastTime = parcel.readLong();
        } catch (Exception e) {
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getWifiHistory() {
        int i = 0;
        if (this.historyWifi == null || this.historyWifi.size() == 0) {
            return null;
        }
        int i2;
        StringBuilder stringBuilder = new StringBuilder(512);
        int i3 = 3;
        if (this.updateFlag) {
            i2 = 1;
            i3 = 4;
        } else {
            i2 = 0;
        }
        int size = i3 > this.historyWifi.size() ? this.historyWifi.size() : i3;
        while (i2 < size) {
            stringBuilder.append("&wfh");
            int i4 = i + 1;
            stringBuilder.append(i);
            stringBuilder.append("=");
            stringBuilder.append((String) this.historyWifi.get(i2));
            i2++;
            i = i4;
        }
        return stringBuilder.toString();
    }

    void recordWifi(List<ScanResult> list) {
        this.lastWifi = list;
        String a = C3372e.m14326a(5, list);
        if (a != null) {
            this.historyWifi.add(a + ";" + (System.currentTimeMillis() / 1000));
            while (this.historyWifi.size() > 4) {
                this.historyWifi.remove(0);
            }
        }
    }

    void updateWifi(List<ScanResult> list) {
        if (this.lastWifi == null || !C3376f.m14359a((List) list, this.lastWifi, 0.5f)) {
            this.updateFlag = true;
            recordWifi(list);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.historyWifi);
        parcel.writeList(this.lastWifi);
        parcel.writeLong(this.lastTime);
    }
}
