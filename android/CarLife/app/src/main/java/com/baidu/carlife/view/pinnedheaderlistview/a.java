package com.baidu.carlife.view.pinnedheaderlistview;

import android.util.Log;
import android.widget.SectionIndexer;
import java.util.Arrays;

public class a
  implements SectionIndexer
{
  private final String[] a;
  private final int[] b;
  private final int c;
  
  public a(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfString == null) || (paramArrayOfInt == null)) {
      throw new NullPointerException();
    }
    if (paramArrayOfString.length != paramArrayOfInt.length) {
      throw new IllegalArgumentException("The sections and counts arrays must have the same length");
    }
    this.a = paramArrayOfString;
    this.b = new int[paramArrayOfInt.length];
    int j = 0;
    int i = 0;
    if (i < paramArrayOfInt.length)
    {
      if (this.a[i] == null) {
        this.a[i] = "";
      }
      for (;;)
      {
        this.b[i] = j;
        j += paramArrayOfInt[i];
        Log.i("MySectionIndexer", "counts[" + i + "]:" + paramArrayOfInt[i]);
        i += 1;
        break;
        this.a[i] = this.a[i].trim();
      }
    }
    this.c = j;
  }
  
  public int getPositionForSection(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a.length)) {
      return -1;
    }
    return this.b[paramInt];
  }
  
  public int getSectionForPosition(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.c)) {
      paramInt = -1;
    }
    int i;
    do
    {
      return paramInt;
      i = Arrays.binarySearch(this.b, paramInt);
      paramInt = i;
    } while (i >= 0);
    return -i - 2;
  }
  
  public Object[] getSections()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/pinnedheaderlistview/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */