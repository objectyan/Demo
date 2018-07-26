package com.baidu.navi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.style.StyleManager;

public class CatalogItem extends LinearLayout {
    private Context mContext;
    private ImageView mImageView;
    private LayoutInflater mInflater;
    private LinearLayout mLayout = ((LinearLayout) this.mInflater.inflate(C0965R.layout.catalog_item, null));
    private TextView mTextView;

    public CatalogItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        addView(this.mLayout);
        this.mImageView = (ImageView) this.mLayout.findViewById(C0965R.id.image);
        this.mTextView = (TextView) this.mLayout.findViewById(C0965R.id.text);
        initAttributeSet(context, attrs);
    }

    private void initAttributeSet(Context context, AttributeSet attrs) {
        TypedArray typeArray = context.obtainStyledAttributes(attrs, C0965R.C0963p.CatalogItem);
        Drawable d = typeArray.getDrawable(0);
        if (d != null) {
            this.mLayout.setBackgroundDrawable(d);
        }
        d = typeArray.getDrawable(1);
        if (d != null) {
            this.mImageView.setImageDrawable(d);
        }
        int size = typeArray.getInteger(3, 0);
        if (size > 0) {
            this.mTextView.setTextSize((float) size);
        }
        TypedValue value = typeArray.peekValue(2);
        if (value != null) {
            if (value.type == 3) {
                this.mTextView.setText(typeArray.getString(2));
            } else if (value.type == 16) {
                this.mTextView.setText(typeArray.getInteger(2, 0));
            }
        }
        this.mTextView.setTextColor(typeArray.getColor(4, StyleManager.getColor(C0965R.color.bnav_rp_node_head_text_color)));
        this.mLayout.setLayoutParams(new LayoutParams((int) typeArray.getDimension(5, -1.0f), (int) typeArray.getDimension(6, -2.0f)));
        typeArray.recycle();
    }

    public void setOnClickListener(OnClickListener listener) {
        this.mLayout.setOnClickListener(listener);
    }

    public void setDayNightStyle(int rid) {
        this.mTextView.setTextColor(StyleManager.getColor(C0965R.color.bnav_rp_node_head_text_color));
        this.mImageView.setImageDrawable(StyleManager.getDrawable(rid));
        this.mLayout.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.carmode_common_button_selector));
    }

    public void setDayNightStyle() {
        this.mTextView.setTextColor(StyleManager.getColor(C0965R.color.bnav_rp_node_head_text_color));
        this.mLayout.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.carmode_common_button_selector));
    }

    public LinearLayout getLayout() {
        return this.mLayout;
    }
}
