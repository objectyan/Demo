package com.baidu.tts.client;

import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.tools.ResourceTools;
import com.baidu.tts.tools.StringTool;
import java.io.File;

public class SynthesizerTool
{
  public static String getEngineInfo()
  {
    return EmbeddedSynthesizerEngine.bdTTSGetEngineParam();
  }
  
  public static int getEngineVersion()
  {
    return EmbeddedSynthesizerEngine.getEngineMinVersion();
  }
  
  public static String getModelInfo(String paramString)
  {
    if (!StringTool.isEmpty(paramString))
    {
      File localFile = new File(paramString);
      if ((localFile.exists()) && (localFile.canRead())) {
        return EmbeddedSynthesizerEngine.bdTTSGetDatParam(paramString);
      }
    }
    return null;
  }
  
  public static boolean verifyModelFile(String paramString)
  {
    if (StringTool.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      paramString = ResourceTools.stringToByteArrayAddNull(paramString);
      try
      {
        int i = EmbeddedSynthesizerEngine.bdTTSVerifyDataFile(paramString);
        if (i >= 0) {
          return true;
        }
      }
      catch (Exception paramString) {}
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/SynthesizerTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */