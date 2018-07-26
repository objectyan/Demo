package com.indooratlas.android.sdk._internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class iq implements Serializable, Comparable<iq> {
    /* renamed from: a */
    static final char[] f24393a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /* renamed from: b */
    public static final iq f24394b = m21227a(new byte[0]);
    private static final long serialVersionUID = 1;
    /* renamed from: c */
    public final byte[] f24395c;
    /* renamed from: d */
    transient int f24396d;
    /* renamed from: e */
    transient String f24397e;

    public /* synthetic */ int compareTo(Object obj) {
        iq iqVar = (iq) obj;
        int length = this.f24395c.length;
        int length2 = iqVar.f24395c.length;
        int min = Math.min(length, length2);
        int i = 0;
        while (i < min) {
            int i2 = this.f24395c[i] & 255;
            int i3 = iqVar.f24395c[i] & 255;
            if (i2 == i3) {
                i++;
            } else if (i2 < i3) {
                return -1;
            } else {
                return 1;
            }
        }
        if (length == length2) {
            return 0;
        }
        return length >= length2 ? 1 : -1;
    }

    iq(byte[] bArr) {
        this.f24395c = bArr;
    }

    /* renamed from: a */
    public static iq m21227a(byte... bArr) {
        if (bArr != null) {
            return new iq((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: a */
    public static iq m21226a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        iq iqVar = new iq(str.getBytes(jf.f24438a));
        iqVar.f24397e = str;
        return iqVar;
    }

    /* renamed from: a */
    public final String m21229a() {
        String str = this.f24397e;
        if (str != null) {
            return str;
        }
        str = new String(this.f24395c, jf.f24438a);
        this.f24397e = str;
        return str;
    }

    /* renamed from: b */
    private iq m21228b(String str) {
        try {
            return m21227a(MessageDigest.getInstance(str).digest(this.f24395c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b */
    public final String m21230b() {
        int i = 0;
        char[] cArr = new char[(this.f24395c.length * 2)];
        byte[] bArr = this.f24395c;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = f24393a[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = f24393a[b & 15];
            i++;
        }
        return new String(cArr);
    }

    /* renamed from: c */
    public final iq m21231c() {
        int i = 0;
        while (i < this.f24395c.length) {
            byte b = this.f24395c[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.f24395c.clone();
                int i2 = i + 1;
                bArr[i] = (byte) (b + 32);
                for (i = i2; i < bArr.length; i++) {
                    byte b2 = bArr[i];
                    if (b2 >= (byte) 65 && b2 <= (byte) 90) {
                        bArr[i] = (byte) (b2 + 32);
                    }
                }
                return new iq(bArr);
            }
        }
        return this;
    }

    /* renamed from: d */
    public final byte[] m21232d() {
        return (byte[]) this.f24395c.clone();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o instanceof iq) && ((iq) o).f24395c.length == this.f24395c.length) {
            Object obj;
            iq iqVar = (iq) o;
            byte[] bArr = this.f24395c;
            int length = this.f24395c.length;
            if (iqVar.f24395c.length - length < 0 || bArr.length - length < 0 || !jf.m21316a(iqVar.f24395c, bArr, length)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.f24396d;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.f24395c);
        this.f24396d = i;
        return i;
    }

    public String toString() {
        if (this.f24395c.length == 0) {
            return "ByteString[size=0]";
        }
        if (this.f24395c.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", new Object[]{Integer.valueOf(this.f24395c.length), m21230b()});
        }
        return String.format("ByteString[size=%s md5=%s]", new Object[]{Integer.valueOf(this.f24395c.length), m21228b("MD5").m21230b()});
    }

    private void readObject(ObjectInputStream in) throws IOException {
        int readInt = in.readInt();
        if (in == null) {
            throw new IllegalArgumentException("in == null");
        } else if (readInt < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + readInt);
        } else {
            byte[] bArr = new byte[readInt];
            int i = 0;
            while (i < readInt) {
                int read = in.read(bArr, i, readInt - i);
                if (read == -1) {
                    throw new EOFException();
                }
                i += read;
            }
            iq iqVar = new iq(bArr);
            try {
                Field declaredField = iq.class.getDeclaredField("c");
                declaredField.setAccessible(true);
                declaredField.set(this, iqVar.f24395c);
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            } catch (IllegalAccessException e2) {
                throw new AssertionError();
            }
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.f24395c.length);
        out.write(this.f24395c);
    }
}
