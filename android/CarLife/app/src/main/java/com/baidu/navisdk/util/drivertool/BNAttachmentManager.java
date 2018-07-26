package com.baidu.navisdk.util.drivertool;

import android.content.Intent;
import android.database.Cursor;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BNAttachmentManager {
    public static final int REQUEST_ADD_ATTACH_CODE = 257;
    private static BNAttachmentManager mInstance = new BNAttachmentManager();
    public String mCurrentFilePath = null;
    public List<String> mFilePathList = new ArrayList();

    private BNAttachmentManager() {
    }

    public static BNAttachmentManager getInstance() {
        return mInstance;
    }

    public void startSelectPicture() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.PICK");
        if (BNaviModuleManager.getNaviActivity() != null) {
            BNaviModuleManager.getNaviActivity().startActivityForResult(Intent.createChooser(intent, "Select Picture"), 257);
        }
    }

    public void onSelectPictureFinish(Intent intent) {
        if (intent != null) {
            String[] filePathColumn = new String[]{"_data"};
            Cursor cursor = BNaviModuleManager.getNaviActivity().getContentResolver().query(intent.getData(), filePathColumn, null, null, null);
            cursor.moveToFirst();
            String picturePath = cursor.getString(cursor.getColumnIndex(filePathColumn[0]));
            cursor.close();
            if (!this.mFilePathList.contains(picturePath)) {
                this.mFilePathList.add(picturePath);
            }
            BNDrivingToolIssueStoreDialog missueDialog = BNDrivingToolManager.getInstance().getCurrentIssueStoreDialog();
            missueDialog.updateAttachNumber(this.mFilePathList.size());
            if (!BNDrivingToolParams.DEFAULT_SPINNER_DATA.equals(BNDrivingToolManager.getInstance().getIssueInfo().mIssueID)) {
                missueDialog.setStoreBtnState(true);
            }
        }
    }

    public void storeAttachmentIndex(int type) {
        int count = 0;
        for (String filePath : this.mFilePathList) {
            this.mCurrentFilePath = filePath;
            BNDrivingToolManager.getInstance().storeIndexFile(type);
            if (count == 0) {
                BNDrivingToolManager.getInstance().getIssueInfo().mIssueDescrption = "";
            }
            count++;
        }
    }

    public String getAttachmentIndexPath() {
        StringBuffer buf = new StringBuffer();
        buf.append(BNDrivingToolParams.NO_DT_INDEX_PREFIX);
        buf.append(JNISearchConst.LAYER_ID_DIVIDER);
        buf.append(UUID.randomUUID().toString());
        return BNDrivingToolUtils.getDrivingToolDir() + File.separator + buf.toString() + BNDrivingToolParams.NO_DT_INDEX_SUFFIX;
    }
}
