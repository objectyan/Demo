package com.baidu.navi.style;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LayoutAnimationController;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;

public class StyleManager {
    public static final String SUFFIX_DAY_MODEL = "";
    public static final String SUFFIX_NIGHT_MODEL = "_night";
    private static Context mAppContext = BaiduNaviApplication.getInstance();
    private static boolean mDayStyle = true;
    private static String mPackageName = BaiduNaviApplication.getInstance().getPackageName();
    private static boolean mRealDayStyle = true;
    private static SparseIntArray mResIdMap = new SparseIntArray();
    private static Resources mResources = BaiduNaviApplication.getInstance().getResources();

    public static void setDayStyle(boolean dayStyle) {
        mResIdMap.clear();
        mDayStyle = dayStyle;
        mRealDayStyle = dayStyle;
        if (!isUsingMapMode()) {
            mDayStyle = false;
        }
        BNStyleManager.setDayStyle(mDayStyle);
    }

    public static boolean isUsingMapMode() {
        if (BNSettingManager.getCurrentUsingMode() == 1) {
            return true;
        }
        return false;
    }

    public static void switchToCarMode() {
        BNStyleManager.switchToCarMode();
        mDayStyle = false;
    }

    public static void switchToMapMode() {
        if (mDayStyle != mRealDayStyle) {
            mDayStyle = mRealDayStyle;
        }
    }

    public static void clearCacheResId() {
        mResIdMap.clear();
    }

    public static boolean getDayStyle() {
        return mDayStyle;
    }

    public static boolean getRealDayStyle() {
        return mRealDayStyle;
    }

    private static String getSuffix(boolean isDay) {
        String suffix = "";
        if (isDay) {
            return suffix;
        }
        return "_night";
    }

    public static void setResource(Resources resources) {
        mResources = resources;
    }

    private static String getResourceNameById(int resId) {
        String name = "";
        if (mResources == null) {
            return name;
        }
        try {
            return mResources.getResourceEntryName(resId);
        } catch (NotFoundException e) {
            return "";
        }
    }

    public static Drawable getDrawable(int resId) {
        return getDrawable(resId, mDayStyle);
    }

    public static Drawable getDrawable(int resId, boolean dayStyle) {
        if (mResources == null) {
            return null;
        }
        if (!dayStyle) {
            int cacheResId = mResIdMap.get(resId, -1);
            if (cacheResId != -1) {
                resId = cacheResId;
            } else {
                int resIdInNight = mResources.getIdentifier(getResourceNameById(resId) + getSuffix(dayStyle), "drawable", mPackageName);
                if (resIdInNight != 0) {
                    mResIdMap.put(resId, resIdInNight);
                }
                if (resIdInNight != 0) {
                    resId = resIdInNight;
                }
            }
        }
        try {
            return mResources.getDrawable(resId);
        } catch (NotFoundException e) {
            return null;
        }
    }

    public static Drawable getRealDrawable(int resId) {
        return getDrawable(resId, mRealDayStyle);
    }

    public static int getDayColor(int resId) {
        if (mResources == null) {
            return 0;
        }
        try {
            return mResources.getColor(resId);
        } catch (NotFoundException e) {
            return 0;
        }
    }

    public static int getColor(int resId) {
        return getColor(resId, mDayStyle);
    }

    public static int getColor(int resId, boolean dayStyle) {
        if (mResources == null) {
            return 0;
        }
        if (!dayStyle) {
            int cacheResId = mResIdMap.get(resId, -1);
            if (cacheResId != -1) {
                resId = cacheResId;
            } else {
                int resIdInNight = mResources.getIdentifier(getResourceNameById(resId) + getSuffix(dayStyle), OVERLAY_KEY.SGEO_LEVEL_COLOR_LINE, mPackageName);
                if (resIdInNight != 0) {
                    mResIdMap.put(resId, resIdInNight);
                }
                if (resIdInNight != 0) {
                    resId = resIdInNight;
                }
            }
        }
        try {
            return mResources.getColor(resId);
        } catch (NotFoundException e) {
            return 0;
        }
    }

    public static String getString(int resId) {
        if (mResources == null) {
            return "";
        }
        String retStr = "";
        try {
            return mResources.getString(resId);
        } catch (NotFoundException e) {
            return "";
        }
    }

    public static String getString(int resId, Object... params) {
        if (mResources == null) {
            return "";
        }
        String retStr = "";
        String formatStr = "";
        try {
            formatStr = mResources.getString(resId);
        } catch (NotFoundException e) {
            formatStr = "";
        }
        if (formatStr.length() == 0 || formatStr == null) {
            return formatStr;
        }
        return String.format(formatStr, params);
    }

    public static int getDimension(int resId) {
        if (mResources == null) {
            return 0;
        }
        try {
            return (int) mResources.getDimension(resId);
        } catch (NotFoundException e) {
            return 0;
        }
    }

    public static String[] getStringArray(int resId) {
        if (mResources == null) {
            return null;
        }
        try {
            return mResources.getStringArray(resId);
        } catch (NotFoundException e) {
            return null;
        }
    }

    public static boolean getBoolean(int resId) {
        if (mResources == null) {
            return false;
        }
        try {
            return mResources.getBoolean(resId);
        } catch (NotFoundException e) {
            return false;
        }
    }

    public static Bitmap getBitmap(int resId) {
        if (mResources == null) {
            return null;
        }
        try {
            return BitmapFactory.decodeResource(mResources, resId);
        } catch (NotFoundException e) {
            return null;
        }
    }

    public static View inflate(int resId, ViewGroup viewGroup) {
        return LayoutInflater.from(mAppContext).inflate(resId, viewGroup);
    }

    public static Animation loadAnimation(int id) {
        return AnimationUtils.loadAnimation(mAppContext, id);
    }

    public static LayoutAnimationController loadLayoutAnimation(int id) {
        return AnimationUtils.loadLayoutAnimation(mAppContext, id);
    }

    public static Interpolator loadInterpolator(int id) {
        return AnimationUtils.loadInterpolator(mAppContext, id);
    }
}
