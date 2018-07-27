package me.objectyan.screensharing.core.config;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;

import me.objectyan.screensharing.core.CarlifeUtil;
import me.objectyan.screensharing.core.CommonParams;

import me.objectyan.screensharing.core.connect.ConnectClient;

import java.util.ArrayList;
import java.util.List;


public class CarlifeConfig {

    public static final boolean isLollipop;

    public static final boolean f3156b = false;

    public static boolean sNotSupportInternalScreen = false;

    private static List<ChannelItem> sChannelItems = new ArrayList();


    public static class ChannelItem {

        public String mChannel;

        public String f3154b;
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            z = true;
        } else {
            z = false;
        }
        isLollipop = z;
    }


    public static void setNotSupportInternalScreen(boolean notSupportInternalScreen) {
        sNotSupportInternalScreen = notSupportInternalScreen;
    }


    public static boolean isSupportInternalScreen() {
        if (!isLollipop || sNotSupportInternalScreen) {
            return false;
        }
        return true;
    }


    public static void addChannel(ChannelItem channel) {
        sChannelItems.add(channel);
    }


    public static void clearChannel() {
        sChannelItems.clear();
    }


    public static boolean m4067c() {
        String channel = CommonParams.sVehicleChannel.getChannel();
        boolean isWechatEnable = false;
        for (ChannelItem wechatChannel : sChannelItems) {
            if (TextUtils.equals(channel, wechatChannel.mChannel)) {
                isWechatEnable = true;
                break;
            }
        }
        return CarlifeUtil.newInstance().isConnected() && ConnectClient.newInstance().getIS() && isWechatEnable;
    }


    public static String m4068d() {
        String channel = CommonParams.sVehicleChannel.getChannel();
        for (ChannelItem wechatChannel : sChannelItems) {
            if (TextUtils.equals(channel, wechatChannel.mChannel)) {
                return wechatChannel.f3154b;
            }
        }
        return "";
    }
}
