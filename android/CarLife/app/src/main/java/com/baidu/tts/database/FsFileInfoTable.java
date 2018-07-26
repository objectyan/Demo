package com.baidu.tts.database;

import com.baidu.tts.tools.SqlTool;

public class FsFileInfoTable {

    public enum Field {
        ABS_PATH("absPath", "varchar primary key"),
        STATE("state", "integer");
        
        /* renamed from: c */
        private final String f20949c;
        /* renamed from: d */
        private final String f20950d;

        private Field(String columnName, String dataType) {
            this.f20949c = columnName;
            this.f20950d = dataType;
        }

        public String getColumnName() {
            return this.f20949c;
        }

        public String getDataType() {
            return this.f20950d;
        }
    }

    /* renamed from: a */
    public static String m17190a() {
        return SqlTool.sqlCreateTable("fsFileInfo", Field.values());
    }

    /* renamed from: b */
    public static String m17191b() {
        return SqlTool.sqlDropTable("fsFileInfo");
    }
}
