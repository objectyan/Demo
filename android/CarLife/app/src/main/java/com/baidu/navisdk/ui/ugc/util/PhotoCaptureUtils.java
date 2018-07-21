package com.baidu.navisdk.ui.ugc.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class PhotoCaptureUtils
{
  public static final String CAMERA_COMPRESS_TEMP_FILE_PATH = SysOSAPI.getInstance().GetSDCardCachePath() + "/ugc_camera_compress_temp.jpg";
  public static final String CAMERA_TEMP_FILE_PATH;
  public static final int COMPRESSED_HEIGHT = 600;
  public static final int COMPRESSED_WIDTH = 800;
  private static final int WHAT_COMPRESS_PHOTO = 1000;
  public static boolean hasCompressed;
  private static PhotoCaptureUtils instatnce = null;
  public static boolean isCompressing;
  private Activity mActivity = null;
  private Bitmap mBitMap = null;
  private Bitmap mDefaultBitmap = null;
  private String mFilePath = null;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if (paramAnonymousMessage.what == 1000)
      {
        if (PhotoCaptureUtils.isCompressing)
        {
          PhotoCaptureUtils.this.mHandler.removeMessages(1000);
          PhotoCaptureUtils.this.mHandler.sendEmptyMessageDelayed(1000, 1000L);
        }
      }
      else {
        return;
      }
      PhotoCaptureUtils.isCompressing = true;
      PhotoCaptureUtils.hasCompressed = false;
      new PhotoCaptureUtils.GetCompressBitmapUriTask(PhotoCaptureUtils.this, null).execute(new Uri[] { PhotoCaptureUtils.this.mUri });
    }
  };
  private ImageView mImageView = null;
  private Uri mUri = null;
  
  static
  {
    hasCompressed = false;
    isCompressing = false;
    CAMERA_TEMP_FILE_PATH = SysOSAPI.getInstance().GetSDCardCachePath() + "/ugc_camera_temp.jpg";
  }
  
  public static Bitmap compress(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    int i;
    int j;
    do
    {
      return (Bitmap)localObject;
      i = paramBitmap.getHeight();
      j = paramBitmap.getWidth();
      if (i >= paramInt1) {
        break;
      }
      localObject = paramBitmap;
    } while (j < paramInt2);
    float f1;
    if (i > j) {
      f1 = paramInt1 / i;
    }
    for (float f2 = paramInt1 / i;; f2 = paramInt2 / j)
    {
      localObject = new Matrix();
      ((Matrix)localObject).postScale(f2, f1);
      return Bitmap.createBitmap(paramBitmap, 0, 0, j, i, (Matrix)localObject, true);
      f1 = paramInt2 / j;
    }
  }
  
  private String compressBitmap(ContentResolver paramContentResolver, Uri paramUri)
    throws IOException
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    InputStream localInputStream = paramContentResolver.openInputStream(paramUri);
    BitmapFactory.decodeStream(localInputStream, null, localOptions);
    localOptions.inJustDecodeBounds = false;
    int k = localOptions.outWidth;
    int m = localOptions.outHeight;
    int j = 1;
    int i;
    if ((k > m) && (k > 800)) {
      i = localOptions.outWidth / 800;
    }
    for (;;)
    {
      j = i;
      if (i <= 0) {
        j = 1;
      }
      localOptions.inSampleSize = j;
      paramContentResolver = paramContentResolver.openInputStream(paramUri);
      paramUri = rotateBitmapByDegree(BitmapFactory.decodeStream(paramContentResolver, null, localOptions), getBitmapDegree(CAMERA_TEMP_FILE_PATH));
      if (paramUri != null) {
        this.mBitMap = compress(paramUri, 600, 800);
      }
      if (localInputStream != null) {
        localInputStream.close();
      }
      if (paramContentResolver != null) {
        paramContentResolver.close();
      }
      if (!setBitmapToFile(CAMERA_COMPRESS_TEMP_FILE_PATH, this.mBitMap)) {
        break;
      }
      return CAMERA_COMPRESS_TEMP_FILE_PATH;
      i = j;
      if (k < m)
      {
        i = j;
        if (m > 600) {
          i = localOptions.outHeight / 600;
        }
      }
    }
    return "";
  }
  
  private int getBitmapDegree(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private String getCompressedUri(Uri paramUri)
  {
    if ((paramUri == null) || (this.mActivity == null)) {}
    while (paramUri == null) {
      return null;
    }
    try
    {
      paramUri = compressBitmap(this.mActivity.getContentResolver(), paramUri);
      return paramUri;
    }
    catch (Exception paramUri) {}
    return null;
  }
  
  public static PhotoCaptureUtils getInstance()
  {
    if (instatnce == null) {
      instatnce = new PhotoCaptureUtils();
    }
    return instatnce;
  }
  
  public static Bitmap rotateBitmapByDegree(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt == 0) {
      return paramBitmap;
    }
    Object localObject1 = null;
    Object localObject2 = new Matrix();
    ((Matrix)localObject2).postRotate(paramInt);
    try
    {
      localObject2 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject2, true);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramBitmap;
    }
    if (paramBitmap != localObject2) {
      paramBitmap.recycle();
    }
    return (Bitmap)localObject2;
  }
  
  /* Error */
  public Bitmap getBitmapCompressed()
  {
    // Byte code:
    //   0: new 229	java/io/File
    //   3: dup
    //   4: getstatic 74	com/baidu/navisdk/ui/ugc/util/PhotoCaptureUtils:CAMERA_COMPRESS_TEMP_FILE_PATH	Ljava/lang/String;
    //   7: invokespecial 230	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 234	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 236	java/io/FileInputStream
    //   21: dup
    //   22: new 229	java/io/File
    //   25: dup
    //   26: getstatic 74	com/baidu/navisdk/ui/ugc/util/PhotoCaptureUtils:CAMERA_COMPRESS_TEMP_FILE_PATH	Ljava/lang/String;
    //   29: invokespecial 230	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 239	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: astore_1
    //   36: aload_1
    //   37: invokestatic 242	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   40: astore_2
    //   41: aload_1
    //   42: invokevirtual 183	java/io/InputStream:close	()V
    //   45: aload_2
    //   46: areturn
    //   47: astore_1
    //   48: aload_1
    //   49: invokevirtual 243	java/lang/Exception:printStackTrace	()V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 243	java/lang/Exception:printStackTrace	()V
    //   59: aload_1
    //   60: invokevirtual 183	java/io/InputStream:close	()V
    //   63: aconst_null
    //   64: areturn
    //   65: astore_2
    //   66: aload_1
    //   67: invokevirtual 183	java/io/InputStream:close	()V
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	PhotoCaptureUtils
    //   35	7	1	localFileInputStream	java.io.FileInputStream
    //   47	20	1	localException1	Exception
    //   40	6	2	localBitmap	Bitmap
    //   54	2	2	localException2	Exception
    //   65	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	16	47	java/lang/Exception
    //   18	36	47	java/lang/Exception
    //   41	45	47	java/lang/Exception
    //   59	63	47	java/lang/Exception
    //   66	72	47	java/lang/Exception
    //   36	41	54	java/lang/Exception
    //   36	41	65	finally
    //   55	59	65	finally
  }
  
  public void goToCapture(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", Uri.fromFile(new File(CAMERA_TEMP_FILE_PATH)));
    try
    {
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (ActivityNotFoundException paramActivity) {}
  }
  
  /* Error */
  public boolean setBitmapToFile(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_2
    //   3: ifnull +7 -> 10
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: iconst_0
    //   11: putstatic 44	com/baidu/navisdk/ui/ugc/util/PhotoCaptureUtils:isCompressing	Z
    //   14: iconst_0
    //   15: istore_3
    //   16: iload_3
    //   17: ireturn
    //   18: aconst_null
    //   19: astore 4
    //   21: aconst_null
    //   22: astore 6
    //   24: aconst_null
    //   25: astore 5
    //   27: new 229	java/io/File
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 230	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 234	java/io/File:exists	()Z
    //   40: ifne +8 -> 48
    //   43: aload_1
    //   44: invokevirtual 275	java/io/File:createNewFile	()Z
    //   47: pop
    //   48: new 277	java/io/FileOutputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 278	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   56: astore_1
    //   57: aload_2
    //   58: getstatic 284	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   61: bipush 100
    //   63: aload_1
    //   64: invokevirtual 287	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   67: pop
    //   68: aload_1
    //   69: invokevirtual 290	java/io/FileOutputStream:flush	()V
    //   72: iconst_1
    //   73: putstatic 42	com/baidu/navisdk/ui/ugc/util/PhotoCaptureUtils:hasCompressed	Z
    //   76: iconst_0
    //   77: putstatic 44	com/baidu/navisdk/ui/ugc/util/PhotoCaptureUtils:isCompressing	Z
    //   80: aload_1
    //   81: ifnull -65 -> 16
    //   84: aload_1
    //   85: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   88: iconst_1
    //   89: ireturn
    //   90: astore_1
    //   91: iconst_1
    //   92: ireturn
    //   93: astore_1
    //   94: aload 5
    //   96: astore_2
    //   97: aload_2
    //   98: astore 4
    //   100: aload_1
    //   101: invokevirtual 243	java/lang/Exception:printStackTrace	()V
    //   104: iconst_0
    //   105: putstatic 44	com/baidu/navisdk/ui/ugc/util/PhotoCaptureUtils:isCompressing	Z
    //   108: aload_2
    //   109: ifnull +7 -> 116
    //   112: aload_2
    //   113: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_1
    //   119: iconst_0
    //   120: putstatic 44	com/baidu/navisdk/ui/ugc/util/PhotoCaptureUtils:isCompressing	Z
    //   123: aload 4
    //   125: ifnull +8 -> 133
    //   128: aload 4
    //   130: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: goto -20 -> 116
    //   139: astore_2
    //   140: goto -7 -> 133
    //   143: astore_1
    //   144: aload 6
    //   146: astore 4
    //   148: goto -29 -> 119
    //   151: astore_2
    //   152: aload_1
    //   153: astore 4
    //   155: aload_2
    //   156: astore_1
    //   157: goto -38 -> 119
    //   160: astore_1
    //   161: aload 5
    //   163: astore_2
    //   164: goto -67 -> 97
    //   167: astore 4
    //   169: aload_1
    //   170: astore_2
    //   171: aload 4
    //   173: astore_1
    //   174: goto -77 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	PhotoCaptureUtils
    //   0	177	1	paramString	String
    //   0	177	2	paramBitmap	Bitmap
    //   1	16	3	bool	boolean
    //   19	135	4	localObject1	Object
    //   167	5	4	localException	Exception
    //   25	137	5	localObject2	Object
    //   22	123	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   84	88	90	java/io/IOException
    //   27	36	93	java/lang/Exception
    //   27	36	118	finally
    //   100	104	118	finally
    //   112	116	135	java/io/IOException
    //   128	133	139	java/io/IOException
    //   36	48	143	finally
    //   48	57	143	finally
    //   57	76	151	finally
    //   36	48	160	java/lang/Exception
    //   48	57	160	java/lang/Exception
    //   57	76	167	java/lang/Exception
  }
  
  public void startCompressedBitmap(Activity paramActivity, ImageView paramImageView)
  {
    if ((paramImageView == null) || (paramActivity == null)) {
      return;
    }
    this.mActivity = paramActivity;
    this.mUri = Uri.fromFile(new File(CAMERA_TEMP_FILE_PATH));
    this.mImageView = paramImageView;
    this.mHandler.sendEmptyMessage(1000);
  }
  
  private class GetCompressBitmapUriTask
    extends AsyncTask<Uri, Uri, Boolean>
  {
    private GetCompressBitmapUriTask() {}
    
    protected Boolean doInBackground(Uri... paramVarArgs)
    {
      PhotoCaptureUtils.access$302(PhotoCaptureUtils.this, PhotoCaptureUtils.this.getCompressedUri(paramVarArgs[0]));
      return Boolean.valueOf(false);
    }
    
    protected void onPostExecute(Boolean paramBoolean)
    {
      super.onPostExecute(paramBoolean);
      if ((PhotoCaptureUtils.this.mImageView != null) && (PhotoCaptureUtils.this.mBitMap != null)) {
        PhotoCaptureUtils.this.mImageView.setBackgroundDrawable(new BitmapDrawable(PhotoCaptureUtils.this.mBitMap));
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/ugc/util/PhotoCaptureUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */