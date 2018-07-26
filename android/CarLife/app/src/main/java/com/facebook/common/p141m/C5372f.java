package com.facebook.common.p141m;

/* compiled from: TriState */
/* renamed from: com.facebook.common.m.f */
public enum C5372f {
    YES,
    NO,
    UNSET;

    /* renamed from: a */
    public boolean m18392a() {
        return this != UNSET;
    }

    /* renamed from: a */
    public static C5372f m18391a(boolean bool) {
        return bool ? YES : NO;
    }

    /* renamed from: a */
    public static C5372f m18390a(Boolean bool) {
        return bool != null ? C5372f.m18391a(bool.booleanValue()) : UNSET;
    }

    /* renamed from: b */
    public boolean m18393b() {
        switch (this) {
            case YES:
                return true;
            case NO:
                return false;
            case UNSET:
                throw new IllegalStateException("No boolean equivalent for UNSET");
            default:
                throw new IllegalStateException("Unrecognized TriState value: " + this);
        }
    }

    /* renamed from: b */
    public boolean m18394b(boolean defaultValue) {
        switch (this) {
            case YES:
                return true;
            case NO:
                return false;
            case UNSET:
                return defaultValue;
            default:
                throw new IllegalStateException("Unrecognized TriState value: " + this);
        }
    }

    /* renamed from: c */
    public Boolean m18395c() {
        switch (this) {
            case YES:
                return Boolean.TRUE;
            case NO:
                return Boolean.FALSE;
            case UNSET:
                return null;
            default:
                throw new IllegalStateException("Unrecognized TriState value: " + this);
        }
    }

    /* renamed from: d */
    public int m18396d() {
        switch (this) {
            case YES:
                return 1;
            case NO:
                return 2;
            default:
                return 3;
        }
    }

    /* renamed from: a */
    public static C5372f m18389a(int value) {
        switch (value) {
            case 1:
                return YES;
            case 2:
                return NO;
            default:
                return UNSET;
        }
    }
}
