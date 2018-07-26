package com.baidu.navisdk.ui.ugc.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.platform.comapi.util.C4820d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PhotoCaptureUtils {
    public static final String CAMERA_COMPRESS_TEMP_FILE_PATH = (SysOSAPI.getInstance().GetSDCardCachePath() + "/ugc_camera_compress_temp.jpg");
    public static final String CAMERA_TEMP_FILE_PATH = (SysOSAPI.getInstance().GetSDCardCachePath() + "/ugc_camera_temp.jpg");
    public static final int COMPRESSED_HEIGHT = 600;
    public static final int COMPRESSED_WIDTH = 800;
    private static final int WHAT_COMPRESS_PHOTO = 1000;
    public static boolean hasCompressed = false;
    private static PhotoCaptureUtils instatnce = null;
    public static boolean isCompressing = false;
    private Activity mActivity = null;
    private Bitmap mBitMap = null;
    private Bitmap mDefaultBitmap = null;
    private String mFilePath = null;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what != 1000) {
                return;
            }
            if (PhotoCaptureUtils.isCompressing) {
                PhotoCaptureUtils.this.mHandler.removeMessages(1000);
                PhotoCaptureUtils.this.mHandler.sendEmptyMessageDelayed(1000, 1000);
                return;
            }
            PhotoCaptureUtils.isCompressing = true;
            PhotoCaptureUtils.hasCompressed = false;
            new GetCompressBitmapUriTask().execute(new Uri[]{PhotoCaptureUtils.this.mUri});
        }
    };
    private ImageView mImageView = null;
    private Uri mUri = null;

    private class GetCompressBitmapUriTask extends AsyncTask<Uri, Uri, Boolean> {
        private GetCompressBitmapUriTask() {
        }

        protected Boolean doInBackground(Uri... uris) {
            PhotoCaptureUtils.this.mFilePath = PhotoCaptureUtils.this.getCompressedUri(uris[0]);
            return Boolean.valueOf(false);
        }

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected void onPostExecute(Boolean flag) {
            super.onPostExecute(flag);
            if (PhotoCaptureUtils.this.mImageView != null && PhotoCaptureUtils.this.mBitMap != null) {
                PhotoCaptureUtils.this.mImageView.setBackgroundDrawable(new BitmapDrawable(PhotoCaptureUtils.this.mBitMap));
            }
        }
    }

    private PhotoCaptureUtils() {
    }

    public static PhotoCaptureUtils getInstance() {
        if (instatnce == null) {
            instatnce = new PhotoCaptureUtils();
        }
        return instatnce;
    }

    public void goToCapture(Activity mActivity, int resultCode) {
        if (mActivity != null) {
            Intent intent = new Intent();
            intent.setAction("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", Uri.fromFile(new File(CAMERA_TEMP_FILE_PATH)));
            try {
                mActivity.startActivityForResult(intent, resultCode);
            } catch (ActivityNotFoundException e) {
            }
        }
    }

    public void startCompressedBitmap(Activity mActivity, ImageView mImageView) {
        if (mImageView != null && mActivity != null) {
            this.mActivity = mActivity;
            this.mUri = Uri.fromFile(new File(CAMERA_TEMP_FILE_PATH));
            this.mImageView = mImageView;
            this.mHandler.sendEmptyMessage(1000);
        }
    }

    private String getCompressedUri(Uri uri) {
        String str = null;
        if (!(uri == null || this.mActivity == null || uri == null)) {
            try {
                str = compressBitmap(this.mActivity.getContentResolver(), uri);
            } catch (Exception e) {
            }
        }
        return str;
    }

    private String compressBitmap(ContentResolver cr, Uri uri) throws IOException {
        Options newOpts = new Options();
        newOpts.inJustDecodeBounds = true;
        InputStream isPre = cr.openInputStream(uri);
        BitmapFactory.decodeStream(isPre, null, newOpts);
        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        int be = 1;
        if (w > h && w > 800) {
            be = newOpts.outWidth / 800;
        } else if (w < h && h > 600) {
            be = newOpts.outHeight / 600;
        }
        if (be <= 0) {
            be = 1;
        }
        newOpts.inSampleSize = be;
        InputStream isPos = cr.openInputStream(uri);
        Bitmap bitmap = rotateBitmapByDegree(BitmapFactory.decodeStream(isPos, null, newOpts), getBitmapDegree(CAMERA_TEMP_FILE_PATH));
        if (bitmap != null) {
            this.mBitMap = compress(bitmap, 600, 800);
        }
        if (isPre != null) {
            isPre.close();
        }
        if (isPos != null) {
            isPos.close();
        }
        if (setBitmapToFile(CAMERA_COMPRESS_TEMP_FILE_PATH, this.mBitMap)) {
            return CAMERA_COMPRESS_TEMP_FILE_PATH;
        }
        return "";
    }

    public static Bitmap compress(Bitmap bitmap, int maxH, int maxW) {
        if (bitmap == null) {
            return null;
        }
        int rawHeight = bitmap.getHeight();
        int rawWidth = bitmap.getWidth();
        if (rawHeight < maxH && rawWidth < maxW) {
            return bitmap;
        }
        float heightScale;
        float widthScale;
        if (rawHeight > rawWidth) {
            heightScale = ((float) maxH) / ((float) rawHeight);
            widthScale = ((float) maxH) / ((float) rawHeight);
        } else {
            heightScale = ((float) maxW) / ((float) rawWidth);
            widthScale = ((float) maxW) / ((float) rawWidth);
        }
        Matrix matrix = new Matrix();
        matrix.postScale(widthScale, heightScale);
        return Bitmap.createBitmap(bitmap, 0, 0, rawWidth, rawHeight, matrix, true);
    }

    public Bitmap getBitmapCompressed() {
        try {
            if (!new File(CAMERA_COMPRESS_TEMP_FILE_PATH).exists()) {
                return null;
            }
            Bitmap bitmap = null;
            InputStream in = new FileInputStream(new File(CAMERA_COMPRESS_TEMP_FILE_PATH));
            try {
                bitmap = BitmapFactory.decodeStream(in);
                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return bitmap;
            } finally {
                in.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean setBitmapToFile(String filePath, Bitmap bitmap) {
        Exception e;
        File file;
        Throwable th;
        if (bitmap == null || filePath == null) {
            isCompressing = false;
            return false;
        }
        FileOutputStream fos = null;
        try {
            File file2 = new File(filePath);
            try {
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileOutputStream fos2 = new FileOutputStream(file2);
                try {
                    bitmap.compress(CompressFormat.JPEG, 100, fos2);
                    fos2.flush();
                    hasCompressed = true;
                    isCompressing = false;
                    if (fos2 == null) {
                        return true;
                    }
                    try {
                        fos2.close();
                        return true;
                    } catch (IOException e2) {
                        return true;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fos = fos2;
                    file = file2;
                    try {
                        e.printStackTrace();
                        isCompressing = false;
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e4) {
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        isCompressing = false;
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fos = fos2;
                    file = file2;
                    isCompressing = false;
                    if (fos != null) {
                        fos.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                file = file2;
                e.printStackTrace();
                isCompressing = false;
                if (fos != null) {
                    fos.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                file = file2;
                isCompressing = false;
                if (fos != null) {
                    fos.close();
                }
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            e.printStackTrace();
            isCompressing = false;
            if (fos != null) {
                fos.close();
            }
            return false;
        }
    }

    private int getBitmapDegree(String path) {
        try {
            switch (new ExifInterface(path).getAttributeInt("Orientation", 1)) {
                case 3:
                    return C4820d.f19955a;
                case 6:
                    return 90;
                case 8:
                    return 270;
                default:
                    return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap rotateBitmapByDegree(Bitmap bm, int degree) {
        if (degree == 0) {
            return bm;
        }
        Bitmap returnBm = null;
        Matrix matrix = new Matrix();
        matrix.postRotate((float) degree);
        try {
            returnBm = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
        }
        if (returnBm == null) {
            returnBm = bm;
        }
        if (bm != returnBm) {
            bm.recycle();
        }
        return returnBm;
    }
}
