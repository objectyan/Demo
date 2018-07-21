package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelInfo;
import com.baidu.tts.tools.SqlTool;
import java.util.Iterator;
import java.util.List;

public class SpeechModelTable
{
  public static int a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    return paramSQLiteDatabase.delete("speechModel", "id=?", new String[] { paramString });
  }
  
  public static String a()
  {
    return SqlTool.sqlCreateTable("speechModel", Field.values());
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, ModelBags paramModelBags)
  {
    new f(paramSQLiteDatabase, new f.a()
    {
      public boolean a(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        try
        {
          paramAnonymousSQLiteDatabase = paramAnonymousSQLiteDatabase.compileStatement("insert into speechModel (name, version_min, version_max, language, gender, speaker, domain, quality, text_data_id, speech_data_id, id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
          Iterator localIterator = this.a.getModelInfos().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (ModelInfo)localIterator.next();
            String str1 = ((ModelInfo)localObject).getName();
            String str2 = ((ModelInfo)localObject).getVersionMin();
            String str3 = ((ModelInfo)localObject).getVersionMax();
            String str4 = ((ModelInfo)localObject).getLanguage();
            String str5 = ((ModelInfo)localObject).getGender();
            String str6 = ((ModelInfo)localObject).getSpeaker();
            String str7 = ((ModelInfo)localObject).getDomain();
            String str8 = ((ModelInfo)localObject).getQuality();
            String str9 = ((ModelInfo)localObject).getTextDataId();
            String str10 = ((ModelInfo)localObject).getSpeechDataId();
            localObject = ((ModelInfo)localObject).getServerId();
            paramAnonymousSQLiteDatabase.bindString(1, str1);
            paramAnonymousSQLiteDatabase.bindString(2, str2);
            paramAnonymousSQLiteDatabase.bindString(3, str3);
            paramAnonymousSQLiteDatabase.bindString(4, str4);
            paramAnonymousSQLiteDatabase.bindString(5, str5);
            paramAnonymousSQLiteDatabase.bindString(6, str6);
            paramAnonymousSQLiteDatabase.bindString(7, str7);
            paramAnonymousSQLiteDatabase.bindString(8, str8);
            paramAnonymousSQLiteDatabase.bindString(9, str9);
            paramAnonymousSQLiteDatabase.bindString(10, str10);
            paramAnonymousSQLiteDatabase.bindString(11, (String)localObject);
            paramAnonymousSQLiteDatabase.executeInsert();
          }
          return true;
        }
        catch (Exception paramAnonymousSQLiteDatabase)
        {
          return false;
        }
      }
    }).a();
  }
  
  public static String b()
  {
    return SqlTool.sqlDropTable("speechModel");
  }
  
  public static enum Field
  {
    private final String l;
    private final String m;
    
    private Field(String paramString1, String paramString2)
    {
      this.l = paramString1;
      this.m = paramString2;
    }
    
    public String getColumnName()
    {
      return this.l;
    }
    
    public String getDataType()
    {
      return this.m;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/database/SpeechModelTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */