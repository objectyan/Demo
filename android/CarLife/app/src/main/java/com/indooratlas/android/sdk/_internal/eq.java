package com.indooratlas.android.sdk._internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class eq {
    /* renamed from: a */
    public final ArrayList<double[]> f23528a;
    /* renamed from: b */
    final er f23529b;

    public eq(List<double[]> list) {
        if (list.size() <= 2) {
            throw new IllegalArgumentException("Invalid number of edges for a geofence.");
        }
        this.f23529b = m20428a(list);
        this.f23528a = new ArrayList(list);
        this.f23528a.add(list.get(0));
    }

    /* renamed from: a */
    private static er m20428a(List<double[]> list) {
        double d = ((double[]) list.get(0))[1];
        double d2 = ((double[]) list.get(0))[0];
        double d3 = d2;
        double d4 = d;
        for (int i = 1; i < list.size(); i++) {
            d4 = Math.min(((double[]) list.get(i))[1], d4);
            d3 = Math.min(((double[]) list.get(i))[0], d3);
            d = Math.max(((double[]) list.get(i))[1], d);
            d2 = Math.max(((double[]) list.get(i))[0], d2);
        }
        return new er(d4, d3, d, d2);
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        eq eqVar = (eq) o;
        if (this.f23528a.size() != eqVar.f23528a.size()) {
            return false;
        }
        for (int i = 0; i < this.f23528a.size(); i++) {
            double[] dArr = (double[]) this.f23528a.get(i);
            double[] dArr2 = (double[]) eqVar.f23528a.get(i);
            if (dArr[0] != dArr2[0] || dArr[1] != dArr2[1]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        Iterator it = this.f23528a.iterator();
        int i = 1;
        while (it.hasNext()) {
            double[] dArr = (double[]) it.next();
            long doubleToLongBits = Double.doubleToLongBits(dArr[0]);
            i = (i * 37) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
            doubleToLongBits = Double.doubleToLongBits(dArr[1]);
            i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + (i * 37);
        }
        return i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Polygon{");
        Iterator it = this.f23528a.iterator();
        while (it.hasNext()) {
            double[] dArr = (double[]) it.next();
            stringBuilder.append('[').append(dArr[0]).append(',').append(dArr[1]).append(']');
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
