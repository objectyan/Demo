package com.baidu.navisdk.util.http.center;

import java.io.File;
import java.util.HashMap;

public class BNHttpParams {
    public String charset = "UTF-8";
    public File file = null;
    public String fileKey = null;
    public boolean isAsync = true;
    public HashMap<String, File> postFileMap = null;
    @Deprecated
    public HashMap<String, String> postMethodParams = null;
}
