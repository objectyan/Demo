package com.baidu.navi.track.datashop;

import com.baidu.navi.track.util.TrackNaviCsvFileUtil;
import java.util.List;

public class DeleteFileThread extends Thread {
    private List<String> listGuid;

    public DeleteFileThread(List<String> listGuid) {
        this.listGuid = listGuid;
    }

    public void run() {
        if (this.listGuid != null) {
            int size = this.listGuid.size();
            for (int i = 0; i < size; i++) {
                TrackNaviCsvFileUtil.deleteGuidsFile((String) this.listGuid.get(i));
                TrackNaviCsvFileUtil.deleteGuidsFile(((String) this.listGuid.get(i)) + "_rp");
            }
        }
    }
}
