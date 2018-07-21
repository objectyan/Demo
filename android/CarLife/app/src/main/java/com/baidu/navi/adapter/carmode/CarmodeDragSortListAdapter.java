package com.baidu.navi.adapter.carmode;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.DragSortListener;
import com.baidu.navi.view.draglistview.OnDragAdapterListener;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import java.util.Vector;

public class CarmodeDragSortListAdapter
  extends ArrayAdapter<RoutePlanNode>
  implements OnDragAdapterListener
{
  private Context mContext;
  private Vector<RoutePlanNode> mData;
  private DragSortListener mDragSortListener;
  private Vector<ViewHolder> mViewHolder = new Vector();
  private TextWatcher watcher = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      int j = CarmodeDragSortListAdapter.this.mViewHolder.size();
      int i = 0;
      while (i < j)
      {
        Editable localEditable = ((CarmodeDragSortListAdapter.ViewHolder)CarmodeDragSortListAdapter.this.mViewHolder.get(i)).mEdit.getEditableText();
        if ((localEditable != null) && (localEditable.equals(paramAnonymousEditable))) {
          ((CarmodeDragSortListAdapter.ViewHolder)CarmodeDragSortListAdapter.this.mViewHolder.get(i)).mItem.mName = paramAnonymousEditable.toString();
        }
        i += 1;
      }
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  
  public CarmodeDragSortListAdapter(Context paramContext, DragSortListener paramDragSortListener, Vector<RoutePlanNode> paramVector)
  {
    super(paramContext, 0, paramVector);
    this.mContext = paramContext;
    this.mData = paramVector;
    this.mDragSortListener = paramDragSortListener;
    if (this.mData.size() == 0) {
      this.mData.add(new RoutePlanNode());
    }
  }
  
  private String getRoutePlanNodeName(RoutePlanNode paramRoutePlanNode)
  {
    String str = "";
    if (paramRoutePlanNode == null) {
      return "";
    }
    if (paramRoutePlanNode.isNodeSettedData())
    {
      if (paramRoutePlanNode.mFrom != 3) {
        break label60;
      }
      if (!StringUtils.isEmpty(paramRoutePlanNode.mName)) {
        break label47;
      }
      str = this.mContext.getString(2131296903);
    }
    for (;;)
    {
      return str;
      label47:
      str = this.mContext.getString(2131296902);
      continue;
      label60:
      if ((paramRoutePlanNode.mFrom != 1) || (!StringUtils.isEmpty(paramRoutePlanNode.mName))) {
        break;
      }
      str = this.mContext.getString(2131296901);
    }
    if (StringUtils.isEmpty(paramRoutePlanNode.mName)) {}
    for (str = this.mContext.getString(2131296709);; str = paramRoutePlanNode.mName) {
      break;
    }
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LogUtil.e("RoutePlan", "position:" + paramInt);
    paramViewGroup = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    paramView = new ViewHolder(null);
    paramViewGroup = paramViewGroup.inflate(2130968685, null);
    paramView.mSelectView = ((ImageView)paramViewGroup.findViewById(2131624591));
    paramView.mEdit = ((TextView)paramViewGroup.findViewById(2131624593));
    paramView.mDragIcon = ((ImageView)paramViewGroup.findViewById(2131624592));
    paramView.mDragIcon.setVisibility(8);
    paramView.mProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131624594));
    paramView.mItem = ((RoutePlanNode)getItem(paramInt));
    this.mViewHolder.add(paramView);
    paramViewGroup.setTag(paramView);
    paramViewGroup.setVisibility(0);
    paramView.mSelectView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (CarmodeDragSortListAdapter.this.mDragSortListener != null) {
          CarmodeDragSortListAdapter.this.mDragSortListener.onDeleteNode(paramInt);
        }
      }
    });
    paramView.mEdit.setTag(Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      paramView.mEdit.setHint(2131296905);
      RoutePlanNode localRoutePlanNode = (RoutePlanNode)this.mData.get(0);
      paramView.mEdit.setText(getRoutePlanNodeName(localRoutePlanNode));
      if ((paramView.mSelectView != null) && (paramView.mItem != null)) {
        paramView.mSelectView.setImageDrawable(StyleManager.getDrawable(2130837955));
      }
    }
    for (;;)
    {
      paramView.mEdit.removeTextChangedListener(this.watcher);
      paramView.mEdit.setText(getRoutePlanNodeName(paramView.mItem));
      paramView.mEdit.addTextChangedListener(this.watcher);
      if ((paramView.mProgressBar != null) && (paramView.mItem != null))
      {
        if ((!StringUtils.isEmpty(paramView.mItem.mName)) || (!paramView.mItem.isNodeSettedData())) {
          break;
        }
        paramView.mProgressBar.setVisibility(0);
      }
      return paramViewGroup;
      if (getCount() >= 2) {
        if (paramInt == getCount() - 1)
        {
          if (paramView.mSelectView != null) {
            paramView.mSelectView.setImageDrawable(StyleManager.getDrawable(2130837954));
          }
          paramView.mEdit.setHint(this.mContext.getString(2131296899));
        }
        else
        {
          if (paramView.mSelectView != null)
          {
            paramView.mSelectView.setImageDrawable(StyleManager.getDrawable(2130837949));
            paramView.mSelectView.setVisibility(0);
          }
          paramView.mEdit.setHint(this.mContext.getString(2131296910) + paramInt);
        }
      }
    }
    paramView.mProgressBar.setVisibility(8);
    return paramViewGroup;
  }
  
  public void onExchange(int paramInt1, int paramInt2)
  {
    RoutePlanNode localRoutePlanNode1 = (RoutePlanNode)getItem(paramInt1);
    RoutePlanNode localRoutePlanNode2 = (RoutePlanNode)getItem(paramInt2);
    LogUtil.e("ON", "startPostion ==== " + paramInt1);
    LogUtil.e("ON", "endPosition ==== " + paramInt2);
    if (paramInt1 < paramInt2)
    {
      this.mData.add(paramInt2 + 1, localRoutePlanNode1);
      this.mData.remove(paramInt1);
      this.mData.add(paramInt1, localRoutePlanNode2);
      this.mData.remove(paramInt2);
      return;
    }
    this.mData.add(paramInt2, localRoutePlanNode1);
    this.mData.remove(paramInt1 + 1);
    this.mData.add(paramInt1, localRoutePlanNode2);
    this.mData.remove(paramInt2 + 1);
  }
  
  private class ViewHolder
  {
    public ImageView mDragIcon;
    public TextView mEdit;
    public RoutePlanNode mItem;
    public ProgressBar mProgressBar;
    public ImageView mSelectView;
    
    private ViewHolder() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/carmode/CarmodeDragSortListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */