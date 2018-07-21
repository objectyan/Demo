package com.baidu.carlife.adpter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.e;
import com.baidu.carlife.l.a;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.util.r;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.track.common.TrackConfigUtil;

public class q
  extends BaseAdapter
{
  private String[] a;
  private Context b;
  private Object c = new Object();
  private b d = new b()
  {
    public void a()
    {
      q.this.notifyDataSetChanged();
    }
  };
  private CompoundButton.OnCheckedChangeListener e = new CompoundButton.OnCheckedChangeListener()
  {
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean == q.a(q.this)) {
        return;
      }
      new q.a(q.this, paramAnonymousCompoundButton, paramAnonymousBoolean).start();
    }
  };
  private CompoundButton.OnCheckedChangeListener f = new CompoundButton.OnCheckedChangeListener()
  {
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      a.a().d(paramAnonymousBoolean);
    }
  };
  private CompoundButton.OnCheckedChangeListener g = new CompoundButton.OnCheckedChangeListener()
  {
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean == TrackConfigUtil.getInstance().getRouteRecordFlag()) {
        return;
      }
      TrackConfigUtil.getInstance().setRouteRecordFlag(paramAnonymousBoolean);
    }
  };
  
  public q(Context paramContext, int paramInt)
  {
    this.b = paramContext;
    this.a = this.b.getResources().getStringArray(paramInt);
    n.a().a(this.d);
    BaseFragment.mActivity.a(this.d);
  }
  
  private boolean a()
  {
    return e.a().o();
  }
  
  public void a(int paramInt)
  {
    this.a = this.b.getResources().getStringArray(paramInt);
  }
  
  public int getCount()
  {
    if (a.a().i()) {
      return this.a.length;
    }
    return this.a.length - 1;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (paramInt == 0) {
      return 0L;
    }
    if (a.a().i()) {
      return paramInt;
    }
    return paramInt + 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.b).inflate(2130969013, paramViewGroup, false);
      paramView = new c(null);
      paramView.a = ((TextView)localView.findViewById(2131624662));
      paramView.b = ((SwitchButton)localView.findViewById(2131625241));
      paramView.c = ((ImageView)localView.findViewById(2131625842));
      paramView.d = localView.findViewById(2131624253);
      localView.setTag(paramView);
    }
    paramView = (c)localView.getTag();
    paramView.b.setOnCheckedChangeListener(null);
    if (a.a().i()) {
      switch (paramInt)
      {
      case 3: 
      default: 
        paramView.c.setVisibility(0);
        paramView.b.setVisibility(8);
      }
    }
    for (;;)
    {
      paramView.a.setText(this.a[((int)getItemId(paramInt))]);
      paramView.a.setTextColor(r.a(2131558702));
      return localView;
      paramView.b.setVisibility(0);
      paramView.c.setVisibility(8);
      paramView.b.setClickable(false);
      if (paramInt == 0)
      {
        paramView.b.setOnCheckedChangeListener(this.e);
        paramView.b.setChecked(a());
      }
      else if (paramInt == 1)
      {
        paramView.b.setOnCheckedChangeListener(this.f);
        paramView.b.setChecked(a.a().j());
      }
      else if (paramInt == 4)
      {
        paramView.b.setOnCheckedChangeListener(this.g);
        paramView.b.setChecked(TrackConfigUtil.getInstance().getRouteRecordFlag());
        continue;
        paramView.c.setVisibility(0);
        paramView.b.setVisibility(8);
        continue;
        switch (paramInt)
        {
        case 1: 
        default: 
          paramView.c.setVisibility(0);
          paramView.b.setVisibility(8);
          break;
        case 0: 
        case 3: 
          paramView.b.setVisibility(0);
          paramView.c.setVisibility(8);
          paramView.b.setClickable(false);
          if (paramInt == 0)
          {
            paramView.b.setOnCheckedChangeListener(this.e);
            paramView.b.setChecked(a());
          }
          else if (paramInt == 3)
          {
            paramView.b.setOnCheckedChangeListener(this.g);
            paramView.b.setChecked(TrackConfigUtil.getInstance().getRouteRecordFlag());
          }
          break;
        case 2: 
          paramView.c.setVisibility(0);
          paramView.b.setVisibility(8);
        }
      }
    }
  }
  
  private class a
    extends Thread
  {
    CompoundButton a;
    boolean b;
    
    public a(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      this.a = paramCompoundButton;
      this.b = paramBoolean;
    }
    
    public void run()
    {
      for (;;)
      {
        synchronized (q.b(q.this))
        {
          if (n.a().n())
          {
            if (this.a.isChecked())
            {
              this.a.setChecked(false);
              e.a().a(false);
            }
            return;
          }
          if (this.b != q.a(q.this))
          {
            n.a().a(this.b);
            if (this.b)
            {
              e.a().a(this.b);
              w.a(2131297225, 0);
              this.a.post(new Runnable()
              {
                public void run()
                {
                  n.a().g();
                }
              });
            }
          }
          else
          {
            return;
          }
        }
        e.a().a(this.b);
        w.a(2131297206, 0);
        this.a.post(new Runnable()
        {
          public void run()
          {
            n.a().h();
          }
        });
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
  
  private class c
  {
    TextView a;
    SwitchButton b;
    ImageView c;
    View d;
    
    private c() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */