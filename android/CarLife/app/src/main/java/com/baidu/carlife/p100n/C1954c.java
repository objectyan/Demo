package com.baidu.carlife.p100n;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.view.dialog.C1953c;

/* compiled from: FirmwareUpdateDialog */
/* renamed from: com.baidu.carlife.n.c */
public class C1954c extends C1953c {
    /* renamed from: e */
    protected static final String f6229e = "FirmwareUpdateDialog";
    /* renamed from: f */
    public static final int f6230f = 0;
    /* renamed from: g */
    public static final int f6231g = 1001;
    /* renamed from: h */
    public static final int f6232h = 1002;
    /* renamed from: i */
    public static final int f6233i = 1003;
    /* renamed from: j */
    public static final int f6234j = 1004;
    /* renamed from: k */
    public static final int f6235k = 1005;
    /* renamed from: l */
    public static final int f6236l = 1006;
    /* renamed from: m */
    public static final int f6237m = 1007;
    /* renamed from: q */
    private TextView f6238q;
    /* renamed from: r */
    private TextView f6239r;
    /* renamed from: s */
    private int f6240s = 0;
    /* renamed from: t */
    private int f6241t = 0;

    public C1954c(Context context, int dlgType) {
        super(context);
        this.f6240s = dlgType;
    }

    /* renamed from: b */
    protected void mo1529b() {
        super.mo1529b();
        this.f6238q = (TextView) findViewById(C0965R.id.first_btn);
        this.f6239r = (TextView) findViewById(C0965R.id.second_btn);
    }

    public void setNewAppSize(int size) {
        this.f6241t = size;
    }

    public void setDialogType(int type) {
        this.f6240s = type;
    }

    public int getDialogType() {
        return this.f6240s;
    }

    /* renamed from: i */
    public void mo1630i() {
        if (1001 == this.f6240s) {
            C1260i.m4435b(f6229e, "Dialog set: " + this.f6240s);
            m7462j();
        } else if (1002 == this.f6240s) {
            m7463k();
        } else if (1003 == this.f6240s) {
            m7464l();
        } else if (1004 == this.f6240s) {
            m7465m();
        } else if (1005 == this.f6240s) {
            m7466n();
        } else if (1006 == this.f6240s) {
            m7467o();
        } else if (1007 == this.f6240s) {
            m7468p();
        }
    }

    /* renamed from: j */
    public void m7462j() {
        m7442b((int) C0965R.string.carlife_update_tips_dialog_title);
        m7447c((int) C0965R.string.carlife_net_wait_wifi_download);
        m7444b("当前以为最新固件，无需下载更新");
        if (this.f6239r != null) {
            this.f6239r.setVisibility(8);
        }
    }

    /* renamed from: k */
    public void m7463k() {
        m7442b((int) C0965R.string.carlife_update_tips_dialog_title);
        m7447c((int) C0965R.string.alert_confirm);
        m7450d((int) C0965R.string.alert_cancel);
        long size = (long) this.f6241t;
        long modeK = size % 1048576;
        C1260i.m4435b(f6229e, "get firmware size: " + size + " | " + modeK);
        m7444b("检测到最新固件为(" + (size / 1048576) + "." + (((modeK / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + 99) / 100) + "M),请确认使用流量下载!");
        if (this.f6239r != null) {
            this.f6239r.setVisibility(0);
        }
    }

    /* renamed from: l */
    public void m7464l() {
        m7442b((int) C0965R.string.carlife_update_tips_dialog_title);
        m7447c((int) C0965R.string.alert_confirm);
        m7450d((int) C0965R.string.alert_cancel);
        long size = (long) this.f6241t;
        long modeK = size % 1048576;
        C1260i.m4435b(f6229e, "get firmware size: " + size + " | " + modeK);
        m7444b("检测到最新固件大小为(" + (size / 1048576) + "." + (((modeK / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + 99) / 100) + "M)请确认是否立即下载!");
        if (this.f6239r != null) {
            this.f6239r.setVisibility(0);
        }
    }

    /* renamed from: m */
    public void m7465m() {
        m7442b((int) C0965R.string.carlife_update_tips_dialog_title);
        m7447c((int) C0965R.string.alert_confirm);
        m7450d((int) C0965R.string.alert_cancel);
        m7444b("下载失败请重新下载");
        if (this.f6239r != null) {
            this.f6239r.setVisibility(8);
        }
    }

    /* renamed from: n */
    public void m7466n() {
        m7442b((int) C0965R.string.carlife_update_tips_dialog_title);
        m7447c((int) C0965R.string.alert_confirm);
        m7450d((int) C0965R.string.alert_cancel);
        m7444b("已成功下载固件，是否立即推送到车机端进行安装，在固件升级过程中，请不要断开连接，请靠边停车后进行安装.");
        if (this.f6239r != null) {
            this.f6239r.setVisibility(0);
        }
    }

    /* renamed from: o */
    public void m7467o() {
        m7442b((int) C0965R.string.carlife_update_tips_dialog_title);
        m7447c((int) C0965R.string.alert_confirm);
        m7444b("安装失败，请确认重新安装!");
        if (this.f6239r != null) {
            this.f6239r.setVisibility(8);
        }
    }

    /* renamed from: p */
    public void m7468p() {
        m7442b((int) C0965R.string.carlife_update_tips_dialog_title);
        m7447c((int) C0965R.string.alert_confirm);
        m7450d((int) C0965R.string.alert_cancel);
        m7444b("已升级成功.");
        if (this.f6239r != null) {
            this.f6239r.setVisibility(8);
        }
    }
}
