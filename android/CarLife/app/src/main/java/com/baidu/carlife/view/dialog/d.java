package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.baidu.carlife.adpter.g;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.c;
import com.baidu.navi.style.StyleManager;
import java.util.HashMap;

public class d
  extends BaseDialog
{
  private ListView e;
  private BaseAdapter f;
  private View g;
  private boolean h = false;
  private c i;
  private HashMap<String, Integer> j;
  
  public d(Context paramContext, BaseAdapter paramBaseAdapter, AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    super(paramContext);
    this.f = paramBaseAdapter;
    this.e.setOnItemClickListener(paramOnItemClickListener);
    this.e.setAdapter(this.f);
    setCanceledOnTouchOutside(true);
    k();
  }
  
  private void k()
  {
    this.j = new HashMap();
    this.j.put("route_setting", Integer.valueOf(1));
    this.j.put("map_setting", Integer.valueOf(2));
    this.j.put("voice_setting", Integer.valueOf(3));
    this.j.put("help", Integer.valueOf(4));
    this.j.put("about", Integer.valueOf(6));
  }
  
  protected View a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2130968708, null);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView) {}
    });
    return localView;
  }
  
  public void a(final int paramInt)
  {
    if (this.e != null) {
      this.e.post(new Runnable()
      {
        public void run()
        {
          ListView localListView = d.a(d.this);
          if (paramInt > 0) {}
          for (int i = paramInt - 1;; i = paramInt)
          {
            localListView.setSelection(i);
            return;
          }
        }
      });
    }
  }
  
  public void a(View paramView)
  {
    this.g = paramView;
  }
  
  public boolean a(String paramString)
  {
    String[] arrayOfString = StyleManager.getStringArray(2131230733);
    int n = -1;
    int k = 0;
    int m = n;
    if (k < arrayOfString.length)
    {
      if (arrayOfString[k].equals(paramString)) {
        m = k;
      }
    }
    else
    {
      i.b("BaseDialog", "person dialog onVoiceCommand: " + m);
      if (m == -1) {
        break label107;
      }
      m += 1;
    }
    for (;;)
    {
      if (m == -1) {
        break label169;
      }
      paramString = this.e.getOnItemClickListener();
      if (paramString == null) {
        break label169;
      }
      paramString.onItemClick(this.e, null, m, 0L);
      return true;
      k += 1;
      break;
      label107:
      i.b("BaseDialog", "check login command: " + paramString);
      if (paramString.contains("登录帐号"))
      {
        m = 0;
        i.b("BaseDialog", "person dialog item index: " + 0);
      }
    }
    label169:
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    paramString1 = this.e.getOnItemClickListener();
    if (paramString1 == null) {}
    int k;
    do
    {
      return false;
      k = b(paramString2);
      i.b("BaseDialog", "List click index: " + k);
    } while (k == -1);
    paramString1.onItemClick(this.e, null, k, 0L);
    return true;
  }
  
  public int b(String paramString)
  {
    if (paramString.equals("login")) {
      return 0;
    }
    paramString = (Integer)this.j.get(paramString);
    if (paramString == null) {
      return -1;
    }
    return paramString.intValue();
  }
  
  protected void b()
  {
    this.e = ((ListView)findViewById(2131624060));
    this.e.setOverScrollMode(2);
    if (this.g != null) {
      this.e.addFooterView(this.g, null, false);
    }
    if (this.h) {
      this.e.setDivider(null);
    }
  }
  
  public void f()
  {
    if (this.i == null)
    {
      this.i = new c(this.e, 9);
      this.i.a(new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousInt == 22))
          {
            d.this.d();
            return true;
          }
          return false;
        }
      });
      this.i.a(true);
    }
    com.baidu.carlife.f.d.a().a(new a[] { this.i });
  }
  
  public void g()
  {
    com.baidu.carlife.f.d.a().e();
  }
  
  protected int getCustomWidth()
  {
    return this.c.getResources().getDimensionPixelSize(2131361851);
  }
  
  public void i()
  {
    if (this.f != null) {
      this.f.notifyDataSetChanged();
    }
  }
  
  public void j()
  {
    this.h = true;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if (this.e != null) {
      this.e.setOnItemClickListener(paramOnItemClickListener);
    }
  }
  
  public void setSelected(int paramInt)
  {
    if ((this.f instanceof g))
    {
      ((g)this.f).a(paramInt);
      this.f.notifyDataSetChanged();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */