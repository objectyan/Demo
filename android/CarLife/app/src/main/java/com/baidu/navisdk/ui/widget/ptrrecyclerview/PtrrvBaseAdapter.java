package com.baidu.navisdk.ui.widget.ptrrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

public class PtrrvBaseAdapter<VH extends ViewHolder> extends Adapter<VH> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_HISVIDEO = 1;
    public static final int TYPE_MESSAGE = 2;
    protected Context mContext = null;
    protected int mCount = 0;

    public PtrrvBaseAdapter(Context context) {
        this.mContext = context;
    }

    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    public void onBindViewHolder(VH vh, int position) {
    }

    public int getItemCount() {
        return this.mCount;
    }

    public Object getItem(int position) {
        return null;
    }
}
