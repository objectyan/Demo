package com.baidu.location.e;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.baidu.location.Address;
import com.baidu.location.Address.Builder;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.f.a;
import com.baidu.location.h.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

final class e
{
  private static final String[] a = { "CoorType", "Time", "LocType", "Longitude", "Latitude", "Radius", "NetworkLocationType", "Country", "CountryCode", "Province", "City", "CityCode", "District", "Street", "StreetNumber", "PoiList", "LocationDescription" };
  
  static Cursor a(BDLocation paramBDLocation)
  {
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()));
    MatrixCursor localMatrixCursor = new MatrixCursor(a);
    Object[] arrayOfObject = new Object[a.length];
    arrayOfObject[localMatrixCursor.getColumnIndex("CoorType")] = "gcj02";
    arrayOfObject[localMatrixCursor.getColumnIndex("Time")] = localObject1;
    arrayOfObject[localMatrixCursor.getColumnIndex("LocType")] = Integer.valueOf(paramBDLocation.getLocType());
    arrayOfObject[localMatrixCursor.getColumnIndex("Longitude")] = Double.valueOf(paramBDLocation.getLongitude());
    arrayOfObject[localMatrixCursor.getColumnIndex("Latitude")] = Double.valueOf(paramBDLocation.getLatitude());
    arrayOfObject[localMatrixCursor.getColumnIndex("Radius")] = Float.valueOf(paramBDLocation.getRadius());
    arrayOfObject[localMatrixCursor.getColumnIndex("NetworkLocationType")] = paramBDLocation.getNetworkLocationType();
    localObject1 = paramBDLocation.getAddress();
    String str5;
    String str4;
    String str3;
    String str2;
    String str1;
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      str5 = ((Address)localObject1).country;
      str4 = ((Address)localObject1).countryCode;
      str3 = ((Address)localObject1).province;
      str2 = ((Address)localObject1).city;
      str1 = ((Address)localObject1).cityCode;
      localObject3 = ((Address)localObject1).district;
      localObject2 = ((Address)localObject1).street;
      localObject1 = ((Address)localObject1).streetNumber;
    }
    for (;;)
    {
      arrayOfObject[localMatrixCursor.getColumnIndex("Country")] = str5;
      arrayOfObject[localMatrixCursor.getColumnIndex("CountryCode")] = str4;
      arrayOfObject[localMatrixCursor.getColumnIndex("Province")] = str3;
      arrayOfObject[localMatrixCursor.getColumnIndex("City")] = str2;
      arrayOfObject[localMatrixCursor.getColumnIndex("CityCode")] = str1;
      arrayOfObject[localMatrixCursor.getColumnIndex("District")] = localObject3;
      arrayOfObject[localMatrixCursor.getColumnIndex("Street")] = localObject2;
      arrayOfObject[localMatrixCursor.getColumnIndex("StreetNumber")] = localObject1;
      localObject1 = paramBDLocation.getPoiList();
      if (localObject1 == null) {
        arrayOfObject[localMatrixCursor.getColumnIndex("PoiList")] = null;
      }
      for (;;)
      {
        paramBDLocation = paramBDLocation.getLocationDescribe();
        arrayOfObject[localMatrixCursor.getColumnIndex("LocationDescription")] = paramBDLocation;
        localMatrixCursor.addRow(arrayOfObject);
        return localMatrixCursor;
        localObject2 = new StringBuffer();
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject3 = (Poi)((List)localObject1).get(i);
          ((StringBuffer)localObject2).append(((Poi)localObject3).getId()).append(";").append(((Poi)localObject3).getName()).append(";").append(((Poi)localObject3).getRank()).append(";|");
          i += 1;
        }
        arrayOfObject[localMatrixCursor.getColumnIndex("PoiList")] = ((StringBuffer)localObject2).toString();
      }
      localObject1 = null;
      localObject2 = null;
      localObject3 = null;
      str1 = null;
      str2 = null;
      str3 = null;
      str4 = null;
      str5 = null;
    }
  }
  
  static BDLocation a(Cursor paramCursor)
  {
    BDLocation localBDLocation = new BDLocation();
    Object localObject3;
    if ((paramCursor != null) && (paramCursor.getCount() > 0) && (paramCursor.moveToFirst()))
    {
      int i = 0;
      double d1 = 0.0D;
      double d2 = 0.0D;
      String str1 = null;
      String str2 = null;
      float f = 0.0F;
      String str3 = null;
      if (paramCursor.getColumnIndex("LocType") != -1) {
        i = paramCursor.getInt(paramCursor.getColumnIndex("LocType"));
      }
      if (paramCursor.getColumnIndex("Latitude") != -1) {
        d1 = paramCursor.getDouble(paramCursor.getColumnIndex("Latitude"));
      }
      if (paramCursor.getColumnIndex("Longitude") != -1) {
        d2 = paramCursor.getDouble(paramCursor.getColumnIndex("Longitude"));
      }
      if (paramCursor.getColumnIndex("CoorType") != -1) {
        str1 = paramCursor.getString(paramCursor.getColumnIndex("CoorType"));
      }
      if (paramCursor.getColumnIndex("NetworkLocationType") != -1) {
        str2 = paramCursor.getString(paramCursor.getColumnIndex("NetworkLocationType"));
      }
      if (paramCursor.getColumnIndex("Radius") != -1) {
        f = paramCursor.getFloat(paramCursor.getColumnIndex("Radius"));
      }
      if (paramCursor.getColumnIndex("Time") != -1) {
        str3 = paramCursor.getString(paramCursor.getColumnIndex("Time"));
      }
      Object localObject1 = null;
      localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      String str4 = null;
      String str5 = null;
      String str6 = null;
      String str7 = null;
      if (paramCursor.getColumnIndex("Country") != -1) {
        localObject1 = paramCursor.getString(paramCursor.getColumnIndex("Country"));
      }
      if (paramCursor.getColumnIndex("CountryCode") != -1) {
        localObject3 = paramCursor.getString(paramCursor.getColumnIndex("CountryCode"));
      }
      if (paramCursor.getColumnIndex("Province") != -1) {
        localObject4 = paramCursor.getString(paramCursor.getColumnIndex("Province"));
      }
      if (paramCursor.getColumnIndex("City") != -1) {
        localObject5 = paramCursor.getString(paramCursor.getColumnIndex("City"));
      }
      if (paramCursor.getColumnIndex("CityCode") != -1) {
        str4 = paramCursor.getString(paramCursor.getColumnIndex("CityCode"));
      }
      if (paramCursor.getColumnIndex("District") != -1) {
        str5 = paramCursor.getString(paramCursor.getColumnIndex("District"));
      }
      if (paramCursor.getColumnIndex("Street") != -1) {
        str6 = paramCursor.getString(paramCursor.getColumnIndex("Street"));
      }
      if (paramCursor.getColumnIndex("StreetNumber") != -1) {
        str7 = paramCursor.getString(paramCursor.getColumnIndex("StreetNumber"));
      }
      localObject4 = new Address.Builder().country((String)localObject1).countryCode((String)localObject3).province((String)localObject4).city((String)localObject5).cityCode(str4).district(str5).street(str6).streetNumber(str7).build();
      localObject1 = null;
      if (paramCursor.getColumnIndex("PoiList") != -1)
      {
        localObject3 = new ArrayList();
        localObject1 = paramCursor.getString(paramCursor.getColumnIndex("PoiList"));
        if (localObject1 == null) {}
      }
      try
      {
        localObject1 = ((String)localObject1).split("\\|");
        int j = 0;
        while (j < localObject1.length)
        {
          localObject5 = localObject1[j].split(";");
          if (localObject5.length >= 3) {
            ((List)localObject3).add(new Poi(localObject5[0], localObject5[1], Double.valueOf(localObject5[2]).doubleValue()));
          }
          j += 1;
        }
        localObject1 = localObject3;
        if (((List)localObject3).size() == 0) {
          localObject1 = null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = localObject3;
          if (((List)localObject3).size() == 0) {
            localObject2 = null;
          }
        }
      }
      finally
      {
        if (((List)localObject3).size() != 0) {
          break label823;
        }
      }
      localObject3 = null;
      if (paramCursor.getColumnIndex("LocationDescription") != -1) {
        localObject3 = paramCursor.getString(paramCursor.getColumnIndex("LocationDescription"));
      }
      localBDLocation.setTime(str3);
      localBDLocation.setRadius(f);
      localBDLocation.setLocType(i);
      localBDLocation.setCoorType(str1);
      localBDLocation.setLatitude(d1);
      localBDLocation.setLongitude(d2);
      localBDLocation.setNetworkLocationType(str2);
      localBDLocation.setAddr((Address)localObject4);
      localBDLocation.setPoiList((List)localObject1);
      localBDLocation.setLocationDescribe((String)localObject3);
      return localBDLocation;
    }
    label823:
    localBDLocation.setLocType(67);
    return localBDLocation;
  }
  
  static String a(BDLocation paramBDLocation, int paramInt)
  {
    if ((paramBDLocation == null) || (paramBDLocation.getLocType() == 67))
    {
      paramBDLocation = String.format(Locale.CHINA, "&ofl=%s|%d", new Object[] { "1", Integer.valueOf(paramInt) });
      return paramBDLocation;
    }
    String str1 = String.format(Locale.CHINA, "&ofl=%s|%d|%f|%f|%d", new Object[] { "1", Integer.valueOf(paramInt), Double.valueOf(paramBDLocation.getLongitude()), Double.valueOf(paramBDLocation.getLatitude()), Integer.valueOf((int)paramBDLocation.getRadius()) });
    if (paramBDLocation.getAddress() != null) {
      str1 = str1 + "&ofaddr=" + paramBDLocation.getAddress().address;
    }
    for (;;)
    {
      String str2 = str1;
      if (paramBDLocation.getPoiList() != null)
      {
        str2 = str1;
        if (paramBDLocation.getPoiList().size() > 0)
        {
          paramBDLocation = (Poi)paramBDLocation.getPoiList().get(0);
          str2 = str1 + String.format(Locale.US, "&ofpoi=%s|%s", new Object[] { paramBDLocation.getId(), paramBDLocation.getName() });
        }
      }
      paramBDLocation = str2;
      if (com.baidu.location.h.b.d == null) {
        break;
      }
      return str2 + String.format(Locale.US, "&pack=%s&sdk=%.3f", new Object[] { com.baidu.location.h.b.d, Float.valueOf(7.32F) });
    }
  }
  
  static String a(BDLocation paramBDLocation1, BDLocation paramBDLocation2, a parama)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramBDLocation2 == null)
    {
      localStringBuffer.append("&ofcl=0");
      if (paramBDLocation1 != null) {
        break label178;
      }
      localStringBuffer.append("&ofwf=0");
      label32:
      if ((parama == null) || (!parama.e)) {
        break label230;
      }
      localStringBuffer.append("&rgcn=1");
      label51:
      if ((parama == null) || (!parama.d)) {
        break label241;
      }
      localStringBuffer.append("&poin=1");
      label70:
      if ((parama == null) || (!parama.h)) {
        break label252;
      }
      localStringBuffer.append("&desc=1");
    }
    for (;;)
    {
      if (parama != null) {
        localStringBuffer.append(String.format(Locale.US, "&aps=%d", new Object[] { Integer.valueOf(parama.f) }));
      }
      return localStringBuffer.toString();
      localStringBuffer.append(String.format(Locale.US, "&ofcl=1|%f|%f|%d", new Object[] { Double.valueOf(paramBDLocation2.getLongitude()), Double.valueOf(paramBDLocation2.getLatitude()), Integer.valueOf((int)paramBDLocation2.getRadius()) }));
      break;
      label178:
      localStringBuffer.append(String.format(Locale.US, "&ofwf=1|%f|%f|%d", new Object[] { Double.valueOf(paramBDLocation1.getLongitude()), Double.valueOf(paramBDLocation1.getLatitude()), Integer.valueOf((int)paramBDLocation1.getRadius()) }));
      break label32;
      label230:
      localStringBuffer.append("&rgcn=0");
      break label51;
      label241:
      localStringBuffer.append("&poin=0");
      break label70;
      label252:
      localStringBuffer.append("&desc=0");
    }
  }
  
  static String[] a(a parama, com.baidu.location.f.e parame, BDLocation paramBDLocation, String paramString, boolean paramBoolean, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    if (parama != null) {
      localStringBuffer.append(com.baidu.location.f.b.a().b(parama));
    }
    if (parame != null) {
      localStringBuffer.append(parame.a(30));
    }
    if (localStringBuffer.length() > 0)
    {
      if (paramString != null) {
        localStringBuffer.append(paramString);
      }
      localArrayList.add("-loc");
      localArrayList.add(localStringBuffer.toString());
    }
    if (paramBDLocation != null)
    {
      parama = String.format(Locale.US, "%f;%f;%d;%s", new Object[] { Double.valueOf(paramBDLocation.getLatitude()), Double.valueOf(paramBDLocation.getLongitude()), Integer.valueOf(paramBDLocation.getLocType()), paramBDLocation.getNetworkLocationType() });
      localArrayList.add("-com");
      localArrayList.add(parama);
    }
    if (paramBoolean)
    {
      localArrayList.add("-log");
      localArrayList.add("true");
    }
    if (g.g.equals("all"))
    {
      localArrayList.add("-rgc");
      localArrayList.add("true");
    }
    if (g.i)
    {
      localArrayList.add("-poi");
      localArrayList.add("true");
    }
    if (g.h)
    {
      localArrayList.add("-des");
      localArrayList.add("true");
    }
    localArrayList.add("-minap");
    localArrayList.add(Integer.toString(paramInt));
    parama = new String[localArrayList.size()];
    localArrayList.toArray(parama);
    return parama;
  }
  
  static final class a
  {
    final String a;
    final String b;
    final boolean c;
    final boolean d;
    final boolean e;
    final int f;
    final BDLocation g;
    final boolean h;
    final LinkedHashMap<String, Integer> i;
    
    public a(String[] paramArrayOfString)
    {
      if (paramArrayOfString == null)
      {
        this.a = null;
        this.b = null;
        this.i = null;
        this.c = false;
        this.d = false;
        this.e = false;
        this.g = null;
        this.h = false;
        this.f = 8;
        return;
      }
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      int j = 0;
      m = 8;
      bool3 = false;
      bool2 = false;
      bool1 = false;
      k = 0;
      localObject3 = null;
      localObject1 = null;
      localObject2 = null;
      localObject4 = localObject1;
      localObject5 = localObject2;
      try
      {
        if (j >= paramArrayOfString.length) {
          break label1117;
        }
        localObject4 = localObject1;
        localObject5 = localObject2;
        if (!paramArrayOfString[j].equals("-loc")) {
          break label375;
        }
        localObject2 = paramArrayOfString[(j + 1)];
        localObject4 = localObject1;
        localObject5 = localObject2;
        arrayOfString = ((String)localObject2).split("&");
        n = 0;
      }
      catch (Exception paramArrayOfString)
      {
        for (;;)
        {
          String[] arrayOfString;
          int n;
          int i1;
          boolean bool5;
          boolean bool6;
          int i2;
          Object localObject8;
          Object localObject6;
          Object localObject7;
          localObject2 = localObject5;
          localObject1 = localObject4;
          boolean bool4 = false;
          continue;
          n += 1;
          localObject1 = localObject6;
          continue;
          i1 += 1;
        }
      }
      i1 = m;
      bool4 = bool3;
      bool5 = bool2;
      bool6 = bool1;
      i2 = k;
      localObject8 = localObject3;
      localObject6 = localObject1;
      localObject7 = localObject2;
      localObject4 = localObject1;
      localObject5 = localObject2;
      if (n < arrayOfString.length)
      {
        localObject4 = localObject1;
        localObject5 = localObject2;
        if (arrayOfString[n].startsWith("cl="))
        {
          localObject4 = localObject1;
          localObject5 = localObject2;
          localObject6 = arrayOfString[n].substring(3);
          break label1241;
        }
        localObject4 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject1;
        if (!arrayOfString[n].startsWith("wf=")) {
          break label1241;
        }
        localObject4 = localObject1;
        localObject5 = localObject2;
        localObject7 = arrayOfString[n].substring(3).split("\\|");
        i1 = 0;
        localObject4 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject1;
        if (i1 >= localObject7.length) {
          break label1241;
        }
        localObject4 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject7[i1].split(";");
        localObject4 = localObject1;
        localObject5 = localObject2;
        if (localObject6.length < 2) {
          break label1254;
        }
        localObject4 = localObject1;
        localObject5 = localObject2;
        localLinkedHashMap.put(localObject6[0], Integer.valueOf(localObject6[1]));
        break label1254;
        label375:
        localObject4 = localObject1;
        localObject5 = localObject2;
        if (!paramArrayOfString[j].equals("-com")) {
          break label599;
        }
        localObject4 = localObject1;
        localObject5 = localObject2;
        arrayOfString = paramArrayOfString[(j + 1)].split(";");
        i1 = m;
        bool4 = bool3;
        bool5 = bool2;
        bool6 = bool1;
        i2 = k;
        localObject8 = localObject3;
        localObject6 = localObject1;
        localObject7 = localObject2;
        localObject4 = localObject1;
        localObject5 = localObject2;
        if (arrayOfString.length > 0)
        {
          localObject4 = localObject1;
          localObject5 = localObject2;
          localObject6 = new BDLocation();
        }
      }
      for (;;)
      {
        try
        {
          ((BDLocation)localObject6).setLatitude(Double.valueOf(arrayOfString[0]).doubleValue());
          ((BDLocation)localObject6).setLongitude(Double.valueOf(arrayOfString[1]).doubleValue());
          ((BDLocation)localObject6).setLocType(Integer.valueOf(arrayOfString[2]).intValue());
          ((BDLocation)localObject6).setNetworkLocationType(arrayOfString[3]);
          localObject8 = localObject6;
          localObject7 = localObject2;
          localObject6 = localObject1;
          i2 = k;
          bool6 = bool1;
          bool5 = bool2;
          bool4 = bool3;
          i1 = m;
        }
        catch (Exception paramArrayOfString)
        {
          label599:
          localObject3 = localObject6;
          continue;
          continue;
        }
        j += 2;
        m = i1;
        bool3 = bool4;
        bool2 = bool5;
        bool1 = bool6;
        k = i2;
        localObject3 = localObject8;
        localObject1 = localObject6;
        localObject2 = localObject7;
        break;
        localObject4 = localObject1;
        localObject5 = localObject2;
        if (paramArrayOfString[j].equals("-log"))
        {
          i1 = m;
          bool4 = bool3;
          bool5 = bool2;
          bool6 = bool1;
          i2 = k;
          localObject8 = localObject3;
          localObject6 = localObject1;
          localObject7 = localObject2;
          localObject4 = localObject1;
          localObject5 = localObject2;
          if (paramArrayOfString[(j + 1)].equals("true"))
          {
            i2 = 1;
            i1 = m;
            bool4 = bool3;
            bool5 = bool2;
            bool6 = bool1;
            localObject8 = localObject3;
            localObject6 = localObject1;
            localObject7 = localObject2;
          }
        }
        else
        {
          localObject4 = localObject1;
          localObject5 = localObject2;
          if (paramArrayOfString[j].equals("-rgc"))
          {
            i1 = m;
            bool4 = bool3;
            bool5 = bool2;
            bool6 = bool1;
            i2 = k;
            localObject8 = localObject3;
            localObject6 = localObject1;
            localObject7 = localObject2;
            localObject4 = localObject1;
            localObject5 = localObject2;
            if (paramArrayOfString[(j + 1)].equals("true"))
            {
              bool5 = true;
              i1 = m;
              bool4 = bool3;
              bool6 = bool1;
              i2 = k;
              localObject8 = localObject3;
              localObject6 = localObject1;
              localObject7 = localObject2;
            }
          }
          else
          {
            localObject4 = localObject1;
            localObject5 = localObject2;
            if (paramArrayOfString[j].equals("-poi"))
            {
              i1 = m;
              bool4 = bool3;
              bool5 = bool2;
              bool6 = bool1;
              i2 = k;
              localObject8 = localObject3;
              localObject6 = localObject1;
              localObject7 = localObject2;
              localObject4 = localObject1;
              localObject5 = localObject2;
              if (paramArrayOfString[(j + 1)].equals("true"))
              {
                bool6 = true;
                i1 = m;
                bool4 = bool3;
                bool5 = bool2;
                i2 = k;
                localObject8 = localObject3;
                localObject6 = localObject1;
                localObject7 = localObject2;
              }
            }
            else
            {
              localObject4 = localObject1;
              localObject5 = localObject2;
              bool4 = paramArrayOfString[j].equals("-minap");
              if (!bool4) {}
            }
          }
        }
        try
        {
          i1 = Integer.valueOf(paramArrayOfString[(j + 1)]).intValue();
          bool4 = bool3;
          bool5 = bool2;
          bool6 = bool1;
          i2 = k;
          localObject8 = localObject3;
          localObject6 = localObject1;
          localObject7 = localObject2;
        }
        catch (Exception localException)
        {
          boolean bool7;
          i1 = m;
          bool4 = bool3;
          bool5 = bool2;
          bool6 = bool1;
          i2 = k;
          localObject8 = localObject3;
          localObject6 = localObject1;
          localObject7 = localObject2;
        }
        i1 = m;
        bool4 = bool3;
        bool5 = bool2;
        bool6 = bool1;
        i2 = k;
        localObject8 = localObject3;
        localObject6 = localObject1;
        localObject7 = localObject2;
        localObject4 = localObject1;
        localObject5 = localObject2;
        if (paramArrayOfString[j].equals("-des"))
        {
          localObject4 = localObject1;
          localObject5 = localObject2;
          bool7 = paramArrayOfString[(j + 1)].equals("true");
          i1 = m;
          bool4 = bool3;
          bool5 = bool2;
          bool6 = bool1;
          i2 = k;
          localObject8 = localObject3;
          localObject6 = localObject1;
          localObject7 = localObject2;
          if (bool7)
          {
            bool4 = true;
            i1 = m;
            bool5 = bool2;
            bool6 = bool1;
            i2 = k;
            localObject8 = localObject3;
            localObject6 = localObject1;
            localObject7 = localObject2;
          }
        }
      }
      label1117:
      if (k == 0) {
        localObject2 = null;
      }
      bool4 = true;
      this.a = ((String)localObject2);
      this.b = ((String)localObject1);
      this.i = localLinkedHashMap;
      this.c = bool4;
      this.d = bool1;
      this.e = bool2;
      this.f = m;
      this.g = ((BDLocation)localObject3);
      this.h = bool3;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */