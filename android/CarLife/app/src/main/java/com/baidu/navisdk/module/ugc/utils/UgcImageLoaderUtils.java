package com.baidu.navisdk.module.ugc.utils;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.navisdk.module.ugc.data.datarepository.IUgcDataParams;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions$Builder;
import com.baidu.navisdk.util.navimageloader.BNImageLoader;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;

public class UgcImageLoaderUtils {
    public boolean updateUgcViewOffline(int type, ImageView mView) {
        if (mView == null) {
            return false;
        }
        if (mView != null) {
            Drawable mDrawable = BNStyleManager.getDrawable(UgcDataProvider.getDrawableIdByType(type));
            if (mDrawable == null) {
                return false;
            }
            mView.setImageDrawable(mDrawable);
        }
        return true;
    }

    public void updateUgcViewOnLine(int type, ImageView mView, BNDisplayImageOptions mOptions, BNImageLoadingListener listener, String url) {
        if (mView != null) {
            if (mOptions == null) {
                mOptions = new BNDisplayImageOptions$Builder().showImageOnLoading(UgcDataProvider.getDrawableIdByType(type)).build();
            }
            if (url == null) {
                url = UgcDataProvider.getUrlByType(type);
            }
            if (TextUtils.isEmpty(url)) {
                updateUgcViewOffline(type, mView);
                if (listener != null) {
                    listener.onLoadingComplete(url, mView, null, 4);
                    return;
                }
                return;
            }
            BNImageLoader.getInstance().displayImage(url, mView, mOptions, listener);
        }
    }

    public void updateUgcViewOnLine(boolean isMainPage, int type, ImageView mView, BNDisplayImageOptions mOptions, BNImageLoadingListener listener, String url) {
        if (mView != null) {
            if (mOptions == null) {
                mOptions = new BNDisplayImageOptions$Builder().showImageOnLoading(UgcDataProvider.getDrawableIdByType(getMainCacheIconKey(type, isMainPage))).build();
            }
            if (url == null) {
                url = UgcDataProvider.getUrlByType(getMainCacheIconKey(type, isMainPage));
            }
            if (TextUtils.isEmpty(url)) {
                updateUgcViewOffline(getMainCacheIconKey(type, isMainPage), mView);
                if (listener != null) {
                    listener.onLoadingComplete(url, mView, null, 4);
                    return;
                }
                return;
            }
            BNImageLoader.getInstance().displayImage(url, mView, mOptions, listener);
        }
    }

    private int getMainCacheIconKey(int type, boolean isMainPage) {
        int localIocn = type;
        if (!isMainPage) {
            return localIocn;
        }
        switch (type) {
            case 4:
                return IUgcDataParams.TYPE_DEFAULT_MAP_MAIN_TRAFIC_JAM;
            case 5:
                return IUgcDataParams.TYPE_DEFAULT_MAP_MAIN_TRAFIC_ACCIDENT;
            case 6:
                return IUgcDataParams.TYPE_DEFAULT_MAP_MAIN_ROAD_BUILD;
            case 7:
                return IUgcDataParams.TYPE_DEFAULT_MAP_MAIN_ROAD_CLOSED;
            case 9:
                return IUgcDataParams.TYPE_DEFAULT_MAP_MAIN_POLICE;
            case 10:
                return IUgcDataParams.TYPE_DEFAULT_MAP_MAIN_DANGEROU;
            default:
                return localIocn;
        }
    }

    public void updateUgcViewOnLine(int type, ImageView mView) {
        updateUgcViewOnLine(type, mView, null, null, null);
    }

    public void updateUgcViewOnLine(boolean main, int type, ImageView mView) {
        updateUgcViewOnLine(main, type, mView, null, null, null);
    }

    public void updateUgcViewOnLine(int type, ImageView mView, BNDisplayImageOptions mOptions) {
        updateUgcViewOnLine(type, mView, mOptions, null, null);
    }

    public void updateUgcViewOnLine(int type, ImageView mView, BNImageLoadingListener listener) {
        updateUgcViewOnLine(type, mView, null, listener, null);
    }

    public void updateUgcViewOnLine(int type, ImageView mView, String url) {
        updateUgcViewOnLine(type, mView, null, null, url);
    }
}
