package com.baidu.mapframework.nirvana.network.asynchttp;

import android.os.Looper;
import com.baidu.mapframework.commonlib.asynchttp.BinaryHttpResponseHandler;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

public abstract class NirvanaBinaryHttpResponseHandler extends BinaryHttpResponseHandler implements NirvanaResponseHandlerInterface {
    public NirvanaBinaryHttpResponseHandler(String[] allowedContentTypes, Module module, ScheduleConfig config) {
        super(allowedContentTypes);
        this.module = module;
        this.scheduleConfig = config;
    }

    public NirvanaBinaryHttpResponseHandler(Module module, ScheduleConfig config) {
        this.module = module;
        this.scheduleConfig = config;
    }

    public NirvanaBinaryHttpResponseHandler(Module module, ScheduleConfig config, String[] allowedContentTypes) {
        super(allowedContentTypes);
        this.module = module;
        this.scheduleConfig = config;
    }

    public NirvanaBinaryHttpResponseHandler(Module module, ScheduleConfig config, String[] allowedContentTypes, Looper looper) {
        super(allowedContentTypes, looper);
        this.module = module;
        this.scheduleConfig = config;
    }

    public Module getNirvanaModule() {
        return this.module;
    }

    public ScheduleConfig getNirvanaScheduleConfig() {
        return this.scheduleConfig;
    }
}
