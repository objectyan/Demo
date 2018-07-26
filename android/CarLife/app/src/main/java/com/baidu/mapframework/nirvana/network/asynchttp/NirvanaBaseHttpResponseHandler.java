package com.baidu.mapframework.nirvana.network.asynchttp;

import com.baidu.mapframework.commonlib.asynchttp.AsyncHttpResponseHandler;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

public abstract class NirvanaBaseHttpResponseHandler extends AsyncHttpResponseHandler implements NirvanaResponseHandlerInterface {
    public NirvanaBaseHttpResponseHandler(Module module, ScheduleConfig config) {
        this.module = module;
        this.scheduleConfig = config;
    }

    public Module getNirvanaModule() {
        return this.module;
    }

    public ScheduleConfig getNirvanaScheduleConfig() {
        return this.scheduleConfig;
    }

    public void onProgress(long bytesWritten, long totalSize) {
        super.onProgress(bytesWritten, totalSize);
    }
}
