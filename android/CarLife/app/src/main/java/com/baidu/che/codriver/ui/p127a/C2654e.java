package com.baidu.che.codriver.ui.p127a;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.protocol.data.Place.DetailInfo;
import com.baidu.che.codriver.protocol.data.Place.Result;
import com.baidu.che.codriver.ui.p124d.C2705h;
import com.baidu.che.codriver.ui.p128b.C2674b;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.vr.p130a.C2761c;
import com.baidu.che.codriver.widget.CompoundRelativeLayout;
import java.math.BigDecimal;
import java.util.List;

/* compiled from: NearbyAdapter */
/* renamed from: com.baidu.che.codriver.ui.a.e */
public class C2654e extends C2645a implements OnClickListener, C2651h {
    /* renamed from: b */
    public static final String f8724b = "NearbyAdapter";
    /* renamed from: c */
    public static final int f8725c = 3;
    /* renamed from: d */
    private LayoutInflater f8726d;
    /* renamed from: e */
    private List<Result> f8727e;
    /* renamed from: f */
    private C2705h f8728f;
    /* renamed from: g */
    private Context f8729g;

    public C2654e(Context mContext) {
        this.f8729g = mContext;
        this.f8726d = LayoutInflater.from(mContext);
    }

    public void onClick(View v) {
        int position = ((Integer) v.getTag()).intValue();
        v.getId();
        m9931c(position);
    }

    /* renamed from: c */
    private void m9931c(int position) {
        Result result = (Result) this.f8727e.get(position);
        if (result.location != null) {
            C2725h.m10207b(f8724b, "handleRoutClick: " + position);
            String lat = new BigDecimal(result.location.lat * 100000.0d).toString();
            String lng = new BigDecimal(result.location.lng * 100000.0d).toString();
            C2725h.m10207b(f8724b, "handle: " + C2761c.m10463a().m10473a("map", "route", new Pair("lat", lat), new Pair(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, lng), new Pair("poiName", result.name), new Pair("poiRegion", result.address)));
            C2674b.m9985b().mo1936d();
            C2761c.m10463a().m10478d();
            C2674b.m9985b().mo1925a();
        }
    }

    /* renamed from: a */
    public int mo1919a() {
        return (int) Math.ceil((double) (((float) this.f8727e.size()) / 3.0f));
    }

    /* renamed from: a */
    public View mo1920a(int position) {
        ViewGroup linearLayout = new LinearLayout(this.f8729g);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-1, -2, 0.0f));
        for (int i = 0; i < 3; i++) {
            int index = (position * 3) + i;
            View view = this.f8726d.inflate(C0965R.layout.nearby_layout_item, null);
            TextView title = (TextView) view.findViewById(C0965R.id.text_title);
            TextView price = (TextView) view.findViewById(C0965R.id.text_price);
            TextView address = (TextView) view.findViewById(C0965R.id.text_address);
            RatingBar ratingBar = (RatingBar) view.findViewById(C0965R.id.rating);
            TextView distanceTv = (TextView) view.findViewById(C0965R.id.text_distance);
            View line = view.findViewById(C0965R.id.route_layout_item_line);
            if (index >= this.f8727e.size()) {
                if (i > 0) {
                    break;
                }
            }
            String str;
            Result result = (Result) this.f8727e.get(index);
            DetailInfo detailInfo = result.detailInfo;
            title.setText(String.format("%d. %s", new Object[]{Integer.valueOf(index + 1), result.name}));
            double distance = 0.0d;
            if (detailInfo != null) {
                if (detailInfo.price == null) {
                    price.setVisibility(4);
                } else {
                    try {
                        int priceInt = (int) Float.parseFloat(detailInfo.price);
                        if (priceInt > 0) {
                            price.setText("¥" + priceInt + "/人");
                            price.setVisibility(0);
                        } else {
                            price.setVisibility(4);
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        price.setVisibility(4);
                    }
                }
                if (detailInfo.overallRating != null) {
                    ratingBar.setVisibility(0);
                    ratingBar.setRating(Float.parseFloat(detailInfo.overallRating));
                }
                if (detailInfo.distance > 0) {
                    distance = (double) detailInfo.distance;
                }
            }
            if (distance <= 0.0d && result.location != null) {
                distance = LocationUtil.getInstance().calculateDistance(result.location.lat, result.location.lng);
            }
            if (distance >= 1000.0d) {
                str = String.format("%.1fkm", new Object[]{Double.valueOf(distance / 1000.0d)});
            } else {
                str = String.format("%dm", new Object[]{Integer.valueOf((int) distance)});
            }
            distanceTv.setText(str);
            address.setText(result.address == null ? "" : result.address);
            view.setTag(Integer.valueOf(index));
            view.setOnClickListener(this);
            super.m9912a(linearLayout, (CompoundRelativeLayout) view, index);
            if (mo1919a() == 1) {
                ((RelativeLayout.LayoutParams) line.getLayoutParams()).rightMargin = 0;
            }
            if (i == 2) {
                line.setVisibility(4);
            } else {
                line.setVisibility(0);
            }
        }
        return linearLayout;
    }

    /* renamed from: a */
    public void m9934a(C2705h data) {
        this.f8728f = data;
        this.f8727e = data.m10124a();
        C2725h.m10207b(f8724b, this.f8727e.toString());
    }

    /* renamed from: b */
    public void mo1922b(int position) {
        this.f8728f.f8869l = position;
    }

    /* renamed from: b */
    public int mo1921b() {
        return this.f8728f.f8869l;
    }
}
