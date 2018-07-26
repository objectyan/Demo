package com.baidu.platform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import java.util.ArrayList;
import java.util.List;

public class MessageProxy {
    /* renamed from: a */
    private static final SparseArray<List<MainLooperHandler>> f19999a = new SparseArray();

    public static void registerMessageHandler(int msgId, MainLooperHandler handler) {
        if (handler != null) {
            synchronized (f19999a) {
                List<MainLooperHandler> handlers = (List) f19999a.get(msgId);
                if (handlers == null) {
                    handlers = new ArrayList();
                    handlers.add(handler);
                    f19999a.put(msgId, handlers);
                } else if (!handlers.contains(handler)) {
                    handlers.add(handler);
                }
            }
        }
    }

    public static void unRegisterMessageHandler(int msgId, MainLooperHandler handler) {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            synchronized (f19999a) {
                List<MainLooperHandler> handlers = (List) f19999a.get(msgId);
                if (handlers != null) {
                    handlers.remove(handler);
                }
            }
        }
    }

    public static void dispatchMessage(int what, int arg1, int arg2, int target) {
        synchronized (f19999a) {
            List<MainLooperHandler> outboxHandlers = (List) f19999a.get(what);
            if (!(outboxHandlers == null || outboxHandlers.isEmpty())) {
                for (Handler handler : outboxHandlers) {
                    Message.obtain(handler, what, arg1, arg2, Integer.valueOf(target)).sendToTarget();
                }
            }
        }
    }

    public static void destroy() {
        int size = f19999a.size();
        for (int i = 0; i < size; i++) {
            List<MainLooperHandler> outboxHandlers = (List) f19999a.get(f19999a.keyAt(i));
            if (outboxHandlers != null) {
                outboxHandlers.clear();
            }
        }
        f19999a.clear();
    }
}
