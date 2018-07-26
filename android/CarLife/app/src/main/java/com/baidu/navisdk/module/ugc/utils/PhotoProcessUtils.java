package com.baidu.navisdk.module.ugc.utils;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import com.baidu.mapframework.nirvana.runtime.http.Constants;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.platform.comapi.util.C4820d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PhotoProcessUtils {
    public static final int COMPRESSED_HEIGHT = 800;
    public static final int COMPRESSED_WIDTH = 640;

    public static class PicProcessResInfo {
        public Bitmap bitmap = null;
        public String filePath = null;
    }

    public PicProcessResInfo processCameraPic(ContentResolver cr, Uri uri, String originFilePath) throws Exception {
        PicProcessResInfo mPicProcessResInfo = new PicProcessResInfo();
        Bitmap mBitmap = rotateBitmapByDegree(compressBitmap(cr, uri), getBitmapDegree(originFilePath));
        String saveFilePath = setBitmapToFile(mBitmap);
        mPicProcessResInfo.bitmap = mBitmap;
        mPicProcessResInfo.filePath = saveFilePath;
        return mPicProcessResInfo;
    }

    public PicProcessResInfo processAlbumPic(ContentResolver cr, Uri uri) throws Exception {
        PicProcessResInfo mPicProcessResInfo = new PicProcessResInfo();
        Bitmap mBitmap = compressBitmap(cr, uri);
        String saveFilePath = setBitmapToFile(mBitmap);
        mPicProcessResInfo.bitmap = mBitmap;
        mPicProcessResInfo.filePath = saveFilePath;
        return mPicProcessResInfo;
    }

    private Bitmap compressBitmap(ContentResolver cr, Uri uri) throws IOException {
        Options newOpts = new Options();
        newOpts.inJustDecodeBounds = true;
        InputStream in = cr.openInputStream(uri);
        BitmapFactory.decodeStream(in, null, newOpts);
        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        if (w > h) {
            w = newOpts.outHeight;
            h = newOpts.outWidth;
        }
        newOpts.inPreferredConfig = Config.RGB_565;
        int be = 1;
        if (w > 640 && h > 800) {
            be = Math.min((int) Math.round((((double) w) * 1.0d) / 640.0d), (int) Math.round((((double) h) * 1.0d) / 800.0d));
        }
        LogUtil.m15791e(Constants.UGC_TOKEN, "compressBitmap() be=" + be);
        if (be <= 0) {
            be = 1;
        }
        if (in != null) {
            in.close();
        }
        newOpts.inSampleSize = be;
        in = cr.openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(in, null, newOpts);
        if (in != null) {
            in.close();
        }
        return bitmap;
    }

    public String setBitmapToFile(Bitmap bitmap) throws IOException {
        String filePath = getUniqueFilePath();
        if (bitmap == null || filePath == null) {
            return null;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        bitmap.compress(CompressFormat.JPEG, 80, fos);
        fos.flush();
        fos.close();
        return filePath;
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

    private Bitmap rotateBitmapByDegree(Bitmap bm, int degree) {
        if (degree == 0) {
            return bm;
        }
        Bitmap returnBm = null;
        Matrix matrix = new Matrix();
        matrix.postRotate((float) degree);
        try {
            returnBm = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        if (returnBm == null) {
            returnBm = bm;
        }
        if (bm != returnBm) {
            bm.recycle();
        }
        return returnBm;
    }

    public Bitmap compress(Bitmap bitmap, int maxH, int maxW) {
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

    private String getUniqueFilePath() {
        return SysOSAPI.getInstance().GetSDCardCachePath() + "/" + new Object().hashCode();
    }
}
