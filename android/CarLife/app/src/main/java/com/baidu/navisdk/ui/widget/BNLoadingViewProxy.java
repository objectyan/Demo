package com.baidu.navisdk.ui.widget;

import android.view.View;
import android.view.ViewGroup;

public class BNLoadingViewProxy {

    public interface ViewActionListener {
        public static final int ACTION_RETRY = 1;

        void onAction(int i);
    }

    public interface LoadingProxy {
        public static final int LOADING_TYPE_DEFAULT = 1;
        public static final int LOADING_TYPE_DIALOG = 2;

        View getLoadingView();

        void onLoadingEnd(int i, boolean z, ViewGroup viewGroup, ViewActionListener viewActionListener);

        void onLoadingStart(int i, ViewGroup viewGroup);
    }
}
