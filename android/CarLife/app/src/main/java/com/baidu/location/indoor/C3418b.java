package com.baidu.location.indoor;

import java.util.ArrayList;

/* renamed from: com.baidu.location.indoor.b */
public class C3418b<T> extends ArrayList<T> {
    /* renamed from: a */
    private int f18512a = 0;

    public C3418b(int i) {
        this.f18512a = i;
    }

    public boolean add(T t) {
        synchronized (this) {
            if (size() == this.f18512a) {
                remove(0);
            }
            add(size(), t);
        }
        return true;
    }

    public void clear() {
        synchronized (this) {
            if (size() <= 3) {
                return;
            }
            int size = size() / 2;
            while (true) {
                int i = size - 1;
                if (size > 0) {
                    remove(0);
                    size = i;
                } else {
                    return;
                }
            }
        }
    }
}
