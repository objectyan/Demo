package com.baidu.navi.util;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListViewUtils {
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {
            int totalHeight = 0;
            int len = listAdapter.getCount();
            for (int i = 0; i < len; i++) {
                View listItem = null;
                try {
                    listItem = listAdapter.getView(i, null, listView);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (listItem != null) {
                    listItem.measure(0, 0);
                    totalHeight += listItem.getMeasuredHeight();
                }
            }
            LayoutParams params = listView.getLayoutParams();
            params.height = (listView.getDividerHeight() * (listAdapter.getCount() - 1)) + totalHeight;
            listView.setLayoutParams(params);
        }
    }
}
