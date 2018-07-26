package com.baidu.navisdk.vi;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.model.VMsgDataCache;
import com.baidu.navisdk.model.modelfactory.OfflineDataMergeMsgModel;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VMsgDispatcher {
    private static final String TAG = VMsgDispatcher.class.getSimpleName();
    public static final int VM_USER_ID = 4096;
    private static Map<Integer, Set<Handler>> sFirtPriorityMsgMap = new HashMap();
    private static Map<Integer, Set<Handler>> sMsgHandlersMap = new HashMap();

    public static class PRIORITY {
        public static final int HIGH = 0;
        public static final int NORMAL = 1;
    }

    public static void registerMsgHandler(MsgHandler handler) {
        if (handler != null) {
            registerMsgHandler((Handler) handler, handler.getInterests());
        }
    }

    public static void registerMsgHandler(Handler handler, Collection<Integer> observedMsgs) {
        if (handler != null && observedMsgs != null) {
            for (Integer msgId : observedMsgs) {
                if (msgId != null) {
                    synchronized (sMsgHandlersMap) {
                        Set<Handler> handlers = (Set) sMsgHandlersMap.get(msgId);
                        if (handlers != null) {
                            handlers.add(handler);
                        } else {
                            handlers = new HashSet();
                            handlers.add(handler);
                            sMsgHandlersMap.put(msgId, handlers);
                        }
                    }
                }
            }
        }
    }

    public static void unregisterMsgHandler(MsgHandler handler) {
        if (handler != null) {
            unregisterMsgHandler(handler, handler.getInterests());
        }
    }

    public static void unregisterMsgHandler(Handler handler, Collection<Integer> observedMsgs) {
        if (handler != null && observedMsgs != null) {
            for (Integer msgId : observedMsgs) {
                if (msgId != null) {
                    Set<Handler> handlers;
                    synchronized (sMsgHandlersMap) {
                        handlers = (Set) sMsgHandlersMap.get(msgId);
                        if (handlers != null) {
                            handlers.remove(handler);
                            if (handlers.isEmpty()) {
                                sMsgHandlersMap.remove(msgId);
                            }
                        }
                    }
                    synchronized (sFirtPriorityMsgMap) {
                        handlers = (Set) sFirtPriorityMsgMap.get(msgId);
                        if (handlers != null) {
                            handlers.remove(handler);
                            if (handlers.isEmpty()) {
                                sFirtPriorityMsgMap.remove(msgId);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void unregisterAll() {
        synchronized (sMsgHandlersMap) {
            sMsgHandlersMap.clear();
        }
        synchronized (sFirtPriorityMsgMap) {
            sFirtPriorityMsgMap.clear();
        }
    }

    public static void dispatchMessage(int what, int arg1, int arg2) {
        if (what > 4096) {
            Set<Handler> handlers;
            if (4099 == what && PerformStatItem.sUserTest) {
                PerformStatisticsController.peByType(0, "sdk_routeguide_dispatch_msg_rp_result", System.currentTimeMillis());
            }
            Bundle data = VMsgDataCache.update(what);
            synchronized (sFirtPriorityMsgMap) {
                handlers = (Set) sFirtPriorityMsgMap.get(Integer.valueOf(what));
                if (handlers != null) {
                    for (Handler handler : handlers) {
                        if (handler != null) {
                            try {
                                handler.sendMessage(handler.obtainMessage(what, arg1, arg2, data));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            synchronized (sMsgHandlersMap) {
                handlers = (Set) sMsgHandlersMap.get(Integer.valueOf(what));
                if (handlers != null) {
                    for (Handler handler2 : handlers) {
                        if (handler2 != null) {
                            try {
                                handler2.sendMessage(handler2.obtainMessage(what, arg1, arg2, data));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
            if ((what == MsgDefine.MSG_NAVI_DOWNLOAD_MERGE_START || what == MsgDefine.MSG_NAVI_DOWNLOAD_MERGE_WAIT || what == MsgDefine.MSG_NAVI_DOWNLOAD_MERGE_FAIL || what == MsgDefine.MSG_NAVI_DOWNLOAD_MERGE_SUCCESS) && OfflineDataMergeMsgModel.getInstance().getIsMergeNeedCache()) {
                BNOfflineDataManager.initMergeMessageCache(what, arg1);
            }
        }
    }

    private static void postMessage(int nMsgID, int nArg1, int nArg2) {
        dispatchMessage(nMsgID, nArg1, nArg2);
    }

    public static void dumpList() {
        synchronized (sMsgHandlersMap) {
            for (Integer msgId : sMsgHandlersMap.keySet()) {
                Set<Handler> handlers = (Set) sMsgHandlersMap.get(msgId);
                if (handlers != null) {
                    LogUtil.m15791e(TAG, "### MsgID " + msgId + ",  handlers count=" + handlers.size());
                    for (Handler handler : handlers) {
                        LogUtil.m15791e(TAG, "handler class name: " + handler.getClass().getSimpleName());
                    }
                }
            }
        }
    }

    public static void registerMsgHandler(MsgHandler handler, int priority) {
        if (handler == null) {
            return;
        }
        if (priority == 0) {
            registerMsgHandlerHighPriority(handler, handler.getInterests());
        } else {
            registerMsgHandler((Handler) handler, handler.getInterests());
        }
    }

    public static void registerMsgHandlerHighPriority(Handler handler, Collection<Integer> observedMsgs) {
        if (handler != null && observedMsgs != null) {
            for (Integer msgId : observedMsgs) {
                if (msgId != null) {
                    synchronized (sFirtPriorityMsgMap) {
                        Set<Handler> handlers = (Set) sFirtPriorityMsgMap.get(msgId);
                        if (handlers != null) {
                            handlers.add(handler);
                        } else {
                            handlers = new HashSet();
                            handlers.add(handler);
                            sFirtPriorityMsgMap.put(msgId, handlers);
                        }
                    }
                }
            }
        }
    }
}
