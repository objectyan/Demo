package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.baidu.speech.asr.SpeechConstant;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelInfo;
import com.baidu.tts.database.C5073f.C5065a;
import com.baidu.tts.tools.SqlTool;

public class SpeechModelTable {

    public enum Field {
        ID("id", "integer primary key"),
        TEXT_DATA_ID("text_data_id", "integer"),
        SPEECH_DATA_ID("speech_data_id", "integer"),
        NAME("name", "varchar(256) not null default unnamed"),
        VERSION_MIN("version_min", "integer"),
        VERSION_MAX("version_max", "integer"),
        LANGUAGE(SpeechConstant.LANGUAGE, "varchar(20)"),
        GENDER("gender", "varchar(20)"),
        SPEAKER("speaker", "varchar(256)"),
        DOMAIN("domain", "varchar(50)"),
        QUALITY("quality", "varchar(50)");
        
        /* renamed from: l */
        private final String f20973l;
        /* renamed from: m */
        private final String f20974m;

        private Field(String columnName, String dataType) {
            this.f20973l = columnName;
            this.f20974m = dataType;
        }

        public String getColumnName() {
            return this.f20973l;
        }

        public String getDataType() {
            return this.f20974m;
        }
    }

    /* renamed from: a */
    public static String m17200a() {
        return SqlTool.sqlCreateTable("speechModel", Field.values());
    }

    /* renamed from: b */
    public static String m17202b() {
        return SqlTool.sqlDropTable("speechModel");
    }

    /* renamed from: a */
    public static int m17199a(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.delete("speechModel", "id=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m17201a(SQLiteDatabase sQLiteDatabase, final ModelBags modelBags) {
        new C5073f(sQLiteDatabase, new C5065a() {
            /* renamed from: a */
            public boolean mo3879a(SQLiteDatabase sQLiteDatabase) {
                try {
                    SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("insert into speechModel (name, version_min, version_max, language, gender, speaker, domain, quality, text_data_id, speech_data_id, id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    for (ModelInfo modelInfo : modelBags.getModelInfos()) {
                        String name = modelInfo.getName();
                        String versionMin = modelInfo.getVersionMin();
                        String versionMax = modelInfo.getVersionMax();
                        String language = modelInfo.getLanguage();
                        String gender = modelInfo.getGender();
                        String speaker = modelInfo.getSpeaker();
                        String domain = modelInfo.getDomain();
                        String quality = modelInfo.getQuality();
                        String textDataId = modelInfo.getTextDataId();
                        String speechDataId = modelInfo.getSpeechDataId();
                        String serverId = modelInfo.getServerId();
                        compileStatement.bindString(1, name);
                        compileStatement.bindString(2, versionMin);
                        compileStatement.bindString(3, versionMax);
                        compileStatement.bindString(4, language);
                        compileStatement.bindString(5, gender);
                        compileStatement.bindString(6, speaker);
                        compileStatement.bindString(7, domain);
                        compileStatement.bindString(8, quality);
                        compileStatement.bindString(9, textDataId);
                        compileStatement.bindString(10, speechDataId);
                        compileStatement.bindString(11, serverId);
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
