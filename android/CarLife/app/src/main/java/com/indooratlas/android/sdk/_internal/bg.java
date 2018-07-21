package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

public final class bg
{
  @NonNull
  public final String a;
  @NonNull
  public final String b;
  @NonNull
  public final String c;
  @Nullable
  public final String d;
  public final int e;
  public final boolean f;
  @NonNull
  final Bundle g;
  
  private bg(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, int paramInt, Bundle paramBundle)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        new URL(paramString1);
        i = j;
        if (!paramBoolean)
        {
          i = j;
          if (paramString4 == null) {}
        }
      }
      catch (MalformedURLException paramString2)
      {
        throw new IllegalArgumentException("invalid service endpoint: " + paramString1);
      }
      try
      {
        if (!paramString4.startsWith("http://")) {
          break label152;
        }
        str = paramString4;
        new URL(str);
        i = 1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        ee.a("IACore", "invalid proxy address: " + paramString4, new Object[0]);
        i = j;
        continue;
        paramString4 = null;
        continue;
        paramInt = -1;
        continue;
      }
      this.a = paramString1;
      this.f = paramBoolean;
      if (i == 0) {
        break;
      }
      this.d = paramString4;
      if ((i == 0) || (paramInt <= 0) || (paramInt > 65535)) {
        break label215;
      }
      this.e = paramInt;
      this.b = paramString2;
      this.c = paramString3;
      this.g = paramBundle;
      return;
      label152:
      String str = "http://" + paramString4;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SdkEnvironment{restEndpoint='").append(this.a).append('\'').append(", apiKey='").append(this.b).append('\'');
    localStringBuilder.append(", mExtras=").append(this.g).append('}');
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public Bundle a;
    private Context b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g = -1;
    private boolean h;
    
    public a(Context paramContext)
    {
      this.b = ((Context)eg.a(paramContext, "context must be non-null", new Object[0]));
    }
    
    public final bg a()
      throws bc
    {
      boolean bool3 = true;
      Bundle localBundle1 = this.a;
      if ((localBundle1 == null) || (localBundle1.isEmpty())) {
        localBundle1 = Bundle.EMPTY;
      }
      for (;;)
      {
        Object localObject3;
        String str1;
        String str2;
        boolean bool2;
        boolean bool1;
        Object localObject2;
        int i;
        int j;
        try
        {
          Bundle localBundle2 = this.b.getPackageManager().getApplicationInfo(this.b.getPackageName(), 128).metaData;
          localObject3 = ct.a(new String[] { this.c, ed.a(localBundle1, "com.indooratlas.android.sdk.intent.extras.apiKey"), ed.a(localBundle2, "com.indooratlas.android.sdk.API_KEY") });
          str1 = ct.a(new String[] { this.d, ed.a(localBundle1, "com.indooratlas.android.sdk.intent.extras.apiSecret"), ed.a(localBundle2, "com.indooratlas.android.sdk.API_SECRET") });
          str2 = ct.a(new String[] { this.e, ed.a(localBundle1, "com.indooratlas.android.sdk.intent.extras.restEndpoint"), ed.a(localBundle2, "com.indooratlas.android.sdk.SERVICE_ENDPOINT"), "https://ipsws.indooratlas.com" });
          bool2 = bool3;
          if (!this.h)
          {
            if (localBundle1 == null) {
              break label461;
            }
            bool1 = localBundle1.getBoolean("com.indooratlas.android.sdk.intent.extras.proxyDisabled", false);
            bool2 = bool3;
            if (!bool1)
            {
              if ((localBundle2 == null) || (!localBundle2.getBoolean("com.indooratlas.android.sdk.PROXY_DISABLED", false))) {
                break label467;
              }
              bool2 = bool3;
            }
          }
          if (bool2) {
            break label546;
          }
          localObject2 = ct.a(new String[] { this.f, ed.a(localBundle1, "com.indooratlas.android.sdk.intent.extras.proxyAddress"), ed.a(localBundle2, "com.indooratlas.android.sdk.PROXY_ADDRESS"), ct.b("http.proxyHost") });
          int k = this.g;
          if (localBundle1 == null) {
            break label473;
          }
          i = localBundle1.getInt("com.indooratlas.android.sdk.intent.extras.proxyPort", -1);
          if (localBundle2 == null) {
            break label478;
          }
          j = localBundle2.getInt("com.indooratlas.android.sdk.PROXY_PORT", -1);
          i = ct.a(new int[] { k, i, j, ct.c("http.proxyPort") });
          if ((i <= 0) || (i > 65535)) {
            break label483;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          throw new bc("reading metadata failed: " + localNameNotFoundException);
        }
        Object localObject1;
        if (ei.a((CharSequence)localObject3))
        {
          throw new bc("SDK API key not set, check that manifest contains: com.indooratlas.android.sdk.API_KEY");
          localObject2 = new Bundle(localNameNotFoundException);
          localObject3 = new HashSet(((Bundle)localObject2).keySet()).iterator();
          for (;;)
          {
            localObject1 = localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (String)((Iterator)localObject3).next();
            if (((String)localObject1).contains(".debug.")) {
              ((Bundle)localObject2).remove((String)localObject1);
            }
          }
          label461:
          bool1 = false;
          continue;
          label467:
          bool2 = false;
          continue;
          label473:
          i = -1;
          continue;
          label478:
          j = -1;
          continue;
          label483:
          i = -1;
        }
        else
        {
          if (ei.a(str1)) {
            throw new bc("SDK API secret not set, check that manifest contains: com.indooratlas.android.sdk.API_SECRET");
          }
          if (ei.a(str2)) {
            throw new bc("Service endpoint empty, cannot proceed");
          }
          return new bg(str2, (String)localObject3, str1, bool2, (String)localObject2, i, (Bundle)localObject1, (byte)0);
          label546:
          localObject2 = null;
          i = -1;
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */