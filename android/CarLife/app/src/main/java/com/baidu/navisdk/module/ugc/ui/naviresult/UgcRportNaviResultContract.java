package com.baidu.navisdk.module.ugc.ui.naviresult;

import android.content.Context;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.ui.SubContentContract.View;
import com.baidu.navisdk.module.ugc.ui.SubContentPrensenter;
import com.baidu.navisdk.module.ugc.ui.SubContentView;

public class UgcRportNaviResultContract
{
  public static abstract class Presenter
    extends SubContentPrensenter
  {
    public Presenter(Context paramContext, SubContentContract.View paramView, UgcDataProvider.UgcLayout paramUgcLayout)
    {
      super(paramView, paramUgcLayout);
    }
    
    abstract void finish();
    
    abstract void gotoDtailView();
    
    abstract void hasShowOriginPage();
    
    abstract void hasShowSelectorPointStatus();
    
    abstract void informComHeight();
    
    abstract boolean isInNewRoad();
    
    abstract void secondUpload();
    
    abstract void showSelectorPointStatus();
  }
  
  public static abstract class View
    extends SubContentView
  {
    public View(Context paramContext)
    {
      super();
    }
    
    abstract boolean isSelectPointViewShowing();
    
    abstract void setNewRoadSelectStatus(int paramInt);
    
    abstract void showNewRoadLayoutView(boolean paramBoolean);
    
    abstract void showOriginPage();
    
    abstract void showPositionChangeLayout(boolean paramBoolean);
    
    abstract void showSelectorPointStatus();
    
    abstract void supportScrollView();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/naviresult/UgcRportNaviResultContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */