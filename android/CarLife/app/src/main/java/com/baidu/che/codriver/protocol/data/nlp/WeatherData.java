package com.baidu.che.codriver.protocol.data.nlp;

import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherData implements INoProguard {
    public String city;
    @SerializedName("current_temp")
    public String currentTemp;
    public List<WeatherDetail> list;
    public String pm25;
    @SerializedName("pm25_level")
    public String pm25Level;
    @SerializedName("update_time")
    public String updateTime;

    public static class WeatherDetail implements INoProguard {
        public String temp;
        public String weather;
        public String wind;
    }
}
