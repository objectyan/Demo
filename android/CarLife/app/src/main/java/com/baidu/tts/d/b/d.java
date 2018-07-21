package com.baidu.tts.d.b;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.f.g;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class d
{
  private String a;
  private String b;
  private String c;
  private long d = 0L;
  private a e = a.a();
  private CopyOnWriteArraySet<DownloadHandler> f = new CopyOnWriteArraySet();
  
  public d(String paramString)
  {
    this.a = paramString;
  }
  
  private void j()
  {
    this.e.a(this.b, this.a);
    this.e.a(this.c, this.a);
  }
  
  public void a()
  {
    this.f.clear();
    j();
  }
  
  public void a(DownloadHandler paramDownloadHandler)
  {
    if (this.f != null) {
      this.f.add(paramDownloadHandler);
    }
  }
  
  public void a(DownloadHandler paramDownloadHandler, TtsError paramTtsError)
  {
    paramDownloadHandler.updateFinish(this, paramTtsError);
    b(paramDownloadHandler);
  }
  
  public void a(ModelBags paramModelBags, com.baidu.tts.database.a parama)
  {
    parama.a(paramModelBags);
    a(parama);
  }
  
  public void a(b paramb)
  {
    if (this.f != null)
    {
      paramb = this.f.iterator();
      while (paramb.hasNext()) {
        ((DownloadHandler)paramb.next()).updateProgress(this);
      }
    }
  }
  
  public void a(b paramb, TtsError paramTtsError)
  {
    LoggerProxy.d("ModelFlyweight", "onFileDownloadFailure");
    if (this.f != null)
    {
      paramb = this.f.iterator();
      while (paramb.hasNext()) {
        a((DownloadHandler)paramb.next(), paramTtsError);
      }
    }
  }
  
  public boolean a(com.baidu.tts.database.a parama)
  {
    Map localMap = parama.e(this.a);
    if ((localMap == null) || (localMap.isEmpty())) {
      return false;
    }
    this.b = DataTool.getMapValue(localMap, g.r.b());
    this.c = DataTool.getMapValue(localMap, g.s.b());
    boolean bool1 = StringTool.isEmpty(this.b);
    boolean bool2 = StringTool.isEmpty(this.c);
    if ((!bool1) && (!bool2)) {
      return true;
    }
    parama.a(this.a);
    return false;
  }
  
  public Set<String> b()
  {
    HashSet localHashSet = new HashSet();
    Object localObject2 = e.a();
    Object localObject1 = ((e)localObject2).b(this.b);
    localObject2 = ((e)localObject2).b(this.c);
    localObject1 = ((c)localObject1).a();
    localObject2 = ((c)localObject2).a();
    localHashSet.add(localObject1);
    localHashSet.add(localObject2);
    return localHashSet;
  }
  
  public void b(DownloadHandler paramDownloadHandler)
  {
    boolean bool = DataTool.isSetEmpty(this.f);
    LoggerProxy.d("ModelFlyweight", "unregisterListener 1isEmpty=" + bool);
    if (!bool)
    {
      this.f.remove(paramDownloadHandler);
      bool = DataTool.isSetEmpty(this.f);
      LoggerProxy.d("ModelFlyweight", "unregisterListener 2isEmpty=" + bool);
      if (!bool) {
        break label86;
      }
      j();
    }
    for (;;)
    {
      return;
      label86:
      paramDownloadHandler = this.f.iterator();
      while (paramDownloadHandler.hasNext())
      {
        DownloadHandler localDownloadHandler = (DownloadHandler)paramDownloadHandler.next();
        LoggerProxy.d("ModelFlyweight", "unregisterListener item=" + localDownloadHandler);
      }
    }
  }
  
  public void b(b paramb)
  {
    boolean bool = i();
    LoggerProxy.d("ModelFlyweight", "onFileDownloadSuccess isAllFileDownloadSuccess=" + bool);
    if ((bool) && (this.f != null))
    {
      paramb = this.f.iterator();
      while (paramb.hasNext()) {
        a((DownloadHandler)paramb.next(), null);
      }
    }
  }
  
  public long c()
  {
    d();
    return this.d;
  }
  
  public void c(DownloadHandler paramDownloadHandler)
  {
    a(paramDownloadHandler);
    paramDownloadHandler.updateStart(this);
  }
  
  public void d()
  {
    if (this.d == 0L) {
      e();
    }
  }
  
  public void e()
  {
    Object localObject = e.a();
    String str = ((e)localObject).b(this.b).b();
    localObject = ((e)localObject).b(this.c).b();
    long l2 = Long.parseLong(str);
    long l1 = Long.parseLong((String)localObject);
    l2 = Long.valueOf(l2).longValue();
    this.d = (Long.valueOf(l1).longValue() + l2);
  }
  
  public Set<String> f()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.b);
    localHashSet.add(this.c);
    return localHashSet;
  }
  
  public String g()
  {
    return this.a;
  }
  
  public long h()
  {
    return this.e.d(this.b) + this.e.d(this.c);
  }
  
  public boolean i()
  {
    int i = this.e.e(this.b);
    int j = this.e.e(this.c);
    return (i == 7) && (j == 7);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/d/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */