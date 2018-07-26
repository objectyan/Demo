package com.baidu.che.codriver.ui.p124d;

import android.text.TextUtils;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.model.BaiKeConversationModel;
import com.baidu.che.codriver.model.BaiKeConversationModel.BaiKe;
import com.baidu.che.codriver.protocol.data.nlp.CardMovieData;
import com.baidu.che.codriver.protocol.data.nlp.CinemaData;
import com.baidu.che.codriver.protocol.data.nlp.CinemaData.CinemaBean;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData.Result;
import com.baidu.che.codriver.protocol.data.nlp.StockData;
import com.baidu.che.codriver.protocol.data.nlp.WeatherData;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NLPModelFactory */
/* renamed from: com.baidu.che.codriver.ui.d.g */
public class C2704g {
    /* renamed from: A */
    private static final String f8837A = "baike";
    /* renamed from: B */
    private static final String f8838B = "chat";
    /* renamed from: C */
    private static final String f8839C = "navi";
    /* renamed from: D */
    private static final String f8840D = "traffic_rule";
    /* renamed from: E */
    private static final String f8841E = "holiday";
    /* renamed from: a */
    public static final String f8842a = "telematics_weather";
    /* renamed from: b */
    public static final String f8843b = "duer_weather";
    /* renamed from: c */
    public static final String f8844c = "multi_movie";
    /* renamed from: d */
    public static final String f8845d = "traffic_limit";
    /* renamed from: e */
    public static final String f8846e = "movie_satisfy";
    /* renamed from: f */
    public static final String f8847f = "image_search";
    /* renamed from: g */
    public static final String f8848g = "flight";
    /* renamed from: h */
    public static final String f8849h = "parking";
    /* renamed from: i */
    public static final String f8850i = "violation";
    /* renamed from: j */
    public static final String f8851j = "train_ticket";
    /* renamed from: k */
    public static final String f8852k = "shanghai_shenzhen_stock";
    /* renamed from: l */
    public static final String f8853l = "stock_index";
    /* renamed from: m */
    public static final String f8854m = "hongkong_stock";
    /* renamed from: n */
    public static final String f8855n = "us_stock";
    /* renamed from: o */
    public static final String f8856o = "travel";
    /* renamed from: p */
    public static final String f8857p = "ui_control";
    /* renamed from: q */
    private static final String f8858q = "talk_service";
    /* renamed from: r */
    private static final String f8859r = "txt";
    /* renamed from: s */
    private static final String f8860s = "txt_card_movie";
    /* renamed from: t */
    private static final String f8861t = "img_comm";
    /* renamed from: u */
    private static final String f8862u = "tts";
    /* renamed from: v */
    private static final String f8863v = "lottery";
    /* renamed from: w */
    private static final String f8864w = "poem";
    /* renamed from: x */
    private static final String f8865x = "time_zone";
    /* renamed from: y */
    private static final String f8866y = "tow";
    /* renamed from: z */
    private static final String f8867z = "population";

    /* compiled from: NLPModelFactory */
    /* renamed from: com.baidu.che.codriver.ui.d.g$1 */
    static class C27001 extends TypeToken<WeatherData> {
        C27001() {
        }
    }

    /* compiled from: NLPModelFactory */
    /* renamed from: com.baidu.che.codriver.ui.d.g$2 */
    static class C27012 extends TypeToken<CardMovieData> {
        C27012() {
        }
    }

    /* compiled from: NLPModelFactory */
    /* renamed from: com.baidu.che.codriver.ui.d.g$3 */
    static class C27023 extends TypeToken<CinemaData> {
        C27023() {
        }
    }

    /* compiled from: NLPModelFactory */
    /* renamed from: com.baidu.che.codriver.ui.d.g$4 */
    static class C27034 extends TypeToken<StockData> {
        C27034() {
        }
    }

    /* renamed from: a */
    public static Result m10120a(NLPResponseData response) {
        if (response == null || response.resultList == null || response.resultList.size() <= 0 || response.errno != 0) {
            return null;
        }
        return (Result) response.resultList.get(0);
    }

    /* renamed from: b */
    public static C2549b m10123b(NLPResponseData response) {
        return C2704g.m10121a(C2704g.m10120a(response));
    }

    /* renamed from: a */
    public static C2549b m10121a(Result result) {
        C2549b model = new C2549b();
        if (result == null) {
            return C2704g.m10122a(null);
        }
        if (TextUtils.isEmpty(result.cardType) || TextUtils.isEmpty(result.ttsStatus.tts)) {
            return C2704g.m10122a(null);
        }
        String cardType = result.cardType;
        String tts = result.ttsStatus.tts.toString();
        JsonObject data;
        if (f8843b.equals(cardType) || f8842a.equals(cardType)) {
            data = result.data;
            if (data != null) {
                try {
                    WeatherData weatherData = new WeatherData();
                    if (f8843b.equals(cardType)) {
                        weatherData.updateTime = result.updateTime;
                        weatherData.city = result.city;
                        weatherData.currentTemp = result.currentTemp;
                        weatherData.pm25 = result.pm25;
                        weatherData.pm25Level = result.pm25Level;
                    }
                    WeatherData weatherDataResult = (WeatherData) new Gson().fromJson(data, new C27001().getType());
                    if (weatherDataResult.list != null) {
                        if (f8842a.equals(cardType)) {
                            weatherData = weatherDataResult;
                        } else {
                            weatherData.list = weatherDataResult.list;
                        }
                        model = new C2710l(weatherData);
                    } else {
                        model = C2704g.m10122a(null);
                    }
                } catch (Exception e) {
                    model = C2704g.m10122a(null);
                }
            } else {
                model = C2704g.m10122a(null);
            }
        } else if (f8860s.equals(cardType)) {
            data = result.data;
            if (data != null) {
                try {
                    model = new C2694a((CardMovieData) new Gson().fromJson(data, new C27012().getType()));
                } catch (Exception e2) {
                    model = C2704g.m10122a(null);
                }
            } else {
                model = C2704g.m10122a(null);
            }
        } else if (f8844c.equals(cardType) || f8846e.equals(cardType)) {
            C2725h.m10207b("NLPModelFactory", "cardType:" + cardType + ";ttsStatus:" + tts);
            data = result.data;
            if (data != null) {
                try {
                    CinemaData cinemaDataResult = (CinemaData) new Gson().fromJson(data, new C27023().getType());
                    CinemaData cinemaData = new CinemaData();
                    if (cinemaDataResult.list != null) {
                        List<CinemaBean> cines = new ArrayList();
                        for (int i = 0; i < cinemaDataResult.list.size(); i++) {
                            CinemaBean bean = new CinemaBean();
                            bean.name = ((CinemaBean) cinemaDataResult.list.get(i)).name;
                            bean.post = ((CinemaBean) cinemaDataResult.list.get(i)).post;
                            bean.score = ((CinemaBean) cinemaDataResult.list.get(i)).score;
                            cines.add(bean);
                        }
                        cinemaData.list = cines;
                        model = new C2698e(cinemaDataResult);
                        try {
                            if (cinemaDataResult.list.size() <= 3) {
                                model.f8468j = 0;
                            }
                            model = model;
                        } catch (Exception e3) {
                            model = model;
                            model = C2704g.m10122a(tts);
                            model.f8465g = tts;
                            return model;
                        }
                    }
                    model = C2704g.m10122a(tts);
                } catch (Exception e4) {
                    model = C2704g.m10122a(tts);
                    model.f8465g = tts;
                    return model;
                }
            }
            model = C2704g.m10122a(tts);
        } else if (f8852k.equals(cardType) || f8853l.equals(cardType) || f8854m.equals(cardType) || f8855n.equals(cardType)) {
            data = result.data;
            if (data != null) {
                try {
                    StockData stockData = new StockData();
                    StockData stockDataResult = (StockData) new Gson().fromJson(data, new C27034().getType());
                    if (TextUtils.isEmpty(stockDataResult.kurl) || stockDataResult.code == null) {
                        model = new C2549b();
                        model.f8468j = 0;
                        model = model;
                    } else {
                        stockData.code = stockDataResult.code;
                        stockData.kurl = stockDataResult.kurl;
                        stockData.cardType = f8854m;
                        model = new C2709k(stockData);
                        try {
                            C2725h.m10207b("NLPModelFactory", "cardType:" + cardType + ";ttsStatus:" + tts + ";data:" + stockData.kurl);
                            model = model;
                        } catch (Exception e5) {
                            model = model;
                            model = C2704g.m10122a(null);
                            model.f8465g = tts;
                            return model;
                        }
                    }
                } catch (Exception e6) {
                    model = C2704g.m10122a(null);
                    model.f8465g = tts;
                    return model;
                }
            }
            model = C2704g.m10122a(null);
        } else if (f8837A.equals(cardType)) {
            model = new BaiKeConversationModel((BaiKe) new Gson().fromJson(result.data, BaiKe.class));
        } else {
            model = new C2549b();
            model.f8468j = 1;
        }
        model.f8465g = tts;
        return model;
    }

    /* renamed from: a */
    private static C2549b m10122a(String msg) {
        C2549b model = new C2549b();
        if (msg == null) {
            model.f8465g = C2716c.m10141a().getString(C0965R.string.xiaodu_is_not_understand_service);
        } else {
            model.f8465g = msg;
        }
        model.f8468j = 0;
        return model;
    }
}
