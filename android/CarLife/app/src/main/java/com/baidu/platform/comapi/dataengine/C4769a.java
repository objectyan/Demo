package com.baidu.platform.comapi.dataengine;

import android.os.Message;
import com.baidu.platform.comapi.UIMsg.m_AppUI;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MapDataEngineNotifier */
/* renamed from: com.baidu.platform.comapi.dataengine.a */
class C4769a {
    /* renamed from: a */
    private CopyOnWriteArrayList<MapDataEngineListener> f19805a = new CopyOnWriteArrayList();

    C4769a() {
    }

    /* renamed from: a */
    void m15844a(MapDataEngineListener listener) {
        if (listener != null) {
            this.f19805a.add(listener);
        }
    }

    /* renamed from: b */
    void m15845b(MapDataEngineListener listener) {
        this.f19805a.remove(listener);
    }

    /* renamed from: a */
    public void m15843a(Message msg) {
        if (msg.what == m_AppUI.V_WM_VDATAENGINE && this.f19805a != null && this.f19805a.size() != 0) {
            switch (msg.arg1) {
                case 61:
                case 62:
                case 66:
                case 69:
                case 70:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                    Iterator it = this.f19805a.iterator();
                    while (it.hasNext()) {
                        ((MapDataEngineListener) it.next()).onGetDataEngineRst(msg.arg1, msg.arg2);
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
