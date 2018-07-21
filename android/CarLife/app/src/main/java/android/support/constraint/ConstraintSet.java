package android.support.constraint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet
{
  private static final int ALPHA = 43;
  public static final int BASELINE = 5;
  private static final int BASELINE_TO_BASELINE = 1;
  public static final int BOTTOM = 4;
  private static final int BOTTOM_MARGIN = 2;
  private static final int BOTTOM_TO_BOTTOM = 3;
  private static final int BOTTOM_TO_TOP = 4;
  public static final int CHAIN_PACKED = 2;
  public static final int CHAIN_SPREAD = 0;
  public static final int CHAIN_SPREAD_INSIDE = 1;
  private static final boolean DEBUG = false;
  private static final int DIMENSION_RATIO = 5;
  private static final int EDITOR_ABSOLUTE_X = 6;
  private static final int EDITOR_ABSOLUTE_Y = 7;
  private static final int ELEVATION = 44;
  public static final int END = 7;
  private static final int END_MARGIN = 8;
  private static final int END_TO_END = 9;
  private static final int END_TO_START = 10;
  public static final int GONE = 8;
  private static final int GONE_BOTTOM_MARGIN = 11;
  private static final int GONE_END_MARGIN = 12;
  private static final int GONE_LEFT_MARGIN = 13;
  private static final int GONE_RIGHT_MARGIN = 14;
  private static final int GONE_START_MARGIN = 15;
  private static final int GONE_TOP_MARGIN = 16;
  private static final int GUIDE_BEGIN = 17;
  private static final int GUIDE_END = 18;
  private static final int GUIDE_PERCENT = 19;
  private static final int HEIGHT_DEFAULT = 55;
  private static final int HEIGHT_MAX = 57;
  private static final int HEIGHT_MIN = 59;
  public static final int HORIZONTAL = 0;
  private static final int HORIZONTAL_BIAS = 20;
  public static final int HORIZONTAL_GUIDELINE = 0;
  private static final int HORIZONTAL_STYLE = 41;
  private static final int HORIZONTAL_WEIGHT = 39;
  public static final int INVISIBLE = 4;
  private static final int LAYOUT_HEIGHT = 21;
  private static final int LAYOUT_VISIBILITY = 22;
  private static final int LAYOUT_WIDTH = 23;
  public static final int LEFT = 1;
  private static final int LEFT_MARGIN = 24;
  private static final int LEFT_TO_LEFT = 25;
  private static final int LEFT_TO_RIGHT = 26;
  public static final int MATCH_CONSTRAINT = 0;
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  private static final int ORIENTATION = 27;
  public static final int PARENT_ID = 0;
  public static final int RIGHT = 2;
  private static final int RIGHT_MARGIN = 28;
  private static final int RIGHT_TO_LEFT = 29;
  private static final int RIGHT_TO_RIGHT = 30;
  private static final int ROTATION_X = 45;
  private static final int ROTATION_Y = 46;
  private static final int SCALE_X = 47;
  private static final int SCALE_Y = 48;
  public static final int START = 6;
  private static final int START_MARGIN = 31;
  private static final int START_TO_END = 32;
  private static final int START_TO_START = 33;
  private static final String TAG = "ConstraintSet";
  public static final int TOP = 3;
  private static final int TOP_MARGIN = 34;
  private static final int TOP_TO_BOTTOM = 35;
  private static final int TOP_TO_TOP = 36;
  private static final int TRANSFORM_PIVOT_X = 49;
  private static final int TRANSFORM_PIVOT_Y = 50;
  private static final int TRANSLATION_X = 51;
  private static final int TRANSLATION_Y = 52;
  private static final int TRANSLATION_Z = 53;
  public static final int UNSET = -1;
  private static final int UNUSED = 60;
  public static final int VERTICAL = 1;
  private static final int VERTICAL_BIAS = 37;
  public static final int VERTICAL_GUIDELINE = 1;
  private static final int VERTICAL_STYLE = 42;
  private static final int VERTICAL_WEIGHT = 40;
  private static final int VIEW_ID = 38;
  private static final int[] VISIBILITY_FLAGS = { 0, 4, 8 };
  public static final int VISIBLE = 0;
  private static final int WIDTH_DEFAULT = 54;
  private static final int WIDTH_MAX = 56;
  private static final int WIDTH_MIN = 58;
  public static final int WRAP_CONTENT = -2;
  private static SparseIntArray mapToConstant = new SparseIntArray();
  private HashMap<Integer, Constraint> mConstraints = new HashMap();
  
  static
  {
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
    mapToConstant.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
    mapToConstant.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
    mapToConstant.append(R.styleable.ConstraintSet_android_orientation, 27);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_width, 23);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_height, 21);
    mapToConstant.append(R.styleable.ConstraintSet_android_visibility, 22);
    mapToConstant.append(R.styleable.ConstraintSet_android_alpha, 43);
    mapToConstant.append(R.styleable.ConstraintSet_android_elevation, 44);
    mapToConstant.append(R.styleable.ConstraintSet_android_rotationX, 45);
    mapToConstant.append(R.styleable.ConstraintSet_android_rotationY, 46);
    mapToConstant.append(R.styleable.ConstraintSet_android_scaleX, 47);
    mapToConstant.append(R.styleable.ConstraintSet_android_scaleY, 48);
    mapToConstant.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
    mapToConstant.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
    mapToConstant.append(R.styleable.ConstraintSet_android_translationX, 51);
    mapToConstant.append(R.styleable.ConstraintSet_android_translationY, 52);
    mapToConstant.append(R.styleable.ConstraintSet_android_translationZ, 53);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
    mapToConstant.append(R.styleable.ConstraintSet_android_id, 38);
  }
  
  private void createHorizontalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramArrayOfInt.length < 2) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if (paramArrayOfFloat != null) {
      get(paramArrayOfInt[0]).verticalWeight = paramArrayOfFloat[0];
    }
    get(paramArrayOfInt[0]).horizontalChainStyle = paramInt5;
    connect(paramArrayOfInt[0], paramInt6, paramInt1, paramInt2, -1);
    paramInt1 = 1;
    while (paramInt1 < paramArrayOfInt.length)
    {
      paramInt2 = paramArrayOfInt[paramInt1];
      connect(paramArrayOfInt[paramInt1], paramInt6, paramArrayOfInt[(paramInt1 - 1)], paramInt7, -1);
      connect(paramArrayOfInt[(paramInt1 - 1)], paramInt7, paramArrayOfInt[paramInt1], paramInt6, -1);
      if (paramArrayOfFloat != null) {
        get(paramArrayOfInt[paramInt1]).horizontalWeight = paramArrayOfFloat[paramInt1];
      }
      paramInt1 += 1;
    }
    connect(paramArrayOfInt[(paramArrayOfInt.length - 1)], paramInt7, paramInt3, paramInt4, -1);
  }
  
  private Constraint fillFromAttributeList(Context paramContext, AttributeSet paramAttributeSet)
  {
    Constraint localConstraint = new Constraint(null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
    populateConstraint(localConstraint, paramContext);
    paramContext.recycle();
    return localConstraint;
  }
  
  private Constraint get(int paramInt)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt))) {
      this.mConstraints.put(Integer.valueOf(paramInt), new Constraint(null));
    }
    return (Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
  }
  
  private static int lookupID(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    int i = paramTypedArray.getResourceId(paramInt1, paramInt2);
    paramInt2 = i;
    if (i == -1) {
      paramInt2 = paramTypedArray.getInt(paramInt1, -1);
    }
    return paramInt2;
  }
  
  private void populateConstraint(Constraint paramConstraint, TypedArray paramTypedArray)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    if (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      switch (mapToConstant.get(k))
      {
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
      default: 
        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(k) + "   " + mapToConstant.get(k));
      }
      for (;;)
      {
        i += 1;
        break;
        paramConstraint.leftToLeft = lookupID(paramTypedArray, k, paramConstraint.leftToLeft);
        continue;
        paramConstraint.leftToRight = lookupID(paramTypedArray, k, paramConstraint.leftToRight);
        continue;
        paramConstraint.rightToLeft = lookupID(paramTypedArray, k, paramConstraint.rightToLeft);
        continue;
        paramConstraint.rightToRight = lookupID(paramTypedArray, k, paramConstraint.rightToRight);
        continue;
        paramConstraint.topToTop = lookupID(paramTypedArray, k, paramConstraint.topToTop);
        continue;
        paramConstraint.topToBottom = lookupID(paramTypedArray, k, paramConstraint.topToBottom);
        continue;
        paramConstraint.bottomToTop = lookupID(paramTypedArray, k, paramConstraint.bottomToTop);
        continue;
        paramConstraint.bottomToBottom = lookupID(paramTypedArray, k, paramConstraint.bottomToBottom);
        continue;
        paramConstraint.baselineToBaseline = lookupID(paramTypedArray, k, paramConstraint.baselineToBaseline);
        continue;
        paramConstraint.editorAbsoluteX = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.editorAbsoluteX);
        continue;
        paramConstraint.editorAbsoluteY = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.editorAbsoluteY);
        continue;
        paramConstraint.guideBegin = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.guideBegin);
        continue;
        paramConstraint.guideEnd = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.guideEnd);
        continue;
        paramConstraint.guidePercent = paramTypedArray.getFloat(k, paramConstraint.guidePercent);
        continue;
        paramConstraint.orientation = paramTypedArray.getInt(k, paramConstraint.orientation);
        continue;
        paramConstraint.startToEnd = lookupID(paramTypedArray, k, paramConstraint.startToEnd);
        continue;
        paramConstraint.startToStart = lookupID(paramTypedArray, k, paramConstraint.startToStart);
        continue;
        paramConstraint.endToStart = lookupID(paramTypedArray, k, paramConstraint.endToStart);
        continue;
        paramConstraint.bottomToTop = lookupID(paramTypedArray, k, paramConstraint.endToEnd);
        continue;
        paramConstraint.goneLeftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneLeftMargin);
        continue;
        paramConstraint.goneTopMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneTopMargin);
        continue;
        paramConstraint.goneRightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneRightMargin);
        continue;
        paramConstraint.goneBottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneBottomMargin);
        continue;
        paramConstraint.goneStartMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneStartMargin);
        continue;
        paramConstraint.goneEndMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneEndMargin);
        continue;
        paramConstraint.horizontalBias = paramTypedArray.getFloat(k, paramConstraint.horizontalBias);
        continue;
        paramConstraint.verticalBias = paramTypedArray.getFloat(k, paramConstraint.verticalBias);
        continue;
        paramConstraint.leftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.leftMargin);
        continue;
        paramConstraint.rightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.rightMargin);
        continue;
        paramConstraint.startMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.startMargin);
        continue;
        paramConstraint.endMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.endMargin);
        continue;
        paramConstraint.topMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.topMargin);
        continue;
        paramConstraint.bottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.bottomMargin);
        continue;
        paramConstraint.mWidth = paramTypedArray.getLayoutDimension(k, paramConstraint.mWidth);
        continue;
        paramConstraint.mHeight = paramTypedArray.getLayoutDimension(k, paramConstraint.mHeight);
        continue;
        paramConstraint.visibility = paramTypedArray.getInt(k, paramConstraint.visibility);
        paramConstraint.visibility = VISIBILITY_FLAGS[paramConstraint.visibility];
        continue;
        paramConstraint.alpha = paramTypedArray.getFloat(k, paramConstraint.alpha);
        continue;
        paramConstraint.applyElevation = true;
        paramConstraint.elevation = paramTypedArray.getFloat(k, paramConstraint.elevation);
        continue;
        paramConstraint.rotationX = paramTypedArray.getFloat(k, paramConstraint.rotationX);
        continue;
        paramConstraint.rotationY = paramTypedArray.getFloat(k, paramConstraint.rotationY);
        continue;
        paramConstraint.scaleX = paramTypedArray.getFloat(k, paramConstraint.scaleX);
        continue;
        paramConstraint.scaleY = paramTypedArray.getFloat(k, paramConstraint.scaleY);
        continue;
        paramConstraint.transformPivotX = paramTypedArray.getFloat(k, paramConstraint.transformPivotX);
        continue;
        paramConstraint.transformPivotY = paramTypedArray.getFloat(k, paramConstraint.transformPivotY);
        continue;
        paramConstraint.translationX = paramTypedArray.getFloat(k, paramConstraint.translationX);
        continue;
        paramConstraint.translationY = paramTypedArray.getFloat(k, paramConstraint.translationY);
        continue;
        paramConstraint.translationZ = paramTypedArray.getFloat(k, paramConstraint.translationZ);
        continue;
        paramConstraint.verticalWeight = paramTypedArray.getFloat(k, paramConstraint.verticalWeight);
        continue;
        paramConstraint.horizontalWeight = paramTypedArray.getFloat(k, paramConstraint.horizontalWeight);
        continue;
        paramConstraint.verticalChainStyle = paramTypedArray.getInt(k, paramConstraint.verticalChainStyle);
        continue;
        paramConstraint.horizontalChainStyle = paramTypedArray.getInt(k, paramConstraint.horizontalChainStyle);
        continue;
        paramConstraint.mViewId = paramTypedArray.getResourceId(k, paramConstraint.mViewId);
        continue;
        paramConstraint.dimensionRatio = paramTypedArray.getString(k);
        continue;
        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(k) + "   " + mapToConstant.get(k));
      }
    }
  }
  
  private String sideToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "undefined";
    case 1: 
      return "left";
    case 2: 
      return "right";
    case 3: 
      return "top";
    case 4: 
      return "bottom";
    case 5: 
      return "baseline";
    case 6: 
      return "start";
    }
    return "end";
  }
  
  public void addToHorizontalChain(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 0)
    {
      i = 1;
      connect(paramInt1, 1, paramInt2, i, 0);
      if (paramInt3 != 0) {
        break label67;
      }
    }
    label67:
    for (int i = 2;; i = 1)
    {
      connect(paramInt1, 2, paramInt3, i, 0);
      if (paramInt2 != 0) {
        connect(paramInt2, 2, paramInt1, 1, 0);
      }
      if (paramInt3 != 0) {
        connect(paramInt3, 1, paramInt1, 2, 0);
      }
      return;
      i = 2;
      break;
    }
  }
  
  public void addToHorizontalChainRTL(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 0)
    {
      i = 6;
      connect(paramInt1, 6, paramInt2, i, 0);
      if (paramInt3 != 0) {
        break label76;
      }
    }
    label76:
    for (int i = 7;; i = 6)
    {
      connect(paramInt1, 7, paramInt3, i, 0);
      if (paramInt2 != 0) {
        connect(paramInt2, 7, paramInt1, 6, 0);
      }
      if (paramInt3 != 0) {
        connect(paramInt3, 6, paramInt1, 7, 0);
      }
      return;
      i = 7;
      break;
    }
  }
  
  public void addToVerticalChain(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 0)
    {
      i = 3;
      connect(paramInt1, 3, paramInt2, i, 0);
      if (paramInt3 != 0) {
        break label67;
      }
    }
    label67:
    for (int i = 4;; i = 3)
    {
      connect(paramInt1, 4, paramInt3, i, 0);
      if (paramInt2 != 0) {
        connect(paramInt2, 4, paramInt1, 3, 0);
      }
      if (paramInt2 != 0) {
        connect(paramInt3, 3, paramInt1, 4, 0);
      }
      return;
      i = 4;
      break;
    }
  }
  
  public void applyTo(ConstraintLayout paramConstraintLayout)
  {
    applyToInternal(paramConstraintLayout);
    paramConstraintLayout.setConstraintSet(null);
  }
  
  void applyToInternal(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    Object localObject1 = new HashSet(this.mConstraints.keySet());
    int i = 0;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    while (i < j)
    {
      localObject2 = paramConstraintLayout.getChildAt(i);
      int k = ((View)localObject2).getId();
      if (this.mConstraints.containsKey(Integer.valueOf(k)))
      {
        ((HashSet)localObject1).remove(Integer.valueOf(k));
        localObject3 = (Constraint)this.mConstraints.get(Integer.valueOf(k));
        localObject4 = (ConstraintLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((Constraint)localObject3).applyTo((ConstraintLayout.LayoutParams)localObject4);
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((View)localObject2).setVisibility(((Constraint)localObject3).visibility);
        if (Build.VERSION.SDK_INT >= 17)
        {
          ((View)localObject2).setAlpha(((Constraint)localObject3).alpha);
          ((View)localObject2).setRotationX(((Constraint)localObject3).rotationX);
          ((View)localObject2).setRotationY(((Constraint)localObject3).rotationY);
          ((View)localObject2).setScaleX(((Constraint)localObject3).scaleX);
          ((View)localObject2).setScaleY(((Constraint)localObject3).scaleY);
          ((View)localObject2).setPivotX(((Constraint)localObject3).transformPivotX);
          ((View)localObject2).setPivotY(((Constraint)localObject3).transformPivotY);
          ((View)localObject2).setTranslationX(((Constraint)localObject3).translationX);
          ((View)localObject2).setTranslationY(((Constraint)localObject3).translationY);
          if (Build.VERSION.SDK_INT >= 21)
          {
            ((View)localObject2).setTranslationZ(((Constraint)localObject3).translationZ);
            if (((Constraint)localObject3).applyElevation) {
              ((View)localObject2).setElevation(((Constraint)localObject3).elevation);
            }
          }
        }
      }
      i += 1;
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (Integer)((Iterator)localObject1).next();
      localObject2 = (Constraint)this.mConstraints.get(localObject4);
      if (((Constraint)localObject2).mIsGuideline)
      {
        localObject3 = new Guideline(paramConstraintLayout.getContext());
        ((Guideline)localObject3).setId(((Integer)localObject4).intValue());
        localObject4 = paramConstraintLayout.generateDefaultLayoutParams();
        ((Constraint)localObject2).applyTo((ConstraintLayout.LayoutParams)localObject4);
        paramConstraintLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      }
    }
  }
  
  public void center(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    if (paramInt4 < 0) {
      throw new IllegalArgumentException("margin must be > 0");
    }
    if (paramInt7 < 0) {
      throw new IllegalArgumentException("margin must be > 0");
    }
    if ((paramFloat <= 0.0F) || (paramFloat > 1.0F)) {
      throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    }
    if ((paramInt3 == 1) || (paramInt3 == 2))
    {
      connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
      connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
      ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
      return;
    }
    if ((paramInt3 == 6) || (paramInt3 == 7))
    {
      connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
      connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
      ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
      return;
    }
    connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 1, 0, 0, 2, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 2, 0, paramInt2, 1, 0, 0.5F);
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 6, 0, 0, 7, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 7, 0, paramInt2, 6, 0, 0.5F);
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
  }
  
  public void centerVertically(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 3, 0, 0, 4, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 4, 0, paramInt2, 3, 0, 0.5F);
  }
  
  public void centerVertically(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
  }
  
  public void clear(int paramInt)
  {
    this.mConstraints.remove(Integer.valueOf(paramInt));
  }
  
  public void clear(int paramInt1, int paramInt2)
  {
    Constraint localConstraint;
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt1));
    }
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 1: 
      localConstraint.leftToRight = -1;
      localConstraint.leftToLeft = -1;
      localConstraint.leftMargin = -1;
      localConstraint.goneLeftMargin = -1;
      return;
    case 2: 
      localConstraint.rightToRight = -1;
      localConstraint.rightToLeft = -1;
      localConstraint.rightMargin = -1;
      localConstraint.goneRightMargin = -1;
      return;
    case 3: 
      localConstraint.topToBottom = -1;
      localConstraint.topToTop = -1;
      localConstraint.topMargin = -1;
      localConstraint.goneTopMargin = -1;
      return;
    case 4: 
      localConstraint.bottomToTop = -1;
      localConstraint.bottomToBottom = -1;
      localConstraint.bottomMargin = -1;
      localConstraint.goneBottomMargin = -1;
      return;
    case 5: 
      localConstraint.baselineToBaseline = -1;
      return;
    case 6: 
      localConstraint.startToEnd = -1;
      localConstraint.startToStart = -1;
      localConstraint.startMargin = -1;
      localConstraint.goneStartMargin = -1;
      return;
    }
    localConstraint.endToStart = -1;
    localConstraint.endToEnd = -1;
    localConstraint.endMargin = -1;
    localConstraint.goneEndMargin = -1;
  }
  
  public void clone(Context paramContext, int paramInt)
  {
    clone((ConstraintLayout)LayoutInflater.from(paramContext).inflate(paramInt, null));
  }
  
  public void clone(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    this.mConstraints.clear();
    int i = 0;
    while (i < j)
    {
      View localView = paramConstraintLayout.getChildAt(i);
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
      int k = localView.getId();
      if (!this.mConstraints.containsKey(Integer.valueOf(k))) {
        this.mConstraints.put(Integer.valueOf(k), new Constraint(null));
      }
      Constraint localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(k));
      localConstraint.fillFrom(k, localLayoutParams);
      localConstraint.visibility = localView.getVisibility();
      if (Build.VERSION.SDK_INT >= 17)
      {
        localConstraint.alpha = localView.getAlpha();
        localConstraint.rotationX = localView.getRotationX();
        localConstraint.rotationY = localView.getRotationY();
        localConstraint.scaleX = localView.getScaleX();
        localConstraint.scaleY = localView.getScaleY();
        localConstraint.transformPivotX = localView.getPivotX();
        localConstraint.transformPivotY = localView.getPivotY();
        localConstraint.translationX = localView.getTranslationX();
        localConstraint.translationY = localView.getTranslationY();
        if (Build.VERSION.SDK_INT >= 21)
        {
          localConstraint.translationZ = localView.getTranslationZ();
          if (localConstraint.applyElevation) {
            localConstraint.elevation = localView.getElevation();
          }
        }
      }
      i += 1;
    }
  }
  
  public void clone(ConstraintSet paramConstraintSet)
  {
    this.mConstraints.clear();
    Iterator localIterator = paramConstraintSet.mConstraints.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.mConstraints.put(localInteger, ((Constraint)paramConstraintSet.mConstraints.get(localInteger)).clone());
    }
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      this.mConstraints.put(Integer.valueOf(paramInt1), new Constraint(null));
    }
    Constraint localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException(sideToString(paramInt2) + " to " + sideToString(paramInt4) + " unknown");
    case 1: 
      if (paramInt4 == 1)
      {
        localConstraint.leftToLeft = paramInt3;
        localConstraint.leftToRight = -1;
        return;
      }
      if (paramInt4 == 2)
      {
        localConstraint.leftToRight = paramInt3;
        localConstraint.leftToLeft = -1;
        return;
      }
      throw new IllegalArgumentException("left to " + sideToString(paramInt4) + " undefined");
    case 2: 
      if (paramInt4 == 1)
      {
        localConstraint.rightToLeft = paramInt3;
        localConstraint.rightToRight = -1;
        return;
      }
      if (paramInt4 == 2)
      {
        localConstraint.rightToRight = paramInt3;
        localConstraint.rightToLeft = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 3: 
      if (paramInt4 == 3)
      {
        localConstraint.topToTop = paramInt3;
        localConstraint.topToBottom = -1;
        localConstraint.baselineToBaseline = -1;
        return;
      }
      if (paramInt4 == 4)
      {
        localConstraint.topToBottom = paramInt3;
        localConstraint.topToTop = -1;
        localConstraint.baselineToBaseline = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 4: 
      if (paramInt4 == 4)
      {
        localConstraint.bottomToBottom = paramInt3;
        localConstraint.bottomToTop = -1;
        localConstraint.baselineToBaseline = -1;
        return;
      }
      if (paramInt4 == 3)
      {
        localConstraint.bottomToTop = paramInt3;
        localConstraint.bottomToBottom = -1;
        localConstraint.baselineToBaseline = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 5: 
      if (paramInt4 == 5)
      {
        localConstraint.baselineToBaseline = paramInt3;
        localConstraint.bottomToBottom = -1;
        localConstraint.bottomToTop = -1;
        localConstraint.topToTop = -1;
        localConstraint.topToBottom = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 6: 
      if (paramInt4 == 6)
      {
        localConstraint.startToStart = paramInt3;
        localConstraint.startToEnd = -1;
        return;
      }
      if (paramInt4 == 7)
      {
        localConstraint.startToEnd = paramInt3;
        localConstraint.startToStart = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    }
    if (paramInt4 == 7)
    {
      localConstraint.endToEnd = paramInt3;
      localConstraint.endToStart = -1;
      return;
    }
    if (paramInt4 == 6)
    {
      localConstraint.endToStart = paramInt3;
      localConstraint.endToEnd = -1;
      return;
    }
    throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      this.mConstraints.put(Integer.valueOf(paramInt1), new Constraint(null));
    }
    Constraint localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException(sideToString(paramInt2) + " to " + sideToString(paramInt4) + " unknown");
    case 1: 
      if (paramInt4 == 1)
      {
        localConstraint.leftToLeft = paramInt3;
        localConstraint.leftToRight = -1;
      }
      for (;;)
      {
        localConstraint.leftMargin = paramInt5;
        return;
        if (paramInt4 != 2) {
          break;
        }
        localConstraint.leftToRight = paramInt3;
        localConstraint.leftToLeft = -1;
      }
      throw new IllegalArgumentException("Left to " + sideToString(paramInt4) + " undefined");
    case 2: 
      if (paramInt4 == 1)
      {
        localConstraint.rightToLeft = paramInt3;
        localConstraint.rightToRight = -1;
      }
      for (;;)
      {
        localConstraint.rightMargin = paramInt5;
        return;
        if (paramInt4 != 2) {
          break;
        }
        localConstraint.rightToRight = paramInt3;
        localConstraint.rightToLeft = -1;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 3: 
      if (paramInt4 == 3)
      {
        localConstraint.topToTop = paramInt3;
        localConstraint.topToBottom = -1;
      }
      for (localConstraint.baselineToBaseline = -1;; localConstraint.baselineToBaseline = -1)
      {
        localConstraint.topMargin = paramInt5;
        return;
        if (paramInt4 != 4) {
          break;
        }
        localConstraint.topToBottom = paramInt3;
        localConstraint.topToTop = -1;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 4: 
      if (paramInt4 == 4)
      {
        localConstraint.bottomToBottom = paramInt3;
        localConstraint.bottomToTop = -1;
      }
      for (localConstraint.baselineToBaseline = -1;; localConstraint.baselineToBaseline = -1)
      {
        localConstraint.bottomMargin = paramInt5;
        return;
        if (paramInt4 != 3) {
          break;
        }
        localConstraint.bottomToTop = paramInt3;
        localConstraint.bottomToBottom = -1;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 5: 
      if (paramInt4 == 5)
      {
        localConstraint.baselineToBaseline = paramInt3;
        localConstraint.bottomToBottom = -1;
        localConstraint.bottomToTop = -1;
        localConstraint.topToTop = -1;
        localConstraint.topToBottom = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 6: 
      if (paramInt4 == 6)
      {
        localConstraint.startToStart = paramInt3;
        localConstraint.startToEnd = -1;
      }
      for (;;)
      {
        localConstraint.startMargin = paramInt5;
        return;
        if (paramInt4 != 7) {
          break;
        }
        localConstraint.startToEnd = paramInt3;
        localConstraint.startToStart = -1;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    }
    if (paramInt4 == 7)
    {
      localConstraint.endToEnd = paramInt3;
      localConstraint.endToStart = -1;
    }
    for (;;)
    {
      localConstraint.endMargin = paramInt5;
      return;
      if (paramInt4 != 6) {
        break;
      }
      localConstraint.endToStart = paramInt3;
      localConstraint.endToEnd = -1;
    }
    throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
  }
  
  public void constrainDefaultHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).heightDefault = paramInt2;
  }
  
  public void constrainDefaultWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).widthDefault = paramInt2;
  }
  
  public void constrainHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).mHeight = paramInt2;
  }
  
  public void constrainMaxHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).heightMax = paramInt2;
  }
  
  public void constrainMaxWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).widthMax = paramInt2;
  }
  
  public void constrainMinHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).heightMin = paramInt2;
  }
  
  public void constrainMinWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).widthMin = paramInt2;
  }
  
  public void constrainWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).mWidth = paramInt2;
  }
  
  public void create(int paramInt1, int paramInt2)
  {
    Constraint localConstraint = get(paramInt1);
    localConstraint.mIsGuideline = true;
    localConstraint.orientation = paramInt2;
  }
  
  public void createHorizontalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    createHorizontalChain(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramArrayOfFloat, paramInt5, 1, 2);
  }
  
  public void createHorizontalChainRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    createHorizontalChain(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramArrayOfFloat, paramInt5, 6, 7);
  }
  
  public void createVerticalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    if (paramArrayOfInt.length < 2) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if (paramArrayOfFloat != null) {
      get(paramArrayOfInt[0]).verticalWeight = paramArrayOfFloat[0];
    }
    get(paramArrayOfInt[0]).verticalChainStyle = paramInt5;
    connect(paramArrayOfInt[0], 3, paramInt1, paramInt2, 0);
    paramInt1 = 1;
    while (paramInt1 < paramArrayOfInt.length)
    {
      paramInt2 = paramArrayOfInt[paramInt1];
      connect(paramArrayOfInt[paramInt1], 3, paramArrayOfInt[(paramInt1 - 1)], 4, 0);
      connect(paramArrayOfInt[(paramInt1 - 1)], 4, paramArrayOfInt[paramInt1], 3, 0);
      if (paramArrayOfFloat != null) {
        get(paramArrayOfInt[paramInt1]).verticalWeight = paramArrayOfFloat[paramInt1];
      }
      paramInt1 += 1;
    }
    connect(paramArrayOfInt[(paramArrayOfInt.length - 1)], 4, paramInt3, paramInt4, 0);
  }
  
  public boolean getApplyElevation(int paramInt)
  {
    return get(paramInt).applyElevation;
  }
  
  public void load(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    for (;;)
    {
      try
      {
        paramInt = localXmlResourceParser.getEventType();
      }
      catch (XmlPullParserException paramContext)
      {
        String str;
        Constraint localConstraint;
        paramContext.printStackTrace();
        return;
        continue;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      paramInt = localXmlResourceParser.next();
      break label111;
      localXmlResourceParser.getName();
      continue;
      str = localXmlResourceParser.getName();
      localConstraint = fillFromAttributeList(paramContext, Xml.asAttributeSet(localXmlResourceParser));
      if (str.equalsIgnoreCase("Guideline")) {
        localConstraint.mIsGuideline = true;
      }
      this.mConstraints.put(Integer.valueOf(localConstraint.mViewId), localConstraint);
      continue;
      label111:
      if (paramInt != 1) {
        switch (paramInt)
        {
        }
      }
    }
  }
  
  public void removeFromHorizontalChain(int paramInt)
  {
    Constraint localConstraint;
    int i;
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt)))
    {
      localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
      i = localConstraint.leftToRight;
      j = localConstraint.rightToLeft;
      if ((i == -1) && (j == -1)) {
        break label153;
      }
      if ((i == -1) || (j == -1)) {
        break label93;
      }
      connect(i, 2, j, 1, 0);
      connect(j, 1, i, 2, 0);
    }
    for (;;)
    {
      clear(paramInt, 1);
      clear(paramInt, 2);
      return;
      label93:
      if ((i != -1) || (j != -1)) {
        if (localConstraint.rightToRight != -1) {
          connect(i, 2, localConstraint.rightToRight, 2, 0);
        } else if (localConstraint.leftToLeft != -1) {
          connect(j, 1, localConstraint.leftToLeft, 1, 0);
        }
      }
    }
    label153:
    int j = localConstraint.startToEnd;
    int k = localConstraint.endToStart;
    if ((j != -1) || (k != -1))
    {
      if ((j == -1) || (k == -1)) {
        break label227;
      }
      connect(j, 7, k, 6, 0);
      connect(k, 6, i, 7, 0);
    }
    for (;;)
    {
      clear(paramInt, 6);
      clear(paramInt, 7);
      return;
      label227:
      if ((i != -1) || (k != -1)) {
        if (localConstraint.rightToRight != -1) {
          connect(i, 7, localConstraint.rightToRight, 7, 0);
        } else if (localConstraint.leftToLeft != -1) {
          connect(k, 6, localConstraint.leftToLeft, 6, 0);
        }
      }
    }
  }
  
  public void removeFromVerticalChain(int paramInt)
  {
    Constraint localConstraint;
    int i;
    int j;
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt)))
    {
      localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
      i = localConstraint.topToBottom;
      j = localConstraint.bottomToTop;
      if ((i != -1) || (j != -1))
      {
        if ((i == -1) || (j == -1)) {
          break label93;
        }
        connect(i, 4, j, 3, 0);
        connect(j, 3, i, 4, 0);
      }
    }
    for (;;)
    {
      clear(paramInt, 3);
      clear(paramInt, 4);
      return;
      label93:
      if ((i != -1) || (j != -1)) {
        if (localConstraint.bottomToBottom != -1) {
          connect(i, 4, localConstraint.bottomToBottom, 4, 0);
        } else if (localConstraint.topToTop != -1) {
          connect(j, 3, localConstraint.topToTop, 3, 0);
        }
      }
    }
  }
  
  public void setAlpha(int paramInt, float paramFloat)
  {
    get(paramInt).alpha = paramFloat;
  }
  
  public void setApplyElevation(int paramInt, boolean paramBoolean)
  {
    get(paramInt).applyElevation = paramBoolean;
  }
  
  public void setDimensionRatio(int paramInt, String paramString)
  {
    get(paramInt).dimensionRatio = paramString;
  }
  
  public void setElevation(int paramInt, float paramFloat)
  {
    get(paramInt).elevation = paramFloat;
    get(paramInt).applyElevation = true;
  }
  
  public void setGoneMargin(int paramInt1, int paramInt2, int paramInt3)
  {
    Constraint localConstraint = get(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 1: 
      localConstraint.goneLeftMargin = paramInt3;
      return;
    case 2: 
      localConstraint.goneRightMargin = paramInt3;
      return;
    case 3: 
      localConstraint.goneTopMargin = paramInt3;
      return;
    case 4: 
      localConstraint.goneBottomMargin = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 6: 
      localConstraint.goneStartMargin = paramInt3;
      return;
    }
    localConstraint.goneEndMargin = paramInt3;
  }
  
  public void setGuidelineBegin(int paramInt1, int paramInt2)
  {
    get(paramInt1).guideBegin = paramInt2;
    get(paramInt1).guideEnd = -1;
    get(paramInt1).guidePercent = -1.0F;
  }
  
  public void setGuidelineEnd(int paramInt1, int paramInt2)
  {
    get(paramInt1).guideEnd = paramInt2;
    get(paramInt1).guideBegin = -1;
    get(paramInt1).guidePercent = -1.0F;
  }
  
  public void setGuidelinePercent(int paramInt, float paramFloat)
  {
    get(paramInt).guidePercent = paramFloat;
    get(paramInt).guideEnd = -1;
    get(paramInt).guideBegin = -1;
  }
  
  public void setHorizontalBias(int paramInt, float paramFloat)
  {
    get(paramInt).horizontalBias = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt1, int paramInt2)
  {
    get(paramInt1).horizontalChainStyle = paramInt2;
  }
  
  public void setHorizontalWeight(int paramInt, float paramFloat)
  {
    get(paramInt).horizontalWeight = paramFloat;
  }
  
  public void setMargin(int paramInt1, int paramInt2, int paramInt3)
  {
    Constraint localConstraint = get(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 1: 
      localConstraint.leftMargin = paramInt3;
      return;
    case 2: 
      localConstraint.rightMargin = paramInt3;
      return;
    case 3: 
      localConstraint.topMargin = paramInt3;
      return;
    case 4: 
      localConstraint.bottomMargin = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 6: 
      localConstraint.startMargin = paramInt3;
      return;
    }
    localConstraint.endMargin = paramInt3;
  }
  
  public void setRotationX(int paramInt, float paramFloat)
  {
    get(paramInt).rotationX = paramFloat;
  }
  
  public void setRotationY(int paramInt, float paramFloat)
  {
    get(paramInt).rotationY = paramFloat;
  }
  
  public void setScaleX(int paramInt, float paramFloat)
  {
    get(paramInt).scaleX = paramFloat;
  }
  
  public void setScaleY(int paramInt, float paramFloat)
  {
    get(paramInt).scaleY = paramFloat;
  }
  
  public void setTransformPivot(int paramInt, float paramFloat1, float paramFloat2)
  {
    Constraint localConstraint = get(paramInt);
    localConstraint.transformPivotY = paramFloat2;
    localConstraint.transformPivotX = paramFloat1;
  }
  
  public void setTransformPivotX(int paramInt, float paramFloat)
  {
    get(paramInt).transformPivotX = paramFloat;
  }
  
  public void setTransformPivotY(int paramInt, float paramFloat)
  {
    get(paramInt).transformPivotY = paramFloat;
  }
  
  public void setTranslation(int paramInt, float paramFloat1, float paramFloat2)
  {
    Constraint localConstraint = get(paramInt);
    localConstraint.translationX = paramFloat1;
    localConstraint.translationY = paramFloat2;
  }
  
  public void setTranslationX(int paramInt, float paramFloat)
  {
    get(paramInt).translationX = paramFloat;
  }
  
  public void setTranslationY(int paramInt, float paramFloat)
  {
    get(paramInt).translationY = paramFloat;
  }
  
  public void setTranslationZ(int paramInt, float paramFloat)
  {
    get(paramInt).translationZ = paramFloat;
  }
  
  public void setVerticalBias(int paramInt, float paramFloat)
  {
    get(paramInt).verticalBias = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt1, int paramInt2)
  {
    get(paramInt1).verticalChainStyle = paramInt2;
  }
  
  public void setVerticalWeight(int paramInt, float paramFloat)
  {
    get(paramInt).verticalWeight = paramFloat;
  }
  
  public void setVisibility(int paramInt1, int paramInt2)
  {
    get(paramInt1).visibility = paramInt2;
  }
  
  private static class Constraint
  {
    static final int UNSET = -1;
    public float alpha = 1.0F;
    public boolean applyElevation = false;
    public int baselineToBaseline = -1;
    public int bottomMargin = -1;
    public int bottomToBottom = -1;
    public int bottomToTop = -1;
    public String dimensionRatio = null;
    public int editorAbsoluteX = -1;
    public int editorAbsoluteY = -1;
    public float elevation = 0.0F;
    public int endMargin = -1;
    public int endToEnd = -1;
    public int endToStart = -1;
    public int goneBottomMargin = -1;
    public int goneEndMargin = -1;
    public int goneLeftMargin = -1;
    public int goneRightMargin = -1;
    public int goneStartMargin = -1;
    public int goneTopMargin = -1;
    public int guideBegin = -1;
    public int guideEnd = -1;
    public float guidePercent = -1.0F;
    public int heightDefault = -1;
    public int heightMax = -1;
    public int heightMin = -1;
    public float horizontalBias = 0.5F;
    public int horizontalChainStyle = 0;
    public float horizontalWeight = 0.0F;
    public int leftMargin = -1;
    public int leftToLeft = -1;
    public int leftToRight = -1;
    public int mHeight;
    boolean mIsGuideline = false;
    int mViewId;
    public int mWidth;
    public int orientation = -1;
    public int rightMargin = -1;
    public int rightToLeft = -1;
    public int rightToRight = -1;
    public float rotationX = 0.0F;
    public float rotationY = 0.0F;
    public float scaleX = 1.0F;
    public float scaleY = 1.0F;
    public int startMargin = -1;
    public int startToEnd = -1;
    public int startToStart = -1;
    public int topMargin = -1;
    public int topToBottom = -1;
    public int topToTop = -1;
    public float transformPivotX = 0.0F;
    public float transformPivotY = 0.0F;
    public float translationX = 0.0F;
    public float translationY = 0.0F;
    public float translationZ = 0.0F;
    public float verticalBias = 0.5F;
    public int verticalChainStyle = 0;
    public float verticalWeight = 0.0F;
    public int visibility = 0;
    public int widthDefault = -1;
    public int widthMax = -1;
    public int widthMin = -1;
    
    private void fillFrom(int paramInt, ConstraintLayout.LayoutParams paramLayoutParams)
    {
      this.mViewId = paramInt;
      this.leftToLeft = paramLayoutParams.leftToLeft;
      this.leftToRight = paramLayoutParams.leftToRight;
      this.rightToLeft = paramLayoutParams.rightToLeft;
      this.rightToRight = paramLayoutParams.rightToRight;
      this.topToTop = paramLayoutParams.topToTop;
      this.topToBottom = paramLayoutParams.topToBottom;
      this.bottomToTop = paramLayoutParams.bottomToTop;
      this.bottomToBottom = paramLayoutParams.bottomToBottom;
      this.baselineToBaseline = paramLayoutParams.baselineToBaseline;
      this.startToEnd = paramLayoutParams.startToEnd;
      this.startToStart = paramLayoutParams.startToStart;
      this.endToStart = paramLayoutParams.endToStart;
      this.endToEnd = paramLayoutParams.endToEnd;
      this.horizontalBias = paramLayoutParams.horizontalBias;
      this.verticalBias = paramLayoutParams.verticalBias;
      this.dimensionRatio = paramLayoutParams.dimensionRatio;
      this.editorAbsoluteX = paramLayoutParams.editorAbsoluteX;
      this.editorAbsoluteY = paramLayoutParams.editorAbsoluteY;
      this.orientation = paramLayoutParams.orientation;
      this.guidePercent = paramLayoutParams.guidePercent;
      this.guideBegin = paramLayoutParams.guideBegin;
      this.guideEnd = paramLayoutParams.guideEnd;
      this.mWidth = paramLayoutParams.width;
      this.mHeight = paramLayoutParams.height;
      this.leftMargin = paramLayoutParams.leftMargin;
      this.rightMargin = paramLayoutParams.rightMargin;
      this.topMargin = paramLayoutParams.topMargin;
      this.bottomMargin = paramLayoutParams.bottomMargin;
      this.verticalWeight = paramLayoutParams.verticalWeight;
      this.horizontalWeight = paramLayoutParams.horizontalWeight;
      this.verticalChainStyle = paramLayoutParams.verticalChainStyle;
      this.horizontalChainStyle = paramLayoutParams.horizontalChainStyle;
      this.widthDefault = paramLayoutParams.matchConstraintDefaultWidth;
      this.heightDefault = paramLayoutParams.matchConstraintDefaultHeight;
      this.widthMax = paramLayoutParams.matchConstraintMaxWidth;
      this.heightMax = paramLayoutParams.matchConstraintMaxHeight;
      this.widthMin = paramLayoutParams.matchConstraintMinWidth;
      this.heightMin = paramLayoutParams.matchConstraintMinHeight;
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.endMargin = paramLayoutParams.getMarginEnd();
        this.startMargin = paramLayoutParams.getMarginStart();
      }
    }
    
    public void applyTo(ConstraintLayout.LayoutParams paramLayoutParams)
    {
      paramLayoutParams.leftToLeft = this.leftToLeft;
      paramLayoutParams.leftToRight = this.leftToRight;
      paramLayoutParams.rightToLeft = this.rightToLeft;
      paramLayoutParams.rightToRight = this.rightToRight;
      paramLayoutParams.topToTop = this.topToTop;
      paramLayoutParams.topToBottom = this.topToBottom;
      paramLayoutParams.bottomToTop = this.bottomToTop;
      paramLayoutParams.bottomToBottom = this.bottomToBottom;
      paramLayoutParams.baselineToBaseline = this.baselineToBaseline;
      paramLayoutParams.startToEnd = this.startToEnd;
      paramLayoutParams.startToStart = this.startToStart;
      paramLayoutParams.endToStart = this.endToStart;
      paramLayoutParams.endToEnd = this.endToEnd;
      paramLayoutParams.leftMargin = this.leftMargin;
      paramLayoutParams.rightMargin = this.rightMargin;
      paramLayoutParams.topMargin = this.topMargin;
      paramLayoutParams.bottomMargin = this.bottomMargin;
      paramLayoutParams.goneStartMargin = this.goneStartMargin;
      paramLayoutParams.goneEndMargin = this.goneEndMargin;
      paramLayoutParams.horizontalBias = this.horizontalBias;
      paramLayoutParams.verticalBias = this.verticalBias;
      paramLayoutParams.dimensionRatio = this.dimensionRatio;
      paramLayoutParams.editorAbsoluteX = this.editorAbsoluteX;
      paramLayoutParams.editorAbsoluteY = this.editorAbsoluteY;
      paramLayoutParams.verticalWeight = this.verticalWeight;
      paramLayoutParams.horizontalWeight = this.horizontalWeight;
      paramLayoutParams.verticalChainStyle = this.verticalChainStyle;
      paramLayoutParams.horizontalChainStyle = this.horizontalChainStyle;
      paramLayoutParams.matchConstraintDefaultWidth = this.widthDefault;
      paramLayoutParams.matchConstraintDefaultHeight = this.heightDefault;
      paramLayoutParams.matchConstraintMaxWidth = this.widthMax;
      paramLayoutParams.matchConstraintMaxHeight = this.heightMax;
      paramLayoutParams.matchConstraintMinWidth = this.widthMin;
      paramLayoutParams.matchConstraintMinHeight = this.heightMin;
      paramLayoutParams.orientation = this.orientation;
      paramLayoutParams.guidePercent = this.guidePercent;
      paramLayoutParams.guideBegin = this.guideBegin;
      paramLayoutParams.guideEnd = this.guideEnd;
      paramLayoutParams.width = this.mWidth;
      paramLayoutParams.height = this.mHeight;
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramLayoutParams.setMarginStart(this.startMargin);
        paramLayoutParams.setMarginEnd(this.endMargin);
      }
      paramLayoutParams.validate();
    }
    
    public Constraint clone()
    {
      Constraint localConstraint = new Constraint();
      localConstraint.mIsGuideline = this.mIsGuideline;
      localConstraint.mWidth = this.mWidth;
      localConstraint.mHeight = this.mHeight;
      localConstraint.guideBegin = this.guideBegin;
      localConstraint.guideEnd = this.guideEnd;
      localConstraint.guidePercent = this.guidePercent;
      localConstraint.leftToLeft = this.leftToLeft;
      localConstraint.leftToRight = this.leftToRight;
      localConstraint.rightToLeft = this.rightToLeft;
      localConstraint.rightToRight = this.rightToRight;
      localConstraint.topToTop = this.topToTop;
      localConstraint.topToBottom = this.topToBottom;
      localConstraint.bottomToTop = this.bottomToTop;
      localConstraint.bottomToBottom = this.bottomToBottom;
      localConstraint.baselineToBaseline = this.baselineToBaseline;
      localConstraint.startToEnd = this.startToEnd;
      localConstraint.startToStart = this.startToStart;
      localConstraint.endToStart = this.endToStart;
      localConstraint.endToEnd = this.endToEnd;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.verticalBias = this.verticalBias;
      localConstraint.dimensionRatio = this.dimensionRatio;
      localConstraint.editorAbsoluteX = this.editorAbsoluteX;
      localConstraint.editorAbsoluteY = this.editorAbsoluteY;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.orientation = this.orientation;
      localConstraint.leftMargin = this.leftMargin;
      localConstraint.rightMargin = this.rightMargin;
      localConstraint.topMargin = this.topMargin;
      localConstraint.bottomMargin = this.bottomMargin;
      localConstraint.endMargin = this.endMargin;
      localConstraint.startMargin = this.startMargin;
      localConstraint.visibility = this.visibility;
      localConstraint.goneLeftMargin = this.goneLeftMargin;
      localConstraint.goneTopMargin = this.goneTopMargin;
      localConstraint.goneRightMargin = this.goneRightMargin;
      localConstraint.goneBottomMargin = this.goneBottomMargin;
      localConstraint.goneEndMargin = this.goneEndMargin;
      localConstraint.goneStartMargin = this.goneStartMargin;
      localConstraint.verticalWeight = this.verticalWeight;
      localConstraint.horizontalWeight = this.horizontalWeight;
      localConstraint.horizontalChainStyle = this.horizontalChainStyle;
      localConstraint.verticalChainStyle = this.verticalChainStyle;
      localConstraint.alpha = this.alpha;
      localConstraint.applyElevation = this.applyElevation;
      localConstraint.elevation = this.elevation;
      localConstraint.rotationX = this.rotationX;
      localConstraint.rotationY = this.rotationY;
      localConstraint.scaleX = this.scaleX;
      localConstraint.scaleY = this.scaleY;
      localConstraint.transformPivotX = this.transformPivotX;
      localConstraint.transformPivotY = this.transformPivotY;
      localConstraint.translationX = this.translationX;
      localConstraint.translationY = this.translationY;
      localConstraint.translationZ = this.translationZ;
      localConstraint.widthDefault = this.widthDefault;
      localConstraint.heightDefault = this.heightDefault;
      localConstraint.widthMax = this.widthMax;
      localConstraint.heightMax = this.heightMax;
      localConstraint.widthMin = this.widthMin;
      localConstraint.heightMin = this.heightMin;
      return localConstraint;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/constraint/ConstraintSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */