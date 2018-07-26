package com.indooratlas.android.sdk._internal;

public abstract class gu implements Runnable {
    /* renamed from: b */
    protected final String f23938b;

    /* renamed from: b */
    public abstract void mo4692b();

    public gu(String str, Object... objArr) {
        this.f23938b = String.format(str, objArr);
    }

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f23938b);
        try {
            mo4692b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
