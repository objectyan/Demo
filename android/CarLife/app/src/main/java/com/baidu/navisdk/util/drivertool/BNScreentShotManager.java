package com.baidu.navisdk.util.drivertool;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.drivertool.view.BNDrivingToolImageShowDialog;
import com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.io.File;
import java.io.OutputStream;
import java.nio.IntBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BNScreentShotManager
{
  public static final String SCREEN_IN_HANDLE = "截图正在处理中...请稍候再试";
  public static final int TYPE_COLLADA = 2;
  public static final int TYPE_MAP_RENDER = 1;
  public static final int TYPE_SWITCH = 3;
  private static BNScreentShotManager mInstance;
  public static boolean sIsInThread = false;
  private CaptureMapListener captureMapListener;
  public boolean isSaveShot = false;
  private Bitmap mBitmap = null;
  public String mCachePath = SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/naving/capture.png";
  public Bitmap mColladaBitmap = null;
  private View mDecorView = null;
  public Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int i = paramAnonymousMessage.what;
      if (i == 256)
      {
        i = BNDrivingToolUtils.getCurrentScreenCount();
        if (BNDrivingToolUtils.sScreenShotCount == i)
        {
          BNDrivingToolUtils.setSurfaceViewState(false);
          BNWorkerCenter.getInstance().submitMainThreadTask(BNScreentShotManager.this.mergeTask, new BNWorkerConfig(100, 0));
          BNDrivingToolUtils.sScreenShotCount = 0;
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (i == 261)
              {
                BNDrivingToolUtils.sMapRenderShow = false;
                if (paramAnonymousMessage.obj == null)
                {
                  BNScreentShotManager.this.mMapRenderBitmap = null;
                  TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "大屏截图失败");
                }
                for (;;)
                {
                  i = BNDrivingToolUtils.getCurrentScreenCount();
                  if (BNDrivingToolUtils.sScreenShotCount != i) {
                    break;
                  }
                  BNDrivingToolUtils.setSurfaceViewState(false);
                  BNWorkerCenter.getInstance().submitMainThreadTask(BNScreentShotManager.this.mergeTask, new BNWorkerConfig(100, 0));
                  BNDrivingToolUtils.sScreenShotCount = 0;
                  return;
                  BNScreentShotManager.this.mMapRenderBitmap = ((Bitmap)paramAnonymousMessage.obj);
                  BNDrivingToolUtils.sScreenShotCount += 1;
                }
              }
              if (i != 258) {
                break;
              }
            } while (BNScreentShotManager.this.mShowDialog == null);
            BNScreentShotManager.this.mShowDialog.updateImage(BNScreentShotManager.this.mBitmap);
            BNScreentShotManager.this.mHandler.sendEmptyMessageDelayed(260, 1500L);
            return;
            if (i != 257) {
              break;
            }
          } while (BNScreentShotManager.this.mShowDialog == null);
          BNScreentShotManager.this.mShowDialog.updateImage(BNScreentShotManager.this.mBitmap);
          BNScreentShotManager.this.mHandler.sendEmptyMessageDelayed(259, 1500L);
          return;
          if (i != 260) {
            break;
          }
        } while (BNScreentShotManager.this.mShowDialog == null);
        BNScreentShotManager.this.mShowDialog.dismiss();
        return;
      } while ((i != 259) || (BNScreentShotManager.this.mShowDialog == null));
      BNScreentShotManager.this.mShowDialog.dismiss();
    }
  };
  private boolean mIsCommomViewShow = false;
  public boolean mIsCross = false;
  public Bitmap mMapRenderBitmap = null;
  public int mScreenState = 0;
  private BNDrivingToolImageShowDialog mShowDialog = null;
  public Bitmap mSwitchBitmap = null;
  private BNWorkerNormalTask mergeTask = new BNWorkerNormalTask("mergeTask", null)
  {
    protected String execute()
    {
      BNScreentShotManager.this.mergeBitmap();
      return null;
    }
  };
  
  private void addWaterMark(String paramString)
  {
    int i = this.mBitmap.getWidth();
    int j = this.mBitmap.getHeight();
    Canvas localCanvas = new Canvas(this.mBitmap);
    Paint localPaint = new Paint(257);
    localPaint.setTextSize(30.0F);
    localPaint.setColor(65280);
    localPaint.setTypeface(Typeface.DEFAULT_BOLD);
    localPaint.setShadowLayer(3.0F, 1.0F, 1.0F, -65536);
    localCanvas.drawText(paramString, i / 3, (float)(j * 0.9D), localPaint);
    localCanvas.save(31);
    localCanvas.restore();
  }
  
  private int getColladaBottomPx()
  {
    int i = 0;
    if (!this.mIsCross) {
      i = ScreenUtil.getInstance().getHeightPixels() / 2;
    }
    return i;
  }
  
  private int getColladaRightPx()
  {
    int i = 0;
    if (this.mIsCross) {
      i = ScreenUtil.getInstance().getHeightPixels() / 2;
    }
    return i;
  }
  
  public static String getEnlargeImgPath()
  {
    File localFile = new File(SysOSAPI.getInstance().GetSDCardPath() + File.separator + "EnlargeDir");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    String str = new SimpleDateFormat("yyyyMMddHHmm", Locale.getDefault()).format(new Date());
    return localFile.getAbsolutePath() + File.separator + str + ".png";
  }
  
  private String getInfo()
  {
    return "dingbbin";
  }
  
  public static BNScreentShotManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNScreentShotManager();
    }
    return mInstance;
  }
  
  private String getPicturePath()
  {
    return BNDrivingToolUtils.getAbsoluteFilePath(3);
  }
  
  private String getRootPath()
  {
    return getEnlargeImgPath();
  }
  
  private int getSmallSurfaceLeftPx()
  {
    if (this.mIsCross) {
      return ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().dip2px(136);
    }
    return ScreenUtil.getInstance().getWidthPixels() - ScreenUtil.getInstance().dip2px(136);
  }
  
  private int getSmallSurfaceTopPx()
  {
    int i = 0;
    if (this.mIsCommomViewShow) {
      i = 112;
    }
    if (this.mIsCross) {
      return ScreenUtil.getInstance().getWidthPixels() - ScreenUtil.getInstance().dip2px(i + 136);
    }
    return ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().dip2px(i + 136);
  }
  
  private int getSwitchViewBottomPix()
  {
    if (this.mIsCommomViewShow) {
      return ScreenUtil.getInstance().dip2px(120);
    }
    return ScreenUtil.getInstance().dip2px(8);
  }
  
  private String getTmpStorePath()
  {
    return "/sdcard/drivingToolPic.temp";
  }
  
  private void mergeBitmap()
  {
    LogUtil.e("drivingTool", "mergeBitmap state is " + this.mScreenState + "isCross is " + this.mIsCross);
    Bitmap localBitmap = getInstance().takeScreenShot();
    Object localObject2 = new ArrayList();
    Object localObject1 = null;
    ((List)localObject2).add(new BitmapDrawable(this.mMapRenderBitmap));
    ((List)localObject2).add(new BitmapDrawable(localBitmap));
    if (this.mScreenState == 0)
    {
      localObject1 = new LayerDrawable((Drawable[])((List)localObject2).toArray(new Drawable[((List)localObject2).size()]));
      ((LayerDrawable)localObject1).setLayerInset(0, 0, 0, 0, 0);
      ((LayerDrawable)localObject1).setLayerInset(1, 0, 0, 0, 0);
      if (!this.mIsCross) {
        break label576;
      }
      this.mBitmap = Bitmap.createBitmap(ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels(), Bitmap.Config.ARGB_8888);
      localObject2 = new Canvas(this.mBitmap);
      ((LayerDrawable)localObject1).setBounds(0, 0, ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels());
    }
    for (;;)
    {
      ((LayerDrawable)localObject1).draw((Canvas)localObject2);
      showImageInDialog(0);
      return;
      if (this.mScreenState == 1)
      {
        ((List)localObject2).add(new BitmapDrawable(this.mColladaBitmap));
        localObject1 = new LayerDrawable((Drawable[])((List)localObject2).toArray(new Drawable[((List)localObject2).size()]));
        ((LayerDrawable)localObject1).setLayerInset(0, 0, 0, 0, 0);
        ((LayerDrawable)localObject1).setLayerInset(1, 0, 0, 0, 0);
        ((LayerDrawable)localObject1).setLayerInset(2, 0, 0, getColladaRightPx(), getColladaBottomPx());
        break;
      }
      if (this.mScreenState == 2)
      {
        ((List)localObject2).add(new BitmapDrawable(this.mSwitchBitmap));
        localObject1 = new LayerDrawable((Drawable[])((List)localObject2).toArray(new Drawable[((List)localObject2).size()]));
        ((LayerDrawable)localObject1).setLayerInset(0, 0, 0, 0, 0);
        ((LayerDrawable)localObject1).setLayerInset(1, 0, 0, 0, 0);
        ((LayerDrawable)localObject1).setLayerInset(2, getSmallSurfaceLeftPx(), getSmallSurfaceTopPx(), ScreenUtil.getInstance().dip2px(8), getSwitchViewBottomPix());
        break;
      }
      if (this.mScreenState != 3) {
        break;
      }
      localObject1 = RGMapModeViewController.getInstance().getEnlargeBitmap();
      if (localObject1 != null)
      {
        LogUtil.e("drivingTool", "dingbin merge enlarge map");
        ((List)localObject2).add(new BitmapDrawable((Bitmap)localObject1));
        localObject1 = new LayerDrawable((Drawable[])((List)localObject2).toArray(new Drawable[((List)localObject2).size()]));
        ((LayerDrawable)localObject1).setLayerInset(0, 0, 0, 0, 0);
        ((LayerDrawable)localObject1).setLayerInset(1, 0, 0, 0, 0);
        ((LayerDrawable)localObject1).setLayerInset(2, getSmallSurfaceLeftPx(), getSmallSurfaceTopPx(), ScreenUtil.getInstance().dip2px(8), getSwitchViewBottomPix());
        break;
      }
      localObject1 = new LayerDrawable((Drawable[])((List)localObject2).toArray(new Drawable[((List)localObject2).size()]));
      ((LayerDrawable)localObject1).setLayerInset(0, 0, 0, 0, 0);
      ((LayerDrawable)localObject1).setLayerInset(1, 0, 0, 0, 0);
      break;
      label576:
      this.mBitmap = Bitmap.createBitmap(ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels(), Bitmap.Config.ARGB_8888);
      localObject2 = new Canvas(this.mBitmap);
      ((LayerDrawable)localObject1).setBounds(0, 0, ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels());
    }
  }
  
  /* Error */
  private void readPictureInBitmap()
  {
    // Byte code:
    //   0: new 198	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 371	com/baidu/navisdk/util/drivertool/BNScreentShotManager:getTmpStorePath	()Ljava/lang/String;
    //   8: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: new 373	java/io/FileInputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 376	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_2
    //   21: aload_0
    //   22: aload_2
    //   23: invokestatic 382	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   26: getstatic 385	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   29: iconst_1
    //   30: invokevirtual 389	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   33: putfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   36: aload_1
    //   37: invokevirtual 392	java/io/File:delete	()Z
    //   40: pop
    //   41: return
    //   42: astore_1
    //   43: return
    //   44: astore_1
    //   45: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	BNScreentShotManager
    //   11	26	1	localFile	File
    //   42	1	1	localException1	Exception
    //   44	1	1	localException2	Exception
    //   20	3	2	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   12	21	42	java/lang/Exception
    //   21	41	44	java/lang/Exception
  }
  
  private void releaseResource()
  {
    if ((this.mMapRenderBitmap != null) && (!this.mMapRenderBitmap.isRecycled()))
    {
      this.mMapRenderBitmap.recycle();
      this.mMapRenderBitmap = null;
    }
    if ((this.mColladaBitmap != null) && (!this.mColladaBitmap.isRecycled()))
    {
      this.mColladaBitmap.recycle();
      this.mColladaBitmap = null;
    }
    if ((this.mSwitchBitmap != null) && (!this.mSwitchBitmap.isRecycled()))
    {
      this.mSwitchBitmap.recycle();
      this.mSwitchBitmap = null;
    }
  }
  
  /* Error */
  private void savePicture(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 402	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 403	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +17 -> 31
    //   17: aload_0
    //   18: getfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   21: getstatic 409	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   24: bipush 90
    //   26: aload_1
    //   27: invokevirtual 413	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   30: pop
    //   31: aload_1
    //   32: ifnull +11 -> 43
    //   35: aload_1
    //   36: invokevirtual 416	java/io/FileOutputStream:flush	()V
    //   39: aload_1
    //   40: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   43: aload_0
    //   44: getfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   47: ifnull +139 -> 186
    //   50: aload_0
    //   51: getfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   54: invokevirtual 396	android/graphics/Bitmap:isRecycled	()Z
    //   57: ifne +129 -> 186
    //   60: aload_0
    //   61: getfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   64: invokevirtual 399	android/graphics/Bitmap:recycle	()V
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   72: return
    //   73: astore_1
    //   74: aload_3
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +11 -> 88
    //   80: aload_1
    //   81: invokevirtual 416	java/io/FileOutputStream:flush	()V
    //   84: aload_1
    //   85: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   88: aload_0
    //   89: getfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   92: ifnull -20 -> 72
    //   95: aload_0
    //   96: getfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   99: invokevirtual 396	android/graphics/Bitmap:isRecycled	()Z
    //   102: ifne -30 -> 72
    //   105: aload_0
    //   106: getfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   109: invokevirtual 399	android/graphics/Bitmap:recycle	()V
    //   112: aload_0
    //   113: aconst_null
    //   114: putfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   117: return
    //   118: astore_1
    //   119: aload_2
    //   120: ifnull +11 -> 131
    //   123: aload_2
    //   124: invokevirtual 416	java/io/FileOutputStream:flush	()V
    //   127: aload_2
    //   128: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   131: aload_0
    //   132: getfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   135: ifnull +25 -> 160
    //   138: aload_0
    //   139: getfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   142: invokevirtual 396	android/graphics/Bitmap:isRecycled	()Z
    //   145: ifne +15 -> 160
    //   148: aload_0
    //   149: getfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   152: invokevirtual 399	android/graphics/Bitmap:recycle	()V
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 64	com/baidu/navisdk/util/drivertool/BNScreentShotManager:mBitmap	Landroid/graphics/Bitmap;
    //   160: aload_1
    //   161: athrow
    //   162: astore_2
    //   163: goto -32 -> 131
    //   166: astore_3
    //   167: aload_1
    //   168: astore_2
    //   169: aload_3
    //   170: astore_1
    //   171: goto -52 -> 119
    //   174: astore_1
    //   175: goto -87 -> 88
    //   178: astore_2
    //   179: goto -103 -> 76
    //   182: astore_1
    //   183: goto -140 -> 43
    //   186: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	BNScreentShotManager
    //   0	187	1	paramString	String
    //   1	127	2	localObject1	Object
    //   162	1	2	localException1	Exception
    //   168	1	2	str	String
    //   178	1	2	localException2	Exception
    //   3	72	3	localObject2	Object
    //   166	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   4	13	73	java/lang/Exception
    //   4	13	118	finally
    //   123	131	162	java/lang/Exception
    //   17	31	166	finally
    //   80	88	174	java/lang/Exception
    //   17	31	178	java/lang/Exception
    //   35	43	182	java/lang/Exception
  }
  
  private Bitmap takeScreenShot()
  {
    Object localObject = BNaviModuleManager.getNaviActivity();
    if (localObject == null) {
      return null;
    }
    this.mDecorView = ((Activity)localObject).getWindow().getDecorView();
    int i = ((ColorDrawable)this.mDecorView.getBackground()).getColor();
    LogUtil.e("drivingTool", "colorid is, alph " + i);
    this.mDecorView.setBackgroundColor(0);
    this.mDecorView.setDrawingCacheEnabled(true);
    this.mDecorView.buildDrawingCache();
    Bitmap localBitmap = this.mDecorView.getDrawingCache();
    Rect localRect = new Rect();
    this.mDecorView.getWindowVisibleDisplayFrame(localRect);
    int j = localRect.top;
    localObject = Bitmap.createBitmap(localBitmap, 0, j, ((Activity)localObject).getWindowManager().getDefaultDisplay().getWidth(), ((Activity)localObject).getWindowManager().getDefaultDisplay().getHeight() - j);
    this.mDecorView.setBackgroundColor(i);
    return (Bitmap)localObject;
  }
  
  /* Error */
  private void test(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: new 198	java/io/File
    //   3: dup
    //   4: new 80	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 494
    //   14: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_2
    //   18: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc -16
    //   23: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 497	java/io/File:createNewFile	()Z
    //   37: pop
    //   38: new 402	java/io/FileOutputStream
    //   41: dup
    //   42: aload_2
    //   43: invokespecial 498	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   46: astore_2
    //   47: aload_1
    //   48: getstatic 409	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   51: bipush 100
    //   53: aload_2
    //   54: invokevirtual 413	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   57: pop
    //   58: aload_2
    //   59: invokevirtual 416	java/io/FileOutputStream:flush	()V
    //   62: aload_2
    //   63: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   66: return
    //   67: astore_1
    //   68: return
    //   69: astore_1
    //   70: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	BNScreentShotManager
    //   0	71	1	paramBitmap	Bitmap
    //   0	71	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   33	47	67	java/lang/Exception
    //   47	66	69	java/lang/Exception
  }
  
  public void captureSurfaceView(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 1)
    {
      if (getCaptureMapListener() != null) {
        getCaptureMapListener().getMapScreenshot(this.mCachePath, this.mHandler, 261);
      }
      return;
    }
    int[] arrayOfInt;
    IntBuffer localIntBuffer;
    int i;
    if (paramInt3 == 2)
    {
      BNDrivingToolUtils.sColladaRenderShow = false;
      localObject = new int[paramInt1 * paramInt2];
      arrayOfInt = new int[paramInt1 * paramInt2];
      localIntBuffer = IntBuffer.wrap((int[])localObject);
      localIntBuffer.position(0);
      GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, localIntBuffer);
      i = 0;
    }
    for (;;)
    {
      if (i >= paramInt2) {
        break label185;
      }
      int j = 0;
      for (;;)
      {
        if (j < paramInt1)
        {
          int k = localObject[(i * paramInt1 + j)];
          arrayOfInt[((paramInt2 - i - 1) * paramInt1 + j)] = (0xFF00FF00 & k | k << 16 & 0xFF0000 | k >> 16 & 0xFF);
          j += 1;
          continue;
          if (paramInt3 != 3) {
            break;
          }
          BNDrivingToolUtils.sSwitchRenderShow = false;
          break;
        }
      }
      i += 1;
    }
    label185:
    Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565).copyPixelsFromBuffer(localIntBuffer);
    Object localObject = Bitmap.createBitmap(arrayOfInt, paramInt1, paramInt2, Bitmap.Config.RGB_565);
    if (paramInt3 == 2) {
      this.mColladaBitmap = ((Bitmap)localObject);
    }
    for (;;)
    {
      BNDrivingToolUtils.sScreenShotCount += 1;
      this.mHandler.sendEmptyMessage(256);
      return;
      if (paramInt3 == 3) {
        this.mSwitchBitmap = ((Bitmap)localObject);
      }
    }
  }
  
  public CaptureMapListener getCaptureMapListener()
  {
    return this.captureMapListener;
  }
  
  public void handleCancel()
  {
    uninit();
    releaseResource();
  }
  
  public void handleSave()
  {
    this.mBitmap = BNDrivingToolUtils.addWaterMark(this.mBitmap, BNDrivingToolUtils.getLocationInfo(), BNDrivingToolUtils.getCurrentTimeInfo(), null);
    savePicture(getPicturePath());
    LogUtil.e("drivingTool", "finish time is " + System.currentTimeMillis());
    this.isSaveShot = true;
    handleCancel();
  }
  
  public void initParams()
  {
    this.mScreenState = BNDrivingToolUtils.getCurrentScreenState();
    if (BNaviModuleManager.getNaviActivity() == null) {
      return;
    }
    if (2 == 2)
    {
      this.mIsCross = true;
      if (!RGMapModeViewController.getInstance().isCommomViewShow()) {
        break label51;
      }
    }
    label51:
    for (this.mIsCommomViewShow = true;; this.mIsCommomViewShow = false)
    {
      BNDrivingToolUtils.setSurfaceViewState(true);
      return;
      this.mIsCross = false;
      break;
    }
  }
  
  public void rootScreenByMsg()
  {
    if (BNSettingManager.isShowJavaLog()) {
      BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask(RGEnlargeRoadMapModel.class.getSimpleName() + "setRasterImage", null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNScreentShotManager.getInstance().screenShortByMsg();
          return null;
        }
      }, new BNWorkerConfig(100, 0), 100L);
    }
  }
  
  public void rootScreenShot()
  {
    if (!screenShotByCommand())
    {
      BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
      return;
    }
    readPictureInBitmap();
    showImageInDialog(1);
  }
  
  public void saveImgDirect(final Bitmap paramBitmap)
  {
    if (!BNSettingManager.isShowJavaLog()) {
      return;
    }
    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask(RGEnlargeRoadMapModel.class.getSimpleName() + "savImg", null)new BNWorkerConfig
    {
      /* Error */
      protected String execute()
      {
        // Byte code:
        //   0: new 33	java/io/File
        //   3: dup
        //   4: invokestatic 36	com/baidu/navisdk/util/drivertool/BNScreentShotManager:getEnlargeImgPath	()Ljava/lang/String;
        //   7: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
        //   10: astore_1
        //   11: new 41	java/io/FileOutputStream
        //   14: dup
        //   15: aload_1
        //   16: invokespecial 44	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   19: astore_1
        //   20: aload_0
        //   21: getfield 20	com/baidu/navisdk/util/drivertool/BNScreentShotManager$6:val$bitmap	Landroid/graphics/Bitmap;
        //   24: getstatic 50	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
        //   27: bipush 90
        //   29: aload_1
        //   30: invokevirtual 56	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   33: pop
        //   34: aload_1
        //   35: invokevirtual 60	java/io/FileOutputStream:flush	()V
        //   38: aload_1
        //   39: invokevirtual 63	java/io/FileOutputStream:close	()V
        //   42: aconst_null
        //   43: areturn
        //   44: astore_1
        //   45: aload_1
        //   46: invokevirtual 66	java/lang/Exception:printStackTrace	()V
        //   49: goto -7 -> 42
        //   52: astore_1
        //   53: goto -8 -> 45
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	56	0	this	6
        //   10	29	1	localObject	Object
        //   44	2	1	localException1	Exception
        //   52	1	1	localException2	Exception
        // Exception table:
        //   from	to	target	type
        //   11	20	44	java/lang/Exception
        //   20	42	52	java/lang/Exception
      }
    }, new BNWorkerConfig(100, 0));
  }
  
  /* Error */
  public void screenShortByMsg()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 658	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   7: ldc_w 660
    //   10: invokevirtual 664	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   13: astore_1
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 4
    //   20: aload_1
    //   21: invokevirtual 670	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   24: astore 6
    //   26: aload 6
    //   28: astore 4
    //   30: aload 6
    //   32: astore 5
    //   34: aload 6
    //   36: new 80	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 672
    //   46: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: invokespecial 674	com/baidu/navisdk/util/drivertool/BNScreentShotManager:getRootPath	()Ljava/lang/String;
    //   53: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: ldc_w 676
    //   62: invokevirtual 682	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   65: invokevirtual 688	java/io/OutputStream:write	([B)V
    //   68: aload 6
    //   70: astore 4
    //   72: aload 6
    //   74: astore 5
    //   76: aload 6
    //   78: invokevirtual 689	java/io/OutputStream:flush	()V
    //   81: aload 6
    //   83: ifnull +12 -> 95
    //   86: aload_1
    //   87: astore_2
    //   88: aload_1
    //   89: astore_3
    //   90: aload 6
    //   92: invokevirtual 690	java/io/OutputStream:close	()V
    //   95: aload_1
    //   96: astore_2
    //   97: aload_1
    //   98: astore_3
    //   99: aload_1
    //   100: invokevirtual 693	java/lang/Process:waitFor	()I
    //   103: pop
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 696	java/lang/Process:destroy	()V
    //   112: return
    //   113: astore_2
    //   114: aload 4
    //   116: ifnull -21 -> 95
    //   119: aload_1
    //   120: astore_2
    //   121: aload_1
    //   122: astore_3
    //   123: aload 4
    //   125: invokevirtual 690	java/io/OutputStream:close	()V
    //   128: goto -33 -> 95
    //   131: astore_1
    //   132: aload_2
    //   133: ifnull -21 -> 112
    //   136: aload_2
    //   137: invokevirtual 696	java/lang/Process:destroy	()V
    //   140: return
    //   141: astore 4
    //   143: aload 5
    //   145: ifnull +12 -> 157
    //   148: aload_1
    //   149: astore_2
    //   150: aload_1
    //   151: astore_3
    //   152: aload 5
    //   154: invokevirtual 690	java/io/OutputStream:close	()V
    //   157: aload_1
    //   158: astore_2
    //   159: aload_1
    //   160: astore_3
    //   161: aload 4
    //   163: athrow
    //   164: astore_1
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 696	java/lang/Process:destroy	()V
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	BNScreentShotManager
    //   13	109	1	localProcess	Process
    //   131	29	1	localException1	Exception
    //   164	10	1	localObject1	Object
    //   3	94	2	localObject2	Object
    //   113	1	2	localException2	Exception
    //   120	39	2	localObject3	Object
    //   1	169	3	localObject4	Object
    //   18	106	4	localObject5	Object
    //   141	21	4	localObject6	Object
    //   15	138	5	localObject7	Object
    //   24	67	6	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   20	26	113	java/lang/Exception
    //   34	68	113	java/lang/Exception
    //   76	81	113	java/lang/Exception
    //   4	14	131	java/lang/Exception
    //   90	95	131	java/lang/Exception
    //   99	104	131	java/lang/Exception
    //   123	128	131	java/lang/Exception
    //   152	157	131	java/lang/Exception
    //   161	164	131	java/lang/Exception
    //   20	26	141	finally
    //   34	68	141	finally
    //   76	81	141	finally
    //   4	14	164	finally
    //   90	95	164	finally
    //   99	104	164	finally
    //   123	128	164	finally
    //   152	157	164	finally
    //   161	164	164	finally
  }
  
  public boolean screenShot()
  {
    Activity localActivity = BNaviModuleManager.getNaviActivity();
    if (localActivity != null) {
      BNDrivingToolManager.getInstance().asynAntiGeoSearch(localActivity);
    }
    return true;
  }
  
  public boolean screenShotByCommand()
  {
    boolean bool = false;
    localObject7 = null;
    localObject6 = null;
    for (;;)
    {
      try
      {
        localProcess = Runtime.getRuntime().exec("su");
        localObject4 = null;
        localObject2 = null;
      }
      catch (Exception localException1)
      {
        Process localProcess;
        Object localObject4;
        Object localObject2;
        OutputStream localOutputStream;
        Object localObject5;
        if (localObject6 == null) {
          continue;
        }
        ((Process)localObject6).destroy();
        continue;
      }
      finally
      {
        if (localObject7 == null) {
          continue;
        }
        ((Process)localObject7).destroy();
      }
      try
      {
        localOutputStream = localProcess.getOutputStream();
        localObject2 = localOutputStream;
        localObject4 = localOutputStream;
        localOutputStream.write(("screencap -p " + getTmpStorePath()).getBytes("utf-8"));
        localObject2 = localOutputStream;
        localObject4 = localOutputStream;
        localOutputStream.flush();
        if (localOutputStream != null)
        {
          localObject6 = localProcess;
          localObject7 = localProcess;
          localOutputStream.close();
        }
        localObject6 = localProcess;
        localObject7 = localProcess;
        localProcess.waitFor();
        if (localProcess != null) {
          localProcess.destroy();
        }
        bool = true;
      }
      catch (Exception localException2)
      {
        localObject5 = localObject2;
        BNSettingManager.setRootScreenshotState(false);
        if (localObject2 == null) {
          continue;
        }
        localObject6 = localProcess;
        localObject7 = localProcess;
        ((OutputStream)localObject2).close();
        if (localProcess == null) {
          continue;
        }
        localProcess.destroy();
        return false;
      }
      finally
      {
        if (localObject5 == null) {
          continue;
        }
        localObject6 = localProcess;
        localObject7 = localProcess;
        ((OutputStream)localObject5).close();
        localObject6 = localProcess;
        localObject7 = localProcess;
      }
    }
    return bool;
  }
  
  public void screenShotFinish()
  {
    if (this.mBitmap == null)
    {
      BNSettingManager.setRootScreenshotState(false);
      releaseResource();
      BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
      return;
    }
    BNDrivingToolUtils.sIssueOccurTime = System.currentTimeMillis();
    BNDrivingToolIssueStoreDialog localBNDrivingToolIssueStoreDialog = BNDrivingToolManager.getInstance().getIssueStoreDialog(3);
    localBNDrivingToolIssueStoreDialog.show();
    this.isSaveShot = false;
    localBNDrivingToolIssueStoreDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        if (!BNScreentShotManager.this.isSaveShot) {
          BNScreentShotManager.this.handleCancel();
        }
        BNScreentShotManager.this.isSaveShot = false;
      }
    });
  }
  
  public void setCaptureMapListener(CaptureMapListener paramCaptureMapListener)
  {
    this.captureMapListener = paramCaptureMapListener;
  }
  
  public void showImageInDialog(int paramInt)
  {
    this.mShowDialog = new BNDrivingToolImageShowDialog(BNaviModuleManager.getNaviActivity());
    this.mShowDialog.show();
    this.mShowDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        BNScreentShotManager.this.screenShot();
      }
    });
    if (paramInt == 0) {
      this.mHandler.sendEmptyMessage(258);
    }
    while (paramInt != 1) {
      return;
    }
    this.mHandler.sendEmptyMessage(257);
  }
  
  /* Error */
  public void testSavePic(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: new 198	java/io/File
    //   3: dup
    //   4: new 80	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 738
    //   14: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_2
    //   18: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc -16
    //   23: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_2
    //   33: new 402	java/io/FileOutputStream
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 498	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: astore_2
    //   42: aload_1
    //   43: getstatic 409	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   46: bipush 90
    //   48: aload_2
    //   49: invokevirtual 413	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   52: pop
    //   53: aload_2
    //   54: invokevirtual 416	java/io/FileOutputStream:flush	()V
    //   57: aload_2
    //   58: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   61: return
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 741	java/lang/Exception:printStackTrace	()V
    //   67: return
    //   68: astore_1
    //   69: goto -6 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	BNScreentShotManager
    //   0	72	1	paramBitmap	Bitmap
    //   0	72	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   33	42	62	java/lang/Exception
    //   42	61	68	java/lang/Exception
  }
  
  public void uninit()
  {
    if (this.mDecorView != null)
    {
      this.mDecorView.destroyDrawingCache();
      this.mDecorView.setDrawingCacheEnabled(false);
    }
  }
  
  public static abstract interface CaptureMapListener
  {
    public abstract void getMapScreenshot(String paramString, Handler paramHandler, int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/BNScreentShotManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */