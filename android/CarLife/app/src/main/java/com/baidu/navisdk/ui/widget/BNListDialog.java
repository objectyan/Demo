package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class BNListDialog extends BNDialog {
    private Activity mActivity;
    private ListView mListView;

    public class InnerListAdapter extends BaseAdapter {
        private ArrayList<String> mDataList = new ArrayList();

        public InnerListAdapter(ArrayList<String> mDataList) {
            for (int i = 0; i < mDataList.size(); i++) {
                this.mDataList.add(mDataList.get(i));
            }
        }

        public int getCount() {
            if (this.mDataList == null || this.mDataList.size() <= 0) {
                return 0;
            }
            return this.mDataList.size();
        }

        public Object getItem(int position) {
            if (this.mDataList == null || position < 0 || position >= this.mDataList.size()) {
                return null;
            }
            return this.mDataList.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if (convertView == null) {
                convertView = JarUtils.inflate(BNListDialog.this.mActivity, C4048R.layout.tv_iv_list_item, null);
                textView = (TextView) convertView.findViewById(C4048R.id.text_view);
                convertView.setTag(textView);
            } else {
                textView = (TextView) convertView.getTag();
            }
            if (this.mDataList != null && position >= 0 && position < this.mDataList.size()) {
                textView.setText((CharSequence) this.mDataList.get(position));
            }
            if (position == getCount() - 1) {
                textView.setTextColor(BNStyleManager.getColor(C4048R.color.poi_city_list_title));
                convertView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
            } else {
                textView.setTextColor(BNStyleManager.getColor(C4048R.color.poi_city_list_title));
                convertView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_middle));
            }
            return convertView;
        }
    }

    public BNListDialog(Activity activity) {
        super(activity);
        this.mActivity = activity;
        View view = JarUtils.inflate(activity, C4048R.layout.navi_dialog_listview, null);
        this.mListView = (ListView) view.findViewById(C4048R.id.list_view);
        setContentList(view);
    }

    public BNListDialog setAdapter(ListAdapter adapter) {
        this.mListView.setAdapter(adapter);
        return this;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public BNListDialog setOnItemClickListener(OnItemClickListener listener) {
        this.mListView.setOnItemClickListener(listener);
        return this;
    }

    public BNListDialog setListWidth(int width) {
        LayoutParams params = this.mListView.getLayoutParams();
        params.width = width;
        this.mListView.setLayoutParams(params);
        return this;
    }

    public BNListDialog setListHeight(int height) {
        LayoutParams params = this.mListView.getLayoutParams();
        params.height = height;
        this.mListView.setLayoutParams(params);
        return this;
    }

    public BNListDialog setListSelection(int position) {
        this.mListView.setSelection(position);
        return this;
    }

    public BNListDialog setTitleText(String text) {
        super.setTitleText(text);
        return this;
    }

    public BNListDialog setTitleText(int resId) {
        super.setTitleText(resId);
        return this;
    }

    public BNListDialog setFirstBtnText(String text) {
        super.setFirstBtnText(text);
        return this;
    }

    public BNListDialog setFirstBtnText(int resId) {
        super.setFirstBtnText(resId);
        return this;
    }

    public BNListDialog setSecondBtnText(String text) {
        super.setSecondBtnText(text);
        return this;
    }

    public BNListDialog setSecondBtnText(int resId) {
        super.setSecondBtnText(resId);
        return this;
    }

    public BNListDialog setContentList(View content) {
        super.setContentList(content);
        return this;
    }

    public BNListDialog setOnFirstBtnClickListener(OnNaviClickListener listener) {
        super.setOnFirstBtnClickListener(listener);
        return this;
    }

    public BNListDialog setOnSecondBtnClickListener(OnNaviClickListener listener) {
        super.setOnSecondBtnClickListener(listener);
        return this;
    }

    public BNListDialog setFirstBtnEnabled(boolean enabled) {
        super.setFirstBtnEnabled(enabled);
        return this;
    }

    public BNListDialog setSecondBtnEnabled(boolean enabled) {
        super.setSecondBtnEnabled(enabled);
        return this;
    }

    public BNListDialog enableBackKey(boolean cancelable) {
        super.enableBackKey(cancelable);
        return this;
    }

    public BNListDialog setListTitleText(String text) {
        super.setListTitleText(text);
        return this;
    }

    public void setListAdapter(ArrayList<String> mDataList) {
        this.mListView.setAdapter(new InnerListAdapter(mDataList));
    }
}
