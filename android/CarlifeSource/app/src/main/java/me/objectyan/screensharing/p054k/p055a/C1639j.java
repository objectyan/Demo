package com.baidu.carlife.p054k.p055a;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/* compiled from: NetWorkDownloaddHelper */
/* renamed from: com.baidu.carlife.k.a.j */
public class C1639j {
    /* renamed from: a */
    public static final String f5047a = C1639j.class.getSimpleName();
    /* renamed from: b */
    public static final int f5048b = 3;
    /* renamed from: c */
    public static C1639j f5049c;
    /* renamed from: d */
    private static Queue<C1638i> f5050d = new LinkedList();
    /* renamed from: e */
    private static Queue<C1638i> f5051e = new PriorityBlockingQueue();

    /* renamed from: a */
    public static C1639j m5944a() {
        if (f5049c == null) {
            f5049c = new C1639j();
        }
        return f5049c;
    }

    /* renamed from: a */
    public synchronized void m5945a(C1638i task) {
        if (f5050d.size() >= 3) {
            f5051e.add(task);
        } else if (!task.m5939d()) {
            f5050d.add(task);
            task.start();
        }
    }

    /* renamed from: b */
    public synchronized void m5946b(C1638i task) {
        if (f5050d.contains(task)) {
            f5050d.remove(task);
        }
        if (f5051e.contains(task)) {
            f5051e.remove(task);
        }
        if (f5051e.size() > 0 && f5050d.size() < 3) {
            C1638i waitingTask = (C1638i) f5051e.poll();
            if (!waitingTask.m5939d()) {
                f5050d.add(waitingTask);
                waitingTask.start();
            }
        }
    }
}
