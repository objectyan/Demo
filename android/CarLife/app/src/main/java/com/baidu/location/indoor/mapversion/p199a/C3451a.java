package com.baidu.location.indoor.mapversion.p199a;

import com.baidu.location.BDLocation;
import com.baidu.location.indoor.mapversion.IndoorJni;
import com.baidu.location.indoor.mapversion.p198b.C3456a;
import com.baidu.location.indoor.mapversion.p198b.C3456a.C3455d;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.baidu.location.indoor.mapversion.a.a */
public class C3451a {
    /* renamed from: a */
    private static Lock f18700a = new ReentrantLock();

    /* renamed from: a */
    public static boolean m14816a() {
        return IndoorJni.f18699a;
    }

    /* renamed from: a */
    public static synchronized boolean m14817a(BDLocation bDLocation) {
        boolean z = false;
        synchronized (C3451a.class) {
            if (C3451a.m14816a()) {
                C3455d b = C3456a.m14829a().m14851b(bDLocation.getFloor());
                if (b != null) {
                    double a = b.m14822a(bDLocation.getLongitude());
                    double b2 = b.m14825b(bDLocation.getLatitude());
                    double[] dArr = new double[]{0.0d, 0.0d};
                    f18700a.lock();
                    try {
                        dArr = IndoorJni.setPfWf(a, b2);
                        f18700a.unlock();
                    } catch (Exception e) {
                        e.printStackTrace();
                        f18700a.unlock();
                    } catch (Throwable th) {
                        f18700a.unlock();
                    }
                    if (dArr[0] > 0.0d && dArr[1] > 0.0d) {
                        a = b.m14827c(dArr[0]);
                        double d = b.m14828d(dArr[1]);
                        bDLocation.setLongitude(a);
                        bDLocation.setLatitude(d);
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public static synchronized boolean m14818a(String str) {
        boolean z = true;
        synchronized (C3451a.class) {
            if (C3451a.m14816a()) {
                C3455d b = C3456a.m14829a().m14851b(str);
                if (b == null) {
                    z = false;
                } else {
                    b.m14824a("gcj02");
                    short[][] sArr = b.f18720g;
                    double d = b.m14823a().f18703a;
                    double d2 = b.m14823a().f18704b;
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < sArr.length; i++) {
                        int i2 = sArr[i][0];
                        int i3 = 1;
                        for (int i4 = 1; i4 < sArr[i].length; i4++) {
                            if (i2 != sArr[i][i4]) {
                                stringBuilder.append(i3).append("*").append(i2).append(";");
                                i2 = sArr[i][i4];
                                i3 = 1;
                            } else {
                                i3++;
                            }
                        }
                        stringBuilder.append(i3).append("*").append(i2).append(";");
                        if (i != sArr.length - 1) {
                            stringBuilder.append("|");
                        }
                    }
                    f18700a.lock();
                    try {
                        IndoorJni.setRdnt(str, sArr, d, d2, (int) b.f18719f.f18709g, (int) b.f18719f.f18710h);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        f18700a.unlock();
                    }
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static synchronized double[] m14819a(String str, double d, double d2) {
        double[] dArr = null;
        synchronized (C3451a.class) {
            if (C3451a.m14816a()) {
                C3455d b = C3456a.m14829a().m14851b(str);
                if (b != null) {
                    f18700a.lock();
                    double[] dArr2 = new double[2];
                    dArr2 = new double[]{0.0d, 0.0d};
                    try {
                        dArr2 = IndoorJni.getPfFr(d2, d);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        dArr2 = f18700a;
                        dArr2.unlock();
                    }
                    if (dArr2[0] > 0.0d && dArr2[1] > 0.0d) {
                        double c = b.m14827c(dArr2[0]);
                        double d3 = b.m14828d(dArr2[1]);
                        dArr = new double[]{d3, c};
                    }
                }
            }
        }
        return dArr;
    }

    /* renamed from: b */
    public static void m14820b() {
        if (C3451a.m14816a()) {
            try {
                IndoorJni.resetPf();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
