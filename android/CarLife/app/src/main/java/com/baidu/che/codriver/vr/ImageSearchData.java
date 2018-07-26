package com.baidu.che.codriver.vr;

import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ImageSearchData implements INoProguard {
    @SerializedName("images")
    public List<ImageDetail> list;

    public static class ImageDetail implements INoProguard {
        @SerializedName("src")
        public String bigImage;
        @SerializedName("thumb")
        public String smailImage;
    }
}
