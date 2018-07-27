package me.objectyan.screensharing.core.screen.presentation;

import android.content.Context;
import android.view.Display;

import me.objectyan.screensharing.core.screen.OnSurfaceListener;


public class CarlifeFakePresentation extends AbsCarlifeFakePresentation {
    public CarlifeFakePresentation(Context outerContext, Display display, OnSurfaceListener listener) {
        super(outerContext, display, listener);
    }
}
