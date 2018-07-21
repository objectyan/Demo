package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflater
{
  private static final int[] Animator = { 16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488 };
  private static final int[] AnimatorSet = { 16843490 };
  private static final int AnimatorSet_ordering = 0;
  private static final int Animator_duration = 1;
  private static final int Animator_interpolator = 0;
  private static final int Animator_repeatCount = 3;
  private static final int Animator_repeatMode = 4;
  private static final int Animator_startOffset = 2;
  private static final int Animator_valueFrom = 5;
  private static final int Animator_valueTo = 6;
  private static final int Animator_valueType = 7;
  private static final int[] PropertyAnimator = { 16843489 };
  private static final int PropertyAnimator_propertyName = 0;
  private static final int TOGETHER = 0;
  private static final int VALUE_TYPE_FLOAT = 0;
  
  private static Animator createAnimatorFromXml(Context paramContext, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    return createAnimatorFromXml(paramContext, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser), null, 0);
  }
  
  private static Animator createAnimatorFromXml(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt)
    throws XmlPullParserException, IOException
  {
    Object localObject3 = null;
    Object localObject2 = null;
    int j = paramXmlPullParser.getDepth();
    int i;
    do
    {
      i = paramXmlPullParser.next();
      if (((i == 3) && (paramXmlPullParser.getDepth() <= j)) || (i == 1)) {
        break;
      }
    } while (i != 2);
    Object localObject1 = paramXmlPullParser.getName();
    if (((String)localObject1).equals("objectAnimator")) {}
    Object localObject4;
    for (localObject1 = loadObjectAnimator(paramContext, paramAttributeSet);; localObject1 = loadAnimator(paramContext, paramAttributeSet, null))
    {
      localObject3 = localObject1;
      if (paramAnimatorSet == null) {
        break;
      }
      localObject4 = localObject2;
      if (localObject2 == null) {
        localObject4 = new ArrayList();
      }
      ((ArrayList)localObject4).add(localObject1);
      localObject3 = localObject1;
      localObject2 = localObject4;
      break;
      if (!((String)localObject1).equals("animator")) {
        break label142;
      }
    }
    label142:
    if (((String)localObject1).equals("set"))
    {
      localObject1 = new AnimatorSet();
      localObject3 = paramContext.obtainStyledAttributes(paramAttributeSet, AnimatorSet);
      localObject4 = new TypedValue();
      ((TypedArray)localObject3).getValue(0, (TypedValue)localObject4);
      if (((TypedValue)localObject4).type == 16) {}
      for (i = ((TypedValue)localObject4).data;; i = 0)
      {
        createAnimatorFromXml(paramContext, paramXmlPullParser, paramAttributeSet, (AnimatorSet)localObject1, i);
        ((TypedArray)localObject3).recycle();
        break;
      }
    }
    throw new RuntimeException("Unknown animator name: " + paramXmlPullParser.getName());
    if ((paramAnimatorSet != null) && (localObject2 != null))
    {
      paramContext = new Animator[((ArrayList)localObject2).size()];
      i = 0;
      paramXmlPullParser = ((ArrayList)localObject2).iterator();
      while (paramXmlPullParser.hasNext())
      {
        paramContext[i] = ((Animator)paramXmlPullParser.next());
        i += 1;
      }
      if (paramInt == 0) {
        paramAnimatorSet.playTogether(paramContext);
      }
    }
    else
    {
      return (Animator)localObject3;
    }
    paramAnimatorSet.playSequentially(paramContext);
    return (Animator)localObject3;
  }
  
  /* Error */
  public static Animator loadAnimator(Context paramContext, int paramInt)
    throws Resources.NotFoundException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_3
    //   7: aload_0
    //   8: invokevirtual 182	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   11: iload_1
    //   12: invokevirtual 188	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   15: astore 5
    //   17: aload 5
    //   19: astore_3
    //   20: aload 5
    //   22: astore_2
    //   23: aload 5
    //   25: astore 4
    //   27: aload_0
    //   28: aload 5
    //   30: invokestatic 190	com/nineoldandroids/animation/AnimatorInflater:createAnimatorFromXml	(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;)Lcom/nineoldandroids/animation/Animator;
    //   33: astore_0
    //   34: aload 5
    //   36: ifnull +10 -> 46
    //   39: aload 5
    //   41: invokeinterface 195 1 0
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_3
    //   50: astore_2
    //   51: new 178	android/content/res/Resources$NotFoundException
    //   54: dup
    //   55: new 137	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   62: ldc -59
    //   64: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_1
    //   68: invokestatic 203	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   71: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 204	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   80: astore 4
    //   82: aload_3
    //   83: astore_2
    //   84: aload 4
    //   86: aload_0
    //   87: invokevirtual 208	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   90: pop
    //   91: aload_3
    //   92: astore_2
    //   93: aload 4
    //   95: athrow
    //   96: astore_0
    //   97: aload_2
    //   98: ifnull +9 -> 107
    //   101: aload_2
    //   102: invokeinterface 195 1 0
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: aload 4
    //   112: astore_2
    //   113: new 178	android/content/res/Resources$NotFoundException
    //   116: dup
    //   117: new 137	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   124: ldc -59
    //   126: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: iload_1
    //   130: invokestatic 203	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   133: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokespecial 204	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   142: astore_3
    //   143: aload 4
    //   145: astore_2
    //   146: aload_3
    //   147: aload_0
    //   148: invokevirtual 208	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   151: pop
    //   152: aload 4
    //   154: astore_2
    //   155: aload_3
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramContext	Context
    //   0	157	1	paramInt	int
    //   1	154	2	localObject1	Object
    //   6	150	3	localObject2	Object
    //   3	150	4	localObject3	Object
    //   15	25	5	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   7	17	48	org/xmlpull/v1/XmlPullParserException
    //   27	34	48	org/xmlpull/v1/XmlPullParserException
    //   7	17	96	finally
    //   27	34	96	finally
    //   51	82	96	finally
    //   84	91	96	finally
    //   93	96	96	finally
    //   113	143	96	finally
    //   146	152	96	finally
    //   155	157	96	finally
    //   7	17	109	java/io/IOException
    //   27	34	109	java/io/IOException
  }
  
  private static ValueAnimator loadAnimator(Context paramContext, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator)
    throws Resources.NotFoundException
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Animator);
    long l1 = localTypedArray.getInt(1, 0);
    long l2 = localTypedArray.getInt(2, 0);
    int i = localTypedArray.getInt(7, 0);
    paramAttributeSet = paramValueAnimator;
    if (paramValueAnimator == null) {
      paramAttributeSet = new ValueAnimator();
    }
    int j;
    label76:
    int m;
    label87:
    int k;
    label102:
    int n;
    label113:
    float f1;
    label201:
    float f2;
    if (i == 0)
    {
      i = 1;
      paramValueAnimator = localTypedArray.peekValue(5);
      if (paramValueAnimator == null) {
        break label328;
      }
      j = 1;
      if (j == 0) {
        break label334;
      }
      m = paramValueAnimator.type;
      paramValueAnimator = localTypedArray.peekValue(6);
      if (paramValueAnimator == null) {
        break label340;
      }
      k = 1;
      if (k == 0) {
        break label346;
      }
      n = paramValueAnimator.type;
      int i1;
      if ((j == 0) || (m < 28) || (m > 31))
      {
        i1 = i;
        if (k != 0)
        {
          i1 = i;
          if (n >= 28)
          {
            i1 = i;
            if (n > 31) {}
          }
        }
      }
      else
      {
        i1 = 0;
        paramAttributeSet.setEvaluator(new ArgbEvaluator());
      }
      if (i1 == 0) {
        break label431;
      }
      if (j == 0) {
        break label390;
      }
      if (m != 5) {
        break label352;
      }
      f1 = localTypedArray.getDimension(5, 0.0F);
      if (k == 0) {
        break label376;
      }
      if (n != 5) {
        break label363;
      }
      f2 = localTypedArray.getDimension(6, 0.0F);
      label222:
      paramAttributeSet.setFloatValues(new float[] { f1, f2 });
    }
    label328:
    label334:
    label340:
    label346:
    label352:
    label363:
    label376:
    label390:
    label431:
    label452:
    label532:
    label572:
    label587:
    do
    {
      for (;;)
      {
        paramAttributeSet.setDuration(l1);
        paramAttributeSet.setStartDelay(l2);
        if (localTypedArray.hasValue(3)) {
          paramAttributeSet.setRepeatCount(localTypedArray.getInt(3, 0));
        }
        if (localTypedArray.hasValue(4)) {
          paramAttributeSet.setRepeatMode(localTypedArray.getInt(4, 1));
        }
        i = localTypedArray.getResourceId(0, 0);
        if (i > 0) {
          paramAttributeSet.setInterpolator(AnimationUtils.loadInterpolator(paramContext, i));
        }
        localTypedArray.recycle();
        return paramAttributeSet;
        i = 0;
        break;
        j = 0;
        break label76;
        m = 0;
        break label87;
        k = 0;
        break label102;
        n = 0;
        break label113;
        f1 = localTypedArray.getFloat(5, 0.0F);
        break label201;
        f2 = localTypedArray.getFloat(6, 0.0F);
        break label222;
        paramAttributeSet.setFloatValues(new float[] { f1 });
        continue;
        if (n == 5) {}
        for (f1 = localTypedArray.getDimension(6, 0.0F);; f1 = localTypedArray.getFloat(6, 0.0F))
        {
          paramAttributeSet.setFloatValues(new float[] { f1 });
          break;
        }
        if (j == 0) {
          break label587;
        }
        if (m == 5)
        {
          i = (int)localTypedArray.getDimension(5, 0.0F);
          if (k == 0) {
            break label572;
          }
          if (n != 5) {
            break label532;
          }
          j = (int)localTypedArray.getDimension(6, 0.0F);
        }
        for (;;)
        {
          paramAttributeSet.setIntValues(new int[] { i, j });
          break;
          if ((m >= 28) && (m <= 31))
          {
            i = localTypedArray.getColor(5, 0);
            break label452;
          }
          i = localTypedArray.getInt(5, 0);
          break label452;
          if ((n >= 28) && (n <= 31)) {
            j = localTypedArray.getColor(6, 0);
          } else {
            j = localTypedArray.getInt(6, 0);
          }
        }
        paramAttributeSet.setIntValues(new int[] { i });
      }
    } while (k == 0);
    if (n == 5) {
      i = (int)localTypedArray.getDimension(6, 0.0F);
    }
    for (;;)
    {
      paramAttributeSet.setIntValues(new int[] { i });
      break;
      if ((n >= 28) && (n <= 31)) {
        i = localTypedArray.getColor(6, 0);
      } else {
        i = localTypedArray.getInt(6, 0);
      }
    }
  }
  
  private static ObjectAnimator loadObjectAnimator(Context paramContext, AttributeSet paramAttributeSet)
    throws Resources.NotFoundException
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    loadAnimator(paramContext, paramAttributeSet, localObjectAnimator);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, PropertyAnimator);
    localObjectAnimator.setPropertyName(paramContext.getString(0));
    paramContext.recycle();
    return localObjectAnimator;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/nineoldandroids/animation/AnimatorInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */