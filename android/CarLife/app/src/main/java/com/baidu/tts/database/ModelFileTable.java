package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.client.model.ModelFileInfo;
import com.baidu.tts.tools.SqlTool;
import java.util.Iterator;
import java.util.List;

public class ModelFileTable
{
  public static int a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    return paramSQLiteDatabase.delete("modelFile", "id=?", new String[] { paramString });
  }
  
  public static String a()
  {
    return SqlTool.sqlCreateTable("modelFile", Field.values());
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, ModelFileBags paramModelFileBags)
  {
    new f(paramSQLiteDatabase, new f.a()
    {
      public boolean a(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        try
        {
          paramAnonymousSQLiteDatabase = paramAnonymousSQLiteDatabase.compileStatement("insert into modelFile (id, length, md5, name, absPath) values (?, ?, ?, ?, ?)");
          Iterator localIterator = this.a.getModelFileInfos().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (ModelFileInfo)localIterator.next();
            String str1 = ((ModelFileInfo)localObject).getServerid();
            String str2 = ((ModelFileInfo)localObject).getLength();
            String str3 = ((ModelFileInfo)localObject).getMd5();
            String str4 = ((ModelFileInfo)localObject).getName();
            localObject = ((ModelFileInfo)localObject).getAbsPath();
            paramAnonymousSQLiteDatabase.bindString(1, str1);
            paramAnonymousSQLiteDatabase.bindString(2, str2);
            paramAnonymousSQLiteDatabase.bindString(3, str3);
            paramAnonymousSQLiteDatabase.bindString(4, str4);
            paramAnonymousSQLiteDatabase.bindString(5, (String)localObject);
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
    return SqlTool.sqlDropTable("modelFile");
  }
  
  public static enum Field
  {
    private final String f;
    private final String g;
    
    private Field(String paramString1, String paramString2)
    {
      this.f = paramString1;
      this.g = paramString2;
    }
    
    public String getColumnName()
    {
      return this.f;
    }
    
    public String getDataType()
    {
      return this.g;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/database/ModelFileTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */