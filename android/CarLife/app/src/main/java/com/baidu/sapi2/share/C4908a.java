package com.baidu.sapi2.share;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.sapi2.C4891b;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SapiShareClient */
/* renamed from: com.baidu.sapi2.share.a */
public final class C4908a {
    /* renamed from: a */
    public static final int f20500a = 5;
    /* renamed from: b */
    static final String f20501b = "LOGIN_SHARE_MODEL";
    /* renamed from: c */
    static final String f20502c = "RELOGIN_CREDENTIALS";
    /* renamed from: d */
    static final String f20503d = "RUNTIME_ENVIRONMENT";
    /* renamed from: e */
    static final String f20504e = "baidu.intent.action.account.SHARE_SERVICE";
    /* renamed from: f */
    private static SapiConfiguration f20505f = SapiAccountManager.getInstance().getSapiConfiguration();
    /* renamed from: g */
    private static C4891b f20506g = C4891b.m16250a(f20505f.context);
    /* renamed from: h */
    private static final C4908a f20507h = new C4908a();

    /* renamed from: a */
    public static C4908a m16342a() {
        return f20507h;
    }

    private C4908a() {
    }

    /* renamed from: a */
    public void m16350a(SapiAccount account) {
        if (SapiUtils.isValidAccount(account)) {
            if (TextUtils.isEmpty(account.app)) {
                account.app = SapiUtils.getAppName(f20505f.context);
            }
            f20506g.m16265a(account);
            f20506g.m16275c(account);
            f20506g.m16279d(account);
            if (f20505f.loginShareStrategy() != LoginShareStrategy.DISABLED && !C4908a.m16346c()) {
                final HandlerThread handlerThread = new HandlerThread("ValidateThread");
                handlerThread.start();
                final Handler handler = new Handler(handlerThread.getLooper());
                final List<Intent> shareServices = C4912c.m16359a(f20505f.context);
                final SapiAccount sapiAccount = account;
                handler.post(new Runnable(this) {
                    /* renamed from: e */
                    final /* synthetic */ C4908a f20481e;

                    public void run() {
                        final C49011 binderTask = this;
                        if (!shareServices.isEmpty()) {
                            try {
                                C4908a.f20505f.context.bindService((Intent) shareServices.get(0), new ServiceConnection(this) {
                                    /* renamed from: b */
                                    final /* synthetic */ C49011 f20476b;

                                    public void onServiceConnected(ComponentName name, final IBinder service) {
                                        final C49001 connection = this;
                                        handler.post(new Runnable(this) {
                                            /* renamed from: c */
                                            final /* synthetic */ C49001 f20474c;

                                            public void run() {
                                                try {
                                                    service.transact(0, C4908a.m16341a(new ShareModel(ShareEvent.VALIDATE, sapiAccount, Collections.singletonList(sapiAccount))), Parcel.obtain(), 0);
                                                    try {
                                                        C4908a.f20505f.context.unbindService(connection);
                                                    } catch (Throwable e) {
                                                        C4913L.m16374e(e);
                                                    }
                                                } catch (Throwable e2) {
                                                    C4913L.m16374e(e2);
                                                }
                                                shareServices.remove(0);
                                                if (shareServices.isEmpty()) {
                                                    handlerThread.quit();
                                                } else {
                                                    handler.post(binderTask);
                                                }
                                            }
                                        });
                                    }

                                    public void onServiceDisconnected(ComponentName name) {
                                    }
                                }, 1);
                            } catch (Throwable e) {
                                C4913L.m16374e(e);
                            }
                        }
                    }
                });
            }
        }
    }

    /* renamed from: b */
    public void m16351b(SapiAccount currentAccount) {
        if (currentAccount != null && f20505f.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            f20506g.m16279d(currentAccount);
            if (!C4908a.m16346c()) {
                final HandlerThread handlerThread = new HandlerThread("InvalidateThread");
                handlerThread.start();
                final Handler handler = new Handler(handlerThread.getLooper());
                final List<Intent> shareServices = C4912c.m16359a(f20505f.context);
                final SapiAccount sapiAccount = currentAccount;
                handler.post(new Runnable(this) {
                    /* renamed from: e */
                    final /* synthetic */ C4908a f20491e;

                    public void run() {
                        final C49042 binderTask = this;
                        if (!shareServices.isEmpty()) {
                            try {
                                C4908a.f20505f.context.bindService((Intent) shareServices.get(0), new ServiceConnection(this) {
                                    /* renamed from: b */
                                    final /* synthetic */ C49042 f20486b;

                                    public void onServiceConnected(ComponentName name, final IBinder service) {
                                        final C49031 connection = this;
                                        handler.post(new Runnable(this) {
                                            /* renamed from: c */
                                            final /* synthetic */ C49031 f20484c;

                                            public void run() {
                                                try {
                                                    service.transact(0, C4908a.m16341a(new ShareModel(ShareEvent.INVALIDATE, null, Collections.singletonList(sapiAccount))), Parcel.obtain(), 0);
                                                    try {
                                                        C4908a.f20505f.context.unbindService(connection);
                                                    } catch (Throwable e) {
                                                        C4913L.m16374e(e);
                                                    }
                                                } catch (Throwable e2) {
                                                    C4913L.m16374e(e2);
                                                }
                                                shareServices.remove(0);
                                                if (shareServices.isEmpty()) {
                                                    handlerThread.quit();
                                                } else {
                                                    handler.post(binderTask);
                                                }
                                            }
                                        });
                                    }

                                    public void onServiceDisconnected(ComponentName name) {
                                    }
                                }, 1);
                            } catch (Throwable e) {
                                C4913L.m16374e(e);
                            }
                        }
                    }
                });
            }
        }
    }

    /* renamed from: b */
    public static void m16344b() {
        if (f20506g.m16285g()) {
            if (f20505f.loginShareStrategy() != LoginShareStrategy.DISABLED) {
                C4908a.m16349f();
            }
        } else if (!f20506g.m16286h() && f20505f.loginShareStrategy() == LoginShareStrategy.SILENT) {
            C4908a.m16349f();
        }
    }

    /* renamed from: f */
    private static void m16349f() {
        if (!C4908a.m16346c()) {
            final HandlerThread handlerThread = new HandlerThread("SyncThread");
            handlerThread.start();
            final Handler handler = new Handler(handlerThread.getLooper());
            final List<Intent> shareServices = C4912c.m16359a(f20505f.context);
            handler.post(new Runnable() {
                public void run() {
                    final C49073 binderTask = this;
                    if (!shareServices.isEmpty()) {
                        try {
                            C4908a.f20505f.context.bindService((Intent) shareServices.get(0), new ServiceConnection(this) {
                                /* renamed from: b */
                                final /* synthetic */ C49073 f20496b;

                                public void onServiceConnected(ComponentName name, final IBinder service) {
                                    final C49061 connection = this;
                                    handler.post(new Runnable(this) {
                                        /* renamed from: c */
                                        final /* synthetic */ C49061 f20494c;

                                        public void run() {
                                            try {
                                                Parcel data = C4908a.m16341a(new ShareModel(ShareEvent.SYNC_REQ));
                                                Parcel reply = Parcel.obtain();
                                                if (service.transact(0, data, reply, 0)) {
                                                    C4908a.m16345b(reply);
                                                }
                                                try {
                                                    C4908a.f20505f.context.unbindService(connection);
                                                } catch (Throwable e) {
                                                    C4913L.m16374e(e);
                                                }
                                            } catch (Throwable e2) {
                                                C4913L.m16374e(e2);
                                            }
                                            shareServices.remove(0);
                                            if (shareServices.isEmpty() || C4908a.f20506g.m16281e().size() >= 5) {
                                                handlerThread.quit();
                                            } else {
                                                handler.post(binderTask);
                                            }
                                        }
                                    });
                                }

                                public void onServiceDisconnected(ComponentName name) {
                                }
                            }, 1);
                        } catch (Throwable e) {
                            C4913L.m16374e(e);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: b */
    private static void m16345b(Parcel reply) {
        if (reply != null) {
            try {
                Bundle bundle = reply.readBundle(ShareModel.class.getClassLoader());
                ShareModel shareModel = (ShareModel) bundle.getParcelable(f20501b);
                C4912c.m16370c(f20505f.context, bundle.getString(f20502c));
                C4912c.m16361a(f20505f.context, f20505f.loginShareStrategy(), shareModel);
            } catch (Throwable e) {
                C4913L.m16374e(e);
            }
        }
    }

    /* renamed from: a */
    static Parcel m16341a(ShareModel shareModel) {
        Parcel data = Parcel.obtain();
        Bundle bundle = new Bundle();
        C4912c.m16367b(f20505f.context, f20505f.loginShareStrategy(), shareModel);
        bundle.putParcelable(f20501b, shareModel);
        if (f20506g.m16293o() != null) {
            bundle.putString(f20502c, C4909b.m16354a(f20505f.context, f20506g.m16293o().toString()));
        }
        bundle.putSerializable(f20503d, f20505f.environment);
        data.writeBundle(bundle);
        return data;
    }

    /* renamed from: c */
    static boolean m16346c() {
        List<String> blackList = new ArrayList();
        blackList.add("com.baidu.input_huawei");
        return blackList.contains(f20505f.context.getPackageName());
    }
}
