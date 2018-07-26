package com.indooratlas.android.sdk._internal;

import java.util.List;

public final class em {
    /* renamed from: a */
    public final eq f23518a;
    /* renamed from: b */
    public final Integer f23519b;

    public em(List<double[]> list, Integer num) {
        this.f23518a = new eq(list);
        this.f23519b = num;
    }

    /* renamed from: a */
    public final boolean m20423a(ep epVar) {
        Object obj;
        Integer num = epVar.f23527c;
        if (this.f23519b == null || (num != null && num.equals(this.f23519b))) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            eq eqVar = this.f23518a;
            double d = epVar.f23525a;
            double d2 = epVar.f23526b;
            er erVar = eqVar.f23529b;
            if (erVar.f23530a > d2 || d2 > erVar.f23532c || erVar.f23531b > d || d > erVar.f23533d) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                int i = 0;
                int i2 = 0;
                while (i2 < eqVar.f23528a.size() - 1) {
                    int i3;
                    double d3 = ((double[]) eqVar.f23528a.get(i2))[1];
                    double d4 = ((double[]) eqVar.f23528a.get(i2))[0];
                    d3 = ((((double[]) eqVar.f23528a.get(i2 + 1))[1] - d3) * (d - d4)) - ((d2 - d3) * (((double[]) eqVar.f23528a.get(i2 + 1))[0] - d4));
                    if (((double[]) eqVar.f23528a.get(i2))[0] <= d) {
                        if (((double[]) eqVar.f23528a.get(i2 + 1))[0] > d && d3 > 0.0d) {
                            i3 = i + 1;
                        }
                        i3 = i;
                    } else {
                        if (((double[]) eqVar.f23528a.get(i2 + 1))[0] <= d && d3 < 0.0d) {
                            i3 = i - 1;
                        }
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
                if (i != 0) {
                    obj = 1;
                    if (obj != null) {
                        return true;
                    }
                }
            }
            obj = null;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object o) {
        if (o == null || !(o instanceof em)) {
            return false;
        }
        em emVar = (em) o;
        if (!this.f23518a.equals(emVar.f23518a)) {
            return false;
        }
        if (this.f23519b == null) {
            if (emVar.f23519b != null) {
                return false;
            }
        } else if (!this.f23519b.equals(emVar.f23519b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.f23519b == null ? 0 : this.f23519b.intValue()) + (this.f23518a.hashCode() * 37);
    }

    public final String toString() {
        return "FloorArea{polygon=" + this.f23518a + ",floor=" + (this.f23519b == null ? "null" : this.f23519b) + "}";
    }
}
