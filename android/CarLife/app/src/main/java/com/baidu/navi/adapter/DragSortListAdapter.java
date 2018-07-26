package com.baidu.navi.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.DragSortListener;
import com.baidu.navi.view.draglistview.OnDragAdapterListener;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import java.util.Vector;

public class DragSortListAdapter extends ArrayAdapter<RoutePlanNode> implements OnDragAdapterListener {
    private Context mContext;
    private Vector<RoutePlanNode> mData;
    private DragSortListener mDragSortListener;
    private Vector<ViewHolder> mViewHolder = new Vector();
    private TextWatcher watcher = new C36212();

    /* renamed from: com.baidu.navi.adapter.DragSortListAdapter$2 */
    class C36212 implements TextWatcher {
        C36212() {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            int size = DragSortListAdapter.this.mViewHolder.size();
            for (int i = 0; i < size; i++) {
                Editable editable = ((ViewHolder) DragSortListAdapter.this.mViewHolder.get(i)).mEdit.getEditableText();
                if (editable != null && editable.equals(s)) {
                    ((ViewHolder) DragSortListAdapter.this.mViewHolder.get(i)).mItem.mName = s.toString();
                }
            }
        }
    }

    private class ViewHolder {
        public ImageView mDragIcon;
        public TextView mEdit;
        public RoutePlanNode mItem;
        public ProgressBar mProgressBar;
        public ImageView mSelectView;

        private ViewHolder() {
        }
    }

    public DragSortListAdapter(Context context, DragSortListener l, Vector<RoutePlanNode> list) {
        super(context, 0, list);
        this.mContext = context;
        this.mData = list;
        this.mDragSortListener = l;
        if (this.mData.size() == 0) {
            this.mData.add(new RoutePlanNode());
        }
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        LogUtil.m15791e("RoutePlan", "position:" + position);
        LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewHolder hold = new ViewHolder();
        View view = inflater.inflate(C0965R.layout.route_plan_node_item, null);
        hold.mSelectView = (ImageView) view.findViewById(C0965R.id.ic_input_delete);
        hold.mEdit = (TextView) view.findViewById(C0965R.id.tv_input);
        hold.mDragIcon = (ImageView) view.findViewById(C0965R.id.iv_drag);
        hold.mProgressBar = (ProgressBar) view.findViewById(C0965R.id.progress_anti_geo);
        hold.mItem = (RoutePlanNode) getItem(position);
        this.mViewHolder.add(hold);
        view.setTag(hold);
        view.setVisibility(0);
        hold.mDragIcon.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.route_plan_drag_list_icon_selector));
        hold.mSelectView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (DragSortListAdapter.this.mDragSortListener != null) {
                    DragSortListAdapter.this.mDragSortListener.onDeleteNode(position);
                }
            }
        });
        hold.mEdit.setTag(Integer.valueOf(position));
        if (position == 0) {
            hold.mEdit.setHint(C0965R.string.route_plan_start_point);
            hold.mEdit.setText(getRoutePlanNodeName((RoutePlanNode) this.mData.get(0)));
            if (!(hold.mSelectView == null || hold.mItem == null)) {
                hold.mSelectView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_rp_ic_start));
            }
        } else if (getCount() >= 2) {
            if (position == getCount() - 1) {
                if (hold.mSelectView != null) {
                    hold.mSelectView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_rp_ic_end));
                }
                hold.mEdit.setHint(this.mContext.getString(C0965R.string.route_plan_end_point));
            } else {
                if (hold.mSelectView != null) {
                    hold.mSelectView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_rp_ic_delete));
                    hold.mSelectView.setVisibility(0);
                }
                hold.mEdit.setHint(this.mContext.getString(C0965R.string.route_plan_via_point) + position);
            }
        }
        hold.mEdit.removeTextChangedListener(this.watcher);
        hold.mEdit.setText(getRoutePlanNodeName(hold.mItem));
        hold.mEdit.addTextChangedListener(this.watcher);
        if (!(hold.mProgressBar == null || hold.mItem == null)) {
            if (StringUtils.isEmpty(hold.mItem.mName) && hold.mItem.isNodeSettedData()) {
                hold.mProgressBar.setVisibility(0);
            } else {
                hold.mProgressBar.setVisibility(8);
            }
        }
        view.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.history_list_item_bg_selector));
        return view;
    }

    private String getRoutePlanNodeName(RoutePlanNode node) {
        String reStr = "";
        if (node == null) {
            return reStr;
        }
        if (node.isNodeSettedData()) {
            if (node.mFrom == 3) {
                if (StringUtils.isEmpty(node.mName)) {
                    reStr = this.mContext.getString(C0965R.string.route_plan_start_my_pos);
                } else {
                    reStr = this.mContext.getString(C0965R.string.route_plan_node_my_pos);
                }
            } else if (node.mFrom == 1 && StringUtils.isEmpty(node.mName)) {
                reStr = this.mContext.getString(C0965R.string.route_plan_map_point);
            } else {
                reStr = StringUtils.isEmpty(node.mName) ? this.mContext.getString(C0965R.string.navi_unknown_road) : node.mName;
            }
        }
        return reStr;
    }

    public void onExchange(int startPosition, int endPosition) {
        RoutePlanNode startObject = (RoutePlanNode) getItem(startPosition);
        RoutePlanNode endObject = (RoutePlanNode) getItem(endPosition);
        LogUtil.m15791e("ON", "startPostion ==== " + startPosition);
        LogUtil.m15791e("ON", "endPosition ==== " + endPosition);
        if (startPosition < endPosition) {
            this.mData.add(endPosition + 1, startObject);
            this.mData.remove(startPosition);
            this.mData.add(startPosition, endObject);
            this.mData.remove(endPosition);
            return;
        }
        this.mData.add(endPosition, startObject);
        this.mData.remove(startPosition + 1);
        this.mData.add(startPosition, endObject);
        this.mData.remove(endPosition + 1);
    }
}
