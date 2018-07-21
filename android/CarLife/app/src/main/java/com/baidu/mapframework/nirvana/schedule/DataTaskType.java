package com.baidu.mapframework.nirvana.schedule;

public class DataTaskType
  implements TaskType
{
  private final Purpose a;
  
  private DataTaskType(Purpose paramPurpose)
  {
    this.a = paramPurpose;
  }
  
  public static DataTaskType forDownload()
  {
    return new DataTaskType(Purpose.DOWNLOAD);
  }
  
  public static DataTaskType forStatictics()
  {
    return new DataTaskType(Purpose.STATISTICS);
  }
  
  public static DataTaskType forUpdateData()
  {
    return new DataTaskType(Purpose.UPDATE_DATA);
  }
  
  public String toString()
  {
    return "DataTaskType{purpose=" + this.a + '}';
  }
  
  private static enum Purpose
  {
    private Purpose() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/schedule/DataTaskType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */