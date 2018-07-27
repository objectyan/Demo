package me.objectyan.screensharing.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class CarLifeSettings  {

    private static final String f3165a;

    private static final String f3166b;

    private static final String f3167c = "isFristHelpInVoice";

    private static CarLifeSettings f3168n = new CarLifeSettings();

    private boolean f3169d;

    private boolean f3170e;

    private boolean f3171f;

    private int f3172g;

    private boolean f3173h;

    private boolean f3174i;

    private boolean f3175j;

    private boolean f3176k;

    private boolean f3177l;

    private SharedPreferences f3178m;

    static {
        StringBuilder append = new StringBuilder().append("hadGuide_v");
        CarlifeUtil.newInstance();
        f3165a = append.append(CarlifeUtil.getVersionCode()).toString();
        append = new StringBuilder().append("hadAgreeDisclaimer");
        CarlifeUtil.newInstance();
        f3166b = append.append(CarlifeUtil.getVersionCode()).toString();
    }


    public static CarLifeSettings m4069a() {
        return f3168n;
    }

    private CarLifeSettings() {
        this.f3169d = false;
        this.f3170e = false;
        this.f3171f = true;
        this.f3173h = false;
        this.f3174i = false;
        this.f3175j = false;
        this.f3176k = false;
        this.f3177l = false;
        this.f3178m = null;
        this.f3178m = AppContext.getAppContext().getSharedPreferences(CommonParams.CAR_LIFE_TEMP, 0);
        m4072n();
    }


    private void m4072n() {
    }


    private void m4070a(Editor editor) {
        m4071a(editor, false);
    }


    private void m4071a(Editor editor, boolean sync) {
        if (sync) {
            editor.commit();
        } else {
            editor.apply();
        }
    }


    public boolean m4076b() {
        return this.f3178m.getBoolean(f3165a, true);
    }


    public void m4074a(boolean status) {
        Editor editor = this.f3178m.edit();
        editor.putBoolean(f3165a, status);
        m4070a(editor);
    }


    public boolean m4078c() {
        return this.f3178m.getBoolean(f3166b, false);
    }


    public void m4075b(boolean status) {
        Editor editor = this.f3178m.edit();
        editor.putBoolean(f3166b, status);
        m4070a(editor);
    }


    public boolean m4080d() {
        return this.f3169d;
    }


    public void m4077c(boolean engineInitFinish) {
        this.f3169d = engineInitFinish;
    }


    public boolean m4082e() {
        return this.f3170e;
    }


    public void m4079d(boolean mLaunchInit) {
        this.f3170e = mLaunchInit;
    }


    public boolean m4084f() {
        return this.f3171f;
    }


    public int m4085g() {
        return this.f3172g;
    }


    public void m4073a(int mOrientation) {
        this.f3172g = mOrientation;
    }


    public boolean m4088h() {
        return this.f3174i;
    }


    public void m4081e(boolean isCoverSupport) {
        this.f3174i = isCoverSupport;
    }


    public boolean m4090i() {
        return this.f3175j;
    }


    public void m4083f(boolean lastCoverState) {
        this.f3175j = lastCoverState;
    }


    public boolean m4092j() {
        return this.f3178m.getBoolean("isFristHelpInVoice", true);
    }


    public void m4086g(boolean status) {
        Editor editor = this.f3178m.edit();
        editor.putBoolean("isFristHelpInVoice", status);
        m4070a(editor);
    }


    public boolean m4093k() {
        return this.f3173h;
    }


    public void m4087h(boolean flag) {
        this.f3173h = flag;
    }


    public boolean m4094l() {
        return this.f3176k;
    }


    public void m4089i(boolean surfaceCreatedDone) {
        this.f3176k = surfaceCreatedDone;
    }


    public boolean m4095m() {
        return this.f3177l;
    }


    public void m4091j(boolean isForeground) {
        this.f3177l = isForeground;
    }
}
