package com.baidu.navisdk.module.ugc.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.module.ugc.dialog.PicChooseDialog;
import com.baidu.navisdk.module.ugc.dialog.PicChooseDialog.PicProcessCallBack;
import com.baidu.navisdk.module.ugc.dialog.UgcSoundsRecordDialog;
import com.baidu.navisdk.module.ugc.dialog.UgcSoundsRecordDialog.OnUgcSoundsRecordCallback;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils;
import com.baidu.navisdk.module.ugc.ui.SubContentContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.SubContentContract.View;
import com.baidu.navisdk.module.ugc.ui.inmap.sub.UgcReportMapSubDetailPresenter;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter;
import com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailContract;
import com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailView;
import com.baidu.navisdk.module.ugc.ui.naviresult.UgcRportNaviResultPresenter;
import com.baidu.navisdk.module.ugc.utils.PhotoProcessUtils.PicProcessResInfo;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public abstract class SubContentPrensenter implements Presenter {
    protected UgcReportInfoUploadPackage infoPackage;
    private boolean isFromNavi = false;
    private Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1003:
                    if (msg.arg1 == 0) {
                        SearchPoi poi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getAntiGeoPoi();
                        if (poi != null && poi.mAddress.length() > 0 && SubContentPrensenter.this.mRootView != null && SubContentPrensenter.this.infoPackage != null && poi.mGuidePoint != null && poi.mAddress != null) {
                            if (TextUtils.isEmpty(SubContentPrensenter.this.infoPackage.point) || TextUtils.isEmpty(SubContentPrensenter.this.infoPackage.name)) {
                                Bundle mBundle = CoordinateTransformUtil.LLE62MC(poi.mGuidePoint.getLongitudeE6(), poi.mGuidePoint.getLatitudeE6());
                                int ptx = mBundle.getInt("MCx");
                                int pty = mBundle.getInt("MCy");
                                if (SubContentPrensenter.this.infoPackage.point == null) {
                                    SubContentPrensenter.this.infoPackage.point = mBundle.getInt("MCx") + "," + mBundle.getInt("MCy");
                                }
                                if (SubContentPrensenter.this.infoPackage.userPoint == null) {
                                    SubContentPrensenter.this.infoPackage.userPoint = SubContentPrensenter.this.infoPackage.point;
                                }
                                SubContentPrensenter.this.infoPackage.name = poi.mAddress;
                                SubContentPrensenter.this.informRubPointAdsorb(SubContentPrensenter.this.infoPackage.point, poi.mAddress);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private PicProcessCallBack mPicProcessLinsener = new C41991();
    private View mRootView;
    private UgcLayout mUgcLayout;
    private PicChooseDialog picChooseDialog = null;
    private UgcSoundsRecordDialog soundsDialog = null;

    /* renamed from: com.baidu.navisdk.module.ugc.ui.SubContentPrensenter$1 */
    class C41991 implements PicProcessCallBack {
        C41991() {
        }

        public void onSuccess(PicProcessResInfo mPicProcessResInfo) {
            if (SubContentPrensenter.this.mRootView != null && mPicProcessResInfo != null) {
                SubContentPrensenter.this.mRootView.showPhotoBitmap(mPicProcessResInfo.bitmap);
                if (SubContentPrensenter.this.infoPackage != null) {
                    SubContentPrensenter.this.infoPackage.photoPicPath = mPicProcessResInfo.filePath;
                    SubContentPrensenter.this.infoPackage.photoPoint = new UgcHttpsUtils().getCurrentLocationPoint();
                }
                if (UgcReportNaviMainPresenter.statusPackage != null && SubContentPrensenter.this.isFromNavi) {
                    UgcReportNaviMainPresenter.statusPackage.photoPicPath = SubContentPrensenter.this.infoPackage.photoPicPath;
                    UgcReportNaviMainPresenter.statusPackage.photoPoint = SubContentPrensenter.this.infoPackage.photoPoint;
                }
                SubContentPrensenter.this.dimissPicDialog();
                SubContentPrensenter.this.upLoadBtnStatusChange();
            }
        }

        public void onFail(String str) {
            SubContentPrensenter.this.dimissPicDialog();
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.SubContentPrensenter$2 */
    class C42002 implements OnCancelListener {
        C42002() {
        }

        public void onCancel(DialogInterface dialog) {
            if (SubContentPrensenter.this.picChooseDialog != null) {
                SubContentPrensenter.this.picChooseDialog.dismiss();
                SubContentPrensenter.this.picChooseDialog = null;
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.SubContentPrensenter$3 */
    class C42013 implements OnUgcSoundsRecordCallback {
        C42013() {
        }

        public void onRecordFinish(int recordTime, String filePath, boolean isSucess) {
            if (isSucess && recordTime >= 1) {
                SubContentPrensenter.this.mRootView.showRecordResult(recordTime);
            }
            if (SubContentPrensenter.this.infoPackage != null) {
                SubContentPrensenter.this.infoPackage.voicePath = filePath;
                SubContentPrensenter.this.infoPackage.recordTime = recordTime;
            }
            if (UgcReportNaviMainPresenter.statusPackage != null && SubContentPrensenter.this.isFromNavi) {
                UgcReportNaviMainPresenter.statusPackage.voicePath = SubContentPrensenter.this.infoPackage.voicePath;
                UgcReportNaviMainPresenter.statusPackage.recordTime = SubContentPrensenter.this.infoPackage.recordTime;
            }
            SubContentPrensenter.this.dismissSoundsDialog();
            SubContentPrensenter.this.upLoadBtnStatusChange();
        }
    }

    public abstract void informRubPointAdsorb(String str, String str2);

    public SubContentPrensenter(Context mContext, View mRootView, UgcLayout mUgcLayout) {
        this.mRootView = mRootView;
        this.mContext = mContext;
        this.mUgcLayout = mUgcLayout;
        this.infoPackage = new UgcReportInfoUploadPackage();
        if (mRootView instanceof UgcReportNaviSubDetailView) {
            this.isFromNavi = true;
        }
        mRootView.setPresenter(this);
    }

    public void setRootView(UgcReportNaviSubDetailContract.View mRootView) {
        this.mRootView = mRootView;
    }

    public void start() {
        if (this.mRootView != null) {
            this.mRootView.initPresenterView();
            getCurrentPositionInfo();
            if (this.mUgcLayout.getSubType() == 6 && (this instanceof UgcReportMapSubDetailPresenter)) {
                this.mRootView.setDetailFlagVisibility(true);
            } else {
                this.mRootView.setDetailFlagVisibility(false);
            }
            if (this.mUgcLayout.getSubType() == 15) {
                this.mRootView.setDescriEditHintText("以上选项说不清，可在这里吐槽...");
            }
            if (this.mUgcLayout.getSubType() == 1 && (this instanceof UgcRportNaviResultPresenter)) {
                this.mRootView.setPositionLayout(false);
            }
            upLoadBtnStatusChange();
        }
    }

    public void gotoSoundsRecordDialog() {
        openSoundsDialog();
    }

    public void ugcUpLoad() {
    }

    public void onDestroy() {
        dimissPicDialog();
        dismissSoundsDialog();
    }

    public boolean onBackPress() {
        return false;
    }

    public void gotoSelectorPointPage() {
    }

    public void gotoPhotoCapture() {
        openPicDialog();
    }

    private void openPicDialog() {
        if (this.mRootView != null) {
            if (this.picChooseDialog == null) {
                this.picChooseDialog = new PicChooseDialog(this.mRootView.getContext());
            }
            this.picChooseDialog.setListener(this.mPicProcessLinsener);
            this.picChooseDialog.setOnCancelListener(new C42002());
            this.picChooseDialog.show();
        }
    }

    private void dimissPicDialog() {
        if (this.picChooseDialog != null) {
            this.picChooseDialog.dismiss();
            this.picChooseDialog = null;
        }
    }

    private void openSoundsDialog() {
        if (this.mRootView != null && UgcSoundsRecordDialog.checkAudioAuth()) {
            if (this.soundsDialog == null) {
                this.soundsDialog = new UgcSoundsRecordDialog(this.mRootView.getContext());
            }
            this.soundsDialog.setOnUgcSoundsRecordCallback(new C42013());
            this.soundsDialog.show();
        }
    }

    private void dismissSoundsDialog() {
        if (this.soundsDialog != null) {
            this.soundsDialog.dismiss();
            this.soundsDialog = null;
        }
    }

    public int getLaneInfoGvSize() {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getLaneSize();
        }
        return 0;
    }

    public String getDetailGvTextTile(int position) {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getDetailTitle(position);
        }
        return null;
    }

    public int getDetailGvSize() {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getDetailSize();
        }
        return 0;
    }

    public String getPositionInfoGvTextTile(int position) {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getPositionTitle(position);
        }
        return null;
    }

    public int getPositionInfoGvSize() {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getPositionSize();
        }
        return 0;
    }

    public String getLaneInfoGvTextTile(int index) {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getLaneTitle(index);
        }
        return null;
    }

    public String getSubTitleText() {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getSubTitle();
        }
        return null;
    }

    public void recordPositionSelected(int index) {
        if (!(this.mUgcLayout == null || this.infoPackage == null)) {
            this.infoPackage.subType = this.mUgcLayout.getPositionType(index);
            if (this.infoPackage.parentType == 15) {
                this.infoPackage.speedLimit = this.infoPackage.subType;
            }
        }
        if (UgcReportNaviMainPresenter.statusPackage != null && this.isFromNavi) {
            UgcReportNaviMainPresenter.statusPackage.subPosition = index;
        }
        upLoadBtnStatusChange();
    }

    public void recordDetailSelected(int index) {
        if (!(this.mUgcLayout == null || this.infoPackage == null)) {
            this.infoPackage.detailType = this.mUgcLayout.getDetailType(index);
            this.infoPackage.showLog("detailType change" + this.infoPackage.detailType);
        }
        if (UgcReportNaviMainPresenter.statusPackage != null && this.isFromNavi) {
            UgcReportNaviMainPresenter.statusPackage.detailPosition = index;
        }
        upLoadBtnStatusChange();
    }

    public int getSubType() {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getSubType();
        }
        return -1;
    }

    public void recordLaneSelected(int index) {
        if (!(this.mUgcLayout == null || this.infoPackage == null)) {
            this.infoPackage.laneType = this.mUgcLayout.getLaneType(index);
            this.infoPackage.showLog("laneType change" + this.infoPackage.laneType);
        }
        if (UgcReportNaviMainPresenter.statusPackage != null && this.isFromNavi) {
            UgcReportNaviMainPresenter.statusPackage.lanePosition = index;
        }
        upLoadBtnStatusChange();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.picChooseDialog != null) {
            this.picChooseDialog.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void deletePhotoShow() {
        if (this.infoPackage != null) {
            this.infoPackage.photoPicPath = null;
            this.infoPackage.photoPoint = null;
        }
        if (this.mRootView != null) {
            this.mRootView.showPhotoCancle();
        }
        upLoadBtnStatusChange();
    }

    public void deletSoundShow() {
        if (this.infoPackage != null) {
            this.infoPackage.voicePath = null;
        }
        if (this.mRootView != null) {
            this.mRootView.showSoundCancle();
        }
        upLoadBtnStatusChange();
    }

    private void getCurrentPositionInfo() {
        LocData curLoaction = BNLocationManagerProxy.getInstance().getCurLocation();
        if (curLoaction != null) {
            GeoPoint mGeoPoint = curLoaction.toGeoPoint();
            if (mGeoPoint != null) {
                int netMode = 1;
                if (!(BNaviModuleManager.getActivity() == null || NetworkUtils.isNetworkAvailable(BNaviModuleManager.getActivity()))) {
                    netMode = 0;
                }
                BNPoiSearcher.getInstance().asynGetPoiByPoint(mGeoPoint, netMode, 3000, this.mHandler);
            }
        }
    }

    public void recordContentChange(String content) {
        if (this.infoPackage != null) {
            this.infoPackage.content = content;
        }
        if (UgcReportNaviMainPresenter.statusPackage != null && this.isFromNavi) {
            UgcReportNaviMainPresenter.statusPackage.content = this.infoPackage.content;
        }
        upLoadBtnStatusChange();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        this.isFromNavi = true;
        start();
        if (UgcReportNaviMainPresenter.statusPackage != null) {
            if (UgcReportNaviMainPresenter.statusPackage.name != null) {
                informRubPointAdsorb(null, UgcReportNaviMainPresenter.statusPackage.name);
            }
            if (UgcReportNaviMainPresenter.statusPackage.content != null) {
                this.mRootView.setDescriEditText(UgcReportNaviMainPresenter.statusPackage.content);
            }
            if (UgcReportNaviMainPresenter.statusPackage.photoPicPath != null) {
                try {
                    this.mRootView.showPhotoBitmap(BitmapFactory.decodeFile(UgcReportNaviMainPresenter.statusPackage.photoPicPath));
                    this.infoPackage.photoPicPath = UgcReportNaviMainPresenter.statusPackage.photoPicPath;
                    this.infoPackage.photoPoint = UgcReportNaviMainPresenter.statusPackage.photoPoint;
                } catch (Exception e) {
                }
            }
            if (UgcReportNaviMainPresenter.statusPackage.voicePath != null) {
                this.mRootView.showRecordResult(UgcReportNaviMainPresenter.statusPackage.recordTime);
                this.infoPackage.voicePath = UgcReportNaviMainPresenter.statusPackage.voicePath;
            }
            if (UgcReportNaviMainPresenter.statusPackage.detailPosition != -1) {
                this.mRootView.updateSubContainerStatus(UgcReportNaviMainPresenter.statusPackage.detailPosition, 2);
            }
            if (UgcReportNaviMainPresenter.statusPackage.lanePosition != -1) {
                this.mRootView.updateSubContainerStatus(UgcReportNaviMainPresenter.statusPackage.lanePosition, 0);
            }
            if (UgcReportNaviMainPresenter.statusPackage.subPosition != -1) {
                this.mRootView.updateSubContainerStatus(UgcReportNaviMainPresenter.statusPackage.subPosition, 1);
            }
            upLoadBtnStatusChange();
        }
    }

    private void upLoadBtnStatusChange() {
        if (this.infoPackage != null && this.mRootView != null) {
            if (this.infoPackage.parentType == 6 && (this instanceof UgcReportMapSubDetailPresenter)) {
                if (this.infoPackage.detailType != -1) {
                    this.mRootView.setUploadBtnClickable(true);
                } else {
                    this.mRootView.setUploadBtnClickable(false);
                }
            } else if (this.infoPackage.parentType != 1 && this.infoPackage.parentType != 2) {
            } else {
                if (this.infoPackage.detailType == -1 && this.infoPackage.laneType == -1 && this.infoPackage.subType == -1 && TextUtils.isEmpty(this.infoPackage.content) && TextUtils.isEmpty(this.infoPackage.voicePath) && TextUtils.isEmpty(this.infoPackage.photoPicPath)) {
                    this.mRootView.setUploadBtnClickable(false);
                } else {
                    this.mRootView.setUploadBtnClickable(true);
                }
            }
        }
    }
}
