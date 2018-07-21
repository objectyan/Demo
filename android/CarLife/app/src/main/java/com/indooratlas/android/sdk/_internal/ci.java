package com.indooratlas.android.sdk._internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;
import java.util.UUID;

public final class ci
{
  public static final String a = bd.a;
  public static final Uri b = Uri.parse("content://" + a);
  
  public static String a()
  {
    return UUID.randomUUID().toString();
  }
  
  public static final class a
    implements BaseColumns
  {
    public static final Uri a = Uri.withAppendedPath(ci.b, "events");
    
    public static int a(cj paramcj, String paramString)
    {
      paramcj = paramcj.a();
      if (paramcj == null) {
        return 0;
      }
      ContentValues localContentValues = new ContentValues(1);
      localContentValues.put("sync_batch_id", paramString);
      return paramcj.update("event", localContentValues, "sync_status=?", new String[] { "local" });
    }
    
    public static Cursor a(cj paramcj, String paramString, String[] paramArrayOfString, int paramInt)
    {
      SQLiteDatabase localSQLiteDatabase = paramcj.b();
      if (localSQLiteDatabase == null) {
        return null;
      }
      paramcj = new StringBuilder();
      paramcj.append("sync_batch_id=?");
      String str = paramcj.toString();
      if (paramInt != -1) {}
      for (paramcj = String.valueOf(paramInt);; paramcj = null) {
        return localSQLiteDatabase.query("event", paramArrayOfString, str, new String[] { paramString }, null, null, "_id asc", paramcj);
      }
    }
    
    public static int b(cj paramcj, String paramString)
    {
      paramcj = paramcj.a();
      if (paramcj == null) {
        return 0;
      }
      return paramcj.delete("event", "sync_batch_id=?", new String[] { paramString });
    }
    
    public static int c(cj paramcj, String paramString)
    {
      paramcj = paramcj.a();
      if (paramcj == null) {
        return 0;
      }
      ContentValues localContentValues = new ContentValues(1);
      localContentValues.put("sync_batch_id", null);
      return paramcj.update("event", localContentValues, "sync_batch_id=?", new String[] { paramString });
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */