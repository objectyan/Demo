package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.control.RGLaneLineController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import com.baidu.navisdk.util.drivertool.BNScreentShotManager;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.map.ColladaGLSurfaceView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RGMMEnlargeRoadMapView
  extends BNBaseView
{
  public static final String TAG = RGMMEnlargeRoadMapView.class.getSimpleName();
  private Animation.AnimationListener animationListener = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (RGMMEnlargeRoadMapView.this.mEnlargeRoadMapView != null) {
        RGMMEnlargeRoadMapView.this.mEnlargeRoadMapView.setVisibility(8);
      }
      RGMapModeViewController.getInstance().setIsShowEnlargeRoadMap(false);
    }
    
    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  private View bnav_rg_enlarge_image_mask;
  private Animation.AnimationListener colladaAnimationListener = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      RGMMEnlargeRoadMapView.this.showColladaWithoutAnimation(false);
    }
    
    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  private ImageView mCarPosImgView;
  private View mCarPosLayout;
  private int mCarPosX = 0;
  private int mCarPosY = 0;
  private int mCarRotate;
  private View mColladaCloseImage = null;
  private ColladaGLSurfaceView mColladaGLSurfaceView;
  private LinearLayout mColladaLayout = null;
  private View mColladaRl = null;
  private View mEnlargeGuideInfoBackground = null;
  private ImageView mEnlargeImageView = null;
  private View mEnlargeRoadMapView = null;
  private TextView mEnterNextRoadTV = null;
  private boolean mForceRefreshImage = false;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  Animation mInAnimation = null;
  private Animation.AnimationListener mInListener = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (RGLaneLineController.getInstance().isNormalEnlargeShow)
      {
        LogUtil.e(RGLaneInfoModel.TAG, "enlagre onAnimationEnd");
        RGMapModeViewController.getInstance().handleLaneEnlargeShow(true);
      }
      BNScreentShotManager.getInstance().rootScreenByMsg();
    }
    
    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  private TextView mNextRoadTV = null;
  Animation mOutAnimation = null;
  private int mProgress;
  private ProgressBar mProgressBar = null;
  private int mRemDist;
  private TextView mRemainDistTV = null;
  private TextView mRemainDistUnitTV = null;
  private String mRoadName;
  private Matrix mRotateMatrix;
  private FrameLayout mStreetLayout;
  private ImageView mSwitchView = null;
  private int mTotalDist;
  private ImageView mTurnIcon = null;
  private int mTurnIconId = 0;
  private boolean mbUpdateRasterInfo;
  private String rasterType;
  
  public RGMMEnlargeRoadMapView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {
      return;
    }
    Object localObject = (ViewStub)this.mRootViewGroup.findViewById(1711866542);
    if (localObject != null) {
      this.mEnlargeRoadMapView = ((ViewStub)localObject).inflate();
    }
    this.mEnlargeGuideInfoBackground = this.mRootViewGroup.findViewById(1711866598);
    this.mEnlargeImageView = ((ImageView)this.mRootViewGroup.findViewById(1711866599));
    this.mRemainDistTV = ((TextView)this.mRootViewGroup.findViewById(1711866602));
    this.mRemainDistUnitTV = ((TextView)this.mRootViewGroup.findViewById(1711866603));
    this.mNextRoadTV = ((TextView)this.mRootViewGroup.findViewById(1711866606));
    this.mEnterNextRoadTV = ((TextView)this.mRootViewGroup.findViewById(1711866605));
    this.mTurnIcon = ((ImageView)this.mRootViewGroup.findViewById(1711866604));
    this.mProgressBar = ((ProgressBar)this.mRootViewGroup.findViewById(1711866607));
    this.mSwitchView = ((ImageView)this.mRootViewGroup.findViewById(1711866608));
    this.mRotateMatrix = new Matrix();
    this.mCarPosLayout = this.mRootViewGroup.findViewById(1711866609);
    this.mCarPosImgView = ((ImageView)this.mRootViewGroup.findViewById(1711866610));
    this.mStreetLayout = ((FrameLayout)this.mRootViewGroup.findViewById(1711866611));
    this.bnav_rg_enlarge_image_mask = this.mRootViewGroup.findViewById(1711866600);
    this.mColladaCloseImage = this.mRootViewGroup.findViewById(1711866545);
    this.mColladaRl = this.mRootViewGroup.findViewById(1711866543);
    this.mColladaLayout = ((LinearLayout)this.mRootViewGroup.findViewById(1711866544));
    if (this.mColladaLayout != null) {
      this.mColladaLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          UserOPController.getInstance().add("3.q", null, "99", null);
          RGMapModeViewController.getInstance().setmIsShowColladaView(false);
          RouteGuideFSM.getInstance().run("收到collada隐藏消息");
          RGMMEnlargeRoadMapView.this.resetColladaView();
        }
      });
    }
    this.mColladaCloseImage.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UserOPController.getInstance().add("3.q", null, "99", null);
        RGMapModeViewController.getInstance().setmIsShowColladaView(false);
        RouteGuideFSM.getInstance().run("收到collada隐藏消息");
        RGMMEnlargeRoadMapView.this.resetColladaView();
      }
    });
    this.mSwitchView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UserOPController.getInstance().add("3.q", null, String.valueOf(RGEnlargeRoadMapModel.getInstance().getEnlargeMapTypeForStatisitcs()), null);
        RGEnlargeRoadMapModel.getInstance().setEnlargeMapTypeForStatisitcs(0);
        RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(false);
        RouteGuideFSM.getInstance().run("收到放大图隐藏消息");
      }
    });
    this.mEnlargeRoadMapView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UserOPController.getInstance().add("3.q", null, String.valueOf(RGEnlargeRoadMapModel.getInstance().getEnlargeMapTypeForStatisitcs()), null);
        RGEnlargeRoadMapModel.getInstance().setEnlargeMapTypeForStatisitcs(0);
        RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(false);
        RouteGuideFSM.getInstance().run("收到放大图隐藏消息");
      }
    });
    if (RGViewController.getInstance().getOrientation() == 2)
    {
      this.mInAnimation = JarUtils.loadAnimation(this.mContext, 1711538187);
      this.mOutAnimation = JarUtils.loadAnimation(this.mContext, 1711538190);
      localObject = this.mEnlargeRoadMapView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = (ScreenUtil.getInstance().getHeightPixels() / 2);
      ((ViewGroup.LayoutParams)localObject).height = ScreenUtil.getInstance().getWidthPixels();
      this.mEnlargeRoadMapView.requestLayout();
      localObject = this.mColladaRl.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = (ScreenUtil.getInstance().getHeightPixels() / 2);
      ((ViewGroup.LayoutParams)localObject).height = ScreenUtil.getInstance().getWidthPixels();
      this.mColladaRl.requestLayout();
    }
    for (;;)
    {
      resetColladaView();
      updateDataByLastest();
      return;
      this.mInAnimation = JarUtils.loadAnimation(this.mContext, 1711538188);
      this.mOutAnimation = JarUtils.loadAnimation(this.mContext, 1711538191);
      localObject = this.mEnlargeRoadMapView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ScreenUtil.getInstance().getWidthPixels();
      ((ViewGroup.LayoutParams)localObject).height = (ScreenUtil.getInstance().getHeightPixels() / 2);
      this.mEnlargeRoadMapView.requestLayout();
      localObject = this.mColladaRl.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ScreenUtil.getInstance().getWidthPixels();
      ((ViewGroup.LayoutParams)localObject).height = (ScreenUtil.getInstance().getHeightPixels() / 2);
      this.mColladaRl.requestLayout();
    }
  }
  
  private void progressRun()
  {
    LogUtil.e(TAG, "update raster, raster type=" + this.rasterType + "," + this.mbUpdateRasterInfo + "," + this.mForceRefreshImage);
    if ((this.mbUpdateRasterInfo) || (this.mForceRefreshImage))
    {
      this.mForceRefreshImage = false;
      if (!"raster_direct_board".equals(this.rasterType)) {
        break label104;
      }
      updateDirectBoardView();
    }
    for (;;)
    {
      updateProgress();
      updateRoadInfo();
      updateTurnIcon();
      return;
      label104:
      if ("raster_grid".equals(this.rasterType)) {
        updateSimpleModelView();
      } else if ("raster_vector".equals(this.rasterType)) {
        updateVectorMapView();
      } else if ("raster_street".equals(this.rasterType)) {
        updateStreetView();
      }
    }
  }
  
  private void progressRun(boolean paramBoolean)
  {
    LogUtil.e(TAG, "update raster, raster type=" + this.rasterType + "show," + paramBoolean + "," + this.mForceRefreshImage);
    if ((paramBoolean) || (this.mForceRefreshImage))
    {
      this.mForceRefreshImage = false;
      if (!"raster_direct_board".equals(this.rasterType)) {
        break label98;
      }
      updateDirectBoardView();
    }
    for (;;)
    {
      updateProgress();
      updateRoadInfo();
      updateTurnIcon();
      return;
      label98:
      if ("raster_grid".equals(this.rasterType)) {
        updateSimpleModelView();
      } else if ("raster_vector".equals(this.rasterType)) {
        updateVectorMapView();
      } else if ("raster_street".equals(this.rasterType)) {
        updateStreetView();
      }
    }
  }
  
  private void showColladaWithoutAnimation(boolean paramBoolean)
  {
    if (this.mColladaRl != null)
    {
      LogUtil.e(RGLaneInfoModel.TAG, "showColladaWithoutAnimation " + paramBoolean);
      RGMapModeViewController.getInstance().handleLaneEnlargeShow(paramBoolean);
      if (!paramBoolean) {
        break label126;
      }
      this.mColladaGLSurfaceView = new ColladaGLSurfaceView(this.mContext);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      if (this.mColladaLayout != null)
      {
        this.mColladaLayout.removeAllViews();
        this.mColladaLayout.addView(this.mColladaGLSurfaceView, localLayoutParams);
        this.mColladaLayout.requestLayout();
      }
      RGMapModeViewController.getInstance().handleAssistHighwayShow(false);
      this.mColladaRl.setVisibility(0);
      this.mColladaGLSurfaceView.setVisibility(0);
    }
    label126:
    do
    {
      return;
      RGMapModeViewController.getInstance().handleAssistHighwayShow(true);
      this.mColladaRl.setVisibility(8);
    } while (this.mColladaGLSurfaceView == null);
    this.mColladaGLSurfaceView.setVisibility(8);
  }
  
  /* Error */
  private void updateDirectBoardView()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 98	com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMEnlargeRoadMapView:mEnlargeImageView	Landroid/widget/ImageView;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 90	com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMEnlargeRoadMapView:mEnlargeGuideInfoBackground	Landroid/view/View;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 98	com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMEnlargeRoadMapView:mEnlargeImageView	Landroid/widget/ImageView;
    //   25: invokestatic 398	com/baidu/navisdk/ui/util/UIUtils:releaseImageView	(Landroid/widget/ImageView;)V
    //   28: invokestatic 403	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:getInstance	()Lcom/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel;
    //   31: invokevirtual 407	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:getArrowBitmap	()Landroid/graphics/Bitmap;
    //   34: ifnull +45 -> 79
    //   37: invokestatic 403	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:getInstance	()Lcom/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel;
    //   40: invokevirtual 410	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:getBGBitmap	()Landroid/graphics/Bitmap;
    //   43: ifnull +36 -> 79
    //   46: aload_0
    //   47: getfield 98	com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMEnlargeRoadMapView:mEnlargeImageView	Landroid/widget/ImageView;
    //   50: invokestatic 403	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:getInstance	()Lcom/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel;
    //   53: invokevirtual 407	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:getArrowBitmap	()Landroid/graphics/Bitmap;
    //   56: invokevirtual 414	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   59: aload_0
    //   60: getfield 98	com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMEnlargeRoadMapView:mEnlargeImageView	Landroid/widget/ImageView;
    //   63: new 416	android/graphics/drawable/BitmapDrawable
    //   66: dup
    //   67: invokestatic 403	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:getInstance	()Lcom/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel;
    //   70: invokevirtual 410	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:getBGBitmap	()Landroid/graphics/Bitmap;
    //   73: invokespecial 418	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   76: invokevirtual 422	android/widget/ImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   79: aload_0
    //   80: getfield 90	com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMEnlargeRoadMapView:mEnlargeGuideInfoBackground	Landroid/view/View;
    //   83: iconst_0
    //   84: invokevirtual 391	android/view/View:setVisibility	(I)V
    //   87: aload_0
    //   88: getfield 98	com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMEnlargeRoadMapView:mEnlargeImageView	Landroid/widget/ImageView;
    //   91: iconst_0
    //   92: invokevirtual 423	android/widget/ImageView:setVisibility	(I)V
    //   95: goto -77 -> 18
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	RGMMEnlargeRoadMapView
    //   13	2	1	localView	View
    //   98	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	98	finally
    //   21	79	98	finally
    //   79	95	98	finally
  }
  
  private void updateProgress()
  {
    if ((this.mRemainDistTV == null) || (this.mProgressBar == null) || (this.mStreetLayout == null) || (this.mRemainDistUnitTV == null)) {
      LogUtil.e(TAG, "updateProgress fail has null view");
    }
    label567:
    do
    {
      return;
      StringBuffer localStringBuffer = new StringBuffer();
      StringUtils.formatDistance(this.mRemDist, StringUtils.UnitLangEnum.ZH, localStringBuffer);
      String str2 = "";
      str4 = "";
      localObject1 = str2;
      try
      {
        Matcher localMatcher = Pattern.compile("\\d+").matcher(localStringBuffer);
        str3 = str4;
        str1 = str2;
        localObject1 = str2;
        if (localMatcher.find())
        {
          localObject1 = str2;
          int i = localMatcher.end();
          str3 = str4;
          str1 = str2;
          if (i >= 0)
          {
            str3 = str4;
            str1 = str2;
            localObject1 = str2;
            if (i < localStringBuffer.length())
            {
              localObject1 = str2;
              str1 = localStringBuffer.substring(0, i);
              localObject1 = str1;
              str3 = localStringBuffer.substring(i);
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str1;
          String str3 = str4;
          Object localObject2 = localObject1;
        }
      }
      LogUtil.e(TAG, "updateProgress distance = " + localStringBuffer + ", distanceValue = " + str1 + ", distanceUnit = " + str3);
      if (("raster_vector".equals(this.rasterType)) || ("raster_street".equals(this.rasterType)) || ("raster_direct_board".equals(this.rasterType)) || ("raster_grid".equals(this.rasterType))) {
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)))
        {
          this.mRemainDistTV.setVisibility(0);
          this.mRemainDistUnitTV.setVisibility(0);
          if (this.mRemDist < 10)
          {
            this.mRemainDistTV.setText("现在");
            this.mRemainDistUnitTV.setText("");
          }
        }
      }
      for (;;)
      {
        this.mProgressBar.setProgress(this.mProgress);
        if ("raster_vector".equals(this.rasterType)) {
          break;
        }
        if (!"raster_street".equals(this.rasterType)) {
          break label567;
        }
        this.mStreetLayout.setVisibility(0);
        if (this.mCarPosImgView == null) {
          break;
        }
        this.mCarPosImgView.setVisibility(4);
        return;
        this.mRemainDistTV.setText(str1);
        this.mRemainDistUnitTV.setText(str3 + "后");
        continue;
        this.mRemainDistTV.setVisibility(8);
        this.mRemainDistUnitTV.setVisibility(8);
        continue;
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)))
        {
          this.mRemainDistTV.setVisibility(0);
          this.mRemainDistUnitTV.setVisibility(0);
          if (this.mRemDist < 10)
          {
            this.mRemainDistTV.setText("现在");
            this.mRemainDistUnitTV.setText("");
          }
          else
          {
            this.mRemainDistTV.setText(str1);
            this.mRemainDistUnitTV.setText(str3 + "后");
          }
        }
        else
        {
          this.mRemainDistTV.setVisibility(8);
          this.mRemainDistUnitTV.setVisibility(8);
        }
      }
    } while (this.mCarPosImgView == null);
    this.mCarPosImgView.setVisibility(4);
  }
  
  private void updateRoadInfo()
  {
    if ((this.mNextRoadTV == null) || (this.mEnterNextRoadTV == null))
    {
      LogUtil.e(TAG, "updateRoadInfo fail view is null");
      return;
    }
    LogUtil.e(TAG, "updateRoadInfo, roadName=" + this.mRoadName);
    if (("raster_vector".equals(this.rasterType)) || ("raster_direct_board".equals(this.rasterType)) || ("raster_grid".equals(this.rasterType)))
    {
      this.mNextRoadTV.setVisibility(0);
      this.mEnterNextRoadTV.setVisibility(0);
      this.mEnterNextRoadTV.setText(JarUtils.getResources().getString(1711669862));
      if (!TextUtils.isEmpty(this.mRoadName))
      {
        this.mNextRoadTV.setText(this.mRoadName);
        return;
      }
      this.mNextRoadTV.setText(JarUtils.getResources().getString(1711669364));
      return;
    }
    if ("raster_street".equals(this.rasterType))
    {
      this.mEnterNextRoadTV.setVisibility(0);
      this.mEnterNextRoadTV.setText(JarUtils.getResources().getString(1711669863));
      if (!TextUtils.isEmpty(this.mRoadName))
      {
        this.mNextRoadTV.setVisibility(0);
        this.mNextRoadTV.setText(this.mRoadName);
        return;
      }
      this.mNextRoadTV.setVisibility(8);
      return;
    }
    this.mNextRoadTV.setVisibility(8);
    this.mEnterNextRoadTV.setVisibility(8);
  }
  
  private void updateSimpleModelView()
  {
    if ((this.mEnlargeImageView == null) || (this.mEnlargeGuideInfoBackground == null)) {
      return;
    }
    UIUtils.releaseImageView(this.mEnlargeImageView);
    if ((RGEnlargeRoadMapModel.getInstance().getArrowBitmap() != null) && (RGEnlargeRoadMapModel.getInstance().getBGBitmap() != null))
    {
      this.mEnlargeImageView.setImageBitmap(RGEnlargeRoadMapModel.getInstance().getArrowBitmap());
      this.mEnlargeImageView.setBackgroundDrawable(new BitmapDrawable(RGEnlargeRoadMapModel.getInstance().getBGBitmap()));
    }
    this.mEnlargeGuideInfoBackground.setVisibility(0);
    this.mEnlargeImageView.setVisibility(0);
  }
  
  private void updateStreetView()
  {
    if ((this.mEnlargeImageView == null) || (this.mEnlargeGuideInfoBackground == null)) {}
    do
    {
      return;
      LogUtil.e(TAG, "updateStreetView, roadName=" + this.mRoadName);
      UIUtils.releaseImageView(this.mEnlargeImageView);
      if (RGEnlargeRoadMapModel.getInstance().getBGBitmap() != null)
      {
        LogUtil.e(TAG, "!# updateVectorMapView: set bitmap");
        this.mEnlargeImageView.setImageBitmap(RGEnlargeRoadMapModel.getInstance().getBGBitmap());
        this.mEnlargeImageView.setBackgroundResource(17170445);
      }
      this.mEnlargeGuideInfoBackground.setVisibility(0);
      this.mEnlargeImageView.setVisibility(0);
    } while ((this.bnav_rg_enlarge_image_mask == null) || (BNStyleManager.getDayStyle()));
    this.bnav_rg_enlarge_image_mask.setVisibility(0);
  }
  
  private void updateTurnIcon()
  {
    if (this.mTurnIcon == null) {
      return;
    }
    if (("raster_vector".equals(this.rasterType)) || ("raster_direct_board".equals(this.rasterType)) || ("raster_grid".equals(this.rasterType)))
    {
      if ((this.mTurnIconId != 0) && (this.mTurnIconId != 1711407751))
      {
        this.mTurnIcon.setVisibility(0);
        try
        {
          if (RightHandResourcesProvider.getEnNaviType() == 0) {
            this.mTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(this.mTurnIconId));
          }
          for (;;)
          {
            this.mTurnIconId = 0;
            return;
            this.mTurnIcon.setImageDrawable(RightHandResourcesProvider.getDrawableIncludeRightHandIcon(this.mTurnIconId));
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            LogUtil.e(TAG, "updateTurnIcon setImageDrawable throwable");
          }
        }
      }
      this.mTurnIcon.setVisibility(8);
      return;
    }
    this.mTurnIcon.setVisibility(8);
  }
  
  private void updateVectorMapCarPos()
  {
    if (RGEnlargeRoadMapModel.getInstance().getBGBitmap() == null) {
      LogUtil.e(TAG, "!# %%%%%%%%% No vector expand map!! %%%%%%%%%");
    }
    do
    {
      return;
      if ((RGEnlargeRoadMapModel.getInstance().getVectorImgWidth() == 0) || (RGEnlargeRoadMapModel.getInstance().getVectorImgHeight() == 0))
      {
        LogUtil.e(TAG, "!# %%%%%%%%% Unkown vector map width or height!!");
        return;
      }
      double d1 = this.mCarPosLayout.getWidth() / RGEnlargeRoadMapModel.getInstance().getVectorImgWidth();
      double d2 = this.mCarPosLayout.getHeight() / RGEnlargeRoadMapModel.getInstance().getVectorImgHeight();
      this.mCarPosX -= ScreenUtil.getInstance().dip2px(42) / 2;
      this.mCarPosY -= ScreenUtil.getInstance().dip2px(46) / 2;
      LogUtil.e(TAG, "!# adjust car pos X=" + this.mCarPosX + ", Y=" + this.mCarPosY + String.format(", xScale=%1$.2f, yScale=%2$.2f", new Object[] { Double.valueOf(d1), Double.valueOf(d2) }) + ", layout W=" + this.mCarPosLayout.getWidth() + ", H=" + this.mCarPosLayout.getHeight());
      if ((this.mCarPosX <= this.mCarPosLayout.getWidth()) && (this.mCarPosY <= this.mCarPosLayout.getHeight())) {
        break;
      }
      LogUtil.e(TAG, "!# out of vector map, W=" + this.mCarPosLayout.getWidth() + ", H=" + this.mCarPosLayout.getHeight());
    } while (this.mCarPosImgView == null);
    this.mCarPosImgView.setVisibility(8);
    this.mCarPosImgView.setImageBitmap(null);
    this.mCarPosImgView.setBackgroundResource(17170445);
    this.mCarPosImgView.setBackgroundDrawable(null);
    return;
    Object localObject = ((BitmapDrawable)BNStyleManager.getDrawable(1711407812)).getBitmap();
    this.mRotateMatrix.setRotate(this.mCarRotate);
    localObject = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), this.mRotateMatrix, true);
    this.mCarPosImgView.setImageBitmap((Bitmap)localObject);
    localObject = new AbsoluteLayout.LayoutParams(ScreenUtil.getInstance().dip2px(42), ScreenUtil.getInstance().dip2px(46), this.mCarPosX, this.mCarPosY);
    this.mCarPosImgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mCarPosImgView.setVisibility(0);
    this.mCarPosImgView.invalidate();
    RGEnlargeRoadMapModel.getInstance().updateLastCarPos(this.mCarPosX, this.mCarPosY, this.mCarRotate);
  }
  
  private void updateVectorMapView()
  {
    if ((this.mEnlargeImageView == null) || (this.mEnlargeGuideInfoBackground == null)) {
      return;
    }
    UIUtils.releaseImageView(this.mEnlargeImageView);
    LogUtil.e(TAG, "!# updateVectorMapView:");
    if (RGEnlargeRoadMapModel.getInstance().getBGBitmap() != null)
    {
      LogUtil.e(TAG, "!# updateVectorMapView: set bitmap");
      this.mEnlargeImageView.setImageBitmap(RGEnlargeRoadMapModel.getInstance().getBGBitmap());
      this.mEnlargeImageView.setBackgroundResource(17170445);
    }
    this.mEnlargeGuideInfoBackground.setVisibility(0);
    this.mEnlargeImageView.setVisibility(0);
  }
  
  public void dispose()
  {
    super.dispose();
    LogUtil.e(TAG, "onDispose start.");
    UIUtils.releaseImageView(this.mEnlargeImageView);
    UIUtils.releaseImageView(this.mCarPosImgView);
    LogUtil.e(TAG, "onDispose end.");
  }
  
  public Bitmap getEnlargeBitmap()
  {
    Object localObject = null;
    try
    {
      if (RGEnlargeRoadMapModel.getInstance().getBGBitmap() != null)
      {
        Bitmap localBitmap = Bitmap.createBitmap(RGEnlargeRoadMapModel.getInstance().getBGBitmap().getWidth(), RGEnlargeRoadMapModel.getInstance().getBGBitmap().getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        Matrix localMatrix = new Matrix();
        localCanvas.drawBitmap(RGEnlargeRoadMapModel.getInstance().getBGBitmap(), localMatrix, localPaint);
        if (!"raster_direct_board".equals(this.rasterType))
        {
          localObject = localBitmap;
          if (!"raster_grid".equals(this.rasterType)) {}
        }
        else
        {
          localObject = localBitmap;
          if (RGEnlargeRoadMapModel.getInstance().getArrowBitmap() != null)
          {
            localCanvas.drawBitmap(RGEnlargeRoadMapModel.getInstance().getArrowBitmap(), localMatrix, localPaint);
            localObject = localBitmap;
          }
        }
      }
      return (Bitmap)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public Bitmap getEnlargeViewBitmap()
  {
    this.mEnlargeRoadMapView.setDrawingCacheEnabled(true);
    return this.mEnlargeRoadMapView.getDrawingCache();
  }
  
  public void hide()
  {
    if (!RGEnlargeRoadMapModel.getInstance().canEnlargeViewHide()) {}
    do
    {
      return;
      super.hide();
      if (this.mEnlargeRoadMapView != null)
      {
        RGLaneLineController.getInstance().isNormalEnlargeShow = false;
        this.mInAnimation.setAnimationListener(null);
        this.mOutAnimation.setAnimationListener(this.animationListener);
        this.mEnlargeRoadMapView.startAnimation(this.mOutAnimation);
      }
      if (this.mSwitchView != null) {
        this.mSwitchView.setVisibility(4);
      }
      if (this.mCarPosLayout != null) {
        this.mCarPosLayout.setVisibility(8);
      }
      if (this.mCarPosImgView != null) {
        this.mCarPosImgView.setVisibility(4);
      }
      if (this.mStreetLayout != null) {
        this.mStreetLayout.setVisibility(4);
      }
    } while (this.bnav_rg_enlarge_image_mask == null);
    this.bnav_rg_enlarge_image_mask.setVisibility(4);
  }
  
  public void hideWithoutAnimation()
  {
    if (this.mEnlargeRoadMapView != null)
    {
      RGLaneLineController.getInstance().isNormalEnlargeShow = false;
      this.mEnlargeRoadMapView.setVisibility(8);
    }
    if (this.mCarPosLayout != null) {
      this.mCarPosLayout.setVisibility(8);
    }
    if (this.mCarPosImgView != null) {
      this.mCarPosImgView.setVisibility(4);
    }
    if (this.mStreetLayout != null) {
      this.mStreetLayout.setVisibility(4);
    }
    if (this.bnav_rg_enlarge_image_mask != null) {
      this.bnav_rg_enlarge_image_mask.setVisibility(4);
    }
    RGMapModeViewController.getInstance().setIsShowEnlargeRoadMap(false);
  }
  
  public boolean isEnlargeOrColladaShow()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.mEnlargeRoadMapView != null)
    {
      if (this.mEnlargeRoadMapView.getVisibility() == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        return bool1;
      }
    }
    if (this.mColladaRl != null)
    {
      if (this.mColladaRl.getVisibility() == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        return bool1;
      }
    }
    return bool2;
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
  }
  
  public void reset()
  {
    UIUtils.releaseImageViewWithoutNull(this.mEnlargeImageView);
    UIUtils.releaseImageViewWithoutNull(this.mCarPosImgView);
  }
  
  public void resetColladaView()
  {
    if (this.mColladaLayout != null) {
      this.mColladaLayout.removeAllViews();
    }
    this.mColladaGLSurfaceView = null;
  }
  
  public void show()
  {
    super.show();
    if (this.mEnlargeRoadMapView != null)
    {
      RGLaneLineController.getInstance().isNormalEnlargeShow = true;
      this.mInAnimation.setAnimationListener(this.mInListener);
      this.mEnlargeRoadMapView.startAnimation(this.mInAnimation);
      this.mEnlargeRoadMapView.setVisibility(0);
    }
    if (this.mSwitchView != null) {
      this.mSwitchView.setVisibility(0);
    }
    if ("raster_vector".equals(this.rasterType)) {}
    for (;;)
    {
      RGMapModeViewController.getInstance().setIsShowEnlargeRoadMap(true);
      return;
      if ("raster_street".equals(this.rasterType)) {
        this.mStreetLayout.setVisibility(0);
      }
    }
  }
  
  public void showColladaView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      showColladaWithoutAnimation(true);
      return;
    }
    showColladaWithoutAnimation(false);
  }
  
  public void updateData(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      LogUtil.e(TAG, "b == null");
      return;
    }
    if (this.mEnlargeRoadMapView != null)
    {
      updateRasterMapInfo(paramBundle.getBoolean("updateprogress"), paramBundle, null);
      return;
    }
    LogUtil.e(TAG, "mEnlargeRoadMapView == null");
  }
  
  public void updateData(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null) {}
    while (this.mEnlargeRoadMapView == null) {
      return;
    }
    boolean bool = paramBundle.getBoolean("updateprogress");
    if (paramBoolean)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        updateRasterMapInfo(paramBoolean, paramBundle, new Object());
        return;
      }
    }
    updateRasterMapInfo(bool, paramBundle, null);
  }
  
  public void updateDataByLastest()
  {
    if (!"EnlargeRoadmap".equals(RouteGuideFSM.getInstance().getCurrentState())) {
      return;
    }
    this.mForceRefreshImage = true;
    updateData(RGEnlargeRoadMapModel.getInstance().getLastestData());
  }
  
  public void updateRasterMapInfo(final boolean paramBoolean, Bundle paramBundle, final Object paramObject)
  {
    String str1 = paramBundle.getString("road_name");
    int i = paramBundle.getInt("total_dist");
    int j = paramBundle.getInt("rem_dist");
    String str2 = paramBundle.getString("raster_type");
    if (!TextUtils.isEmpty(str1)) {
      this.mRoadName = str1;
    }
    this.rasterType = str2;
    this.mTotalDist = i;
    this.mRemDist = j;
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      this.mbUpdateRasterInfo = bool;
      if ((j > 0) && (i > 0)) {
        break label423;
      }
      i = 100;
      label95:
      LogUtil.e(TAG, "!# mRoadName=" + this.mRoadName + ", " + this.rasterType + ", updateRaster=" + this.mbUpdateRasterInfo);
      LogUtil.e(TAG, "!# Raster Pos = " + i + " Total = " + this.mTotalDist + " Rem = " + this.mRemDist);
      this.mProgress = i;
      if (("raster_vector".equals(this.rasterType)) || ("raster_direct_board".equals(this.rasterType)) || ("raster_grid".equals(this.rasterType))) {
        this.mTurnIconId = paramBundle.getInt("resid", 0);
      }
      if (!"raster_vector".equals(this.rasterType)) {
        break label439;
      }
      this.mCarPosX = paramBundle.getInt("car_pos_x", 0);
      this.mCarPosY = paramBundle.getInt("car_pos_y", 0);
      this.mCarRotate = paramBundle.getInt("car_rotate", 0);
      this.mCarRotate = (-this.mCarRotate);
    }
    for (;;)
    {
      if (!"raster_street".equals(this.rasterType))
      {
        if (this.mStreetLayout != null) {
          this.mStreetLayout.setVisibility(4);
        }
        if (this.bnav_rg_enlarge_image_mask != null) {
          this.bnav_rg_enlarge_image_mask.setVisibility(4);
        }
      }
      BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("UpdateRasterMapInfo-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          if (paramObject == null)
          {
            RGMMEnlargeRoadMapView.this.progressRun();
            return null;
          }
          RGMMEnlargeRoadMapView localRGMMEnlargeRoadMapView = RGMMEnlargeRoadMapView.this;
          if (!paramBoolean) {}
          for (boolean bool = true;; bool = false)
          {
            localRGMMEnlargeRoadMapView.progressRun(bool);
            break;
          }
        }
      }, new BNWorkerConfig(100, 0));
      return;
      bool = false;
      break;
      label423:
      i = (i - j) * 100 / i;
      break label95;
      label439:
      if (this.mCarPosImgView != null) {
        this.mCarPosImgView.setVisibility(4);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMEnlargeRoadMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */