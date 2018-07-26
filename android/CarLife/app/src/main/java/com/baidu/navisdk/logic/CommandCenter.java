package com.baidu.navisdk.logic;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CommandCenter {
    private static final String TAG = "CommandCenter";
    private HookCommandDispatcher mAppDispatcher;
    private CommandCenterListener mListener = new C41261();
    private RequestQueue mRequests = new RequestQueue("msgqueue");

    public interface CommandCenterListener {
        void onRequestFinish(ReqData reqData, CommandResult commandResult);
    }

    /* renamed from: com.baidu.navisdk.logic.CommandCenter$1 */
    class C41261 implements CommandCenterListener {
        C41261() {
        }

        public void onRequestFinish(ReqData reqdata, CommandResult ret) {
            Message msg;
            if (ret.isSuccess()) {
                if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                    msg = reqdata.mHandler.obtainMessage(reqdata.mHandlerMsgWhat);
                    msg.arg1 = 0;
                    msg.obj = new RspData(reqdata, null);
                    msg.sendToTarget();
                    reqdata.mHasMsgSent = true;
                }
            } else if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                msg = reqdata.mHandler.obtainMessage(reqdata.mHandlerMsgWhat);
                msg.arg1 = ret.mErrCode;
                msg.obj = new RspData(reqdata, null);
                msg.sendToTarget();
                reqdata.mHasMsgSent = true;
            }
            CommandCenter.this.mRequests.removeRequest(reqdata);
        }
    }

    private static class LazyHolder {
        private static final CommandCenter sInstance = new CommandCenter();

        private LazyHolder() {
        }
    }

    class RequestQueue extends HandlerThread {
        private Map<ReqData, Future<CommandResult>> mRequests = Collections.synchronizedMap(new HashMap());

        public RequestQueue(String name) {
            super(name);
            start();
        }

        public void addRequest(final ReqData reqdata) {
            LogUtil.m15791e(CommandCenter.TAG, "task added to request queue,reqdata=" + reqdata.toString());
            if (!(reqdata.mSubSystem == 5 || reqdata.mSubSystem == 4 || reqdata.mSubSystem == 7)) {
                cancelRequestInSubSystem(reqdata.mSubSystem);
            }
            BNWorkerCenter.getInstance().submitQueneTask(new BNWorkerNormalTask<String, String>(CommandCenter.class.getSimpleName() + "2", null) {
                protected String execute() {
                    Callable<CommandResult> task;
                    if (CommandCenter.this.mAppDispatcher != null) {
                        task = CommandCenter.newTask(reqdata, CommandCenter.this.mAppDispatcher);
                    } else {
                        task = CommandCenter.newTask(reqdata);
                    }
                    if (task != null) {
                        try {
                            RequestQueue.this.mRequests.put(reqdata, BNWorkerCenter.getInstance().submitTask(new BNWorkerNormalTask<Callable<CommandResult>, CommandResult>(CommandCenter.class.getSimpleName(), task) {
                                protected CommandResult execute() {
                                    try {
                                        return (CommandResult) ((Callable) this.inData).call();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        return null;
                                    }
                                }
                            }, new BNWorkerConfig(100, 0)));
                        } catch (Throwable th) {
                        }
                    }
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
            BNWorkerCenter.getInstance().submitQueneTaskDelay(new BNWorkerNormalTask<String, String>(CommandCenter.class.getSimpleName() + "3", null) {
                protected String execute() {
                    Message msg;
                    Future<CommandResult> future = (Future) RequestQueue.this.mRequests.remove(reqdata);
                    if (future != null) {
                        boolean result = future.cancel(true);
                        CommandResult ret = new CommandResult();
                        try {
                            ret = (CommandResult) future.get();
                            if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                                msg = reqdata.mHandler.obtainMessage(reqdata.mHandlerMsgWhat);
                                msg.arg1 = ret.mErrCode;
                                msg.obj = new RspData(reqdata, null);
                                msg.sendToTarget();
                                reqdata.mHasMsgSent = true;
                            }
                        } catch (InterruptedException e) {
                            LogUtil.m15791e(TAG, "task interrupted because timeout, reqdata=" + reqdata.toString());
                            ret.setSDKError(2);
                            if (LogUtil.LOGGABLE) {
                                e.printStackTrace();
                            }
                            if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                                msg = reqdata.mHandler.obtainMessage(reqdata.mHandlerMsgWhat);
                                msg.arg1 = ret.mErrCode;
                                msg.obj = new RspData(reqdata, null);
                                msg.sendToTarget();
                                reqdata.mHasMsgSent = true;
                            }
                        } catch (ExecutionException e2) {
                            LogUtil.m15791e(TAG, "task ExecutionException, reqdata=" + reqdata.toString());
                            ret.set(NaviErrCode.RET_BUG, "Exception:reqdata=" + reqdata.toString());
                            if (LogUtil.LOGGABLE) {
                                e2.printStackTrace();
                            }
                            if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                                msg = reqdata.mHandler.obtainMessage(reqdata.mHandlerMsgWhat);
                                msg.arg1 = ret.mErrCode;
                                msg.obj = new RspData(reqdata, null);
                                msg.sendToTarget();
                                reqdata.mHasMsgSent = true;
                            }
                        } catch (CancellationException e3) {
                            LogUtil.m15791e(TAG, "task cancelled because timeout,reqdata=" + reqdata.toString());
                            ret.setSDKError(2);
                            if (LogUtil.LOGGABLE) {
                                e3.printStackTrace();
                            }
                            if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                                msg = reqdata.mHandler.obtainMessage(reqdata.mHandlerMsgWhat);
                                msg.arg1 = ret.mErrCode;
                                msg.obj = new RspData(reqdata, null);
                                msg.sendToTarget();
                                reqdata.mHasMsgSent = true;
                            }
                        } catch (Exception e4) {
                            LogUtil.m15791e(TAG, "task Exception, reqdata=" + reqdata.toString());
                            ret.set(NaviErrCode.RET_BUG, "Exception:reqdata=" + reqdata.toString());
                            if (LogUtil.LOGGABLE) {
                                e4.printStackTrace();
                            }
                            if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                                msg = reqdata.mHandler.obtainMessage(reqdata.mHandlerMsgWhat);
                                msg.arg1 = ret.mErrCode;
                                msg.obj = new RspData(reqdata, null);
                                msg.sendToTarget();
                                reqdata.mHasMsgSent = true;
                            }
                        } catch (Throwable th) {
                            if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                                msg = reqdata.mHandler.obtainMessage(reqdata.mHandlerMsgWhat);
                                msg.arg1 = ret.mErrCode;
                                msg.obj = new RspData(reqdata, null);
                                msg.sendToTarget();
                                reqdata.mHasMsgSent = true;
                            }
                        }
                    }
                    return null;
                }
            }, new BNWorkerConfig(100, 0), (long) reqdata.mTimeout);
        }

        public void cancelRequest(final String tag) {
            BNWorkerCenter.getInstance().submitQueneTask(new BNWorkerNormalTask<String, String>(CommandCenter.class.getSimpleName() + "2", null) {
                protected String execute() {
                    Message msg;
                    Iterator<Entry<ReqData, Future<CommandResult>>> iter = RequestQueue.this.mRequests.entrySet().iterator();
                    while (iter.hasNext()) {
                        Entry<ReqData, Future<CommandResult>> entry = (Entry) iter.next();
                        Future<CommandResult> future = (Future) entry.getValue();
                        ReqData reqdata = (ReqData) entry.getKey();
                        if (!(reqdata.mTag == null || tag == null || !reqdata.mTag.contains(tag))) {
                            iter.remove();
                            boolean result = future.cancel(true);
                            CommandResult ret = new CommandResult();
                            try {
                                ret = (CommandResult) future.get();
                                if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null || reqdata == null || reqdata.mHandler == null)) {
                                    msg = reqdata.mHandler.obtainMessage(100000);
                                    msg.arg1 = ret.mErrCode;
                                    msg.obj = new RspData(reqdata, null);
                                    msg.sendToTarget();
                                    reqdata.mHasMsgSent = true;
                                }
                            } catch (InterruptedException e) {
                                LogUtil.m15791e(TAG, "task interrupted because cancel,reqdata=" + reqdata.toString());
                                ret.set(-3);
                                if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null || reqdata == null || reqdata.mHandler == null)) {
                                    msg = reqdata.mHandler.obtainMessage(100000);
                                    msg.arg1 = ret.mErrCode;
                                    msg.obj = new RspData(reqdata, null);
                                    msg.sendToTarget();
                                    reqdata.mHasMsgSent = true;
                                }
                            } catch (ExecutionException e2) {
                                LogUtil.m15791e(TAG, "task ExecutionException,reqdata=" + reqdata.toString());
                                ret.set(NaviErrCode.RET_BUG, "Exception:reqdata=" + reqdata.toString());
                                if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null || reqdata == null || reqdata.mHandler == null)) {
                                    msg = reqdata.mHandler.obtainMessage(100000);
                                    msg.arg1 = ret.mErrCode;
                                    msg.obj = new RspData(reqdata, null);
                                    msg.sendToTarget();
                                    reqdata.mHasMsgSent = true;
                                }
                            } catch (CancellationException e3) {
                                LogUtil.m15791e(TAG, "task cancelled because cancel,reqdata=" + reqdata.toString());
                                ret.set(-3);
                                if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null || reqdata == null || reqdata.mHandler == null)) {
                                    msg = reqdata.mHandler.obtainMessage(100000);
                                    msg.arg1 = ret.mErrCode;
                                    msg.obj = new RspData(reqdata, null);
                                    msg.sendToTarget();
                                    reqdata.mHasMsgSent = true;
                                }
                            } catch (Exception e4) {
                                LogUtil.m15791e(TAG, "task exception,reqdata=" + reqdata.toString());
                                ret.set(NaviErrCode.RET_BUG, "Exception:" + e4.toString());
                                if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null || reqdata == null || reqdata.mHandler == null)) {
                                    msg = reqdata.mHandler.obtainMessage(100000);
                                    msg.arg1 = ret.mErrCode;
                                    msg.obj = new RspData(reqdata, null);
                                    msg.sendToTarget();
                                    reqdata.mHasMsgSent = true;
                                }
                            } catch (Throwable th) {
                                if (!(reqdata == null || reqdata.mHasMsgSent || reqdata.mHandler == null || reqdata == null || reqdata.mHandler == null)) {
                                    msg = reqdata.mHandler.obtainMessage(100000);
                                    msg.arg1 = ret.mErrCode;
                                    msg.obj = new RspData(reqdata, null);
                                    msg.sendToTarget();
                                    reqdata.mHasMsgSent = true;
                                }
                            }
                        }
                    }
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }

        private void cancelRequestInSubSystem(final int subsystem) {
            BNWorkerCenter.getInstance().submitQueneTask(new BNWorkerNormalTask<String, String>(CommandCenter.class.getSimpleName() + "2", null) {
                protected String execute() {
                    Message msg;
                    Iterator<Entry<ReqData, Future<CommandResult>>> iter = RequestQueue.this.mRequests.entrySet().iterator();
                    while (iter.hasNext()) {
                        Entry<ReqData, Future<CommandResult>> entry = (Entry) iter.next();
                        Future<CommandResult> future = (Future) entry.getValue();
                        ReqData reqdata = (ReqData) entry.getKey();
                        if (reqdata.mSubSystem == subsystem) {
                            iter.remove();
                            boolean result = future.cancel(true);
                            CommandResult ret = new CommandResult();
                            try {
                                ret = (CommandResult) future.get();
                                if (!(reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                                    msg = reqdata.mHandler.obtainMessage(100000);
                                    msg.arg1 = ret.mErrCode;
                                    msg.obj = new RspData(reqdata, null);
                                    msg.sendToTarget();
                                    reqdata.mHasMsgSent = true;
                                }
                            } catch (InterruptedException e) {
                                LogUtil.m15791e(TAG, "task interrupted because cancel, reqdata=" + reqdata.toString());
                                ret.set(-3);
                                if (!(reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                                    msg = reqdata.mHandler.obtainMessage(100000);
                                    msg.arg1 = ret.mErrCode;
                                    msg.obj = new RspData(reqdata, null);
                                    msg.sendToTarget();
                                    reqdata.mHasMsgSent = true;
                                }
                            } catch (ExecutionException e2) {
                                LogUtil.m15791e(TAG, "task ExecutionException,reqdata=" + reqdata.toString());
                                ret.set(NaviErrCode.RET_BUG, "Exception:reqdata=" + reqdata.toString());
                                if (!(reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                                    msg = reqdata.mHandler.obtainMessage(100000);
                                    msg.arg1 = ret.mErrCode;
                                    msg.obj = new RspData(reqdata, null);
                                    msg.sendToTarget();
                                    reqdata.mHasMsgSent = true;
                                }
                            } catch (CancellationException e3) {
                                LogUtil.m15791e(TAG, "task cancelled because cancel, reqdata=" + reqdata.toString());
                                ret.set(-3);
                                if (!(reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                                    msg = reqdata.mHandler.obtainMessage(100000);
                                    msg.arg1 = ret.mErrCode;
                                    msg.obj = new RspData(reqdata, null);
                                    msg.sendToTarget();
                                    reqdata.mHasMsgSent = true;
                                }
                            } catch (Exception e4) {
                                LogUtil.m15791e(TAG, "task Exception,reqdata=" + reqdata.toString());
                                ret.set(NaviErrCode.RET_BUG, "Exception:" + e4.toString());
                                if (!(reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                                    msg = reqdata.mHandler.obtainMessage(100000);
                                    msg.arg1 = ret.mErrCode;
                                    msg.obj = new RspData(reqdata, null);
                                    msg.sendToTarget();
                                    reqdata.mHasMsgSent = true;
                                }
                            } catch (Throwable th) {
                                if (!(reqdata.mHasMsgSent || reqdata.mHandler == null)) {
                                    msg = reqdata.mHandler.obtainMessage(100000);
                                    msg.arg1 = ret.mErrCode;
                                    msg.obj = new RspData(reqdata, null);
                                    msg.sendToTarget();
                                    reqdata.mHasMsgSent = true;
                                }
                            }
                        }
                    }
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }

        public void removeRequest(final ReqData reqdata) {
            BNWorkerCenter.getInstance().submitQueneTask(new BNWorkerNormalTask<String, String>(CommandCenter.class.getSimpleName() + "2", null) {
                protected String execute() {
                    RequestQueue.this.mRequests.remove(reqdata);
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }
    }

    public static CommandCenter getInstance() {
        return LazyHolder.sInstance;
    }

    public void setCommandDispatcher(HookCommandDispatcher dispatcher) {
        this.mAppDispatcher = dispatcher;
    }

    public int sendRequest(ReqData reqdata) {
        reqdata.mRequestListener = this.mListener;
        this.mRequests.addRequest(reqdata);
        return 0;
    }

    public RspData getFromCache(ReqData reqdata) {
        CommandBase proto = CommandDispatcher.getCommandParser(reqdata.mCmd);
        if (proto == null) {
            return null;
        }
        return proto.getFromCache(reqdata);
    }

    public int cancelRequest(String tag) {
        this.mRequests.cancelRequest(tag);
        return 0;
    }

    public int cancelRequestBySubSystem(int subsystem) {
        this.mRequests.cancelRequestInSubSystem(subsystem);
        return 0;
    }

    public Looper getLooper() {
        return this.mRequests.getLooper();
    }

    public static CommandResult doTask(ReqData reqdata, String cmd) throws Exception {
        CommandResult ret = new CommandResult();
        CommandBase commandParser = CommandDispatcher.getCommandParser(cmd);
        if (commandParser != null) {
            return commandParser.execute(reqdata);
        }
        ret.set((int) NaviErrCode.RET_BUG);
        return ret;
    }

    public static CommandResult doTask(ReqData reqdata, String cmd, HookCommandDispatcher dispatcher) throws Exception {
        CommandResult ret = new CommandResult();
        CommandBase commandParser = dispatcher.getCommandParser(cmd);
        if (commandParser != null) {
            return commandParser.execute(reqdata);
        }
        ret.set((int) NaviErrCode.RET_BUG);
        return ret;
    }

    public static Callable<CommandResult> newTask(final ReqData reqdata) {
        return new Callable<CommandResult>() {
            public CommandResult call() throws Exception {
                CommandResult result = CommandCenter.doTask(reqdata, reqdata.mCmd);
                reqdata.mRequestListener.onRequestFinish(reqdata, result);
                return result;
            }
        };
    }

    public static Callable<CommandResult> newTask(final ReqData reqdata, final HookCommandDispatcher dispatcher) {
        return new Callable<CommandResult>() {
            public CommandResult call() throws Exception {
                CommandResult result = CommandCenter.doTask(reqdata, reqdata.mCmd, dispatcher);
                reqdata.mRequestListener.onRequestFinish(reqdata, result);
                return result;
            }
        };
    }
}
