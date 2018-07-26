package com.baidu.navi.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import com.baidu.carlife.C0965R;
import com.baidu.navi.style.StyleManager;
import java.util.List;
import java.util.Map;

public class NaviSimpleListviewAdapter extends SimpleAdapter {
    private Context mContext;

    public NaviSimpleListviewAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.mContext = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        view.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.common_list_bg_selector));
        return view;
    }
}
