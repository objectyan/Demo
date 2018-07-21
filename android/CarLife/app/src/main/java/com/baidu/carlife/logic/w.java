package com.baidu.carlife.logic;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.net.HttpURLConnection;

public abstract interface w
{
  public abstract int a(String paramString, HttpURLConnection paramHttpURLConnection)
    throws IOException;
  
  public abstract String a(String paramString1, String paramString2);
  
  @NonNull
  public abstract HttpURLConnection a(String paramString)
    throws IOException;
  
  public abstract boolean b(HttpURLConnection paramHttpURLConnection)
    throws IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */