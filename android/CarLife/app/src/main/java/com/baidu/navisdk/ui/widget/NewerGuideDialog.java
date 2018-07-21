package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class NewerGuideDialog
  extends Dialog
{
  private static final int HIGHT_VIEW_ID = 1;
  private RelativeLayout mContent;
  private Activity mContext;
  private ImageView mInfoImageView;
  
  public NewerGuideDialog(Activity paramActivity)
  {
    super(paramActivity);
    Object localObject = JarUtils.getResources().newTheme();
    ((Resources.Theme)localObject).applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, (Resources.Theme)localObject);
    localObject = JarUtils.inflate(paramActivity, 1711472689, null);
    setContentView((View)localObject);
    this.mContent = ((RelativeLayout)((View)localObject).findViewById(1711866080));
    this.mInfoImageView = ((ImageView)((View)localObject).findViewById(1711866330));
    getWindow().setLayout(-1, -1);
    this.mContext = paramActivity;
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        NewerGuideDialog.this.dissmss();
      }
    });
  }
  
  public NewerGuideDialog addHighLightView(View paramView, int paramInt, boolean paramBoolean)
  {
    try
    {
      Object localObject1 = new Rect();
      paramView.getGlobalVisibleRect((Rect)localObject1);
      Object localObject2 = new ViewGroup.MarginLayoutParams(paramView.getLayoutParams());
      Object localObject3 = new Rect();
      this.mContext.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
      LogUtil.e("NewER", "status bar height2=" + ((Rect)localObject3).top);
      ((ViewGroup.MarginLayoutParams)localObject2).setMargins(((Rect)localObject1).left, ((Rect)localObject1).top - ((Rect)localObject3).top, 0, 0);
      localObject2 = new RelativeLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9);
      localObject3 = new ImageView(this.mContext);
      localObject1 = Bitmap.createBitmap(((Rect)localObject1).right - ((Rect)localObject1).left, ((Rect)localObject1).bottom - ((Rect)localObject1).top, Bitmap.Config.ARGB_8888);
      paramView.draw(new Canvas((Bitmap)localObject1));
      ((ImageView)localObject3).setImageBitmap((Bitmap)localObject1);
      ((ImageView)localObject3).setId(1);
      if (this.mContent != null) {
        this.mContent.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
      }
      this.mInfoImageView.setBackgroundDrawable(JarUtils.getResources().getDrawable(paramInt));
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      if (paramBoolean) {
        paramView.addRule(3, 1);
      }
      for (;;)
      {
        paramView.addRule(5, 1);
        this.mInfoImageView.setLayoutParams(paramView);
        if (this.mContent == null) {
          break;
        }
        this.mContent.requestLayout();
        this.mContent.invalidate();
        return this;
        paramView.addRule(2, 1);
      }
      return this;
    }
    catch (Exception paramView) {}
  }
  
  public void dissmss()
  {
    dismiss();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/NewerGuideDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */