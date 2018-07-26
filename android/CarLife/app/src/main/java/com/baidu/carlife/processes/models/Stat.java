package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.IOException;

public final class Stat extends ProcFile {
    public static final Creator<Stat> CREATOR = new C20351();
    /* renamed from: a */
    private final String[] f6572a;

    /* renamed from: com.baidu.carlife.processes.models.Stat$1 */
    static class C20351 implements Creator<Stat> {
        C20351() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m7814a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m7815a(i);
        }

        /* renamed from: a */
        public Stat m7814a(Parcel source) {
            return new Stat(source);
        }

        /* renamed from: a */
        public Stat[] m7815a(int size) {
            return new Stat[size];
        }
    }

    /* renamed from: a */
    public static Stat m7816a(int pid) throws IOException {
        return new Stat(String.format("/proc/%d/stat", new Object[]{Integer.valueOf(pid)}));
    }

    private Stat(String path) throws IOException {
        super(path);
        this.f6572a = this.b.split("\\s+");
    }

    private Stat(Parcel in) {
        super(in);
        this.f6572a = in.createStringArray();
    }

    /* renamed from: a */
    public int m7843a() {
        return Integer.parseInt(this.f6572a[0]);
    }

    /* renamed from: b */
    public String m7844b() {
        return this.f6572a[1].replace("(", "").replace(")", "");
    }

    /* renamed from: c */
    public char m7845c() {
        return this.f6572a[2].charAt(0);
    }

    /* renamed from: d */
    public int m7846d() {
        return Integer.parseInt(this.f6572a[3]);
    }

    /* renamed from: e */
    public int m7847e() {
        return Integer.parseInt(this.f6572a[4]);
    }

    /* renamed from: f */
    public int m7848f() {
        return Integer.parseInt(this.f6572a[5]);
    }

    /* renamed from: g */
    public int m7849g() {
        return Integer.parseInt(this.f6572a[6]);
    }

    /* renamed from: h */
    public int m7850h() {
        return Integer.parseInt(this.f6572a[7]);
    }

    /* renamed from: i */
    public int m7851i() {
        return Integer.parseInt(this.f6572a[8]);
    }

    /* renamed from: j */
    public long m7852j() {
        return Long.parseLong(this.f6572a[9]);
    }

    /* renamed from: k */
    public long m7853k() {
        return Long.parseLong(this.f6572a[10]);
    }

    /* renamed from: l */
    public long m7854l() {
        return Long.parseLong(this.f6572a[11]);
    }

    /* renamed from: m */
    public long m7855m() {
        return Long.parseLong(this.f6572a[12]);
    }

    /* renamed from: n */
    public long m7856n() {
        return Long.parseLong(this.f6572a[13]);
    }

    /* renamed from: o */
    public long m7857o() {
        return Long.parseLong(this.f6572a[14]);
    }

    /* renamed from: p */
    public long m7858p() {
        return Long.parseLong(this.f6572a[15]);
    }

    /* renamed from: q */
    public long m7859q() {
        return Long.parseLong(this.f6572a[16]);
    }

    /* renamed from: r */
    public long m7860r() {
        return Long.parseLong(this.f6572a[17]);
    }

    /* renamed from: s */
    public int m7861s() {
        return Integer.parseInt(this.f6572a[18]);
    }

    /* renamed from: t */
    public long m7862t() {
        return Long.parseLong(this.f6572a[19]);
    }

    /* renamed from: u */
    public long m7863u() {
        return Long.parseLong(this.f6572a[20]);
    }

    /* renamed from: v */
    public long m7864v() {
        return Long.parseLong(this.f6572a[21]);
    }

    /* renamed from: w */
    public long m7865w() {
        return Long.parseLong(this.f6572a[22]);
    }

    /* renamed from: x */
    public long m7866x() {
        return Long.parseLong(this.f6572a[23]);
    }

    /* renamed from: y */
    public long m7867y() {
        return Long.parseLong(this.f6572a[24]);
    }

    /* renamed from: z */
    public long m7868z() {
        return Long.parseLong(this.f6572a[25]);
    }

    /* renamed from: A */
    public long m7817A() {
        return Long.parseLong(this.f6572a[26]);
    }

    /* renamed from: B */
    public long m7818B() {
        return Long.parseLong(this.f6572a[27]);
    }

    /* renamed from: C */
    public long m7819C() {
        return Long.parseLong(this.f6572a[28]);
    }

    /* renamed from: D */
    public long m7820D() {
        return Long.parseLong(this.f6572a[29]);
    }

    /* renamed from: E */
    public long m7821E() {
        return Long.parseLong(this.f6572a[30]);
    }

    /* renamed from: F */
    public long m7822F() {
        return Long.parseLong(this.f6572a[31]);
    }

    /* renamed from: G */
    public long m7823G() {
        return Long.parseLong(this.f6572a[32]);
    }

    /* renamed from: H */
    public long m7824H() {
        return Long.parseLong(this.f6572a[33]);
    }

    /* renamed from: I */
    public long m7825I() {
        return Long.parseLong(this.f6572a[34]);
    }

    /* renamed from: J */
    public long m7826J() {
        return Long.parseLong(this.f6572a[35]);
    }

    /* renamed from: K */
    public long m7827K() {
        return Long.parseLong(this.f6572a[36]);
    }

    /* renamed from: L */
    public int m7828L() {
        return Integer.parseInt(this.f6572a[37]);
    }

    /* renamed from: M */
    public int m7829M() {
        return Integer.parseInt(this.f6572a[38]);
    }

    /* renamed from: N */
    public int m7830N() {
        return Integer.parseInt(this.f6572a[39]);
    }

    /* renamed from: O */
    public int m7831O() {
        return Integer.parseInt(this.f6572a[40]);
    }

    /* renamed from: P */
    public long m7832P() {
        return Long.parseLong(this.f6572a[41]);
    }

    /* renamed from: Q */
    public long m7833Q() {
        return Long.parseLong(this.f6572a[42]);
    }

    /* renamed from: R */
    public long m7834R() {
        return Long.parseLong(this.f6572a[43]);
    }

    /* renamed from: S */
    public long m7835S() {
        return Long.parseLong(this.f6572a[44]);
    }

    /* renamed from: T */
    public long m7836T() {
        return Long.parseLong(this.f6572a[45]);
    }

    /* renamed from: U */
    public long m7837U() {
        return Long.parseLong(this.f6572a[46]);
    }

    /* renamed from: V */
    public long m7838V() {
        return Long.parseLong(this.f6572a[47]);
    }

    /* renamed from: W */
    public long m7839W() {
        return Long.parseLong(this.f6572a[48]);
    }

    /* renamed from: X */
    public long m7840X() {
        return Long.parseLong(this.f6572a[49]);
    }

    /* renamed from: Y */
    public long m7841Y() {
        return Long.parseLong(this.f6572a[50]);
    }

    /* renamed from: Z */
    public int m7842Z() {
        return Integer.parseInt(this.f6572a[51]);
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeStringArray(this.f6572a);
    }
}
