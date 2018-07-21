package com.baidu.navisdk.ui.widget.ptrrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

public class PtrrvBaseAdapter<VH extends RecyclerView.ViewHolder>
  extends RecyclerView.Adapter<VH>
{
  public static final int TYPE_HEADER = 0;
  public static final int TYPE_HISVIDEO = 1;
  public static final int TYPE_MESSAGE = 2;
  protected Context mContext = null;
  protected int mCount = 0;
  
  public PtrrvBaseAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public int getItemCount()
  {
    return this.mCount;
  }
  
  public void onBindViewHolder(VH paramVH, int paramInt) {}
  
  public VH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/ptrrecyclerview/PtrrvBaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */