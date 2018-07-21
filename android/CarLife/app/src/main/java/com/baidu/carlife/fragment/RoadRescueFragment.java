package com.baidu.carlife.fragment;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.logic.q;
import com.baidu.carlife.util.p;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xmlpull.v1.XmlPullParser;

public class RoadRescueFragment
  extends ContentFragment
  implements View.OnClickListener
{
  public static final String a = RoadRescueFragment.class.getSimpleName();
  public static final String b = "key_rescue_name";
  public static final String c = "key_rescue_phone";
  public static final String d = "key_rescue_car_num";
  public static final String e = "key_rescue_car_color";
  public static final String f = "key_rescue_contact_name";
  public static final String g = "key_rescue_contact_phone";
  public static final String h = "key_rescue_show_info";
  private LinearLayout i;
  private LinearLayout j;
  private LinearLayout k;
  private TextView l;
  private ImageButton m;
  private j n = new a(null);
  private View o;
  private View p;
  private TextView q;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private g w;
  private g x;
  
  public RoadRescueFragment()
  {
    k.a(this.n);
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramString = new String(Base64.encode(paramString, 0, paramString.length, 0), "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a()
  {
    String str1 = p.a().a("key_rescue_name", null);
    String str2 = p.a().a("key_rescue_phone", null);
    String str3 = p.a().a("key_rescue_car_num", null);
    String str4 = p.a().a("key_rescue_car_color", null);
    String str5 = p.a().a("key_rescue_contact_name", null);
    String str6 = p.a().a("key_rescue_contact_phone", null);
    if (!TextUtils.isEmpty(str1))
    {
      this.q.setText(str1);
      if (TextUtils.isEmpty(str2)) {
        break label172;
      }
      this.r.setText(str2);
      label93:
      if (TextUtils.isEmpty(str3)) {
        break label184;
      }
      this.s.setText(str3);
      label108:
      if (TextUtils.isEmpty(str4)) {
        break label196;
      }
      this.t.setText(str4);
      label125:
      if (TextUtils.isEmpty(str5)) {
        break label208;
      }
      this.u.setText(str5);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str6)) {
        break label220;
      }
      this.v.setText(str6);
      return;
      this.q.setText("");
      break;
      label172:
      this.r.setText("");
      break label93;
      label184:
      this.s.setText("");
      break label108;
      label196:
      this.t.setText("");
      break label125;
      label208:
      this.u.setText("");
    }
    label220:
    this.v.setText("");
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (mActivity == null) {}
    for (;;)
    {
      return;
      Object localObject5 = null;
      Object localObject2 = null;
      Object localObject4 = null;
      String str1 = null;
      String str2 = null;
      InputStream localInputStream2 = null;
      InputStream localInputStream3 = localInputStream2;
      Object localObject3 = str1;
      Object localObject1 = str2;
      try
      {
        localInputStream1 = mActivity.getAssets().open("carlife_soap.xml");
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = str1;
        localObject5 = localInputStream1;
        localObject1 = str2;
        localObject2 = localInputStream1;
        String str3 = a(localInputStream1);
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = str1;
        localObject5 = localInputStream1;
        localObject1 = str2;
        localObject2 = localInputStream1;
        localInputStream2 = mActivity.getAssets().open("carlife_fsd.xml");
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        str2 = a(localInputStream2);
        str1 = paramString1;
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        if (TextUtils.isEmpty(paramString1)) {
          str1 = "";
        }
        paramString1 = paramString2;
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = "13800000000";
        }
        paramString2 = paramString4;
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        if (TextUtils.isEmpty(paramString4)) {
          paramString2 = "";
        }
        paramString4 = paramString3;
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        if (TextUtils.isEmpty(paramString3)) {
          paramString4 = "";
        }
        paramString3 = paramString5;
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        if (TextUtils.isEmpty(paramString5)) {
          paramString3 = "";
        }
        paramString5 = paramString6;
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        if (TextUtils.isEmpty(paramString6)) {
          paramString5 = "";
        }
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString6 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        if ((str3 == null) || (str2 == null))
        {
          if (localInputStream1 != null) {}
          try
          {
            localInputStream1.close();
            if (localInputStream2 == null) {
              continue;
            }
          }
          catch (IOException paramString1)
          {
            try
            {
              localInputStream2.close();
              return;
              paramString1 = paramString1;
              paramString1.printStackTrace();
            }
            catch (IOException paramString1)
            {
              for (;;)
              {
                paramString1.printStackTrace();
              }
            }
          }
        }
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString4 = str2.replaceAll("CARLIFE_RESCUE_TIME", paramString6).replaceAll("CARLIFE_LINK_NAME", str1).replaceAll("CARLIFE_LINK_PHONE", paramString1).replaceAll("CARLIFE_CONTACT_NAME", paramString4).replaceAll("CARLIFE_CONTACT_PHONE", paramString2).replaceAll("CARLIFE_RESCUE_CAR_NUMBER", paramString3).replaceAll("CARLIFE_RESCUE_CAR_COLOR", paramString5).replaceAll("CARLIFE_RESCUE_MESSAGE_ID", String.valueOf(System.currentTimeMillis()) + (int)((Math.random() * 9.0D + 1.0D) * 10000.0D));
        paramString1 = "";
        paramString5 = "";
        paramString3 = paramString1;
        paramString2 = paramString5;
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        if (BNLocationManagerProxy.getInstance().isLocationValid())
        {
          localInputStream3 = localInputStream2;
          localObject4 = localInputStream1;
          localObject3 = localInputStream2;
          localObject5 = localInputStream1;
          localObject1 = localInputStream2;
          localObject2 = localInputStream1;
          paramString6 = BNLocationManagerProxy.getInstance().getCurLocation();
          paramString3 = paramString1;
          paramString2 = paramString5;
          if (paramString6 != null)
          {
            localInputStream3 = localInputStream2;
            localObject4 = localInputStream1;
            localObject3 = localInputStream2;
            localObject5 = localInputStream1;
            localObject1 = localInputStream2;
            localObject2 = localInputStream1;
            paramString3 = String.valueOf(paramString6.latitude);
            localInputStream3 = localInputStream2;
            localObject4 = localInputStream1;
            localObject3 = localInputStream2;
            localObject5 = localInputStream1;
            localObject1 = localInputStream2;
            localObject2 = localInputStream1;
            paramString2 = String.valueOf(paramString6.longitude);
          }
        }
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString6 = GeoLocateModel.getInstance().getProvinceDistrict().mName;
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString5 = GeoLocateModel.getInstance().getCurrentDistrict().mName;
        paramString1 = paramString4;
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        if (!TextUtils.isEmpty(paramString6))
        {
          localInputStream3 = localInputStream2;
          localObject4 = localInputStream1;
          localObject3 = localInputStream2;
          localObject5 = localInputStream1;
          localObject1 = localInputStream2;
          localObject2 = localInputStream1;
          paramString1 = paramString4.replaceAll("CARLIFE_RESCUE_PROVINCE", paramString6);
        }
        paramString4 = paramString1;
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        if (!TextUtils.isEmpty(paramString5))
        {
          localInputStream3 = localInputStream2;
          localObject4 = localInputStream1;
          localObject3 = localInputStream2;
          localObject5 = localInputStream1;
          localObject1 = localInputStream2;
          localObject2 = localInputStream1;
          paramString4 = paramString1.replaceAll("CARLIFE_RESCUE_CITY", paramString5);
        }
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString1 = paramString4.replaceAll("CARLIFE_RESCUE_LATITUDE", paramString3).replaceAll("CARLIFE_RESCUE_LONGITUDE", paramString2);
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString2 = str3.replaceAll("CARLIFE_USERNAME", "bdcarlife").replaceAll("CARLIFE_PASSWORD", "tsp123").replaceAll("CARLIFE_FSD", a(paramString1));
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        i.c(a, paramString1);
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        i.c(a, paramString2);
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString2 = paramString2.getBytes();
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString1 = (HttpURLConnection)new URL("http://lbs.mecall.healthlink.cn:8080/map/services/Ecallservice?wsdl").openConnection();
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString1.setConnectTimeout(5000);
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString1.setRequestMethod("POST");
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString1.setDoOutput(true);
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString1.setRequestProperty("Content-Type", "application/soap+xml;charset=UTF-8");
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString1.setRequestProperty("Content-Length", String.valueOf(paramString2.length));
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        paramString1.getOutputStream().write(paramString2);
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        i.c(a, paramString1.getResponseCode() + "");
        localInputStream3 = localInputStream2;
        localObject4 = localInputStream1;
        localObject3 = localInputStream2;
        localObject5 = localInputStream1;
        localObject1 = localInputStream2;
        localObject2 = localInputStream1;
        if (paramString1.getResponseCode() == 200)
        {
          localInputStream3 = localInputStream2;
          localObject4 = localInputStream1;
          localObject3 = localInputStream2;
          localObject5 = localInputStream1;
          localObject1 = localInputStream2;
          localObject2 = localInputStream1;
          paramString2 = Xml.newPullParser();
          localInputStream3 = localInputStream2;
          localObject4 = localInputStream1;
          localObject3 = localInputStream2;
          localObject5 = localInputStream1;
          localObject1 = localInputStream2;
          localObject2 = localInputStream1;
          paramString2.setInput(paramString1.getInputStream(), "UTF-8");
          localInputStream3 = localInputStream2;
          localObject4 = localInputStream1;
          localObject3 = localInputStream2;
          localObject5 = localInputStream1;
          localObject1 = localInputStream2;
          localObject2 = localInputStream1;
          i1 = paramString2.getEventType();
          break label1949;
          for (;;)
          {
            localInputStream3 = localInputStream2;
            localObject4 = localInputStream1;
            localObject3 = localInputStream2;
            localObject5 = localInputStream1;
            localObject1 = localInputStream2;
            localObject2 = localInputStream1;
            i1 = paramString2.next();
            break;
            localInputStream3 = localInputStream2;
            localObject4 = localInputStream1;
            localObject3 = localInputStream2;
            localObject5 = localInputStream1;
            localObject1 = localInputStream2;
            localObject2 = localInputStream1;
            i.c(a, paramString2.getName());
            localInputStream3 = localInputStream2;
            localObject4 = localInputStream1;
            localObject3 = localInputStream2;
            localObject5 = localInputStream1;
            localObject1 = localInputStream2;
            localObject2 = localInputStream1;
            if ("return".equals(paramString2.getName()))
            {
              localInputStream3 = localInputStream2;
              localObject4 = localInputStream1;
              localObject3 = localInputStream2;
              localObject5 = localInputStream1;
              localObject1 = localInputStream2;
              localObject2 = localInputStream1;
              paramString1 = paramString2.nextText();
              if (paramString1 != null)
              {
                localInputStream3 = localInputStream2;
                localObject4 = localInputStream1;
                localObject3 = localInputStream2;
                localObject5 = localInputStream1;
                localObject1 = localInputStream2;
                localObject2 = localInputStream1;
                if (paramString1.contains("接收信息成功"))
                {
                  localInputStream3 = localInputStream2;
                  localObject4 = localInputStream1;
                  localObject3 = localInputStream2;
                  localObject5 = localInputStream1;
                  localObject1 = localInputStream2;
                  localObject2 = localInputStream1;
                  i.c(a, "上传成功啦");
                }
              }
            }
          }
        }
      }
      catch (IOException paramString1)
      {
        InputStream localInputStream1;
        localObject1 = localInputStream3;
        localObject2 = localObject4;
        paramString1.printStackTrace();
        if (localObject4 != null) {}
        try
        {
          ((InputStream)localObject4).close();
          if (localInputStream3 == null) {
            continue;
          }
        }
        catch (IOException paramString1)
        {
          try
          {
            localInputStream3.close();
            return;
            if (localInputStream1 != null) {}
            try
            {
              localInputStream1.close();
              if (localInputStream2 == null) {
                continue;
              }
            }
            catch (IOException paramString1)
            {
              try
              {
                localInputStream2.close();
                return;
                paramString1 = paramString1;
                paramString1.printStackTrace();
              }
              catch (IOException paramString1)
              {
                for (;;)
                {
                  paramString1.printStackTrace();
                }
              }
            }
            paramString1 = paramString1;
            paramString1.printStackTrace();
          }
          catch (IOException paramString1)
          {
            for (;;)
            {
              paramString1.printStackTrace();
            }
          }
        }
      }
      catch (Exception paramString1)
      {
        localObject1 = localObject3;
        localObject2 = localObject5;
        paramString1.printStackTrace();
        if (localObject5 != null) {}
        try
        {
          ((InputStream)localObject5).close();
          if (localObject3 == null) {
            continue;
          }
        }
        catch (IOException paramString1)
        {
          try
          {
            ((InputStream)localObject3).close();
            return;
            paramString1 = paramString1;
            paramString1.printStackTrace();
          }
          catch (IOException paramString1)
          {
            for (;;)
            {
              paramString1.printStackTrace();
            }
          }
        }
      }
      finally
      {
        for (;;)
        {
          int i1;
          if (localObject2 != null) {}
          try
          {
            ((InputStream)localObject2).close();
            if (localObject1 == null) {}
          }
          catch (IOException paramString2)
          {
            try
            {
              ((InputStream)localObject1).close();
              throw paramString1;
              paramString2 = paramString2;
              paramString2.printStackTrace();
            }
            catch (IOException paramString2)
            {
              for (;;)
              {
                paramString2.printStackTrace();
              }
            }
          }
          label1949:
          if (i1 != 1) {
            switch (i1)
            {
            }
          }
        }
      }
    }
  }
  
  private void b()
  {
    this.i.setAlpha(1.0F);
    this.i.setEnabled(true);
    if (p.a().a("key_rescue_show_info", false))
    {
      this.m.setAlpha(1.0F);
      this.m.setEnabled(true);
      return;
    }
    this.m.setAlpha(0.2F);
    this.m.setEnabled(false);
  }
  
  private void c()
  {
    this.i.setAlpha(0.2F);
    this.i.setEnabled(false);
    this.m.setAlpha(0.2F);
    this.m.setEnabled(false);
  }
  
  public String a(InputStream paramInputStream)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      byte[] arrayOfByte = new byte['ࠀ'];
      for (;;)
      {
        int i1 = paramInputStream.read(arrayOfByte);
        if (i1 == -1) {
          break;
        }
        localStringBuffer.append(new String(arrayOfByte, 0, i1));
      }
      paramInputStream = localStringBuffer.toString();
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return null;
    }
    return paramInputStream;
  }
  
  public void driving()
  {
    i.b("yftech", "RoadRescueFragment driving");
    c();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131624264: 
    case 2131625103: 
      do
      {
        return;
      } while (showConnectForbidDialog());
      showFragment(551, null);
      return;
    case 2131625106: 
      showFragment(552, null);
      return;
    }
    StatisticManager.onEvent("DISCOVER_HJY_0002");
    paramView = new c(getContext()).a(2131296872).c(2131296259).r().d(2131296264);
    paramView.b(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        StatisticManager.onEvent("DISCOVER_HJY_0003");
        if (e.a().r()) {
          new Thread(new Runnable()
          {
            public void run()
            {
              String str1 = p.a().a("key_rescue_name", null);
              String str2 = p.a().a("key_rescue_phone", null);
              String str3 = p.a().a("key_rescue_contact_name", null);
              String str4 = p.a().a("key_rescue_contact_phone", null);
              String str5 = p.a().a("key_rescue_car_num", null);
              String str6 = p.a().a("key_rescue_car_color", null);
              RoadRescueFragment.a(RoadRescueFragment.this, str1, str2, str3, str4, str5, str6);
            }
          }).start();
        }
        q.f().a(RoadRescueFragment.this.getContext(), "010-57390680");
        StatisticManager.onEvent("1044", "1044");
      }
    });
    showDialog(paramView);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    i.c(a, "onCreateContentView");
    this.o = paramLayoutInflater.inflate(2130968798, null);
    setCommonTitleBar(this.o, getString(2131296885));
    this.m = ((ImageButton)this.o.findViewById(2131624264));
    this.i = ((LinearLayout)this.o.findViewById(2131625103));
    this.j = ((LinearLayout)this.o.findViewById(2131625105));
    this.k = ((LinearLayout)this.o.findViewById(2131625102));
    this.l = ((TextView)this.o.findViewById(2131625106));
    this.p = this.o.findViewById(2131625104);
    this.q = ((TextView)this.o.findViewById(2131624783));
    this.r = ((TextView)this.o.findViewById(2131624785));
    this.s = ((TextView)this.o.findViewById(2131624787));
    this.t = ((TextView)this.o.findViewById(2131624789));
    this.u = ((TextView)this.o.findViewById(2131624791));
    this.v = ((TextView)this.o.findViewById(2131624793));
    this.m.setVisibility(0);
    this.m.setImageResource(2130838279);
    paramLayoutInflater = getResources().getString(2131296882);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramLayoutInflater);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131558648)), paramLayoutInflater.length() - 4, paramLayoutInflater.length(), 33);
    this.l.setText(localSpannableStringBuilder);
    boolean bool = p.a().a("key_rescue_show_info", false);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    if (bool)
    {
      a();
      this.p.setVisibility(0);
      this.k.setVisibility(8);
      this.m.setAlpha(1.0F);
      this.m.setEnabled(true);
    }
    for (;;)
    {
      return this.o;
      this.m.setAlpha(0.2F);
      this.m.setEnabled(false);
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      setBottomBarStatus(false);
    }
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onInitFocusAreas()
  {
    if (this.w == null)
    {
      this.w = new g(this.mContentView.findViewById(2131624259), 2);
      this.w.d(this.mContentView.findViewById(2131624258));
    }
    if (this.x == null)
    {
      this.x = new g(this.o, 4);
      this.x.d(this.j);
    }
    d.a().b(new a[] { this.w, this.x });
    d.a().h(this.x);
  }
  
  protected void onInitView() {}
  
  public void onResume()
  {
    super.onResume();
    if (getNaviFragmentManager().isDriving())
    {
      i.b("yftech", "RoadRescueFragment onResume driving");
      c();
      return;
    }
    i.b("yftech", "RoadRescueFragment onResume stopDriving");
    b();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    updateCommonSkin();
    if (this.m != null) {
      this.m.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
    }
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void stopDriving()
  {
    i.b("yftech", "RoadRescueFragment stopDriving");
    b();
  }
  
  private class a
    extends j
  {
    private a() {}
    
    public void careAbout()
    {
      addMsg(3011);
    }
    
    public void handleMessage(Message paramMessage)
    {
      i.c(RoadRescueFragment.a, "msg.what=" + paramMessage.what);
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      try
      {
        if (p.a().a("key_rescue_show_info", false))
        {
          RoadRescueFragment.a(RoadRescueFragment.this);
          RoadRescueFragment.b(RoadRescueFragment.this).setVisibility(0);
          RoadRescueFragment.c(RoadRescueFragment.this).setVisibility(8);
          RoadRescueFragment.d(RoadRescueFragment.this).setAlpha(1.0F);
          RoadRescueFragment.d(RoadRescueFragment.this).setEnabled(true);
          return;
        }
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
      RoadRescueFragment.b(RoadRescueFragment.this).setVisibility(8);
      RoadRescueFragment.c(RoadRescueFragment.this).setVisibility(0);
      RoadRescueFragment.d(RoadRescueFragment.this).setAlpha(0.2F);
      RoadRescueFragment.d(RoadRescueFragment.this).setEnabled(false);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/RoadRescueFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */