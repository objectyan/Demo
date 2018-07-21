package com.baidu.navisdk.module.ugc.ui.inmap.sub;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.ui.SubContentContract.View;
import com.baidu.navisdk.module.ugc.ui.SubContentPrensenter;
import com.baidu.navisdk.module.ugc.ui.SubContentView;

public class UgcReportMapSubDetailContract
{
  public static abstract class Presenter
    extends SubContentPrensenter
  {
    public Presenter(Context paramContext, SubContentContract.View paramView, UgcDataProvider.UgcLayout paramUgcLayout)
    {
      super(paramView, paramUgcLayout);
    }
    
    abstract void finish();
    
    abstract void goback();
    
    abstract void hasShowOriginPage();
    
    abstract void hasShowSelectorPointStatus();
    
    abstract void informComHeight();
    
    abstract boolean isRoadBuild();
    
    abstract void showSelectorPointStatus();
  }
  
  public static abstract class View
    extends SubContentView
  {
    public View(Context paramContext)
    {
      super();
    }
    
    abstract ViewGroup getMapComPanelContainer();
    
    abstract boolean isSelectPointViewShowing();
    
    abstract void showOriginPage();
    
    abstract void showSelectorPointStatus();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/inmap/sub/UgcReportMapSubDetailContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */