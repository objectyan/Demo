package com.baidu.navisdk.module.ugc.ui.innavi.main;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.util.jar.JarUtils;

public class UgcReportNaviMainView
  implements View.OnClickListener, UgcReportNaviMainContract.View
{
  private Button cancleBtn = null;
  private Button closeBtn = null;
  private String closeText = "关闭";
  private Button contentSupBtn = null;
  private ImageView[] dynamicBtnArr = null;
  private View fadeViewLayout = null;
  private View mContentView = null;
  private Context mContext;
  private int mOrientation;
  private UgcReportNaviMainContract.Presenter mPresenter = null;
  private View mRootView = null;
  private ViewGroup mRootViewContainer = null;
  private View mainViewLayout = null;
  private GridView parentItemsGv = null;
  private View routeGuideView = null;
  private ImageView subItemImageIv = null;
  private TextView subItemTextTv = null;
  private View.OnClickListener tipsViewClickListnener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      switch (paramAnonymousView.getId())
      {
      }
      do
      {
        do
        {
          return;
        } while (UgcReportNaviMainView.this.mPresenter == null);
        UgcReportNaviMainView.this.mPresenter.simpleUpload();
        return;
      } while (UgcReportNaviMainView.this.mPresenter == null);
      UgcReportNaviMainView.this.mPresenter.gotoNaviSubDetailView(false);
    }
  };
  private ImageView uploadItemImagev = null;
  private TextView uploadItemTextv = null;
  private View uploadViewLayout = null;
  
  public UgcReportNaviMainView(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mOrientation = paramInt;
    initView(paramContext, paramInt);
    initListener();
  }
  
  private void initListener()
  {
    if (this.cancleBtn != null) {
      this.cancleBtn.setOnClickListener(this);
    }
    if (this.mContentView != null) {
      this.mContentView.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
    }
  }
  
  private void initView(Context paramContext, int paramInt)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      this.mContext = paramContext;
      if (paramInt == 1) {}
      for (this.mRootView = JarUtils.inflate((Activity)paramContext, 1711472763, null); this.mRootView != null; this.mRootView = JarUtils.inflate((Activity)paramContext, 1711472764, null))
      {
        this.mContentView = this.mRootView.findViewById(1711867123);
        this.parentItemsGv = ((GridView)this.mRootView.findViewById(1711867124));
        this.dynamicBtnArr = new ImageView[2];
        this.dynamicBtnArr[0] = ((ImageView)this.mRootView.findViewById(1711867125));
        this.dynamicBtnArr[1] = ((ImageView)this.mRootView.findViewById(1711867126));
        this.cancleBtn = ((Button)this.mRootView.findViewById(1711867128));
        this.routeGuideView = this.mRootView.findViewById(1711867122);
        return;
      }
    }
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public ViewGroup getParentContainer()
  {
    if (this.mRootViewContainer != null) {
      return this.mRootViewContainer;
    }
    if ((this.mRootView != null) && (this.mRootView.getParent() != null)) {
      return (ViewGroup)this.mRootView.getParent();
    }
    return null;
  }
  
  public View getParentView()
  {
    return this.mRootView;
  }
  
  public void hideTipItemIv()
  {
    if (this.subItemImageIv != null) {
      this.subItemImageIv.setVisibility(8);
    }
  }
  
  public void initPresenterView()
  {
    if (this.mPresenter == null) {}
    for (;;)
    {
      return;
      if (this.parentItemsGv != null) {
        this.parentItemsGv.setAdapter(new NaviMainGvAdapter(this.mPresenter, (Activity)this.mContext, this.mOrientation));
      }
      if (this.mPresenter.getDynamicItemsSize() == 0) {
        if ((this.dynamicBtnArr[0] != null) && (this.dynamicBtnArr[1] != null))
        {
          ((View)this.dynamicBtnArr[0].getParent()).setVisibility(8);
          ((View)this.dynamicBtnArr[1].getParent()).setVisibility(8);
        }
      }
      while ((this.dynamicBtnArr[0] != null) && (this.dynamicBtnArr[1] != null))
      {
        this.dynamicBtnArr[0].setOnClickListener(this);
        this.dynamicBtnArr[1].setOnClickListener(this);
        return;
        if (this.mPresenter.getDynamicItemsSize() == 1) {
          if ("缺路".endsWith(this.mPresenter.getParentItemsGvTextTile(0)))
          {
            if (this.dynamicBtnArr[1] != null) {
              ((View)this.dynamicBtnArr[1].getParent()).setVisibility(8);
            }
          }
          else if (this.dynamicBtnArr[0] != null)
          {
            this.dynamicBtnArr[0].setVisibility(8);
            ((View)this.dynamicBtnArr[0].getParent()).setVisibility(8);
          }
        }
      }
    }
  }
  
  public void initUploadView()
  {
    if ((this.mRootView == null) || (this.mContext == null) || (this.mPresenter == null)) {}
    label262:
    label269:
    for (;;)
    {
      return;
      this.mRootViewContainer = ((ViewGroup)this.mRootView.getParent());
      View localView;
      if (this.mOrientation == 1)
      {
        localView = JarUtils.inflate((Activity)this.mContext, 1711472769, null);
        if ((this.mRootViewContainer != null) && (localView != null))
        {
          this.mRootViewContainer.removeAllViews();
          ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
          this.mRootViewContainer.addView(localView, localLayoutParams);
        }
        this.closeBtn = ((Button)localView.findViewById(1711867199));
        this.contentSupBtn = ((Button)localView.findViewById(1711867198));
        this.subItemImageIv = ((ImageView)localView.findViewById(1711867140));
        this.subItemTextTv = ((TextView)localView.findViewById(1711867141));
        if ((this.closeBtn != null) && (this.contentSupBtn != null))
        {
          this.closeBtn.setOnClickListener(this.tipsViewClickListnener);
          this.contentSupBtn.setOnClickListener(this.tipsViewClickListnener);
          if (!this.mPresenter.getIsTipsDynamic()) {
            break label262;
          }
        }
      }
      for (this.closeText = "稍后补充";; this.closeText = "立即上报")
      {
        if ((this.subItemTextTv == null) || (this.subItemImageIv == null)) {
          break label269;
        }
        this.subItemTextTv.setText(this.mPresenter.getUploadTipsTextTitle());
        this.mPresenter.parentTipsItemsGvImageLoader(this.subItemImageIv);
        return;
        localView = JarUtils.inflate((Activity)this.mContext, 1711472770, null);
        break;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.mPresenter == null) {
      return;
    }
    switch (paramView.getId())
    {
    case 1711867127: 
    default: 
      return;
    case 1711867125: 
      this.mPresenter.gotoUploadView(0, true);
      return;
    case 1711867126: 
      if ((this.dynamicBtnArr[0] != null) && (this.dynamicBtnArr[0].getVisibility() == 8))
      {
        this.mPresenter.gotoUploadView(0, true);
        return;
      }
      this.mPresenter.gotoUploadView(1, true);
      return;
    }
    this.mPresenter.finish();
  }
  
  public void setPresenter(UgcReportNaviMainContract.Presenter paramPresenter)
  {
    this.mPresenter = paramPresenter;
  }
  
  public void showCurTimes(int paramInt)
  {
    if (this.closeBtn != null) {
      this.closeBtn.setText(this.closeText + "(" + paramInt + "s)");
    }
  }
  
  public void showIpoView()
  {
    if (this.routeGuideView != null)
    {
      this.routeGuideView.setBackgroundColor(17170444);
      this.routeGuideView.getBackground().setAlpha(66);
    }
  }
  
  public void showUploadCountDownView()
  {
    if (this.mainViewLayout != null) {
      this.mainViewLayout.setVisibility(8);
    }
    if (this.uploadViewLayout != null) {
      this.uploadViewLayout.setVisibility(0);
    }
  }
  
  class NaviMainGvAdapter
    extends BaseAdapter
    implements View.OnClickListener
  {
    private Activity mContext;
    private int mOrientation;
    private UgcReportNaviMainContract.Presenter mPresenter;
    View.OnTouchListener onTouchListener = new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        paramAnonymousView = ((UgcReportNaviMainView.NaviMainGvAdapter.ViewHolder)paramAnonymousView.getTag()).mChildIView;
        if (paramAnonymousView == null) {}
        do
        {
          do
          {
            do
            {
              return false;
              if (paramAnonymousMotionEvent.getAction() != 0) {
                break;
              }
              paramAnonymousView = paramAnonymousView.getBackground();
            } while (paramAnonymousView == null);
            paramAnonymousView.setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
            return false;
          } while ((paramAnonymousMotionEvent.getAction() != 1) && (paramAnonymousMotionEvent.getAction() != 3));
          paramAnonymousView = paramAnonymousView.getBackground();
        } while (paramAnonymousView == null);
        paramAnonymousView.clearColorFilter();
        return false;
      }
    };
    
    public NaviMainGvAdapter(UgcReportNaviMainContract.Presenter paramPresenter, Activity paramActivity, int paramInt)
    {
      this.mContext = paramActivity;
      this.mPresenter = paramPresenter;
      this.mOrientation = paramInt;
    }
    
    public int getCount()
    {
      if (this.mPresenter == null) {
        return 0;
      }
      return this.mPresenter.parentItemsGvSize();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        if (this.mOrientation == 1) {}
        for (paramView = JarUtils.inflate(this.mContext, 1711472757, null); paramView == null; paramView = JarUtils.inflate(this.mContext, 1711472758, null)) {
          return null;
        }
        paramViewGroup = new ViewHolder();
        paramViewGroup.mChildIView = ((ImageView)paramView.findViewById(1711867092));
        paramViewGroup.mChildName = ((TextView)paramView.findViewById(1711867093));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.position = paramInt;
        if (paramView != null) {
          paramView.setOnTouchListener(this.onTouchListener);
        }
        paramView.setOnClickListener(this);
        this.mPresenter.parentItemsGvImageLoader(paramInt, paramViewGroup.mChildIView);
        paramViewGroup.mChildName.setText(this.mPresenter.getParentItemsGvTextTile(paramInt));
        return paramView;
        paramViewGroup = (ViewHolder)paramView.getTag();
      }
    }
    
    public void onClick(View paramView)
    {
      try
      {
        paramView = (ViewHolder)paramView.getTag();
        if (this.mPresenter != null) {
          this.mPresenter.gotoUploadView(paramView.position, false);
        }
        return;
      }
      catch (Exception paramView) {}
    }
    
    class ViewHolder
    {
      public ImageView mChildIView;
      public TextView mChildName;
      public int position;
      
      ViewHolder() {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/innavi/main/UgcReportNaviMainView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */