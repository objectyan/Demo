package com.baidu.navisdk.debug.commonui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

public class DebugCommonUIView {
    private DebugListViewAdapter mAdapter = null;
    private DebugCommonUICallback mCallback = null;
    private int mIndex = 1;
    private TextView mInfoTV = null;
    private ListView mKeyValueLV = null;
    private String mOldInfo = "";
    private Button mRefreshBtn = null;
    private View mRootView = null;

    /* renamed from: com.baidu.navisdk.debug.commonui.DebugCommonUIView$1 */
    class C40891 implements OnClickListener {
        C40891() {
        }

        public void onClick(View v) {
            DebugCommonUIView.this.refresh();
        }
    }

    /* renamed from: com.baidu.navisdk.debug.commonui.DebugCommonUIView$2 */
    class C40902 implements OnTouchListener {
        C40902() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    }

    private static class DebugListItemHolder {
        public TextView mKeyTV;
        public TextView mValueTV;

        private DebugListItemHolder() {
            this.mKeyTV = null;
            this.mValueTV = null;
        }
    }

    public static class DebugListViewAdapter extends BaseAdapter {
        private List<DebugViewKeyValueData> mData = new ArrayList();

        public void updateData(List<DebugViewKeyValueData> data) {
            this.mData.clear();
            if (data != null) {
                this.mData.addAll(data);
            }
        }

        public int getCount() {
            return this.mData.size();
        }

        public DebugViewKeyValueData getDataItem(int position) {
            if (position < 0 || position >= this.mData.size()) {
                return null;
            }
            return (DebugViewKeyValueData) this.mData.get(position);
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public boolean isEnabled(int position) {
            return false;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            DebugListItemHolder holder;
            if (convertView == null) {
                convertView = JarUtils.inflate(BNaviModuleManager.getActivity(), C4048R.layout.debug_common_listview_item, null);
                holder = new DebugListItemHolder();
                holder.mKeyTV = (TextView) convertView.findViewById(C4048R.id.debug_key_tv);
                holder.mValueTV = (TextView) convertView.findViewById(C4048R.id.debug_value_tv);
                convertView.setTag(holder);
            } else {
                holder = (DebugListItemHolder) convertView.getTag();
            }
            DebugViewKeyValueData data = getDataItem(position);
            if (data != null) {
                holder.mKeyTV.setText(data.key);
                holder.mValueTV.setText(data.value);
            } else {
                holder.mKeyTV.setText("");
                holder.mValueTV.setText("");
            }
            return convertView;
        }
    }

    public static class DebugViewKeyValueData {
        public String key;
        public String value;

        public DebugViewKeyValueData(String k, String v) {
            this.key = k;
            this.value = v;
        }
    }

    public DebugCommonUIView(DebugCommonUICallback callback) {
        this.mCallback = callback;
        init();
    }

    private void init() {
        this.mRootView = JarUtils.inflate(BNaviModuleManager.getActivity(), C4048R.layout.debug_common_layout, null);
        this.mRefreshBtn = (Button) this.mRootView.findViewById(C4048R.id.debug_refresh_btn);
        this.mInfoTV = (TextView) this.mRootView.findViewById(C4048R.id.debug_info_tv);
        this.mKeyValueLV = (ListView) this.mRootView.findViewById(C4048R.id.debug_key_value_lv);
        if (this.mRefreshBtn != null) {
            this.mRefreshBtn.setOnClickListener(new C40891());
        }
        if (this.mKeyValueLV != null) {
            this.mAdapter = new DebugListViewAdapter();
            this.mKeyValueLV.setAdapter(this.mAdapter);
            this.mKeyValueLV.setOnTouchListener(new C40902());
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void show() {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(0);
        }
    }

    public void hide() {
        this.mRootView.setVisibility(8);
    }

    public void refresh() {
        if (this.mCallback != null) {
            updateKeyValueData(this.mCallback.getKeyValues());
            updateInfo(this.mCallback.getInfo(), false);
        }
    }

    public void updateKeyValueData(List<DebugViewKeyValueData> data) {
        if (this.mAdapter != null) {
            this.mAdapter.updateData(data);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void updateInfo(String info, boolean clearOld) {
        if (this.mInfoTV != null && info != null) {
            if (clearOld) {
                this.mOldInfo = "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            int i = this.mIndex;
            this.mIndex = i + 1;
            this.mOldInfo = stringBuilder.append(String.valueOf(i)).append("-").append(info).append("\n").append(this.mOldInfo).toString();
            this.mInfoTV.setText(this.mOldInfo);
            if (this.mIndex > 9) {
                this.mIndex = 1;
            }
        }
    }
}
