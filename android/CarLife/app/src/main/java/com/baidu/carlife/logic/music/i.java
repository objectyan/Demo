package com.baidu.carlife.logic.music;

import android.text.TextUtils;
import com.baidu.carlife.model.MusicSongModel;
import java.util.Iterator;
import java.util.List;

public class i
{
  private static int a = -1;
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      switch (paramInt1)
      {
      default: 
        return paramInt3 + 1;
      case 2: 
        if (paramInt3 == paramInt2 - 1) {
          return 0;
        }
        return paramInt3 + 1;
      case 1: 
        if ((a != -1) && (a < paramInt2))
        {
          paramInt1 = a;
          a = -1;
          return paramInt1;
        }
        return (int)(Math.random() * paramInt2);
      }
      if (paramBoolean2) {
        return a(2, paramInt2, paramInt3, paramBoolean1, paramBoolean2);
      }
      return paramInt3;
    }
    switch (paramInt1)
    {
    default: 
      return paramInt3 - 1;
    case 2: 
      if (paramInt3 == 0) {
        return paramInt2 - 1;
      }
      return paramInt3 - 1;
    case 1: 
      return (int)(Math.random() * paramInt2);
    }
    if (paramBoolean2) {
      return a(2, paramInt2, paramInt3, paramBoolean1, paramBoolean2);
    }
    return paramInt3;
  }
  
  public static int a(List<MusicSongModel> paramList1, List<MusicSongModel> paramList2)
  {
    paramList2.clear();
    int i = 0;
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2.add((MusicSongModel)paramList1.next());
      i += 1;
    }
    return i;
  }
  
  public static int a(List<MusicSongModel> paramList1, List<MusicSongModel> paramList2, String paramString)
  {
    int j;
    if ((paramList1 == null) || (paramList1.isEmpty()) || (paramList2 == null) || (TextUtils.isEmpty(paramString)))
    {
      j = -1;
      return j;
    }
    paramList2.clear();
    int i = 0;
    paramList1 = paramList1.iterator();
    for (;;)
    {
      j = i;
      if (!paramList1.hasNext()) {
        break;
      }
      MusicSongModel localMusicSongModel = (MusicSongModel)paramList1.next();
      if (paramString.equals(localMusicSongModel.f))
      {
        paramList2.add(localMusicSongModel);
        i += 1;
      }
    }
  }
  
  public static int a(List<MusicSongModel> paramList1, List<MusicSongModel> paramList2, String paramString1, String paramString2)
  {
    int j;
    if ((paramList1 == null) || (paramList1.isEmpty()) || (paramList2 == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      j = -1;
      return j;
    }
    paramList2.clear();
    int i = 0;
    paramList1 = paramList1.iterator();
    for (;;)
    {
      j = i;
      if (!paramList1.hasNext()) {
        break;
      }
      MusicSongModel localMusicSongModel = (MusicSongModel)paramList1.next();
      if ((localMusicSongModel.b != null) && (localMusicSongModel.b.contains(paramString1)) && (paramString2.equals(localMusicSongModel.f)))
      {
        paramList2.add(localMusicSongModel);
        i += 1;
      }
    }
  }
  
  public static void a(int paramInt)
  {
    a = paramInt;
  }
  
  public static int b(List<MusicSongModel> paramList1, List<MusicSongModel> paramList2, String paramString)
  {
    int j;
    if ((paramList1 == null) || (paramList1.isEmpty()) || (paramList2 == null) || (TextUtils.isEmpty(paramString)))
    {
      j = -1;
      return j;
    }
    paramList2.clear();
    int i = 0;
    paramList1 = paramList1.iterator();
    for (;;)
    {
      j = i;
      if (!paramList1.hasNext()) {
        break;
      }
      MusicSongModel localMusicSongModel = (MusicSongModel)paramList1.next();
      if ((localMusicSongModel.b != null) && (localMusicSongModel.b.contains(paramString)))
      {
        paramList2.add(localMusicSongModel);
        i += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */