package com.baidu.carlife.model;

import com.baidu.carlife.platform.model.CLAlbum;

public class i
{
  public String a = null;
  public String b = null;
  public String c = null;
  public int d = -1;
  
  public i() {}
  
  public i(CLAlbum paramCLAlbum)
  {
    this.c = paramCLAlbum.albumId;
    this.b = paramCLAlbum.coverUrl;
    this.a = paramCLAlbum.albumName;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/model/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */