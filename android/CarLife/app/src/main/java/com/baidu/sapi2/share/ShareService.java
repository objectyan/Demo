package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.sapi2.C4891b;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.Collections;
import java.util.List;

public final class ShareService extends Service {
    /* renamed from: a */
    private static Context f20467a;
    /* renamed from: b */
    private static LoginShareStrategy f20468b;
    /* renamed from: c */
    private static C4891b f20469c;
    /* renamed from: d */
    private static boolean f20470d = false;
    /* renamed from: e */
    private Handler f20471e;

    /* renamed from: com.baidu.sapi2.share.ShareService$a */
    private class C4898a extends Binder {
        /* renamed from: a */
        final /* synthetic */ ShareService f20466a;

        /* renamed from: com.baidu.sapi2.share.ShareService$a$1 */
        class C48971 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C4898a f20465a;

            C48971(C4898a c4898a) {
                this.f20465a = c4898a;
            }

            public void run() {
                if (SapiAccountManager.getReceiveShareListener() != null) {
                    SapiAccountManager.getReceiveShareListener().onReceiveShare();
                }
            }
        }

        private C4898a(ShareService shareService) {
            this.f20466a = shareService;
        }

        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (!C4912c.m16368b(this.f20466a)) {
                return false;
            }
            if (SapiAccountManager.getReceiveShareListener() != null) {
                if (this.f20466a.f20471e == null) {
                    this.f20466a.f20471e = new Handler(Looper.getMainLooper());
                }
                this.f20466a.f20471e.post(new C48971(this));
            }
            if (!ShareService.f20470d) {
                this.f20466a.m16339a(this.f20466a);
            }
            if (!ShareService.f20470d || ShareService.f20468b == LoginShareStrategy.DISABLED) {
                return true;
            }
            try {
                Bundle bundle = data.readBundle(ShareModel.class.getClassLoader());
                ShareModel shareModel = (ShareModel) bundle.getParcelable("LOGIN_SHARE_MODEL");
                if (shareModel == null) {
                    return true;
                }
                if (bundle.getSerializable("RUNTIME_ENVIRONMENT") != null && (bundle.getSerializable("RUNTIME_ENVIRONMENT") instanceof Domain) && ((Domain) bundle.getSerializable("RUNTIME_ENVIRONMENT")) != SapiAccountManager.getInstance().getSapiConfiguration().environment) {
                    return true;
                }
                C4912c.m16370c(ShareService.f20467a, bundle.getString("RELOGIN_CREDENTIALS"));
                switch (shareModel.m16331b()) {
                    case VALIDATE:
                        C4912c.m16361a(ShareService.f20467a, ShareService.f20468b, shareModel);
                        return true;
                    case INVALIDATE:
                        C4912c.m16360a(ShareService.f20467a, shareModel);
                        return true;
                    case SYNC_REQ:
                        this.f20466a.m16340a(reply);
                        return true;
                    default:
                        return true;
                }
                C4913L.m16374e(e);
                return true;
            } catch (Throwable e) {
                C4913L.m16374e(e);
                return true;
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        this.f20471e = new Handler(Looper.getMainLooper());
    }

    public IBinder onBind(Intent intent) {
        return new C4898a();
    }

    @TargetApi(5)
    public int onStartCommand(Intent intent, int flags, int startId) {
        stopSelf();
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        stopSelf();
        return super.onUnbind(intent);
    }

    /* renamed from: a */
    void m16339a(Context ctx) {
        try {
            f20467a = ctx;
            f20469c = C4891b.m16250a(ctx);
            f20468b = SapiAccountManager.getInstance().getSapiConfiguration().loginShareStrategy();
            f20470d = true;
        } catch (IllegalStateException e) {
            f20470d = false;
        }
    }

    /* renamed from: a */
    void m16340a(Parcel replay) {
        Bundle bundle = new Bundle();
        ShareModel model = new ShareModel(ShareEvent.SYNC_ACK);
        SapiAccount currentAccount = f20469c.m16278d();
        model.m16326a(currentAccount);
        List<SapiAccount> loginAccounts = f20469c.m16284f();
        if (currentAccount != null) {
            currentAccount.app = SapiUtils.getAppName(f20467a);
            if (loginAccounts.size() > 0 && loginAccounts.contains(currentAccount)) {
                loginAccounts.set(loginAccounts.indexOf(currentAccount), loginAccounts.get(0));
                loginAccounts.set(0, currentAccount);
            }
        } else {
            Collections.reverse(loginAccounts);
        }
        model.m16324a().addAll(loginAccounts);
        model.m16324a().addAll(f20469c.m16281e());
        for (SapiAccount account : model.m16324a()) {
            account.app = SapiUtils.getAppName(f20467a);
        }
        C4912c.m16367b(f20467a, f20468b, model);
        bundle.putParcelable("LOGIN_SHARE_MODEL", model);
        if (f20469c.m16293o() != null) {
            bundle.putString("RELOGIN_CREDENTIALS", C4909b.m16354a(f20467a, f20469c.m16293o().toString()));
        }
        bundle.putSerializable("RUNTIME_ENVIRONMENT", SapiAccountManager.getInstance().getSapiConfiguration().environment);
        replay.writeBundle(bundle);
    }
}
