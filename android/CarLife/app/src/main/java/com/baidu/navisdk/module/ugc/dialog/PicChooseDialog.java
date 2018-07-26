package com.baidu.navisdk.module.ugc.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.ugc.utils.PhotoProcessUtils;
import com.baidu.navisdk.module.ugc.utils.PhotoProcessUtils.PicProcessResInfo;
import com.baidu.navisdk.module.ugc.utils.UgcMapsViewConstructor;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.File;

public class PicChooseDialog extends Dialog implements OnClickListener {
    public static final String CAMERA_TEMP_FILE_PATH = (SysOSAPI.getInstance().GetSDCardCachePath() + "/ugc_camera_temp.jpg");
    private static final int PHOTO_REQUEST_CAREMA = 1;
    private static final int PHOTO_REQUEST_GALLERY = 2;
    private PicProcessCallBack callBack = null;
    private TextView chooseAlbumBtn = null;
    private TextView chooseCameraBtn = null;
    private Context context;

    public interface PicProcessCallBack {
        void onFail(String str);

        void onSuccess(PicProcessResInfo picProcessResInfo);
    }

    public void setListener(PicProcessCallBack mPicProcessCallBack) {
        this.callBack = mPicProcessCallBack;
    }

    public PicChooseDialog(Context context) {
        super(context);
        this.context = context;
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        View view = JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_ugc_report_pic_choose_dialog, null);
        if (view != null) {
            this.chooseCameraBtn = (TextView) view.findViewById(C4048R.id.choose_camera_btn);
            this.chooseAlbumBtn = (TextView) view.findViewById(C4048R.id.choose_album_btn);
            setContentView(view);
            initListener();
        }
    }

    private void initListener() {
        if (this.chooseCameraBtn != null) {
            this.chooseCameraBtn.setOnClickListener(this);
        }
        if (this.chooseAlbumBtn != null) {
            this.chooseAlbumBtn.setOnClickListener(this);
        }
    }

    public void onClick(View v) {
        if (v.getId() == C4048R.id.choose_camera_btn) {
            if (SystemAuth.checkAuth(SystemAuth.PHOTO_CAPTURE_AUTH, true, SystemAuth.PHOTO_CAPTURE_MSG)) {
                goToCapture();
            } else {
                UgcMapsViewConstructor.requestPhotoCaptureAuth();
            }
        } else if (v.getId() == C4048R.id.choose_album_btn) {
            gallery();
        }
    }

    public void gallery() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        ((Activity) this.context).startActivityForResult(intent, 2);
    }

    public void goToCapture() {
        Intent intent = new Intent();
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", Uri.fromFile(new File(CAMERA_TEMP_FILE_PATH)));
        ((Activity) this.context).startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri uri;
        PicProcessResInfo mPicProcessResInfo;
        if (requestCode == 2) {
            if (resultCode == -1 && data != null) {
                uri = data.getData();
                try {
                    mPicProcessResInfo = new PhotoProcessUtils().processAlbumPic(((Activity) this.context).getContentResolver(), uri);
                    if (this.callBack != null) {
                        this.callBack.onSuccess(mPicProcessResInfo);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.callBack != null) {
                this.callBack.onFail("异常");
            }
        } else if (requestCode == 1) {
            if (resultCode == -1) {
                uri = Uri.fromFile(new File(CAMERA_TEMP_FILE_PATH));
                try {
                    mPicProcessResInfo = new PhotoProcessUtils().processCameraPic(((Activity) this.context).getContentResolver(), uri, CAMERA_TEMP_FILE_PATH);
                    if (this.callBack != null) {
                        this.callBack.onSuccess(mPicProcessResInfo);
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (this.callBack != null) {
                this.callBack.onFail("异常");
            }
        }
    }
}
