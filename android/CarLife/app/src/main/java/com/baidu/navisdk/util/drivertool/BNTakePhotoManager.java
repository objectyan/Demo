package com.baidu.navisdk.util.drivertool;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.navisdk.BNaviModuleManager;

public class BNTakePhotoManager
{
  public static final int REQUEST_TAKE_PHOTO_CODE = 256;
  private static BNTakePhotoManager mInstance;
  private Bitmap mBitmap = null;
  private Object mObj = null;
  
  public static BNTakePhotoManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNTakePhotoManager();
    }
    return mInstance;
  }
  
  public String getPathStr()
  {
    return BNDrivingToolUtils.getAbsoluteFilePath(2);
  }
  
  public void onPhotoTakeActionFinish(Bitmap paramBitmap, Object paramObject)
  {
    Activity localActivity = BNaviModuleManager.getNaviActivity();
    BNDrivingToolManager.getInstance().asynAntiGeoSearch(localActivity);
    this.mBitmap = paramBitmap;
    this.mObj = paramObject;
  }
  
  /* Error */
  public void photoFinishAction()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   12: invokevirtual 61	android/graphics/Bitmap:isMutable	()Z
    //   15: ifne +25 -> 40
    //   18: ldc 63
    //   20: ldc 65
    //   22: invokestatic 71	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   30: getstatic 77	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   33: iconst_1
    //   34: invokevirtual 81	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   37: putfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   40: aload_0
    //   41: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   44: invokestatic 84	com/baidu/navisdk/util/drivertool/BNDrivingToolUtils:getLocationInfo	()Ljava/lang/String;
    //   47: invokestatic 87	com/baidu/navisdk/util/drivertool/BNDrivingToolUtils:getCurrentTimeInfo	()Ljava/lang/String;
    //   50: aload_0
    //   51: getfield 21	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mObj	Ljava/lang/Object;
    //   54: invokestatic 91	com/baidu/navisdk/util/drivertool/BNDrivingToolUtils:addWaterMark	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Landroid/graphics/Bitmap;
    //   57: pop
    //   58: aconst_null
    //   59: astore_2
    //   60: aconst_null
    //   61: astore_3
    //   62: new 93	java/io/File
    //   65: dup
    //   66: aload_0
    //   67: invokevirtual 95	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:getPathStr	()Ljava/lang/String;
    //   70: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore_1
    //   74: new 100	java/io/FileOutputStream
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 103	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   82: astore_1
    //   83: aload_0
    //   84: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   87: getstatic 109	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   90: bipush 90
    //   92: aload_1
    //   93: invokevirtual 113	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   96: pop
    //   97: aload_1
    //   98: ifnull +11 -> 109
    //   101: aload_1
    //   102: invokevirtual 116	java/io/FileOutputStream:flush	()V
    //   105: aload_1
    //   106: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   109: aload_0
    //   110: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   113: ifnull +158 -> 271
    //   116: aload_0
    //   117: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   120: invokevirtual 122	android/graphics/Bitmap:isRecycled	()Z
    //   123: ifne +148 -> 271
    //   126: aload_0
    //   127: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   130: invokevirtual 125	android/graphics/Bitmap:recycle	()V
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   138: invokestatic 48	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:getInstance	()Lcom/baidu/navisdk/util/drivertool/BNDrivingToolManager;
    //   141: iconst_0
    //   142: invokevirtual 129	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:setDrivingToolIconVisibility	(Z)V
    //   145: invokestatic 48	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:getInstance	()Lcom/baidu/navisdk/util/drivertool/BNDrivingToolManager;
    //   148: iconst_2
    //   149: invokevirtual 133	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:getIssueStoreDialog	(I)Lcom/baidu/navisdk/util/drivertool/view/BNDrivingToolIssueStoreDialog;
    //   152: invokevirtual 138	com/baidu/navisdk/util/drivertool/view/BNDrivingToolIssueStoreDialog:show	()V
    //   155: return
    //   156: astore_1
    //   157: aload_3
    //   158: astore_1
    //   159: aload_1
    //   160: ifnull +11 -> 171
    //   163: aload_1
    //   164: invokevirtual 116	java/io/FileOutputStream:flush	()V
    //   167: aload_1
    //   168: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   171: aload_0
    //   172: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   175: ifnull -37 -> 138
    //   178: aload_0
    //   179: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   182: invokevirtual 122	android/graphics/Bitmap:isRecycled	()Z
    //   185: ifne -47 -> 138
    //   188: aload_0
    //   189: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   192: invokevirtual 125	android/graphics/Bitmap:recycle	()V
    //   195: aload_0
    //   196: aconst_null
    //   197: putfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   200: goto -62 -> 138
    //   203: astore_1
    //   204: aload_2
    //   205: ifnull +11 -> 216
    //   208: aload_2
    //   209: invokevirtual 116	java/io/FileOutputStream:flush	()V
    //   212: aload_2
    //   213: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   216: aload_0
    //   217: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   220: ifnull +25 -> 245
    //   223: aload_0
    //   224: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   227: invokevirtual 122	android/graphics/Bitmap:isRecycled	()Z
    //   230: ifne +15 -> 245
    //   233: aload_0
    //   234: getfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   237: invokevirtual 125	android/graphics/Bitmap:recycle	()V
    //   240: aload_0
    //   241: aconst_null
    //   242: putfield 19	com/baidu/navisdk/util/drivertool/BNTakePhotoManager:mBitmap	Landroid/graphics/Bitmap;
    //   245: aload_1
    //   246: athrow
    //   247: astore_2
    //   248: goto -32 -> 216
    //   251: astore_3
    //   252: aload_1
    //   253: astore_2
    //   254: aload_3
    //   255: astore_1
    //   256: goto -52 -> 204
    //   259: astore_1
    //   260: goto -89 -> 171
    //   263: astore_2
    //   264: goto -105 -> 159
    //   267: astore_1
    //   268: goto -159 -> 109
    //   271: goto -133 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	BNTakePhotoManager
    //   73	33	1	localObject1	Object
    //   156	1	1	localException1	Exception
    //   158	10	1	localObject2	Object
    //   203	50	1	localObject3	Object
    //   255	1	1	localObject4	Object
    //   259	1	1	localException2	Exception
    //   267	1	1	localException3	Exception
    //   59	154	2	localObject5	Object
    //   247	1	2	localException4	Exception
    //   253	1	2	localObject6	Object
    //   263	1	2	localException5	Exception
    //   61	97	3	localObject7	Object
    //   251	4	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   74	83	156	java/lang/Exception
    //   74	83	203	finally
    //   208	216	247	java/lang/Exception
    //   83	97	251	finally
    //   163	171	259	java/lang/Exception
    //   83	97	263	java/lang/Exception
    //   101	109	267	java/lang/Exception
  }
  
  public void takePhoto()
  {
    BNDrivingToolUtils.sIssueOccurTime = System.currentTimeMillis();
    Activity localActivity = BNaviModuleManager.getNaviActivity();
    if (localActivity != null) {
      localActivity.startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), 256);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/BNTakePhotoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */