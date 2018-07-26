package com.baidu.navi.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.view.inputmethod.InputMethodManager;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.navisdk.ui.util.TipTool;
import java.io.InputStream;

public class Tools {
    public static Bitmap getBitmapFromByteArray(byte[] data) {
        try {
            return BitmapFactory.decodeByteArray(data, 0, data.length);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public static Bitmap getBitmapFromPath(String path) {
        try {
            return BitmapFactory.decodeFile(path);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public static Bitmap getBitmapFromResId(int resId) {
        try {
            return BitmapFactory.decodeResource(BaiduNaviApplication.getInstance().getResources(), resId);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public static Bitmap getBitmapFromStream(InputStream stream) {
        Bitmap bmp;
        try {
            bmp = BitmapFactory.decodeStream(stream);
            try {
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (OutOfMemoryError e2) {
            bmp = null;
            try {
                stream.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                stream.close();
            } catch (Exception e32) {
                e32.printStackTrace();
            }
            throw th;
        }
        return bmp;
    }

    public static Rect calcSquareRect(Rect r) {
        int w = r.right - r.left;
        int h = r.bottom - r.top;
        int s = Math.min(w, h);
        int horiMargin = (w - s) / 2;
        int vertMargin = (h - s) / 2;
        if (horiMargin == 0) {
            r.top += vertMargin;
            r.bottom -= vertMargin;
        } else {
            r.left += horiMargin;
            r.right -= horiMargin;
        }
        return r;
    }

    public static String getRealUrl(String url) {
        return "https://vehicle.baidu.com" + url;
    }

    public static void softInputHide(Activity mActivity, Context mContext) {
        try {
            InputMethodManager imm = (InputMethodManager) mActivity.getSystemService("input_method");
            if (imm != null) {
                imm.hideSoftInputFromWindow(mActivity.getWindow().getDecorView().getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void goMarket() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + BaiduNaviApplication.getInstance().getPackageName()));
        intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        try {
            BaiduNaviApplication.getInstance().startActivity(intent);
        } catch (Exception e) {
            TipTool.onCreateToastDialog(BaiduNaviApplication.getInstance(), "您还没有安装google play，请先安装google play。");
            e.printStackTrace();
        }
    }
}
