package com.baidu.location.indoor;

import android.location.Location;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.location.indoor.f */
public class C3443f {
    /* renamed from: a */
    private List<Location> f18637a;
    /* renamed from: b */
    private String f18638b;
    /* renamed from: c */
    private Location f18639c = null;

    C3443f(String str, Location[] locationArr) {
        if (locationArr != null && locationArr.length > 0) {
            m14755a(locationArr);
            this.f18638b = str;
        }
    }

    /* renamed from: a */
    private void m14755a(Location[] locationArr) {
        double d = 0.0d;
        if (locationArr != null && locationArr.length > 0) {
            if (this.f18637a == null) {
                this.f18637a = new ArrayList();
            }
            double d2 = 0.0d;
            for (int i = 0; i < locationArr.length; i++) {
                d2 += locationArr[i].getLatitude();
                d += locationArr[i].getLongitude();
                this.f18637a.add(locationArr[i]);
            }
            if (this.f18639c == null) {
                this.f18639c = new Location("gps");
                this.f18639c.setLatitude(d2 / ((double) locationArr.length));
                this.f18639c.setLongitude(d / ((double) locationArr.length));
            }
        }
    }

    /* renamed from: a */
    public String m14756a() {
        return this.f18638b;
    }

    /* renamed from: a */
    public boolean m14757a(double d, double d2) {
        boolean z = false;
        if (this.f18637a == null) {
            return false;
        }
        int size = this.f18637a.size();
        int i = (int) (((double) 1000000) * d2);
        int i2 = (int) (((double) 1000000) * d);
        int i3 = 0;
        int i4 = size - 1;
        while (i3 < size) {
            int longitude = (int) (((Location) this.f18637a.get(i3)).getLongitude() * ((double) 1000000));
            int latitude = (int) (((Location) this.f18637a.get(i3)).getLatitude() * ((double) 1000000));
            int longitude2 = (int) (((Location) this.f18637a.get(i4)).getLongitude() * ((double) 1000000));
            int latitude2 = (int) (((Location) this.f18637a.get(i4)).getLatitude() * ((double) 1000000));
            if ((i == longitude && i2 == latitude) || (i == longitude2 && i2 == latitude2)) {
                return true;
            }
            boolean z2;
            if ((latitude < i2 && latitude2 >= i2) || (latitude >= i2 && latitude2 < i2)) {
                latitude2 = (((i2 - latitude) * (longitude2 - longitude)) / (latitude2 - latitude)) + longitude;
                if (latitude2 == i) {
                    return true;
                }
                if (latitude2 > i) {
                    z2 = !z;
                    i4 = i3;
                    i3++;
                    z = z2;
                }
            }
            z2 = z;
            i4 = i3;
            i3++;
            z = z2;
        }
        return z;
    }
}
