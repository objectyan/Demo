package com.baidu.navisdk.module.ugc.ui.innavi.sub;

import android.content.Context;
import android.view.MotionEvent;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.ui.SubContentContract.View;
import com.baidu.navisdk.module.ugc.ui.SubContentPrensenter;
import com.baidu.navisdk.module.ugc.ui.SubContentView;

public abstract interface UgcReportNaviSubDetailContract
{
  public static abstract class Presenter
    extends SubContentPrensenter
  {
    public Presenter(Context paramContext, SubContentContract.View paramView, UgcDataProvider.UgcLayout paramUgcLayout)
    {
      super(paramView, paramUgcLayout);
    }
    
    abstract void comUpload();
    
    abstract void mainContentOnTouch(MotionEvent paramMotionEvent);
    
    abstract void simpleUpload();
  }
  
  public static abstract class View
    extends SubContentView
  {
    public View(Context paramContext)
    {
      super();
    }
    
    public View(Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    abstract int getOrientation();
    
    abstract void hideSubTitleIv();
    
    abstract void showCurTimes(int paramInt);
    
    abstract void showIpoNaviView();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/innavi/sub/UgcReportNaviSubDetailContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */