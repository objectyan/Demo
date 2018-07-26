package com.baidu.ufosdk.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import com.baidu.navi.protocol.util.BNaviProtocolDef;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* compiled from: ScreenShotBitmapUtil */
/* renamed from: com.baidu.ufosdk.util.t */
public final class C5227t {
    /* renamed from: a */
    public static byte[] m17793a(byte[] bArr, int i) {
        Bitmap decodeByteArray;
        Bitmap createBitmap;
        Throwable th;
        int i2 = 1;
        Bitmap bitmap = null;
        if (bArr == null) {
            return null;
        }
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            if (i3 > 800 || i4 > BNaviProtocolDef.DEFAULT_IMAGE_HEIGHT) {
                i2 = Math.round(((float) i3) / 800.0f);
                i3 = Math.round(((float) i4) / 480.0f);
                if (i2 >= i3) {
                    i2 = i3;
                }
            }
            options.inSampleSize = i2;
            options.inPreferredConfig = Config.RGB_565;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inJustDecodeBounds = false;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            try {
                Matrix matrix = new Matrix();
                matrix.postRotate((float) i);
                createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
            } catch (IllegalArgumentException e) {
                decodeByteArray.recycle();
                return null;
            } catch (NullPointerException e2) {
                createBitmap = decodeByteArray;
                createBitmap.recycle();
                return null;
            } catch (RuntimeException e3) {
                createBitmap = decodeByteArray;
                createBitmap.recycle();
                return null;
            } catch (OutOfMemoryError e4) {
                createBitmap = decodeByteArray;
                try {
                    System.gc();
                    createBitmap.recycle();
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bitmap = createBitmap;
                    bitmap.recycle();
                    throw th;
                }
            } catch (Exception e5) {
                createBitmap = decodeByteArray;
                createBitmap.recycle();
                return null;
            } catch (Throwable th3) {
                bitmap = decodeByteArray;
                th = th3;
                bitmap.recycle();
                throw th;
            }
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(CompressFormat.JPEG, 30, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                if (createBitmap == null || createBitmap.isRecycled()) {
                    return toByteArray;
                }
                createBitmap.recycle();
                return toByteArray;
            } catch (IllegalArgumentException e6) {
                decodeByteArray = createBitmap;
                decodeByteArray.recycle();
                return null;
            } catch (NullPointerException e7) {
                createBitmap.recycle();
                return null;
            } catch (RuntimeException e8) {
                createBitmap.recycle();
                return null;
            } catch (OutOfMemoryError e9) {
                System.gc();
                createBitmap.recycle();
                return null;
            } catch (Exception e10) {
                createBitmap.recycle();
                return null;
            }
        } catch (IllegalArgumentException e11) {
            decodeByteArray = null;
            if (!(decodeByteArray == null || decodeByteArray.isRecycled())) {
                decodeByteArray.recycle();
            }
            return null;
        } catch (NullPointerException e12) {
            createBitmap = null;
            if (!(createBitmap == null || createBitmap.isRecycled())) {
                createBitmap.recycle();
            }
            return null;
        } catch (RuntimeException e13) {
            createBitmap = null;
            if (!(createBitmap == null || createBitmap.isRecycled())) {
                createBitmap.recycle();
            }
            return null;
        } catch (OutOfMemoryError e14) {
            createBitmap = null;
            System.gc();
            if (!(createBitmap == null || createBitmap.isRecycled())) {
                createBitmap.recycle();
            }
            return null;
        } catch (Exception e15) {
            createBitmap = null;
            if (!(createBitmap == null || createBitmap.isRecycled())) {
                createBitmap.recycle();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
            throw th;
        }
    }
}
