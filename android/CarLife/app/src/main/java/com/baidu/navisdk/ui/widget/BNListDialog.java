package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class BNListDialog
  extends BNDialog
{
  private Activity mActivity;
  private ListView mListView;
  
  public BNListDialog(Activity paramActivity)
  {
    super(paramActivity);
    this.mActivity = paramActivity;
    paramActivity = JarUtils.inflate(paramActivity, 1711472649, null);
    this.mListView = ((ListView)paramActivity.findViewById(1711865875));
    setContentList(paramActivity);
  }
  
  public BNListDialog enableBackKey(boolean paramBoolean)
  {
    super.enableBackKey(paramBoolean);
    return this;
  }
  
  public ListView getListView()
  {
    return this.mListView;
  }
  
  public BNListDialog setAdapter(ListAdapter paramListAdapter)
  {
    this.mListView.setAdapter(paramListAdapter);
    return this;
  }
  
  public BNListDialog setContentList(View paramView)
  {
    super.setContentList(paramView);
    return this;
  }
  
  public BNListDialog setFirstBtnEnabled(boolean paramBoolean)
  {
    super.setFirstBtnEnabled(paramBoolean);
    return this;
  }
  
  public BNListDialog setFirstBtnText(int paramInt)
  {
    super.setFirstBtnText(paramInt);
    return this;
  }
  
  public BNListDialog setFirstBtnText(String paramString)
  {
    super.setFirstBtnText(paramString);
    return this;
  }
  
  public void setListAdapter(ArrayList<String> paramArrayList)
  {
    paramArrayList = new InnerListAdapter(paramArrayList);
    this.mListView.setAdapter(paramArrayList);
  }
  
  public BNListDialog setListHeight(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.mListView.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.mListView.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public BNListDialog setListSelection(int paramInt)
  {
    this.mListView.setSelection(paramInt);
    return this;
  }
  
  public BNListDialog setListTitleText(String paramString)
  {
    super.setListTitleText(paramString);
    return this;
  }
  
  public BNListDialog setListWidth(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.mListView.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.mListView.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public BNListDialog setOnFirstBtnClickListener(BNDialog.OnNaviClickListener paramOnNaviClickListener)
  {
    super.setOnFirstBtnClickListener(paramOnNaviClickListener);
    return this;
  }
  
  public BNListDialog setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mListView.setOnItemClickListener(paramOnItemClickListener);
    return this;
  }
  
  public BNListDialog setOnSecondBtnClickListener(BNDialog.OnNaviClickListener paramOnNaviClickListener)
  {
    super.setOnSecondBtnClickListener(paramOnNaviClickListener);
    return this;
  }
  
  public BNListDialog setSecondBtnEnabled(boolean paramBoolean)
  {
    super.setSecondBtnEnabled(paramBoolean);
    return this;
  }
  
  public BNListDialog setSecondBtnText(int paramInt)
  {
    super.setSecondBtnText(paramInt);
    return this;
  }
  
  public BNListDialog setSecondBtnText(String paramString)
  {
    super.setSecondBtnText(paramString);
    return this;
  }
  
  public BNListDialog setTitleText(int paramInt)
  {
    super.setTitleText(paramInt);
    return this;
  }
  
  public BNListDialog setTitleText(String paramString)
  {
    super.setTitleText(paramString);
    return this;
  }
  
  public class InnerListAdapter
    extends BaseAdapter
  {
    private ArrayList<String> mDataList = new ArrayList();
    
    public InnerListAdapter()
    {
      int i = 0;
      Object localObject;
      while (i < ((ArrayList)localObject).size())
      {
        this.mDataList.add(((ArrayList)localObject).get(i));
        i += 1;
      }
    }
    
    public int getCount()
    {
      if ((this.mDataList != null) && (this.mDataList.size() > 0)) {
        return this.mDataList.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if ((this.mDataList != null) && (paramInt >= 0) && (paramInt < this.mDataList.size())) {
        return this.mDataList.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = JarUtils.inflate(BNListDialog.this.mActivity, 1711472791, null);
        paramViewGroup = (TextView)paramView.findViewById(1711865859);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        if ((this.mDataList != null) && (paramInt >= 0) && (paramInt < this.mDataList.size())) {
          paramViewGroup.setText((CharSequence)this.mDataList.get(paramInt));
        }
        if (paramInt != getCount() - 1) {
          break;
        }
        paramViewGroup.setTextColor(BNStyleManager.getColor(1711800396));
        paramView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407371));
        return paramView;
        paramViewGroup = (TextView)paramView.getTag();
      }
      paramViewGroup.setTextColor(BNStyleManager.getColor(1711800396));
      paramView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407374));
      return paramView;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNListDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */