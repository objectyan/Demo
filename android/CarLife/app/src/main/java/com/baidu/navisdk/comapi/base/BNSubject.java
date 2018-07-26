package com.baidu.navisdk.comapi.base;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;

public class BNSubject {
    private static final String TAG = "Common";
    protected BNObserver mObserver;
    protected final ArrayList<BNObserver> mObservers = new ArrayList();

    public void setObserver(BNObserver observer) {
        this.mObserver = observer;
        LogUtil.m15791e("BNSubject", "set " + observer);
    }

    public void addObserver(BNObserver observer) {
        if (observer == null) {
            LogUtil.m15791e("Common", "The BNObserver is null when addObserver");
            return;
        }
        synchronized (this.mObservers) {
            if (this.mObservers.contains(observer)) {
                LogUtil.m15791e("Common", "BNObserver " + observer + " is already added.");
                return;
            }
            this.mObservers.add(observer);
            LogUtil.m15791e("BNSubject", "add " + this.mObservers.size() + " " + observer);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void deleteObserver(com.baidu.navisdk.comapi.base.BNObserver r6) {
        /*
        r5 = this;
        if (r6 != 0) goto L_0x000c;
    L_0x0002:
        r1 = "Common";
        r2 = "The BNObserver is null.";
        com.baidu.navisdk.util.common.LogUtil.m15791e(r1, r2);
    L_0x000b:
        return;
    L_0x000c:
        r2 = r5.mObservers;
        monitor-enter(r2);
        r1 = r5.mObservers;	 Catch:{ all -> 0x003b }
        r0 = r1.indexOf(r6);	 Catch:{ all -> 0x003b }
        r1 = -1;
        if (r0 != r1) goto L_0x003e;
    L_0x0018:
        r1 = "Common";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003b }
        r3.<init>();	 Catch:{ all -> 0x003b }
        r4 = "BNObserver ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x003b }
        r3 = r3.append(r6);	 Catch:{ all -> 0x003b }
        r4 = " was not added.";
        r3 = r3.append(r4);	 Catch:{ all -> 0x003b }
        r3 = r3.toString();	 Catch:{ all -> 0x003b }
        com.baidu.navisdk.util.common.LogUtil.m15791e(r1, r3);	 Catch:{ all -> 0x003b }
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        goto L_0x000b;
    L_0x003b:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        throw r1;
    L_0x003e:
        r1 = "BNSubject";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003b }
        r3.<init>();	 Catch:{ all -> 0x003b }
        r4 = "delete ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x003b }
        r4 = r5.mObservers;	 Catch:{ all -> 0x003b }
        r4 = r4.size();	 Catch:{ all -> 0x003b }
        r3 = r3.append(r4);	 Catch:{ all -> 0x003b }
        r4 = " ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x003b }
        r3 = r3.append(r6);	 Catch:{ all -> 0x003b }
        r3 = r3.toString();	 Catch:{ all -> 0x003b }
        com.baidu.navisdk.util.common.LogUtil.m15791e(r1, r3);	 Catch:{ all -> 0x003b }
        r1 = r5.mObservers;	 Catch:{ all -> 0x003b }
        r1.remove(r0);	 Catch:{ all -> 0x003b }
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        r1 = r5.mObserver;
        if (r1 == 0) goto L_0x000b;
    L_0x0073:
        r1 = r5.mObserver;
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x000b;
    L_0x007b:
        r1 = "BNSubject";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "remove ";
        r2 = r2.append(r3);
        r2 = r2.append(r6);
        r2 = r2.toString();
        com.baidu.navisdk.util.common.LogUtil.m15791e(r1, r2);
        r1 = 0;
        r5.mObserver = r1;
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.comapi.base.BNSubject.deleteObserver(com.baidu.navisdk.comapi.base.BNObserver):void");
    }

    public void deleteAllObserver() {
        LogUtil.m15791e("BNSubject", "delete all");
        this.mObservers.clear();
    }

    public void notifyObservers(int type, int event, Object arg) {
        synchronized (this) {
            int i = this.mObservers.size() - 1;
            while (i >= 0 && this.mObservers.get(i) != null) {
                ((BNObserver) this.mObservers.get(i)).update(this, type, event, arg);
                i--;
            }
            if (this.mObserver != null) {
                this.mObserver.update(this, type, event, arg);
            }
        }
    }
}
