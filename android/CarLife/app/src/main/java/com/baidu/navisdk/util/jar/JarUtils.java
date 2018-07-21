package com.baidu.navisdk.util.jar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
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
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.adapter.impl.BaiduNaviSDKStub;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class JarUtils
{
  private static int activityHasCode = 0;
  private static Field activityThemeField;
  private static String checkSoSizeName;
  private static Field contextResourcesField;
  private static Field contextThemeField;
  private static String jarDir;
  private static String jarName;
  private static String jarNameOrigin;
  private static String jarNamePrefix;
  private static String jarNameSuffix;
  private static String jarNameSuffixOrigin;
  private static String jarPath;
  private static String jarVersion;
  private static boolean mAsJar;
  private static Activity mProxyActivity;
  private static Resources oldResources;
  private static Resources.Theme oldTheme;
  private static Activity outsideActivity;
  private static AssetManager selfAsset = null;
  private static Resources selfResources = null;
  private static Resources.Theme selfTheme;
  
  static
  {
    oldResources = null;
    selfTheme = null;
    oldTheme = null;
    activityThemeField = null;
    contextThemeField = null;
    contextResourcesField = null;
    outsideActivity = null;
    mAsJar = false;
    jarNamePrefix = "BaiduNaviSDK_Resource_";
    jarVersion = "1.0";
    jarNameSuffixOrigin = ".png";
    jarNameSuffix = ".jar";
    jarName = jarNamePrefix + jarVersion + jarNameSuffix;
    jarNameOrigin = jarNamePrefix + jarVersion + jarNameSuffixOrigin;
    jarDir = SysOSAPI.getInstance().getSDcardRootPath() + "/";
    jarPath = jarDir + jarName;
    checkSoSizeName = "libapp_BaiduNaviApplib.so";
    mProxyActivity = null;
  }
  
  private static boolean alterParClaLoader(ClassLoader paramClassLoader1, ClassLoader paramClassLoader2)
  {
    for (Object localObject = paramClassLoader1.getClass();; localObject = ((Class)localObject).getSuperclass())
    {
      if (((localObject != null) && (!((Class)localObject).getName().endsWith(".ClassLoader"))) || (localObject != null)) {}
      try
      {
        localObject = ((Class)localObject).getDeclaredField("parent");
        ((Field)localObject).setAccessible(true);
        ClassLoader localClassLoader = (ClassLoader)((Field)localObject).get(paramClassLoader1);
        ((Field)localObject).set(paramClassLoader1, paramClassLoader2);
        return true;
      }
      catch (Exception paramClassLoader1)
      {
        paramClassLoader1.printStackTrace();
        LogUtil.e("mytest1-1", paramClassLoader1.toString());
      }
    }
    return false;
  }
  
  private static void clearOldVersion()
  {
    File[] arrayOfFile = new File(jarDir).listFiles(new OldResourceFileFilter());
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  private static boolean copyJarToSD(Context paramContext)
  {
    initJarPath(paramContext);
    try
    {
      InputStream localInputStream = paramContext.getResources().getAssets().open(jarNameOrigin);
      Object localObject = new File(jarPath);
      long l = ((File)localObject).length();
      int i = localInputStream.available();
      if ((!isNaviApplibSoSizeChange(paramContext)) && (((File)localObject).exists()) && (l == i))
      {
        localInputStream.close();
        return true;
      }
      clearOldVersion();
      paramContext = new FileOutputStream(new File(jarDir, jarName));
      localObject = new byte['Ѐ'];
      for (;;)
      {
        i = localInputStream.read((byte[])localObject);
        if (i <= 0) {
          break;
        }
        paramContext.write((byte[])localObject, 0, i);
      }
      localInputStream.close();
    }
    catch (Exception paramContext)
    {
      LogUtil.e("", paramContext.toString());
      return false;
    }
    paramContext.close();
    return true;
  }
  
  private static Animation createAnimationFromXml(Context paramContext, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    return createAnimationFromXml(paramContext, paramXmlPullParser, null, Xml.asAttributeSet(paramXmlPullParser));
  }
  
  private static Animation createAnimationFromXml(Context paramContext, XmlPullParser paramXmlPullParser, AnimationSet paramAnimationSet, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    Object localObject2 = null;
    int i = paramXmlPullParser.getDepth();
    int j;
    do
    {
      j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break;
      }
    } while (j != 2);
    Object localObject1 = paramXmlPullParser.getName();
    if (((String)localObject1).equals("set"))
    {
      localObject1 = new AnimationSet(paramContext, paramAttributeSet);
      createAnimationFromXml(paramContext, paramXmlPullParser, (AnimationSet)localObject1, paramAttributeSet);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramAnimationSet == null) {
        break;
      }
      paramAnimationSet.addAnimation((Animation)localObject1);
      localObject2 = localObject1;
      break;
      if (((String)localObject1).equals("alpha"))
      {
        localObject1 = new AlphaAnimation(paramContext, paramAttributeSet);
      }
      else if (((String)localObject1).equals("scale"))
      {
        localObject1 = new ScaleAnimation(paramContext, paramAttributeSet);
      }
      else if (((String)localObject1).equals("rotate"))
      {
        localObject1 = new RotateAnimation(paramContext, paramAttributeSet);
      }
      else
      {
        if (!((String)localObject1).equals("translate")) {
          break label211;
        }
        localObject1 = new TranslateAnimation(paramContext, paramAttributeSet);
      }
    }
    label211:
    throw new RuntimeException("Unknown animation name: " + paramXmlPullParser.getName());
    return (Animation)localObject2;
  }
  
  private static Interpolator createInterpolatorFromXml(Context paramContext, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    Object localObject = null;
    int i = paramXmlPullParser.getDepth();
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break label323;
      }
      if (j == 2)
      {
        localObject = Xml.asAttributeSet(paramXmlPullParser);
        String str = paramXmlPullParser.getName();
        if (str.equals("linearInterpolator"))
        {
          localObject = new LinearInterpolator(paramContext, (AttributeSet)localObject);
        }
        else if (str.equals("accelerateInterpolator"))
        {
          localObject = new AccelerateInterpolator(paramContext, (AttributeSet)localObject);
        }
        else if (str.equals("decelerateInterpolator"))
        {
          localObject = new DecelerateInterpolator(paramContext, (AttributeSet)localObject);
        }
        else if (str.equals("accelerateDecelerateInterpolator"))
        {
          localObject = new AccelerateDecelerateInterpolator(paramContext, (AttributeSet)localObject);
        }
        else if (str.equals("cycleInterpolator"))
        {
          localObject = new CycleInterpolator(paramContext, (AttributeSet)localObject);
        }
        else if (str.equals("anticipateInterpolator"))
        {
          localObject = new AnticipateInterpolator(paramContext, (AttributeSet)localObject);
        }
        else if (str.equals("overshootInterpolator"))
        {
          localObject = new OvershootInterpolator(paramContext, (AttributeSet)localObject);
        }
        else if (str.equals("anticipateOvershootInterpolator"))
        {
          localObject = new AnticipateOvershootInterpolator(paramContext, (AttributeSet)localObject);
        }
        else
        {
          if (!str.equals("bounceInterpolator")) {
            break;
          }
          localObject = new BounceInterpolator(paramContext, (AttributeSet)localObject);
        }
      }
    }
    throw new RuntimeException("Unknown interpolator name: " + paramXmlPullParser.getName());
    label323:
    return (Interpolator)localObject;
  }
  
  private static LayoutAnimationController createLayoutAnimationFromXml(Context paramContext, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    return createLayoutAnimationFromXml(paramContext, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser));
  }
  
  private static LayoutAnimationController createLayoutAnimationFromXml(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    Object localObject = null;
    int i = paramXmlPullParser.getDepth();
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break label133;
      }
      if (j == 2)
      {
        localObject = paramXmlPullParser.getName();
        if ("layoutAnimation".equals(localObject))
        {
          localObject = new LayoutAnimationController(paramContext, paramAttributeSet);
        }
        else
        {
          if (!"gridLayoutAnimation".equals(localObject)) {
            break;
          }
          localObject = new GridLayoutAnimationController(paramContext, paramAttributeSet);
        }
      }
    }
    throw new RuntimeException("Unknown layout animation name: " + (String)localObject);
    label133:
    return (LayoutAnimationController)localObject;
  }
  
  public static long currentAnimationTimeMillis()
  {
    return SystemClock.uptimeMillis();
  }
  
  private static Field getActivityThemeField()
  {
    try
    {
      activityThemeField = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mTheme");
      activityThemeField.setAccessible(true);
      return activityThemeField;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        LogUtil.e("", localThrowable.toString());
      }
    }
  }
  
  public static boolean getAsJar()
  {
    return mAsJar;
  }
  
  private static Field getContextResourcesField()
  {
    try
    {
      contextResourcesField = Class.forName("android.app.ContextImpl").getDeclaredField("mResources");
      contextResourcesField.setAccessible(true);
      return contextResourcesField;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        LogUtil.e("", localThrowable.toString());
      }
    }
  }
  
  private static Field getContextThemeField()
  {
    try
    {
      contextThemeField = Class.forName("android.app.ContextImpl").getDeclaredField("mTheme");
      contextThemeField.setAccessible(true);
      return contextThemeField;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        LogUtil.e("", localThrowable.toString());
      }
    }
  }
  
  public static int getInnerRIdValue(String paramString)
  {
    int j = -1;
    int i = j;
    if (paramString != null) {
      i = j;
    }
    try
    {
      if (paramString.length() > 0)
      {
        String str1 = paramString.substring(0, paramString.indexOf(".R.") + 2);
        i = paramString.lastIndexOf(".");
        String str2 = paramString.substring(i + 1, paramString.length());
        paramString = paramString.substring(0, i);
        paramString = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length());
        i = Class.forName(str1 + "$" + paramString).getDeclaredField(str2).getInt(null);
      }
      return i;
    }
    catch (Throwable paramString)
    {
      LogUtil.e("", paramString.toString());
    }
    return -1;
  }
  
  public static String getJarName()
  {
    return jarNameOrigin;
  }
  
  public static ClassLoader getParentClassLoader(ClassLoader paramClassLoader)
  {
    for (Object localObject = paramClassLoader.getClass(); ((localObject != null) && (!((Class)localObject).getName().endsWith(".ClassLoader"))) || (localObject != null); localObject = ((Class)localObject).getSuperclass()) {
      try
      {
        localObject = ((Class)localObject).getDeclaredField("parent");
        ((Field)localObject).setAccessible(true);
        paramClassLoader = (ClassLoader)((Field)localObject).get(paramClassLoader);
        return paramClassLoader;
      }
      catch (Exception paramClassLoader)
      {
        paramClassLoader.printStackTrace();
        LogUtil.e("getParentClassLoader() error:", paramClassLoader.toString());
        return null;
      }
    }
    return null;
  }
  
  public static Resources getResources()
  {
    if ((selfResources == null) && (BNaviModuleManager.getContext() != null)) {
      selfResources = BNaviModuleManager.getContext().getResources();
    }
    return selfResources;
  }
  
  public static AssetManager getSDKAssetManager()
  {
    if (jarPath != null) {
      return getSelfAssets(jarPath);
    }
    return null;
  }
  
  private static AssetManager getSelfAssets(String paramString)
  {
    AssetManager localAssetManager2 = null;
    AssetManager localAssetManager1 = localAssetManager2;
    try
    {
      Class localClass = Class.forName("android.content.res.AssetManager");
      localAssetManager1 = localAssetManager2;
      localAssetManager2 = (AssetManager)localClass.getConstructor((Class[])null).newInstance((Object[])null);
      localAssetManager1 = localAssetManager2;
      localClass.getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localAssetManager2, new Object[] { paramString });
      return localAssetManager2;
    }
    catch (Throwable paramString)
    {
      LogUtil.e("", paramString.toString());
    }
    return localAssetManager1;
  }
  
  private static Resources getSelfRes(Context paramContext, AssetManager paramAssetManager)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setToDefaults();
    return new Resources(paramAssetManager, localDisplayMetrics, paramContext.getResources().getConfiguration());
  }
  
  private static Resources.Theme getSelfTheme()
  {
    if (selfTheme == null)
    {
      if (selfAsset == null) {
        selfAsset = getSelfAssets(jarPath);
      }
      if (selfResources == null) {
        selfResources = getSelfRes(outsideActivity, selfAsset);
      }
      selfTheme = selfResources.newTheme();
      int i = getInnerRIdValue("com.android.internal.R.style.Theme");
      selfTheme.applyStyle(i, true);
    }
    return selfTheme;
  }
  
  private static String getSoPath(Context paramContext)
  {
    String str = paramContext.getFilesDir().getAbsolutePath();
    if (str != null)
    {
      int i = str.lastIndexOf("/");
      if (i >= 0) {
        paramContext = str.substring(0, i) + "/lib";
      }
    }
    for (;;)
    {
      return paramContext + "/" + checkSoSizeName;
      paramContext = "/data/data/" + paramContext.getPackageName() + "/lib";
      continue;
      paramContext = "/data/data/" + paramContext.getPackageName() + "/lib";
    }
  }
  
  public static View inflate(Activity paramActivity, int paramInt, ViewGroup paramViewGroup)
  {
    if (paramActivity == null) {
      return null;
    }
    if (!(paramActivity instanceof ProxyActivity)) {
      initProxyActivity(paramActivity);
    }
    try
    {
      paramActivity = LayoutInflater.from(paramActivity).cloneInContext(mProxyActivity).inflate(selfResources.getXml(paramInt), paramViewGroup);
      return paramActivity;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", "Jarutil inflate Throwable:" + paramActivity.getCause());
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", "Jarutil inflate Throwable:" + paramActivity.getMessage());
    }
    return null;
  }
  
  private static void initJarPath(Context paramContext)
  {
    jarDir = paramContext.getFilesDir().getAbsolutePath();
    jarPath = jarDir + "/" + jarName;
  }
  
  private static void initProxyActivity(Activity paramActivity)
  {
    if (mProxyActivity != null)
    {
      if (paramActivity.hashCode() != activityHasCode)
      {
        ((ProxyActivity)mProxyActivity).destory();
        mProxyActivity = null;
      }
    }
    else
    {
      activityHasCode = paramActivity.hashCode();
      mProxyActivity = new ProxyActivity(paramActivity);
    }
  }
  
  public static boolean initalClassLoader()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (ClassLoader localClassLoader = BaiduNaviSDKStub.dexClassLoader; localClassLoader != null; localClassLoader = getParentClassLoader(localClassLoader))
    {
      localObject2 = localObject1;
      localObject1 = localClassLoader;
    }
    if ((localObject1 == null) || (localObject2 == null)) {
      return false;
    }
    boolean bool = alterParClaLoader((ClassLoader)localObject2, BaiduNaviSDKStub.dexClassLoader);
    return (alterParClaLoader(BaiduNaviSDKStub.dexClassLoader, (ClassLoader)localObject1)) && (bool);
  }
  
  private static boolean isNaviApplibSoSizeChange(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      Long localLong = Long.valueOf(PreferenceHelper.getInstance(paramContext).getLong("sp_last_naviapplibso_size", 0L));
      Object localObject = getSoPath(paramContext);
      if (localObject == null) {
        return false;
      }
      localObject = new File((String)localObject);
      bool1 = bool2;
      if (localObject == null) {
        return bool1;
      }
      bool1 = bool2;
      if (!((File)localObject).exists()) {
        return bool1;
      }
      localObject = Long.valueOf(((File)localObject).length());
      LogUtil.e("JarUtils_preSoSize", localLong + "");
      LogUtil.e("JarUtils_curSoSize", localObject + "");
      if (localLong != localObject)
      {
        PreferenceHelper.getInstance(paramContext).putLong("sp_last_naviapplibso_size", ((Long)localObject).longValue());
        return false;
      }
    }
    catch (Exception paramContext)
    {
      return false;
    }
    boolean bool1 = true;
    return bool1;
  }
  
  /* Error */
  public static Animation loadAnimation(Context paramContext, int paramInt)
    throws android.content.res.Resources.NotFoundException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_3
    //   7: invokestatic 630	com/baidu/navisdk/util/jar/JarUtils:getResources	()Landroid/content/res/Resources;
    //   10: iload_1
    //   11: invokevirtual 633	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   14: astore 5
    //   16: aload 5
    //   18: astore_3
    //   19: aload 5
    //   21: astore_2
    //   22: aload 5
    //   24: astore 4
    //   26: aload_0
    //   27: aload 5
    //   29: invokestatic 635	com/baidu/navisdk/util/jar/JarUtils:createAnimationFromXml	(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;)Landroid/view/animation/Animation;
    //   32: astore_0
    //   33: aload 5
    //   35: ifnull +10 -> 45
    //   38: aload 5
    //   40: invokeinterface 638 1 0
    //   45: aload_0
    //   46: areturn
    //   47: astore_0
    //   48: aload_3
    //   49: astore_2
    //   50: new 629	android/content/res/Resources$NotFoundException
    //   53: dup
    //   54: new 76	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 640
    //   64: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_1
    //   68: invokestatic 646	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   71: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 647	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   80: astore 4
    //   82: aload_3
    //   83: astore_2
    //   84: aload 4
    //   86: aload_0
    //   87: invokevirtual 651	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   90: pop
    //   91: aload_3
    //   92: astore_2
    //   93: aload 4
    //   95: athrow
    //   96: astore_0
    //   97: aload_2
    //   98: ifnull +9 -> 107
    //   101: aload_2
    //   102: invokeinterface 638 1 0
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: aload 4
    //   112: astore_2
    //   113: new 629	android/content/res/Resources$NotFoundException
    //   116: dup
    //   117: new 76	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 640
    //   127: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: iload_1
    //   131: invokestatic 646	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   134: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 647	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   143: astore_3
    //   144: aload 4
    //   146: astore_2
    //   147: aload_3
    //   148: aload_0
    //   149: invokevirtual 651	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   152: pop
    //   153: aload 4
    //   155: astore_2
    //   156: aload_3
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramContext	Context
    //   0	158	1	paramInt	int
    //   1	155	2	localObject1	Object
    //   6	151	3	localObject2	Object
    //   3	151	4	localObject3	Object
    //   14	25	5	localXmlResourceParser	XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   7	16	47	org/xmlpull/v1/XmlPullParserException
    //   26	33	47	org/xmlpull/v1/XmlPullParserException
    //   7	16	96	finally
    //   26	33	96	finally
    //   50	82	96	finally
    //   84	91	96	finally
    //   93	96	96	finally
    //   113	144	96	finally
    //   147	153	96	finally
    //   156	158	96	finally
    //   7	16	109	java/io/IOException
    //   26	33	109	java/io/IOException
  }
  
  /* Error */
  public static Interpolator loadInterpolator(Context paramContext, int paramInt)
    throws android.content.res.Resources.NotFoundException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_3
    //   7: invokestatic 630	com/baidu/navisdk/util/jar/JarUtils:getResources	()Landroid/content/res/Resources;
    //   10: iload_1
    //   11: invokevirtual 633	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   14: astore 5
    //   16: aload 5
    //   18: astore_3
    //   19: aload 5
    //   21: astore_2
    //   22: aload 5
    //   24: astore 4
    //   26: aload_0
    //   27: aload 5
    //   29: invokestatic 655	com/baidu/navisdk/util/jar/JarUtils:createInterpolatorFromXml	(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;)Landroid/view/animation/Interpolator;
    //   32: astore_0
    //   33: aload 5
    //   35: ifnull +10 -> 45
    //   38: aload 5
    //   40: invokeinterface 638 1 0
    //   45: aload_0
    //   46: areturn
    //   47: astore_0
    //   48: aload_3
    //   49: astore_2
    //   50: new 629	android/content/res/Resources$NotFoundException
    //   53: dup
    //   54: new 76	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 640
    //   64: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_1
    //   68: invokestatic 646	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   71: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 647	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   80: astore 4
    //   82: aload_3
    //   83: astore_2
    //   84: aload 4
    //   86: aload_0
    //   87: invokevirtual 651	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   90: pop
    //   91: aload_3
    //   92: astore_2
    //   93: aload 4
    //   95: athrow
    //   96: astore_0
    //   97: aload_2
    //   98: ifnull +9 -> 107
    //   101: aload_2
    //   102: invokeinterface 638 1 0
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: aload 4
    //   112: astore_2
    //   113: new 629	android/content/res/Resources$NotFoundException
    //   116: dup
    //   117: new 76	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 640
    //   127: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: iload_1
    //   131: invokestatic 646	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   134: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 647	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   143: astore_3
    //   144: aload 4
    //   146: astore_2
    //   147: aload_3
    //   148: aload_0
    //   149: invokevirtual 651	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   152: pop
    //   153: aload 4
    //   155: astore_2
    //   156: aload_3
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramContext	Context
    //   0	158	1	paramInt	int
    //   1	155	2	localObject1	Object
    //   6	151	3	localObject2	Object
    //   3	151	4	localObject3	Object
    //   14	25	5	localXmlResourceParser	XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   7	16	47	org/xmlpull/v1/XmlPullParserException
    //   26	33	47	org/xmlpull/v1/XmlPullParserException
    //   7	16	96	finally
    //   26	33	96	finally
    //   50	82	96	finally
    //   84	91	96	finally
    //   93	96	96	finally
    //   113	144	96	finally
    //   147	153	96	finally
    //   156	158	96	finally
    //   7	16	109	java/io/IOException
    //   26	33	109	java/io/IOException
  }
  
  /* Error */
  public static LayoutAnimationController loadLayoutAnimation(Context paramContext, int paramInt)
    throws android.content.res.Resources.NotFoundException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_3
    //   7: invokestatic 630	com/baidu/navisdk/util/jar/JarUtils:getResources	()Landroid/content/res/Resources;
    //   10: iload_1
    //   11: invokevirtual 633	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   14: astore 5
    //   16: aload 5
    //   18: astore_3
    //   19: aload 5
    //   21: astore_2
    //   22: aload 5
    //   24: astore 4
    //   26: aload_0
    //   27: aload 5
    //   29: invokestatic 659	com/baidu/navisdk/util/jar/JarUtils:createLayoutAnimationFromXml	(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;)Landroid/view/animation/LayoutAnimationController;
    //   32: astore_0
    //   33: aload 5
    //   35: ifnull +10 -> 45
    //   38: aload 5
    //   40: invokeinterface 638 1 0
    //   45: aload_0
    //   46: areturn
    //   47: astore_0
    //   48: aload_3
    //   49: astore_2
    //   50: new 629	android/content/res/Resources$NotFoundException
    //   53: dup
    //   54: new 76	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 640
    //   64: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_1
    //   68: invokestatic 646	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   71: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 647	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   80: astore 4
    //   82: aload_3
    //   83: astore_2
    //   84: aload 4
    //   86: aload_0
    //   87: invokevirtual 651	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   90: pop
    //   91: aload_3
    //   92: astore_2
    //   93: aload 4
    //   95: athrow
    //   96: astore_0
    //   97: aload_2
    //   98: ifnull +9 -> 107
    //   101: aload_2
    //   102: invokeinterface 638 1 0
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: aload 4
    //   112: astore_2
    //   113: new 629	android/content/res/Resources$NotFoundException
    //   116: dup
    //   117: new 76	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 640
    //   127: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: iload_1
    //   131: invokestatic 646	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   134: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 647	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   143: astore_3
    //   144: aload 4
    //   146: astore_2
    //   147: aload_3
    //   148: aload_0
    //   149: invokevirtual 651	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   152: pop
    //   153: aload 4
    //   155: astore_2
    //   156: aload_3
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramContext	Context
    //   0	158	1	paramInt	int
    //   1	155	2	localObject1	Object
    //   6	151	3	localObject2	Object
    //   3	151	4	localObject3	Object
    //   14	25	5	localXmlResourceParser	XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   7	16	47	org/xmlpull/v1/XmlPullParserException
    //   26	33	47	org/xmlpull/v1/XmlPullParserException
    //   7	16	96	finally
    //   26	33	96	finally
    //   50	82	96	finally
    //   84	91	96	finally
    //   93	96	96	finally
    //   113	144	96	finally
    //   147	153	96	finally
    //   156	158	96	finally
    //   7	16	109	java/io/IOException
    //   26	33	109	java/io/IOException
  }
  
  public static View oldInflate(Activity paramActivity, int paramInt, ViewGroup paramViewGroup)
  {
    Object localObject4 = null;
    try
    {
      if (!mAsJar)
      {
        View localView = LayoutInflater.from(paramActivity).inflate(selfResources.getXml(paramInt), paramViewGroup);
        return localView;
      }
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e("", localThrowable.toString());
      localObject3 = null;
      localObject1 = null;
      localObject2 = localObject4;
      try
      {
        XmlResourceParser localXmlResourceParser = selfResources.getXml(paramInt);
        localObject1 = localXmlResourceParser;
        localObject2 = localObject4;
        localObject3 = localXmlResourceParser;
        boolean bool = switchToJarResourcesAndTheme(paramActivity);
        localObject1 = localXmlResourceParser;
        localObject2 = localObject4;
        localObject3 = localXmlResourceParser;
        paramViewGroup = LayoutInflater.from(paramActivity).inflate(localXmlResourceParser, paramViewGroup);
        if (bool)
        {
          localObject1 = localXmlResourceParser;
          localObject2 = paramViewGroup;
          localObject3 = localXmlResourceParser;
          switchToOriginResourceAndTheme(paramActivity);
        }
        paramActivity = paramViewGroup;
        if (localXmlResourceParser != null)
        {
          localXmlResourceParser.close();
          paramActivity = paramViewGroup;
        }
      }
      catch (Throwable paramActivity)
      {
        for (;;)
        {
          localObject3 = localObject1;
          LogUtil.e("", paramActivity.toString());
          paramActivity = (Activity)localObject2;
          if (localObject1 != null)
          {
            ((XmlResourceParser)localObject1).close();
            paramActivity = (Activity)localObject2;
          }
        }
      }
      finally
      {
        if (localObject3 == null) {
          break label187;
        }
        ((XmlResourceParser)localObject3).close();
      }
      return paramActivity;
    }
  }
  
  public static boolean setAsJar(Context paramContext)
  {
    if (!copyJarToSD(paramContext)) {
      return false;
    }
    mAsJar = true;
    selfAsset = getSelfAssets(jarPath);
    selfResources = getSelfRes(paramContext, selfAsset);
    BNStyleManager.setResource(selfResources);
    ProxyActivity.setAssetManager(selfAsset);
    ProxyActivity.setResource(selfResources);
    ProxyActivity.setResourcesTheme(getSelfTheme());
    return true;
  }
  
  public static void setDialogThemeField(Dialog paramDialog, Resources.Theme paramTheme)
  {
    try
    {
      Field localField = Class.forName("android.app.Dialog").getDeclaredField("mContext");
      localField.setAccessible(true);
      paramDialog = (ContextThemeWrapper)localField.get(paramDialog);
      localField = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mTheme");
      localField.setAccessible(true);
      localField.set(paramDialog, paramTheme);
      return;
    }
    catch (Throwable paramDialog)
    {
      LogUtil.e("", paramDialog.toString());
    }
  }
  
  public static void switchToJarResources(ContextWrapper paramContextWrapper)
  {
    try
    {
      if (contextResourcesField == null) {
        contextResourcesField = getContextResourcesField();
      }
      if (contextThemeField == null) {
        contextThemeField = getContextThemeField();
      }
      if (selfTheme == null) {
        selfTheme = getSelfTheme();
      }
      paramContextWrapper = paramContextWrapper.getBaseContext();
      oldResources = (Resources)contextResourcesField.get(paramContextWrapper);
      oldTheme = (Resources.Theme)contextThemeField.get(paramContextWrapper);
      contextResourcesField.set(paramContextWrapper, selfResources);
      contextThemeField.set(paramContextWrapper, selfTheme);
      return;
    }
    catch (Throwable paramContextWrapper)
    {
      LogUtil.e("", paramContextWrapper.toString());
    }
  }
  
  public static boolean switchToJarResourcesAndTheme(Activity paramActivity)
  {
    if (oldResources != null) {
      return false;
    }
    try
    {
      if (activityThemeField == null) {
        activityThemeField = getActivityThemeField();
      }
      if (contextResourcesField == null) {
        contextResourcesField = getContextResourcesField();
      }
      if (selfTheme == null) {
        selfTheme = getSelfTheme();
      }
      Context localContext = paramActivity.getBaseContext();
      oldResources = (Resources)contextResourcesField.get(localContext);
      oldTheme = (Resources.Theme)activityThemeField.get(paramActivity);
      contextResourcesField.set(localContext, selfResources);
      activityThemeField.set(paramActivity, selfTheme);
      return true;
    }
    catch (Throwable paramActivity)
    {
      LogUtil.e("", paramActivity.toString());
    }
    return false;
  }
  
  public static void switchToOriginResource(ContextWrapper paramContextWrapper)
  {
    try
    {
      paramContextWrapper = paramContextWrapper.getBaseContext();
      contextResourcesField.set(paramContextWrapper, oldResources);
      contextThemeField.set(paramContextWrapper, oldTheme);
      return;
    }
    catch (Throwable paramContextWrapper)
    {
      LogUtil.e("", paramContextWrapper.toString());
    }
  }
  
  public static void switchToOriginResourceAndTheme(Activity paramActivity)
  {
    if (oldResources == null) {
      return;
    }
    try
    {
      Context localContext = paramActivity.getBaseContext();
      contextResourcesField.set(localContext, oldResources);
      activityThemeField.set(paramActivity, oldTheme);
      return;
    }
    catch (Throwable paramActivity)
    {
      LogUtil.e("", paramActivity.toString());
      return;
    }
    finally
    {
      oldResources = null;
    }
  }
  
  public static void uninitProxyActivity()
  {
    if (mProxyActivity != null)
    {
      ((ProxyActivity)mProxyActivity).destory();
      mProxyActivity = null;
    }
    activityHasCode = 0;
  }
  
  static class OldResourceFileFilter
    implements FilenameFilter
  {
    public boolean accept(File paramFile, String paramString)
    {
      paramFile = JarUtils.jarVersion + JarUtils.jarNameSuffix;
      return (paramString.startsWith(JarUtils.jarNamePrefix)) && (!paramString.endsWith(paramFile));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/jar/JarUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */