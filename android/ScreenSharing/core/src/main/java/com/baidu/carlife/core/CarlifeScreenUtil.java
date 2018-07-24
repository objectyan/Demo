package com.baidu.carlife.core;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;

import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.config.CarlifeConfig;
import com.baidu.carlife.protobuf.CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.HashSet;
import java.util.Iterator;

/* compiled from: CarlifeScreenUtil */
/* renamed from: com.baidu.carlife.core.d */
public class CarlifeScreenUtil implements KeepClass {
    /* renamed from: a */
    public static final int f3450a = 160;
    /* renamed from: b */
    public static final int f3451b = 640;
    /* renamed from: c */
    private static final double f3452c = 2.6666666666666665d;
    /* renamed from: d */
    private static final String f3453d = "CarlifeScreenUtil";
    /* renamed from: e */
    private static CarlifeScreenUtil f3454e = null;
    /* renamed from: f */
    private static HashSet<String> f3455f = new HashSet();
    /* renamed from: g */
    private DisplayMetrics f3456g;
    /* renamed from: h */
    private float f3457h = 0.0f;
    /* renamed from: i */
    private int f3458i = 0;
    /* renamed from: j */
    private int f3459j = 0;
    /* renamed from: k */
    private int f3460k = 0;
    /* renamed from: l */
    private int f3461l = 0;
    /* renamed from: m */
    private int f3462m = 0;
    /* renamed from: n */
    private int f3463n = 0;
    /* renamed from: o */
    private C1248a f3464o = C1248a.W_16_H_9;
    /* renamed from: p */
    private int f3465p = 0;
    /* renamed from: q */
    private int f3466q = 0;

    /* compiled from: CarlifeScreenUtil */
    /* renamed from: com.baidu.carlife.core.d$a */
    public enum C1248a {
        W_16_H_9(1.7777777777777777d),
        W_8_H_3(CarlifeScreenUtil.f3452c);

        /* renamed from: c */
        double f3449c;

        /* renamed from: a */
        public double m4330a() {
            return this.f3449c;
        }

        private C1248a(double radio) {
            this.f3449c = radio;
        }
    }

    private CarlifeScreenUtil() {
    }

    /* renamed from: a */
    public static CarlifeScreenUtil m4331a() {
        if (f3454e == null) {
            synchronized (CarlifeScreenUtil.class) {
                if (f3454e == null) {
                    f3454e = new CarlifeScreenUtil();
                }
            }
        }
        return f3454e;
    }

    /* renamed from: b */
    public C1248a m4340b() {
        return this.f3464o;
    }

    /* renamed from: a */
    public void m4337a(Activity activity) {
        if (activity != null) {
            this.f3456g = activity.getResources().getDisplayMetrics();
            this.f3457h = this.f3456g.density;
            this.f3458i = Math.max(this.f3456g.widthPixels, this.f3456g.heightPixels);
            this.f3459j = Math.min(this.f3456g.widthPixels, this.f3456g.heightPixels);
            if (VERSION.SDK_INT >= 17) {
                Display display = activity.getWindowManager().getDefaultDisplay();
                Point point = new Point();
                display.getRealSize(point);
                this.f3460k = Math.max(point.x, point.y);
                this.f3461l = Math.min(point.x, point.y);
            } else {
                this.f3460k = this.f3458i;
                this.f3461l = this.f3459j;
            }
            this.f3462m = m4333b(activity);
            try {
                if (Integer.parseInt(VERSION.SDK) > 3) {
                    this.f3463n = this.f3456g.densityDpi;
                } else {
                    this.f3463n = 160;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (this.f3463n == 0) {
                this.f3463n = 160;
            }
            this.f3465p = this.f3458i;
            this.f3466q = this.f3459j;
            LogUtil.m4429a(f3453d, "mDensity = " + this.f3457h);
            LogUtil.m4429a(f3453d, "mWidthPixels = " + this.f3458i + ", mHeightPixels = " + this.f3459j);
            LogUtil.m4429a(f3453d, "mWindowWidthPixels = " + this.f3460k + ", mWindowHeightPixels = " + this.f3461l);
            LogUtil.m4429a(f3453d, "mStatusBarHeight = " + this.f3462m);
            LogUtil.m4429a(f3453d, "mDensityDpi = " + this.f3463n);
        }
    }

    /* renamed from: c */
    public DisplayMetrics m4344c() {
        return this.f3456g;
    }

    /* renamed from: a */
    public void m4338a(Message message) {
        try {
            CarlifeVideoEncoderInfo initInfo = CarlifeVideoEncoderInfo.parseFrom(message.obj.m4205f());
            int width = initInfo.getWidth();
            int height = initInfo.getHeight();
            LogUtil.d(f3453d, "####### MSG_CMD_VIDEO_ENCODER_INIT:[ " + width + " : " + height + "]");
            if (((double) width) / ((double) height) >= 2.3d) {
                this.f3464o = C1248a.W_8_H_3;
                LogUtil.d(f3453d, "####### W_8_H_3 : " + this.f3464o);
                return;
            }
            this.f3464o = C1248a.W_16_H_9;
            LogUtil.d(f3453d, "####### W_16_H_9 : " + this.f3464o);
        } catch (InvalidProtocolBufferException e) {
            LogUtil.m4445e(f3453d, "Get VIDEO_ENCODER_INIT_INFO Error");
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public int m4345d() {
        return this.f3465p;
    }

    /* renamed from: e */
    public int m4348e() {
        return this.f3466q;
    }

    /* renamed from: f */
    public void m4349f() {
        this.f3464o = C1248a.W_16_H_9;
    }

    /* renamed from: g */
    public int m4350g() {
        return this.f3463n;
    }

    /* renamed from: h */
    public int m4351h() {
        return this.f3458i;
    }

    /* renamed from: a */
    public void m4336a(int mWidthPixels) {
        this.f3458i = mWidthPixels;
    }

    /* renamed from: b */
    public void m4341b(int mHeightPixels) {
        this.f3459j = mHeightPixels;
    }

    /* renamed from: i */
    public int m4352i() {
        return this.f3459j;
    }

    /* renamed from: j */
    public int m4353j() {
        return this.f3462m;
    }

    /* renamed from: k */
    public int m4354k() {
        return this.f3460k;
    }

    /* renamed from: l */
    public int m4355l() {
        return this.f3461l;
    }

    /* renamed from: a */
    public int m4335a(float dip) {
        return (int) (0.5f + (this.f3457h * dip));
    }

    /* renamed from: c */
    public int m4343c(int dip) {
        return (int) (0.5f + (this.f3457h * ((float) dip)));
    }

    /* renamed from: d */
    public int m4347d(int px) {
        return (int) (0.5f + (((float) px) / this.f3457h));
    }

    /* renamed from: b */
    public int m4339b(float px) {
        return (int) (0.5f + (px / this.f3457h));
    }

    /* renamed from: c */
    public int m4342c(float percent) {
        return (int) (((float) m4352i()) * percent);
    }

    /* renamed from: d */
    public int m4346d(float percent) {
        return (int) (((float) m4351h()) * percent);
    }

    /* renamed from: b */
    private int m4333b(Activity activity) {
        if (activity == null) {
            return 0;
        }
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            return activity.getResources().getDimensionPixelSize(Integer.parseInt(c.getField("status_bar_height").get(c.newInstance()).toString()));
        } catch (Exception e) {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect.top;
        }
    }

    /* renamed from: m */
    public static boolean m4334m() {
        if (CarlifeScreenUtil.m4331a().m4340b() == C1248a.W_16_H_9 || !CarlifeConfig.m4065a()) {
            return false;
        }
        String channel = CommonParams.sVehicleChannel.getChannel();
        LogUtil.d(f3453d, "####### isVehicleSupportScreenAdapt: " + channel);
        if (channel != null) {
            if (CommonParams.sVehicleChannel == CommonParams.VEHICLE_CHANNEL_YUANFENG_ELH_ONLINE || CommonParams.sVehicleChannel == EnumVehicleChannel.VEHICLE_CHANNEL_YUANFENG_ELH_PCBA || channel.equals("20882101") || channel.equals("20882100")) {
                LogUtil.d(f3453d, "####### isVehicleSupportScreenAdapt: true");
                return true;
            }
            Iterator iter = f3455f.iterator();
            while (iter.hasNext()) {
                String value = (String) iter.next();
                if (value.equals(channel)) {
                    LogUtil.d(f3453d, "Server channel support ScreenAdapt: " + value);
                    return true;
                }
            }
        }
        LogUtil.d(f3453d, "####### isVehicleSupportScreenAdapt: not sport");
        return false;
    }

    /* renamed from: a */
    public static void m4332a(String strChannel) {
        LogUtil.d(f3453d, "####### addScreenAdaptChannel: " + strChannel);
        f3455f.add(strChannel);
    }
}
