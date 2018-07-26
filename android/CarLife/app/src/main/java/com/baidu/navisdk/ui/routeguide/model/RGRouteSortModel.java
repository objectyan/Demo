package com.baidu.navisdk.ui.routeguide.model;

public class RGRouteSortModel {
    public String mItemName = null;
    public int mPreferValue = 0;

    public RGRouteSortModel(String itemName, int preferValue) {
        this.mItemName = itemName;
        this.mPreferValue = preferValue;
    }

    public void reset() {
        this.mItemName = null;
        this.mPreferValue = 0;
    }
}
