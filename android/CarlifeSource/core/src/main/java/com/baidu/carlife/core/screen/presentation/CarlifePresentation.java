package com.baidu.carlife.core.screen.presentation;

import android.view.Display;
import android.view.Window;

import com.baidu.carlife.core.screen.presentation.view.CarlifeViewContainer;

/* compiled from: CarlifePresentation */
/* renamed from: com.baidu.carlife.core.screen.presentation.e */
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

    /* renamed from: a */
    public AbsCarlifeWindowCallback mo1452a(Window window) {
        return new CarlifeWindowCallback(window);
    }
}
