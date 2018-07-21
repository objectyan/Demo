package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocation.Builder;

public class cg
  extends ds
{
  cr b;
  
  public cg(cr paramcr)
  {
    this.b = paramcr;
  }
  
  public final void a(cx paramcx, dd paramdd)
  {
    if (paramcx.b()) {
      if (!paramcx.b()) {
        break label106;
      }
    }
    label106:
    for (dq localdq = (dq)paramcx.c;; localdq = null)
    {
      if (localdq != null)
      {
        Object localObject = ct.a(paramcx);
        if (localObject != null)
        {
          localObject = ((IALocation)localObject).newBuilder();
          ((IALocation.Builder)localObject).withLongExtra("com.indooratlas.android.sdk.intent.extras.clientTime", this.b.a());
          if (localdq.j != null) {
            ((IALocation.Builder)localObject).withIntExtra("com.indooratlas.android.sdk.intent.extras.satelliteCount", localdq.j.intValue());
          }
          a(new IALocation[] { ((IALocation.Builder)localObject).build() });
        }
      }
      super.a(paramcx, paramdd);
      return;
    }
  }
  
  public void a(IALocation... paramVarArgs) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */