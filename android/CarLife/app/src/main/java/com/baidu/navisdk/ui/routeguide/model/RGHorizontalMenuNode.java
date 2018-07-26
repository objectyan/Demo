package com.baidu.navisdk.ui.routeguide.model;

public class RGHorizontalMenuNode {
    public String mButtonName;
    public boolean mIsTopShow;
    public String mMenuName;
    public int mResId;

    public RGHorizontalMenuNode(String name, int resId, boolean b, String btnName) {
        this.mMenuName = name;
        this.mResId = resId;
        this.mIsTopShow = b;
        this.mButtonName = btnName;
    }
}
