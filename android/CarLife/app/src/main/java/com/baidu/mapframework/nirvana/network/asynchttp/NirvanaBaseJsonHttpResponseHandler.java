package com.baidu.mapframework.nirvana.network.asynchttp;

import com.baidu.mapframework.commonlib.asynchttp.BaseJsonHttpResponseHandler;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

public abstract class NirvanaBaseJsonHttpResponseHandler<JSON_TYPE> extends BaseJsonHttpResponseHandler implements NirvanaResponseHandlerInterface {
    public NirvanaBaseJsonHttpResponseHandler(Module module, ScheduleConfig config) {
        this(module, config, "UTF-8");
    }

    public NirvanaBaseJsonHttpResponseHandler(Module module, ScheduleConfig config, String encoding) {
        super(encoding);
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
