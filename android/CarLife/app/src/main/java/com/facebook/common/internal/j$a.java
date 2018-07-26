package com.facebook.common.internal;

import javax.annotation.Nullable;

/* compiled from: Objects */
public final class j$a {
    /* renamed from: a */
    private final String f21922a;
    /* renamed from: b */
    private C5349a f21923b;
    /* renamed from: c */
    private C5349a f21924c;
    /* renamed from: d */
    private boolean f21925d;

    /* compiled from: Objects */
    /* renamed from: com.facebook.common.internal.j$a$a */
    private static final class C5349a {
        /* renamed from: a */
        String f21919a;
        /* renamed from: b */
        Object f21920b;
        /* renamed from: c */
        C5349a f21921c;

        private C5349a() {
        }
    }

    private j$a(String className) {
        this.f21923b = new C5349a();
        this.f21924c = this.f21923b;
        this.f21925d = false;
        this.f21922a = (String) C5350k.m18310a((Object) className);
    }

    /* renamed from: a */
    public j$a m18293a() {
        this.f21925d = true;
        return this;
    }

    /* renamed from: a */
    public j$a m18305a(String name, @Nullable Object value) {
        return m18292b(name, value);
    }

    /* renamed from: a */
    public j$a m18306a(String name, boolean value) {
        return m18292b(name, String.valueOf(value));
    }

    /* renamed from: a */
    public j$a m18300a(String name, char value) {
        return m18292b(name, String.valueOf(value));
    }

    /* renamed from: a */
    public j$a m18301a(String name, double value) {
        return m18292b(name, String.valueOf(value));
    }

    /* renamed from: a */
    public j$a m18302a(String name, float value) {
        return m18292b(name, String.valueOf(value));
    }

    /* renamed from: a */
    public j$a m18303a(String name, int value) {
        return m18292b(name, String.valueOf(value));
    }

    /* renamed from: a */
    public j$a m18304a(String name, long value) {
        return m18292b(name, String.valueOf(value));
    }

    /* renamed from: a */
    public j$a m18299a(@Nullable Object value) {
        return m18291b(value);
    }

    /* renamed from: a */
    public j$a m18307a(boolean value) {
        return m18291b(String.valueOf(value));
    }

    /* renamed from: a */
    public j$a m18294a(char value) {
        return m18291b(String.valueOf(value));
    }

    /* renamed from: a */
    public j$a m18295a(double value) {
        return m18291b(String.valueOf(value));
    }

    /* renamed from: a */
    public j$a m18296a(float value) {
        return m18291b(String.valueOf(value));
    }

    /* renamed from: a */
    public j$a m18297a(int value) {
        return m18291b(String.valueOf(value));
    }

    /* renamed from: a */
    public j$a m18298a(long value) {
        return m18291b(String.valueOf(value));
    }

    public String toString() {
        boolean omitNullValuesSnapshot = this.f21925d;
        String nextSeparator = "";
        StringBuilder builder = new StringBuilder(32).append(this.f21922a).append('{');
        C5349a valueHolder = this.f21923b.f21921c;
        while (valueHolder != null) {
            if (!omitNullValuesSnapshot || valueHolder.f21920b != null) {
                builder.append(nextSeparator);
                nextSeparator = ", ";
                if (valueHolder.f21919a != null) {
                    builder.append(valueHolder.f21919a).append('=');
                }
                builder.append(valueHolder.f21920b);
            }
            valueHolder = valueHolder.f21921c;
        }
        return builder.append('}').toString();
    }

    /* renamed from: b */
    private C5349a m18290b() {
        C5349a valueHolder = new C5349a();
        this.f21924c.f21921c = valueHolder;
        this.f21924c = valueHolder;
        return valueHolder;
    }

    /* renamed from: b */
    private j$a m18291b(@Nullable Object value) {
        m18290b().f21920b = value;
        return this;
    }

    /* renamed from: b */
    private j$a m18292b(String name, @Nullable Object value) {
        C5349a valueHolder = m18290b();
        valueHolder.f21920b = value;
        valueHolder.f21919a = (String) C5350k.m18310a((Object) name);
        return this;
    }
}
