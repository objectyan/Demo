package com.baidu.navi.track.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.carlife.core.i;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.model.BaseTrackModel;
import com.baidu.navi.track.model.CarNavi;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.NaviPoint;
import com.baidu.navi.track.model.TrackAcmp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TrackDao
{
  private static final String TAG = "TrackDao";
  private SQLiteDatabase mDatabase;
  
  public TrackDao(SQLiteDatabase paramSQLiteDatabase)
  {
    this.mDatabase = paramSQLiteDatabase;
  }
  
  private Object buildModelByType(String paramString, Cursor paramCursor)
  {
    if ((paramString == null) || (paramCursor == null)) {
      return null;
    }
    localObject = DataBaseConstants.TRACK_TYPE.car_navi;
    try
    {
      DataBaseConstants.TRACK_TYPE localTRACK_TYPE = DataBaseConstants.TRACK_TYPE.valueOf(paramString.toLowerCase());
      paramString = localTRACK_TYPE;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i.b("TrackDao", "--- buildModelByType has no type:" + paramString);
        paramString = (String)localObject;
        continue;
        boolean bool = true;
      }
    }
    switch (paramString)
    {
    default: 
      return null;
    }
    paramString = new CarNaviModel();
    paramString.setCarCuid(paramCursor.getString(paramCursor.getColumnIndex("car_cuid")));
    paramString.setCarChannel(paramCursor.getString(paramCursor.getColumnIndex("car_channel")));
    paramString.setCarVersion(paramCursor.getString(paramCursor.getColumnIndex("car_version")));
    if (paramCursor.getInt(paramCursor.getColumnIndex("isconnect")) == 0)
    {
      bool = false;
      paramString.setIsConnect(bool);
      paramString.setSDcardPath(paramCursor.getString(paramCursor.getColumnIndex("sdcard_path")));
      paramString.setSyncState(paramCursor.getInt(paramCursor.getColumnIndex("action_state")));
      paramString.setUseId(paramCursor.getString(paramCursor.getColumnIndex("useid")));
      localObject = new NaviPoint();
      ((NaviPoint)localObject).setAddr(paramCursor.getString(paramCursor.getColumnIndex("start_addr")));
      ((NaviPoint)localObject).setLat(paramCursor.getDouble(paramCursor.getColumnIndex("start_lat")));
      ((NaviPoint)localObject).setLng(paramCursor.getDouble(paramCursor.getColumnIndex("start_lng")));
      paramString.getPBData().setStartPoint((NaviPoint)localObject);
      localObject = new NaviPoint();
      ((NaviPoint)localObject).setAddr(paramCursor.getString(paramCursor.getColumnIndex("end_addr")));
      ((NaviPoint)localObject).setLat(paramCursor.getDouble(paramCursor.getColumnIndex("end_lat")));
      ((NaviPoint)localObject).setLng(paramCursor.getDouble(paramCursor.getColumnIndex("end_lng")));
      paramString.getPBData().setEndPoint((NaviPoint)localObject);
      paramString.getPBData().setSid(paramCursor.getString(paramCursor.getColumnIndex("sid")));
      paramString.getPBData().setGuid(paramCursor.getString(paramCursor.getColumnIndex("guid")));
      paramString.getPBData().setCtime(paramCursor.getInt(paramCursor.getColumnIndex("ctime")));
      paramString.getPBData().setModifyTime(paramCursor.getInt(paramCursor.getColumnIndex("modifyTime")));
      paramString.getPBData().setAvgSpeed(paramCursor.getDouble(paramCursor.getColumnIndex("avg_speed")));
      paramString.getPBData().setMaxSpeed(paramCursor.getDouble(paramCursor.getColumnIndex("maxSpeed")));
      paramString.getPBData().setDistance(paramCursor.getInt(paramCursor.getColumnIndex("distance")));
      paramString.getPBData().setDuration(paramCursor.getInt(paramCursor.getColumnIndex("duration")));
      paramString.getPBData().setSign(paramCursor.getString(paramCursor.getColumnIndex("sign")));
      paramString.getPBData().setType(paramCursor.getString(paramCursor.getColumnIndex("type")));
      i.b("TrackDao", paramString.toString());
      return paramString;
    }
  }
  
  private void writeCarTrackToDB(CarNaviModel paramCarNaviModel)
  {
    if (paramCarNaviModel == null) {
      return;
    }
    try
    {
      if ((paramCarNaviModel.getPBData().getStartPoint() == null) || (paramCarNaviModel.getPBData().getStartPoint() == null))
      {
        i.b("TrackDao", "Start OR End Point is null");
        return;
      }
    }
    catch (Exception paramCarNaviModel)
    {
      i.b("TrackDao", "DB Exception");
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("car_cuid", paramCarNaviModel.getCarCuid());
    localContentValues.put("car_channel", paramCarNaviModel.getCarChannel());
    localContentValues.put("car_version", paramCarNaviModel.getCarVersion());
    localContentValues.put("useid", paramCarNaviModel.getUseId());
    localContentValues.put("isconnect", Boolean.valueOf(paramCarNaviModel.isConnect()));
    localContentValues.put("sdcard_path", paramCarNaviModel.getSDcardPath());
    localContentValues.put("action_state", Integer.valueOf(paramCarNaviModel.getSyncState()));
    localContentValues.put("guid", paramCarNaviModel.getPBData().getGuid());
    localContentValues.put("type", paramCarNaviModel.getPBData().getType());
    localContentValues.put("ctime", Integer.valueOf(paramCarNaviModel.getPBData().getCtime()));
    localContentValues.put("modifyTime", Integer.valueOf(paramCarNaviModel.getPBData().getModifyTime()));
    localContentValues.put("sid", paramCarNaviModel.getPBData().getSid());
    localContentValues.put("distance", Integer.valueOf(paramCarNaviModel.getPBData().getDistance()));
    localContentValues.put("duration", Integer.valueOf(paramCarNaviModel.getPBData().getDuration()));
    localContentValues.put("maxSpeed", Double.valueOf(paramCarNaviModel.getPBData().getMaxSpeed()));
    localContentValues.put("avg_speed", Double.valueOf(paramCarNaviModel.getPBData().getAvgSpeed()));
    localContentValues.put("sign", paramCarNaviModel.getPBData().getSign());
    localContentValues.put("start_addr", paramCarNaviModel.getPBData().getStartPoint().getAddr());
    localContentValues.put("start_lng", Double.valueOf(paramCarNaviModel.getPBData().getStartPoint().getLng()));
    localContentValues.put("start_lat", Double.valueOf(paramCarNaviModel.getPBData().getStartPoint().getLat()));
    localContentValues.put("end_addr", paramCarNaviModel.getPBData().getEndPoint().getAddr());
    localContentValues.put("end_lng", Double.valueOf(paramCarNaviModel.getPBData().getEndPoint().getLng()));
    localContentValues.put("end_lat", Double.valueOf(paramCarNaviModel.getPBData().getEndPoint().getLat()));
    long l = this.mDatabase.replace("Track_Car", null, localContentValues);
    i.b("TrackDao", "rawId : " + l);
  }
  
  /* Error */
  public int clearTrackByUseId(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload_0
    //   12: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   24: invokevirtual 346	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   27: aload_0
    //   28: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   31: ldc_w 325
    //   34: ldc_w 348
    //   37: iconst_2
    //   38: anewarray 32	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: aload_1
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: ldc_w 350
    //   50: aastore
    //   51: invokevirtual 354	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   54: pop
    //   55: aload_0
    //   56: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   59: invokevirtual 357	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   62: iconst_1
    //   63: istore_2
    //   64: aload_0
    //   65: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   68: invokevirtual 360	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   71: iload_2
    //   72: ireturn
    //   73: astore_1
    //   74: iconst_0
    //   75: istore_2
    //   76: goto -5 -> 71
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   84: invokevirtual 360	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   87: goto -16 -> 71
    //   90: astore_1
    //   91: iconst_0
    //   92: istore_2
    //   93: goto -22 -> 71
    //   96: astore_1
    //   97: aload_0
    //   98: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   101: invokevirtual 360	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   104: aload_1
    //   105: athrow
    //   106: astore_3
    //   107: goto -3 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	TrackDao
    //   0	110	1	paramString	String
    //   1	92	2	i	int
    //   106	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   64	71	73	java/lang/Exception
    //   27	62	79	java/lang/Exception
    //   80	87	90	java/lang/Exception
    //   27	62	96	finally
    //   97	104	106	java/lang/Exception
  }
  
  public int deleteTrackByGUID(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    if (this.mDatabase == null) {
      return 0;
    }
    this.mDatabase.beginTransaction();
    int i = j;
    for (;;)
    {
      try
      {
        paramString = paramString + "";
        i = j;
        j = this.mDatabase.delete("Track_Car", "guid=?", new String[] { paramString });
        i = j;
        this.mDatabase.setTransactionSuccessful();
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        try
        {
          this.mDatabase.endTransaction();
        }
        catch (Exception paramString)
        {
          i = 0;
        }
        continue;
      }
      finally {}
      try
      {
        this.mDatabase.endTransaction();
        i = j;
      }
      catch (Exception paramString)
      {
        i = 0;
      }
    }
    return i;
    try
    {
      this.mDatabase.endTransaction();
      throw paramString;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public int deleteTrackByGuidList(List<String> paramList)
  {
    int i = 0;
    int j = 0;
    if ((paramList == null) || (paramList.size() <= 0)) {
      return 0;
    }
    if (this.mDatabase == null) {
      return 0;
    }
    this.mDatabase.beginTransaction();
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        i = j;
        if (paramList.hasNext())
        {
          i = j;
          String str = (String)paramList.next();
          i = j;
          str = str + "";
          i = j;
          j = this.mDatabase.delete("Track_Car", "guid=?", new String[] { str });
          continue;
        }
        i = j;
        this.mDatabase.setTransactionSuccessful();
        i = 1;
      }
      catch (Exception paramList)
      {
        paramList = paramList;
        try
        {
          this.mDatabase.endTransaction();
        }
        catch (Exception paramList)
        {
          i = 0;
        }
        continue;
      }
      finally {}
      try
      {
        this.mDatabase.endTransaction();
        return i;
      }
      catch (Exception paramList)
      {
        i = 0;
      }
    }
    try
    {
      this.mDatabase.endTransaction();
      throw paramList;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public List<Object> getAllTrack()
  {
    Object localObject5 = null;
    Object localObject4 = null;
    if (this.mDatabase == null) {
      return null;
    }
    Object localObject2 = localObject5;
    for (;;)
    {
      try
      {
        localCursor = this.mDatabase.query("Track_Car", null, null, null, null, null, "ctime DESC");
        localObject1 = localObject4;
        if (localCursor == null) {
          continue;
        }
        localObject1 = localObject4;
        localObject2 = localObject5;
        if (localCursor.getColumnCount() <= 0) {
          continue;
        }
        localObject2 = localObject5;
        localObject1 = new ArrayList();
        try
        {
          if (!localCursor.moveToNext()) {
            continue;
          }
          ((ArrayList)localObject1).add(buildModelByType(localCursor.getString(localCursor.getColumnIndex("type")), localCursor));
          continue;
          i.b("TrackDao", "DB Exception");
        }
        catch (Exception localException2)
        {
          localObject3 = localObject1;
        }
      }
      catch (Exception localException1)
      {
        Cursor localCursor;
        Object localObject1;
        Object localObject3;
        continue;
      }
      return (List<Object>)localObject3;
      localObject3 = localObject1;
      if (localCursor != null)
      {
        localObject3 = localObject1;
        localCursor.close();
        localObject3 = localObject1;
      }
    }
  }
  
  public List<Object> getTrackAfterTime(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    i.b("TrackDao", paramString1 + " " + paramInt1 + " " + paramInt2 + " " + paramString2);
    if ((paramInt1 < 1) || (paramInt2 < 1)) {
      return null;
    }
    if (this.mDatabase == null) {
      return null;
    }
    Object localObject4 = DataBaseConstants.TRACK_TYPE.car_navi;
    localObject4 = DataBaseConstants.TrackQueryType.CAR;
    for (;;)
    {
      try
      {
        paramString2 = DataBaseConstants.TrackQueryType.valueOf(paramString2);
        switch (1.$SwitchMap$com$baidu$navi$track$database$DataBaseConstants$TrackQueryType[paramString2.ordinal()])
        {
        default: 
          paramString2 = (String)localObject3;
          return paramString2;
        }
      }
      catch (Exception paramString1)
      {
        return null;
      }
      localObject3 = "" + paramInt2;
      localObject4 = paramInt1 + "";
      paramString2 = DataBaseConstants.TRACK_TYPE.car_navi;
      paramString2 = (String)localObject2;
      try
      {
        localObject3 = this.mDatabase.query("Track_Car", new String[] { "car_cuid", "car_channel", "car_version", "useid", "isconnect", "sdcard_path", "action_state", "guid", "type", "ctime", "modifyTime", "sid", "distance", "duration", "maxSpeed", "avg_speed", "sign", "start_addr", "start_lng", "start_lat", "end_addr", "end_lng", "end_lat" }, "type =? AND ctime <? AND (useid =? OR useid =?) AND action_state !=? AND action_state !=?", new String[] { "car_navi", localObject4, paramString1, "", "2", "12" }, null, null, "ctime DESC", (String)localObject3);
        paramString1 = (String)localObject1;
        if (localObject3 == null) {
          break label485;
        }
        paramString1 = (String)localObject1;
        paramString2 = (String)localObject2;
        if (((Cursor)localObject3).getColumnCount() <= 0) {
          break label485;
        }
        paramString2 = (String)localObject2;
        paramString1 = new ArrayList();
        try
        {
          while (((Cursor)localObject3).moveToNext()) {
            paramString1.add(buildModelByType(((Cursor)localObject3).getString(((Cursor)localObject3).getColumnIndex("type")), (Cursor)localObject3));
          }
          paramString1.printStackTrace();
        }
        catch (Exception localException)
        {
          paramString2 = paramString1;
          paramString1 = localException;
        }
      }
      catch (Exception paramString1)
      {
        for (;;) {}
      }
      i.b("TrackDao", "DB Exception");
      continue;
      label485:
      paramString2 = paramString1;
      if (localObject3 != null)
      {
        paramString2 = paramString1;
        ((Cursor)localObject3).close();
        paramString2 = paramString1;
      }
    }
  }
  
  public Map<String, Integer> getTrackStateByGuidList(List<String> paramList)
  {
    localHashMap = new HashMap();
    if (paramList == null) {
      paramList = null;
    }
    for (;;)
    {
      return paramList;
      if (this.mDatabase == null) {
        return null;
      }
      try
      {
        Iterator localIterator = paramList.iterator();
        for (;;)
        {
          paramList = localHashMap;
          if (!localIterator.hasNext()) {
            break;
          }
          paramList = (String)localIterator.next();
          if (paramList != null)
          {
            int j = -1;
            Cursor localCursor = this.mDatabase.query("Track_Car", new String[] { "action_state" }, "guid=?", new String[] { paramList }, null, null, "ctime DESC");
            int i = j;
            if (localCursor != null)
            {
              i = j;
              if (localCursor.getCount() > 0)
              {
                i = j;
                if (localCursor.moveToFirst()) {
                  i = localCursor.getInt(localCursor.getColumnIndex("action_state"));
                }
              }
            }
            localHashMap.put(paramList, Integer.valueOf(i));
            if (localCursor != null) {
              localCursor.close();
            }
          }
        }
        return localHashMap;
      }
      catch (Exception paramList)
      {
        i.b("TrackDao", "DB Exception");
      }
    }
  }
  
  public TrackAcmp getTrackStatistics(String paramString, int paramInt)
  {
    if (this.mDatabase == null) {
      return null;
    }
    TrackAcmp localTrackAcmp = new TrackAcmp();
    try
    {
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = "SUM(distance) AS distance";
      String[] arrayOfString1 = new String[5];
      arrayOfString1[0] = "car_navi";
      arrayOfString1[1] = paramString;
      arrayOfString1[2] = "";
      arrayOfString1[3] = "2";
      arrayOfString1[4] = "12";
      int i = 0;
      int j = 0;
      int k = 0;
      Object localObject1 = Calendar.getInstance();
      ((Calendar)localObject1).set(7, 2);
      ((Calendar)localObject1).set(11, 0);
      ((Calendar)localObject1).set(12, 0);
      ((Calendar)localObject1).set(13, 0);
      long l2 = ((Calendar)localObject1).getTimeInMillis() / 1000L;
      long l1 = l2;
      if (((Calendar)localObject1).getTimeInMillis() > System.currentTimeMillis()) {
        l1 = l2 - 604800L;
      }
      Object localObject2 = new Date(1000L * l1);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy:MM:dd HH:mm:ss");
      i.b("TrackDao", "date :" + localSimpleDateFormat.format((Date)localObject2) + "firstDay : " + ((Calendar)localObject1).getFirstDayOfWeek());
      localObject1 = this.mDatabase.query("Track_Car", arrayOfString2, "type =? AND (useid =? OR useid =?) AND action_state !=? AND action_state !=?", arrayOfString1, null, null, null);
      paramInt = i;
      if (localObject1 != null)
      {
        paramInt = i;
        if (((Cursor)localObject1).getCount() > 0)
        {
          paramInt = i;
          if (((Cursor)localObject1).moveToFirst()) {
            paramInt = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndex("distance"));
          }
        }
      }
      localObject1 = l1 + "";
      localObject2 = 604800L + l1 + "";
      paramString = this.mDatabase.query("Track_Car", arrayOfString2, "type =? AND ctime >? AND ctime <=? AND (useid =? OR useid =?) AND action_state !=? AND action_state !=?", new String[] { "car_navi", localObject1, localObject2, paramString, "", "2", "12" }, null, null, null);
      i = j;
      if (paramString != null)
      {
        i = j;
        if (paramString.getCount() > 0)
        {
          i = j;
          if (paramString.moveToFirst()) {
            i = paramString.getInt(paramString.getColumnIndex("distance"));
          }
        }
      }
      paramString = this.mDatabase.query("Track_Car", new String[] { "MAX(duration) AS duration" }, "type =? AND (useid =? OR useid =?) AND action_state !=? AND action_state !=?", arrayOfString1, null, null, null);
      j = k;
      if (paramString != null)
      {
        j = k;
        if (paramString.getCount() > 0)
        {
          j = k;
          if (paramString.moveToFirst()) {
            j = paramString.getInt(paramString.getColumnIndex("duration"));
          }
        }
      }
      localTrackAcmp.setCarNaviDistance(paramInt);
      localTrackAcmp.setCarWeekMileage(i);
      localTrackAcmp.setCarMaxDuration(j);
      TrackConfig.getInstance().setWeekEndTime((int)(604800L + l1));
      TrackConfig.getInstance().setTotalDistanse(paramInt);
      TrackConfig.getInstance().setWeekDistanse(i);
      TrackConfig.getInstance().setMaxTime(j);
      i.b("TrackDao", localTrackAcmp.toString());
      if (paramString != null) {
        paramString.close();
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        i.b("TrackDao", "db getTrackStatistics exception");
      }
    }
    return localTrackAcmp;
  }
  
  public List<Object> getUnsyncTrack(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    if (this.mDatabase == null) {
      return null;
    }
    Object localObject1 = localObject3;
    for (;;)
    {
      try
      {
        localCursor = this.mDatabase.query("Track_Car", new String[] { "car_cuid", "car_channel", "car_version", "useid", "isconnect", "sdcard_path", "action_state", "guid", "type", "ctime", "modifyTime", "distance", "duration", "maxSpeed", "avg_speed", "sign", "start_addr", "start_lng", "start_lat", "end_addr", "end_lng", "end_lat", "sid" }, "action_state !=? AND useid !=? ", new String[] { "1", "" }, null, null, "ctime DESC");
        paramString = (String)localObject2;
        if (localCursor == null) {
          continue;
        }
        paramString = (String)localObject2;
        localObject1 = localObject3;
        if (localCursor.getColumnCount() <= 0) {
          continue;
        }
        localObject1 = localObject3;
        paramString = new ArrayList();
        try
        {
          if (!localCursor.moveToNext()) {
            continue;
          }
          paramString.add(buildModelByType(localCursor.getString(localCursor.getColumnIndex("type")), localCursor));
          continue;
          i.b("TrackDao", "DB Exception");
        }
        catch (Exception localException)
        {
          str = paramString;
        }
      }
      catch (Exception paramString)
      {
        Cursor localCursor;
        String str;
        continue;
      }
      return str;
      str = paramString;
      if (localCursor != null)
      {
        str = paramString;
        localCursor.close();
        str = paramString;
      }
    }
  }
  
  /* Error */
  public int updateNotLoginTracksBduid(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload_0
    //   12: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   24: invokevirtual 346	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   27: new 230	android/content/ContentValues
    //   30: dup
    //   31: invokespecial 231	android/content/ContentValues:<init>	()V
    //   34: astore_3
    //   35: aload_3
    //   36: ldc 100
    //   38: aload_1
    //   39: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_3
    //   43: ldc -91
    //   45: invokestatic 494	java/lang/System:currentTimeMillis	()J
    //   48: ldc2_w 488
    //   51: ldiv
    //   52: l2i
    //   53: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: invokevirtual 272	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   59: aload_0
    //   60: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   63: ldc_w 325
    //   66: aload_3
    //   67: ldc_w 564
    //   70: iconst_1
    //   71: anewarray 32	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: ldc_w 363
    //   79: aastore
    //   80: invokevirtual 568	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   83: pop
    //   84: aload_0
    //   85: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   88: invokevirtual 357	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   91: iconst_1
    //   92: istore_2
    //   93: aload_0
    //   94: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   97: invokevirtual 360	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   100: iload_2
    //   101: ireturn
    //   102: astore_1
    //   103: iconst_0
    //   104: istore_2
    //   105: goto -5 -> 100
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   113: invokevirtual 360	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   116: goto -16 -> 100
    //   119: astore_1
    //   120: iconst_0
    //   121: istore_2
    //   122: goto -22 -> 100
    //   125: astore_1
    //   126: aload_0
    //   127: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   130: invokevirtual 360	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   133: aload_1
    //   134: athrow
    //   135: astore_3
    //   136: goto -3 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	TrackDao
    //   0	139	1	paramString	String
    //   1	121	2	i	int
    //   34	33	3	localContentValues	ContentValues
    //   135	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   93	100	102	java/lang/Exception
    //   27	91	108	java/lang/Exception
    //   109	116	119	java/lang/Exception
    //   27	91	125	finally
    //   126	133	135	java/lang/Exception
  }
  
  public int updateTrackInfoByGuid(List<Object> paramList)
  {
    int i = 0;
    if ((paramList == null) || (paramList.size() == 0)) {
      return 0;
    }
    if (this.mDatabase == null) {
      return 0;
    }
    this.mDatabase.beginTransaction();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = paramList.next();
        if ((localObject1 != null) && ((localObject1 instanceof CarNaviModel)))
        {
          Object localObject2 = (CarNaviModel)localObject1;
          localObject1 = new ContentValues();
          ((ContentValues)localObject1).put("car_cuid", ((CarNaviModel)localObject2).getCarCuid());
          ((ContentValues)localObject1).put("car_channel", ((CarNaviModel)localObject2).getCarChannel());
          ((ContentValues)localObject1).put("car_version", ((CarNaviModel)localObject2).getCarVersion());
          ((ContentValues)localObject1).put("useid", ((CarNaviModel)localObject2).getUseId());
          ((ContentValues)localObject1).put("isconnect", Boolean.valueOf(((CarNaviModel)localObject2).isConnect()));
          ((ContentValues)localObject1).put("sdcard_path", ((CarNaviModel)localObject2).getSDcardPath());
          ((ContentValues)localObject1).put("guid", ((CarNaviModel)localObject2).getPBData().getGuid());
          ((ContentValues)localObject1).put("type", ((CarNaviModel)localObject2).getPBData().getType());
          ((ContentValues)localObject1).put("ctime", Integer.valueOf(((CarNaviModel)localObject2).getPBData().getCtime()));
          ((ContentValues)localObject1).put("modifyTime", Integer.valueOf(((CarNaviModel)localObject2).getPBData().getModifyTime()));
          ((ContentValues)localObject1).put("distance", Integer.valueOf(((CarNaviModel)localObject2).getPBData().getDistance()));
          ((ContentValues)localObject1).put("duration", Integer.valueOf(((CarNaviModel)localObject2).getPBData().getDuration()));
          ((ContentValues)localObject1).put("maxSpeed", Double.valueOf(((CarNaviModel)localObject2).getPBData().getMaxSpeed()));
          ((ContentValues)localObject1).put("avg_speed", Double.valueOf(((CarNaviModel)localObject2).getPBData().getAvgSpeed()));
          ((ContentValues)localObject1).put("sign", ((CarNaviModel)localObject2).getPBData().getSign());
          ((ContentValues)localObject1).put("start_addr", ((CarNaviModel)localObject2).getPBData().getStartPoint().getAddr());
          ((ContentValues)localObject1).put("start_lng", Double.valueOf(((CarNaviModel)localObject2).getPBData().getStartPoint().getLng()));
          ((ContentValues)localObject1).put("start_lat", Double.valueOf(((CarNaviModel)localObject2).getPBData().getStartPoint().getLat()));
          ((ContentValues)localObject1).put("end_addr", ((CarNaviModel)localObject2).getPBData().getEndPoint().getAddr());
          ((ContentValues)localObject1).put("end_lng", Double.valueOf(((CarNaviModel)localObject2).getPBData().getEndPoint().getLng()));
          ((ContentValues)localObject1).put("end_lat", Double.valueOf(((CarNaviModel)localObject2).getPBData().getEndPoint().getLat()));
          localObject2 = ((CarNaviModel)localObject2).getPBData().getGuid();
          this.mDatabase.update("Track_Car", (ContentValues)localObject1, "guid=?", new String[] { localObject2 });
        }
      }
      try
      {
        this.mDatabase.endTransaction();
        throw paramList;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    catch (Exception paramList)
    {
      paramList = paramList;
      try
      {
        this.mDatabase.endTransaction();
        for (;;)
        {
          return i;
          this.mDatabase.setTransactionSuccessful();
          i = 1;
          try
          {
            this.mDatabase.endTransaction();
          }
          catch (Exception paramList)
          {
            i = 0;
          }
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          i = 0;
        }
      }
    }
    finally {}
  }
  
  public int updateTrackSyncStateAndSidByIDList(List<BaseTrackModel> paramList)
  {
    int i = 0;
    if (paramList == null) {
      return 0;
    }
    if (this.mDatabase == null) {
      return 0;
    }
    this.mDatabase.beginTransaction();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (BaseTrackModel)paramList.next();
        String str1 = ((BaseTrackModel)localObject).guid;
        String str2 = ((BaseTrackModel)localObject).sid;
        int j = ((BaseTrackModel)localObject).syncState;
        if ((str1 != null) && (!str1.isEmpty()))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("action_state", Integer.valueOf(j));
          if (str2 != null) {
            ((ContentValues)localObject).put("sid", str2);
          }
          this.mDatabase.update("Track_Car", (ContentValues)localObject, "guid=?", new String[] { str1 });
        }
      }
      try
      {
        this.mDatabase.endTransaction();
        throw paramList;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    catch (Exception paramList)
    {
      paramList = paramList;
      try
      {
        this.mDatabase.endTransaction();
        for (;;)
        {
          return i;
          this.mDatabase.setTransactionSuccessful();
          i = 1;
          try
          {
            this.mDatabase.endTransaction();
          }
          catch (Exception paramList)
          {
            i = 0;
          }
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          i = 0;
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public int updateTrackSyncStateByID(BaseTrackModel paramBaseTrackModel)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   12: ifnonnull +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   21: invokevirtual 346	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   24: new 230	android/content/ContentValues
    //   27: dup
    //   28: invokespecial 231	android/content/ContentValues:<init>	()V
    //   31: astore_3
    //   32: aload_3
    //   33: ldc -102
    //   35: aload_1
    //   36: getfield 575	com/baidu/navi/track/model/BaseTrackModel:guid	Ljava/lang/String;
    //   39: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_3
    //   43: ldc -60
    //   45: aload_1
    //   46: getfield 588	com/baidu/navi/track/model/BaseTrackModel:type	Ljava/lang/String;
    //   49: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_3
    //   53: ldc -97
    //   55: aload_1
    //   56: getfield 590	com/baidu/navi/track/model/BaseTrackModel:modifyTime	I
    //   59: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: invokevirtual 272	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   65: aload_3
    //   66: ldc 94
    //   68: aload_1
    //   69: getfield 581	com/baidu/navi/track/model/BaseTrackModel:syncState	I
    //   72: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: invokevirtual 272	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   78: aload_3
    //   79: ldc 100
    //   81: aload_1
    //   82: getfield 593	com/baidu/navi/track/model/BaseTrackModel:useId	Ljava/lang/String;
    //   85: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_3
    //   89: ldc -108
    //   91: aload_1
    //   92: getfield 577	com/baidu/navi/track/model/BaseTrackModel:sid	Ljava/lang/String;
    //   95: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_1
    //   99: getfield 575	com/baidu/navi/track/model/BaseTrackModel:guid	Ljava/lang/String;
    //   102: astore_1
    //   103: aload_0
    //   104: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   107: ldc_w 325
    //   110: aload_3
    //   111: ldc_w 365
    //   114: iconst_1
    //   115: anewarray 32	java/lang/String
    //   118: dup
    //   119: iconst_0
    //   120: aload_1
    //   121: aastore
    //   122: invokevirtual 568	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   125: pop
    //   126: aload_0
    //   127: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   130: invokevirtual 357	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   133: iconst_1
    //   134: istore_2
    //   135: aload_0
    //   136: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   139: invokevirtual 360	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   142: iload_2
    //   143: ireturn
    //   144: astore_1
    //   145: iconst_0
    //   146: istore_2
    //   147: goto -5 -> 142
    //   150: astore_1
    //   151: aload_0
    //   152: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   155: invokevirtual 360	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   158: goto -16 -> 142
    //   161: astore_1
    //   162: iconst_0
    //   163: istore_2
    //   164: goto -22 -> 142
    //   167: astore_1
    //   168: aload_0
    //   169: getfield 19	com/baidu/navi/track/database/TrackDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   172: invokevirtual 360	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   175: aload_1
    //   176: athrow
    //   177: astore_3
    //   178: goto -3 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	TrackDao
    //   0	181	1	paramBaseTrackModel	BaseTrackModel
    //   1	163	2	i	int
    //   31	80	3	localContentValues	ContentValues
    //   177	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   135	142	144	java/lang/Exception
    //   24	133	150	java/lang/Exception
    //   151	158	161	java/lang/Exception
    //   24	133	167	finally
    //   168	175	177	java/lang/Exception
  }
  
  public int updateTrackSyncStateByIDList(Map<String, Integer> paramMap)
  {
    int i = 0;
    if (paramMap == null) {
      return 0;
    }
    if (this.mDatabase == null) {
      return 0;
    }
    this.mDatabase.beginTransaction();
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
        if ((str != null) && (!str.isEmpty()))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("action_state", Integer.valueOf(j));
          this.mDatabase.update("Track_Car", (ContentValues)localObject, "guid=?", new String[] { str });
        }
      }
      try
      {
        this.mDatabase.endTransaction();
        throw paramMap;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    catch (Exception paramMap)
    {
      paramMap = paramMap;
      try
      {
        this.mDatabase.endTransaction();
        for (;;)
        {
          return i;
          this.mDatabase.setTransactionSuccessful();
          i = 1;
          try
          {
            this.mDatabase.endTransaction();
          }
          catch (Exception paramMap)
          {
            i = 0;
          }
        }
      }
      catch (Exception paramMap)
      {
        for (;;)
        {
          i = 0;
        }
      }
    }
    finally {}
  }
  
  public int writeTracksToDB(List<Object> paramList)
  {
    int i = 0;
    if ((paramList == null) || (paramList.size() <= 0)) {
      return 0;
    }
    if (this.mDatabase == null) {
      return 0;
    }
    try
    {
      this.mDatabase.beginTransaction();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if ((localObject instanceof CarNaviModel)) {
          writeCarTrackToDB((CarNaviModel)localObject);
        }
      }
      return 0;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        try
        {
          this.mDatabase.endTransaction();
          return i;
        }
        catch (Exception paramList)
        {
          return 0;
        }
        this.mDatabase.setTransactionSuccessful();
        i = 1;
        try
        {
          this.mDatabase.endTransaction();
        }
        catch (Exception paramList)
        {
          return 0;
        }
      }
    }
    finally
    {
      try
      {
        this.mDatabase.endTransaction();
        throw paramList;
      }
      catch (Exception paramList) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/database/TrackDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */