package com.baidu.che.codriver.util;

import com.baidu.carlife.core.C1253f;

/* compiled from: WeatherUtil */
/* renamed from: com.baidu.che.codriver.util.r */
public class C2738r {
    /* renamed from: a */
    public static int m10262a(String weather) {
        Object obj = -1;
        switch (weather.hashCode()) {
            case -1854753918:
                if (weather.equals("暴雨-大暴雨")) {
                    obj = 25;
                    break;
                }
                break;
            case -1840735405:
                if (weather.equals("中雨-大雨")) {
                    obj = 23;
                    break;
                }
                break;
            case -1840675821:
                if (weather.equals("中雪-大雪")) {
                    obj = 28;
                    break;
                }
                break;
            case -1236115480:
                if (weather.equals("雷阵雨伴有冰雹")) {
                    obj = 6;
                    break;
                }
                break;
            case -1005221516:
                if (weather.equals("大暴雨-特大暴雨")) {
                    obj = 26;
                    break;
                }
                break;
            case 26228:
                if (weather.equals(C1253f.gB)) {
                    obj = null;
                    break;
                }
                break;
            case 38452:
                if (weather.equals(C1253f.gD)) {
                    obj = 3;
                    break;
                }
                break;
            case 38654:
                if (weather.equals("雾")) {
                    obj = 19;
                    break;
                }
                break;
            case 38718:
                if (weather.equals("霾")) {
                    obj = 33;
                    break;
                }
                break;
            case 659035:
                if (weather.equals("中雨")) {
                    obj = 9;
                    break;
                }
                break;
            case 659037:
                if (weather.equals("中雪")) {
                    obj = 16;
                    break;
                }
                break;
            case 687245:
                if (weather.equals("冻雨")) {
                    obj = 20;
                    break;
                }
                break;
            case 727223:
                if (weather.equals(C1253f.gA)) {
                    obj = 1;
                    break;
                }
                break;
            case 746145:
                if (weather.equals("大雨")) {
                    obj = 10;
                    break;
                }
                break;
            case 746147:
                if (weather.equals("大雪")) {
                    obj = 17;
                    break;
                }
                break;
            case 769209:
                if (weather.equals("小雨")) {
                    obj = 8;
                    break;
                }
                break;
            case 769211:
                if (weather.equals("小雪")) {
                    obj = 15;
                    break;
                }
                break;
            case 808877:
                if (weather.equals("扬沙")) {
                    obj = 31;
                    break;
                }
                break;
            case 853684:
                if (weather.equals("暴雨")) {
                    obj = 11;
                    break;
                }
                break;
            case 853686:
                if (weather.equals("暴雪")) {
                    obj = 18;
                    break;
                }
                break;
            case 892010:
                if (weather.equals("浮尘")) {
                    obj = 30;
                    break;
                }
                break;
            case 1230675:
                if (weather.equals("阵雨")) {
                    obj = 4;
                    break;
                }
                break;
            case 1230677:
                if (weather.equals("阵雪")) {
                    obj = 14;
                    break;
                }
                break;
            case 22786587:
                if (weather.equals("大暴雨")) {
                    obj = 12;
                    break;
                }
                break;
            case 27439871:
                if (weather.equals("沙城暴")) {
                    obj = 21;
                    break;
                }
                break;
            case 37872057:
                if (weather.equals("雨夹雪")) {
                    obj = 7;
                    break;
                }
                break;
            case 38370442:
                if (weather.equals("雷阵雨")) {
                    obj = 5;
                    break;
                }
                break;
            case 700037951:
                if (weather.equals("多云转阴")) {
                    obj = 2;
                    break;
                }
                break;
            case 753718907:
                if (weather.equals("强沙尘暴")) {
                    obj = 32;
                    break;
                }
                break;
            case 754466144:
                if (weather.equals("大雨-暴雨")) {
                    obj = 24;
                    break;
                }
                break;
            case 754525728:
                if (weather.equals("大雪-暴雪")) {
                    obj = 29;
                    break;
                }
                break;
            case 895811842:
                if (weather.equals("特大暴雨")) {
                    obj = 13;
                    break;
                }
                break;
            case 1441371119:
                if (weather.equals("小雨-中雨")) {
                    obj = 22;
                    break;
                }
                break;
            case 1441430703:
                if (weather.equals("小雪-中雪")) {
                    obj = 27;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return 1;
            case 1:
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 10;
            case 11:
                return 11;
            case 12:
                return 12;
            case 13:
                return 13;
            case 14:
                return 14;
            case 15:
                return 15;
            case 16:
                return 16;
            case 17:
                return 17;
            case 18:
                return 18;
            case 19:
                return 19;
            case 20:
                return 20;
            case 21:
                return 21;
            case 22:
                return 22;
            case 23:
                return 23;
            case 24:
                return 24;
            case 25:
                return 25;
            case 26:
                return 26;
            case 27:
                return 27;
            case 28:
                return 28;
            case 29:
                return 29;
            case 30:
                return 30;
            case 31:
                return 31;
            case 32:
                return 32;
            case 33:
                return 33;
            default:
                if (weather != null && weather.contains(C1253f.gz)) {
                    return 8;
                }
                if (weather != null && weather.contains(C1253f.gC)) {
                    return 15;
                }
                if (weather == null || !weather.contains("云")) {
                    return 0;
                }
                return 2;
        }
    }
}
