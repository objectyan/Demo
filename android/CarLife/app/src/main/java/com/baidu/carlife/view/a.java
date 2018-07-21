package com.baidu.carlife.view;

import android.app.Activity;
import android.content.res.Resources;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.KeyboardService;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.logic.g;
import com.baidu.carlife.view.dialog.l;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;

public class a
  implements KeyboardResultView.c
{
  public static boolean a = false;
  private static a c;
  private Activity b;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private com.baidu.carlife.core.screen.e h;
  private l i;
  private TextView j;
  private TextView k;
  private TextView[] l;
  private ImageView m;
  private int n;
  private char[] o;
  private TextView p;
  private KeyboardEditText q;
  private TextView r;
  private View s;
  private View t;
  private KeyboardResultView u;
  private EditText v;
  private b w;
  private boolean x = false;
  private b y = new b(null);
  
  public static a a()
  {
    if (c == null) {
      c = new a();
    }
    return c;
  }
  
  private void a(String paramString)
  {
    int i1 = this.q.getSelectionStart();
    Editable localEditable = this.q.getEditableText();
    if (i1 >= 0) {}
    try
    {
      if (i1 >= localEditable.length())
      {
        localEditable.append(paramString);
        return;
      }
      localEditable.insert(i1, paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    this.w.a(paramArrayList);
    this.w.notifyDataSetChanged();
  }
  
  private void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
    SpannableString localSpannableString = new SpannableString("中/英");
    int i1 = BaiduNaviApplication.getInstance().getResources().getColor(2131558697);
    int i2 = BaiduNaviApplication.getInstance().getResources().getColor(2131558686);
    if (paramBoolean)
    {
      localSpannableString.setSpan(new ForegroundColorSpan(i2), 0, 2, 17);
      localSpannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, 2, 17);
      localSpannableString.setSpan(new ForegroundColorSpan(i1), 2, 3, 17);
      localSpannableString.setSpan(new AbsoluteSizeSpan(16, true), 2, 3, 17);
      this.j.setText("Space");
    }
    for (;;)
    {
      this.k.setText(localSpannableString);
      return;
      localSpannableString.setSpan(new ForegroundColorSpan(i1), 0, 1, 17);
      localSpannableString.setSpan(new AbsoluteSizeSpan(16, true), 0, 1, 17);
      localSpannableString.setSpan(new ForegroundColorSpan(i2), 1, 3, 17);
      localSpannableString.setSpan(new AbsoluteSizeSpan(12, true), 1, 3, 17);
      this.j.setText("空格");
    }
  }
  
  private void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (paramBoolean)
    {
      i1 = 0;
      while (i1 < this.n)
      {
        this.l[i1].setText(String.valueOf((char)(this.o[i1] - ' ')));
        i1 += 1;
      }
      this.m.setImageResource(2130838782);
      return;
    }
    int i1 = 0;
    while (i1 < this.n)
    {
      this.l[i1].setText(String.valueOf(this.o[i1]));
      i1 += 1;
    }
    this.m.setImageResource(2130838781);
  }
  
  private void d(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (paramBoolean)
    {
      this.p.setText(2131296546);
      this.p.setSelected(true);
      return;
    }
    String str2 = com.baidu.carlife.core.a.a().getString(2131296547);
    String str1 = str2;
    if (this.q != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(this.q.getFinishText())) {
        str1 = this.q.getFinishText();
      }
    }
    this.p.setText(str1);
    this.p.setSelected(false);
    this.r.setText(str1);
  }
  
  private void e()
  {
    this.i = new l(com.baidu.carlife.core.a.a());
    this.i.setOnClickListener(this.y);
    this.i.setResultItemClickListener(this);
    this.j = this.i.getLetterSpaceKey();
    this.k = this.i.getLetterLanguageKey();
    this.l = this.i.getLetterKeys();
    this.m = this.i.getLetterShiftKey();
    this.n = this.i.getLetterSize();
    this.o = this.i.getLetters();
    this.p = this.i.getLetterFinishKey();
    this.r = this.i.getNumFinishKey();
    this.s = this.i.getLetterKeyboard();
    this.t = this.i.getNumKeyboard();
    this.u = this.i.getResultKeyboard();
    this.v = this.i.getResultEditText();
    this.w = this.i.getResultAdapter();
    b(false);
    if (this.x) {
      this.i.i();
    }
    this.d = false;
  }
  
  private void e(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (paramBoolean)
    {
      this.s.setVisibility(8);
      this.t.setVisibility(0);
    }
    for (;;)
    {
      this.i.setNumType(paramBoolean);
      c(false);
      return;
      this.s.setVisibility(0);
      this.t.setVisibility(8);
    }
  }
  
  private boolean f()
  {
    if (this.q == null) {
      return true;
    }
    if (this.u.getChildCount() > 0)
    {
      a(((TextView)this.u.getChildAt(0)).getText().toString());
      g();
      return true;
    }
    if (!TextUtils.isEmpty(this.v.getText().toString()))
    {
      a(this.v.getText().toString());
      this.v.setText("");
      d(false);
      return true;
    }
    return false;
  }
  
  private void g()
  {
    this.v.setText("");
    d(false);
    a(null);
  }
  
  public void a(int paramInt, View paramView)
  {
    paramView = ((TextView)paramView.findViewById(2131625465)).getText().toString();
    a(paramView);
    this.v.setText("");
    d(false);
    a(KeyboardService.getInstance().relateWords(paramView));
    if (this.i != null) {
      this.i.setNeedGrantResultFocus(true);
    }
    if (!TextUtils.isEmpty(paramView)) {
      KeyboardService.getInstance().userSelected(paramView);
    }
  }
  
  public void a(Activity paramActivity, com.baidu.carlife.core.screen.e parame)
  {
    this.h = parame;
    this.b = paramActivity;
    e();
  }
  
  public void a(KeyboardEditText paramKeyboardEditText)
  {
    this.q = paramKeyboardEditText;
    if (com.baidu.carlife.l.a.a().N())
    {
      this.q.setShowSoftInputOnFocus(false);
      this.b.getWindow().setSoftInputMode(2);
      return;
    }
    this.q.setShowSoftInputOnFocus(true);
    this.b.getWindow().setSoftInputMode(2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.x = paramBoolean;
    if (!b()) {}
    while (this.i == null) {
      return;
    }
    if (paramBoolean)
    {
      this.i.i();
      return;
    }
    this.i.j();
  }
  
  public boolean b()
  {
    return (this.h != null) && (this.h.isDialogShown());
  }
  
  public boolean b(KeyboardEditText paramKeyboardEditText)
  {
    if (com.baidu.carlife.l.a.a().N())
    {
      a = true;
      if (g.a().c())
      {
        c();
        return true;
      }
      if (KeyboardService.getInstance().isLoadLibSuc())
      {
        c();
        return true;
      }
    }
    return false;
  }
  
  public void c()
  {
    e();
    if (this.h != null)
    {
      this.h.showDialog(this.i, BaseDialog.a.c);
      if (com.baidu.carlife.core.e.z() >= 5) {
        StatisticManager.onEvent("OTHER_0006");
      }
    }
  }
  
  public void d()
  {
    if ((this.h != null) && (this.h.isDialogShown()))
    {
      this.h.dismissDialog(this.i);
      g();
      this.d = false;
      c(false);
      b(false);
      this.q = null;
    }
  }
  
  public class a
    implements View.OnTouchListener
  {
    public a(KeyboardEditText paramKeyboardEditText)
    {
      this(paramKeyboardEditText, 0, null, null);
    }
    
    public a(KeyboardEditText paramKeyboardEditText, int paramInt, a.c paramc, final a.d paramd)
    {
      paramKeyboardEditText.setOnClickFinishListener(paramc);
      switch (paramInt)
      {
      default: 
        paramKeyboardEditText.setFinishText(BaiduNaviApplication.getInstance().getString(2131296547));
      }
      for (;;)
      {
        paramKeyboardEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            if (paramd != null) {
              paramd.onFocusChange(paramAnonymousView, paramAnonymousBoolean);
            }
          }
        });
        return;
        paramKeyboardEditText.setFinishText(BaiduNaviApplication.getInstance().getString(2131296548));
      }
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return false;
        a.this.a((KeyboardEditText)paramView);
        continue;
        a.this.b((KeyboardEditText)paramView);
      }
    }
  }
  
  private class b
    extends d
  {
    private b() {}
    
    public void a(View paramView)
    {
      boolean bool2 = true;
      boolean bool3 = true;
      boolean bool1 = true;
      switch (paramView.getId())
      {
      case 2131625399: 
      case 2131625401: 
      case 2131625403: 
      case 2131625404: 
      case 2131625405: 
      case 2131625406: 
      case 2131625407: 
      case 2131625418: 
      case 2131625428: 
      case 2131625438: 
      case 2131625443: 
      default: 
      case 2131625408: 
      case 2131625409: 
      case 2131625410: 
      case 2131625411: 
      case 2131625412: 
      case 2131625413: 
      case 2131625414: 
      case 2131625415: 
      case 2131625416: 
      case 2131625417: 
      case 2131625419: 
      case 2131625420: 
      case 2131625421: 
      case 2131625422: 
      case 2131625423: 
      case 2131625424: 
      case 2131625425: 
      case 2131625426: 
      case 2131625427: 
      case 2131625430: 
      case 2131625431: 
      case 2131625432: 
      case 2131625433: 
      case 2131625434: 
      case 2131625435: 
      case 2131625436: 
      case 2131625444: 
      case 2131625445: 
      case 2131625446: 
      case 2131625447: 
      case 2131625449: 
      case 2131625450: 
      case 2131625451: 
      case 2131625452: 
      case 2131625453: 
      case 2131625454: 
      case 2131625455: 
      case 2131625456: 
      case 2131625457: 
      case 2131625458: 
      case 2131625461: 
      case 2131625462: 
      case 2131625429: 
      case 2131625440: 
      case 2131625437: 
      case 2131625448: 
      case 2131625442: 
      case 2131625463: 
      case 2131625441: 
      case 2131625460: 
        do
        {
          int i;
          do
          {
            do
            {
              return;
              paramView = ((TextView)paramView).getText().toString();
              if ((a.a(a.this)) || (a.b(a.this)))
              {
                a.a(a.this, paramView);
                a.a(a.this, false);
                return;
              }
              a.c(a.this).append(paramView);
              a.c(a.this).setSelection(a.c(a.this).getText().length());
              a.b(a.this, true);
              paramView = KeyboardService.getInstance().search(a.c(a.this).getText().toString());
              a.a(a.this, paramView);
              return;
              paramView = ((TextView)paramView).getText().toString();
              a.a(a.this, paramView);
              return;
              paramView = a.this;
              if (!a.b(a.this)) {}
              for (;;)
              {
                a.c(paramView, bool1);
                a.a(a.this, a.b(a.this));
                a.d(a.this);
                return;
                bool1 = false;
              }
              paramView = a.this;
              if (!a.a(a.this)) {}
              for (bool1 = bool2;; bool1 = false)
              {
                a.d(paramView, bool1);
                a.e(a.this, a.a(a.this));
                a.a(a.this, false);
                a.d(a.this);
                return;
              }
            } while (a.e(a.this) == null);
            paramView = a.c(a.this).getText().toString();
            if (paramView.length() > 0)
            {
              paramView = paramView.substring(0, paramView.length() - 1);
              a.c(a.this).setText(paramView);
              a.c(a.this).setSelection(paramView.length());
              if (TextUtils.isEmpty(paramView)) {
                a.b(a.this, false);
              }
              for (;;)
              {
                paramView = KeyboardService.getInstance().search(paramView);
                a.a(a.this, paramView);
                return;
                a.b(a.this, true);
              }
            }
            if (a.f(a.this).getCount() > 0)
            {
              a.a(a.this, null);
              return;
            }
            a.b(a.this, false);
            paramView = a.e(a.this).getText();
            i = a.e(a.this).getSelectionStart();
          } while ((paramView == null) || (paramView.length() <= 0) || (i <= 0));
          paramView.delete(i - 1, i);
          return;
          paramView = a.c(a.this).getText().toString();
          if ((a.g(a.this)) && (!TextUtils.isEmpty(paramView)) && (a.e(a.this) != null))
          {
            a.a(a.this, paramView);
            a.h(a.this);
            return;
          }
          if ((a.e(a.this) != null) && (a.e(a.this).getOnClickFinishListener() != null)) {
            a.e(a.this).getOnClickFinishListener().onClickFinish();
          }
          a.this.d();
          return;
        } while (a.d(a.this));
        a.a(a.this, " ");
        return;
      case 2131625439: 
      case 2131625459: 
        paramView = a.this;
        if (!a.i(a.this)) {}
        for (bool1 = bool3;; bool1 = false)
        {
          a.f(paramView, bool1);
          a.d(a.this);
          a.g(a.this, a.i(a.this));
          return;
        }
      case 2131625398: 
        a.this.d();
        return;
      case 2131625400: 
        a.j(a.this).b();
        return;
      case 2131625402: 
        a.j(a.this).a();
        return;
      }
      StatisticManager.onEvent("OTHER_0007");
    }
  }
  
  public static abstract interface c
  {
    public abstract void onClickFinish();
  }
  
  public static abstract interface d
  {
    public abstract void onFocusChange(View paramView, boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */