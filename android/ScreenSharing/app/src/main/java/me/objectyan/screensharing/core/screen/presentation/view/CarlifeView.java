package me.objectyan.screensharing.core.screen.presentation.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import me.objectyan.screensharing.core.screen.OnDialogListener;
import me.objectyan.screensharing.core.screen.OnHintChangeListener;
import me.objectyan.screensharing.core.screen.OnLightnessCoverListener;
import me.objectyan.screensharing.core.screen.OnProgressDialogListener;
import me.objectyan.screensharing.core.screen.OnUIListener;
import me.objectyan.screensharing.core.screen.OnWindowManagerViewListener;


public abstract class CarlifeView implements OnDialogListener, OnHintChangeListener, OnLightnessCoverListener, OnProgressDialogListener, OnUIListener, OnWindowManagerViewListener {

    protected View mView;

    protected Context mContext;


    public abstract Context mo1482e();


    public abstract void mo1483f();

    public CarlifeView(Context context, int rId) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(rId, null);
    }


    public View m4695g() {
        return this.mView;
    }


    public void mo1484h() {
    }


    public boolean m4697i() {
        return true;
    }


    public boolean mo1489j() {
        return true;
    }
}
