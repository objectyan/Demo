package com.facebook.common.p141m;

import javax.annotation.Nullable;

/* compiled from: HashCodeUtil */
/* renamed from: com.facebook.common.m.b */
public class C5366b {
    /* renamed from: a */
    private static final int f21950a = 31;

    /* renamed from: a */
    public static int m18370a(@Nullable Object o1) {
        int i;
        if (o1 == null) {
            i = 0;
        } else {
            i = o1.hashCode();
        }
        return C5366b.m18364a(i);
    }

    /* renamed from: a */
    public static int m18371a(@Nullable Object o1, @Nullable Object o2) {
        int i;
        int i2 = 0;
        if (o1 == null) {
            i = 0;
        } else {
            i = o1.hashCode();
        }
        if (o2 != null) {
            i2 = o2.hashCode();
        }
        return C5366b.m18365a(i, i2);
    }

    /* renamed from: a */
    public static int m18372a(@Nullable Object o1, @Nullable Object o2, @Nullable Object o3) {
        int i;
        int i2;
        int i3 = 0;
        if (o1 == null) {
            i = 0;
        } else {
            i = o1.hashCode();
        }
        if (o2 == null) {
            i2 = 0;
        } else {
            i2 = o2.hashCode();
        }
        if (o3 != null) {
            i3 = o3.hashCode();
        }
        return C5366b.m18366a(i, i2, i3);
    }

    /* renamed from: a */
    public static int m18373a(@Nullable Object o1, @Nullable Object o2, @Nullable Object o3, @Nullable Object o4) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (o1 == null) {
            i = 0;
        } else {
            i = o1.hashCode();
        }
        if (o2 == null) {
            i2 = 0;
        } else {
            i2 = o2.hashCode();
        }
        if (o3 == null) {
            i3 = 0;
        } else {
            i3 = o3.hashCode();
        }
        if (o4 != null) {
            i4 = o4.hashCode();
        }
        return C5366b.m18367a(i, i2, i3, i4);
    }

    /* renamed from: a */
    public static int m18374a(@Nullable Object o1, @Nullable Object o2, @Nullable Object o3, @Nullable Object o4, @Nullable Object o5) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        if (o1 == null) {
            i = 0;
        } else {
            i = o1.hashCode();
        }
        if (o2 == null) {
            i2 = 0;
        } else {
            i2 = o2.hashCode();
        }
        if (o3 == null) {
            i3 = 0;
        } else {
            i3 = o3.hashCode();
        }
        if (o4 == null) {
            i4 = 0;
        } else {
            i4 = o4.hashCode();
        }
        if (o5 != null) {
            i5 = o5.hashCode();
        }
        return C5366b.m18368a(i, i2, i3, i4, i5);
    }

    /* renamed from: a */
    public static int m18375a(@Nullable Object o1, @Nullable Object o2, @Nullable Object o3, @Nullable Object o4, @Nullable Object o5, @Nullable Object o6) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (o1 == null) {
            i = 0;
        } else {
            i = o1.hashCode();
        }
        if (o2 == null) {
            i2 = 0;
        } else {
            i2 = o2.hashCode();
        }
        if (o3 == null) {
            i3 = 0;
        } else {
            i3 = o3.hashCode();
        }
        if (o4 == null) {
            i4 = 0;
        } else {
            i4 = o4.hashCode();
        }
        if (o5 == null) {
            i5 = 0;
        } else {
            i5 = o5.hashCode();
        }
        if (o6 != null) {
            i6 = o6.hashCode();
        }
        return C5366b.m18369a(i, i2, i3, i4, i5, i6);
    }

    /* renamed from: a */
    public static int m18364a(int i1) {
        return i1 + 31;
    }

    /* renamed from: a */
    public static int m18365a(int i1, int i2) {
        return ((i1 + 31) * 31) + i2;
    }

    /* renamed from: a */
    public static int m18366a(int i1, int i2, int i3) {
        return ((((i1 + 31) * 31) + i2) * 31) + i3;
    }

    /* renamed from: a */
    public static int m18367a(int i1, int i2, int i3, int i4) {
        return ((((((i1 + 31) * 31) + i2) * 31) + i3) * 31) + i4;
    }

    /* renamed from: a */
    public static int m18368a(int i1, int i2, int i3, int i4, int i5) {
        return ((((((((i1 + 31) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5;
    }

    /* renamed from: a */
    public static int m18369a(int i1, int i2, int i3, int i4, int i5, int i6) {
        return ((((((((((i1 + 31) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6;
    }
}
