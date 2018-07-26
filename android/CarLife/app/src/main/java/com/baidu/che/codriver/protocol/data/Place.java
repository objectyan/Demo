package com.baidu.che.codriver.protocol.data;

import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Place implements INoProguard {
    public List<Result> list;
    public String message;
    public List<Result> results;
    public int status;

    public static class DetailInfo implements INoProguard {
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

    public static class Location implements INoProguard {
        public double lat;
        public double lng;

        public String toString() {
            return "Location [lng=" + this.lng + ", lat=" + this.lat + "]";
        }
    }

    public static class Result implements INoProguard {
        public String address;
        public int detail;
        @SerializedName("detail_info")
        public DetailInfo detailInfo;
        public double distance;
        public Location location;
        public String name;
        public String telephone;
        public String uid;

        public String toString() {
            return "Result [name=" + this.name + ", location=" + this.location + ", address=" + this.address + ", detail=" + this.detail + ", uid=" + this.uid + ", detailInfo=" + this.detailInfo + "]";
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Place { status=");
        sb.append(this.status);
        sb.append(", message=");
        sb.append(this.message);
        if (this.results != null && this.results.size() > 0) {
            sb.append(", results_size=");
            sb.append(this.results.size());
            sb.append("}");
        }
        return sb.toString();
    }
}
