package com.facebook.common.m;

public enum f
{
  private f() {}
  
  public static f a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return c;
    case 1: 
      return a;
    }
    return b;
  }
  
  public static f a(Boolean paramBoolean)
  {
    if (paramBoolean != null) {
      return a(paramBoolean.booleanValue());
    }
    return c;
  }
  
  public static f a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a;
    }
    return b;
  }
  
  public boolean a()
  {
    return this != c;
  }
  
  public boolean b()
  {
    switch (1.a[ordinal()])
    {
    default: 
      throw new IllegalStateException("Unrecognized TriState value: " + this);
    case 1: 
      return true;
    case 2: 
      return false;
    }
    throw new IllegalStateException("No boolean equivalent for UNSET");
  }
  
  public boolean b(boolean paramBoolean)
  {
    switch (1.a[ordinal()])
    {
    default: 
      throw new IllegalStateException("Unrecognized TriState value: " + this);
    case 1: 
      paramBoolean = true;
    case 3: 
      return paramBoolean;
    }
    return false;
  }
  
  public Boolean c()
  {
    switch (1.a[ordinal()])
    {
    default: 
      throw new IllegalStateException("Unrecognized TriState value: " + this);
    case 1: 
      return Boolean.TRUE;
    case 2: 
      return Boolean.FALSE;
    }
    return null;
  }
  
  public int d()
  {
    switch (1.a[ordinal()])
    {
    default: 
      return 3;
    case 1: 
      return 1;
    }
    return 2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/m/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */