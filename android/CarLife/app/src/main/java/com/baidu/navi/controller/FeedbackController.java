package com.baidu.navi.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.util.Base64;
import com.baidu.carlife.p054k.C1644e;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.navi.logic.drawable.PathDrawable;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.apache.http.NameValuePair;

public class FeedbackController {
    private static final String KEY = "bd44977f4225b957923ddefa781e8f93";
    public static final int PHOTO_REQUEST_CAREMA = 4609;
    public static final int PHOTO_REQUEST_GALLERY = 4610;
    private static final String PREIX = "navi";
    private static FeedbackController sInstance = null;
    private int bmpSize = 120;
    private String mContact;
    private String mContent;
    private Handler mHandler;
    private ArrayList<Bitmap> mPicList;
    private ArrayList<String> mPicListPath;
    private File tempFile;
    private String type;

    public interface UploadFeedbackCallback {
        void onUploadFeedbackFail(Exception exception);

        void onUploadFeedbackSuccess();
    }

    public static FeedbackController getInstance() {
        if (sInstance == null) {
            sInstance = new FeedbackController();
        }
        return sInstance;
    }

    public void setmHandler(Handler handle) {
        this.mHandler = handle;
    }

    public ArrayList<Bitmap> getmPicList() {
        return this.mPicList;
    }

    public void setmPicList(ArrayList<Bitmap> mPicList) {
        this.mPicList = mPicList;
    }

    public ArrayList<String> getmPicListPath() {
        return this.mPicListPath;
    }

    public void setmPicListPath(ArrayList<String> mPicListPath) {
        this.mPicListPath = mPicListPath;
    }

    public void initPicList() {
        this.mPicList = new ArrayList();
        this.mPicListPath = new ArrayList();
    }

    public String getmContent() {
        return this.mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmContact() {
        return this.mContact;
    }

    public void setmContact(String mContact) {
        this.mContact = mContact;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public File getTempFile() {
        return this.tempFile;
    }

    public void setTempFile(File tempFile) {
        this.tempFile = tempFile;
    }

    public void startUploadFeedback(C0924a netWorkResponseListener, String content, String contact, String type, Context context) {
        if (this.mPicListPath == null || this.mPicListPath.size() <= 0) {
            toRequest(null, content, contact, type, context, netWorkResponseListener);
            return;
        }
        final String str = content;
        final String str2 = contact;
        final String str3 = type;
        final Context context2 = context;
        final C0924a c0924a = netWorkResponseListener;
        new Thread(new Runnable() {
            public void run() {
                List<String> picFileList = new ArrayList();
                for (int i = 0; i < FeedbackController.this.mPicListPath.size(); i++) {
                    picFileList.add(FeedbackController.this.bitmapToBase64(FeedbackController.this.getBitMap(FeedbackController.this.judgeFileSize(FeedbackController.this.bitmapToFile(FeedbackController.this.getBitmapByOptToSend((String) FeedbackController.this.mPicListPath.get(i)))).getPath())));
                }
                FeedbackController.this.toRequest(picFileList, str, str2, str3, context2, c0924a);
            }
        }).start();
    }

    private void toRequest(List<String> picFileList, String content, String contact, String type, Context context, C0924a netWorkResponseListener) {
        C1644e request = new C1644e(content, contact, type, picFileList, context);
        request.registerResponseListener(netWorkResponseListener);
        request.toPostRequest();
    }

    public boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        return false;
    }

    public void openPicSrc(Activity mActivity, int position) {
        if (getInstance().getmPicListPath() != null && position >= 0 && position < getInstance().getmPicListPath().size()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File((String) getInstance().getmPicListPath().get(position))), "image/*");
            mActivity.startActivity(intent);
        }
    }

    public Bitmap getBitmapByOpt(String picturePath) {
        int i = 1;
        try {
            int i2;
            int i3;
            Options opt = new Options();
            opt.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(picturePath, opt);
            int scaleX = opt.outWidth / this.bmpSize;
            int scaleY = opt.outHeight / this.bmpSize;
            int scale = 1;
            if (scaleX > scaleY) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (((scaleY >= 1 ? 1 : 0) & i2) != 0) {
                scale = scaleX;
            }
            if (scaleY > scaleX) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (scaleX < 1) {
                i = 0;
            }
            if ((i & i3) != 0) {
                scale = scaleY;
            }
            opt.inJustDecodeBounds = false;
            opt.inSampleSize = scale;
            return BitmapFactory.decodeFile(picturePath, opt);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public Bitmap getBitmapByOptToSend(String picturePath) {
        int i = 1;
        try {
            int i2;
            int i3;
            Options opt = new Options();
            opt.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(picturePath, opt);
            int destSize = this.bmpSize * 2;
            int scaleX = opt.outWidth / destSize;
            int scaleY = opt.outHeight / destSize;
            int scale = 1;
            if (scaleX > scaleY) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (((scaleY >= 1 ? 1 : 0) & i2) != 0) {
                scale = scaleX;
            }
            if (scaleY > scaleX) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (scaleX < 1) {
                i = 0;
            }
            if ((i & i3) != 0) {
                scale = scaleY;
            }
            opt.inJustDecodeBounds = false;
            opt.inSampleSize = scale;
            opt.inDensity = 0;
            return BitmapFactory.decodeFile(picturePath, opt);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public Bitmap getBitMap(String path) {
        try {
            return BitmapFactory.decodeFile(path);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public File bitmapToFile(Bitmap bitmap) {
        File f = new File(PathDrawable.getCachePath(), UUID.randomUUID().toString() + ".jpg");
        try {
            f.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        if (f != null) {
            FileOutputStream fOut = null;
            try {
                fOut = new FileOutputStream(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                bitmap.compress(CompressFormat.JPEG, 50, fOut);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                fOut.flush();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            try {
                fOut.close();
            } catch (IOException e32) {
                e32.printStackTrace();
            }
        }
        return f;
    }

    public String getBitmapFilePath(Activity mActivity, int requestCode, int resultCode, Intent data) {
        if (requestCode == 4610) {
            if (data != null) {
                String[] filePathColumn = new String[]{"_data"};
                try {
                    Cursor cursor = mActivity.getApplicationContext().getContentResolver().query(data.getData(), filePathColumn, null, null, null);
                    if (cursor == null) {
                        return null;
                    }
                    cursor.moveToFirst();
                    String picturePath = cursor.getString(cursor.getColumnIndex(filePathColumn[0]));
                    cursor.close();
                    return picturePath;
                } catch (Exception e) {
                }
            }
        } else if (requestCode == 4609) {
            if (hasSdcard()) {
                return this.tempFile.getAbsolutePath();
            }
            TipTool.onCreateToastDialog(mActivity.getApplicationContext(), "未找到存储卡，无法存储照片！");
        }
        return null;
    }

    protected String generateSign(List<NameValuePair> params) {
        if (params == null) {
            return null;
        }
        try {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < params.size(); i++) {
                sb.append(((NameValuePair) params.get(i)).getName());
                sb.append("=");
                sb.append(URLEncoder.encode(((NameValuePair) params.get(i)).getValue(), "utf-8"));
                if (i < params.size() - 1) {
                    sb.append("&");
                }
            }
            String source = "navi" + sb.toString() + KEY;
            String sign = MD5.toMD5(source).toLowerCase(Locale.getDefault());
            LogUtil.m15791e("FeedBackFragment", "sign source = " + source + "\n sign = " + sign);
            return sign;
        } catch (Exception e) {
            LogUtil.m15791e("FeedBackFragment", "generateSign fail" + e.getMessage());
            return null;
        }
    }

    public File judgeFileSize(File file) {
        while (file != null && file.length() >= ((long) 2097152)) {
            file = bitmapToFile(getBitmapByOptToSend(file.getPath()));
        }
        return file;
    }

    public String bitmapToBase64(Bitmap bitmap) {
        IOException e;
        Throwable th;
        String result = null;
        ByteArrayOutputStream baos = null;
        if (bitmap != null) {
            try {
                ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
                try {
                    bitmap.compress(CompressFormat.JPEG, 100, baos2);
                    baos2.flush();
                    baos2.close();
                    result = Base64.encodeToString(baos2.toByteArray(), 0);
                    baos = baos2;
                } catch (IOException e2) {
                    e = e2;
                    baos = baos2;
                    try {
                        e.printStackTrace();
                        if (baos != null) {
                            try {
                                baos.flush();
                                baos.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return result;
                    } catch (Throwable th2) {
                        th = th2;
                        if (baos != null) {
                            try {
                                baos.flush();
                                baos.close();
                            } catch (IOException e32) {
                                e32.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    baos = baos2;
                    if (baos != null) {
                        baos.flush();
                        baos.close();
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e32 = e4;
                e32.printStackTrace();
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
                return result;
            }
        }
        if (baos != null) {
            try {
                baos.flush();
                baos.close();
            } catch (IOException e322) {
                e322.printStackTrace();
            }
        }
        return result;
    }

    public Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, 0);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
