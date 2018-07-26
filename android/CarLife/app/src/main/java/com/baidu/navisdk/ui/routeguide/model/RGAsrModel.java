package com.baidu.navisdk.ui.routeguide.model;

public class RGAsrModel {
    private static RGAsrModel mInstance = null;
    private boolean isUserDismissed = false;
    private String mDefaultAsrContent = null;

    public static RGAsrModel getInstance() {
        if (mInstance == null) {
            mInstance = new RGAsrModel();
        }
        return mInstance;
    }

    public String getmDefaultAsrContent() {
        return this.mDefaultAsrContent;
    }

    public void setmDefaultAsrContent(String mDefaultAsrContent) {
        this.mDefaultAsrContent = mDefaultAsrContent;
    }

    public boolean isUserDismissed() {
        return this.isUserDismissed;
    }

    public void setUserDismissed(boolean isUserDismissed) {
        this.isUserDismissed = isUserDismissed;
    }
}
