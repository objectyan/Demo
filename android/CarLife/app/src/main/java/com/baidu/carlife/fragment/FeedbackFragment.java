package com.baidu.carlife.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.carlife.custom.a;
import com.baidu.carlife.k.a.e.a;
import com.baidu.carlife.k.d;
import com.baidu.carlife.util.r;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.dialog.c;
import com.baidu.carlife.view.dialog.h;
import com.baidu.carlife.view.dialog.h.a;
import com.baidu.navi.controller.FeedbackController;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.StringUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class FeedbackFragment
  extends ContentFragment
  implements View.OnClickListener
{
  private static final int b = 400;
  private static final int c = 4;
  private static final String d = "key_content";
  private static final String e = "key_contact";
  private static final String f = "key_type";
  private static final String g = "28170";
  private static final String h = "28172";
  private static final String i = "28171";
  private static final int j = 40;
  private String A = "28170";
  private GridView B;
  private a C;
  private LayoutInflater D;
  private String E;
  private String F;
  private Animation G;
  private e.a H = new e.a()
  {
    public void onNetWorkResponse(int paramAnonymousInt)
    {
      if (!FeedbackFragment.this.isAdded()) {
        return;
      }
      FeedbackFragment.a(FeedbackFragment.this, true);
      if (paramAnonymousInt == 0)
      {
        if (FeedbackFragment.a(FeedbackFragment.this) != null) {
          FeedbackFragment.a(FeedbackFragment.this).setText("");
        }
        if (FeedbackFragment.b(FeedbackFragment.this) != null) {
          FeedbackFragment.b(FeedbackFragment.this).setText("");
        }
        FeedbackFragment.a(FeedbackFragment.this, "28170");
        TipTool.onCreateToastDialog(BaseFragment.mActivity, StyleManager.getString(2131296470));
        FeedbackFragment.this.onBackPressed();
        return;
      }
      FeedbackFragment.this.a(FeedbackFragment.this.getStringUtil(2131296469));
    }
  };
  private h.a I = new h.a()
  {
    public void a(int paramAnonymousInt) {}
    
    public void b(int paramAnonymousInt) {}
    
    public void c(int paramAnonymousInt) {}
    
    public void d(int paramAnonymousInt) {}
    
    public void e(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 0) {
        FeedbackFragment.this.b();
      }
      while (paramAnonymousInt != 1) {
        return;
      }
      FeedbackFragment.this.a();
    }
  };
  public e.a a = new e.a()
  {
    public void onNetWorkResponse(int paramAnonymousInt)
    {
      if (!FeedbackFragment.this.isAdded()) {
        return;
      }
      if (paramAnonymousInt == 0)
      {
        FeedbackController.getInstance().startUploadFeedback(FeedbackFragment.c(FeedbackFragment.this), FeedbackFragment.d(FeedbackFragment.this), FeedbackFragment.e(FeedbackFragment.this), FeedbackFragment.f(FeedbackFragment.this), BaseFragment.getNaviActivity());
        return;
      }
      FeedbackFragment.a(FeedbackFragment.this, true);
      FeedbackFragment.this.a(FeedbackFragment.this.getStringUtil(2131296469));
    }
  };
  private EditText k;
  private EditText l;
  private boolean m = false;
  private RelativeLayout n;
  private TextView o;
  private ImageView p;
  private ImageView q;
  private ImageButton r;
  private TextView s;
  private TextView t;
  private LinearLayout u;
  private LinearLayout v;
  private LinearLayout w;
  private ImageView x;
  private ImageView y;
  private ImageView z;
  
  private void a(View paramView)
  {
    this.n = ((RelativeLayout)paramView.findViewById(2131624116));
    this.o = ((TextView)paramView.findViewById(2131624750));
    this.p = ((ImageView)paramView.findViewById(2131624749));
    this.l = ((EditText)paramView.findViewById(2131624102));
    this.k = ((EditText)paramView.findViewById(2131624115));
    this.u = ((LinearLayout)paramView.findViewById(2131624739));
    this.v = ((LinearLayout)paramView.findViewById(2131624741));
    this.w = ((LinearLayout)paramView.findViewById(2131624743));
    this.x = ((ImageView)paramView.findViewById(2131624740));
    this.y = ((ImageView)paramView.findViewById(2131624742));
    this.z = ((ImageView)paramView.findViewById(2131624744));
    this.r = ((ImageButton)paramView.findViewById(2131624258));
    this.s = ((TextView)paramView.findViewById(2131624746));
    this.t = ((TextView)paramView.findViewById(2131624748));
    this.B = ((GridView)paramView.findViewById(2131624104));
    if (FeedbackController.getInstance().getmPicList().isEmpty()) {
      FeedbackController.getInstance().getmPicList().add(null);
    }
    this.C = new a();
    this.B.setAdapter(this.C);
    this.k.clearFocus();
  }
  
  private void a(ImageView paramImageView)
  {
    this.z.setBackgroundResource(2130838317);
    this.y.setBackgroundResource(2130838317);
    this.x.setBackgroundResource(2130838317);
    paramImageView.setBackgroundResource(2130838316);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.n.setClickable(true);
      this.o.setText(getStringUtil(2131296462));
      this.p.clearAnimation();
      this.p.setVisibility(8);
      return;
    }
    this.n.setClickable(false);
    this.o.setText(getStringUtil(2131296463));
    this.p.startAnimation(this.G);
    this.p.setVisibility(0);
  }
  
  private boolean a(EditText paramEditText)
  {
    int i1 = paramEditText.getScrollY();
    int i2 = paramEditText.getLayout().getHeight() - (paramEditText.getHeight() - paramEditText.getCompoundPaddingTop() - paramEditText.getCompoundPaddingBottom());
    if (i2 == 0) {}
    while ((i1 <= 0) && (i1 >= i2 - 1)) {
      return false;
    }
    return true;
  }
  
  private void b(String paramString)
  {
    if ("28172".equals(paramString))
    {
      a(this.y);
      return;
    }
    if ("28171".equals(paramString))
    {
      a(this.z);
      return;
    }
    a(this.x);
  }
  
  private void c()
  {
    View.OnClickListener local3 = new View.OnClickListener()
    {
      private long b;
      
      public void onClick(View paramAnonymousView)
      {
        long l = System.currentTimeMillis() / 1000L;
        FeedbackFragment.b(FeedbackFragment.this, FeedbackFragment.b(FeedbackFragment.this).getText().toString().trim());
        FeedbackFragment.c(FeedbackFragment.this, FeedbackFragment.a(FeedbackFragment.this).getText().toString().trim());
        if (StringUtils.isEmpty(FeedbackFragment.d(FeedbackFragment.this)))
        {
          FeedbackFragment.b(FeedbackFragment.this).setText("");
          FeedbackFragment.this.a(FeedbackFragment.this.getStringUtil(2131296466));
          return;
        }
        if (FeedbackFragment.d(FeedbackFragment.this).length() > 400)
        {
          FeedbackFragment.this.a(FeedbackFragment.this.getStringUtil(2131296467));
          return;
        }
        if (StringUtils.isEmpty(FeedbackFragment.e(FeedbackFragment.this)))
        {
          FeedbackFragment.a(FeedbackFragment.this).setText("");
          FeedbackFragment.this.a(FeedbackFragment.this.getStringUtil(2131296468));
          return;
        }
        if (FeedbackFragment.e(FeedbackFragment.this).length() > 40)
        {
          TipTool.onCreateToastDialog(BaseFragment.mActivity, FeedbackFragment.this.getStringUtil(2131296465));
          return;
        }
        if (NetworkUtils.mConnectState == 0)
        {
          TipTool.onCreateToastDialog(BaseFragment.mActivity, StyleManager.getString(2131296718));
          return;
        }
        this.b = l;
        FeedbackFragment.a(FeedbackFragment.this, false);
        paramAnonymousView = PreferenceHelper.getInstance(BaseFragment.getNaviActivity()).getString("feedback_clientid", "");
        String str1 = PreferenceHelper.getInstance(BaseFragment.getNaviActivity()).getString("feedback_appid", "");
        String str2 = PreferenceHelper.getInstance(BaseFragment.getNaviActivity()).getString("feedback_deviceid", "");
        if ((TextUtils.isEmpty(paramAnonymousView)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
        {
          paramAnonymousView = new d(FeedbackFragment.this.getStringUtil(2131296296), BaseFragment.getNaviActivity());
          paramAnonymousView.registerResponseListener(FeedbackFragment.this.a);
          paramAnonymousView.toPostRequest();
          return;
        }
        FeedbackController.getInstance().startUploadFeedback(FeedbackFragment.c(FeedbackFragment.this), FeedbackFragment.d(FeedbackFragment.this), FeedbackFragment.e(FeedbackFragment.this), FeedbackFragment.f(FeedbackFragment.this), BaseFragment.getNaviActivity());
      }
    };
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FeedbackFragment.this.onBackPressed();
      }
    };
    this.l.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if ((paramAnonymousView.getId() == 2131624102) && (FeedbackFragment.a(FeedbackFragment.this, FeedbackFragment.b(FeedbackFragment.this))))
        {
          paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(true);
          if (paramAnonymousMotionEvent.getAction() == 1) {
            paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(false);
          }
        }
        return false;
      }
    });
    this.r.setOnClickListener(local4);
    this.n.setOnClickListener(local3);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
  }
  
  private void d()
  {
    if (this.l != null) {
      FeedbackController.getInstance().setmContent(this.l.getText().toString().trim());
    }
    if (this.k != null) {
      FeedbackController.getInstance().setmContact(this.k.getText().toString().trim());
    }
    FeedbackController.getInstance().setType(this.A);
  }
  
  private void e()
  {
    TextWatcher local6 = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable != null)
        {
          FeedbackFragment.g(FeedbackFragment.this).setText("" + paramAnonymousEditable.length());
          if (paramAnonymousEditable.length() > 400) {
            FeedbackFragment.g(FeedbackFragment.this).setTextColor(r.a(2131558641));
          }
        }
        else
        {
          return;
        }
        FeedbackFragment.g(FeedbackFragment.this).setTextColor(r.a(2131558685));
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    TextWatcher local7 = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (FeedbackFragment.h(FeedbackFragment.this))
        {
          FeedbackFragment.b(FeedbackFragment.this, false);
          return;
        }
        FeedbackFragment.a(FeedbackFragment.this).getSelectionStart();
        int j = FeedbackFragment.a(FeedbackFragment.this).getSelectionEnd();
        int i;
        if (paramAnonymousEditable.length() > 40) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0) {
            TipTool.onCreateToastDialog(BaseFragment.mActivity, 2131296465);
          }
          try
          {
            paramAnonymousEditable.delete(40, j);
            String str = paramAnonymousEditable.toString();
            m = 0;
            int n = paramAnonymousEditable.length();
            j = 0;
            i = 0;
            for (;;)
            {
              if (i < n)
              {
                k = j;
                if (str.substring(i, i + 1).matches("[一-龥]"))
                {
                  m = 1;
                  FeedbackFragment.b(FeedbackFragment.this, true);
                }
                try
                {
                  paramAnonymousEditable.delete(i - j, i + 1 - j);
                  k = j + 1;
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    localException2.printStackTrace();
                    k = j;
                  }
                }
                i += 1;
                j = k;
                continue;
                i = 0;
              }
            }
          }
          catch (Exception localException1)
          {
            int m;
            int k;
            for (;;)
            {
              localException1.printStackTrace();
            }
            if (m != 0) {
              TipTool.onCreateToastDialog(BaseFragment.mActivity, 2131296464);
            }
            FeedbackFragment.b(FeedbackFragment.this, false);
          }
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.l.addTextChangedListener(local6);
    this.k.addTextChangedListener(local7);
    this.k.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView) {}
    });
  }
  
  private void f()
  {
    FeedbackController.getInstance().getmPicList().clear();
    FeedbackController.getInstance().getmPicList().add(null);
    FeedbackController.getInstance().getmPicListPath().clear();
    if (this.C != null) {
      this.C.notifyDataSetChanged();
    }
  }
  
  public void a()
  {
    Intent localIntent = new Intent("android.intent.action.PICK");
    localIntent.setType("image/*");
    try
    {
      startActivityForResult(localIntent, 4610);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      w.a("您的手机没有图库应用", 0);
    }
  }
  
  public void a(String paramString)
  {
    showDialog(new c(mActivity).b(paramString).g(17).c(2131296262));
  }
  
  public void b()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    if (FeedbackController.getInstance().hasSdcard())
    {
      FeedbackController.getInstance().setTempFile(new File(Environment.getExternalStorageDirectory(), UUID.randomUUID().toString() + ".png"));
      localIntent.putExtra("output", FileProvider.getUriForFile(getNaviActivity(), "com.baidu.carlife.fileprovider", FeedbackController.getInstance().getTempFile()));
    }
    try
    {
      startActivityForResult(localIntent, 4609);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      w.a("您的手机没有摄像应用", 0);
    }
  }
  
  public void driving()
  {
    i.b("yftech", "FeedbackFragment driving");
    getNaviFragmentManager().back();
    getNaviFragmentManager().back();
    a.a().d();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    String str2;
    String str1;
    Object localObject;
    if (paramBundle != null)
    {
      str2 = paramBundle.getString("key_content");
      String str3 = paramBundle.getString("key_contact");
      str1 = str3;
      localObject = str2;
      if (!TextUtils.isEmpty(paramBundle.getString("key_type")))
      {
        str1 = str3;
        localObject = str2;
        if (!TextUtils.isEmpty(str2))
        {
          this.A = paramBundle.getString("key_type");
          localObject = str2;
          str1 = str3;
        }
      }
      if (this.k != null) {
        this.k.setText(str1);
      }
      if (this.l != null) {
        this.l.setText((CharSequence)localObject);
      }
      if (this.s != null)
      {
        if (localObject != null) {
          break label346;
        }
        this.s.setText("0");
      }
      label124:
      if ((this.s != null) && (localObject != null))
      {
        if (((String)localObject).length() <= 400) {
          break label379;
        }
        this.s.setTextColor(r.a(2131558641));
      }
    }
    for (;;)
    {
      b(this.A);
      paramBundle = new SpannableString(getStringUtil(2131296314));
      paramBundle.setSpan(new AbsoluteSizeSpan(18, true), 0, paramBundle.length(), 33);
      this.l.setHint(paramBundle);
      paramBundle = new SpannableString(getStringUtil(2131296316));
      paramBundle.setSpan(new AbsoluteSizeSpan(18, true), 0, paramBundle.length(), 33);
      this.k.setHint(paramBundle);
      this.G = AnimationUtils.loadAnimation(getNaviActivity(), 2131034132);
      paramBundle = new LinearInterpolator();
      this.G.setInterpolator(paramBundle);
      return;
      paramBundle = FeedbackController.getInstance().getmContent();
      str2 = FeedbackController.getInstance().getmContact();
      str1 = str2;
      localObject = paramBundle;
      if (TextUtils.isEmpty(FeedbackController.getInstance().getType())) {
        break;
      }
      str1 = str2;
      localObject = paramBundle;
      if (TextUtils.isEmpty(paramBundle)) {
        break;
      }
      this.A = FeedbackController.getInstance().getType();
      str1 = str2;
      localObject = paramBundle;
      break;
      label346:
      this.s.setText(((String)localObject).length() + "");
      break label124;
      label379:
      this.s.setTextColor(r.a(2131558685));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = FeedbackController.getInstance().getBitmapFilePath(mActivity, paramInt1, paramInt2, paramIntent);
    Bitmap localBitmap = FeedbackController.getInstance().getBitmapByOpt(paramIntent);
    if (localBitmap != null)
    {
      FeedbackController.getInstance().getmPicList().add(0, localBitmap);
      FeedbackController.getInstance().getmPicListPath().add(0, paramIntent);
      this.C.notifyDataSetChanged();
    }
  }
  
  public boolean onBackPressed()
  {
    mActivity.m();
    d();
    f();
    back(null);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131624740: 
    case 2131624742: 
    default: 
      return;
    case 2131624739: 
      this.A = "28170";
      a(this.x);
      return;
    case 2131624741: 
      this.A = "28172";
      a(this.y);
      return;
    }
    this.A = "28171";
    a(this.z);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((FeedbackController.getInstance().getmPicList() == null) || (FeedbackController.getInstance().getmPicListPath() == null)) {
      FeedbackController.getInstance().initPicList();
    }
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968742, null);
    setCommonTitleBar(this.mContentView, getString(2131296461));
    a(this.mContentView);
    return this.mContentView;
  }
  
  protected void onInitView()
  {
    c();
    e();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if ((this.k != null) && (this.l != null))
    {
      paramBundle.putString("key_content", this.l.getText().toString().trim());
      paramBundle.putString("key_contact", this.k.getText().toString().trim());
      paramBundle.putString("key_type", this.A);
    }
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onUpdateOrientation(int paramInt)
  {
    if (mActivity == null) {}
  }
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
    updateCommonSkin();
    this.mContentView.findViewById(2131624132).setBackground(r.b(2130837853));
    EditText localEditText = (EditText)this.mContentView.findViewById(2131624102);
    localEditText.setHintTextColor(r.a(2131558685));
    localEditText.setTextColor(r.a(2131558702));
    ((TextView)this.mContentView.findViewById(2131624745)).setTextColor(r.a(2131558685));
    if ((FeedbackController.getInstance().getmContent() != null) && (FeedbackController.getInstance().getmContent().length() > 400)) {
      this.s.setTextColor(r.a(2131558641));
    }
    for (;;)
    {
      this.mContentView.findViewById(2131624747).setBackground(r.b(2130837853));
      localEditText = (EditText)this.mContentView.findViewById(2131624115);
      localEditText.setBackground(r.b(2130837853));
      localEditText.setHintTextColor(r.a(2131558685));
      localEditText.setTextColor(r.a(2131558702));
      ((RelativeLayout)this.mContentView.findViewById(2131624116)).setBackground(r.b(2130838217));
      ((TextView)this.mContentView.findViewById(2131624750)).setTextColor(r.a(2131558701));
      return;
      this.s.setTextColor(r.a(2131558685));
    }
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void stopDriving() {}
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      if (FeedbackController.getInstance().getmPicList() == null) {
        return 0;
      }
      int i = FeedbackController.getInstance().getmPicList().size();
      FeedbackFragment.i(FeedbackFragment.this).setText(i - 1 + "");
      return FeedbackController.getInstance().getmPicList().size();
    }
    
    public Object getItem(int paramInt)
    {
      if (paramInt < FeedbackController.getInstance().getmPicList().size()) {
        return FeedbackController.getInstance().getmPicList().get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (FeedbackFragment.j(FeedbackFragment.this) == null) {
        FeedbackFragment.a(FeedbackFragment.this, LayoutInflater.from(FeedbackFragment.this.getContext()));
      }
      if (paramInt == FeedbackController.getInstance().getmPicList().size() - 1)
      {
        paramView = FeedbackFragment.j(FeedbackFragment.this).inflate(2130968628, null);
        FeedbackFragment.a(FeedbackFragment.this, (ImageView)paramView.findViewById(2131624098));
        if (FeedbackController.getInstance().getmPicList().size() == 4) {
          FeedbackFragment.k(FeedbackFragment.this).setVisibility(4);
        }
        FeedbackFragment.k(FeedbackFragment.this).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (FeedbackController.getInstance().getmPicList().size() == 4) {
              return;
            }
            paramAnonymousView = new h(BaseFragment.mActivity, 4, paramInt, FeedbackFragment.l(FeedbackFragment.this));
            FeedbackFragment.this.showDialog(paramAnonymousView);
          }
        });
        return paramView;
      }
      paramView = FeedbackFragment.j(FeedbackFragment.this).inflate(2130968629, null);
      paramViewGroup = (ImageView)paramView.findViewById(2131624099);
      paramViewGroup.setImageBitmap((Bitmap)FeedbackController.getInstance().getmPicList().get(paramInt));
      paramViewGroup.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FeedbackController.getInstance().openPicSrc(BaseFragment.mActivity, paramInt);
        }
      });
      paramView.findViewById(2131624100).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FeedbackController.getInstance().getmPicList().remove(paramInt);
          FeedbackController.getInstance().getmPicListPath().remove(paramInt);
          FeedbackFragment.m(FeedbackFragment.this).notifyDataSetChanged();
        }
      });
      return paramView;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/FeedbackFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */