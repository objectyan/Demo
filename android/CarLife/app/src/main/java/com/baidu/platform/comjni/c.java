package com.baidu.platform.comjni;

public abstract class c
  extends a
{
  protected long mNativePointer;
  
  public abstract long create();
  
  public abstract int dispose();
  
  protected void finalize()
    throws Throwable
  {
    dispose();
    super.finalize();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/platform/comjni/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */