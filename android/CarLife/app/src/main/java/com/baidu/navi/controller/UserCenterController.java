package com.baidu.navi.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.baidu.navi.logic.AppCommandConst;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.ShareTools;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.trajectory.MileageInfo;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.modelfactory.FavoriteModel;
import com.baidu.navisdk.util.common.HttpUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.tencent.qplayauto.device.QPlayAutoJNI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class UserCenterController implements AppCommandConst {
    private static final int K_TIMEOUT = 100000;
    private int mFavCount;
    private String mMileageRank;
    private ShareTools mShareTool;
    private int mTrackCount;
    private int mUnReadNewsCount;
    private boolean mUpdate;

    private static class LazyHolder {
        private static UserCenterController sInstance = new UserCenterController();

        private LazyHolder() {
        }
    }

    private UserCenterController() {
        this.mMileageRank = "";
        this.mTrackCount = 0;
        this.mFavCount = 0;
        this.mUpdate = false;
        this.mUnReadNewsCount = 0;
        this.mShareTool = null;
    }

    public static UserCenterController getInstance() {
        return LazyHolder.sInstance;
    }

    public boolean isOfflineDataUpdate() {
        return BNOfflineDataManager.getInstance().isNewUpdateData();
    }

    public int getFavCount() {
        int count = FavoriteModel.getInstance().getFavCount();
        if (count != 0) {
            return count;
        }
        count = BNFavoriteManager.getInstance().getAllFavPoiCnt();
        FavoriteModel.getInstance().setFavCount(count);
        return count;
    }

    public int getTrackCount() {
        String uid = "";
        String bduss = "";
        if (NaviAccountUtils.getInstance().isLogin()) {
            uid = NaviAccountUtils.getInstance().getUid();
            bduss = NaviAccountUtils.getInstance().syncGetBduss();
        }
        return JNITrajectoryControl.sInstance.getTrajectoryCnt(bduss, uid);
    }

    public void setUnReadNewsSum(int count) {
        this.mUnReadNewsCount = count;
    }

    public int getUnReadNewsSum() {
        return this.mUnReadNewsCount;
    }

    public void setMileageRank(String rank) {
        this.mMileageRank = rank;
    }

    public String getMileageRank() {
        return this.mMileageRank;
    }

    public void resetMileageRank() {
        this.mMileageRank = "";
    }

    public String produceUsercenteHeadUrl() {
        String url = "http://usercenter.navi.baidu.com/usercenter/view";
        int cityId = GeoLocateModel.getInstance().getCurrentDistrict().mId;
        String bduss = "";
        if (NaviAccountUtils.getInstance().isLogin()) {
            bduss = NaviAccountUtils.getInstance().syncGetBduss();
        } else {
            bduss = QPlayAutoJNI.SONG_LIST_ROOT_ID;
        }
        List<NameValuePair> params = new ArrayList();
        params.add(new BasicNameValuePair("bduss", bduss));
        params.add(new BasicNameValuePair("cityID", String.valueOf(cityId)));
        return url + "?bduss=" + bduss + "&cityID=" + String.valueOf(cityId) + "&sign=" + HttpUtils.calcUrlSign(params);
    }

    public void startGetUserData(Handler handler) {
        if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()) || !NaviAccountUtils.getInstance().isLogin()) {
            this.mMileageRank = "";
        }
    }

    public void cancelGetUserData(String tag) {
    }

    public String getUserName() {
        if (NaviAccountUtils.getInstance().isLogin()) {
            return NaviAccountUtils.getInstance().getUserName();
        }
        return null;
    }

    public void setDataUpdate(Handler handler) {
    }

    public boolean hasNewNews() {
        return this.mUnReadNewsCount != 0 || BNOfflineDataManager.getInstance().isNewUpdateData();
    }

    public void startUpdateUserInfo(int isLogin, Handler handler) {
    }

    public int getTotalNoSyncMileage(ArrayList<MileageInfo> mileageList) {
        int totalMileage = 0;
        if (mileageList == null || mileageList.size() == 0) {
            return 0;
        }
        Iterator<MileageInfo> iterator = mileageList.iterator();
        while (iterator.hasNext()) {
            totalMileage += ((MileageInfo) iterator.next()).mDistance;
        }
        return totalMileage;
    }

    public String getMileageDecritpion() {
        return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getString(AppCommandConst.SP_MILEAGE_DESCRIPTION_TEXT, "");
    }

    public void setMileageDecription(String description) {
        PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putString(AppCommandConst.SP_MILEAGE_DESCRIPTION_TEXT, description);
    }

    public int getUserMileageValue() {
        return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt(AppCommandConst.SP_MILEAGE_TEXT, 0);
    }

    public void setUserMileageValue(int mileage) {
        PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putInt(AppCommandConst.SP_MILEAGE_TEXT, mileage);
    }

    public int getUserScoreValue() {
        return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt(AppCommandConst.SP_SCORE_TEXT, 0);
    }

    public void setUserScoreValue(int score) {
        PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putInt(AppCommandConst.SP_SCORE_TEXT, score);
    }

    public String getScoreShopAddr() {
        return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getString(AppCommandConst.SCORE_SHOP_ADDR, "");
    }

    public void setScoreShopAddr(String addr) {
        PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putString(AppCommandConst.SCORE_SHOP_ADDR, addr);
    }

    public String getUserScoreText(int score) {
        String scoreText = AppCommandConst.SP_DEFAULT_SCORE_TEXT;
        return String.valueOf(score) + "分";
    }

    public String getUserMileageText(int mileage) {
        String mileageText = AppCommandConst.SP_DEFAULT_MILEAGE_TEXT;
        return String.valueOf(mileage) + "km";
    }

    public void setShareTools(ShareTools tool) {
        this.mShareTool = tool;
    }

    public void handleSinaCallback(Context context, int requestCode, int resultCode, Intent data) {
        if (this.mShareTool == null) {
            this.mShareTool = new ShareTools(context, 9);
        }
        this.mShareTool.onSinaAuthorizeCallback(requestCode, resultCode, data);
    }
}
