package com.baidu.navisdk.module.ugc.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.navisdk.module.ugc.BasePresenter;
import com.baidu.navisdk.module.ugc.BaseView;

public interface SubContentContract {

    public interface Presenter extends BasePresenter {
        void deletSoundShow();

        void deletePhotoShow();

        int getDetailGvSize();

        String getDetailGvTextTile(int i);

        int getLaneInfoGvSize();

        String getLaneInfoGvTextTile(int i);

        int getPositionInfoGvSize();

        String getPositionInfoGvTextTile(int i);

        String getSubTitleText();

        int getSubType();

        void gotoPhotoCapture();

        void gotoSelectorPointPage();

        void gotoSoundsRecordDialog();

        boolean onBackPress();

        void onDestroy();

        void recordContentChange(String str);

        void recordDetailSelected(int i);

        void recordLaneSelected(int i);

        void recordPositionSelected(int i);

        void ugcUpLoad();
    }

    public interface View extends BaseView<Presenter> {
        Context getContext();

        void setDescriEditHintText(String str);

        void setDescriEditText(String str);

        void setDetailFlagVisibility(boolean z);

        void setPositionLayout(boolean z);

        void setUploadBtnClickable(boolean z);

        void showAddrInfoUpdate(String str, String str2);

        void showPhotoBitmap(Bitmap bitmap);

        void showPhotoCancle();

        void showPhotoGraph(Bitmap bitmap);

        void showRecordResult(int i);

        void showSoundCancle();

        void updateSubContainerStatus(int i, int i2);
    }
}
