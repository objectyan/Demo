package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.client.model.ModelFileInfo;
import com.baidu.tts.database.C5073f.C5065a;
import com.baidu.tts.tools.SqlTool;

public class ModelFileTable {

    public enum Field {
        ID("id", "integer primary key"),
        LENGTH("length", "bigint"),
        MD5("md5", "varchar(32)"),
        NAME("name", "varchar(256) not null default unnamed"),
        ABS_PATH("absPath", "varchar");
        
        /* renamed from: f */
        private final String f20958f;
        /* renamed from: g */
        private final String f20959g;

        private Field(String columnName, String dataType) {
            this.f20958f = columnName;
            this.f20959g = dataType;
        }

        public String getColumnName() {
            return this.f20958f;
        }

        public String getDataType() {
            return this.f20959g;
        }
    }

    /* renamed from: a */
    public static String m17195a() {
        return SqlTool.sqlCreateTable("modelFile", Field.values());
    }

    /* renamed from: b */
    public static String m17197b() {
        return SqlTool.sqlDropTable("modelFile");
    }

    /* renamed from: a */
    public static int m17194a(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.delete("modelFile", "id=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m17196a(SQLiteDatabase sQLiteDatabase, final ModelFileBags modelFileBags) {
        new C5073f(sQLiteDatabase, new C5065a() {
            /* renamed from: a */
            public boolean mo3879a(SQLiteDatabase sQLiteDatabase) {
                try {
                    SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("insert into modelFile (id, length, md5, name, absPath) values (?, ?, ?, ?, ?)");
                    for (ModelFileInfo modelFileInfo : modelFileBags.getModelFileInfos()) {
                        String serverid = modelFileInfo.getServerid();
                        String length = modelFileInfo.getLength();
                        String md5 = modelFileInfo.getMd5();
                        String name = modelFileInfo.getName();
                        String absPath = modelFileInfo.getAbsPath();
                        compileStatement.bindString(1, serverid);
                        compileStatement.bindString(2, length);
                        compileStatement.bindString(3, md5);
                        compileStatement.bindString(4, name);
                        compileStatement.bindString(5, absPath);
                        compileStatement.executeInsert();
                    }
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }).m17226a();
    }
}
