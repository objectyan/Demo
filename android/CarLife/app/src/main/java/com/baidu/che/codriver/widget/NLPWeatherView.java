package com.baidu.che.codriver.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.protocol.data.nlp.WeatherData;
import com.baidu.che.codriver.protocol.data.nlp.WeatherData.WeatherDetail;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2710l;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.C2738r;
import com.baidu.navisdk.util.common.CommonHandlerThread;

public class NLPWeatherView extends LinearLayout {
    /* renamed from: a */
    public static final String f9472a = NLPWeatherView.class.getSimpleName();
    /* renamed from: b */
    private TextView f9473b;
    /* renamed from: c */
    private TextView f9474c;
    /* renamed from: d */
    private TextView f9475d;
    /* renamed from: e */
    private TextView f9476e;
    /* renamed from: f */
    private TextView f9477f;
    /* renamed from: g */
    private TextView f9478g;
    /* renamed from: h */
    private TextView f9479h;
    /* renamed from: i */
    private TextView f9480i;
    /* renamed from: j */
    private TextView f9481j;
    /* renamed from: k */
    private ImageView f9482k;
    /* renamed from: l */
    private ImageView f9483l;
    /* renamed from: m */
    private ImageView f9484m;
    /* renamed from: n */
    private Context f9485n;

    public NLPWeatherView(Context context) {
        super(context, null);
        this.f9485n = context;
    }

    public NLPWeatherView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.f9485n = context;
    }

    public NLPWeatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f9485n = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        m10904a();
    }

    /* renamed from: a */
    private void m10904a() {
        this.f9473b = (TextView) findViewById(C0965R.id.weather_current_temp);
        this.f9474c = (TextView) findViewById(C0965R.id.weather_city);
        this.f9475d = (TextView) findViewById(C0965R.id.weather_air_qulity_text);
        this.f9476e = (TextView) findViewById(C0965R.id.weather_temp);
        this.f9477f = (TextView) findViewById(C0965R.id.weather_weather);
        this.f9482k = (ImageView) findViewById(C0965R.id.weather_pic);
        this.f9478g = (TextView) findViewById(C0965R.id.weather_temp_tomorrow);
        this.f9479h = (TextView) findViewById(C0965R.id.weather_weather_tomorrow);
        this.f9483l = (ImageView) findViewById(C0965R.id.weather_pic_tomorrow);
        this.f9484m = (ImageView) findViewById(C0965R.id.weather_pic_tdat);
        this.f9480i = (TextView) findViewById(C0965R.id.weather_temp_tdat);
        this.f9481j = (TextView) findViewById(C0965R.id.weather_weather_tdat);
    }

    /* renamed from: a */
    public void m10905a(C2549b model) {
        C2725h.m10207b(f9472a, "updateWeatherInfo");
        try {
            WeatherData weatherResult = ((C2710l) model).f8882a;
            if (weatherResult.currentTemp != null) {
                weatherResult.currentTemp = weatherResult.currentTemp.replace("℃", "°");
                this.f9473b.setText(weatherResult.currentTemp);
            } else {
                this.f9473b.setText(m10903a(((WeatherDetail) weatherResult.list.get(0)).temp) + "°");
            }
            if (weatherResult.city != null) {
                this.f9474c.setText(weatherResult.city);
                if (weatherResult.pm25Level == null || weatherResult.pm25 == null) {
                    this.f9475d.setText("暂无");
                } else {
                    int pm25int = Integer.parseInt(weatherResult.pm25);
                    GradientDrawable background = (GradientDrawable) this.f9475d.getBackground();
                    if (pm25int <= 50) {
                        background.setColor(this.f9485n.getResources().getColor(C0965R.color.level_1));
                    } else if (pm25int <= 100) {
                        background.setColor(this.f9485n.getResources().getColor(C0965R.color.level_2));
                    } else if (pm25int <= CommonHandlerThread.MSG_START_RECORD_TRAJECTORY) {
                        background.setColor(this.f9485n.getResources().getColor(C0965R.color.level_3));
                    } else if (pm25int <= 200) {
                        background.setColor(this.f9485n.getResources().getColor(C0965R.color.level_4));
                    } else if (pm25int <= 300) {
                        background.setColor(this.f9485n.getResources().getColor(C0965R.color.level_5));
                    } else {
                        background.setColor(this.f9485n.getResources().getColor(C0965R.color.level_6));
                    }
                    this.f9475d.setText(weatherResult.pm25Level);
                }
            } else {
                this.f9474c.setText("暂无数据");
                this.f9475d.setText("暂无");
            }
            if (weatherResult.list == null || weatherResult.list.size() < 0) {
                this.f9477f.setText("暂无数据");
                this.f9476e.setText("今天：暂无数据");
                return;
            }
            this.f9477f.setText(((WeatherDetail) weatherResult.list.get(0)).weather);
            setWeatherPic(((WeatherDetail) weatherResult.list.get(0)).weather, this.f9482k);
            ((WeatherDetail) weatherResult.list.get(0)).temp = ((WeatherDetail) weatherResult.list.get(0)).temp.replace("℃", "°");
            this.f9476e.setText("今天：" + ((WeatherDetail) weatherResult.list.get(0)).temp);
            if (weatherResult.list.size() >= 2) {
                ((WeatherDetail) weatherResult.list.get(1)).temp = ((WeatherDetail) weatherResult.list.get(1)).temp.replace("℃", "°");
                this.f9478g.setText(((WeatherDetail) weatherResult.list.get(1)).temp);
                this.f9479h.setText(((WeatherDetail) weatherResult.list.get(1)).weather);
                setWeatherPicB(((WeatherDetail) weatherResult.list.get(1)).weather, this.f9483l);
                ((WeatherDetail) weatherResult.list.get(2)).temp = ((WeatherDetail) weatherResult.list.get(2)).temp.replace("℃", "°");
                this.f9480i.setText(((WeatherDetail) weatherResult.list.get(2)).temp);
                this.f9481j.setText(((WeatherDetail) weatherResult.list.get(2)).weather);
                setWeatherPicB(((WeatherDetail) weatherResult.list.get(2)).weather, this.f9484m);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C2725h.m10214e(f9472a, 9 + e.getMessage().toString());
        }
    }

    /* renamed from: a */
    private int m10903a(String tempString) {
        int temp1;
        int temp2;
        String[] temp = tempString.split("/");
        if (temp.length == 1) {
            temp = tempString.split("~");
            if (temp.length > 1) {
                temp1 = Integer.parseInt(temp[0].substring(0, temp[0].length() - 1));
                temp2 = Integer.parseInt(temp[1].substring(0, temp[1].length() - 1));
            } else {
                temp1 = 0;
                temp2 = 40;
            }
        } else {
            temp2 = Integer.parseInt(temp[0].substring(0, temp[0].length() - 1));
            temp1 = Integer.parseInt(temp[1].substring(0, temp[1].length() - 1));
        }
        return (temp1 + temp2) / 2;
    }

    private void setWeatherPic(String name, ImageView view) {
        int type = C2738r.m10262a(name);
        if (type == 1) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_sun));
        } else if (type == 2 || type == 3) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_cloudy));
        } else if ((type >= 4 && type <= 13) || type == 20 || (type >= 22 && type <= 26)) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_rain));
        } else if ((type >= 14 && type <= 18) || (type >= 27 && type <= 29)) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_snow));
        } else if (type == 19 || type == 33) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_fog));
        } else if (type == 21 || (type >= 30 && type <= 32)) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_sand_storm));
        } else if (name != null && name.contains(C1253f.gz)) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_rain));
        } else if (name != null && name.contains(C1253f.gC)) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_snow));
        }
    }

    private void setWeatherPicB(String name, ImageView view) {
        int type = C2738r.m10262a(name);
        if (type == 1) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_sun_b));
        } else if (type == 2 || type == 3) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_cloudy_b));
        } else if ((type >= 4 && type <= 13) || type == 20 || (type >= 22 && type <= 26)) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_rain_b));
        } else if ((type >= 14 && type <= 18) || (type >= 27 && type <= 29)) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_snow_b));
        } else if (type == 19 || type == 33) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_fog_b));
        } else if (type == 21 || (type >= 30 && type <= 32)) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_sand_storm_b));
        } else if (name != null && name.contains(C1253f.gz)) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_rain_b));
        } else if (name != null && name.contains(C1253f.gC)) {
            view.setImageDrawable(this.f9485n.getResources().getDrawable(C0965R.drawable.weather_snow_b));
        }
    }
}
