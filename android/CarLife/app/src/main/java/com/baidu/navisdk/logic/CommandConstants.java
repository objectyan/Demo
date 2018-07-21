package com.baidu.navisdk.logic;

import com.baidu.navisdk.logic.commandparser.CmdDataCheckUpload;
import com.baidu.navisdk.logic.commandparser.CmdGeneralFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpPostDataFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpPostFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestDataFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdRequestResource;
import com.baidu.navisdk.logic.commandparser.CmdRouteSearchForMapPoiResultPB;
import com.baidu.navisdk.logic.commandparser.CmdSDKInitEngine;
import com.baidu.navisdk.logic.commandparser.CmdSDKVerify;
import com.baidu.navisdk.logic.commandparser.CmdSearchAroundPark;
import com.baidu.navisdk.logic.commandparser.CmdSearchByCircleForMapPoiResultPB;
import com.baidu.navisdk.logic.commandparser.CmdSearchByKey;
import com.baidu.navisdk.logic.commandparser.CmdSearchByKeyForMapPoiResultPB;
import com.baidu.navisdk.logic.commandparser.CmdSearchByKeyForMapRPNodePoiResultPB;
import com.baidu.navisdk.logic.commandparser.CmdSearchByPoint;
import com.baidu.navisdk.logic.commandparser.CmdSearchGetSug;
import com.baidu.navisdk.logic.commandparser.CmdSearchNearest;
import com.baidu.navisdk.logic.commandparser.CmdSearchWithPager;
import com.baidu.navisdk.logic.commandparser.CmdStatisticsRecord;
import com.baidu.navisdk.logic.commandparser.CmdStatisticsUpload;

public abstract interface CommandConstants
{
  @CommandDeclare(CmdDataCheckUpload.class)
  public static final String K_COMMAND_KEY_DATACHECK_UPLOAD = "cmd.datacheck.upload";
  @CommandDeclare(CmdGeneralFunc.class)
  public static final String K_COMMAND_KEY_GENERAL_FUNC = "cmd.general.func";
  @CommandDeclare(CmdGeneralHttpRequestDataFunc.class)
  public static final String K_COMMAND_KEY_GENERAL_HTTPGET_DATA_FUNC = "cmd.general.http.request.data.func";
  @CommandDeclare(CmdGeneralHttpPostDataFunc.class)
  public static final String K_COMMAND_KEY_GENERAL_HTTPPOST_DATA_FUNC = "cmd.general.http.post.data.func";
  @CommandDeclare(CmdGeneralHttpPostFunc.class)
  public static final String K_COMMAND_KEY_GENERAL_HTTPPOST_FUNC = "cmd.general.http.post.func";
  @CommandDeclare(CmdGeneralHttpRequestFunc.class)
  public static final String K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC = "cmd.general.httprequest.func";
  @CommandDeclare(CmdRouteSearchForMapPoiResultPB.class)
  public static final String K_COMMAND_KEY_ROUTE_SEARCH_FOR_MAP_POI_RESULT_PB = "cmd.search.routesearch.for.mappoiresult.pb";
  @CommandDeclare(CmdSDKInitEngine.class)
  public static final String K_COMMAND_KEY_SDKOP_INIT = "cmd.sdkop.init";
  @CommandDeclare(CmdSDKVerify.class)
  public static final String K_COMMAND_KEY_SDKOP_VERIFY = "cmd.sdkop.verify";
  @CommandDeclare(CmdSearchAroundPark.class)
  public static final String K_COMMAND_KEY_SEARCH_AROUND_PARK = "cmd.search.around.park";
  @CommandDeclare(CmdSearchByKey.class)
  public static final String K_COMMAND_KEY_SEARCH_BYKEY = "cmd.search.bykey";
  @CommandDeclare(CmdSearchByPoint.class)
  public static final String K_COMMAND_KEY_SEARCH_BYPOINT = "cmd.search.bypoint";
  @CommandDeclare(CmdSearchByCircleForMapPoiResultPB.class)
  public static final String K_COMMAND_KEY_SEARCH_BY_CIRCLE_FOR_MAP_POI_RESULT_PB = "cmd.search.bycircle.for.mappoiresult.pb";
  @CommandDeclare(CmdSearchByKeyForMapPoiResultPB.class)
  public static final String K_COMMAND_KEY_SEARCH_BY_KEY_FOR_MAP_POI_RESULT_PB = "cmd.search.bykey.for.mappoiresult.pb";
  @CommandDeclare(CmdSearchByKeyForMapRPNodePoiResultPB.class)
  public static final String K_COMMAND_KEY_SEARCH_BY_KEY_FOR_MAP_RP_NODE_POI_RESULT_PB = "cmd.search.bykey.for.maprpnodepoiresult.pb";
  @CommandDeclare(CmdSearchGetSug.class)
  public static final String K_COMMAND_KEY_SEARCH_GETSUG = "cmd.search.getsug";
  @CommandDeclare(CmdSearchNearest.class)
  public static final String K_COMMAND_KEY_SEARCH_NEAREST = "cmd.search.neareast";
  @CommandDeclare(CmdSearchWithPager.class)
  public static final String K_COMMAND_KEY_SEARCH_WITH_PAGER = "cmd.search.with.pager";
  @CommandDeclare(CmdStatisticsRecord.class)
  public static final String K_COMMAND_KEY_STATISTICS_RECORD = "cmd.statistics.record";
  @CommandDeclare(CmdStatisticsUpload.class)
  public static final String K_COMMAND_KEY_STATISTICS_UPLOAD = "cmd.statistics.upload";
  @CommandDeclare(CmdRequestResource.class)
  public static final String K_COMMAND_REQUEST_RESOURCE = "cmd.request.resource";
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/navisdk/logic/CommandConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */