package com.baidu.navisdk.comapi.base;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class MsgHandler extends Handler {
    private Set<Integer> mInterests = new HashSet();

    public abstract void careAbout();

    public MsgHandler(Looper looper) {
        super(looper);
        careAbout();
    }

    public MsgHandler() {
        careAbout();
    }

    public synchronized void observe(int msgID) {
        if (this.mInterests != null) {
            this.mInterests.add(Integer.valueOf(msgID));
        }
    }

    public synchronized void observe(Collection<Integer> msgIDs) {
        if (!(this.mInterests == null || msgIDs == null)) {
            this.mInterests.addAll(msgIDs);
        }
    }

    public synchronized void observe(int[] msgIDs) {
        if (!(this.mInterests == null || msgIDs == null)) {
            for (int msgID : msgIDs) {
                this.mInterests.add(Integer.valueOf(msgID));
            }
        }
    }

    public synchronized boolean ignore(int msgID) {
        boolean remove;
        if (this.mInterests != null) {
            remove = this.mInterests.remove(Integer.valueOf(msgID));
        } else {
            remove = false;
        }
        return remove;
    }

    public synchronized void ignore(Collection<Integer> msgIDs) {
        if (!(this.mInterests == null || msgIDs == null)) {
            this.mInterests.removeAll(msgIDs);
        }
    }

    public synchronized void ignore(Integer[] msgIDs) {
        if (!(this.mInterests == null || msgIDs == null)) {
            this.mInterests.removeAll(Arrays.asList(msgIDs));
        }
    }

    public synchronized boolean isObserved(int msgID) {
        boolean z;
        if (this.mInterests == null || !this.mInterests.contains(Integer.valueOf(msgID))) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    public Set<Integer> getInterests() {
        return this.mInterests;
    }
}
