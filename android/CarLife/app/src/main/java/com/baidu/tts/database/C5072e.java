package com.baidu.tts.database;

import com.baidu.tts.tools.SqlTool;

/* compiled from: StatisticsInfoTable */
/* renamed from: com.baidu.tts.database.e */
public class C5072e {
    /* renamed from: a */
    public static String m17224a() {
        return "CREATE TABLE StatisticsInfo(id INTEGER PRIMARY KEY AUTOINCREMENT,uuid varchar(256),startInfo varchar(256),endInfo varchar(256))";
    }

    /* renamed from: b */
    public static String m17225b() {
        return SqlTool.sqlDropTable("StatisticsInfo");
    }
}
