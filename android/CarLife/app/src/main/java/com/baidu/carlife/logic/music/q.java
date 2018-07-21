package com.baidu.carlife.logic.music;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.platform.c;
import com.baidu.carlife.util.w;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.util.StatisticManager;
import com.tencent.qplayauto.device.QPlayAutoJNI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class q
  extends b
{
  public static final List<MusicSongModel> T = new ArrayList();
  public static final String U = "LOCAL_MUSIC";
  public static final String V = "LAST_PLAYLIST";
  public static final String W = "MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}";
  public static boolean Y = false;
  private static final int aa = -202;
  private static final int ab = 20;
  private static final String ac = "http://dldir1.qq.com/music/clntupate/QQMusic.apk";
  private static final String ad = "com.tencent.qqmusic";
  private static final String ae = "DEFAULT_POP";
  private static final String af = "DEFAULT_HOT";
  protected b.b X;
  public HashMap<String, Integer> Z = new HashMap();
  private boolean ag = false;
  private boolean ah = false;
  private String ai = null;
  private int aj = -1;
  private long ak = 0L;
  private long al = 0L;
  private HashMap<String, Integer> am = new HashMap();
  private j an = new j(BaiduNaviApplication.getInstance().getMainLooper())
  {
    public void careAbout()
    {
      addMsg(4014);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 4014: 
      case -202: 
      case 1: 
      case 2: 
      case 5: 
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      str = (String)paramAnonymousMessage.obj;
                    } while ((TextUtils.isEmpty(str)) || (!str.equals(q.this.q())));
                    if (paramAnonymousMessage.arg1 == 43990)
                    {
                      q.this.j(1);
                      return;
                    }
                  } while (paramAnonymousMessage.arg1 != 43991);
                  q.this.j(0);
                  return;
                } while (paramAnonymousMessage.obj == null);
                String str = (String)paramAnonymousMessage.obj;
                q.this.a(null, str, 0, 0, paramAnonymousMessage.arg1);
                return;
                if (paramAnonymousMessage.obj.toString().indexOf("Heartbeat") < 0) {}
                q.a(q.this, (HashMap)paramAnonymousMessage.obj);
                return;
                if (paramAnonymousMessage.arg1 != 2) {
                  break;
                }
                paramAnonymousMessage = q.a((byte[])paramAnonymousMessage.obj);
              } while (paramAnonymousMessage == null);
              k.a(219, 1, paramAnonymousMessage);
              return;
            } while (paramAnonymousMessage.arg1 != 3);
            return;
            if (paramAnonymousMessage.arg1 != 1) {
              break;
            }
          } while (paramAnonymousMessage.obj == null);
          com.baidu.carlife.core.i.b("CarLifeMusic", "QQMusic:" + paramAnonymousMessage.obj.toString());
          return;
        } while (paramAnonymousMessage.arg1 != 2);
        com.baidu.carlife.core.i.b("CarLifeMusic", "播放缓冲区大小:" + paramAnonymousMessage.arg2);
        return;
      case 4: 
        if (paramAnonymousMessage.arg1 == 0)
        {
          com.baidu.carlife.core.i.c("CarLifeMusic", "连接成功");
          q.a(q.this);
          if (q.b(q.this)) {
            q.this.j(2);
          }
          paramAnonymousMessage = new Intent("com.baidu.carlife.Action.StartActivityBroadReceiver");
          BaseFragment.getNaviActivity().sendBroadcast(paramAnonymousMessage);
          try
          {
            Thread.sleep(500L);
            QPlayAutoJNI.SendRegisterPlayState(0);
            com.baidu.carlife.core.i.c("CarLifeMusic", "连接成功 end");
            return;
          }
          catch (InterruptedException paramAnonymousMessage)
          {
            for (;;)
            {
              paramAnonymousMessage.printStackTrace();
            }
          }
        }
        int i = 1;
        if (paramAnonymousMessage.arg1 == 1) {
          com.baidu.carlife.core.i.e("CarLifeMusic", "QQMusic:与手机连接失败!");
        }
        for (;;)
        {
          if (q.this.v() == 1)
          {
            q.this.u();
            q.this.a(0);
            q.a(q.this, false);
            q.a(q.this, null);
            q.a(q.this, -1);
          }
          q.this.j(i);
          q.this.e(null);
          q.this.I.clear();
          q.this.x.clear();
          if (q.this.H != null) {
            q.this.H.a("com.tencent.qqmusic");
          }
          q.this.S.clear();
          QPlayAutoJNI.stopConnect();
          return;
          if (paramAnonymousMessage.arg1 == 2)
          {
            com.baidu.carlife.core.i.e("CarLifeMusic", "QQMusic:与手机连接中断!");
            i = 7;
          }
        }
      }
      QPlayAutoJNI.SendInfo(1, "CarLifeMusic", "出现错误:" + paramAnonymousMessage.obj.toString());
    }
  };
  
  public q(Context paramContext, int paramInt, String paramString)
  {
    this.C = paramContext;
    this.E = paramString;
    this.F = paramInt;
    C();
    this.I = new ArrayList();
    k.a(this.an);
  }
  
  private void A()
  {
    this.Z.clear();
    this.ak = System.currentTimeMillis();
    QPlayAutoJNI.SetHandler(this.an);
    if (QPlayAutoJNI.startConnect() < 0)
    {
      QPlayAutoJNI.stopConnect();
      com.baidu.carlife.core.i.e("CarLifeMusic", "QQ音乐发现线程启动失败!");
    }
    while (k("com.tencent.qqmusic")) {
      return;
    }
    c("com.tencent.qqmusic");
  }
  
  private void B()
  {
    if (!e.a().r())
    {
      w.a(this.C.getString(2131296368), 0);
      return;
    }
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://dldir1.qq.com/music/clntupate/QQMusic.apk"));
      localIntent.addFlags(268435456);
      this.C.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void C()
  {
    if (n(this.E))
    {
      List localList = g();
      if ((localList != null) && (!localList.isEmpty()))
      {
        c(2);
        return;
      }
      c(1);
      return;
    }
    c(0);
  }
  
  private void D()
  {
    this.aj = ((int)(System.currentTimeMillis() - this.ak));
    int i = (int)(System.currentTimeMillis() - this.al);
    if (this.ai != null)
    {
      StatisticManager.onEventDuration(this.C, "MUSIC_QQ_0008", "QQ音乐版本号" + this.ai, this.aj);
      this.aj = -1;
    }
    if (i < 20000) {
      StatisticManager.onEvent("MUSIC_QQ_0017");
    }
  }
  
  public static Bitmap a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 0) {
      return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    return null;
  }
  
  @NonNull
  private com.baidu.carlife.model.i a(String paramString1, String paramString2, int paramInt)
  {
    com.baidu.carlife.model.i locali = new com.baidu.carlife.model.i();
    locali.a = paramString1;
    locali.c = paramString2;
    locali.d = paramInt;
    return locali;
  }
  
  private void a(String paramString, int paramInt)
  {
    com.baidu.carlife.core.i.b("CarLifeMusic", "QQMusic.onGetSongList() - FAIL");
    b(paramString);
    if (paramInt == 110)
    {
      k.b(249, s(), paramInt);
      return;
    }
    k.b(249, s(), -1);
  }
  
  private void a(final String paramString, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.ag) {
        return;
      }
      this.ag = true;
    }
    new Thread()
    {
      private String a(String paramAnonymousString, int paramAnonymousInt)
      {
        int j = q.this.I.size();
        int i = 0;
        while (i < j)
        {
          if (((com.baidu.carlife.model.i)q.this.I.get(i)).d == paramAnonymousInt)
          {
            paramAnonymousString = ((com.baidu.carlife.model.i)q.this.I.get(i)).c;
            q.this.e(paramAnonymousString);
          }
          i += 1;
        }
        return paramAnonymousString;
      }
      
      private void a(ArrayList paramAnonymousArrayList, List<MusicSongModel> paramAnonymousList)
      {
        int i = 0;
        if (i < paramAnonymousArrayList.size())
        {
          HashMap localHashMap = (HashMap)paramAnonymousArrayList.get(i);
          if (localHashMap.get("issong").toString().equals("0")) {}
          for (;;)
          {
            i += 1;
            break;
            MusicSongModel localMusicSongModel = new MusicSongModel();
            localMusicSongModel.b = localHashMap.get("name").toString();
            localMusicSongModel.f = localHashMap.get("artist").toString();
            localMusicSongModel.c = localHashMap.get("album").toString();
            localMusicSongModel.a = localHashMap.get("id").toString().replace("\"", "\\\"");
            paramAnonymousList.add(localMusicSongModel);
          }
        }
      }
      
      public void run()
      {
        Object localObject2 = paramString;
        Object localObject1;
        if (paramString.equals("DEFAULT_HOT"))
        {
          q.b(q.this, false);
          localObject1 = a((String)localObject2, 2130838994);
        }
        int m;
        ArrayList localArrayList2;
        label67:
        int n;
        int i1;
        int i2;
        for (;;)
        {
          m = paramInt2;
          int k = 0;
          int i = -11;
          int j = 1;
          ArrayList localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          n = i;
          i1 = k;
          i2 = j;
          if (j != 0)
          {
            n = i;
            i1 = k;
            i2 = j;
            if (localArrayList2.size() < 10) {
              if (i <= m * 20)
              {
                n = i;
                i1 = k;
                i2 = j;
                if (i != -11) {}
              }
              else
              {
                Object localObject3 = QPlayAutoJNI.GetSongLists(localArrayList1, (String)localObject1, m, paramInt1);
                localObject2 = localObject3;
                i = j;
                if (localObject3 == null)
                {
                  localObject3 = QPlayAutoJNI.GetSongLists(localArrayList1, (String)localObject1, m, paramInt1);
                  localObject2 = localObject3;
                  i = j;
                  if (localObject3 == null)
                  {
                    i = 0;
                    localObject2 = localObject3;
                  }
                }
                localObject3 = ((HashMap)localObject2).get("error");
                j = i;
                if (localObject3 != null) {}
                try
                {
                  k = Integer.parseInt(localObject3.toString());
                  j = 0;
                  localObject2 = ((HashMap)localObject2).get("count");
                  if (localObject2 == null)
                  {
                    i = 0;
                    n = i;
                    i1 = k;
                    i2 = j;
                    if (j == 0) {
                      break label325;
                    }
                    a(localArrayList1, localArrayList2);
                    localArrayList1.clear();
                    m += 1;
                    break label67;
                    localObject1 = localObject2;
                    if (!paramString.equals("DEFAULT_POP")) {
                      continue;
                    }
                    q.b(q.this, false);
                    localObject1 = a((String)localObject2, 2130838995);
                  }
                }
                catch (NumberFormatException localNumberFormatException2)
                {
                  for (;;)
                  {
                    k = -65535;
                    continue;
                    try
                    {
                      i = Integer.parseInt(localObject2.toString());
                    }
                    catch (NumberFormatException localNumberFormatException1)
                    {
                      i = 0;
                    }
                  }
                }
              }
            }
          }
        }
        label325:
        if (i2 != 0)
        {
          if ("MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}" == localObject1) {
            q.Y = true;
          }
          if (paramBoolean) {
            if (q.this.X != null) {
              q.this.X.a((String)localObject1, n);
            }
          }
        }
        for (;;)
        {
          q.c(q.this, false);
          return;
          q.this.a(localArrayList2, (String)localObject1, m, n, i1);
          continue;
          if (!paramBoolean) {
            q.c(q.this).obtainMessage(65334, i1, 0, localObject1).sendToTarget();
          }
          if ("MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}" == localObject1) {
            q.Y = false;
          }
        }
      }
    }.start();
  }
  
  private void a(HashMap paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.size() < 1)) {}
    label342:
    do
    {
      return;
      float f;
      for (;;)
      {
        try
        {
          if (!paramHashMap.get("request").toString().equalsIgnoreCase("DeviceInfos")) {
            break label342;
          }
          QPlayAutoJNI.SendDeviceInfos("Baidu", "CarLife", "Android", "4.4", 614400);
          paramHashMap = QPlayAutoJNI.GetMobileDeviceInfos();
          f = Float.parseFloat(paramHashMap.get("ver").toString());
          if (paramHashMap.get("appver") != null)
          {
            this.ai = paramHashMap.get("appver").toString();
            if (this.aj > 0)
            {
              StatisticManager.onEventDuration(this.C, "MUSIC_QQ_0008", "QQ音乐版本号" + this.ai, this.aj);
              this.aj = -1;
            }
            if (Float.compare(f, 1.2F) < 0) {
              break;
            }
            com.baidu.carlife.core.i.c("CarLifeMusic", "version = " + f);
            this.ah = true;
            j(2);
            j();
            return;
          }
        }
        catch (Exception paramHashMap)
        {
          paramHashMap.printStackTrace();
          return;
        }
        this.ai = "unkown";
      }
      com.baidu.carlife.core.i.c("CarLifeMusic", "version = " + f);
      this.ah = false;
      this.ai = null;
      this.aj = -1;
      QPlayAutoJNI.stopConnect();
      com.baidu.carlife.core.i.e("CarLifeMusic", "QQ音乐协议版本过低!");
      StatisticManager.onEvent("MUSIC_QQ_0014", "版本不支持");
      d();
      j(0);
      e(null);
      this.I.clear();
      this.x.clear();
      this.am.clear();
      this.H.a(this.E);
      this.S.clear();
      paramHashMap = new Intent("com.baidu.carlife.Action.StartActivityBroadReceiver");
      BaseFragment.getNaviActivity().sendBroadcast(paramHashMap);
      return;
      if (paramHashMap.get("request").toString().equalsIgnoreCase("Disconnect"))
      {
        if (v() == 1)
        {
          u();
          a(0);
          this.ah = false;
          this.ai = null;
          this.aj = -1;
        }
        if (this.ah) {
          j(1);
        }
        e(null);
        this.I.clear();
        this.x.clear();
        this.am.clear();
        this.H.a(this.E);
        this.S.clear();
        return;
      }
      if (paramHashMap.get("request").toString().equalsIgnoreCase("DevicePlayStop"))
      {
        com.baidu.carlife.core.i.c("CarLifeMusic", "DevicePlay = DevicePlayStop");
        return;
      }
      if (paramHashMap.get("request").toString().equalsIgnoreCase("DevicePlayPre"))
      {
        com.baidu.carlife.core.i.c("CarLifeMusic", "DevicePlay = DevicePlayPre");
        return;
      }
      if (paramHashMap.get("request").toString().equalsIgnoreCase("DevicePlayNext"))
      {
        com.baidu.carlife.core.i.c("CarLifeMusic", "DevicePlay = DevicePlayNext");
        return;
      }
      if (paramHashMap.get("request").toString().equalsIgnoreCase("DevicePlayPlay"))
      {
        if ((!h.b().q()) && (h.b().n() == 1) && (!h.b().l()))
        {
          n.a(2);
          h.b().d(false);
        }
        com.baidu.carlife.core.i.c("CarLifeMusic", "DevicePlay = DevicePlayPlay");
        return;
      }
    } while (!paramHashMap.get("request").toString().equalsIgnoreCase("DevicePlayPause"));
    if ((!h.b().q()) && (h.b().n() == 1) && (p().m == null))
    {
      n.a(1);
      h.b().f(false);
    }
    com.baidu.carlife.core.i.c("CarLifeMusic", "DevicePlay = DevicePlayPause");
  }
  
  private void a(List<MusicSongModel> paramList, String paramString, int paramInt1, int paramInt2)
  {
    paramList = new Pair(paramString, paramList);
    k.a(218, s(), paramList);
    this.am.put(paramString, Integer.valueOf(paramInt1));
    if ((paramInt2 > 0) && (paramInt2 <= paramInt1 * 20))
    {
      com.baidu.carlife.core.i.b("CarLifeMusic", "QQMusic.onGetSongList() - ALL");
      j(paramString);
    }
  }
  
  private void a(boolean paramBoolean, com.baidu.carlife.model.i parami1, com.baidu.carlife.model.i parami2, com.baidu.carlife.model.i parami3)
  {
    if (paramBoolean)
    {
      new a(parami1, parami2, parami3, true).start();
      return;
    }
    new a(parami1, parami2, parami3, false).run();
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    int i;
    int j;
    if (f(paramString) == null)
    {
      i = 0;
      if (this.am.get(paramString) != null) {
        break label91;
      }
      j = 0;
      label27:
      if (!i(paramString)) {
        break label110;
      }
      if (!paramBoolean) {
        w.a(this.C.getString(2131296616), 1);
      }
      if (this.X != null) {
        this.X.a(paramString, i);
      }
      bool = true;
    }
    label91:
    label110:
    do
    {
      return bool;
      i = f(paramString).size();
      break;
      j = ((Integer)this.am.get(paramString)).intValue();
      break label27;
      if ((i == 0) && (!paramBoolean)) {
        c();
      }
    } while (TextUtils.isEmpty(paramString));
    a(paramString, 20, j, paramBoolean);
    return false;
  }
  
  private void c(boolean paramBoolean)
  {
    com.baidu.carlife.model.i locali1 = null;
    com.baidu.carlife.model.i locali3;
    com.baidu.carlife.model.i locali2;
    if (this.I.size() == 4)
    {
      locali3 = (com.baidu.carlife.model.i)this.I.get(1);
      if (locali3.d == 2130838996) {
        locali2 = (com.baidu.carlife.model.i)this.I.get(3);
      }
    }
    for (;;)
    {
      a(paramBoolean, locali3, locali2, locali1);
      return;
      locali3 = null;
      locali2 = (com.baidu.carlife.model.i)this.I.get(2);
      locali1 = (com.baidu.carlife.model.i)this.I.get(3);
      continue;
      com.baidu.carlife.model.i locali4 = a(this.C.getString(2131296634), "LOCAL_MUSIC", 2130838992);
      locali3 = a(this.C.getString(2131296638), "LAST_PLAYLIST", 2130838996);
      com.baidu.carlife.model.i locali5 = a(this.C.getString(2131296635), "MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}", 2130838993);
      locali2 = a(this.C.getString(2131296637), "DEFAULT_POP", 2130838995);
      locali1 = a(this.C.getString(2131296631), "DEFAULT_HOT", 2130838994);
      this.I.add(locali4);
      this.I.add(locali3);
      this.I.add(locali5);
      this.I.add(locali2);
      this.I.add(locali1);
    }
  }
  
  public static boolean k(String paramString)
  {
    File[] arrayOfFile = new File("/proc").listFiles();
    int j = 0;
    int m = arrayOfFile.length;
    int i = 0;
    if (i < m)
    {
      File localFile = arrayOfFile[i];
      int k;
      if (!localFile.isDirectory()) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        try
        {
          k = Integer.parseInt(localFile.getName());
        }
        catch (NumberFormatException localNumberFormatException)
        {
          try
          {
            boolean bool = o(String.format("/proc/%d/cmdline", new Object[] { Integer.valueOf(k) })).contains(paramString);
            k = j;
            if (!bool) {
              continue;
            }
            j += 1;
            k = j;
            if (j <= 1) {
              continue;
            }
            return true;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            k = j;
          }
          localNumberFormatException = localNumberFormatException;
          k = j;
        }
      }
    }
    return false;
  }
  
  private void l(String paramString)
  {
    if (!g(paramString))
    {
      h.b().f(true);
      e();
      a(w(), paramString);
    }
    while (paramString.equals(n())) {
      return;
    }
    e(paramString);
    f(0);
    b();
  }
  
  private void m(String paramString)
  {
    if ((!paramString.equals("MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}")) || (n() == null))
    {
      this.x.remove("MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}");
      this.am.remove("MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}");
      this.S.remove("MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}");
    }
  }
  
  private boolean n(String paramString)
  {
    try
    {
      paramString = this.C.getPackageManager().getPackageInfo(paramString, 0);
      if (paramString != null) {
        break label19;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      label19:
      do
      {
        paramString = paramString;
      } while (0 == 0);
      return true;
    }
    finally
    {
      do
      {
        paramString = finally;
      } while (0 == 0);
    }
    return false;
    return true;
    return true;
  }
  
  private static String o(String paramString)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramString));
    localStringBuilder.append(localBufferedReader.readLine());
    for (paramString = localBufferedReader.readLine(); paramString != null; paramString = localBufferedReader.readLine()) {
      localStringBuilder.append('\n').append(paramString);
    }
    localBufferedReader.close();
    return localStringBuilder.toString().trim();
  }
  
  private int z()
  {
    if (T.size() == 0)
    {
      b("LOCAL_MUSIC");
      k.b(249, s(), -101);
      return 1;
    }
    Pair localPair = new Pair("LOCAL_MUSIC", T);
    j("LOCAL_MUSIC");
    k.a(218, s(), localPair);
    return 1;
  }
  
  public int a(int paramInt, String paramString)
  {
    paramInt = 0;
    e(paramString);
    if ((paramString != null) && (paramString.equals("LOCAL_MUSIC"))) {
      paramInt = z();
    }
    do
    {
      return paramInt;
      if (!e.a().r()) {
        break;
      }
    } while (!a(paramString, false));
    return 1;
    i(3);
    return 0;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      String str;
      do
      {
        do
        {
          return;
          paramBundle = paramBundle.getBundle("show_bundle");
          if (paramBundle != null) {
            break;
          }
        } while (R);
        R = true;
        b();
        return;
        if (!paramBundle.containsKey("album_id")) {
          break;
        }
        str = paramBundle.getString("album_id");
      } while (str == null);
      m(str);
      l(str);
      paramBundle.remove("album_id");
      return;
      if (paramBundle.getBoolean("music_type_changed", false))
      {
        b();
        paramBundle.remove("music_type_changed");
        return;
      }
    } while (!paramBundle.getBoolean("music_playing_icon", false));
    b(n());
    paramBundle.remove("music_playing_icon");
  }
  
  public void a(b.b paramb)
  {
    this.X = paramb;
    this.X.a("LOCAL_MUSIC", T.size());
    a("MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}", true);
    a("LAST_PLAYLIST", true);
  }
  
  public void a(List<MusicSongModel> paramList, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      a(paramList, paramString, paramInt1, paramInt2);
    }
    do
    {
      return;
      paramList = f(paramString);
    } while ((paramList != null) && (!paramList.isEmpty()));
    a(paramString, paramInt3);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((x() == 1) || (x() == 7)) {
      if (paramBoolean)
      {
        StatisticManager.onEvent("MUSIC_QQ_0007");
        A();
      }
    }
    do
    {
      return;
      this.al = System.currentTimeMillis();
      StatisticManager.onEvent("MUSIC_QQ_0016");
      break;
      if (x() == 0)
      {
        if (paramBoolean) {
          StatisticManager.onEvent("MUSIC_QQ_0006");
        }
        B();
        return;
      }
    } while (x() != 3);
    if (v() == 0)
    {
      a(false);
      j();
      return;
    }
    b();
  }
  
  public Bitmap d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return e.a(paramString);
  }
  
  public void d(int paramInt)
  {
    if (e(w()))
    {
      if (this.H != null) {
        this.H.a(paramInt);
      }
      return;
    }
    c();
    c(true);
  }
  
  public boolean e(int paramInt)
  {
    if (paramInt == 2) {
      if (this.J != null) {}
    }
    while ((paramInt != 1) || (this.I == null) || (this.I.isEmpty()))
    {
      do
      {
        return false;
      } while (this.J.isEmpty());
      return true;
    }
    return true;
  }
  
  public List<MusicSongModel> g()
  {
    return f(n());
  }
  
  @Deprecated
  public void h() {}
  
  public boolean i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.S.contains(paramString)) {
      return false;
    }
    return true;
  }
  
  public void j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.S.add(paramString);
  }
  
  public void y()
  {
    c.a().c(q());
    e(null);
    this.I.clear();
    this.x.clear();
    k.b(this.an);
    this.an = null;
    super.y();
  }
  
  private class a
    extends Thread
  {
    int a = -1;
    boolean b = false;
    com.baidu.carlife.model.i c;
    com.baidu.carlife.model.i d;
    com.baidu.carlife.model.i e;
    
    public a(com.baidu.carlife.model.i parami1, com.baidu.carlife.model.i parami2, com.baidu.carlife.model.i parami3, boolean paramBoolean)
    {
      this.c = parami1;
      this.d = parami2;
      this.e = parami3;
      this.b = paramBoolean;
    }
    
    private boolean a(ArrayList paramArrayList, String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      HashMap localHashMap = QPlayAutoJNI.GetSongLists(paramArrayList, paramString1, paramInt1, paramInt2);
      Object localObject = localHashMap;
      if (localHashMap == null)
      {
        paramString1 = QPlayAutoJNI.GetSongLists(paramArrayList, paramString1, paramInt1, paramInt2);
        localObject = paramString1;
        if (paramString1 != null) {}
      }
      while (((HashMap)localObject).get("error") != null) {
        return false;
      }
      for (this.a = 0;; this.a += 1) {
        if (this.a < paramArrayList.size())
        {
          if ((paramArrayList.get(this.a) instanceof HashMap))
          {
            paramString1 = (HashMap)paramArrayList.get(this.a);
            if ((!paramString1.containsKey("name")) || (!paramString1.get("name").toString().contains(paramString2))) {}
          }
        }
        else
        {
          if (this.a >= paramArrayList.size()) {
            break;
          }
          return true;
        }
      }
    }
    
    public void run()
    {
      ArrayList localArrayList = new ArrayList();
      String str;
      if (this.c != null)
      {
        if (a(localArrayList, "-1", 0, 20, "最近播放"))
        {
          localArrayList.clear();
          q.this.I.remove(this.e);
        }
      }
      else
      {
        this.a = -1;
        str = "RANK";
        if (!a(localArrayList, "RANK", 0, 20, "流行")) {
          break label284;
        }
        if (this.a < localArrayList.size()) {
          str = ((HashMap)localArrayList.get(this.a)).get("id").toString().replace("\"", "\\\"");
        }
        localArrayList.clear();
        label116:
        this.d.c = str;
        this.a = -1;
        if ((this.c == null) && (this.e != null))
        {
          str = "RANK";
          if (!a(localArrayList, "RANK", 0, 20, "热歌")) {
            break label294;
          }
          if (this.a < localArrayList.size()) {
            str = ((HashMap)localArrayList.get(this.a)).get("id").toString().replace("\"", "\\\"");
          }
          localArrayList.clear();
        }
      }
      for (;;)
      {
        this.e.c = str;
        this.a = -1;
        if (this.b) {
          k.b(206, 1, q.this.s());
        }
        return;
        if (this.e == null)
        {
          this.d.c = "DEFAULT_POP";
          return;
        }
        localArrayList.clear();
        q.this.I.remove(this.c);
        this.c = null;
        break;
        label284:
        str = "DEFAULT_POP";
        localArrayList.clear();
        break label116;
        label294:
        str = "DEFAULT_HOT";
        localArrayList.clear();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */