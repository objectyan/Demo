package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class e
{
  private static final String a = "AudioFilePipeLine";
  private static final int c = 10;
  private LinkedBlockingQueue<String> b = new LinkedBlockingQueue(10);
  
  public static e a()
  {
    return a.a;
  }
  
  private void e()
  {
    Object localObject = new ArrayList();
    this.b.drainTo((Collection)localObject);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      File localFile = new File((String)((Iterator)localObject).next());
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.b.put(paramString);
      return;
    }
    catch (InterruptedException paramString)
    {
      paramString.printStackTrace();
      i.e("AudioFilePipeLine", "InterruptedException in put, message is " + paramString.getMessage());
      return;
    }
    catch (NullPointerException paramString)
    {
      paramString.printStackTrace();
      i.e("AudioFilePipeLine", "NullPointerException in put, message is " + paramString.getMessage());
    }
  }
  
  public void a(List<String> paramList)
  {
    this.b.drainTo(paramList);
  }
  
  public void b()
  {
    e();
    this.b.clear();
  }
  
  public String c()
  {
    try
    {
      String str = (String)this.b.take();
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      i.e("AudioFilePipeLine", "InterruptedException in take, message is " + localInterruptedException.getMessage());
    }
    return "";
  }
  
  public int d()
  {
    return this.b.size();
  }
  
  private static class a
  {
    static final e a = new e(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */