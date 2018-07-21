package com.baidu.carlife.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.carlife.core.f;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.navi.fragment.ContentFragment;

public class SettingVoiceFragment
  extends ContentFragment
{
  private g a;
  
  private void a()
  {
    TextView localTextView = (TextView)this.mContentView.findViewById(2131623980);
    if (f.jr)
    {
      localTextView.setText(2131297209);
      this.mContentView.findViewById(2131624643).setVisibility(0);
      this.mContentView.findViewById(2131626184).setVisibility(0);
      return;
    }
    localTextView.setText(2131297210);
    this.mContentView.findViewById(2131624643).setVisibility(8);
    this.mContentView.findViewById(2131626184).setVisibility(8);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = ((ViewGroup)LayoutInflater.from(mActivity).inflate(2130968813, null));
    setCommonTitleBar(this.mContentView, getString(2131296644));
    a();
    return this.mContentView;
  }
  
  public void onInitFocusAreas()
  {
    if (this.a == null)
    {
      this.a = new g(this.mContentView.findViewById(2131624146), 2);
      this.a.d(this.mContentView.findViewById(2131624258));
    }
    d.a().b(new a[] { this.a });
    d.a().h(this.a);
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
    updateCommonSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/SettingVoiceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */