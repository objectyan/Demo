package com.baidu.android.pushservice.message;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.android.pushservice.b.f;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.h.k;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.i.c;
import com.baidu.android.pushservice.i.d;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.a.l;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicMsg
  implements Parcelable
{
  public static final Parcelable.Creator<PublicMsg> CREATOR = new Parcelable.Creator()
  {
    public PublicMsg a(Parcel paramAnonymousParcel)
    {
      return new PublicMsg(paramAnonymousParcel);
    }
    
    public PublicMsg[] a(int paramAnonymousInt)
    {
      return new PublicMsg[paramAnonymousInt];
    }
  };
  public static final int FLAG_NEED_CLEAR = 1;
  public static final int FLAG_NEED_SOUND = 4;
  public static final int FLAG_NEED_VIBRATE = 2;
  private static final String TAG = "PublicMsg";
  public String mAdvertiseBigPictureClickUrl;
  public String mAdvertiseBigPictureContent;
  public String mAdvertiseBigPictureTitle;
  public String mAdvertiseBigPictureUrl;
  public String mAdvertiseClickUrl;
  public String mAdvertiseDetailClickUrl;
  public String mAdvertiseDownloadClickUrl;
  public String mAdvertiseLargeIconUrl;
  public String mAdvertiseSmallIconUrl;
  public int mAdvertiseStyle;
  public String mAppId;
  public String mCustomContent;
  public String mDescription;
  public boolean mIsSupportApp = true;
  public String mMsgId;
  public int mNetType = 0;
  public int mNotificationBasicStyle = 7;
  public int mNotificationBuilder = 0;
  public int mOpenType = 0;
  public String mPkgContent;
  public String mPkgName;
  public int mPkgVercode = 0;
  public String mSupportAppname;
  public String mTitle;
  public String mUrl;
  public int mUserConfirm = 0;
  
  public PublicMsg() {}
  
  PublicMsg(Parcel paramParcel)
  {
    this.mMsgId = paramParcel.readString();
    this.mAppId = paramParcel.readString();
    this.mTitle = paramParcel.readString();
    this.mDescription = paramParcel.readString();
    this.mUrl = paramParcel.readString();
    this.mPkgName = paramParcel.readString();
    this.mPkgVercode = paramParcel.readInt();
    this.mNotificationBuilder = paramParcel.readInt();
    this.mNotificationBasicStyle = paramParcel.readInt();
    this.mOpenType = paramParcel.readInt();
    this.mUserConfirm = paramParcel.readInt();
    this.mCustomContent = paramParcel.readString();
    this.mPkgContent = paramParcel.readString();
    this.mAdvertiseStyle = paramParcel.readInt();
    this.mAdvertiseSmallIconUrl = paramParcel.readString();
    this.mAdvertiseLargeIconUrl = paramParcel.readString();
    this.mAdvertiseClickUrl = paramParcel.readString();
    this.mAdvertiseBigPictureUrl = paramParcel.readString();
    this.mAdvertiseBigPictureClickUrl = paramParcel.readString();
    this.mAdvertiseDownloadClickUrl = paramParcel.readString();
    this.mAdvertiseDetailClickUrl = paramParcel.readString();
    this.mAdvertiseBigPictureTitle = paramParcel.readString();
    this.mAdvertiseBigPictureContent = paramParcel.readString();
  }
  
  private void addCustomContentToIntent(Intent paramIntent)
  {
    if (this.mCustomContent != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.mCustomContent);
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramIntent.putExtra(str, localJSONObject.getString(str));
        }
        paramIntent.putExtra("extra_extra_custom_content", this.mCustomContent);
        return;
      }
      catch (JSONException paramIntent) {}
    }
  }
  
  private void insertBehavior(Context paramContext, f paramf, k paramk, com.baidu.android.pushservice.h.j paramj)
  {
    if (paramf != null)
    {
      paramj.b(paramf.c());
      paramj = p.a(paramj, paramContext, paramf.c());
      paramk.j = paramf.c();
    }
    try
    {
      q.a(paramContext, paramk);
      q.a(paramContext, paramj);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void insertNotiBehavior(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    k localk = new k();
    localk.d = paramString3;
    localk.a = paramString1;
    localk.e = System.currentTimeMillis();
    localk.f = com.baidu.android.pushservice.h.a.b.b(paramContext);
    localk.c = l.f.a();
    localk.h = paramString2;
    paramString1 = com.baidu.android.pushservice.b.b.a(paramContext).d(paramString2);
    if (paramString1 != null) {
      insertBehavior(paramContext, paramString1, localk, new com.baidu.android.pushservice.h.j(paramString2));
    }
  }
  
  private void sendResult(final Context paramContext, final String paramString, int paramInt)
  {
    final String str1 = com.baidu.android.pushservice.j.a(paramContext).a();
    final String str2 = com.baidu.android.pushservice.j.a(paramContext).b();
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      com.baidu.android.pushservice.g.a.b("PublicMsg", "Fail Send Public msg result. Token invalid!", paramContext.getApplicationContext());
      return;
    }
    com.baidu.android.pushservice.g.a.a("PublicMsg", "Send Linkhit, msgId = " + paramString + ", resultCode = " + paramInt, paramContext.getApplicationContext());
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgid", paramString);
      localJSONObject.put("result_code", paramInt);
      paramString = localJSONObject.toString();
      d.a().a(new c("PushService-linkhit", (short)90)
      {
        public void a()
        {
          try
          {
            HashMap localHashMap = new HashMap();
            com.baidu.android.pushservice.e.b.a(localHashMap);
            localHashMap.put("method", "linkhit");
            localHashMap.put("channel_token", str2);
            localHashMap.put("data", paramString);
            if (com.baidu.android.pushservice.f.b.a(h.e() + str1, "POST", localHashMap).b() == 200) {
              com.baidu.android.pushservice.g.a.c("PublicMsg", "<<< public msg send result return OK!", paramContext.getApplicationContext());
            }
            return;
          }
          catch (Exception localException)
          {
            com.baidu.android.pushservice.g.a.b("PublicMsg", "error : " + localException.getMessage(), paramContext.getApplicationContext());
          }
        }
      });
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        com.baidu.android.pushservice.g.a.b("PublicMsg", paramString.getMessage(), paramContext.getApplicationContext());
      }
    }
  }
  
  private void startApplicationLauncher(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (this.mPkgContent != null) {}
      for (Intent localIntent = Intent.parseUri(this.mPkgContent, 0);; localIntent = new Intent())
      {
        String str = getLauncherActivityName(paramContext, paramString1);
        if (str == null) {
          break;
        }
        localIntent.setClassName(paramString1, str);
        localIntent.setFlags(localIntent.getFlags() | 0x10000000);
        localIntent.putExtra("open_type", 1);
        localIntent.putExtra("msgid", paramString2);
        paramContext.startActivity(localIntent);
        return;
      }
      return;
    }
    catch (URISyntaxException paramString1)
    {
      com.baidu.android.pushservice.g.a.b("PublicMsg", "error " + paramString1.getMessage(), paramContext.getApplicationContext());
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getLauncherActivityName(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.setPackage(paramString);
    paramContext = paramContext.getPackageManager().queryIntentActivities(localIntent, 0).iterator();
    while (paramContext.hasNext())
    {
      paramString = (ResolveInfo)paramContext.next();
      if (paramString.activityInfo != null) {
        return paramString.activityInfo.name;
      }
    }
    return null;
  }
  
  /* Error */
  public void handle(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc 24
    //   8: ldc_w 400
    //   11: aload_1
    //   12: invokevirtual 265	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   15: invokestatic 289	com/baidu/android/pushservice/g/a:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   18: ldc_w 402
    //   21: aload_2
    //   22: invokevirtual 406	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +23 -> 48
    //   28: ldc 24
    //   30: ldc_w 408
    //   33: aload_1
    //   34: invokevirtual 265	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   37: invokestatic 289	com/baidu/android/pushservice/g/a:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   40: aload_0
    //   41: aload_1
    //   42: aload_3
    //   43: iconst_2
    //   44: invokespecial 410	com/baidu/android/pushservice/message/PublicMsg:sendResult	(Landroid/content/Context;Ljava/lang/String;I)V
    //   47: return
    //   48: aload_1
    //   49: invokevirtual 371	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   52: astore_2
    //   53: aload_2
    //   54: aload_0
    //   55: getfield 93	com/baidu/android/pushservice/message/PublicMsg:mPkgName	Ljava/lang/String;
    //   58: iconst_0
    //   59: invokevirtual 414	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   62: getfield 419	android/content/pm/PackageInfo:versionCode	I
    //   65: aload_0
    //   66: getfield 62	com/baidu/android/pushservice/message/PublicMsg:mPkgVercode	I
    //   69: if_icmplt +271 -> 340
    //   72: aload_0
    //   73: getfield 101	com/baidu/android/pushservice/message/PublicMsg:mPkgContent	Ljava/lang/String;
    //   76: iconst_0
    //   77: invokestatic 326	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
    //   80: astore 6
    //   82: aload 6
    //   84: aload_0
    //   85: getfield 93	com/baidu/android/pushservice/message/PublicMsg:mPkgName	Ljava/lang/String;
    //   88: invokevirtual 367	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   91: pop
    //   92: aload_2
    //   93: aload 6
    //   95: iconst_0
    //   96: invokevirtual 422	android/content/pm/PackageManager:queryBroadcastReceivers	(Landroid/content/Intent;I)Ljava/util/List;
    //   99: invokeinterface 425 1 0
    //   104: ifle +59 -> 163
    //   107: aload_1
    //   108: aload 6
    //   110: invokevirtual 428	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   113: iload 4
    //   115: ifne +39 -> 154
    //   118: new 152	android/content/Intent
    //   121: dup
    //   122: ldc_w 430
    //   125: invokespecial 431	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   128: astore_2
    //   129: aload_2
    //   130: aload_0
    //   131: getfield 91	com/baidu/android/pushservice/message/PublicMsg:mUrl	Ljava/lang/String;
    //   134: invokestatic 437	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   137: invokevirtual 441	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   140: pop
    //   141: aload_2
    //   142: ldc_w 337
    //   145: invokevirtual 444	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   148: pop
    //   149: aload_1
    //   150: aload_2
    //   151: invokevirtual 348	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   154: aload_0
    //   155: aload_1
    //   156: aload_3
    //   157: iload 4
    //   159: invokespecial 410	com/baidu/android/pushservice/message/PublicMsg:sendResult	(Landroid/content/Context;Ljava/lang/String;I)V
    //   162: return
    //   163: aload_2
    //   164: aload 6
    //   166: iconst_0
    //   167: invokevirtual 377	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
    //   170: invokeinterface 425 1 0
    //   175: ifle +165 -> 340
    //   178: aload 6
    //   180: ldc_w 337
    //   183: invokevirtual 444	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   186: pop
    //   187: aload_1
    //   188: aload 6
    //   190: invokevirtual 348	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   193: goto -80 -> 113
    //   196: astore_2
    //   197: ldc 24
    //   199: new 272	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 446
    //   209: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_2
    //   213: invokevirtual 447	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
    //   216: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: aload_1
    //   223: invokestatic 270	com/baidu/android/pushservice/g/a:b	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   226: iload 5
    //   228: istore 4
    //   230: goto -117 -> 113
    //   233: astore_2
    //   234: ldc 24
    //   236: new 272	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 449
    //   246: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_2
    //   250: invokevirtual 352	java/net/URISyntaxException:getMessage	()Ljava/lang/String;
    //   253: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: aload_1
    //   260: invokestatic 270	com/baidu/android/pushservice/g/a:b	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   263: iload 5
    //   265: istore 4
    //   267: goto -154 -> 113
    //   270: astore_2
    //   271: ldc 24
    //   273: new 272	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   280: ldc_w 451
    //   283: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_2
    //   287: invokevirtual 452	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   290: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: aload_1
    //   297: invokestatic 270	com/baidu/android/pushservice/g/a:b	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   300: iload 5
    //   302: istore 4
    //   304: goto -191 -> 113
    //   307: astore_2
    //   308: ldc 24
    //   310: new 272	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 454
    //   320: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_2
    //   324: invokevirtual 455	android/content/ActivityNotFoundException:getMessage	()Ljava/lang/String;
    //   327: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: aload_1
    //   334: invokestatic 270	com/baidu/android/pushservice/g/a:b	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   337: goto -183 -> 154
    //   340: iconst_0
    //   341: istore 4
    //   343: goto -230 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	PublicMsg
    //   0	346	1	paramContext	Context
    //   0	346	2	paramString1	String
    //   0	346	3	paramString2	String
    //   1	341	4	i	int
    //   4	297	5	j	int
    //   80	109	6	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   53	113	196	android/content/pm/PackageManager$NameNotFoundException
    //   163	193	196	android/content/pm/PackageManager$NameNotFoundException
    //   53	113	233	java/net/URISyntaxException
    //   163	193	233	java/net/URISyntaxException
    //   53	113	270	java/lang/Exception
    //   163	193	270	java/lang/Exception
    //   149	154	307	android/content/ActivityNotFoundException
  }
  
  public void handleAlarmMessage(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    insertNotiBehavior(paramContext, paramString2, paramString3, paramString1);
  }
  
  public void handlePrivateNotification(Context paramContext, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    com.baidu.android.pushservice.g.a.a("PublicMsg", "=== Handle private notification: " + paramString1, paramContext);
    if ("com.baidu.android.pushservice.action.privatenotification.DELETE".equals(paramString1)) {
      insertNotiBehavior(paramContext, paramString2, paramString3, "010202");
    }
    do
    {
      for (;;)
      {
        return;
        paramString1 = paramContext.getPackageManager();
        try
        {
          if (paramString1.getPackageInfo(this.mPkgName, 0).versionCode >= this.mPkgVercode)
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("msgid", paramString2);
            localIntent.putExtra("notification_title", this.mTitle);
            localIntent.putExtra("notification_content", this.mDescription);
            localIntent.putExtra("com.baidu.pushservice.app_id", paramString3);
            localIntent.putExtra("baidu_message_secur_info", paramArrayOfByte1);
            localIntent.putExtra("baidu_message_body", paramArrayOfByte2);
            addCustomContentToIntent(localIntent);
            p.b(paramContext, localIntent, "com.baidu.android.pushservice.action.notification.CLICK", this.mPkgName);
            insertNotiBehavior(paramContext, paramString2, paramString3, "010201");
            if ((this.mOpenType == 1) && (this.mUrl != null))
            {
              paramString1 = new Intent();
              paramString1.setAction("android.intent.action.VIEW");
              paramString1.setData(Uri.parse(this.mUrl));
              paramString1.addFlags(268435456);
              paramContext.startActivity(paramString1);
              return;
            }
          }
        }
        catch (PackageManager.NameNotFoundException paramString1)
        {
          com.baidu.android.pushservice.g.a.b("PublicMsg", "package not exist \r\n" + paramString1.getMessage(), paramContext);
          return;
          if (this.mOpenType == 2)
          {
            if (TextUtils.isEmpty(this.mPkgContent)) {
              break label410;
            }
            paramString3 = Intent.parseUri(this.mPkgContent, 0);
            paramString3.setPackage(this.mPkgName);
            if (paramString1.queryBroadcastReceivers(paramString3, 0).size() > 0)
            {
              paramContext.sendBroadcast(paramString3);
              return;
            }
          }
        }
        catch (URISyntaxException paramString1)
        {
          com.baidu.android.pushservice.g.a.b("PublicMsg", "uri to intent fail \r\n" + paramString1.getMessage(), paramContext);
          return;
        }
      }
    } while (paramString1.queryIntentActivities(paramString3, 0).size() <= 0);
    paramString3.addFlags(268435456);
    paramString3.putExtra("open_type", 1);
    paramString3.putExtra("msgid", paramString2);
    paramContext.startActivity(paramString3);
    return;
    label410:
    startApplicationLauncher(paramContext, this.mPkgName, paramString2);
  }
  
  public void handleRichMediaNotification(Context paramContext, String paramString1, String paramString2)
  {
    com.baidu.android.pushservice.g.a.a("PublicMsg", "Handle rich media notification", paramContext);
    k localk = new k();
    if ("com.baidu.android.pushservice.action.media.DELETE".equals(paramString1)) {}
    for (localk.d = "010402";; localk.d = "010401")
    {
      localk.a = this.mMsgId;
      localk.c = l.h.a();
      localk.e = System.currentTimeMillis();
      localk.g = 0;
      localk.f = com.baidu.android.pushservice.h.a.b.b(paramContext);
      localk.h = paramString2;
      paramString1 = com.baidu.android.pushservice.b.b.a(paramContext).d(paramString2);
      if (paramString1 != null) {
        insertBehavior(paramContext, paramString1, localk, new com.baidu.android.pushservice.h.j(paramString2));
      }
      return;
      paramString1 = new Intent("com.baidu.android.pushservice.action.media.CLICK");
      paramString1.setPackage(this.mPkgName);
      paramString1.putExtra("public_msg", this);
      paramContext.sendBroadcast(paramString1);
    }
  }
  
  public String toString()
  {
    return "\r\n mMsgId = " + this.mMsgId + "\r\n mAppId = " + this.mAppId + "\r\n mTitle = " + this.mTitle + "\r\n mDescription = " + this.mDescription + "\r\n mUrl = " + this.mUrl + "\r\n mNetType = " + this.mNetType + "\r\n mSupportAppname = " + this.mSupportAppname + "\r\n mIsSupportApp = " + this.mIsSupportApp + "\r\n mPkgName = " + this.mPkgName + "\r\n mPlgVercode = " + this.mPkgVercode + "\r\n mNotificationBuilder = " + this.mNotificationBuilder + "\r\n mNotificationBasicStyle = " + this.mNotificationBasicStyle + "\r\n mOpenType = " + this.mOpenType + "\r\n mCustomContent = " + this.mCustomContent + "\r\n mIntent = " + this.mPkgContent + "\r\n";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mMsgId);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mDescription);
    paramParcel.writeString(this.mUrl);
    paramParcel.writeString(this.mPkgName);
    paramParcel.writeInt(this.mPkgVercode);
    paramParcel.writeInt(this.mNotificationBuilder);
    paramParcel.writeInt(this.mNotificationBasicStyle);
    paramParcel.writeInt(this.mOpenType);
    paramParcel.writeInt(this.mUserConfirm);
    paramParcel.writeString(this.mCustomContent);
    paramParcel.writeString(this.mPkgContent);
    paramParcel.writeInt(this.mAdvertiseStyle);
    paramParcel.writeString(this.mAdvertiseSmallIconUrl);
    paramParcel.writeString(this.mAdvertiseLargeIconUrl);
    paramParcel.writeString(this.mAdvertiseClickUrl);
    paramParcel.writeString(this.mAdvertiseBigPictureUrl);
    paramParcel.writeString(this.mAdvertiseBigPictureClickUrl);
    paramParcel.writeString(this.mAdvertiseDownloadClickUrl);
    paramParcel.writeString(this.mAdvertiseDetailClickUrl);
    paramParcel.writeString(this.mAdvertiseBigPictureTitle);
    paramParcel.writeString(this.mAdvertiseBigPictureContent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/PublicMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */