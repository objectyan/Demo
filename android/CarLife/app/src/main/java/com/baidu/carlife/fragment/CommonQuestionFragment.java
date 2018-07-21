package com.baidu.carlife.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.f;
import com.baidu.carlife.f.g;
import com.baidu.navi.fragment.ContentFragment;

public class CommonQuestionFragment
  extends ContentFragment
{
  private ScrollView a;
  private ImageButton b;
  private TextView c;
  private g d;
  private f e;
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968744, null);
    this.a = ((ScrollView)this.mContentView.findViewById(2131624757));
    this.b = ((ImageButton)this.mContentView.findViewById(2131624258));
    this.c = ((TextView)this.mContentView.findViewById(2131624059));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CommonQuestionFragment.this.back(null);
      }
    });
    this.c.setText(2131296387);
    return this.mContentView;
  }
  
  public void onInitFocusAreas()
  {
    if (this.fragmentType != getCurrentFragmentType()) {
      return;
    }
    if (this.d == null)
    {
      this.d = new g(this.mContentView.findViewById(2131624135), 2);
      this.d.d(this.mContentView.findViewById(2131624258));
    }
    if (this.e == null) {
      this.e = new f(this.a, 4);
    }
    d locald = d.a();
    locald.b(new a[] { this.d, this.e });
    locald.h(this.d);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/CommonQuestionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */