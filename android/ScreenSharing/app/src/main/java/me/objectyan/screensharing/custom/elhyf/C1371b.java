package com.baidu.carlife.custom.elhyf;

import android.content.Context;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.core.screen.OnBtnClickListener;
import com.baidu.carlife.core.screen.presentation.view.CarlifeViewContainer;
import com.baidu.carlife.custom.elhyf.mydvr.C1398a;
import com.baidu.carlife.custom.elhyf.mydvr.C1402c;
import com.baidu.carlife.custom.elhyf.p072a.C1344a;
import com.baidu.carlife.custom.elhyf.p073c.C1376b;
import com.baidu.carlife.custom.elhyf.p073c.C1381d;
import com.baidu.carlife.custom.elhyf.p073c.C1381d.C1359a;
import com.baidu.carlife.custom.elhyf.p074b.C1370a;
import com.baidu.carlife.custom.elhyf.p074b.C1370a.C1369a;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.protobuf.CarlifeASRVersionMatchProto.CarlifeASRVersionMatch;
import com.baidu.carlife.protobuf.CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync;
import com.baidu.carlife.protobuf.CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.Builder;
import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.dialog.C1953c;
import java.util.TimeZone;

/* compiled from: ElhCustom */
/* renamed from: com.baidu.carlife.custom.elhyf.b */
public class C1371b implements C1369a {
    /* renamed from: k */
    static C1371b f3994k;
    /* renamed from: a */
    String f3995a;
    /* renamed from: b */
    String f3996b;
    /* renamed from: c */
    C1370a f3997c;
    /* renamed from: d */
    C1953c f3998d;
    /* renamed from: e */
    C1953c f3999e;
    /* renamed from: f */
    C1953c f4000f;
    /* renamed from: g */
    C1953c f4001g;
    /* renamed from: h */
    C1344a f4002h;
    /* renamed from: i */
    C1344a f4003i;
    /* renamed from: j */
    Context f4004j;

    /* compiled from: ElhCustom */
    /* renamed from: com.baidu.carlife.custom.elhyf.b$1 */
    class C13531 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1371b f3956a;

        C13531(C1371b this$0) {
            this.f3956a = this$0;
        }

        public void onClick() {
            this.f3956a.f3997c.m4992b();
            if (this.f3956a.f4002h == null) {
                this.f3956a.f4002h = new C1344a(this.f3956a.f4004j);
            }
            this.f3956a.f4002h.setProgress(0);
            this.f3956a.f4002h.setTitle(this.f3956a.f4004j.getString(R.string.ota_title_downloading));
            CarlifeViewContainer.m4699a().showDialog(this.f3956a.f4002h);
        }
    }

    /* compiled from: ElhCustom */
    /* renamed from: com.baidu.carlife.custom.elhyf.b$2 */
    class C13542 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1371b f3957a;

        C13542(C1371b this$0) {
            this.f3957a = this$0;
        }

        public void onClick() {
            this.f3957a.f3997c.m4993c();
        }
    }

    /* compiled from: ElhCustom */
    /* renamed from: com.baidu.carlife.custom.elhyf.b$4 */
    class C13564 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1371b f3962a;

        C13564(C1371b this$0) {
            this.f3962a = this$0;
        }

        public void onClick() {
            this.f3962a.f3997c.m4993c();
        }
    }

    /* compiled from: ElhCustom */
    /* renamed from: com.baidu.carlife.custom.elhyf.b$5 */
    class C13575 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1371b f3963a;

        C13575(C1371b this$0) {
            this.f3963a = this$0;
        }

        public void onClick() {
            this.f3963a.f4001g.mo1526d();
            this.f3963a.f3997c.m4992b();
            if (this.f3963a.f4002h == null) {
                this.f3963a.f4002h = new C1344a(this.f3963a.f4004j);
            }
            this.f3963a.f4002h.setProgress(0);
            this.f3963a.f4002h.setTitle(this.f3963a.f4004j.getString(R.string.ota_title_downloading));
            CarlifeViewContainer.m4699a().m4701b().showDialog(this.f3963a.f4002h);
        }
    }

    /* compiled from: ElhCustom */
    /* renamed from: com.baidu.carlife.custom.elhyf.b$6 */
    class C13586 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1371b f3964a;

        C13586(C1371b this$0) {
            this.f3964a = this$0;
        }

        public void onClick() {
            this.f3964a.f4001g.mo1526d();
        }
    }

    /* compiled from: ElhCustom */
    /* renamed from: com.baidu.carlife.custom.elhyf.b$7 */
    class C13607 implements C1359a {
        /* renamed from: a */
        final /* synthetic */ C1371b f3965a;

        C13607(C1371b this$0) {
            this.f3965a = this$0;
        }

        /* renamed from: a */
        public void mo1531a() {
        }

        /* renamed from: a */
        public void mo1532a(int progress) {
            this.f3965a.f4003i.setProgress(progress);
        }

        /* renamed from: b */
        public void mo1533b() {
            C2201w.m8371a((int) R.string.ota_send_success, 1);
            this.f3965a.f4003i.mo1526d();
        }

        /* renamed from: c */
        public void mo1534c() {
            C2201w.m8371a((int) R.string.ota_send_fail, 1);
            this.f3965a.f4003i.mo1526d();
        }
    }

    /* compiled from: ElhCustom */
    /* renamed from: com.baidu.carlife.custom.elhyf.b$8 */
    class C13618 implements C1359a {
        /* renamed from: a */
        final /* synthetic */ C1371b f3966a;

        C13618(C1371b this$0) {
            this.f3966a = this$0;
        }

        /* renamed from: a */
        public void mo1531a() {
            C2201w.m8373a("Photo TransferData start!", 1);
        }

        /* renamed from: a */
        public void mo1532a(int progress) {
            C2201w.m8373a("Photo TransferData  " + progress + "%", 1);
        }

        /* renamed from: b */
        public void mo1533b() {
            C2201w.m8373a("Photo TransferData success!", 1);
        }

        /* renamed from: c */
        public void mo1534c() {
            C2201w.m8373a("Photo TransferData failed!", 1);
        }
    }

    /* renamed from: a */
    public static C1371b m4996a() {
        if (f3994k == null) {
            f3994k = new C1371b();
        }
        return f3994k;
    }

    /* renamed from: a */
    public void m5007a(Context context) {
        this.f4004j = context;
        C1381d.m5073a().m5092a(context);
        C1376b.m5035a().m5056a(context.getApplicationContext());
        C1398a.m5125a().m5150a(context.getApplicationContext());
        C1402c.m5174a().m5180a(context.getApplicationContext());
    }

    /* renamed from: b */
    public static void m4999b() {
        if (CarlifeCoreSDK.m5979a().m5993N()) {
            int timeStamp = (int) ((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 1000);
            Builder builder = CarlifeConnectTimeSync.newBuilder();
            builder.setTimeStamp(timeStamp);
            CarlifeConnectTimeSync proto = builder.build();
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            command.m4199b(proto.toByteArray());
            command.m4203d(proto.getSerializedSize());
            command.m4201c(CommonParams.f3541H);
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, command.getServiceType(), 1001, 0, command));
        }
    }

    /* renamed from: c */
    public static void m5002c() {
        if (CarlifeCoreSDK.m5979a().m5993N()) {
            CarlifeASRVersionMatch.Builder builder = CarlifeASRVersionMatch.newBuilder();
            builder.setAsrName("UscAsr");
            builder.setVersionCode(1);
            CarlifeASRVersionMatch proto = builder.build();
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            command.m4199b(proto.toByteArray());
            command.m4203d(proto.getSerializedSize());
            command.m4201c(CommonParams.f3542I);
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, command.getServiceType(), 1001, 0, command));
        }
    }

    /* renamed from: d */
    public void m5014d() {
        if (this.f3997c == null) {
            this.f3997c = new C1370a(this);
        }
        this.f3997c.m4989a();
    }

    /* renamed from: a */
    public void m5009a(String board, String code) {
        if (this.f3997c == null) {
            this.f3997c = new C1370a(this);
        }
        this.f3995a = board;
        this.f3996b = code;
        this.f3997c.m4991a(this.f3995a, this.f3996b, false);
    }

    /* renamed from: e */
    public void m5015e() {
        if (CarlifeCoreSDK.m5979a().m5993N() && (this.f3996b == null || "".equals(this.f3996b))) {
            C2201w.m8371a((int) R.string.ota_low_version, 0);
        } else {
            this.f3997c.m4989a();
        }
    }

    /* renamed from: f */
    public boolean m5016f() {
        return this.f3997c.m4994d();
    }

    /* renamed from: b */
    private void m5000b(String tips, long packSize) {
        boolean isMobileNetwork = true;
        if (this.f3998d == null) {
            this.f3998d = new C1953c(this.f4004j).m7448c(this.f4004j.getString(R.string.ota_find_new_version, new Object[]{Float.valueOf(((float) (packSize / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)) / 1024.0f)})).m7457g(17).m7451d(this.f4004j.getString(R.string.alert_confirm)).m7458q().m7450d((int) R.string.alert_ignore);
            this.f3998d.m7438a(new C13531(this));
            this.f3998d.m7443b(new C13542(this));
        }
        if (this.f3998d.isShown()) {
            this.f3998d.mo1526d();
        }
        if (CarlifeUtil.m4381s() != 1) {
            isMobileNetwork = false;
        }
        this.f3998d.m7444b(tips + "\n" + this.f4004j.getString(R.string.ota_is_download) + (isMobileNetwork ? "\n（" + this.f4004j.getString(R.string.module_music_mobile_flow_hint) + ")" : ""));
        CarlifeViewContainer.m4699a().m4701b().showDialog(this.f3998d);
    }

    /* renamed from: b */
    private void m5001b(final String filePath, final String boardName, final String versionCode) {
        if (this.f3999e == null) {
            this.f3999e = new C1953c(this.f4004j).m7442b((int) R.string.ota_new_version_downloaded).m7457g(17).m7447c((int) R.string.alert_confirm).m7458q().m7450d((int) R.string.alert_ignore);
            this.f3999e.m7438a(new OnBtnClickListener(this) {
                /* renamed from: d */
                final /* synthetic */ C1371b f3961d;

                public void onClick() {
                    this.f3961d.m5003c(filePath, boardName, versionCode);
                }
            });
            this.f3999e.m7443b(new C13564(this));
        }
        if (this.f3999e.isShown()) {
            this.f3999e.mo1526d();
        }
        this.f3999e.m7444b(this.f4004j.getString(R.string.ota_already_download));
        CarlifeViewContainer.m4699a().showDialog(this.f3999e);
    }

    /* renamed from: i */
    private void m5004i() {
        if (this.f4000f == null) {
            this.f4000f = new C1953c(this.f4004j).m7442b((int) R.string.ota_title_md5_check).m7457g(17);
        }
        if (this.f4000f.isShown()) {
            this.f4000f.mo1526d();
        }
        this.f4000f.m7435a((int) R.string.ota_file_md5_check_start);
        CarlifeViewContainer.m4699a().showDialog(this.f4000f);
    }

    /* renamed from: j */
    private void m5005j() {
        if (this.f4001g == null) {
            this.f4001g = new C1953c(this.f4004j).m7442b((int) R.string.ota_title_md5_check).m7457g(17).m7447c((int) R.string.ota_file_re_download).m7450d((int) R.string.alert_cancel);
            this.f4001g.m7438a(new C13575(this));
            this.f4001g.m7443b(new C13586(this));
        }
        if (this.f4001g.isShown()) {
            this.f4001g.mo1526d();
        }
        this.f4001g.m7435a((int) R.string.ota_file_md5_check_failed);
        CarlifeViewContainer.m4699a().showDialog(this.f4001g);
    }

    /* renamed from: c */
    private void m5003c(String filePath, String newBoardName, String newVersionCode) {
        if (!CarlifeCoreSDK.m5979a().m5993N()) {
            C2201w.m8371a((int) R.string.usb_disconnected, 1);
        } else if (this.f3996b == null || this.f3996b.isEmpty()) {
            C2201w.m8371a((int) R.string.ota_low_version, 1);
        } else {
            long curVerCode = (long) Integer.parseInt(this.f3996b);
            long newCode = (long) Integer.parseInt(newVersionCode);
            if (this.f3995a.equals(newBoardName) && curVerCode < newCode) {
                if (this.f4003i == null) {
                    this.f4003i = new C1344a(this.f4004j);
                }
                this.f4003i.setProgress(0);
                this.f4003i.setTitle(this.f4004j.getString(R.string.ota_title_pushing));
                CarlifeViewContainer.m4699a().showDialog(this.f4003i);
                C1381d.m5073a().m5093a(filePath, DataType.Firmware, new C13607(this));
            }
        }
    }

    /* renamed from: a */
    private void m4998a(String path) {
        C1381d.m5073a().m5093a(path, DataType.Photo, new C13618(this));
    }

    /* renamed from: a */
    public void mo1536a(String tips, long packSize) {
        m5000b(tips, packSize);
    }

    /* renamed from: a */
    public void mo1538a(boolean manual) {
        if (manual) {
            C2201w.m8370a((int) R.string.ota_net_error);
        }
    }

    /* renamed from: a */
    public void mo1537a(String filePath, String boardName, String versionCode) {
        if (this.f4002h != null) {
            this.f4002h.mo1526d();
        }
        if (this.f4000f != null) {
            this.f4000f.mo1526d();
        }
        m5001b(filePath, boardName, versionCode);
    }

    /* renamed from: a */
    public void mo1535a(int code) {
        this.f4002h.mo1526d();
        C2201w.m8370a((int) R.string.ota_download_fail);
    }

    /* renamed from: b */
    public void mo1540b(boolean manual) {
        if (manual) {
            C2201w.m8370a((int) R.string.ota_no_find_new_version);
        }
    }

    /* renamed from: g */
    public void mo1541g() {
        if (this.f4002h != null) {
            this.f4002h.mo1526d();
        }
        m5004i();
    }

    /* renamed from: h */
    public void mo1542h() {
        if (this.f4002h != null) {
            this.f4002h.mo1526d();
        }
        this.f4000f.mo1526d();
        m5005j();
    }

    /* renamed from: b */
    public void mo1539b(int progress) {
        this.f4002h.setProgress(progress);
    }
}
