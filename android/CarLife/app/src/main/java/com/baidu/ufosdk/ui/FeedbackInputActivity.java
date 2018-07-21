package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.Editable;
import android.text.Html.ImageGetter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.ufosdk.ResumeCallBack;
import com.baidu.ufosdk.SubmitMessageCallBack;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.b.e;
import com.baidu.ufosdk.e.b;
import com.baidu.ufosdk.util.i;
import com.baidu.ufosdk.util.l;
import com.baidu.ufosdk.util.m;
import com.baidu.ufosdk.util.p;
import com.baidu.ufosdk.util.r;
import com.baidu.ufosdk.util.s;
import com.baidu.ufosdk.util.t;
import com.baidu.ufosdk.util.u;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

@SuppressLint({"NewApi", "HandlerLeak"})
public class FeedbackInputActivity
  extends Activity
{
  public static ArrayList a;
  public static Bitmap b;
  private final int A = 2131755008;
  private final int B = 2131755009;
  private final int C = 2131755010;
  private Intent D;
  private LinearLayout E;
  private LinearLayout F;
  private LinearLayout G;
  private RelativeLayout H;
  private ImageView I;
  private Button J;
  private LinearLayout K;
  private String L = "";
  private String M = "";
  private com.baidu.ufosdk.a.a N;
  private List O = new ArrayList();
  private ListView P;
  private br Q;
  private View R;
  private ExecutorService S;
  private View T;
  private TextView U;
  private boolean V = false;
  private boolean W = false;
  private LinearLayout X;
  private List Y;
  private int Z = -1;
  private SharedPreferences.Editor aa;
  private SharedPreferences ab;
  private View ac;
  private int ad = 0;
  private int ae = 0;
  private boolean af = true;
  private boolean ag = false;
  private boolean ah = false;
  private boolean ai = false;
  private ArrayList aj;
  private Handler ak = new aj(this);
  private BroadcastReceiver al = new be(this);
  private View am;
  private boolean an = false;
  private boolean ao = false;
  private EditText ap;
  private String aq = "";
  private boolean ar = true;
  private LinearLayout as;
  private String at;
  private boolean au = true;
  private TextView av;
  private String aw;
  private Button ax;
  protected boolean c = false;
  protected boolean d = false;
  protected boolean e = false;
  protected int f;
  Html.ImageGetter g = new bk(this);
  private final int h = 2131296257;
  private final int i = 2131296258;
  private final int j = 2131296259;
  private final int k = 2131296299;
  private final int l = 2131296273;
  private final int m = 2131296265;
  private final int n = 2131296266;
  private final int o = 2131296267;
  private final int p = 2131296268;
  private final int q = 2131296272;
  private final int r = 2131296269;
  private final int s = 2131296270;
  private final int t = 2131296260;
  private final int u = 2131296261;
  private final int v = 2131296262;
  private final int w = 2131296263;
  private final int x = 2131296283;
  private final int y = 2131296315;
  private final int z = 2131296264;
  
  /* Error */
  private int a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: invokevirtual 542	com/baidu/ufosdk/ui/FeedbackInputActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   10: aload_1
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: invokevirtual 548	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull +89 -> 109
    //   23: aload_1
    //   24: invokeinterface 553 1 0
    //   29: pop
    //   30: aload_1
    //   31: aload_1
    //   32: ldc_w 555
    //   35: invokeinterface 558 2 0
    //   40: invokeinterface 562 2 0
    //   45: astore_3
    //   46: aload_3
    //   47: ifnonnull +13 -> 60
    //   50: iconst_0
    //   51: istore_2
    //   52: aload_1
    //   53: invokeinterface 565 1 0
    //   58: iload_2
    //   59: ireturn
    //   60: aload_3
    //   61: invokestatic 570	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   64: istore_2
    //   65: goto -13 -> 52
    //   68: astore_1
    //   69: aconst_null
    //   70: astore_1
    //   71: aload_1
    //   72: invokeinterface 565 1 0
    //   77: iconst_0
    //   78: ireturn
    //   79: astore_1
    //   80: iconst_0
    //   81: ireturn
    //   82: astore_3
    //   83: aconst_null
    //   84: astore_1
    //   85: aload_1
    //   86: invokeinterface 565 1 0
    //   91: aload_3
    //   92: athrow
    //   93: astore_1
    //   94: goto -36 -> 58
    //   97: astore_1
    //   98: goto -7 -> 91
    //   101: astore_3
    //   102: goto -17 -> 85
    //   105: astore_3
    //   106: goto -35 -> 71
    //   109: iconst_0
    //   110: istore_2
    //   111: goto -59 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	FeedbackInputActivity
    //   0	114	1	paramUri	Uri
    //   51	60	2	i1	int
    //   45	16	3	str	String
    //   82	10	3	localObject1	Object
    //   101	1	3	localObject2	Object
    //   105	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   6	19	68	java/lang/Exception
    //   71	77	79	java/lang/Exception
    //   6	19	82	finally
    //   52	58	93	java/lang/Exception
    //   85	91	97	java/lang/Exception
    //   23	46	101	finally
    //   60	65	101	finally
    //   23	46	105	java/lang/Exception
    //   60	65	105	java/lang/Exception
  }
  
  private static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Bitmap localBitmap;
    if ((paramBitmap == null) || (paramInt <= 0)) {
      localBitmap = null;
    }
    int i3;
    int i4;
    do
    {
      do
      {
        return localBitmap;
        i3 = paramBitmap.getWidth();
        i4 = paramBitmap.getHeight();
        localBitmap = paramBitmap;
      } while (i3 <= paramInt);
      localBitmap = paramBitmap;
    } while (i4 <= paramInt);
    int i1 = Math.max(i3, i4) * paramInt / Math.min(i3, i4);
    int i2;
    if (i3 > i4) {
      i2 = i1;
    }
    for (;;)
    {
      if (i3 > i4) {
        i1 = paramInt;
      }
      try
      {
        paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i2, i1, true);
        i2 = (i2 - paramInt) / 2;
        i1 = (i1 - paramInt) / 2;
        try
        {
          localBitmap = Bitmap.createBitmap(paramBitmap, i2, i1, paramInt, paramInt);
          paramBitmap.recycle();
          return localBitmap;
        }
        catch (Exception paramBitmap)
        {
          return null;
        }
        i2 = paramInt;
      }
      catch (Exception paramBitmap) {}
    }
    return null;
  }
  
  private void a()
  {
    if (this.ac.getVisibility() == 0)
    {
      this.ac.setVisibility(8);
      this.ao = false;
      this.av.setTextColor(i.a(com.baidu.ufosdk.a.w, com.baidu.ufosdk.a.x, com.baidu.ufosdk.a.w, com.baidu.ufosdk.a.w));
      this.ap.setEnabled(true);
      return;
    }
    if (a != null) {
      a.clear();
    }
    getApplicationContext();
    new cb(this).execute(new Void[0]);
  }
  
  private void a(String paramString)
  {
    paramString = new cx(this, paramString);
    paramString.a(new az(this, paramString));
    paramString.show();
  }
  
  private boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Handler paramHandler)
  {
    Object localObject;
    String str;
    boolean bool;
    label159:
    int i1;
    label167:
    label207:
    long l1;
    if (com.baidu.ufosdk.a.ai != null)
    {
      localObject = com.baidu.ufosdk.a.ai;
      if (paramString2.contains("newMessage"))
      {
        str = null;
        ((SubmitMessageCallBack)localObject).onSubmitMessageBeforeCallback(paramString3, str);
      }
    }
    else
    {
      str = com.baidu.ufosdk.a.as;
      localObject = new HashMap();
      ((Map)localObject).put("clientid", paramString1);
      ((Map)localObject).put("appid", UfoSDK.appid);
      ((Map)localObject).put("devid", UfoSDK.devid);
      if ((UfoSDK.robotAnswer) && (this.af)) {
        ((Map)localObject).put("answerPerson", "robot");
      }
      if (!paramString2.contains("newMessage")) {
        ((Map)localObject).put("id", paramString2);
      }
      ((Map)localObject).put("content", paramString3);
      if (paramString4 != null) {
        break label824;
      }
      bool = false;
      if (!bool) {
        break label843;
      }
      i1 = 1;
      com.baidu.ufosdk.util.c.c("contactWay is " + paramString4);
      if (i1 != 0) {
        break label925;
      }
      ((Map)localObject).put("contact_way", paramString4);
      ((Map)localObject).put("brand", Build.MANUFACTURER);
      ((Map)localObject).put("model", Build.MODEL);
      ((Map)localObject).put("sdkvn", "1.7.13");
      ((Map)localObject).put("os", "android");
      ((Map)localObject).put("appvn", com.baidu.ufosdk.b.d.c());
      if (!s.a("android.permission.MOUNT_UNMOUNT_FILESYSTEMS")) {
        break label1006;
      }
      paramString1 = new StatFs(Environment.getDataDirectory().getPath());
      l1 = paramString1.getBlockSize();
      l1 = paramString1.getAvailableBlocks() * l1;
      label317:
      ((Map)localObject).put("freespace", String.valueOf(l1));
      ((Map)localObject).put("uid", com.baidu.ufosdk.a.b);
      ((Map)localObject).put("osvn", Build.VERSION.RELEASE);
      ((Map)localObject).put("extra", com.baidu.ufosdk.a.d);
      ((Map)localObject).put("extend_feedback_channel", Integer.valueOf(com.baidu.ufosdk.a.h));
      ((Map)localObject).put("osvc", String.valueOf(l.a()));
      ((Map)localObject).put("referer", com.baidu.ufosdk.a.n);
      ((Map)localObject).put("baiducuid", com.baidu.ufosdk.a.c);
      if (!TextUtils.isEmpty(this.aq)) {
        ((Map)localObject).put("faq_id", this.aq);
      }
      ((Map)localObject).put("phonetime", String.valueOf(System.currentTimeMillis()));
      if (!s.a("android.permission.ACCESS_NETWORK_STATE")) {
        break label1014;
      }
      ((Map)localObject).put("nettype", com.baidu.ufosdk.b.c.a(paramContext));
      label503:
      ((Map)localObject).put("screenSize", e.b(paramContext));
      if (com.baidu.ufosdk.a.a) {
        ((Map)localObject).put("logcat", com.baidu.ufosdk.b.a.a());
      }
      if (!TextUtils.isEmpty(com.baidu.ufosdk.a.f)) {
        ((Map)localObject).put("ip_location", com.baidu.ufosdk.a.f);
      }
      paramString1 = m.a(com.baidu.ufosdk.c.a.a((Map)localObject));
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString5))
        {
          paramString1 = "sdk_encrypt=" + URLEncoder.encode(paramString1, "UTF-8");
          paramString1 = b.a(str, paramString1);
          if (TextUtils.isEmpty(paramString1)) {
            break label1122;
          }
          paramString1 = new JSONObject(m.b(paramString1));
          com.baidu.ufosdk.util.c.a("response is -----------------> " + paramString1.toString());
          if ((UfoSDK.robotAnswer) && (this.af))
          {
            if (!paramString1.has("round")) {
              continue;
            }
            this.ad = ((Integer)paramString1.get("round")).intValue();
          }
          if (((Integer)paramString1.get("errno")).intValue() != 0) {
            break label1122;
          }
          UfoSDK.neverFeedback = false;
          UfoSDK.lastSendTime = System.currentTimeMillis();
          paramString4 = paramContext.getSharedPreferences("UfoSharePreference", 0).edit();
          paramString4.putBoolean("UfoNeverFeedback", false);
          paramString4.putLong("Ufolastsendtime", UfoSDK.lastSendTime);
          paramString4.commit();
          paramString1 = String.valueOf(paramString1.get("id"));
          if (com.baidu.ufosdk.a.ai != null) {
            com.baidu.ufosdk.a.ai.onSubmitMessageAfterCallback(paramString3, paramString1);
          }
          if (!paramString2.contains("newMessage")) {
            break label1124;
          }
          paramHandler.obtainMessage(14, paramString1).sendToTarget();
          return true;
          str = paramString2;
          break;
          label824:
          bool = Pattern.compile("[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}").matcher(paramString4).matches();
          break label159;
          label843:
          if (paramString4 == null)
          {
            bool = false;
            if (!bool) {
              continue;
            }
            i1 = 2;
            break label167;
          }
          bool = Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9]))\\d{8}$").matcher(paramString4).matches();
          continue;
          if (paramString4 == null)
          {
            bool = false;
            if (!bool) {
              continue;
            }
            i1 = 3;
            break label167;
          }
          bool = Pattern.compile("^[1-9][0-9]{4,}$").matcher(paramString4).matches();
          continue;
          i1 = 0;
          break label167;
          label925:
          if (i1 == 1)
          {
            com.baidu.ufosdk.util.c.c("contactWay is email");
            ((Map)localObject).put("email", paramString4);
            break label207;
          }
          if (i1 == 2)
          {
            com.baidu.ufosdk.util.c.c("contactWay is tel");
            ((Map)localObject).put("tel", paramString4);
            break label207;
          }
          com.baidu.ufosdk.util.c.c("contactWay is qq");
          ((Map)localObject).put("qq", paramString4);
          break label207;
          label1006:
          l1 = -1L;
          break label317;
          label1014:
          ((Map)localObject).put("nettype", "N/A");
          break label503;
        }
        paramString1 = "sdk_encrypt=" + URLEncoder.encode(paramString1, "UTF-8") + "&screenshot=" + URLEncoder.encode(paramString5, "UTF-8");
        continue;
        this.af = false;
        continue;
        return false;
      }
      catch (Exception paramString1)
      {
        com.baidu.ufosdk.util.c.a("sendRecord fail.", paramString1);
        Looper.prepare();
        Toast.makeText(paramContext, u.a("18"), 1).show();
        paramHandler.obtainMessage(13).sendToTarget();
        Looper.loop();
      }
      label1122:
      label1124:
      paramHandler.obtainMessage(12, paramString1).sendToTarget();
    }
  }
  
  private void b()
  {
    if (this.X == null) {}
    int i1;
    do
    {
      return;
      this.X.removeAllViews();
      i1 = 0;
    } while (i1 >= this.Y.size());
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    Object localObject3;
    if (i1 != this.Y.size() - 1)
    {
      localObject3 = new db(this);
      ((db)localObject3).setTag(Integer.valueOf(i1));
      ((db)localObject3).setBackgroundDrawable(null);
      ((db)localObject3).setPadding(0, 0, 0, 0);
      ((db)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((db)localObject3).setMaxHeight(i.a(getApplicationContext(), 48.0F));
      ((db)localObject3).setMinimumHeight(i.a(getApplicationContext(), 48.0F));
      ((db)localObject3).setMaxWidth(i.a(getApplicationContext(), 48.0F));
      ((db)localObject3).setMinimumWidth(i.a(getApplicationContext(), 48.0F));
      localRelativeLayout.addView((View)localObject3, new RelativeLayout.LayoutParams(i.a(getApplicationContext(), 48.0F), i.a(getApplicationContext(), 48.0F)));
    }
    for (;;)
    {
      try
      {
        if (this.Y.get(i1) == null) {
          break label747;
        }
        if (BitmapFactory.decodeByteArray((byte[])this.Y.get(i1), 0, ((byte[])this.Y.get(i1)).length) == null) {
          break;
        }
        Object localObject1 = BitmapFactory.decodeByteArray((byte[])this.Y.get(i1), 0, ((byte[])this.Y.get(i1)).length);
        if ((localObject1 == null) || (a((Bitmap)localObject1, i.a(getApplicationContext(), 45.0F)) == null)) {
          break;
        }
        ((db)localObject3).setImageBitmap((Bitmap)localObject1);
        localObject1 = new ImageButton(this);
        ((ImageButton)localObject1).setTag(Integer.valueOf(i1));
        ((ImageButton)localObject1).setBackgroundDrawable(null);
        ((ImageButton)localObject1).setPadding(i.a(getApplicationContext(), 9.0F), 0, 0, i.a(getApplicationContext(), 9.0F));
        ((ImageButton)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
        localObject3 = p.a(getApplicationContext(), "ufo_delete_little_icon.png");
        if (localObject3 == null) {
          break;
        }
        ((ImageButton)localObject1).setImageBitmap((Bitmap)localObject3);
        localObject3 = new RelativeLayout.LayoutParams(i.a(getApplicationContext(), 24.0F), i.a(getApplicationContext(), 24.0F));
        ((RelativeLayout.LayoutParams)localObject3).addRule(11);
        ((RelativeLayout.LayoutParams)localObject3).addRule(10);
        ((RelativeLayout.LayoutParams)localObject3).setMargins(0, 0, 0, 0);
        localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        ((ImageButton)localObject1).setOnClickListener(new bd(this));
        localObject1 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 48.0F), i.a(getApplicationContext(), 48.0F));
        if (i1 != 0) {
          break label727;
        }
        ((LinearLayout.LayoutParams)localObject1).setMargins(i.a(getApplicationContext(), 6.0F), 0, 0, 0);
        ((LinearLayout.LayoutParams)localObject1).gravity = 80;
        this.X.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
        i1 += 1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        System.gc();
        return;
      }
      ImageView localImageView = new ImageView(this);
      localImageView.setTag(Integer.valueOf(i1));
      localImageView.setBackgroundDrawable(null);
      localImageView.setPadding(0, 0, 0, 0);
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localImageView.setMaxHeight(i.a(getApplicationContext(), 48.0F));
      localImageView.setMinimumHeight(i.a(getApplicationContext(), 48.0F));
      localImageView.setMaxWidth(i.a(getApplicationContext(), 48.0F));
      localImageView.setMinimumWidth(i.a(getApplicationContext(), 48.0F));
      localRelativeLayout.addView(localImageView, new RelativeLayout.LayoutParams(i.a(getApplicationContext(), 48.0F), i.a(getApplicationContext(), 48.0F)));
      try
      {
        localObject3 = BitmapFactory.decodeByteArray((byte[])this.Y.get(i1), 0, ((byte[])this.Y.get(i1)).length);
        if ((localObject3 == null) || (a((Bitmap)localObject3, i.a(getApplicationContext(), 45.0F)) == null)) {
          break;
        }
        localImageView.setImageBitmap((Bitmap)localObject3);
        localImageView.setOnClickListener(new bf(this));
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        System.gc();
        return;
      }
      label727:
      localOutOfMemoryError2.setMargins(i.a(getApplicationContext(), 10.0F), 0, 0, 0);
      continue;
      label747:
      Object localObject2 = null;
    }
  }
  
  protected final void a(View paramView)
  {
    Object localObject = new Button(this);
    ((Button)localObject).setBackgroundDrawable(null);
    ((Button)localObject).setText("复制");
    ((Button)localObject).setTextSize(12.0F);
    ((Button)localObject).setTextColor(-1);
    ((Button)localObject).setGravity(17);
    localObject = new PopupWindow((View)localObject, i.a(getApplicationContext(), 60.0F), i.a(getApplicationContext(), 35.0F), true);
    ((PopupWindow)localObject).setTouchable(true);
    ((PopupWindow)localObject).getContentView().setOnClickListener(new bi(this, paramView, (PopupWindow)localObject));
    ((PopupWindow)localObject).setTouchInterceptor(new bj(this));
    try
    {
      ((PopupWindow)localObject).setBackgroundDrawable(r.a(this, "ufo_loading_bg.9.png"));
      ((PopupWindow)localObject).showAsDropDown(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      this.c = true;
      a();
      return false;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 1;
    if (paramMotionEvent.getAction() == 0)
    {
      LinearLayout localLinearLayout = this.F;
      Object localObject;
      int i1;
      int i3;
      if ((localLinearLayout != null) && ((localLinearLayout instanceof LinearLayout)))
      {
        localObject = new int[2];
        localLinearLayout.getLocationInWindow((int[])localObject);
        i1 = localObject[0];
        i3 = localObject[1];
        int i4 = localLinearLayout.getHeight();
        int i5 = localLinearLayout.getWidth();
        if ((paramMotionEvent.getX() <= i1) || (paramMotionEvent.getX() >= i5 + i1) || (paramMotionEvent.getY() <= i3) || (paramMotionEvent.getY() >= i4 + i3))
        {
          i1 = i2;
          if (this.aj != null) {
            localObject = this.aj.iterator();
          }
        }
      }
      label285:
      for (;;)
      {
        if (!((Iterator)localObject).hasNext())
        {
          i1 = i2;
          if (i1 != 0)
          {
            localObject = (InputMethodManager)getSystemService("input_method");
            if (localObject != null) {
              ((InputMethodManager)localObject).hideSoftInputFromWindow(localLinearLayout.getWindowToken(), 0);
            }
          }
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        View localView = (View)((Iterator)localObject).next();
        int[] arrayOfInt = new int[2];
        localView.getLocationOnScreen(arrayOfInt);
        i1 = arrayOfInt[0];
        i3 = arrayOfInt[1];
        if ((paramMotionEvent.getX() < i1) || (paramMotionEvent.getX() > i1 + localView.getWidth()) || (paramMotionEvent.getY() < i3) || (paramMotionEvent.getY() > localView.getHeight() + i3)) {}
        for (i1 = 0;; i1 = 1)
        {
          if (i1 == 0) {
            break label285;
          }
          i1 = 0;
          break;
        }
      }
    }
    if (getWindow().superDispatchTouchEvent(paramMotionEvent)) {
      return true;
    }
    return onTouchEvent(paramMotionEvent);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    if (!this.an)
    {
      localObject1 = new com.baidu.ufosdk.util.d(this);
      ((com.baidu.ufosdk.util.d)localObject1).c(((com.baidu.ufosdk.util.d)localObject1).c() + 1);
      this.an = true;
    }
    if (paramInt2 != -1) {}
    do
    {
      return;
      this.W = false;
    } while (paramIntent == null);
    for (;;)
    {
      try
      {
        localObject1 = paramIntent.getData();
        if (localObject1 == null) {
          break;
        }
        try
        {
          paramIntent = getContentResolver().openInputStream((Uri)localObject1);
          if (paramIntent.available() >= 3145728) {
            continue;
          }
          localObject3 = new byte['Ѐ'];
          localObject4 = new ByteArrayOutputStream();
          paramInt2 = paramIntent.read((byte[])localObject3);
          if (paramInt2 != -1) {
            continue;
          }
          localObject3 = ((ByteArrayOutputStream)localObject4).toByteArray();
          ((ByteArrayOutputStream)localObject4).close();
          paramIntent.close();
          if (localObject3 != null) {
            break label263;
          }
          paramIntent = (Intent)localObject3;
          try
          {
            Toast.makeText(this, u.a("21"), 1).show();
            return;
          }
          catch (Exception localException1) {}
        }
        catch (Exception localException2)
        {
          Object localObject3;
          Object localObject4;
          Object localObject2;
          long l1;
          paramIntent = null;
          continue;
        }
        System.out.println(localException1.getMessage());
        if (paramInt1 != this.Y.size() - 1) {
          break label429;
        }
        this.Y.set(paramInt1, paramIntent);
        this.Y.add(p.b(this));
        b();
        this.ap.setFocusable(true);
        this.ap.setFocusableInTouchMode(true);
        return;
      }
      catch (Exception paramIntent)
      {
        localObject2 = null;
        continue;
        ((ByteArrayOutputStream)localObject4).write((byte[])localObject3, 0, paramInt2);
        continue;
        Toast.makeText(this, u.a("21"), 1).show();
        return;
      }
      label263:
      paramIntent = (Intent)localObject3;
      localObject2 = t.a((byte[])localObject3, a((Uri)localObject2));
      if (localObject2 == null)
      {
        paramIntent = (Intent)localObject2;
        Toast.makeText(this, u.a("21"), 1).show();
        return;
      }
      paramIntent = (Intent)localObject2;
      paramInt2 = localObject2.length;
      if (paramInt2 > 1048576)
      {
        Toast.makeText(this, u.a("21"), 1).show();
        return;
      }
      paramIntent = (Intent)localObject2;
      paramInt2 = localObject2.length;
      if (paramInt2 == 0)
      {
        Toast.makeText(this, "图片选择错误，请重新选择一张。", 1).show();
        return;
      }
      paramIntent = (Intent)localObject2;
      localObject3 = (ActivityManager)getSystemService("activity");
      paramIntent = (Intent)localObject2;
      localObject4 = new ActivityManager.MemoryInfo();
      paramIntent = (Intent)localObject2;
      ((ActivityManager)localObject3).getMemoryInfo((ActivityManager.MemoryInfo)localObject4);
      paramIntent = (Intent)localObject2;
      l1 = ((ActivityManager.MemoryInfo)localObject4).availMem / 1024L;
      if (l1 < 35000L)
      {
        Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
        System.gc();
        return;
        label429:
        Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
        com.baidu.ufosdk.util.c.b("picBytesList--->clear");
        this.Y.clear();
        this.Y.add(p.b(this));
      }
      else
      {
        paramIntent = (Intent)localObject2;
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setRequestedOrientation(1);
    this.ab = getSharedPreferences("UfoSharePreference", 0);
    this.aa = this.ab.edit();
    this.aq = getIntent().getStringExtra("faq_id");
    this.L = getIntent().getStringExtra("msgid");
    this.at = getIntent().getStringExtra("no_result");
    if (TextUtils.isEmpty(this.L)) {
      this.L = "newMessage";
    }
    if (TextUtils.isEmpty(this.aq)) {
      this.aq = "";
    }
    paramBundle = this.ab.getString("contact", "N/A");
    com.baidu.ufosdk.util.c.a("************************加密后的联系方式：tempContactStr: " + paramBundle);
    this.aw = m.b(paramBundle);
    com.baidu.ufosdk.util.c.a("************************解密后的联系方式：contactStr: " + this.aw);
    this.aa.putBoolean("ADD_PIC_FLAG", true);
    this.aa.commit();
    if (this.aw == null) {
      this.aw = "";
    }
    com.baidu.ufosdk.a.h = getIntent().getIntExtra("feedback_channel", 0);
    a = new ArrayList();
    this.H = new RelativeLayout(this);
    this.H.setId(2131296260);
    this.H.setBackgroundColor(com.baidu.ufosdk.a.y);
    Object localObject2 = new RelativeLayout(this);
    ((RelativeLayout)localObject2).setId(2131296261);
    new RelativeLayout(this).setId(2131296263);
    this.J = new Button(this);
    this.J.setText(u.a("23"));
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(13);
    this.H.addView(this.J, paramBundle);
    this.J.setVisibility(8);
    paramBundle = new LinearLayout(this);
    paramBundle.setOrientation(0);
    paramBundle.setGravity(16);
    paramBundle.setBackgroundDrawable(p.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
    Object localObject1 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 18.0F), i.a(getApplicationContext(), 50.0F));
    ((LinearLayout.LayoutParams)localObject1).setMargins(i.a(getApplicationContext(), 10.0F), 0, 0, 0);
    this.I = new ImageView(this);
    this.I.setId(2131296257);
    this.I.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.I.setBackgroundDrawable(new BitmapDrawable(p.a(getApplicationContext(), "ufo_back_icon.png")));
    paramBundle.addView(this.I, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new TextView(this);
    ((TextView)localObject1).setText(com.baidu.ufosdk.a.g);
    ((TextView)localObject1).setTextSize(com.baidu.ufosdk.a.K);
    ((TextView)localObject1).setTextColor(com.baidu.ufosdk.a.D);
    ((TextView)localObject1).setGravity(16);
    Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).setMargins(0, 0, i.a(getApplicationContext(), 8.0F), 0);
    paramBundle.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(9);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout)localObject2).addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new TextView(this);
    ((TextView)localObject1).setId(2131296258);
    ((TextView)localObject1).setTextColor(com.baidu.ufosdk.a.s);
    ((TextView)localObject1).setTextSize(com.baidu.ufosdk.a.L);
    ((TextView)localObject1).setGravity(17);
    localObject3 = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(13);
    ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    this.ax = new Button(this);
    this.ax.setVisibility(8);
    this.ax.setText(u.a("17"));
    this.ax.setId(2131755010);
    this.ax.setTextColor(com.baidu.ufosdk.a.t);
    this.ax.setTextSize(com.baidu.ufosdk.a.S);
    this.ax.setGravity(17);
    this.ax.setTextColor(i.a(com.baidu.ufosdk.a.t, com.baidu.ufosdk.a.u, com.baidu.ufosdk.a.t, com.baidu.ufosdk.a.t));
    this.ax.setBackgroundColor(16777215);
    this.ax.setPadding(i.a(getApplicationContext(), 8.0F), 0, i.a(getApplicationContext(), 8.0F), 0);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(0, 0, i.a(getApplicationContext(), 10.0F), 0);
    ((RelativeLayout)localObject2).addView(this.ax, (ViewGroup.LayoutParams)localObject3);
    try
    {
      ((RelativeLayout)localObject2).setBackgroundDrawable(new BitmapDrawable(p.a(getApplicationContext(), "ufo_nav_bg.png")));
      localObject3 = new RelativeLayout.LayoutParams(-1, i.a(getApplicationContext(), 50.0F));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      this.H.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      this.ac = i.b(this, u.a("25"));
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      this.H.addView(this.ac, (ViewGroup.LayoutParams)localObject3);
      this.ac.setVisibility(8);
      this.G = new LinearLayout(this);
      this.G.setId(2131296273);
      this.G.setOrientation(0);
      this.F = new LinearLayout(this);
      this.F.setId(2131296259);
      this.F.setOrientation(1);
      this.F.setBackgroundColor(com.baidu.ufosdk.a.E);
      localObject3 = new RelativeLayout(this);
      ((RelativeLayout)localObject3).setId(2131296265);
      ((RelativeLayout)localObject3).setFocusable(true);
      ((RelativeLayout)localObject3).setFocusableInTouchMode(true);
      this.av = new TextView(this);
      this.av.setText("发送");
      this.av.setTextColor(com.baidu.ufosdk.a.w);
      this.av.setTextSize(13.0F);
      this.av.setGravity(17);
      this.av.setId(2131296299);
      this.av.setBackgroundColor(com.baidu.ufosdk.a.E);
      this.av.setClickable(true);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -1);
      ((RelativeLayout.LayoutParams)localObject4).addRule(11);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15);
      ((RelativeLayout.LayoutParams)localObject4).setMargins(i.a(getApplicationContext(), 7.0F), 0, 0, 0);
      ((RelativeLayout)localObject3).addView(this.av, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new LinearLayout(this);
      ((LinearLayout)localObject4).setOrientation(0);
      ((LinearLayout)localObject4).setBackgroundDrawable(p.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
      ((LinearLayout)localObject4).setClickable(true);
      ((LinearLayout)localObject4).setId(2131296300);
      Object localObject5 = new ImageView(this);
      ((ImageView)localObject5).setId(2131296267);
      ((ImageView)localObject5).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ImageView)localObject5).setBackgroundDrawable(new BitmapDrawable(p.a(getApplicationContext(), "ufo_pluspic_icon.png")));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      localLayoutParams.setMargins(i.a(getApplicationContext(), 5.0F), i.a(getApplicationContext(), 5.0F), i.a(getApplicationContext(), 5.0F), i.a(getApplicationContext(), 5.0F));
      ((LinearLayout)localObject4).addView((View)localObject5, localLayoutParams);
      localObject5 = new RelativeLayout.LayoutParams(i.a(getApplicationContext(), 33.0F), i.a(getApplicationContext(), 33.0F));
      ((RelativeLayout.LayoutParams)localObject5).addRule(15);
      ((RelativeLayout.LayoutParams)localObject5).addRule(9);
      ((RelativeLayout)localObject3).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      this.ap = new EditText(this);
      this.ap.setImeOptions(4);
      this.ap.setInputType(262144);
      this.ap.setSingleLine(false);
      this.ap.setId(2131296266);
      this.ap.setVisibility(0);
      this.ap.setTextSize(14.0F);
      this.ap.setGravity(16);
      this.ap.setPadding(i.a(getApplicationContext(), 5.0F), 0, i.a(getApplicationContext(), 5.0F), 0);
      localObject5 = new GradientDrawable();
      ((GradientDrawable)localObject5).setStroke(1, -2697514);
      float f1 = i.a(getApplicationContext(), 4.0F);
      ((GradientDrawable)localObject5).setColor(-1);
      ((GradientDrawable)localObject5).setCornerRadius(f1);
      this.ap.setBackgroundDrawable((Drawable)localObject5);
      localObject5 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject5).addRule(1, ((LinearLayout)localObject4).getId());
      ((RelativeLayout.LayoutParams)localObject5).addRule(0, this.av.getId());
      ((RelativeLayout.LayoutParams)localObject5).addRule(15);
      ((RelativeLayout)localObject3).addView(this.ap, (ViewGroup.LayoutParams)localObject5);
      this.ap.setOnEditorActionListener(new bl(this));
      this.ap.addTextChangedListener(new bm(this));
      this.av.setOnClickListener(new bn(this));
      ((LinearLayout)localObject4).setOnClickListener(new bo(this));
      this.ax.setOnClickListener(new bp(this));
      localObject4 = new LinearLayout.LayoutParams(-1, -1);
      this.G.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      this.G.setGravity(16);
      localObject3 = new LinearLayout.LayoutParams(-1, i.a(getApplicationContext(), 40.0F));
      this.G.setPadding(0, i.a(getApplicationContext(), 3.0F), i.a(getApplicationContext(), 4.0F), i.a(getApplicationContext(), 3.0F));
      this.F.setGravity(3);
      this.F.addView(this.G, (ViewGroup.LayoutParams)localObject3);
      this.am = new View(this);
      this.am.setId(2131296272);
      this.am.setBackgroundColor(com.baidu.ufosdk.a.C);
      localObject3 = new LinearLayout.LayoutParams(-1, 1);
      ((LinearLayout.LayoutParams)localObject3).setMargins(0, i.a(getApplicationContext(), 3.0F), 0, i.a(getApplicationContext(), 3.0F));
      this.F.addView(this.am, (ViewGroup.LayoutParams)localObject3);
      this.am.setVisibility(8);
      this.X = new LinearLayout(this);
      this.X.setOrientation(0);
      this.X.setPadding(0, i.a(getApplicationContext(), 8.0F), 0, i.a(getApplicationContext(), 8.0F));
      this.X.setId(2131296270);
      this.X.setVisibility(8);
      this.Y = new ArrayList();
      localObject3 = getIntent().getByteArrayExtra("shot");
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        this.Y.add(localObject3);
        this.Y.add(p.b(this));
        this.X.setVisibility(0);
        b();
        localObject3 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 229.0F), i.a(getApplicationContext(), 64.0F));
        this.F.addView(this.X, (ViewGroup.LayoutParams)localObject3);
        localObject3 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject3).addRule(12);
        this.F.setPadding(i.a(getApplicationContext(), 7.0F), i.a(getApplicationContext(), 5.0F), i.a(getApplicationContext(), 7.0F), i.a(getApplicationContext(), 5.0F));
        this.F.bringToFront();
        this.H.addView(this.F, (ViewGroup.LayoutParams)localObject3);
        this.P = new ListView(this);
        this.P.setBackgroundColor(com.baidu.ufosdk.a.F);
        this.P.setDivider(new ColorDrawable(com.baidu.ufosdk.a.F));
        this.P.setDividerHeight(0);
        this.Q = new br(this, this);
        this.P.setAdapter(this.Q);
        this.P.setFocusable(false);
        this.P.setCacheColorHint(com.baidu.ufosdk.a.F);
        this.P.setClickable(false);
        this.P.setTranscriptMode(2);
        this.P.setRecyclerListener(new bq(this));
        localObject3 = new LinearLayout(this);
        ((LinearLayout)localObject3).setId(2131296315);
        ((LinearLayout)localObject3).setBackgroundColor(0);
        ((LinearLayout)localObject3).setOrientation(1);
        ((LinearLayout)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.K = new LinearLayout(this);
        this.K.setId(2131296283);
        this.K.setBackgroundColor(com.baidu.ufosdk.a.F);
        this.K.clearAnimation();
        localObject4 = new LinearLayout.LayoutParams(-1, -1);
        localObject5 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject5).addRule(3, ((RelativeLayout)localObject2).getId());
        ((RelativeLayout.LayoutParams)localObject5).addRule(2, ((LinearLayout)localObject3).getId());
        ((RelativeLayout.LayoutParams)localObject5).setMargins(0, 0, 0, 0);
        this.K.addView(this.P, (ViewGroup.LayoutParams)localObject4);
        this.H.addView(this.K, (ViewGroup.LayoutParams)localObject5);
        this.as = new LinearLayout(this);
        this.as.setId(2131296269);
        this.as.setOrientation(0);
        this.as.setBackgroundColor(com.baidu.ufosdk.a.G);
        this.as.setGravity(16);
        this.as.setVisibility(8);
        localObject2 = new TextView(this);
        ((TextView)localObject2).setText("以上内容是否解决了您的问题？");
        ((TextView)localObject2).setTextColor(com.baidu.ufosdk.a.I);
        ((TextView)localObject2).setSingleLine(false);
        ((TextView)localObject2).setTextSize(12.0F);
        ((TextView)localObject2).setGravity(17);
        localObject4 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject4).setMargins(i.a(getApplicationContext(), 10.0F), 0, i.a(getApplicationContext(), 15.0F), 0);
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        this.as.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
        localObject2 = new Button(this);
        ((Button)localObject2).setText("解决了");
        ((Button)localObject2).setTextColor(com.baidu.ufosdk.a.H);
        ((Button)localObject2).setTextSize(13.0F);
        ((Button)localObject2).setGravity(17);
        ((Button)localObject2).setBackgroundDrawable(p.a(getApplicationContext(), "ufo_feedback_btn_defult.9.png", "ufo_feedback_btn_press.9.png"));
        localObject4 = new LinearLayout.LayoutParams(-1, i.a(getApplicationContext(), 43.0F));
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        this.as.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
        localObject4 = new View(this);
        ((View)localObject4).setBackgroundColor(0);
        localObject5 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 10.0F), -1);
        this.as.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
        localObject4 = new Button(this);
        ((Button)localObject4).setText("没有解决\n提交人工处理");
        ((Button)localObject4).setTextColor(com.baidu.ufosdk.a.H);
        ((Button)localObject4).setTextSize(10.0F);
        ((Button)localObject4).setGravity(17);
        ((Button)localObject4).setBackgroundDrawable(p.a(getApplicationContext(), "ufo_loading_bg_n.9.png", "ufo_loading_bg.9.png"));
        localObject5 = new LinearLayout.LayoutParams(-1, i.a(getApplicationContext(), 45.0F));
        ((LinearLayout.LayoutParams)localObject5).weight = 1.0F;
        this.as.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
        ((Button)localObject2).setOnClickListener(new ao(this));
        ((Button)localObject4).setOnClickListener(new aq(this));
        localObject2 = new LinearLayout.LayoutParams(-1, i.a(getApplicationContext(), 60.0F));
        this.as.bringToFront();
        this.as.setPadding(i.a(getApplicationContext(), 0.0F), i.a(getApplicationContext(), 0.0F), i.a(getApplicationContext(), 15.0F), i.a(getApplicationContext(), 0.0F));
        ((LinearLayout)localObject3).addView(this.as, (ViewGroup.LayoutParams)localObject2);
        this.T = new View(this);
        this.T.setId(2131296268);
        this.T.setBackgroundColor(-2236963);
        localObject2 = new LinearLayout.LayoutParams(-1, 1);
        ((LinearLayout)localObject3).addView(this.T, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, this.F.getId());
        this.H.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
        this.E = new LinearLayout(this);
        this.E.setOrientation(1);
        new LinearLayout.LayoutParams(-2, -2);
        localObject2 = new ImageView(this);
        localObject3 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 115.0F), i.a(getApplicationContext(), 101.0F));
      }
    }
    catch (Exception localException3)
    {
      try
      {
        ((ImageView)localObject2).setBackgroundDrawable(r.a(getApplicationContext(), "ufo_no_netwrok.png"));
        this.E.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        this.U = new TextView(this);
        this.U.setPadding(i.a(getApplicationContext(), 10.0F), i.a(getApplicationContext(), 18.0F), i.a(getApplicationContext(), 10.0F), i.a(getApplicationContext(), 11.0F));
        this.U.setTextSize(com.baidu.ufosdk.a.M);
        this.U.setTextColor(-10066330);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        i.a(getApplicationContext(), this.U);
        this.E.addView(this.U, (ViewGroup.LayoutParams)localObject2);
        this.J = new Button(this);
        this.J.setText(u.a("22"));
        this.J.setTextSize(com.baidu.ufosdk.a.N);
        this.J.setTextColor(-13421773);
      }
      catch (Exception localException3)
      {
        try
        {
          for (;;)
          {
            this.J.setBackgroundDrawable(p.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
            localObject2 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 122.0F), i.a(getApplicationContext(), 40.0F));
            this.E.addView(this.J, (ViewGroup.LayoutParams)localObject2);
            localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(13);
            this.H.addView(this.E, (ViewGroup.LayoutParams)localObject2);
            this.E.setGravity(17);
            this.E.setVisibility(8);
            localObject2 = new ViewGroup.LayoutParams(-1, -1);
            setContentView(this.H, (ViewGroup.LayoutParams)localObject2);
            this.R = i.b(this, u.a("13"));
            localObject2 = new RelativeLayout.LayoutParams(i.a(getApplicationContext(), 114.0F), i.a(getApplicationContext(), 39.0F));
            ((RelativeLayout.LayoutParams)localObject2).addRule(13);
            this.H.addView(this.R, (ViewGroup.LayoutParams)localObject2);
            if (UfoSDK.clientid.length() != 0) {
              break;
            }
            Toast.makeText(getApplicationContext(), u.a("18"), 1).show();
            paramBundle = new Intent(this, FeedbackListActivity.class);
            paramBundle.putExtra("feedback_channel", com.baidu.ufosdk.a.h);
            startActivity(paramBundle);
            finish();
            return;
            localException2 = localException2;
            localException2.printStackTrace();
            continue;
            this.Y.add(p.a(this));
            this.X.setVisibility(8);
          }
          localException3 = localException3;
          localException3.printStackTrace();
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            localException1.printStackTrace();
          }
          this.D = getIntent();
          this.L = this.D.getStringExtra("msgid");
          if (this.L == null) {
            break label3768;
          }
        }
      }
    }
    if ((this.L.length() > 0) && (!this.L.equals("newMessage")))
    {
      ((TextView)localObject1).setText("反馈详情");
      this.ax.setVisibility(8);
      this.af = false;
      this.au = true;
      this.e = true;
      this.S = Executors.newSingleThreadExecutor();
      this.S.execute(new as(this));
      paramBundle.setOnClickListener(new at(this));
      this.F.setOnClickListener(new au(this));
      this.J.setOnClickListener(new av(this));
      return;
    }
    label3768:
    ((TextView)localObject1).setText("意见反馈");
    if (UfoSDK.isShowFeedbackBtn) {
      this.ax.setVisibility(0);
    }
    for (;;)
    {
      this.af = true;
      this.au = false;
      this.e = false;
      this.R.setVisibility(8);
      this.ac.setVisibility(8);
      this.ak.obtainMessage(5, "newMessage").sendToTarget();
      break;
      this.ax.setVisibility(8);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.baidu.ufosdk.util.a.a = null;
  }
  
  public void onPause()
  {
    super.onPause();
    super.onPause();
    this.aa.putString("contactWay", null);
    if (this.ar)
    {
      if (TextUtils.isEmpty(this.aq)) {
        break label95;
      }
      this.aa.putString(this.aq, this.ap.getText().toString());
    }
    for (;;)
    {
      this.aa.commit();
      if (this.N != null)
      {
        this.N.a();
        this.N = null;
      }
      return;
      label95:
      this.aa.putString(this.L, this.ap.getText().toString());
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  public void onResume()
  {
    super.onResume();
    if (com.baidu.ufosdk.a.ah != null) {
      com.baidu.ufosdk.a.ah.onResumeCallback();
    }
    this.J.setText(u.a("22"));
    i.a((RelativeLayout)this.R, u.a("13"));
    if ((this.L != null) && (this.L.length() > 0))
    {
      if (this.N == null) {
        this.N = new com.baidu.ufosdk.a.a(getApplicationContext(), this.L);
      }
      this.N.b();
      if (!this.N.isAlive()) {
        this.N.start();
      }
    }
    Object localObject = new com.baidu.ufosdk.util.d(this);
    ((com.baidu.ufosdk.util.d)localObject).a(((com.baidu.ufosdk.util.d)localObject).a() + 1);
    if (com.baidu.ufosdk.a.ah != null) {
      com.baidu.ufosdk.a.ah.onResumeCallback();
    }
    i.a((RelativeLayout)this.ac, u.a("25"));
    this.ar = true;
    if (this.L == null)
    {
      this.L = "newMessage";
      localObject = "";
      if (this.at == null) {
        break label293;
      }
      this.ap.setText(this.at);
      label203:
      this.ap.setSelection(((String)localObject).length());
      if (this.ap.getText().toString().trim().length() > 0) {
        break label357;
      }
      this.av.setTextColor(com.baidu.ufosdk.a.x);
    }
    for (;;)
    {
      if (UfoSDK.clientid.length() != 0) {
        break label382;
      }
      new Thread(new bg(this)).start();
      return;
      if (this.L.length() != 0) {
        break;
      }
      this.L = "newMessage";
      break;
      label293:
      if (!TextUtils.isEmpty(this.aq))
      {
        localObject = this.ab.getString(this.aq, "");
        this.ap.setText((CharSequence)localObject);
        break label203;
      }
      localObject = this.ab.getString(this.L, "");
      this.ap.setText((CharSequence)localObject);
      break label203;
      label357:
      this.av.setTextColor(i.a(com.baidu.ufosdk.a.w, com.baidu.ufosdk.a.x, com.baidu.ufosdk.a.w, com.baidu.ufosdk.a.w));
    }
    label382:
    new Thread(new bh(this)).start();
  }
  
  public void onStart()
  {
    super.onStart();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.baidu.ufosdk.getchat");
    localIntentFilter.addAction("com.baidu.ufosdk.getmsgid");
    localIntentFilter.addAction("com.baidu.ufosdk.deletemsg_dialogdismiss");
    localIntentFilter.addAction("com.baidu.ufosdk.reload");
    registerReceiver(this.al, localIntentFilter);
  }
  
  public void onStop()
  {
    super.onStop();
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      View localView = getCurrentFocus();
      if (localView != null) {
        localInputMethodManager.hideSoftInputFromWindow(localView.getApplicationWindowToken(), 2);
      }
    }
    unregisterReceiver(this.al);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/FeedbackInputActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */