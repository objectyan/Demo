package com.baidu.mapframework.common.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.baidu.carlife.C0965R;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.widget.BMAlertDialog.Builder;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class MapDataUtil {
    public static String previousVersion;
    private Context mContext;
    private String sdPath = (StorageSettings.getInstance().getCurrentStorage().getRootPath() + "/BaiduMap/");

    /* renamed from: com.baidu.mapframework.common.util.MapDataUtil$1 */
    class C34811 implements OnCancelListener {
        C34811() {
        }

        public void onCancel(DialogInterface dialog) {
            MapDataUtil.this.deleteNotImportedData();
        }
    }

    /* renamed from: com.baidu.mapframework.common.util.MapDataUtil$2 */
    class C34822 implements OnClickListener {
        C34822() {
        }

        public void onClick(DialogInterface dialog, int which) {
            MapDataUtil.this.deleteNotImportedData();
        }
    }

    /* renamed from: com.baidu.mapframework.common.util.MapDataUtil$3 */
    class C34833 extends ConcurrentTask {
        C34833() {
        }

        public void run() {
            MapDataUtil.this.delSDFile(MapDataUtil.this.sdPath + "Mapdata");
        }
    }

    /* renamed from: com.baidu.mapframework.common.util.MapDataUtil$4 */
    class C34844 implements FileFilter {
        C34844() {
        }

        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }
    }

    /* renamed from: com.baidu.mapframework.common.util.MapDataUtil$5 */
    class C34855 implements FilenameFilter {
        C34855() {
        }

        public boolean accept(File dir, String filename) {
            return filename.endsWith(".dat");
        }
    }

    /* renamed from: com.baidu.mapframework.common.util.MapDataUtil$6 */
    class C34866 implements FilenameFilter {
        C34866() {
        }

        public boolean accept(File dir, String filename) {
            return filename.endsWith(".cfg");
        }
    }

    public MapDataUtil(Context context) {
        this.mContext = context;
    }

    public void showNotImportedDataTip() {
        new Builder(this.mContext).setTitle((CharSequence) "离线地图包导入提醒").setMessage((int) C0965R.string.off_map_not_imported_data_tip).setPositiveButton((CharSequence) "我知道了", new C34822()).setOnCancelListener(new C34811()).show();
    }

    protected void deleteNotImportedData() {
        ConcurrentManager.executeTask(Module.BASE_MAPVIEW_MODULE, new C34833(), ScheduleConfig.forData());
    }

    public boolean existsImportedData() {
        File file = new File(this.sdPath + "data");
        if (!file.isDirectory()) {
            return false;
        }
        File[] directorys = file.listFiles(new C34844());
        if (directorys == null || directorys.length <= 0) {
            return false;
        }
        for (int i = directorys.length - 1; i >= 0; i--) {
            String[] files = directorys[i].list(new C34855());
            if (files != null && files.length >= 0) {
                return true;
            }
        }
        return false;
    }

    public boolean existsNotImportedData() {
        File file = new File(this.sdPath + "Mapdata");
        if (!file.isDirectory()) {
            return false;
        }
        String[] files = file.list(new C34866());
        if (files == null || files.length <= 0) {
            return false;
        }
        return true;
    }

    public boolean delSDFile(String fileName) {
        int i = 0;
        if (fileName == null) {
            return false;
        }
        File file = new File(fileName);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            file.delete();
            return true;
        }
        File[] listFiles = file.listFiles();
        int length = listFiles.length;
        while (i < length) {
            File files = listFiles[i];
            if (files.isFile()) {
                files.delete();
            } else {
                delSDFile(files.getPath());
            }
            i++;
        }
        file.delete();
        return true;
    }
}
