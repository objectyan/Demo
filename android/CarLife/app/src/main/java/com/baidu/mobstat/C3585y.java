package com.baidu.mobstat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.baidu.mobstat.y */
public enum C3585y {
    AP_LIST(0),
    APP_LIST(1),
    APP_TRACE(2),
    APP_CHANGE(3),
    APP_APK(4);
    
    /* renamed from: f */
    private int f19381f;

    /* renamed from: a */
    public abstract C3586x mo2721a();

    private C3585y(int i) {
        this.f19381f = i;
    }

    public String toString() {
        return String.valueOf(this.f19381f);
    }

    /* renamed from: a */
    public synchronized ArrayList<C3608w> m15292a(int i, int i2) {
        ArrayList<C3608w> arrayList;
        arrayList = new ArrayList();
        C3586x c3586x = null;
        try {
            c3586x = mo2721a();
            if (c3586x.m15312a()) {
                arrayList = c3586x.mo2723a(i, i2);
                if (c3586x != null) {
                    c3586x.close();
                }
            } else if (c3586x != null) {
                c3586x.close();
            }
        } catch (Throwable e) {
            bd.m15432b(e);
            if (c3586x != null) {
                c3586x.close();
            }
        } catch (Throwable th) {
            if (c3586x != null) {
                c3586x.close();
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized long m15290a(long j, String str) {
        long j2;
        j2 = -1;
        C3586x c3586x = null;
        try {
            c3586x = mo2721a();
            if (c3586x.m15312a()) {
                j2 = c3586x.mo2722a(String.valueOf(j), str);
                if (c3586x != null) {
                    c3586x.close();
                }
            } else if (c3586x != null) {
                c3586x.close();
            }
        } catch (Throwable e) {
            bd.m15432b(e);
            if (c3586x != null) {
                c3586x.close();
            }
        } catch (Throwable th) {
            if (c3586x != null) {
                c3586x.close();
            }
        }
        return j2;
    }

    /* renamed from: a */
    public synchronized int m15289a(ArrayList<Long> arrayList) {
        int i = 0;
        synchronized (this) {
            if (arrayList != null) {
                if (arrayList.size() != 0) {
                    C3586x c3586x = null;
                    int i2;
                    try {
                        c3586x = mo2721a();
                        if (c3586x.m15312a()) {
                            int size = arrayList.size();
                            int i3 = 0;
                            while (i3 < size) {
                                if (c3586x.mo2724b(((Long) arrayList.get(i3)).longValue())) {
                                    i3++;
                                    i++;
                                } else if (c3586x != null) {
                                    c3586x.close();
                                }
                            }
                            if (c3586x != null) {
                                c3586x.close();
                                i2 = i;
                            } else {
                                i2 = i;
                            }
                            i = i2;
                        } else if (c3586x != null) {
                            c3586x.close();
                        }
                    } catch (Throwable e) {
                        Throwable th = e;
                        i2 = 0;
                        bd.m15432b(th);
                        if (c3586x != null) {
                            c3586x.close();
                        }
                    } catch (Throwable th2) {
                        if (c3586x != null) {
                            c3586x.close();
                        }
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    public synchronized List<String> m15293a(int i) {
        List<String> arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        m15287a(arrayList, arrayList2, arrayList3, i, 500);
        if (arrayList3.size() != 0 && arrayList.size() == 0 && arrayList2.size() == 0) {
            C3608w c3608w = (C3608w) arrayList3.get(0);
            long a = c3608w.m15784a();
            String b = c3608w.m15785b();
            arrayList2.add(Long.valueOf(a));
            arrayList.add(b);
        }
        int a2 = m15289a(arrayList2);
        if (a2 != arrayList.size()) {
            arrayList = arrayList.subList(0, a2);
        }
        return arrayList;
    }

    /* renamed from: a */
    private int m15287a(List<String> list, ArrayList<Long> arrayList, ArrayList<C3608w> arrayList2, int i, int i2) {
        int i3 = 0;
        int c = m15288c();
        int i4 = 0;
        int i5 = i2;
        while (c > 0) {
            int i6;
            if (c < i5) {
                i6 = c;
            } else {
                i6 = i5;
            }
            ArrayList a = m15292a(i6, i4);
            if (i4 == 0 && a.size() != 0) {
                arrayList2.add((C3608w) a.get(0));
            }
            Iterator it = a.iterator();
            while (it.hasNext()) {
                C3608w c3608w = (C3608w) it.next();
                long a2 = c3608w.m15784a();
                String b = c3608w.m15785b();
                int length = b.length();
                if (i3 + length > i) {
                    break;
                }
                arrayList.add(Long.valueOf(a2));
                list.add(b);
                i3 += length;
            }
            c -= i6;
            i4 += i6;
            i5 = i6;
        }
        return i3;
    }

    /* renamed from: b */
    public synchronized boolean m15294b() {
        return m15288c() == 0;
    }

    /* renamed from: b */
    public synchronized boolean m15295b(int i) {
        return m15288c() >= i;
    }

    /* renamed from: c */
    private int m15288c() {
        C3586x c3586x = null;
        try {
            c3586x = mo2721a();
            if (c3586x.m15312a()) {
                int b = c3586x.m15314b();
                if (c3586x == null) {
                    return b;
                }
                c3586x.close();
                return b;
            }
            if (c3586x != null) {
                c3586x.close();
            }
            return 0;
        } catch (Throwable e) {
            bd.m15432b(e);
            if (c3586x != null) {
                c3586x.close();
            }
        } catch (Throwable th) {
            if (c3586x != null) {
                c3586x.close();
            }
        }
    }
}
