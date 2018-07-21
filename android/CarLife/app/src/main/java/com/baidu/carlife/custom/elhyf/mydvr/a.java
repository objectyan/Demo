package com.baidu.carlife.custom.elhyf.mydvr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType;
import com.baidu.carlife.util.w;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  public static String a = a.class.getSimpleName();
  private static final int b = 0;
  private static final int c = 1;
  private static a j;
  private ArrayList<b> d = new ArrayList();
  private ArrayList<b> e = new ArrayList();
  private ArrayList<a> f = new ArrayList();
  private Context g;
  private Thread h;
  private Handler i = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 0: 
        a.a(a.this, (ArrayList)paramAnonymousMessage.obj);
        a.a(a.this);
        return;
      }
      a.b(a.this, (ArrayList)paramAnonymousMessage.obj);
      a.b(a.this);
    }
  };
  private com.baidu.carlife.custom.elhyf.c.b.a k = new com.baidu.carlife.custom.elhyf.c.b.a()
  {
    public void a(com.baidu.carlife.custom.elhyf.c.a paramAnonymousa) {}
    
    public void a(com.baidu.carlife.custom.elhyf.c.a paramAnonymousa, int paramAnonymousInt) {}
    
    public void b(com.baidu.carlife.custom.elhyf.c.a paramAnonymousa)
    {
      if (!a.a(a.this, paramAnonymousa.c())) {}
      b localb;
      do
      {
        return;
        localb = new b();
        localb.a(paramAnonymousa.c());
        localb.b(a.b(a.this, paramAnonymousa.c()));
        localb.e(a.c(a.this, paramAnonymousa.c()));
        localb.c(a.a(a.this, paramAnonymousa.e().length()));
        localb.d(paramAnonymousa.e().getPath());
        localb.a(a.d(a.this, paramAnonymousa.c()));
        if (paramAnonymousa.b() == CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType.Video)
        {
          a.a(a.this, localb);
          a.c(a.this).add(localb);
          Collections.sort(a.c(a.this));
          a.a(a.this);
          return;
        }
      } while (paramAnonymousa.b() != CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType.Photo);
      a.b(a.this, localb);
      a.e(a.this).add(localb);
      Collections.sort(a.e(a.this));
      a.b(a.this);
    }
    
    public void c(com.baidu.carlife.custom.elhyf.c.a paramAnonymousa) {}
  };
  
  public static a a()
  {
    if (j == null) {
      j = new a();
    }
    return j;
  }
  
  private String a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    return new DecimalFormat("0.0").format((float)l / 1024.0F / 1024.0F);
  }
  
  private String a(String paramString)
  {
    Object localObject2 = "";
    try
    {
      if (paramString.length() >= 4) {
        localObject2 = paramString.substring(0, 4) + "/";
      }
      Object localObject1 = localObject2;
      if (paramString.length() >= 6) {
        localObject1 = (String)localObject2 + paramString.substring(4, 6) + "/";
      }
      localObject2 = localObject1;
      if (paramString.length() >= 8) {
        localObject2 = (String)localObject1 + paramString.substring(4, 8);
      }
      return (String)localObject2;
    }
    catch (Exception paramString) {}
    return "unknown";
  }
  
  private String b(String paramString)
  {
    Object localObject2 = "";
    try
    {
      if (paramString.length() >= 11) {
        localObject2 = paramString.substring(9, 11) + ":";
      }
      Object localObject1 = localObject2;
      if (paramString.length() >= 13) {
        localObject1 = (String)localObject2 + paramString.substring(11, 13) + ":";
      }
      localObject2 = localObject1;
      if (paramString.length() >= 15) {
        localObject2 = (String)localObject1 + paramString.substring(11, 15);
      }
      return (String)localObject2;
    }
    catch (Exception paramString) {}
    return "unknown";
  }
  
  private b.a c(String paramString)
  {
    try
    {
      if (paramString.charAt(15) == 'B') {
        return b.a.b;
      }
      paramString = b.a.a;
      return paramString;
    }
    catch (Exception paramString) {}
    return b.a.a;
  }
  
  private void c(b paramb)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.b().equals(paramb.b())) {
        this.d.remove(localb);
      }
    }
  }
  
  private void d()
  {
    this.h = new Thread(new Runnable()
    {
      public void run()
      {
        int j = 0;
        Object localObject1 = new File(com.baidu.carlife.custom.elhyf.c.b.d);
        if (!a.c(a.this).isEmpty()) {
          a.c(a.this).clear();
        }
        int k;
        int i;
        Object localObject2;
        b localb;
        if (((File)localObject1).listFiles().length > 0)
        {
          localObject1 = ((File)localObject1).listFiles();
          k = localObject1.length;
          i = 0;
          if (i < k)
          {
            localObject2 = localObject1[i];
            if (!a.a(a.this, ((File)localObject2).getName())) {}
            for (;;)
            {
              i += 1;
              break;
              localb = new b();
              localb.a(((File)localObject2).getName());
              localb.b(a.b(a.this, ((File)localObject2).getName()));
              localb.e(a.c(a.this, ((File)localObject2).getName()));
              localb.c(a.a(a.this, ((File)localObject2).length()));
              localb.d(((File)localObject2).getPath());
              localb.a(a.d(a.this, ((File)localObject2).getName()));
              a.c(a.this).add(localb);
            }
          }
          Collections.sort(a.c(a.this));
          localObject1 = new Message();
          ((Message)localObject1).what = 0;
          ((Message)localObject1).obj = a.c(a.this);
          a.d(a.this).sendMessage((Message)localObject1);
        }
        localObject1 = new File(com.baidu.carlife.custom.elhyf.c.b.c);
        if (!a.e(a.this).isEmpty()) {
          a.e(a.this).clear();
        }
        if (((File)localObject1).listFiles().length > 0)
        {
          localObject1 = ((File)localObject1).listFiles();
          k = localObject1.length;
          i = j;
          if (i < k)
          {
            localObject2 = localObject1[i];
            if (!a.a(a.this, ((File)localObject2).getName())) {}
            for (;;)
            {
              i += 1;
              break;
              localb = new b();
              localb.a(((File)localObject2).getName());
              localb.b(a.b(a.this, ((File)localObject2).getName()));
              localb.e(a.c(a.this, ((File)localObject2).getName()));
              localb.c(a.a(a.this, ((File)localObject2).length()));
              localb.d(((File)localObject2).getPath());
              localb.a(a.d(a.this, ((File)localObject2).getName()));
              a.e(a.this).add(localb);
            }
          }
          Collections.sort(a.e(a.this));
          localObject1 = new Message();
          ((Message)localObject1).what = 1;
          ((Message)localObject1).obj = a.e(a.this);
          a.d(a.this).sendMessage((Message)localObject1);
        }
      }
    });
    this.h.start();
  }
  
  private void d(b paramb)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.b().equals(paramb.b())) {
        this.e.remove(localb);
      }
    }
  }
  
  private boolean d(String paramString)
  {
    return Pattern.compile("[0-9]{8}_[0-9]{6}(A|B)(.jpg|.mpg)").matcher(paramString).matches();
  }
  
  private void e()
  {
    ArrayList localArrayList = new ArrayList(this.f);
    int m = 0;
    while (m < localArrayList.size())
    {
      ((a)localArrayList.get(m)).a(b());
      m += 1;
    }
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList(this.f);
    int m = 0;
    while (m < localArrayList.size())
    {
      ((a)localArrayList.get(m)).b(c());
      m += 1;
    }
  }
  
  public void a(Context paramContext)
  {
    this.g = paramContext;
    d();
    com.baidu.carlife.custom.elhyf.c.b.a().a(this.k);
  }
  
  public void a(Context paramContext, String paramString)
  {
    try
    {
      paramString = new File(paramString);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.fromFile(paramString), "image/*");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      w.a(paramContext.getString(2131298850), 1);
    }
  }
  
  public void a(a parama)
  {
    if (!this.f.contains(parama)) {
      this.f.add(parama);
    }
  }
  
  public void a(b paramb)
  {
    File localFile = new File(paramb.e());
    if (localFile.exists())
    {
      localFile.delete();
      this.d.remove(paramb);
      e();
    }
  }
  
  public ArrayList<b> b()
  {
    return this.d;
  }
  
  public void b(Context paramContext, String paramString)
  {
    try
    {
      paramString = new File(paramString);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.fromFile(paramString), "video/*");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      w.a(paramContext.getString(2131298848), 1);
    }
  }
  
  public void b(a parama)
  {
    this.f.remove(parama);
  }
  
  public void b(b paramb)
  {
    File localFile = new File(paramb.e());
    if (localFile.exists())
    {
      localFile.delete();
      this.e.remove(paramb);
      f();
    }
  }
  
  public ArrayList<b> c()
  {
    return this.e;
  }
  
  public static abstract interface a
  {
    public abstract void a(ArrayList<b> paramArrayList);
    
    public abstract void b(ArrayList<b> paramArrayList);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/custom/elhyf/mydvr/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */