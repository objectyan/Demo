package com.baidu.navisdk.module.ugc.ui.innavi.sub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.module.ugc.ui.SubContentContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.widget.UgcCustomLinearScrollView;
import com.baidu.navisdk.module.ugc.ui.widget.UgcCustomLinearScrollView.EventCatchListener;
import com.baidu.navisdk.util.common.ScreenUtil;

public class UgcReportNaviSubDetailView
  extends UgcReportNaviSubDetailContract.View
{
  private Button cancleUploadBtn = null;
  private Context mContext;
  private int mOrientation;
  private UgcReportNaviSubDetailContract.Presenter mPresenter = null;
  private UgcCustomLinearScrollView mainContentView = null;
  private View.OnClickListener onClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (UgcReportNaviSubDetailView.this.mPresenter == null) {
        return;
      }
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 1711867194: 
        UgcReportNaviSubDetailView.this.mPresenter.simpleUpload();
        return;
      }
      UgcReportNaviSubDetailView.this.mPresenter.comUpload();
    }
  };
  private TextView positionInfoTv;
  private View subFadeLayer = null;
  private ImageView subTitleIv = null;
  private View subUploadLayout = null;
  private View subUploadSpacing = null;
  private Button uploadBtn = null;
  
  public UgcReportNaviSubDetailView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mContext = paramContext;
    this.mOrientation = paramInt;
    initView(paramInt);
    initListener();
  }
  
  private void initListener()
  {
    if (this.uploadBtn != null) {
      this.uploadBtn.setOnClickListener(this.onClickListener);
    }
    if (this.cancleUploadBtn != null) {
      this.cancleUploadBtn.setOnClickListener(this.onClickListener);
    }
    if (this.mainContentView != null) {
      this.mainContentView.setOnEventCatchListener(new UgcCustomLinearScrollView.EventCatchListener()
      {
        public void onEventCatch(MotionEvent paramAnonymousMotionEvent)
        {
          if (UgcReportNaviSubDetailView.this.mPresenter != null) {
            UgcReportNaviSubDetailView.this.mPresenter.mainContentOnTouch(paramAnonymousMotionEvent);
          }
          if (UgcReportNaviSubDetailView.this.cancleUploadBtn != null) {
            UgcReportNaviSubDetailView.this.cancleUploadBtn.setText("取消 ");
          }
        }
      });
    }
  }
  
  private void initView(int paramInt)
  {
    if (this.rootView == null) {
      return;
    }
    this.subTitleIv = ((ImageView)this.rootView.findViewById(1711867140));
    this.subUploadSpacing = this.rootView.findViewById(1711867192);
    this.subUploadLayout = this.rootView.findViewById(1711867193);
    this.subFadeLayer = this.rootView.findViewById(1711867137);
    this.positionInfoTv = ((TextView)this.rootView.findViewById(1711867143));
    if ((this.subUploadSpacing != null) && (this.subUploadLayout != null) && (this.subFadeLayer != null))
    {
      this.subUploadSpacing.setVisibility(0);
      this.subUploadLayout.setVisibility(0);
      if (paramInt != 1) {
        break label178;
      }
      this.subFadeLayer.setVisibility(0);
    }
    for (;;)
    {
      this.uploadBtn = ((Button)this.rootView.findViewById(1711867195));
      this.cancleUploadBtn = ((Button)this.rootView.findViewById(1711867194));
      this.mainContentView = ((UgcCustomLinearScrollView)this.rootView.findViewById(1711867138));
      return;
      label178:
      this.subFadeLayer.setVisibility(8);
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
  
  public void hideSubTitleIv()
  {
    if (this.subTitleIv != null) {
      this.subTitleIv.setVisibility(8);
    }
  }
  
  public void initPresenterView()
  {
    super.initPresenterView();
  }
  
  public void setPresenter(SubContentContract.Presenter paramPresenter)
  {
    super.setPresenter(paramPresenter);
    this.mPresenter = ((UgcReportNaviSubDetailContract.Presenter)paramPresenter);
  }
  
  public void showAddrInfoUpdate(String paramString1, String paramString2)
  {
    if (this.positionInfoTv != null)
    {
      TextView localTextView = this.positionInfoTv;
      paramString2 = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramString2 = "地图上的点";
      }
      localTextView.setText(paramString2);
    }
  }
  
  public void showCurTimes(int paramInt)
  {
    if (this.cancleUploadBtn != null) {
      this.cancleUploadBtn.setText("取消 (" + paramInt + "s)");
    }
  }
  
  public void showIpoNaviView()
  {
    Object localObject;
    if (this.subFadeLayer != null)
    {
      this.subFadeLayer.setVisibility(0);
      this.subFadeLayer.setBackgroundColor(-16777216);
      this.subFadeLayer.getBackground().setAlpha(66);
      localObject = (LinearLayout.LayoutParams)this.subFadeLayer.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = 0;
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.subFadeLayer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.subUploadSpacing != null)
    {
      localObject = this.subUploadSpacing.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = ScreenUtil.getInstance().dip2px(50);
      this.subUploadSpacing.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/innavi/sub/UgcReportNaviSubDetailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */