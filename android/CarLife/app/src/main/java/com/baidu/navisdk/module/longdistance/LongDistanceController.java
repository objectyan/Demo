package com.baidu.navisdk.module.longdistance;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.vi.VDeviceAPI;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class LongDistanceController {
    public static final int MSG_FETCH_WEATHER_RET = 291;
    private static final String TAG = LongDistanceController.class.getSimpleName();
    private FetchWeatherCallback mFetchWeatherCallback;
    private Handler mFetchWeatherHandler;
    private boolean mIsFetchingWeather;
    private WeatherData mWeatherData;

    public class CityWeather {
        public boolean alarm;
        public int cityId;
        public String cityName;
        public String temperature;
        public String weather;
    }

    public interface FetchWeatherCallback {
        void onGetData(WeatherData weatherData);
    }

    private static class LazyLoader {
        private static LongDistanceController instance = new LongDistanceController();

        private LazyLoader() {
        }
    }

    public class WeatherData {
        public int date = 0;
        public String errmsg = null;
        public int errno = Integer.MIN_VALUE;
        public SparseArray<CityWeather> weatherMap = null;
    }

    private LongDistanceController() {
        this.mIsFetchingWeather = false;
        this.mWeatherData = null;
        this.mFetchWeatherCallback = null;
        this.mFetchWeatherHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                if (msg != null && msg.what == 291) {
                    if (msg.arg1 == 0) {
                        LogUtil.m15791e(LongDistanceController.TAG, "mFetchWeatherHandler: RET_OK --> ");
                        if (LongDistanceController.this.mFetchWeatherCallback != null) {
                            LongDistanceController.this.mFetchWeatherCallback.onGetData(LongDistanceController.this.mWeatherData);
                        }
                    } else {
                        LogUtil.m15791e(LongDistanceController.TAG, "mFetchWeatherHandler: RET_ERR --> " + msg.arg1);
                        WeatherData weatherData = new WeatherData();
                        weatherData.errno = msg.arg1;
                        if (LongDistanceController.this.mFetchWeatherCallback != null) {
                            LongDistanceController.this.mFetchWeatherCallback.onGetData(weatherData);
                        }
                    }
                    LongDistanceController.this.mIsFetchingWeather = false;
                }
            }
        };
    }

    public static LongDistanceController getInstance() {
        return LazyLoader.instance;
    }

    public synchronized void fetchWeather(final String cityList, FetchWeatherCallback fetchWeatherCallback) {
        LogUtil.m15791e(TAG, "fetchWeather: --> mIsFetchingWeather: " + this.mIsFetchingWeather + ", cityList: " + cityList);
        if (!(this.mIsFetchingWeather || TextUtils.isEmpty(cityList))) {
            this.mIsFetchingWeather = true;
            this.mFetchWeatherCallback = fetchWeatherCallback;
            ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mFetchWeatherHandler, 291, 3000);
            reqdata.mCookieStore = BusinessActivityManager.getInstance().getCookieStore();
            CmdGeneralHttpRequestFunc.addFunc(reqdata, new Callback() {
                public boolean parseResponseJSON(JSONObject jsonObj) {
                    return LongDistanceController.this.parseFetchWeatherJson(jsonObj);
                }

                public String getUrl() {
                    return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_LONG_DIS_WEATHER);
                }

                public int getRequestType() {
                    return 1;
                }

                public void responseImage(byte[] img) {
                }

                public List<NameValuePair> getRequestParams() {
                    List<NameValuePair> params = new ArrayList();
                    StringBuffer sb = new StringBuffer();
                    try {
                        params.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
                        sb.append("cuid=" + StringUtils.getUrlEncodeString(PackageUtil.getCuid()));
                        params.add(new BasicNameValuePair("os", "2"));
                        sb.append("&os=2");
                        params.add(new BasicNameValuePair("osv", PackageUtil.strOSVersion));
                        sb.append("&osv=" + StringUtils.getUrlEncodeString(PackageUtil.strOSVersion));
                        params.add(new BasicNameValuePair("sv", PackageUtil.strSoftWareVer));
                        sb.append("&sv=" + StringUtils.getUrlEncodeString(PackageUtil.strSoftWareVer));
                        params.add(new BasicNameValuePair("pcn", VDeviceAPI.getAppPackageName()));
                        sb.append("&pcn=" + StringUtils.getUrlEncodeString(VDeviceAPI.getAppPackageName()));
                        params.add(new BasicNameValuePair("mb", VDeviceAPI.getPhoneType()));
                        sb.append("&mb=" + StringUtils.getUrlEncodeString(VDeviceAPI.getPhoneType()));
                        params.add(new BasicNameValuePair("sid", "1"));
                        sb.append("&sid=1");
                        int cityId = GeoLocateModel.getInstance().getCurrentCityId();
                        if (cityId != Integer.MIN_VALUE) {
                            params.add(new BasicNameValuePair("cityid", "" + cityId));
                            sb.append("&cityid=" + cityId);
                        }
                        Bundle bundle = new Bundle();
                        BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl(bundle);
                        String sessionId = bundle.getString("session");
                        if (sessionId != null) {
                            params.add(new BasicNameValuePair("session_id", sessionId));
                            sb.append("&session_id=" + StringUtils.getUrlEncodeString(sessionId));
                        } else {
                            LogUtil.m15791e(LongDistanceController.TAG, "fetchWeather: sessionId --> " + sessionId);
                        }
                        params.add(new BasicNameValuePair("city_list", cityList));
                        sb.append("&city_list=" + StringUtils.getUrlEncodeString(cityList));
                        String sign = JNITrajectoryControl.sInstance.getUrlParamsSign(CloudConfigObtainManager.SortSequenceWithAscendingOder(params));
                        if (TextUtils.isEmpty(sign)) {
                            sign = "";
                        }
                        params.add(new BasicNameValuePair("sign", sign));
                        sb.append("&sign=" + URLEncoder.encode(sign, "utf-8"));
                        LogUtil.m15791e(LongDistanceController.TAG, "fetchWeather: --> " + sb.toString());
                        return params;
                    } catch (UnsupportedEncodingException e) {
                        LogUtil.m15791e(LongDistanceController.TAG, "fetchWeather: --> UnsupportedEncodingException");
                        return null;
                    }
                }
            });
            CommandCenter.getInstance().sendRequest(reqdata);
        }
    }

    private synchronized boolean parseFetchWeatherJson(JSONObject jsonObj) {
        boolean z = false;
        synchronized (this) {
            if (jsonObj != null) {
                LogUtil.m15791e(TAG, "parseFetchWeatherJson: --> " + jsonObj.toString());
                WeatherData weatherData = new WeatherData();
                try {
                    weatherData.errno = jsonObj.getInt(C2125n.f6745M);
                    weatherData.errmsg = jsonObj.getString(C2125n.f6746N);
                    JSONObject dataJson = jsonObj.getJSONObject("data");
                    if (dataJson != null) {
                        if (dataJson.has("date")) {
                            weatherData.date = dataJson.getInt("date");
                        }
                        if (dataJson.has("list")) {
                            JSONArray list = dataJson.getJSONArray("list");
                            weatherData.weatherMap = new SparseArray();
                            for (int i = 0; i < list.length(); i++) {
                                JSONObject item = list.getJSONObject(i);
                                if (item != null) {
                                    boolean z2;
                                    CityWeather cityWeather = new CityWeather();
                                    cityWeather.cityId = item.getInt("id");
                                    if (item.has(NaviStatConstants.K_NSC_KEY_FINISHNAVI_CITY)) {
                                        cityWeather.cityName = item.getString(NaviStatConstants.K_NSC_KEY_FINISHNAVI_CITY);
                                    }
                                    cityWeather.weather = item.getString("weather");
                                    cityWeather.temperature = item.getString("temp");
                                    if (item.getInt("critical") == 1) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    cityWeather.alarm = z2;
                                    weatherData.weatherMap.put(cityWeather.cityId, cityWeather);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    LogUtil.m15791e(TAG, "parseFetchWeatherJson: Exception --> " + (e == null ? "" : e.getMessage()));
                }
                this.mWeatherData = weatherData;
                z = true;
            }
        }
        return z;
    }
}
