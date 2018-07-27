package me.objectyan.screensharing.core.screen.presentation.view;

public interface APPVoiceFuncCallback {
    boolean changeLocationMode(int i);

    boolean exitAPP();

    int getPageType();

    boolean goHome();

    boolean goOffice();

    boolean limitLine();

    String myLoc();

    boolean nameSearch(String str);

    boolean onFullview();

    boolean onOtherVoiceFunc(int i, int i2, int i3, int i4);

    void poiDataNotNew();

    void showVoiceHelp();

    boolean spaceSearch(String str);

    boolean switchDayNightMode(int i);

    boolean washCar();

    boolean weather();
}
