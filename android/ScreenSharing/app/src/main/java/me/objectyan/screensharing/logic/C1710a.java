package com.baidu.carlife.logic;

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
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.OnBtnClickListener;
import com.baidu.carlife.core.screen.OnDialogCancelListener;
import com.baidu.carlife.core.screen.OnDialogListener;
import com.baidu.carlife.core.screen.presentation.view.CarlifeProgressDialogContainer;
import com.baidu.carlife.model.C1923c;
import com.baidu.carlife.p054k.C1640a;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.carlife.p054k.p055a.C1635h;
import com.baidu.carlife.p054k.p055a.C1635h.C1489c;
import com.baidu.carlife.p054k.p055a.C1635h.C1633a;
import com.baidu.carlife.p054k.p055a.C1635h.C1634b;
import com.baidu.carlife.service.NotificationDownloadService;
import com.baidu.carlife.service.NotificationDownloadService.C2165a;
import com.baidu.carlife.util.C2176g;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.dialog.C2269b;
import com.baidu.navi.ActivityStack;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: AppUpdateManager */
/* renamed from: com.baidu.carlife.logic.a */
public class C1710a {
    /* renamed from: h */
    private static final int f5207h = 96;
    /* renamed from: a */
    private final int f5208a = 8194;
    /* renamed from: b */
    private final int f5209b = 1;
    /* renamed from: c */
    private final int f5210c = 2;
    /* renamed from: d */
    private final int f5211d = 3;
    /* renamed from: e */
    private final int f5212e = 4;
    /* renamed from: f */
    private final int f5213f = 4097;
    /* renamed from: g */
    private final int f5214g = 4098;
    /* renamed from: i */
    private Activity f5215i = null;
    /* renamed from: j */
    private OnDialogListener f5216j;
    /* renamed from: k */
    private volatile int f5217k = 4097;
    /* renamed from: l */
    private SharedPreferences f5218l = null;
    /* renamed from: m */
    private C2269b f5219m = null;
    /* renamed from: n */
    private C1953c f5220n = null;
    /* renamed from: o */
    private NotificationDownloadService f5221o = null;
    /* renamed from: p */
    private boolean f5222p;
    /* renamed from: q */
    private boolean f5223q;
    /* renamed from: r */
    private C1640a f5224r;
    /* renamed from: s */
    private C1923c f5225s;
    /* renamed from: t */
    private C1635h f5226t;
    /* renamed from: u */
    private File f5227u;
    /* renamed from: v */
    private Handler f5228v = new C16691(this);
    /* renamed from: w */
    private C1489c f5229w = new C16723(this);
    /* renamed from: x */
    private ServiceConnection f5230x = new C16734(this);

    /* compiled from: AppUpdateManager */
    /* renamed from: com.baidu.carlife.logic.a$1 */
    class C16691 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C1710a f5164a;

        C16691(C1710a this$0) {
            this.f5164a = this$0;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.f5164a.f5217k = 4097;
                    CarlifeProgressDialogContainer.m4686a().mo1468c();
                    this.f5164a.m6231k();
                    if (this.f5164a.m6222f()) {
                        ActivityStack.exitApp(true);
                        return;
                    }
                    return;
                case 2:
                    CarlifeProgressDialogContainer.m4686a().mo1468c();
                    this.f5164a.m6241p();
                    return;
                case 3:
                    this.f5164a.m6217d();
                    return;
                case 4:
                    this.f5164a.m6215c();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: AppUpdateManager */
    /* renamed from: com.baidu.carlife.logic.a$2 */
    class C16702 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1710a f5165a;

        C16702(C1710a this$0) {
            this.f5165a = this$0;
        }

        public void run() {
            if (this.f5165a.m6229j() == 1) {
                this.f5165a.f5228v.sendEmptyMessage(1);
            } else {
                this.f5165a.f5228v.sendEmptyMessage(2);
            }
        }
    }

    /* compiled from: AppUpdateManager */
    /* renamed from: com.baidu.carlife.logic.a$3 */
    class C16723 implements C1489c {
        /* renamed from: a */
        final /* synthetic */ C1710a f5167a;

        /* compiled from: AppUpdateManager */
        /* renamed from: com.baidu.carlife.logic.a$3$1 */
        class C16711 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C16723 f5166a;

            C16711(C16723 this$1) {
                this.f5166a = this$1;
            }

            public void run() {
                if (this.f5166a.f5167a.m6229j() == 1) {
                    this.f5166a.f5167a.f5228v.sendEmptyMessage(3);
                } else {
                    this.f5166a.f5167a.f5228v.sendEmptyMessage(4);
                }
            }
        }

        C16723(C1710a this$0) {
            this.f5167a = this$0;
        }

        /* renamed from: a */
        public void mo1561a(C1634b state, C1633a errorCode) {
            switch (state) {
                case SUCESS:
                    m6128b();
                    return;
                case ERROR:
                    m6127a();
                    return;
                case CANCEL:
                    m6129c();
                    return;
                default:
                    return;
            }
        }

        /* renamed from: a */
        public void mo1560a(long total, int progress) {
            try {
                if (this.f5167a.f5222p) {
                    this.f5167a.f5221o.m8210a(progress);
                } else if (this.f5167a.f5219m != null) {
                    this.f5167a.f5219m.setProgress(progress);
                    this.f5167a.f5219m.setPercent(progress);
                    this.f5167a.f5219m.setHasFinished((int) ((((((long) progress) * total) / 100) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID), (int) ((total / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        /* renamed from: a */
        private void m6127a() {
            this.f5167a.f5227u = null;
            this.f5167a.m6248s();
            this.f5167a.m6213a(null, true);
        }

        /* renamed from: b */
        private void m6128b() {
            this.f5167a.f5227u = this.f5167a.f5226t.m5922b();
            new Thread(new C16711(this)).start();
        }

        /* renamed from: c */
        private void m6129c() {
            this.f5167a.m6248s();
        }
    }

    /* compiled from: AppUpdateManager */
    /* renamed from: com.baidu.carlife.logic.a$4 */
    class C16734 implements ServiceConnection {
        /* renamed from: a */
        final /* synthetic */ C1710a f5168a;

        C16734(C1710a this$0) {
            this.f5168a = this$0;
        }

        public void onServiceConnected(ComponentName className, IBinder service) {
            this.f5168a.f5221o = ((C2165a) service).m8208a();
            this.f5168a.f5221o.m8211a(this.f5168a.f5215i);
            this.f5168a.f5221o.m8210a(0);
        }

        public void onServiceDisconnected(ComponentName arg0) {
            LogUtil.d("AppUpdateManager", "app update onServiceDisconnected");
            if (this.f5168a.f5221o != null) {
                this.f5168a.f5221o.m8209a();
            }
        }
    }

    /* compiled from: AppUpdateManager */
    /* renamed from: com.baidu.carlife.logic.a$6 */
    class C16756 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1710a f5170a;

        C16756(C1710a this$0) {
            this.f5170a = this$0;
        }

        public void onClick() {
            this.f5170a.f5224r.cancel();
        }
    }

    /* compiled from: AppUpdateManager */
    /* renamed from: com.baidu.carlife.logic.a$7 */
    class C16767 implements OnDialogCancelListener {
        /* renamed from: a */
        final /* synthetic */ C1710a f5171a;

        C16767(C1710a this$0) {
            this.f5171a = this$0;
        }

        public void onCancel() {
            this.f5171a.m6227i();
        }
    }

    /* compiled from: AppUpdateManager */
    /* renamed from: com.baidu.carlife.logic.a$8 */
    class C16778 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1710a f5172a;

        C16778(C1710a this$0) {
            this.f5172a = this$0;
        }

        public void onClick() {
            this.f5172a.m6250t();
        }
    }

    /* compiled from: AppUpdateManager */
    /* renamed from: com.baidu.carlife.logic.a$9 */
    class C16789 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1710a f5173a;

        C16789(C1710a this$0) {
            this.f5173a = this$0;
        }

        public void onClick() {
            this.f5173a.m6227i();
        }
    }

    /* compiled from: AppUpdateManager */
    /* renamed from: com.baidu.carlife.logic.a$a */
    private class C1679a implements C0924a {
        /* renamed from: a */
        final /* synthetic */ C1710a f5174a;

        private C1679a(C1710a c1710a) {
            this.f5174a = c1710a;
        }

        public void onNetWorkResponse(int responseCode) {
            CarlifeProgressDialogContainer.m4686a().mo1468c();
            switch (responseCode) {
                case -2:
                    if (!this.f5174a.f5223q) {
                        C2201w.m8371a((int) R.string.carlife_update_no_network, 0);
                        return;
                    }
                    return;
                case 0:
                    this.f5174a.f5225s = this.f5174a.f5224r.m5947a();
                    this.f5174a.m6219e();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: AppUpdateManager */
    /* renamed from: com.baidu.carlife.logic.a$b */
    private static class C1680b {
        /* renamed from: a */
        private static C1710a f5175a = new C1710a();

        private C1680b() {
        }
    }

    /* renamed from: c */
    private void m6215c() {
        m6248s();
        m6254a(this.f5227u);
        C2201w.m8371a((int) R.string.carlife_update_download_again, 0);
    }

    /* renamed from: d */
    private void m6217d() {
        m6248s();
        m6254a(this.f5227u);
        m6234l();
        m6231k();
        if (m6222f()) {
            ActivityStack.exitApp(true);
        }
    }

    /* renamed from: a */
    public static C1710a m6207a() {
        return C1680b.f5175a;
    }

    /* renamed from: a */
    public void m6253a(Activity activity, OnDialogListener listener) {
        this.f5215i = activity;
        this.f5216j = listener;
        this.f5218l = activity.getSharedPreferences("CarlifeUpdateRecord", 0);
    }

    /* renamed from: a */
    public void m6255a(boolean isFromHome) {
        if (!CommonParams.jc.equals(CommonParams.sChannel)) {
            if (this.f5217k != 4097) {
                C2201w.m8371a((int) R.string.carlife_update_wait_for_complete, 0);
                return;
            }
            if (!isFromHome) {
                m6223g();
            }
            this.f5223q = isFromHome;
            this.f5224r = new C1640a();
            this.f5224r.registerResponseListener(new C1679a());
            this.f5224r.toPostRequest();
        }
    }

    /* renamed from: e */
    private void m6219e() {
        if (this.f5225s != null) {
            if (this.f5225s.f5945g == 1) {
                if (m6222f() || !this.f5223q || !m6246r()) {
                    m6213a(this.f5225s.f5949k, false);
                }
            } else if (!this.f5223q) {
                C2201w.m8371a((int) R.string.carlife_update_no_new_version, 0);
            }
        }
    }

    /* renamed from: f */
    private boolean m6222f() {
        boolean z = true;
        if (this.f5225s == null) {
            return false;
        }
        if (this.f5225s.f5946h != 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: g */
    private void m6223g() {
        CarlifeProgressDialogContainer.m4686a().mo1465a(AppContext.m3876a().getString(R.string.checking_update), new C16756(this));
    }

    /* renamed from: h */
    private void m6225h() {
        if (this.f5215i != null) {
            if (this.f5219m == null) {
                this.f5219m = new C2269b(this.f5215i);
                this.f5219m.setOnDialogCancelListener(new C16767(this));
            }
            if (m6222f()) {
                this.f5219m.m7458q();
                this.f5219m.m7447c((int) R.string.carlife_update_cancel);
                this.f5219m.m7438a(new OnBtnClickListener(this) {
                    /* renamed from: a */
                    final /* synthetic */ C1710a f5160a;

                    {
                        this.f5160a = this$0;
                    }

                    public void onClick() {
                        this.f5160a.m6227i();
                    }
                });
            } else {
                this.f5219m.m7447c((int) R.string.carlife_update_backstage);
                this.f5219m.m7458q();
                this.f5219m.m7450d((int) R.string.carlife_update_cancel);
                this.f5219m.m7438a(new C16778(this));
                this.f5219m.m7443b(new C16789(this));
            }
            this.f5219m.setPercent(0);
            this.f5219m.setProgress(0);
            this.f5219m.setHasFinished(0, this.f5225s.f5948j / 1048576);
            this.f5216j.showDialog(this.f5219m);
        }
    }

    /* renamed from: i */
    private void m6227i() {
        this.f5216j.dismissDialog(this.f5219m);
        if (this.f5226t != null) {
            this.f5226t.m5923d();
        }
        if (this.f5221o != null) {
            this.f5221o.m8209a();
        }
        if (m6222f()) {
            ActivityStack.exitApp(true);
        }
    }

    /* renamed from: j */
    private int m6229j() {
        Throwable th;
        C2176g md5 = new C2176g();
        md5.m8266b();
        long fileSize = this.f5227u.length();
        if (fileSize == 0) {
            return 0;
        }
        byte[] inbuf;
        int len;
        if (fileSize <= 10485760) {
            BufferedInputStream bis = null;
            try {
                BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(this.f5227u));
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
            RandomAccessFile out2 = new RandomAccessFile(this.f5227u, "r");
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
                out2.seek((long) (this.f5225s.f5948j / 2));
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
                out2.seek((long) (this.f5225s.f5948j - 2097152));
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
        if (result.toString().equalsIgnoreCase(this.f5225s.f5952n)) {
            return 1;
        }
        return 0;
    }

    /* renamed from: k */
    private void m6231k() {
        if (this.f5227u != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setDataAndType(Uri.fromFile(this.f5227u), "application/vnd.android.package-archive");
            this.f5215i.startActivity(intent);
        }
    }

    /* renamed from: l */
    private void m6234l() {
        Editor editor = this.f5218l.edit();
        editor.putString("newAppVersionName", this.f5225s.f5950l);
        editor.commit();
    }

    /* renamed from: m */
    private void m6236m() {
        this.f5226t = new C1635h(this.f5225s.f5951m, CommonParams.hP, this.f5229w);
        this.f5226t.m5920a((long) this.f5225s.f5948j);
        this.f5226t.m5924e();
    }

    /* renamed from: a */
    private void m6213a(String message, boolean isError) {
        if (this.f5215i != null) {
            if (this.f5220n == null) {
                this.f5220n = new C1953c(this.f5215i).m7458q();
                this.f5220n.m7438a(new OnBtnClickListener(this) {
                    /* renamed from: a */
                    final /* synthetic */ C1710a f5161a;

                    {
                        this.f5161a = this$0;
                    }

                    public void onClick() {
                        this.f5161a.f5217k = 4098;
                        if (this.f5161a.f5222p) {
                            this.f5161a.f5216j.dismissDialog(this.f5161a.f5220n);
                            if (this.f5161a.f5221o != null) {
                                this.f5161a.f5221o.m8210a(0);
                            }
                            this.f5161a.f5226t.m5924e();
                            return;
                        }
                        this.f5161a.m6238n();
                    }
                });
                this.f5220n.m7443b(new OnBtnClickListener(this) {
                    /* renamed from: a */
                    final /* synthetic */ C1710a f5162a;

                    {
                        this.f5162a = this$0;
                    }

                    public void onClick() {
                        this.f5162a.m6243q();
                    }
                });
                this.f5220n.setOnDialogCancelListener(new OnDialogCancelListener(this) {
                    /* renamed from: a */
                    final /* synthetic */ C1710a f5163a;

                    {
                        this.f5163a = this$0;
                    }

                    public void onCancel() {
                        this.f5163a.m6243q();
                    }
                });
            }
            if (isError) {
                this.f5220n.m7442b((int) R.string.carlife_update_download_failed_dialog_title);
                this.f5220n.m7447c((int) R.string.carlife_update_download_failed_dialog_retry);
                this.f5220n.m7450d((int) R.string.carlife_update_cancel);
                this.f5220n.m7435a((int) R.string.carlife_update_download_failed_dialog_content);
            } else {
                this.f5220n.m7442b((int) R.string.carlife_update_tips_dialog_title);
                this.f5220n.m7447c((int) R.string.carlife_update_tips_dialog_confirm);
                if (m6222f()) {
                    this.f5220n.m7450d((int) R.string.carlife_update_tips_dialog_exit);
                } else {
                    this.f5220n.m7450d((int) R.string.carlife_update_tips_dialog_cancel);
                }
                if (!TextUtils.isEmpty(message)) {
                    try {
                        if (message.length() > 96) {
                            message = message.substring(0, 96) + "\n...";
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    this.f5220n.m7444b(message);
                }
            }
            this.f5216j.showDialog(this.f5220n);
        }
    }

    /* renamed from: n */
    private void m6238n() {
        this.f5216j.dismissDialog(this.f5220n);
        if (!this.f5218l.contains("newAppVersionName")) {
            m6241p();
        } else if (!this.f5218l.getString("newAppVersionName", "").equals(this.f5225s.f5950l)) {
            m6241p();
        } else if (this.f5227u == null || !this.f5227u.exists()) {
            m6241p();
        } else {
            m6240o();
            new Thread(new C16702(this)).start();
        }
    }

    /* renamed from: o */
    private void m6240o() {
        CarlifeProgressDialogContainer.m4686a().mo1467b(AppContext.m3876a().getString(R.string.update_waiting_install));
    }

    /* renamed from: p */
    private void m6241p() {
        if (this.f5225s.f5947i == 0) {
            m6225h();
            m6236m();
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f5225s.f5951m));
            this.f5215i.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: q */
    private void m6243q() {
        this.f5217k = 4097;
        this.f5216j.dismissDialog(this.f5220n);
        if (this.f5221o != null) {
            this.f5221o.m8209a();
        }
        if (this.f5226t != null) {
            this.f5226t.m5923d();
        }
        if (m6222f()) {
            ActivityStack.exitApp(true);
        }
    }

    /* renamed from: r */
    private boolean m6246r() {
        Editor editor = this.f5218l.edit();
        int todayUpdateCount = this.f5218l.getInt("todayUpdateCount", 0);
        if (this.f5218l.contains("lastUpdateTime")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String newLastUpdateTime = df.format(new Date());
            try {
                if (df.parse(newLastUpdateTime).after(df.parse(this.f5218l.getString("lastUpdateTime", null)))) {
                    editor.putString("lastUpdateTime", newLastUpdateTime);
                    editor.putInt("todayUpdateCount", 1);
                    editor.commit();
                    return false;
                } else if (todayUpdateCount >= 2) {
                    return true;
                } else {
                    editor.putInt("todayUpdateCount", todayUpdateCount + 1);
                    editor.commit();
                    return false;
                }
            } catch (ParseException e) {
                return false;
            }
        }
        editor.putString("lastUpdateTime", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        editor.putInt("todayUpdateCount", 1);
        editor.commit();
        return false;
    }

    /* renamed from: a */
    public void m6254a(File apkFile) {
        if (this.f5215i != null) {
            Builder builder = new Builder(this.f5215i).setSmallIcon(R.drawable.ic_launcher).setContentTitle(this.f5215i.getString(R.string.carlife_update_download_finish)).setContentText(this.f5215i.getString(R.string.carlife_update_click_to_install));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this.f5215i);
            stackBuilder.addParentStack(CarlifeActivity.class);
            stackBuilder.addNextIntent(intent);
            builder.setContentIntent(stackBuilder.getPendingIntent(0, 134217728));
            NotificationManager notificationManager = (NotificationManager) this.f5215i.getSystemService("notification");
            Notification n = builder.build();
            n.flags |= 16;
            notificationManager.notify(8194, n);
        }
    }

    /* renamed from: s */
    private void m6248s() {
        this.f5217k = 4097;
        this.f5216j.dismissDialog();
        if (this.f5221o != null) {
            this.f5221o.m8209a();
        }
    }

    /* renamed from: t */
    private void m6250t() {
        this.f5222p = this.f5215i.bindService(new Intent(this.f5215i, NotificationDownloadService.class), this.f5230x, 1);
    }

    /* renamed from: b */
    public void m6256b() {
        if (this.f5221o != null) {
            LogUtil.d("AppUpdateManager", "unbindService");
            this.f5221o.stopSelf();
            this.f5215i.unbindService(this.f5230x);
        }
    }
}
