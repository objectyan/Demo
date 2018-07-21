package com.baidu.carlife.fragment;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.view.CommonTitleBar;

public class YMServiceDetailFragment
  extends ContentFragment
{
  private TextView a;
  private TextView b;
  private CommonTitleBar c;
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(2130968820, null);
    setCommonTitleBar(paramLayoutInflater, getResources().getString(2131297240));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131625179));
    return paramLayoutInflater;
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    updateCommonSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/YMServiceDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */