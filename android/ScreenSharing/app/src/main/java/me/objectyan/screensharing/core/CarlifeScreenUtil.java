package me.objectyan.screensharing.core;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;

import me.objectyan.screensharing.core.config.CarlifeConfig;
import me.objectyan.screensharing.core.connect.CarlifeCmdMessage;
import me.objectyan.screensharing.protobuf.CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.HashSet;
import java.util.Iterator;


public class CarlifeScreenUtil {
    private static final String Tag = "CarlifeScreenUtil";

    private static CarlifeScreenUtil sCarlifeScreenUtil = null;

    private static HashSet<String> sHashSet = new HashSet();

    private DisplayMetrics mDisplayMetrics;

    private float mDensity = 0.0f;

    private int mWidthPixels = 0;

    private int mHeightPixels = 0;

    private int mWindowWidthPixels = 0;

    private int mWindowHeightPixels = 0;

    private int mStatusBarHeight = 0;

    private int mDensityDpi = 0;

    private EnumRadio mEnumRadio = EnumRadio.W_16_H_9;

    private int f3465p = 0;

    private int f3466q = 0;

    public enum EnumRadio {
        W_16_H_9(1.7777777777777777d),
        W_8_H_3(2.6666666666666665d);


        double mCurrRadio;


        public double getCurrRadio() {
            return this.mCurrRadio;
        }

        private EnumRadio(double radio) {
            this.mCurrRadio = radio;
        }
    }

    public static CarlifeScreenUtil newInstance() {
        if (sCarlifeScreenUtil == null) {
            synchronized (CarlifeScreenUtil.class) {
                if (sCarlifeScreenUtil == null) {
                    sCarlifeScreenUtil = new CarlifeScreenUtil();
                }
            }
        }
        return sCarlifeScreenUtil;
    }


    public EnumRadio getCurrRadio() {
        return this.mEnumRadio;
    }


    public void initScreenInfo(Activity activity) {
        if (activity != null) {
            this.mDisplayMetrics = activity.getResources().getDisplayMetrics();
            this.mDensity = this.mDisplayMetrics.density;
            this.mWidthPixels = Math.max(this.mDisplayMetrics.widthPixels, this.mDisplayMetrics.heightPixels);
            this.mHeightPixels = Math.min(this.mDisplayMetrics.widthPixels, this.mDisplayMetrics.heightPixels);
            if (VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Display display = activity.getWindowManager().getDefaultDisplay();
                Point point = new Point();
                display.getRealSize(point);
                this.mWindowWidthPixels = Math.max(point.x, point.y);
                this.mWindowHeightPixels = Math.min(point.x, point.y);
            } else {
                this.mWindowWidthPixels = this.mWidthPixels;
                this.mWindowHeightPixels = this.mHeightPixels;
            }
            this.mStatusBarHeight = getStatusBarHeight(activity);
            try {
                if (VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                    this.mDensityDpi = this.mDisplayMetrics.densityDpi;
                } else {
                    this.mDensityDpi = 160;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (this.mDensityDpi == 0) {
                this.mDensityDpi = 160;
            }
            this.f3465p = this.mWidthPixels;
            this.f3466q = this.mHeightPixels;
            Log.v(Tag, "mDensity = " + this.mDensity);
            Log.v(Tag, "mWidthPixels = " + this.mWidthPixels + ", mHeightPixels = " + this.mHeightPixels);
            Log.v(Tag, "mWindowWidthPixels = " + this.mWindowWidthPixels + ", mWindowHeightPixels = " + this.mWindowHeightPixels);
            Log.v(Tag, "mStatusBarHeight = " + this.mStatusBarHeight);
            Log.v(Tag, "mDensityDpi = " + this.mDensityDpi);
        }
    }


    public DisplayMetrics getDisplayMetrics() {
        return this.mDisplayMetrics;
    }


    public void initInfoForVideoEncoder(Message message) {
        try {
            CarlifeVideoEncoderInfo initInfo = CarlifeVideoEncoderInfo.parseFrom(((CarlifeCmdMessage) message.obj).getData());
            int width = initInfo.getWidth();
            int height = initInfo.getHeight();
            Log.d(Tag, "####### MSG_CMD_VIDEO_ENCODER_INIT:[ " + width + " : " + height + "]");
            if (((double) width) / ((double) height) >= 2.3d) {
                this.mEnumRadio = EnumRadio.W_8_H_3;
                Log.d(Tag, "####### W_8_H_3 : " + this.mEnumRadio);
                return;
            }
            this.mEnumRadio = EnumRadio.W_16_H_9;
            Log.d(Tag, "####### W_16_H_9 : " + this.mEnumRadio);
        } catch (InvalidProtocolBufferException e) {
            Log.e(Tag, "Get VIDEO_ENCODER_INIT_INFO Error");
            e.printStackTrace();
        }
    }


    public int m4345d() {
        return this.f3465p;
    }


    public int m4348e() {
        return this.f3466q;
    }


    public void m4349f() {
        this.mEnumRadio = EnumRadio.W_16_H_9;
    }


    public int getDensityDpi() {
        return this.mDensityDpi;
    }


    public int getWidthPixels() {
        return this.mWidthPixels;
    }


    public void setWidthPixels(int mWidthPixels) {
        this.mWidthPixels = mWidthPixels;
    }


    public void setHeightPixels(int mHeightPixels) {
        this.mHeightPixels = mHeightPixels;
    }


    public int getHeightPixels() {
        return this.mHeightPixels;
    }


    public int getStatusBarHeight() {
        return this.mStatusBarHeight;
    }


    public int getWindowWidthPixels() {
        return this.mWindowWidthPixels;
    }


    public int getWindowHeightPixels() {
        return this.mWindowHeightPixels;
    }


    public int m4335a(float dip) {
        return (int) (0.5f + (this.mDensity * dip));
    }


    public int m4343c(int dip) {
        return (int) (0.5f + (this.mDensity * ((float) dip)));
    }


    public int m4347d(int px) {
        return (int) (0.5f + (((float) px) / this.mDensity));
    }


    public int m4339b(float px) {
        return (int) (0.5f + (px / this.mDensity));
    }


    public int m4342c(float percent) {
        return (int) (((float) getHeightPixels()) * percent);
    }

    public int m4346d(float percent) {
        return (int) (((float) getWidthPixels()) * percent);
    }

    private int getStatusBarHeight(Activity activity) {
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


    public static boolean isVehicleSupportScreenAdapt() {
        if (CarlifeScreenUtil.newInstance().getCurrRadio() == EnumRadio.W_16_H_9 || !CarlifeConfig.isSupportInternalScreen()) {
            return false;
        }
        String channel = CommonParams.sVehicleChannel.getChannel();
        Log.d(Tag, "####### isVehicleSupportScreenAdapt: " + channel);
        if (channel != null) {
            if (CommonParams.sVehicleChannel == CommonParams.EnumVehicleChannel.VEHICLE_CHANNEL_YUANFENG_ELH_ONLINE
                    || CommonParams.sVehicleChannel == CommonParams.EnumVehicleChannel.VEHICLE_CHANNEL_YUANFENG_ELH_PCBA
                    || channel.equals("20882101") || channel.equals("20882100")) {
                Log.d(Tag, "####### isVehicleSupportScreenAdapt: true");
                return true;
            }
            Iterator iter = sHashSet.iterator();
            while (iter.hasNext()) {
                String value = (String) iter.next();
                if (value.equals(channel)) {
                    Log.d(Tag, "Server channel support ScreenAdapt: " + value);
                    return true;
                }
            }
        }
        Log.d(Tag, "####### isVehicleSupportScreenAdapt: not sport");
        return false;
    }


    public static void addScreenAdaptChannel(String strChannel) {
        Log.d(Tag, "####### addScreenAdaptChannel: " + strChannel);
        sHashSet.add(strChannel);
    }
}
