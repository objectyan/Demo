package com.baidu.navisdk.ui.routeguide.toolbox.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;

public interface IRGToolBoxView {
    void closeToolBox();

    void closeToolBox(boolean z);

    void hideToolBox();

    View inflate();

    void onDestroy();

    void onOrientationChange(ViewGroup viewGroup, int i);

    void openToolBox();

    void setCurStateTips(String str);

    void showToolBox();

    void switchToolBarMode(int i);

    void updateArriveTime(String str);

    void updateRemainTimeAndDist(String str);

    void updateStyle(boolean z);

    void updateSubListener(OnRGSubViewListener onRGSubViewListener);
}
