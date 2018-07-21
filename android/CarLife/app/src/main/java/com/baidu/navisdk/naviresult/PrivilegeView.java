package com.baidu.navisdk.naviresult;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel.NaviEndPrivilege;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.drawable.UrlDrawableContainIView;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class PrivilegeView
{
  private static final int ICONS_MAX = 4;
  private View iconsContainer;
  private ImageView[] iconsList;
  private Activity mActivity;
  private BusinessActivityModel.NaviEndPrivilege mData;
  private View privilegeBtn;
  private ImageView privilegeBtnIcon;
  private TextView privilegeBtnTv;
  private TextView privilegeDesp;
  private TextView privilegeDue;
  private LinearLayout rootView = null;
  private View shade;
  private View textContainer;
  private TextView title;
  
  public PrivilegeView(Activity paramActivity, BusinessActivityModel.NaviEndPrivilege paramNaviEndPrivilege)
  {
    this.mActivity = paramActivity;
    this.mData = paramNaviEndPrivilege;
  }
  
  private void findViews()
  {
    if (this.rootView == null) {
      return;
    }
    this.title = ((TextView)this.rootView.findViewById(1711866307));
    this.iconsContainer = this.rootView.findViewById(1711866309);
    ImageView localImageView1 = (ImageView)this.rootView.findViewById(1711866311);
    ImageView localImageView2 = (ImageView)this.rootView.findViewById(1711866313);
    ImageView localImageView3 = (ImageView)this.rootView.findViewById(1711866315);
    ImageView localImageView4 = (ImageView)this.rootView.findViewById(1711866317);
    this.shade = this.rootView.findViewById(1711866318);
    this.textContainer = this.rootView.findViewById(1711866319);
    this.privilegeDesp = ((TextView)this.rootView.findViewById(1711866320));
    this.privilegeDue = ((TextView)this.rootView.findViewById(1711866321));
    this.privilegeBtn = this.rootView.findViewById(1711866322);
    this.privilegeBtnIcon = ((ImageView)this.rootView.findViewById(1711866323));
    this.privilegeBtnTv = ((TextView)this.rootView.findViewById(1711866324));
    this.iconsList = new ImageView[4];
    this.iconsList[0] = localImageView1;
    this.iconsList[1] = localImageView2;
    this.iconsList[2] = localImageView3;
    this.iconsList[3] = localImageView4;
  }
  
  private void onDataSetChanged()
  {
    LogUtil.e("PrivilegeView", "onDataSetChanged: mData --> " + this.mData.toString());
    boolean bool;
    Object localObject;
    if (this.mData.unlock == 1)
    {
      bool = true;
      if (bool) {
        this.rootView.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if ("text".equals(PrivilegeView.this.mData.cardType)) {
              UserOPController.getInstance().add("6.8");
            }
            for (;;)
            {
              BNNaviResultController.getInstance().openWithOpenAPI(PrivilegeView.this.mData.hlink);
              return;
              if ("pic".equals(PrivilegeView.this.mData.cardType)) {
                UserOPController.getInstance().add("6.9");
              }
            }
          }
        });
      }
      TextView localTextView;
      if (this.title != null)
      {
        localTextView = this.title;
        if (this.mData.hint != null) {
          break label316;
        }
        localObject = "";
        label88:
        localTextView.setText((CharSequence)localObject);
      }
      if (this.privilegeBtnTv != null)
      {
        localTextView = this.privilegeBtnTv;
        if (this.mData.tip != null) {
          break label327;
        }
        localObject = "";
        label120:
        localTextView.setText((CharSequence)localObject);
      }
      if (this.privilegeBtn != null) {
        this.privilegeBtn.setEnabled(bool);
      }
      if (this.privilegeBtnIcon != null) {
        UrlDrawableContainIView.getDrawable(this.mData.hicon, 1711408007, this.privilegeBtnIcon, new Handler(Looper.getMainLooper())
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            super.handleMessage(paramAnonymousMessage);
            if (paramAnonymousMessage.what == 8192)
            {
              if (paramAnonymousMessage.arg1 == 0) {
                PrivilegeView.this.privilegeBtnIcon.setVisibility(0);
              }
            }
            else {
              return;
            }
            PrivilegeView.this.privilegeBtnIcon.setVisibility(8);
          }
        });
      }
      if (!"text".equals(this.mData.cardType)) {
        break label348;
      }
      if (this.textContainer != null) {
        this.textContainer.setVisibility(0);
      }
      if ((this.mData.list != null) && (this.privilegeDesp != null) && (this.privilegeDue != null))
      {
        if (this.mData.list.length > 0)
        {
          localObject = Html.fromHtml(this.mData.list[0]);
          if (localObject != null) {
            this.privilegeDesp.setText((CharSequence)localObject);
          }
        }
        if (this.mData.list.length <= 1) {
          break label338;
        }
        localObject = Html.fromHtml(this.mData.list[1]);
        if (localObject != null)
        {
          this.privilegeDue.setText((CharSequence)localObject);
          this.privilegeDue.setVisibility(0);
        }
      }
    }
    label316:
    label327:
    label338:
    label348:
    while (!"pic".equals(this.mData.cardType))
    {
      return;
      bool = false;
      break;
      localObject = this.mData.hint;
      break label88;
      localObject = this.mData.tip;
      break label120;
      this.privilegeDue.setVisibility(8);
      return;
    }
    if (this.iconsContainer != null) {
      this.iconsContainer.setVisibility(0);
    }
    if (this.shade != null)
    {
      localObject = this.shade;
      if (!bool) {
        break label464;
      }
    }
    label464:
    for (int i = 8;; i = 0)
    {
      ((View)localObject).setVisibility(i);
      if ((this.mData.list == null) || (this.iconsList == null)) {
        break;
      }
      i = 0;
      while ((i < this.mData.list.length) && (i < 4))
      {
        setupUrlDrawable(this.iconsList[i], this.mData.list[i]);
        i += 1;
      }
      break;
    }
  }
  
  private void setupUrlDrawable(ImageView paramImageView, final String paramString)
  {
    if (paramImageView == null) {
      return;
    }
    UrlDrawableContainIView.getDrawable(paramString, 1711407326, paramImageView, new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        super.handleMessage(paramAnonymousMessage);
        if ((paramAnonymousMessage.what != 8192) || (paramAnonymousMessage.arg1 == 0)) {
          return;
        }
        LogUtil.e("PrivilegeView", "setupUrlDrawable: Fail --> url: " + paramString);
      }
    });
  }
  
  public void clearImgData()
  {
    if (this.iconsList != null)
    {
      int i = 0;
      while (i < this.iconsList.length)
      {
        if (this.iconsList[i] != null) {
          UIUtils.releaseImageViewWithoutNull(this.iconsList[i]);
        }
        i += 1;
      }
    }
  }
  
  public LinearLayout getView()
  {
    if ((this.mActivity == null) || (this.mData == null)) {}
    View localView;
    do
    {
      return null;
      localView = JarUtils.inflate(this.mActivity, 1711472687, null);
    } while (localView == null);
    this.rootView = ((LinearLayout)localView);
    findViews();
    onDataSetChanged();
    return this.rootView;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/naviresult/PrivilegeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */