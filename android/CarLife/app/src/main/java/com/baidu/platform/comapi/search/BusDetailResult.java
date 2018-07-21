package com.baidu.platform.comapi.search;

import android.text.TextUtils;
import com.baidu.entity.pb.Bsl;
import com.baidu.entity.pb.Bsl.Content;
import com.baidu.entity.pb.Bsl.Content.PairLine;
import com.baidu.entity.pb.Bsl.Content.Stations;
import com.baidu.entity.pb.Bsl.Content.Stations.RtInfo;
import com.baidu.entity.pb.Bsl.Content.Stations.RtInfo.NextVehicle;
import com.baidu.entity.pb.Bsl.Content.Stations.Subways;
import com.baidu.entity.pb.Bsl.Content.Stations.TriRtInfo;
import com.baidu.entity.pb.Bsl.Content.Stations.TriRtInfo.VehicleInfo;
import com.baidu.entity.pb.Bsl.Content.UgcInfo;
import com.baidu.entity.pb.Bsl.Option;
import com.baidu.entity.pb.CurrentCity;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.tools.AppTools;
import com.google.protobuf.micro.ByteStringMicro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BusDetailResult
  implements ResultBase
{
  public int count;
  public int currentCity;
  public String drawJsonStr;
  public byte[] exImageByte;
  public boolean exceedOperateTime;
  public boolean hasRtBus;
  public String headway;
  private ArrayList<OneLineInfo> mDetails;
  private int requestId;
  public int rtinfoSY;
  public int total;
  
  public static BusDetailResult fromPB(Bsl paramBsl)
  {
    BusDetailResult localBusDetailResult = new BusDetailResult();
    localBusDetailResult.drawJsonStr = parseDrawerJson(paramBsl);
    if (paramBsl.getContent(0).hasImage()) {
      localBusDetailResult.exImageByte = paramBsl.getContent(0).getImage().toByteArray();
    }
    localBusDetailResult.count = paramBsl.getContentCount();
    boolean bool;
    Object localObject1;
    label89:
    label120:
    int i;
    if (paramBsl.getOption().getHasRtbus() == 1)
    {
      bool = true;
      localBusDetailResult.hasRtBus = bool;
      if (paramBsl.getContentCount() <= 0) {
        break label508;
      }
      localObject1 = paramBsl.getContent(0).getHeadway();
      localBusDetailResult.headway = ((String)localObject1);
      if (paramBsl.getContent(0).hasRunState())
      {
        if (paramBsl.getContent(0).getRunState() != 1) {
          break label515;
        }
        bool = true;
        localBusDetailResult.exceedOperateTime = bool;
      }
      if (!paramBsl.hasCurrentCity()) {
        break label520;
      }
      i = paramBsl.getCurrentCity().getCode();
      label141:
      localBusDetailResult.currentCity = i;
      localBusDetailResult.total = paramBsl.getOption().getTotal();
      localBusDetailResult.rtinfoSY = paramBsl.getOption().getRtinfoSy();
      if (localBusDetailResult.getDetails() != null) {
        localBusDetailResult.getDetails().clear();
      }
      localObject1 = paramBsl.getContentList().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label1241;
      }
      Object localObject2 = (Bsl.Content)((Iterator)localObject1).next();
      localBusDetailResult.getClass();
      OneLineInfo localOneLineInfo = new OneLineInfo(localBusDetailResult);
      localOneLineInfo.starttime = ((Bsl.Content)localObject2).getStartTime();
      localOneLineInfo.triRtbusTip = ((Bsl.Content)localObject2).getTriRtbusTip();
      localOneLineInfo.maxprice = ((Bsl.Content)localObject2).getMaxPrice();
      if (((Bsl.Content)localObject2).getIsMonTicket() == 1) {}
      for (bool = true;; bool = false)
      {
        localOneLineInfo.ismonticket = bool;
        localOneLineInfo.setIsDisplay(((Bsl.Content)localObject2).getIsDisplay());
        localOneLineInfo.endtime = ((Bsl.Content)localObject2).getEndTime();
        localOneLineInfo.uid = ((Bsl.Content)localObject2).getUid();
        localOneLineInfo.name = ((Bsl.Content)localObject2).getName();
        localOneLineInfo.getClass();
        paramBsl = new BusDetailResult.OneLineInfo.WorkTime(localOneLineInfo);
        paramBsl.start = localOneLineInfo.starttime;
        paramBsl.end = localOneLineInfo.endtime;
        localOneLineInfo.setWorkTime(paramBsl);
        localOneLineInfo.rtbusUpdateTime = ((Bsl.Content)localObject2).getRtbusUpdateTime();
        localOneLineInfo.rtbusUpdateInterval = ((Bsl.Content)localObject2).getRtbusUpdateInterval();
        localOneLineInfo.lineDirection = ((Bsl.Content)localObject2).getLineDirection();
        localOneLineInfo.nearestStationIdx = ((Bsl.Content)localObject2).getNearestStationIdx();
        localOneLineInfo.rtbusNu = ((Bsl.Content)localObject2).getRtbusNu();
        localOneLineInfo.pathGeo = AppTools.getGeoComplexPtBoundFromString(((Bsl.Content)localObject2).getGeo());
        localOneLineInfo.geo = ((Bsl.Content)localObject2).getGeo();
        localOneLineInfo.kindtype = ((Bsl.Content)localObject2).getKindtype();
        localOneLineInfo.workingTimeDesc = new ArrayList();
        paramBsl = ((Bsl.Content)localObject2).getWorkingTimeDescList().iterator();
        while (paramBsl.hasNext())
        {
          localObject3 = (String)paramBsl.next();
          localOneLineInfo.workingTimeDesc.add(localObject3);
        }
        bool = false;
        break;
        label508:
        localObject1 = "";
        break label89;
        label515:
        bool = false;
        break label120;
        label520:
        i = 0;
        break label141;
      }
      Object localObject3 = ((Bsl.Content)localObject2).getStationsList().iterator();
      Object localObject4;
      while (((Iterator)localObject3).hasNext())
      {
        paramBsl = (Bsl.Content.Stations)((Iterator)localObject3).next();
        localOneLineInfo.getClass();
        localObject4 = new BusDetailResult.OneLineInfo.Station(localOneLineInfo);
        ((BusDetailResult.OneLineInfo.Station)localObject4).uid = paramBsl.getUid();
        ((BusDetailResult.OneLineInfo.Station)localObject4).name = paramBsl.getName();
        ((BusDetailResult.OneLineInfo.Station)localObject4).geo = paramBsl.getGeo();
        ((BusDetailResult.OneLineInfo.Station)localObject4).setmPtGeo(AppTools.getGeoPointFromString(((BusDetailResult.OneLineInfo.Station)localObject4).geo));
        if ((paramBsl.hasRtInfo()) && (paramBsl.getRtInfo().hasNextVehicle()))
        {
          localObject5 = paramBsl.getRtInfo().getNextVehicle();
          localObject4.getClass();
          ((BusDetailResult.OneLineInfo.Station)localObject4).realTimeInfo = new BusDetailResult.OneLineInfo.Station.RealTimeInfo((BusDetailResult.OneLineInfo.Station)localObject4);
          ((BusDetailResult.OneLineInfo.Station)localObject4).realTimeInfo.nextVehicle.has_next_vehicle = ((Bsl.Content.Stations.RtInfo.NextVehicle)localObject5).getHasNextVehicle();
          ((BusDetailResult.OneLineInfo.Station)localObject4).realTimeInfo.nextVehicle.remain_time = ((Bsl.Content.Stations.RtInfo.NextVehicle)localObject5).getRemainTime();
          ((BusDetailResult.OneLineInfo.Station)localObject4).realTimeInfo.nextVehicle.remain_dist = ((Bsl.Content.Stations.RtInfo.NextVehicle)localObject5).getRemainDist();
          ((BusDetailResult.OneLineInfo.Station)localObject4).realTimeInfo.nextVehicle.remain_stops = ((Bsl.Content.Stations.RtInfo.NextVehicle)localObject5).getRemainStops();
        }
        Object localObject6;
        Object localObject7;
        if (paramBsl.hasTriRtInfo())
        {
          localObject5 = paramBsl.getTriRtInfo().getVehicleInfoList().iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (Bsl.Content.Stations.TriRtInfo.VehicleInfo)((Iterator)localObject5).next();
            localObject7 = ((BusDetailResult.OneLineInfo.Station)localObject4).triRtInf;
            localObject7.getClass();
            localObject7 = new BusDetailResult.OneLineInfo.Station.TriRtInf.VehicleInfo((BusDetailResult.OneLineInfo.Station.TriRtInf)localObject7);
            ((BusDetailResult.OneLineInfo.Station.TriRtInf.VehicleInfo)localObject7).remainTip = ((Bsl.Content.Stations.TriRtInfo.VehicleInfo)localObject6).getRemainTip();
            ((BusDetailResult.OneLineInfo.Station.TriRtInf.VehicleInfo)localObject7).vehicleX = ((Bsl.Content.Stations.TriRtInfo.VehicleInfo)localObject6).getVehicleX();
            ((BusDetailResult.OneLineInfo.Station.TriRtInf.VehicleInfo)localObject7).vehicleY = ((Bsl.Content.Stations.TriRtInfo.VehicleInfo)localObject6).getVehicleY();
            ((BusDetailResult.OneLineInfo.Station)localObject4).triRtInf.vehicleInfos.add(localObject7);
          }
        }
        ((BusDetailResult.OneLineInfo.Station)localObject4).subwaysInfo = new ArrayList();
        Object localObject5 = paramBsl.getSubwaysList().iterator();
        if (((Iterator)localObject5).hasNext())
        {
          localObject7 = (Bsl.Content.Stations.Subways)((Iterator)localObject5).next();
          localObject4.getClass();
          localObject6 = new BusDetailResult.OneLineInfo.Station.SubwayInfo((BusDetailResult.OneLineInfo.Station)localObject4);
          if (TextUtils.isEmpty(((Bsl.Content.Stations.Subways)localObject7).getName()))
          {
            paramBsl = "";
            label923:
            ((BusDetailResult.OneLineInfo.Station.SubwayInfo)localObject6).name = paramBsl;
            if (!TextUtils.isEmpty(((Bsl.Content.Stations.Subways)localObject7).getBackgroundColor())) {
              break label973;
            }
          }
          label973:
          for (paramBsl = "";; paramBsl = ((Bsl.Content.Stations.Subways)localObject7).getBackgroundColor())
          {
            ((BusDetailResult.OneLineInfo.Station.SubwayInfo)localObject6).backgroundColor = paramBsl;
            ((BusDetailResult.OneLineInfo.Station)localObject4).subwaysInfo.add(localObject6);
            break;
            paramBsl = ((Bsl.Content.Stations.Subways)localObject7).getName();
            break label923;
          }
        }
        localOneLineInfo.setStations((BusDetailResult.OneLineInfo.Station)localObject4);
      }
      if (((Bsl.Content)localObject2).hasPairLine())
      {
        paramBsl = ((Bsl.Content)localObject2).getPairLine();
        localObject3 = new BusDetailResult();
        localObject3.getClass();
        localObject3 = new OneLineInfo((BusDetailResult)localObject3);
        localObject3.getClass();
        localObject3 = new BusDetailResult.OneLineInfo.PairLine((OneLineInfo)localObject3);
        ((BusDetailResult.OneLineInfo.PairLine)localObject3).name = paramBsl.getName();
        ((BusDetailResult.OneLineInfo.PairLine)localObject3).uid = paramBsl.getUid();
        ((BusDetailResult.OneLineInfo.PairLine)localObject3).startTime = paramBsl.getStartTime();
        ((BusDetailResult.OneLineInfo.PairLine)localObject3).endTime = paramBsl.getEndTime();
        ((BusDetailResult.OneLineInfo.PairLine)localObject3).kindType = paramBsl.getKindtype();
        ((BusDetailResult.OneLineInfo.PairLine)localObject3).direction = paramBsl.getDirection();
        localOneLineInfo.setPairLine((BusDetailResult.OneLineInfo.PairLine)localObject3);
      }
      for (;;)
      {
        paramBsl = new ArrayList();
        localObject2 = ((Bsl.Content)localObject2).getUgcinfoList().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Bsl.Content.UgcInfo)((Iterator)localObject2).next();
          localOneLineInfo.getClass();
          localObject4 = new BusDetailResult.OneLineInfo.UgcInfo(localOneLineInfo);
          ((BusDetailResult.OneLineInfo.UgcInfo)localObject4).user = ((Bsl.Content.UgcInfo)localObject3).getUser();
          ((BusDetailResult.OneLineInfo.UgcInfo)localObject4).time = ((Bsl.Content.UgcInfo)localObject3).getTime();
          ((BusDetailResult.OneLineInfo.UgcInfo)localObject4).type = ((Bsl.Content.UgcInfo)localObject3).getType();
          paramBsl.add(localObject4);
        }
        localOneLineInfo.setPairLine(null);
      }
      if (paramBsl.size() > 0) {
        localOneLineInfo.setUgcInfoList(paramBsl);
      }
      localBusDetailResult.setDetails(localOneLineInfo);
    }
    label1241:
    return localBusDetailResult;
  }
  
  public static String parseDrawerJson(Bsl paramBsl)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray1 = new JSONArray();
    paramBsl = paramBsl.getContentList().iterator();
    if (paramBsl.hasNext())
    {
      Object localObject1 = (Bsl.Content)paramBsl.next();
      JSONObject localJSONObject2 = new JSONObject();
      label114:
      JSONObject localJSONObject3;
      JSONObject localJSONObject4;
      Object localObject3;
      try
      {
        localJSONObject2.put("uid", ((Bsl.Content)localObject1).getUid());
        localJSONObject2.put("geo", ((Bsl.Content)localObject1).getGeo());
        localJSONObject2.put("name", ((Bsl.Content)localObject1).getName());
        JSONArray localJSONArray2 = new JSONArray();
        localObject1 = ((Bsl.Content)localObject1).getStationsList().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Bsl.Content.Stations)((Iterator)localObject1).next();
          localJSONObject3 = new JSONObject();
          localJSONObject3.put("name", ((Bsl.Content.Stations)localObject2).getName());
          localJSONObject3.put("uid", ((Bsl.Content.Stations)localObject2).getUid());
          localJSONObject3.put("geo", ((Bsl.Content.Stations)localObject2).getGeo());
          Object localObject4;
          if ((((Bsl.Content.Stations)localObject2).hasRtInfo()) && (((Bsl.Content.Stations)localObject2).getRtInfo().hasNextVehicle()))
          {
            localJSONObject4 = new JSONObject();
            localObject3 = ((Bsl.Content.Stations)localObject2).getRtInfo().getNextVehicle();
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("vehicle_x", ((Bsl.Content.Stations.RtInfo.NextVehicle)localObject3).getVehicleX());
            ((JSONObject)localObject4).put("vehicle_y", ((Bsl.Content.Stations.RtInfo.NextVehicle)localObject3).getVehicleY());
            localJSONObject4.put("next_vehicle", localObject4);
            localJSONObject3.put("rt_info", localJSONObject4);
          }
          if (((Bsl.Content.Stations)localObject2).hasTriRtInfo())
          {
            localJSONObject4 = new JSONObject();
            localObject3 = new JSONArray();
            localObject2 = ((Bsl.Content.Stations)localObject2).getTriRtInfo().getVehicleInfoList().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (Bsl.Content.Stations.TriRtInfo.VehicleInfo)((Iterator)localObject2).next();
              JSONObject localJSONObject5 = new JSONObject();
              localJSONObject5.put("vehicle_x", ((Bsl.Content.Stations.TriRtInfo.VehicleInfo)localObject4).getVehicleX());
              localJSONObject5.put("vehicle_y", ((Bsl.Content.Stations.TriRtInfo.VehicleInfo)localObject4).getVehicleY());
              ((JSONArray)localObject3).put(localJSONObject5);
              continue;
              localJSONArray1.put(localJSONObject2);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      for (;;)
      {
        break;
        localJSONObject4.put("vehicle_info", localObject3);
        localJSONObject3.put("tri_rt_info", localJSONObject4);
        localException.put(localJSONObject3);
        break label114;
        localJSONObject2.put("stations", localException);
      }
    }
    try
    {
      localJSONObject1.put("details", localJSONArray1);
      localJSONObject1.put("result_type", 18);
      localJSONObject1.put("error", 0);
      return localJSONObject1.toString();
    }
    catch (Exception paramBsl)
    {
      for (;;)
      {
        paramBsl.printStackTrace();
      }
    }
  }
  
  public OneLineInfo getDetails(int paramInt)
  {
    if (this.mDetails.size() > paramInt) {
      return (OneLineInfo)this.mDetails.get(paramInt);
    }
    return null;
  }
  
  public ArrayList<OneLineInfo> getDetails()
  {
    return this.mDetails;
  }
  
  public int getRequestId()
  {
    return this.requestId;
  }
  
  public boolean hasDetails()
  {
    return (this.mDetails != null) && (this.mDetails.size() > 0);
  }
  
  void setDetails(OneLineInfo paramOneLineInfo)
  {
    if (this.mDetails == null) {
      this.mDetails = new ArrayList();
    }
    this.mDetails.add(paramOneLineInfo);
  }
  
  void setDetails(ArrayList<OneLineInfo> paramArrayList)
  {
    this.mDetails = paramArrayList;
  }
  
  public void setRequestId(int paramInt)
  {
    this.requestId = paramInt;
  }
  
  public class OneLineInfo
  {
    public String endtime;
    public String geo;
    private int isDisplay;
    public boolean ismonticket;
    public int kindtype;
    public String lineDirection;
    private ArrayList<Station> mStations;
    public int maxprice;
    public String name;
    public int nearestStationIdx = -1;
    private PairLine pairLine;
    public ComplexPt pathGeo;
    public int rtbusNu;
    public int rtbusUpdateInterval;
    public int rtbusUpdateTime;
    public String starttime;
    public String triRtbusTip;
    public ArrayList<UgcInfo> ugcInfoList;
    public String uid;
    private ArrayList<WorkTime> workTimes;
    public List<String> workingTimeDesc;
    
    public OneLineInfo() {}
    
    public int getIsDisplay()
    {
      return this.isDisplay;
    }
    
    public PairLine getPairLine()
    {
      return this.pairLine;
    }
    
    public Station getStations(int paramInt)
    {
      if (this.mStations.size() > paramInt) {
        return (Station)this.mStations.get(paramInt);
      }
      return null;
    }
    
    public ArrayList<Station> getStations()
    {
      return this.mStations;
    }
    
    public ArrayList<UgcInfo> getUgcInfoList()
    {
      return this.ugcInfoList;
    }
    
    public ArrayList<WorkTime> getWorkTimes()
    {
      return this.workTimes;
    }
    
    public void setIsDisplay(int paramInt)
    {
      this.isDisplay = paramInt;
    }
    
    public void setPairLine(PairLine paramPairLine)
    {
      this.pairLine = paramPairLine;
    }
    
    void setStations(Station paramStation)
    {
      if (this.mStations == null) {
        this.mStations = new ArrayList();
      }
      this.mStations.add(paramStation);
    }
    
    void setStations(ArrayList<Station> paramArrayList)
    {
      this.mStations = paramArrayList;
    }
    
    public void setUgcInfoList(ArrayList<UgcInfo> paramArrayList)
    {
      this.ugcInfoList = paramArrayList;
    }
    
    public void setWorkTime(WorkTime paramWorkTime)
    {
      if (this.workTimes == null) {
        this.workTimes = new ArrayList();
      }
      this.workTimes.add(paramWorkTime);
    }
    
    public class PairLine
    {
      public String direction;
      public String endTime;
      public int kindType;
      public String name;
      public String startTime;
      public String uid;
      
      public PairLine() {}
    }
    
    public class Station
    {
      public String geo;
      public String name;
      public Point pt;
      public RealTimeInfo realTimeInfo = null;
      public ArrayList<SubwayInfo> subwaysInfo = null;
      public TriRtInf triRtInf = new TriRtInf();
      public String uid;
      
      public Station() {}
      
      public Point getmPtGeo()
      {
        return this.pt;
      }
      
      public boolean hasValidRealTimeInfo()
      {
        return (this.realTimeInfo != null) && (this.realTimeInfo.nextVehicle != null) && (this.realTimeInfo.nextVehicle.has_next_vehicle == 1);
      }
      
      void setmPtGeo(Point paramPoint)
      {
        this.pt = paramPoint;
      }
      
      public class RealTimeInfo
      {
        public NextVehicle nextVehicle = null;
        
        public RealTimeInfo()
        {
          if (this.nextVehicle == null) {
            this.nextVehicle = new NextVehicle();
          }
        }
        
        public class NextVehicle
        {
          public int has_next_vehicle;
          public int remain_dist;
          public int remain_stops;
          public int remain_time;
          
          public NextVehicle() {}
        }
      }
      
      public class SubwayInfo
      {
        public String backgroundColor;
        public String name;
        
        public SubwayInfo() {}
      }
      
      public class TriRtInf
      {
        public List<VehicleInfo> vehicleInfos = new ArrayList();
        
        public TriRtInf() {}
        
        public class VehicleInfo
        {
          public String remainTip = null;
          public double vehicleX = 0.0D;
          public double vehicleY = 0.0D;
          
          public VehicleInfo() {}
        }
      }
    }
    
    public class UgcInfo
    {
      public String time;
      public int type;
      public String user;
      
      public UgcInfo() {}
    }
    
    public class WorkTime
    {
      public String end;
      public String start;
      
      public WorkTime() {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/BusDetailResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */