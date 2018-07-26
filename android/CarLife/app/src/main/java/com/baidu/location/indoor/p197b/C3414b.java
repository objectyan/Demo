package com.baidu.location.indoor.p197b;

import com.baidu.location.BDLocation;
import com.baidu.location.p188h.C3391g;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

/* renamed from: com.baidu.location.indoor.b.b */
public final class C3414b {
    /* renamed from: q */
    private static volatile C3414b f18483q = null;
    /* renamed from: a */
    private HashMap<String, HashMap<Integer, C3415c>> f18484a;
    /* renamed from: b */
    private HashMap<String, HashMap<Integer, Vector<Integer>>> f18485b;
    /* renamed from: c */
    private HashMap<String, ArrayList<ArrayList<Integer>>> f18486c;
    /* renamed from: d */
    private HashMap<String, ArrayList<ArrayList<Integer>>> f18487d;
    /* renamed from: e */
    private ArrayList<BDLocation> f18488e;
    /* renamed from: f */
    private ArrayList<BDLocation> f18489f;
    /* renamed from: g */
    private C3413c f18490g;
    /* renamed from: h */
    private String f18491h;
    /* renamed from: i */
    private String f18492i;
    /* renamed from: j */
    private boolean f18493j;
    /* renamed from: k */
    private boolean f18494k;
    /* renamed from: l */
    private boolean f18495l;
    /* renamed from: m */
    private boolean f18496m;
    /* renamed from: n */
    private C3412b f18497n;
    /* renamed from: o */
    private boolean f18498o;
    /* renamed from: p */
    private String f18499p;

    /* renamed from: com.baidu.location.indoor.b.b$a */
    private static class C3411a {
        /* renamed from: a */
        private final C3411a f18470a;
        /* renamed from: b */
        private final int f18471b;
        /* renamed from: c */
        private final int f18472c;

        private C3411a(C3411a c3411a, int i, int i2) {
            this.f18470a = c3411a;
            this.f18471b = i;
            this.f18472c = i2;
        }
    }

    /* renamed from: com.baidu.location.indoor.b.b$b */
    private static class C3412b {
        /* renamed from: a */
        private double f18473a;
        /* renamed from: b */
        private double f18474b;
        /* renamed from: c */
        private HashMap<String, C3417e> f18475c;
        /* renamed from: d */
        private double f18476d;
        /* renamed from: e */
        private double f18477e;
        /* renamed from: f */
        private boolean f18478f;
        /* renamed from: g */
        private C3415c f18479g;
        /* renamed from: h */
        private C3415c f18480h;
        /* renamed from: i */
        private boolean f18481i;

        private C3412b(double d, double d2) {
            this.f18475c = null;
            this.f18478f = false;
            this.f18481i = false;
            this.f18473a = d;
            this.f18474b = d2;
        }

        /* renamed from: a */
        private HashMap<String, C3417e> m14543a() {
            return this.f18475c;
        }

        /* renamed from: a */
        private void m14545a(HashMap<String, C3417e> hashMap) {
            this.f18475c = hashMap;
        }
    }

    /* renamed from: com.baidu.location.indoor.b.b$c */
    private static class C3413c {
        /* renamed from: a */
        private final ArrayDeque<C3412b> f18482a;

        private C3413c() {
            this.f18482a = new ArrayDeque();
        }

        /* renamed from: a */
        private void m14560a() {
            if (this.f18482a.size() > 0) {
                this.f18482a.removeFirst();
            }
        }

        /* renamed from: a */
        private void m14561a(C3412b c3412b) {
            if (this.f18482a.size() >= 3) {
                this.f18482a.removeFirst();
            }
            this.f18482a.addLast(c3412b);
        }

        /* renamed from: b */
        private void m14564b() {
            this.f18482a.clear();
        }

        /* renamed from: c */
        private boolean m14567c() {
            return this.f18482a.size() == 3;
        }

        /* renamed from: d */
        private int m14568d() {
            return this.f18482a.size();
        }
    }

    private C3414b() {
        this.f18484a = null;
        this.f18485b = null;
        this.f18486c = null;
        this.f18487d = null;
        this.f18488e = null;
        this.f18489f = null;
        this.f18490g = null;
        this.f18491h = null;
        this.f18492i = null;
        this.f18493j = false;
        this.f18494k = true;
        this.f18495l = false;
        this.f18496m = false;
        this.f18497n = null;
        this.f18498o = false;
        this.f18499p = null;
        this.f18484a = new HashMap();
        this.f18485b = new HashMap();
        this.f18486c = new HashMap();
        this.f18487d = new HashMap();
        this.f18490g = new C3413c();
    }

    /* renamed from: a */
    private double m14571a(BDLocation bDLocation, ArrayList<C3415c> arrayList) {
        C3415c c3415c = (C3415c) arrayList.get(arrayList.size() - 1);
        C3415c c3415c2 = new C3415c();
        c3415c2.f18500a = bDLocation.getLatitude();
        c3415c2.f18501b = bDLocation.getLongitude();
        double a = c3415c.m14593a(c3415c2);
        Iterator it = this.f18490g.f18482a.iterator();
        double d = a;
        while (it.hasNext()) {
            d = m14572a((C3412b) it.next(), (ArrayList) arrayList) + d;
        }
        return d;
    }

    /* renamed from: a */
    private double m14572a(C3412b c3412b, ArrayList<C3415c> arrayList) {
        int i = 0;
        C3415c c3415c = new C3415c();
        c3415c.f18500a = c3412b.f18474b;
        c3415c.f18501b = c3412b.f18473a;
        if (arrayList.size() < 2) {
            return Double.MAX_VALUE;
        }
        C3415c c3415c2 = (C3415c) arrayList.get(0);
        C3415c c3415c3 = (C3415c) arrayList.get(arrayList.size() - 1);
        if (!(c3415c2.f18503d == Integer.MAX_VALUE || c3415c2.f18504e == Integer.MAX_VALUE)) {
            C3415c c3415c4;
            c3415c4 = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(c3415c2.f18503d));
            c3415c2 = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(c3415c2.f18504e));
            C3415c c = m14582c(c3415c, c3415c4, c3415c2);
            if (m14585d(c, c3415c4, c3415c2)) {
                return c3415c.m14593a(c);
            }
        }
        if (!(c3415c3.f18503d == Integer.MAX_VALUE || c3415c3.f18504e == Integer.MAX_VALUE)) {
            c3415c2 = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(c3415c3.f18503d));
            c3415c3 = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(c3415c3.f18504e));
            c3415c4 = m14582c(c3415c, c3415c2, c3415c3);
            if (m14585d(c3415c4, c3415c2, c3415c3)) {
                return c3415c.m14593a(c3415c4);
            }
        }
        if (c3412b.f18481i) {
            c3415c2 = new C3415c();
            c3415c2.f18500a = c3412b.f18477e;
            c3415c2.f18501b = c3412b.f18476d;
            return c3415c.m14593a(c3415c2);
        }
        double d = Double.MAX_VALUE;
        while (i < arrayList.size() - 1) {
            double a;
            c3415c2 = (C3415c) arrayList.get(i);
            c3415c3 = (C3415c) arrayList.get(i + 1);
            C3415c c2 = m14582c(c3415c, c3415c2, c3415c3);
            if (m14585d(c2, c3415c2, c3415c3)) {
                a = c3415c.m14593a(c2);
                if (a < d) {
                    i++;
                    d = a;
                }
            }
            a = d;
            i++;
            d = a;
        }
        return d;
    }

    /* renamed from: a */
    private double m14573a(C3415c c3415c, C3415c c3415c2, ArrayList<C3415c> arrayList) {
        int i = 0;
        double d = 0.0d;
        while (arrayList.size() >= 2 && i < arrayList.size() - 1) {
            d += ((C3415c) arrayList.get(i)).m14593a((C3415c) arrayList.get(i + 1));
            i++;
        }
        return c3415c.m14593a((C3415c) arrayList.get(arrayList.size() - 1)) + (d + c3415c.m14593a((C3415c) arrayList.get(0)));
    }

    /* renamed from: a */
    private double m14574a(List<C3415c> list) {
        if (list.size() < 2) {
            return Double.MAX_VALUE;
        }
        double d = 0.0d;
        for (int i = 0; i < list.size() - 1; i++) {
            d += ((C3415c) list.get(i)).m14593a((C3415c) list.get(i + 1));
        }
        return d;
    }

    /* renamed from: a */
    public static C3414b m14575a() {
        if (f18483q == null) {
            synchronized (C3414b.class) {
                if (f18483q == null) {
                    f18483q = new C3414b();
                }
            }
        }
        return f18483q;
    }

    /* renamed from: a */
    private C3415c m14576a(C3415c c3415c, C3415c c3415c2, C3415c c3415c3) {
        C3415c c3415c4 = new C3415c();
        double d = c3415c2.f18500a;
        double d2 = c3415c2.f18501b;
        double d3 = c3415c3.f18500a;
        double d4 = c3415c3.f18501b;
        double d5 = c3415c.f18500a;
        double d6 = c3415c.f18501b;
        d6 = Math.sqrt(((d5 - d3) * (d5 - d3)) + ((d6 - d4) * (d6 - d4)));
        if (Math.abs((d2 - d4) / (d - d3)) > 10.0d) {
            d5 = d4 + d6;
            d6 = d4 - d6;
            if (((d3 - d3) * (d3 - d)) + ((d5 - d4) * (d4 - d2)) <= 0.0d) {
                d5 = d6;
            }
            d6 = d3;
        } else {
            double d7 = (d4 - d2) / (d3 - d);
            double d8 = ((d * d4) - (d3 * d2)) / (d - d3);
            double d9 = (d7 * d7) + 1.0d;
            double d10 = ((2.0d * d7) * (d8 - d4)) - (2.0d * d3);
            d6 = ((d3 * d3) + ((d8 - d4) * (d8 - d4))) - (d6 * d6);
            if ((d10 * d10) - ((4.0d * d9) * d6) < 0.0d) {
                c3415c4.f18500a = Double.MAX_VALUE;
                c3415c4.f18501b = Double.MAX_VALUE;
                return c3415c4;
            }
            double sqrt = ((-1.0d * d10) + Math.sqrt((d10 * d10) - ((4.0d * d9) * d6))) / (2.0d * d9);
            d5 = (d7 * sqrt) + d8;
            d9 = ((-1.0d * d10) - Math.sqrt((d10 * d10) - (d6 * (4.0d * d9)))) / (d9 * 2.0d);
            d6 = (d7 * d9) + d8;
            if (((d3 - d) * (sqrt - d3)) + ((d5 - d4) * (d4 - d2)) > 0.0d) {
                d6 = sqrt;
            } else {
                d5 = d6;
                d6 = d9;
            }
        }
        c3415c4.f18500a = d6;
        c3415c4.f18501b = d5;
        return c3415c4;
    }

    /* renamed from: a */
    private ArrayList<C3415c> m14577a(C3417e c3417e, C3417e c3417e2) {
        c3417e.f18509c.f18503d = c3417e.m14595a();
        c3417e.f18509c.f18504e = c3417e.m14596b();
        c3417e2.f18509c.f18503d = c3417e2.m14595a();
        c3417e2.f18509c.f18504e = c3417e2.m14596b();
        double d = Double.MAX_VALUE;
        ArrayList<C3415c> arrayList = new ArrayList();
        if (c3417e.m14595a() == c3417e2.m14595a() && c3417e.m14596b() == c3417e2.m14596b()) {
            arrayList.add(c3417e.f18509c);
            arrayList.add(c3417e2.f18509c);
            return arrayList;
        }
        Set hashSet = new HashSet();
        hashSet.add(Integer.valueOf(c3417e.m14596b()));
        hashSet.add(Integer.valueOf(c3417e2.m14596b()));
        List a = m14578a(this.f18491h, c3417e.m14595a(), c3417e2.m14595a(), c3417e.f18509c, c3417e2.f18509c, hashSet);
        double a2 = m14574a(a);
        if (a2 < Double.MAX_VALUE) {
            arrayList = a;
            d = a2;
        }
        hashSet.clear();
        hashSet.add(Integer.valueOf(c3417e.m14595a()));
        hashSet.add(Integer.valueOf(c3417e2.m14596b()));
        a = m14578a(this.f18491h, c3417e.m14596b(), c3417e2.m14595a(), c3417e.f18509c, c3417e2.f18509c, hashSet);
        a2 = m14574a(a);
        if (a2 < d) {
            arrayList = a;
            d = a2;
        }
        hashSet.clear();
        hashSet.add(Integer.valueOf(c3417e.m14596b()));
        hashSet.add(Integer.valueOf(c3417e2.m14595a()));
        a = m14578a(this.f18491h, c3417e.m14595a(), c3417e2.m14596b(), c3417e.f18509c, c3417e2.f18509c, hashSet);
        a2 = m14574a(a);
        if (a2 < d) {
            arrayList = a;
            d = a2;
        }
        hashSet.clear();
        hashSet.add(Integer.valueOf(c3417e.m14595a()));
        hashSet.add(Integer.valueOf(c3417e2.m14595a()));
        a = m14578a(this.f18491h, c3417e.m14596b(), c3417e2.m14596b(), c3417e.f18509c, c3417e2.f18509c, hashSet);
        return m14574a(a) < d ? a : arrayList;
    }

    /* renamed from: a */
    private ArrayList<C3415c> m14578a(String str, int i, int i2, C3415c c3415c, C3415c c3415c2, Set<Integer> set) {
        HashMap hashMap = (HashMap) this.f18485b.get(str);
        ArrayList arrayList = new ArrayList();
        Queue linkedList = new LinkedList();
        linkedList.add(new C3411a(null, i, 0));
        while (!linkedList.isEmpty()) {
            C3411a c3411a = (C3411a) linkedList.poll();
            if (!set.contains(Integer.valueOf(c3411a.f18471b)) && c3411a.f18472c <= 4) {
                if (c3411a.f18471b != i2) {
                    set.add(Integer.valueOf(c3411a.f18471b));
                    if (c3411a.f18472c < 4) {
                        Vector vector = (Vector) hashMap.get(Integer.valueOf(c3411a.f18471b));
                        int i3 = 0;
                        while (vector != null && i3 < vector.size()) {
                            linkedList.offer(new C3411a(c3411a, ((Integer) vector.get(i3)).intValue(), c3411a.f18472c + 1));
                            i3++;
                        }
                    }
                } else {
                    arrayList.add(c3411a);
                }
            }
        }
        ArrayList<C3415c> arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            ArrayList arrayList3 = new ArrayList();
            for (C3411a c3411a2 = (C3411a) arrayList.get(i4); c3411a2 != null; c3411a2 = c3411a2.f18470a) {
                arrayList3.add((C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(c3411a2.f18471b)));
            }
            Collection arrayList4 = new ArrayList();
            for (int size = arrayList3.size() - 1; size >= 0; size--) {
                arrayList4.add(arrayList3.get(size));
            }
            if (m14573a(c3415c, c3415c2, arrayList3) < ((double) Float.MAX_VALUE)) {
                arrayList2.clear();
                arrayList2.add(c3415c);
                arrayList2.addAll(arrayList4);
                arrayList2.add(c3415c2);
            }
        }
        return arrayList2;
    }

    /* renamed from: a */
    private boolean m14579a(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(str)));
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            HashMap hashMap = null;
            HashMap hashMap2 = null;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    HashMap hashMap3 = (HashMap) this.f18484a.get(this.f18491h);
                    hashMap3 = (HashMap) this.f18485b.get(this.f18491h);
                    return true;
                } else if (readLine.contains("Floor")) {
                    HashMap hashMap4 = new HashMap();
                    HashMap hashMap5 = new HashMap();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    Object obj = readLine.split(Config.TRACE_TODAY_VISIT_SPLIT)[1];
                    this.f18484a.put(obj, hashMap4);
                    this.f18485b.put(obj, hashMap5);
                    this.f18486c.put(obj, arrayList3);
                    this.f18487d.put(obj, arrayList4);
                    hashMap = hashMap5;
                    hashMap2 = hashMap4;
                    arrayList = arrayList4;
                    arrayList2 = arrayList3;
                } else {
                    int intValue;
                    String[] split;
                    String[] split2 = readLine.split(",");
                    if (split2[0].equals("0")) {
                        intValue = Integer.valueOf(split2[2]).intValue();
                        C3415c c3415c = new C3415c();
                        c3415c.f18500a = Double.valueOf(split2[4]).doubleValue();
                        c3415c.f18501b = Double.valueOf(split2[3]).doubleValue();
                        c3415c.f18502c = intValue;
                        hashMap2.put(Integer.valueOf(intValue), c3415c);
                    }
                    if (split2[0].equals("1")) {
                        for (int i = 1; i < split2.length; i++) {
                            Vector vector;
                            int intValue2;
                            String[] split3 = split2[i].split("-");
                            if (hashMap.keySet().contains(Integer.valueOf(split3[0]))) {
                                vector = (Vector) hashMap.get(Integer.valueOf(split3[0]));
                                if (!vector.contains(Integer.valueOf(split3[1]))) {
                                    vector.add(Integer.valueOf(split3[1]));
                                    Collections.sort(vector);
                                }
                            } else {
                                vector = new Vector();
                                intValue2 = Integer.valueOf(split3[0]).intValue();
                                vector.add(Integer.valueOf(split3[1]));
                                hashMap.put(Integer.valueOf(intValue2), vector);
                            }
                            if (hashMap.keySet().contains(Integer.valueOf(split3[1]))) {
                                vector = (Vector) hashMap.get(Integer.valueOf(split3[1]));
                                if (!vector.contains(Integer.valueOf(split3[0]))) {
                                    vector.add(Integer.valueOf(split3[0]));
                                    Collections.sort(vector);
                                }
                            } else {
                                vector = new Vector();
                                intValue2 = Integer.valueOf(split3[1]).intValue();
                                vector.add(Integer.valueOf(split3[0]));
                                hashMap.put(Integer.valueOf(intValue2), vector);
                            }
                        }
                    }
                    if (split2[0].equals("2")) {
                        split = split2[1].split("-");
                        ArrayList arrayList5 = new ArrayList();
                        for (String valueOf : split) {
                            arrayList5.add(Integer.valueOf(valueOf));
                        }
                        arrayList2.add(arrayList5);
                    }
                    if (split2[0].equals("3")) {
                        split = split2[1].split("-");
                        ArrayList arrayList6 = new ArrayList();
                        for (String valueOf2 : split) {
                            arrayList6.add(Integer.valueOf(valueOf2));
                        }
                        arrayList.add(arrayList6);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    /* renamed from: b */
    private C3415c m14580b(C3415c c3415c, C3415c c3415c2, C3415c c3415c3) {
        C3415c c3415c4 = new C3415c();
        double d = c3415c2.f18500a;
        double d2 = c3415c2.f18501b;
        double d3 = c3415c3.f18500a;
        double d4 = c3415c3.f18501b;
        double d5 = c3415c.f18500a;
        double d6 = c3415c.f18501b;
        d6 = Math.sqrt(((d5 - d) * (d5 - d)) + ((d6 - d2) * (d6 - d2)));
        if (Math.abs((d2 - d4) / (d - d3)) > 200.0d) {
            d5 = d2 + d6;
            d6 = d2 - d6;
            if (((d - d) * (d3 - d)) + ((d5 - d2) * (d4 - d2)) <= 0.0d) {
                d5 = d6;
            }
            d6 = d;
        } else {
            double d7 = (d4 - d2) / (d3 - d);
            double d8 = ((d * d4) - (d3 * d2)) / (d - d3);
            double d9 = (d7 * d7) + 1.0d;
            double d10 = ((2.0d * d7) * (d8 - d2)) - (2.0d * d);
            d6 = ((d * d) + ((d8 - d2) * (d8 - d2))) - (d6 * d6);
            if ((d10 * d10) - ((4.0d * d9) * d6) < 0.0d) {
                c3415c4.f18500a = Double.MAX_VALUE;
                c3415c4.f18501b = Double.MAX_VALUE;
                return c3415c4;
            }
            double sqrt = ((-1.0d * d10) + Math.sqrt((d10 * d10) - ((4.0d * d9) * d6))) / (2.0d * d9);
            d5 = (d7 * sqrt) + d8;
            d9 = ((-1.0d * d10) - Math.sqrt((d10 * d10) - (d6 * (4.0d * d9)))) / (d9 * 2.0d);
            d6 = (d7 * d9) + d8;
            if (((d3 - d) * (sqrt - d)) + ((d4 - d2) * (d5 - d2)) > 0.0d) {
                d6 = sqrt;
            } else {
                d5 = d6;
                d6 = d9;
            }
        }
        c3415c4.f18500a = d6;
        c3415c4.f18501b = d5;
        return c3415c4;
    }

    /* renamed from: b */
    private boolean m14581b(C3412b c3412b, ArrayList<C3415c> arrayList) {
        boolean z = false;
        C3415c c3415c = new C3415c();
        c3415c.f18500a = c3412b.f18474b;
        c3415c.f18501b = c3412b.f18473a;
        if (arrayList.size() < 2) {
            return false;
        }
        C3415c c3415c2 = (C3415c) arrayList.get(0);
        C3415c c3415c3 = (C3415c) arrayList.get(arrayList.size() - 1);
        if (!(c3415c2.f18503d == Integer.MAX_VALUE || c3415c2.f18504e == Integer.MAX_VALUE)) {
            C3415c c3415c4 = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(c3415c2.f18503d));
            c3415c2 = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(c3415c2.f18504e));
            if (m14585d(m14582c(c3415c, c3415c4, c3415c2), c3415c4, c3415c2)) {
                return true;
            }
        }
        if (!(c3415c3.f18503d == Integer.MAX_VALUE || c3415c3.f18504e == Integer.MAX_VALUE)) {
            c3415c2 = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(c3415c3.f18503d));
            c3415c3 = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(c3415c3.f18504e));
            if (m14585d(m14582c(c3415c, c3415c2, c3415c3), c3415c2, c3415c3)) {
                return true;
            }
        }
        for (int i = 0; i < arrayList.size() - 1; i++) {
            c3415c2 = (C3415c) arrayList.get(i);
            c3415c3 = (C3415c) arrayList.get(i + 1);
            if (m14585d(m14582c(c3415c, c3415c2, c3415c3), c3415c2, c3415c3)) {
                z = true;
                break;
            }
        }
        return !c3412b.f18481i ? z : true;
    }

    /* renamed from: c */
    private C3415c m14582c(C3415c c3415c, C3415c c3415c2, C3415c c3415c3) {
        C3415c c3415c4 = new C3415c();
        double d = c3415c.f18500a;
        double d2 = c3415c.f18501b;
        double d3 = c3415c2.f18500a;
        double d4 = c3415c2.f18501b;
        double d5 = c3415c3.f18500a;
        double d6 = c3415c3.f18501b;
        if (Math.abs((d4 - d6) / (d3 - d5)) > 20000.0d) {
            c3415c4.f18500a = d3;
            c3415c4.f18501b = d2;
        } else {
            d5 = (d4 - d6) / (d3 - d5);
            c3415c4.f18500a = ((d / d5) + ((d2 - d4) + (d5 * d3))) * (d5 / ((d5 * d5) + 1.0d));
            c3415c4.f18501b = ((c3415c4.f18500a - d3) * d5) + d4;
        }
        return c3415c4;
    }

    /* renamed from: c */
    private boolean m14583c(BDLocation bDLocation) {
        this.f18498o = false;
        String buildingName = bDLocation.getBuildingName();
        if (!this.f18494k) {
            if (!buildingName.equals(this.f18499p)) {
                this.f18495l = false;
                this.f18496m = false;
                C3409a.m14530b().m14534a(buildingName);
            }
            this.f18499p = buildingName;
        }
        this.f18491h = bDLocation.getFloor();
        if (bDLocation.getNetworkLocationType().equals("wf")) {
            if (this.f18494k) {
                this.f18499p = buildingName;
                C3409a.m14530b().m14534a(buildingName);
            }
            this.f18494k = false;
        }
        if (!this.f18496m) {
            if (!this.f18495l) {
                return false;
            }
            if (m14579a(C3391g.m14456l() + File.separator + "indoorinfo" + File.separator + buildingName + File.separator + buildingName + ".txt")) {
                this.f18496m = true;
            } else {
                this.f18496m = false;
                this.f18495l = false;
                C3409a.m14530b().mo2499c();
                return false;
            }
        }
        if (this.f18484a.get(this.f18491h) == null) {
            return false;
        }
        if (bDLocation.getNetworkLocationType().equals("wf")) {
            this.f18492i = this.f18491h;
            this.f18497n = new C3412b(bDLocation.getLongitude(), bDLocation.getLatitude());
            this.f18497n.f18477e = this.f18497n.f18474b;
            this.f18497n.f18476d = this.f18497n.f18473a;
            this.f18488e = new ArrayList();
            this.f18489f = new ArrayList();
            if (m14590b(bDLocation)) {
                this.f18490g.m14564b();
                this.f18497n = null;
                this.f18493j = false;
                return true;
            } else if (this.f18491h.equals(this.f18492i)) {
                HashMap e = m14587e(bDLocation);
                if (e.size() <= 0) {
                    return true;
                }
                if (this.f18490g.m14567c()) {
                    this.f18497n.m14545a(e);
                    if (!this.f18498o) {
                        m14584d(bDLocation);
                        this.f18493j = true;
                        this.f18490g.m14561a(this.f18497n);
                    }
                    return true;
                } else if (this.f18498o) {
                    return true;
                } else {
                    double d = -1.0d;
                    C3417e c3417e = null;
                    for (Entry value : e.entrySet()) {
                        C3417e c3417e2 = (C3417e) value.getValue();
                        if (c3417e2.f18511e > d) {
                            d = c3417e2.f18511e;
                        } else {
                            c3417e2 = c3417e;
                        }
                        c3417e = c3417e2;
                    }
                    if (c3417e == null || c3417e.f18511e <= 0.5d) {
                        this.f18490g.m14564b();
                        this.f18493j = false;
                        return true;
                    }
                    bDLocation.setLatitude(c3417e.f18509c.f18500a);
                    bDLocation.setLongitude(c3417e.f18509c.f18501b);
                    this.f18497n.f18477e = c3417e.f18509c.f18500a;
                    this.f18497n.f18476d = c3417e.f18509c.f18501b;
                    bDLocation.setNetworkLocationType("wf2");
                    this.f18493j = true;
                    this.f18497n.f18478f = false;
                    this.f18497n.f18479g = new C3415c();
                    this.f18497n.f18479g.f18500a = c3417e.f18507a.f18500a;
                    this.f18497n.f18479g.f18501b = c3417e.f18507a.f18501b;
                    this.f18497n.f18480h = new C3415c();
                    this.f18497n.f18480h.f18500a = c3417e.f18508b.f18500a;
                    this.f18497n.f18480h.f18501b = c3417e.f18508b.f18501b;
                    if (!this.f18490g.m14567c()) {
                        this.f18497n.m14545a(e);
                        this.f18490g.m14561a(this.f18497n);
                    }
                    return true;
                }
            } else {
                this.f18490g.m14564b();
                if (this.f18493j) {
                    this.f18493j = false;
                }
                this.f18492i = this.f18491h;
                return true;
            }
        } else if (!bDLocation.getNetworkLocationType().equals("dr")) {
            return true;
        } else {
            this.f18488e.add(new BDLocation(bDLocation));
            if (this.f18493j) {
                m14584d(bDLocation);
                this.f18489f.add(bDLocation);
            }
            return true;
        }
    }

    /* renamed from: d */
    private void m14584d(BDLocation bDLocation) {
        C3415c c;
        C3415c c3415c;
        int i;
        if (bDLocation.getNetworkLocationType().equals("dr")) {
            double e = this.f18497n.f18476d;
            double f = this.f18497n.f18477e;
            double b = this.f18497n.f18473a;
            double a = this.f18497n.f18474b;
            bDLocation.setLongitude((e + bDLocation.getLongitude()) - b);
            bDLocation.setLatitude((bDLocation.getLatitude() + f) - a);
            C3415c c3415c2 = new C3415c();
            c3415c2.f18500a = bDLocation.getLatitude();
            c3415c2.f18501b = bDLocation.getLongitude();
            if (!(this.f18497n.f18479g == null || this.f18497n.f18480h == null)) {
                if (!this.f18497n.f18478f) {
                    c = m14582c(c3415c2, this.f18497n.f18479g, this.f18497n.f18480h);
                } else if (this.f18497n.f18481i) {
                    c = m14580b(c3415c2, this.f18497n.f18479g, this.f18497n.f18480h);
                    if (c.f18500a == Double.MAX_VALUE && c.f18501b == Double.MAX_VALUE) {
                        c = m14582c(c3415c2, this.f18497n.f18479g, this.f18497n.f18480h);
                        bDLocation.setLongitude(c.f18501b);
                        bDLocation.setLatitude(c.f18500a);
                        bDLocation.setNetworkLocationType("dr2");
                        return;
                    }
                    bDLocation.setLongitude(c.f18501b);
                    bDLocation.setLatitude(c.f18500a);
                    bDLocation.setNetworkLocationType("dr2");
                    return;
                } else {
                    C3415c a2 = m14576a(c3415c2, this.f18497n.f18479g, this.f18497n.f18480h);
                    if (a2.f18500a == Double.MAX_VALUE && a2.f18501b == Double.MAX_VALUE) {
                        c = m14582c(c3415c2, this.f18497n.f18479g, this.f18497n.f18480h);
                        bDLocation.setLongitude(c.f18501b);
                        bDLocation.setLatitude(c.f18500a);
                        bDLocation.setNetworkLocationType("dr2");
                        return;
                    }
                    if (this.f18497n.f18480h.f18503d != Integer.MAX_VALUE) {
                        int i2 = this.f18497n.f18480h.f18503d;
                        c = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(i2));
                        c3415c = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(this.f18497n.f18480h.f18504e));
                        if (!m14585d(a2, c, c3415c)) {
                            C3415c c3415c3;
                            C3415c c3415c4 = new C3415c();
                            i = 0;
                            if (this.f18497n.f18479g.f18502c == Integer.MAX_VALUE) {
                                c3415c3 = new C3415c();
                                c3415c3.f18500a = this.f18497n.f18479g.f18500a;
                                c3415c3.f18501b = this.f18497n.f18479g.f18501b;
                                C3415c c3415c5 = new C3415c();
                                c3415c5.f18500a = this.f18497n.f18480h.f18500a;
                                c3415c5.f18501b = this.f18497n.f18480h.f18501b;
                                if (c.m14593a(c3415c3) > c.m14593a(c3415c5)) {
                                    c3415c4.f18502c = c.f18502c;
                                    c3415c4.f18500a = c.f18500a;
                                    c3415c4.f18501b = c.f18501b;
                                    i = c3415c.f18502c;
                                }
                                if (c.m14593a(c3415c3) < c.m14593a(c3415c5)) {
                                    c3415c4.f18502c = c3415c.f18502c;
                                    c3415c4.f18500a = c3415c.f18500a;
                                    c3415c4.f18501b = c3415c.f18501b;
                                    i = c.f18502c;
                                }
                                if (c.m14593a(c3415c3) == c.m14593a(c3415c5)) {
                                    bDLocation.setLongitude(a2.f18501b);
                                    bDLocation.setLatitude(a2.f18500a);
                                    bDLocation.setNetworkLocationType("dr2");
                                    return;
                                }
                            } else if (c.f18502c == this.f18497n.f18479g.f18502c) {
                                c3415c4.f18500a = c3415c.f18500a;
                                c3415c4.f18501b = c3415c.f18501b;
                                c3415c4.f18502c = c3415c.f18502c;
                                i = c.f18502c;
                            } else {
                                c3415c4.f18500a = c.f18500a;
                                c3415c4.f18501b = c.f18501b;
                                c3415c4.f18502c = c.f18502c;
                                i = c3415c.f18502c;
                            }
                            Vector vector = (Vector) ((HashMap) this.f18485b.get(this.f18491h)).get(Integer.valueOf(c3415c4.f18502c));
                            c3415c3 = new C3415c();
                            if (vector.size() == 2) {
                                if (((Integer) vector.get(0)).intValue() != i) {
                                    c3415c3.f18500a = ((C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(vector.get(0))).f18500a;
                                    c3415c3.f18501b = ((C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(vector.get(0))).f18501b;
                                } else {
                                    c3415c3.f18500a = ((C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(vector.get(1))).f18500a;
                                    c3415c3.f18501b = ((C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(vector.get(1))).f18501b;
                                }
                                c = m14580b(c3415c2, c3415c4, c3415c3);
                                if (c.f18500a == Double.MAX_VALUE && c.f18501b == Double.MAX_VALUE) {
                                    c = m14582c(c3415c2, this.f18497n.f18479g, this.f18497n.f18480h);
                                    bDLocation.setLongitude(c.f18501b);
                                    bDLocation.setLatitude(c.f18500a);
                                    bDLocation.setNetworkLocationType("dr2");
                                    return;
                                }
                            }
                        }
                    }
                    c = a2;
                }
                bDLocation.setLongitude(c.f18501b);
                bDLocation.setLatitude(c.f18500a);
            }
            bDLocation.setNetworkLocationType("dr2");
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (bDLocation.getNetworkLocationType().equals("wf")) {
            C3412b c3412b = (C3412b) this.f18490g.f18482a.getFirst();
            HashMap i3 = this.f18497n.m14543a();
            HashMap i4 = c3412b.m14543a();
            for (Entry value : i3.entrySet()) {
                C3417e c3417e = (C3417e) value.getValue();
                for (Entry value2 : i4.entrySet()) {
                    ArrayList a3 = m14577a((C3417e) value2.getValue(), c3417e);
                    if (a3 != null && a3.size() > 0) {
                        arrayList.add(a3);
                    }
                }
            }
            if (arrayList.size() == 0) {
                this.f18497n.f18477e = bDLocation.getLatitude();
                this.f18497n.f18476d = bDLocation.getLongitude();
                bDLocation.setNetworkLocationType("wf2");
                return;
            }
            ArrayList arrayList2;
            int i5;
            for (i = 0; i < arrayList.size(); i++) {
                arrayList2 = (ArrayList) arrayList.get(i);
                Iterator it = this.f18490g.f18482a.iterator();
                i5 = 0;
                int i6 = 0;
                while (it.hasNext()) {
                    C3412b c3412b2 = (C3412b) it.next();
                    if (i6 != 0) {
                        if (!m14581b(c3412b2, arrayList2)) {
                            break;
                        }
                        i5++;
                    } else {
                        i6++;
                    }
                }
                if (i5 < this.f18490g.m14568d() - 1) {
                    arrayList.remove(i);
                }
            }
            if (arrayList.size() == 0) {
                this.f18497n.f18477e = bDLocation.getLatitude();
                this.f18497n.f18476d = bDLocation.getLongitude();
                bDLocation.setNetworkLocationType("wf2");
                return;
            }
            c = new C3415c();
            if (arrayList.size() == 1) {
                c = (C3415c) ((ArrayList) arrayList.get(0)).get(((ArrayList) arrayList.get(0)).size() - 1);
                bDLocation.setLatitude(c.f18500a);
                bDLocation.setLongitude(c.f18501b);
                this.f18497n.f18477e = c.f18500a;
                this.f18497n.f18476d = c.f18501b;
                bDLocation.setNetworkLocationType("wf2");
                this.f18497n.f18478f = true;
                this.f18497n.f18479g = new C3415c();
                this.f18497n.f18479g.f18500a = ((C3415c) ((ArrayList) arrayList.get(0)).get(((ArrayList) arrayList.get(0)).size() - 2)).f18500a;
                this.f18497n.f18479g.f18501b = ((C3415c) ((ArrayList) arrayList.get(0)).get(((ArrayList) arrayList.get(0)).size() - 2)).f18501b;
                this.f18497n.f18479g.f18502c = ((C3415c) ((ArrayList) arrayList.get(0)).get(((ArrayList) arrayList.get(0)).size() - 2)).f18502c;
                this.f18497n.f18480h = new C3415c();
                this.f18497n.f18480h.f18500a = ((C3415c) ((ArrayList) arrayList.get(0)).get(((ArrayList) arrayList.get(0)).size() - 1)).f18500a;
                this.f18497n.f18480h.f18501b = ((C3415c) ((ArrayList) arrayList.get(0)).get(((ArrayList) arrayList.get(0)).size() - 1)).f18501b;
                this.f18497n.f18480h.f18503d = ((C3415c) ((ArrayList) arrayList.get(0)).get(((ArrayList) arrayList.get(0)).size() - 1)).f18503d;
                this.f18497n.f18480h.f18504e = ((C3415c) ((ArrayList) arrayList.get(0)).get(((ArrayList) arrayList.get(0)).size() - 1)).f18504e;
                this.f18497n.f18480h.f18502c = ((C3415c) ((ArrayList) arrayList.get(0)).get(((ArrayList) arrayList.get(0)).size() - 1)).f18502c;
                return;
            }
            i5 = 0;
            if (arrayList.size() >= 2) {
                ArrayList arrayList3 = new ArrayList();
                for (i2 = 0; i2 < arrayList.size(); i2++) {
                    arrayList3.add(Double.valueOf(m14571a(bDLocation, (ArrayList) arrayList.get(i2))));
                }
                f = Double.MAX_VALUE;
                for (i2 = 0; i2 < arrayList3.size(); i2++) {
                    if (((Double) arrayList3.get(i2)).doubleValue() < f) {
                        f = ((Double) arrayList3.get(i2)).doubleValue();
                        i5 = i2;
                    }
                }
                arrayList2 = (ArrayList) arrayList.get(i5);
                c3415c = (C3415c) arrayList2.get(arrayList2.size() - 1);
                bDLocation.setLatitude(c3415c.f18500a);
                bDLocation.setLongitude(c3415c.f18501b);
                this.f18497n.f18477e = c3415c.f18500a;
                this.f18497n.f18476d = c3415c.f18501b;
                this.f18497n.f18478f = true;
                this.f18497n.f18479g = new C3415c();
                this.f18497n.f18479g.f18500a = ((C3415c) arrayList2.get(arrayList2.size() - 2)).f18500a;
                this.f18497n.f18479g.f18501b = ((C3415c) arrayList2.get(arrayList2.size() - 2)).f18501b;
                this.f18497n.f18479g.f18502c = ((C3415c) arrayList2.get(arrayList2.size() - 2)).f18502c;
                this.f18497n.f18480h = new C3415c();
                this.f18497n.f18480h.f18500a = ((C3415c) arrayList2.get(arrayList2.size() - 1)).f18500a;
                this.f18497n.f18480h.f18501b = ((C3415c) arrayList2.get(arrayList2.size() - 1)).f18501b;
                this.f18497n.f18480h.f18503d = ((C3415c) arrayList2.get(arrayList2.size() - 1)).f18503d;
                this.f18497n.f18480h.f18504e = ((C3415c) arrayList2.get(arrayList2.size() - 1)).f18504e;
                this.f18497n.f18480h.f18502c = ((C3415c) arrayList2.get(arrayList2.size() - 1)).f18502c;
                bDLocation.setNetworkLocationType("wf2");
            }
        }
    }

    /* renamed from: d */
    private boolean m14585d(C3415c c3415c, C3415c c3415c2, C3415c c3415c3) {
        double d = c3415c.f18500a;
        double d2 = c3415c.f18501b;
        double d3 = c3415c2.f18500a;
        return ((c3415c3.f18500a - d) * (d3 - d)) + ((c3415c3.f18501b - d2) * (c3415c2.f18501b - d2)) <= 0.0d;
    }

    /* renamed from: e */
    private double m14586e(C3415c c3415c, C3415c c3415c2, C3415c c3415c3) {
        C3415c c3415c4 = new C3415c();
        C3415c c3415c5 = new C3415c();
        c3415c4.f18500a = c3415c2.f18500a - c3415c.f18500a;
        c3415c4.f18501b = c3415c2.f18501b - c3415c.f18501b;
        c3415c5.f18500a = c3415c3.f18500a - c3415c.f18500a;
        c3415c5.f18501b = c3415c3.f18501b - c3415c.f18501b;
        return Math.acos(((c3415c4.f18500a * c3415c5.f18500a) + (c3415c4.f18501b * c3415c5.f18501b)) / (c3415c5.m14592a() * c3415c4.m14592a()));
    }

    /* renamed from: e */
    private HashMap<String, C3417e> m14587e(BDLocation bDLocation) {
        C3415c c3415c;
        Vector vector;
        int intValue;
        C3415c c3415c2;
        int i;
        HashMap<String, C3417e> hashMap = new HashMap();
        double latitude = bDLocation.getLatitude();
        double longitude = bDLocation.getLongitude();
        C3415c c3415c3 = new C3415c();
        c3415c3.f18500a = latitude;
        c3415c3.f18501b = longitude;
        HashMap hashMap2 = (HashMap) this.f18485b.get(this.f18491h);
        if (hashMap2 != null) {
            HashMap hashMap3 = new HashMap();
            for (Entry entry : hashMap2.entrySet()) {
                int intValue2 = ((Integer) entry.getKey()).intValue();
                c3415c = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(intValue2));
                vector = (Vector) entry.getValue();
                for (int i2 = 0; i2 < vector.size(); i2++) {
                    intValue = ((Integer) vector.get(i2)).intValue();
                    String str = String.valueOf(intValue2 > intValue ? intValue : intValue2) + JNISearchConst.LAYER_ID_DIVIDER + String.valueOf(intValue2 < intValue ? intValue : intValue2);
                    if (!hashMap3.containsKey(str)) {
                        hashMap3.put(str, Integer.valueOf(1));
                        c3415c2 = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(intValue));
                        C3415c c = m14582c(c3415c3, c3415c, c3415c2);
                        if (m14585d(c, c3415c, c3415c2)) {
                            C3417e c3417e = new C3417e();
                            c3417e.f18509c = c;
                            c3417e.f18510d = c3415c3.m14593a(c);
                            c3417e.f18507a = c3415c;
                            c3417e.f18508b = c3415c2;
                            if (c3417e.f18510d < 2.0E-4d) {
                                hashMap.put(str, c3417e);
                            }
                        }
                    }
                }
            }
        }
        if (hashMap.size() > 0) {
            longitude = 0.0d;
            for (Entry entry2 : hashMap.entrySet()) {
                longitude = (1.0d / (((C3417e) entry2.getValue()).f18510d + 1.0E-6d)) + longitude;
            }
            ArrayList arrayList = new ArrayList();
            for (Entry entry22 : hashMap.entrySet()) {
                C3417e c3417e2 = (C3417e) entry22.getValue();
                String str2 = (String) entry22.getKey();
                if (hashMap.size() == 1) {
                    c3417e2.f18511e = 1.0d;
                } else {
                    c3417e2.f18511e = (1.0d / (1.0E-6d + c3417e2.f18510d)) / longitude;
                }
                if (c3417e2.f18511e < 0.1d) {
                    arrayList.add(str2);
                }
            }
            for (i = 0; i < arrayList.size(); i++) {
                hashMap.remove((String) arrayList.get(i));
            }
        }
        if (hashMap.size() >= 0) {
            C3415c c3415c4 = null;
            double d = 999999.0d;
            int i3 = 0;
            for (Entry entry222 : ((HashMap) this.f18484a.get(this.f18491h)).entrySet()) {
                i = ((Integer) entry222.getKey()).intValue();
                C3415c c3415c5 = (C3415c) entry222.getValue();
                if (Math.abs(c3415c5.f18500a - c3415c3.f18500a) <= 5.0E-4d && Math.abs(c3415c5.f18501b - c3415c3.f18501b) <= 5.0E-4d) {
                    int i4;
                    double a = c3415c5.m14593a(c3415c3);
                    if (d > a) {
                        longitude = a;
                        int i5 = i;
                        c3415c = c3415c5;
                        i4 = i5;
                    } else {
                        i4 = i3;
                        c3415c = c3415c4;
                        longitude = d;
                    }
                    d = longitude;
                    i3 = i4;
                    c3415c4 = c3415c;
                }
            }
            Object obj = 1;
            for (Entry entry2222 : hashMap.entrySet()) {
                obj = ((C3417e) entry2222.getValue()).f18510d <= d ? null : obj;
            }
            if (obj == null) {
                return hashMap;
            }
            hashMap.clear();
            vector = (Vector) ((HashMap) this.f18485b.get(this.f18491h)).get(Integer.valueOf(i3));
            if (vector == null) {
                return hashMap;
            }
            i = ((Integer) vector.get(0)).intValue();
            C3417e c3417e3 = new C3417e();
            c3417e3.f18509c = c3415c4;
            c3417e3.f18510d = 0.0d;
            c3417e3.f18507a = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(i3));
            c3417e3.f18508b = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(i));
            hashMap.put(String.valueOf(i3) + JNISearchConst.LAYER_ID_DIVIDER + String.valueOf(i), c3417e3);
            this.f18497n.f18474b = bDLocation.getLatitude();
            this.f18497n.f18473a = bDLocation.getLongitude();
            bDLocation.setLatitude(c3415c4.f18500a);
            bDLocation.setLongitude(c3415c4.f18501b);
            bDLocation.setNetworkLocationType("wf2");
            this.f18498o = true;
            this.f18497n.f18479g = new C3415c();
            this.f18497n.f18479g.f18500a = c3417e3.f18508b.f18500a;
            this.f18497n.f18479g.f18501b = c3417e3.f18508b.f18501b;
            this.f18497n.f18480h = new C3415c();
            this.f18497n.f18480h.f18500a = c3415c4.f18500a;
            this.f18497n.f18480h.f18501b = c3415c4.f18501b;
            this.f18497n.f18477e = c3415c4.f18500a;
            this.f18497n.f18476d = c3415c4.f18501b;
            this.f18497n.m14545a((HashMap) hashMap);
            this.f18497n.f18481i = true;
            this.f18497n.f18478f = false;
            if (this.f18490g.m14567c()) {
                C3412b c3412b = (C3412b) this.f18490g.f18482a.getLast();
                if (c3412b.f18480h != null && (c3412b.f18480h.f18503d == i3 || c3412b.f18480h.f18504e == i3)) {
                    c3417e3.f18507a = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(i3));
                    this.f18497n.f18478f = true;
                    intValue = c3412b.f18480h.f18504e == i3 ? c3412b.f18480h.f18503d : c3412b.f18480h.f18503d == i3 ? c3412b.f18480h.f18504e : 0;
                    c3417e3.f18508b = (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(Integer.valueOf(intValue));
                    vector = (Vector) ((HashMap) this.f18485b.get(this.f18491h)).get(Integer.valueOf(i3));
                    c3415c2 = new C3415c();
                    if (vector.size() == 2) {
                        if (((Integer) vector.get(0)).intValue() != intValue) {
                            c3415c2.f18500a = ((C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(vector.get(0))).f18500a;
                            c3415c2.f18501b = ((C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(vector.get(0))).f18501b;
                        } else {
                            c3415c2.f18500a = ((C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(vector.get(1))).f18500a;
                            c3415c2.f18501b = ((C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(vector.get(1))).f18501b;
                        }
                    }
                    this.f18497n.f18480h = c3415c2;
                    this.f18497n.f18479g = c3415c4;
                    this.f18497n.f18480h.f18503d = Integer.MAX_VALUE;
                    this.f18497n.f18481i = true;
                }
                this.f18490g.m14560a();
                this.f18490g.m14561a(this.f18497n);
            } else {
                this.f18490g.m14561a(this.f18497n);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public boolean m14588a(BDLocation bDLocation) {
        return false;
    }

    /* renamed from: b */
    void m14589b() {
        this.f18495l = true;
    }

    /* renamed from: b */
    boolean m14590b(BDLocation bDLocation) {
        boolean z = false;
        ArrayList arrayList = (ArrayList) this.f18486c.get(this.f18491h);
        ArrayList arrayList2 = (ArrayList) this.f18487d.get(this.f18491h);
        C3415c c3415c = new C3415c();
        c3415c.f18500a = bDLocation.getLatitude();
        c3415c.f18501b = bDLocation.getLongitude();
        int i = 0;
        while (arrayList != null && i < arrayList.size()) {
            ArrayList arrayList3 = (ArrayList) arrayList.get(i);
            double d = 0.0d;
            for (int i2 = 0; i2 < arrayList3.size() - 1; i2++) {
                d += m14586e(c3415c, (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(arrayList3.get(i2)), (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(arrayList3.get(i2 + 1)));
            }
            if (Math.abs((m14586e(c3415c, (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(arrayList3.get(0)), (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(arrayList3.get(arrayList3.size() - 1))) + d) - 360.0d) < 0.1d) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            i = 0;
            while (arrayList2 != null && i < arrayList2.size()) {
                arrayList = (ArrayList) arrayList2.get(i);
                d = 0.0d;
                for (int i3 = 0; i3 < arrayList.size() - 1; i3++) {
                    d += m14586e(c3415c, (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(arrayList.get(i3)), (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(arrayList.get(i3 + 1)));
                }
                if (Math.abs((m14586e(c3415c, (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(arrayList.get(0)), (C3415c) ((HashMap) this.f18484a.get(this.f18491h)).get(arrayList.get(arrayList.size() - 1))) + d) - 360.0d) < 0.1d) {
                    return true;
                }
                i++;
            }
        }
        return z;
    }
}
