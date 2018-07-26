package com.baidu.navi.controller;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.net.Uri;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.navi.logic.AppPreferenceHelperConst;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;

public class DeskShortCutHelper {
    private static final String TAG = "DeckShortCut";
    private Context mContext;

    public DeskShortCutHelper(Context mContext) {
        this.mContext = mContext;
    }

    public void createHomeDeskShortCut() {
        if (!PreferenceHelper.getInstance(this.mContext).getBoolean(AppPreferenceHelperConst.HOME_SHOR_CUT, false)) {
            LogUtil.m15791e("coder", "------createShortCut--------");
            Intent shortcutIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            shortcutIntent.putExtra("duplicate", false);
            shortcutIntent.putExtra("android.intent.extra.shortcut.NAME", this.mContext.getString(C0965R.string.tip_home_short_cut));
            shortcutIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(this.mContext, C0965R.drawable.bnav_rp_icon_go_home));
            Intent intent = new Intent(PlatformConstants.BAIDU_NAVI_START_ACTIVITY_ACTION);
            intent.setData(Uri.parse("bdnavi://gohomebyshortcut"));
            shortcutIntent.putExtra("android.intent.extra.shortcut.INTENT", intent);
            this.mContext.sendBroadcast(shortcutIntent);
            PreferenceHelper.getInstance(this.mContext).putBoolean(AppPreferenceHelperConst.HOME_SHOR_CUT, true);
            LogUtil.m15791e(TAG, "@移动统计 @设置-设置家公司-添加一键回家");
        }
    }

    public void createCompDeskShortCut() {
        if (!PreferenceHelper.getInstance(this.mContext).getBoolean(AppPreferenceHelperConst.COMP_SHOR_CUT, false)) {
            LogUtil.m15791e("coder", "------createShortCut--------");
            Intent shortcutIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            shortcutIntent.putExtra("duplicate", false);
            shortcutIntent.putExtra("android.intent.extra.shortcut.NAME", this.mContext.getString(C0965R.string.tip_comp_short_cut));
            shortcutIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(this.mContext, C0965R.drawable.bnav_rp_icon_go_comp));
            Intent intent = new Intent(PlatformConstants.BAIDU_NAVI_START_ACTIVITY_ACTION);
            intent.setData(Uri.parse("bdnavi://gocompanybyshortcut"));
            shortcutIntent.putExtra("android.intent.extra.shortcut.INTENT", intent);
            this.mContext.sendBroadcast(shortcutIntent);
            PreferenceHelper.getInstance(this.mContext).putBoolean(AppPreferenceHelperConst.COMP_SHOR_CUT, true);
            LogUtil.m15791e(TAG, "@移动统计 @设置-设置家公司-添加一键回公司");
        }
    }

    public boolean checkHomeAdded() {
        if (PreferenceHelper.getInstance(this.mContext).getBoolean(AppPreferenceHelperConst.HOME_SHOR_CUT, false)) {
            return true;
        }
        return false;
    }

    public boolean checkCompAdded() {
        if (PreferenceHelper.getInstance(this.mContext).getBoolean(AppPreferenceHelperConst.COMP_SHOR_CUT, false)) {
            return true;
        }
        return false;
    }

    public void delHomeDeskShortCut() {
        Intent shortcut = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
        shortcut.putExtra("android.intent.extra.shortcut.NAME", this.mContext.getString(C0965R.string.tip_home_short_cut));
        Intent intent = new Intent(PlatformConstants.BAIDU_NAVI_START_ACTIVITY_ACTION);
        intent.setData(Uri.parse("bdnavi://gohomebyshortcut"));
        shortcut.putExtra("android.intent.extra.shortcut.INTENT", intent);
        this.mContext.sendBroadcast(shortcut);
        PreferenceHelper.getInstance(this.mContext).putBoolean(AppPreferenceHelperConst.HOME_SHOR_CUT, false);
    }

    public void delCompDeskShortCut() {
        Intent shortcut = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
        shortcut.putExtra("android.intent.extra.shortcut.NAME", this.mContext.getString(C0965R.string.tip_comp_short_cut));
        Intent intent = new Intent(PlatformConstants.BAIDU_NAVI_START_ACTIVITY_ACTION);
        intent.setData(Uri.parse("bdnavi://gocompanybyshortcut"));
        shortcut.putExtra("android.intent.extra.shortcut.INTENT", intent);
        this.mContext.sendBroadcast(shortcut);
        PreferenceHelper.getInstance(this.mContext).putBoolean(AppPreferenceHelperConst.COMP_SHOR_CUT, false);
    }
}
