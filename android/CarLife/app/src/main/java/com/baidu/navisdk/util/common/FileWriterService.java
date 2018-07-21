package com.baidu.navisdk.util.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterService
{
  private static BufferedWriter fileWriter;
  private static FileWriterService instance;
  
  private FileWriterService(String paramString) {}
  
  public static FileWriterService getInstance(String paramString)
  {
    if (instance == null) {
      instance = new FileWriterService(paramString);
    }
    return instance;
  }
  
  private void initFile(String paramString)
  {
    paramString = new File(SysOSAPI.getInstance().GetSDCardPath(), paramString);
    try
    {
      fileWriter = new BufferedWriter(new FileWriter(paramString, true));
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void uninit()
  {
    try
    {
      if (fileWriter != null)
      {
        fileWriter.flush();
        fileWriter.close();
        fileWriter = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void writeline(String paramString)
  {
    if (fileWriter == null) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/FileWriterService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */