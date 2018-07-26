package com.baidu.mapframework.nirvana.network.asynchttp;

import com.baidu.mapframework.commonlib.asynchttp.FileAsyncHttpResponseHandler;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.io.File;

public abstract class NirvanaRangeFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler implements NirvanaResponseHandlerInterface {
    public NirvanaRangeFileAsyncHttpResponseHandler(Module module, ScheduleConfig config, File file) {
        super(file);
        this.module = module;
        this.scheduleConfig = this.scheduleConfig;
    }

    public Module getNirvanaModule() {
        return this.module;
    }

    public ScheduleConfig getNirvanaScheduleConfig() {
        return this.scheduleConfig;
    }
}
