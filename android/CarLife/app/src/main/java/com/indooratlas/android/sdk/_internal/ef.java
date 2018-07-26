package com.indooratlas.android.sdk._internal;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class ef<K, V> extends LinkedHashMap<K, V> {
    /* renamed from: a */
    private int f23514a = 500;

    public ef() {
        super(500);
    }

    protected final boolean removeEldestEntry(Entry<K, V> entry) {
        return size() > this.f23514a;
    }
}
