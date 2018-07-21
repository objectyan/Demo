package com.baidu.navi.protocol.model;

public class VoiceRecogniseDataStruct
  extends DataStruct
{
  public static final String KEY_FILE_PATH = "filePath";
  public static final String KEY_LIST = "list";
  public static final String KEY_TYPE = "type";
  public static final int TYPE_COMPANY = 2;
  public static final int TYPE_HOME = 1;
  public static final int TYPE_OTHERS = 3;
  public String filePath;
  
  public VoiceRecogniseDataStruct()
  {
    this.mCmd = "voiceRecognise";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/VoiceRecogniseDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */