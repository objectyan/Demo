package com.baidu.android.pushservice.p022i;

import java.util.concurrent.PriorityBlockingQueue;

/* renamed from: com.baidu.android.pushservice.i.b */
public class C0557b<E> extends PriorityBlockingQueue<E> {
    public boolean offer(E e) {
        boolean z = false;
        try {
            if (size() < 20) {
                z = super.offer(e);
            }
        } catch (Exception e2) {
        }
        return z;
    }
}
