package com.baidu.mapframework.nirvana.network.asynchttp;

import com.baidu.mapframework.commonlib.asynchttp.BlackholeHttpResponseHandler;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

public class NirvanaBlackholeHttpResponseHandler extends BlackholeHttpResponseHandler implements NirvanaResponseHandlerInterface {
    public NirvanaBlackholeHttpResponseHandler(Module module, ScheduleConfig scheduleConfig) {
        this.module = module;
        this.scheduleConfig = scheduleConfig;
    }

    public Module getNirvanaModule() {
        return this.module;
    }

    public ScheduleConfig getNirvanaScheduleConfig() {
        return this.scheduleConfig;
    }
}
