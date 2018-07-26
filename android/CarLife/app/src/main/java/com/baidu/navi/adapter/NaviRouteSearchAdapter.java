package com.baidu.navi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener.ActionTypeSearchParams;

public class NaviRouteSearchAdapter extends BaseAdapter {
    private int[] icons = new int[]{C0965R.drawable.map_ic_navigating_point_oil, C0965R.drawable.map_ic_navigating_point_park, C0965R.drawable.map_ic_navigating_point_toilets, C0965R.drawable.map_ic_navigating_point_food, C0965R.drawable.map_ic_navigating_point_hotel, C0965R.drawable.map_ic_navigating_point_bank};
    private String[] items;
    private Context mContext;

    public NaviRouteSearchAdapter(Context context) {
        this.mContext = context;
        this.items = StyleManager.getStringArray(C0965R.array.map_in_navi_route_search_list_item_keywords);
    }

    public int getCount() {
        return this.items.length;
    }

    public String getItem(int position) {
        if (position < 0 || position >= this.items.length) {
            return "";
        }
        return this.items[position];
    }

    public String getSearchKey(int position) {
        if (position >= 0 && position < this.items.length) {
            if (position == 0) {
                return ActionTypeSearchParams.Gas_Station;
            }
            if (position == 1) {
                return ActionTypeSearchParams.Park;
            }
            if (position == 2) {
                return ActionTypeSearchParams.Toilet;
            }
            if (position == 3) {
                return ActionTypeSearchParams.Restaurant;
            }
            if (position == 4) {
                return ActionTypeSearchParams.Hotel;
            }
            if (position == 5) {
                return ActionTypeSearchParams.Bank;
            }
        }
        return "";
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(this.mContext).inflate(C0965R.layout.innavi_route_search_list_item, parent, false);
        TextView tv = (TextView) convertView.findViewById(C0965R.id.tv_route_search_keyword);
        ((ImageView) convertView.findViewById(C0965R.id.img_route_search_icon)).setImageDrawable(StyleManager.getDrawable(this.icons[position]));
        tv.setText(getItem(position));
        if (position + 1 == getCount()) {
            convertView.findViewById(C0965R.id.dirver).setVisibility(8);
        }
        return convertView;
    }
}
