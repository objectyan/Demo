package com.baidu.mapframework.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.util.SysOSAPIv2;

public class BMAlertDialog
  extends Dialog
  implements DialogInterface, View.OnClickListener
{
  private static final int a = 14;
  private static final int b = 1;
  private LinearLayout c;
  private ImageView d;
  private TextView e;
  private LinearLayout f;
  private TextView g;
  private RelativeLayout h;
  private LinearLayout i;
  private Button j;
  private Button k;
  private Builder l;
  private LinearLayout m;
  
  private BMAlertDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  public BMAlertDialog(Builder paramBuilder, int paramInt)
  {
    super(paramBuilder.getContext(), paramInt);
    this.l = paramBuilder;
    if (Builder.a()) {}
    for (this.c = ((LinearLayout)a(paramBuilder, 2130968593));; this.c = ((LinearLayout)a(paramBuilder, 2130968592)))
    {
      if (this.c != null)
      {
        this.c.setMinimumWidth(SysOSAPIv2.getInstance().getScreenWidth());
        this.d = ((ImageView)this.c.findViewById(2131624032));
        this.e = ((TextView)this.c.findViewById(2131624033));
        this.f = ((LinearLayout)this.c.findViewById(2131624034));
        this.g = ((TextView)this.c.findViewById(2131624036));
        this.h = ((RelativeLayout)this.c.findViewById(2131624037));
        this.i = ((LinearLayout)this.c.findViewById(2131624038));
        this.j = ((Button)this.c.findViewById(2131624039));
        this.k = ((Button)this.c.findViewById(2131624040));
        this.m = ((LinearLayout)this.c.findViewById(2131624031));
      }
      return;
    }
  }
  
  private View a(Builder paramBuilder, int paramInt)
  {
    try
    {
      View localView = LayoutInflater.from(paramBuilder.getContext()).inflate(paramInt, null);
      return localView;
    }
    catch (Exception localException)
    {
      try
      {
        paramBuilder = LayoutInflater.from(paramBuilder.getContext()).inflate(paramInt, null);
        return paramBuilder;
      }
      catch (Exception paramBuilder) {}
    }
    return null;
  }
  
  private boolean a(Context paramContext)
  {
    return (paramContext != null) && (!((Activity)paramContext).isFinishing());
  }
  
  public View getButton(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return this.j;
    }
    return this.k;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131624039: 
      if (Builder.f(this.l) != null) {
        Builder.f(this.l).onClick(this, -1);
      }
      dismiss();
      return;
    }
    if (Builder.g(this.l) != null) {
      Builder.g(this.l).onClick(this, -2);
    }
    dismiss();
  }
  
  public void show()
  {
    if ((this.c != null) && (a(this.l.getContext())))
    {
      setContentView(this.c, new ViewGroup.LayoutParams(-1, -2));
      super.show();
    }
  }
  
  public void updateMessage(CharSequence paramCharSequence)
  {
    if ((this.g != null) && (paramCharSequence != null)) {
      this.g.setText(paramCharSequence);
    }
  }
  
  public static class Builder
  {
    public static final int HILIGHTED_TEXT_COLOR = -15564033;
    private int a;
    private CharSequence b;
    private CharSequence c;
    private int d;
    private CharSequence e;
    private CharSequence f;
    private String[] g;
    private ListAdapter h;
    private boolean[] i;
    private boolean j = false;
    private boolean k = true;
    private boolean l = false;
    private boolean m = false;
    private DialogInterface.OnClickListener n;
    private DialogInterface.OnClickListener o;
    private DialogInterface.OnDismissListener p;
    private DialogInterface.OnCancelListener q;
    private DialogInterface.OnKeyListener r;
    private DialogInterface.OnMultiChoiceClickListener s;
    private DialogInterface.OnClickListener t;
    private View u;
    private Context v;
    private boolean w = false;
    
    public Builder(Context paramContext)
    {
      this.v = paramContext;
    }
    
    private void a(View paramView, int paramInt)
    {
      if (paramView == null) {
        return;
      }
      try
      {
        paramView.setBackgroundResource(paramInt);
        return;
      }
      catch (Exception localException)
      {
        paramView.setBackgroundResource(0);
      }
    }
    
    private static boolean b()
    {
      return Build.VERSION.SDK_INT >= 14;
    }
    
    public BMAlertDialog create()
    {
      final BMAlertDialog localBMAlertDialog = new BMAlertDialog(this, 2131427331);
      if (this.b != null)
      {
        BMAlertDialog.a(localBMAlertDialog).setText(this.b);
        BMAlertDialog.a(localBMAlertDialog).setVisibility(0);
        BMAlertDialog.b(localBMAlertDialog).setVisibility(0);
        if (this.a <= 0) {
          break label340;
        }
        BMAlertDialog.c(localBMAlertDialog).setImageResource(this.a);
        BMAlertDialog.c(localBMAlertDialog).setVisibility(0);
        label71:
        if (this.c == null) {
          break label352;
        }
        BMAlertDialog.d(localBMAlertDialog).setText(this.c);
        if (this.d > 0) {
          BMAlertDialog.d(localBMAlertDialog).setGravity(this.d);
        }
        BMAlertDialog.e(localBMAlertDialog).setVisibility(0);
        BMAlertDialog.f(localBMAlertDialog).setVisibility(8);
        label124:
        localBMAlertDialog.setOnCancelListener(this.q);
        localBMAlertDialog.setOnDismissListener(this.p);
        if (this.r != null) {
          localBMAlertDialog.setOnKeyListener(this.r);
        }
        if (this.e == null) {
          break label695;
        }
        BMAlertDialog.g(localBMAlertDialog).setText(this.e);
        BMAlertDialog.g(localBMAlertDialog).setOnClickListener(localBMAlertDialog);
        BMAlertDialog.g(localBMAlertDialog).setVisibility(0);
        if (this.l) {
          BMAlertDialog.g(localBMAlertDialog).setTextColor(-15564033);
        }
        label205:
        if (this.f == null) {
          break label707;
        }
        BMAlertDialog.h(localBMAlertDialog).setText(this.f);
        BMAlertDialog.h(localBMAlertDialog).setOnClickListener(localBMAlertDialog);
        BMAlertDialog.h(localBMAlertDialog).setVisibility(0);
        if (this.m) {
          BMAlertDialog.h(localBMAlertDialog).setTextColor(-15564033);
        }
        label255:
        if ((BMAlertDialog.g(localBMAlertDialog).getVisibility() != 0) || (BMAlertDialog.h(localBMAlertDialog).getVisibility() != 0)) {
          break label742;
        }
        BMAlertDialog.i(localBMAlertDialog).setVisibility(0);
        if (!b()) {
          break label719;
        }
        a(BMAlertDialog.g(localBMAlertDialog), 2130837513);
        a(BMAlertDialog.h(localBMAlertDialog), 2130837505);
      }
      for (;;)
      {
        localBMAlertDialog.setCancelable(this.k);
        return localBMAlertDialog;
        BMAlertDialog.a(localBMAlertDialog).setVisibility(8);
        BMAlertDialog.b(localBMAlertDialog).setVisibility(8);
        break;
        label340:
        BMAlertDialog.c(localBMAlertDialog).setVisibility(8);
        break label71;
        label352:
        ListView localListView;
        if ((this.g != null) && (this.g.length > 0))
        {
          localListView = (ListView)View.inflate(this.v, 2130968587, null);
          if (this.j)
          {
            localListView.setAdapter(new MultiChoiceAdapter(null));
            if (this.s != null) {
              localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
              {
                public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
                {
                  paramAnonymousAdapterView = (ImageView)paramAnonymousView.findViewById(2131624020);
                  boolean bool;
                  if (!((Boolean)paramAnonymousAdapterView.getTag()).booleanValue())
                  {
                    bool = true;
                    BMAlertDialog.Builder.a(BMAlertDialog.Builder.this)[paramAnonymousInt] = bool;
                    if (!bool) {
                      break label82;
                    }
                    paramAnonymousAdapterView.setImageResource(2130838532);
                    paramAnonymousAdapterView.setTag(Boolean.valueOf(true));
                  }
                  for (;;)
                  {
                    BMAlertDialog.Builder.b(BMAlertDialog.Builder.this).onClick(localBMAlertDialog, paramAnonymousInt, bool);
                    return;
                    bool = false;
                    break;
                    label82:
                    paramAnonymousAdapterView.setImageResource(2130838531);
                    paramAnonymousAdapterView.setTag(Boolean.valueOf(false));
                  }
                }
              });
            }
            BMAlertDialog.f(localBMAlertDialog).removeAllViews();
            BMAlertDialog.f(localBMAlertDialog).addView(localListView, new ViewGroup.LayoutParams(-1, -2));
            BMAlertDialog.f(localBMAlertDialog).setVisibility(0);
            BMAlertDialog.e(localBMAlertDialog).setVisibility(8);
            break label124;
          }
          if (this.w) {}
          for (int i1 = 2130968589;; i1 = 2130968588)
          {
            localListView.setAdapter(new ArrayAdapter(this.v, i1, this.g));
            if (this.t == null) {
              break;
            }
            localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                BMAlertDialog.Builder.c(BMAlertDialog.Builder.this).onClick(localBMAlertDialog, paramAnonymousInt);
                localBMAlertDialog.dismiss();
              }
            });
            break;
          }
        }
        if (this.h != null)
        {
          localListView = (ListView)View.inflate(this.v, 2130968587, null);
          localListView.setAdapter(this.h);
          if (this.t != null) {
            localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                BMAlertDialog.Builder.c(BMAlertDialog.Builder.this).onClick(localBMAlertDialog, paramAnonymousInt);
                localBMAlertDialog.dismiss();
              }
            });
          }
          BMAlertDialog.f(localBMAlertDialog).removeAllViews();
          BMAlertDialog.f(localBMAlertDialog).addView(localListView, new ViewGroup.LayoutParams(-1, -2));
          BMAlertDialog.f(localBMAlertDialog).setVisibility(0);
          BMAlertDialog.e(localBMAlertDialog).setVisibility(8);
          break label124;
        }
        if (this.u != null)
        {
          BMAlertDialog.f(localBMAlertDialog).removeAllViews();
          BMAlertDialog.f(localBMAlertDialog).addView(this.u, new ViewGroup.LayoutParams(-1, -2));
          BMAlertDialog.f(localBMAlertDialog).setVisibility(0);
          BMAlertDialog.e(localBMAlertDialog).setVisibility(8);
          break label124;
        }
        BMAlertDialog.e(localBMAlertDialog).setVisibility(8);
        BMAlertDialog.f(localBMAlertDialog).setVisibility(8);
        break label124;
        label695:
        BMAlertDialog.g(localBMAlertDialog).setVisibility(8);
        break label205;
        label707:
        BMAlertDialog.h(localBMAlertDialog).setVisibility(8);
        break label255;
        label719:
        a(BMAlertDialog.g(localBMAlertDialog), 2130837505);
        a(BMAlertDialog.h(localBMAlertDialog), 2130837513);
        continue;
        label742:
        if ((BMAlertDialog.g(localBMAlertDialog).getVisibility() == 0) || (BMAlertDialog.h(localBMAlertDialog).getVisibility() == 0))
        {
          BMAlertDialog.i(localBMAlertDialog).setVisibility(0);
          a(BMAlertDialog.g(localBMAlertDialog), 2130837510);
          a(BMAlertDialog.h(localBMAlertDialog), 2130837510);
        }
        else
        {
          BMAlertDialog.i(localBMAlertDialog).setVisibility(8);
          a(BMAlertDialog.e(localBMAlertDialog), 2130837509);
          a(BMAlertDialog.f(localBMAlertDialog), 2130837509);
        }
      }
    }
    
    public Context getContext()
    {
      return this.v;
    }
    
    public Builder setAdapter(ListAdapter paramListAdapter, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.h = paramListAdapter;
      this.t = paramOnClickListener;
      return this;
    }
    
    public Builder setCancelable(boolean paramBoolean)
    {
      this.k = paramBoolean;
      return this;
    }
    
    public Builder setContentCenter(boolean paramBoolean)
    {
      this.w = paramBoolean;
      return this;
    }
    
    public Builder setIcon(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
    
    public Builder setItems(String[] paramArrayOfString, DialogInterface.OnClickListener paramOnClickListener)
    {
      if (paramArrayOfString != null) {
        this.g = ((String[])paramArrayOfString.clone());
      }
      this.t = paramOnClickListener;
      return this;
    }
    
    public Builder setMessage(int paramInt)
    {
      this.c = this.v.getText(paramInt);
      return this;
    }
    
    public Builder setMessage(CharSequence paramCharSequence)
    {
      this.c = paramCharSequence;
      return this;
    }
    
    public Builder setMessageGravity(int paramInt)
    {
      this.d = paramInt;
      return this;
    }
    
    public Builder setMultiChoiceItems(String[] paramArrayOfString, boolean[] paramArrayOfBoolean, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
    {
      this.g = ((String[])paramArrayOfString.clone());
      this.i = ((boolean[])paramArrayOfBoolean.clone());
      this.s = paramOnMultiChoiceClickListener;
      this.j = true;
      return this;
    }
    
    public Builder setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.f = this.v.getText(paramInt);
      this.o = paramOnClickListener;
      return this;
    }
    
    public Builder setNegativeButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.f = paramCharSequence;
      this.o = paramOnClickListener;
      return this;
    }
    
    public Builder setNegativeHilighted(boolean paramBoolean)
    {
      this.m = paramBoolean;
      return this;
    }
    
    public Builder setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.q = paramOnCancelListener;
      return this;
    }
    
    public Builder setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.p = paramOnDismissListener;
      return this;
    }
    
    public Builder setOnKeyListener(DialogInterface.OnKeyListener paramOnKeyListener)
    {
      this.r = paramOnKeyListener;
      return this;
    }
    
    public Builder setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.e = this.v.getText(paramInt);
      this.n = paramOnClickListener;
      return this;
    }
    
    public Builder setPositiveButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.e = paramCharSequence;
      this.n = paramOnClickListener;
      return this;
    }
    
    public Builder setPositiveHilighted(boolean paramBoolean)
    {
      this.l = paramBoolean;
      return this;
    }
    
    public Builder setTitle(int paramInt)
    {
      this.b = this.v.getText(paramInt);
      return this;
    }
    
    public Builder setTitle(CharSequence paramCharSequence)
    {
      this.b = paramCharSequence;
      return this;
    }
    
    public Builder setView(View paramView)
    {
      if (paramView != null) {
        this.u = paramView;
      }
      return this;
    }
    
    public BMAlertDialog show()
    {
      BMAlertDialog localBMAlertDialog = create();
      localBMAlertDialog.show();
      return localBMAlertDialog;
    }
    
    private class MultiChoiceAdapter
      extends BaseAdapter
    {
      private MultiChoiceAdapter() {}
      
      public int getCount()
      {
        if (BMAlertDialog.Builder.d(BMAlertDialog.Builder.this) != null) {
          return BMAlertDialog.Builder.d(BMAlertDialog.Builder.this).length;
        }
        return 0;
      }
      
      public Object getItem(int paramInt)
      {
        if ((BMAlertDialog.Builder.d(BMAlertDialog.Builder.this) != null) && (BMAlertDialog.Builder.d(BMAlertDialog.Builder.this).length > paramInt)) {
          return BMAlertDialog.Builder.d(BMAlertDialog.Builder.this)[paramInt];
        }
        return null;
      }
      
      public long getItemId(int paramInt)
      {
        return paramInt;
      }
      
      public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
      {
        paramViewGroup = paramView;
        if (paramView == null) {
          paramViewGroup = View.inflate(BMAlertDialog.Builder.e(BMAlertDialog.Builder.this), 2130968586, null);
        }
        paramView = (TextView)paramViewGroup.findViewById(2131624019);
        ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131624020);
        if ((BMAlertDialog.Builder.d(BMAlertDialog.Builder.this) != null) && (BMAlertDialog.Builder.d(BMAlertDialog.Builder.this).length > paramInt)) {
          paramView.setText(BMAlertDialog.Builder.d(BMAlertDialog.Builder.this)[paramInt]);
        }
        if ((BMAlertDialog.Builder.a(BMAlertDialog.Builder.this) != null) && (BMAlertDialog.Builder.a(BMAlertDialog.Builder.this).length > paramInt))
        {
          if (BMAlertDialog.Builder.a(BMAlertDialog.Builder.this)[paramInt] != 0)
          {
            localImageView.setImageResource(2130838532);
            localImageView.setTag(Boolean.valueOf(true));
          }
        }
        else {
          return paramViewGroup;
        }
        localImageView.setImageResource(2130838531);
        localImageView.setTag(Boolean.valueOf(false));
        return paramViewGroup;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/widget/BMAlertDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */