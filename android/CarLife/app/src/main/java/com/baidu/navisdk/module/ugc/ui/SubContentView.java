package com.baidu.navisdk.module.ugc.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public abstract class SubContentView
  implements View.OnClickListener, SubContentContract.View
{
  private static final int TEXT_MAX_LENGTH = 40;
  private EditText descriEditText = null;
  private ViewGroup[] detailContainerArr = new ViewGroup[4];
  private View detailFlagTv = null;
  private View detailLayout = null;
  private View[] detailSpaceViewArr = new View[3];
  private ViewGroup[] laneContainerArr = new ViewGroup[4];
  protected View laneLayout = null;
  private View[] laneSpaceViewArr = new View[3];
  TextWatcher mContentTextWatcher = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      SubContentView.this.descriEditText.getSelectionStart();
      SubContentView.this.descriEditText.getSelectionEnd();
      int i;
      if (paramAnonymousEditable.length() > 40) {
        i = 1;
      }
      for (;;)
      {
        if (SubContentView.this.soundsGetIv != null)
        {
          if ((SubContentView.this.soundsGetIv != null) && (paramAnonymousEditable != null) && (paramAnonymousEditable.length() > 0)) {
            SubContentView.this.soundsGetIv.setBackgroundDrawable(BNStyleManager.getDrawable(1711408142));
          }
        }
        else if (i != 0) {
          paramAnonymousEditable = SubContentView.this.descriEditText.getText().toString();
        }
        try
        {
          SubContentView.this.descriEditText.setText(paramAnonymousEditable.substring(0, 40));
          TipTool.onCreateToastDialog(SubContentView.this.mContext, JarUtils.getResources().getString(1711670292));
          if (SubContentView.this.mPresenter != null) {
            SubContentView.this.mPresenter.recordContentChange(SubContentView.this.descriEditText.getText().toString());
          }
          return;
          i = 0;
          continue;
          SubContentView.this.soundsGetIv.setBackgroundDrawable(BNStyleManager.getDrawable(1711408143));
        }
        catch (Exception paramAnonymousEditable)
        {
          for (;;) {}
        }
      }
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  protected Context mContext = null;
  private View.OnFocusChangeListener mOnFocusChangeListener = new View.OnFocusChangeListener()
  {
    public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      if (!paramAnonymousBoolean) {
        SubContentView.this.hideInputMethod();
      }
    }
  };
  private int mOrientation = 2;
  private SubContentContract.Presenter mPresenter = null;
  private ImageView photoDeletedIv = null;
  private ImageView photoGetIv = null;
  private ImageView photoShowIv = null;
  private View photoShowLayout = null;
  private ViewGroup[] positionContainerArr = new ViewGroup[4];
  private View positionLayout = null;
  private View[] positionSpaceViewArr = new View[3];
  protected View rootView = null;
  private TextView soundsDecTv = null;
  private ImageView soundsGetIv = null;
  private ImageView subTitleIv = null;
  private TextView subTitleStrIv = null;
  private Button uploadCommonBtn = null;
  private Button uploadNaviBtn = null;
  private View.OnClickListener viewGroupListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if ((SubContentView.this.laneContainerArr == null) || (SubContentView.this.positionContainerArr == null) || (SubContentView.this.detailContainerArr == null)) {
        return;
      }
      try
      {
        paramAnonymousView = (ViewGroup)paramAnonymousView;
        SubContentView.this.proccessViewGroupClickPerform(paramAnonymousView);
        return;
      }
      catch (Exception paramAnonymousView)
      {
        paramAnonymousView.printStackTrace();
      }
    }
  };
  
  public SubContentView(Context paramContext)
  {
    this(paramContext, 1);
  }
  
  public SubContentView(Context paramContext, int paramInt)
  {
    initVariable(paramContext, paramInt);
    initView();
    initListener();
  }
  
  private void initListener()
  {
    if (this.photoGetIv != null) {
      this.photoGetIv.setOnClickListener(this);
    }
    if (this.photoDeletedIv != null) {
      this.photoDeletedIv.setOnClickListener(this);
    }
    if (this.soundsGetIv != null) {
      this.soundsGetIv.setOnClickListener(this);
    }
    if (this.descriEditText != null) {
      this.descriEditText.setOnFocusChangeListener(this.mOnFocusChangeListener);
    }
  }
  
  private void initVariable(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mOrientation = paramInt;
  }
  
  private void initView()
  {
    if (this.mOrientation == 1) {}
    for (this.rootView = JarUtils.inflate((Activity)this.mContext, 1711472767, null); this.rootView == null; this.rootView = JarUtils.inflate((Activity)this.mContext, 1711472768, null)) {
      return;
    }
    if ((this.laneContainerArr != null) && (this.laneContainerArr.length >= 4))
    {
      this.laneContainerArr[0] = ((ViewGroup)this.rootView.findViewById(1711867149));
      this.laneContainerArr[1] = ((ViewGroup)this.rootView.findViewById(1711867152));
      this.laneContainerArr[2] = ((ViewGroup)this.rootView.findViewById(1711867155));
      this.laneContainerArr[3] = ((ViewGroup)this.rootView.findViewById(1711867158));
      if ((this.laneContainerArr[0] != null) && (this.laneContainerArr[1] != null) && (this.laneContainerArr[2] != null) && (this.laneContainerArr[3] != null))
      {
        this.laneContainerArr[0].setTag(this.rootView.findViewById(1711867150));
        this.laneContainerArr[1].setTag(this.rootView.findViewById(1711867153));
        this.laneContainerArr[2].setTag(this.rootView.findViewById(1711867156));
        this.laneContainerArr[3].setTag(this.rootView.findViewById(1711867159));
      }
    }
    if ((this.laneSpaceViewArr != null) && (this.laneSpaceViewArr.length >= 3))
    {
      this.laneSpaceViewArr[0] = this.rootView.findViewById(1711867151);
      this.laneSpaceViewArr[1] = this.rootView.findViewById(1711867154);
      this.laneSpaceViewArr[2] = this.rootView.findViewById(1711867157);
    }
    if ((this.positionContainerArr != null) && (this.positionContainerArr.length >= 4))
    {
      this.positionContainerArr[0] = ((ViewGroup)this.rootView.findViewById(1711867162));
      this.positionContainerArr[1] = ((ViewGroup)this.rootView.findViewById(1711867165));
      this.positionContainerArr[2] = ((ViewGroup)this.rootView.findViewById(1711867168));
      this.positionContainerArr[3] = ((ViewGroup)this.rootView.findViewById(1711867171));
      if ((this.positionContainerArr[0] != null) && (this.positionContainerArr[1] != null) && (this.positionContainerArr[2] != null) && (this.positionContainerArr[3] != null))
      {
        this.positionContainerArr[0].setTag(this.rootView.findViewById(1711867163));
        this.positionContainerArr[1].setTag(this.rootView.findViewById(1711867166));
        this.positionContainerArr[2].setTag(this.rootView.findViewById(1711867169));
        this.positionContainerArr[3].setTag(this.rootView.findViewById(1711867172));
      }
    }
    if ((this.positionSpaceViewArr != null) && (this.positionSpaceViewArr.length >= 3))
    {
      this.positionSpaceViewArr[0] = this.rootView.findViewById(1711867164);
      this.positionSpaceViewArr[1] = this.rootView.findViewById(1711867167);
      this.positionSpaceViewArr[2] = this.rootView.findViewById(1711867170);
    }
    if ((this.detailContainerArr != null) && (this.detailContainerArr.length >= 4))
    {
      this.detailContainerArr[0] = ((ViewGroup)this.rootView.findViewById(1711867176));
      this.detailContainerArr[1] = ((ViewGroup)this.rootView.findViewById(1711867179));
      this.detailContainerArr[2] = ((ViewGroup)this.rootView.findViewById(1711867182));
      this.detailContainerArr[3] = ((ViewGroup)this.rootView.findViewById(1711867185));
      if ((this.detailContainerArr[0] != null) && (this.detailContainerArr[1] != null) && (this.detailContainerArr[2] != null) && (this.detailContainerArr[3] != null))
      {
        this.detailContainerArr[0].setTag(this.rootView.findViewById(1711867177));
        this.detailContainerArr[1].setTag(this.rootView.findViewById(1711867180));
        this.detailContainerArr[2].setTag(this.rootView.findViewById(1711867183));
        this.detailContainerArr[3].setTag(this.rootView.findViewById(1711867186));
      }
    }
    if ((this.detailSpaceViewArr != null) && (this.detailSpaceViewArr.length >= 3))
    {
      this.detailSpaceViewArr[0] = this.rootView.findViewById(1711867178);
      this.detailSpaceViewArr[1] = this.rootView.findViewById(1711867181);
      this.detailSpaceViewArr[2] = this.rootView.findViewById(1711867184);
    }
    this.detailLayout = this.rootView.findViewById(1711867173);
    this.positionLayout = this.rootView.findViewById(1711867160);
    this.laneLayout = this.rootView.findViewById(1711867147);
    this.subTitleIv = ((ImageView)this.rootView.findViewById(1711867140));
    this.subTitleStrIv = ((TextView)this.rootView.findViewById(1711867141));
    this.descriEditText = ((EditText)this.rootView.findViewById(1711867188));
    this.photoGetIv = ((ImageView)this.rootView.findViewById(1711866997));
    this.soundsGetIv = ((ImageView)this.rootView.findViewById(1711867190));
    this.photoShowLayout = this.rootView.findViewById(1711867001);
    this.photoShowIv = ((ImageView)this.rootView.findViewById(1711867002));
    this.photoDeletedIv = ((ImageView)this.rootView.findViewById(1711867003));
    this.soundsDecTv = ((TextView)this.rootView.findViewById(1711867189));
    this.detailFlagTv = this.rootView.findViewById(1711867174);
    this.descriEditText.addTextChangedListener(this.mContentTextWatcher);
    this.descriEditText.setHintTextColor(Color.parseColor("#999999"));
    this.uploadCommonBtn = ((Button)this.rootView.findViewById(1711867191));
    this.uploadNaviBtn = ((Button)this.rootView.findViewById(1711867195));
    showPhotoCancle();
  }
  
  private void initViewGroupLayout(int paramInt, ViewGroup[] paramArrayOfViewGroup, View paramView, View[] paramArrayOfView)
  {
    if ((paramArrayOfViewGroup == null) || (paramView == null) || (this.mPresenter == null) || (paramArrayOfView == null)) {}
    for (;;)
    {
      return;
      if (paramInt <= 0)
      {
        paramView.setVisibility(8);
        return;
      }
      int i = 0;
      if ((i < paramInt) && (i < paramArrayOfViewGroup.length))
      {
        if (paramArrayOfViewGroup[i] != null)
        {
          paramArrayOfViewGroup[i].setVisibility(0);
          paramArrayOfViewGroup[i].setOnClickListener(this.viewGroupListener);
          if (paramArrayOfViewGroup != this.laneContainerArr) {
            break label110;
          }
          setViewGroupText(paramArrayOfViewGroup[i], this.mPresenter.getLaneInfoGvTextTile(i));
        }
        for (;;)
        {
          i += 1;
          break;
          label110:
          if (paramArrayOfViewGroup == this.positionContainerArr) {
            setViewGroupText(paramArrayOfViewGroup[i], this.mPresenter.getPositionInfoGvTextTile(i));
          } else if (paramArrayOfViewGroup == this.detailContainerArr) {
            setViewGroupText(paramArrayOfViewGroup[i], this.mPresenter.getDetailGvTextTile(i));
          }
        }
      }
      i = paramInt;
      while (i < paramArrayOfViewGroup.length)
      {
        if (paramArrayOfViewGroup[i] != null) {
          paramArrayOfViewGroup[i].setVisibility(8);
        }
        i += 1;
      }
      i = 0;
      while ((i < paramInt - 1) && (i < paramArrayOfView.length))
      {
        if (paramArrayOfView[i] != null) {
          paramArrayOfView[i].setVisibility(0);
        }
        i += 1;
      }
      paramInt -= 1;
      while ((paramInt >= 0) && (paramInt < paramArrayOfView.length))
      {
        if (paramArrayOfView[paramInt] != null) {
          paramArrayOfView[paramInt].setVisibility(8);
        }
        paramInt += 1;
      }
    }
  }
  
  private void proccessViewGroupClickPerform(ViewGroup paramViewGroup)
  {
    if ((this.laneContainerArr == null) || (this.positionContainerArr == null) || (this.detailContainerArr == null)) {}
    Object localObject3;
    Object localObject4;
    int j;
    label200:
    do
    {
      return;
      localObject3 = null;
      localObject4 = null;
      int k = -1;
      j = 0;
      int i = k;
      Object localObject2 = localObject4;
      Object localObject1 = localObject3;
      if (j < this.laneContainerArr.length)
      {
        if (this.laneContainerArr[j] == paramViewGroup)
        {
          localObject1 = this.laneContainerArr;
          localObject2 = this.laneContainerArr[j];
          i = j;
        }
      }
      else {
        k = 0;
      }
      for (;;)
      {
        j = i;
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (i < 0)
        {
          j = i;
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (k < this.positionContainerArr.length)
          {
            if (this.positionContainerArr[k] != paramViewGroup) {
              break label200;
            }
            localObject4 = this.positionContainerArr;
            localObject3 = this.positionContainerArr[k];
            j = k;
          }
        }
        i = 0;
        while ((j < 0) && (i < this.detailContainerArr.length))
        {
          if (this.detailContainerArr[i] == paramViewGroup)
          {
            localObject4 = this.detailContainerArr;
            localObject3 = this.detailContainerArr[i];
            j = i;
          }
          i += 1;
        }
        j += 1;
        break;
        k += 1;
      }
    } while ((localObject4 == null) || (j < 0));
    if (((View)((ViewGroup)localObject3).getTag()).getTag() == null)
    {
      updateContainerStatusView(j, (ViewGroup[])localObject4);
      recordClickStatus(j, (ViewGroup[])localObject4);
      ((View)((ViewGroup)localObject3).getTag()).setTag(new Object());
      return;
    }
    updateContainerStatusView(-1, (ViewGroup[])localObject4);
    recordClickStatus(-1, (ViewGroup[])localObject4);
    ((View)((ViewGroup)localObject3).getTag()).setTag(null);
  }
  
  private void recordClickStatus(int paramInt, ViewGroup[] paramArrayOfViewGroup)
  {
    if (this.mPresenter != null)
    {
      if (paramArrayOfViewGroup != this.laneContainerArr) {
        break label26;
      }
      this.mPresenter.recordLaneSelected(paramInt);
    }
    label26:
    do
    {
      return;
      if (paramArrayOfViewGroup == this.positionContainerArr)
      {
        this.mPresenter.recordPositionSelected(paramInt);
        return;
      }
    } while (paramArrayOfViewGroup != this.detailContainerArr);
    this.mPresenter.recordDetailSelected(paramInt);
  }
  
  private void setViewGroupText(ViewGroup paramViewGroup, String paramString)
  {
    if ((paramViewGroup == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    try
    {
      ((TextView)paramViewGroup.getTag()).setText(paramString);
      return;
    }
    catch (Exception paramViewGroup)
    {
      paramViewGroup.printStackTrace();
    }
  }
  
  private void updateContainerStatusView(int paramInt, ViewGroup[] paramArrayOfViewGroup)
  {
    if (paramArrayOfViewGroup != null)
    {
      int i = 0;
      if (i < paramArrayOfViewGroup.length)
      {
        Object localObject = paramArrayOfViewGroup[i];
        if (i == paramInt)
        {
          LogUtil.e("updateContainerStatusView click:", paramInt + "" + paramArrayOfViewGroup.toString());
          paramArrayOfViewGroup[i].setBackgroundDrawable(BNStyleManager.getDrawable(1711407810));
          localObject = (TextView)paramArrayOfViewGroup[i].getTag();
          ((TextView)localObject).setTag(new Object());
          ((TextView)localObject).setTextColor(BNStyleManager.getColor(1711800673));
        }
        for (;;)
        {
          i += 1;
          break;
          LogUtil.e("updateContainerStatusView click:", paramInt + "" + paramArrayOfViewGroup.toString());
          paramArrayOfViewGroup[i].setBackgroundDrawable(BNStyleManager.getDrawable(1711407811));
          localObject = (TextView)paramArrayOfViewGroup[i].getTag();
          ((TextView)localObject).setTag(null);
          ((TextView)localObject).setTextColor(BNStyleManager.getColor(1711800672));
        }
      }
    }
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public View getParentView()
  {
    return this.rootView;
  }
  
  public void hideInputMethod()
  {
    if (this.descriEditText != null) {
      ((InputMethodManager)BNaviModuleManager.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.descriEditText.getWindowToken(), 0);
    }
  }
  
  public void initPresenterView()
  {
    if (this.mPresenter == null) {
      return;
    }
    if (this.subTitleIv != null) {
      new UgcImageLoaderUtils().updateUgcViewOnLine(this.mPresenter.getSubType(), this.subTitleIv);
    }
    if (this.subTitleStrIv != null) {
      this.subTitleStrIv.setText(this.mPresenter.getSubTitleText());
    }
    if (this.descriEditText != null) {
      this.descriEditText.setHint("点击填写描述...");
    }
    initViewGroupLayout(this.mPresenter.getLaneInfoGvSize(), this.laneContainerArr, this.laneLayout, this.laneSpaceViewArr);
    initViewGroupLayout(this.mPresenter.getPositionInfoGvSize(), this.positionContainerArr, this.positionLayout, this.positionSpaceViewArr);
    initViewGroupLayout(this.mPresenter.getDetailGvSize(), this.detailContainerArr, this.detailLayout, this.detailSpaceViewArr);
    updateContainerStatusView(-1, this.laneContainerArr);
    updateContainerStatusView(-1, this.positionContainerArr);
    updateContainerStatusView(-1, this.detailContainerArr);
  }
  
  public void onClick(View paramView)
  {
    if (this.mPresenter == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 1711866997: 
      this.mPresenter.gotoPhotoCapture();
      return;
    case 1711867003: 
      this.mPresenter.deletePhotoShow();
      return;
    }
    if ((this.soundsDecTv.getVisibility() == 8) && (this.descriEditText != null) && (TextUtils.isEmpty(this.descriEditText.getText())))
    {
      this.mPresenter.gotoSoundsRecordDialog();
      return;
    }
    this.mPresenter.deletSoundShow();
  }
  
  public void setDescriEditHintText(String paramString)
  {
    if (this.descriEditText != null)
    {
      this.descriEditText.setHint(paramString);
      this.descriEditText.setVisibility(4);
    }
  }
  
  public void setDescriEditText(String paramString)
  {
    if (this.descriEditText != null) {
      this.descriEditText.setText(paramString);
    }
    if (this.mPresenter != null) {
      this.mPresenter.recordContentChange(this.descriEditText.getText().toString());
    }
  }
  
  public void setDetailFlagVisibility(boolean paramBoolean)
  {
    if (this.detailFlagTv != null)
    {
      if (paramBoolean) {
        this.detailFlagTv.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.detailFlagTv.setVisibility(8);
  }
  
  public void setPositionLayout(boolean paramBoolean)
  {
    if (this.positionLayout != null)
    {
      if (paramBoolean) {
        this.positionLayout.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.positionLayout.setVisibility(8);
  }
  
  public void setPresenter(SubContentContract.Presenter paramPresenter)
  {
    this.mPresenter = paramPresenter;
  }
  
  public void setUploadBtnClickable(boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.uploadCommonBtn != null) && (this.uploadNaviBtn != null))
      {
        this.uploadCommonBtn.setClickable(true);
        this.uploadNaviBtn.setClickable(true);
        this.uploadCommonBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407140));
        this.uploadNaviBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407140));
      }
    }
    while ((this.uploadCommonBtn == null) || (this.uploadNaviBtn == null)) {
      return;
    }
    this.uploadCommonBtn.setClickable(false);
    this.uploadNaviBtn.setClickable(false);
    this.uploadCommonBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407142));
    this.uploadNaviBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407142));
  }
  
  public void showAddrInfoUpdate(String paramString1, String paramString2) {}
  
  public void showPhotoBitmap(Bitmap paramBitmap)
  {
    if ((this.photoShowLayout == null) || (this.photoShowIv == null) || (this.photoDeletedIv == null) || (this.photoGetIv == null) || (paramBitmap == null)) {
      return;
    }
    this.photoShowLayout.setVisibility(0);
    this.photoGetIv.setVisibility(8);
    this.photoShowIv.setImageBitmap(paramBitmap);
  }
  
  public void showPhotoCancle()
  {
    if ((this.photoShowLayout == null) || (this.photoGetIv == null)) {
      return;
    }
    this.photoShowLayout.setVisibility(8);
    this.photoGetIv.setVisibility(0);
  }
  
  public void showPhotoGraph(Bitmap paramBitmap) {}
  
  public void showRecordResult(int paramInt)
  {
    if ((this.soundsDecTv == null) || (this.descriEditText == null) || (this.soundsGetIv == null)) {
      return;
    }
    this.descriEditText.setVisibility(8);
    this.soundsDecTv.setVisibility(0);
    this.soundsGetIv.setBackgroundDrawable(BNStyleManager.getDrawable(1711408142));
    this.soundsDecTv.setText(Html.fromHtml("语音描述  <font color=\"#3a86fd\"> " + paramInt + " \""));
  }
  
  public void showSoundCancle()
  {
    if ((this.soundsDecTv == null) || (this.descriEditText == null) || (this.soundsGetIv == null)) {
      return;
    }
    this.descriEditText.setVisibility(0);
    this.descriEditText.setText("");
    this.descriEditText.setHint("点击填写描述...");
    this.soundsDecTv.setVisibility(8);
    this.soundsGetIv.setBackgroundDrawable(BNStyleManager.getDrawable(1711408143));
  }
  
  public void updateSubContainerStatus(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      updateContainerStatusView(paramInt1, this.laneContainerArr);
      recordClickStatus(paramInt1, this.laneContainerArr);
    }
    do
    {
      return;
      if (paramInt2 == 1)
      {
        updateContainerStatusView(paramInt1, this.positionContainerArr);
        recordClickStatus(paramInt1, this.positionContainerArr);
        return;
      }
    } while (paramInt2 != 2);
    updateContainerStatusView(paramInt1, this.detailContainerArr);
    recordClickStatus(paramInt1, this.detailContainerArr);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/SubContentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */