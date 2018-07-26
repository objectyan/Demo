package com.baidu.sapi2;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.UUID;

class SapiWebView$FastRegAction {
    /* renamed from: b */
    private static final int f20121b = 0;
    /* renamed from: c */
    private static final int f20122c = 1;
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20123a;
    /* renamed from: d */
    private String f20124d;
    /* renamed from: e */
    private boolean f20125e = true;
    /* renamed from: f */
    private boolean f20126f = false;
    /* renamed from: g */
    private Handler f20127g;
    /* renamed from: h */
    private Runnable f20128h;
    /* renamed from: i */
    private Handler f20129i;
    /* renamed from: j */
    private int f20130j = 0;
    /* renamed from: k */
    private Handler f20131k;
    /* renamed from: l */
    private Runnable f20132l;

    /* renamed from: com.baidu.sapi2.SapiWebView$FastRegAction$5 */
    class C48685 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ SapiWebView$FastRegAction f20115a;

        C48685(SapiWebView$FastRegAction sapiWebView$FastRegAction) {
            this.f20115a = sapiWebView$FastRegAction;
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            this.f20115a.f20123a.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + "#sms_login");
        }
    }

    /* renamed from: com.baidu.sapi2.SapiWebView$FastRegAction$6 */
    class C48696 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ SapiWebView$FastRegAction f20116a;

        C48696(SapiWebView$FastRegAction sapiWebView$FastRegAction) {
            this.f20116a = sapiWebView$FastRegAction;
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            boolean sendSuccess = false;
            if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", this.f20116a.f20123a.getContext())) {
                sendSuccess = SapiUtils.sendSms(this.f20116a.f20123a.getContext(), this.f20116a.f20124d, SapiUtils.getFastRegChannel(this.f20116a.f20123a.getContext()));
            }
            if (sendSuccess) {
                this.f20116a.f20127g.postDelayed(this.f20116a.f20128h, 15000);
                this.f20116a.f20125e = false;
                this.f20116a.m16112d();
                return;
            }
            this.f20116a.m16114e();
        }
    }

    /* renamed from: com.baidu.sapi2.SapiWebView$FastRegAction$7 */
    class C48717 implements SapiCallBack<SapiAccountResponse> {
        /* renamed from: a */
        final /* synthetic */ SapiWebView$FastRegAction f20118a;

        /* renamed from: com.baidu.sapi2.SapiWebView$FastRegAction$7$1 */
        class C48701 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C48717 f20117a;

            C48701(C48717 c48717) {
                this.f20117a = c48717;
            }

            public void run() {
                this.f20117a.f20118a.m16112d();
            }
        }

        C48717(SapiWebView$FastRegAction sapiWebView$FastRegAction) {
            this.f20118a = sapiWebView$FastRegAction;
        }

        public void onSuccess(SapiAccountResponse response) {
            if (response.newReg) {
                SapiWebView.c(this.f20118a.f20123a, response);
            } else {
                SapiWebView.a(this.f20118a.f20123a, response);
            }
            this.f20118a.m16110c();
        }

        public void onNetworkFailed() {
            this.f20118a.m16114e();
            this.f20118a.m16110c();
        }

        public void onSystemError(int errorCode) {
            switch (errorCode) {
                case 2:
                    this.f20118a.f20123a.postDelayed(new C48701(this), 400);
                    return;
                default:
                    this.f20118a.m16114e();
                    this.f20118a.m16110c();
                    return;
            }
        }
    }

    /* renamed from: com.baidu.sapi2.SapiWebView$FastRegAction$8 */
    class C48728 implements SapiCallBack<SapiResponse> {
        /* renamed from: a */
        final /* synthetic */ SapiWebView$FastRegAction f20119a;

        C48728(SapiWebView$FastRegAction sapiWebView$FastRegAction) {
            this.f20119a = sapiWebView$FastRegAction;
        }

        public void onSuccess(SapiResponse response) {
            SapiWebView.a(this.f20119a.f20123a, this.f20119a.f20129i);
            this.f20119a.f20131k.postDelayed(this.f20119a.f20132l, 15000);
        }

        public void onNetworkFailed() {
            this.f20119a.f20123a.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + "#sms_login");
        }

        public void onSystemError(int errorCode) {
            this.f20119a.f20123a.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + "#sms_login");
        }
    }

    /* renamed from: com.baidu.sapi2.SapiWebView$FastRegAction$9 */
    class C48739 implements SapiCallBack<SapiAccountResponse> {
        /* renamed from: a */
        final /* synthetic */ SapiWebView$FastRegAction f20120a;

        C48739(SapiWebView$FastRegAction sapiWebView$FastRegAction) {
            this.f20120a = sapiWebView$FastRegAction;
        }

        public void onSuccess(SapiAccountResponse response) {
            SapiAccountResponse fastRegResponse = new SapiAccountResponse();
            fastRegResponse.displayname = response.displayname;
            fastRegResponse.username = response.username;
            fastRegResponse.uid = response.uid;
            fastRegResponse.bduss = response.bduss;
            fastRegResponse.ptoken = response.ptoken;
            fastRegResponse.stoken = response.stoken;
            fastRegResponse.email = response.email;
            fastRegResponse.newReg = !TextUtils.isEmpty(response.authSid);
            fastRegResponse.authSid = response.authSid;
            if (fastRegResponse.newReg) {
                SapiWebView.c(this.f20120a.f20123a, fastRegResponse);
                return;
            }
            SapiWebView.a(this.f20120a.f20123a, fastRegResponse);
            this.f20120a.f20123a.finish();
        }

        public void onNetworkFailed() {
            this.f20120a.m16103a(SapiWebView.u(this.f20120a.f20123a));
        }

        public void onSystemError(int errorCode) {
            this.f20120a.m16103a(SapiWebView.u(this.f20120a.f20123a));
        }
    }

    public SapiWebView$FastRegAction(final SapiWebView sapiWebView) {
        this.f20123a = sapiWebView;
        this.f20127g = new Handler(this) {
            /* renamed from: b */
            final /* synthetic */ SapiWebView$FastRegAction f20108b;

            public void handleMessage(Message msg) {
                this.f20108b.f20125e = true;
            }
        };
        this.f20128h = new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ SapiWebView$FastRegAction f20110b;

            public void run() {
                this.f20110b.f20127g.sendMessage(new Message());
            }
        };
        this.f20129i = new Handler(this) {
            /* renamed from: b */
            final /* synthetic */ SapiWebView$FastRegAction f20112b;

            public void handleMessage(Message msg) {
                if (msg.obj != null) {
                    String code = msg.obj;
                    String phoneNum = SapiWebView.u(this.f20112b.f20123a);
                    if (!TextUtils.isEmpty(phoneNum) && this.f20112b.f20130j == 1) {
                        this.f20112b.m16104a(phoneNum, code);
                    }
                    SapiWebView.n(this.f20112b.f20123a);
                    this.f20112b.f20131k.removeCallbacks(this.f20112b.f20132l);
                }
            }
        };
        this.f20131k = new Handler();
        this.f20132l = new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ SapiWebView$FastRegAction f20114b;

            public void run() {
                SapiWebView.n(this.f20114b.f20123a);
                this.f20114b.m16103a(SapiWebView.u(this.f20114b.f20123a));
            }
        };
    }

    /* renamed from: a */
    private String m16099a() {
        return UUID.randomUUID().toString() + "-" + System.currentTimeMillis() + "," + "点击发送直接登录";
    }

    /* renamed from: b */
    private void m16107b() {
        if (this.f20125e) {
            this.f20124d = m16099a();
        }
        if (!SapiUtils.isSimReady(this.f20123a.getContext())) {
            m16114e();
        } else if (!SapiUtils.hasActiveNetwork(this.f20123a.getContext())) {
            m16114e();
        } else if (SapiWebView.d(this.f20123a).fastRegConfirm) {
            AlertDialog dialog = new Builder(this.f20123a.getContext()).setTitle("提示").setMessage("发送一条短信，即可完成注册。").setPositiveButton("确定", new C48696(this)).setNegativeButton("取消", new C48685(this)).create();
            if (!TextUtils.isEmpty(SapiWebView.d(this.f20123a).fastRegConfirmMsg)) {
                dialog.setMessage(SapiWebView.d(this.f20123a).fastRegConfirmMsg);
            }
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } else {
            boolean sendSuccess = false;
            if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", this.f20123a.getContext())) {
                sendSuccess = SapiUtils.sendSms(this.f20123a.getContext(), this.f20124d, SapiUtils.getFastRegChannel(this.f20123a.getContext()));
            }
            if (sendSuccess) {
                this.f20127g.postDelayed(this.f20128h, 15000);
                this.f20125e = false;
                m16112d();
                return;
            }
            m16114e();
        }
    }

    /* renamed from: c */
    private void m16110c() {
        this.f20127g.removeCallbacks(this.f20128h);
        this.f20125e = true;
    }

    /* renamed from: d */
    private void m16112d() {
        if (this.f20126f) {
            m16110c();
        } else if (this.f20125e) {
            this.f20127g.removeCallbacks(this.f20128h);
            m16114e();
        } else {
            SapiAccountManager.getInstance().getAccountService().a(new C48717(this), this.f20124d);
        }
    }

    /* renamed from: e */
    private void m16114e() {
        String phoneNum = SapiWebView.u(this.f20123a);
        if (TextUtils.isEmpty(phoneNum)) {
            this.f20123a.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + "#sms_login");
            return;
        }
        this.f20130j = 1;
        SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new C48728(this), phoneNum);
    }

    /* renamed from: a */
    private void m16104a(String phone, String password) {
        SapiAccountManager.getInstance().getAccountService().a(new C48739(this), phone, password);
    }

    /* renamed from: a */
    private void m16103a(String phoneNum) {
        this.f20123a.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&username=" + phoneNum + "#fastRegVerify");
    }
}
