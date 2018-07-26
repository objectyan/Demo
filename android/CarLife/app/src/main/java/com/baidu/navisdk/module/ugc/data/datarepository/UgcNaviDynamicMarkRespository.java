package com.baidu.navisdk.module.ugc.data.datarepository;

import android.graphics.drawable.Drawable;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class UgcNaviDynamicMarkRespository {
    private static UgcNaviDynamicMarkRespository instance = null;
    public boolean gotoSupDetailPageFlag = false;
    private ArrayList<NaviDynamicMark> list = null;
    private OnTapListener mOnTapListener = null;
    private ArrayList<NaviDynamicMark> upLoadingList = null;

    public static class NaviDynamicMark {
        public Drawable drawable;
        public int id;
        public GeoPoint mGeoPoint;
        public int type;
        /* renamed from: x */
        public double f19709x;
        /* renamed from: y */
        public double f19710y;
    }

    public interface OnTapListener {
        void onTap(int i);
    }

    private UgcNaviDynamicMarkRespository() {
    }

    public static UgcNaviDynamicMarkRespository getInstance() {
        if (instance == null) {
            instance = new UgcNaviDynamicMarkRespository();
        }
        return instance;
    }

    public void clear() {
        if (this.list != null) {
            this.list.clear();
            this.list = null;
        }
        if (this.upLoadingList != null) {
            this.upLoadingList.clear();
            this.upLoadingList = null;
        }
    }

    public void addUgcReportInfoUploadPackage(UgcReportInfoUploadPackage mPackage) {
        if (mPackage != null && mPackage.id != -1 && mPackage.userPoint != null) {
            NaviDynamicMark mNaviDynamicMark = new NaviDynamicMark();
            int i = mPackage.userPoint.indexOf(",");
            if (i > 0 && i < mPackage.userPoint.length() - 1) {
                String xStr = mPackage.userPoint.substring(0, i);
                String yStr = mPackage.userPoint.substring(i + 1, mPackage.userPoint.length());
                try {
                    mNaviDynamicMark.f19709x = Double.parseDouble(xStr);
                    mNaviDynamicMark.f19710y = Double.parseDouble(yStr);
                } catch (Exception e) {
                }
                mNaviDynamicMark.id = mPackage.id;
                mNaviDynamicMark.type = mPackage.parentType;
                mNaviDynamicMark.mGeoPoint = mPackage.mGeoPoint;
                Drawable mDrawable = BNStyleManager.getDrawable(UgcDataProvider.getDrawableIdByType(mPackage.parentType));
                if (mDrawable != null) {
                    mNaviDynamicMark.drawable = mDrawable;
                    if (this.list == null) {
                        this.list = new ArrayList();
                    }
                    this.list.add(mNaviDynamicMark);
                }
            }
        }
    }

    public ArrayList<NaviDynamicMark> getInfoPackageList() {
        return this.list;
    }

    public OnTapListener getOnTapListener() {
        return this.mOnTapListener;
    }

    public void setOnTapListener(OnTapListener mOnTapListener) {
        this.mOnTapListener = mOnTapListener;
    }

    public boolean hasContainUgcDynamicMark() {
        if (this.list == null || this.list.size() <= 0) {
            return false;
        }
        return true;
    }

    public NaviDynamicMark getNaviDynamicMarkById(int id) {
        if (this.list != null) {
            for (int i = 0; i < this.list.size(); i++) {
                if (((NaviDynamicMark) this.list.get(i)).id == id) {
                    return (NaviDynamicMark) this.list.get(i);
                }
            }
        }
        return null;
    }

    public void removeId(int id) {
        NaviDynamicMark mNaviDynamicMark = getNaviDynamicMarkById(id);
        if (mNaviDynamicMark != null) {
            this.list.remove(mNaviDynamicMark);
        }
    }

    public void addUploadingDynamicMark(NaviDynamicMark mNaviDynamicMark) {
        if (this.upLoadingList == null) {
            this.upLoadingList = new ArrayList();
        }
        if (mNaviDynamicMark != null) {
            this.upLoadingList.add(mNaviDynamicMark);
        }
    }

    public void removeUploadingId(int id) {
        if (this.upLoadingList != null) {
            for (int i = 0; i < this.upLoadingList.size(); i++) {
                if (((NaviDynamicMark) this.upLoadingList.get(i)).id == id) {
                    this.upLoadingList.remove(i);
                }
            }
        }
    }

    public boolean containLoadingId(int id) {
        if (this.upLoadingList != null) {
            for (int i = 0; i < this.upLoadingList.size(); i++) {
                if (((NaviDynamicMark) this.upLoadingList.get(i)).id == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getNaviDynamicMarkCounts() {
        if (this.list != null) {
            return this.list.size();
        }
        return 0;
    }
}
