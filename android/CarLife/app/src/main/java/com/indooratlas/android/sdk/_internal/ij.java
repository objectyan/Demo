package com.indooratlas.android.sdk._internal;

import com.baidu.carlife.core.C1253f;
import javax.security.auth.x500.X500Principal;

final class ij {
    /* renamed from: a */
    final String f24368a;
    /* renamed from: b */
    final int f24369b = this.f24368a.length();
    /* renamed from: c */
    int f24370c;
    /* renamed from: d */
    int f24371d;
    /* renamed from: e */
    int f24372e;
    /* renamed from: f */
    int f24373f;
    /* renamed from: g */
    char[] f24374g;

    public ij(X500Principal x500Principal) {
        this.f24368a = x500Principal.getName("RFC2253");
    }

    /* renamed from: a */
    final String m21118a() {
        while (this.f24370c < this.f24369b && this.f24374g[this.f24370c] == ' ') {
            this.f24370c++;
        }
        if (this.f24370c == this.f24369b) {
            return null;
        }
        this.f24371d = this.f24370c;
        this.f24370c++;
        while (this.f24370c < this.f24369b && this.f24374g[this.f24370c] != '=' && this.f24374g[this.f24370c] != ' ') {
            this.f24370c++;
        }
        if (this.f24370c >= this.f24369b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f24368a);
        }
        this.f24372e = this.f24370c;
        if (this.f24374g[this.f24370c] == ' ') {
            while (this.f24370c < this.f24369b && this.f24374g[this.f24370c] != '=' && this.f24374g[this.f24370c] == ' ') {
                this.f24370c++;
            }
            if (this.f24374g[this.f24370c] != '=' || this.f24370c == this.f24369b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f24368a);
            }
        }
        do {
            this.f24370c++;
            if (this.f24370c >= this.f24369b) {
                break;
            }
        } while (this.f24374g[this.f24370c] == ' ');
        if (this.f24372e - this.f24371d > 4 && this.f24374g[this.f24371d + 3] == '.' && ((this.f24374g[this.f24371d] == 'O' || this.f24374g[this.f24371d] == 'o') && ((this.f24374g[this.f24371d + 1] == 'I' || this.f24374g[this.f24371d + 1] == 'i') && (this.f24374g[this.f24371d + 2] == 'D' || this.f24374g[this.f24371d + 2] == 'd')))) {
            this.f24371d += 4;
        }
        return new String(this.f24374g, this.f24371d, this.f24372e - this.f24371d);
    }

    /* renamed from: b */
    final String m21119b() {
        if (this.f24370c + 4 >= this.f24369b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f24368a);
        }
        int i;
        this.f24371d = this.f24370c;
        this.f24370c++;
        while (this.f24370c != this.f24369b && this.f24374g[this.f24370c] != '+' && this.f24374g[this.f24370c] != ',' && this.f24374g[this.f24370c] != ';') {
            int i2;
            if (this.f24374g[this.f24370c] == ' ') {
                this.f24372e = this.f24370c;
                this.f24370c++;
                while (this.f24370c < this.f24369b && this.f24374g[this.f24370c] == ' ') {
                    this.f24370c++;
                }
                i = this.f24372e - this.f24371d;
                if (i >= 5 || (i & 1) == 0) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f24368a);
                }
                byte[] bArr = new byte[(i / 2)];
                int i3 = this.f24371d + 1;
                for (i2 = 0; i2 < bArr.length; i2++) {
                    bArr[i2] = (byte) m21116a(i3);
                    i3 += 2;
                }
                return new String(this.f24374g, this.f24371d, i);
            }
            if (this.f24374g[this.f24370c] >= 'A' && this.f24374g[this.f24370c] <= 'F') {
                char[] cArr = this.f24374g;
                i2 = this.f24370c;
                cArr[i2] = (char) (cArr[i2] + 32);
            }
            this.f24370c++;
        }
        this.f24372e = this.f24370c;
        i = this.f24372e - this.f24371d;
        if (i >= 5) {
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f24368a);
    }

    /* renamed from: c */
    final String m21120c() {
        this.f24371d = this.f24370c;
        this.f24372e = this.f24370c;
        while (this.f24370c < this.f24369b) {
            char[] cArr;
            int i;
            switch (this.f24374g[this.f24370c]) {
                case ' ':
                    this.f24373f = this.f24372e;
                    this.f24370c++;
                    cArr = this.f24374g;
                    i = this.f24372e;
                    this.f24372e = i + 1;
                    cArr[i] = ' ';
                    while (this.f24370c < this.f24369b && this.f24374g[this.f24370c] == ' ') {
                        cArr = this.f24374g;
                        i = this.f24372e;
                        this.f24372e = i + 1;
                        cArr[i] = ' ';
                        this.f24370c++;
                    }
                    if (this.f24370c != this.f24369b && this.f24374g[this.f24370c] != ',' && this.f24374g[this.f24370c] != '+' && this.f24374g[this.f24370c] != ';') {
                        break;
                    }
                    return new String(this.f24374g, this.f24371d, this.f24373f - this.f24371d);
                    break;
                case '+':
                case ',':
                case ';':
                    return new String(this.f24374g, this.f24371d, this.f24372e - this.f24371d);
                case '\\':
                    cArr = this.f24374g;
                    i = this.f24372e;
                    this.f24372e = i + 1;
                    cArr[i] = m21121d();
                    this.f24370c++;
                    break;
                default:
                    cArr = this.f24374g;
                    i = this.f24372e;
                    this.f24372e = i + 1;
                    cArr[i] = this.f24374g[this.f24370c];
                    this.f24370c++;
                    break;
            }
        }
        return new String(this.f24374g, this.f24371d, this.f24372e - this.f24371d);
    }

    /* renamed from: d */
    final char m21121d() {
        this.f24370c++;
        if (this.f24370c == this.f24369b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f24368a);
        }
        switch (this.f24374g[this.f24370c]) {
            case ' ':
            case '\"':
            case '#':
            case '%':
            case '*':
            case '+':
            case ',':
            case ';':
            case '<':
            case '=':
            case '>':
            case '\\':
            case '_':
                return this.f24374g[this.f24370c];
            default:
                return m21117e();
        }
    }

    /* renamed from: e */
    private char m21117e() {
        int a = m21116a(this.f24370c);
        this.f24370c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > C1253f.dP) {
            return '?';
        }
        int i;
        if (a <= 223) {
            i = 1;
            a &= 31;
        } else if (a <= 239) {
            i = 2;
            a &= 15;
        } else {
            i = 3;
            a &= 7;
        }
        int i2 = a;
        for (a = 0; a < i; a++) {
            this.f24370c++;
            if (this.f24370c == this.f24369b || this.f24374g[this.f24370c] != '\\') {
                return '?';
            }
            this.f24370c++;
            int a2 = m21116a(this.f24370c);
            this.f24370c++;
            if ((a2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a2 & 63);
        }
        return (char) i2;
    }

    /* renamed from: a */
    private int m21116a(int i) {
        if (i + 1 >= this.f24369b) {
            throw new IllegalStateException("Malformed DN: " + this.f24368a);
        }
        int i2;
        int i3;
        char c = this.f24374g[i];
        if (c >= '0' && c <= '9') {
            i2 = c - 48;
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 87;
        } else if (c < 'A' || c > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f24368a);
        } else {
            i2 = c - 55;
        }
        char c2 = this.f24374g[i + 1];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - 48;
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 87;
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f24368a);
        } else {
            i3 = c2 - 55;
        }
        return (i2 << 4) + i3;
    }
}
