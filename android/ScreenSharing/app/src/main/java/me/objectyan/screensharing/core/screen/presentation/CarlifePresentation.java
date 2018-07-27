package me.objectyan.screensharing.core.screen.presentation;

import android.view.Display;
import android.view.Window;

import me.objectyan.screensharing.core.screen.presentation.view.CarlifeViewContainer;


public class CarlifePresentation extends AbsCarlifePresentation {
    public CarlifePresentation(AbsCarlifeActivityService outerContext, Display display) {
        super(outerContext, outerContext, display);
    }

    public void show() {
        super.show();
        if (CarlifeViewContainer.newInstance().getCarlifeView() != null) {
            CarlifeViewContainer.newInstance().getCarlifeView().mo1484h();
        }
    }


    public AbsCarlifeWindowCallback mo1452a(Window window) {
        return new CarlifeWindowCallback(window);
    }
}
