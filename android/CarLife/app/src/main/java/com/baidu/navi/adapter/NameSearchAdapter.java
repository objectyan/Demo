package com.baidu.navi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameSearchAdapter extends BaseAdapter {
    private String mCompanyDistance;
    private String mCompanyTime;
    private Context mContext;
    private List<NameSearchEntity> mData = new ArrayList();
    private String mHomeDistance;
    private String mHomeTime;
    private String mKeyword;

    public static class NameSearchEntity implements Comparable<NameSearchEntity> {
        private String address;
        private int id;
        private String name;
        private RoutePlanNode node;
        private Type type;

        public enum Type {
            HISTORY(5),
            SUG(1),
            HOME(2),
            COMPANY(3),
            FAVORITE(4);
            
            private final int value;

            private Type(int value) {
                this.value = value;
            }

            public int getValue() {
                return this.value;
            }
        }

        public int compareTo(@NonNull NameSearchEntity field) {
            if (field.getType() == Type.HISTORY && getType() == Type.HISTORY) {
                return field.id - this.id;
            }
            return field.getType().getValue() - getType().getValue();
        }

        public NameSearchEntity(String name, Type type) {
            this(name, null, type);
        }

        public NameSearchEntity(String name, String address, Type type) {
            this.type = Type.HISTORY;
            this.name = name;
            this.address = address;
            this.type = type;
            this.node = null;
            this.id = 0;
        }

        public NameSearchEntity(String name, String address, Type type, int id) {
            this.type = Type.HISTORY;
            this.name = name;
            this.address = address;
            this.type = type;
            this.node = null;
            this.id = id;
        }

        public NameSearchEntity(RoutePlanNode node, Type type) {
            this.type = Type.HISTORY;
            this.node = node;
            this.name = node.getName();
            this.address = node.getDescription();
            this.type = type;
        }

        public String getName() {
            return this.name;
        }

        public String getAddress() {
            return this.address;
        }

        public Type getType() {
            return this.type;
        }

        public RoutePlanNode getNode() {
            return this.node;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean equals(Object o) {
            if (!(o instanceof NameSearchEntity)) {
                return false;
            }
            NameSearchEntity mNameSearch = (NameSearchEntity) o;
            if (TextUtils.isEmpty(this.name)) {
                this.name = "";
            }
            if (TextUtils.isEmpty(this.address)) {
                this.address = "";
            }
            if (TextUtils.isEmpty(mNameSearch.name)) {
                mNameSearch.name = "";
            }
            if (TextUtils.isEmpty(mNameSearch.address)) {
                mNameSearch.address = "";
            }
            return (this.name + " " + this.address).trim().equals((mNameSearch.name + " " + mNameSearch.address).trim());
        }

        public int hashCode() {
            if (TextUtils.isEmpty(this.name)) {
                this.name = "";
            }
            if (TextUtils.isEmpty(this.address)) {
                this.address = "";
            }
            return (this.name + " " + this.address).trim().hashCode();
        }
    }

    private class ViewHolder {
        TextView address;
        View bottomLine;
        TextView name;

        private ViewHolder() {
        }
    }

    public NameSearchAdapter(Context context, List<NameSearchEntity> data, String keyword) {
        this.mContext = context;
        Set<NameSearchEntity> ns = new HashSet();
        ns.addAll(data);
        this.mData.clear();
        this.mData.addAll(ns);
        Collections.sort(this.mData);
        this.mKeyword = keyword;
    }

    public void setData(List<NameSearchEntity> data, String keyword) {
        Set<NameSearchEntity> ns = new HashSet();
        ns.addAll(data);
        this.mData.clear();
        this.mData.addAll(ns);
        Collections.sort(this.mData);
        this.mKeyword = keyword;
    }

    public void updateHomeInfo(String time, String distance) {
        this.mHomeTime = time;
        this.mHomeDistance = distance;
    }

    public void updateCompanyInfo(String time, String distance) {
        this.mCompanyTime = time;
        this.mCompanyDistance = distance;
    }

    public int getCount() {
        return this.mData == null ? 0 : this.mData.size();
    }

    public NameSearchEntity getItem(int position) {
        return (this.mData == null || this.mData.size() <= position || position < 0) ? null : (NameSearchEntity) this.mData.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(this.mContext).inflate(C0965R.layout.carmode_name_search_item, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(C0965R.id.carmode_name_search_item_name);
            viewHolder.address = (TextView) convertView.findViewById(C0965R.id.carmode_name_search_item_address);
            viewHolder.bottomLine = convertView.findViewById(C0965R.id.carmode_name_search_item_line_bottom);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        NameSearchEntity item = getItem(position);
        switch (item.getType()) {
            case HOME:
                viewHolder.name.setText(C0965R.string.carmode_go_home);
                break;
            case COMPANY:
                viewHolder.name.setText(C0965R.string.carmode_go_company);
                break;
            default:
                viewHolder.name.setText(item.name);
                break;
        }
        if (!TextUtils.isEmpty(this.mKeyword)) {
            keywordHighlight(viewHolder.name, this.mKeyword);
        }
        float density = this.mContext.getResources().getDisplayMetrics().density;
        int height = (int) (80.0f * density);
        if (TextUtils.isEmpty(item.address)) {
            height = (int) (60.0f * density);
            viewHolder.address.setVisibility(8);
            viewHolder.address.setText("");
        } else {
            viewHolder.address.setVisibility(0);
            if (item.getType() == Type.HOME && !TextUtils.isEmpty(this.mHomeTime) && !TextUtils.isEmpty(this.mHomeDistance)) {
                viewHolder.address.setText(this.mHomeDistance + "，" + this.mHomeTime);
            } else if (item.getType() != Type.COMPANY || TextUtils.isEmpty(this.mCompanyTime) || TextUtils.isEmpty(this.mCompanyDistance)) {
                viewHolder.address.setText(item.address);
            } else {
                viewHolder.address.setText(this.mCompanyDistance + "，" + this.mCompanyTime);
            }
        }
        LayoutParams params = convertView.getLayoutParams();
        params.width = -1;
        params.height = height;
        convertView.setLayoutParams(params);
        return convertView;
    }

    private void keywordHighlight(TextView textView, String keyword) {
        String content = textView.getText().toString();
        if (!TextUtils.isEmpty(keyword) && !TextUtils.isEmpty(content)) {
            keyword = keyword.replaceAll("[`\\\\~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%…&*（）——+|{}【】‘；：”“’。，、？]", "");
            int start = content.indexOf(keyword);
            if (start >= 0) {
                int end = start + keyword.length();
                Spannable span = new SpannableString(content);
                span.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(C0965R.color.cl_other_c)), start, end, 33);
                textView.setText(span);
            }
        }
    }
}
