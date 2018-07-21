package com.baidu.speech.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class BDSMessage
{
  public long m_dataOffset;
  public byte[] m_messageData;
  public String m_messageName;
  public HashMap<String, BDSParamBase> m_messageParams;
  
  public String toString()
  {
    String str1 = this.m_messageName;
    Object localObject = this.m_messageParams.entrySet();
    str1 = str1 + " messageParamsCount=" + this.m_messageParams.size() + " messageParams:{  ";
    localObject = ((Set)localObject).iterator();
    Map.Entry localEntry;
    String str2;
    if (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      str2 = (String)localEntry.getKey();
      if (str2.endsWith("int")) {
        str1 = str1 + " (" + (String)localEntry.getKey() + " , " + ((BDSParamBase.BDSIntParam)localEntry.getValue()).iValue + ") ";
      }
    }
    for (;;)
    {
      break;
      if (str2.endsWith("string"))
      {
        str1 = str1 + " (" + (String)localEntry.getKey() + " , " + ((BDSParamBase.BDSObjectParam)localEntry.getValue()).iValue + ") ";
      }
      else if (str2.endsWith("float"))
      {
        str1 = str1 + " (" + (String)localEntry.getKey() + " , " + ((BDSParamBase.BDSFloatParam)localEntry.getValue()).iValue + ") ";
      }
      else if (str2.endsWith("bool"))
      {
        str1 = str1 + " (" + (String)localEntry.getKey() + " , " + ((BDSParamBase.BDSBooleanParam)localEntry.getValue()).iValue + ") ";
        continue;
        return str1 + "  } ";
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/core/BDSMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */