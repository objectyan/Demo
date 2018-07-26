package com.baidu.che.codriver.protocol.data.nlp;

import android.text.TextUtils;
import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;

public class NLPResponseData implements INoProguard {
    public int errno;
    @SerializedName("list_type")
    public String listType;
    public String logid;
    @SerializedName("raw_text")
    public String rawText;
    @SerializedName("result")
    public ArrayList<Result> resultList;

    public static class Directives implements INoProguard {
        public JsonObject header;
        public Payload payload;
    }

    public static class Payload implements INoProguard {
        @SerializedName("ask_type")
        public String askType;
        public int index;
        public String scene;
        public String url;
        /* renamed from: x */
        public int f8526x;
        /* renamed from: y */
        public int f8527y;
    }

    public static class Result implements INoProguard {
        @SerializedName("card_type")
        public String cardType;
        public String city;
        @SerializedName("current_temp")
        public String currentTemp;
        public JsonObject data;
        public ArrayList<Directives> directives;
        public String intent;
        public String listType;
        public String pm25;
        @SerializedName("pm25_level")
        public String pm25Level;
        @SerializedName("tts_status")
        public TtsData ttsStatus;
        @SerializedName("update_time")
        public String updateTime;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (!(TextUtils.isEmpty(this.rawText) || TextUtils.isEmpty(this.logid))) {
            sb.append("BaseResult{errno='" + this.errno + '\'' + ", rawText='" + this.rawText + '\'' + ", logid='" + this.logid + '\'' + ", listType='" + this.listType + '\'' + '}');
        }
        if (!(this.resultList == null || this.resultList.isEmpty())) {
            sb.append('\n');
            sb.append("-----NLP播报结果:");
            Iterator it = this.resultList.iterator();
            while (it.hasNext()) {
                Result result = (Result) it.next();
                if (result.ttsStatus != null) {
                    sb.append(result.ttsStatus.toString());
                }
            }
        }
        return sb.toString();
    }
}
