package com.baidu.tts.database;

import com.baidu.tts.tools.SqlTool;

public class FsFileInfoTable
{
  public static String a()
  {
    return SqlTool.sqlCreateTable("fsFileInfo", Field.values());
  }
  
  public static String b()
  {
    return SqlTool.sqlDropTable("fsFileInfo");
  }
  
  public static enum Field
  {
    private final String c;
    private final String d;
    
    private Field(String paramString1, String paramString2)
    {
      this.c = paramString1;
      this.d = paramString2;
    }
    
    public String getColumnName()
    {
      return this.c;
    }
    
    public String getDataType()
    {
      return this.d;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/database/FsFileInfoTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */