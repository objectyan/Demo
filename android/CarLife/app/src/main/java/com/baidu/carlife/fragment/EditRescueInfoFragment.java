package com.baidu.carlife.fragment;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.util.p;
import com.baidu.carlife.util.r;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticManager;

public class EditRescueInfoFragment
  extends ContentFragment
  implements View.OnClickListener
{
  public static final String a = EditRescueInfoFragment.class.getSimpleName();
  TextWatcher b = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if ((!TextUtils.isEmpty(EditRescueInfoFragment.a(EditRescueInfoFragment.this).getText().toString())) || (!TextUtils.isEmpty(EditRescueInfoFragment.b(EditRescueInfoFragment.this).getText().toString())) || (!TextUtils.isEmpty(EditRescueInfoFragment.c(EditRescueInfoFragment.this).getText().toString())) || (!TextUtils.isEmpty(EditRescueInfoFragment.d(EditRescueInfoFragment.this).getText().toString())) || (!TextUtils.isEmpty(EditRescueInfoFragment.e(EditRescueInfoFragment.this).getText().toString())) || (!TextUtils.isEmpty(EditRescueInfoFragment.f(EditRescueInfoFragment.this).getText().toString())))
      {
        EditRescueInfoFragment.g(EditRescueInfoFragment.this).setSelected(true);
        EditRescueInfoFragment.g(EditRescueInfoFragment.this).setClickable(true);
        EditRescueInfoFragment.g(EditRescueInfoFragment.this).setAlpha(1.0F);
        return;
      }
      EditRescueInfoFragment.g(EditRescueInfoFragment.this).setSelected(false);
      EditRescueInfoFragment.g(EditRescueInfoFragment.this).setClickable(false);
      EditRescueInfoFragment.g(EditRescueInfoFragment.this).setAlpha(0.2F);
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      i.c(EditRescueInfoFragment.a, "beforeTextChanged");
    }
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      i.c(EditRescueInfoFragment.a, "onTextChanged");
    }
  };
  private Button c;
  private EditText d;
  private EditText e;
  private EditText f;
  private EditText g;
  private EditText h;
  private EditText i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private c q;
  
  private void a()
  {
    if (this.q == null)
    {
      this.q = new c(getContext()).a(2131296883).g(17).c(2131296264).q().d(2131296259);
      this.q.a(new b()
      {
        public void onClick()
        {
          EditRescueInfoFragment.h(EditRescueInfoFragment.this);
          EditRescueInfoFragment.this.back();
          k.b(3011);
        }
      });
      this.q.b(new b()
      {
        public void onClick()
        {
          EditRescueInfoFragment.this.back();
        }
      });
    }
    showDialog(this.q);
  }
  
  private void b()
  {
    p.a().b("key_rescue_name", this.d.getText().toString());
    p.a().b("key_rescue_phone", this.e.getText().toString());
    p.a().b("key_rescue_car_num", this.f.getText().toString());
    p.a().b("key_rescue_car_color", this.g.getText().toString());
    p.a().b("key_rescue_contact_name", this.h.getText().toString());
    p.a().b("key_rescue_contact_phone", this.i.getText().toString());
    p.a().c("key_rescue_show_info", true);
    StatisticManager.onEvent("1043", "1043");
    StatisticManager.onEvent("DISCOVER_HJY_0004");
  }
  
  private void c()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)mActivity.getSystemService("input_method");
    View localView = mActivity.getCurrentFocus();
    if (localView != null) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 2);
    }
  }
  
  public boolean onBackPressed()
  {
    String str1 = this.d.getText().toString();
    String str2 = this.e.getText().toString();
    String str3 = this.f.getText().toString();
    String str4 = this.g.getText().toString();
    String str5 = this.h.getText().toString();
    String str6 = this.i.getText().toString();
    str1 = str1 + str2 + str3 + str4 + str5 + str6;
    this.j = p.a().a("key_rescue_name", null);
    this.k = p.a().a("key_rescue_phone", null);
    this.l = p.a().a("key_rescue_contact_name", null);
    this.m = p.a().a("key_rescue_contact_phone", null);
    this.n = p.a().a("key_rescue_car_num", null);
    this.o = p.a().a("key_rescue_car_color", null);
    this.p = (this.j + this.k + this.n + this.o + this.l + this.m);
    if (TextUtils.isEmpty(str1)) {}
    do
    {
      return false;
      i.c(a, "mOriginalStr=" + this.p + "\n,modifyStr=" + str1);
    } while ((!TextUtils.isEmpty(str1)) && (str1.equals(this.p)));
    a();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131624795: 
      do
      {
        return;
      } while ((TextUtils.isEmpty(this.d.getText().toString())) && (TextUtils.isEmpty(this.e.getText().toString())) && (TextUtils.isEmpty(this.f.getText().toString())) && (TextUtils.isEmpty(this.g.getText().toString())) && (TextUtils.isEmpty(this.h.getText().toString())) && (TextUtils.isEmpty(this.i.getText().toString())));
      b();
      back();
      k.b(3011);
      return;
    }
    c();
    paramView = this.d.getText().toString();
    String str1 = this.e.getText().toString();
    String str2 = this.f.getText().toString();
    String str3 = this.g.getText().toString();
    String str4 = this.h.getText().toString();
    String str5 = this.i.getText().toString();
    paramView = paramView + str1 + str2 + str3 + str4 + str5;
    this.j = p.a().a("key_rescue_name", null);
    this.k = p.a().a("key_rescue_phone", null);
    this.l = p.a().a("key_rescue_contact_name", null);
    this.m = p.a().a("key_rescue_contact_phone", null);
    this.n = p.a().a("key_rescue_car_num", null);
    this.o = p.a().a("key_rescue_car_color", null);
    this.p = (this.j + this.k + this.n + this.o + this.l + this.m);
    if (TextUtils.isEmpty(paramView))
    {
      back();
      return;
    }
    if ((!TextUtils.isEmpty(paramView)) && (paramView.equals(this.p)))
    {
      back();
      return;
    }
    a();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    i.c(a, "onCreateContentView");
    paramLayoutInflater = paramLayoutInflater.inflate(2130968752, null);
    setCommonTitleBar(paramLayoutInflater, getResources().getString(2131296876));
    this.c = ((Button)paramLayoutInflater.findViewById(2131624795));
    this.d = ((EditText)paramLayoutInflater.findViewById(2131624784));
    this.e = ((EditText)paramLayoutInflater.findViewById(2131624786));
    this.f = ((EditText)paramLayoutInflater.findViewById(2131624788));
    this.g = ((EditText)paramLayoutInflater.findViewById(2131624790));
    this.h = ((EditText)paramLayoutInflater.findViewById(2131624792));
    this.i = ((EditText)paramLayoutInflater.findViewById(2131624794));
    ImageButton localImageButton = (ImageButton)paramLayoutInflater.findViewById(2131624258);
    this.c.setOnClickListener(this);
    this.c.setSelected(false);
    localImageButton.setOnClickListener(this);
    this.d.addTextChangedListener(this.b);
    this.e.addTextChangedListener(this.b);
    this.f.addTextChangedListener(this.b);
    this.g.addTextChangedListener(this.b);
    this.h.addTextChangedListener(this.b);
    this.i.addTextChangedListener(this.b);
    this.j = p.a().a("key_rescue_name", null);
    this.k = p.a().a("key_rescue_phone", null);
    this.l = p.a().a("key_rescue_contact_name", null);
    this.m = p.a().a("key_rescue_contact_phone", null);
    this.n = p.a().a("key_rescue_car_num", null);
    this.o = p.a().a("key_rescue_car_color", null);
    this.p = (this.j + this.k + this.l + this.m + this.n + this.o);
    if (!TextUtils.isEmpty(this.j)) {
      this.d.setText(this.j);
    }
    if (!TextUtils.isEmpty(this.k)) {
      this.e.setText(this.k);
    }
    if (!TextUtils.isEmpty(this.l)) {
      this.h.setText(this.l);
    }
    if (!TextUtils.isEmpty(this.m)) {
      this.i.setText(this.m);
    }
    if (!TextUtils.isEmpty(this.n)) {
      this.f.setText(this.n);
    }
    if (!TextUtils.isEmpty(this.o)) {
      this.g.setText(this.o);
    }
    if ((TextUtils.isEmpty(this.j)) && (TextUtils.isEmpty(this.k)) && (TextUtils.isEmpty(this.l)) && (TextUtils.isEmpty(this.m)) && (TextUtils.isEmpty(this.n)) && (TextUtils.isEmpty(this.o)))
    {
      this.c.setSelected(false);
      this.c.setClickable(false);
      this.c.setAlpha(0.2F);
      return paramLayoutInflater;
    }
    this.c.setSelected(true);
    this.c.setClickable(true);
    this.c.setAlpha(1.0F);
    return paramLayoutInflater;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      setBottomBarStatus(false);
    }
    super.onHiddenChanged(paramBoolean);
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    updateCommonSkin();
    this.c.setBackground(r.b(2130838206));
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/EditRescueInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */