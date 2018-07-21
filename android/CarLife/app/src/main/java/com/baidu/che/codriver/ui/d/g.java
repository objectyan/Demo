package com.baidu.che.codriver.ui.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.che.codriver.model.BaiKeConversationModel;
import com.baidu.che.codriver.model.BaiKeConversationModel.BaiKe;
import com.baidu.che.codriver.protocol.data.nlp.CardMovieData;
import com.baidu.che.codriver.protocol.data.nlp.CinemaData;
import com.baidu.che.codriver.protocol.data.nlp.CinemaData.CinemaBean;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData.Result;
import com.baidu.che.codriver.protocol.data.nlp.StockData;
import com.baidu.che.codriver.protocol.data.nlp.TtsData;
import com.baidu.che.codriver.protocol.data.nlp.WeatherData;
import com.baidu.che.codriver.util.c;
import com.baidu.che.codriver.util.h;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class g
{
  private static final String A = "baike";
  private static final String B = "chat";
  private static final String C = "navi";
  private static final String D = "traffic_rule";
  private static final String E = "holiday";
  public static final String a = "telematics_weather";
  public static final String b = "duer_weather";
  public static final String c = "multi_movie";
  public static final String d = "traffic_limit";
  public static final String e = "movie_satisfy";
  public static final String f = "image_search";
  public static final String g = "flight";
  public static final String h = "parking";
  public static final String i = "violation";
  public static final String j = "train_ticket";
  public static final String k = "shanghai_shenzhen_stock";
  public static final String l = "stock_index";
  public static final String m = "hongkong_stock";
  public static final String n = "us_stock";
  public static final String o = "travel";
  public static final String p = "ui_control";
  private static final String q = "talk_service";
  private static final String r = "txt";
  private static final String s = "txt_card_movie";
  private static final String t = "img_comm";
  private static final String u = "tts";
  private static final String v = "lottery";
  private static final String w = "poem";
  private static final String x = "time_zone";
  private static final String y = "tow";
  private static final String z = "population";
  
  public static NLPResponseData.Result a(NLPResponseData paramNLPResponseData)
  {
    if ((paramNLPResponseData != null) && (paramNLPResponseData.resultList != null) && (paramNLPResponseData.resultList.size() > 0) && (paramNLPResponseData.errno == 0)) {
      return (NLPResponseData.Result)paramNLPResponseData.resultList.get(0);
    }
    return null;
  }
  
  public static b a(NLPResponseData.Result paramResult)
  {
    new b();
    if (paramResult != null)
    {
      if ((!TextUtils.isEmpty(paramResult.cardType)) && (!TextUtils.isEmpty(paramResult.ttsStatus.tts)))
      {
        Object localObject2 = paramResult.cardType;
        String str = paramResult.ttsStatus.tts.toString();
        Object localObject3;
        if (("duer_weather".equals(localObject2)) || ("telematics_weather".equals(localObject2)))
        {
          localObject3 = paramResult.data;
          if (localObject3 == null) {}
        }
        for (;;)
        {
          try
          {
            localObject1 = new WeatherData();
            if ("duer_weather".equals(localObject2))
            {
              ((WeatherData)localObject1).updateTime = paramResult.updateTime;
              ((WeatherData)localObject1).city = paramResult.city;
              ((WeatherData)localObject1).currentTemp = paramResult.currentTemp;
              ((WeatherData)localObject1).pm25 = paramResult.pm25;
              ((WeatherData)localObject1).pm25Level = paramResult.pm25Level;
            }
            paramResult = (WeatherData)new Gson().fromJson((JsonElement)localObject3, new TypeToken() {}.getType());
            if (paramResult.list == null) {
              continue;
            }
            if (!"telematics_weather".equals(localObject2)) {
              continue;
            }
            paramResult = new l(paramResult);
          }
          catch (Exception paramResult)
          {
            paramResult = a(null);
            continue;
            paramResult = a(null);
            continue;
          }
          paramResult.g = str;
          return paramResult;
          ((WeatherData)localObject1).list = paramResult.list;
          paramResult = (NLPResponseData.Result)localObject1;
          continue;
          paramResult = a(null);
          continue;
          if ("txt_card_movie".equals(localObject2))
          {
            paramResult = paramResult.data;
            if (paramResult != null) {
              try
              {
                localObject1 = new TypeToken() {}.getType();
                paramResult = new a((CardMovieData)new Gson().fromJson(paramResult, (Type)localObject1));
              }
              catch (Exception paramResult)
              {
                paramResult = a(null);
              }
            } else {
              paramResult = a(null);
            }
          }
          else if (("multi_movie".equals(localObject2)) || ("movie_satisfy".equals(localObject2)))
          {
            h.b("NLPModelFactory", "cardType:" + (String)localObject2 + ";ttsStatus:" + str);
            paramResult = paramResult.data;
            if (paramResult != null) {
              try
              {
                localObject1 = new TypeToken() {}.getType();
                localObject1 = (CinemaData)new Gson().fromJson(paramResult, (Type)localObject1);
                paramResult = new CinemaData();
                if (((CinemaData)localObject1).list != null)
                {
                  localObject2 = new ArrayList();
                  int i1 = 0;
                  while (i1 < ((CinemaData)localObject1).list.size())
                  {
                    localObject3 = new CinemaData.CinemaBean();
                    ((CinemaData.CinemaBean)localObject3).name = ((CinemaData.CinemaBean)((CinemaData)localObject1).list.get(i1)).name;
                    ((CinemaData.CinemaBean)localObject3).post = ((CinemaData.CinemaBean)((CinemaData)localObject1).list.get(i1)).post;
                    ((CinemaData.CinemaBean)localObject3).score = ((CinemaData.CinemaBean)((CinemaData)localObject1).list.get(i1)).score;
                    ((List)localObject2).add(localObject3);
                    i1 += 1;
                  }
                  paramResult.list = ((List)localObject2);
                  paramResult = new e((CinemaData)localObject1);
                }
              }
              catch (Exception paramResult) {}
            }
          }
          try
          {
            if (((CinemaData)localObject1).list.size() <= 3) {
              paramResult.j = 0;
            }
          }
          catch (Exception paramResult)
          {
            for (;;) {}
          }
          paramResult = a(str);
          continue;
          paramResult = a(str);
          continue;
          paramResult = a(str);
          continue;
          if (("shanghai_shenzhen_stock".equals(localObject2)) || ("stock_index".equals(localObject2)) || ("hongkong_stock".equals(localObject2)) || ("us_stock".equals(localObject2)))
          {
            paramResult = paramResult.data;
            if (paramResult != null) {
              try
              {
                localObject3 = new StockData();
                paramResult = (StockData)new Gson().fromJson(paramResult, new TypeToken() {}.getType());
                if ((!TextUtils.isEmpty(paramResult.kurl)) && (paramResult.code != null))
                {
                  ((StockData)localObject3).code = paramResult.code;
                  ((StockData)localObject3).kurl = paramResult.kurl;
                  ((StockData)localObject3).cardType = "hongkong_stock";
                  localObject1 = new k((StockData)localObject3);
                  paramResult = (NLPResponseData.Result)localObject1;
                }
              }
              catch (Exception paramResult) {}
            }
          }
          try
          {
            h.b("NLPModelFactory", "cardType:" + (String)localObject2 + ";ttsStatus:" + str + ";data:" + ((StockData)localObject3).kurl);
            paramResult = (NLPResponseData.Result)localObject1;
          }
          catch (Exception paramResult)
          {
            for (;;) {}
          }
          Object localObject1 = new b();
          paramResult = (NLPResponseData.Result)localObject1;
          ((b)localObject1).j = 0;
          paramResult = (NLPResponseData.Result)localObject1;
          continue;
          paramResult = a(null);
          continue;
          paramResult = a(null);
          continue;
          if ("baike".equals(localObject2))
          {
            paramResult = new BaiKeConversationModel((BaiKeConversationModel.BaiKe)new Gson().fromJson(paramResult.data, BaiKeConversationModel.BaiKe.class));
          }
          else
          {
            paramResult = new b();
            paramResult.j = 1;
          }
        }
      }
      return a(null);
    }
    return a(null);
  }
  
  private static b a(String paramString)
  {
    b localb = new b();
    if (paramString == null) {}
    for (localb.g = c.a().getString(2131297238);; localb.g = paramString)
    {
      localb.j = 0;
      return localb;
    }
  }
  
  public static b b(NLPResponseData paramNLPResponseData)
  {
    return a(a(paramNLPResponseData));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */