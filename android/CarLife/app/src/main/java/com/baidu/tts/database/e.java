package com.baidu.tts.database;

import com.baidu.tts.tools.SqlTool;

public class e
{
  public static String a()
  {
    return "CREATE TABLE StatisticsInfo(id INTEGER PRIMARY KEY AUTOINCREMENT,uuid varchar(256),startInfo varchar(256),endInfo varchar(256))";
  }
  
  public static String b()
  {
    return SqlTool.sqlDropTable("StatisticsInfo");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/database/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */