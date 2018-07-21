package com.baidu.carlife.custom.elhyf.c;

import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType;
import java.io.File;

public class a
{
  private int a;
  private CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType b;
  private String c;
  private int d;
  private File e;
  
  public a(int paramInt1, CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType paramDataType, String paramString, int paramInt2, File paramFile)
  {
    this.a = paramInt1;
    this.b = paramDataType;
    this.c = paramString;
    this.d = paramInt2;
    this.e = paramFile;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType paramDataType)
  {
    this.b = paramDataType;
  }
  
  public void a(File paramFile)
  {
    this.e = paramFile;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public File e()
  {
    return this.e;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/custom/elhyf/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */