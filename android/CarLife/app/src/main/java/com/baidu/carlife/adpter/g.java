package com.baidu.carlife.adpter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.logic.b.b;
import com.baidu.carlife.util.p;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.facebook.drawee.view.SimpleDraweeView;

public class g
  extends BaseAdapter
{
  public static final int a = -1;
  private String[] b;
  private Activity c;
  private LayoutInflater d;
  private String e;
  private int f = -1;
  private b g;
  
  public g(Activity paramActivity)
  {
    this.c = paramActivity;
    this.b = StyleManager.getStringArray(2131230733);
    this.d = LayoutInflater.from(paramActivity);
  }
  
  private void a(final SimpleDraweeView paramSimpleDraweeView)
  {
    if (paramSimpleDraweeView == null) {
      return;
    }
    if (NaviAccountUtils.getInstance().isLogin())
    {
      if (NaviAccountUtils.getInstance().getPortraitUrl() != null)
      {
        paramSimpleDraweeView.setController(com.baidu.carlife.g.a.a(paramSimpleDraweeView, NaviAccountUtils.getInstance().getPortraitUrl(), 52, 52));
        return;
      }
      NaviAccountUtils.getInstance().asyncGetProtraitUrl(new SapiCallBack()
      {
        public void a(GetPortraitResponse paramAnonymousGetPortraitResponse)
        {
          com.facebook.drawee.c.a locala = com.baidu.carlife.g.a.a(paramSimpleDraweeView, paramAnonymousGetPortraitResponse.portrait, 52, 52);
          paramSimpleDraweeView.setController(locala);
          p.a().b("account_portrait_url", paramAnonymousGetPortraitResponse.portrait);
        }
        
        public void onNetworkFailed()
        {
          Object localObject = p.a().a("account_portrait_url", "");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = com.baidu.carlife.g.a.a(paramSimpleDraweeView, (String)localObject, 52, 52);
            paramSimpleDraweeView.setController((com.facebook.drawee.g.a)localObject);
          }
        }
        
        public void onSystemError(int paramAnonymousInt) {}
      });
      return;
    }
    paramSimpleDraweeView.setImageURI("");
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(b paramb)
  {
    this.g = paramb;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return (!com.baidu.carlife.l.a.a().N()) || (NaviAccountUtils.getInstance().isLogin());
  }
  
  public String b(int paramInt)
  {
    if (paramInt == 0) {
      return this.e;
    }
    return this.b[(paramInt - 1)];
  }
  
  public int getCount()
  {
    return this.b.length + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    float f1;
    if (paramInt == 0)
    {
      paramView = this.d.inflate(2130968982, paramViewGroup, false);
      paramViewGroup = (TextView)paramView.findViewById(2131625965);
      localObject = (SimpleDraweeView)paramView.findViewById(2131625964);
      if (a())
      {
        f1 = 1.0F;
        ((SimpleDraweeView)localObject).setAlpha(f1);
        a((SimpleDraweeView)localObject);
        paramViewGroup.setText(this.e);
        paramViewGroup.setEnabled(a());
      }
    }
    for (;;)
    {
      if (this.f != paramInt) {
        break label226;
      }
      paramViewGroup.setSelected(true);
      return paramView;
      f1 = 0.4F;
      break;
      localObject = this.d.inflate(2130968983, paramViewGroup, false);
      TextView localTextView = (TextView)((View)localObject).findViewById(2131625967);
      localTextView.setText(b(paramInt));
      View localView = ((View)localObject).findViewById(2131625966);
      paramView = ((View)localObject).findViewById(2131624253);
      if (this.g.a(paramInt)) {
        paramView.setVisibility(0);
      }
      for (;;)
      {
        paramViewGroup = localTextView;
        paramView = (View)localObject;
        if (localView == null) {
          break;
        }
        if (paramInt != this.b.length) {
          break label211;
        }
        localView.setVisibility(8);
        paramViewGroup = localTextView;
        paramView = (View)localObject;
        break;
        paramView.setVisibility(8);
      }
      label211:
      localView.setVisibility(0);
      paramViewGroup = localTextView;
      paramView = (View)localObject;
    }
    label226:
    paramViewGroup.setSelected(false);
    return paramView;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (paramInt == 0) {
      return a();
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */