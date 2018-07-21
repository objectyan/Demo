package com.baidu.tts.n;

public abstract class a<T>
  implements b<T>
{
  public T B()
  {
    try
    {
      Object localObject = super.clone();
      return (T)localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/n/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */