package com.baidu.navisdk.debug.commonui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

public class DebugCommonUIView
{
  private DebugListViewAdapter mAdapter = null;
  private DebugCommonUICallback mCallback = null;
  private int mIndex = 1;
  private TextView mInfoTV = null;
  private ListView mKeyValueLV = null;
  private String mOldInfo = "";
  private Button mRefreshBtn = null;
  private View mRootView = null;
  
  public DebugCommonUIView(DebugCommonUICallback paramDebugCommonUICallback)
  {
    this.mCallback = paramDebugCommonUICallback;
    init();
  }
  
  private void init()
  {
    this.mRootView = JarUtils.inflate(BNaviModuleManager.getActivity(), 1711472642, null);
    this.mRefreshBtn = ((Button)this.mRootView.findViewById(1711865860));
    this.mInfoTV = ((TextView)this.mRootView.findViewById(1711865861));
    this.mKeyValueLV = ((ListView)this.mRootView.findViewById(1711865862));
    if (this.mRefreshBtn != null) {
      this.mRefreshBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DebugCommonUIView.this.refresh();
        }
      });
    }
    if (this.mKeyValueLV != null)
    {
      this.mAdapter = new DebugListViewAdapter();
      this.mKeyValueLV.setAdapter(this.mAdapter);
      this.mKeyValueLV.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return false;
        }
      });
    }
  }
  
  public View getView()
  {
    return this.mRootView;
  }
  
  public void hide()
  {
    this.mRootView.setVisibility(8);
  }
  
  public void refresh()
  {
    if (this.mCallback != null)
    {
      updateKeyValueData(this.mCallback.getKeyValues());
      updateInfo(this.mCallback.getInfo(), false);
    }
  }
  
  public void show()
  {
    if (this.mRootView != null) {
      this.mRootView.setVisibility(0);
    }
  }
  
  public void updateInfo(String paramString, boolean paramBoolean)
  {
    if ((this.mInfoTV != null) && (paramString != null))
    {
      if (paramBoolean) {
        this.mOldInfo = "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int i = this.mIndex;
      this.mIndex = (i + 1);
      this.mOldInfo = (String.valueOf(i) + "-" + paramString + "\n" + this.mOldInfo);
      this.mInfoTV.setText(this.mOldInfo);
      if (this.mIndex > 9) {
        this.mIndex = 1;
      }
    }
  }
  
  public void updateKeyValueData(List<DebugViewKeyValueData> paramList)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.updateData(paramList);
      this.mAdapter.notifyDataSetChanged();
    }
  }
  
  private static class DebugListItemHolder
  {
    public TextView mKeyTV = null;
    public TextView mValueTV = null;
  }
  
  public static class DebugListViewAdapter
    extends BaseAdapter
  {
    private List<DebugCommonUIView.DebugViewKeyValueData> mData = new ArrayList();
    
    public boolean areAllItemsEnabled()
    {
      return false;
    }
    
    public int getCount()
    {
      return this.mData.size();
    }
    
    public DebugCommonUIView.DebugViewKeyValueData getDataItem(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.mData.size())) {
        return (DebugCommonUIView.DebugViewKeyValueData)this.mData.get(paramInt);
      }
      return null;
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = JarUtils.inflate(BNaviModuleManager.getActivity(), 1711472643, null);
        paramViewGroup = new DebugCommonUIView.DebugListItemHolder(null);
        paramViewGroup.mKeyTV = ((TextView)paramView.findViewById(1711865863));
        paramViewGroup.mValueTV = ((TextView)paramView.findViewById(1711865864));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        DebugCommonUIView.DebugViewKeyValueData localDebugViewKeyValueData = getDataItem(paramInt);
        if (localDebugViewKeyValueData == null) {
          break;
        }
        paramViewGroup.mKeyTV.setText(localDebugViewKeyValueData.key);
        paramViewGroup.mValueTV.setText(localDebugViewKeyValueData.value);
        return paramView;
        paramViewGroup = (DebugCommonUIView.DebugListItemHolder)paramView.getTag();
      }
      paramViewGroup.mKeyTV.setText("");
      paramViewGroup.mValueTV.setText("");
      return paramView;
    }
    
    public boolean isEnabled(int paramInt)
    {
      return false;
    }
    
    public void updateData(List<DebugCommonUIView.DebugViewKeyValueData> paramList)
    {
      this.mData.clear();
      if (paramList != null) {
        this.mData.addAll(paramList);
      }
    }
  }
  
  public static class DebugViewKeyValueData
  {
    public String key;
    public String value;
    
    public DebugViewKeyValueData(String paramString1, String paramString2)
    {
      this.key = paramString1;
      this.value = paramString2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/debug/commonui/DebugCommonUIView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */