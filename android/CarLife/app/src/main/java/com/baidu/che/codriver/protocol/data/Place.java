package com.baidu.che.codriver.protocol.data;

import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Place
  implements INoProguard
{
  public List<Result> list;
  public String message;
  public List<Result> results;
  public int status;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("Place { status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", message=");
    localStringBuilder.append(this.message);
    if ((this.results != null) && (this.results.size() > 0))
    {
      localStringBuilder.append(", results_size=");
      localStringBuilder.append(this.results.size());
      localStringBuilder.append("}");
    }
    return localStringBuilder.toString();
  }
  
  public static class DetailInfo
    implements INoProguard
  {
    @SerializedName("comment_num")
    public String commentNum;
    @SerializedName("detail_url")
    public String detailUrl;
    public int distance;
    @SerializedName("environment_rating")
    public String environmentRating;
    @SerializedName("groupon_num")
    public String grouponNum;
    @SerializedName("image_num")
    public String imageNum;
    @SerializedName("overall_rating")
    public String overallRating;
    public String price;
    @SerializedName("service_rating")
    public String serviceRating;
    public String tag;
    @SerializedName("taste_rating")
    public String tasteRating;
    public String type;
  }
  
  public static class Location
    implements INoProguard
  {
    public double lat;
    public double lng;
    
    public String toString()
    {
      return "Location [lng=" + this.lng + ", lat=" + this.lat + "]";
    }
  }
  
  public static class Result
    implements INoProguard
  {
    public String address;
    public int detail;
    @SerializedName("detail_info")
    public Place.DetailInfo detailInfo;
    public double distance;
    public Place.Location location;
    public String name;
    public String telephone;
    public String uid;
    
    public String toString()
    {
      return "Result [name=" + this.name + ", location=" + this.location + ", address=" + this.address + ", detail=" + this.detail + ", uid=" + this.uid + ", detailInfo=" + this.detailInfo + "]";
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/data/Place.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */