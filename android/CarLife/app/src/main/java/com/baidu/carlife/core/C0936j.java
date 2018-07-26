package com.baidu.carlife.core;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: MsgBaseHandler */
/* renamed from: com.baidu.carlife.core.j */
public abstract class C0936j extends Handler implements C0689h {
    private ArrayList<Integer> mInterests = new ArrayList();

    public abstract void careAbout();

    public C0936j(Looper looper) {
        super(looper);
        careAbout();
    }

    public C0936j() {
        careAbout();
    }

    public void addMsg(int msgID) {
        Iterator it = this.mInterests.iterator();
        while (it.hasNext()) {
            if (((Integer) it.next()).intValue() == msgID) {
                return;
            }
        }
        this.mInterests.add(Integer.valueOf(msgID));
    }

    public void removeMsg(int msgID) {
        Iterator<Integer> it = this.mInterests.iterator();
        while (it.hasNext()) {
            if (((Integer) it.next()).intValue() == msgID) {
                it.remove();
            }
        }
    }

    public boolean isAdded(int msgID) {
        if (this.mInterests == null) {
            return false;
        }
        return this.mInterests.contains(Integer.valueOf(msgID));
    }
}
