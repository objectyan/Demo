package com.baidu.carlife.p100n;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.TaskStackBuilder;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.connect.C1212c;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.fragment.HomeMoreFragment.C1508b;
import com.baidu.carlife.model.C1923c;
import com.baidu.carlife.n.e.AnonymousClass11;
import com.baidu.carlife.p054k.C1661t;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.carlife.p054k.p055a.C1635h;
import com.baidu.carlife.p054k.p055a.C1635h.C1489c;
import com.baidu.carlife.p054k.p055a.C1635h.C1633a;
import com.baidu.carlife.p054k.p055a.C1635h.C1634b;
import com.baidu.carlife.p100n.C1952b.C1947a;
import com.baidu.carlife.p100n.C1952b.C1949c;
import com.baidu.carlife.p100n.C1952b.C1950d;
import com.baidu.carlife.p100n.C1977e;
import com.baidu.carlife.p100n.C1977e.11.C19631;
import com.baidu.carlife.protobuf.CarLifeUpdateSuccessProtos.CarLifeUpdateSuccess;
import com.baidu.carlife.protobuf.CarlifeSystemInfoProtos.CarlifeSystemInfo;
import com.baidu.carlife.service.NotificationDownloadService;
import com.baidu.carlife.service.NotificationDownloadService.C2165a;
import com.baidu.carlife.util.C2176g;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.dialog.C2329u;
import com.baidu.navisdk.ui.util.DialogReplaceToastUtils;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: VehicleUpdateManager */
/* renamed from: com.baidu.carlife.n.e */
public class C1977e {
    /* renamed from: A */
    private static final String f6291A = "newVehhicleVersionName";
    /* renamed from: B */
    private static final String f6292B = "hasDownVehhicleVersionName";
    /* renamed from: d */
    private static final String f6293d = "VehicleDownloadManager";
    /* renamed from: C */
    private C1974b f6294C = null;
    /* renamed from: D */
    private int f6295D = -1;
    /* renamed from: E */
    private int f6296E = -1;
    /* renamed from: F */
    private boolean f6297F = false;
    /* renamed from: G */
    private boolean f6298G = false;
    /* renamed from: H */
    private C1508b f6299H;
    /* renamed from: I */
    private C1489c f6300I = new C1489c(this) {
        /* renamed from: a */
        final /* synthetic */ C1977e f6274a;

        /* compiled from: VehicleUpdateManager */
        /* renamed from: com.baidu.carlife.n.e$11$1 */
        class C19631 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ AnonymousClass11 f6273a;

            C19631(AnonymousClass11 this$1) {
                this.f6273a = this$1;
            }

            public void run() {
                C1260i.m4435b(C1977e.f6293d, "StartCheckMD5");
                if (this.f6273a.f6274a.m7532o() == 1) {
                    C1260i.m4435b(C1977e.f6293d, "checkApkMD5 success");
                    this.f6273a.f6274a.f6294C.sendEmptyMessage(3);
                    return;
                }
                C1260i.m4435b(C1977e.f6293d, "checkApkMD5 Fail");
                this.f6273a.f6274a.f6294C.sendEmptyMessage(4);
            }
        }

        {
            this.f6274a = this$0;
        }

        /* renamed from: a */
        public void mo1561a(C1634b state, C1633a errorCode) {
            switch (state) {
                case SUCESS:
                    m7487b();
                    return;
                case ERROR:
                    m7486a();
                    return;
                case CANCEL:
                    m7488c();
                    return;
                default:
                    return;
            }
        }

        /* renamed from: a */
        public void mo1560a(long total, int progress) {
            try {
                if (this.f6274a.f6322u) {
                    this.f6274a.f6321t.m8210a(progress);
                } else if (this.f6274a.f6319r != null) {
                    this.f6274a.f6319r.setProgress(progress);
                    this.f6274a.f6319r.setPercent(progress);
                    this.f6274a.f6319r.setHasFinished((int) ((((((long) progress) * total) / 100) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID), (int) ((total / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        /* renamed from: a */
        private void m7486a() {
            C1260i.m4435b(C1977e.f6293d, "Download Error!");
            this.f6274a.f6326y = null;
            this.f6274a.m7548w();
            this.f6274a.m7556b(1004);
        }

        /* renamed from: b */
        private void m7487b() {
            C1260i.m4435b(C1977e.f6293d, "after DownLoadSuccess");
            this.f6274a.f6326y = this.f6274a.f6325x.m5922b();
            new Thread(new C19631(this)).start();
        }

        /* renamed from: c */
        private void m7488c() {
            C1260i.m4435b(C1977e.f6293d, "afterDownloadCancel");
            this.f6274a.m7548w();
        }
    };
    /* renamed from: J */
    private ServiceConnection f6301J = new ServiceConnection(this) {
        /* renamed from: a */
        final /* synthetic */ C1977e f6275a;

        {
            this.f6275a = this$0;
        }

        public void onServiceConnected(ComponentName className, IBinder service) {
            this.f6275a.f6321t = ((C2165a) service).m8208a();
            this.f6275a.f6321t.m8211a(this.f6275a.f6315n);
            this.f6275a.f6321t.m8210a(0);
        }

        public void onServiceDisconnected(ComponentName arg0) {
            C1260i.m4435b(C1977e.f6293d, "app update onServiceDisconnected");
            if (this.f6275a.f6321t != null) {
                this.f6275a.f6321t.m8209a();
            }
        }
    };
    /* renamed from: K */
    private C1947a f6302K = new C1947a(this) {
        /* renamed from: a */
        final /* synthetic */ C1977e f6276a;

        {
            this.f6276a = this$0;
        }

        /* renamed from: a */
        public void mo1725a(C1950d state, C1949c errorCode) {
            switch (state) {
                case SUCESS:
                    m7491a();
                    return;
                case ERROR:
                    m7492b();
                    return;
                case CANCEL:
                    m7493c();
                    return;
                default:
                    return;
            }
        }

        /* renamed from: a */
        public void mo1724a(long total, int progress) {
            try {
                if (this.f6276a.f6322u) {
                    this.f6276a.f6321t.m8210a(progress);
                } else if (this.f6276a.f6319r != null) {
                    this.f6276a.f6319r.setProgress(progress);
                    this.f6276a.f6319r.setPercent(progress);
                    this.f6276a.f6319r.setHasFinished((int) ((((((long) progress) * total) / 100) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID), (int) ((total / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        /* renamed from: a */
        private void m7491a() {
            C1260i.m4435b(C1977e.f6293d, "OnTranfer Success");
            this.f6276a.f6317p = 4097;
            this.f6276a.f6316o.dismissDialog();
            if (this.f6276a.f6321t != null) {
                this.f6276a.f6321t.m8209a();
            }
        }

        /* renamed from: b */
        private void m7492b() {
            C1260i.m4435b(C1977e.f6293d, "OnTranfer Error");
            this.f6276a.f6317p = 4097;
            this.f6276a.f6316o.dismissDialog(this.f6276a.f6319r);
            if (this.f6276a.f6321t != null) {
                this.f6276a.f6321t.m8209a();
            }
            this.f6276a.m7556b(1006);
        }

        /* renamed from: c */
        private void m7493c() {
            C1260i.m4435b(C1977e.f6293d, "OnTranfer Cancel");
            this.f6276a.f6317p = 4097;
            this.f6276a.f6316o.dismissDialog();
            if (this.f6276a.f6321t != null) {
                this.f6276a.f6321t.m8209a();
            }
        }
    };
    /* renamed from: a */
    C0672b f6303a = new C19652(this);
    /* renamed from: b */
    C0672b f6304b = new C19663(this);
    /* renamed from: c */
    C0690d f6305c = new C19674(this);
    /* renamed from: e */
    private final int f6306e = 8194;
    /* renamed from: f */
    private final int f6307f = 1;
    /* renamed from: g */
    private final int f6308g = 2;
    /* renamed from: h */
    private final int f6309h = 3;
    /* renamed from: i */
    private final int f6310i = 4;
    /* renamed from: j */
    private final int f6311j = 11;
    /* renamed from: k */
    private final int f6312k = 4097;
    /* renamed from: l */
    private final int f6313l = 4098;
    /* renamed from: m */
    private final int f6314m = 5;
    /* renamed from: n */
    private Activity f6315n = null;
    /* renamed from: o */
    private C1277e f6316o;
    /* renamed from: p */
    private volatile int f6317p = 4097;
    /* renamed from: q */
    private SharedPreferences f6318q = null;
    /* renamed from: r */
    private C2329u f6319r = null;
    /* renamed from: s */
    private C1954c f6320s = null;
    /* renamed from: t */
    private NotificationDownloadService f6321t = null;
    /* renamed from: u */
    private boolean f6322u;
    /* renamed from: v */
    private C1661t f6323v;
    /* renamed from: w */
    private C1923c f6324w;
    /* renamed from: x */
    private C1635h f6325x;
    /* renamed from: y */
    private File f6326y;
    /* renamed from: z */
    private String f6327z = "0";

    /* compiled from: VehicleUpdateManager */
    /* renamed from: com.baidu.carlife.n.e$1 */
    class C19641 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ C1977e f6277a;

        C19641(C1977e this$0) {
            this.f6277a = this$0;
        }

        public void onClick() {
            this.f6277a.f6323v.cancel();
        }
    }

    /* compiled from: VehicleUpdateManager */
    /* renamed from: com.baidu.carlife.n.e$2 */
    class C19652 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ C1977e f6278a;

        C19652(C1977e this$0) {
            this.f6278a = this$0;
        }

        public void onClick() {
            C1260i.m4435b(C1977e.f6293d, "####### OnDialogFirstBtnClick: " + this.f6278a.f6320s.getDialogType());
            switch (this.f6278a.f6320s.getDialogType()) {
                case 1001:
                    C1260i.m4435b(C1977e.f6293d, "####### DLG_NO_NEED_UPDATE click");
                    this.f6278a.m7556b(1001);
                    return;
                case 1002:
                    C1260i.m4435b(C1977e.f6293d, "####### DLG_CHECK_USE_MOBILE_NET_DWON click");
                    this.f6278a.m7522j();
                    return;
                case 1003:
                    C1260i.m4435b(C1977e.f6293d, "####### DLG_CHECK_DOWN_LOAD");
                    this.f6278a.m7522j();
                    return;
                case 1005:
                    C1260i.m4435b(C1977e.f6293d, "####### DLG_CHECK_TRANSFER_NOW");
                    this.f6278a.m7534p();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: VehicleUpdateManager */
    /* renamed from: com.baidu.carlife.n.e$3 */
    class C19663 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ C1977e f6279a;

        C19663(C1977e this$0) {
            this.f6279a = this$0;
        }

        public void onClick() {
            C1260i.m4435b(C1977e.f6293d, "####### OnDialogSecondBtnClick: " + this.f6279a.f6320s.getDialogType());
            switch (this.f6279a.f6320s.getDialogType()) {
                case 1001:
                    C1260i.m4435b(C1977e.f6293d, "####### DLG_NO_NEED_UPDATE second");
                    return;
                case 1002:
                    C1260i.m4435b(C1977e.f6293d, "####### DLG_CHECK_USE_WIFI_DWON second");
                    return;
                case 1005:
                    C1260i.m4435b(C1977e.f6293d, "####### DLG_CHECK_TRANSFER_NOW second");
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: VehicleUpdateManager */
    /* renamed from: com.baidu.carlife.n.e$4 */
    class C19674 implements C0690d {
        /* renamed from: a */
        final /* synthetic */ C1977e f6280a;

        C19674(C1977e this$0) {
            this.f6280a = this$0;
        }

        public void onCancel() {
            C1260i.m4435b(C1977e.f6293d, "####### OnDialogCancelBtnClick: " + this.f6280a.f6320s.getDialogType());
            switch (this.f6280a.f6320s.getDialogType()) {
                case 1001:
                    C1260i.m4435b(C1977e.f6293d, "####### DLG_NO_NEED_UPDATE cancel");
                    return;
                case 1002:
                    C1260i.m4435b(C1977e.f6293d, "####### DLG_CHECK_USE_WIFI_DWON cancel");
                    return;
                case 1005:
                    C1260i.m4435b(C1977e.f6293d, "####### DLG_CHECK_TRANSFER_NOW cancel");
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: VehicleUpdateManager */
    /* renamed from: com.baidu.carlife.n.e$6 */
    class C19696 implements C0690d {
        /* renamed from: a */
        final /* synthetic */ C1977e f6283a;

        C19696(C1977e this$0) {
            this.f6283a = this$0;
        }

        public void onCancel() {
            this.f6283a.m7531n();
        }
    }

    /* compiled from: VehicleUpdateManager */
    /* renamed from: com.baidu.carlife.n.e$7 */
    class C19707 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ C1977e f6284a;

        C19707(C1977e this$0) {
            this.f6284a = this$0;
        }

        public void onClick() {
            this.f6284a.m7531n();
        }
    }

    /* compiled from: VehicleUpdateManager */
    /* renamed from: com.baidu.carlife.n.e$8 */
    class C19718 implements C0690d {
        /* renamed from: a */
        final /* synthetic */ C1977e f6285a;

        C19718(C1977e this$0) {
            this.f6285a = this$0;
        }

        public void onCancel() {
            this.f6285a.m7531n();
        }
    }

    /* compiled from: VehicleUpdateManager */
    /* renamed from: com.baidu.carlife.n.e$9 */
    class C19729 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ C1977e f6286a;

        C19729(C1977e this$0) {
            this.f6286a = this$0;
        }

        public void onClick() {
            this.f6286a.m7531n();
        }
    }

    /* compiled from: VehicleUpdateManager */
    /* renamed from: com.baidu.carlife.n.e$a */
    private class C1973a implements C0924a {
        /* renamed from: a */
        final /* synthetic */ C1977e f6287a;

        private C1973a(C1977e c1977e) {
            this.f6287a = c1977e;
        }

        public void onNetWorkResponse(int responseCode) {
            C1260i.m4435b(C1977e.f6293d, "onNetWorkResponse: " + responseCode);
            C1307e.m4686a().mo1468c();
            switch (responseCode) {
                case -2:
                    C2201w.m8371a((int) C0965R.string.carlife_update_no_network, 0);
                    return;
                case 0:
                    this.f6287a.f6324w = this.f6287a.f6323v.m5976a();
                    C1260i.m4435b(C1977e.f6293d, "RESPONSE_SUCCESS: " + this.f6287a.f6324w.toString());
                    if (this.f6287a.f6324w.f5945g == 1) {
                        this.f6287a.f6297F = true;
                        this.f6287a.m7521i();
                        this.f6287a.m7550a(this.f6287a.f6324w.f5948j);
                        this.f6287a.m7560e();
                        return;
                    }
                    this.f6287a.f6297F = false;
                    this.f6287a.m7521i();
                    this.f6287a.m7556b(1001);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: VehicleUpdateManager */
    /* renamed from: com.baidu.carlife.n.e$b */
    private class C1974b extends C0936j {
        /* renamed from: a */
        final /* synthetic */ C1977e f6288a;

        public C1974b(C1977e c1977e, Looper looper) {
            this.f6288a = c1977e;
            super(looper);
        }

        public C1974b(C1977e c1977e) {
            this.f6288a = c1977e;
        }

        public void careAbout() {
            addMsg(C1253f.bO);
            addMsg(C1253f.bS);
            addMsg(C1253f.bT);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    C1260i.m4435b(C1977e.f6293d, "MD5 Success!");
                    this.f6288a.f6317p = 4097;
                    C1307e.m4686a().mo1468c();
                    this.f6288a.m7556b(1005);
                    return;
                case 2:
                    C1260i.m4435b(C1977e.f6293d, "MD5 Error!");
                    C1307e.m4686a().mo1468c();
                    this.f6288a.m7544u();
                    return;
                case 3:
                    C1260i.m4435b(C1977e.f6293d, "MD5 Success!  AfterDownload");
                    this.f6288a.m7519h();
                    return;
                case 4:
                    this.f6288a.m7516g();
                    return;
                case 5:
                    if (this.f6288a.f6299H != null) {
                        this.f6288a.f6299H.mo1573a();
                        return;
                    }
                    return;
                case 11:
                    this.f6288a.m7510c(msg.arg1);
                    return;
                case C1253f.bO /*491526*/:
                    this.f6288a.m7506b((C1212c) msg.obj);
                    return;
                case C1253f.bS /*491530*/:
                    this.f6288a.m7552a((C1212c) msg.obj);
                    return;
                case C1253f.bT /*491531*/:
                    this.f6288a.m7511c((C1212c) msg.obj);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: VehicleUpdateManager */
    /* renamed from: com.baidu.carlife.n.e$c */
    private static class C1975c {
        /* renamed from: a */
        private static C1977e f6289a = new C1977e();

        private C1975c() {
        }
    }

    /* compiled from: VehicleUpdateManager */
    /* renamed from: com.baidu.carlife.n.e$d */
    private class C1976d implements C0924a {
        /* renamed from: a */
        final /* synthetic */ C1977e f6290a;

        private C1976d(C1977e c1977e) {
            this.f6290a = c1977e;
        }

        public void onNetWorkResponse(int responseCode) {
            C1260i.m4435b(C1977e.f6293d, "checkNewVersion Response: " + responseCode);
            switch (responseCode) {
                case -2:
                    C1260i.m4435b(C1977e.f6293d, "onNetWorkResponse: RESPONSE_ERROR_NONETWORK");
                    return;
                case 0:
                    this.f6290a.f6324w = this.f6290a.f6323v.m5976a();
                    C1260i.m4435b(C1977e.f6293d, "RESPONSE_SUCCESS: " + this.f6290a.f6324w.toString());
                    this.f6290a.f6296E = Integer.parseInt(this.f6290a.f6324w.f5950l);
                    C1260i.m4435b(C1977e.f6293d, "checkNewVersion: " + this.f6290a.f6296E);
                    if (this.f6290a.f6324w.f5945g == 1 || this.f6290a.f6296E > this.f6290a.f6295D) {
                        this.f6290a.f6297F = true;
                        this.f6290a.m7521i();
                        C1261k.m4461b((int) C1253f.gi);
                        this.f6290a.m7550a(this.f6290a.f6324w.f5948j);
                        return;
                    }
                    this.f6290a.f6297F = false;
                    this.f6290a.m7521i();
                    return;
                default:
                    C1260i.m4435b(C1977e.f6293d, "onNetWorkResponse Error: " + responseCode);
                    return;
            }
        }
    }

    /* renamed from: a */
    public void m7552a(C1212c msg) {
        C2201w.m8369a();
        C2201w.m8373a("传输完成，车机端开始安装更新!", (int) DialogReplaceToastUtils.LONG_TIME);
    }

    /* renamed from: b */
    private void m7506b(C1212c msg) {
        try {
            CarlifeSystemInfo firmwareInfo = CarlifeSystemInfo.parseFrom(msg.m4205f());
            String strUpdateUrl = firmwareInfo.getUpdateUrl();
            C1661t.m5975b(strUpdateUrl);
            this.f6295D = firmwareInfo.getFirmwareVersionCode();
            m7555a(false);
            C1260i.m4435b(f6293d, "MSG_DATA_HU_SYSTEMINFO= " + strUpdateUrl);
            C1260i.m4435b(f6293d, "MSG_DATA_HU_SYSTEMINFO= " + this.f6295D);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m7511c(C1212c msg) {
        try {
            String strMsg = "车机端安装完成! 版本号：" + CarLifeUpdateSuccess.parseFrom(msg.m4205f()).getVersionCode();
            C2201w.m8369a();
            C2201w.m8373a(strMsg, (int) DialogReplaceToastUtils.LONG_TIME);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private void m7516g() {
        C1260i.m4435b(f6293d, "afterDownloadCheckMD5Fail");
        m7548w();
        m7554a(this.f6326y);
        C2201w.m8371a((int) C0965R.string.carlife_update_download_again, 0);
    }

    /* renamed from: h */
    private void m7519h() {
        C1260i.m4435b(f6293d, "afterDownloadCheckMD5Success");
        m7537q();
        m7556b(1005);
    }

    /* renamed from: a */
    public static C1977e m7498a() {
        return C1975c.f6289a;
    }

    /* renamed from: a */
    public void m7551a(Activity activity, C1277e listener) {
        this.f6315n = activity;
        this.f6316o = listener;
        this.f6318q = activity.getSharedPreferences("CarlifeUpdateRecord", 0);
        this.f6294C = new C1974b(this);
        C1261k.m4460a(this.f6294C);
    }

    /* renamed from: b */
    public boolean m7557b() {
        return this.f6297F;
    }

    /* renamed from: c */
    public void m7558c() {
        if (this.f6317p != 4097) {
            C2201w.m8371a((int) C0965R.string.carlife_update_wait_for_complete, 0);
            return;
        }
        C1260i.m4435b(f6293d, "checkHUNewVersion");
        m7525k();
        m7555a(true);
    }

    /* renamed from: d */
    public boolean m7559d() {
        if (this.f6318q.getString(f6291A, "").equals(this.f6324w.f5950l)) {
            if (this.f6326y == null) {
                this.f6326y = new File(C1962d.m7476f());
            }
            if (this.f6326y != null && this.f6326y.exists()) {
                return true;
            }
            C1260i.m4435b(f6293d, "Not exit down load apk file !");
        }
        return false;
    }

    /* renamed from: a */
    public void m7555a(boolean bUdpate) {
        C1260i.m4435b("#######", "####### checkNewVersion: " + bUdpate);
        this.f6323v = new C1661t();
        this.f6323v.m5977a(this.f6327z);
        if (bUdpate) {
            this.f6323v.registerResponseListener(new C1973a());
        } else {
            this.f6323v.registerResponseListener(new C1976d());
        }
        this.f6323v.toPostRequest();
    }

    /* renamed from: i */
    private void m7521i() {
        this.f6294C.obtainMessage(5).sendToTarget();
    }

    /* renamed from: a */
    public void m7553a(C1508b updateRedPoint) {
        this.f6299H = updateRedPoint;
    }

    /* renamed from: e */
    public void m7560e() {
        if (C1251e.m4381s() == 1) {
            C1260i.m4435b(f6293d, "checkUseWifiToDownLoad MOBILE");
            m7556b(1002);
            return;
        }
        C1260i.m4435b(f6293d, "checkUseWifiToDownLoad WIFI ->> check download immediately");
        m7556b(1003);
    }

    /* renamed from: j */
    private void m7522j() {
        this.f6297F = false;
        if (this.f6324w != null) {
            if (this.f6324w.f5945g != 1) {
                m7556b(1001);
            } else if (m7559d()) {
                C1260i.m4435b(f6293d, "Download Apk has exist !");
                m7556b(1005);
            } else {
                C1260i.m4435b(f6293d, "Download file not exit, Download now.......");
                m7541s();
            }
        }
    }

    /* renamed from: k */
    private void m7525k() {
        C1307e.m4686a().mo1465a(C1157a.m3876a().getString(C0965R.string.checking_update), new C19641(this));
    }

    /* renamed from: l */
    private void m7527l() {
        if (this.f6315n != null) {
            if (this.f6319r == null) {
                this.f6319r = new C2329u(this.f6315n);
            }
            this.f6319r.setOnDialogCancelListener(new C19696(this));
            this.f6319r.setTitle((int) C0965R.string.download_vehicle_carlife);
            this.f6319r.m7458q();
            this.f6319r.m7447c((int) C0965R.string.carlife_update_cancel);
            this.f6319r.m7438a(new C19707(this));
            this.f6319r.setPercent(0);
            this.f6319r.setProgress(0);
            this.f6319r.setHasFinished(0, this.f6324w.f5948j / 1048576);
            this.f6316o.showDialog(this.f6319r);
        }
    }

    /* renamed from: m */
    private void m7528m() {
        if (this.f6315n != null) {
            if (this.f6319r == null) {
                this.f6319r = new C2329u(this.f6315n);
            }
            this.f6319r.setOnDialogCancelListener(new C19718(this));
            this.f6319r.setTitle((int) C0965R.string.transfer_vehicle_carlife);
            this.f6319r.m7458q();
            this.f6319r.m7447c((int) C0965R.string.carlife_update_cancel);
            this.f6319r.m7438a(new C19729(this));
            this.f6319r.setPercent(0);
            this.f6319r.setProgress(0);
            this.f6319r.setHasFinished(0, this.f6324w.f5948j / 1048576);
            this.f6316o.showDialog(this.f6319r);
        }
    }

    /* renamed from: n */
    private void m7531n() {
        this.f6316o.dismissDialog(this.f6319r);
        C1260i.m4435b(f6293d, "cancel:: cancelUpdateProgressDialog");
        if (this.f6325x != null) {
            this.f6325x.m5923d();
        }
        if (this.f6321t != null) {
            this.f6321t.m8209a();
        }
    }

    /* renamed from: o */
    private int m7532o() {
        Throwable th;
        C2176g md5 = new C2176g();
        md5.m8266b();
        long fileSize = this.f6326y.length();
        if (fileSize == 0) {
            return 0;
        }
        byte[] inbuf;
        int len;
        if (fileSize <= 10485760) {
            BufferedInputStream bis = null;
            try {
                BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(this.f6326y));
                try {
                    inbuf = new byte[1024];
                    while (true) {
                        len = bis2.read(inbuf);
                        if (len == -1) {
                            break;
                        }
                        md5.m8263a(inbuf, len);
                    }
                    if (bis2 != null) {
                        try {
                            bis2.close();
                        } catch (IOException e) {
                            return -1;
                        }
                    }
                } catch (IOException e2) {
                    bis = bis2;
                    if (bis != null) {
                        return -1;
                    }
                    try {
                        bis.close();
                        return -1;
                    } catch (IOException e3) {
                        return -1;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bis = bis2;
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e4) {
                            return -1;
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                if (bis != null) {
                    return -1;
                }
                bis.close();
                return -1;
            } catch (Throwable th3) {
                th = th3;
                if (bis != null) {
                    bis.close();
                }
                throw th;
            }
        }
        RandomAccessFile out = null;
        try {
            RandomAccessFile out2 = new RandomAccessFile(this.f6326y, "r");
            try {
                inbuf = new byte[1024];
                out2.seek(0);
                int curByte = 0;
                do {
                    len = out2.read(inbuf);
                    if (len == -1) {
                        break;
                    }
                    curByte += len;
                    if (curByte <= 2097152) {
                        md5.m8263a(inbuf, len);
                        continue;
                    } else {
                        md5.m8263a(inbuf, len - (curByte - 2097152));
                        continue;
                    }
                } while (curByte < 2097152);
                out2.seek((long) (this.f6324w.f5948j / 2));
                curByte = 0;
                do {
                    len = out2.read(inbuf);
                    if (len == -1) {
                        break;
                    }
                    curByte += len;
                    if (curByte <= 2097152) {
                        md5.m8263a(inbuf, len);
                        continue;
                    } else {
                        md5.m8263a(inbuf, len - (curByte - 2097152));
                        continue;
                    }
                } while (curByte < 2097152);
                out2.seek((long) (this.f6324w.f5948j - 2097152));
                curByte = 0;
                do {
                    len = out2.read(inbuf);
                    if (len == -1) {
                        break;
                    }
                    curByte += len;
                    if (curByte <= 2097152) {
                        md5.m8263a(inbuf, len);
                        continue;
                    } else {
                        md5.m8263a(inbuf, len - (curByte - 2097152));
                        continue;
                    }
                } while (curByte < 2097152);
                if (out2 != null) {
                    try {
                        out2.close();
                    } catch (IOException e6) {
                        return -1;
                    }
                }
            } catch (Exception e7) {
                out = out2;
            } catch (Throwable th4) {
                th = th4;
                out = out2;
            }
        } catch (Exception e8) {
            if (out == null) {
                return -1;
            }
            try {
                out.close();
                return -1;
            } catch (IOException e9) {
                return -1;
            }
        } catch (Throwable th5) {
            th = th5;
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e10) {
                    return -1;
                }
            }
            throw th;
        }
        md5.m8267c();
        byte[] dst = md5.m8264a();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            result.append(C2176g.m8252b(dst[i]));
        }
        if (result.toString().equalsIgnoreCase(this.f6324w.f5952n)) {
            return 1;
        }
        return 0;
    }

    /* renamed from: p */
    private void m7534p() {
        m7528m();
        C1952b.m7413a().m7425a(this.f6302K);
        C1952b.m7413a().m7429c(this.f6324w.f5945g);
    }

    /* renamed from: q */
    private void m7537q() {
        Editor editor = this.f6318q.edit();
        editor.putString(f6291A, this.f6324w.f5950l);
        editor.commit();
    }

    /* renamed from: r */
    private void m7539r() {
        String strVehicleApkPath = C1962d.m7475e();
        C1260i.m4435b(f6293d, "requestDownloadApp: " + strVehicleApkPath);
        this.f6325x = new C1635h(this.f6315n, this.f6324w.f5951m, C1253f.hQ, strVehicleApkPath, this.f6300I, true, 0);
        this.f6325x.m5920a((long) this.f6324w.f5948j);
        this.f6325x.m5924e();
    }

    /* renamed from: s */
    private void m7541s() {
        if (this.f6318q.contains(f6291A)) {
            C1260i.m4435b(f6293d, "contain update record");
            if (this.f6318q.getString(f6291A, "").equals(this.f6324w.f5950l)) {
                C1260i.m4435b(f6293d, "has down new vehicle apk");
                if (this.f6326y == null) {
                    this.f6326y = new File(C1962d.m7476f());
                }
                if (this.f6326y == null || !this.f6326y.exists()) {
                    C1260i.m4435b(f6293d, "OTA File not exist!");
                    m7544u();
                    return;
                }
                m7543t();
                new Thread(new Runnable(this) {
                    /* renamed from: a */
                    final /* synthetic */ C1977e f6272a;

                    {
                        this.f6272a = this$0;
                    }

                    public void run() {
                        if (this.f6272a.m7532o() == 1) {
                            this.f6272a.f6294C.sendEmptyMessage(1);
                        } else {
                            this.f6272a.f6294C.sendEmptyMessage(2);
                        }
                    }
                }).start();
                return;
            }
            m7544u();
            return;
        }
        C1260i.m4435b(f6293d, "not contain update record");
        m7544u();
    }

    /* renamed from: t */
    private void m7543t() {
        C1307e.m4686a().mo1467b(C1157a.m3876a().getString(C0965R.string.update_waiting_install));
    }

    /* renamed from: u */
    private void m7544u() {
        this.f6317p = 4098;
        if (this.f6324w.f5947i == 0) {
            C1260i.m4435b(f6293d, "downloadApk");
            m7527l();
            m7539r();
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f6324w.f5951m));
            this.f6315n.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: v */
    private void m7546v() {
        this.f6317p = 4097;
        if (this.f6321t != null) {
            this.f6321t.m8209a();
        }
        C1260i.m4435b(f6293d, "cancel:: updateDialogCancel");
        if (this.f6325x != null) {
            this.f6325x.m5923d();
        }
    }

    /* renamed from: a */
    public void m7554a(File apkFile) {
        if (this.f6315n != null) {
            Builder builder = new Builder(this.f6315n).setSmallIcon(C0965R.drawable.ic_launcher).setContentTitle(this.f6315n.getString(C0965R.string.carlife_update_download_finish)).setContentText(this.f6315n.getString(C0965R.string.carlife_update_click_to_install));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this.f6315n);
            stackBuilder.addParentStack(CarlifeActivity.class);
            stackBuilder.addNextIntent(intent);
            builder.setContentIntent(stackBuilder.getPendingIntent(0, 134217728));
            NotificationManager notificationManager = (NotificationManager) this.f6315n.getSystemService("notification");
            Notification n = builder.build();
            n.flags |= 16;
            notificationManager.notify(8194, n);
        }
    }

    /* renamed from: w */
    private void m7548w() {
        this.f6317p = 4097;
        C1260i.m4435b(f6293d, "afterDownload dismissdialog");
        this.f6316o.dismissDialog();
        if (this.f6321t != null) {
            this.f6321t.m8209a();
        }
    }

    /* renamed from: x */
    private void m7549x() {
        this.f6322u = this.f6315n.bindService(new Intent(this.f6315n, NotificationDownloadService.class), this.f6301J, 1);
    }

    /* renamed from: f */
    public void m7561f() {
        if (this.f6321t != null) {
            C1260i.m4435b(f6293d, "unbindService");
            this.f6321t.stopSelf();
            this.f6315n.unbindService(this.f6301J);
        }
    }

    /* renamed from: a */
    public void m7550a(int nSize) {
        if (this.f6320s != null) {
            this.f6320s.setNewAppSize(nSize);
        }
    }

    /* renamed from: b */
    public void m7556b(int dlgType) {
        Message msg = Message.obtain();
        msg.what = 11;
        msg.arg1 = dlgType;
        this.f6294C.sendMessage(msg);
    }

    /* renamed from: c */
    private void m7510c(int dlgType) {
        C1260i.m4435b(f6293d, "showUpdateDialog: " + dlgType);
        if (this.f6320s == null) {
            this.f6320s = new C1954c(this.f6315n, dlgType);
        }
        this.f6320s.m7438a(this.f6303a);
        this.f6320s.m7443b(this.f6304b);
        this.f6320s.setOnDialogCancelListener(this.f6305c);
        this.f6320s.setNewAppSize(this.f6324w.f5948j);
        this.f6320s.setDialogType(dlgType);
        this.f6320s.mo1630i();
        this.f6316o.showDialog(this.f6320s);
    }
}
