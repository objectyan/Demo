package com.baidu.navisdk.ui.routeguide.subview.util;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ShowDebugTextManager {
    private static final int MaxNum = 20;
    private static Object mSyncObj = new Object();
    private static ShowDebugTextManager sInstance = null;
    private LinearLayout mDebugLayout;
    private ArrayList<String> mDebugText;
    private TextView mDebugTextView;
    private SimpleDateFormat mLiteSDF;
    private SimpleDateFormat mSDF;

    private ShowDebugTextManager() {
        this.mDebugLayout = null;
        this.mDebugTextView = null;
        this.mDebugText = new ArrayList();
        this.mSDF = null;
        this.mLiteSDF = null;
        this.mSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.mLiteSDF = new SimpleDateFormat("HH:mm:ss");
    }

    public static ShowDebugTextManager getInstance() {
        if (sInstance == null) {
            synchronized (mSyncObj) {
                if (sInstance == null) {
                    sInstance = new ShowDebugTextManager();
                }
            }
        }
        return sInstance;
    }

    public void addLiteDebugText(String debugText) {
        printText(this.mLiteSDF.format(new Date()) + " # " + debugText);
    }

    public void addDebugText(String debugText) {
        printText(this.mSDF.format(new Date()) + " ### " + debugText);
    }

    private void printText(String printText) {
        this.mDebugLayout = RGMapModeViewController.getInstance().getDebugLinearLayout();
        this.mDebugTextView = RGMapModeViewController.getInstance().getDebugText();
        if (this.mDebugLayout != null && this.mDebugTextView != null) {
            if (this.mDebugText != null && this.mDebugText.size() < 20) {
                this.mDebugText.add(0, printText);
            } else if (this.mDebugText != null && this.mDebugText.size() >= 20) {
                this.mDebugText.remove(this.mDebugText.size() - 1);
                this.mDebugText.add(0, printText);
            }
            String text = "";
            if (this.mDebugText != null) {
                for (int i = 0; i < this.mDebugText.size(); i++) {
                    text = text + "\n" + ((String) this.mDebugText.get(i));
                }
            }
            this.mDebugLayout.setVisibility(0);
            this.mDebugTextView.setText(text);
        }
    }
}
