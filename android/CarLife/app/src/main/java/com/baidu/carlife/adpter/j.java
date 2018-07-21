package com.baidu.carlife.adpter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.core.e;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.r;
import java.util.List;

public class j
  extends h
{
  private List<MusicSongModel> h = null;
  private boolean i = true;
  
  public j(Context paramContext)
  {
    super(paramContext);
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.g).inflate(2130968939, null);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, (int)this.g.getResources().getDimension(2131362012)));
      paramView = new a(null);
      paramView.a = ((ImageView)paramViewGroup.findViewById(2131625678));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131625679));
      paramView.c = ((TextView)paramViewGroup.findViewById(2131625680));
      paramView.d = ((TextView)paramViewGroup.findViewById(2131625681));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    paramView.b.setText(((MusicSongModel)this.h.get(paramInt)).b);
    paramView.c.setText(((MusicSongModel)this.h.get(paramInt)).f);
    if (this.i) {
      paramView.d.setVisibility(0);
    }
    for (;;)
    {
      try
      {
        j = Integer.parseInt(((MusicSongModel)this.h.get(paramInt)).i) / 1000;
        paramView.d.setText(e.a().a(j));
        MusicSongModel localMusicSongModel = com.baidu.carlife.logic.music.h.b().h();
        if ((localMusicSongModel == null) || (!((MusicSongModel)this.h.get(paramInt)).equals(localMusicSongModel))) {
          break;
        }
        paramView.a.setVisibility(0);
        paramView.b.setTextColor(r.a(2131558648));
        paramView.c.setTextColor(r.a(2131558648));
        paramView.d.setTextColor(r.a(2131558648));
        return paramViewGroup;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int j = 1;
        continue;
      }
      paramView.d.setVisibility(4);
    }
    paramView.a.setVisibility(4);
    paramView.b.setTextColor(r.a(2131558703));
    paramView.c.setTextColor(r.a(2131558692));
    paramView.d.setTextColor(r.a(2131558692));
    return paramViewGroup;
  }
  
  public void a(List<MusicSongModel> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.h = paramList;
    notifyDataSetChanged();
  }
  
  public void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public int d()
  {
    if ((this.h == null) || (this.h.size() == 0)) {
      return 0;
    }
    return this.h.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.h.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  private static class a
  {
    ImageView a;
    TextView b;
    TextView c;
    TextView d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */