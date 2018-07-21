package com.baidu.che.codriver.protocol.a;

import android.text.TextUtils;
import com.baidu.che.codriver.protocol.b;
import com.baidu.che.codriver.protocol.d;
import com.baidu.che.codriver.protocol.data.Place;
import com.baidu.che.codriver.protocol.e;
import com.baidu.che.codriver.protocol.e.a;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.util.h;

public class c
  extends b<Place>
{
  private static final String a = "PlaceTask";
  private String b;
  private String c;
  private boolean d = false;
  
  public c(d<Place> paramd, Class<Place> paramClass, String paramString1, String paramString2)
  {
    super(paramd, paramClass);
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public c(d<Place> paramd, Class<Place> paramClass, String paramString, boolean paramBoolean)
  {
    super(paramd, paramClass);
    this.b = paramString;
    this.d = paramBoolean;
  }
  
  protected String b()
  {
    Object localObject = new e().a("http://api.map.baidu.com/").b("place/v2/search");
    ((e)localObject).a("scope", "2");
    ((e)localObject).a("output", "json");
    ((e)localObject).a("region", LocationUtil.getInstance().getCity());
    ((e)localObject).a("ak", "OTLMypNt9tKU60avOae9zHszuxSPEFyG");
    ((e)localObject).a("page_size", "10");
    ((e)localObject).a("ret_coordtype", LocationUtil.getInstance().getCoordinateSysmem());
    if (!this.d)
    {
      ((e)localObject).a("radius", "100000");
      if (!TextUtils.isEmpty(this.c)) {
        break label164;
      }
      ((e)localObject).a("location", String.format("%.6f,%.6f", new Object[] { Double.valueOf(LocationUtil.getInstance().getLatitudeBd09ll()), Double.valueOf(LocationUtil.getInstance().getLongitudeBd09ll()) }));
    }
    for (;;)
    {
      ((e)localObject).a("q", this.b);
      try
      {
        localObject = ((e)localObject).b();
        return (String)localObject;
      }
      catch (e.a locala)
      {
        label164:
        h.d("PlaceTask", "Config url exception!!!!", locala);
      }
      this.b = (this.c + "附近的" + this.b);
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */