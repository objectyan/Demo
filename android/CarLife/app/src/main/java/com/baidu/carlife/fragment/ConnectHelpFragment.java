package com.baidu.carlife.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.custom.b;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.f;
import com.baidu.carlife.f.g;
import com.baidu.navi.fragment.ContentFragment;

public class ConnectHelpFragment
  extends ContentFragment
  implements View.OnClickListener
{
  private ScrollView a;
  private ImageButton b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private View i;
  private View j;
  private g k;
  private f l;
  
  public void driving()
  {
    i.b("yftech", "CarModeOfflineDataFragment driving");
    if (b.a().b())
    {
      back();
      back();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968745, null);
    this.a = ((ScrollView)this.mContentView.findViewById(2131624757));
    this.a.setOverScrollMode(2);
    this.b = ((ImageButton)this.mContentView.findViewById(2131624258));
    this.c = ((TextView)this.mContentView.findViewById(2131624059));
    this.d = ((TextView)this.mContentView.findViewById(2131624759));
    this.e = ((TextView)this.mContentView.findViewById(2131624762));
    this.f = ((TextView)this.mContentView.findViewById(2131624763));
    this.g = ((TextView)this.mContentView.findViewById(2131624764));
    this.h = ((TextView)this.mContentView.findViewById(2131624761));
    this.i = this.mContentView.findViewById(2131624758);
    this.j = this.mContentView.findViewById(2131624760);
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ConnectHelpFragment.this.back(null);
      }
    });
    this.c.setText(2131296398);
    this.d.setText(2131296396);
    this.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838799, 0);
    this.i.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          ConnectHelpFragment.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
          return;
        }
        catch (Exception paramAnonymousView)
        {
          i.b("Framework", "open adb setting page failed!");
          paramAnonymousView.printStackTrace();
        }
      }
    });
    this.j.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ConnectHelpFragment.this.showFragment(577, null);
      }
    });
    this.e.setText(2131296395);
    this.f.setText(2131296394);
    this.g.setText(2131296397);
    this.h.setText(2131296393);
    this.h.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838799, 0);
    return this.mContentView;
  }
  
  public void onInitFocusAreas()
  {
    if (this.fragmentType != getCurrentFragmentType()) {
      return;
    }
    if (this.k == null)
    {
      this.k = new g(this.mContentView.findViewById(2131624135), 2);
      this.k.d(this.mContentView.findViewById(2131624258));
    }
    if (this.l == null) {
      this.l = new f(this.a, 4);
    }
    d locald = d.a();
    locald.b(new a[] { this.k, this.l });
    locald.h(this.k);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/ConnectHelpFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */