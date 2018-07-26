package com.baidu.che.codriver.protocol.data.nlp;

import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.annotations.SerializedName;

public class RestrictionData implements INoProguard {
    @SerializedName("today_restriction")
    public String todayRestriction;

    public String getTodayRestriction() {
        return this.todayRestriction;
    }

    public void setTodayRestriction(String todayRestriction) {
        this.todayRestriction = todayRestriction;
    }

    public String toString() {
        return this.todayRestriction;
    }
}
