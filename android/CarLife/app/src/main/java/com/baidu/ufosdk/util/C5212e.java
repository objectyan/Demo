package com.baidu.ufosdk.util;

import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: BoundedLinkedList */
/* renamed from: com.baidu.ufosdk.util.e */
public final class C5212e extends LinkedList {
    /* renamed from: a */
    private final int f21698a = 2000;

    public final boolean add(Object obj) {
        if (size() == this.f21698a) {
            removeFirst();
        }
        return super.add(obj);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append(it.next().toString());
        }
        return stringBuilder.toString();
    }
}
