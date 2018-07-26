package com.baidu.navisdk.util.jar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.Interpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.adapter.impl.BaiduNaviSDKStub;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.SDKDebugFileUtil.CoreLogModule;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.PreferenceHelperConst;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.drivertool.BNDrivingToolParams;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class JarUtils {
    private static int activityHasCode = 0;
    private static Field activityThemeField = null;
    private static String checkSoSizeName = "libapp_BaiduNaviApplib.so";
    private static Field contextResourcesField = null;
    private static Field contextThemeField = null;
    private static String jarDir = (SysOSAPI.getInstance().getSDcardRootPath() + "/");
    private static String jarName = (jarNamePrefix + jarVersion + jarNameSuffix);
    private static String jarNameOrigin = (jarNamePrefix + jarVersion + jarNameSuffixOrigin);
    private static String jarNamePrefix = "BaiduNaviSDK_Resource_";
    private static String jarNameSuffix = ".jar";
    private static String jarNameSuffixOrigin = BNDrivingToolParams.RESOURCE_PICTURE_SUFFIX;
    private static String jarPath = (jarDir + jarName);
    private static String jarVersion = "1.0";
    private static boolean mAsJar = false;
    private static Activity mProxyActivity = null;
    private static Resources oldResources = null;
    private static Theme oldTheme = null;
    private static Activity outsideActivity = null;
    private static AssetManager selfAsset = null;
    private static Resources selfResources = null;
    private static Theme selfTheme = null;

    static class OldResourceFileFilter implements FilenameFilter {
        OldResourceFileFilter() {
        }

        public boolean accept(File dir, String filename) {
            String suffix = JarUtils.jarVersion + JarUtils.jarNameSuffix;
            if (!filename.startsWith(JarUtils.jarNamePrefix) || filename.endsWith(suffix)) {
                return false;
            }
            return true;
        }
    }

    public static boolean initalClassLoader() {
        ClassLoader prePreClassLoader = null;
        ClassLoader preClassLoader = null;
        for (ClassLoader curClassLoader = BaiduNaviSDKStub.dexClassLoader; curClassLoader != null; curClassLoader = getParentClassLoader(curClassLoader)) {
            prePreClassLoader = preClassLoader;
            preClassLoader = curClassLoader;
        }
        if (preClassLoader == null || prePreClassLoader == null) {
            return false;
        }
        boolean ret = alterParClaLoader(prePreClassLoader, BaiduNaviSDKStub.dexClassLoader);
        if (alterParClaLoader(BaiduNaviSDKStub.dexClassLoader, preClassLoader) && ret) {
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }

    public static ClassLoader getParentClassLoader(ClassLoader sourceClaLoader) {
        Class mClass = sourceClaLoader.getClass();
        while (mClass != null && !mClass.getName().endsWith(".ClassLoader")) {
            mClass = mClass.getSuperclass();
        }
        if (mClass == null) {
            return null;
        }
        try {
            Field field1 = mClass.getDeclaredField("parent");
            field1.setAccessible(true);
            return (ClassLoader) field1.get(sourceClaLoader);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.m15791e("getParentClassLoader() error:", e.toString());
            return null;
        }
    }

    private static boolean alterParClaLoader(ClassLoader sourceClaLoader, ClassLoader parClaLoader) {
        Class mClass = sourceClaLoader.getClass();
        while (mClass != null && !mClass.getName().endsWith(".ClassLoader")) {
            mClass = mClass.getSuperclass();
        }
        if (mClass == null) {
            return true;
        }
        try {
            Field field1 = mClass.getDeclaredField("parent");
            field1.setAccessible(true);
            ClassLoader a = (ClassLoader) field1.get(sourceClaLoader);
            field1.set(sourceClaLoader, parClaLoader);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.m15791e("mytest1-1", e.toString());
            return false;
        }
    }

    public static AssetManager getSDKAssetManager() {
        if (jarPath != null) {
            return getSelfAssets(jarPath);
        }
        return null;
    }

    private static boolean isNaviApplibSoSizeChange(Context ctx) {
        try {
            Long preSoSize = Long.valueOf(PreferenceHelper.getInstance(ctx).getLong(PreferenceHelperConst.SP_LAST_NAVIAPPLIBSO_SIZE, 0));
            String soPath = getSoPath(ctx);
            if (soPath == null) {
                return false;
            }
            File file = new File(soPath);
            if (file == null || !file.exists()) {
                return false;
            }
            Long curSoSize = Long.valueOf(file.length());
            LogUtil.m15791e("JarUtils_preSoSize", preSoSize + "");
            LogUtil.m15791e("JarUtils_curSoSize", curSoSize + "");
            if (preSoSize == curSoSize) {
                return true;
            }
            PreferenceHelper.getInstance(ctx).putLong(PreferenceHelperConst.SP_LAST_NAVIAPPLIBSO_SIZE, curSoSize.longValue());
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private static String getSoPath(Context ctx) {
        String soDirPath;
        String dirPath = ctx.getFilesDir().getAbsolutePath();
        if (dirPath != null) {
            int index = dirPath.lastIndexOf("/");
            if (index >= 0) {
                soDirPath = dirPath.substring(0, index) + "/lib";
            } else {
                soDirPath = "/data/data/" + ctx.getPackageName() + "/lib";
            }
        } else {
            soDirPath = "/data/data/" + ctx.getPackageName() + "/lib";
        }
        return soDirPath + "/" + checkSoSizeName;
    }

    private static boolean copyJarToSD(Context ctx) {
        initJarPath(ctx);
        try {
            InputStream is = ctx.getResources().getAssets().open(jarNameOrigin);
            File file = new File(jarPath);
            long fileLen = file.length();
            int assetLen = is.available();
            if (!isNaviApplibSoSizeChange(ctx) && file.exists() && fileLen == ((long) assetLen)) {
                is.close();
                return true;
            }
            clearOldVersion();
            OutputStream os = new FileOutputStream(new File(jarDir, jarName));
            byte[] buf = new byte[1024];
            while (true) {
                int len = is.read(buf);
                if (len > 0) {
                    os.write(buf, 0, len);
                } else {
                    is.close();
                    os.close();
                    return true;
                }
            }
        } catch (Exception e) {
            LogUtil.m15791e("", e.toString());
            return false;
        }
    }

    private static void clearOldVersion() {
        File[] files = new File(jarDir).listFiles(new OldResourceFileFilter());
        if (files != null && files.length > 0) {
            for (File f : files) {
                f.delete();
            }
        }
    }

    private static void initJarPath(Context ctx) {
        jarDir = ctx.getFilesDir().getAbsolutePath();
        jarPath = jarDir + "/" + jarName;
    }

    public static String getJarName() {
        return jarNameOrigin;
    }

    private static AssetManager getSelfAssets(String apkPath) {
        AssetManager instance = null;
        try {
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            instance = (AssetManager) cls.getConstructor((Class[]) null).newInstance((Object[]) null);
            cls.getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(instance, new Object[]{apkPath});
            return instance;
        } catch (Throwable e) {
            LogUtil.m15791e("", e.toString());
            return instance;
        }
    }

    private static Resources getSelfRes(Context ctx, AssetManager selfAsset) {
        DisplayMetrics metrics = new DisplayMetrics();
        metrics.setToDefaults();
        return new Resources(selfAsset, metrics, ctx.getResources().getConfiguration());
    }

    private static Theme getSelfTheme() {
        if (selfTheme == null) {
            if (selfAsset == null) {
                selfAsset = getSelfAssets(jarPath);
            }
            if (selfResources == null) {
                selfResources = getSelfRes(outsideActivity, selfAsset);
            }
            selfTheme = selfResources.newTheme();
            selfTheme.applyStyle(getInnerRIdValue("com.android.internal.R.style.Theme"), true);
        }
        return selfTheme;
    }

    public static int getInnerRIdValue(String rStrnig) {
        int value = -1;
        if (rStrnig != null) {
            try {
                if (rStrnig.length() > 0) {
                    String Rpath = rStrnig.substring(0, rStrnig.indexOf(".R.") + 2);
                    int fieldIndex = rStrnig.lastIndexOf(".");
                    String fieldName = rStrnig.substring(fieldIndex + 1, rStrnig.length());
                    rStrnig = rStrnig.substring(0, fieldIndex);
                    value = Class.forName(Rpath + "$" + rStrnig.substring(rStrnig.lastIndexOf(".") + 1, rStrnig.length())).getDeclaredField(fieldName).getInt(null);
                }
            } catch (Throwable e) {
                LogUtil.m15791e("", e.toString());
            }
        }
        return value;
    }

    private static Field getActivityThemeField() {
        try {
            activityThemeField = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mTheme");
            activityThemeField.setAccessible(true);
        } catch (Throwable e) {
            LogUtil.m15791e("", e.toString());
        }
        return activityThemeField;
    }

    private static Field getContextThemeField() {
        try {
            contextThemeField = Class.forName("android.app.ContextImpl").getDeclaredField("mTheme");
            contextThemeField.setAccessible(true);
        } catch (Throwable e) {
            LogUtil.m15791e("", e.toString());
        }
        return contextThemeField;
    }

    public static void setDialogThemeField(Dialog dialog, Theme newTheme) {
        try {
            Field fd = Class.forName("android.app.Dialog").getDeclaredField("mContext");
            fd.setAccessible(true);
            ContextThemeWrapper ctw = (ContextThemeWrapper) fd.get(dialog);
            fd = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mTheme");
            fd.setAccessible(true);
            fd.set(ctw, newTheme);
        } catch (Throwable e) {
            LogUtil.m15791e("", e.toString());
        }
    }

    private static Field getContextResourcesField() {
        try {
            contextResourcesField = Class.forName("android.app.ContextImpl").getDeclaredField("mResources");
            contextResourcesField.setAccessible(true);
        } catch (Throwable e) {
            LogUtil.m15791e("", e.toString());
        }
        return contextResourcesField;
    }

    public static boolean switchToJarResourcesAndTheme(Activity activity) {
        if (oldResources != null) {
            return false;
        }
        try {
            if (activityThemeField == null) {
                activityThemeField = getActivityThemeField();
            }
            if (contextResourcesField == null) {
                contextResourcesField = getContextResourcesField();
            }
            if (selfTheme == null) {
                selfTheme = getSelfTheme();
            }
            Context context = activity.getBaseContext();
            oldResources = (Resources) contextResourcesField.get(context);
            oldTheme = (Theme) activityThemeField.get(activity);
            contextResourcesField.set(context, selfResources);
            activityThemeField.set(activity, selfTheme);
            return true;
        } catch (Throwable t) {
            LogUtil.m15791e("", t.toString());
            return false;
        }
    }

    public static void switchToOriginResourceAndTheme(Activity activity) {
        if (oldResources != null) {
            try {
                contextResourcesField.set(activity.getBaseContext(), oldResources);
                activityThemeField.set(activity, oldTheme);
            } catch (Throwable t) {
                LogUtil.m15791e("", t.toString());
            } finally {
                oldResources = null;
            }
        }
    }

    public static void switchToJarResources(ContextWrapper contextWrapper) {
        try {
            if (contextResourcesField == null) {
                contextResourcesField = getContextResourcesField();
            }
            if (contextThemeField == null) {
                contextThemeField = getContextThemeField();
            }
            if (selfTheme == null) {
                selfTheme = getSelfTheme();
            }
            Context context = contextWrapper.getBaseContext();
            oldResources = (Resources) contextResourcesField.get(context);
            oldTheme = (Theme) contextThemeField.get(context);
            contextResourcesField.set(context, selfResources);
            contextThemeField.set(context, selfTheme);
        } catch (Throwable t) {
            LogUtil.m15791e("", t.toString());
        }
    }

    public static void switchToOriginResource(ContextWrapper activity) {
        try {
            Context context = activity.getBaseContext();
            contextResourcesField.set(context, oldResources);
            contextThemeField.set(context, oldTheme);
        } catch (Throwable t) {
            LogUtil.m15791e("", t.toString());
        }
    }

    public static boolean setAsJar(Context context) {
        if (!copyJarToSD(context)) {
            return false;
        }
        mAsJar = true;
        selfAsset = getSelfAssets(jarPath);
        selfResources = getSelfRes(context, selfAsset);
        BNStyleManager.setResource(selfResources);
        ProxyActivity.setAssetManager(selfAsset);
        ProxyActivity.setResource(selfResources);
        ProxyActivity.setResourcesTheme(getSelfTheme());
        return true;
    }

    public static boolean getAsJar() {
        return mAsJar;
    }

    public static Resources getResources() {
        if (selfResources == null && BNaviModuleManager.getContext() != null) {
            selfResources = BNaviModuleManager.getContext().getResources();
        }
        return selfResources;
    }

    public static View oldInflate(Activity activity, int resource, ViewGroup root) {
        View view = null;
        try {
            if (!mAsJar) {
                return LayoutInflater.from(activity).inflate(selfResources.getXml(resource), root);
            }
        } catch (Throwable e) {
            LogUtil.m15791e("", e.toString());
        }
        XmlResourceParser parser = null;
        try {
            parser = selfResources.getXml(resource);
            boolean ret = switchToJarResourcesAndTheme(activity);
            view = LayoutInflater.from(activity).inflate(parser, root);
            if (ret) {
                switchToOriginResourceAndTheme(activity);
            }
            if (parser != null) {
                parser.close();
            }
        } catch (Throwable th) {
            if (parser != null) {
                parser.close();
            }
        }
        return view;
    }

    public static View inflate(Activity activity, int resource, ViewGroup root) {
        if (activity == null) {
            return null;
        }
        if (!(activity instanceof ProxyActivity)) {
            initProxyActivity(activity);
        }
        View view = null;
        try {
            return LayoutInflater.from(activity).cloneInContext(mProxyActivity).inflate(selfResources.getXml(resource), root);
        } catch (Throwable e) {
            e.printStackTrace();
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, "Jarutil inflate Throwable:" + e.getCause());
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, "Jarutil inflate Throwable:" + e.getMessage());
            return view;
        }
    }

    private static void initProxyActivity(Activity activity) {
        if (mProxyActivity != null) {
            if (activity.hashCode() != activityHasCode) {
                ((ProxyActivity) mProxyActivity).destory();
                mProxyActivity = null;
            } else {
                return;
            }
        }
        activityHasCode = activity.hashCode();
        mProxyActivity = new ProxyActivity(activity);
    }

    public static void uninitProxyActivity() {
        if (mProxyActivity != null) {
            ((ProxyActivity) mProxyActivity).destory();
            mProxyActivity = null;
        }
        activityHasCode = 0;
    }

    public static long currentAnimationTimeMillis() {
        return SystemClock.uptimeMillis();
    }

    public static Animation loadAnimation(Context context, int id) throws NotFoundException {
        NotFoundException rnf;
        XmlResourceParser parser = null;
        try {
            parser = getResources().getAnimation(id);
            Animation createAnimationFromXml = createAnimationFromXml(context, parser);
            if (parser != null) {
                parser.close();
            }
            return createAnimationFromXml;
        } catch (XmlPullParserException ex) {
            rnf = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex2) {
            rnf = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(ex2);
            throw rnf;
        } catch (Throwable th) {
            if (parser != null) {
                parser.close();
            }
        }
    }

    private static Animation createAnimationFromXml(Context c, XmlPullParser parser) throws XmlPullParserException, IOException {
        return createAnimationFromXml(c, parser, null, Xml.asAttributeSet(parser));
    }

    private static Animation createAnimationFromXml(Context c, XmlPullParser parser, AnimationSet parent, AttributeSet attrs) throws XmlPullParserException, IOException {
        Animation anim = null;
        int depth = parser.getDepth();
        while (true) {
            int type = parser.next();
            if ((type != 3 || parser.getDepth() > depth) && type != 1) {
                if (type == 2) {
                    String name = parser.getName();
                    if (name.equals(C2848p.af)) {
                        anim = new AnimationSet(c, attrs);
                        createAnimationFromXml(c, parser, (AnimationSet) anim, attrs);
                    } else if (name.equals("alpha")) {
                        anim = new AlphaAnimation(c, attrs);
                    } else if (name.equals("scale")) {
                        anim = new ScaleAnimation(c, attrs);
                    } else if (name.equals("rotate")) {
                        anim = new RotateAnimation(c, attrs);
                    } else if (name.equals("translate")) {
                        anim = new TranslateAnimation(c, attrs);
                    } else {
                        throw new RuntimeException("Unknown animation name: " + parser.getName());
                    }
                    if (parent != null) {
                        parent.addAnimation(anim);
                    }
                }
            }
        }
        return anim;
    }

    public static LayoutAnimationController loadLayoutAnimation(Context context, int id) throws NotFoundException {
        NotFoundException rnf;
        XmlResourceParser parser = null;
        try {
            parser = getResources().getAnimation(id);
            LayoutAnimationController createLayoutAnimationFromXml = createLayoutAnimationFromXml(context, parser);
            if (parser != null) {
                parser.close();
            }
            return createLayoutAnimationFromXml;
        } catch (XmlPullParserException ex) {
            rnf = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex2) {
            rnf = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(ex2);
            throw rnf;
        } catch (Throwable th) {
            if (parser != null) {
                parser.close();
            }
        }
    }

    private static LayoutAnimationController createLayoutAnimationFromXml(Context c, XmlPullParser parser) throws XmlPullParserException, IOException {
        return createLayoutAnimationFromXml(c, parser, Xml.asAttributeSet(parser));
    }

    private static LayoutAnimationController createLayoutAnimationFromXml(Context c, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        LayoutAnimationController controller = null;
        int depth = parser.getDepth();
        while (true) {
            int type = parser.next();
            if ((type != 3 || parser.getDepth() > depth) && type != 1) {
                if (type == 2) {
                    String name = parser.getName();
                    if ("layoutAnimation".equals(name)) {
                        controller = new LayoutAnimationController(c, attrs);
                    } else if ("gridLayoutAnimation".equals(name)) {
                        controller = new GridLayoutAnimationController(c, attrs);
                    } else {
                        throw new RuntimeException("Unknown layout animation name: " + name);
                    }
                }
            }
        }
        return controller;
    }

    public static Interpolator loadInterpolator(Context context, int id) throws NotFoundException {
        NotFoundException rnf;
        XmlResourceParser parser = null;
        try {
            parser = getResources().getAnimation(id);
            Interpolator createInterpolatorFromXml = createInterpolatorFromXml(context, parser);
            if (parser != null) {
                parser.close();
            }
            return createInterpolatorFromXml;
        } catch (XmlPullParserException ex) {
            rnf = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex2) {
            rnf = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(ex2);
            throw rnf;
        } catch (Throwable th) {
            if (parser != null) {
                parser.close();
            }
        }
    }

    private static Interpolator createInterpolatorFromXml(Context c, XmlPullParser parser) throws XmlPullParserException, IOException {
        Interpolator interpolator = null;
        int depth = parser.getDepth();
        while (true) {
            int type = parser.next();
            if ((type != 3 || parser.getDepth() > depth) && type != 1) {
                if (type == 2) {
                    AttributeSet attrs = Xml.asAttributeSet(parser);
                    String name = parser.getName();
                    if (name.equals("linearInterpolator")) {
                        interpolator = new LinearInterpolator(c, attrs);
                    } else if (name.equals("accelerateInterpolator")) {
                        interpolator = new AccelerateInterpolator(c, attrs);
                    } else if (name.equals("decelerateInterpolator")) {
                        interpolator = new DecelerateInterpolator(c, attrs);
                    } else if (name.equals("accelerateDecelerateInterpolator")) {
                        interpolator = new AccelerateDecelerateInterpolator(c, attrs);
                    } else if (name.equals("cycleInterpolator")) {
                        interpolator = new CycleInterpolator(c, attrs);
                    } else if (name.equals("anticipateInterpolator")) {
                        interpolator = new AnticipateInterpolator(c, attrs);
                    } else if (name.equals("overshootInterpolator")) {
                        interpolator = new OvershootInterpolator(c, attrs);
                    } else if (name.equals("anticipateOvershootInterpolator")) {
                        interpolator = new AnticipateOvershootInterpolator(c, attrs);
                    } else if (name.equals("bounceInterpolator")) {
                        interpolator = new BounceInterpolator(c, attrs);
                    } else {
                        throw new RuntimeException("Unknown interpolator name: " + parser.getName());
                    }
                }
            }
        }
        return interpolator;
    }
}
