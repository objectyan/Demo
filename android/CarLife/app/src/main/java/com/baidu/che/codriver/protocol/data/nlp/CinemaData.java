package com.baidu.che.codriver.protocol.data.nlp;

import com.baidu.che.codriver.util.INoProguard;
import java.util.List;

public class CinemaData implements INoProguard {
    public int curPage;
    public List<CinemaBean> list;

    public static class CinemaBean implements INoProguard {
        public String name;
        public String post;
        public String score;
    }

    public String toString() {
        return "CinemaData{curPage=" + this.curPage + ", list=" + this.list + '}';
    }
}
