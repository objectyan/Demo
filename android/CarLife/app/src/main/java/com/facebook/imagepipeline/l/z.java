package com.facebook.imagepipeline.l;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.i.d;
import com.facebook.imagepipeline.m.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

public class z
  extends y
{
  @VisibleForTesting
  static final String a = "LocalFileFetchProducer";
  
  public z(Executor paramExecutor, com.facebook.imagepipeline.memory.z paramz, boolean paramBoolean)
  {
    super(paramExecutor, paramz, paramBoolean);
  }
  
  protected d a(c paramc)
    throws IOException
  {
    return b(new FileInputStream(paramc.m().toString()), (int)paramc.m().length());
  }
  
  protected String a()
  {
    return "LocalFileFetchProducer";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */