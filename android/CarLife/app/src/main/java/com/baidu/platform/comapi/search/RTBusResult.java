package com.baidu.platform.comapi.search;

import com.baidu.entity.pb.Rtbus;
import java.util.ArrayList;
import java.util.List;

public class RTBusResult implements ResultBase {
    public static final int ERROR_NO = -1;
    public Content content;
    private int requestId;
    public Result result;

    public class Content {
        public int rtbusVersion;
        public int rtbus_nu;
        public int rtbus_update_time;
        public List<Station> stations;
    }

    public class Result {
        public int error;
        public int has_rtbus;
    }

    public class Station {
        public String imageTipRtbus;
        public Line line;
        public String name;
        public NextBusInfo nextBusInfo;
        public String tip_rtbus;
        public String uid;

        public class Line {
            public String endStation;
            public String name;
            public String rawName;
            public String uid;
        }

        public class NextBusInfo {
            public int remain_dist;
            public int remain_stops;
            public int remain_time;
            public ArrayList<Integer> spath;
            /* renamed from: x */
            public int f19867x;
            /* renamed from: y */
            public int f19868y;
        }
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public static RTBusResult parsePBToRTBusResult(Rtbus rtbus) {
        RTBusResult busResult = new RTBusResult();
        if (rtbus == null) {
            return null;
        }
        try {
            if (rtbus.hasOption()) {
                busResult.getClass();
                busResult.result = new Result();
                busResult.result.has_rtbus = rtbus.getOption().getHasRtbus();
            }
            if (!rtbus.hasContent()) {
                return busResult;
            }
            busResult.getClass();
            busResult.content = new Content();
            busResult.content.rtbus_nu = rtbus.getContent().getRtbusNu();
            busResult.content.rtbus_update_time = rtbus.getContent().getRtbusUpdateTime();
            busResult.content.rtbusVersion = rtbus.getContent().getRtbusVersion();
            if (rtbus.getContent().getStationsCount() <= 0) {
                return busResult;
            }
            busResult.content.stations = new ArrayList();
            for (com.baidu.entity.pb.Rtbus.Content.Station station : rtbus.getContent().getStationsList()) {
                busResult.getClass();
                Station temp = new Station();
                temp.name = station.getName();
                temp.tip_rtbus = station.getTipRtbus();
                temp.uid = station.getUid();
                temp.imageTipRtbus = station.getImageTipRtbus();
                temp.getClass();
                Line line = new Line();
                if (station.getLine() != null) {
                    line.name = station.getLine().getName();
                    line.uid = station.getLine().getUid();
                    line.rawName = station.getLine().getRawName();
                    temp.line = line;
                }
                temp.getClass();
                NextBusInfo busInfo = new NextBusInfo();
                if (station.hasNextBusInfo()) {
                    busInfo.remain_dist = station.getNextBusInfo().getRemainDist();
                    busInfo.remain_stops = station.getNextBusInfo().getRemainStops();
                    busInfo.remain_time = station.getNextBusInfo().getRemainTime();
                    busInfo.f19867x = station.getNextBusInfo().getX();
                    busInfo.f19868y = station.getNextBusInfo().getY();
                    busInfo.spath = new ArrayList();
                    List<Integer> jsonArray = station.getNextBusInfo().getSpathList();
                    if (!(jsonArray == null || jsonArray.isEmpty())) {
                        for (Integer i : jsonArray) {
                            busInfo.spath.add(i);
                        }
                    }
                    temp.nextBusInfo = busInfo;
                }
                busResult.content.stations.add(temp);
            }
            return busResult;
        } catch (Exception e) {
            return null;
        }
    }
}
