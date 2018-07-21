package com.baidu.che.codriver.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SwitchPageLayout
  extends RelativeLayout
  implements View.OnClickListener, e
{
  public static final String a = "SwitchPageLayout";
  public static final int b = 500;
  private com.baidu.che.codriver.ui.a.h c;
  private int d;
  private int e;
  private TextView f;
  private TextView g;
  private CompoundImageView h;
  private CompoundImageView i;
  private View j;
  private SparseArray<View> k = new SparseArray();
  private LinearLayout l;
  
  public SwitchPageLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchPageLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwitchPageLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private View a(int paramInt)
  {
    if (this.k.get(paramInt) != null) {
      return (View)this.k.get(paramInt);
    }
    View localView = this.c.a(this.d);
    this.k.put(paramInt, localView);
    return localView;
  }
  
  private void a()
  {
    this.l = ((LinearLayout)findViewById(2131624990));
    this.f = ((TextView)findViewById(2131625346));
    this.j = findViewById(2131626091);
    this.g = ((TextView)findViewById(2131626090));
    this.h = ((CompoundImageView)findViewById(2131626092));
    this.i = ((CompoundImageView)findViewById(2131626093));
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }
  
  private void a(ViewGroup paramViewGroup, ArrayList<String> paramArrayList)
  {
    int n = paramViewGroup.getChildCount();
    int m = 0;
    if (m < n)
    {
      View localView = paramViewGroup.getChildAt(m);
      if ((localView instanceof TextView)) {
        if (localView.getVisibility() == 0) {
          paramArrayList.add(((TextView)localView).getText().toString());
        }
      }
      for (;;)
      {
        m += 1;
        break;
        if ((localView instanceof ViewGroup)) {
          a((ViewGroup)localView, paramArrayList);
        }
      }
    }
  }
  
  private boolean a(boolean paramBoolean1, final boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      if (this.d == this.e - 1) {
        return false;
      }
      this.d += 1;
      label29:
      if (!paramBoolean1) {
        break label95;
      }
      if (!paramBoolean2) {
        break label84;
      }
      this.i.setChecked(true);
      label45:
      postDelayed(new Runnable()
      {
        public void run()
        {
          SwitchPageLayout.a(SwitchPageLayout.this);
          if (paramBoolean2)
          {
            SwitchPageLayout.b(SwitchPageLayout.this).setChecked(false);
            return;
          }
          SwitchPageLayout.c(SwitchPageLayout.this).setChecked(false);
        }
      }, 500L);
    }
    for (;;)
    {
      return true;
      if (this.d == 0) {
        break;
      }
      this.d -= 1;
      break label29;
      label84:
      this.h.setChecked(true);
      break label45;
      label95:
      d();
    }
  }
  
  private void d()
  {
    this.c.b(this.d);
    this.l.removeAllViewsInLayout();
    setPageIndex(this.d + 1, this.e);
    this.l.addView(a(this.d));
    if (this.e <= 1)
    {
      this.j.setVisibility(8);
      return;
    }
    if (this.d == 0)
    {
      this.j.setVisibility(0);
      this.h.setEnabled(false);
      this.h.setAlpha(0.4F);
      this.i.setEnabled(true);
      this.i.setAlpha(1.0F);
      return;
    }
    if (this.d == this.e - 1)
    {
      this.j.setVisibility(0);
      this.h.setEnabled(true);
      this.h.setAlpha(1.0F);
      this.i.setEnabled(false);
      this.i.setAlpha(0.4F);
      return;
    }
    this.j.setVisibility(0);
    this.h.setEnabled(true);
    this.h.setAlpha(1.0F);
    this.i.setEnabled(true);
    this.i.setAlpha(1.0F);
  }
  
  public boolean b()
  {
    com.baidu.che.codriver.util.h.b("SwitchPageLayout", "switchToPrevPage() mCurrentPage=" + this.d + " mMaxPage=" + this.e);
    return a(true, false);
  }
  
  public boolean c()
  {
    com.baidu.che.codriver.util.h.b("SwitchPageLayout", "switchToNextPage() mCurrentPage=" + this.d + " mMaxPage=" + this.e);
    return a(true, true);
  }
  
  public LinkedHashMap<View, ArrayList<String>> getKeywords()
  {
    ViewGroup localViewGroup = (ViewGroup)a(this.d);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int n = localViewGroup.getChildCount();
    int m = 0;
    while (m < n)
    {
      ArrayList localArrayList = new ArrayList();
      View localView = localViewGroup.getChildAt(m);
      if ((localView instanceof ViewGroup)) {
        a((ViewGroup)localView, localArrayList);
      }
      localLinkedHashMap.put(localView, localArrayList);
      m += 1;
    }
    return localLinkedHashMap;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131626092: 
      a(false, false);
      return;
    }
    a(false, true);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
  }
  
  public void setAdapter(com.baidu.che.codriver.ui.a.h paramh)
  {
    this.c = paramh;
    this.e = this.c.a();
    this.d = this.c.b();
    this.k.clear();
    d();
  }
  
  public void setPageIndex(int paramInt1, int paramInt2)
  {
    this.g.setText(paramInt1 + "/" + paramInt2);
  }
  
  public void setTitle(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.f.setText(paramString);
      return;
    }
    this.f.setVisibility(8);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/SwitchPageLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */