package com.baidu.platform.comapi.search;

import com.baidu.entity.pb.Rtbus;
import com.baidu.entity.pb.Rtbus.Content;
import com.baidu.entity.pb.Rtbus.Content.Station;
import com.baidu.entity.pb.Rtbus.Content.Station.Line;
import com.baidu.entity.pb.Rtbus.Content.Station.NextBusInfo;
import com.baidu.entity.pb.Rtbus.Option;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RTBusResult
  implements ResultBase
{
  public static final int ERROR_NO = -1;
  public Content content;
  private int requestId;
  public Result result;
  
  public static RTBusResult parsePBToRTBusResult(Rtbus paramRtbus)
  {
    RTBusResult localRTBusResult = new RTBusResult();
    Object localObject1;
    if (paramRtbus == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return (RTBusResult)localObject1;
      try
      {
        if (paramRtbus.hasOption())
        {
          localRTBusResult.getClass();
          localRTBusResult.result = new Result(localRTBusResult);
          localRTBusResult.result.has_rtbus = paramRtbus.getOption().getHasRtbus();
        }
        localObject1 = localRTBusResult;
        if (!paramRtbus.hasContent()) {
          continue;
        }
        localRTBusResult.getClass();
        localRTBusResult.content = new Content(localRTBusResult);
        localRTBusResult.content.rtbus_nu = paramRtbus.getContent().getRtbusNu();
        localRTBusResult.content.rtbus_update_time = paramRtbus.getContent().getRtbusUpdateTime();
        localRTBusResult.content.rtbusVersion = paramRtbus.getContent().getRtbusVersion();
        localObject1 = localRTBusResult;
        if (paramRtbus.getContent().getStationsCount() <= 0) {
          continue;
        }
        localRTBusResult.content.stations = new ArrayList();
        paramRtbus = paramRtbus.getContent().getStationsList().iterator();
        for (;;)
        {
          localObject1 = localRTBusResult;
          if (!paramRtbus.hasNext()) {
            break;
          }
          Object localObject3 = (Rtbus.Content.Station)paramRtbus.next();
          localRTBusResult.getClass();
          localObject1 = new Station(localRTBusResult);
          ((Station)localObject1).name = ((Rtbus.Content.Station)localObject3).getName();
          ((Station)localObject1).tip_rtbus = ((Rtbus.Content.Station)localObject3).getTipRtbus();
          ((Station)localObject1).uid = ((Rtbus.Content.Station)localObject3).getUid();
          ((Station)localObject1).imageTipRtbus = ((Rtbus.Content.Station)localObject3).getImageTipRtbus();
          localObject1.getClass();
          Object localObject2 = new RTBusResult.Station.Line((Station)localObject1);
          if (((Rtbus.Content.Station)localObject3).getLine() != null)
          {
            ((RTBusResult.Station.Line)localObject2).name = ((Rtbus.Content.Station)localObject3).getLine().getName();
            ((RTBusResult.Station.Line)localObject2).uid = ((Rtbus.Content.Station)localObject3).getLine().getUid();
            ((RTBusResult.Station.Line)localObject2).rawName = ((Rtbus.Content.Station)localObject3).getLine().getRawName();
            ((Station)localObject1).line = ((RTBusResult.Station.Line)localObject2);
          }
          localObject1.getClass();
          localObject2 = new RTBusResult.Station.NextBusInfo((Station)localObject1);
          if (((Rtbus.Content.Station)localObject3).hasNextBusInfo())
          {
            ((RTBusResult.Station.NextBusInfo)localObject2).remain_dist = ((Rtbus.Content.Station)localObject3).getNextBusInfo().getRemainDist();
            ((RTBusResult.Station.NextBusInfo)localObject2).remain_stops = ((Rtbus.Content.Station)localObject3).getNextBusInfo().getRemainStops();
            ((RTBusResult.Station.NextBusInfo)localObject2).remain_time = ((Rtbus.Content.Station)localObject3).getNextBusInfo().getRemainTime();
            ((RTBusResult.Station.NextBusInfo)localObject2).x = ((Rtbus.Content.Station)localObject3).getNextBusInfo().getX();
            ((RTBusResult.Station.NextBusInfo)localObject2).y = ((Rtbus.Content.Station)localObject3).getNextBusInfo().getY();
            ((RTBusResult.Station.NextBusInfo)localObject2).spath = new ArrayList();
            localObject3 = ((Rtbus.Content.Station)localObject3).getNextBusInfo().getSpathList();
            if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
            {
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                Integer localInteger = (Integer)((Iterator)localObject3).next();
                ((RTBusResult.Station.NextBusInfo)localObject2).spath.add(localInteger);
              }
            }
            ((Station)localObject1).nextBusInfo = ((RTBusResult.Station.NextBusInfo)localObject2);
          }
          localRTBusResult.content.stations.add(localObject1);
        }
        return null;
      }
      catch (Exception paramRtbus) {}
    }
  }
  
  public int getRequestId()
  {
    return this.requestId;
  }
  
  public void setRequestId(int paramInt)
  {
    this.requestId = paramInt;
  }
  
  public class Content
  {
    public int rtbusVersion;
    public int rtbus_nu;
    public int rtbus_update_time;
    public List<RTBusResult.Station> stations;
    
    public Content() {}
  }
  
  public class Result
  {
    public int error;
    public int has_rtbus;
    
    public Result() {}
  }
  
  public class Station
  {
    public String imageTipRtbus;
    public Line line;
    public String name;
    public NextBusInfo nextBusInfo;
    public String tip_rtbus;
    public String uid;
    
    public Station() {}
    
    public class Line
    {
      public String endStation;
      public String name;
      public String rawName;
      public String uid;
      
      public Line() {}
    }
    
    public class NextBusInfo
    {
      public int remain_dist;
      public int remain_stops;
      public int remain_time;
      public ArrayList<Integer> spath;
      public int x;
      public int y;
      
      public NextBusInfo() {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/RTBusResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */